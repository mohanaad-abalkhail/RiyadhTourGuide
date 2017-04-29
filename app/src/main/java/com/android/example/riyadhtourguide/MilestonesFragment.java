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
public class MilestonesFragment extends Fragment {


    public MilestonesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);


        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.milestone1_name, R.string.milestone1_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone2_name, R.string.milestone2_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone3_name, R.string.milestone3_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone4_name, R.string.milestone4_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone5_name, R.string.milestone5_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone6_name, R.string.milestone6_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone7_name, R.string.milestone7_Info, R.mipmap.milestone));
        items.add(new Item(R.string.milestone8_name, R.string.milestone8_Info, R.mipmap.milestone));

        ItemAddapter Adapter = new ItemAddapter(getActivity(), items, R.color.milestones_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(Adapter);
        return rootView;
    }

}
