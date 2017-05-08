package com.spidren.websocket;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import com.spidren.vaividhya2k15.Config;


public class ServerConnection {

	private Context context;
	private WsClient client;
	private BroadcastReceiver receiver;
	
	
	public ServerConnection(Context context) {
		this.context = context;
		
		receiver = new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context context, Intent intent) {
				if(intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")){
					isServerConnectionReady();
				}
			}
		};
		
		IntentFilter filter = new IntentFilter();
		filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		context.registerReceiver(receiver, filter);
		
		
		isServerConnectionReady();
	}
	
	
	public void serverReady(){
		if(!Config.isConnected){
			Config.isConnected = true;
			try {
				client = new WsClient(new URI(Config.webscoket_link));
				client.connect();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void serverNotReady(){
		
		
		final Toast toast = Toast.makeText(context, "Can't connect : for update internet connection required", Toast.LENGTH_LONG);
	    toast.show();

	    Handler handler = new Handler();
	        handler.postDelayed(new Runnable() {
	           @Override
	           public void run() {
	               toast.cancel(); 
	           }
	    }, 2500);
		
		if(Config.isConnected){
			client = null;			
		}

	}
	
	
	public void isServerConnectionReady(){
		
		if(NetworkUtil.getConnectivityStatusString(context)){
			
			AsyncTask<String, Integer, Boolean> task = new AsyncTask<String, Integer, Boolean>() {
				@Override
				protected Boolean doInBackground(String... params) {
					
					try {
						URL url = new URL(params[0]);
						HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
						//urlc.setRequestMethod("HEAD");
						urlc.setConnectTimeout(1000);
						urlc.connect();
						if (urlc.getResponseCode() == 200) {
							return true;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					return false;
				}

				@Override
				protected void onPostExecute(Boolean result) {
					if(result){
						serverReady();
					}else {
						serverNotReady();
					}
					
				}
			};

			task.execute("http://"+Config.host);
			
		}else {			
			serverNotReady();
		}
		
	}
	
	public void onDestroy(){
		if(Config.isConnected){
			client.close();
		}
		client = null;
		
		if(receiver !=null)
			context.unregisterReceiver(receiver);
		
	}
	
}
