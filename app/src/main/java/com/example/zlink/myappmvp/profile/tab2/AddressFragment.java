package com.example.zlink.myappmvp.profile.tab2;

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
import com.example.zlink.myappmvp.profile.tab2.di.DaggerAddresscomponent;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressFragment extends Fragment implements AddressContract.View {
    private static final String ARG_PARAM1 = "DataUser";
    @BindView(R.id.txt_address_no)
    TextView txtAddressNo;
    @BindView(R.id.txt_address_state)
    TextView txtAddressState;
    @BindView(R.id.txt_address_contry)
    TextView txtAddressContry;
    @BindView(R.id.btn_profile_back)
    Button btnProfileBack;


    private DataUser dataUser;

    @Inject
    AddressContract.Presenter presenter;


    private listeners listeners;


    public interface listeners {
        void GpBack();
    }


    public AddressFragment() {

    }


    public static AddressFragment newInstance(DataUser dataUser) {
        AddressFragment fragment = new AddressFragment();
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
        DaggerAddresscomponent.builder()
                .appComponent(DaggerAppComponent.create())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);
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
        if (dataUser != null) {
            txtAddressNo.setText("No : " + dataUser.getNo());
            txtAddressState.setText("State : " + dataUser.getState());
            txtAddressContry.setText("Contry :" + dataUser.getContry());
        }
    }

    @OnClick(R.id.btn_profile_back)
    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_profile_back:
                listeners.GpBack();
                break;
        }
    }
}
