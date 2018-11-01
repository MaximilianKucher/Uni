package de.hochschulekarlsruhe.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by Max on 17.05.2017.
 */

public class ToDoView extends Activity{

    TextView title;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_view);

        title = (TextView) findViewById(R.id.ToDo_Title);
        text = (TextView) findViewById(R.id.ToDo_Text);
        Intent intent = getIntent();
        String titlePassed = intent.getStringExtra(MainActivity.TITLE_CLICKED);
        String textPassed = intent.getStringExtra(MainActivity.TEXT_CLICKED);

        title.setText(titlePassed);
        text.setText(textPassed);
    }
}
