package com.spidren.ui.drawer.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.spidren.api.shape.MyShapeImg;

public class ListDrawerShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(25f, 5.45f);
			quadTo(25f, 6.15f, 24.45f, 6.6f);
			quadTo(24f, 7.2f, 23.25f, 7.2f);
			lineTo(1.85f, 7.2f);
			quadTo(1.05f, 7.2f, 0.65f, 6.6f);
			quadTo(0f, 6.15f, 0f, 5.45f);
			quadTo(0f, 4.65f, 0.5f, 4.25f);
			quadTo(1.05f, 3.6f, 1.85f, 3.6f);
			lineTo(23.25f, 3.6f);
			quadTo(24f, 3.6f, 24.6f, 4.25f);
			quadTo(25f, 4.65f, 25f, 5.45f);
			moveTo(24.6f, 11.35f);
			quadTo(25f, 11.8f, 25f, 12.55f);
			quadTo(25f, 13.3f, 24.45f, 13.75f);
			quadTo(24f, 14.3f, 23.25f, 14.3f);
			lineTo(1.85f, 14.3f);
			quadTo(1.05f, 14.3f, 0.65f, 13.75f);
			quadTo(0f, 13.3f, 0f, 12.55f);
			quadTo(0f, 11.8f, 0.5f, 11.35f);
			quadTo(1.05f, 10.75f, 1.85f, 10.75f);
			lineTo(23.25f, 10.75f);
			quadTo(24f, 10.75f, 24.6f, 11.35f);
			moveTo(24.45f, 20.85f);
			quadTo(24f, 21.45f, 23.25f, 21.45f);
			lineTo(1.85f, 21.45f);
			quadTo(1.05f, 21.45f, 0.65f, 20.85f);
			quadTo(0f, 20.45f, 0f, 19.7f);
			quadTo(0f, 18.95f, 0.5f, 18.5f);
			quadTo(1.05f, 17.9f, 1.85f, 17.9f);
			lineTo(23.25f, 17.9f);
			quadTo(24f, 17.9f, 24.6f, 18.5f);
			quadTo(25f, 18.95f, 25f, 19.7f);
			quadTo(25f, 20.45f, 24.45f, 20.85f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public ListDrawerShape() {
	}

	public ListDrawerShape(int width, int height, int x, int y) {

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