SOLID
S Single Responsibility Principle(SRP)
    Each class should have only one Responsibility or job to do.

Open / Closed Principle(OCP)
    Software entities should be open for extension but closed for modification.
    In Java, it can be achieved by using interfaces, abstract classes and polymorphism

Liskov Substitution Principle(LSP)
    LSP states that subtypes should be substituted for their base types. Subclass should not 
    change the behavior of the superclass.
Interface Segregation Principle(ISP)
    Aim to create interfaces that are small and focused

Dependency Inversion Principle (DIP)
    Use interfaces of abstract classes to define the behavior of your classes,
    then use dependency injection to provide specific implementations

Maven
It is a tool for building and managing any Java-based project.
Maven helps in the following ways:
Simplifies the build process
Adding jars and dependencies
Documenting project information with change logs and reports
Intergrating with source control systems(GIT)

Features of Maven:
Project Object Model(POM)
Maven Lifecycles

POM handles maven project configuration and dependecies.
They are defined in the pom.xml file.

Maven build lifecycle:
    Validate
    Compile
    Test
    Package - packages all compiled code to WAR/JAR file
            intergration
    Verify
    Install
    Deploy

Each dependency in the Pom.xml file is described by its groupId, artifactId and version.

JaCoCo(Java Code Coverage)

SDLC - Software Development Lifecycle
Planning, Requirements, Design, Build, Document, Test, Deploy

Scrum Ceremonies
Sprint Planning
Daily Standup
Sprint Review
Sprint Retrospective

Waterfall Methodology
Requirements(sometimes made into Idea phase or broken into Planning and Analysis Phase)
Design(sometimes broken into Logical and Physical Design sub-phases)
Implementation
Verification(Testing occurs here)
Maintenance

Linux File Commands Using Gitbash
ls - lists directory contents. It lists files and directories ie ls -l | more
    ls -l shows a more details of the contents in the directory

cd - changes the current directory ie cd/var/log

pwd - displays the current directory path

mkdir - makes a directory

cat - used to create, view and concatenate files. ie cat > newfilename - creates a new file
        cat sourcefilename > destinationfilename - this command copies the file "sourcename" into the file
                            "destinationfilename"
touch - creates an empty file for editing later ie touch filename

echo - prints the strings that are passed as arguments to the standard output which can be redirected to a file.
        ie echo "Some line" > file1.txt - will create a file1.txt file containing the text "Some line"

grep - grep is used to search files and directories for a string.
        grep Aaron filename - searches the file "filename" for the string "Aaron"

diff - the diff compares two files line by line to find differences.
        diff file1.txt file2.txt


Commands For Moving And Deleting Files Using Gitbash
    mv - moves a file or renames it
        mv file1 directory1// moves 'file1' to 'directory1' //moves 'file1' to 'directory1'
        mv file1 file2 file3 dir1 // moves 'file1', 'file2' and 'file3' to 'dir1'
        mv file1 file2 // renames 'file1' with the new name 'file2'. Can also be used to rename directories.
        mv -i file directory1 // just as above, this will move 'file1' into 'directory1' but the -i flag will
                                prompt the operator should the command result in overwriting an existing file.
        mv -n file1 directory1 // similar to the above, however the -n flag will not move 'file1' to 'directory'
                                if it causes an overwrite
        mv -u file1 directory1 //the -u flag will only move 'file1' to 'directory1' if the source file is newer
                                    than the destination file
        mv -b file1 directory1 // the -b flag will create a backup of any existing destination file overwritten by
                                    file1
    
    cp - copies a file
        cp second.txt third.txt // copies 'second.txt' into a file 'third.txt'
        cp -i second.txt third.txt // -i stands for Interactive copying. With this option system first warns
                                        the user before overwriting the destination file
        cp -b second.txt third.txt  // -b will create a backup of the destination file in the same folder
        cp -f second.txt third.txt // -f stands for force; if the system cannot open the destination file then
                                        the destination file is deleted first before the copying proceeds
        cp -r directory1 directory //-r is for Recursive copying which is used for copying the contents of
                                    'directory1', including all subdirectories, into 'directory'

        cp -p second.txt third.txt // -p stands for preserve. The command preserves some characteristics of
                                    'second.txt' in the destination file 'third.txt' including times of last
                                    modification and access, ownership and file permissions.

    rm
    The rm command deletes files/directories.
        rm file1 // deletes 'file1' in the current working directory
        rm -i file1 //-i stands for interactive; this prompts the operator before deleting each file
        rm -f file1 // -f forces deletion if a file is write protected. It will not remove a write-
                        protected directory.
        rm -r directory1 // -r (recurisive) will delete all files in 'directory1' and all subdirectories
                            of 'directory1' and their contents.

    Root Directories
    - /bin: holds executable programs that are required for the operating system to work
    - /boot: contains all the files needed for your operating system to boot.
    - /home: contains directories for each user.Sometimes these are in /usr instead.
    - /lib : essential C libraries used by binaries
    - /opt : contains local/optional software
    - /sbin: system binaries
    - /var : for files that are changed often

Version Control Systems
- There are 2 types of Version Control Systems:
    - Centralized Version Control System - repository is located in one place and gives acces to many clients
    - Distributed Version Control System - every user has a local copy of the repository and there is one
                                            central repo on the server-side.

Git
- Distributed Version Control System
- There are three main states that your files can reside in: modified, staged and commited

Main Sections Of A Git Project
- There are three main sections of a git project
    - The working tree -  single checkout of one version of the project, downloaded on your local machine.
    - The staging area - store information about what will go into your next commit.
    - The Git directory(repository) - it is where git stores the metadata and object database for your project.

Data - information with a purpose. 

Database - system of software and capabilities that make validating, storing, searching, filtering, aggregating,
            grouping, and administering data possible. In enterprise applications, databases fall into 2 main categories SQL and NOSQL.Organized collection of data.

            SQL Databases - They are a type of RDBMS which use the Structured Query Language to administer
                            the data
            
            NoSQL databases - Not Only SQL(NoSQL) databases are not necessarily based on the relational model
                                unlike RDMS. They use other means or DSL(domain-specific language) for
                                administering data and use different structures for storing data and
                                elational information.

            SQL is divided into 5 sublanguages:
                -DDL 
                    Data definition language. Defines data structure.Create,alter, drop,
                    truncate, rename
                -DML
                    Data manipulation Language. Insert, update, delete, record. CRUD.
                -DCL
                    Data Control Language. Grant or revoke access permissions to database
                    object.Grant.Revoke.
                -TCL
                    Transaction Control Language.Defines concurrent operation boundaries
                -DQL
                    Data Query Language.Search, filter, goup, aggregate stored data. Select.
            
            ANSI - American National Standards Institute

            Schema - organization of data as a bluprint for the construction of the database.
                    Modeling them implentation. Modeling done using tools to create an Entity Relation
                    Diagram(ERD), implementation uses SQL to create the table objects.
                    integrity constraints - information that defines the schema
                                            - ie Column names, data types, data constraints, relationships 
            Tuple - an ordered set of values. The number of values is fixed.It is a row in a table.

            CREATE TABLE, DROP TABLE, TRUNCATE TABLE(emove all the data from a table), ALTER TABLE

            SQL Data Types
            Character - fixed(char(n), character(n)), variable length
            Numeric - Decimal, integer, Floating Point
            Temporal - Date, time, timestamp







