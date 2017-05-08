package com.spidren.ui.developer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.spidren.api.layout.MyImageView;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyTextView;
import com.spidren.api.layout.MyView;
import com.spidren.vaividhya2k15.MainActivity;
import com.spidren.vaividhya2k15.R;

public class DeveloperLayout extends MyRelativeLayout {

	private MyImageView backImage;
	private MyView backSurface;
	private MyTextView myName;

	private MyRelativeLayout myNameContainer;

	private DeveloperConnectBar connectBar;

	public DeveloperLayout(Context context, int type, int width, int height,
			int x, int y) {
		super(context, type, width, height, x, y);

		setBackgroundColor(Color.BLACK);

		backImage = new MyImageView(context, MyLayoutParms.RELATIVE_LAYOUT,width, height, 0, 0);
		backImage.setScaleType(ScaleType.CENTER_CROP);
		addView(backImage);

		backSurface = new MyView(context, MyLayoutParms.RELATIVE_LAYOUT, width,
				height, 0, 0);
		backSurface.setBackgroundColor(Color.BLACK);
		backSurface.getBackground().setAlpha(150);
		addView(backSurface);

		myNameContainer = new MyRelativeLayout(context,
				MyLayoutParms.RELATIVE_LAYOUT, width, height
						- MainActivity.cf.dpix[150], 0, 0);
		addView(myNameContainer);

		myName = new MyTextView(context, MyLayoutParms.RELATIVE_LAYOUT, -1, -2,
				0, 0);
		myName.setText(Html
				.fromHtml("<small>develop by</small><br><big><big>Pathik Devani</big></big><br><small><i>Computer 3rd year</i></small><br><br><br><small>maintained by\u00A0<a href=\"http://ssasit.org/app/department/about-department.aspx?deptid=MQ==-bSh7bgiPfvY=\">Computer department</a></small>."));
		myName.setMovementMethod(LinkMovementMethod.getInstance());
		myName.setTextColor(Color.WHITE);
		myName.setGravity(Gravity.CENTER);
		((RelativeLayout.LayoutParams) myName.getLayoutParams())
				.addRule(RelativeLayout.CENTER_IN_PARENT);
		myNameContainer.addView(myName);

		connectBar = new DeveloperConnectBar(context, type, width,
				MainActivity.cf.dpix[60], 0, height - MainActivity.cf.dpix[60]);
		addView(connectBar);

	}

	public void readyForView() {
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
				.displayer(new FadeInBitmapDisplayer(250, true, true, false))
				.build();

		ImageLoader.getInstance().displayImage( "drawable://" + R.drawable.devnew, backImage, defaultOptions);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

}
