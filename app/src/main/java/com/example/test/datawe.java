package com.example.test;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class datawe {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("weather_state_name")
    @Expose
    private String weatherstatename;
    @SerializedName("weather_state_abbr")
    @Expose
    private String weatherstateabbr;
    @SerializedName("wind_direction_compass")
    @Expose
    private String winddirectioncompass;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("applicable_date")
    @Expose
    private String applicabledate;
    @SerializedName("min_temp")
    @Expose
    private Double mintemp;
    @SerializedName("max_temp")
    @Expose
    private Double maxtemp;
    @SerializedName("the_temp")
    @Expose
    private Double thetemp;
    @SerializedName("wind_speed")
    @Expose
    private Double windspeed;
    @SerializedName("wind_direction")
    @Expose
    private Double winddirection;
    @SerializedName("air_pressure")
    @Expose
    private Double airpressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("visibility")
    @Expose
    private Double visibility;
    @SerializedName("predictability")
    @Expose
    private Integer predictability;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeatherStateName() {
        return weatherstatename;
    }

    public void setWeatherStateName(String weatherstatename) {
        this.weatherstatename = weatherstatename;
    }

    public String getWeatherStateAbbr() {
        return weatherstateabbr;
    }

    public void setWeatherStateAbbr(String weatherstateabbr) {
        this.weatherstateabbr = weatherstateabbr;
    }



    public void setWindDirectionCompass(String winddirectioncompass) {
        this.winddirectioncompass = winddirectioncompass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicableDate() {
        return applicabledate;
    }

    public void setApplicableDate(String applicabledate) {
        this.applicabledate = applicabledate;
    }

    public Double getMinTemp() {
        return mintemp;
    }

    public void setMinTemp(Double mintemp) {
        this.mintemp = mintemp;
    }

    public Double getMaxTemp() {
        return maxtemp;
    }

    public void setMaxTemp(Double maxtemp) {
        this.maxtemp = maxtemp;
    }

    public Double getTheTemp() {
        return thetemp;
    }

    public void setTheTemp(Double thetemp) {
        this.thetemp = thetemp;
    }

    public Double getWindSpeed() {
        return windspeed;
    }

    public void setWindSpeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public Double getWindDirection() {
        return winddirection;
    }

    public void setWindDirection(Double winddirection) {
        this.winddirection = winddirection;
    }

    public Double getAirPressure() {
        return airpressure;
    }

    public void setAirPressure(Double airpressure) {
        this.airpressure = airpressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Integer getPredictability() {
        return predictability;
    }

    public void setPredictability(Integer predictability) {
        this.predictability = predictability;
    }

}


