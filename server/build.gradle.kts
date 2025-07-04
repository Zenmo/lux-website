plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
//    id("com.gradleup.shadow") version "8.3.8"
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
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-security-oauth")
    implementation("org.http4k:http4k-format-kotlinx-serialization")
    implementation("org.http4k:http4k-multipart")

    // Implements Jakarta Email specification
    implementation("org.eclipse.angus:angus-mail:2.0.3")
}

application {
    mainClass = "com.zenmo.server.MainKt"
}

kotlin {
    sourceSets {
        all {
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }
    jvmToolchain(21)
}

tasks.register<Copy>("copyJsResources") {
    dependsOn(":site:npmRollup")

    from(project(":site").layout.buildDirectory.dir("rollup"))
    into(project.layout.projectDirectory.dir("src/main/resources"))
}

tasks.named("processResources") {
    dependsOn("copyJsResources")
}
