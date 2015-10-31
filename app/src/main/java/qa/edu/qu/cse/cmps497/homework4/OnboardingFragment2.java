package qa.edu.qu.cse.cmps497.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Nezar Saleh on 10/31/2015.
 */

public class OnboardingFragment2 extends Fragment {
    TextView tf_title;
    TextView tf_content;
    TextView tf_link;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.custom_list
                ,
                container,
                false
        );
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tf_title = (TextView) view.findViewById(R.id.tf_title);
        tf_content = (TextView) view.findViewById(R.id.tf_content);
             tf_link = (TextView) view.findViewById(R.id.tf_link);




        Bundle bundle = OnboardingFragment2.this.getArguments();
        if (bundle != null) {
            String titel = bundle.getString("Title");
            System.out.println("hhhhhhhhhhhhhhhhhhhh" + titel);

        }


    }
}
