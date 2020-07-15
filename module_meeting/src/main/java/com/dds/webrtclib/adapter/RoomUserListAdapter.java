package com.dds.webrtclib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dds.webrtclib.R;

import java.util.List;

public class RoomUserListAdapter extends ArrayAdapter {


    private List<String> data;
    public RoomUserListAdapter(Context context, int headImage, List<String> obj){
        super(context,headImage,obj);
        data = obj;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.room_user_listitem,parent);//这个是实例化一个我们自己写的界面Item
        TextView headText = view.findViewById(R.id.tv_socketid);
        headText.setText(data.get(position));
        headText.setOnClickListener(new View.OnClickListener() {//检查哪一项被点击了
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"你点击了第"+position+"项",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}