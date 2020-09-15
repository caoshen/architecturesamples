package cn.okclouder.architecturesamples.viewmodel;

import androidx.databinding.ViewDataBinding;

import com.google.gson.Gson;

import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.databinding.ActivitySampleMvvmBinding;
import cn.okclouder.architecturesamples.http.HttpUtil;
import cn.okclouder.architecturesamples.model.SampleModel;

/**
 * @author caoshen
 * @date 2020/9/15
 */
public class SampleViewModel extends AbstractViewModel<ActivitySampleMvvmBinding> {

    public SampleViewModel(ActivitySampleMvvmBinding viewDataBinding) {
        super(viewDataBinding);
    }

    public void getUserInfo(String uid, Callback1<SampleModel.UserInfo> callback) {
        String json = new HttpUtil().get(uid);
        SampleModel.UserInfo userInfo = new Gson().fromJson(json, SampleModel.UserInfo.class);
        callback.onCallback(userInfo);
    }
}
