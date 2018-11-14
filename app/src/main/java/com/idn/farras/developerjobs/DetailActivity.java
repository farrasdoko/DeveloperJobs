package com.idn.farras.developerjobs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.img_logo_detail)
    ImageView imgLogoDetail;
    @BindView(R.id.txt_title_detail)
    TextView txtTitleDetail;
    @BindView(R.id.txt_company_detail)
    TextView txtCompanyDetail;
    @BindView(R.id.txt_location_detail)
    TextView txtLocationDetail;
    @BindView(R.id.txt_created_detail)
    TextView txtCreatedDetail;
    @BindView(R.id.txt_type_detail)
    TextView txtTypeDetail;
    @BindView(R.id.txt_description_detail)
    TextView txtDescriptionDetail;
    @BindView(R.id.txt_howto_detail)
    TextView txtHowtoDetail;
    @BindView(R.id.txt_company_url_detail)
    TextView txtCompanyUrlDetail;
    @BindView(R.id.txt_apply_detail)
    TextView txtApplyDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        txtTitleDetail.setText(intent.getStringExtra("title"));
        txtCompanyDetail.setText(intent.getStringExtra("company") + " ● ");
        txtLocationDetail.setText(intent.getStringExtra("location"));
        txtCreatedDetail.setText(intent.getStringExtra("created"));
        txtTypeDetail.setText(intent.getStringExtra("type"));
        txtDescriptionDetail.setText(intent.getStringExtra("description"));
        txtHowtoDetail.setText(intent.getStringExtra("howToApply"));;

        try {
            Glide.with(getApplicationContext())
                    .load(intent.getStringExtra("companyLogo"))
                    .into(imgLogoDetail);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @OnClick({R.id.txt_company_url_detail, R.id.txt_apply_detail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_company_url_detail:
                break;
            case R.id.txt_apply_detail:
                break;
        }
    }
}
