Introduction to Spring Framework
    - The Spring Framework is a Java platform that provides infrastructure support
    to develop Java applications
    - Spring helps build applications using "plain old java objects"(POJOS)

    Modules of Spring Framework
        - The features of the Spring framework are organized into 20 modules
        - The Spring modules are grouped into:
            - Core Container            - Instrumentation 
                - Beans                 - Test
                - Core
                - Context
                - Expression Language            
            - Data Access/Intergration
                - JDBC  - JMS
                - ORM   - Transactions
                - OXM
            - Web(MVC / Remoting )
                - Web   -Servlet
                - Portlet - Struts
            - AOP(Aspect Oriented Programming)
        - The Spring Core follows the principle of Inversion of Control
        - Inversion of Control is the transfer of control of objects or portions of a program to a container
        or framework
        - IoC container uses Dependency Injection or IoC pattern to implicity provide and object reference
        in a class during runtime
        - Dependency injection - injecting objects into other objects
        - Beans are the objects in Spring and are managed by the IoC container
        - The Spring Container can be implemented in two different ways:
            - BeanFactory (org.springframework.beans.factory.BeanFactory)
                - Its responsibility is to instantiate, configure objects and assemble the dependecies between these
                objects
            - ApplicationContext (org.springframework.context)
                - Provides additional functionality like easy intergration with Spring AOP features, message resource handling,
                event propagation and contexts specific to the application-layer like WebApplicationContext for use in web
                applications
        - The Spring container is used for handling objects ie calling the objects of a class and adding dependencies

        Advantages of IoC
            - Decoupling the task execution from the implementation
            - Easy switching between different implementations
            - Greater modularity of a program
            - Easy testing of a program by isolating the component or mocking its dependencies

        Overview Of Inversion Of Control
            - Inversion of Control is a software design principle that promotes loose coupling and modularity by shifting the
            responsibility of managing dependencies from the application itself to an external container or framework.

            - Key points about Inversion of Control include:
                - Decoupling dependencies
                    Reduces direct dependencies of components
                - Dependency Injection
                - Loose coupling
                - Inversion of Control Containers
                - Dependency inversion principle
                    High-level modules should not depend on low-level modules but both should depend on abstractions
                - Software frameworks and libraries
                    IoC is highly used in frameworks and libraries
            
            Dependecy Injection
                - It is a design patter in programming that enhances the modularity and testability of a software.
                - It addresses issues like tightly coupled code, code duplication and challenges in unti testing.
                - It enables building systems where components can be independently replaced and tested, resulting
                in highly modular architecture
                - Spring is popular in Java for dependency injection. In practice dependencies are injected into classes via:
                    
                    - constuctors(Constructor Injections)
                        - Occurs when a class receives its dependencies through its constructor during the instantiation process
                        Advantages
                        - Allows for the creation of immutable objects. Also less prone to null pointer exceptions
                        Disadvantages
                        - The class could end up with a large number of constructor arguments if there are many dependencies which
                        can make the code difficult to understand
                        Best use cases
                        - When the dependecies are required for the class to function and should not be changed after the class is
                        constructed
                    
                    - setter method(Setter injection)
                        - Occurs when a class receives its dependencies through setter methods after it has been constructed
                        Advantages
                        - Provides a way to change the dependencies of a class after it has been costructed. It also makes it easier
                        to handle optional dependencies
                        Disadvantages
                        - The object is not guaranteed to be in a fully initialized state because it might not have received all its
                        dependencies
                        Best use case
                        - When the dependencies can be changed during the lifespan of the class or when some dependencies are optional
                    - directly into fields (Field injection)
                        - Occurs when dependencies are injected directly into the fields of a class, bypassing the constructor or setters
                        Advantages
                        - It reduces the amount of boilerplate code, as no explicit setter or constructor is needed
                        Disadvantages
                        - It makes your classes harder to tests because you can't easily replace the dependencies with mocks. It also
                        breaks encapsulation because you are modifying fields outside the class
                        Best use case
                        - When you need to reduce the amount of boilerplate code and you are not concerned about the testing implications.
                - For example in a Spring-bases web appliaction, dependencies such as data access objects(DAOs), service components
                and controllers are injected into each other using annotations or XML configurations
                    @Configuration marks a class as a configuration class, where bean definitions and dependecies are declared
                    @Bean annotates methods that define and return instances of beans
                    @ComponentScan is used to specify the packages to scan for @Component annotations or its derivatives
                - Java EE(Enterprise Edition) also supports dependency injection through its Contexts and Dependency Injection(CDI)
                framework
                - Google Guice, Angular JS and Angular, JUnit and Mockito also utilize dependency injection
                - In Android Development, we have frameworks like Dagger 2
                - Node.js and Javascript have IntensifyJS and Awilix
            
            Annotation Based Configuration
             - Annotation-based configuration is a type of Spring configuration that uses Component annotations only
             - Annotations include @Component, @Service, @Repository, @Controller and @Autowired
                @Component is a general-purpose stereotype annotation indicating that a class is a Spring component
                @Service,@Repository and @Controller are specializations of @Component for specific use cases
                @Autowired is used to achieve Dependecy Injection
                @ComponentScan annotation or <context:component-scan> element in XML is used to specify the packages
                that Spring scan for component classes
            
            Stereotype Annotations
                - Spring provides stereotype annotations. They are used to create Spring beans automatically in Application
                Context
                - The following are the Spring Stereotype Annotations:
                    @Component
                    It is the main Stereotype Annotation. It is a class-level annotation.
                    @Service
                    It is a specialization of @Component. The business logic is in the service layer, @Service annotation is
                    used to indicate that a class belongs to the service layer
                    @Repository
                    It is a specialization of @Component and is very similar to the DAO pattern
                    DAO classes provide CRUD operations for database tables
                    @Controller
                    It is a specialisation of @Component. It indicates that a particular class is a controller. Mostly used with Spring
                    MVC applications.It is used in combination with annotated methods based on the @RequestMapping annotation
            
            Bean Definition and Instantiation
                
                Bean Definition
                    - In Spring, a bean definition serves as a blueprint for creating bean instances. It defines the charasteristics
                    and configuration of a bean, including its class, scope, properties and dependencies.
                
                Instantiation
                    - Bean instantiation refers to the process of creating an instance of a bean based on its bean definition. Bean
                    instantiation can be done through constructor injection, setter injection and factory methods
                
                Configuration Options
                    - Spring offers multiple approaches to define beans including, XML configuration, Java-based configuration using annotations
                    or @Bean methods and component scanning
                
                Scopes
                    - Beans can have different scopes, such a singleton, prototype, request, session and more
                    - A bean's scope determines how the bean behaves when that bean is requested from the ApplicationContext. Spring could be instructed to either perform a newly-instantiated object or reuse an existing object. Below are the Spring beans scopes:
                        - Singleton
                            The default scpoe, any time a specific bean is requested, the existine object it reused
                        - Prototype
                            Any time a bean is requested, a new object is instantiated
                        - Request
                            Only used in web applications. A new object is instantiated once per web session
                        Session
                            Only used in web applications. A new object is instantiated once per web session
                        Application
                            Only used in web applications. A new object is instantiated once per web servlet
                        Websocket
                            Only used in web applications. A new object is instantiated once per web socket
                
                Lifecycle Management
                    - Spring supports lifecycle callbacks for beans
                
                Dependencies
                    - Beans often depend on other beans to fulfill their functionality. Spring offerrs dependency injection, where dependencies
                    are resolved and injected into beans, promoting loose coupling and modular design
                
                Lazy Initialization
                    - Spring supports lazy initialization, allowing beans to be created and initialized only when they are requested, improving
                    application startup time and resource usage


                Bean Lifecycle
                    - The bean lifecycle is as follows:
                        - Spring IOC starts
                        - Bean Instantiated
                        - Dependencies Injected
                        - Internal Spring Processing
                        - Custom init method(ready for use)
                        - Container shutdown
                        - Custom destroy method
                    
                    - The configuration for custom init and custom destroy methods is done in three methods:
                        - XML-based configuration
                        - Annotation configuration
                        - Interface configuration
                Scopes Of A Bean
                    - The scope of a bean defines the life cycle and visibility of the bean

                    - Singleton
                        - In singleton scope, the container creates a single instance of that bean
                        - It is used for stateless beans(Business logic)
                        - It is defined explicitly by using @Scope("singleton") or @Scope(value = ConfigurableBean
                        Factory.SCOPE_SINGLETON)
                        - All requests for that bean name will return the same object, which is cached
                        - Any modifications to the object will be reflected in all references to the bean
                        - The scope is the default value if no other scope is specified
                    
                    - Prototype
                        - The prototype scope will return a different instance every time it is requested from the
                        container
                        - It is used for stateful beans (Business Logic and State)
                        - It is defined by setting the value prototype to the @Scope("prototype") annotation or
                        `@Scopevalue = (ConfigurableBeanFactory.SCOPE_PROTOTYPE)` in the bean definition
                        - A prototype bean is not initialized by Spring IoC until an object is created
                        - If a Singleton class has a prototype class dependency, the prototype class is initialized
                        along with the singleton class
                        - When a prototype class object is injected into the singleton class a single instance of the
                        prototype class is created
                        -This can be avoided by using AOP proxy object and @Lookup
                    
                    Web Aware Scopes
                        - Request
                        The request scope creates a bean instance for a single HTTP request
                        
                        - Session
                        The session scope creates a bean instance for an HTTP session
                        
                        - Application
                        The application scope creates the bean instance for the lifecycle of a
                        ServletContext

                        - Websocket
                        The WebSocket scope creates it for a particular WebSocket Session 

                Lombok
                 - Lombok is a Java library that helps reduce boiler plate code in Java classes by
                 providing annotations that automatically generate common methods such as getters, setters,
                 constructor, equals, hashCode and toString

                    Features of Lombok
                        - @Getter and @Setter are used to generate getters and setters
                        - @Data is a bundle of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
                        - @Builder - getters, setters and constructor methods
                        - @SneakyThrows - catch blocks or throws
                        - @Cleanup - close()
                        - @Log4j and @Slf4j can be used for annotations
                        - @Synchronized is used to get an autogenerated, private unexposed field


