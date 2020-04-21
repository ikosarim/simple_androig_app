package com.example.todoapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ToDoListActivity extends Activity implements OnNewItemListener {

    private ToDoItemAdaptor aa;
    private ArrayList<ToDoItem> todoItems;

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
        int resId = R.layout.todolist_item;
        aa = new ToDoItemAdaptor(this, resId, todoItems);

//         Привязать Адаптер массива к ListView
        toDoListFragment.setListAdapter(aa);
    }

    @Override
    public void onNewItemAdded(String newItem) {
        ToDoItem newToDoItem = new ToDoItem(newItem);
        todoItems.add(0, newToDoItem);
        aa.notifyDataSetChanged();
    }
}
