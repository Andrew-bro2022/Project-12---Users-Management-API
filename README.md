- Hello, this is a mini backend Users Management API.

- Tech stack: Spring Boot, Rest API, h2 database, Spring web, Junit, Java 17,  etc.

- The API service will be responsible for the following, you can run the UsersManageApiApplicationTests.java file for the testing. Thank you.

• Creating new users

• Listing all available users<br>
• Listing a single user<br>
• Updating an existing user<br>
• Deleting an existing user<br>

The users should store the following information:
• A username<br>
• A first name<br>
• A last name<br>
• An email<br>
• A phone number<br>

Initialization | The service will need to perform the following:
• Present a REST API (producing and consuming JSON)<br>
• Persist users through restarts<br>

Exposing an API | The service should present the following API endpoint:
• POST /users - create a new user<br>
• GET /users - get a list of users<br>
• GET /users/{id}<br>
• PUT /users/{id}<br>
• DELETE /users/{id}<br>
