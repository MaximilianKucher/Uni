package de.hochschulekarlsruhe.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Max on 16.05.2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, ArrayList<String> titles) {
        super(context, R.layout.todo_list_item, titles);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater toDosInflator = LayoutInflater.from(getContext());
        View customView = toDosInflator.inflate(R.layout.todo_list_item, parent, false);

        String title = getItem(position);
        TextView textView = (TextView) customView.findViewById(R.id.toDo_list_item_title);

        textView.setText(title);

        return customView;
    }


}
