package com.idn.farras.developerjobs;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.idn.farras.developerjobs.Adapter.CustomAdapter;
import com.idn.farras.developerjobs.Model.ResponseJobs;
import com.idn.farras.developerjobs.Rest.ApiClient;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.rv_item)
    RecyclerView rvItem;

    String description, location;

    List<ResponseJobs> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        description = getIntent().getStringExtra("description");
        location = getIntent().getStringExtra("location");
        
        getData();
    }

    private void getData() {
        Call<JsonArray> recipeCall = ApiClient.getClient().getJobs(description, location);
        recipeCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                String hasilString = response.body().toString();

                Type listType = new TypeToken<List<ResponseJobs>>(){}.getType();
                dataItems = getTeamListFromJson(hasilString, listType);
                Log.d("Retrofit Get", "Jumlah Data = " + String.valueOf(dataItems.size()));

                if (dataItems.size() == 0){
                    ConstraintLayout constraintLayout = findViewById(R.id.constlayout);
                    Snackbar snackbar = Snackbar.make(constraintLayout, "Empty Jobs", Snackbar.LENGTH_LONG);
                    snackbar.setAction("GO BACK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    });
                    snackbar.show();
                } else {
                    rvItem.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
                    rvItem.setAdapter(new CustomAdapter(dataItems, RecyclerActivity.this));
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("Retrofit Get", t.getMessage());
            }
        });
    }

    public static List<ResponseJobs> getTeamListFromJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }
}
