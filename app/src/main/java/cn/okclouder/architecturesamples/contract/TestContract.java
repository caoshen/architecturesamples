package cn.okclouder.architecturesamples.contract;

import android.view.ActionMode;

import cn.okclouder.architecturesamples.callback.Callback;
import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.callback.Callback2;
import cn.okclouder.architecturesamples.callback.Callback3;
import cn.okclouder.architecturesamples.model.BaseModel;
import cn.okclouder.architecturesamples.presenter.BasePresenter;
import cn.okclouder.architecturesamples.view.BaseView;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public class TestContract {

    interface Model extends BaseModel {

        void getData1(Callback1 callback11);

        void getData2(Callback2 callback2);

        void getData3(Callback3 callback3);
    }

    interface View extends BaseView {

        void updateUi1();

        void updateUi2();

        void updateUi3();
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        abstract void request1();

        abstract void request2();

        void request3() {
            mModel.getData3(new Callback3() {
                @Override
                public void onResult(Object o, Object o2, Object o3) {
                    mView.updateUi3();
                }
            });
        }
    }
}
