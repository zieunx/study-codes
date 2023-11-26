
val ktor_version: String by project

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    // infrastructure: http client
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    // infrastructure: event
    implementation("org.springframework.boot:spring-boot-starter-amqp")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
