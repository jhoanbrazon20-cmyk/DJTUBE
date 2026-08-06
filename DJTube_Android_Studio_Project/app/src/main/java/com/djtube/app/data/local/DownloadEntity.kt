package com.djtube.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "downloads")
data class DownloadEntity(
    @PrimaryKey val id: String,
    val mediaId: String,
    val title: String,
    val channelName: String,
    val thumbnail: String,
    val downloadType: String, // "audio" or "video"
    val format: String, // "FLAC", "MP3", "1080p", etc.
    val totalBytes: Long,
    val downloadedBytes: Long,
    val filePath: String,
    val status: String, // "downloading", "completed", "paused"
    val createdAt: Long = System.currentTimeMillis()
)
