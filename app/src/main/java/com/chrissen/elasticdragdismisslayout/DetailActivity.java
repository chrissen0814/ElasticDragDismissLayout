package com.chrissen.elasticdragdismisslayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chrissen.core.ElasticDragDismissFrameLayout;
import com.chrissen.elasticdragdismisslayout.bean.ContentBean;

public class DetailActivity extends AppCompatActivity {

    private static final String DATA = "data";
    private ContentBean mContentBean;

    public static void actionStart(Context context, ContentBean contentBean) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DATA, contentBean);
        context.startActivity(intent);
    }

    private ElasticDragDismissFrameLayout mLayout;
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mContentBean = (ContentBean) getIntent().getSerializableExtra(DATA);
        mLayout = findViewById(R.id.elastic_layout);
        mImageView = findViewById(R.id.iv_image);
        mTextView = findViewById(R.id.tv_content);
        Glide.with(this).asBitmap().load(mContentBean.getImageUrl()).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mImageView.setImageBitmap(resource);
                Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@NonNull Palette palette) {
                        Palette.Swatch lvSwatch = palette.getDarkVibrantSwatch();
                        if (lvSwatch != null) {
                            mLayout.setBackgroundColor(lvSwatch.getRgb());
                        }
                        Palette.Swatch lmSwatch = palette.getDarkMutedSwatch();
                        if (lmSwatch != null) {
                            mLayout.setBackgroundColor(lmSwatch.getRgb());
                        }
                    }
                });
            }
        });
        mTextView.setText(mContentBean.getContent());
        mLayout.addListener(new ElasticDragDismissFrameLayout.SystemChromeFader(this){
            @Override
            public void onDragDismissed() {
                super.onDragDismissed();
                if (mLayout.getTranslationY() > 0) {
                    getWindow().setReturnTransition(TransitionInflater.from(DetailActivity.this)
                            .inflateTransition(R.transition.about_return_downward));
                }
                finishAfterTransition();
            }
        });
    }



}
