package github.hemandroid.transformerswar.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import github.hemandroid.transformerswar.interfaces.RetrofitInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NetworkUtils {

    public static NetworkUtils mNetworkUtils;
    public static Retrofit mRetrofit;
    public static RetrofitInterface mRetrofitInterface;
    public static RetrofitInterface mRetrofitHTMLInterface;

    public static NetworkUtils getInstance() {
        if (mNetworkUtils == null) {
            mNetworkUtils = new NetworkUtils();
        }
        return mNetworkUtils;
    }

    public static Retrofit getJSONRetrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(APIs.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());
            mRetrofit = builder.client(httpBuilder.build()).build();
        }
        return mRetrofit;
    }

//    public static Retrofit getHTMLRetrofit(){
//        if (mRetrofit == null){
//            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
//            Retrofit.Builder htmlBuilder = new Retrofit.Builder().baseUrl(APIs.BASE_URL)
//                    .addConverterFactory(ScalarsConverterFactory.create());
//            mRetrofit = htmlBuilder.client(httpBuilder.build()).build();
//        }
//        return mRetrofit;
//    }

    public static RetrofitInterface getApiInterface() {
        mRetrofitInterface = getJSONRetrofit().create(RetrofitInterface.class);
        return mRetrofitInterface;
    }

//    public static RetrofitInterface getApiHTMLInterface(){
//        mRetrofitHTMLInterface = getHTMLRetrofit().create(RetrofitInterface.class);
//        return mRetrofitHTMLInterface;
//    }

    public Boolean isNetworkAvailable(Context context) {
        ConnectivityManager check = (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] info = check.getAllNetworkInfo();
        for (int i = 0; i < info.length; i++) {
            if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }

        return false;
    }

    public static ProgressDialog getProgressDialog(Context context) {
        return ProgressDialog.show(context, "", "Loading please wait...", true);
    }

}
