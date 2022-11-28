#Run Local DB Environment

###Create local colume
docker volume create postgres-data

###Start DB
docker-compose up -d