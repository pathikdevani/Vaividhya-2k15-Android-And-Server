package com.spidren.ui.drawer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class MenuNewsShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(20.8f, 21.1f);
			quadTo(20.3f, 20.5f, 20.3f, 19.55f);
			lineTo(20.3f, 3.95f);
			lineTo(1.55f, 3.95f);
			lineTo(1.55f, 19.55f);
			lineTo(1.6f, 19.95f);
			quadTo(1.65f, 20.35f, 2f, 20.75f);
			lineTo(3.15f, 21.1f);
			lineTo(20.8f, 21.1f);
			moveTo(21.9f, 2.35f);
			lineTo(21.9f, 5.5f);
			lineTo(25f, 5.5f);
			lineTo(25f, 19.55f);
			lineTo(24.75f, 21.05f);
			lineTo(24.15f, 22f);
			lineTo(23.45f, 22.45f);
			lineTo(22.9f, 22.65f);
			lineTo(22.65f, 22.7f);
			lineTo(3.15f, 22.7f);
			lineTo(1.6f, 22.35f);
			lineTo(0.65f, 21.6f);
			lineTo(0.25f, 20.65f);
			lineTo(0f, 19.9f);
			lineTo(0f, 19.55f);
			lineTo(0f, 2.35f);
			lineTo(21.9f, 2.35f);
			moveTo(18.75f, 11.75f);
			lineTo(11.7f, 11.75f);
			lineTo(11.7f, 10.2f);
			lineTo(18.75f, 10.2f);
			lineTo(18.75f, 11.75f);
			moveTo(18.75f, 8.6f);
			lineTo(3.15f, 8.6f);
			lineTo(3.15f, 7.05f);
			lineTo(18.75f, 7.05f);
			lineTo(18.75f, 8.6f);
			moveTo(11.7f, 14.85f);
			lineTo(11.7f, 13.3f);
			lineTo(18.75f, 13.3f);
			lineTo(18.75f, 14.85f);
			lineTo(11.7f, 14.85f);
			moveTo(17.2f, 16.45f);
			lineTo(17.2f, 18f);
			lineTo(11.7f, 18f);
			lineTo(11.7f, 16.45f);
			lineTo(17.2f, 16.45f);
			moveTo(10.15f, 18f);
			lineTo(3.15f, 18f);
			lineTo(3.15f, 10.2f);
			lineTo(10.15f, 10.2f);
			lineTo(10.15f, 18f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public MenuNewsShape() {
	}

	public MenuNewsShape(int width, int height, int x, int y) {

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