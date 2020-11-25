package com.norada.noradaava_3csb_se3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] collegeNames = {"Inst. of Information and Computing Sciences", "Faculty of Engineering", "College of Architecture"};
    String[] patronSaint = {"St. Vincent Ferrer", "Blessed Jordan of Saxony", "Jordan the Apostle"};
    String[] foundedDate = {"Founded in 2014", "Founded 1907", "Founded 1930"};
    int[] collegeIcons = {R.drawable.iics, R.drawable.eng, R.drawable.arki};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView =findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, collegeNames, patronSaint, foundedDate, collegeIcons);
        listView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rCollegeNames[];
        String rPatronSaint[];
        String rFoundedDate[];
        int rCollegeIcons[];

        MyAdapter(Context c, String cNames[], String pSaint[], String fDate[], int cIcons[]){
            super(c, R.layout.row, R.id.collegeName, cNames);
            this.context= c;
            this.rCollegeNames = cNames;
            this.rPatronSaint = pSaint;
            this.rFoundedDate = fDate;
            this.rCollegeIcons = cIcons;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.row, parent, false);
            ImageView imgView = row.findViewById(R.id.collegeIcon);
            TextView tvNames = row.findViewById(R.id.collegeName);
            TextView tvSaint = row.findViewById(R.id.patronSaint);
            TextView tvDate = row.findViewById(R.id.foundedDate);

            imgView.setImageResource(rCollegeIcons[position]);
            tvNames.setText(rCollegeNames[position]);
            tvSaint.setText(rPatronSaint[position]);
            tvDate.setText(rFoundedDate[position]);

            return row;
        }
    }
}