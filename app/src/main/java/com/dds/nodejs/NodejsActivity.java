package com.dds.nodejs;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.dds.webrtc.R;


/**
 * Created by dds on 2018/11/7.
 * android_shuai@163.com
 */
public class NodejsActivity extends AppCompatActivity {
    private EditText et_signal;
    private EditText et_room;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodejs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initVar();

    }

    private void initView() {
        et_signal = findViewById(R.id.et_signal);
        et_room = findViewById(R.id.et_room);
    }


//        et_signal.setText("ws://192.168.4.151:3000");

    private void initVar() {
        et_signal.setText("ws://192.168.4.151:3000");
        et_room.setText("100");
    }

    /*-------------------------- nodejs版本服务器测试--------------------------------------------*/
    public void JoinRoomSingleVideo(View view) {
        WebrtcUtil.callSingle(this,
                et_signal.getText().toString(),
                et_room.getText().toString().trim(),
                true);
    }

    public void JoinRoom(View view) {
        WebrtcUtil.call(this, et_signal.getText().toString(), et_room.getText().toString().trim());

    }


}
