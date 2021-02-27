package example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
	embeddedServer(Netty, 8080, module = Application::routes, watchPaths = listOf("ktor"))
		.start(wait = true)
}

fun Application.routes() {
	routing {
		get("/") {
			call.respondText("Hello Foo!")
		}
	}
}
