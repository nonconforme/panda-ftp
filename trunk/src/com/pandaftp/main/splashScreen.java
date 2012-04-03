//Contributed Code help from DroidNova.com
package com.pandaftp.main;

import com.pandaftp.main.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class splashScreen extends Activity {
	protected boolean _active = true;
	protected int _splashTime = 5000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        final splashScreen Splash = this;
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    
                    Intent intent = new Intent();
                    intent.setClass(Splash, Testshell.class);
                    startActivity(intent);
                    finish();
                    stop();
                		
                }
            }
        };
        splashTread.start();
        //startActivity(new Intent("com.pandaftp.main.Testshell"));
    }
    public boolean onTouchEvent(MotionEvent event) {
	    if (event.getAction() == MotionEvent.ACTION_DOWN) {
	        _active = false;
	    }
	    return true;
	}
}