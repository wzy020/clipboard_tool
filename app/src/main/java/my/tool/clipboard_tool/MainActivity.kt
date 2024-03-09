package my.tool.clipboard_tool

import android.content.ClipboardManager
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.WindowCompat


class MainActivity : AppCompatActivity() {

    val panel: AppCompatEditText by lazy { findViewById(R.id.content_panel) }
    val cleanBtn: AppCompatTextView by lazy { findViewById(R.id.btn_clean) }
    val clipboardManager: ClipboardManager by lazy {
        getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT

        setContentView(R.layout.activity_main)

        cleanBtn.setOnClickListener {
            clipboardManager.clearPrimaryClip()
            refreshPanel()
        }
    }

    override fun onResume() {
        super.onResume()
        refreshPanel()
    }

    private fun refreshPanel() {
        panel.post {
            val clipData = getClipData() ?: ""
            panel.setText(clipData)
        }
    }

    private fun getClipData(): CharSequence? {
        val clipData = clipboardManager.primaryClip ?: return null
        if (clipData.itemCount <= 0) return null
        val item = clipData.getItemAt(0) ?: return null
        return item.text
    }

}