package com.laco.myapplication

import android.app.Application
import com.facebook.common.logging.FLog
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestLoggingListener

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        FLog.setMinimumLoggingLevel(FLog.VERBOSE)
        val imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
            .setDiskCacheEnabled(false)
            .setRequestListeners(setOf(RequestLoggingListener()))
            .build()
        Fresco.initialize(this, imagePipelineConfig)

    }
}
