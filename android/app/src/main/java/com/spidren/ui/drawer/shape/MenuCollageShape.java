package com.spidren.ui.drawer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class MenuCollageShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(25f, 9.6f);
			lineTo(0f, 9.6f);
			lineTo(0f, 7.65f);
			lineTo(11.8f, 7.65f);
			lineTo(11.8f, 3.95f);
			lineTo(19.05f, 3.95f);
			lineTo(19.05f, 7.65f);
			lineTo(25f, 7.65f);
			lineTo(25f, 9.6f);
			moveTo(20.85f, 12.05f);
			lineTo(17.75f, 12.05f);
			lineTo(17.75f, 15.85f);
			lineTo(20.85f, 15.85f);
			lineTo(20.85f, 12.05f);
			moveTo(22.6f, 21.05f);
			lineTo(10.35f, 21.05f);
			lineTo(10.35f, 14.6f);
			lineTo(6.75f, 14.6f);
			lineTo(6.75f, 21.05f);
			lineTo(2.3f, 21.05f);
			lineTo(2.3f, 10.55f);
			lineTo(22.6f, 10.55f);
			lineTo(22.6f, 21.05f);
			moveTo(13.6f, 12.05f);
			lineTo(13.6f, 15.85f);
			lineTo(16.75f, 15.85f);
			lineTo(16.75f, 12.05f);
			lineTo(13.6f, 12.05f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public MenuCollageShape() {
	}

	public MenuCollageShape(int width, int height, int x, int y) {

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