package com.spidren.ui.list;

import java.util.ArrayList;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBEventBox;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;


public class EventListLayout extends GridView{

	private int margin ,colWidth;
	private EventListAdapter adapter;

	public EventListLayout(Context context, int type, int width, int height, int x, int y) {
		super(context);

		setLayoutParams(new MyLayoutParms(type, width, height, x, y).getParams());
		setBackgroundColor(Config.BACK_COLOR);

		margin = MainActivity.cf.dpix[4];
		colWidth = (width - margin*3)/2 ;

		setGravity(Gravity.CENTER_HORIZONTAL);
		setVerticalSpacing(margin);
		setNumColumns(GridView.AUTO_FIT);
		setStretchMode(3);
		setColumnWidth(colWidth);
		setClipToPadding(false);
		setPadding(0, margin, 0, margin);

		adapter = new EventListAdapter(context,colWidth);
		setAdapter(adapter);

		
		setSmoothScrollbarEnabled(true);
		setVerticalScrollBarEnabled(false);
		setHorizontalScrollBarEnabled(false);
		setOverScrollMode(OVER_SCROLL_NEVER);
		//setOnScrollListener(new PauseOnScrollListener(ImageLoader.getInstance(), true,false));
		
	}

	private class EventListAdapter extends BaseAdapter{

		private Context context;
		private int width;

		private ArrayList<DBEventBox> data;

		public EventListAdapter(Context context,int width) {
			this.context = context;
			this.width = width;

			data = MainActivity.db.getEventBoxList();
			/*for (int i = 0; i < data.size(); i++) {
				ImageLoader.getInstance().loadImage(Config.event_image_link(data.get(i).getId()), null);
			}*/
			
			
			MainActivity.macros.addMacro(new Macro(MacroTag.NOTIFY_EVENT_LIST) {
				@Override
				public void run(Object obj) {
					//MainActivity.cf.Log("i am nptify event list");
				
					data = MainActivity.db.getEventBoxList();
					notifyDataSetChanged();
				}
			});
		}

		@Override
		public int getCount() {

			return data.size();
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {

			if(view == null){
				EventListItemLayout item = new EventListItemLayout(context, MyLayoutParms.ABS_LIST_VIEW, width, (int) (width * 1.2f));
				view = item;
			}
			
			((EventListItemLayout) view).setEventBox(data.get(position));
			return view;
		}


	}

}

