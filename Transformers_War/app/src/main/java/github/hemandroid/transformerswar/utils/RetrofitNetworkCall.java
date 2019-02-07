package github.hemandroid.transformerswar.utils;

import github.hemandroid.transformerswar.interfaces.RetrofitCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitNetworkCall {

    public static <T> void callRetrofit(Call<T> call, final RetrofitCallBack retrofitCallBack){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                retrofitCallBack.onSuccessResponse(response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                retrofitCallBack.onFailureResponse(call);
            }
        });
    }
}
