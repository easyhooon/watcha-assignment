@file:Suppress("UnstableApiUsage", "INLINE_FROM_HIGHER_PLATFORM")

plugins {
  watcha("android-application")
  watcha("android-hilt")
}

android {
  namespace = "com.leejihun.watcha.assignment"

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  coreLibraryDesugaring(libs.desugar.jdk)
  implementations(
    projects.data,
    projects.domain,
    projects.presentation,
    libs.androidx.core,
    libs.androidx.constraintlayout,
    libs.androidx.startup,
    libs.timber,
  )
}
