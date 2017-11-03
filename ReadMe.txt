I created apis so that clients can use this.

Following are the APIs.

1) Once we start this project as Spring boot application using spring-boot:run and once sensor code also 
run with the following command this project will record all the data from the sensors.
java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080 sensor-emulator-0.0.1-SNAPSHOT.jar

2) If client want to get all different weights sensor has captured
http://localhost:8080/getAllWeights

3) If client want to get all Alerts recorderd (Alerts were created based on the rules)
http://localhost:8080/getAllAlerts.

4) If client want to get all the weights between particular dates
http://localhost:8080/getAllWeights/<startDate>/<enddate>
Eg:
http://localhost:8080/getWeights/1509683482787/1509683492837
client will get all the weights between those dates.

Because of Time Factor I did not considered using all spring feature in this project. 