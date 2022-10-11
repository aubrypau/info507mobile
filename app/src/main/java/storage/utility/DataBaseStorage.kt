package storage.utility

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


abstract class DataBaseStorage<T>(private val helper: SQLiteOpenHelper, private val table: String): Storage<T>() {

    protected abstract fun objectToValues(obj: T): ContentValues
    protected abstract fun cursorToObject(cursor: Cursor): T

    override fun insert(obj: T): Int {
        return helper.writableDatabase.insert(table,null,objectToValues(obj)).toInt()
    }

    override fun delete(id: Int) {
        helper.writableDatabase.delete(table, "${BaseColumns._ID} = ?", arrayOf("$id"))
    }

    override fun find(id: Int): T? {
            var obj: T? = null
            val cursor = helper.readableDatabase.query(
                table, null, "${BaseColumns._ID} = ?", arrayOf("$id"), null, null, null
            )
            if(cursor.moveToNext()){
                obj = cursorToObject(cursor)
            }
            cursor.close()
            return obj
        }

    override fun findAll(): List<T> {
        val list = arrayListOf<T>()
        val cursor = helper.readableDatabase.query(table, null, null, null, null, null,null, null)
        while(cursor.moveToNext()){
            list.add(cursorToObject(cursor))
        }
        cursor.close()
        return list
    }

    override fun size(): Int {
        return helper.readableDatabase.query(table, null, null, null, null,null, null,null).count
    }

    override fun update(id: Int, obj: T) {
        helper.writableDatabase.update(
            table, objectToValues(obj), "${BaseColumns._ID} = ?", arrayOf("$id")
        )
    }
}