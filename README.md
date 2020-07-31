# DiviCal

How to start the DiviCal application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dividend-cal-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Notes
---
Try this out when running:
http://localhost:8080/dividends/getByDate?date=08/10/2020

Sample google calendar API code in here - this should actually be done at the front-end layer:
https://github.com/Kubessandra/react-google-calendar-api#readme