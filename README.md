# Blog-Microservices


## Description
This project is a simple microservices project that uses Spring Boot, Spring Cloud, and Docker. The project is divided into three services: blog-service, user-service, and comment-service. The blog-service is responsible for creating and retrieving blog posts. The user-service is responsible for creating and retrieving users. The comment-service is responsible for creating and retrieving comments. The services communicate with each other using REST APIs. The project uses Eureka for service discovery and Ribbon for client-side load balancing. The project uses Docker to containerize the services.
This project has microservices that would be needed for a blog application. The services are:
- post-management: This service is responsible for managing blog posts. It has APIs for creating and retrieving blog posts.
- comments-management: This service is responsible for managing comments. It has APIs for creating , retrieving and managing comments.
- Authentication and Authorization: This service is responsible for registering , login and security purpose.
- Category-management: This service is responsible for managing categories. It has APIs that helps in managing the comments category wise.