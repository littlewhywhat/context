package com.littlewhywhat.context.android.ui;

import com.littlewhywhat.context.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String HELLO_WORLD = "Hello World!";
	private static final String[] texts = new String[] {"sun","grass","sky"};
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		getHello().setText(HELLO_WORLD);
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.itemText);
		getListView().setAdapter(adapter);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				getHello().setText(String.valueOf(id));
			}
		});
		swapArray(texts);
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