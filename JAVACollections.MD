Two types of memory in JAVA:
    Stack memory
     - Used to store local variables
     - Stores the value of a primitive variable
     - Methods, flow control
     - Stores references fore primitive and reference variables
     - Faster access of data
     - Fixed size for a program
     - Data is store in an a last-in-first-out order

    Heap memory
        - Use to store larger allocations of memory(larger objects)
        - Memory is allocated in a random order
        - Stores globally accessible data
        - Slower access to data
        - Data can be stored in fragments across heap

Data Structure
    - It is a format for storing and managing more than one piece of data.
    - Two fundamental ways of storing information in data structures:
        - In arrays
        - With nodes
    Array Based Data Structure                                  Node-Based Data Structure
        - Default Datatype(built-in)                            - Custom-made, though many are provided in JAVA API
        - Supports Random Access                                - Supports different ways to store data(list vs queue vs set)
        - Fixed(non-changing) size                              - Dynamic (changeable) size
        - Immediate access to any index                         - Iteration through traversal of collection
        - Iteration uses indexes                                - Custom iteration must be defined
        - Inserting data may require                            - Easier to insert data in the middle of the collection
        updating multiple proceeding indexes 
    
    Collections Framework
        - The Collections Framework in Java is a set of classes and interfaces that impelement commonly used data structures.
        - The important interfaces in the Collections API are:
            - Iterable - guarantees the collection can be iterated over
            - List - an ordered collection
            - Set - a collection that does not contain duplicates
            - Queue - a collection that operates on a first-in-first-out(FIFO) basis
            - Map - contains key/value pairs.Does not exten Iterable
        - The Map interface does not extend the Collection interface.
        - Collection interface extends the Iterable interface
        - Iterable interface has only one method called the iterator.
        Deque
            - It is a sub-interface of the Queue interface
            - It was added to the collection frameword in Java SE 6.
        Methods of the Collection Interface
            - The Collection interface consists of 15 methods for manipulating elements in the collection.
            - add()
                - It is used to add an element in the collection.
            - addAll()
                - It adds a collection of elemtns to the collection.
            -clear()
                - this method clears or removes all the elements from the collection.
            - contains()
                - this method checks whethher an element is present or not in a collection.
            - containsAll()
                - this methos checks whether a specified collection of elements is present or not.
            - equals()
                - It checks for equality with another object
            -hashCode()
                - It returns the hash code number for the collection
            - isEmpty()
                - It returns true if a collection is empty
            - iterator()
                - It returns an iterator
            - remove()
                - It removes a specified element from the collection.
            - removeAll()
                - it removes all elements from the collection
            - retainAll()
                - This method is used to remove all elements from the collection except the the specified
                collections.
            - size()
                - Returns the total number of elements in the collection
            - toArray
                - Returns the elements of a collection in the form of an array. The array elements are copies
                of the collection elements
    
        Generics
            - They are used with collections to enforce compile time safety by allowing you to use parameterized
            types.
            Generic Classes
            To make a class(or interface) generic, use the angle brackets when declaring it and use an arbitary 
            "generic type" which is determined by the invoking code.
            Naming Convention for Generics
                E => Element
                K => Map Key
                V => Map Value
                N => Number
                T => Generic data type
        Set
            - The set interface contains only methods inherited from Collection and adds the restriction that duplicate
            items are prohibited

            HashSet
            - HashSet implements Set and is backed by a Hashmap.It
                - Guarantees not ordering when iterating
                - Allows one null value
                - Allows fast insertion and traversal
                - Does not maintain order in which you insert elements
            - TreeSet
            - Type of Set whose lements maintain a sorted order when inserted.
            It is backed by a Sorted Tree. It cannot contain a null value.

            - The methods declared by a Set are summarized as follows:
                - add() - Adds an object to the collection
                - clear() - Removes all objects from the collection
                - contains() - Returns true if a specified object is an element
                            within the collection.
                - isEmpty() - Returns true if the collection has no elements
                - iterator() - Returns an iterator object for the collection,
                                which may be used to retrieve an object.
                - remove() - removes a specified object from the collection.
                - size() - returns the number of elements in the collection.
        
        Queue Interface
            - Based of FIFO(First In First Out Structure)
            - Some queue specific methods include:
                - offer() - Inserts a new element into the queue
                - poll() - Removes an element from the front of the queue
                - peek() - Inspects the element at the front of the queue without
                            removing it
        
        Map Interface
            - Map cannot impelement the collection interface but it is still considered part
            of the Collection Framework.
            - Map cannot be iterated over driectly. One must either use:
                - entrySet()
                    Method to iterate over the set of Map.Entry
                - keySet()
                    Method to iterate over the set of keys
                - values()
                    Method to return a Collection of values which can then 
                    be iterated over
            - There are two interfaces for implementing Map in Java:
                - Map
                - SortedMaps
            - There are three classes:
                - HashMap
                    - An older, thread-safe implementation of a HashMap is called
                    a HashTable. It does not allow null keys or null values.
                    - Stores elements in key-value pairs
                    - Insertion/Retieval of element by key is fast
                    - Tradeoff is that it does not maintain the order of insertion
                    - Permits one null key and null values
                - LinkedHashMap
                - TreeMap
                    - Keys are stored in a Sorted Tree Structure
                    - Main benefit is that keys are always in sorted order
                    - Insertion/Retrieval are slow
                    - Cannot contain null keys as null cannot be compared for sorting
                - Use put() to add items to a HashMap or a HashTable
                - Use remove() to remove the items
                - Use get() to retrieve the items

Iterators
    - Iterable and Iterator Interface
        - The Iterable interface defines a data structure which can be directly traversed using the
        .iterator() method which returns an Iterator
        - The Iterator interface contains methods for traversal including:
            - hasNext()
            - next()
            - remove()
        - Any object which implements the Iterable interface can be iterated over using a special
        kind of for loop, the enhanced for loop.
            List<String> names = new ArrayList<>();
            // add names....
            for (String name : names) {
                System.out.println(name);
            }
        - The enhanced for loop does not track the index of iteration

        - Iterable represents a collection that can be traversed
        - Iterator() is an interface that allows us to iterate over some other object
            We use the hasNext() and next() methods in a while loop