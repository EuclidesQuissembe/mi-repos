package euclidesquissembe.mirepos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import euclidesquissembe.mirepos.data.models.Repo
import euclidesquissembe.mirepos.databinding.RepoItemBinding

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoAdapterViewHolder>() {

    private var repos: MutableList<Repo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepoItemBinding.inflate(inflater, parent, false)

        return RepoAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoAdapterViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount() = repos.size

    fun addRepo(repo: Repo) {
        repos.add(repo)
        notifyItemInserted(repos.size - 1)
    }

    class RepoAdapterViewHolder(
        private val binding: RepoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repo) {
            binding.repo = repo
        }

    }
}