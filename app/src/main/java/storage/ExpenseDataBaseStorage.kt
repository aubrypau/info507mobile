package storage

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import helper.DataBaseHelper
import model.Expense
import model.Expense.Companion.ID
import storage.utility.DataBaseStorage

class ExpenseDataBaseStorage(context: Context) :
    DataBaseStorage<Expense>(DataBaseHelper(context),"expense"){
    companion object {
        const val ID = 0
        const val NAME = 1
        const val CATEGORY = 2
        const val AMOUNT = 3
        const val DATE = 4
        const val AUTHOR = 5
    }
    override fun objectToValues(obj: Expense): ContentValues {
        val res = ContentValues()
        res.put(Expense.ID,obj.id)
        res.put(Expense.NAME,obj.name)
        res.put(Expense.CATEGORY,obj.category)
        res.put(Expense.AMOUNT,obj.amount)
        res.put(Expense.DATE,obj.date)
        res.put(Expense.AUTHOR, obj.author)
        return res
    }

    override fun cursorToObject(cursor: Cursor): Expense {
        return Expense(
            cursor.getInt(ID),
            cursor.getString(NAME),
            cursor.getInt(CATEGORY),
            cursor.getString(AMOUNT),
            cursor.getString(DATE),
            cursor.getInt(AUTHOR),
        )
    }

}