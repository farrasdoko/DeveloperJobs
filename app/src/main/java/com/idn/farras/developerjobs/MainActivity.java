package com.idn.farras.developerjobs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_description)
    EditText etDescription;
    @BindView(R.id.et_location)
    EditText etLocation;
    @BindView(R.id.btn_find)
    Button btnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_find)
    public void onViewClicked() {
        String description = etDescription.getText().toString();
        String location = etLocation.getText().toString();
            startActivity(new Intent(MainActivity.this, RecyclerActivity.class)
                    .putExtra("description", description)
                    .putExtra("location", location.toLowerCase()));

    }
}
