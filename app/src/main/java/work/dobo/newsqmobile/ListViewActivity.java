package work.dobo.newsqmobile;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends AppCompatActivity {
    ListView listView = null;

    class Item {
        int subnews_img;
        String subnews_title;
        int publisher_img;
        String publisher_name;
        String publisher_info;
        Item(int subnews_img, String subnews_title,int publisher_img, String publisher_name, String publisher_info){
            this.subnews_img = subnews_img;
            this.publisher_img = publisher_img;
            this.subnews_title = subnews_title;
            this.publisher_name = publisher_name;
            this.publisher_info = publisher_info;
        }
    }
    ArrayList<Item> itemList = new ArrayList<Item>();
    class ItemAdapter extends ArrayAdapter{
        // getView가 호출되면 position 가져온다.
        //있으면 그냥 내용만 바꿔주고 없으면 그려준다.
        // inflater xml 로 정의된 것들을 객체화하여 convertview에 넣어준다.
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.list_item_sml, null);
            }
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.subnews_img);
            ImageView imageView2 = (ImageView) convertView.findViewById(R.id.publisher_img);
            TextView text1View = (TextView) convertView.findViewById(R.id.subnews_title);
            TextView text2View = (TextView) convertView.findViewById(R.id.publisher_name);
            TextView text3View = (TextView) convertView.findViewById(R.id.publisher_info);

            Item item = itemList.get(position);
            imageView1.setImageResource(item.subnews_img);
            imageView2.setImageResource(item.publisher_img);
            text1View.setText(item.subnews_title);
            text2View.setText(item.publisher_name);
            text3View.setText(item.publisher_info);
            return convertView;
        }

        public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

    }
    ItemAdapter itemAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.list_item_cate);




        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listview);

        //데이터 넣기.
        itemList.add(new Item(R.drawable.trump,"Title01",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title02",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title03",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title04",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title05",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title06",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title07",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title08",R.drawable.trump,"Title01","Text0101"));
        itemList.add(new Item(R.drawable.trump,"Title09",R.drawable.trump,"Title01","Text0101"));
        //어댑터 설정
        itemAdapter = new ItemAdapter(ListViewActivity.this, R.layout.list_item_sml, itemList);
        listView.setAdapter(itemAdapter);
        //기본
        /*String[] items = {"items1", "items2","items3","items4","items5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1, items);*/




    }
}
