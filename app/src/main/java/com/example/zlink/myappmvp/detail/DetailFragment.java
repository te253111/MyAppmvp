package com.example.zlink.myappmvp.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.adapter.DetailAdapter;
import com.example.zlink.myappmvp.detail.di.DaggerDetailcomponent;
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.di.DaggerAppComponent;
import com.example.zlink.myappmvp.login.LoginFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment implements DetailContract.View,DetailAdapter.Listener {
    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.recycleview)
    RecyclerView recycleview;


    listeners listeners;


    public interface listeners{
        void GotoPageProfile(DataUser dataUser);
    }


    private String mParam1;
    private List<DataUser> users;

    @Override
    public void onItemClicked(DataUser clickedItem) {
        listeners.GotoPageProfile(clickedItem);
    }

    @Override
    public void Showdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Test")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         builder.show();
    }


    @Inject
    DetailContract.Presenter presenter;

    public DetailFragment() {

    }

    public static DetailFragment newInstance(String param1) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }


        DaggerDetailcomponent.builder()
                .appComponent(DaggerAppComponent.create())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.getDataUser();
        onInitInstances();
    }

    private void onInitInstances() {
        DetailAdapter adapter = new DetailAdapter(users,this,getContext());
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof listeners){
            listeners = (listeners) context;
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void SetDataUser(List<DataUser> userList) {
        users = userList;
    }


}
