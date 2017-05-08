package com.spidren.ui.list.shape;

import com.spidren.api.shape.MyShapeImg;
import com.spidren.vaividhya2k15.Config;

import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.Canvas;

public class EventItemWisedShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(25f, 25f);
			lineTo(0f, 0f);
			lineTo(25f, 0f);
			lineTo(25f, 25f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventItemWisedShape() {
	}

	public EventItemWisedShape(int width, int height, int x, int y) {

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
		P0.setColor(Config.BACK_COLOR);
		P0.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
	}
}