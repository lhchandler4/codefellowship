# Spring for Full-Stack Web Apps

## Description
- A app using spring security where users can sign up, log in, and view their codefellowship
profile. They can also view the profiles of other users based on their usernames

## API
- @GetMapping("/login")
    - users can login
- @GetMapping("/signup}")
    - user can sign up when visiting for the first time
- @GetMapping("/users")
    - display the users based on username
-  @GetMapping("/myprofile")
    - shows the individual profile of a user
- @Getmapping("details")
    - see the details of a user when clicking
- @Getmapping("/")
    - default page is the login page

## Directions
- IntelliJ
    - open CodefellowshipApplication.java
    - run CodefellowshipApplication.java 
- Terminal
    - ```./gradlew test```
    - build and run ```./gradlew bootRun```

## Routes
- ```localhost:8080/login```
- ```localhost:8080/signup```
- ```localhost:8080/users```
- ```localhost:8080/myprofile```
- ```localhost:8080/details```


## Acknowledgments
- I relied heavily on the class repo dinosaur demo. 