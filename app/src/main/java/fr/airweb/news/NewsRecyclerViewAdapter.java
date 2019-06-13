package fr.airweb.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import fr.airweb.news.models.News;

import java.util.List;


public class NewsRecyclerViewAdapter  extends RecyclerView.Adapter<NewsRecyclerViewAdapter.CustomViewHolder> {
    private List<News> newsItemList;
    private Context mContext;
    private OnItemClickListener onItemClickListener;


    public NewsRecyclerViewAdapter(AppCompatActivity context, List<News> newsItemList) {
        this.newsItemList = newsItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        final News news = newsItemList.get(i);

        //Download image using picasso library
        if (!TextUtils.isEmpty(news.getPicture())) {
            Picasso.get().load(news.getPicture())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(customViewHolder.imageView);
        }

        //Setting text view title
        customViewHolder.titletxt.setText(Html.fromHtml(news.getTitle()));
        customViewHolder.contenttxt.setText(Html.fromHtml(news.getContent()));


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  onItemClickListener.onItemClick(news);
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("news",news);

                mContext.startActivity(intent);
                ((AppCompatActivity) mContext).finish();

            }
        };
        customViewHolder.imageView.setOnClickListener(listener);
        customViewHolder.titletxt.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return (null != newsItemList ? newsItemList.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView titletxt;
        protected TextView contenttxt;

        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.titletxt = (TextView) view.findViewById(R.id.title);
            this.contenttxt = (TextView) view.findViewById(R.id.content);
            this.contenttxt.setMaxLines(3);

        }
    }


    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}