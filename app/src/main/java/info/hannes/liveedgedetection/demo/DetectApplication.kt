package info.hannes.liveedgedetection.demo

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings
import com.google.firebase.crashlytics.FirebaseCrashlytics
import info.hannes.crashlytic.CrashlyticsTree
import info.hannes.timber.FileLoggingTree
import timber.log.Timber

class DetectApplication : Application() {
    @SuppressLint("HardwareIds")
    override fun onCreate() {
        super.onCreate()

        externalCacheDir?.let {
            Timber.plant(FileLoggingTree(it, this))
        }

        FirebaseCrashlytics.getInstance().setCustomKey("VERSION_NAME", info.hannes.logcat.BuildConfig.VERSION_NAME)

        if (!BuildConfig.DEBUG)
            Timber.plant(CrashlyticsTree(Settings.Secure.getString(applicationContext.contentResolver, Settings.Secure.ANDROID_ID)))
    }
}