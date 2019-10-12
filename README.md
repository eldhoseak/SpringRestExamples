# SpringRestExamples

This is a sample project to demonstrate the Spring RESTful services using web mvc. 
You can run the project using Embedded Tomcat using Maven, settings for which you can find in the pom.xml. 

In order to run, clone the project and use mvn tomcat7:run command. 
This will start the embedded tomcat and depoyed project will be available in context path /springrest

Sample URL in local: http://localhost:8080/springrest/person

A sample input for POST/ PUT endpoint is below
{
"age": 30,
"firstName" : "Ed",
"lastName": "Abraham"
}
