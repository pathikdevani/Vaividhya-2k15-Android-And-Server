package com.spidren.ui.news;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyListView;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBNews;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class NewsLayout extends MyListView{

	private Adapter adapter;
	private int gapSize;
	
	
	public NewsLayout(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		setBackgroundColor(Config.BACK_COLOR);
		gapSize = MainActivity.cf.dpix[7];
		
		
		setPadding(gapSize, gapSize, 0, gapSize);
		setDivider(null);
		setDividerHeight(gapSize);
		setClipToPadding(false);
		
		
		
		
		
		adapter = new Adapter(context,width - (2 * gapSize));
		setAdapter(adapter);
		
		
		
		
		
		
	}
	
	
	
	private class Adapter extends BaseAdapter{

		private Context context;
		private int width;
		private ArrayList<DBNews> data;
		
		
		
		public Adapter(Context context,int width) {
			this.context = context;
			this.width = width;
			

			MainActivity.db.set_news_view_to_read();
			data = MainActivity.db.getNewsList();
			MainActivity.macros.addMacro(new Macro(MacroTag.NOTIFY_NEWS_LIST) {
				
				@Override
				public void run(Object obj) {
					data = MainActivity.db.getNewsList();
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
			NewsItem item;
			if(convertView == null){				
				item = new NewsItem(context, MyLayoutParms.ABS_LIST_VIEW, width, -2, 0, 0);
				
			}else {
				item = (NewsItem) convertView;				
			}
			
			item.setData(data.get(position));
			return item;
		}
		
	}

}
