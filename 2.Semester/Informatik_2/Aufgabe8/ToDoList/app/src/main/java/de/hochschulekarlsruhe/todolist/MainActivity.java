package de.hochschulekarlsruhe.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    public static final String TITLE_CLICKED = "de.hochschulekarlsruhe.todolist.TITLE_CLICKED";
    public static final String TEXT_CLICKED = "de.hochschulekarlsruhe.todolist.TEXT_CLICKED";

    ArrayList<String> toDosTitles;
    ArrayList<String> toDosDetails;
    CustomAdapter adapter;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDosTitles = new ArrayList<>();
        toDosDetails = new ArrayList<>();

        adapter = new CustomAdapter(this,toDosTitles);
        list = (ListView) findViewById(R.id.list_view_todos);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent getToDoViewScreenIntent = new Intent(this, ToDoView.class);
        getToDoViewScreenIntent.putExtra(TITLE_CLICKED, toDosTitles.get(position));
        getToDoViewScreenIntent.putExtra(TEXT_CLICKED, toDosDetails.get(position));
        startActivity(getToDoViewScreenIntent);
    }


    // Füge ein neues Item zur Liste hinzu
    public void onAddNewTodoClick(View view) {
        Intent getToDoInputScreenIntent = new Intent(this, ToDoInput.class);

        final int result = 1;

        startActivityForResult(getToDoInputScreenIntent, result);
    }


    // Lösche alle Items in der Liste
    public void onClearListClick(View view) {
        toDosTitles.clear();
        toDosDetails.clear();
        adapter.notifyDataSetChanged();
    }


    // Lösche alle ausgewählten Items in der Liste
    public void onDeleteItemsClick(View view) {
        CheckBox box;
        for (int i = toDosTitles.size() - 1; i >= 0; i--) {
            box = (CheckBox) list.getChildAt(i).findViewById(R.id.checkBox_toDo);
            if (box.isChecked()) {
                toDosTitles.remove(i);
                toDosDetails.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String title = data.getStringExtra(ToDoInput.TITLE_BACK);
        String details = data.getStringExtra(ToDoInput.DETAILS_BACK);

        toDosTitles.add(title);
        toDosDetails.add(details);
    }


}
