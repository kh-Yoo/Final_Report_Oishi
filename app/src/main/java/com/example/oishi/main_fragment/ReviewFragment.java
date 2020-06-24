package com.example.oishi.main_fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.R;
import com.example.oishi.review.PopupActivity;
import com.example.oishi.review.ReviewItem;
import com.example.oishi.review.ReviewItemAdapter;
import com.example.oishi.review.ReviewLayoutManager;
import com.example.oishi.review.ReviewRecyclerView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ReviewFragment extends Fragment {
    public ReviewItemAdapter adapter;
    ReviewRecyclerView recyclerView;
    ReviewLayoutManager layout;

    private static final String TAG_UID = "id";
    private static final String TAG_CONTENT ="content";
    private static final String TAG_RATING = "rating";
    private static final String TAG_TIME = "present";
    ArrayList<HashMap<String, String>> review_List;

    public ReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        adapter = new ReviewItemAdapter(getActivity());

        recyclerView = (ReviewRecyclerView) view.findViewById(R.id.recycler_view);

        review_List = new ArrayList<HashMap<String,String>>();
        String url = "http://ykh3587.dothome.co.kr/read_review.php";


        BackgroundTask task = new BackgroundTask(url, null);
        task.execute();

        Button register = (Button) view.findViewById(R.id.register_review);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String name = data.getStringExtra("name");
                String content = data.getStringExtra("content");
                String url = data.getStringExtra("url");
                item.add(new Item(name, url, content));
            }
        }
    }*/

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
                    String uid = c.getString(TAG_UID);
                    String content = c.getString(TAG_CONTENT);
                    String rating = c.getString(TAG_RATING);
                    String time = c.getString(TAG_TIME);

                    HashMap<String,String> persons = new HashMap<String,String>();

                    persons.put(TAG_UID,uid);
                    persons.put(TAG_CONTENT,content);
                    persons.put(TAG_RATING, rating);
                    persons.put(TAG_TIME, time);

                    review_List.add(persons);

                }

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new ReviewItem(hashMap.get(TAG_UID), hashMap.get(TAG_CONTENT), hashMap.get(TAG_RATING), hashMap.get(TAG_TIME)));
                    System.out.println(hashMap.get(TAG_UID));
                }
                recyclerView.setHasFixedSize(true);

                layout = new ReviewLayoutManager(getActivity());
                recyclerView.setLayoutManager(layout);

                recyclerView.setAdapter(adapter);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}