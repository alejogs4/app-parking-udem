const express = require('express')
const parking = express.Router()

//Controllers
const parkingController = require('../controllers/parking_controller')
const pc = new parkingController()

parking.get( '/api/v1/incomes',pc.getAll )
parking.post( '/api/v1/incomes/registry',pc.registryNewParking )

module.exports = parking