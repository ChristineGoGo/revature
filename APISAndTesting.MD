Functional programming - It is the process of building programs by relying on functions
                            to transform data.
                        Functions are treated as "first-class citizens"
                        They can be assigned to variables and passed as arguments into a method call.
                        In Java we can use lambda expressions and method references as our "first class citizen" functions
                        Functional interface variables and method parameters are where we can place
                        these functions
                        A functional interfaces define only one abstract method.
                        We can assign it a function but the function must implement the functional
                        interface's abstract method.

Lambda Expression Syntax - It is composed of three parts:
                                    Argument List(int x, int y), Arrow Token(->), Body(x + y)
                                    Curly braces must be present if the lambda's body consists
                                    of more than one statement
                                    They are only usable with functional interfaces

Method references - Introduced in Java 8
                    Provides a shorthand way of referring to methods without having to explicitly call
                    them
                    Always utilize :: ie myString::indexOf
                    char -> myString.indexOf(char) - lambda version

                    Four kinds of method references:
                        - reference to a static method
                            ClassName::methodName ie Math::max
                        - reference to an instance method of a particular object
                            objectName::methodName
                            ie
                            String myString = "hello";
                            myString::toUpperCase
                        - reference to an instance method of an arbitary object of a
                        a particular type
                            ClassName::methodName ie
                            String::startsWith

                        - a reference to a constuctor
                            ClassName::new

Built-in Functional Interfaces
    - Runnable - used to create threads
    - Comparable - used for an Object to provide natural order
    - Comparator  - Used to compare objects of a given type
    - Predicate - used to provide a Boolean response given one argument
    - Supplier - used to provide an instance of a given type
    - Consumer - used to perform an operation on a given type with no input
    - Function - used to perform an operation on a given type and provide a
                specified output

REST(Representational State Transfer)
    - It is an architectural style that defines a set of constraints to be used
    for creating web services.
    - REST API is a way of accessing web services in a smiple and flexible way without
    having any processing.
    - It is used to fetch or give some information from a web service.
    - It is preferred over SOAP(Simple Object Access Protocol)
    - REST API only uses HTTP requests to comminicate.
    - In REST-based Architecture, there are five methods that are used. POST(create), GET(read), 
    PUT(Update), PATCH(update) and DELETE.
    - Client-Server
    -Stateless

JAVALIN
    - It is a lightweight web framework for Java 8(and later) and Kotlin.
    - The following are some of the configurations for Javalin:
        Javalin.create() // create had to be called first
        .contextPath("/context-path")// set a context path (default is "/")
        .dontIgnoreTrailingSlashes() //treat '/test' and '/test/' as different URLs
        .defaultContentType(string) //set a default content-type for responses
        .defaultCharacterEncoding(string) //set a default character-encoding for responses
        .disableStartupBanner() //remove the javalin startup banner from logs
        .embeddedserver(...)
        .enableCorsForOrigin("origin") //enables cors for specfied origin(s)
        .enableDynamicGzip // gzip response (if client accepts gzip and response is
                                                more than 1500 bytes)
        .enableRouteOverview("/path") // render a HTML page showing all mapped routes
        .enableStandardRequestLogging() // does requestLogLevel(Loglevel.STANDARD)
        .enableStaticFile("public") // enable static files (opt. second param location.
                                                            CLASSPATH/Location.EXTERNAL)
        .maxBodySizeForRequestCache(long) // set max body size for request cache
        .port(port) // set the port
        .start(); // start has to be called last   
    
    - Javalin has three main handler types:
        - before-handlers
        - endpoint-handlers
        - after-handlers
        
        - They require three parts:
            - An HTTP verb like GET or POST 
            - A path ex: /, /hello-world
            - A handler implementation ex ctx -> { ... }, MyClass implements Handler
JSON
    - Javascript Object Notation(JSON) is a lightweight data-interchange format.
    - A JSON Object is a set of key and value pair enclosed within curly braces
    - Used to transmit data between the server and web application
    
    - REST API uses JSON/XML or HTML format to send a representation of the resource's
      current state to the requester or endpoint.
    
    - Exposing endpoints
        1. Identify your resources
        2. Identify your endpoints
        3.Implementation
    - Consuming endpoints involves sending requests to the exposed endpoints of another
    application or service to access its functionalities or resources. It is the process
    of making HTTP requests to interact with an API and retrieve data or perform actions.

    - A resource is a conceptual mapping to a set of entities.
    - REST APIs use Uniform Resource Identifiers(URIs) to address resources

Resource Archetypes
There are four categories:
        - Document
        It is a singular concept that is akin to an object instance or database record.
        In REST, you can view it as a single resource inside a resource collection.
        - Collection
        It is a server-managed directory of resources.
        - Store
        It is a client-managed resource repository.
        
        - Controller
        It models a procedural concept.
        Controller resources are like executable functions, with parameters
        and return values, inputs and outputs
Logback
    It is a logging framework and replacement for log4j.
    The logback architecture is comprised of three classes:
        - Logger - context for log messages
        - Appender - they place log messages in their final destinationns
        - Layout -  prepares messages for outputting.
    Reasons to prefer logback over log4j 1.x
        - Faster implementation
        - Extensive battery of tests
        - Automatic reloading of configuration files
        - Graceful recovery from I/O failures
        - Automatic removal of old log archives
        - Automatic compression of old archived log files
    In most logging frameworks like Logback, you will encounter
    all or some of the following log levels:
        TRACE
         - very verbose and fine-grained information
        DEBUG
          - Ideal for everyday use
        INFO
        WARN
            - indicates that something unexpected happened
        ERROR

TDD
    Test Driven Development process consists of writing unit tests first, before the implemented
    application code has been written. The process is:
        - Design interface/funstion
        - Write tests that use signatures to ensure that the functions are intuitive
        in usage
        - Implement functions
        - Run tests to verify functionality
    Unit Testing
    It is the testing of individual software components in isolation from the rest of the system.
    JUnit is the most common testing framework in Java.

    Types of testing:
        - Unit tests - testing individual code written for your product
        - User inteface tests - testing the user interface components in different
                                devices or browsers
        - Intergration testing - making sure different parts of your product works
                                well together
        - Functional testing - testing whether the customer needs are delivered in your
                                product.
        - Performance testing - checks the performance under heavy use.
        - Security testing - making sure whether your product is resistant to cyber
                             attacks

Mockito
    It is a popular open source framework for mocking objects(mock objects) and methods
    (method subs) in software tests.
    A mock object is a dummy implementation for an interface of a class.
    Behavior testing - it is where you verify the interactions between the objects in 
                        your code rather than just the output.
    Spies - they are partial mocks.
    Stub - it is a piece of code that takes place of another component.

The DAO Layer and the Service Layer
    - The DAO layer is responsible for interacting with the underlying data storage mechanism.
    It can be the database or web service. They handle CRUD operations and database transactions.

    - The service layer contains the business logic of the application. They implement use cases,
    enforce business rules, perform validation and coordinate transactions across multiple DAOs.


