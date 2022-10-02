package com.btm.info507

import adapter.ExpenseAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dialog.ExpenseDialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.expense_list).adapter = ExpenseAdapter()

        findViewById<FloatingActionButton>(R.id.expense_add).setOnClickListener {
            ExpenseDialogFragment(1).show(supportFragmentManager,null)
        }


        //val button = findViewById<Button>(R.id.my_button)

        //button.setOnClickListener {
            //Toast.makeText(applicationContext, "Coucou !", Toast.LENGTH_SHORT).show()
            //val intent = Intent(applicationContext, ExpenseActivity::class.java)
            //startActivity(intent)
        }
    }
