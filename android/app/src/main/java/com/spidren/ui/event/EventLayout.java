package com.spidren.ui.event;


import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.spidren.ui.components.FloatButtonView;
import com.spidren.ui.event.shape.EventPluseShape;
import com.spidren.ui.event.shape.EventRulesShape;
import com.spidren.ui.event.shape.EventTaskShape;
import com.spidren.ui.event.shape.EventTrueShape;
import com.spidren.api.MyColor;
import com.spidren.api.layout.MyImageView;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyLinearLayout;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyScrollView;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.layout.MyView;
import com.spidren.api.macro.MacroTag;
import com.spidren.api.shape.MyShapeImg;
import com.spidren.database.DBEvent;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;


public class EventLayout extends MyRelativeLayout{
	
	
	private MyScrollView scroll;
	private EventMenuBarlayout menuBar;
	
	private int topGap,leftGap,floatSize,rightGap;
	private DBEvent event;
	
	public EventLayout(Context context,DBEvent event, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		this.event = event;
		
		setBackgroundColor(Color.WHITE);
		topGap = MainActivity.cf.dpix[40];
		rightGap = MainActivity.cf.dpix[15];
		leftGap = MainActivity.cf.dpix[75];
		floatSize = MainActivity.cf.dpix[44];
		
		scroll = new Scroll(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		addView(scroll);
		
		menuBar = new EventMenuBarlayout(context, type,event, width, topGap + MainActivity.cf.dpix[10], 0, 0);
		addView(menuBar);
	}
	
	
	
	private class Scroll extends MyScrollView{

		private ScrollBody scrollBody;
		private int gap;
		
		public Scroll(Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			setSmoothScrollingEnabled(true);
			setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
			setVerticalScrollBarEnabled(false);
			setHorizontalScrollBarEnabled(false);
			
			
			scrollBody = new ScrollBody(context, MyLayoutParms.FRAM_LAYOUT, width, -2, 0, 0);
			addView(scrollBody);
			
			gap = scrollBody.geGap();
		}
		
		@Override
		protected void onScrollChanged(int x, int y, int oldx, int oldy) {
			
			scrollBody.setHeadY(y/2);
		
			if(y >= gap){
				
				scrollBody.setMenu(true);
				if(y - gap >= MainActivity.cf.dpix[10] ){
					scrollBody.setTitleY(y - gap - MainActivity.cf.dpix[10]);
				}else {
					scrollBody.setTitleY(0);
				}
				
			}else {
				scrollBody.setMenu(false);
				scrollBody.setTitleY(0);
			}
			
			super.onScrollChanged(x, y, oldx, oldy);
		}
		
	}
	
	private class ScrollBody extends MyRelativeLayout{

		private HeaderLayout header;
		private BodyLayout body;
		private TitleLayout title;
		private int headerHeight;
		
		public ScrollBody(Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			
			headerHeight = MainActivity.cf.dpix[200];
			
			header = new HeaderLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, headerHeight, 0, 0);
			addView(header);
			
			title = new TitleLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, headerHeight - topGap);
			title.setId(MainActivity.cf.getId());
			addView(title);
			
			body = new BodyLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
			((RelativeLayout.LayoutParams) body.getLayoutParams()).addRule(RelativeLayout.BELOW,title.getId());
			((RelativeLayout.LayoutParams) body.getLayoutParams()).topMargin = - MainActivity.cf.dpix[25];
			addView(body);	
			
			
			header.bringToFront();
			body.bringToFront();
			title.bringToFront();
			
		}
		
		
		public void setHeadY(int y){
			header.setTranslationY(y);
		}
		
		public void setTitleY(int y) {
			title.setTranslationY(y);
		}
		
		public int geGap() {
			return headerHeight - topGap;	
		}
		
