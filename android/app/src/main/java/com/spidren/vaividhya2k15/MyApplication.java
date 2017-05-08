package com.spidren.vaividhya2k15;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.utils.L;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
				.cacheOnDisk(true).cacheInMemory(true)
				.displayer(new FadeInBitmapDisplayer(250, true, true, false))
				.resetViewBeforeLoading(true)
				.imageScaleType(ImageScaleType.EXACTLY).build();

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.threadPriority(Thread.NORM_PRIORITY)
				.defaultDisplayImageOptions(defaultOptions)
				.memoryCache(new LruMemoryCache(25 * 1024 * 1024))
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(100 * 1024 * 1024).build();

		ImageLoader.getInstance().init(config);
		L.writeDebugLogs(true);
	}

}
