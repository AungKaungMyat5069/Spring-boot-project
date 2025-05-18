### install from file sql to sql database
- create database
- use database
- source path/sqlFile.sql
# configuration of microservice
- created the normal java project with maven
- delete the src
- add the dependencyManagement in pom.xml
- inside dependencyManagement add dependency
- inside, add this
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>3.4.1</version>
      <scope>import</scope>
      <type>pom</type>
    </dependency>
- add packaging with pom
- add spring boot modules 
// note : modules must have eureka client 
## in client pom 
- delete the relative tag
- change the parent tag to normal java project
- change spring cloud version to fixed 
- cut that dependency to parent pom in DependencyManagement(one time)
- delete all dependencyManagement
- close (temporary) the eureka client(cause of error)
- add version in plugins tag (cause of error)
- close test annotation
- delete the application.properties
- add the application.yml
- add in application.yml
## in parent pom
- add modules element
- add module with spring boot (affable-bean-backend)
- go to the child affable-bean-backend
- create the child affable-bean-ui
- configuration is same as # 5
- go to the child affable-bean-ui

### create the payment-gateway
- go to the child payment-gateway
- configuration is same as # 5



### random Number
- just add the common.lang3 in apache to the pom.xml


### eureka server using
- create the modules with eureka-server
- same as the server as # 5
- go to eureka-server

### gateway create
- create the modules with, gateway and eureka client
- same as configuration as # 5
- go to that module
- open all the eureka client if closed
- in yml, modifies server port 0 
- and add eureka.client.service-url.defaultZone:localhost:8083/eureka

# run with eureka 
- first change all RestClient catch is 8080 not other numbers
- run(program) button of left side 
- ender the edit configuration
- Go to the backend and add 1 to the name
- Click the "Modify Option" button, click "VM Option"
- In VM Option, type "-Dserver.port=80--", not 8080
- Click the apply button

### Create a clone project
- left top angle, click the plus button
- Run the main method that needs to run virtually
- next instruction is same as above instruction

- Check eureka server.port = 8083
- Check api-gateway server.port = 8080

### run all modules
- in edit configuration, add compound 
- in compound add all which modules is needed to run
- finish
