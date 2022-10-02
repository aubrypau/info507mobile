package com.btm.info507

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class ExpenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense)

        val image = findViewById<ImageView>(R.id.expense_image)
        val takePhoto = registerForActivityResult(
            ActivityResultContracts.TakePicturePreview()
        ) { bitmap ->
            if (bitmap == null) {
                image.setImageResource(R.drawable.ic_photo)
            } else {
                image.setImageBitmap(bitmap)
            }
        }

        image.setOnClickListener {
            takePhoto.launch(null)
        }

        //il faut créer une personne toto dans activity expense.xml et lui donner l'id @+id/toto
        val toto = findViewById<View>(R.id.toto).setOnClickListener {
            if (checkPermission(android.Manifest.permission.CALL_PHONE)) {
                intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:0605040302"))
                startActivity(intent)
            }
        }

        }
        private fun checkPermission(permission: String):Boolean{
            var res = true
            if(ContextCompat.checkSelfPermission(applicationContext,permission) != PackageManager.PERMISSION_GRANTED){
                if(!ActivityCompat.shouldShowRequestPermissionRationale(this,permission)){
                    ActivityCompat.requestPermissions(this, arrayOf(permission),0)
                }
                res = false
            }
            return res

    }
}
