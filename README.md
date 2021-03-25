# Online Medication Platform Asynchronous Communication

This is the second module of a distributed system for an intelligent medication management system for home-care for patients that need constant medication, medical supervision and assistance in case of home accidents.

The patient has deployed a set of sensors in their house to monitor their activity and automatically detect if they have problems and alert the caregivers or the doctors. The sensors send data as tuples (patient_id, start_time, end_time, activity_label), where start_time and end_time represent the date and time when each activity has started and ended while the activity label represents the type of activity performed by the person: Leaving, Toileting, Showering, Sleeping, Breakfast, Lunch, Dinner, Snack, Spare_Time/TV, Grooming. Two consecutive activities are different.

This module is implemented based on a message broker middleware that gathers data from the sensors and pre-processes them before storing them in the database to the corresponding patient. If the queue consumer application that preprocesses the data detects an anomalous activity according to a of rules, it notifies asynchronously the caregiver application that a patient has problems

## Set of rules
* R1: Sleep period longer than 7 hours
* R2: The leaving activity (outdoor) is longer than 5 hours
* R3: Period spent in bathroom is longer than 30 minutes

## Prerequisites

In order to run the system, you should run in the same time the producer, consumer and the client. The consumer and client will be both run when you are running the client application from Heroku. The producer needs to be run locally. 

For that, after you take locally the version from the master branch, you need to open a browser in order to access the url for sending the messages from producer to consumer. The producer runs on port *8084* and with the endpoint */sending*. So, the needed url will be: http://localhost:8084/sending

Obviously, you will need:
* a version of Java JDK: [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* an IDEA (like IntelliJ or Eclipse)