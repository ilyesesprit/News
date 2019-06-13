package fr.airweb.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import fr.airweb.news.models.News;

public class DetailsActivity extends AppCompatActivity {

    protected ImageView imageView;
    protected TextView titletxt;
    protected TextView contenttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       imageView = (ImageView)findViewById(R.id.thumbnail);
       titletxt = (TextView) findViewById(R.id.title);
       contenttxt = (TextView) findViewById(R.id.content);

        getSupportActionBar().setTitle(null);
        // Set onClickListener to customView
        ImageView imback = (ImageView) findViewById(R.id.back);
        ImageView ishare = (ImageView) findViewById(R.id.back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, NewsActivity.class);


               startActivity(intent);
              finish();
            }
        });

        News news = (News) getIntent().getParcelableExtra("news");
        if (news != null) {
            if (!TextUtils.isEmpty(news.getPicture())) {
                Picasso.get().load(news.getPicture())
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(imageView);
            }

            //Setting text view title
           titletxt.setText(Html.fromHtml(news.getTitle()));
           contenttxt.setText(Html.fromHtml(news.getContent()));
           
        }

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailsActivity.this, NewsActivity.class);


        startActivity(intent);
        finish();
    }

}
