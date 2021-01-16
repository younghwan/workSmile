package com.smilegate.worksmile.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.smilegate.worksmile.adapter.ChatRoomAdapter
import com.smilegate.worksmile.model.ChatRoomData
import com.smilegate.worksmile.R
import com.smilegate.worksmile.activity.ChatActivity
import com.smilegate.worksmile.adapter.ChatRoomClickListener
import kotlinx.android.synthetic.main.fragment_message.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessageFragment : Fragment() {

    private val mAdapter: ChatRoomAdapter by lazy {
        ChatRoomAdapter(object : ChatRoomClickListener {
            override fun onRoomClick(room: ChatRoomData) {
                Toast.makeText(context, "room", Toast.LENGTH_SHORT).show()
                val chatIntent = Intent(context, ChatActivity::class.java)
                startActivity(chatIntent)
            }

            override fun onFavoriteClick(position: Int, room: ChatRoomData) {
                room.isFavorite = !room.isFavorite
                Toast.makeText(context, room.isFavorite.toString(), Toast.LENGTH_SHORT).show()
                mAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_favorite_msg.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

        val dataList = arrayListOf<ChatRoomData>(
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", true),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", true),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", true),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", true),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", true),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지", "1", false),
            ChatRoomData("thumbnail", "채팅방 이름", "마지막 메시지?", "1", false)
        )

        mAdapter.setItems(dataList)

//        tv_favorite_msg.setOnClickListener {
//            if (rv_favorite_msg.visibility == View.GONE) {
//                rv_favorite_msg.visibility = View.VISIBLE
//            } else {
//                rv_favorite_msg.visibility = View.GONE
//            }
//
//        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MessageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MessageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}