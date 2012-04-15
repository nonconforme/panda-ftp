package com.pandaftp.utils;

import com.pandaftp.main.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomImageListAdapter extends BaseAdapter {

	private int[] images = {R.drawable.addserver, R.drawable.connect, R.drawable.admin};
	
	private String[] imageDesc = { "Manage Servers", "Connect to Server", "Delete Server"};
	
	private Context ctx = null;
	
	public CustomImageListAdapter(Context context) {
		this.ctx = context;
	}
	
	public int getCount() {
		return images.length;
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		ImageView imgView = new ImageView(this.ctx);
		imgView.setScaleType(ScaleType.FIT_CENTER);
		imgView.setPadding(8, 8, 8, 8);
		imgView.setImageResource(images[arg0]);
		imgView.setAdjustViewBounds(Boolean.TRUE);
		imgView.setContentDescription(imageDesc[arg0]);
		imgView.setMaxHeight(200);
		imgView.setMaxWidth(200);

		TextView tv = new TextView(this.ctx);
		tv.setText(imageDesc[arg0]);
		tv.setMaxHeight(100);
		tv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tv.setGravity(Gravity.CENTER);
		tv.setTextColor(this.ctx.getResources().getColor(android.R.color.white));
		
		
		LinearLayout layoutView = new LinearLayout(this.ctx);
		layoutView.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(150, 150);
		layoutView.addView(imgView, params1);
		LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		layoutView.addView(tv, params2);
		
		return layoutView;
	}

}