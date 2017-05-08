package com.spidren.vaividhya2k15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.spidren.api.MyColor;
import com.spidren.api.layout.MyImageView;
import com.spidren.api.layout.MyLayoutParms;

public class StartupLayout extends RelativeLayout {

    private TextView text, spidren;
    private Bitmap b1, b2;
    private MyImageView back;


    @SuppressWarnings("deprecation")
    public StartupLayout(Context context, int time) {
        super(context);


        setBackgroundColor(MyColor.Blue.A500);

        text = new TextView(context);
        text.setText(Html.fromHtml("Vaividhya 15<br>"
                + "<i><small><small><small><small>"
                + "Explore the vividness of mindspark"
                + "</small></small></small></small></i>"));
        text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28);
        text.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        text.setTextColor(MyColor.Blue.A50);
        text.setGravity(Gravity.CENTER);
        addView(text);


        spidren = new TextView(context);
        RelativeLayout.LayoutParams spidrenParams = new RelativeLayout.LayoutParams(-2, -2);
        spidrenParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        spidrenParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        spidren.setLayoutParams(spidrenParams);
        spidren.setText("Spidren.Inc");
        spidren.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        spidren.setPadding(0, 0, 0, MainActivity.cf.dpix[15]);
        spidren.setTextColor(MyColor.Blue.A50);
        addView(spidren);


        back = new MyImageView(context, MyLayoutParms.RELATIVE_LAYOUT, -1, -1, 0, 0);
        back.setScaleType(ScaleType.CENTER_CROP);
        addView(back);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(false)
                .cacheInMemory(false)


                .displayer(new FadeInBitmapDisplayer(100, true, true, false))
                .resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .build();

        ImageViewAware aware = new ImageViewAware(back);
        ImageLoader.getInstance().displayImage("drawable://" + R.drawable.finalback, aware, defaultOptions);


        b1 = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        b2 = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b1);
        canvas.drawColor(MyColor.Blue.A400);
        canvas = new Canvas(b2);
        canvas.drawColor(Color.parseColor("#43a047"));
        BitmapDrawable drawables[] = new BitmapDrawable[2];
        drawables[0] = new BitmapDrawable(getResources(), b1);
        drawables[1] = new BitmapDrawable(getResources(), b2);

        final TransitionDrawable crossfader = new TransitionDrawable(drawables);
        setBackgroundDrawable(crossfader);
        crossfader.startTransition(time);


    }


    public void recycle() {
        b1.recycle();
        b2.recycle();
    }

}
