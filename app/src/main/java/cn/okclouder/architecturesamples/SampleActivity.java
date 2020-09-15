package cn.okclouder.architecturesamples;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.databinding.ActivitySampleMvvmBinding;
import cn.okclouder.architecturesamples.model.SampleModel;
import cn.okclouder.architecturesamples.viewmodel.SampleViewModel;

/**
 * @author caoshen
 * @date 2020/9/14
 */
public class SampleActivity extends AppCompatActivity {

    private Button mButton;

    private EditText mEditText;

    private SampleViewModel mSampleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySampleMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sample_mvvm);
        mSampleViewModel = new SampleViewModel(binding);

        mEditText = findViewById(R.id.edit_text_user_info);
        mButton = findViewById(R.id.btn_get_user_info);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSampleViewModel.getUserInfo(mEditText.getText().toString(), new Callback1<SampleModel.UserInfo>() {
                    @Override
                    public void onCallback(SampleModel.UserInfo userInfo) {
                        mSampleViewModel.viewDataBinding.setUser(userInfo);
                    }
                });
            }
        });
    }

}
