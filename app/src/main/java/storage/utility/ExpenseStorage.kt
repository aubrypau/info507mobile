package storage.utility

import android.content.Context
import android.content.SharedPreferences

object ExpenseStorage {
    private fun getPreferences(context: Context): SharedPreferences{
        return context.getSharedPreferences("com.btm.info507.preferences", Context.MODE_PRIVATE)
    }

    fun getStorage(context: Context): Int{
        return 0
    }

    fun setStorage(context: Context, prefStorage: Int){


    }

    fun get(context: Context): Storage<Expense>{
        return null
    }

}