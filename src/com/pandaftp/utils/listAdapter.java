/**
 * 
 */
package com.pandaftp.utils;
import com.pandaftp.main.R;
/**
 * @author jacob
 *
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.pandaftp.utils.utilities;

public class listAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	
	static class ViewHolder {
		public TextView text;
		public ImageView image;
	}
	
	
	public listAdapter(Context context, String[] values) {
		super(context, R.layout.dirlist, values); // Dirlist is still being used here. May get split to 2! If someone does remember to refresh this xml!
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.dirlist, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		textView.setText(values[position]);
	
		// Change the icon for Windows and iPhone
		String s = values[position];
		
		if (s.endsWith(".mp3") ) {
			imageView.setImageResource(R.drawable.mp3);
		} else if (s.endsWith(".ac3")){
			imageView.setImageResource(R.drawable.ac3);
		}  else if (s.endsWith(".ade")){
			imageView.setImageResource(R.drawable.ade);
		} else if (s.endsWith(".adp")){
			imageView.setImageResource(R.drawable.adp);
		} else if (s.endsWith(".avi")){
			imageView.setImageResource(R.drawable.avi);
		} else if (s.endsWith(".bat")){
			imageView.setImageResource(R.drawable.bat);
		} else if (s.endsWith(".bin")){
			imageView.setImageResource(R.drawable.bin);
		} else if (s.endsWith(".bmp")){
			imageView.setImageResource(R.drawable.bmp);
		} else if (s.endsWith(".css")){
			imageView.setImageResource(R.drawable.css);
		} else if (s.endsWith(".cue")){
			imageView.setImageResource(R.drawable.cue);
		} else if (s.endsWith(".dll")){
			imageView.setImageResource(R.drawable.dll);
		} else if (s.endsWith(".doc")){
			imageView.setImageResource(R.drawable.doc);
		} else if (s.endsWith(".docx")){
			imageView.setImageResource(R.drawable.docx);
		} else if (s.endsWith(".gif")){
			imageView.setImageResource(R.drawable.gif);
		} else if (s.endsWith(".hlp")){
			imageView.setImageResource(R.drawable.hlp);
		} else if (s.endsWith(".html")){
			imageView.setImageResource(R.drawable.html);
		} else if (s.endsWith(".ini")){
			imageView.setImageResource(R.drawable.ini);
		} else if (s.endsWith(".iso")){
			imageView.setImageResource(R.drawable.iso);
		} else if (s.endsWith(".java")){
			imageView.setImageResource(R.drawable.java);
		} else if (s.endsWith(".tif")){
			imageView.setImageResource(R.drawable.tif);
		} else if (s.endsWith(".jpeg")){
			imageView.setImageResource(R.drawable.jpeg);
		} else if (s.endsWith(".jpg")){
			imageView.setImageResource(R.drawable.jpg);
		} else if (s.endsWith(".log")){
			imageView.setImageResource(R.drawable.log);
		} else if (s.endsWith(".m4a")){
			imageView.setImageResource(R.drawable.m4a);
		} else if (s.endsWith(".mov")){
			imageView.setImageResource(R.drawable.mov);
		} else if (s.endsWith(".mp4")){
			imageView.setImageResource(R.drawable.mp4);
		} else if (s.endsWith(".mpeg")){
			imageView.setImageResource(R.drawable.mpeg);
		} else if (s.endsWith(".mpg")){
			imageView.setImageResource(R.drawable.mpg);
		} else if (s.endsWith(".pdf")){
			imageView.setImageResource(R.drawable.pdf);
		} else if (s.endsWith(".php")){
			imageView.setImageResource(R.drawable.php);
		} else if (s.endsWith(".png")){
			imageView.setImageResource(R.drawable.png);
		} else if (s.endsWith(".pptx")){
			imageView.setImageResource(R.drawable.pptx);
		} else if (s.endsWith(".psd")){
			imageView.setImageResource(R.drawable.psd);
		} else if (s.endsWith(".rar")){
			imageView.setImageResource(R.drawable.rar);
		} else if (s.endsWith(".rtf")){
			imageView.setImageResource(R.drawable.rtf);
		} else if (s.endsWith(".ttf")){
			imageView.setImageResource(R.drawable.ttf);
		} else if (s.endsWith(".txt")){
			imageView.setImageResource(R.drawable.txt);
		} else if (s.endsWith(".vob")){
			imageView.setImageResource(R.drawable.vob);
		} else if (s.endsWith(".wav")){
			imageView.setImageResource(R.drawable.wav);
		} else if (s.endsWith(".wma")){
			imageView.setImageResource(R.drawable.wma);
		} else if (s.endsWith(".wmv")){
			imageView.setImageResource(R.drawable.wmv);
		} else if (s.endsWith(".xlsx")){
			imageView.setImageResource(R.drawable.xlsx);
		} else if (s.endsWith(".xml")){
			imageView.setImageResource(R.drawable.xml);
		} else if (s.endsWith(".zip")){
			imageView.setImageResource(R.drawable.zip);
		} else if (!utilities.isFile(s))
		{
			imageView.setImageResource(R.drawable.folder);
		}
		else {
			imageView.setImageResource(R.drawable.def);
		}
		return rowView;
	}


	
}
