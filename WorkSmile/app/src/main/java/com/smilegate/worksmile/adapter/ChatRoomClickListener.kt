package com.smilegate.worksmile.adapter

import com.smilegate.worksmile.model.ChatRoomData

interface ChatRoomClickListener {
    fun onRoomClick(room: ChatRoomData)
    fun onFavoriteClick(position: Int, room: ChatRoomData)
}