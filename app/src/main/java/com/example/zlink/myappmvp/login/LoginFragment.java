package com.example.zlink.myappmvp.login;

import android.content.Context;
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
import com.example.zlink.myappmvp.di.DaggerAppComponent;
import com.example.zlink.myappmvp.login.di.DaggerLoginComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends Fragment implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.Edit_user)
    EditText EditUser;
    @BindView(R.id.Edit_pass)
    EditText EditPass;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.txt_resultstatus)
    TextView txtResultstatus;
    private String mParam1;



    private  listeners listeners;


    public static interface listeners{
        void GotoPageDetail();

    }

    public LoginFragment() {

    }

    public static LoginFragment newInstance(String param1) {
        LoginFragment fragment = new LoginFragment();
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

        DaggerLoginComponent.builder()
                .appComponent(DaggerAppComponent.create())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
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
            listeners=(listeners)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void Showresultstatus(String result) {
        txtResultstatus.setText(result);
    }

    @Override
    public void GotoPageDetail() {
        listeners.GotoPageDetail();
    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                presenter.OnloginButtonclick(EditUser.getText().toString(),EditPass.getText().toString());
                break;
        }
    }
}
