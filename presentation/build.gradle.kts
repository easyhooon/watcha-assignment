@file:Suppress("UnstableApiUsage", "INLINE_FROM_HIGHER_PLATFORM")

plugins {
  watcha("android-library")
  watcha("android-compose")
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
    libs.androidx.splash,
    libs.androidx.paging.runtime,
    libs.timber,
    libs.bundles.androidx.compose,
    libs.bundles.androidx.lifecycle,
    libs.bundles.coil,
  )
}
