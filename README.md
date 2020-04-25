# glaucus API - Spring MVC, MySQL, Hibernate Rest API

# Requirements

1.Java - 1.8.x

2.Maven - 3.3.9

3.MySQL - 5.7.12

# Steps to Setup

1.Clone the application

  git clone https://github.com/rajeshyash/glaucus.git

2. Create Mysql database
   create database person

3. Change mysql username and password as per your installation
   * open src/main/resources/db.properties
   * change mysql.user and mysql.password as per your mysql installation

4. Build and run the app using maven
   mvn package
   
   A new WAR file will be generated at project/target/glaucus-0.0.1-SNAPSHOT.war, just copy and deploy to your Tomcat.

  The app will start running at http://localhost:8080/glaucus/.
  
# Explore Rest APIs

POST /api/person

GET /api/person/{personId}

PUT /api/person/{personId}

DELETE /api/person/{personId}
