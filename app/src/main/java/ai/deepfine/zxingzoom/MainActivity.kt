package ai.deepfine.zxingzoom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    showQrCode()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == IntentIntegrator.REQUEST_CODE) {
      val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
      Toast.makeText(this, result.contents, Toast.LENGTH_SHORT).show()
      showQrCode()
    }
    super.onActivityResult(requestCode, resultCode, data)
  }

  private fun showQrCode() {
    val intergrator = IntentIntegrator(this).apply {
      MainActivity::class.java
      setTimeout(60000)
      setPrompt("Scanning Code")
    }

    intergrator.initiateScan()
  }
}