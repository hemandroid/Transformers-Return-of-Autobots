package github.hemandroid.transformerswar;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import github.hemandroid.transformerswar.TransformerModelData.transformersList.TransformerData;
import github.hemandroid.transformerswar.TransformerModelData.transformersList.TransformersListResponse;
import github.hemandroid.transformerswar.adapter.TransformersRecyclerListAdapter;
import github.hemandroid.transformerswar.databinding.ActivityMainBinding;
import github.hemandroid.transformerswar.utils.NetworkUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private View.OnClickListener mOnClickListener;
    private List<TransformersListResponse> loadTransformerList = new ArrayList<>();
    private List<TransformerData> loadTransformerData = new ArrayList<>();
    private LinearLayoutManager transformerLinearLayoutManager;
    private TransformersRecyclerListAdapter transformersRecyclerListAdapter;

    private String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0cmFuc2Zvcm1lcnNJZCI6Ii1MWGVfa0Z2TGI2ME1JWjlZaE9xIiwiaWF0IjoxNTQ5MDUwMjUxfQ.s8Vi4yrWtiHp7n8cGUs2h8SAE11YYPhuu4NEKLTQF-g";
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (NetworkUtils.getInstance().isNetworkAvailable(getApplicationContext())) {
            mProgressDialog = NetworkUtils.getProgressDialog(getApplicationContext());
            loadTransformersList();
        } else {
            if (mProgressDialog != null) mProgressDialog.dismiss();
        }

        initViewClickListener();
        initView();
    }

    private void initView() {
        setSupportActionBar(activityMainBinding.toolbar);
        activityMainBinding.createTransformers.setOnClickListener(mOnClickListener);
        activityMainBinding.mainContent.transformersList.setHasFixedSize(true);
        transformerLinearLayoutManager = new LinearLayoutManager(this);
        activityMainBinding.mainContent.transformersList.setLayoutManager(transformerLinearLayoutManager);
    }

    private void initViewClickListener() {
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.create_transformers:
//                        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                        tokeAllSpark();
                        break;
                }
            }
        };
    }

    private void loadTransformersList() {
        Call<TransformersListResponse> getTransformerListData = NetworkUtils.getApiInterface().getListOfTransformers(token);
        getTransformerListData.enqueue(new Callback<TransformersListResponse>() {
            @Override
            public void onResponse(Call<TransformersListResponse> call, Response<TransformersListResponse> response) {
                TransformersListResponse transformersListResponse = response.body();
                if (transformersListResponse != null) {
                    loadTransformerData = transformersListResponse.getTransformers();
                }
                transformersRecyclerListAdapter = new TransformersRecyclerListAdapter(MainActivity.this, loadTransformerData);
                activityMainBinding.mainContent.transformersList.setAdapter(transformersRecyclerListAdapter);
                if (mProgressDialog != null) mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<TransformersListResponse> call, Throwable t) {
                if (mProgressDialog != null) mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Server Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteTransformer() {
        Call<String> deleteTransformer = NetworkUtils.getApiInterface().deleteTransformer(token, "-LXmWyiciLeOEjuIX-h3");
        deleteTransformer.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 204) {
                    Snackbar.make(activityMainBinding.mainLayout, "Item deleted successfully...!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
//                    Toast.makeText(MainActivity.this, "Item deleted successfully...!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (mProgressDialog != null) mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Server Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tokeAllSpark() {
        Call<String> getTokenAllSpark = NetworkUtils.getApiHTMLInterface().getTokenAllSpark();
        getTokenAllSpark.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {
                    Toast.makeText(MainActivity.this, "Token --> " + response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (mProgressDialog != null) mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Server Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
