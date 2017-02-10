package com.jll.zoro.test.ViewPagerAndPhotoView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jll.zoro.test.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerPhotoActivity extends Activity {
    private HackyViewPager hackyViewPager;
    private static PhotoView photoView;
    private static ImageView imageView;
//    private static ImageLoader imageLoader= ImageLoader.getInstance();
    List<String> list = new ArrayList<String>();
    SamplePagerAdapter samplePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_photo);
        Fresco.initialize(this);
        hackyViewPager = (HackyViewPager) findViewById(R.id.HackyViewPager);
        hackyViewPager.setPageMargin(40);
        hackyViewPager.setOffscreenPageLimit(3);
        list.add("http://img4q.duitang.com/uploads/item/201408/11/20140811141753_iNtAF.jpeg");
        list.add("http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg");
        list.add("http://imgsrc.baidu.com/forum/pic/item/8e230cf3d7ca7bcb3acde5a2be096b63f724a8b2.jpg");
        list.add("http://att.bbs.duowan.com/forum/201210/20/210446opy9p5pghu015p9u.jpg");
        list.add("http://img5.duitang.com/uploads/item/201404/11/20140411214939_XswXa.jpeg");
        list.add("http://img4q.duitang.com/uploads/item/201408/11/20140811141753_iNtAF.jpeg");
        list.add("http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg");
        list.add("http://imgsrc.baidu.com/forum/pic/item/8e230cf3d7ca7bcb3acde5a2be096b63f724a8b2.jpg");
        list.add("http://att.bbs.duowan.com/forum/201210/20/210446opy9p5pghu015p9u.jpg");
        list.add("http://img5.duitang.com/uploads/item/201404/11/20140411214939_XswXa.jpeg");
        list.add("http://img4q.duitang.com/uploads/item/201408/11/20140811141753_iNtAF.jpeg");
        list.add("http://imgsrc.baidu.com/forum/pic/item/8b82b9014a90f603fa18d50f3912b31bb151edca.jpg");
        list.add("http://imgsrc.baidu.com/forum/pic/item/8e230cf3d7ca7bcb3acde5a2be096b63f724a8b2.jpg");
        list.add("http://att.bbs.duowan.com/forum/201210/20/210446opy9p5pghu015p9u.jpg");
        list.add("http://img5.duitang.com/uploads/item/201404/11/20140411214939_XswXa.jpeg");
        samplePagerAdapter = new SamplePagerAdapter();
        hackyViewPager.setAdapter(samplePagerAdapter);
        hackyViewPager.setCurrentItem(1);
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {

            photoView = new PhotoView(container.getContext());
            photoView.setImageUri(list.get(position));

            // Now just add PhotoView to ViewPager and return it
//            photoView.setOnViewTapListener(new OnViewTapListener() {
//
//                @Override
//                public void onViewTap(View arg0, float arg1, float arg2) {
//                    viewpager.setVisibility(View.GONE);
//                    showimg.setVisibility(View.VISIBLE);
//                    setShowimage();
//                   finish();
//                }
//            });
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
