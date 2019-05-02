package org.androidtown.jasoseol_assignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static android.content.Context.MODE_PRIVATE;

public class CompanyItemView extends ConstraintLayout {

    ImageView image;
    TextView companyName;
    TextView fields;
    TextView endTime;
    ImageButton selectStar;

    Context context;

    SharedPreferences likes;
    SharedPreferences.Editor editor;

    public CompanyItemView(Context context) {
        super(context);
        init(context);
    }

    public CompanyItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CompanyItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /* Inflate view(layout in company_item.xml) for each item of list view*/
    public void init(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.company_item, this, true);

        image = (ImageView) findViewById(R.id.image);
        companyName = (TextView) findViewById(R.id.company_name);
        fields = (TextView) findViewById(R.id.fields);
        endTime = (TextView) findViewById(R.id.end_time);
        selectStar = (ImageButton) findViewById(R.id.select_star);
    }

    public void setImage(String url) {
        Glide.with(this).load(url).into(image);
    }

    public void setCompanyName(String companyName) {
        this.companyName.setText(companyName);
    }

    public void setFields(String fields) {
        this.fields.setText(fields);
    }

    public void setEndTime(String endTime) {
        this.endTime.setText(endTime);
    }

    public void setSelectStar(final CompanyItem item) {
        likes = context.getSharedPreferences("likes", MODE_PRIVATE);////

        if(likes!=null && likes.getBoolean(item.getCompanyName(),false))
            selectStar.setSelected(true);
        else
            selectStar.setSelected(false);

        //When imageButton(selectStar) is clicked, change state
        selectStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SharedPreference(item, view);
            }
        });
    }

    // store star-selected state information using SharedPreferences
    private void SharedPreference(CompanyItem item, View view) {
        likes = context.getSharedPreferences("likes", MODE_PRIVATE);
        editor = likes.edit();//

        if (likes!=null && likes.getBoolean(item.getCompanyName(),false)) {
            editor.putBoolean(item.getCompanyName(), false);
            view.setSelected(false);
        } else {
            editor.putBoolean(item.getCompanyName(), true);
            view.setSelected(true);
        }
        editor.commit();
    }
}