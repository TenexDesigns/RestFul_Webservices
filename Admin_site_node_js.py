Based on the context, you can create an admin site in Node.js and Express using AdminBro (now called AdminJS) blog.
logrocket.com. Heres a code sample to set up a simple admin panel using AdminJS with Express and MongoDB:


nstall the necessary packages:
npm init
npm i adminjs express tslib express-formidable express-session @adminjs/express @adminjs/mongoose mongoose




Create a file named app.js and add the following code to set up the admin panel:
const AdminJS = require('adminjs')
const AdminJSExpress = require('@adminjs/express')
const AdminJSMongoose = require('@adminjs/mongoose')
const express = require('express')
const mongoose = require('mongoose')

// Replace this with your MongoDB connection string
const MONGODB_URI = 'mongodb://localhost:27017/adminjs-example'

// Register the Mongoose adapter
AdminJS.registerAdapter(AdminJSMongoose)

// Connect to MongoDB
mongoose.connect(MONGODB_URI, {
  useNewUrlParser: true,
  useUnifiedTopology: true
})

// Define a sample schema for demonstration
const userSchema = new mongoose.Schema({
  email: { type: String, required: true },
  password: { type: String, required: true },
  role: { type: String, enum: ['admin', 'user'], required: true }
})
const User = mongoose.model('User', userSchema)

// Set up AdminJS
const admin = new AdminJS({
  resources: [
    { resource: User }
  ],
  rootPath: '/admin',
})

// Set up the Express app and AdminJS router
const app = express()
const adminRouter = AdminJSExpress.buildAuthenticatedRouter(admin, {
  authenticate: async (email, password) => {
    const user = await User.findOne({ email })
    if (user && user.password === password && user.role === 'admin') {
      return user
    }
    return false
  },
  cookiePassword: 'some-secret-password-used-to-secure-cookie',
})

app.use(admin.options.rootPath, adminRouter)
app.listen(3000, () => console.log('Listening on port 3000'))




This code sets up a simple admin panel with user authentication. Replace MONGODB_URI with your MongoDB connection string. 
The example uses a simple user schema with an email, password, and role.
The authenticate function checks if the user is an admin before granting access to the admin panel.

Run the application with node app.js, and access the admin panel at http://localhost:3000/admin.













































































































...
