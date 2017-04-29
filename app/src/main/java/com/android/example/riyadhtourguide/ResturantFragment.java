package com.android.example.riyadhtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResturantFragment extends Fragment {


    public ResturantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);


        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.restaurant1_name, R.string.restaurant1_Info, R.mipmap.resturant1));
        items.add(new Item(R.string.restaurant2_name, R.string.restaurant2_Info, R.mipmap.bbq));
        items.add(new Item(R.string.restaurant3_name, R.string.restaurant3_Info, R.mipmap.resturant1));
        items.add(new Item(R.string.restaurant4_name, R.string.restaurant4_Info, R.mipmap.shawrma));
        items.add(new Item(R.string.restaurant5_name, R.string.restaurant5_Info, R.mipmap.breakfest));
        items.add(new Item(R.string.restaurant6_name, R.string.restaurant6_Info, R.mipmap.resturant1));

        ItemAddapter Adapter = new ItemAddapter(getActivity(), items, R.color.restaurant_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(Adapter);
        return rootView;
    }

}
