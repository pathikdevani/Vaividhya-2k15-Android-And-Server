package com.spidren.ui.search.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class SearchCancleShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(23f, 21.5f);
			quadTo(23f, 22.15f, 22.55f, 22.55f);
			quadTo(22.15f, 23f, 21.55f, 22.95f);
			quadTo(20.95f, 22.9f, 20.6f, 22.5f);
			lineTo(12.5f, 14.55f);
			lineTo(4.5f, 22.5f);
			lineTo(3.45f, 22.95f);
			quadTo(2.85f, 22.95f, 2.45f, 22.45f);
			quadTo(2.05f, 22.1f, 2f, 21.5f);
			quadTo(2.05f, 20.85f, 2.5f, 20.5f);
			lineTo(10.45f, 12.5f);
			lineTo(2.5f, 4.55f);
			quadTo(2.2f, 4.15f, 2.15f, 3.5f);
			quadTo(2.15f, 2.9f, 2.55f, 2.5f);
			quadTo(2.95f, 2.1f, 3.55f, 2.05f);
			quadTo(4.25f, 2.1f, 4.55f, 2.5f);
			lineTo(12.5f, 10.45f);
			lineTo(20.45f, 2.5f);
			quadTo(20.8f, 2.1f, 21.5f, 2.1f);
			quadTo(22.15f, 2.1f, 22.5f, 2.5f);
			quadTo(22.95f, 2.9f, 22.9f, 3.55f);
			lineTo(22.5f, 4.5f);
			lineTo(14.6f, 12.5f);
			lineTo(22.6f, 20.5f);
			quadTo(23f, 20.85f, 23f, 21.5f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public SearchCancleShape() {
	}

	public SearchCancleShape(int width, int height, int x, int y) {

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