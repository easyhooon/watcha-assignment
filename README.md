# 왓챠 Android 개발자 과제

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/gradle-8.0-green.svg)](https://gradle.org/)
[![Android Studio](https://img.shields.io/badge/Android%20Studio-2022.3.1%20%28Giraff%29-green)](https://developer.android.com/studio)
[![minSdkVersion](https://img.shields.io/badge/minSdkVersion-23-red)](https://developer.android.com/distribute/best-practices/develop/target-sdk)
[![targetSdkVersion](https://img.shields.io/badge/targetSdkVersion-34-orange)](https://developer.android.com/distribute/best-practices/develop/target-sdk)
<br/>

![image](https://github.com/easyhooon/watcha-assignment/assets/51016231/970379ba-cf65-4786-9e6b-fa9dab20e24c)

## 요구사항
- iTunes search API 를 호출하여, 결과 track 들을 리스트로 나열
- pagination을 구현하여 트랙들을 리스트에 보여주어야 함

## Features

|트랙 리스트 조회|네트워크 에러 처리|
|:-----:|:-----:|
|<img width="320" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/674c342c-aa4f-437b-a9c5-28fbd7b1c809.gif">|<img width="320" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/201cbdd4-dd96-443b-b18a-731fcf9ae378.gif">|

|트랙 리스트 갱신|트랙 상세 화면|
|:-----:|:-----:|
|<img width="320" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/1869ee54-6b3d-4854-bfbb-205e992cfee7.gif">|<img width="320" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/ec4f7880-6821-46d8-bed5-7340267b53e4.gif">|

## Development

### Environment

- IDE : Android Studio Giraffe
- JDK : Java 17을 실행할 수 있는 JDK
- Kotlin Language : 1.9

### Language

- Kotlin

### Libraries

- AndroidX
  - Activity
  - Core
  - Constraintlayout
  - Lifecycle & AAC ViewModel
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
│   └── application
├── build-logic
├── buildSrc
├── data
│   ├── datasource
│   ├── di
│   ├── mapper
│   ├── model
│   ├── paging
│   ├── repository
│   ├── paging
│   └── servce
├── domain
│   ├── entity
│   ├── repository
│   └── usecase
├── presentation
│   ├── ui
│   └── viewmodel
└── gradle
    └── libs.versions.toml
```

