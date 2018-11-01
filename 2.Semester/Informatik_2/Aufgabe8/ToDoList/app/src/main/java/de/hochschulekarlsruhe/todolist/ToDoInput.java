package de.hochschulekarlsruhe.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Max on 17.05.2017.
 */

public class ToDoInput extends Activity{

    public static final String TITLE_BACK = "de.hochschulekarlsruhe.todolist.TITLE";
    public static final String DETAILS_BACK = "de.hochschulekarlsruhe.todolist.DETAILS";

    EditText editTitle;
    EditText editDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_input);

        editTitle = (EditText) findViewById(R.id.ToDo_Title);
        editDetails = (EditText) findViewById(R.id.ToDo_Text);

        // eingabefelder leeren
        editTitle.setText("");
        editDetails.setText("");
    }

    public void onSubmitToDoClick(View view) {
        String title = editTitle.getText().toString();
        String details = editDetails.getText().toString();

        Intent goingBack = new Intent();
        goingBack.putExtra(TITLE_BACK, title);
        goingBack.putExtra(DETAILS_BACK, details);


        setResult(RESULT_OK, goingBack);

        finish();
    }
}
