package com.spidren.ui.drawer.menu;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.spidren.api.MyColor;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.api.shape.MyShapeImg;
import com.spidren.vaividhya2k15.MainActivity;
import com.spidren.vaividhya2k15.R;

public class MenuListItem extends MyRelativeLayout{

	
	private MenuIconView icon;
	private MyTextView title;
	private MenuItemEnum data;
	private int position;
	private Context context;
	
	private MenuNotificationView notification;
	
	
	public MenuListItem(Context context, int type, int width, int height) {
		super(context, type, width, height, 0, 0);
		
		setWillNotDraw(false);
		setRipple(true);
		getRipple().setAlpha(250);
		getRipple().setColor(Color.parseColor("#e3e3e3"));
		
		this.context = context;
		
		icon = new MenuIconView(context, MyLayoutParms.RELATIVE_LAYOUT, height, MainActivity.cf.dpix[10], 0);
		icon.setClickable(false);
		addView(icon);
		
		title = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width - height , height, height, 0);
		title.setGravity(Gravity.CENTER_VERTICAL);
		title.setTextColor(Color.GRAY);
		title.setPadding(MainActivity.cf.dpix[10], 0, MainActivity.cf.dpix[10], 0);
		addView(title);
		
		
		
		setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				initClick();
				endClick(data);

				
				
			}
		});
	}
	
	
	public void SetData(MenuItemEnum data, boolean isSelected,int position,MyShapeImg shape,boolean isHaseNew){
		this.data = data;
		this.position = position;
		
		title.setText(data.toString());
		
		if(shape != null)
			icon.setShape(shape);
		else {
			
			icon.setScaleType(ScaleType.FIT_XY);
			ImageLoader.getInstance().displayImage("drawable://"+R.drawable.menulogo, icon);
		}
		
		if(isSelected){
			setBackgroundColor(Color.parseColor("#e3e3e3"));
			if(shape != null)
				icon.setColor(MyColor.Blue.A800);
			title.setTextColor(MyColor.Blue.A800);
			
		}else {
			setBackgroundColor(Color.WHITE);
			if(shape != null)
				icon.setColor(MyColor.Grey.A700);
			title.setTextColor(MyColor.Grey.A700);
		}
		
		
		if(isHaseNew){
			if(notification == null){
				notification = new MenuNotificationView(context, MyLayoutParms.RELATIVE_LAYOUT, -2, -2, 0, 0);
				notification.setClickable(false);
				RelativeLayout.LayoutParams notificationParams = (LayoutParams) notification.getLayoutParams();
				notificationParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				notificationParams.addRule(RelativeLayout.CENTER_VERTICAL);
				notificationParams.rightMargin =  MainActivity.cf.dpix[15];
				addView(notification);			
			}
		}else {
			if(notification != null){
				removeView(notification);
				notification = null;
			}
		}
		
		
	}
	
	
	private void initClick() {
		MainActivity.macros.run(MacroTag.CLICK_MENU_ITEM,position);
	}
	
	private void endClick(final MenuItemEnum data){
		MainActivity.macros.run(MacroTag.DRAWER_CLOSE,1);
		
		MainActivity.macros.addMacro(new Macro(MacroTag.DRAWER_CLOSE_CALLBACK) {
			@Override
			public void run(Object obj) {
				//MainActivity.cf.Log(data.toString());
				switch (data) {
				
				case Events:
					performeEvents();
					break;
				case My_Schedule:
					performeMySchedule();
					break;
				case News:
					performeNews();
					break;
					
					
					
				case Ssasit:
					performeSsasit();
					break;
				case Vavidhya:
					performeVavidhya();
					break;
				case Our_Team:
					performeOurTeam();
					break;
				case Sponsor:
					performeSponsor();
					break;
					
					
					
				case Feedback:
					performeFeedBack();
					break;
				case Developer:
					performeDeveloper();
					break;

					
					
				default:
					break;
				}
			}
		});
	}

	private void performeDeveloper() {
		MainActivity.macros.run(MacroTag.DEVELOPER_OPEN);
	}
	
	private void performeSponsor() {
		MainActivity.macros.run(MacroTag.SPONSOR_LIST_OPEN);
	}

	private void performeOurTeam() {
		MainActivity.macros.run(MacroTag.OUR_TEAM_OPEN);
	}
	
	private void performeNews() {
		MainActivity.macros.run(MacroTag.NEWS_OPEN);
		MainActivity.macros.run(MacroTag.MENU_NOTIFICATION,false);
	}

	private void performeMySchedule() {
		MainActivity.macros.run(MacroTag.MY_SCHEDULE_OPEN);
	}

	

	private void performeFeedBack() {
		MainActivity.cf.sendMail("vaividhyassasit@gmail.com", "Feedback Vavidhya App", "I am");
		MainActivity.macros.run(MacroTag.MENU_ITEM_SELECT_SETUP);
	}

	private void performeVavidhya() {
		MainActivity.cf.goToLink("http://vaividhya.ssasit.org/");
		MainActivity.macros.run(MacroTag.MENU_ITEM_SELECT_SETUP);
	}

	private void performeSsasit() {
		MainActivity.cf.goToLink("http://ssasit.org/");
		MainActivity.macros.run(MacroTag.MENU_ITEM_SELECT_SETUP);
	}

	
	private void performeEvents() {
		MainActivity.macros.run(MacroTag.EVENT_LIST_OPEN);
	}
	
	

}
