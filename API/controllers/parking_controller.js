const parkingModel = require('../models/parking_model')
const parking = new parkingModel()
const h = require('../helpers')

class parkingController {
    getAll( req,res,next ) {
        parking.getAll( ( err,incomes ) => {
            if(err) return res.status(500).send({ message : 'Error al conseguir las entradas' })
            if(incomes.length === 0) return res.status(h.NOT_FOUND).send({
                 message : 'No hay ninguna entrada'
            })

            return res.status(h.OK).send({
                message : 'Entradas conseguidas exitosamente',
                data : incomes
             })
        })
    }

    registryNewParking( req,res,next ) {
        const parkingData = {
            placa : req.body.placa,
            price : req.body.price,
            place : req.body.place,
            type : req.body.type,
        }
        
        parking.registryNewParking( parkingData,(err,income) => {
            if(err) return res.status(h.SERVER_ERROR).send({ message : 'Error al registrar la entrada al parqueadero' })

            return res.status(h.CREATED).send({
                message : 'Entrada resgitrada satisfactoriamente',
                data : income
            })
        } )
    }

    updateParking( req,res,next ) {
        const id = req.params.id
        parking.updateParking(id,{ active : false },(err,income) => {
            if(err) return res.status(h.SERVER_ERROR).send({ message : 'Error al actualizar el registro' })
            if(!income) return res.status(h.NOT_FOUND).send({ message : 'No se encontro el archivo' })

            return res.status(h.OK).send({
                message : 'Registro actualizado exitosamente',
                income
            })
        })
    }
}

module.exports = parkingController