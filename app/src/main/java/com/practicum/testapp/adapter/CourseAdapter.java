package com.practicum.testapp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.practicum.testapp.CoursePage;
import com.practicum.testapp.R;
import com.practicum.testapp.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(courses.get(position).getImg(),"drawable", context.getPackageName()); //Название возможно надо изменить
        holder.courseImage.setImageResource(imageId);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePage.class);


                intent.putExtra("courseBg",Color.parseColor(courses.get(position).getColor()));
                intent.putExtra("courseImage", imageId);
                intent.putExtra("courseTitle", courses.get(position).getTitle());
                intent.putExtra("courseDate", courses.get(position).getDate());
                intent.putExtra("courseLevel", courses.get(position).getLevel());
                intent.putExtra("courseText", courses.get(position).getText());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView courseBg;
        ImageView courseImage;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseLevel = itemView.findViewById(R.id.courseLevel);

        }
    }
}
