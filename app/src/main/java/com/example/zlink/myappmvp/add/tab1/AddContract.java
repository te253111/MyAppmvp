package com.example.zlink.myappmvp.add.tab1;

import com.example.zlink.myappmvp.Base.BasePresenter;
import com.example.zlink.myappmvp.add.model.Hobby;

/**
 * Created by Zlink on 14/3/2560.
 */

public interface AddContract {
        interface View {
            void showstatus(String mess);
        }

        interface Presenter extends BasePresenter<View> {
            void prepareDatatosave(Hobby hobby);
        }
}
