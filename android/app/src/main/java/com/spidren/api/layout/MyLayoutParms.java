package com.spidren.api.layout;

import android.support.v4.widget.DrawerLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MyLayoutParms {

	public static final int RELATIVE_LAYOUT  = 1;
	public static final int LINEAR_LAYOUT    = 2;
	public static final int FRAM_LAYOUT      = 3;
	public static final int DRAWER_LAYOUT    = 4;
	public static final int ABS_LIST_VIEW        = 5;

	private int type, width, height, x, y;

	public MyLayoutParms(int type, int width, int height, int x, int y) {
		this.type = type;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public LayoutParams getParams() {
		switch (type) {
		case RELATIVE_LAYOUT:
				return getRelativeParams();
		case LINEAR_LAYOUT:
				return getLinearParams();
		case FRAM_LAYOUT:
				return getFrameParams();
		case DRAWER_LAYOUT:
			return getDrawerParams();
		case ABS_LIST_VIEW:
			return getGridParams();

		default:
			break;
		}
		return null;
	}

	private LayoutParams getGridParams() {
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(width, height);
		return params;
	}

	private LayoutParams getDrawerParams() {
		DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(width, height);
		return params;
	}

	private LayoutParams getRelativeParams() {
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
		params.topMargin = y;
		params.leftMargin = x;
		return params;
	}

	private LayoutParams getLinearParams() {
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,height);
		return params;
	}

	private LayoutParams getFrameParams() {
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width,height);
		return params;
	}

}
