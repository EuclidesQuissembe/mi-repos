package euclidesquissembe.mirepos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import euclidesquissembe.mirepos.data.models.Repo
import euclidesquissembe.mirepos.data.repositories.RepoRepository
import kotlinx.coroutines.launch

class RepoViewModel(private val repoRepository: RepoRepository) : ViewModel() {

    val repo: LiveData<Repo> = repoRepository.repo

    fun getRepo(owner: String, repo: String) = viewModelScope.launch {
        repoRepository.getRepo(owner, repo)
    }

    class RepoViewModelFactory(private val repoRepository: RepoRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RepoViewModel(repoRepository) as T
        }
    }
}