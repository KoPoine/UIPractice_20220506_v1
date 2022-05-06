package com.neppplus.uipractice_20220506_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.uipractice_20220506_v1.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        1. 로그아웃 버튼 클릭시 로그인 페이지로 이동
        logoutBtn.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
//            2.메인 액티비티 로그아웃 시 ContextUtil에 있는 모든 정보 삭제
            ContextUtil.clear(this)
            finish()
        }
    }
}