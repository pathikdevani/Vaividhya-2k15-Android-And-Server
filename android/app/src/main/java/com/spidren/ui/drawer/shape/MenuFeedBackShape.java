package com.spidren.ui.drawer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class MenuFeedBackShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(24.95f, 11.75f);
			quadTo(24.95f, 14.4f, 23.3f, 16.7f);
			quadTo(21.65f, 19f, 18.75f, 20.3f);
			quadTo(15.9f, 21.6f, 12.45f, 21.6f);
			quadTo(9.9f, 21.6f, 7.55f, 20.8f);
			lineTo(7.6f, 20.85f);
			lineTo(0f, 23.1f);
			lineTo(1.55f, 20.4f);
			lineTo(2.2f, 18.2f);
			lineTo(2.3f, 17.35f);
			quadTo(0f, 14.85f, 0f, 11.75f);
			quadTo(0f, 9.05f, 1.75f, 6.8f);
			quadTo(3.4f, 4.55f, 6.25f, 3.2f);
			quadTo(9.15f, 1.9f, 12.5f, 1.9f);
			quadTo(15.9f, 1.9f, 18.8f, 3.2f);
			quadTo(21.7f, 4.55f, 23.35f, 6.8f);
			quadTo(25f, 9.05f, 25f, 11.75f);
			lineTo(24.95f, 11.75f);
			moveTo(12.85f, 10.2f);
			quadTo(12.25f, 10.2f, 11.8f, 10.7f);
			quadTo(11.35f, 11.15f, 11.35f, 11.75f);
			quadTo(11.35f, 12.4f, 11.8f, 12.85f);
			quadTo(12.25f, 13.3f, 12.85f, 13.3f);
			quadTo(13.55f, 13.3f, 13.95f, 12.85f);
			lineTo(14.4f, 11.75f);
			quadTo(14.4f, 11.15f, 13.95f, 10.7f);
			quadTo(13.55f, 10.2f, 12.85f, 10.2f);
			moveTo(16.65f, 11.75f);
			quadTo(16.65f, 12.4f, 17.1f, 12.85f);
			quadTo(17.55f, 13.3f, 18.15f, 13.3f);
			lineTo(19.2f, 12.85f);
			quadTo(19.7f, 12.4f, 19.7f, 11.75f);
			quadTo(19.7f, 11.15f, 19.2f, 10.7f);
			quadTo(18.8f, 10.2f, 18.15f, 10.2f);
			quadTo(17.55f, 10.2f, 17.1f, 10.7f);
			quadTo(16.65f, 11.15f, 16.65f, 11.75f);
			moveTo(7.6f, 10.2f);
			quadTo(6.95f, 10.2f, 6.5f, 10.7f);
			quadTo(6.05f, 11.15f, 6.05f, 11.75f);
			quadTo(6.05f, 12.4f, 6.5f, 12.85f);
			quadTo(6.95f, 13.3f, 7.6f, 13.3f);
			quadTo(8.25f, 13.3f, 8.65f, 12.85f);
			quadTo(9.1f, 12.4f, 9.1f, 11.75f);
			quadTo(9.1f, 11.15f, 8.65f, 10.7f);
			quadTo(8.25f, 10.2f, 7.6f, 10.2f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public MenuFeedBackShape() {
	}

	public MenuFeedBackShape(int width, int height, int x, int y) {

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