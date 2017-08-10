package sg.edu.rp.c346.p12_mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {

    ImageView iv;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        iv = (ImageView)findViewById(R.id.ivLogo);
        String image = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(image).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(iv);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
}
