package ru.hse.farm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.util.Pair;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.addOnItemTouchListener(new RecyclerClickListener(this, new RecyclerClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, AdvDetails.class);
                intent.putExtra(AdvDetails.ID, Advertisement.ADVERTISEMENTS.get(position).advId);
                //startActivity(intent);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        // the context of the activity
                        MainActivity.this,

                        // For each shared element, add to this method a new Pair item,
                        // which contains the reference of the view we are transitioning *from*,
                        // and the value of the transitionName attribute
                        new Pair<View, String>(view.findViewById(R.id.adv_photo),
                                getString(R.string.transition_name_image))
                );
                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        }));

        initializeAdapter();
    }


    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter();
        rv.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onSettingsClick(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_all) {
            //В главную активити через RecyclerView вывести все возможные объявления
        } else if (id == R.id.nav_vegetables) {
            //В главную активити через RecyclerView вывести объявления из категории Овощи
        } else if (id == R.id.nav_fruit) {
            //Вывести объявления из категории Фрукты
        } else if (id == R.id.nav_milk) {
            //Вывести объявления из категории Молочные продукты
        } else if (id == R.id.nav_meat) {
            //Вывести объявления из категории Мясные продукты
        } else if (id == R.id.nav_my_page) {
            //Intent intent = new Intent(MainActivity.this, .class);
            //startActivity(intent);
        } else if (id == R.id.nav_my_advt) {
            //Переход на страницу с объявлениями пользователя
        } else if (id == R.id.nav_my_favorites){
            //Переход на страницу с избранными объявлениями
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
