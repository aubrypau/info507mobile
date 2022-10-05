package model

class Expense(
    val id: Int,
    val name: String,
    val category: Int,
    val amount: String,
    val date: String,
    val author: Int
) {
    companion object {
        const val ID ="id"
        const val NAME = "name"
        const val CATEGORY ="category"
        const val AMOUNT = "amount"
        const val DATE = "date"
        const val AUTHOR= "author"
    }
}