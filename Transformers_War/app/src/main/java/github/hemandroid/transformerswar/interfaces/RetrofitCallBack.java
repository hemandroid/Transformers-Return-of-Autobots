package github.hemandroid.transformerswar.interfaces;

import retrofit2.Call;
import retrofit2.Response;

public interface RetrofitCallBack {
    <T> void onSuccessResponse(Response<T> successResponse);
    <T> void onFailureResponse(Call<T> errorResponse);
}
