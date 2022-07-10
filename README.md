# Lab10 - Part 2 - Implement an end-to-end data-driven webapp using Spring WebMVC & Spring Data JPA

In this assignment, you are required to implement a new Spring Web application, named 
**"eRegistrar"**, which is an online **Student Registration system** for a University.

To do this, using Spring Boot,
create a new web application project named,
`eRegistrar`. Your solution should make use of the following tools,
technologies, frameworks and APIs:

`Spring Web MVC, Thymeleaf for the UI, Spring Data JPA and a relational database such as MySQL.`


You are expected to implement the following 5 basic use-cases:

1. **Display a homepage** for the web app (e.g. url - http://localhost/eregistrar/home etc) which presents menu of items/links on a navigation bar.
2. **Display List of Students** - presents to the user, a list of all the students who have been registered in the university. You may display the data in an html table.
3. **Register a New Student** - enables the user (e.g. the university registrar) to add a new Student into the system, using an html form.
4. **Edit a Student's registration data** - enables the user (e.g. the university registrar) to retrieve a Student's registration data, update it and save the change(s) to into the system.
5. **Delete a student's registration data**.
6. Also add a feature in the application, to provide a means for the user to be able to **search for Students**.

Note: The specification for Student data, is as follows:
```{
studentId : (should be the primary key field)
studentNumber: e.g. 000-61-0001 (required)
FirstName: e.g. Anna (required)
MiddleName: (optional)
LastName: e.g. Smith (required)
cgpa: e.g. 3.78 (optional)
enrollmentDate: e.g. 2019-5-12 (required)
isInternational: (values: "Yes", "No") (required) - 
Hint: Implement/present this data in a drop-down list or Radio button
```

When complete: 
Take screenshots of your eRegistrar screens and add them to a subfolder inside your
project named screenshots; zip your project folder into a zip file named,
**eregistrar.zip** and
upload/Submit here on Sakai or
push to your github and submit its url to sakai. 
**(Advice: Use the elibrary project (shown in class) as a guide)**

*//-- Enjoy --//*

## Screenshots
### Add Student
<img width="1512" alt="1" src="https://user-images.githubusercontent.com/7867129/178157474-40015914-3515-4875-a1fa-f0b094855391.png">

### List Student
<img width="1512" alt="2" src="https://user-images.githubusercontent.com/7867129/178157476-b03d7943-a0da-4ac9-9534-d3eb2863fd36.png">

### Update Student
<img width="1512" alt="3" src="https://user-images.githubusercontent.com/7867129/178157477-cbce9978-ee22-4eec-8bd3-753fa0f2bd49.png">
