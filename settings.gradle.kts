rootProject.name = "hive-udf-with-hive-runner-demo"

include("hive-runner")
include("udf")

dependencyResolutionManagement {
    versionCatalogs {
        val kotlin = "2.0.21"
        val hiveRunner = "6.1.0"
        val hadoop = "3.1.3"
        create("gradlePlugins") {
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").version(kotlin)
        }
        create("libs") {
            // Hive Tests
            library("hive-runner", "io.github.hiverunner:hiverunner:$hiveRunner")
            // Hive UDF
            library("hadoop-common", "org.apache.hadoop:hadoop-common:$hadoop")
            library("hive-exec", "org.apache.hive:hive-exec:$hadoop")
        }
    }
}
