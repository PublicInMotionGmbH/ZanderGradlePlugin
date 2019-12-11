plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("groovy")
    id("maven")

}

group = "com.publicinmotion.gradle"
version = "0.0.1"

//sourceCompatibility = 1.8

repositories {
    google()
    mavenCentral()
    jcenter()
}

(tasks.findByName("test") as Test).useJUnitPlatform()

tasks.named<Upload>("uploadArchives") {
    repositories.withGroovyBuilder {
        "mavenDeployer" {
            "repository"("url" to uri("./repo"))
        }
    }
}

gradlePlugin {
    plugins {
        register("ZanderGradlePlugin") {
            id = "com.publicinmotion.gradle.zander"
            implementationClass = "com.publicinmotion.gradle.ZanderPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())
    testCompileOnly(gradleTestKit())

    implementation("com.squareup.okhttp3:okhttp:4.2.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.1")
    implementation("com.android.tools.build:gradle:3.3.2")
}
