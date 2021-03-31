# ACCOUNT MICROSERVICE

This microservice is in charge of sending notifications (either mail, sms, etc) to the accounts holders

## How to Run

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 1.8 and Gradle 5.x

* You can build the project and run the tests by running ```gradle clean build```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar build/libs/notification-0.0.1-SNAPSHOT.jar
```


Once the application runs you should see something like this

```
2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is just a simple REST service for creating accounts. It uses a mysql database to store the data. You can also use other relational database like PostgreSQL. If your database connection properties work, you can call some REST endpoints defined in ```package com.nnamdi.notification.controller``` on **port 9000**. (see below)

More interestingly, you can start calling some operational endpoints (see full list below) like ```/notify/{channelType}```  (this is available on **port 9000**)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backend RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service.


Here are some endpoints you can call:

### Send custom notification

```
http://localhost:9000/api/v1.0/notifier/notify/{channelType}
```



### Send notification

```
POST /api/auth/signup
Accept: application/json
Content-Type: application/json
{  
   "body": "Body of the message",  
   "from": "nwabuokeinnamdi@gmail.com",  
   "subject": "Notification Service Test Subject",  
   "to": "nwabuokeinnamdi19@gmail.com"  
 }

RESPONSE: HTTP 201 (No Content)
```


### To view Swagger 2 API docs

Run the server and browse to localhost:9000/swagger-ui.html

# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. In addition to easy set up of Spring Controllers, Spring Data, etc. Spring Boot comes with the Actuator module that gives the application the following endpoints helpful in monitoring and operating the service:



# Area of Improvement

**1. Setting up notification on successful payment - Partly completed**

**2. Implementing JWT Authentication**

**2. Improve Code documentation**


# Questions and Comments: nwabuokeinnamdi19@gmail.com

