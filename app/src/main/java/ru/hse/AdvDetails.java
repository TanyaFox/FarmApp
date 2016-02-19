package ru.hse.farm; //com

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class AdvDetails extends AppCompatActivity {
    public final static String ID = "ID";
    private Advertisement adv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adv_details);
        adv = Advertisement.ADVERTISEMENTS.get(getIntent().getIntExtra(ID, 0));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView AdvDetailsName = (TextView)findViewById(R.id.adv_details_name);
        TextView AdvDetailsPrice = (TextView)findViewById(R.id.adv_details_price);
        TextView AdvDetailsType_of_price = (TextView)findViewById(R.id.adv_details_type_of_price);
        TextView AdvDetailsDescription = (TextView)findViewById(R.id.adv_details_description);
        TextView AdvDetailsSaler = (TextView)findViewById(R.id.adv_details_saler);
        ImageView galleryIm = (ImageView)findViewById(R.id.gallery_image);
        final RatingBar AdvDetailsRate = (RatingBar)findViewById(R.id.adv_details_rate);
        final RatingBar AdvDetailsGivenRate = (RatingBar)findViewById(R.id.adv_details_give_rate);

        AdvDetailsName.setText(adv.name);
        AdvDetailsPrice.setText(adv.price.toString());
        AdvDetailsType_of_price.setText(adv.type_of_price);
        AdvDetailsDescription.setText(adv.description);
        AdvDetailsSaler.setText(adv.salerName + " " + adv.salerSurname);
        galleryIm.setImageResource(adv.photoId);
        AdvDetailsRate.setRating(adv.rate.floatValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_settings_menu, menu);
        return true;
    }

    public void onBackClick(MenuItem item){

    }


}
