package org.androidtown.jasoseol_assignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CompanyAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<CompanyItem> companyList;

    public CompanyAdapter(Context context) {
        this.context = context;
        Log.d("testCase", "context initialized");
    }

    public void setItem(ArrayList<CompanyItem> companyList) {
        this.companyList = companyList;
        notifyDataSetChanged();
        Log.d("testCase", "setItem");
    }

    @Override       //return the number of items
    public int getCount() {
        Log.d("testCase", "getCount");
        return companyList.size();
    }

    @Override
    public Object getItem(int i) {
        Log.d("testCase", "getItem");
        return companyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        Log.d("testCase", "getItemId");
        return 0;
    }

    @Override       //return view which is represented to each item
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Log.d("testCase", "getView");

        CompanyItemView view = null;

        if (convertView == null) {
            view = new CompanyItemView(context);
        }
        else{
            view = (CompanyItemView) convertView;
        }

        CompanyItem item = companyList.get(i);
        view.setCompanyName(item.getCompanyName());
        view.setFields(item.getFields());
        view.setEndTime(item.getEndTime());
        view.setImage(item.getImage());
        view.setSelectStar();

        return view;
    }
}
