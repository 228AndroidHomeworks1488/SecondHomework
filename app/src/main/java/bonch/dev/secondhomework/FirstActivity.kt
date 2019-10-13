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

    public val IS_BUTTON_CLICKED = "IS_BUTTON_CLICKED"
    public val COUNTER = "IS_BUTTON_CLICKED"
    public val INPUT_TEXT = "INPUT_TEXT"


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
            indicatorButton.setEnabled(false)
            isClicked = true
        }

        counterButton.setOnClickListener {
            counter++
            counterButton.setText("нажато ${counter} раз")
        }

        nextActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(COUNTER, counter)
            intent.putExtra(IS_BUTTON_CLICKED, isClicked)
            intent.putExtra(INPUT_TEXT, textField.getText().toString())

            startActivity(intent)

        }

    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER, counter)
        outState.putBoolean(IS_BUTTON_CLICKED, isClicked)
        outState.putString(INPUT_TEXT, textField.getText().toString())
    }*/

    fun initActivity(){
        initViews()
        setOnClickListeners()
    }

}
