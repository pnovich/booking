 REST application Hotel booking
========
The app create user,new booking, show bookigs, 
evailable rooms for the dates,total price of booking.
The examples of main rest -requests:
1.Creating booking(post). 
Creating new booking if dates are avaible.
One user can create only one booking.
(pathvariable userId,param roomId,dates "yyyy-MM-dd")
http://localhost:8080/createbooking/1?roomId=1&string1=2018-05-01&string2=2018-05-15&ad=true

2.Creating user(post)
(pathvariable userName)
http://localhost:8080/createuser/freeusername

3.Show all avaibaile rooms for the dates(get)
(param String date1,date2)
http://localhost:8080/getfree?string1=2018-10-11&string2=2018-10-14

4.Show booking for user be userId(get)
(pathvariable userId)
http://localhost:8080/viewbooking/1

5.Show total cost of booking by userId(get)
(pathvariable userId)
http://localhost:8080/bookingprice/1

6.Show rooms filtered by category(get)
(pathvariable categoryId)
http://localhost:8080/category/1

7.Show all bookings(get)
http://localhost:8080/bookings



H2 Database SetUp
--------------------
The scripts in data.sql create two rooms,two categories and two users.

--------------------
If you use h2 database console you have to 
connect it with url:
     url :    jdbc:h2:mem:booking
and username with empty password:
    username:   user 
     


Start app:
---------
You must run the command on the command line

If install Maven: mvn spring-boot:run


Open in browser: http://localhost:8080

Tools that was used:
Spring Boot,  
Spring-data jpa,
h2,
maven, 
JUnit,
Mockito.
