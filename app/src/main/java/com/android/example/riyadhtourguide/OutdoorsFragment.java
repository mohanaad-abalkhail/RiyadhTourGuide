package com.android.example.riyadhtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutdoorsFragment extends Fragment {


    public OutdoorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);


        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.outdoor1_name, R.string.outdoor1_Info, R.mipmap.thumamh));
        items.add(new Item(R.string.outdoor2_name, R.string.outdoor2_Info, R.mipmap.khfs));
        items.add(new Item(R.string.outdoor3_name, R.string.outdoor3_Info, R.mipmap.khuraym));
        items.add(new Item(R.string.outdoor4_name, R.string.outdoor4_Info, R.mipmap.tnhat));
        items.add(new Item(R.string.outdoor5_name, R.string.outdoor5_Info, R.mipmap.dhna));

        ItemAddapter Adapter = new ItemAddapter(getActivity(), items, R.color.outdoors_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(Adapter);
        return rootView;
    }

}
