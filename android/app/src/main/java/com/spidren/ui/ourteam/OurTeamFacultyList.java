package com.spidren.ui.ourteam;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.spidren.api.layout.MyImageView;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBFaculty;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;
public class OurTeamFacultyList extends GridView{

	
	private int margin,colWidth;
	private Adapter adapter;
	
	
	public OurTeamFacultyList(Context context, int type, int width, int height, int x, int y) {
		super(context);
		
		setLayoutParams(new MyLayoutParms(type, width, height, x, y).getParams());

		margin = MainActivity.cf.dpix[4];
		colWidth = width - (2 * margin);
		
		setGravity(Gravity.CENTER_HORIZONTAL);
		setVerticalSpacing(margin);
		setNumColumns(GridView.AUTO_FIT);
		//setStretchMode(3);
		setColumnWidth(colWidth);
		setClipToPadding(false);
		setPadding(0, margin, 0, margin);
	
		
		adapter = new Adapter(context, colWidth);
		setAdapter(adapter);
	}
	
	private class Adapter extends BaseAdapter{

		
		private Context context;
		private int width;
		
		private ArrayList<DBFaculty> data;
		
		public Adapter(Context context,int width) {
			this.context = context;
			this.width = width;
			
			data = MainActivity.db.getFacultyList();
			MainActivity.macros.addMacro(new Macro(MacroTag.NOTIFY_FACULTY_LIST) {
				
				@Override
				public void run(Object obj) {
					data = MainActivity.db.getFacultyList();
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
			Iteam item;
			
			if(convertView == null){
				item = new Iteam(context, MyLayoutParms.ABS_LIST_VIEW, width, RelativeLayout.LayoutParams.WRAP_CONTENT);
			}else {
				item = (Iteam) convertView;				
			}
			
			item.setData(data.get(position));
			
			
			return item;
		}
		
		
		private class Iteam extends MyRelativeLayout{

			private MyImageView profile;
			
			private MyTextView name,post;
			
			public Iteam(Context context, int type, int width, int height) {
				super(context, type, width, height, 0, 0);
				
				profile = new MyImageView(context, MyLayoutParms.RELATIVE_LAYOUT, width, MainActivity.cf.dpix[215], 0, 0);
				profile.setBackgroundColor(Color.BLACK);
				profile.getBackground().setAlpha(125);
				profile.setScaleType(ScaleType.CENTER_CROP);
				profile.setId(MainActivity.cf.getId());
				addView(profile);
				
				name = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, -1, -2, 0, 0);
				((RelativeLayout.LayoutParams)name.getLayoutParams()).addRule(RelativeLayout.BELOW,profile.getId());
				name.setId(MainActivity.cf.getId());
				name.setPadding(MainActivity.cf.dpix[10], MainActivity.cf.dpix[10], MainActivity.cf.dpix[10], MainActivity.cf.dpix[10]);
				name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
				name.setTextColor(Color.WHITE);
				name.setBackgroundColor(Color.parseColor("#5e35b1"));
				name.setMovementMethod(LinkMovementMethod.getInstance());
				addView(name);
				
				post = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, -1, -2, 0, 0);
				((RelativeLayout.LayoutParams)post.getLayoutParams()).addRule(RelativeLayout.BELOW, name.getId());
				post.setPadding(MainActivity.cf.dpix[10], MainActivity.cf.dpix[0], MainActivity.cf.dpix[10], MainActivity.cf.dpix[10]);
				post.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
				post.setTextColor(Color.WHITE);
				post.setBackgroundColor(Color.parseColor("#5e35b1"));
				post.setId(MainActivity.cf.getId());
				post.setMovementMethod(LinkMovementMethod.getInstance());
				addView(post);
				
			}
			
			public void setData(DBFaculty faculty){
				ImageLoader.getInstance().displayImage(Config.faculty_image_link(faculty.getId()), profile);
				post.setText(Html.fromHtml(faculty.getPost()));
				name.setText(Html.fromHtml(faculty.getName()));
			}
			
		}

	}

}
