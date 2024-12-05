# Task 1

## a- Our task:

### 1 - Q: What is Spring Boot and why do we use it?
**A:** Spring Boot is a framework built on top of the Spring Framework, designed to simplify the development of Java-based applications.  
We use it because it is widely used in enterprise-level applications due to its scalability, flexibility, and ease of integration.

### 2 - Q: What is the difference between Spring and Spring Boot?
**A:**
- Spring requires manual configuration (XML or Java-based), which is more complex and not friendly for beginners.
- Spring Boot provides auto-configuration, making it easier and faster to use. It’s ideal for Microservices and REST APIs.

### 3 - Q: Explain Spring Boot Annotations: `@Component`, `@Service`, `@Repository`, `@Configuration`, `@SpringBootApplication`.
**A:**
- `@Component`: Defines a class as a component for scanning into the application context.
- `@Service`: A specialized version of `@Component` that provides business logic.
- `@Repository`: A specialized version of `@Component` that interacts with the database.
- `@Configuration`: Marks a class as a configuration class for instantiating beans.
- `@SpringBootApplication`: A combination of three annotations controlling the application context before running.

### 4 - Q: What is the `application.properties` file for?
**A:** It’s a file that defines application settings and properties, making the app flexible and easier to manage.

### 5 - Q: What is Dependency Injection, why is it useful, and how to apply it?
**A:**
- Dependency Injection (DI) is a design pattern where an object’s dependencies are provided by an external entity rather than being created by the object itself.

### 6 - Q: What is Maven, and what is it used for?
**A:**
- Maven is an open-source build automation and dependency management tool primarily used for Java projects.
- It simplifies project builds by managing dependencies, packaging, and deployment.
