package com.smilegate.worksmile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smilegate.worksmile.R
import com.smilegate.worksmile.model.ChatRoomData
import com.smilegate.worksmile.viewholder.ChatRoomViewHolder

class ChatRoomAdapter(
    private val itemClickListener: ChatRoomClickListener?
) :
    RecyclerView.Adapter<ChatRoomViewHolder>() {

    private var mChatRoomDataList = mutableListOf<ChatRoomData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
        return ChatRoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
        holder.bind(mChatRoomDataList[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return mChatRoomDataList.size
    }

    fun setItem(position: Int, item: ChatRoomData) {
        synchronized(mChatRoomDataList) {
            mChatRoomDataList.set(position, item)
        }

        notifyDataSetChanged()
    }

    fun setItems(items: List<ChatRoomData>) {
        synchronized(mChatRoomDataList) {
            mChatRoomDataList.run {
                clear()
                addAll(items)
            }
            notifyDataSetChanged()
        }
    }

}