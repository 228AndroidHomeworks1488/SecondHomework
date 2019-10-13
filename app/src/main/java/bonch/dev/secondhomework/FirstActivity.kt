package bonch.dev.secondhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText

    companion object{
        val IS_BUTTON_CLICKED = "IS_BUTTON_CLICKED"
        val COUNTER = "COUNTER"
        val INPUT_TEXT = "INPUT_TEXT"
    }


    private var counter = 0
    private var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initActivity()
    }

    fun initViews(){
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        textField = findViewById(R.id.text_field)
    }

    fun setOnClickListeners(){

        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
            isClicked = true
        }

        counterButton.setOnClickListener {
            counter++
            counterButton.text = "нажато ${counter} раз"
        }

        nextActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(COUNTER, counter)
            intent.putExtra(IS_BUTTON_CLICKED, isClicked)
            var text = textField.text.toString()
            intent.putExtra(INPUT_TEXT, text)

            startActivity(intent)

        }
    }

    fun initActivity(){
        initViews()
        setOnClickListeners()
    }

}
