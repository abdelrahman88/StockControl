package com.stockcontrol.remote.test.factory

import java.util.*

object DataFactory {
    fun randomUuid() : String{
        return UUID.randomUUID().toString()
    }
    fun randomFloat() : Float{
        val random = Random()
        return random.nextFloat()
    }

    fun randomInt () : Int{
        val random =  Random()
        return  random.nextInt()
    }
}