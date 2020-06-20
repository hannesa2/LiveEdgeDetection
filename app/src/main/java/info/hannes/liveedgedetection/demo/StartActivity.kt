package info.hannes.liveedgedetection.demo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import info.hannes.logcat.crashlytic.BothLogActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        buttonScan.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        buttonLog.setOnClickListener { startActivity(Intent(this, BothLogActivity::class.java)) }
        buttonCrash.setOnClickListener {
            Toast.makeText(this, "force crash ${info.hannes.logcat.BuildConfig.VERSION_NAME}", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ throw RuntimeException("Test Crash ${info.hannes.logcat.BuildConfig.VERSION_NAME}") }, 3000)
        }

        textAppVersion.text = "App version   : ${BuildConfig.VERSION_NAME}"
        textOpenCVVersion.text = "OpenCV version: ${org.opencv.BuildConfig.VERSION_NAME}"
    }

}
