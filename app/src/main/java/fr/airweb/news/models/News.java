package fr.airweb.news.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class News implements Parcelable {
    @SerializedName("nid")
    String nid;
    @SerializedName("type")
    String type;
    @SerializedName("date")
    String date;
    @SerializedName("title")
    String title;
    @SerializedName("picture")
    String picture;
    @SerializedName("content")
    String content;
    @SerializedName("dateformated")
    String dateformated;

    public News() {
    }

    public News(String nid, String type, String date, String title, String picture, String content, String dateformated) {
        this.nid = nid;
        this.type = type;
        this.date = date;
        this.title = title;
        this.picture = picture;
        this.content = content;
        this.dateformated = dateformated;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateformated() {
        return dateformated;
    }

    public void setDateformated(String dateformated) {
        this.dateformated = dateformated;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(nid);
        dest.writeString(type);
        dest.writeString(date);
        dest.writeString(content);
        dest.writeString(picture);
        dest.writeString(date);
        dest.writeString(dateformated);





    }




    /**
     * Retrieving Movie data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     **/
    private News(Parcel in){
        this.title = in.readString();
        this.nid = in.readString();

        this.type = in.readString();
        this.date = in.readString();
        this.content = in.readString();
        this.picture = in.readString();
        this.date = in.readString();
        this.dateformated = in.readString();

    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public String toString() {
        return "News{" +
                "nid='" + nid + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", picture='" + picture + '\'' +
                ", content='" + content + '\'' +
                ", dateformated='" + dateformated + '\'' +
                '}';
    }
}
