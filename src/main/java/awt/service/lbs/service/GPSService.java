package awt.service.lbs.service;

import awt.service.lbs.model.dto.DeviceIdLocationPair;
import awt.service.lbs.model.dto.GetDeviceCloseToMeRequest;
import awt.service.lbs.model.entity.Device;
import awt.service.lbs.model.entity.TopicLocation;
import org.springframework.stereotype.Service;

import java.lang.*;

@Service
public class GPSService {

    double earthRadius=6371000;

    public boolean compareLocations(double longitudeA, double longitudeB, double latitudeA, double latitudeB, double radius) {
        double longitude = Math.abs(longitudeA - longitudeB);
        double latitude = Math.abs(latitudeA - latitudeB);
        double longitudeDistance = longitude/360 * earthRadius * Math.PI;
        double latitudeDistance = latitude/180 * earthRadius * Math.PI;
        double distance = Math.sqrt(latitudeDistance*latitudeDistance+longitudeDistance*longitudeDistance);
        if(distance<=radius)
            return true;
        else
            return false;
    }
}
