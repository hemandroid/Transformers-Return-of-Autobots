package github.hemandroid.transformerswar.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import github.hemandroid.transformerswar.R;
import github.hemandroid.transformerswar.databinding.ActivityCreateTransformerBinding;

public class CreateTransformerActivity extends AppCompatActivity {

    ActivityCreateTransformerBinding createTransformerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createTransformerBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_transformer);
    }
}
