package com.littlewhywhat.context.android.ui;

import com.littlewhywhat.context.android.R;

import com.littlewhywhat.context.android.data.Data;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Data data;
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		data = new Data();
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.itemText);
		getTitleView().setText(Data.ROOT_ID);
		getTitleView().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final String stringId = ((TextView)view).getText().toString();
				final String parentId = data.getParent(stringId);
				getTitleView().setText(parentId);
				setContextButton();
				swapArray(data.getChildren(parentId));
			}
		});
		getListView().setAdapter(adapter);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final String stringId = ((TextView)((ViewGroup)view).getChildAt(0)).getText().toString();
				getTitleView().setText(stringId);
				setContextButton();
				swapArray(data.getChildren(stringId));
			}
		});
		getContextButton().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final String stringId = getTitleView().getText().toString();
				final String contextId = data.getContext(stringId);
				getTitleView().setText(contextId);
				setContextButton();
				swapArray(data.getChildren(contextId));
			}
		});
		setContextButton();
		swapArray(data.getRoot());
	}

	private void setContextButton() {
		final String stringId = getTitleView().getText().toString();
		if (data.getContext(stringId) != null) 
			getContextButton().setEnabled(true);
		else
			getContextButton().setEnabled(false);
	}

	private void swapArray(String[] array) {
		adapter.clear();
		adapter.addAll(array);
	}

	private ListView getListView() {
		return (ListView)findViewById(R.id.list);
	}

	private TextView getTitleView() {
		return (TextView)findViewById(R.id.title);
	}

	private Button getContextButton() {
		return (Button)findViewById(R.id.context);
	}
}