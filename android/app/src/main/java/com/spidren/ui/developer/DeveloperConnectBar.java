package com.spidren.ui.developer;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;

import com.spidren.ui.components.IconView;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.ui.developer.shape.DeveloperCallShape;
import com.spidren.ui.developer.shape.DeveloperFacebookShape;
import com.spidren.ui.developer.shape.DeveloperLinkInShape;
import com.spidren.ui.developer.shape.DeveloperMailShape;
import com.spidren.vaividhya2k15.MainActivity;

public class DeveloperConnectBar extends MyRelativeLayout implements View.OnClickListener{

	
	private IconView call,mail,facebook,linkedin;
	
	private int leftMargin;
	
	public DeveloperConnectBar(Context context, int type, int width, int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		
		leftMargin = (width - 4 * height)/2;
		
		
		call = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new DeveloperCallShape(), height, .33f, leftMargin, 0);
		call.setTag("call");
		call.setOnClickListener(this);
		addView(call);
		
		mail = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new DeveloperMailShape(), height, .33f, height + leftMargin, 0);
		mail.setTag("mail");
		mail.setOnClickListener(this);
		addView(mail);
		
		facebook = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new DeveloperFacebookShape(), height, .33f, height * 2 + leftMargin, 0);
		facebook.setTag("facebook");
		facebook.setOnClickListener(this);
		addView(facebook);
		
		linkedin = new IconView(context, MyLayoutParms.RELATIVE_LAYOUT, new DeveloperLinkInShape(), height, .33f, height * 3 + leftMargin, 0);
		linkedin.setTag("linkedin");
		linkedin.setOnClickListener(this);
		addView(linkedin);
		
		
	}

	@Override
	public void onClick(View v) {
		switch ((String)v.getTag()) {
		
		case "call":
				doCall();
			break;
			
		case "mail":
				doMail();
			break;

		case "facebook":
				goFacbook();
			break;

		case "linkedin":
				goLinkedIn();
			break;

		default:
			break;
		}
		
	}

	private void goLinkedIn() {
		//MainActivity.cf.goToLink("https://www.linkedin.com/in/pathikdevani");	
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/342381351"));
		final PackageManager packageManager = getContext().getPackageManager();
		final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		if (list.isEmpty()) {
		    MainActivity.cf.goToLink("http://www.linkedin.com/profile/view?id=342381351");
		}else {
			MainActivity.cf.context.startActivity(intent);
		}
		
	}

	private void goFacbook() {
		MainActivity.cf.goFacebook("100004238705306", "https://www.facebook.com/devani.pathiki");
	}

	private void doMail() {
		MainActivity.cf.sendMail("pathikdevani@gmail.com", "App Developer", "I am");
	}

	private void doCall() {
		String posted_by = "+91-90-33-583224";

		String uri = "tel:" + posted_by.trim();
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse(uri));
		MainActivity.cf.context.startActivity(intent);
	}
	
	
	
	

}
