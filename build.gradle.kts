import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion = "1.4.3"

plugins {
	application
	kotlin("jvm") version "1.4.30"
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.useIR = true

group = "me.max"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
	implementation("io.ktor:ktor-server-core:$ktorVersion")
	implementation("io.ktor:ktor-server-netty:$ktorVersion")

	testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
	mainClass.set("example.ApplicationKt")
	applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}
