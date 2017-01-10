package com.winthan.ybs.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winthan.ybs.R;
import com.winthan.ybs.adapters.BusAdapter;
import com.winthan.ybs.data.Bus;
import com.winthan.ybs.data.BusDatabaseHandler;
import com.winthan.ybs.data.BusModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends Fragment {

    @BindView(R.id.rv_buses)
    RecyclerView rvBuses;

    private List<Bus> busList;

    private BusAdapter mAdapter;

    public BusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus, container, false);
        ButterKnife.bind(this,view);

        BusDatabaseHandler db = new BusDatabaseHandler(getActivity());
        busList = db.getAllBuses();

        if (busList.size() <= 0){
            BusModel.getInstance().addData();
            busList = db.getAllBuses();
        }

        rvBuses.setHasFixedSize(true);
        rvBuses.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBuses.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new BusAdapter(busList);
        rvBuses.setAdapter(mAdapter);

        return view;
    }

}