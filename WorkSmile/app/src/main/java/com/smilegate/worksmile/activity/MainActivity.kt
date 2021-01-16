package com.smilegate.worksmile.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.smilegate.worksmile.*
import com.smilegate.worksmile.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        bottom_nav_main.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_message -> {
                    setFragment(MessageFragment(), "메세지")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_channel -> {
                    setFragment(ChannelFragment(), "채널")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_organization -> {
                    setFragment(OrganizationFragment(), "조직도")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_calender -> {
                    setFragment(CalenderFragment(), "일정")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_setting -> {
                    setFragment(SettingFragment(), "설정")
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
        setFragment(MessageFragment(), "메세지")
    }


    private fun setFragment(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main, fragment).commit()
        tv_name_toolbar.text = name

    }
}