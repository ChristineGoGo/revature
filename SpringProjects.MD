Spring Data
    - It is an umbrella project within the larger Spring ecosystem that aims to simplify
    database access and persistence is Spring based applications
    - The CrudRepository interface provides CRUD operations irrespective of databases
    - The PagingAndSortingRepository provides options to sort the data using the Sort interface

    The following are Spring Data Modules which are specific to the databases:
        - Spring Data JPA
        - Spring Data MongoDB
        - Spring Data REST

Spring Boot Actuator
    - Spring Boot Actuator is a sub-project of the Spring Boot Framework that aims to assist
    you in monitoring and managing your application when it's pushed to production

    Built In Actuator Endpoints
        List of Endpoints
            - /health
             -This endpoint provides basic health information about the application
            - /info
             - It returns arbitary application information. It is empty by default
            - /metrics
             - It provides detailed metrics about the JVM, application usage, and system
             details
            - /loggers
             - It allows you to view and change the logging level of your application dynamically
            - /threadDump
             - It performs a threaad dump allowing you to see what every thread in the JVM is doing
            - /heapdump
             - useful when diagnosing memory related issues
            - /auditevents
             - exposes audit events in yout application, including authentication events (like login and logout)
            - /httptrace
             -It keeps trace information about the last 100 HTTP request-response exchanges
            - /env
             - It provides details about the environment in which the application is running. This
             inclues property sourrces and system properties
Junit
    - It is an open-source testing framework that provides a set of annotations and assertions to
    write tests efficiently
    - Some of the key feature of JUnit are:
        - Annotations to define test methods, test classes, setup and tear-down procedures
        - Assertions to verify expected outcomes
        - Test runners to execute tests and report results

Mockito
    - Mockito is a popular open-source mocking framework for Java applications
    - It is specifically useful when testing components that interact with databases, web services,
    or other external systems
    - Some of the key Mockito features are:
        - Creating mock objects for classes and interfaces
        - Stubbing methods to return specific values or throw exceptions
        - Verifying the number of times a method has been called, or if certain methods were called at all
        - Argument matchers to verify that methods are called with the correct parameters

Integration Testing
    - It is the process of combining individual software modules and testing them as a group

    Levels of Integration Testing
    - Integration testing is typically performed at several levels including:
        -
         Component Integration Testing
            - Verifies the interaction between software components. Usually done after component
            testing
        System Integration Testing
            - Verifies the interaction between different systems and may involve testing interfaces
            to external organizations
    
    Integration Testing in the Context of Spring
    - Spring provides annotations such as @SpringBootTest and @DataJpaTest that can be used to create
    application contexts ith different levels of detail, depending on the requirements of your tests.

    In a Spring application you might need to test the interactions between:
     - Different layers of your application such as the service and repository layers
     - Your application and your database
     - Your application and other Spring Boot features, like caching or the Actuator

    - MockMVC and RESTTemplate are both used for testing REST APIs.

    MockMVC
    - It is used for testing the controller layer of the application

    RESTTemplate
    - It is used to test the interactions between the application and external RESTful
    services or APIs
    - It is used to test the service layer of the application and is typically used for
    unit testing
    - It can be used to test the controller layer as well but it makes actual resquests unlike
    MockMVC

    Data Integration Testing
    - It is a type of testing that verifies the interaction between different components of an 
    application and the database.
    - It ensures that the application interacts with the database correctly, by testing the data
    access layer of the application

    Key points about data intergration testing in a Spring Boot app:
    - It is used for testing the data access layer
    - You can use tools like Spring Boot Test, JUnit and Mockito to write and execute data
    intergration tests

    Spring Annotations
    @Controller
     - similar to @Component. It provides information that a class is a controller.
     
