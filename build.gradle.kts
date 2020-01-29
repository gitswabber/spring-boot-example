plugins {
    java
    idea
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    id("net.ltgt.apt") version "0.21"
    id("net.ltgt.apt-idea") version "0.21"
    id("io.freefair.lombok") version "4.1.6"
    id("com.bmuschko.docker-spring-boot-application") version "6.1.3"
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
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
}

val dockerRegistryUrl: String by extra { "com.swabber" }
val dockerImageName: String by extra { "spring-boot-example" }
val dockerImageTag: String by extra { "0.0.2" }

docker {
    springBootApplication {
        baseImage.set("openjdk:8-alpine")
        maintainer.set("doutorking@gmail.com")
        ports.set(listOf(8080))
        images.set(setOf("$dockerRegistryUrl/$dockerImageName:$dockerImageTag"))
//        jvmArgs.set(listOf("-Dspring.profiles.active=dev", "-Xmx1024m"))
    }
}

/*
tasks.dockerBuildImage {
    inputDir.dir("./")
    images.set(setOf("$dockerRegistryUrl/$dockerImageName:$dockerImageTag"))
}*/
