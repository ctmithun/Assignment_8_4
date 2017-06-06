package com.billionman.com.assignment_8_4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageAdapter ima = new ImageAdapter(this, buildData(images.length));
        GridView gv = (GridView) findViewById(R.id.gview);
        gv.setAdapter(ima);
    }

    class ImageAdapter extends BaseAdapter {
        List<ImageData> imagesData;

        Context imgContext;

        // Constructor
        public ImageAdapter(Context c, List<ImageData> imgData) {
            this.imgContext = c;
            this.imagesData = imgData;
        }

        @Override
        public int getCount() {
            return imagesData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View v = new View(imgContext);
            v = inflater.inflate(R.layout.image_view,null);
            if(convertView == null) {
                ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
                TextView tv = (TextView) v.findViewById(R.id.textView);
                GridView gv = (GridView) v.findViewById(R.id.gview);
//                imageView.setLayoutParams(new LayoutParams(350, 350));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
                imageView.setImageResource(imagesData.get(position).getImageId());
                tv.setText(imagesData.get(position).getDescription());
            } else {
                v = convertView;
            }
            return v;
        }


    }

    private List<ImageData> buildData(int size) {
        List<ImageData> imagesData = new ArrayList<>(size);
        for(int i =1; i<= size;i++) {
            ImageData img = new ImageData();
            img.setImageId(images[i-1]);
            img.setDescription(titles[i-1]);
            imagesData.add(img);
        }
        return imagesData;
    }

    public Integer[] images = {
            R.drawable.img_gingerbread, R.drawable.img_honeycomb,
            R.drawable.img_icecream, R.drawable.img_jellybean,
            R.drawable.img_kitkat, R.drawable.img_lollipop
    };

    public String[] titles = {
            "gingerbread", "honeycomb",
            "icecream", "jellybean",
            "kitkat", "lollipop"
    };
}
