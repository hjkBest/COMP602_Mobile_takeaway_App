COMP602_Restaurant_App
Mobile Takeaway APP
=====================

Team member
========
* Brian liang
* Jiakun hou 
* Tony xu
* Yunchao cai 


Introduction
=====
> Our team project purpose is to build a modern, useful application that could help our user to order their takeaway easier than before. Our team project is trying to provide a platform that includes many restaurants. So, the user could have more option when they want to order a takeaway. We will manage user order information and generate a unique order ID used to avoid mess up the order. We put the send button down below each menu page; the request will send to the restaurants when the user clicks the button. And a QR code will produce and get to the user.  
>

Installation
=====
* Android API 16 or higher 
* Need APP permissions 
   * Camera
   * SMS
   * Storage

Development Environment
====
* Android studio V 3.1
* JAVA



Porject version: V.0.03
===========

| Version | Sprint |      Date |
| ------- | :----: | --------: |
| V.0.01  |   0    | 29/3/2018 |
| V.0.02  |   1    |  7/5/2018 |
| V.0.03  |   2    | 11/6/2018 |


Change Log
=========

V.0.02 (7/5/2018)
* Set up the User Interface
* Add some basic function to the application
* Allow user to send order to the restaurants

V.0.03 (11/6/2018) 
* Improved the User interface 
* Fix some bug 
* Modify the send and receive function
* Could generate the QR code 
* Could scan the QR code


##Project Feature(fulfilled)
==========
* Allows user to select the restaurants
* Allows user to select the favor and add comment
* Allows user to use the search bar to do a quick search
* Allows user to see the photo of the meal
* Allows user to select the amount of the meal
* Allows user to set the pick-up time as comment
* Could display the order detail (order information; the price of the order)
* Could display the information of the restaurants
* Could send order detail by message
* Could generate a QR code based on the order detail
* Could scan the QR code


Project Feature (futrue)
=============
* Allows the user to check the order history 
* Will implementation login system (need sign up as a user, more secure)
* Will allow send the order by the email
* May add the payment system
* May add the catalogue of the restaurants
* And so on…



Project Preview
========
![Imgur](https://i.imgur.com/Ofg1eIv.gif)



Sequence Diagram
=================

```sequence
user->app: Open the APP
Note right of app: Load the restaurants List (home page)
app-->user: display the restaurants List (home page)
user->app: choice the restaurants
Note right of app: Load the menu page of the selected restaurants
app-->user: display the menu page
user->app: select the meal(s)
Note right of app: receive the order
app->app: generate the order information
user->app: switch to the order page to check it
app-->user: display the order detail
user->app: confirm the order
app->restaurant: send order
app->app: generate QR code
app-->user: display QR code
Note right of restaurant: perpare the order 
user->restaurant: arrive the restaurant
restaurant->user: scan the QR code
user->restaurant: show the QR code
user->restaurant: pick up the order
restaurant-->user: provide the order 
user->restaurant: finish the payment
```


End
====
