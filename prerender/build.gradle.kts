plugins {
    `kotlin-dsl`
    kotlin("jvm")
    id("java-gradle-plugin")
    id("maven-publish")
}

group = "energy.lux.prerender"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // programmatic web browser with javascript support
    implementation("com.microsoft.playwright:playwright:1.50.0")
    // html parser
    implementation("org.jsoup:jsoup:1.16.2")

    implementation(platform("org.http4k:http4k-bom:6.15.1.0"))
    // URI manipulation
    implementation("org.http4k:http4k-core")

    testImplementation("org.http4k:http4k-server-undertow")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("LuxPrerenderPlugin") {
            id = "energy.lux.prerender"
            implementationClass = "energy.lux.prerender.PreRenderPlugin"
        }
    }
}

publishing {
    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("maven-repo"))
        }
    }
}
