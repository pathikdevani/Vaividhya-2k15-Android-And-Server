package com.spidren.ui.drawer.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Html;

import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.vaividhya2k15.MainActivity;

public class MenuListHeader extends MyRelativeLayout{

	private MyTextView text;
	private Paint paint;
	
	public MenuListHeader(Context context, int type, int width, int height) {
		super(context, type, width, height, 0, 0);
		
		setWillNotDraw(false);
		setBackgroundColor(Color.WHITE);
		setPadding(0, MainActivity.cf.dpix[5], 0, 0);
		
		text = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
		text.setText(Html.fromHtml("Events"));
		text.setPadding(MainActivity.cf.dpix[10] +  + (MainActivity.cf.dpix[50]/4), MainActivity.cf.dpix[10], 0, MainActivity.cf.dpix[5]);
		text.setTextColor(Color.parseColor("#888888"));
		addView(text);
		
		
		paint = new Paint();
		paint.setStrokeWidth(MainActivity.cf.dpix[1]);
		paint.setColor(Color.parseColor("#e3e3e3"));
		paint.setAntiAlias(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawLine(0, MainActivity.cf.dpix[5], canvas.getWidth(),MainActivity.cf.dpix[5], paint);
		super.onDraw(canvas);
	}
	
	public void SetData(MenuItemEnum data){
		text.setText(data.toString());
	}

}
