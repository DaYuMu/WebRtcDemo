package com.dds.nodejs;

import android.app.Activity;
import android.text.TextUtils;

import com.dds.webrtclib.WebRTCManager;
import com.dds.webrtclib.WebRTCRoomManager;
import com.dds.webrtclib.bean.MediaType;
import com.dds.webrtclib.bean.MyIceServer;
import com.dds.webrtclib.ui.ChatRoomActivity;
import com.dds.webrtclib.ui.ChatSingleActivity;
import com.dds.webrtclib.ui.RoomUserListActivity;
import com.dds.webrtclib.ws.IConnectEvent;

/**
 * Created by dds on 2019/1/7.
 * android_shuai@163.com
 */
public class WebrtcUtil {


    // turn and stun
    private static MyIceServer[] iceServers = {
            new MyIceServer("stun:stun.l.google.com:19302"),
            new MyIceServer("stun:23.21.150.121"),

    };

    //本地测试信令地址
     private static String WSS = "ws://219.148.61.25:3000";

    // one to one
    public static void callSingle(Activity activity, String wss, String roomId, boolean videoEnable) {
        if (TextUtils.isEmpty(wss)) {
            wss = WSS;
        }
        WebRTCManager.getInstance().init(wss, iceServers, new IConnectEvent() {
            @Override
            public void onSuccess() {
                ChatSingleActivity.openActivity(activity, videoEnable);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
        WebRTCManager.getInstance().connect(videoEnable ? MediaType.TYPE_VIDEO : MediaType.TYPE_AUDIO, roomId);
    }

    // Videoconferencing
    public static void call(Activity activity, String wss, String roomId) {
        if (TextUtils.isEmpty(wss)) {
            wss = WSS;
        }
        WebRTCRoomManager.getInstance().init(wss, iceServers, new IConnectEvent() {
            @Override
            public void onSuccess() {
//                RoomUserListActivity.openActivity(activity);
                ChatRoomActivity.openActivity(activity);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
        WebRTCRoomManager.getInstance().connect(MediaType.TYPE_MEETING, roomId);
    }


}
