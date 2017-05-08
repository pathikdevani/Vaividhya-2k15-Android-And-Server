package com.spidren.ui.ourteam;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class OurTeamLayout extends MyRelativeLayout{

	
	private ViewPager pager;
	private OurTeamTitlebar ourTeamTitleBar;
	private PAdapter adapter;
	
	public OurTeamLayout(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		setBackgroundColor(Config.BACK_COLOR);
		
		ourTeamTitleBar = new OurTeamTitlebar(context, MyLayoutParms.RELATIVE_LAYOUT, width,MainActivity.cf.dpix[52], 0, 0);
		ourTeamTitleBar.setPosition(0);
		addView(ourTeamTitleBar);
		ourTeamTitleBar.setOnItemSelected(new OurTeamTitlebar.onSelectIteam() {
			
			@Override
			public void onIteam(int position) {
				pager.setCurrentItem(position);
			}
		});
		
		
		pager = new ViewPager(context);
		pager.setLayoutParams(new MyLayoutParms(MyLayoutParms.RELATIVE_LAYOUT, width, height - MainActivity.cf.dpix[50], 0, MainActivity.cf.dpix[50]).getParams());
		addView(pager);
		
		
		GridView data[] = new GridView[]{
				new OurTeamFacultyList(context, MyLayoutParms.ABS_LIST_VIEW, width, height - MainActivity.cf.dpix[50], 0, MainActivity.cf.dpix[50]),
				new OurTeamStudentList(context, MyLayoutParms.ABS_LIST_VIEW, width, height - MainActivity.cf.dpix[50], 0, MainActivity.cf.dpix[50]),
				//new SponsorListLayout(context, MyLayoutParms.ABS_LIST_VIEW, width, height - MainActivity.cf.dpix[50], 0, MainActivity.cf.dpix[50])
		};
		
		adapter = new PAdapter(data);
		pager.setAdapter(adapter);
		
		
		pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				ourTeamTitleBar.setPosition(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
			
		});
		
		ourTeamTitleBar.bringToFront();
		
		
	}
	private class PAdapter extends PagerAdapter{

		private GridView data[];
		
		public PAdapter(GridView[] data) {
			this.data = data;
		}
		
		
		@Override
		public int getCount() {
			return data.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == ((GridView)obj);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			GridView view = data[position];
			((ViewPager)container).addView(view);
			return view;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((GridView) object);
		}
		
	}

}
