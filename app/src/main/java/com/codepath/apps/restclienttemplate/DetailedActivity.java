package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailedActivity extends AppCompatActivity {

    ImageView ivProfileImageDetailed;
    TextView tvScreenNameDetailed;
    TextView tvBodyDetailed;
    Button btnDetailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        ivProfileImageDetailed = findViewById(R.id.ivProfileImageDetailed);
        tvScreenNameDetailed = findViewById(R.id.tvScreenNameDetailed);
        tvBodyDetailed = findViewById(R.id.tvBodyDetailed);
        btnDetailed = findViewById(R.id.btnDetailed);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvScreenNameDetailed.setText(tweet.getUser().getScreenName());
        tvBodyDetailed.setText(tweet.getBody());
        Glide.with(this).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImageDetailed);
        btnDetailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}