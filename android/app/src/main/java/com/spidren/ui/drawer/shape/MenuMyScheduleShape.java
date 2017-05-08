package com.spidren.ui.drawer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class MenuMyScheduleShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(21.3f, 21.3f);
			quadTo(17.85f, 25f, 12.5f, 25f);
			quadTo(7.25f, 25f, 3.8f, 21.3f);
			quadTo(0f, 17.8f, 0f, 12.5f);
			quadTo(0f, 7.2f, 3.8f, 3.7f);
			quadTo(7.25f, 0f, 12.5f, 0f);
			quadTo(17.85f, 0f, 21.3f, 3.7f);
			quadTo(25f, 7.2f, 25f, 12.5f);
			quadTo(25f, 17.8f, 21.3f, 21.3f);
			moveTo(12.5f, 3.15f);
			quadTo(8.45f, 3.15f, 5.95f, 5.95f);
			quadTo(3.15f, 8.45f, 3.15f, 12.5f);
			quadTo(3.15f, 16.6f, 5.95f, 19.1f);
			quadTo(8.5f, 21.85f, 12.5f, 21.85f);
			quadTo(16.6f, 21.85f, 19.1f, 19.1f);
			quadTo(21.85f, 16.5f, 21.85f, 12.5f);
			quadTo(21.85f, 8.45f, 19.1f, 5.95f);
			quadTo(16.5f, 3.15f, 12.5f, 3.15f);
			moveTo(14f, 4.65f);
			lineTo(14f, 13.1f);
			lineTo(18.75f, 15.65f);
			lineTo(16.75f, 17.95f);
			lineTo(10.95f, 14.85f);
			lineTo(10.95f, 4.65f);
			lineTo(14f, 4.65f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public MenuMyScheduleShape() {
	}

	public MenuMyScheduleShape(int width, int height, int x, int y) {

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