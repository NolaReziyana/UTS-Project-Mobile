package api;

import java.util.List;

import model.ModelResep;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectAPI {

    @GET("selectresep.php")
    Call<List<ModelResep>> callResep();

}
