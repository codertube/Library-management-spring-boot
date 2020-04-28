# Library-managment-app

Library managment application with spring boot.

## Getting Started

1. Tomcat server is configured in port 8082.
2. CorsFilter is used to get rid of CORS error we get while connecting to different server in localhost, here it is from Express server (4200 port) to Tomcat server (8082 port).
3. Right clik LibraryMgmntApplication.java and start as Java application.

## Running the tests

Used @DataJpaTest,@MockBean,@WebMvcTest for unit testing Repository, Service and Controller Layers.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Stand-alone spring applications
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Spring implementation for Data access layer


