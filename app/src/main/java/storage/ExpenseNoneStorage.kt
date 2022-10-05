package storage

import model.Expense
import storage.utility.Storage

class ExpenseNoneStorage: Storage<Expense>(){
    override fun insert(obj: Expense): Int {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Expense? {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Expense> {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, obj: Expense) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

}