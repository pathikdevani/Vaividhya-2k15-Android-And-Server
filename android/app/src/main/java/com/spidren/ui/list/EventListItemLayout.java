package com.spidren.ui.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.spidren.ui.event.shape.EventTrueShape;
import com.spidren.ui.list.shape.EventItemWisedShape;
import com.spidren.api.MyColor;
import com.spidren.api.layout.MyImageView;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.layout.MyView;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBEventBox;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class EventListItemLayout extends MyRelativeLayout{

	private MyImageView backImage;
	private MyView surface,surfaceBlack,surfaceWhite;
	private MyTextView eventName,eventTime,eventType;
	private int margin = MainActivity.cf.dpix[15];
	
	
	private Context context;
	private int width;
	private DBEventBox mEventBox;
	private Wised wised;
	
	
	
	public EventListItemLayout(Context context, int type, int width, int height) {
		super(context, type, width, height,0, 0);
		
		this.context = context;
		this.width = width;
		
		backImage = new MyImageView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		backImage.setScaleType(ScaleType.CENTER_CROP);
		addView(backImage);
		
		
		surfaceWhite = new MyView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		surfaceWhite.setBackgroundColor(Color.parseColor("#ffffff"));
		surfaceWhite.getBackground().setAlpha(80);
		surfaceWhite.setClickable(false);
		addView(surfaceWhite);
		
		surface = new MyView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		surface.setBackgroundColor(Color.parseColor("#00ffffff"));
		surface.setRipple(true);
		addView(surface);
		
		
		
		surfaceBlack = new MyView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		surfaceBlack.setBackgroundColor(Color.parseColor("#000000"));
		surfaceBlack.getBackground().setAlpha(80);
		surfaceBlack.setClickable(false);
		addView(surfaceBlack);
		
		
		eventType = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		eventType.setPadding(margin,margin, margin, margin);
		eventType.setTextColor(Color.parseColor("#e3e3e3"));
		eventType.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
		eventType.setMaxLines(1);
		eventType.setEllipsize(TruncateAt.END);
		addView(eventType);
		
		eventTime = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		eventTime.setMaxLines(1);
		eventTime.setEllipsize(TruncateAt.END);
		eventTime.setTextColor(Color.parseColor("#e3e3e3"));
		eventTime.setPadding(margin, 0, margin, margin);
		eventTime.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
		eventTime.setId(9000);
		((RelativeLayout.LayoutParams)eventTime.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		addView(eventTime);
		
		
		
		
		eventName = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		((RelativeLayout.LayoutParams)eventName.getLayoutParams()).addRule(RelativeLayout.ABOVE,eventTime.getId());
		eventName.setPadding(margin, 0, margin, MainActivity.cf.dpix[5] );
		eventName.setMaxLines(2);
		eventName.setLineSpacing(MainActivity.cf.dpix[1], 1);
		eventName.setEllipsize(TruncateAt.END);
		eventName.setTextColor(Color.WHITE);
		eventName.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
		addView(eventName);
		
		
		
		
		setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.macros.run(MacroTag.EVENT_OPEN,mEventBox.getId());
				
			}
		});
		
	}
	
	public void setEventBox(DBEventBox eventBox){
		this.mEventBox = eventBox;
		surface.setBackgroundColor(MyColor.getColor(eventBox.getColor_code(), 2));
		surface.getBackground().setAlpha(150);
		
		
		
		ImageLoader.getInstance().displayImage(Config.event_image_link(eventBox.getId()),backImage);
		
		eventType.setText(eventBox.getType());
		eventTime.setText(eventBox.getTime());
		eventName.setText(eventBox.getName());
		
		if(eventBox.isWised()){
			if(wised == null){
				int wisedSize = MainActivity.cf.dpix[22];
				wised = new Wised(context, MyLayoutParms.RELATIVE_LAYOUT,wisedSize,width - wisedSize, 0);
				addView(wised);
			}
		}else {
			if(wised != null){
				removeView(wised);
				wised = null;
			}
		}
		
		
	}
	
	
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		
		onTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}
	
	public void setImage(final int id){
		
	}
	
	private class Wised extends MyView{

		private EventItemWisedShape backShape;
		private EventTrueShape trueShape;
		
		public Wised(Context context, int type, int size, int x, int y) {
			super(context, type, size, size, x, y);
			
			backShape = new EventItemWisedShape(size, size, 0,0);
			trueShape = new EventTrueShape(size/2, size/2, size/2, 0);
			trueShape.setColor(MyColor.Cyan.A500);
		}
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			
			backShape.draw(canvas);
			trueShape.draw(canvas);
		}
	}


}
