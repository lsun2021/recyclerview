package com.demo.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PolicySpi;
import java.util.List;

/**
 * Created by ${momoThree} on 2017/9/14.
 * Title:
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> mStudentList;

    public StudentAdapter(List<Student> mStudentList) {
        this.mStudentList = mStudentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        final ViewHolder holder=new ViewHolder(view);

        holder.studentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Student student = mStudentList.get(position);
                Toast.makeText(v.getContext(), "你点击了"+student.getName(), Toast.LENGTH_SHORT).show();

            }
        });
        holder.studentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Student student = mStudentList.get(position);
                Toast.makeText(v.getContext(), "你点击了"+student.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student=mStudentList.get(position);
        holder.studentImage.setImageResource(student.getImageId());
        holder.studentname.setText(student.getName());

    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    static   class  ViewHolder extends  RecyclerView.ViewHolder{

        private ImageView studentImage;
        private TextView  studentname;
          View  studentView;

          public ViewHolder(View itemView) {
            super(itemView);
            studentView=itemView;
            studentImage= (ImageView) itemView.findViewById(R.id.iv_head);
            studentname= (TextView) itemView.findViewById(R.id.tv_student_name);
        }
    }


}
