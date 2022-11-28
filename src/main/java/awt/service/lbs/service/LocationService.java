package awt.service.lbs.service;

import awt.service.lbs.client.PushServiceClient;
import awt.service.lbs.model.dto.DeviceIdLocationPair;
import awt.service.lbs.model.dto.GetDeviceCloseToMeRequest;
import awt.service.lbs.model.dto.SendPushMessageRequest;
import awt.service.lbs.model.dto.SendPushMessageRequestDevice;
import awt.service.lbs.model.entity.Device;
import awt.service.lbs.model.entity.DeviceTopicKey;
import awt.service.lbs.model.entity.TopicLocation;
import awt.service.lbs.repository.DeviceRepository;
import awt.service.lbs.service.databaseservice.DeviceDatabaseService;
import awt.service.lbs.service.databaseservice.DeviceTopicKeyDatabaseService;
import awt.service.lbs.service.databaseservice.TopicLocationDatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationService {

    private final DeviceRepository deviceRepository;
    private final DeviceDatabaseService deviceDatabaseService;
    private final DeviceTopicKeyDatabaseService deviceTopicKeyDatabaseService;
    private final TopicLocationDatabaseService topicLocationDatabaseService;
    private final GPSService gpsService;
    private final PushServiceClient pushServiceClient;

    public List<DeviceIdLocationPair> getDevicesCloseToMe(GetDeviceCloseToMeRequest getDeviceCloseToMeRequest) {
        List<DeviceTopicKey> deviceTopicKeyList = deviceTopicKeyDatabaseService.findByTopicId(getDeviceCloseToMeRequest.getTopicId());

        List<Optional<Device>> topicDeviceOptional = new ArrayList<Optional<Device>>();
        for(DeviceTopicKey deviceTopicKey : deviceTopicKeyList){
            topicDeviceOptional.add(deviceRepository.findById(deviceTopicKey.getDeviceId()));
        }

        List<Device> deviceList = topicDeviceOptional.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        deviceList = deviceList
                .stream()
                .filter(device ->
                    gpsService.compareLocations(Double.parseDouble(device.getLognitudeLocation()),
                            Double.parseDouble(getDeviceCloseToMeRequest.getLognitudeLocation()),
                            Double.parseDouble(device.getLatitudeLocation()),
                            Double.parseDouble(getDeviceCloseToMeRequest.getLatitudeLocation()),
                            Double.parseDouble(getDeviceCloseToMeRequest.getRadius()))
                        &&
                            !device.getId().equals(getDeviceCloseToMeRequest.getDeviceIds())
        ).collect(Collectors.toList());

        List<DeviceIdLocationPair> deviceIdLocationPairList = deviceList.stream().map(device ->
            DeviceIdLocationPair.builder().deviceId(device.getId()).latitudeLocation(device.getLatitudeLocation()).lognitudeLocation(device.getLognitudeLocation()).build()
        ).collect(Collectors.toList());

        return deviceIdLocationPairList;
    }

    public void saveLocationOfDevice(DeviceIdLocationPair deviceIdLocationPair) {
        deviceDatabaseService.saveLocationOfDevice(deviceIdLocationPair);
        List<TopicLocation> topicLocationList = inTopicLocationRadius(deviceIdLocationPair);


        if(topicLocationList.size()>0){
            topicLocationList.stream().forEach(topicLocation -> {
                Device device = deviceDatabaseService.getDevice(deviceIdLocationPair.getDeviceId());

                List<SendPushMessageRequestDevice> sendPushMessageRequestDevice = new ArrayList<SendPushMessageRequestDevice>();
                sendPushMessageRequestDevice.add(SendPushMessageRequestDevice.builder().token(device.getDeviceOSId()).os(device.getOperatingSystem()).build());
                SendPushMessageRequest sendPushMessageRequest = SendPushMessageRequest.builder().title(topicLocation.getMessageTitle()).body(topicLocation.getMessageBody()).devices(sendPushMessageRequestDevice).build();
                pushServiceClient.sendMessage(topicLocation.getProjectId(),sendPushMessageRequest);
            });
        }
    }

    private List<TopicLocation> inTopicLocationRadius(DeviceIdLocationPair deviceIdLocationPair) {
        List<DeviceTopicKey> deviceTopicKeyList  = deviceTopicKeyDatabaseService.findByDeviceId(deviceIdLocationPair.getDeviceId());
        List<TopicLocation> topicLocationList = new ArrayList<TopicLocation>();
        deviceTopicKeyList.stream().forEach(deviceTopicKey -> {
            topicLocationList.addAll(topicLocationDatabaseService.findAllByTopicId(deviceTopicKey.getTopicId()));
        });

        return topicLocationList.stream().filter(topicLocation ->
                gpsService.compareLocations(Double.parseDouble(topicLocation.getLognitudeLocation()),
                        Double.parseDouble(deviceIdLocationPair.getLognitudeLocation()),
                        Double.parseDouble(topicLocation.getLatitudeLocation()),
                        Double.parseDouble(deviceIdLocationPair.getLatitudeLocation()),
                        topicLocation.getAlarmRadius())
        ).collect(Collectors.toList());
    }

    public DeviceIdLocationPair getDeviceMyLocation(String deviceId) {
        Device device =  deviceDatabaseService.getDevice(deviceId);
        return  DeviceIdLocationPair.builder().deviceId(device.getId()).latitudeLocation(device.getLatitudeLocation()).lognitudeLocation(device.getLognitudeLocation()).build();
    }
}
