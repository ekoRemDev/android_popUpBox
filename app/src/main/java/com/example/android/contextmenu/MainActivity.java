package com.example.android.contextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView pressView = (TextView)findViewById(R.id.press);
        registerForContextMenu(pressView);

        TextView pressViewSinglePress = (TextView)findViewById(R.id.pressSingle);
        pressViewSinglePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Single Press Occurs", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        //find out which menu item was pressed
        switch (item.getItemId()) {
            case R.id.option1:
                doOptionOne();
                return true;
            case R.id.option2:
                doOptionTwo();
                return true;
            default:
                return false;
        }
    }


    private void doOptionOne() {
        Toast.makeText(this, "Option 1 is Clicked", Toast.LENGTH_SHORT).show();
    }

    private void doOptionTwo() {
        Toast.makeText(this, "Option 2 is Clicked", Toast.LENGTH_SHORT).show();
    }
}
