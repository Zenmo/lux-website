pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    kotlin("jvm") version "2.3.10" apply false
}

rootProject.name = "prerender"
