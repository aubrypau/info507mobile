package com.btm.info507

import adapter.ExpenseAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dialog.ExpenseDialogFragment
import storage.ExpenseStorage


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
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.setting, menu)
            return true
        }

        override fun onPrepareOptionsMenu(menu: Menu): Boolean {
            var id = R.id.storage_none
            when (ExpenseStorage.getStorage(applicationContext)) {
                ExpenseStorage.DATA_BASE -> id = R.id.storage_data_base
                ExpenseStorage.FILE_JSON -> id = R.id.storage_file_json
            }
            menu.findItem(id).isChecked = true
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            var prefStorage = ExpenseStorage.getStorage(applicationContext)
            when (item.itemId) {
                R.id.storage_none -> prefStorage = ExpenseStorage.NONE
                R.id.storage_data_base -> prefStorage = ExpenseStorage.DATA_BASE
                R.id.storage_file_json -> prefStorage = ExpenseStorage.FILE_JSON
            }
            ExpenseStorage.setStorage(applicationContext, prefStorage)
            return true
        }
    }
