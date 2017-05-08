package com.spidren.ui.drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import com.spidren.ui.components.IconView;
import com.spidren.api.MyColor.Blue;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.macro.MacroTag;
import com.spidren.ui.drawer.shape.ListDrawerShape;
import com.spidren.ui.drawer.shape.ListSearchShape;
import com.spidren.vaividhya2k15.MainActivity;

public  class MainTitleBarLayout extends MyRelativeLayout{

		private Paint paint;
		private final static int shadowSize = MainActivity.cf.dpix[2];
		
		
		private IconView drawerBtn,searchBtn;
		private MyTextView titleText;
		
		public MainTitleBarLayout(Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height + shadowSize, x, y);
			
			setWillNotDraw(false);
			
			paint = new Paint();
			paint.setColor(Blue.A800);
			paint.setAntiAlias(true);
			paint.setShadowLayer(shadowSize, 0, 0, Color.parseColor("#B0000000"));
			setLayerType(LAYER_TYPE_SOFTWARE, paint);
			
			
			
			
			drawerBtn = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new ListDrawerShape(), height-shadowSize, .33f, 0, 0);
			drawerBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					MainActivity.macros.run(MacroTag.DRAWER_OPEN);
				}
			});
			addView(drawerBtn);
			
			searchBtn = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new ListSearchShape(), height-shadowSize, .33f, width - (height-shadowSize) , 0);
			searchBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					MainActivity.macros.run(MacroTag.SEARCH_OPEN);
				}
			});
			addView(searchBtn);
			
			
			titleText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width - (2 *(height - shadowSize)), height - shadowSize, height -shadowSize, 0);
			titleText.setText("Events");
			titleText.setGravity(Gravity.CENTER_VERTICAL);
			titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
			titleText.setTextColor(Color.WHITE);
			addView(titleText);
			
		}
		
		
		public void setTitleBarText(String text){
			titleText.setText(text);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight() - shadowSize, paint);
		}
	}