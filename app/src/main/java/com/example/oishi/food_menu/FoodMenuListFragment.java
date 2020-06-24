package com.example.oishi.food_menu;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.oishi.menu_sort.FoodMenuSortActivity;
import com.example.oishi.RequestHttpURLConnection;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class FoodMenuListFragment extends ListFragment {
    private FoodMenuAdapter adapter;
    private String Food_Type, Food_Type2;

    //ListFragment 생성자
    public FoodMenuListFragment(String food_type, String food_Type2) {
        Food_Type = food_type;
        Food_Type2 = food_Type2;
    }

    //ListView 생성 처리
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //9가지 음식 중 사용자가 선택한 음식의 대표메뉴 카테고리를 불러주기위해서
        //php를 9가지로 구성하고 테이블명을 Food_Type2로 설정하여 알맞게 해당 음식의 메뉴 테이블에 연결할수있도록 만들었습니다.
        String url = "http://ykh3587.dothome.co.kr/" + Food_Type2 + ".php";

        ContentValues values = new ContentValues();
        values.put("Food_Type", Food_Type);

        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        FoodMenuListViewItem item = (FoodMenuListViewItem) listView.getItemAtPosition(position);

        String food_menu_name = item.getParents_Name();

        //use item data.
        Intent intent = new Intent(getActivity(), FoodMenuSortActivity.class);
        intent.putExtra("menu_name", food_menu_name);
        startActivity(intent);
    }

    //ListFragment Item추가
    public void addItem(String image, String name, String description) {
        adapter.addItem(image, name, description) ;
    }

    //AsyncTask 스레드 동작 함수
    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;

        //AsyncTask 스레드 생성자
        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }


        //UI 동작 이전 초기화 단계
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //HTTP접속 파일 생성 후 URL, 매개변수 전달 후 값 반환
            asyncDialog = ProgressDialog.show(getActivity(), "Please Wait", null, true, true);
            adapter = new FoodMenuAdapter();
        }

        //백그라운드 동작 실행
        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //다운로드 중 프로그레스바 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        //백그라운드 동작 수행 이후 결과 값 사용
        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            setListAdapter(adapter);

            //Gson : Json객체를 생성자 파일의 형태에 맞게끔 변환시켜줌
            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                int index = 0;
                while(index < jsonArray.length()) {
                    //변환
                    FoodMenuListViewItem foodMenuListViewItem = gson.fromJson(jsonArray.get(index).toString(), FoodMenuListViewItem.class);
                    //어뎁터에 추가
                    adapter.addItem(foodMenuListViewItem.getParents_Img(), foodMenuListViewItem.getParents_Name(), foodMenuListViewItem.getParents_Content());
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}