package com.spidren.ui.drawer.menu;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ScrollView;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyListView;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.api.shape.MyShapeImg;
import com.spidren.ui.drawer.shape.MenuCollageShape;
import com.spidren.ui.drawer.shape.MenuDeveloperShape;
import com.spidren.ui.drawer.shape.MenuExloreShaper;
import com.spidren.ui.drawer.shape.MenuFeedBackShape;
import com.spidren.ui.drawer.shape.MenuNewsShape;
import com.spidren.ui.drawer.shape.MenuMyScheduleShape;
import com.spidren.ui.drawer.shape.MenuOuerTeamShape;
import com.spidren.ui.drawer.shape.MenuSponsorShape;
import com.spidren.vaividhya2k15.MainActivity;

public class MenuLayout extends MyListView{

	MenuAdapter adapter;
	
	public MenuLayout(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		
		setBackgroundColor(Color.WHITE);
		setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
		
		setDivider(null);
		setDividerHeight(0);
		
		
		adapter = new MenuAdapter(context,width);
		setAdapter(adapter);
		
		
		adapter.addHeader(MenuItemEnum.lable_Event);
		adapter.addItem(MenuItemEnum.Events);
		adapter.addItem(MenuItemEnum.My_Schedule);
		adapter.addItem(MenuItemEnum.News);
		

		adapter.addHeader(MenuItemEnum.lable_Connect);
		adapter.addItem(MenuItemEnum.Ssasit);
		adapter.addItem(MenuItemEnum.Vavidhya);
		adapter.addItem(MenuItemEnum.Our_Team);
		adapter.addItem(MenuItemEnum.Sponsor);
		
		adapter.addHeader(MenuItemEnum.lable_Dev);
		adapter.addItem(MenuItemEnum.Feedback);
		adapter.addItem(MenuItemEnum.Developer);
		
		
		//for item click
		MainActivity.macros.addMacro(new Macro(MacroTag.CLICK_MENU_ITEM) {
			
			@Override
			public void run(Object obj) {
				adapter.setSelect((Integer)obj);
				adapter.notifyDataSetChanged();
			}
		});
		
		//for notification 
		MainActivity.macros.addMacro(new Macro(MacroTag.MENU_NOTIFICATION) {
			@Override
			public void run(Object obj) {
				adapter.setNotification(3,(Boolean)obj);
				adapter.notifyDataSetChanged();
			}
		});
		
		
		setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				adapter.setSelect(position);
				adapter.notifyDataSetChanged();
			}
		});
		
		
		
		
	}
	
	
	
	
	private class MenuAdapter extends BaseAdapter{

		private final int  ITEM = 0,
				           HEADER = 1;
		
		private Context context;
		
		private ArrayList<MenuItemEnum> data = new ArrayList<MenuItemEnum>();
		private TreeSet<Integer> header = new TreeSet<Integer>();
		private MyShapeImg[] shapleList = {
				null,
				new MenuExloreShaper(),
				new MenuMyScheduleShape(),
				new MenuNewsShape(),
				null,
				new MenuCollageShape(),
				null,
				new MenuOuerTeamShape(),
				new MenuSponsorShape(),
				null,
				new MenuFeedBackShape(),
				new MenuDeveloperShape()
		};
		
		private boolean[] notification = new boolean[12];
		
		private int width,selectedPosition;
		
		public MenuAdapter(Context context,int width) {
			this.context = context;
			this.width = width;
			selectedPosition = 1;
			
			notification[3] = MainActivity.db.isHasUnReadNews();
			
		}
		
		public void setNotification(int position,boolean val){
			notification[position] = val;
		}
		
		public void setSelect(int position) {
			selectedPosition = position;
		}

		public void addItem(MenuItemEnum str){
			data.add(str);
			notifyDataSetChanged();
		}
		
		public void addHeader(MenuItemEnum str){
			data.add(str);
			header.add(data.size() - 1);
			notifyDataSetChanged();
		}
		
		@Override
		public int getItemViewType(int position) {
			return header.contains(position) ? HEADER : ITEM;
		}
		
		@Override
		public int getViewTypeCount() {
			return 2;
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
			return position;
		}
		
		

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			int type = getItemViewType(position);
			boolean isSelected = selectedPosition == position;
			MenuListItem item = null;
			MenuListHeader header = null;
			
			
			if(convertView == null){
				
				if(type == ITEM){
					item = new MenuListItem(context, MyLayoutParms.ABS_LIST_VIEW, width, MainActivity.cf.dpix[55]);
					item.SetData(data.get(position),isSelected,position,shapleList[position],notification[position]);
					
					convertView = item;
					convertView.setTag(item);
				}else {
					
					header = new MenuListHeader(context, MyLayoutParms.ABS_LIST_VIEW, width, -2);
					header.SetData(data.get(position));

					convertView = header;
					convertView.setTag(header);
				}
				
			}else {
				if(type == ITEM){
					item = (MenuListItem) convertView.getTag();
					item.SetData(data.get(position),isSelected,position,shapleList[position],notification[position]);
					
					convertView = item;
				}else {
					header = (MenuListHeader) convertView.getTag();
					header.SetData(data.get(position));
					
					convertView = header;
				}
			}
			return convertView;
		}
		
		
		
	}
}
