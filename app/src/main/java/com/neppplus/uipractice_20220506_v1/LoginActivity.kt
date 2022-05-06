package com.neppplus.uipractice_20220506_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

//    1. 액티비티 전역에서 쓸 수 있도록 id / pw 변수 생성
    var inputId = ""
    var inputPw = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        2. id, pw값 입력시 입력되는 대로 inputId에 대입하기
        inputIdEdt.addTextChangedListener {
            inputId = it.toString()
        }

        inputPwEdt.addTextChangedListener {
            inputPw = it.toString()
        }

        loginBtn.setOnClickListener {
//            3. id, pw 값이 빈값("") or 공백(" ")이 아닌지 확인후 로그인 기능 진행
            if (inputId.isNotBlank() && inputPw.isNotBlank()) {
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
                finish()
//            4. id, pw가 공백이 아닐시 환영문구 Toast, 공백일 시 틀린문구 Toast
                Toast.makeText(this, this.getText(R.string.welcome), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, this.getText(R.string.faultValue), Toast.LENGTH_SHORT).show()
            }
        }
    }
}