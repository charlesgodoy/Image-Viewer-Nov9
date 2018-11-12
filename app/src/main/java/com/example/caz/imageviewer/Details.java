package com.example.caz.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        TextView outputText = (TextView)findViewById(R.id.outputText);

        outputText.setText(getIntent().getExtras().getString(Intent.EXTRA_TEXT));

        /* // from josh
        Intent intent = getIntent();
        ImageData imageObj = (ImageData)intent.getSerializableExtra(Intent.EXTRA_TEXT);
        */

 //       ImageData imageObj = (ImageData)getIntent().getSerializableExtra(Intent.EXTRA_TEXT);       //REMOVE FOR NOW, BUT PUT BACK IF APP BROKEN



        final Uri myUri = Uri.parse(getIntent().getExtras().getString(Intent.EXTRA_TEXT));


//        TextView createTextView = new TextView(this);
//
//        createTextView.setTextSize(25);
//        createTextView.setText(text);
//        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
//        linearLayout.addView(createTextView);


//        <ImageView
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content" />


        ImageView descriptionImage = new ImageView(this);

        descriptionImage.setImageURI(myUri);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
        layout.addView(descriptionImage);

        descriptionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fullImageIntent = new Intent(Details.this, FullscreenActivity.class);
                fullImageIntent.putExtra(Intent.EXTRA_TEXT, myUri.toString());         // from what i understand, first param is a keyword for checking, next param is the data that will be sent

                startActivity(fullImageIntent);

            }
        });



    }
}
