package com.example.todoapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ToDoListActivity extends Activity implements OnNewItemListener {

    private ArrayAdapter<String> aa;
    private ArrayList<String> todoItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Загрузить представление
        setContentView(R.layout.main);

//        Получить ссылки на фрагменты
        FragmentManager fm = getFragmentManager();
        ToDoListFragment toDoListFragment = (ToDoListFragment) fm.findFragmentById(R.id.ToDoListFragment);

//        Создать список задач
        todoItems = new ArrayList<>();

//        Создать ArrayAdapter, чтобы привязать массив к ListView
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoItems);

//         Привязать Адаптер массива к ListView
        toDoListFragment.setListAdapter(aa);
    }

    @Override
    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        aa.notifyDataSetChanged();
    }
}
