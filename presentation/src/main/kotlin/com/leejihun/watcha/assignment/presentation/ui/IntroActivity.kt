package com.leejihun.watcha.assignment.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.leejihun.watcha.assignment.presentation.databinding.ActivityIntroBinding
import com.leejihun.watcha.assignment.presentation.extensions.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : AppCompatActivity() {

  private val SPLASH_DISPLAY_LENGTH = 500L

  private val binding by lazy { ActivityIntroBinding.inflate(layoutInflater) }
  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    Handler(Looper.getMainLooper()).postDelayed(
      { startActivityWithAnimation<MainActivity>() },
      SPLASH_DISPLAY_LENGTH,
    )
  }
}
