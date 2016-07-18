package com.imooc.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.Window;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.test);
        // 创建Palette对象
        /*Palette.generateAsync(bitmap,
                new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        // 通过Palette来获取对应的色调
                        Palette.Swatch vibrant =
                                palette.getDarkVibrantSwatch();
                        // 将颜色设置给相应的组件
                        getActionBar().setBackgroundDrawable(
                                new ColorDrawable(vibrant.getRgb()));
                        Window window = getWindow();
                        window.setStatusBarColor(vibrant.getRgb());
                    }
                });*/
        Palette palette = Palette.generate(bitmap);
        int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);

        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(darkVibrantColor));

        Window window = getWindow();
        window.setStatusBarColor(darkVibrantColor);

    }
}
