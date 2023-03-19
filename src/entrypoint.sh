#!/bin/sh

echo "springboot container up, please wait,,,,"
sleep 30
echo "springboot service starting"

java -jar springboot/target/dotapedia-1.0.0-SNAPSHOT.war;