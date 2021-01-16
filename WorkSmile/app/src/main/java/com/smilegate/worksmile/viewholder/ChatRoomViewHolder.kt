package com.smilegate.worksmile.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smilegate.worksmile.R
import com.smilegate.worksmile.adapter.ChatRoomClickListener
import com.smilegate.worksmile.model.ChatRoomData

class ChatRoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val mThumbnail: ImageView = view.findViewById(R.id.iv_thumbnail_chatRoom)
    val mFavorite: ImageView = view.findViewById(R.id.iv_favorite_chatRoom)
    val mRoomName: TextView = view.findViewById(R.id.tv_roomName_chatRoom)
    val mLastMsg: TextView = view.findViewById(R.id.tv_lastMsg_chatRoom)
    val mUnreadMsgCnt: TextView = view.findViewById(R.id.tv_unreadMsgCnt_chatRoom)

    fun bind(chatRoom: ChatRoomData, itemClickListener: ChatRoomClickListener?) {
        if (chatRoom.isFavorite) {
            mFavorite.setImageResource(R.drawable.ic_full_star_24)
        }
        mFavorite.run {
            setImageResource(
                if (chatRoom.isFavorite) R.drawable.ic_full_star_24
                else R.drawable.ic_outline_star_24
            )

            setOnClickListener {
                itemClickListener?.onFavoriteClick(adapterPosition, chatRoom)

            }
        }

        mRoomName.text = chatRoom.roomName
        mLastMsg.text = chatRoom.lastMsg
        mUnreadMsgCnt.text = chatRoom.unreadMsgCnt

        itemClickListener?.run {
            itemView.setOnClickListener {
                onRoomClick(chatRoom)
            }
        } ?: itemView.setOnClickListener(null)
    }
}