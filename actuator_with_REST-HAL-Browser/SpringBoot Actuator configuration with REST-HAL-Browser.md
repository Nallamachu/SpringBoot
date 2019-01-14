In microservices projects we use to create no of applications which will interact with earch other to full fill of requirement. At this point monitoring is very difficult like to know which all applications are running/down. To solve this problem, Spring Boot actuator is the best option.

In this place, I am trying to exaplin how to configure SpringBoot actuator with Rest-HAL-Browser. REST-HAL-Browser support better UI to access Actuator privided API's. 

To configure Actuator in SpringBoot application all we need to do is, adding the below dependency in POM.XML file,
```xml
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
```

Now, all you need to do is to start the application and access the URL like http://<host>:<port>/actuator

Similarly configure the below dependency for enabling the support of REST-HAL-Browser.
```xml
    <dependency>
       <groupId>org.springframework.data</groupId>
       <artifactId>spring-data-rest-hal-browser</artifactId>
    </dependency>
```
**Note:** Versions will be decided by Spring Boot Parent Project.

Congrats..... Actuator and HAL browser convifugaration is completed. All you need to do is, you have to start the application and access URL with actuator like below,
>http://localhost:8080/actuator

You will get the below output of actuator, health and info URL's.
```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "info": {
            "href": "http://localhost:8080/actuator/info",
            "templated": false
        }
    }
}
```
You can access the same information in already configured REST-HAL-Browser. For this, you have to access with the URL of <host>:<port> like http://localhost:8080, the URL will automatically redirected to http://localhost:8080/browser/index.html#/ as you can see in below screen.
![]()

You can search for ```/actuator``` for accessing actuator information in REST-HAL-Browser. You can see the above JSON output in the below screen.
![]()

In actuator now we are able to see only actuator, health and info. I want to look at all the endpoint API's available in my SpringBoot application. For that, all we need to do is, need to configure below property in application.properties file and reastart application.
```properties
management.endpoints.web.exposure.include=*
```
Now, You try accessing the /actuator in REST-HAL-Browser and look at how many URL's are showing. If you want, you can also access them from the same browser.

It will show the output as like below API's,
```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "auditevents": {
            "href": "http://localhost:8080/actuator/auditevents",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:8080/actuator/beans",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:8080/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://localhost:8080/actuator/configprops",
            "templated": false
        },
        "env": {
            "href": "http://localhost:8080/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://localhost:8080/actuator/env/{toMatch}",
            "templated": true
        },
        "info": {
            "href": "http://localhost:8080/actuator/info",
            "templated": false
        },
        "loggers": {
            "href": "http://localhost:8080/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:8080/actuator/loggers/{name}",
            "templated": true
        },
        "heapdump": {
            "href": "http://localhost:8080/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://localhost:8080/actuator/threaddump",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "metrics": {
            "href": "http://localhost:8080/actuator/metrics",
            "templated": false
        },
        "scheduledtasks": {
            "href": "http://localhost:8080/actuator/scheduledtasks",
            "templated": false
        },
        "httptrace": {
            "href": "http://localhost:8080/actuator/httptrace",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:8080/actuator/mappings",
            "templated": false
        }
    }
}
```
