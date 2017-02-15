package com.jll.zoro.test.ViewPagerAndPhotoView;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jll.zoro.test.R;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import java.util.ArrayList;
import java.util.List;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class ViewPagerPhotoActivity extends Activity {
    private HackyViewPager hackyViewPager;
    private static PhotoView photoView;
    private List<String> list = new ArrayList<String>();

    SamplePagerAdapter samplePagerAdapter;
    private String permission = "android.permission.READ_CALENDAR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_photo);
        Fresco.initialize(this);
        ViewPagerPhotoActivityPermissionsDispatcher.NeedWithCheck(this,permission);
        hackyViewPager = (HackyViewPager) findViewById(R.id.HackyViewPager);
        hackyViewPager.setPageMargin(40);
        hackyViewPager.setOffscreenPageLimit(3);
        hackyViewPager.setPageTransformer(true, new AlphaPageTransformer(new ScaleInTransformer()));
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

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void Need(String permission) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ViewPagerPhotoActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults,permission);
    }

    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void Show(final PermissionRequest request) {
    }

    @OnPermissionDenied({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void Denied() {
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void NeverAsk() {
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
