package com.example.common.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.coroutines.*

class SearchTextWatcher(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val onReadyToSearch: (String) -> Unit
) : TextWatcher {

    private var scope: CoroutineScope? = null

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        scope?.cancel()
        scope = CoroutineScope(dispatcher)
        scope?.launch {
            delay(1000L)
            p0?.let {
                onReadyToSearch(p0.toString())
            }
        }
    }

    override fun afterTextChanged(p0: Editable?) {}

}
fun EditText.setOnSearchListener(content: (String) -> Unit) {
    addTextChangedListener(
        SearchTextWatcher {
            if(this.hasFocus())
                content(it)
        }
    )
}
