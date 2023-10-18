@file:Suppress("UnstableApiUsage", "INLINE_FROM_HIGHER_PLATFORM")

plugins {
  watcha("android-library")
  watcha("android-hilt")
}

android {
  namespace = "com.leejihun.watcha.assignment.presentation"

  buildFeatures {
    buildConfig = true
    viewBinding = true
  }
}

dependencies {
  implementations(
    projects.domain,
    libs.android.material,
    libs.androidx.core,
    libs.androidx.appcompat,
    libs.androidx.constraintlayout,
  )
  testImplementation(libs.junit)
  androidTestImplementations(
    libs.androidx.test.ext.junit,
    libs.androidx.test.espresso.core,
  )
}
