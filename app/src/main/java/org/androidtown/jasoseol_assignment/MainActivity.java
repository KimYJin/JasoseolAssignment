package org.androidtown.jasoseol_assignment;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar)findViewById(R.id.list_toolBar);
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow);

        ListView listView = findViewById(R.id.list_container);

        CompanyAdapter companyAdapter = new CompanyAdapter(this);
        companyAdapter.setItem(getCompanyList());
        listView.setAdapter(companyAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    /**
     * Json을 파싱하여 데이터 리스트를 만들어서 반환한다.
     */
    private ArrayList<CompanyItem> getCompanyList() {
        ArrayList<CompanyItem> companyList = new ArrayList();
        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < jsonArray.length(); i++) {
                String companyName = jsonArray.getJSONObject(i).getString("company_name");
                String fields = jsonArray.getJSONObject(i).getString("fields");
                String image = jsonArray.getJSONObject(i).getString("image");
                String endTime = jsonArray.getJSONObject(i).getString("end_time");

                companyList.add(new CompanyItem(companyName, fields, image, endTime));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    /**
     * Json 파일을 가져와 String 타입으로 변환하여 반환한다.
     */
    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("Android.json");
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
