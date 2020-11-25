package euclidesquissembe.mirepos.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import euclidesquissembe.mirepos.data.ReposApi.service
import euclidesquissembe.mirepos.data.models.Repo

class RepoRepository {

    val repo: MutableLiveData<Repo> = MutableLiveData()

    suspend fun getRepo(owner: String, repo: String) {
        try {
            val response = service.getRepo(owner, repo)

            this.repo.value = response
        } catch (throwable: Throwable) {
            Log.e(TAG, "getRepo: $throwable", throwable)
        }
    }

    companion object {
        private const val TAG = "RepoRepository"
    }

}