package bonch.dev.secondhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var receivedText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val isClicked = intent.getBooleanExtra(FirstActivity::IS_BUTTON_CLICKED.toString(), false)
        val tapCount = intent.getIntExtra(FirstActivity::COUNTER.toString(), 0)
        val text = intent.getStringExtra(FirstActivity::INPUT_TEXT.toString())
        receivedText +=
            "Нажатие индикатора: ${isClicked}\n" +
            "Количество нажатий на кнопку: ${tapCount}\n" +
            "Введенный текст: ${text}\n"
        initActivity()
    }

    fun initViews(){
        textView = findViewById(R.id.text_field)
    }

    fun displayInfo(){
        textView.setText(receivedText)
    }

    fun initActivity(){
        initViews()
        displayInfo()
    }

}
