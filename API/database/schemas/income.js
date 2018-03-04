const mongoose = require('../connection')
const Schema = mongoose.Schema

const IncomeSchema = new Schema({
    price : Number,
    place : { type : String, enum : ['I','A','D','M'] },
    type : { type : String, enum : ['Carro','Moto'] },
    date : { created : { type : Date , default : Date.now() } }
})

const Income = mongoose.model('Income',IncomeSchema)

module.exports = Income