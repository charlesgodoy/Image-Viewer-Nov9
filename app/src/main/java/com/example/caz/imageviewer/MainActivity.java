package com.example.caz.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    // by Charles Godoy
    // Image Viewer - And1 - Nov5, 2018

    public static final int IMAGE_REQUEST_CODE = 0;
    Button get_image_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_image_button = findViewById(R.id.get_image_button);

        get_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent imageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent, IMAGE_REQUEST_CODE);            // broadcast the intent



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            if(requestCode == IMAGE_REQUEST_CODE) {


                String imgURL = data.getData().toString();



              //ImageData imageData = new ImageData(imgURL);

                //trying to use createImageData method found below
                createImageData(imgURL);




                addTV(imgURL);





            }
        }
    }

    private TextView addTV (String text) {

        final TextView createTextView = new TextView(this);

        createTextView.setTextSize(25);
        createTextView.setText(text);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        linearLayout.addView(createTextView);


        createTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            TextView listUri = createTextView;

            Intent intentDetails = new Intent(MainActivity.this, Details.class);
            intentDetails.putExtra(Intent.EXTRA_TEXT, listUri.getText());


            startActivity(intentDetails);

            }
        });


        return createTextView;
    }





    public void createImageData(String uri){

        ImageData imageDataObj = new ImageData(uri);

        ArrayList<ImageData> imageArray =  new ArrayList<ImageData>();

        imageArray.add(imageDataObj);

        // Code below is used to check log if Contact was saved to ArrayList
        Log.d(TAG, "URI: File check:" + imageArray);


    }

}
