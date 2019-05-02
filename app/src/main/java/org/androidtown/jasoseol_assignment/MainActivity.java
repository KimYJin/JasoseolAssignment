package org.androidtown.jasoseol_assignment;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*create back-button at tool bar*/
        Toolbar mToolbar = (Toolbar) findViewById(R.id.list_toolBar);
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow);

        ListView listView = findViewById(R.id.list_container);      //create ListView object
        CompanyAdapter companyAdapter = new CompanyAdapter(this);       //create Adapter object
        companyAdapter.setItem(getCompanyList());       //set data for items of listView
        listView.setAdapter(companyAdapter);        //set Adapter object to listView
    }

    /*activate back-button of tool bar*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * do JSON Parsing
     * @return ArrayList<CompanyItem>
     */
    private ArrayList<CompanyItem> getCompanyList() {

        ArrayList<CompanyItem> companyList = new ArrayList();

        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String companyName = jsonObject.getString("company_name");
                String fields = jsonObject.getString("fields");
                String image = jsonObject.getString("image");
                String endTime = jsonObject.getString("end_time");

                companyList.add(new CompanyItem(companyName, fields, image, endTime));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    /**
     * read json file
     * @return String
     **/
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
