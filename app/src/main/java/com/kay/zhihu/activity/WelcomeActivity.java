package com.kay.zhihu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kay.zhihu.R;

public class WelcomeActivity extends Activity implements View.OnClickListener{
    private Button btnJump;
    private ImageView ivAD;
    private static final int AD_MESSAGE_WHAT=0;
    private static final int BUTTON_MESSAGE_WHAT=1;
    private static final int JUMP_MESSAGE_WHAT=2;
    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
           switch (message.what){
               case AD_MESSAGE_WHAT:
                  ivAD.setVisibility(View.VISIBLE);
                   break;
               case BUTTON_MESSAGE_WHAT:
                   btnJump.setVisibility(View.VISIBLE);
                   break;
               case JUMP_MESSAGE_WHAT:
                   onClick(ivAD);
                   break;
               default:
                   break;
           }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnJump= (Button) findViewById(R.id.btnJump);
        btnJump.setOnClickListener(this);

        ivAD= (ImageView) findViewById(R.id.ivAD);
        mHandler.sendEmptyMessageDelayed(AD_MESSAGE_WHAT,2000);
        mHandler.sendEmptyMessageDelayed(BUTTON_MESSAGE_WHAT,4000);
        mHandler.sendEmptyMessageDelayed(JUMP_MESSAGE_WHAT,7000);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
