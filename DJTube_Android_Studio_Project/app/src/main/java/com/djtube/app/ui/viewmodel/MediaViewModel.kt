package com.djtube.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djtube.app.data.local.DownloadDao
import com.djtube.app.data.local.DownloadEntity
import com.djtube.app.model.MediaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MediaViewModel(
    private val downloadDao: DownloadDao
) : ViewModel() {

    private val _currentPlaying = MutableStateFlow<MediaItem?>(null)
    val currentPlaying: StateFlow<MediaItem?> = _currentPlaying.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    fun playMedia(media: MediaItem) {
        _currentPlaying.value = media
        _isPlaying.value = true
    }

    fun startImmediateDownload(media: MediaItem, format: String, isAudio: Boolean) {
        viewModelScope.launch {
            val entity = DownloadEntity(
                id = System.currentTimeMillis().toString(),
                mediaId = media.id,
                title = media.title,
                channelName = media.channelName,
                thumbnail = media.thumbnail,
                downloadType = if (isAudio) "audio" else "video",
                format = format,
                totalBytes = 15000000L,
                downloadedBytes = 0L,
                filePath = "/storage/emulated/0/Download/DJTube/${media.title}.${format.lowercase()}",
                status = "downloading"
            )
            downloadDao.insertOrUpdate(entity)
        }
    }
}
