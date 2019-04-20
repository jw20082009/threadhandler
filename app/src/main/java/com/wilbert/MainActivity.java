
package com.wilbert;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

import com.wilbert.library.activity.BaseThreadHandlerActivity;

public class MainActivity extends BaseThreadHandlerActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_test);
        sendEmptyThreadMessage(MSG_THREAD_SLEEP);
    }

    private final int MSG_THREAD_SLEEP = 0x01;

    @Override
    protected void handleThreadMessage(Message message) {
        super.handleThreadMessage(message);
        switch (message.what) {
            case MSG_THREAD_SLEEP:
                try {
                    Thread.sleep(2000);
                    sendEmptyUIMessage(MSG_UI_AFTER_SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private final int MSG_UI_AFTER_SLEEP = 0x01;

    @Override
    protected void handleUIMessage(Message message) {
        super.handleUIMessage(message);
        switch (message.what) {
            case MSG_UI_AFTER_SLEEP:
                textView.animate().scaleX(1.2f).scaleY(1.2f).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        textView.animate().scaleX(1.0f).scaleY(1.0f);
                    }
                });
                textView.setText("This is refreshed by back thread!");
                break;
        }
    }
}
