plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
}

dependencies {
    implementation(project(":shared"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${libs.versions.kotlinx.serialization.get()}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${libs.versions.kotlinx.serialization.get()}")

    // to decode and validate Keycloak access tokens with user info.
    implementation("com.nimbusds:nimbus-jose-jwt:9.39.2")

    implementation("org.graalvm.polyglot:js:24.2.1")
    implementation("org.graalvm.polyglot:polyglot:24.2.1")

    implementation(platform("org.http4k:http4k-bom:6.12.0.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-undertow")
    implementation("org.http4k:http4k-security-oauth")
    implementation("org.http4k:http4k-format-kotlinx-serialization")
    implementation("org.http4k:http4k-multipart")

    // Implements Jakarta Email specification
    implementation("org.eclipse.angus:angus-mail:2.0.3")
    implementation("org.http4k:http4k-format-jackson:4.41.0.0")


    testImplementation(kotlin("test"))
}

application {
    mainClass = "com.zenmo.backend.MainKt"
}

kotlin {
    sourceSets {
        all {
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Copy>("copyJsResources") {
    dependsOn(":site:npmRollup")

    from(project(":site").layout.buildDirectory.dir("rollup"))
    into(project.layout.projectDirectory.dir("src/main/resources"))
}

tasks.named("processResources") {
    dependsOn("copyJsResources")
}

tasks.withType<AbstractArchiveTask>().configureEach {
    // We use these timestamps to set the Last-Modified header
    isPreserveFileTimestamps = true
}
