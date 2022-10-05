package storage

import android.content.Context
import android.content.SharedPreferences
import model.Expense
import storage.utility.Storage

object ExpenseStorage {

    private const val STORAGE = "storage"
    const val NONE = 0
    const val DATA_BASE = 1
    const val FILE_JSON = 2
    private const val DEFAULT = NONE

    private fun getPreferences(context: Context): SharedPreferences{
        return context.getSharedPreferences("com.btm.info507.preferences", Context.MODE_PRIVATE)
    }

    fun getStorage(context: Context): Int {
        return getPreferences(context).getInt(STORAGE, DEFAULT)
    }

    fun setStorage(context: Context, prefStorage: Int) {
        getPreferences(context).edit().putInt(STORAGE, prefStorage).apply()
    }

    fun get(context: Context): Storage<Expense> {
        lateinit var storage: Storage<Expense>
        when (getStorage(context)) {
            NONE -> storage = ExpenseNoneStorage()
            DATA_BASE -> storage = ExpenseDataBaseStorage(context)
            FILE_JSON -> storage = ExpenseJSONFileStorage(context)
        }
        return storage
    }

}