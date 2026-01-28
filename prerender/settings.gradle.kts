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
    kotlin("jvm") version "2.2.21" apply false
}

rootProject.name = "prerender"
