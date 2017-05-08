package com.spidren.ui.news;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Html;
import android.text.method.LinkMovementMethod;

import com.spidren.api.MyColor;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.database.DBNews;
import com.spidren.vaividhya2k15.MainActivity;


@SuppressLint("SimpleDateFormat")
public class NewsItem extends MyRelativeLayout{

	private Paint paintBack,paintShadow;
	private RectF rectBack;
	private int shadowSize = MainActivity.cf.dpix[1];
	private boolean isNew ;
	private MyTextView text;
	
	
	public NewsItem(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
				
		setWillNotDraw(false);
		
		paintBack = new Paint();
		paintBack.setAntiAlias(true);
		paintBack.setColor(Color.parseColor("#DDffffff"));
		
		paintShadow = new Paint();
		paintShadow.setAntiAlias(true);
		paintShadow.setColor(Color.parseColor("#DDffffff"));		
		setLayerType(LAYER_TYPE_SOFTWARE, paintShadow);
		

		rectBack = new RectF();
		
		
		
		text = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0) ;
		text.setPadding(MainActivity.cf.dpix[10], MainActivity.cf.dpix[10], MainActivity.cf.dpix[10], MainActivity.cf.dpix[10]);
		text.setMovementMethod(new LinkMovementMethod());
		text.setLineSpacing(MainActivity.cf.dpix[3], 1);
		addView(text);
		
		//MainActivity.cf.Log("i am item news");
	}
	
	
	public void setData(DBNews news){
		isNew = news.isNew() == 2 ? false : true;
		
		//MainActivity.cf.Log("i am new :"+news.isNew() + "   --"+news.getId());
		String data = null;
		
		
		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa dd-MMM");
		String time = dateFormat.format(new Date(news.getLastUpdate()));
		
		if(isNew){
			data =  "<font color='#e53935'><b>"+news.getTitle()+"</b></font>"
					 + "<br>"
					 + "<font color='#212121'>"+news.getContain()+"</font>"
					 + "<br>"
					 + "<small><font color='#9E9E9E'>"+time+"</font></small>";
			news.setNew(1);
			MainActivity.db.updateNews(news);
			
		}else {			
			data =  "<b>"+news.getTitle()+"</b>"
					+ "<br>"
					+ "<font color='#212121'>"+news.getContain()+"</font>"
					+ "<br>"
					+ "<small><font color='#9E9E9E'>"+time+"</font></small>";
		}
		
		text.setText(Html.fromHtml(data));
		
		invalidate();
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		if(isNew){
			rectBack.set(0  , 0 , canvas.getWidth(), canvas.getHeight());
			paintShadow.setColor(MyColor.Red.A400);
			canvas.drawRoundRect(rectBack, MainActivity.cf.dpix[3] ,MainActivity.cf.dpix[3], paintShadow);
			
			rectBack.set(0 +shadowSize , 0 +shadowSize, canvas.getWidth() - shadowSize, canvas.getHeight() - shadowSize);
			canvas.drawRoundRect(rectBack, MainActivity.cf.dpix[3] ,MainActivity.cf.dpix[3], paintBack);
		}else {
			
			
			rectBack.set(0 + shadowSize , 0 + shadowSize, canvas.getWidth() - shadowSize, canvas.getHeight() - shadowSize);
			paintShadow.setColor(Color.parseColor("#DDffffff"));
			paintShadow.setShadowLayer(shadowSize, shadowSize/2, shadowSize/2, Color.parseColor("#50000000"));
			canvas.drawRoundRect(rectBack, MainActivity.cf.dpix[3] ,MainActivity.cf.dpix[3], paintShadow);
			
			rectBack.set(0  , 0 , canvas.getWidth() - shadowSize *2, canvas.getHeight() - shadowSize *2);
			canvas.drawRoundRect(rectBack, MainActivity.cf.dpix[3] ,MainActivity.cf.dpix[3], paintBack);
		}
		
	}

}
