## Zander Gradle Plugin

## Usage

Plugin will generate tasks for all flavor / build type combination:

`./gradlew app:zanderDistribute{flavor}{buildVariant}`


### Installation
In project `build.gradle`:
```groovy
buildscript {
  repositories {
    maven { url "https://jitpack.io" }
  }
  
  dependencies {
    classpath "com.github.PublicInMotionGmbH:ZanderGradlePlugin:-SNAPSHOT"
  }
}
```

In `app/build.gradle`:
```groovy
apply plugin: "com.publicinmotion.gradle.zander"
```

### Configuration
In `app/build.gradle`

```groovy
zander {
  url "https://zander.domain.com"
  oAuthCredentials "encoded_credentials"
  version "1.2.3"
  buildNumber "100200300"
  releaseNotes "[MA-2136] Bugfix"
}
```
