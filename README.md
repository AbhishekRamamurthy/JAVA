# Java and Java Frameworks

Examples of Java data structure implementation and some examples of Java webapp and database connection using Sping and Hibernate

## Data Structure Implementations
	a) LinkedList
	b) BinaryTree

## Spring5
	a) Webapp demonstrating Spring MVC, demonstrating dependency injection using XML, 
	   Annotations and JAVA Classes

## Hibernate5
	a) Database application demonstrating: 
		(i) OnetoOne bi-directional, uni-directions
		(ii) OnetoMany and ManytoOne
		(iii) ManytoMany 
	database table relationships and a Java applications to verify the same
	
## CustomerTracker (CRM using Spring MVC)
	a) End to End application demonstrating usage of Spring and Hibernate
	b) Database Type: Relational (MySQL)
	c) Application currently supports add, delete, update and search for a customer. 
	d) Logging Aspects using method level aspects of Spring
	e) Login mechanism using spring http security
	f) Role based user view	
	
	Build Tool: Maven
	Screen shots are attached in CustomerTracker directory

## CustomerTracker (CRM using Spring REST Web Service)
	a) Web service layer for CRM project using Spring and Hibernate
	b) 5 End-Points for get all, get by id, add, update and delete delete customers
	c) Secure endpoints, i.e. only authenticated users have view access.
	
	EndPoints:
	get:
		GET: /api/customers
		GET: /api/Customers/{id}
	
	add:
		POST: /api/customers/
	     	applicationContext/json
	
	update:
		PUT: /api/customers/{id}
	     	applicationContext/json
	
	delete:
		DELETE: /api/customers/{id}
	
	Build Tool: Maven



