package com.littlewhywhat.context.android.ui;

import com.littlewhywhat.context.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		getHello().setText("Hello World!");
	}

	private TextView getHello() {
		return (TextView)findViewById(R.id.hello);
	}
}