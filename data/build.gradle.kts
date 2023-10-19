plugins {
  watcha("android-library")
  watcha("android-hilt")
  alias(libs.plugins.google.secrets)
  alias(libs.plugins.kotlinx.serialization)
}

android {
  namespace = "com.leejihun.watcha.assignment.data"

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  implementations(
    projects.domain,
    libs.kotlinx.serialization.json,
    libs.androidx.paging.runtime,
    libs.timber,
    libs.bundles.retrofit,
    libs.bundles.okhttp,
  )
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = freeCompilerArgs + listOf("-opt-in=kotlin.ExperimentalStdlibApi")
  }
}

secrets {
  defaultPropertiesFileName = "secrets.properties"
}
