package org.androidtown.jasoseol_assignment;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CompanyItemView extends ConstraintLayout {

    ImageView image;
    TextView companyName;
    TextView fields;
    TextView endTime;
    ImageButton selectStar;

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

    public void init(Context context) {
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

    public void setSelectStar() {
        selectStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
            }
        });

    }
}
