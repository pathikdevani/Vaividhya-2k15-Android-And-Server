package com.spidren.ui.event.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class EventTaskShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(22.9f, 10.4f);
			lineTo(22.9f, 23.4f);
			quadTo(22.9f, 24.05f, 22.5f, 24.5f);
			quadTo(22f, 25f, 21.35f, 25f);
			lineTo(3.7f, 25f);
			quadTo(3.05f, 25f, 2.6f, 24.5f);
			quadTo(2.1f, 24.05f, 2.1f, 23.4f);
			lineTo(2.1f, 1.55f);
			quadTo(2.1f, 0.9f, 2.6f, 0.4f);
			quadTo(3.05f, 0f, 3.7f, 0f);
			lineTo(12.5f, 0f);
			lineTo(13.95f, 0.3f);
			lineTo(15.2f, 1.1f);
			lineTo(21.8f, 7.7f);
			lineTo(22.6f, 8.95f);
			lineTo(22.9f, 10.4f);
			moveTo(20.8f, 10.4f);
			lineTo(14f, 10.4f);
			quadTo(13.4f, 10.4f, 12.9f, 9.95f);
			quadTo(12.5f, 9.45f, 12.5f, 8.85f);
			lineTo(12.5f, 2.1f);
			lineTo(4.1f, 2.1f);
			lineTo(4.1f, 22.85f);
			lineTo(4.2f, 22.9f);
			lineTo(20.8f, 22.9f);
			lineTo(20.8f, 10.4f);
			moveTo(14.6f, 8.35f);
			lineTo(19.45f, 8.35f);
			lineTo(14.6f, 3.5f);
			lineTo(14.6f, 8.35f);
			moveTo(6.25f, 14.05f);
			lineTo(6.25f, 13f);
			quadTo(6.25f, 12.8f, 6.4f, 12.65f);
			quadTo(6.55f, 12.5f, 6.75f, 12.5f);
			lineTo(18.2f, 12.5f);
			lineTo(18.6f, 12.65f);
			lineTo(18.75f, 13f);
			lineTo(18.75f, 14.05f);
			lineTo(18.6f, 14.45f);
			lineTo(18.2f, 14.6f);
			lineTo(6.75f, 14.6f);
			lineTo(6.4f, 14.45f);
			lineTo(6.25f, 14.05f);
			moveTo(6.25f, 17.15f);
			quadTo(6.25f, 16.95f, 6.4f, 16.8f);
			quadTo(6.55f, 16.65f, 6.75f, 16.65f);
			lineTo(18.2f, 16.65f);
			lineTo(18.6f, 16.8f);
			lineTo(18.75f, 17.15f);
			lineTo(18.75f, 18.2f);
			lineTo(18.6f, 18.6f);
			lineTo(18.2f, 18.75f);
			lineTo(6.75f, 18.75f);
			lineTo(6.4f, 18.6f);
			quadTo(6.25f, 18.5f, 6.25f, 18.2f);
			lineTo(6.25f, 17.15f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventTaskShape() {
	}

	public EventTaskShape(int width, int height, int x, int y) {

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