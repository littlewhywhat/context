package com.littlewhywhat.context.android.ui;

import com.littlewhywhat.context.android.R;

import com.littlewhywhat.context.android.data.Data;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String HELLO_WORLD = "Hello World!";
	private Data data;
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		getHello().setText(HELLO_WORLD);
		data = new Data();
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.itemText);
		getListView().setAdapter(adapter);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final String stringId = ((TextView)((ViewGroup)view).getChildAt(0)).getText().toString();
				getHello().setText(stringId);
				swapArray(data.getChildren(stringId));
			}
		});
		swapArray(data.getRoot());
	}

	private void swapArray(String[] array) {
		adapter.clear();
		adapter.addAll(array);
	}

	private ListView getListView() {
		return (ListView)findViewById(R.id.list);
	}

	private TextView getHello() {
		return (TextView)findViewById(R.id.hello);
	}
}