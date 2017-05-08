package com.spidren.ui.event.shape;

import android.graphics.LinearGradient;
import com.spidren.api.shape.MyShapeImg;
import android.graphics.Shader.TileMode;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class EvevntMenuBarBackShape extends MyShapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(25f, 0f);
			lineTo(25f, 25f);
			lineTo(0f, 25f);
			lineTo(0f, 0f);
			lineTo(25f, 0f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 25;
	float Wh = 25;

	public EvevntMenuBarBackShape() {
	}

	public EvevntMenuBarBackShape(int width, int height, int x, int y) {

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
		LinearGradient Lg = null;
		S0 = new Path0();
		S0.transform(matrix);
		Lg = new LinearGradient(13, 0, 13, 25, new int[] { Color.parseColor("#40000000"), Color.parseColor("#00000000") }, new float[] { 0.0f, 1.0f }, TileMode.MIRROR);
		Lg.setLocalMatrix(matrix);
		P0.setShader(Lg);
		P0.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
	}
}