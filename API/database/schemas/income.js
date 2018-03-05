const mongoose = require('../connection')
const Schema = mongoose.Schema

const IncomeSchema = new Schema({
    placa : String,
    price : Number,
    place : { type : String, enum : ['I','A','D','M'] },
    type : { type : String, enum : ['Carro','Moto'] },
    date : { created : { type : Date , default : Date.now() } },
    active : { type : Boolean, default : true } 

})

const Income = mongoose.model('Income',IncomeSchema)

module.exports = Income