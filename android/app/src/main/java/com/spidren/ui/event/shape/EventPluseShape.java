package com.spidren.ui.event.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.spidren.api.shape.MyShapeImg;

public class EventPluseShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(25f, 12.55f);
			quadTo(25f, 14.65f, 23.75f, 14.65f);
			lineTo(14.75f, 14.65f);
			lineTo(14.75f, 23.6f);
			quadTo(14.75f, 25.05f, 12.6f, 25.05f);
			quadTo(10.45f, 25.05f, 10.45f, 23.6f);
			lineTo(10.45f, 14.65f);
			lineTo(1.25f, 14.65f);
			quadTo(0f, 14.65f, 0f, 12.55f);
			quadTo(0f, 10.4f, 1.25f, 10.4f);
			lineTo(10.45f, 10.4f);
			lineTo(10.45f, 1.45f);
			quadTo(10.45f, 0f, 12.6f, 0f);
			quadTo(14.75f, 0f, 14.75f, 1.45f);
			lineTo(14.75f, 10.4f);
			lineTo(23.75f, 10.4f);
			quadTo(25f, 10.4f, 25f, 12.55f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventPluseShape() {
	}

	public EventPluseShape(int width, int height, int x, int y) {

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
