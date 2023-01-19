1) I have implemented Logger and Lombok in the assingment.
2) There are total of 5 api -entercandidate,castvote,countvote,listvote,getwinner. ALl the api is POST request.
3) For entercandidate , We have to send a query parameter if we will send a blank parameter it will sent a "Invalid name" response.
4) For castvote , we will send the name as query parameter and it will increase the count of vote , if we will send any name which is not a candidate it will return "Invalid candidate name".
5) For countvote , we will send the name as query parameter and it will count number of vote , if we will send any name which is not a candidate it will return "Invalid candidate name".
6) For listvote api , it will give us the total candidate name with their respective vote count.
7) For getwinner , this api will give us the winner candidate.
8) I have implemented testcase of all the 5 api.
9) The model class path is - demo-1/src/main/java/com/example/demo/model/Candidate.java 
10) This is the controller class - demo-1/src/main/java/com/example/demo/controller/Testing.java 
11) This is test case file - demo-1/src/test/java/com/example/demo/TestingControllerTest.java
