package com.example.zlink.myappmvp.profile;

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
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.di.DaggerAppComponent;
import com.example.zlink.myappmvp.profile.di.DaggerProfilecomponent;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment implements ProfileContract.View {
    private static final String ARG_PARAM1 = "DataUser";
    @BindView(R.id.txt_profile_id)
    TextView txtProfileId;
    @BindView(R.id.txt_profile_name)
    TextView txtProfileName;
    @BindView(R.id.txt_profile_age)
    TextView txtProfileAge;
    @BindView(R.id.txt_profile_date)
    TextView txtProfileDate;
    @BindView(R.id.btn_profile_back)
    Button btnProfileBack;

    private DataUser dataUser;

    @Inject
    ProfileContract.Presenter presenter;


    private listeners listeners;


    public interface listeners {
        void GpBack();
    }


    public ProfileFragment() {

    }


    public static ProfileFragment newInstance(DataUser dataUser) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, Parcels.wrap(dataUser));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataUser = Parcels.unwrap(getArguments().getParcelable(ARG_PARAM1));
        }
        DaggerProfilecomponent.builder()
                .appComponent(DaggerAppComponent.create())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.Preparedata(dataUser);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof listeners)
            listeners = (listeners) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void ShowDataUser(DataUser dataUser) {
        txtProfileId.setText("Id : " + dataUser.getId());
        txtProfileName.setText("Name : " + dataUser.getName());
        txtProfileAge.setText("Age :" + dataUser.getAge());
        txtProfileDate.setText("Date :" + dataUser.getDate());
    }

    @OnClick(R.id.btn_profile_back)
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.btn_profile_back :
                listeners.GpBack();
                break;
        }
    }
}
