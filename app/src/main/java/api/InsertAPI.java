package api;

import model.ModelResep;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InsertAPI {
    @FormUrlEncoded
    @POST("insertresep.php")
    Call<ModelResep> inputResep(
         @Field("namaresep") String namaresep,
         @Field("gambar") String gambar,
         @Field("keterangan") String keterangan
    );
}

