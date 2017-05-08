package com.spidren.ui.drawer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.spidren.ui.event.EventLayout;
import com.spidren.ui.event.EventLayout.onAttached;
import com.spidren.ui.list.EventListLayout;
import com.spidren.ui.myschedule.MyScheduleLayout;
import com.spidren.ui.ourteam.OurTeamLayout;
import com.spidren.api.backpress.Back;
import com.spidren.api.backpress.BackTag;
import com.spidren.api.layout.MyLayoutParms;
import com.spidren.api.layout.MyRelativeLayout;
import com.spidren.api.macro.Macro;
import com.spidren.api.macro.MacroTag;
import com.spidren.database.DBEvent;
import com.spidren.sponsor.SponsorListLayout;
import com.spidren.ui.developer.DeveloperLayout;
import com.spidren.ui.news.NewsLayout;
import com.spidren.ui.search.EventSearchLayout;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class DrawerDataLayout extends MyRelativeLayout{

	private final int mainTitleBarHeight = MainActivity.cf.dpix[55];
	private View currentView;
	
	
	private MainTitleBarLayout mainTitleBar;
	private EventListLayout eventListLayout;
	
	
	private EventSearchLayout eventSearchLayout;
	private EventLayout eventLayout;
	private MyScheduleLayout myScheduleLayot;
	private DeveloperLayout developerLayout;
	private OurTeamLayout ourTeamLayout;
	private NewsLayout newsLayout;
	private SponsorListLayout sponsorList;
	
	private int viewSatck = 0;
	
	public DrawerDataLayout(final Context context, int type, final int width, final int height, int x, int y) {
		super(context, type, width, height, x, y);
		
		setBackgroundColor(Config.BACK_COLOR);
		
		mainTitleBar = new MainTitleBarLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, mainTitleBarHeight, 0, 0);
		addView(mainTitleBar);
		
		eventListLayout = new EventListLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height - mainTitleBarHeight, 0, mainTitleBarHeight);
		eventListLayout.setTag("EVENT_LIST");
		addView(eventListLayout);
		
		
		
		mainTitleBar.bringToFront();
		currentView = eventListLayout;
		
		
		
		//event_list
		MainActivity.macros.addMacro(new Macro(MacroTag.EVENT_LIST_OPEN) {
			@Override
			public void run(Object obj) {
				
				if(currentView != eventListLayout){
					
					eventListLayout = new EventListLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height - mainTitleBarHeight, 0, mainTitleBarHeight);
					eventListLayout.setTag("EVENT_LIST");
					addView(eventListLayout);
					
					mainTitleBar.setTitleBarText("Events");
					mainTitleBar.bringToFront();
					
					ObjectAnimator animNew = ObjectAnimator.ofFloat(eventListLayout, "alpha", 0f,1f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.setDuration(200);
					setAnim.setInterpolator(new AccelerateInterpolator(1.4f));
					setAnim.play(animNew);
					setAnim.start();
					
					
					setAnim.addListener(new Animator.AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(currentView);
							
							currentView = eventListLayout;
							
						}
						
						@Override
						public void onAnimationCancel(Animator animation) {
							// TODO Auto-generated method stub
							
						}
					});
				}
				
			}
		});
		
		
		
		
		//sponsor list
		MainActivity.macros.addMacro(new Macro(MacroTag.SPONSOR_LIST_OPEN) {
			@Override
			public void run(Object obj) {

				if(currentView != sponsorList){

					sponsorList = new SponsorListLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height - mainTitleBarHeight, 0, mainTitleBarHeight);
					sponsorList.setTag("SPONSOR_LIST");
					addView(sponsorList);

					mainTitleBar.setTitleBarText("Sponsors");
					mainTitleBar.bringToFront();

					ObjectAnimator animNew = ObjectAnimator.ofFloat(sponsorList, "alpha", 0f,1f);

					AnimatorSet setAnim = new AnimatorSet();
					setAnim.setDuration(200);
					setAnim.setInterpolator(new AccelerateInterpolator(1.4f));
					setAnim.play(animNew);
					setAnim.start();


					setAnim.addListener(new Animator.AnimatorListener() {

						@Override
						public void onAnimationStart(Animator animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationRepeat(Animator animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(currentView);

							currentView = sponsorList;

						}

						@Override
						public void onAnimationCancel(Animator animation) {
							// TODO Auto-generated method stub

						}
					});
				}

			}
		});
		
		
		
		
		
		//my schudule
		MainActivity.macros.addMacro(new Macro(MacroTag.MY_SCHEDULE_OPEN) {
			@Override
			public void run(Object obj) {

				if(currentView != myScheduleLayot){
					
					myScheduleLayot = new MyScheduleLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height - mainTitleBarHeight, 0, mainTitleBarHeight);
					myScheduleLayot.setTag("SCHEDULE");
					addView(myScheduleLayot);
					
					
					mainTitleBar.setTitleBarText("My Schedule");
					mainTitleBar.bringToFront();
					
					ObjectAnimator animNew = ObjectAnimator.ofFloat(myScheduleLayot, "alpha", 0f,1f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.setDuration(200);
					setAnim.setInterpolator(new AccelerateInterpolator(1.4f));
					setAnim.play(animNew);
					setAnim.start();
					
					
					setAnim.addListener(new Animator.AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(currentView);
							
							currentView = myScheduleLayot;
						}
						
						@Override
						public void onAnimationCancel(Animator animation) {
							// TODO Auto-generated method stub
							
						}
					});
				}
				
			}
		});
		
		//news
		MainActivity.macros.addMacro(new Macro(MacroTag.NEWS_OPEN) {
			@Override
			public void run(Object obj) {

				if(currentView != newsLayout){

					newsLayout = new NewsLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height - mainTitleBarHeight, 0, mainTitleBarHeight);
					newsLayout.setTag("NEWS");
					addView(newsLayout);


					mainTitleBar.setTitleBarText("News");
					mainTitleBar.bringToFront();
					
					
					ObjectAnimator animNew = ObjectAnimator.ofFloat(newsLayout, "alpha", 0f,1f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.setDuration(200);
					setAnim.setInterpolator(new AccelerateInterpolator(1.4f));
					setAnim.play(animNew);
					setAnim.start();
					
					
					setAnim.addListener(new Animator.AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(currentView);
							
							currentView = newsLayout;
						}
						
						@Override
						public void onAnimationCancel(Animator animation) {
							// TODO Auto-generated method stub
							
						}
					});
				}

			}
		});
		
		
		//our team
		MainActivity.macros.addMacro(new Macro(MacroTag.OUR_TEAM_OPEN) {
			@Override
			public void run(Object obj) {

				if(currentView != ourTeamLayout){
					
					ourTeamLayout = new OurTeamLayout(context, MyLayoutParms.RELATIVE_LAYOUT,  width, height - mainTitleBarHeight, 0, mainTitleBarHeight);
					ourTeamLayout.setTag("OUR_TEAM");
					addView(ourTeamLayout);
					
					mainTitleBar.setTitleBarText("Our Team");
					mainTitleBar.bringToFront();
					
					
					ObjectAnimator animNew = ObjectAnimator.ofFloat(ourTeamLayout, "alpha", 0f,1f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.setDuration(200);
					setAnim.setInterpolator(new AccelerateInterpolator(1.4f));
					setAnim.play(animNew);
					setAnim.start();
					
					
					setAnim.addListener(new Animator.AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animator animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(currentView);
							
							currentView = ourTeamLayout;
						}
						
						@Override
						public void onAnimationCancel(Animator animation) {
							// TODO Auto-generated method stub
							
						}
					});
					
				}
				
			}
		});

		

		
		
		//For event show
		MainActivity.macros.addMacro(new Macro(MacroTag.EVENT_OPEN) {
			@Override
			public void run(Object obj) {
				if(eventLayout == null){
					viewSatck++;
					
					DBEvent event = MainActivity.db.getEvent((int) obj);
					
					eventLayout = new EventLayout(context, event, MyLayoutParms.RELATIVE_LAYOUT	, width, height, 0, 0);
					eventLayout.setAlpha(0);
					addView(eventLayout);
					
					eventLayout.setListner(new onAttached() {
						
						@Override
						public void ok() {
							
							//set pivot
							eventLayout.setPivotX(width/2);
							eventLayout.setPivotY(height/2);
							
							//set anim
							ObjectAnimator animX = ObjectAnimator.ofFloat(eventLayout, "ScaleX", 0.8f,1f);
							ObjectAnimator animY = ObjectAnimator.ofFloat(eventLayout, "ScaleY", 0.8f,1f);
							ObjectAnimator animAlpha = ObjectAnimator.ofFloat(eventLayout, "alpha", 0f,1f);
							
							AnimatorSet setAnim = new AnimatorSet();
							setAnim.play(animX).with(animY).with(animAlpha);
							setAnim.setDuration(250);
							setAnim.setInterpolator(new DecelerateInterpolator(1.2f));
							setAnim.start();
							
							setAnim.addListener(new Animator.AnimatorListener() {
								
								@Override
								public void onAnimationStart(Animator animation) {
									
								}
								
								@Override
								public void onAnimationRepeat(Animator animation) {
									
								}
								
								@Override
								public void onAnimationEnd(Animator animation) {
									eventLayout.readyForView();
								}
								
								@Override
								public void onAnimationCancel(Animator animation) {
									
								}
							});
						}
					});
					
				}
				MainActivity.macros.run(MacroTag.DRAWER_LOCK);
				MainActivity.back.addBack(new Back(BackTag.EVENT) {
					@Override
					public void perform() {
						MainActivity.macros.run(MacroTag.EVENT_CLOSE);
					}
				});
			}
		});
		MainActivity.macros.addMacro(new Macro(MacroTag.EVENT_CLOSE) {
			@Override
			public void run(Object obj) {
				if(eventLayout != null){
					viewSatck--;
					
					ObjectAnimator animAlpha = ObjectAnimator.ofFloat(eventLayout, "alpha", 1f, 0f);
					ObjectAnimator animX = ObjectAnimator.ofFloat(eventLayout, "ScaleX", 1f,0.9f);
					ObjectAnimator animY = ObjectAnimator.ofFloat(eventLayout, "ScaleY", 1f,0.9f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.play(animX).with(animY).with(animAlpha);
					setAnim.setDuration(250);
					setAnim.setInterpolator(new DecelerateInterpolator(1.2f));
					setAnim.start();
					

					setAnim.addListener(new Animator.AnimatorListener() {

						@Override
						public void onAnimationStart(Animator animation) {

						}

						@Override
						public void onAnimationRepeat(Animator animation) {

						}

						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(eventLayout);
							eventLayout = null;
							
							menu_item_select_setup();
							MainActivity.back.removeBack(BackTag.EVENT);
							if(viewSatck == 0)
								MainActivity.macros.run(MacroTag.DRAWER_UNLOCK);
						}

						@Override
						public void onAnimationCancel(Animator animation) {

						}
					});
				}
			}
		});
		
		
		
		//developer
		MainActivity.macros.addMacro(new Macro(MacroTag.DEVELOPER_OPEN) {
			@Override
			public void run(Object obj) {
				if(developerLayout == null){
					viewSatck++;
					
					developerLayout = new DeveloperLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
					developerLayout.setAlpha(0);
					addView(developerLayout);
					
					
					developerLayout.setPivotX(width/2);
					developerLayout.setPivotY(height/2);
					
					//set anim
					ObjectAnimator animX = ObjectAnimator.ofFloat(developerLayout, "ScaleX", 0.8f,1f);
					ObjectAnimator animY = ObjectAnimator.ofFloat(developerLayout, "ScaleY", 0.8f,1f);
					ObjectAnimator animAlpha = ObjectAnimator.ofFloat(developerLayout, "alpha", 0f,1f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.play(animX).with(animY).with(animAlpha);
					setAnim.setDuration(250);
					setAnim.setInterpolator(new DecelerateInterpolator(1.2f));
					setAnim.start();
					
					setAnim.addListener(new Animator.AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator animation) {
							
						}
						
						@Override
						public void onAnimationRepeat(Animator animation) {
							
						}
						
						@Override
						public void onAnimationEnd(Animator animation) {
							developerLayout.readyForView();
						}
						
						@Override
						public void onAnimationCancel(Animator animation) {
						}
					});
					
					
					
					
				}

				MainActivity.macros.run(MacroTag.DRAWER_LOCK);
				MainActivity.back.addBack(new Back(BackTag.DEVELOPER) {
					@Override
					public void perform() {
						MainActivity.macros.run(MacroTag.DEVELOPER_CLOSE);
					}
				});
			}
		});
		MainActivity.macros.addMacro(new Macro(MacroTag.DEVELOPER_CLOSE) {

			@Override
			public void run(Object obj) {
				if(developerLayout != null){
					viewSatck--;
					
					ObjectAnimator animAlpha = ObjectAnimator.ofFloat(developerLayout, "alpha", 1f, 0f);
					ObjectAnimator animX = ObjectAnimator.ofFloat(developerLayout, "ScaleX", 1f,0.9f);
					ObjectAnimator animY = ObjectAnimator.ofFloat(developerLayout, "ScaleY", 1f,0.9f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.play(animX).with(animY).with(animAlpha);
					setAnim.setDuration(250);
					setAnim.setInterpolator(new DecelerateInterpolator(1.2f));
					setAnim.start();
					

					setAnim.addListener(new Animator.AnimatorListener() {

						@Override
						public void onAnimationStart(Animator animation) {

						}

						@Override
						public void onAnimationRepeat(Animator animation) {

						}

						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(developerLayout);
							developerLayout = null;
							
							menu_item_select_setup();
							if(viewSatck == 0)
								MainActivity.macros.run(MacroTag.DRAWER_UNLOCK);
							//MainActivity.back.removeBack(BackTag.DEVELOPER);
						}

						@Override
						public void onAnimationCancel(Animator animation) {

						}
					});	
				}
			}
		});

		
		
		
		//for search
		MainActivity.macros.addMacro(new Macro(MacroTag.SEARCH_OPEN) {
			@Override
			public void run(Object obj) {
				if(eventSearchLayout == null){
					
					viewSatck++;
					
					eventSearchLayout = new EventSearchLayout(context, MyLayoutParms.RELATIVE_LAYOUT, width, height, 0, 0);
					eventSearchLayout.setAlpha(0);
					addView(eventSearchLayout);
					eventSearchLayout.bringToFront();
					
					
					ObjectAnimator animAlpha = ObjectAnimator.ofFloat(eventSearchLayout, "alpha", 0f,1f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.play(animAlpha);
					setAnim.setDuration(300);
					setAnim.setInterpolator(new DecelerateInterpolator(1.5f));
					setAnim.start();
					
					
					
				}
				MainActivity.macros.run(MacroTag.DRAWER_LOCK);
				MainActivity.back.addBack(new Back(BackTag.DRAWER) {
					
					@Override
					public void perform() {
						MainActivity.macros.run(MacroTag.SEARCH_CLOSE);
					}
				});
			}
		});
		MainActivity.macros.addMacro(new Macro(MacroTag.SEARCH_CLOSE) {
			@Override
			public void run(Object obj) {
				if(eventSearchLayout != null){
					viewSatck--;
					
					ObjectAnimator animAlpha = ObjectAnimator.ofFloat(eventSearchLayout, "alpha", 1f,0f);
					
					AnimatorSet setAnim = new AnimatorSet();
					setAnim.play(animAlpha);
					setAnim.setDuration(150);
					setAnim.setInterpolator(new DecelerateInterpolator(1.5f));
					setAnim.start();
					
					setAnim.addListener(new Animator.AnimatorListener() {
						
						@Override
						public void onAnimationStart(Animator animation) {
							
						}
						
						@Override
						public void onAnimationRepeat(Animator animation) {
							
						}
						
						@Override
						public void onAnimationEnd(Animator animation) {
							removeView(eventSearchLayout);
							eventSearchLayout = null;
						}
						
						@Override
						public void onAnimationCancel(Animator animation) {
							
						}
					});
				}

				menu_item_select_setup();
				MainActivity.back.removeBack(BackTag.DRAWER);
				if(viewSatck == 0)
					MainActivity.macros.run(MacroTag.DRAWER_UNLOCK);
			}
		});
		
		
		
		
		MainActivity.macros.addMacro(new Macro(MacroTag.MENU_ITEM_SELECT_SETUP) {
			@Override
			public void run(Object obj) {
				menu_item_select_setup();
			}
		});
		
	}
	
	public void menu_item_select_setup(){
		
		switch ((String)currentView.getTag()) {
		case "EVENT_LIST":
			MainActivity.macros.run(MacroTag.CLICK_MENU_ITEM,1);
			break;
			
		case "SCHEDULE":
			MainActivity.macros.run(MacroTag.CLICK_MENU_ITEM,2);
			break;
			
		case "NEWS":
			MainActivity.macros.run(MacroTag.CLICK_MENU_ITEM,3);
			break;
			
		case "OUR_TEAM":
			MainActivity.macros.run(MacroTag.CLICK_MENU_ITEM,7);
			
		case "SPONSOR_LIST":
			MainActivity.macros.run(MacroTag.CLICK_MENU_ITEM,8);
			break;
			
		default:
			break;
		}
		
	}
}
