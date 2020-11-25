package euclidesquissembe.mirepos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import euclidesquissembe.mirepos.R
import euclidesquissembe.mirepos.adapters.RepoAdapter
import euclidesquissembe.mirepos.data.repositories.RepoRepository
import euclidesquissembe.mirepos.viewmodels.RepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val repoRepository = RepoRepository()
    private lateinit var searchRepoFragment: SearchRepoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repoViewModel: RepoViewModel = ViewModelProvider(
            this,
            RepoViewModel.RepoViewModelFactory(repoRepository)
        ).get(RepoViewModel::class.java)

        val adapter = RepoAdapter()

        recycler_repos.adapter = adapter

        btn_add_repo.setOnClickListener {
            val fm = supportFragmentManager
            searchRepoFragment = SearchRepoFragment(repoViewModel)
            searchRepoFragment.show(fm, searchRepoFragment.tag)
        }

        repoViewModel.repo.observe(this) { repo ->
            searchRepoFragment.dismiss()

            repo.let {
                adapter.addRepo(it)
            }
        }
    }
}