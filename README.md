# Rezdy API Service
This is a coding test from Rezdy.

## Prerequisites
- JDK 1.8+
- Maven
- port number 12345

### How To Run
- ensure JDK 1.8+ is used and port number 12345 is available
- build the project using Maven (a jar file will be created)
- put the above jar file and the input file in the same folder
- execute the jar with below command
```
  java -jar rezdy-api-service-0.0.1-SNAPSHOT.jar
```

#### Implemented RESTful API
The following service are implemented.
```
/lunch
/lunch?use-by=true
/lunch?best-before=true
```


| Example  										   | Explanation                    															  |
|:-------------------------------------------------|:---------------------------------------------------------------------------------------------|
| http://localhost:12345/lunch    				   | get all recipes whose ingredients are all available										  |
| http://localhost:12345/lunch?use-by=true   	   | get all recipes whose ingredients are all before the use-by date 							  |
| http://localhost:12345/lunch?best-before=true    | get all recipes whose ingredients are all between the best-before date and the use-by date   |



## Authors

* **Jun Feng** 