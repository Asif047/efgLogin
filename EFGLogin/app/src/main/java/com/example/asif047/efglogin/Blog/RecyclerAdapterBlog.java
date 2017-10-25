package com.example.asif047.efglogin.Blog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asif047.efglogin.R;

import java.util.List;

/**
 * Created by admin on 10/11/2017.
 */

public class RecyclerAdapterBlog extends RecyclerView.Adapter<RecyclerAdapterBlog.BlogMyViewHolder> {


    private List<Blog> blogs;

    private final Context context;

    public RecyclerAdapterBlog(Context ctx,List<Blog> blogs)
    {
        this.context = ctx;
        this.blogs=blogs;
    }

    @Override
    public BlogMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_blog,parent,false);

        return new BlogMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BlogMyViewHolder holder, int position) {

        holder.title.setText(blogs.get(position).getTitle());
        holder.details.setText(blogs.get(position).getDetails());

        Glide.with(context).load("http://discover.nanotech.com.bd/blog_images/"+blogs.get(position).getImage().toString()).into(holder.smallIV);

        Glide.with(context).load("http://discover.nanotech.com.bd/blog_images/"+blogs.get(position).getImage().toString()).into(holder.largeIV);

    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }



    public class BlogMyViewHolder extends RecyclerView.ViewHolder
    {

        TextView title,details;
        ImageView smallIV,largeIV;

        public BlogMyViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.title_textview_blog);
            details=(TextView)itemView.findViewById(R.id.details_textview_blog);
            smallIV=(ImageView)itemView.findViewById(R.id.small_image_blog);
            largeIV=(ImageView)itemView.findViewById(R.id.large_image_imageview_blog);
        }
    }

}
