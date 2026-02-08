plugins {
    java
    id("java-library")
}

group = "de.paltopia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Diese Datei muss in 'libs/HytaleServer.jar' liegen!
    compileOnly(files("libs/HytaleServer.jar"))

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

sourceSets {
    main {
        resources {
            srcDir("assets")
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    // Aktualisiert auf Java 25 fuer Hytale
    options.release.set(25)
}

tasks.jar {
    manifest {
        attributes["Implementation-Title"] = "Paltopia ME System"
        attributes["Implementation-Version"] = project.version
    }
    from(sourceSets.main.get().output)
    from("mod.json")
}

tasks.test {
    useJUnitPlatform()
}