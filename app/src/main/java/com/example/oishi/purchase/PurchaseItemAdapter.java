package com.example.oishi.purchase;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oishi.FoodDetailActivity;
import com.example.oishi.R;
import com.example.oishi.RequestHttpURLConnection;
import com.example.oishi.detail_menu.detailmenuItem;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PurchaseItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<PurchaseItem> visibleItems = new ArrayList<>();
    public Context context;
    public int totalsum = 0;

    public PurchaseItemAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return visibleItems.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_order_item,  parent, false);
        viewHolder = new ParentItemVH(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final ParentItemVH parentItemVH = (ParentItemVH)holder;
            parentItemVH.name.setText(visibleItems.get(position).getname());
            parentItemVH.price.setText(Integer.parseInt(visibleItems.get(position).getPrice()) * Integer.parseInt(visibleItems.get(position).getCount()) + "원");
            parentItemVH.count.setText(visibleItems.get(position).getCount());
            parentItemVH.order_detail.setText("기본 : " + visibleItems.get(position).getPrice()  + "원");

        parentItemVH.count_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    visibleItems.get(position).setCount("" + (Integer.parseInt(visibleItems.get(position).getCount()) + 1) + "");

                    parentItemVH.price.setText(Integer.parseInt(visibleItems.get(position).getPrice()) * Integer.parseInt(visibleItems.get(position).getCount()) + "원");

                    parentItemVH.count.setText(visibleItems.get(position).getCount());
                    int count = Integer.parseInt(visibleItems.get(position).getCount());
                    System.out.println(count);
                    String url = "http://ykh3587.dothome.co.kr/alter_count_shopping_basket.php";
                    String name = visibleItems.get(position).getname();
                    String price =  visibleItems.get(position).getPrice();

                    String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    ContentValues values = new ContentValues();
                    values.put("local", local);
                    values.put("foodname", name);
                    values.put("foodprice", price);
                    values.put("count", count);
                    BackgroundTask task = new BackgroundTask(url, values);
                    task.execute();

                }
            });

            parentItemVH.count_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    visibleItems.get(position).setCount("" + (Integer.parseInt(visibleItems.get(position).getCount()) - 1) + "");
                    if(Integer.parseInt(visibleItems.get(position).getCount()) <= 1)
                    {
                        visibleItems.get(position).setCount("1");
                    }
                    parentItemVH.price.setText(Integer.parseInt(visibleItems.get(position).getPrice()) * Integer.parseInt(visibleItems.get(position).getCount()) + "원");

                    parentItemVH.count.setText(visibleItems.get(position).getCount());

                    int count = Integer.parseInt(visibleItems.get(position).getCount());
                    System.out.println(count);
                    String url = "http://ykh3587.dothome.co.kr/alter_count_shopping_basket.php";
                    String name = visibleItems.get(position).getname();
                    String price =  visibleItems.get(position).getPrice();

                    String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    ContentValues values = new ContentValues();
                    values.put("local", local);
                    values.put("foodname", name);
                    values.put("foodprice", price);
                    values.put("count", count);
                    BackgroundTask task = new BackgroundTask(url, values);
                    task.execute();
                }
            });

            parentItemVH.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                                String url = "http://ykh3587.dothome.co.kr/remove_shopping_basket.php";
                                String name = visibleItems.get(position).getname();
                                String price =  visibleItems.get(position).getPrice();
                                System.out.println(name);
                                System.out.println(price);
                                String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                                ContentValues values = new ContentValues();
                                values.put("local", local);
                                values.put("foodname", name);
                                values.put("foodprice", price);
                                BackgroundTask task = new BackgroundTask(url, values);
                                task.execute();

                                visibleItems.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,visibleItems.size());
                }
            });
            totalsum = 0;
            for (int i = 0; i < visibleItems.size(); i++)
            {
                int price =  Integer.parseInt(visibleItems.get(i).getPrice());
                int count = Integer.parseInt(visibleItems.get(i).getCount());
                totalsum = totalsum + (price*count);
            }

        String url = "http://ykh3587.dothome.co.kr/total_sum.php";
        String name = visibleItems.get(position).getname();
        String price =  visibleItems.get(position).getPrice();
        String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        ContentValues values = new ContentValues();
        values.put("local", local);
        values.put("foodname", name);
        values.put("foodprice", price);
        values.put("totalsum", totalsum);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

    }

    static class ParentItemVH extends RecyclerView.ViewHolder {
        TextView name, delete, price, count, order_detail;
        Button count_up, count_down;
        TableRow totalsum_table;

        ParentItemVH(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.order_name);
            delete = itemView.findViewById(R.id.delete_order);
            count_up = itemView.findViewById(R.id.count_up);
            count_down = itemView.findViewById(R.id.count_down);
            price = itemView.findViewById(R.id.order_price);
            count = itemView.findViewById(R.id.count_number);
            order_detail = itemView.findViewById(R.id.order_detail);
        }
    }

    //아이템을 한개 추가해주고싶을때
    public  void addItem(PurchaseItem item){
        visibleItems.add(item);
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

            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
