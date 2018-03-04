const parkingModel = require('../models/parking_model')
const parking = new parkingModel()
const helpers = require('../helpers')

class parkingController {
    getAll( req,res,next ) {
        parking.getAll( ( err,incomes ) => {
            if(err) return res.status(500).send({ message : 'Error al conseguir las entradas' })
            if(incomes.length === 0) return res.status(helpers.NOT_FOUND).send({
                 message : 'No hay ninguna entrada'
            })

            return res.status(helpers.OK).send({
                message : 'Entradas conseguidas exitosamente',
                data : incomes
             })
        })
    }

    registryNewParking( req,res,next ) {
        console.log(req.body)
        const parkingData = {
            price : req.body.price,
            place : req.body.place,
            type : req.body.type,
        }
        
        parking.registryNewParking( parkingData,(err,income) => {
            if(err) return res.status(helpers.SERVER_ERROR).send({ message : 'Error al registrar la entrada al parqueadero' })

            return res.status(helpers.CREATED).send({
                message : 'Entrada resgitrada satisfactoriamente',
                data : income
            })
        } )
    }
}

module.exports = parkingController