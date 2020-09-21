package cn.okclouder.architecturesamples.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public class NameViewModel extends ViewModel {

    private MutableLiveData<String> currentName;

    private LiveData<User> userLiveData = new MutableLiveData<>();

    /**
     * LiveData transformations. Transform a live data value to another live data value
     */
    private LiveData<String> userName = Transformations.map(userLiveData, new Function<User, String>() {
        @Override
        public String apply(User input) {
            return input.name + " " + input.lastName;
        }
    });

    LiveData<String> userId = new MutableLiveData<>();

    /**
     * LiveData transformations. return a live data
     */
    LiveData<User> user = Transformations.switchMap(userId, new Function<String, LiveData<User>>() {
        @Override
        public LiveData<User> apply(String input) {
            return getUser(input);
        }
    });

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }

    private LiveData<User> getUser(String id) {
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        User user = new User();
        user.id = id;
        userMutableLiveData.setValue(user);
        return userMutableLiveData;
    }
}
