package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.Domain.RecommendedDomain;
import com.example.myapplication.R;

public class Show_detail extends AppCompatActivity {
    private TextView title2,fee1,number,desc;
    private ImageView pic1,add,minus,backview;
    private TextView cartbtn;
    private  RecommendedDomain data;
     int total=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        detail();
        getdata();
        backview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Show_detail.this,home.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total=total+1;
                number.setText(String.valueOf(total));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(total>1) {
                    total = total - 1;
                    number.setText(String.valueOf(total));
                }
            }
        });
    }

    private void getdata() {
        data= (RecommendedDomain)getIntent().getSerializableExtra("data");
        title2.setText(data.getTitle());
        desc.setText(data.getDescription());
        fee1.setText("$"+data.getFee());
        number.setText(String.valueOf(total));
        int drawableResourceId=this.getResources().getIdentifier(data.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(pic1);

    }

    private void detail() {
        title2=findViewById(R.id.title2);
        fee1=findViewById(R.id.fee1);
        number=findViewById(R.id.number);
        desc=findViewById(R.id.desc);
        pic1=findViewById(R.id.pic1);
        add=findViewById(R.id.add);
        minus=findViewById(R.id.minus);
        cartbtn=findViewById(R.id.cartbtn);
        backview=findViewById(R.id.backview);
    }
}