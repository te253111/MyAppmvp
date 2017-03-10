package com.example.zlink.myappmvp.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.di.DaggerDetailcomponent;
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.di.DaggerAppComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailFragment extends Fragment implements DetailContract.View {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private listeners listeners;

    public static interface listeners{
        void GoBack();
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
    public void Showresult(DataUser dataUser) {

    }

    @Override
    public void GoBack() {
        listeners.GoBack();
    }


    @OnClick({R.id.btn_detail,R.id.btn_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btn_detail :
                presenter.OnDetailButtonclick();
                break;
            case R.id.btn_back :
                presenter.GoBack();
                break;
        }
    }


}
