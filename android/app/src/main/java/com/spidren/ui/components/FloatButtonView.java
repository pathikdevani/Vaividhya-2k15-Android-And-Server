package com.spidren.ui.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import com.spidren.api.layout.MyView;
import com.spidren.vaividhya2k15.MainActivity;

public class FloatButtonView extends MyView{

		private Paint paint;
		private RectF rect;
		private int size,shadowSize;
		
		public FloatButtonView(Context context, int type, int size, int x, int y) {
			super(context, type, size, size, x, y);
			
			this.size = size;
			shadowSize = MainActivity.cf.dpix[2];
			
			paint = new Paint();
			paint.setColor(Color.WHITE);
			paint.setAntiAlias(true);
			paint.setShadowLayer(shadowSize, 0, 0, Color.parseColor("#30000000"));
			setLayerType(View.LAYER_TYPE_SOFTWARE, paint);
			
			
			rect = new RectF(0 + shadowSize, 0 + shadowSize , size - shadowSize, size - shadowSize);
		}
		@Override
		protected void onDraw(Canvas canvas) {
			
			canvas.drawRoundRect(rect, size, size, paint);
			super.onDraw(canvas);
		}
		
		public void setBackColor(int color){
			paint.setColor(color);
		}
	}