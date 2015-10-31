package qa.edu.qu.cse.cmps497.homework4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Eng Gadala on 10/30/2015.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomTitle extends ArrayAdapter<String> {
    //decleration variables
    private final Activity context;
    private final String[]title;
       //constructor
    public CustomTitle(Activity context, String[] title) {
        super(context, R.layout.titel_viw,title);
        this.context=context;
        this.title=title ;
           }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView =inflater.inflate( R.layout.titel_viw,null,true);
        //connect item to xml withe rowView and inflater
        TextView titlee = (TextView)rowView.findViewById(R.id.tf_titlee);
              //initializations
        titlee.setText(title[position]);
              return rowView;
    }
}
