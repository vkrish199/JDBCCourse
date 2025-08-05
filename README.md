1. Import Packages (Java.sql)
2. Load the driver (we need a JAR file) (in newer versions this is automatic)
3. Register the driver (in newer versions this is automatic)
4. Make a Connection
5. Create statement
6. Execute statement
7. Close the connection

refer DemoJdbc.java 

* Use executeQuery of statement to run select queries
* Use execute of statement to run insert, update, delete queries
* Statement will become problematic for working with user defined values, variables
* Using statement in these cases can also introduce the risk of sql injection
* To overcome this challenge we can use PreparedStatement where we can use dynamic parameters (?)

* Using JDBC, we have to do a lot of steps to manage connections and run queries, it is not very
    developer friendly
* We can use ORM frameworks like Hibernate to improve productivity