Spring Boot
    - Spring Boot is a powerful framework within the Spring ecosystem that simplifies the development of Java-based applications.
    - It makes developing web applications and microservices with Spring Framework faster and easier through three core
    capabilities:
        - Autoconfiguration
         - It automatically configures beans and components based on the dependecies present in the class path
        -  An opinionated approach to configuration
            - It provites sensible defaults and convenctions for various aspects of application development preventing
            developers from spending time on boilerplate configuration
        - Additional features such as an embedded server and start packs


Comparison of Spring Framework and Spring Boot
    Spring Framework                                                    Spring Boot
    It is a comprehensive and modular framework for building            It is an opinionated framework built on top of the Spring Framework
    enterprise Java applications                                        that aims to simplify and streamline the development of Spring-based 
                                                                        applications

    It provides a wide range of features and functionalities            It includes embedded server support and seamless intergration with the
    for various aspects of application development                      Spring ecosystem

    It requires developes to configure and manage many aspects          It is designed to be easy to use and quick to get started with because of
    of their applications manually                                      autoconfiguration


SpringBoot offers the @PropertySource annotation as a convinient mechanism for adding property sources to the environment
Property values can be injected directly into your beans using the @Value annotation

Spring MVC Annotations
    - @Controller
     - It is similar to @Component. It provides additional information that a class is a controller
    - @RequestMapping
     - It can be used at the class level to specify a common base URL for all handler methods within that controller
     - It can be used at the method level to further specify the URL pattern and HTTP Method for individual handler methods
     - It provides attributes for configuring request mappings to further refine the mapping conditions
    - @ResponseBody
     - It is used to indicate that the return value of a controller method should be serialized directly to the HTTP response