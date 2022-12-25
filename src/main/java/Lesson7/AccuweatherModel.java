package Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import Lesson7.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/294021
    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "urw2jJvxJQwatmXr722LnfMlxe5aIEOd";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrlOneDay = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestOneDay = new Request.Builder()
                        .url(httpUrlOneDay)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(requestOneDay).execute();
                String weatherResponseOneDay = oneDayForecastResponse.body().string();
                System.out.println(weatherResponseOneDay);
                String localDate = objectMapper.readTree(weatherResponseOneDay).get(0).at
                        ("/Date").asText();
                String temperature = objectMapper.readTree(weatherResponseOneDay).get(0).at
                        ("/Temperature").asText();
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
                try {
                    dataBaseRepository.saveWeatherToDataBase(new Weather
                            ("Москва","25.12.2022", 12.0));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case FIVE_DAYS:
                HttpUrl httpUrlFiveDays = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestFiveDays = new Request.Builder()
                        .url(httpUrlFiveDays)
                        .build();

                Response fiveDaysForecastResponse = okHttpClient.newCall(requestFiveDays).execute();
                String weatherResponseFiveDays = fiveDaysForecastResponse.body().string();
                System.out.println(weatherResponseFiveDays);
                break;
        }
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }

    public String WeatherResponse(String selectedCity) throws IOException {
        HttpUrl httpUrlOneDay = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(ONE_DAY)
                .addPathSegment(detectCityKey(selectedCity))
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        Request weather = new Request.Builder()
                .url(httpUrlOneDay)
                .build();

        Response weatherResponse = okHttpClient.newCall(weather).execute();
        String getWeatherResponse = weatherResponse.body().string();
        System.out.println(getWeatherResponse);

        return getWeatherResponse;
    }

}