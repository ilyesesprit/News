package fr.airweb.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import fr.airweb.news.models.ListNews;
import fr.airweb.news.models.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private List<News> newsList;
    private RecyclerView mRecyclerView;
    private NewsRecyclerViewAdapter adapter;
    private ProgressBar progressBar;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        newsList = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);


        Call<ListNews> call = apiInterface.doGetListOfNews();
        call.enqueue(new Callback<ListNews>() {
            @Override
            public void onResponse(Call<ListNews> call, Response<ListNews> response) {




               try{

                   ListNews resource = response.body();
                   for (News n : resource.getNews()) {

                      if(n.getType().equals("news")){
                      newsList.add(n);}
                   }

                   adapter =new NewsRecyclerViewAdapter(NewsActivity.this,newsList);
                   mRecyclerView.setAdapter(adapter);
                   mRecyclerView.smoothScrollToPosition(0);



               }


               catch (Exception e){
                   System.out.println("*********"+e.getMessage());
               }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ListNews> call, Throwable t) {
                System.out.println("*********"+t.getMessage());
                call.cancel();
            }
        });




    }
}
