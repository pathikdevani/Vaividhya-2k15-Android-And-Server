package com.spidren.ui.search;


import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;

import com.spidren.api.MyColor;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBEventBox;
import com.spidren.vaividhya2k15.MainActivity;

public class EventSearchResultAdapter extends BaseAdapter{
	
	//private String[] data;
	private ArrayList<DBEventBox> data;
	private Context context;
	
	public EventSearchResultAdapter(Context context , ArrayList<DBEventBox> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = new Row(context,data.get(position), MyLayoutParms.ABS_LIST_VIEW, -1, -2, 0, 0);
		}else {
			((Row) convertView).setData(data.get(position));
		}
		
		return convertView;
	}
	
	
	private class Row extends MyRelativeLayout{
		
		private MyTextView text;
		
		public Row(Context context,DBEventBox data, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			Log.i("My", "i am ="+data.getName() +"  id"+data.getId());
			
			setBackgroundColor(Color.WHITE);
			setRipple(true);
			
			text = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, -1, -2,0, 0);
			text.setPadding(MainActivity.cf.dpix[55], MainActivity.cf.dpix[18], MainActivity.cf.dpix[18], MainActivity.cf.dpix[18]);
			//text.setText(data.getName());
			setData(data);
			text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
			text.setTextColor(MyColor.Grey.A900);
			addView(text);
			
			
			
		}
		
		public void setData(final DBEventBox data){
			text.setText(data.getName());
			
			
			
			setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Log.i("My", "i am " + data.getId());
					MainActivity.macros.run(MacroTag.EVENT_OPEN,data.getId());
					
					InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		            imm.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
		            
				}
			});
		}
		
	}
	
	public void setData(ArrayList<DBEventBox> data){
		this.data = data;
	}
	
	
	

}
