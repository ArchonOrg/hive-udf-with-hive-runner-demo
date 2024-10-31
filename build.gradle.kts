import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(gradlePlugins.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

allprojects {
    group = "cn.archongum.hive"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenLocal()
        maven(url = "https://maven.aliyun.com/nexus/content/groups/public")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://maven.aliyun.com/repository/central")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://repo.huaweicloud.com/repository/maven/huaweicloudsdk")
    }
}
