 const express = require("express");


 // Here we import the routs we created
 const router1 =  require("./Routes/api")
 // How do we tell express to use the above created routes
 // For that ther is a .use module in express

 





 //Set up express app
 const app = express()

 app.use("/api",router1) // This router is down blow
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























This is the router
_________________________________________________________________________________________________







const express = require("express")

const router = express.Router()
// This gets a ninja from the database
router.get('/ninjas',function(req,res){

    res.send({type:'GET'})

})
// This updates a ninja in the database
router.put('/ninjas/:id',function(req,res){

    res.send({type:'PUT'})

})

// This creates a ninja in the database
router.post('/ninjas',function(req,res){

    res.send({type:'POST'})

})
// This deletes an nija of the id in the parameters in the dtatabase
router.delete('/ninjas/:id',function(req,res){

    res.send({type:'DELETE'})

})

// We export the above created routes
module.exports = router








































