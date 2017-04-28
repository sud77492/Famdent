package com.actiknow.famdent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actiknow.famdent.R;
import com.actiknow.famdent.adapter.ExhibitorAdapter;
import com.actiknow.famdent.model.Exhibitor;
import com.actiknow.famdent.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MyFavouriteExhibitorFragment extends Fragment {
    RecyclerView rvExhibitorServices;
    SwipeRefreshLayout swipeRefreshLayout;
    List<Exhibitor> exhibitorList= new ArrayList<>();
    ExhibitorAdapter exhibitorServiceAdapter;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate (R.layout.fragment_my_favourite_exhibitor, container, false);
        initView (rootView);
        initData ();
        initListener ();
        return rootView;
    }

    private void initView(View rootView) {
        rvExhibitorServices=(RecyclerView)rootView.findViewById(R.id.rvExhibitorList);
        swipeRefreshLayout=(SwipeRefreshLayout)rootView.findViewById(R.id.swipeRefreshLayout);
    }

    private void initData() {
        exhibitorList.add(new Exhibitor (1,"","3M ESPE","Hall 1","Stall 28"));
        exhibitorList.add(new Exhibitor(2,"","DENTSPLY SIRONA","Hall 1","Stall 31"));
        exhibitorList.add(new Exhibitor(3, "","DUERR DENTEL INDIA","Hall 1","Stall 45"));
        exhibitorList.add(new Exhibitor(4, "","UNICORN DENMART","Hall 1","Stall 29"));
        exhibitorList.add(new Exhibitor(5, "","CAPRI","Hall 1","Stall 38"));
        exhibitorList.add(new Exhibitor(6, "","ACETON INDIA","Hall 1","Stall 17"));
        exhibitorList.add(new Exhibitor(7, "","SKANRAY TECHNOLOGY","Hall 1","Stall 32"));

        exhibitorServiceAdapter = new ExhibitorAdapter (getActivity(), exhibitorList);
        rvExhibitorServices.setAdapter (exhibitorServiceAdapter);
        rvExhibitorServices.setHasFixedSize (true);
        rvExhibitorServices.setLayoutManager (new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvExhibitorServices.addItemDecoration (new SimpleDividerItemDecoration (getActivity()));
        rvExhibitorServices.setItemAnimator (new DefaultItemAnimator());
    }

    private void initListener() {
        swipeRefreshLayout.setOnRefreshListener (new SwipeRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh () {
                swipeRefreshLayout.setRefreshing (false);
            }
        });
    }
}