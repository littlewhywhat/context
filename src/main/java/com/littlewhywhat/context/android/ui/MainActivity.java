package com.littlewhywhat.context.android.ui;

import com.littlewhywhat.context.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String HELLO_WORLD = "Hello World!";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		getHello().setText(HELLO_WORLD);
	}

	private TextView getHello() {
		return (TextView)findViewById(R.id.hello);
	}
}