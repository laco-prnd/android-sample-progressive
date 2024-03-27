package com.laco.myapplication

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo
import com.facebook.imagepipeline.request.ImageRequestBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        val adapter = Adapter()
        recyclerView.adapter = adapter

        adapter.submitList(listOf("https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_07.jpeg"))
    }
}

private val imageList2 = listOf(
//    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_01_progressive.jpg",
//    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_02_progressive.jpg",
//    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_03_progressive.jpg",
//    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_04_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_05_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_06_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_07_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_08_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_09_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_10_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_11_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_12_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_13_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_14_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_15_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_16_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_17_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_18_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_19_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_20_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_21_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_22_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_23_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_24_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_25_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_26_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_27_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_28_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_29_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_30_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_31_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_32_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_33_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_34_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_35_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_36_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_37_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_38_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_39_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_40_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_41_progressive.jpg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_42_progressive.jpg",
)

private val imageList = listOf(
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_01.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_02.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_03.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_04.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_05.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_06.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_07.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_08.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_09.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_10.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_11.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_12.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_13.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_14.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_15.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_16.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_17.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_18.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_19.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_20.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_21.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_22.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_23.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_24.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_25.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_26.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_27.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_28.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_29.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_30.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_31.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_32.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_33.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_34.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_35.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_36.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_37.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_38.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_39.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_40.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_41.jpeg",
    "https://raw.githubusercontent.com/laco-prnd/android-sample-progressive/main/src/sample_42.jpeg",
)


class Adapter : ListAdapter<String, ViewHolder>(diffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        fun diffCallback(): DiffUtil.ItemCallback<String> =
            object : DiffUtil.ItemCallback<String>() {
                override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                    return oldItem == newItem
                }
            }
    }
}


class ViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
) {
    private val imageView: SimpleDraweeView = itemView.findViewById(R.id.image_view)
    private val dateFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

    fun bind(item: String) {
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER

        val uri = item.toUri()
        val imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
            .setProgressiveRenderingEnabled(true)
            .disableMemoryCache()
            .disableMemoryCache()
            .build()

        val controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(imageRequest)
            .setOldController(imageView.controller)
            .setControllerListener(
                object : BaseControllerListener<ImageInfo>() {
                    override fun onFinalImageSet(
                        id: String?,
                        imageInfo: ImageInfo?,
                        animatable: Animatable?,
                    ) {
                        if (imageInfo != null) {
                            updateSize(imageInfo)
                            logScan(item, imageInfo, true)
                        }
                    }

                    override fun onIntermediateImageSet(id: String?, imageInfo: ImageInfo?) {
                        if (imageInfo != null) {
                            updateSize(imageInfo)
                            logScan(item, imageInfo, false)
                        }
                    }

                    override fun onIntermediateImageFailed(id: String?, throwable: Throwable?) {
                        Log.w("JPEG", "onIntermediateImageFailed: ${throwable?.message}")
                    }
                }
            )
            .build()

        imageView.controller = controller
    }

    private fun updateSize(imageInfo: ImageInfo) {
        imageView.aspectRatio = (imageInfo.width.toFloat() / imageInfo.height.toFloat())
    }

    private fun logScan(
        url: String,
        imageInfo: ImageInfo,
        isFinalImage: Boolean,
    ) {
        val qualityInfo = imageInfo.qualityInfo
        val output = StringBuilder()
        output.append("url: ${url}, ")
        output.append(
            String.format(
                Locale.getDefault(),
                "bytes: %s, %s: %s, goodEnough=%b, fullQuality=%b, quality=%d\n\n",
                imageInfo.sizeInBytes,
                dateFormat.format(Date(System.currentTimeMillis())),
                if (isFinalImage) "final" else "intermediate",
                qualityInfo.isOfGoodEnoughQuality,
                qualityInfo.isOfFullQuality,
                qualityInfo.quality,
            )
        )
        Log.w("JPEG", "logScan: $$output")
    }
}
