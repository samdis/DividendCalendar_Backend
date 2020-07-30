#!/bin/bash
# Starts the web server assuming "mvn clean install" has completed successfully.

java -jar target/dividend-cal-*-SNAPSHOT.jar server config.yml