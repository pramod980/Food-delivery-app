package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;

import com.example.myapplication.Activity.Adapter.CategoryAdapter;
import com.example.myapplication.Activity.Adapter.RecommendyAdapter;
import com.example.myapplication.Activity.Domain.CategoryDomain;
import com.example.myapplication.Activity.Domain.RecommendedDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    private RecyclerView.Adapter myadapter;
    private RecyclerView recyclerViewCategoryList;
    private RecyclerView.Adapter myadapter1;
    private RecyclerView recyclerViewRecommendedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerViewCategory();
        recyclerViewRecommend();
        recyclerViewRecommendedList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    private void recyclerViewRecommend() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewRecommendedList=findViewById(R.id.recyclerView3);
        recyclerViewRecommendedList.setLayoutManager(linearLayoutManager);

        ArrayList<RecommendedDomain> recommend=new ArrayList<>();
        recommend.add(new RecommendedDomain("Peppperoni Pizza","pizza1","Slices pepperoni, mozzerilla cheese, fresh oregano,ground black pepper,pizza sauce",5.6));
        recommend.add(new RecommendedDomain("Cheese Burger","burger","Beef,Gouda cheese,Special Sauce,Lettuce,Tomato",3));
        recommend.add(new RecommendedDomain("Vegetable Pizza","pizza1","Slices pepperoni mozzerilla cheese, fresh oregano,ground black pepper,pizza sauce",5.6));

        myadapter1=new RecommendyAdapter(recommend);
        recyclerViewRecommendedList.setAdapter(myadapter1);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView2);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cate_1"));
        category.add(new CategoryDomain("Burger","cate_2"));
        category.add(new CategoryDomain("Hotdog","cate_3"));
        category.add(new CategoryDomain("Drink","cate_4"));
        category.add(new CategoryDomain("Donut","cate_5"));

        myadapter=new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(myadapter);
    }

}