package com.example.androidtoolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CheckBox check;
    ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        check=(CheckBox)findViewById(R.id.checkBox);
        setSupportActionBar(toolbar);   //its superclasss is a ViewGroup

        getSupportActionBar().setTitle("Home Page");
        toolbar.setSubtitle("Welcome User");
        toolbar.setNavigationIcon(R.drawable.drag_handle);
        toolbar.setNavigationContentDescription("Navigation Icon");

        //OnclickListener on CheckBox
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    actionMode=MainActivity.this.startSupportActionMode(new ActionBarCallback());
                }
                else
                {
                    actionMode.finish();
                }
            }
        });
    }

    class ActionBarCallback implements ActionMode.Callback{

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu)
        {
            mode.getMenuInflater().inflate(R.menu.contextual_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("My Action Mode");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //adds items to action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //To handle clicks on action bar
        int id= item.getItemId();
        //Inspection of SimplifiableStatement
        switch (id)
        {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Settings Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_camera:
                Toast.makeText(getApplicationContext(),"Camera Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(getApplicationContext(),"Delete Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:
                Toast.makeText(getApplicationContext(),"Logout Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_refresh:
                Toast.makeText(getApplicationContext(),"Refresh Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
