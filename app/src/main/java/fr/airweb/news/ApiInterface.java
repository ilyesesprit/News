package fr.airweb.news;

import fr.airweb.news.models.ListNews;
import fr.airweb.news.models.News;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiInterface {

    @GET("/psg/psg.json")
    Call<ListNews> doGetListOfNews();
}