		public void setMenu(boolean isMenuSet){
			if(isMenuSet){
				if(!title.getStat()){
					title.set();
				}
			}else {
				if(title.getStat()){
					title.unSet();
				}
			}
		}
		
		
	} 
	
	private class HeaderLayout extends MyRelativeLayout{

		private MyImageView image;
		public HeaderLayout(Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			image = new MyImageView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
			image.setScaleType(ScaleType.CENTER_CROP);
			addView(image);
			
			reday_for_poster = new ready_update() {
				
				@Override
				public void ready_for_poster() {
					DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
					.cacheOnDisk(true)
					.cacheInMemory(false)
					
					
					.displayer(new FadeInBitmapDisplayer(250))
					.resetViewBeforeLoading(true)
					.imageScaleType(ImageScaleType.EXACTLY)
					.build();
					
					ImageLoader.getInstance().displayImage(Config.event_image_link(event.getId()), image,defaultOptions);
				}
			};
			
		}
		
	}
	
	private class TitleLayout extends MyRelativeLayout{

		private Paint paint;
		private RectF rectf;
		private boolean isMenuSet;
		
		private int width,height;
		private float factor;
		
		private Container container;
		private WiseFloat floatButton;
		
		public TitleLayout(Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			
			setWillNotDraw(false);
			isMenuSet = false;
			this.width = width;
			factor = 0;
			
			paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(MyColor.getColor(event.get_color_code(), 1));
			
			rectf = new RectF();
			
			
			container = new Container(context, MyLayoutParms.RELATIVE_LAYOUT, width - leftGap, -2, leftGap, 0);
			((RelativeLayout.LayoutParams) container.getLayoutParams()).topMargin = topGap;
			container.setId(2001);
			addView(container);
			
			container.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				boolean isAdded = false;
				@Override
				public void onGlobalLayout() {
					if(!isAdded){
						isAdded = true;
						addFloat(container.getHeight());
					}
				}
			});
			
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			height = b - t;
			
		}
		
		private void addFloat(int containerHeight) {
			floatButton = new WiseFloat(MainActivity.cf.context, MyLayoutParms.RELATIVE_LAYOUT, floatSize,(leftGap - floatSize)/2, topGap + containerHeight - (floatSize/2));
			addView(floatButton);
			
			if(listner != null){
				listner.ok();
			}
			
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			
			
			
			rectf.set(0, topGap - factor, width, this.height  - (floatSize/2));
			
			canvas.drawRect(rectf,paint);
			
			super.onDraw(canvas);
		}
		
		public void set(){
			isMenuSet = true;
			
			ValueAnimator anim = ValueAnimator.ofFloat(0f,1f);
			anim.addUpdateListener(new AnimatorUpdateListener() {
				
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					factor = topGap * (Float)animation.getAnimatedValue();
					invalidate();
				}
			});
			anim.setDuration(125);
			anim.setInterpolator(new DecelerateInterpolator(1.3f));
			anim.start();
			
			
		}
		
		public void unSet(){
			isMenuSet = false;
			
			ValueAnimator anim = ValueAnimator.ofFloat(1f,0f);
			anim.addUpdateListener(new AnimatorUpdateListener() {
				
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					factor = topGap * (Float)animation.getAnimatedValue();
					invalidate();
				}
			});
			anim.setDuration(125);
			anim.setInterpolator(new AccelerateInterpolator(1.3f));
			anim.start();
			
		}
		public boolean getStat(){
			return isMenuSet;
		}
		
		private class Container extends MyRelativeLayout{

			private MyTextView titleText,dataText;
			
			public Container(Context context, int type, int width, int height, int x, int y) {
				super(context, type, width, height, x, y);
				
				
				String title = "";
				title = event.getName();
				if(!event.getTag().equals(""))
					title = title +": "+event.getTag();
				
				titleText = new MyTextView(context, type, width, height, 0, y);
				titleText.setText(title);
				titleText.setTextColor(Color.WHITE);
				titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
				titleText.setTypeface(null, Typeface.BOLD);
				titleText.setId(MainActivity.cf.getId());
				titleText.setPadding(MainActivity.cf.dpix[0], MainActivity.cf.dpix[17], MainActivity.cf.dpix[30], MainActivity.cf.dpix[0]);
				titleText.setLineSpacing(MainActivity.cf.dpix[2], 1);
				titleText.setGravity(Gravity.CENTER_VERTICAL);
				addView(titleText);
				
				
				
				if(!(event.getTime().equals("") && event.getLocation().equals(""))){
					
					String data = "";
					if(!event.getTime().equals("")){						
						data = event.getTime();
						if(!event.getLocation().equals(""))								
							data = data +" "+ event.getLocation();						
					}else {
						if(!event.getLocation().equals(""))								
							data = event.getLocation();
					}
					
					dataText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, -2, 0, 0);
					((RelativeLayout.LayoutParams) dataText.getLayoutParams()).addRule(RelativeLayout.BELOW, titleText.getId());
					dataText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
					dataText.setId(3001);
					dataText.setText(data);
					dataText.setTextColor(MyColor.getColor(event.get_color_code(), 0));
					dataText.setLineSpacing(MainActivity.cf.dpix[2], 1);
					dataText.setPadding(MainActivity.cf.dpix[0], MainActivity.cf.dpix[0], MainActivity.cf.dpix[30], MainActivity.cf.dpix[17]);
					addView(dataText);	
				}else {
					titleText.setPadding(MainActivity.cf.dpix[0], MainActivity.cf.dpix[17], MainActivity.cf.dpix[30], MainActivity.cf.dpix[17]);
				}
			}
			
		}
		
		private class WiseFloat extends FloatButtonView{
			
			private MyShapeImg shape;
			
			
			public WiseFloat(Context context, int type, final int size, int x, int y) {
				super(context, type, size, x, y);
				
				
				if(event.isWised()){
					setTrueShape(size/3,(size - size/3)/2,(size - size/3)/2);
					setBackColor(Color.WHITE);
				}else {
					setPluseShape(size/3,(size - size/3)/2,(size - size/3)/2);
					setBackColor(MyColor.Cyan.A500);
				}
				
				
				
				setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						
						if(event.isWised()){
							event.setWised(false);
							MainActivity.db.setWised(event);
							
							setBackColor(MyColor.Cyan.A500);
							setPluseShape(size/3,(size - size/3)/2,(size - size/3)/2);

							invalidate();
						}else {
							event.setWised(true);
							MainActivity.db.setWised(event);
							
							setBackColor(Color.WHITE);
							
							ValueAnimator anim = ValueAnimator.ofFloat(0f,1f);
							anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
								
								@Override
								public void onAnimationUpdate(ValueAnimator animation) {
									int newSize = (int) (((size /3 ) * (Float) animation.getAnimatedValue()));
									setTrueShape(newSize,(size - newSize)/2,(size - newSize)/2);
									invalidate();
								}
							});
							anim.setDuration(200);
							anim.setInterpolator(new AccelerateDecelerateInterpolator());
							anim.start();
						}
						
						MainActivity.macros.run(MacroTag.NOTIFY_EVENT_LIST);
						MainActivity.macros.run(MacroTag.NOTIFY_MY_SCHEDULE_LIST);
					}
				});
			}
			
			public void setTrueShape(int size,int x,int y){
				shape = new EventTrueShape(size, size, x,y);
				shape.setColor(MyColor.Cyan.A500);
			}
			
			public void setPluseShape(int size,int x,int y){
				shape = new EventPluseShape(size, size, x,y);
				shape.setColor(Color.WHITE);
			}
			
			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				shape.draw(canvas);
				
			}
			
			
			
		}
		
	}
	
	private class BodyLayout extends MyLinearLayout{

		MyRelativeLayout task,rules;
		CoOrdinate coOrdinate;
		MyTextView introText;
		
		public BodyLayout(Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			setBackgroundColor(Color.WHITE);

			introText = new MyTextView(context, MyLayoutParms.LINEAR_LAYOUT, -1, -2, 0, 0);
			introText.setPadding(leftGap, MainActivity.cf.dpix[20], rightGap, MainActivity.cf.dpix[20]);
			introText.setLineSpacing(MainActivity.cf.dpix[1], 1);
			introText.setText(event.getIntro());
			addView(introText);

			
			addLine(context, width, MainActivity.cf.dpix[1]);
			
			
			task = new Container(context, MyLayoutParms.LINEAR_LAYOUT, width,-2, new EventTaskShape(), "Task", event.getTask());
			addView(task);
			
			
			addLine(context, width, MainActivity.cf.dpix[1]);
			
			
			rules = new Container(context, MyLayoutParms.LINEAR_LAYOUT, width, -2,new EventRulesShape(), "Rules and Regulations",event.getRule());
			addView(rules);
			
			
			addLine(context, width, MainActivity.cf.dpix[1]);
			
			coOrdinate = new CoOrdinate(context, MyLayoutParms.LINEAR_LAYOUT, width, -2, 0, 0);
			addView(coOrdinate);
			
			
		}
		
		public void addLine(Context context,int width,int height){
			Line line = new Line(context, MyLayoutParms.LINEAR_LAYOUT, width, height, 0, 0);
			addView(line);
		}
		
		private class CoOrdinate extends MyRelativeLayout{

			private MyTextView titleText;
			private MyLinearLayout linCooridator;
			
			public CoOrdinate(Context context, int type, int width, int height, int x, int y) {
				super(context, type, width, height, x, y);
				
				
				
				titleText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width - leftGap, -2, leftGap, 0);
				titleText.setText("Co-ordrinator");
				titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
				titleText.setTextColor(MyColor.getColor(event.get_color_code(), 2));
				titleText.setId(MainActivity.cf.getId());
				titleText.setPadding(0, MainActivity.cf.dpix[20], rightGap, MainActivity.cf.dpix[15]);
				addView(titleText);
				
				
				linCooridator = new MyLinearLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width - leftGap , -2, leftGap, 0);
				((RelativeLayout.LayoutParams) linCooridator.getLayoutParams()).addRule(RelativeLayout.BELOW, titleText.getId());
				addView(linCooridator);
				
				
				
				//fro co1
				MyTextView co1_Text = new MyTextView(context, MyLayoutParms.LINEAR_LAYOUT, -2, -2, leftGap, 0);
				if(isDevloper(event.getCo1_email()))
					co1_Text.setText(Html.fromHtml(event.getCo1_name()+"<font color='#b71c1c'>\u00A0(app developer)</font>"));
				else {
					co1_Text.setText(event.getCo1_name());
				}
				co1_Text.setTextColor(MyColor.Cyan.A800);
				co1_Text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
				co1_Text.setPadding(0, MainActivity.cf.dpix[0], rightGap, MainActivity.cf.dpix[15]);
				linCooridator.addView(co1_Text);
				co1_Text.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String email = event.getCo1_email();
						
						if(isDevloper(email))
							MainActivity.macros.run(MacroTag.DEVELOPER_OPEN);
						else {
							MainActivity.cf.sendMail(email, "Vavidhya from Android app.", "I am");
						}
					}
				});
				
				//fro co1
				MyTextView co2_Text = new MyTextView(context, MyLayoutParms.LINEAR_LAYOUT, -2, -2, leftGap, 0);
				if(isDevloper(event.getCo2_email()))
					co2_Text.setText(Html.fromHtml(event.getCo2_name()+"<font color='#b71c1c'>\u00A0(app developer)</font>"));
				else {
					co2_Text.setText(event.getCo2_name());
				}
				co2_Text.setTextColor(MyColor.Cyan.A800);
				co2_Text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
				co2_Text.setPadding(0, MainActivity.cf.dpix[0], rightGap, MainActivity.cf.dpix[15]);
				linCooridator.addView(co2_Text);
				co2_Text.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String email = event.getCo2_email();
						if(isDevloper(email))
							MainActivity.macros.run(MacroTag.DEVELOPER_OPEN);
						else {
							MainActivity.cf.sendMail(email, "Vavidhya from Android app.", "I am");
						}
					}
				});
				
				
				
				
				
			}
			
			public boolean isDevloper(String email){
				if(email.equalsIgnoreCase("pathikdevani@gmail.com")){
					return true;
				}
				return false;
			}
			
		}
		
		private class Container extends MyRelativeLayout{

			MyTextView titleText,dataText;
			FloatIcon floatButton;
			
			public Container(Context context, int type, int width, int height,MyShapeImg shpe,String title,String data) {
				super(context, type, width, height, 0, 0);
				
				titleText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width - leftGap, -2, leftGap, 0);
				titleText.setText(title);
				titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
				titleText.setTextColor(MyColor.getColor(event.get_color_code(), 2));
				titleText.setId(MainActivity.cf.getId());
				titleText.setPadding(0, MainActivity.cf.dpix[20], rightGap, MainActivity.cf.dpix[15]);
				addView(titleText);
				
				dataText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width - leftGap, -2, leftGap, 0);
				((RelativeLayout.LayoutParams) dataText.getLayoutParams()).addRule(RelativeLayout.BELOW,titleText.getId());
				dataText.setLineSpacing(MainActivity.cf.dpix[1], 1);
				dataText.setPadding(0, 0, rightGap, MainActivity.cf.dpix[15]);
				dataText.setText(data);
				addView(dataText);
				
				
				floatButton = new FloatIcon(context, MyLayoutParms.RELATIVE_LAYOUT,shpe, floatSize, (leftGap - floatSize)/2, MainActivity.cf.dpix[20] /2);
				addView(floatButton);
				
			}
			
		}
		
		private class Line extends MyView{

			private Paint paint;
			public Line(Context context, int type, int width, int height, int x, int y) {
				super(context, type, width, height, x, y);
				
				setWillNotDraw(false);
				paint = new Paint();
				paint.setColor(Color.parseColor("#e3e3e3"));
			}
			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				
				
				canvas.drawRect(leftGap, 0, canvas.getWidth() - rightGap, canvas.getHeight(), paint);
			}
			
		}
		
		private class FloatIcon extends FloatButtonView{

			private MyShapeImg shape;
			
			public FloatIcon(Context context, int type,MyShapeImg shape, int size, int x, int y) {
				super(context, type, size, x, y);
				
				this.shape = shape;
				shape.setPose((int)(size/2.8), (int)(size/2.8), (int)(size - size/2.8)/2, (int)(size - size/2.8)/2);
				shape.setColor(Color.parseColor("#888888"));
			}
			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				
				shape.draw(canvas);
			}
			
		}
		
	}

	
	private onAttached listner;
	
	public void setListner(onAttached listner){
		this.listner = listner;
	}
	
	public interface onAttached{
		public void ok();
	}

	
	private interface ready_update{
		public void ready_for_poster();
	}
	public ready_update reday_for_poster;
	public void readyForView() {
		reday_for_poster.ready_for_poster();
	}

}


