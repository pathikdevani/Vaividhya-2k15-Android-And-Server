package com.spidren.ui.developer.shape;

import com.spidren.api.shape.MyShapeImg;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class DeveloperLinkInShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(0.8f, 7.8f);
			lineTo(5.3f, 7.8f);
			lineTo(5.75f, 7.95f);
			lineTo(5.9f, 8.45f);
			lineTo(5.9f, 24.1f);
			lineTo(5.75f, 24.6f);
			quadTo(5.5f, 24.8f, 5.3f, 24.8f);
			lineTo(0.8f, 24.8f);
			quadTo(0.55f, 24.8f, 0.4f, 24.6f);
			lineTo(0.15f, 24.1f);
			lineTo(0.15f, 8.45f);
			lineTo(0.4f, 7.95f);
			quadTo(0.55f, 7.8f, 0.8f, 7.8f);
			moveTo(25f, 24.1f);
			lineTo(24.85f, 24.6f);
			lineTo(24.4f, 24.8f);
			lineTo(19.85f, 24.8f);
			quadTo(19.5f, 24.8f, 19.35f, 24.6f);
			lineTo(19.15f, 24.1f);
			lineTo(19.15f, 14.6f);
			quadTo(19.15f, 13.3f, 18.65f, 12.7f);
			quadTo(18.2f, 12.15f, 16.95f, 12.15f);
			quadTo(15.35f, 12.15f, 14.7f, 13.05f);
			quadTo(14.05f, 14f, 14.05f, 15.7f);
			lineTo(14.05f, 24.2f);
			lineTo(13.85f, 24.65f);
			lineTo(13.4f, 24.8f);
			lineTo(8.9f, 24.8f);
			lineTo(8.55f, 24.65f);
			lineTo(8.3f, 24.2f);
			lineTo(8.3f, 8.45f);
			lineTo(8.55f, 7.95f);
			quadTo(8.75f, 7.8f, 9f, 7.8f);
			lineTo(13.35f, 7.8f);
			lineTo(13.7f, 7.9f);
			lineTo(13.85f, 8.2f);
			lineTo(13.95f, 8.5f);
			lineTo(13.95f, 8.95f);
			quadTo(15.65f, 7.35f, 18.45f, 7.35f);
			quadTo(21.55f, 7.35f, 23.3f, 8.95f);
			quadTo(25.1f, 10.5f, 25f, 13.55f);
			lineTo(25f, 24.1f);
			moveTo(5.2f, 5.1f);
			quadTo(4.25f, 6.05f, 3.05f, 6.05f);
			quadTo(1.8f, 6.05f, 0.85f, 5.1f);
			quadTo(0f, 4.25f, 0f, 3f);
			quadTo(0f, 1.7f, 0.85f, 0.85f);
			quadTo(1.8f, 0f, 3.05f, 0f);
			quadTo(4.25f, 0f, 5.2f, 0.85f);
			quadTo(6.05f, 1.7f, 6.05f, 3f);
			quadTo(6.05f, 4.25f, 5.2f, 5.1f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public DeveloperLinkInShape() {
	}

	public DeveloperLinkInShape(int width, int height, int x, int y) {

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