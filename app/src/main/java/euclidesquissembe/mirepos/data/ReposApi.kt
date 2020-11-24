package euclidesquissembe.mirepos.data

import euclidesquissembe.mirepos.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReposApi {
    private fun initRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ReposInterface = initRetrofit().create(ReposInterface::class.java)
}