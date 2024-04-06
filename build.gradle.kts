plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        testImplementation("org.seleniumhq.selenium:selenium-java:4.17.0")
        testImplementation("org.aspectj:aspectjweaver:1.9.21")
        testImplementation("io.qameta.allure:allure-junit5:2.24.0")
        testImplementation("com.opencsv:opencsv:5.9")
        testImplementation("org.seleniumhq.selenium:selenium-grid:4.16.1")
        testImplementation("io.qameta.allure:allure-java-commons:2.24.0")
        testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
        testImplementation("org.slf4j:slf4j-simple:2.0.7")
    }
}

tasks.test {
    useJUnitPlatform()
    systemProperty("useRemote", System.getProperty("useRemote", "false"))
}