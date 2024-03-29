import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.9"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
    id("org.jlleitschuh.gradle.ktlint-idea") version "10.2.1"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "study"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.reactivestreams:reactive-streams:1.0.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.h2database:h2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.4")
    implementation("io.ktor:ktor-client-cio:2.2.4")
    implementation("io.ktor:ktor-client-logging:2.2.4")
    implementation("io.ktor:ktor-client-jackson:2.2.4")
    implementation("io.ktor:ktor-client-mock:2.2.4")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:2.14.2")
    implementation("joda-time:joda-time:2.12.5")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
