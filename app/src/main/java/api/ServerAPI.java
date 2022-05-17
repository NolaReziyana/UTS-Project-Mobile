package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerAPI {
    private static final String baseURL = "https://procurable-masses.000webhostapp.com/";
    //private static final String baseLokal = "";
    private static Retrofit retrofit = null;


    public static SelectAPI getSelectAPI() {

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SelectAPI.class);

    }

}
