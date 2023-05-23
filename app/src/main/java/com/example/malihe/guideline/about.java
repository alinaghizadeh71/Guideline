package com.example.malihe.guideline;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Window;
import android.widget.TextView;

;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
       // TextView txt1=(TextView)findViewById(R.id.txt1);
        TextView txt2=(TextView)findViewById(R.id.txt2);
        TextView txt3=(TextView)findViewById(R.id.txt3);
        Typeface i=Typeface.createFromAsset(getAssets(),"fonts/IRAN.ttf");
       // txt1.setTypeface(i);
        txt2.setTypeface(i);
        txt3.setTypeface(i);


       // TextView v=(TextView)findViewById(R.id.v);
       // Spanned sp = Html.fromHtml( getString(R.string.title));
       /*                     String htmlAsString = getString(R.string.title);
                            Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
                            v.setText(htmlAsSpanned);
*/
       /* TextView view = (TextView)findViewById(R.id.sampleText);
        String formattedText = getString(R.string.htmlFormattedText);
        Spanned result = Html.fromHtml(formattedText);
        view.setText(result);*/
    }
}
