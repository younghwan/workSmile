package com.smilegate.worksmile.model

class ChatRoomData(
    val thumbnail: String,
    val roomName: String,
    val lastMsg: String,
    val unreadMsgCnt: String,
    var isFavorite: Boolean
)