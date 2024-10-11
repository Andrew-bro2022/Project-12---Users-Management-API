- Hello, this is a mini backend Users Management API.

- Tech stack: Spring Boot, Rest API, h2 database, Spring web, Junit, Java 17,  etc.

- The API service will be responsible for the following, you can run the UsersManageApiApplicationTests.java file for the testing. Thank you.

• Creating new users
• Listing all available users
• Listing a single user
• Updating an existing user
• Deleting an existing user

The users should store the following information:
• A username
• A first name
• A last name
• An email
• A phone number

Initialization | The service will need to perform the following:
• Present a REST API (producing and consuming JSON)
• Persist users through restarts

Exposing an API | The service should present the following API endpoint:
• POST /users - create a new user
• GET /users - get a list of users
• GET /users/{id}
• PUT /users/{id}
• DELETE /users/{id}
