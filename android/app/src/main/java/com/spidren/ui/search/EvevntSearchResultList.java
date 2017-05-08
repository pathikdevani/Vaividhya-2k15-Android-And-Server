package com.spidren.ui.search;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;

import com.spidren.api.layout.MyListView;
import com.spidren.database.DBEventBox;
import com.spidren.vaividhya2k15.MainActivity;
public class EvevntSearchResultList extends MyListView{

	
	private EventSearchResultAdapter adapter;
	private ArrayList<DBEventBox> data;
	private ArrayList<DBEventBox> mData;
	
	
	public EvevntSearchResultList(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		
		setDividerHeight(0);
		
		
		mData = new ArrayList<DBEventBox>();
		data = MainActivity.db.getEventBoxList();

		
		adapter = new EventSearchResultAdapter(context, mData);
		setAdapter(adapter);
	}
	
	public void setData(String str){
		
		mData.clear();
		
		if(str.equals("")){

		}else {
			final String match = str.toLowerCase(Locale.ENGLISH);
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).toString().toLowerCase(Locale.ENGLISH).contains(match)){
					mData.add(data.get(i));
				}
			}	
		}

		
		adapter.setData(mData);
		adapter.notifyDataSetChanged();
	}
	
}
