package com.neppplus.uipractice_20220506_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.neppplus.uipractice_20220506_v1.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

//    1. 액티비티 전역에서 쓸 수 있도록 id / pw 변수 생성
    var inputId = ""
    var inputPw = ""

//    5. 액티비티 전역에서 쓸 수 있도록 autoLogin 변수 생성
    var autoLogin = false

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

//        6. autoLogin체크박스의 활성화 값(b : Boolean)을 만들어놓은 autoLogin에 대입
        autoLoginCb.setOnCheckedChangeListener { compoundButton, b ->
            autoLogin = b
        }

        loginBtn.setOnClickListener {
//            3. id, pw 값이 빈값("") or 공백(" ")이 아닌지 확인후 로그인 기능 진행
            if (inputId.isNotBlank() && inputPw.isNotBlank()) {
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
//            7. 다음 활용시 사용하기 위해 로그인화면 끝나기전 ContextUtil에 autoLogin 상황 설정
                ContextUtil.setAutoLogin(this, autoLogin)
                finish()
//            4. id, pw가 공백이 아닐시 환영문구 Toast, 공백일 시 틀린문구 Toast
                Toast.makeText(this, this.getText(R.string.welcome), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, this.getText(R.string.faultValue), Toast.LENGTH_SHORT).show()
            }
        }
    }
}