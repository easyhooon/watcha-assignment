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
    libs.androidx.activity.ktx,
    libs.androidx.appcompat,
    libs.androidx.core,
    libs.androidx.constraintlayout,
    libs.androidx.lifecycle.runtime,
    libs.androidx.lifecycle.viewmodel,
    libs.androidx.splash,
    libs.androidx.paging.runtime,
    libs.coil,
    libs.timber,
  )
  testImplementation(libs.junit)
  androidTestImplementations(
    libs.androidx.test.ext.junit,
    libs.androidx.test.espresso.core,
  )
}
