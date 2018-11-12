package com.example.caz.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        Uri fullImageUri = Uri.parse(getIntent().getExtras().getString(Intent.EXTRA_TEXT));


        ImageView fullImage = new ImageView(this);
        fullImage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ) );


                fullImage.setImageURI(fullImageUri);

        LinearLayout full_screen_layout = (LinearLayout)findViewById(R.id.full_layout);

        full_screen_layout.addView(fullImage);




    }
}
