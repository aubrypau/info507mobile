package helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import model.Expense

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context,"mykount.db",null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE Expense (" +
                    "${BaseColumns._ID} INTEGER," +
                    "${Expense.NAME} TEXT," +
                    "${Expense.CATEGORY} INTEGER," +
                    "${Expense.AMOUNT} REAL," +
                    "${Expense.DATE} DATE," +
                    "${Expense.AUTHOR} INTEGER," +
                    "PRIMARY KEY(${BaseColumns._ID})" +
                    ")"
        )
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}