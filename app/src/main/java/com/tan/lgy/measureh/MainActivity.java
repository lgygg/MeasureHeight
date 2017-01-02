package com.tan.lgy.measureh;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * @author Administrator
 * 2016-12-16
 * 测试字体对下面几条线的位置的影响
 * top：浅灰色
 * ascent：黄色
 * baseline：红色
 * descent：蓝色
 * bottom：绿色
 * 经过测试貌似没什么影响
 */
public class MainActivity extends Activity
{
	private LinearLayout bodyLayout = null;
	private LinearLayout.LayoutParams llParams = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		init();
		setContentView(bodyLayout);
	}

	private void init()
	{
		bodyLayout = new LinearLayout(this);
		if (bodyLayout != null)
		{
			llParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			if (llParams!=null)
			{
				bodyLayout.setLayoutParams(llParams);
			}
			bodyLayout.setOrientation(LinearLayout.VERTICAL);
			bodyLayout.setBackgroundColor(Color.WHITE);
			//系统默认字体
			MeasureText measureText = new MeasureText(this);
			if (measureText!=null)
			{
				llParams = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						Util.dip2px(this, 200));
				if (llParams!=null)
				{
					measureText.setLayoutParams(llParams);
				}
				bodyLayout.addView(measureText);
			}
			//行书
			MeasureText measureText2 = new MeasureText(this);
			if (measureText2!=null)
			{
				llParams = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						Util.dip2px(this, 200));
				if (llParams!=null)
				{
					measureText2.setLayoutParams(llParams);
				}
				Typeface face = Typeface.createFromAsset (getAssets() , "fonts/xs.ttf" );
				measureText2.setFace(face);
				
				bodyLayout.addView(measureText2);
			}
			//小篆
			MeasureText measureText3 = new MeasureText(this);
			if (measureText3!=null)
			{
				llParams = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						Util.dip2px(this, 200));
				if (llParams!=null)
				{
					measureText3.setLayoutParams(llParams);
				}
				Typeface face = Typeface.createFromAsset (getAssets() , "fonts/fzxz.TTF" );
				measureText3.setFace(face);
				
				bodyLayout.addView(measureText3);
			}
			//方正姚体
			MeasureText measureText4 = new MeasureText(this);
			if (measureText4!=null)
			{
				llParams = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						Util.dip2px(this, 200));
				if (llParams!=null)
				{
					measureText4.setLayoutParams(llParams);
				}
				Typeface face = Typeface.createFromAsset (getAssets() , "fonts/fzyt.TTF" );
				measureText4.setFace(face);
				
				bodyLayout.addView(measureText4);
			}
		}
	}
}
