const incomeSchema = require('../database/schemas/income')

class parkingModel {
    getAll( cb ) {
        incomeSchema.find(cb)
    }

    registryNewParking( data,cb ) {
        let income = new incomeSchema()
        income.placa = data.placa
        income.price = data.price
        income.place = data.place
        income.type = data.type

        income.save(cb)
    }

    updateParking( id,data,cb ) {
        incomeSchema.findByIdAndUpdate(id,data,cb)
    }
}

module.exports = parkingModel