package cn.okclouder.architecturesamples.model;

import com.google.gson.Gson;

import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.http.HttpUtil;

/**
 * @author caoshen
 * @date 2020/9/14
 */
public class SampleModel implements BaseModel {

    public void getUserInfo(String uid, Callback1<UserInfo> callback) {
        String json = new HttpUtil().get(uid);
        UserInfo userInfo = new Gson().fromJson(json, UserInfo.class);
        callback.onCallback(userInfo);
    }

    @Override
    public void onDestroy() {

    }

    public static class UserInfo {
        private int age;

        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
