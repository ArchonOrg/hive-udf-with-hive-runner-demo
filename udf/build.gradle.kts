
plugins {
    alias(gradlePlugins.plugins.kotlin.jvm)
}

dependencies {
    compileOnly(libs.hive.exec)
    compileOnly(libs.hadoop.common)
}

val thisMainClass = "cn.archongum.hive.udf.MyUpperUDFKt"

task("runMain", JavaExec::class) {
    group = "application"
    mainClass.set(thisMainClass)
    classpath = sourceSets["main"].compileClasspath + sourceSets["main"].runtimeClasspath
}
