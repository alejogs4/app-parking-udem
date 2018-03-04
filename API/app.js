const express = require('express')
const app = express()
const bodyParser = require('body-parser')

//Routes
const parking = require('./routes/parking_routes')


const cross = (req, res, next) => {
    res.header('Access-Control-Allow-Origin', "*");
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}

app.use(cross)
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended : false }))
app.use(parking)

module.exports = app