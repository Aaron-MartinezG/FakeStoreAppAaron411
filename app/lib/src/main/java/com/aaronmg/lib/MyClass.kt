package com.aaronmg.lib

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("=== CORRUTINAS ===")

    // 1. RunBlocking, es una corrutina que BLOQUEA EL HILO PRINCIPAL
    // NO SE DEBE DE USAR EN PRODUCCIÓN!!!
    //corrutinaLaunch()
    corrutinaAsync()
}

fun corrutinaAsync(){
    runBlocking {
        println("Haciendo peticion /GET")
        val result = async {
            println("Haciendo consulta a la API")
            delay(6000)
            println("Retornando resultado")
            """ { "id":1,"name":"Aaron" } """
        }
        println("El resultado de la peticion es ${result.await()}")
    }
}
fun corrutinaLaunch(){
    runBlocking {
        println("Cargando interfaz grafica")
        launch(Dispatchers.IO) {
            consultaAPI()
        }
        println("La UI sigue cargando mientras termina la corrutina")
    }
}

suspend fun consultaAPI(){
    println("Consultando la API")
    delay(6000)
    println("La respuesta es que todo salio bien")
}