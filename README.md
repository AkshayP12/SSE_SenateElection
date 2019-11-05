Australian Senate Election - Web-based Implementation Prototype

Prerequisites:

Jdk 1.8
Spring tool suite 4
Apache tomcat
MYSQL
Steps:

Create database onlinevotingsystem from mysql command prompt

Run the onlinevotingsystem.sql script in the command prompt to create the tables

Configure Spring tool suite with the apache tomcat server by importing it.

Change the mysql database password to your password in src/main/resources/application.properties

Right Click on OnlineVotingSystem > maven > update project

Before running OnlineVotingSystem define its configuration as a maven build.

Base directory: ${workspace_loc:/OnlineVotingSystem}

Goals: spring-boot:run

Parameter Name: server.port

Value: 8443

Select JRE > Alternate JRE > Select Installed JRE > Add jdk1.8 path

Run the project using jdk

Open localhost:8443/login for login page and localhost:8443/register for registeration page
