package com.app.cricapi.services;

import com.app.cricapi.model.Match;
import com.app.cricapi.model.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CricApiServices {

    String API_KEY="HDZlEWZxFIc9A8FlaUXo7RmTCzZ2";

    @GET("matches?apikey="+API_KEY)
    Call<Root> getNewMatches();

}
