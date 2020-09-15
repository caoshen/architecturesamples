package cn.okclouder.architecturesamples;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.okclouder.architecturesamples.callback.Callback1;
import cn.okclouder.architecturesamples.contract.SampleContract;
import cn.okclouder.architecturesamples.model.SampleModel;

/**
 * @author caoshen
 * @date 2020/9/14
 */
public class SampleActivity extends AppCompatActivity implements SampleContract.View {

    private Button mButton;

    private EditText mEditText;

    private TextView mTextAge;

    private TextView mTextName;
    private SampleContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        mEditText = findViewById(R.id.edit_text_user_info);
        mButton = findViewById(R.id.btn_get_user_info);
        mTextAge = findViewById(R.id.text_view_age);
        mTextName = findViewById(R.id.text_view_name);

        setPresenter(new SampleContract.Presenter());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getUserInfo(mEditText.getText().toString(), new Callback1<SampleModel.UserInfo>() {
                    @Override
                    public void onCallback(SampleModel.UserInfo userInfo) {
                        setDataToView(userInfo);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void setPresenter(SampleContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setDataToView(SampleModel.UserInfo userInfo) {
        mTextAge.setText(String.valueOf(userInfo.getAge()));
        mTextName.setText(userInfo.getName());
    }
}
