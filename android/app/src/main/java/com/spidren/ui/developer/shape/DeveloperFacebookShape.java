package com.spidren.ui.developer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class DeveloperFacebookShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(16.35f, 4.8f);
			quadTo(15.2f, 4.8f, 14.8f, 5.35f);
			quadTo(14.4f, 5.9f, 14.4f, 6.9f);
			lineTo(14.4f, 8.6f);
			lineTo(18.65f, 8.6f);
			lineTo(18.2f, 13.75f);
			lineTo(14.4f, 13.75f);
			lineTo(14.4f, 25f);
			lineTo(9.25f, 25f);
			lineTo(9.25f, 13.75f);
			lineTo(6.35f, 13.75f);
			lineTo(6.35f, 8.6f);
			lineTo(9.25f, 8.6f);
			lineTo(9.25f, 4.8f);
			quadTo(9.25f, 2.5f, 10.55f, 1.25f);
			quadTo(11.85f, 0f, 14.4f, 0f);
			lineTo(18.55f, 0f);
			lineTo(18.55f, 4.7f);
			lineTo(18.65f, 4.8f);
			lineTo(16.35f, 4.8f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public DeveloperFacebookShape() {
	}

	public DeveloperFacebookShape(int width, int height, int x, int y) {

		pos(width, height, x, y);

	}

	@Override
	public void setPose(int width, int height, int x, int y) {
		pos(width, height, x, y);
	}

	@Override
	public void setColor(int color) {
		P0.setColor(color);
	}

	public void pos(int width, int height, int x, int y) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		S0 = new Path0();
		S0.transform(matrix);
		P0.setColor(Color.parseColor("#ffffff"));
		P0.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
	}
}