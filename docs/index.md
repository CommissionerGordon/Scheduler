# Scheduler

An application by Team Scheduler  
CSC 413 Advanced Software Development I  
Spring 2015

<br>
##Overview of the software
The scheduler will be an application that allows users to view possible schedules for activities during a given period of time. The application will allow users to create activities that want to be accomplished during the given time. It will also allow users to create conditions for activities or groups of activities, such as when a user wakes up, or what times the user would prefer to go to the gym. Given these activities and conditions, the application will provide optimal schedule options for the user for the given period of time.

---

<br><br><br>
# Introduction

---

##Initial requirements
The basis for the project was to create an application that implemented a database and web-based user interface. Our software would create a locally hosted database that communicated with the application and create events with the restrictions given by the user.

---

##Scope
The functional aim of the project at launch was to create an interactable user interface to which activities/events with restrictions, such as the duration, time, and date, could be added by the user. In the case that the user does not input a specific time or date for an event, the application will give the user an optimized schedule that includes each event.

---

##Team
* Justin Fern
* Kyle Huntsman
* Brandon Olson
* Nathan Reline

---

##Goals
In order to complete the project, the team had to become familiar with how a database and web server work. To provide a uniform build system while using version control between the team members, we sought out to learn Maven and the other benefits it brought with it, which included making the build process easier within our environment and giving guidelines for practices during development. In relation to the scope of the project, we decided that the best option for calculating the most optimized schedule for the user was by using a genetic algorithm, another field we had yet to approach. Last, but not least, was the front end side of development. Members of the team either used JavaFX for the first time and learned how to use the software platform or furthered their knowledge and efficiency for better future usage.

<br><br><br>
#Body

---

##Software architecture
For this project, we implemented a number of different tools that ended up in our project architecture.

* Java
* JavaFX
* Apache Tomcat
* H2 Database

###Java
We chose Java as our primary programming language because of Java's powerful code-once run everywhere mentality. We also chose Java to take advantage of the JavaFX library, which is a library included in the Java Development Kit (JDK) that aids in the creation of graphical user interfaces (GUI). If you'd like to learn more about Java, click [here](https://www.java.com/en/about/).

###JavaFX
After some research on JavaFX, we found we could run JavaFX applications in a browser, which would allow us to use our Java code and our existing knowledge of JavaFX to create the web interface. If you'd like to learn more about JavaFX, click [here](http://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm#JFXST784).

###Apache Tomcat
Apache Tomcat was chosen over other Java servers, because research showed it to be the most supported, and really well documented. It also came with an embeddable version, which allowed us to easily embed a server instance into our application. With the tomcat server embedded into the application, we didn’t have to worry about the user needing to setup a standalone server and managing the apps that are installed on the server. If you'd like to learn more about Apache Tomcat, click [here](http://tomcat.apache.org/).

###H2 Database
H2 Database was our database of choice, because of it's Java compatibility, it's size, and it's ability to run in embedded mode. With the database embedded in the application, we minimize the amount of work the user has to do to run and maintain the application. If you'd like to learn more about H2 Database, click [here](http://www.h2database.com/html/main.html).

---

##Software lifecycle
Still working on it...

---

##Features
Still working on it...

---

##How to use the software
Still working on it...

---

##Software architecture
Still working on it...

---

##UML diagrams
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut risus porttitor, placerat dui nec, feugiat arcu. Sed sit amet tortor ex. Fusce ornare egestas molestie. Cras arcu ipsum, maximus id mollis vitae, consectetur ac dolor. Nam blandit eros congue leo scelerisque elementum. Nullam lorem quam, pellentesque vel faucibus quis, lacinia ac ipsum. Vivamus accumsan vel risus vel hendrerit. Phasellus congue laoreet tellus. Praesent ultrices neque ut tempor dictum. Sed imperdiet orci placerat, sodales velit vitae, auctor neque. Fusce libero risus, viverra vel vehicula vel, vehicula et orci. Donec dignissim orci non orci fringilla, sit amet lacinia ligula facilisis. Duis non metus malesuada, molestie enim sit amet, scelerisque magna. Pellentesque rutrum nec nisi et aliquet. Maecenas tristique eu dolor pellentesque pellentesque. Curabitur congue at ipsum ut accumsan.

---

##Database
As mentioned before, we chose to use H2 Database for our database implementation. We opted to run H2 in embedded mode, which would allow the database to exist within the application, and create less hassle on the user's end by not requiring them to run an external database.

The tables in the database were optimized to third normal form to keep data from being duplicated within the database. Duplicated data is never a good idea, as data that needs to be changed would have to be changed in multiple tables, making the work harder for ourselves.

---

##Web interface
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ut risus porttitor, placerat dui nec, feugiat arcu. Sed sit amet tortor ex. Fusce ornare egestas molestie. Cras arcu ipsum, maximus id mollis vitae, consectetur ac dolor. Nam blandit eros congue leo scelerisque elementum. Nullam lorem quam, pellentesque vel faucibus quis, lacinia ac ipsum. Vivamus accumsan vel risus vel hendrerit. Phasellus congue laoreet tellus. Praesent ultrices neque ut tempor dictum. Sed imperdiet orci placerat, sodales velit vitae, auctor neque. Fusce libero risus, viverra vel vehicula vel, vehicula et orci. Donec dignissim orci non orci fringilla, sit amet lacinia ligula facilisis. Duis non metus malesuada, molestie enim sit amet, scelerisque magna. Pellentesque rutrum nec nisi et aliquet. Maecenas tristique eu dolor pellentesque pellentesque. Curabitur congue at ipsum ut accumsan.


<br><br>
#Conclusion

---

##What we completed
In the end we completed the basis for a scheduling web-interface application with a client-server model. Firstly, we were able to create a server that the user was able to launch on the host computer. The server has an interface in which a user can specify a port, launch the server, and end the server. On the client-side, the user is able to launch a web browser and connect to the server to give the client access to the user interface. Using the user interface, a user is able to create very simple activities when the user selected a time and duration for the activity. 

---

##What had to be scrapped
Currently the application is not able to send information between the server and the client. This means the data created by the application is stored client-side only and cannot be stored on a server. The information that the user can create on the client-side is very limited; the user cannot name activities, remove or edit activities, or create recurring events. Originally the application was going to include several other features such as an automated schedule optimization tool, multiple activity layers, and user logins. These features had to be scrapped to due to a combination of complications during development and lack of time.

---

##Problems faced
Still working on it...

---

##What we would do differently
Still working on it...

---

##Next steps
Still working on it...
