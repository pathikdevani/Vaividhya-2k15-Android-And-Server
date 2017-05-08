package com.spidren.ui.myschedule;


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
import com.spidren.database.DBEvent;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class MyScheduleItem extends MyRelativeLayout{

	private MyImageView backImage;
	private MyView surface,surfaceTop;
	private MyTextView eventName,eventTime,eventType,eventIntro;
	private int margin = MainActivity.cf.dpix[15];
	
	
	private Context context;
	private int width;
	private DBEvent event;
	private Wised wised;
	
	public MyScheduleItem(Context context, int type, int width, int height) {
		super(context, type, width, height,0, 0);
		
		this.context = context;
		this.width = width;
		
		backImage = new MyImageView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		backImage.setScaleType(ScaleType.CENTER_CROP);
		addView(backImage);
		
		surface = new MyView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		surface.setBackgroundColor(Color.parseColor("#00ffffff"));
		surface.setRipple(true);
		addView(surface);
		
		surfaceTop = new MyView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		surfaceTop.setBackgroundColor(Color.parseColor("#000000"));
		surfaceTop.getBackground().setAlpha(40);
		surfaceTop.setClickable(false);
		addView(surfaceTop);
		
		
		eventType = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		eventType.setPadding(margin,margin, margin, margin);
		eventType.setTextColor(Color.parseColor("#e3e3e3"));
		eventType.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
		eventType.setMaxLines(1);
		eventType.setEllipsize(TruncateAt.END);
		addView(eventType);
		
		
		eventIntro = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		eventIntro.setMaxLines(1);
		eventIntro.setEllipsize(TruncateAt.END);
		eventIntro.setMaxLines(2);
		eventIntro.setTextColor(Color.parseColor("#e3e3e3"));
		eventIntro.setPadding(margin, 0, margin, margin);
		eventIntro.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
		eventIntro.setId(MainActivity.cf.getId());
		((RelativeLayout.LayoutParams)eventIntro.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		addView(eventIntro);
		
		
		
		eventTime = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		eventTime.setMaxLines(1);
		eventTime.setEllipsize(TruncateAt.END);
		eventTime.setTextColor(Color.parseColor("#e3e3e3"));
		eventTime.setPadding(margin, 0, margin, margin);
		eventTime.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
		eventTime.setId(MainActivity.cf.getId());
		((RelativeLayout.LayoutParams)eventTime.getLayoutParams()).addRule(RelativeLayout.ABOVE,eventIntro.getId());
		addView(eventTime);
		
		
		eventName = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
		((RelativeLayout.LayoutParams)eventName.getLayoutParams()).addRule(RelativeLayout.ABOVE,eventTime.getId());
		eventName.setPadding(margin, 0, margin, MainActivity.cf.dpix[0] );
		eventName.setMaxLines(2);
		eventName.setLineSpacing(MainActivity.cf.dpix[1], 1);
		eventName.setEllipsize(TruncateAt.END);
		eventName.setTextColor(Color.WHITE);
		eventName.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
		addView(eventName);
		
		
		setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.macros.run(MacroTag.EVENT_OPEN,event.getId());
			}
		});
		
	}
	
	public void setEvent(DBEvent event){
		this.event = event;
		surface.setBackgroundColor(MyColor.getColor(event.get_color_code(), 2));
		surface.getBackground().setAlpha(150);
		
		ImageLoader.getInstance().displayImage(Config.event_image_link(event.getId()),backImage);
		eventType.setText(event.getType());
		eventTime.setText(event.getTime());
		eventName.setText(event.getName());
		if(event.isWised()){
			if(wised == null){
				int wisedSize = MainActivity.cf.dpix[20];
				wised = new Wised(context, MyLayoutParms.RELATIVE_LAYOUT,wisedSize,width - wisedSize, 0);
				addView(wised);
			}
		}else {
			if(wised != null){
				removeView(wised);
				wised = null;
			}
		}
		eventIntro.setText(event.getIntro());
		
		
	}
	
	
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		
		onTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}
	
	public void setImage(final int id){
		
	}
	
	/*private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
		static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				FadeInBitmapDisplayer.animate(imageView, 500);
				displayedImages.add(imageUri);
			}
		}
	}*/
	
	private class Wised extends MyView{

		private EventItemWisedShape backShape;
		private EventTrueShape trueShape;
		
		public Wised(Context context, int type, int size, int x, int y) {
			super(context, type, size, size, x, y);
			
			backShape = new EventItemWisedShape(size, size, 0,0);
			trueShape = new EventTrueShape(size/2, size/2, size/2, 0);
			trueShape.setColor(Color.BLUE);
		}
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			
			backShape.draw(canvas);
			trueShape.draw(canvas);
		}
	}


}
