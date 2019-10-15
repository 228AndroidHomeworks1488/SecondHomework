package bonch.dev.secondhomework.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bonch.dev.secondhomework.FragmentActivity

import bonch.dev.secondhomework.R

class MyFragment : Fragment() {

    private lateinit var textView: TextView
    private var isClicked = false
    private var tapCount = 0
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val boolTmp = arguments?.getBoolean(FragmentActivity.IS_BUTTON_CLICKED, false)
        val intTmp = arguments?.getInt(FragmentActivity.COUNTER, 0)
        val strTmp = arguments?.getString(FragmentActivity.INPUT_TEXT)

        if(boolTmp != null)
            isClicked = boolTmp
        if(intTmp != null)
            tapCount = intTmp
        if(strTmp != null)
            text = strTmp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        textView = view.findViewById(R.id.text_view)
        textView.text =
            "Нажатие индикатора: ${isClicked}\n" +
                    "Количество нажатий на кнопку: ${tapCount}\n" +
                    "Введенный текст: ${text}\n"
        return view
    }


}
