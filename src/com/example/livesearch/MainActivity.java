package com.example.livesearch;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.liveseearch.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

	// List view
	private ListView lv;
	// Listview Adapter
	ArrayAdapter<String> adapter;
	// EditText в котором будем искать
	EditText inputSearch;
	// ArrayList для Listview
	ArrayList<HashMap<String, String>> productList;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Вот что мы будем выводить в ListView
		String products[] = { "Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense",
				"HTC Sensation XE", "iPhone 4S", "Samsung Galaxy Note 800", "Samsung Galaxy S3",
				"MacBook Air", "Mac Mini", "MacBook Pro" };
		lv = (ListView) findViewById(R.id.list_view);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
		// Добавляем данные для ListView
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
		lv.setAdapter(adapter);
		/** Enabling Search Filter */
		inputSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {

				// TODO Auto-generated method stub
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {

				// Когда, юзер изменяет текст он работает
				adapter.getFilter().filter(cs);
			}
		});
	}
}
