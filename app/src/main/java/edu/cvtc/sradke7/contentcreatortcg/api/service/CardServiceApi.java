package edu.cvtc.sradke7.contentcreatortcg.api.service;

import edu.cvtc.sradke7.contentcreatortcg.api.models.CardResponse;
import edu.cvtc.sradke7.contentcreatortcg.api.models.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardServiceApi {

    @GET("cards/search")
    Call<SearchResponse> fetchCard(@Query("q") String searchTerm);

}
