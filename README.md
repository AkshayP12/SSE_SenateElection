# SSE_SenateElection
Australian Senate Election - Web-based Implementation Prototype

Prerequisites:
1. Jdk 1.8 
2. Spring tool suite 4 
3. Apache tomcat
4. MYSQL

Steps: 
1. Create database onlinevotingsystem from mysql command prompt
2. Run the onlinevotingsystem.sql script in the command prompt to create the tables
3. Configure Spring tool suite with the apache tomcat server by importing it.
4. Change the mysql database password to your password in src/main/resources/application.properties
5. Right Click on OnlineVotingSystem > maven > update project
6. Before running OnlineVotingSystem define its configuration as a maven build.

	Base directory: ${workspace_loc:/OnlineVotingSystem} 
	
	Goals: spring-boot:run 
	
	Parameter Name: server.port
	
	Value: 8443
	
7. Select JRE > Alternate JRE > Select Installed JRE > Add jdk1.8 path 
8. Run the project using jdk
9. Open localhost:8443/login for login page and localhost:8443/register for registeration page
