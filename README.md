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
- @Getmapping("/createpost")
    - a user can create a post and it will be posted to their profile page
- @Getmapping("/codefellowshipOfTheRing)
    - just a page to display some cash money
- @Getmapping("error")
    - the default error page to show a few details
- @Getmapping("logout_completed)
    - a page to show that a user has been successfully logged out

## Directions
- IntelliJ
    - open CodefellowshipApplication.java
    - run CodefellowshipApplication.java 
- Terminal
    - ```./gradlew test```
    - build and run ```./gradlew bootRun```

## Routes
-- ```localhost:8080```
- ```localhost:8080/login```
- ```localhost:8080/signup```
- ```localhost:8080/users```
- ```localhost:8080/myprofile```
- ```localhost:8080/details```
- ```localhost:8080/error```
- ```localhost:8080/codefellowshipOfTheRing```
- ```localhost:8080/logout_completed```
- ```localhost:8080/createpost```


## Acknowledgments
- I relied heavily on the class repo dinosaur demo. 
- I have also received assistance from Will Fritts, Reina, and Evan