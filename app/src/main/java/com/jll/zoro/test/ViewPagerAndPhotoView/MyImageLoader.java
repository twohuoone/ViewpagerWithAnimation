package com.jll.zoro.test.ViewPagerAndPhotoView;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class MyImageLoader {
	private static MyImageLoader myImageLoader = new MyImageLoader();
	static ImageLoader imageLoader;

	public static MyImageLoader getInstance(Context context){
//		imageLoader = ((AppApplication) context.getApplicationContext()).imageLoader;

		return myImageLoader;
	}

	private DisplayImageOptions initImageLoader(ImageLoader imageLoader) {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
//				.showImageForEmptyUri(R.drawable.ic_error)
//				.showImageOnFail(R.drawable.ic_error)
//				.showImageOnLoading(R.drawable.default1)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.considerExifParams(true)
				.resetViewBeforeLoading(false)
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
				.bitmapConfig(Bitmap.Config.RGB_565)
						//图片显示圆角
						//.displayer(new RoundedBitmapDisplayer(20))
				.build();
		//imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
		return options;
	}

	public void displayImage(String url, ImageView image){
		DisplayImageOptions options = initImageLoader(imageLoader);
		ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
		imageLoader.displayImage(url, image, options, animateFirstListener);
	}

	/*public void onDestoryLoader(){
		imageLoader.clearMemoryCache();
		AnimateFirstDisplayListener.displayedImages.clear();
	}*/
	private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
		static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
}
