package com.spidren.ui.event;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.View;

import com.spidren.ui.components.IconView;
import com.spidren.ui.event.shape.EventBackShape;
import com.spidren.ui.event.shape.EventShareShape;
import com.spidren.ui.event.shape.EvevntMenuBarBackShape;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.layout.MyView;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBEvent;
import com.spidren.vaividhya2k15.MainActivity;

@SuppressLint("NewApi")
public class EventMenuBarlayout extends MyRelativeLayout{

	private MyView back,share;
	private EvevntMenuBarBackShape backShape;
	
	public EventMenuBarlayout(final Context context, int type,final DBEvent evevnt, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		
		setWillNotDraw(false);
		
		backShape = new EvevntMenuBarBackShape(width, height, 0, 0);
		
		
		back = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new EventBackShape(), height,.38f, 0, 0);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				MainActivity.macros.run(MacroTag.EVENT_CLOSE);
			}
		});
		addView(back);
		
		share = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT,new EventShareShape(), height,.38f, width - height, 0);
		share.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent share = new Intent(android.content.Intent.ACTION_SEND);
			    share.setType("text/plain");
			    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
			    share.putExtra(Intent.EXTRA_SUBJECT, "Vavidhya");
			    share.putExtra(Intent.EXTRA_TEXT, evevnt.getShareLink());
			    context.startActivity(Intent.createChooser(share, "Share link!"));
			}
		});
		addView(share);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		backShape.draw(canvas);
		super.onDraw(canvas);
	}

}
