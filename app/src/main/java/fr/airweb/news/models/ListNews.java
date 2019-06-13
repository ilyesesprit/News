package fr.airweb.news.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListNews {
    @SerializedName("news")
    private List<News> news;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}