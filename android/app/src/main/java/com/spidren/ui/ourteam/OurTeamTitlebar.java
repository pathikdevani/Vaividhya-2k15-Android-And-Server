package com.spidren.ui.ourteam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.View;

import com.spidren.api.MyColor;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.vaividhya2k15.MainActivity;

public class OurTeamTitlebar extends MyRelativeLayout implements View.OnClickListener{

	private MyTextView facultyText,studentText,sponsorText;
	private Paint paint;
	
	public OurTeamTitlebar(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		
		setWillNotDraw(false);
		
		facultyText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width/2, height - MainActivity.cf.dpix[2], 0, 0);
		facultyText.setText("Faculty");
		facultyText.setGravity(Gravity.CENTER);
		facultyText.setTag(0);
		facultyText.setRipple(true);
		facultyText.setOnClickListener(this);
		addView(facultyText);
		
		
		
		studentText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width/2, height - MainActivity.cf.dpix[2], width/2, 0);
		studentText.setText("Student");
		studentText.setGravity(Gravity.CENTER);
		studentText.setTag(1);
		studentText.setRipple(true);
		studentText.setOnClickListener(this);
		addView(studentText);
		
		
		/*sponsorText = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, width/3, height - MainActivity.cf.dpix[2], 2 * (width/3), 0);
		sponsorText.setText("Sponsors");
		sponsorText.setGravity(Gravity.CENTER);
		sponsorText.setTag(2);
		sponsorText.setRipple(true);
		sponsorText.setOnClickListener(this);
		addView(sponsorText);*/
		
		
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(MyColor.Blue.A700);
		paint.setShadowLayer(MainActivity.cf.dpix[2], 0, 0, Color.parseColor("#80000000"));
		setLayerType(LAYER_TYPE_SOFTWARE, paint);
		
	}
	
	
	public void setPosition(int position){
		
		if(position == 0){
			facultyText.setTextColor(Color.WHITE);
		}else {
			facultyText.setTextColor(Color.BLACK);
		}
		
		if(position == 1){
			studentText.setTextColor(Color.WHITE);
		}else {
			studentText.setTextColor(Color.BLACK);
		}
		
		/*if(position == 2){
			sponsorText.setTextColor(Color.WHITE);
		}else {
			sponsorText.setTextColor(Color.BLACK);
		}*/
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight() - MainActivity.cf.dpix[2], paint);
	}
	
	private onSelectIteam listner;
	
	public void setOnItemSelected(onSelectIteam listner){
		this.listner = listner;
	}
	
	public interface onSelectIteam{
		public void onIteam(int position);
	}

	@Override
	public void onClick(View v) {
		
		if(listner != null){
			listner.onIteam((int)(v.getTag()));
		}
		
	}

}
