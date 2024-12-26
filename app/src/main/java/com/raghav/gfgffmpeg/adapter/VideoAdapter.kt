package com.raghav.gfgffmpeg.adapter

import android.media.MediaMetadataRetriever
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.raghav.gfgffmpeg.R

class VideoAdapter(
    private val videoPaths: MutableList<String>,
    private val onClickVideo: (String) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivThumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val videoPath = videoPaths[position]
        val videoUri = Uri.parse(videoPaths[position])
        Log.d(javaClass.name, "videoPaths videoUri: $videoUri")

        // Lấy thumbnail từ video
        val retriever = MediaMetadataRetriever()

        try {
            // Lấy FileDescriptor từ URI
            val parcelFileDescriptor = holder.itemView.context.contentResolver.openFileDescriptor(videoUri, "r")
            parcelFileDescriptor?.fileDescriptor?.let { fd ->
                retriever.setDataSource(fd) // Truyền FileDescriptor vào
                val bitmap = retriever.frameAtTime // Lấy frame đầu tiên

                Log.d(javaClass.name, "videoPaths bitmap: $bitmap")
                holder.ivThumbnail.setImageBitmap(bitmap)
                holder.ivThumbnail.setOnClickListener {
                    onClickVideo(videoPaths[position])
                }
            }
            parcelFileDescriptor?.close()
        } catch (e: Exception) {
            e.printStackTrace()
            holder.ivThumbnail.setImageResource(R.drawable.ic_error) // Hiển thị lỗi
        } finally {
            retriever.release()
        }


//        retriever.setDataSource(videoPath)
//        val bitmap = retriever.frameAtTime // Lấy frame đầu tiên
//        holder.ivThumbnail.setImageBitmap(bitmap)
//        retriever.release()
    }

    override fun getItemCount(): Int = videoPaths.size
}