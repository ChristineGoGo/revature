DCL
    - The Data Control Language of SQL is used to control rights, and permissions
    of users on database objects.
    - Commands include:
        - GRANT
        Used to give users access privileges to the database or specific objects
        - REVOKE
        Removes users' access privileges to the database or specific objects
TCL
    - Transaction Control Languge is used to manage the SQL transactions(a sequence
    of one or more SQL operations such as queries, inserts, updates or deletes)
    - Commands
        - START TRANSACTION
        Starts a new transaction
        - COMMIT
        Used to save the data permanently
        - ROLLBACK
        Used to get the data or restore the data to the last savepoint or last
        committed date
        - SAVEPOINT
        Used to save the data at a particular point temporarily
ACID
    - The ACID properties are a set of four properties that guarantee the realiability
    and consistency of database transactions
    Atomicity
    - An atomic transaction is one that cannot be further broken down into individual
    operations. If a single operation fails during a transaction, then everything must
    be rolled back. All operations that occur within a transaction either fail or succeed
    as a single unit.
    Consistency
    - One of the advantages of using a transaction is that, even if the transaction is a success
    or failure, the database is consistent and the data integrity is maintained.
    Isolation
    - Every transaction is isolated from other transactions.
    Durability
    - Data modifications that take place within a successful transaction may be safely considered
    to be stored in the database regardless of whatever else may occur.

    Transaction Isolation Levels
    - Read Uncommited
    - Read Commited
    - Repeatable Read
    - Serializable

    Transaction Phenomena
        - Transaction phenomena, or concurrecy anomalies, are unwanted or unexpected occurences that can occur due to concurrent transactions being executed
        Examples are
            - Dirty Read
            - Non Repeatable Read
            - Phantom Read

            Isolation Level     Dirty Reads     Non-repeatable Reads    Phantoms
            Read Uncommited     May Occur       May Occur               May Occur
            Read Committed      Don't Occur     May Occur               May Occur
            Repeatable Read     Don't Occur     Don't Occur             May Occur
            Serializable        Don't Occur     Don't Occur             Don't Occur

Aggregate Functions
    - Aggregate functions in MySQL provide the output as a single value after
    performing different opperations on a set if values
    - The 5 commonly used aggregate functions are as follows:
        Aggregate Function                          Description
        count()                                     Returns the number of rows, including NULL
        sum()                                       Returns the total summed values in a set
        avg()                                       Returns the average value of an expression
        min()                                       Returns the lowest value in a set
        max()                                       Returns the highest value in a set

Scalar Functions
    - Scalr functions are predefined functions in SQL. They operate on a single value
    and return a single value. Seven common scalar functions are given as follows:
    Scalar Function                                 Description
    UCASE()                                         Converts the value of a field to uppercase
    LCASE()                                         Converts the value of a field to lowercase
    MID()                                           Returns the substring from the text field
    LEN()                                           Returns the length of the value in a text field
    ROUND()                                         Used to round a numeric field to the number of decimals specified
    NOW()                                           Returns the current system date and time
    FORMAT()                                        Used to format how a field is to be displayed
Sequence
    - A database sequence is an object in a Relational Database Management System(RDBMS) that generates a sequence of
    numeric values according to a specified pattern
    - They are often used to generate unique identifiers for primary keys in database tables especially when the
    primary keys need to be generated independetly of the data being inserted into the table
Trigger
    - A trigger is a named SQL unit that is stored in the database and runs in response to an event that occurs in
    the database or when there is a modification in the database
    - There are 6 types of triggers for each table:
        - AFTER INSERT
        - AFTER UPDATE
        - AFTER DELETE
        - BEFORE INSERT
        - BEFORE UPDATE
        - BEFORE DELETE

Optional Class
    - An optional class in Java is a container object that may or may not contain a non-null value
    - It was introduced in Java 8 as a way to handle scenarios where methods may return null values
    - Optional encourages developers to explicitly handle the case where the value may be absent
    Optional methods
        - of(value)
        -ofNullable(value)
        - empty()
        - isPresent()
        - ifPresent(consumer)
        - get()
        - orElse(other)
        - orElseGet(Supplier)
        - orElseThrow(Supplier)
        - map(function)
        - flatMap(Function)
        - filter(Predicate)
Stream API
    - In Java 8, Stream API is a functional way of defining operations on a stream of elements
        Streams are an abstraction which allow defining operations which do not modify the source
        data and are lazily executed
    - A stream is a sequence of elements that can be processed sequentially or in parallel. It represents
    a pipeline of data processing operations that can be applied to a collection. Streams are created from
    various data sources such as collections, arrays, or generator functions.
    - Streams are divided into intermediate and terminal operations
        - Intermediate 
            They return a new stream and are always lazy. They don't execute until a terminal operation is
            called. Some common examples include map, filter, distinct, sorted, limit and skip
        - Terminal
            They trigger the execution of the stream pipeline, which allows efficiency by performing all
            operations in a single pass over the data. Examples include forEach, collect, reduce, count,
            min, max, anyMatch, allMatch and noneMatch

            Reduction operations take a sequence of elements and combine them into a single result.
            They have the reduce() and collect() methods for this purpose, with many built in operations
            defined in the Collectors class.

Reflection API
    - Reflection in Java is a feature that allows a program to examine and manipulate its own structure,
    behavior and metadata at runtime
    - It provides a way to inspect and modify classes, iterfaces, fields, methods and consturctors, even
    if they are private or inaccessible through normal means
    - They are particularly useful for building generic code, implementing frameworks and writing debugging
    tools. The API can be found in the java.lang.reflect package 
