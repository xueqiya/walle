package com.meituan.android.walle.sample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.meituan.android.walle.ChannelReader;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.read_channel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                readChannel();
                test();
            }
        });
    }

//    private void readChannel() {
//        final TextView tv = (TextView) findViewById(R.id.tv_channel);
//        final long startTime = System.currentTimeMillis();
//        final ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(this.getApplicationContext());
//        if (channelInfo != null) {
//            tv.setText(channelInfo.getChannel() + "\n" + channelInfo.getExtraInfo());
//        }
//        Toast.makeText(this, "ChannelReader takes " + (System.currentTimeMillis() - startTime) + " milliseconds", Toast.LENGTH_SHORT).show();
//    }

    private void test() {
        String inPath  = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "aaa.apk";
        String outPath  =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "aaa.ppt";
        File file = new File(inPath);
        byte[] b = ChannelReader.getBytes(file);
        Log.d(TAG, "byte array size: " + b.length);

        FileUtil.bytesToFile(b, outPath);
    }
}