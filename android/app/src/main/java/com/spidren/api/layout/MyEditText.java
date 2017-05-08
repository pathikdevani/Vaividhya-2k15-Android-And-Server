package com.spidren.api.layout;


import android.content.Context;
import android.widget.EditText;

public class MyEditText extends EditText {
	MyLayoutParms parms;

	public MyEditText(Context context) {
		super(context);

	}

	public MyEditText(Context context, int type, int width, int height, int x,
			int y) {
		super(context,null);

		setEnabled(true);
		
		parms = new MyLayoutParms(type, width, height, x, y);
		setLayoutParams(parms.getParams());
	}	
}
