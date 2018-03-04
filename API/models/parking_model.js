const incomeSchema = require('../database/schemas/income')

class parkingModel {
    getAll( cb ) {
        incomeSchema.find(cb)
    }

    registryNewParking( data,cb ) {
        console.log(data)
        let income = new incomeSchema()
        income.price = data.price
        income.place = data.place
        income.type = data.type

        income.save(cb)
    }
}

module.exports = parkingModel