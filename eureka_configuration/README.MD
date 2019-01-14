**Eureka Configuration** has 3 individual projects to use.
1. *Eureka_Server* : which will work as normal Eureka Server/Registry.
2. *Eureka_Producer*: This is a simple project which will work as Eureka Client with a single API which will return the list of names.
3. *Eureka_Consumer*: As part of this project I am trying to use the Producer API by using the Application/Instance name registered in Eureka Server.

Eureka_Server registered on 8761 port.
Eureka_Producer registered on 8181 port.
Eureka_Consumer registered on 8182 port.
