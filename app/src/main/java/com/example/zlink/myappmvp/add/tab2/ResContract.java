package com.example.zlink.myappmvp.add.tab2;

import com.example.zlink.myappmvp.Base.BasePresenter;
import com.example.zlink.myappmvp.add.model.Hobby;

/**
 * Created by Zlink on 14/3/2560.
 */

public interface ResContract {
        interface View {
            void showdata(Hobby hobby);
        }

        interface Presenter extends BasePresenter<ResContract.View> {
            void prepareDatatoshow();
        }
}
