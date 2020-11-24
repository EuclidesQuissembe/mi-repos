package euclidesquissembe.mirepos.data

import euclidesquissembe.mirepos.data.models.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface ReposInterface {

    @GET("{owner}/{repo}")
    suspend fun getRepo(
        @Path("owner") owner: String, @Path("repo") repo: String
    ): Repo
}