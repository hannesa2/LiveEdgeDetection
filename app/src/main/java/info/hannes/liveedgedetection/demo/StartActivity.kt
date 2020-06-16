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
            Toast.makeText(this, "force crash V2-beta1", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ throw RuntimeException("Test Crash V2-beta1") }, 3000)
        }

        textAppVersion.text = "App version   : ${BuildConfig.VERSION_NAME}"
        textAppVersion.text = "OpenCV version: ${info.hannes.logcat.BuildConfig.VERSION_NAME}"

    }

}
