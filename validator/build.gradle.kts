import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.20"

    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"

    id("org.openapi.generator") version "6.5.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"

    kotlin("plugin.spring") version "1.8.20"
    kotlin("plugin.jpa") version "1.8.20"
}

group = "akirolabs.tokenvalidator"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("io.swagger:swagger-annotations:1.6.8")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    runtimeOnly("com.h2database:h2:2.1.214")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

ktlint {
    filter {
        exclude { entry ->
            entry.file.toString().contains("generated")
        }
    }
}

springBoot {
    mainClass.set("akirolabs.tokenvalidator.TokenValidatorApplicationKt")
}

sourceSets {
    val main by getting
    main.java.srcDirs("src/main/kotlin", "$buildDir/generated/src/main/kotlin")
}
tasks.getByName("sourcesJar") {
    dependsOn(tasks.named("openApiGenerate"))
}

tasks.getByName("openApiGenerate") {
    setProperty("generatorName", "kotlin-spring")
    setProperty("templateDir", "${project.rootDir}/swagger/template/")
    setProperty("inputSpec", "${project.rootDir}/swagger/swagger.yaml")
    setProperty("templateDir", "${project.rootDir}/swagger/template/")
    setProperty("configFile", "${project.rootDir}/swagger/template/config.yaml")
    setProperty("outputDir", "$buildDir/generated")
    setProperty("apiPackage", "akirolabs.tokenvalidator.generated.api")
    setProperty("modelPackage", "akirolabs.tokenvalidator.generated.model")
    setProperty("skipValidateSpec", true)
    setProperty(
        "configOptions",
        mapOf(
            Pair("tile", "Token Manager API"),
            Pair("dateLibrary", "java8"),
            Pair("useBeanValidation", "true"),
            Pair("hideGenerationTimestamp", "false"),
            Pair("swaggerAnnotations", "true"),
            Pair("useTags", "true"),
            Pair("delegatePattern", "false"),
            Pair("interfaceOnly", "false"),
            Pair("serviceInterface", "true"),
            Pair("serviceImplementation", "false"),
            Pair("reactive", "false"),
            Pair("useJakartaEe", "true"),
            Pair("useSpringBoot3", "true"),
            Pair("enumPropertyNaming", "UPPERCASE")
        )
    )
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

tasks.compileKotlin {
    dependsOn(tasks.named("openApiGenerate"))
}

tasks.compileKotlin {
    dependsOn(tasks.named("openApiGenerate"))
}
tasks.getByName("runKtlintCheckOverMainSourceSet") {
    dependsOn(tasks.named("openApiGenerate"))
}
