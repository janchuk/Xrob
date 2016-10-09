package com.theah64.xrob.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.theah64.xrob.commandcenter.commands.BaseCommand;

import java.io.IOException;

/**
 * Created by theapache64 on 8/10/16.
 */

public class WallpaperManager {

    //no cache config.
    private static final DisplayImageOptions options = new DisplayImageOptions.Builder()
            .bitmapConfig(Bitmap.Config.RGB_565)
            .cacheInMemory(false)
            .cacheOnDisk(false)
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
            .build();

    public static void setWallpaper(final Context context, final String imageUrl, final BaseCommand.Callback callback) {

        ImageLoader.getInstance().loadImage(imageUrl, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                callback.onError("ERROR: " + failReason.getCause().getMessage());
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                try {
                    final android.app.WallpaperManager wm = android.app.WallpaperManager.getInstance(context);
                    wm.setBitmap(loadedImage);
                    callback.onSuccess("Wallpaper set : " + imageUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onError("ERROR: " + e.getMessage());
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                callback.onError("ERROR: Loading cancelled");
            }
        });

    }
}