package hw6;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Period;

import static hw6.Controller.NOW;
import static java.time.Period.*;


public class AccuweatherModel {
    //    http://dataservice.accuweather.com/forecasts/v1/daily/1day/

    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "pJhO8rlSp9tUdDUKQvEcYvlG7gdoAr3t";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";


    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();



    public static void getWeather(String selectedCity, String period) throws IOException {
        switch(period) {

            case FIVE_DAYS:
                HttpUrl httUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment("295212")
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httUrl)
                        .build();

                Response fiveDaysForecastsResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = fiveDaysForecastsResponse.body().string();
                System.out.println(weatherResponse);

                break;
        }


    }
    public static void main(String[] args) throws IOException {
        getWeather("222",FIVE_DAYS);
    }



}