package com.example.vasant;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {

    private List<CategoryModel> CategoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        CategoryModelList = categoryModelList;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
         holder.setData(CategoryModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return CategoryModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView title;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.category);
        }

        private void setData(final String title){

            this.title.setText(title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent setIntent=new Intent(itemView.getContext(), list_items.class);
                    setIntent.putExtra("category",title);
                    itemView.getContext().startActivity(setIntent);
                }
            });
        }
    }
}
