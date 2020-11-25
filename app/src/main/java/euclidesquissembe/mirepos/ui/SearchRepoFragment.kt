package euclidesquissembe.mirepos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import euclidesquissembe.mirepos.R
import euclidesquissembe.mirepos.viewmodels.RepoViewModel

class SearchRepoFragment(
    private val repoViewModel: RepoViewModel
) : DialogFragment(), View.OnClickListener {

    private lateinit var edtFullName: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_add).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener(this)

        edtFullName = view.findViewById(R.id.edt_full_name)
        edtFullName.requestFocus()

        dialog?.setTitle(getString(R.string.search_repo))

        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add -> {
                addRepository()
            }
            R.id.btn_cancel -> dismiss()
        }
    }

    private fun addRepository() {
        val fullName = edtFullName.text.toString()

        if (fullName.isNotEmpty()) {
            // Destructing
            val (owner, repo) = fullName.split("/")
            repoViewModel.getRepo(owner, repo)
        }
    }
}