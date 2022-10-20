package com.practicum.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.practicum.testapp.adapter.CategoryAdapter;
import com.practicum.testapp.adapter.CourseAdapter;
import com.practicum.testapp.model.Category;
import com.practicum.testapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category( 1,"Игры"));
        categoryList.add(new Category( 2,"Сайты"));
        categoryList.add(new Category( 3,"Языки"));
        categoryList.add(new Category( 4,"Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course( 1,"java2", "Профессия Java\nразработчик", "1 января", "начальный", "#424345", "test", 3));
        courseList.add(new Course( 2,"python2", "Профессия Python\nразработчик", "10 января", "начальный", "#9FA52D", "test", 3));
        courseList.add(new Course( 3,"unity2", "Профессия Unity\nразработчик", "20 января", "начальный", "#FFC594", "test", 1));
        courseList.add(new Course( 4,"fullstack", "Профессия Fullstack\nразработчик", "30 января", "начальный", "#C8A2C8", "test", 2));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);


    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycle);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filteredCourses = new ArrayList<>();

        for(Course c : courseList) {
            if(c.getCategory() == category)
                filteredCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filteredCourses);

        courseAdapter.notifyDataSetChanged();


    }
}