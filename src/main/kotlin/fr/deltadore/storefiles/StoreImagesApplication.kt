package fr.deltadore.storefiles

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StoreImagesApplication

fun main(args: Array<String>) {
    runApplication<StoreImagesApplication>(*args)
}
