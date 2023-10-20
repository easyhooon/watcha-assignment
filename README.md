# How to build
빌드 전, 프로젝트에 최상위 루트에 'secrets.properties' 파일을 생성하여 다음과 같이 API_BASE_URL 값을 추가해야 합니다.
```
# secrets.properties

API_BASE_URL ="https://itunes.apple.com/"
```

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
- Pagination을 구현하여 트랙들을 리스트에 보여주어야 함

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

- Androidx
  - Activity & Activity Compose
  - AppCompat
  - Core
  - ConstraintLayout
  - Lifecycle & AAC ViewModel Compose
  - Material3
  - StartUp
  - Splash
  - Paging3 & Paging3 Compose

- Kotlinx
  - Coroutines
  - Serialization

- Dagger Hilt
- Retrofit2
- OkHttp3
- Timber
- Coil & Coil Compose

#### Code analysis

- Ktlint
- Detekt

#### Gradle Dependency

- [Gradle Version Catalog](https://docs.gradle.org/current/userguide/platforms.html)

## Architecture
Based on [Google App Architecture](https://developer.android.com/topic/architecture) similar to Clean Architecture

<img width="760" alt="image" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/2837a3b6-32f8-46aa-a102-3fb5b3e3826a">

<img width="760" alt="image" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/b29020a1-69aa-482b-8af4-ddb27122a440">

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
│   │   ├── compose
│   │   └── view
│   └── viewmodel
└── gradle
    └── libs.versions.toml
```

