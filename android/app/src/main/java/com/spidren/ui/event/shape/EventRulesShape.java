package com.spidren.ui.event.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class EventRulesShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(18.05f, 4.5f);
			quadTo(15.55f, 5.8f, 12.55f, 5.8f);
			quadTo(9.45f, 5.8f, 6.95f, 4.5f);
			lineTo(7.1f, 5.75f);
			quadTo(7.1f, 6.5f, 9.35f, 8.75f);
			lineTo(9.85f, 9.3f);
			lineTo(10.45f, 9.85f);
			lineTo(11.35f, 10.85f);
			lineTo(11.65f, 11.3f);
			lineTo(11.9f, 12.5f);
			lineTo(11.9f, 13f);
			lineTo(11.75f, 13.45f);
			lineTo(11.55f, 13.8f);
			lineTo(11.3f, 14.25f);
			lineTo(10.2f, 15.45f);
			lineTo(9.35f, 16.2f);
			quadTo(7.1f, 18.45f, 7.1f, 19.25f);
			lineTo(7.1f, 20.9f);
			lineTo(8.75f, 20.3f);
			lineTo(11f, 19.25f);
			quadTo(11.9f, 18.65f, 11.9f, 17.8f);
			quadTo(11.9f, 17.05f, 12.55f, 17.05f);
			quadTo(13.2f, 17.05f, 13.2f, 17.8f);
			quadTo(13.2f, 18.65f, 13.95f, 19.25f);
			quadTo(14.8f, 19.85f, 16.35f, 20.3f);
			lineTo(18f, 20.9f);
			lineTo(18f, 19.25f);
			quadTo(18f, 18.5f, 15.7f, 16.2f);
			lineTo(15.2f, 15.75f);
			lineTo(14.6f, 15.2f);
			lineTo(14.2f, 14.7f);
			lineTo(13.7f, 14.2f);
			lineTo(13.45f, 13.65f);
			lineTo(13.2f, 13.1f);
			lineTo(13.2f, 12.5f);
			lineTo(13.25f, 11.7f);
			quadTo(13.35f, 11.3f, 13.7f, 10.85f);
			lineTo(14.2f, 10.25f);
			lineTo(14.95f, 9.5f);
			lineTo(15.7f, 8.75f);
			quadTo(18f, 6.45f, 18f, 5.75f);
			lineTo(18.05f, 4.5f);
			moveTo(17.6f, 2.95f);
			quadTo(15.2f, 1.55f, 12.6f, 1.55f);
			quadTo(9.55f, 1.55f, 7.5f, 2.95f);
			lineTo(7f, 3.3f);
			lineTo(7.15f, 3.6f);
			quadTo(9.4f, 4.9f, 12.55f, 4.9f);
			quadTo(15.8f, 4.9f, 18f, 3.65f);
			quadTo(18.35f, 3.4f, 17.6f, 2.95f);
			moveTo(19.5f, 5.75f);
			quadTo(19.5f, 6.8f, 18.3f, 8.1f);
			lineTo(15.85f, 10.6f);
			quadTo(14.65f, 11.75f, 14.65f, 12.5f);
			quadTo(14.65f, 13.3f, 15.85f, 14.4f);
			lineTo(18.3f, 16.85f);
			quadTo(19.5f, 18.1f, 19.5f, 19.25f);
			lineTo(19.5f, 22.2f);
			quadTo(19.5f, 23.05f, 17.35f, 24.05f);
			quadTo(15.2f, 25f, 12.55f, 25f);
			quadTo(9.8f, 25f, 7.65f, 24.05f);
			quadTo(5.55f, 23.05f, 5.55f, 22.2f);
			lineTo(5.55f, 19.25f);
			quadTo(5.55f, 18.1f, 6.7f, 16.85f);
			lineTo(9.15f, 14.4f);
			quadTo(10.35f, 13.3f, 10.35f, 12.5f);
			quadTo(10.35f, 11.75f, 9.15f, 10.6f);
			lineTo(6.7f, 8.1f);
			quadTo(5.55f, 6.8f, 5.55f, 5.75f);
			lineTo(5.55f, 2.75f);
			quadTo(5.55f, 2f, 7.75f, 0.95f);
			quadTo(9.85f, 0f, 12.55f, 0f);
			quadTo(15.15f, 0f, 17.35f, 0.95f);
			quadTo(19.5f, 2f, 19.5f, 2.75f);
			lineTo(19.5f, 5.75f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EventRulesShape() {
	}

	public EventRulesShape(int width, int height, int x, int y) {

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