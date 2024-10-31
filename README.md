# hive-udf-with-hive-runner-demo

## Requirements

- jdk: 1.8

```sh
# Install jdk-8
sudo apt install openjdk-8-jdk

# Set JAVA_HOME in gradle.properties
org.gradle.java.home=/usr/lib/jvm/java-8-openjdk-amd64
```

## Tests

```sh
# -i: verbose
./gradlew clean hive-runner:test -i
```

## Build UDF jar

```sh
./gradlew clean udf:jar
```
