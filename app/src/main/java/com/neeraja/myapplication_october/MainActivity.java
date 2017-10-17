package com.neeraja.myapplication_october;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.neeraja.myapplication_october.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements itemFragment.OnListFragmentInteractionListener, PlusOneFragment.OnFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener{



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment_blank();
                    return true;
                case R.id.navigation_dashboard:
                    showFragment_item();
                    return true;
                case R.id.navigation_notifications:
                    showFragment_plusone();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment frag = new BlankFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,frag);
        ft.addToBackStack(null);
        ft.commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public void showFragment_item(){

        itemFragment frag = new itemFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,frag);
        ft.addToBackStack(null);
        ft.commit();

    }
    public void showFragment_blank(){

        BlankFragment frag = new BlankFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,frag);
        ft.addToBackStack(null);
        ft.commit();

    }
    public void showFragment_plusone(){

        PlusOneFragment frag = new PlusOneFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,frag);
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

        Toast.makeText(this,"item selected", Toast.LENGTH_SHORT);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
