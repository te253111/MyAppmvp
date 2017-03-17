package com.example.zlink.myappmvp.add.tab1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.add.model.Hobby;
import com.example.zlink.myappmvp.add.tab1.di.DaggerAddComponent;
import com.example.zlink.myappmvp.di.DaggerAppComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddFragment extends Fragment implements AddContract.View {


    @Inject
    AddContract.Presenter presenter;
    @BindView(R.id.edt_cook)
    EditText edtCook;
    @BindView(R.id.edt_sport)
    EditText edtSport;
    @BindView(R.id.edt_game)
    EditText edtGame;
    @BindView(R.id.edt_watch)
    EditText edtWatch;
    @BindView(R.id.btn_add_save)
    Button btnAddSave;
    @BindView(R.id.txt_add_resualt)
    TextView txtAddResualt;


    Hobby hobby = new Hobby();

    public AddFragment() {

    }

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerAddComponent.builder()
                .appComponent(DaggerAppComponent.create())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showstatus(String mess) {
        txtAddResualt.setText(mess);

    }


    @OnClick(R.id.btn_add_save)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_save:
                hobby.setCook(edtCook.getText().toString());
                hobby.setGame(edtGame.getText().toString());
                hobby.setSport(edtSport.getText().toString());
                hobby.setWatch(edtWatch.getText().toString());
                presenter.prepareDatatosave(hobby);
                break;
        }
    }



}
