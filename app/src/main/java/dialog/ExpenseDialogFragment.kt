package dialog

import adapter.CategoryAdapter
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.btm.info507.R

class ExpenseDialogFragment(private val id: Int?) : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_expense, null)
        view.findViewById<Spinner>(R.id.expense_category).adapter = CategoryAdapter()

        return AlertDialog.Builder(requireContext())
            .setTitle(if(id == null) R.string.expense_dialog_add else R.string.expense_dialog_edit)
            .setView(view)
            .setPositiveButton(R.string.expense_dialog_confirm, null)
            .setNegativeButton(R.string.expense_dialog_cancel, null)
            .create()
    }
}