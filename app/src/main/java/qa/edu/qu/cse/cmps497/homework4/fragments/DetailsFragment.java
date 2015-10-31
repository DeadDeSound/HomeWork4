package qa.edu.qu.cse.cmps497.homework4.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qa.edu.qu.cse.cmps497.homework4.R;


/**
 * Created by Eng Gadala on 10/29/2015.
 */
public class DetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */

        return inflater.inflate(
                R.layout.custom_list, container, true);
        //

}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = DetailsFragment.this.getArguments();
        if (bundle != null) {
            String titel = bundle.getString("Title");
            System.out.println("hhhhhhhhhhhhhhhhhhhh"+titel);
        }
    }
}
