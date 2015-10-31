package qa.edu.qu.cse.cmps497.homework4;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import qa.edu.qu.cse.cmps497.homework4.fragments.DetailsFragment;
public class DetailsActiveity extends Activity {
    TextView tf_title;
    TextView tf_content;
    TextView tf_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activeity);
        tf_title = (TextView)findViewById(R.id.tf_title);
        tf_content = (TextView)findViewById(R.id.tf_content);
        tf_link = (TextView)findViewById(R.id.tf_link);
        String titel;
        String body;
        String link;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                titel= null;
                body= null;
                link= null;

            } else {
                titel= extras.getString("Titel");
                body= extras.getString("Body");
                link= extras.getString("Link");
            }
        } else {
            titel= (String) savedInstanceState.getSerializable("Titel");
            body= (String) savedInstanceState.getSerializable("Body");
            link= (String) savedInstanceState.getSerializable("Link");
        }
        tf_title.setText(titel);
        tf_content.setText(body);
        tf_link.setText(link);
    }
}
