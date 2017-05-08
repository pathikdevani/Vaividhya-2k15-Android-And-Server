package com.spidren.ui.search;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.spidren.ui.components.IconView;
import com.spidren.ui.event.shape.EventBackShape;
import com.spidren.api.MyColor;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.macro.MacroTag;
import com.spidren.ui.search.shape.SearchCancleShape;
import com.spidren.vaividhya2k15.MainActivity;
import com.spidren.vaividhya2k15.R;

public class EventSearchTopBar extends MyRelativeLayout{

		private Paint paint;
		private int shadowSize;
		
		private IconView searchBack,searchCancleBtn;
		private EditText searchEdit;
		
		private onChangeListener listener;
		
		public interface onChangeListener{
			public void onChange(String str);
		}
		
		public void setOnChangeListener(onChangeListener listener){
			this.listener = listener;
		}
		
		
		public EventSearchTopBar(final Context context, int type, int width, int height, int x, int y) {
			super(context, type, width, height, x, y);
			
			setWillNotDraw(false);
			shadowSize = MainActivity.cf.dpix[2];
			
			paint = new Paint();
			paint.setColor(Color.WHITE);
			paint.setAntiAlias(true);
			paint.setShadowLayer(shadowSize, 0, 0, Color.parseColor("#B0000000"));
			setLayerType(LAYER_TYPE_SOFTWARE, paint);
			
			
			
			
			searchBack = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new EventBackShape(), height-shadowSize, .33f, 0, 0);
			searchBack.setColor(MyColor.Grey.A600);
			searchBack.getRipple().setColor(Color.BLACK);
			searchBack.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		            imm.hideSoftInputFromWindow(searchEdit.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
					MainActivity.macros.run(MacroTag.SEARCH_CLOSE);
				}
			});
			addView(searchBack);
			
			searchCancleBtn = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new SearchCancleShape(), height-shadowSize, .33f, width - (height-shadowSize) , 0);
			searchCancleBtn.setColor(MyColor.Grey.A600);
			searchCancleBtn.getRipple().setColor(Color.BLACK);
			searchCancleBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					searchEdit.setText("");
				}
			});
			addView(searchCancleBtn);
			
			
			LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			searchEdit = (EditText) layoutInflater.inflate(R.layout.edittext, this,false);
			searchEdit.setLayoutParams(new MyLayoutParms(MyLayoutParms.RELATIVE_LAYOUT, width -  (height - shadowSize) *2, height - shadowSize, height - shadowSize,0).getParams());
			searchEdit.setHint("Search Event");
			searchEdit.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
			searchEdit.setTextColor(MyColor.Grey.A900);
			searchEdit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
			searchEdit.setGravity(Gravity.CENTER_VERTICAL);
			searchEdit.setBackgroundColor(Color.WHITE);
			//searchEdit.requestFocus();
			addView(searchEdit);
			
			searchEdit.post(new Runnable() {
				
				@Override
				public void run() {
					searchEdit.requestFocus();
					//MainActivity.cf.context.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
					InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
			        if (imm != null) imm.showSoftInput(searchEdit, InputMethodManager.SHOW_IMPLICIT);
				}
			});
			
			
			
			
			searchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
			            // hide virtual keyboard
			        	
			            InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
			            imm.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
			            return true;
			        }
			        return false;
			    }
			});
			
			searchEdit.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					listener.onChange(s.toString());
				}
				
			});
		}
		
		@Override
		protected void onDraw(Canvas canvas) {

			canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight() - shadowSize, paint);
			super.onDraw(canvas);
		}
		
		
	}