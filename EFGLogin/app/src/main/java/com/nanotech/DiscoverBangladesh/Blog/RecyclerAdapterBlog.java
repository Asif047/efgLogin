package com.nanotech.DiscoverBangladesh.Blog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nanotech.DiscoverBangladesh.R;

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


        makeTextViewResizable(holder.details , 3, "View More", true);


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







    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    int lineEndIndex = tv.getLayout().getLineEnd(0);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                }
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {
            ssb.setSpan(new ClickableSpan() {

                @Override
                public void onClick(View widget) {

                    if (viewMore) {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, -1, "View Less", false);
                    } else {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, 3, "View More", true);
                    }

                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }






}
