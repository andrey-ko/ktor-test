@file:JvmName("App")

package org.andreyko.ktor.test

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(vararg args: String) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/stream") {
                call.respondTextWriter {
                    write("Hello World!")
                }
            }

        }
    }
    server.start(wait = true)
    println("done")
}