package com.spidren.ui.myschedule;

import java.util.ArrayList;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ScrollView;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBEvent;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class MyScheduleLayout extends GridView{

	private MyScheduleAdapter adapter;
	private int margin,colWidth;
	
	
	public MyScheduleLayout(Context context, int type, int width, int height, int x, int y) {
		super(context);
		
		
		
		
		margin = MainActivity.cf.dpix[4];
		colWidth = width - (2 * margin);
		
		
		
		setLayoutParams(new MyLayoutParms(type, width, height, x, y).getParams());
		
		
		setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
		setVerticalScrollBarEnabled(false);
		setHorizontalScrollBarEnabled(false);
		
		setBackgroundColor(Config.BACK_COLOR);
		setGravity(Gravity.CENTER_HORIZONTAL);
		setVerticalSpacing(margin);
		setNumColumns(GridView.AUTO_FIT);
		//setStretchMode(3);
		setColumnWidth(colWidth);
		setClipToPadding(false);
		setPadding(0, margin, 0, margin);
		
		adapter = new MyScheduleAdapter(context, colWidth);
		setAdapter(adapter);
		
	}
	
	private class MyScheduleAdapter extends BaseAdapter{
	
		private Context context;
		private int width;
		private ArrayList<DBEvent> data;
		
		public MyScheduleAdapter(Context context,int width) {
			this.context = context;
			this.width = width;
			
			data = MainActivity.db.getWisedEventList();
			MainActivity.macros.addMacro(new Macro(MacroTag.NOTIFY_MY_SCHEDULE_LIST) {
				@Override
				public void run(Object obj) {
					data = MainActivity.db.getWisedEventList();
					notifyDataSetChanged();
				}
			});
			
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(convertView == null){				
				MyScheduleItem layout = new MyScheduleItem(context, MyLayoutParms.ABS_LIST_VIEW, width, (int)(width * .7));
				convertView = layout;
			}
			((MyScheduleItem) convertView).setEvent(data.get(position));
			
			return convertView;
		}
		
	}

}
