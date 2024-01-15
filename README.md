This is simple Spring Boot REST API based on Spring Boot 2.7.6.SNAPSHOT and supports Java 11.

To run, 
1. Clone this resposity and run ``maven install``
2. Navigate to the *target* directory and run ``java -jar <app-name>.0.0.1-SNAPSHOT.jar``
3. Ensure your database is correctly initialized. Pick ``src/main/resources/schema.sql`` as your database script. Update your database username and password in the ``src/main/resources/application.yml`` file
4. Test the API via a tool like Postman as guided in my blog at https://david-matu.github.io/blog/spring
