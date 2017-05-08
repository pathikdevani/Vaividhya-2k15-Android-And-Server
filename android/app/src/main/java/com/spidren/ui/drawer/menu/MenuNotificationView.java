package com.spidren.ui.drawer.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.Gravity;

import com.spidren.api.MyColor;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.vaividhya2k15.MainActivity;

public class MenuNotificationView extends MyRelativeLayout{

	
	private MyTextView text;
	private Paint paintBack;
	private RectF rect;
	
	public MenuNotificationView(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		
		setWillNotDraw(false);
		
		text = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		text.setText("New");
		text.setTextColor(Color.WHITE);
		text.setPadding(MainActivity.cf.dpix[7], MainActivity.cf.dpix[3], MainActivity.cf.dpix[7], MainActivity.cf.dpix[3]);
		text.setGravity(Gravity.CENTER);
		addView(text);
		
		paintBack = new Paint();
		paintBack.setColor(MyColor.Red.A500);
		paintBack.setAntiAlias(true);
	
		rect = new RectF();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
		canvas.drawRoundRect(rect, MainActivity.cf.dpix[3], MainActivity.cf.dpix[3], paintBack);
		super.onDraw(canvas);
	}

}
