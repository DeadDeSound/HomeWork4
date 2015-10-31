package qa.edu.qu.cse.cmps497.homework4;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
//decleration variables
    private final Activity context;
    private final String[]title;
    private final String[]sup_title;
    private final String[]linkUrl;
       //constructor
        public CustomListAdapter(Activity context, String[] title, String[] bodyOfSubject, String[] linkUrl) {
        super(context, R.layout.custom_list,title);
        this.context=context;
        this.title=title  ;
        this.sup_title=bodyOfSubject;
        this.linkUrl=linkUrl;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView =inflater.inflate( R.layout.custom_list,null,true);

        //connect item to xml withe rowView and inflater
        TextView titlee = (TextView)rowView.findViewById(R.id.tf_title);
        TextView supTitle= (TextView)rowView.findViewById(R.id.tf_content);
        TextView linKL= (TextView)rowView.findViewById(R.id.tf_link);

        //initializations
        titlee.setText(title[position]);
        supTitle.setText(sup_title[position]);
        linKL.setText(linkUrl[position]);
        return rowView;
    }
}
