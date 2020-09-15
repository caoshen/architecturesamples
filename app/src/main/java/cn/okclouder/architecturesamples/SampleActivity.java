package cn.okclouder.architecturesamples;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.model.SampleModel;

/**
 * @author caoshen
 * @date 2020/9/14
 */
public class SampleActivity extends AppCompatActivity {

    private SampleModel mSampleModel;

    private Button mButton;

    private EditText mEditText;

    private TextView mTextAge;

    private TextView mTextName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        mEditText = findViewById(R.id.edit_text_user_info);
        mButton = findViewById(R.id.btn_get_user_info);
        mTextAge = findViewById(R.id.text_view_age);
        mTextName = findViewById(R.id.text_view_name);

        mSampleModel = new SampleModel();

        // View to Controller
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfo(mEditText.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSampleModel.onDestroy();
    }

    private void getUserInfo(String uid) {
        // Controller to Model
        mSampleModel.getUserInfo(uid, new Callback1<SampleModel.UserInfo>() {
            @Override
            public void onCallback(SampleModel.UserInfo userInfo) {
                setDataToView(userInfo);
            }
        });
    }

    private void setDataToView(SampleModel.UserInfo userInfo) {
        // Model to View
        mTextAge.setText(String.valueOf(userInfo.getAge()));
        mTextName.setText(userInfo.getName());
    }
}
