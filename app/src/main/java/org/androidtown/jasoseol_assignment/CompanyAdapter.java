package org.androidtown.jasoseol_assignment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CompanyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CompanyItem> companyList; //store companyItem object which has data of each item

    public CompanyAdapter(Context context) {
        this.context = context;
    }

    //set data for each item of listView
    public void setItem(ArrayList<CompanyItem> companyList) {
        this.companyList = companyList;
        notifyDataSetChanged();
    }

    /**
     * @return the number of items
     */
    @Override
    public int getCount() {
        return companyList.size();
    }

    @Override
    public Object getItem(int position) {
        return companyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     *
     * @param position of item to be viewed in listView
     * @param convertView is view object corresponding to the current index
     * @param viewGroup is parent container object which contains
     * @return view to display item
     */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        CompanyItemView view = null;

        if (convertView == null) {
            view = new CompanyItemView(context);    //create new CompanyItemView object
        } else {
            view = (CompanyItemView) convertView;   //when scrolling, recycle view already been created
        }

        CompanyItem item = companyList.get(position);
        view.setCompanyName(item.getCompanyName());
        view.setFields(item.getFields());
        view.setEndTime(item.getEndTime());
        view.setImage(item.getImage());
        view.setSelectStar(item);

        return view;
    }
}
