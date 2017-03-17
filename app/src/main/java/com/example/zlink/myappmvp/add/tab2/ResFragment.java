package com.example.zlink.myappmvp.add.tab2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.add.model.Hobby;
import com.example.zlink.myappmvp.add.tab2.di.DaggerResComponent;
import com.example.zlink.myappmvp.di.DaggerAppComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ResFragment extends Fragment implements ResContract.View {


    @Inject
    ResContract.Presenter presenter;
    @BindView(R.id.txt_res_cook)
    TextView txtResCook;
    @BindView(R.id.txt_res_sport)
    TextView txtResSport;
    @BindView(R.id.txt_res_game)
    TextView txtResGame;
    @BindView(R.id.txt_res_watch)
    TextView txtResWatch;


    public ResFragment() {

    }

    public static ResFragment newInstance(String param1, String param2) {
        ResFragment fragment = new ResFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerResComponent.builder()
                .appComponent(DaggerAppComponent.create())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_res, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.prepareDatatoshow();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showdata(Hobby hobby) {
        if(hobby != null && hobby.getCook()!=null){
            txtResCook.setText("cook : "+hobby.getCook());
            txtResSport.setText("sport : "+hobby.getSport());
            txtResGame.setText("game : "+hobby.getGame());
            txtResWatch.setText("watch : "+hobby.getWatch());
        }
    }
}
