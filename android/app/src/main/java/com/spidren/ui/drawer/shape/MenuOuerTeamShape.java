package com.spidren.ui.drawer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class MenuOuerTeamShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(22.9f, 18.6f);
			lineTo(23f, 20.75f);
			lineTo(23f, 21.75f);
			lineTo(18.3f, 21.75f);
			lineTo(18.3f, 18.6f);
			quadTo(18.3f, 17.45f, 17.65f, 16.9f);
			lineTo(14.45f, 15f);
			quadTo(15.25f, 14.4f, 15.25f, 13.25f);
			lineTo(15f, 12.55f);
			lineTo(14.6f, 11.5f);
			lineTo(14.3f, 11.15f);
			quadTo(14.05f, 11f, 14f, 10.25f);
			quadTo(14f, 9.75f, 14.25f, 9.65f);
			lineTo(14.1f, 8.4f);
			quadTo(14f, 7.6f, 14.6f, 6.75f);
			quadTo(15.15f, 5.9f, 16.55f, 5.9f);
			quadTo(18f, 5.9f, 18.6f, 6.75f);
			quadTo(19.2f, 7.6f, 19.1f, 8.4f);
			lineTo(18.95f, 9.65f);
			lineTo(19.2f, 10.25f);
			quadTo(19.15f, 11f, 18.9f, 11.15f);
			lineTo(18.6f, 11.5f);
			lineTo(18.2f, 12.55f);
			quadTo(17.9f, 12.9f, 17.9f, 13.25f);
			quadTo(17.9f, 14.15f, 18.35f, 14.65f);
			quadTo(18.8f, 15.15f, 20f, 15.65f);
			quadTo(22.3f, 16.6f, 22.7f, 17.35f);
			lineTo(22.9f, 18.6f);
			moveTo(11.4f, 8.25f);
			quadTo(11.7f, 8.45f, 11.7f, 9.05f);
			quadTo(11.6f, 10f, 11.3f, 10.25f);
			lineTo(10.9f, 10.7f);
			quadTo(10.8f, 11.6f, 10.4f, 12.1f);
			quadTo(10f, 12.6f, 10f, 13.05f);
			quadTo(10f, 14.2f, 10.55f, 14.9f);
			lineTo(12.75f, 16.25f);
			quadTo(16.55f, 17.85f, 16.55f, 18.85f);
			lineTo(16.55f, 21.75f);
			lineTo(2f, 21.75f);
			lineTo(2f, 17.85f);
			quadTo(2f, 16.95f, 3.75f, 16.25f);
			lineTo(5.95f, 14.9f);
			quadTo(6.55f, 14.2f, 6.55f, 13.05f);
			quadTo(6.55f, 12.6f, 6.15f, 12.1f);
			quadTo(5.75f, 11.6f, 5.6f, 10.7f);
			lineTo(5.25f, 10.25f);
			quadTo(4.9f, 10f, 4.8f, 9.05f);
			lineTo(4.9f, 8.55f);
			lineTo(5f, 8.3f);
			lineTo(5.1f, 8.25f);
			lineTo(4.9f, 6.55f);
			quadTo(4.8f, 5.5f, 5.6f, 4.4f);
			quadTo(6.35f, 3.25f, 8.25f, 3.25f);
			quadTo(10.15f, 3.25f, 10.9f, 4.4f);
			quadTo(11.7f, 5.5f, 11.6f, 6.55f);
			lineTo(11.4f, 8.25f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public MenuOuerTeamShape() {
	}

	public MenuOuerTeamShape(int width, int height, int x, int y) {

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