package com.example.test;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class montreal {

    @SerializedName("montreal")
    @Expose
    private List<datawe> datawe = null;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("sun_rise")
    @Expose
    private String sunrise;
    @SerializedName("sun_set")
    @Expose
    private String sunset;
    @SerializedName("timezone_name")
    @Expose
    private String timezonename;

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("location_type")
    @Expose
    private String locationtype;

    @SerializedName("timezone")
    @Expose
    private String timezone;

    public List<datawe> getDataWe() {
        return datawe;
    }

    public void setDataWe(List<datawe> datawe) {
        this.datawe = datawe;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSunRise() {
        return sunrise;
    }

    public void setSunRise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunSet() {
        return sunset;
    }

    public void setSunSet(String sunset) {
        this.sunset = sunset;
    }

    public String getTimezoneName() {
        return timezonename;
    }

    public void setTimezoneName(String timezonename) {
        this.timezonename = timezonename;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationType() {
        return locationtype;
    }

    public void setLocationType(String locationtype) {
        this.locationtype = locationtype;
    }


    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
