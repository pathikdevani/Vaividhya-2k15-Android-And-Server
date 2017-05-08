package com.spidren.ui.developer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class DeveloperCallShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(24.9f, 20.4f);
			lineTo(24.85f, 20.75f);
			lineTo(21.05f, 24.5f);
			quadTo(20.65f, 24.95f, 20.1f, 24.95f);
			lineTo(16.6f, 24.55f);
			quadTo(14.7f, 23.9f, 13.05f, 22.8f);
			lineTo(10.05f, 20.65f);
			lineTo(7.8f, 18.75f);
			lineTo(7f, 18.05f);
			lineTo(6.15f, 17.15f);
			lineTo(4.3f, 15f);
			lineTo(2.15f, 11.85f);
			quadTo(1.2f, 10.3f, 0.55f, 8.4f);
			quadTo(-0.1f, 6.45f, 0f, 4.85f);
			lineTo(0.1f, 4.9f);
			quadTo(0.15f, 4.4f, 0.55f, 3.95f);
			lineTo(4.3f, 0.15f);
			quadTo(4.7f, -0.2f, 4.9f, 0.3f);
			lineTo(7.95f, 5.95f);
			quadTo(8.25f, 6.45f, 7.8f, 6.9f);
			lineTo(6.45f, 8.3f);
			quadTo(6.05f, 8.7f, 6.05f, 9.3f);
			quadTo(6.05f, 10.15f, 7f, 11.65f);
			lineTo(8.85f, 14.15f);
			lineTo(9.8f, 15.15f);
			lineTo(10.9f, 16.25f);
			lineTo(13.2f, 17.95f);
			quadTo(14.85f, 18.9f, 15.75f, 19f);
			quadTo(16.35f, 19f, 16.7f, 18.55f);
			lineTo(18.35f, 16.9f);
			lineTo(19.3f, 16.85f);
			lineTo(24.7f, 20.05f);
			lineTo(24.9f, 20.4f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public DeveloperCallShape() {
	}

	public DeveloperCallShape(int width, int height, int x, int y) {

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