package com.dds.webrtclib.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dds.webrtclib.IViewCallback;
import com.dds.webrtclib.R;
import com.dds.webrtclib.WebRTCManager;
import com.dds.webrtclib.adapter.RoomUserListAdapter;
import com.dds.webrtclib.ws.ISignalingEvents;
import com.dds.webrtclib.ws.IWebSocket;

import org.webrtc.IceCandidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomUserListActivity extends AppCompatActivity implements ISignalingEvents {

    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, RoomUserListActivity.class);
        activity.startActivity(intent);
    }

    private WebRTCManager manager;

    private List<String> myBeanList = new ArrayList<>();//用来存放数据的数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_user_list);

        initview();

        initListener();

    }

    private void initListener() {


    }

    RoomUserListAdapter adapter;
    private void initview() {
        ListView listView = (ListView) findViewById(R.id.listview);
        adapter = new RoomUserListAdapter(RoomUserListActivity.this,R.layout.room_user_listitem,myBeanList);
        listView.setAdapter(adapter);
        manager = new WebRTCManager().getInstance();



    }

    @Override
    public void onWebSocketOpen() {

    }

    @Override
    public void onWebSocketOpenFailed(String msg) {

    }

    @Override
    public void onJoinToRoom(ArrayList<String> connections, String myId) {
        Toast.makeText(this, "myid："+myId, Toast.LENGTH_SHORT).show();

            myBeanList.addAll(connections);
            myBeanList.add("my-self："+myId);
            adapter.notifyDataSetChanged();
    }

    @Override
    public void onRemoteJoinToRoom(String socketId) {

            myBeanList.add(socketId);
            adapter.notifyDataSetChanged();
    }

    @Override
    public void onRemoteIceCandidate(String socketId, IceCandidate iceCandidate) {

    }

    @Override
    public void onRemoteIceCandidateRemove(String socketId, List<IceCandidate> iceCandidates) {

    }

    @Override
    public void onRemoteOutRoom(String socketId) {

    }

    @Override
    public void onReceiveOffer(String socketId, String sdp) {

    }

    @Override
    public void onReceiverAnswer(String socketId, String sdp) {

    }
}