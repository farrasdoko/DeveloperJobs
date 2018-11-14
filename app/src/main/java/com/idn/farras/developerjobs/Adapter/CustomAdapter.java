package com.idn.farras.developerjobs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.idn.farras.developerjobs.DetailActivity;
import com.idn.farras.developerjobs.Model.ResponseJobs;
import com.idn.farras.developerjobs.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<ResponseJobs> responseJobs;
    Context context;

    public CustomAdapter(List<ResponseJobs> responseJobs, Context context) {
        this.responseJobs = responseJobs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final ResponseJobs item = responseJobs.get(i);
        myViewHolder.tvTitle.setText(item.getTitle());
        myViewHolder.tvCompany.setText(" ● " +item.getCompany());
        myViewHolder.tvLocation.setText(item.getLocation());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class)
                .putExtra("description", item.getDescription())
                .putExtra("howToApply", item.getHowToApply())
                .putExtra("type", item.getType())
                .putExtra("companyLogo", item.getCompanyLogo())
                .putExtra("title", item.getTitle())
                .putExtra("company", item.getCompany())
                .putExtra("location", item.getLocation())
                .putExtra("created", item.getCreatedAt())
                .putExtra("type", item.getType())
                .putExtra("companyURL", item.getCompanyUrl())
                .putExtra("apply", item.getUrl()));
            }
        });
        try {
            Glide.with(context)
                    .load(item.getCompanyLogo())
                    .into(myViewHolder.imgLogo);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return responseJobs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_logo)
        ImageView imgLogo;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_location)
        TextView tvLocation;
        @BindView(R.id.tv_company)
        TextView tvCompany;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
