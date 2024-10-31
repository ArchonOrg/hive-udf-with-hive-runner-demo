
plugins {
    alias(gradlePlugins.plugins.kotlin.jvm)
}

dependencies {
    testImplementation(project(":udf"))
    testImplementation(libs.hive.runner)
}

tasks.test {
    useJUnitPlatform()
    filter {
        includeTestsMatching("*UDFTest")
    }
}
