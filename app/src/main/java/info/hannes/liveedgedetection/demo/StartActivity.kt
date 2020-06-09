package info.hannes.liveedgedetection.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.hannes.logcat.LogcatActivity
import info.hannes.logcat.crashlytic.BothLogActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        buttonScan.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        buttonLog.setOnClickListener { startActivity(Intent(this, BothLogActivity::class.java)) }

    }

}
