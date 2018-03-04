const mongoose = require('mongoose')
const dbConf = require('./db_conf') 

mongoose.connect(`mongodb:\/\/${dbConf.mongo.host}/${dbConf.mongo.db}`)

module.exports = mongoose