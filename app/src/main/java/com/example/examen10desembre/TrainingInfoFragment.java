package com.example.examen10desembre;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainingInfoFragment extends ListFragment {
    private ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    private SimpleAdapter adapter;
    private Integer[] images = {R.drawable.lift,R.drawable.pushup,R.drawable.run,R.drawable.small_lift};
    private static Bundle bundlerino;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            HashMap map = new HashMap<String, String>();
            map.put("Exercise", bundle.getString("Title"));
            map.put("Description", bundle.getString("Description"));
            map.put("Image", Integer.toString(bundle.getInt("Image")));
            data.add(map);
            String[] from = {"Exercise", "Description", "Image"};
            int[] to = {R.id.textView1, R.id.textView2, R.id.imageView1};
            adapter = new SimpleAdapter(getActivity(), data, R.layout.training, from, to);
            setListAdapter(adapter);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, TrainingSeriesFragment.class, null)
                            .setReorderingAllowed(true)
                            .commit();
                }
            }
        });
    }


    static interface Listener {
        void itemClicked(long id);
    };
}
