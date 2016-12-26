package com.example.sayi.imdb2;

/**
 * Created by anvaya5 on 23/12/2016.
 */

public class Movies
{
    public String summary;

    private String[] genres;

    private String medium_cover_image;

    private String state;

    public String runtime;

    private String id;

    public String title;

    private String date_uploaded_unix;

    private String synopsis;

    public String year;

    private String title_long;

    public String background_image_original;

    private String description_full;

    public String small_cover_image;

    public String large_cover_image;

    private String mpa_rating;

    public String url;

    private String date_uploaded;

    public String background_image;

    // private Torrents[] torrents;

    private String yt_trailer_code;

    private String title_english;

    private String slug;

    public String rating;

    private String imdb_code;

    public String language;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public String[] getGenres ()
    {
        return genres;
    }

    public void setGenres (String[] genres)
    {
        this.genres = genres;
    }

    public String getMedium_cover_image ()
    {
        return medium_cover_image;
    }

    public void setMedium_cover_image (String medium_cover_image)
    {
        this.medium_cover_image = medium_cover_image;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getRuntime ()
    {
        return runtime;
    }

    public void setRuntime (String runtime)
    {
        this.runtime = runtime;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDate_uploaded_unix ()
    {
        return date_uploaded_unix;
    }

    public void setDate_uploaded_unix (String date_uploaded_unix)
    {
        this.date_uploaded_unix = date_uploaded_unix;
    }

    public String getSynopsis ()
    {
        return synopsis;
    }

    public void setSynopsis (String synopsis)
    {
        this.synopsis = synopsis;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getTitle_long ()
    {
        return title_long;
    }

    public void setTitle_long (String title_long)
    {
        this.title_long = title_long;
    }

    public String getBackground_image_original ()
    {
        return background_image_original;
    }

    public void setBackground_image_original (String background_image_original)
    {
        this.background_image_original = background_image_original;
    }

    public String getDescription_full ()
    {
        return description_full;
    }

    public void setDescription_full (String description_full)
    {
        this.description_full = description_full;
    }

    public String getSmall_cover_image ()
    {
        return small_cover_image;
    }

    public void setSmall_cover_image (String small_cover_image)
    {
        this.small_cover_image = small_cover_image;
    }

    public String getLarge_cover_image ()
    {
        return large_cover_image;
    }

    public void setLarge_cover_image (String large_cover_image)
    {
        this.large_cover_image = large_cover_image;
    }

    public String getMpa_rating ()
    {
        return mpa_rating;
    }

    public void setMpa_rating (String mpa_rating)
    {
        this.mpa_rating = mpa_rating;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getDate_uploaded ()
    {
        return date_uploaded;
    }

    public void setDate_uploaded (String date_uploaded)
    {
        this.date_uploaded = date_uploaded;
    }

    public String getBackground_image ()
    {
        return background_image;
    }

    public void setBackground_image (String background_image)
    {
        this.background_image = background_image;
    }

//    public Torrents[] getTorrents ()
//    {
//        return torrents;
//    }
//
//    public void setTorrents (Torrents[] torrents)
//    {
//        this.torrents = torrents;
//    }

    public String getYt_trailer_code ()
    {
        return yt_trailer_code;
    }

    public void setYt_trailer_code (String yt_trailer_code)
    {
        this.yt_trailer_code = yt_trailer_code;
    }

    public String getTitle_english ()
    {
        return title_english;
    }

    public void setTitle_english (String title_english)
    {
        this.title_english = title_english;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getImdb_code ()
    {
        return imdb_code;
    }

    public void setImdb_code (String imdb_code)
    {
        this.imdb_code = imdb_code;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", genres = "+genres+", medium_cover_image = "+medium_cover_image+", state = "+state+", runtime = "+runtime+", id = "+id+", title = "+title+", date_uploaded_unix = "+date_uploaded_unix+", synopsis = "+synopsis+", year = "+year+", title_long = "+title_long+", background_image_original = "+background_image_original+", description_full = "+description_full+", small_cover_image = "+small_cover_image+", large_cover_image = "+large_cover_image+", mpa_rating = "+mpa_rating+", url = "+url+", date_uploaded = "+date_uploaded+", background_image = "+background_image+", yt_trailer_code = "+yt_trailer_code+", title_english = "+title_english+", slug = "+slug+", rating = "+rating+", imdb_code = "+imdb_code+", language = "+language+"]";
    }
}