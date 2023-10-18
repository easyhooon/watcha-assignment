plugins {
  watcha("android-library")
  watcha("android-hilt")
}

android {
  namespace = "com.leejihun.watcha.assignment.data"

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  implementation(projects.domain,)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = freeCompilerArgs + listOf("-opt-in=kotlin.ExperimentalStdlibApi")
  }
}
