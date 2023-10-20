# 왓챠 Android 개발자 과제

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/gradle-8.0-green.svg)](https://gradle.org/)
[![Android Studio](https://img.shields.io/badge/Android%20Studio-2022.3.1%20%28Giraff%29-green)](https://developer.android.com/studio)
[![minSdkVersion](https://img.shields.io/badge/minSdkVersion-23-red)](https://developer.android.com/distribute/best-practices/develop/target-sdk)
[![targetSdkVersion](https://img.shields.io/badge/targetSdkVersion-34-orange)](https://developer.android.com/distribute/best-practices/develop/target-sdk)
<br/>

![image](https://github.com/easyhooon/watcha-assignment/assets/51016231/970379ba-cf65-4786-9e6b-fa9dab20e24c)

## Features

## Development

### Required

- IDE : Android Studio Giraffe
- JDK : Java 17을 실행할 수 있는 JDK
- Kotlin Language : 1.9

### Language

- Kotlin

### Libraries

- AndroidX
  - Activity
  - Core
  - Lifecycle & ViewModel
  - Material3
  - StartUp
  - Splash
  - Paging3

- Kotlin Libraries (Coroutine, Serialization)

- Dagger Hilt
- Retrofit2
- OkHttp3
- Timber
- Coil

#### Code analysis

- Ktlint
- Detekt

#### Gradle Dependency

- Gradle Version Catalog

## Architecture
[Google App Architecture](https://developer.android.com/topic/architecture)

## Package Structure
```
├── app
│   └── Application
├── build-logic
├── buildSrc
├── data
├── domain
├── presentation
└── gradle
    └── libs.versions.toml
```

