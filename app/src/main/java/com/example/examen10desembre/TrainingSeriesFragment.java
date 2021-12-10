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

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainingSeriesFragment extends ListFragment {

    private ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    private SimpleAdapter adapter;
    private Integer[] images = {R.drawable.lift,R.drawable.pushup,R.drawable.run,R.drawable.small_lift};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HashMap<String, String> map=new HashMap<String, String>();
        for(int i= 0; i<Entrenament.entrenaments.length;i++){
            map=new HashMap<String,String>();
            map.put("Exercise",Entrenament.entrenaments[i].getNom());
            map.put("Image",Integer.toString(images[i]));
            data.add(map);
        }
        String[] from={"Exercise","Image"};
        int[] to={R.id.textView,R.id.imageView};
        adapter=new SimpleAdapter(getActivity(), data, R.layout.listview, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        getListView().setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Title",Entrenament.entrenaments[pos].getNom());
                    bundle.putString("Description",Entrenament.entrenaments[pos].getDescripcio());
                    bundle.putInt("Image",images[pos]);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentInfoView, TrainingInfoFragment.class, bundle)
                            .setReorderingAllowed(true)
                            .commit();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("Title", Entrenament.entrenaments[pos].getNom());
                    bundle.putString("Description", Entrenament.entrenaments[pos].getDescripcio());
                    bundle.putInt("Image", images[pos]);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, TrainingInfoFragment.class, bundle)
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
