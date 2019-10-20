# SSE_SenateElection
Australian Senate Election - Web-based Implementation Prototype

Setup Spring framework:

1. Download Spring tool suite 4 (make sure you provide upgraded version of JDK)
2. Download Apache tomcat
3. Download MYSQL
4. Create database onlinevotingsystem from mysql command prompt
5. Run the onlinevotingsystem.sql script in the command prompt to create the tables
6. Configure Spring tool suite with the apache tomcat server by adding it in the package explorer.
7. Change the database password to your password in src/main/resources/application.properties
8. Right Click on OnlineVotingSystem > maven > update project
9. Before running OnlineVotingSystem define its configuration as a maven build
	Base directory: ${workspace_loc:/OnlineVotingSystem}
	Goals: spring-boot:run
	Parameter Name: server.port
	Value: 8080
10. Run the project
11. Open localhost:8080/login for login page and localhost:8080/register for registeration page
