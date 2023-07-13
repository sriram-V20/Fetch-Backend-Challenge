# Steps To Run :
##Method 1 :
### via docker
1. Install docker
2. If you are using MACOS(Apple Silicon), then use this command to pull the image
    
    
    docker pull sriramv20/fetch-backend-challenge:latest

3.  If you are using a windows/linux OS, then use this command to pull the image

    
    docker pull sriramv20/fetch-backend-challenge-image-windows

4.  After successfully pulling the image check if you have the image using this command


    docker image ls

5.  To run this image, use this command in your terminal, Please don't forget to change the image to the image you've pulled. Tests will run before starting the application


    docker run -p 9000:9000 sriramv20/fetch-backend-challenge

6.  You should be able to this line in terminal, ***Your application is running on port 9000***  
##Note : It might take a while to run the image so please be patient

##Method 2 :

1. Install java and add to path, use the following link
    [Java](https://www.oracle.com/java/technologies/downloads/)
2. Install sbt and add to path, use the following link
    [sbt](https://www.scala-sbt.org/download.html)
3. Open terminal and using git clone, clone the repository


    git clone https://github.com/sriram-V20/Fetch-Backend-Challenge.git

4. Go to the root directory, Fetch-Backend-Challenge and run this command


    sbt clean && sbt compile && sbt test

5. After successful compilation and test, run this command

    
    sbt run

6.After this step, the application should be running on port 9000
    

##Project Structure :
        - app
            - controllers
                - ReceiptProcessorController
            - Models
                - Receipt
                - Item
            - services
                - ReceiptProcessingService
        - conf
            - routes
        - test
            - ReceiptProcessingServiceTest
            - ReceiptWebServiceTest
            - Testcases

 The routes are defined in

        - conf
            - routes

1. The api **/receipt/process** call is processed to ReceiptProcessorController.processReceipt() in controllers and then the request is sent to  ReceiptProcessingService.processReceipt() that stores the receipt in a Map and returns a UUID. 


2. The api **/receipt/:id/points** call is processed to ReceiptProcessorController.getPoints() in controllers and then the request is sent to  ReceiptProcessingService.getPoints()
   where the Receipt object is obtained using the id from params and the points for a Receipt object are calculated in Result.getPoints()

#Tests
`ReceiptWebServiceTest`: This test focuses on the functionality of the web service components, such as controllers, routes, and request/response handling. This test verifies that the web service endpoints are correctly handling requests, returning the expected responses, and interacting with the underlying services as expected.

`ReceiptProcessingServiceTest`: This test focuses on unit tests for the functionality of the receipt processing service. This test verifies the behavior and correctness of the core business logic related to receipt processing, calculating points.

`Testcases` : This file contains the inputs for tests run in ReceiptWebServiceTest and  ReceiptProcessingServiceTest.


##Assumptions :

I assumed the following

1. No two receipts are treated as same because there might be a case in real world where 2 different users can have exact same receipts.


2. Receipt Json in */receipts/process* should have valid values which are not null and Receipt json should not be null


