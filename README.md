Repository: appinventiv

Technologies: 
    Programming Language: Java
    Framework           : Spring Boot (Web + Lombok + Dev Tools) + Spring Data JPA
    Database            : MySQL
    
========================================================================================================

This Project uses:
    Entity              : For Bean Definition
    Repository          : For JpaRepository Interaction to use and interact with the DB
    Controller          : For REST API Definitions
    Service             : For Business Logic behind all API's
    
    
Use of Spring Boot enabled the ease of not having to write a lot of Configurations.
Database Configuration is inside "application.properties"

========================================================================================================

There are 6 services:
    1. Save             : To save on movie at a time
    
          POST          : localhost:8080/save
                          {
                            "title" : "Swades",
                            "category" : "Life",
                            "rating" : 4.5
                          }
                          
    2. Save All         : To save a list of movies at once
    
          POST          : localhost:8080/saveall
                          [
                            {
                              "title" : "Jagga Jasoos",
                              "category" : "Musical Thriller",
                              "rating" : 3.5
                            },
                            {
                              "title" : "Harry Potter and the Goblet of Fire",
                              "category" : "Fiction - Fantasy",
                              "rating" : 4.2
                            },
                            {
                              "title" : "13 Reasons Why !!",
                              "category" : "Web Series: College Drama",
                              "rating" : 3.2
                            }
                          ]
          
    3. Fetch by ID      : To fetch a movie by its corresponding ID 
    
          GET           : localhost:8080/fetch/1
                          {
                            "id" : 1,
                            "title" : "Swades",
                            "category" : "Life",
                            "rating" : 4.5
                          }
    
    4. Fetch All        : To fetch all movies present in the DB
    
          GET           : localhost:8080/fetchall
    
    5. Update           : To update details of a movie based upon matching IDs
    
          PUT           : localhost:8080/update
                          {
                            "id" : 1,
                            "title" : "Swades",
                            "category" : "Life",
                            "rating" : 4.5
                          }
    
    6. Delete           : To delete a movie corresponding to its ID
    
        DELETE          : localhost:8080/delete/1
        
        
========================================================================================================
TEST CASES:

The JUnit Test Cases for the Service(Business Logic) Layer are present inside :

"src/main/test/java/com/vishal/appinventiv/"

File: AppinventivApplicationTests.java

========================================================================================================

** Test Cases are written using innate Spring Boot dependencies, no external dependencies were used

** Dockerisation of the Application is possible, it is not a difficult process yet time consuming.
    Given my current knowledge about Dockerisation (Docker File & docker-compose.yml), the same is a promised
    with more time at my disposal.
    
    
