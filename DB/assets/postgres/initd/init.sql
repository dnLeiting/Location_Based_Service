-- Service DB's
CREATE USER root WITH ENCRYPTED PASSWORD 'admin';
CREATE DATABASE lbs;
GRANT ALL PRIVILEGES ON DATABASE lbs TO root;