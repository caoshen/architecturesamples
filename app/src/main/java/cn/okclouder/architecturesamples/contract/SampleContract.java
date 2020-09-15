package cn.okclouder.architecturesamples.contract;

import com.google.gson.Gson;

import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.http.HttpUtil;
import cn.okclouder.architecturesamples.model.SampleModel;
import cn.okclouder.architecturesamples.presenter.BasePresenter;
import cn.okclouder.architecturesamples.view.BaseView;

/**
 * @author caoshen
 * @date 2020/9/15
 */
public class SampleContract {
    public static class Presenter implements BasePresenter {

        @Override
        public void onDestroy() {

        }

        public void getUserInfo(String uid, Callback1<SampleModel.UserInfo> callback) {
            String json = new HttpUtil().get(uid);
            SampleModel.UserInfo userInfo = new Gson().fromJson(json, SampleModel.UserInfo.class);
            callback.onCallback(userInfo);
        }
    }

    public interface View extends BaseView<Presenter> {
        void setDataToView(SampleModel.UserInfo userInfo);
    }
}
