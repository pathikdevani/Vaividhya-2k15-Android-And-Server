package com.spidren.vaividhya2k15;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.spidren.ui.MainLayout;
import com.spidren.api.MyConfig;
import com.spidren.api.backpress.BackPress;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.macro.Macros;
import com.spidren.database.DBHelper;
import com.spidren.websocket.ServerConnection;

public class MainActivity extends Activity {

	public static MyConfig cf;
	public static DBHelper db;
	public static Macros macros;
	public static BackPress back;
	ServerConnection connection;
    			
	public StartupLayout startup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		cf = new MyConfig(this);
		back = new BackPress();
		macros = new Macros();
		db = new DBHelper(getBaseContext());
		
		back.lock();
		
		startup = new StartupLayout(getBaseContext(),2500);
		setContentView(startup);
		
		startup.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				cf.set(startup.getWidth(), startup.getHeight());
				init();
				startup.recycle();
			}
		},3000);
		
		
		
		
	}
	
	private void init(){
		Log.i("My", "init");
		
		MainLayout layout = new MainLayout(cf.context, MyLayoutParms.RELATIVE_LAYOUT, cf.w, cf.h, 0, 0);
		setContentView(layout);
		
		layout.post(new Runnable() {
			
			@Override
			public void run() {
				back.unLock();
				connection = new ServerConnection(MainActivity.this);
				
			}
		});
	}
	
	
	@Override
	public void onBackPressed() {
		if(!back.isLock()){
			if(!back.performBack()){
				super.onBackPressed();
			}
		}
	}
	
	
	
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	
	@Override
	protected void onDestroy() {
		
		db.close();
		if(connection != null)
			connection.onDestroy();
		super.onDestroy();
	}
}
