package com.jike.animtextview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import com.jike.animtextview.util.FormatUtils;

/**
 * Created by wancc on 2016/7/17.
 */
public class DifferentSizeTextView extends TextView {


    private static final String TAG = "DifferentSizeTextView";
    private float		mWidth;

    private float mDataHeight;

    private Paint.FontMetrics mDataFontMetrics;
    private CharSequence mData;
    private CharSequence mUnit;
    private float dataWidth;
    private float unitWidth;
    private float mUnitHeight;

    public DifferentSizeTextView(Context context) {
        super(context);
//        setLocationAndData();
    }

    public DifferentSizeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        setLocationAndData();
    }

    public DifferentSizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        setLocationAndData();
    }


    private void setLocationAndData() {

        CharSequence text = getText();
        Log.e(TAG,"text>:"+text);
        mData = text.subSequence(0, text.length() - 2);
        mUnit = text.subSequence(text.length() - 2,text.length());
        Log.e(TAG,"data:"+mData+",unit:"+mUnit);

        TextPaint paint = getPaint();
        paint.setTextSize(50);
        dataWidth = paint.measureText(mData.toString());
        mDataFontMetrics = paint.getFontMetrics();

        // 上边距为负数 相加求文字高度
        mDataHeight = -(mDataFontMetrics.ascent + mDataFontMetrics.descent);

        // 可以显示全像g这样的字母，但是下边会空出来一部分
//		mDataHeight = -mDataFontMetrics.ascent;

        paint.setTextSize(20);
        Paint.FontMetrics mUnitFontMeetrics = paint.getFontMetrics();
        mUnitHeight = -(mUnitFontMeetrics.ascent + mUnitFontMeetrics.descent);
        unitWidth = paint.measureText(mUnit.toString());

        mWidth = dataWidth + unitWidth;


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int desWidth = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int desHeight = MeasureSpec.getSize(heightMeasureSpec);

        switch (widthMode)
        {
            case MeasureSpec.EXACTLY:
            case MeasureSpec.UNSPECIFIED:

                mWidth = desWidth;

                break;

            case MeasureSpec.AT_MOST:

                mWidth = mWidth > desWidth ? desWidth : mWidth;

                break;
        }

        switch (heightMode)
        {
            case MeasureSpec.EXACTLY:
            case MeasureSpec.UNSPECIFIED:

                mDataHeight = desHeight;

                break;

            case MeasureSpec.AT_MOST:
                mDataHeight = mDataHeight > desHeight ? desHeight : mDataHeight + 1;

                break;
        }
        setMeasuredDimension((int) Math.ceil(mWidth), (int) Math.ceil(mDataHeight));
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());

        paint.setTextSize(50);
        canvas.drawText(mData.toString(),0, mDataHeight,paint);

        paint.setTextSize(20);
        canvas.drawText(mUnit.toString(),dataWidth, mUnitHeight,paint);
    }


    public void startAnim(float start,float end,long duration){
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(start,end);
        valueAnimator.setDuration(duration);
        valueAnimator.setInterpolator(new AccelerateInterpolator());

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();

                String text = FormatUtils.formatFileSize((long) value);
                Log.e(TAG,"onAnimationUpdate："+text);
                setText(text);

            }
        });
        valueAnimator.start();
    }


    @Override
    public void setText(CharSequence text, BufferType type) {

        super.setText(text, type);
        setLocationAndData();
    }
}
