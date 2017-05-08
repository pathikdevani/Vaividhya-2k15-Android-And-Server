package com.spidren.ui.developer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class DeveloperMailShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(24.15f, 5.95f);
			lineTo(18.85f, 8.8f);
			lineTo(13.75f, 11.5f);
			lineTo(12.5f, 11.75f);
			lineTo(11.25f, 11.5f);
			lineTo(6.15f, 8.8f);
			lineTo(0.85f, 5.95f);
			quadTo(-0.05f, 5.45f, 0.05f, 4.85f);
			quadTo(0.15f, 4.45f, 0.8f, 4.45f);
			lineTo(24.25f, 4.45f);
			quadTo(25.3f, 4.45f, 24.8f, 5.35f);
			lineTo(24.15f, 5.95f);
			moveTo(25f, 9f);
			lineTo(25f, 19.25f);
			lineTo(24.55f, 20.1f);
			lineTo(23.6f, 20.55f);
			lineTo(1.4f, 20.55f);
			quadTo(0.9f, 20.55f, 0.45f, 20.1f);
			lineTo(0f, 19.25f);
			lineTo(0f, 9f);
			quadTo(0f, 8.45f, 0.5f, 8.75f);
			lineTo(11.25f, 14.3f);
			lineTo(12.5f, 14.55f);
			lineTo(13.75f, 14.3f);
			lineTo(24.45f, 8.75f);
			quadTo(25f, 8.45f, 25f, 9f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public DeveloperMailShape() {
	}

	public DeveloperMailShape(int width, int height, int x, int y) {

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