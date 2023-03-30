When using post, we may want to send data to the server.
This data is attached to the request body of the req url

for example ,here if you are using Jquery

Here we make a post request and attach the data to the body.
$.ajax({
  method:"POST",
  url:"http://www.ninjago.com/aoi/ninja",
  data:{name:"George",rank:"Red Belt"}// This is the data being sent.

})


IN NODE JS WHEN WE CARRY OUT A POST REQUEST,AND SEND DATA INTO THE REQUEST BODY,NODE JS AND EXPRESS CAN NOT ACCESS THIS DATA OUT OF THE BOX
THEY HAVE TO USE A MIDDLE WARE CALLED BODY PARSER.


 const express = require("express");
const bodyParser = require("body-parser");


 // Here we import the routs we created
 const router1 =  require("./Routes/api")
 // How do we tell express to use the above created routes
 // For that ther is a .use module in express

 





 //Set up express app
 const app = express()
 
 ************************THIS IS THE BODY PARSER MIDDDLE WARE ***********************

 app.use(bodyParser.json())// This will enable us to receive the Json sent with the body from the request

 
 app.use("/api",router1)
// We can do this or do this  app.use("/api",require("./routes/api"))
// The app,use is the method we use in our app to use any midddle ware
// Midleware is any code that runs betweeen the request and the response








// Here we pass parameters ,i.e the req,and response,
//The request contains all things sent from the client
//The res will contain information about the response e.g status code and the requested data
 app.get("/",function(req,res){
    console.log("You are in the home route")

    res.send({"name":"George Gacau and Eliud wambu"})

    //res.end()// To end this response making the little icon on the website tab on the browere stop spinning meaning that that the broweser is not expecting anything else.
 })


 //listen request

 app.listen(4000,function(){

    console.log("This is litening")

 })



















































