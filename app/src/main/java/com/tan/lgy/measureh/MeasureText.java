package com.tan.lgy.measureh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.FontMetricsInt;
import android.util.Log;
import android.widget.TextView;

/**
 * @author Administrator
 * 2016-12-15
 * http://blog.csdn.net/su1216/article/details/46900617#
 */
public class MeasureText extends TextView
{
	private final static String TAG = "lgy";
	private Paint mPaint = null;
	private String TEST_STRING = "中文与English";
	private FontMetricsInt mFontMetricsInt = null;
	private int mWidth;
	private int mHeight;
	private float mStringWidth;
	//字体格式
	private Typeface face = null;

	public MeasureText(Context context)
	{
		super(context);
		init(context);
	}

	private void init(Context context)
	{
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStrokeWidth(3);
		mPaint.setTextSize(60);
		mPaint.setTextAlign(Paint.Align.CENTER);
		mPaint.setStyle(Paint.Style.STROKE);
		mFontMetricsInt = mPaint.getFontMetricsInt();
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		int x=0;
		if (mPaint.getTextAlign() == Paint.Align.LEFT)
		{ // 左
			x = mWidth / 2 - (int) (mStringWidth / 2);
		} else if (mPaint.getTextAlign() == Paint.Align.CENTER)
		{ // 中
			x = mWidth / 2;
		} else
		{ // 右
			x = mWidth / 2 + (int) (mStringWidth / 2);
		}

		int xFrom = mWidth / 2 - (int) (mStringWidth / 2);
		int xTo = mWidth / 2 + (int) (mStringWidth / 2);

//		 baseline = (mHeight - (mFontMetricsInt.descent -
//		 mFontMetricsInt.ascent)) / 2 - mFontMetricsInt.ascent
//		 baseline = (mHeight - mFontMetricsInt.ascent -
//		 mFontMetricsInt.descent) / 2
		int y = (mHeight - mFontMetricsInt.ascent - mFontMetricsInt.descent) / 2;
		Log.d(TAG, "top: " + mFontMetricsInt.top);
		Log.d(TAG, "ascent: " + mFontMetricsInt.ascent);
		Log.d(TAG, "baseline: " + y);
		Log.d(TAG, "descent: " + mFontMetricsInt.descent);
		Log.d(TAG, "bottom: " + mFontMetricsInt.bottom);


		// baseline
		mPaint.setColor(Color.RED);
		canvas.drawLine(xFrom, y, xTo, y, mPaint);
		// ascent
		mPaint.setColor(Color.YELLOW);
		canvas.drawLine(xFrom, y + mFontMetricsInt.ascent, xTo, y
				+ mFontMetricsInt.ascent, mPaint);
		// descent
		mPaint.setColor(Color.BLUE);
		canvas.drawLine(xFrom, y + mFontMetricsInt.descent, xTo, y
				+ mFontMetricsInt.descent, mPaint);
		// top
		mPaint.setColor(Color.LTGRAY);
		canvas.drawLine(xFrom, y + mFontMetricsInt.top, xTo, y
				+ mFontMetricsInt.top, mPaint);
		// bottom
		mPaint.setColor(Color.GREEN);
		canvas.drawLine(xFrom, y + mFontMetricsInt.bottom, xTo, y
				+ mFontMetricsInt.bottom, mPaint);

		mPaint.setColor(Color.BLACK);
		canvas.drawText(TEST_STRING, x, y, mPaint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		super.onSizeChanged(w, h, oldw, oldh);
		mWidth = w;
		mHeight = h;
		measureText();
	}

	private float measureText()
	{
		mStringWidth = mPaint.measureText(TEST_STRING);
		return mStringWidth;
	}

	public void setFace(Typeface face)
	{
		this.mPaint.setTypeface(face);
	}

	
	
}
