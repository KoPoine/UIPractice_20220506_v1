package com.neppplus.uipractice_20220506_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.neppplus.uipractice_20220506_v1.utils.ContextUtil

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        2. autoLogin이라는 자동 로그인 확인 불린 변수 생성 및 ContextUtil의 오토로그인 값 대입
        val autoLogin = ContextUtil.getAutologin(this)

//        1. 2.5초(2500ms)의 딜레이를 주는 Handler 클래스를 myHandler변수로 대입
        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed({

//            3. 만약에 위에서 받은 값이 true라면 메인 액티비티로, false라면 로그인으로 이동
            val myIntent = if (autoLogin) {
               Intent(this, MainActivity::class.java)
            } else {
                Intent(this, LoginActivity::class.java)
            }
            startActivity(myIntent)
            finish()
        }, 2500)
    }
}