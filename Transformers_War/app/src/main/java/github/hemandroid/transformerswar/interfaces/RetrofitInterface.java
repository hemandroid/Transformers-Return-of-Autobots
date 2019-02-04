package github.hemandroid.transformerswar.interfaces;

import github.hemandroid.transformerswar.TransformerModelData.NewTransformerResponse;
import github.hemandroid.transformerswar.TransformerModelData.TransformerRequestBody;
import github.hemandroid.transformerswar.TransformerModelData.UpdateTransformerData;
import github.hemandroid.transformerswar.TransformerModelData.transformersList.TransformersListResponse;
import github.hemandroid.transformerswar.utils.APIs;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET(APIs.ALL_SPARK)
    Call<String> getTokenAllSpark();

    @Headers("Content-Type:application/json")
    @POST(APIs.TRANSFORMERS)
    Call<NewTransformerResponse> getNewTransformerResponse(@Header("Authorization") String authorization,
                                                        @Body TransformerRequestBody transformerRequestBody);

    @Headers("Content-Type:application/json")
    @GET(APIs.TRANSFORMERS)
    Call<TransformersListResponse> getListOfTransformers(@Header("Authorization") String authorization);

    @Headers("Content-Type:application/json")
    @PUT(APIs.TRANSFORMERS)
    Call<NewTransformerResponse> getUpdatedTransformerResponse(@Header("Authorization") String authorization,
                                                              @Body UpdateTransformerData updateTransformerData);

    @Headers("Content-Type:application/json")
    @DELETE(APIs.DELETE_TRANSFORMER_BY_ID)
    Call<String> deleteTransformer(@Header("Authorization") String authorization,
                                   @Path("transformerId") String transformerID);



}
