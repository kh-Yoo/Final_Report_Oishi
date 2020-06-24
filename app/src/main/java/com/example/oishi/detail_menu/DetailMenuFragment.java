package com.example.oishi.detail_menu;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.review.ReviewItem;
import com.example.oishi.review.ReviewLayoutManager;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailMenuFragment extends Fragment {
    detailmenuRecyclerView recyclerView;
    public detailmenuItemAdapter adapter;
    detailmenuLayoutManager layout;
    public String Food_Type, Brand_Name;
    private static final String TAG_FOODNAME = "Child_Name";
    private static final String TAG_FOODPRICE = "Child_Price";
    private static final String TAG_FOODIMG = "Child_Img";
    ArrayList<HashMap<String, String>> review_List;

    public DetailMenuFragment(String brand_name, String food_type)
    {
        Brand_Name = brand_name;
        Food_Type = food_type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_menu, container, false);
        adapter = new detailmenuItemAdapter(getActivity(), Brand_Name, Food_Type);
        recyclerView = view.findViewById(R.id.detail_recyclerview);
        review_List = new ArrayList<HashMap<String,String>>();
        String url = "http://ykh3587.dothome.co.kr/" + Food_Type + "_detail.php";
        ContentValues values = new ContentValues();
        values.put("storename", Brand_Name);
        System.out.println(url);
        System.out.println(Brand_Name);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

        return view;
    }


    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    String foodname = c.getString(TAG_FOODNAME);
                    String foodprice = c.getString(TAG_FOODPRICE);
                    String foodimg = c.getString(TAG_FOODIMG);

                    HashMap<String,String> persons = new HashMap<String,String>();

                    persons.put(TAG_FOODNAME, foodname);
                    persons.put(TAG_FOODPRICE, foodprice);
                    persons.put(TAG_FOODIMG, foodimg);

                    review_List.add(persons);
                }

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new detailmenuItem(hashMap.get(TAG_FOODNAME), hashMap.get(TAG_FOODPRICE), hashMap.get(TAG_FOODIMG)));
                    System.out.println(hashMap.get(TAG_FOODNAME));
                    System.out.println(hashMap.get(TAG_FOODPRICE));
                    System.out.println(hashMap.get(TAG_FOODIMG));
                }
                recyclerView.setHasFixedSize(true);

                layout = new detailmenuLayoutManager(getActivity());
                recyclerView.setLayoutManager(layout);

                recyclerView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
