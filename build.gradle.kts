plugins {
    java
    idea
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    id("net.ltgt.apt-idea") version "0.21"
    id("io.freefair.lombok") version "4.1.6"
}

apply(from = "versions.gradle.kts")

group = "com.swabber"
version = "1.0-SNAPSHOT"

project.the<SourceSetContainer>()["main"].java.srcDirs("src/main/java")
project.the<SourceSetContainer>()["main"].resources.srcDir("src/main/resources")
project.the<SourceSetContainer>()["test"].java.srcDir("src/test/java")
project.the<SourceSetContainer>()["test"].resources.srcDir("src/test/resources")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.h2database:h2:${rootProject.extra["h2.version"]}")

    implementation("org.mapstruct:mapstruct:${rootProject.extra["mapstruct.version"]}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${rootProject.extra["mapstruct.version"]}")

    implementation("com.google.guava:guava:${rootProject.extra["guava.version"]}")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "junit", module = "junit")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}

tasks.test {
    useJUnitPlatform()
}