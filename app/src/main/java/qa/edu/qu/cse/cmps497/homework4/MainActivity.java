package qa.edu.qu.cse.cmps497.homework4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.view.ViewPager;

import org.json.JSONArray;

import qa.edu.qu.cse.cmps497.homework4.fragments.DetailsFragment;
import qa.edu.qu.cse.cmps497.homework4.model.JsonExtract;

import static qa.edu.qu.cse.cmps497.homework4.model.JsonExtract.getFeed;

public class MainActivity extends FragmentActivity {
    String[] titelArry;
    String[] bodyArry;
    String[] linkArry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // chick if the screen is landscape or porterate
        setContentView(R.layout.activity_main);

        Configuration config = getResources().getConfiguration();

        /**
         * Check the device orientation and act accordingly
         */


        if (config.screenLayout != Configuration.SCREENLAYOUT_SIZE_LARGE) {


            Toast.makeText(MainActivity.this, "7  inch", Toast.LENGTH_SHORT).show();


            //
            populatelistViewTitale();
            final ListView lv = (ListView) findViewById(R.id.listview);
            final DetailsFragment detailsFragment = new DetailsFragment();


            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {


                    String title = titelArry[myItemInt];
                    String body = bodyArry[myItemInt];
                    String  link = linkArry[myItemInt];
//                    FragmentTransaction ft = getFragmentManager()
//                            .beginTransaction();

                    ViewPager pager = (ViewPager) findViewById(R.id.frame_tablet);
//
//                    ft.replace(R.id.frame_tablet, detailsFragment);
//                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                    TextView tf_title = (TextView)findViewById(R.id.tf_title);
//                    TextView tf_content = (TextView)findViewById(R.id.tf_content);
//                    TextView tf_link = (TextView)findViewById(R.id.tf_link);
//
//                    tf_title.setText(title);
//                    tf_content.setText(body);
//                    tf_link.setText(link);
//
//                    ft.commit();




                    FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                        @Override
                        public Fragment getItem(int position) {

                            return new OnboardingFragment2();


                        }

                        @Override
                        public int getCount() {
                            return 1;
                        }
                    };


                    pager.setAdapter(adapter);



                    //

                }
            });


        } else {


            Toast.makeText(MainActivity.this, "Hi Mobile", Toast.LENGTH_SHORT).show();

            // landscape tablet mode

            populatelistViewTitale();
            final ListView lv = (ListView) findViewById(R.id.listview);
            final DetailsFragment detailsFragment = new DetailsFragment();

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                    String title = titelArry[myItemInt];
                    String body = bodyArry[myItemInt];
                    String link = linkArry[myItemInt];
                    //------------------------
                    Intent i = new Intent(MainActivity.this, DetailsActiveity.class);
                    String keyIdentifer = null;
                    i.putExtra("Titel", title);
                    i.putExtra("Body", body);
                    i.putExtra("Link", link);
                    startActivity(i);
                }


            });


        }
    }

    private void populatelistViewTitale() {
        // create list of item
        JSONArray jsonObject;
        jsonObject = getFeed(this, R.raw.nytimes);
        titelArry = JsonExtract.extractTitles(jsonObject);
        bodyArry = JsonExtract.extractAbstracts(jsonObject);
        linkArry = JsonExtract.extractLinks(jsonObject);
        //suild adapter
        CustomTitle adaptertitle = new CustomTitle(this, titelArry);
        // configure the list view
        ListView list = (ListView) findViewById(R.id.listview);
        list.setAdapter(adaptertitle);
    }
}
