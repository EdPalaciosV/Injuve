package com.example.usuario.injuve;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.usuario.injuve.Adapters.ExpandableListViewAdapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    String ActTitle;
    Fragment fragmentResources;


    ExpandableListViewAdapter expandableListViewAdapter;
    ExpandableListView expandableListView;
    List<String> title=new ArrayList<>();
    Map<String,List<String>>childs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.dLayout);

        ActTitle=getTitle().toString();
        View header= getLayoutInflater().inflate(R.layout.nav_header_design,null,false);


        expandableListView=findViewById(R.id.list);
        expandableListView.addHeaderView(header);
        colocarItems();
        expandableListViewAdapter=new ExpandableListViewAdapter(this,title,childs);
        expandableListView.setAdapter(expandableListViewAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                getSupportActionBar().setTitle("INJUVE");
            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String selectedItem=expandableListViewAdapter.getChild(i,i1).toString();
                getSupportActionBar().setTitle(selectedItem);

                setFragmentArguments(selectedItem);
                drawerLayout.closeDrawer(GravityCompat.START);



                return false;
            }
        });
        setDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Injuve");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setDrawer()
    {
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);





    }

    public void colocarItems()
    {
        title= Arrays.asList("Voluntarios","Colaboradores","Mentor","Inversor","Migrantes","Creadores");

        List<String> voluntarios=Arrays.asList("¿Quiénes somos voluntarios?");
        List<String> colaboradores=Arrays.asList("¿Quiénes somos colaboradores?");
        List<String> mentor =Arrays.asList("¿Quiénes somos mentores?");
        List<String> inversor=Arrays.asList("¿Quiénes somos inversores?");
        List<String> migrantes=Arrays.asList("¿Quiénes somos migrantes?");
        List<String> creadores=Arrays.asList("¿Quiénes somos creadores?");

        childs=new HashMap<>();
        childs.put(title.get(0),voluntarios);
        childs.put(title.get(1),colaboradores);
        childs.put(title.get(2),mentor);
        childs.put(title.get(3),inversor);
        childs.put(title.get(4),migrantes);
        childs.put(title.get(5),creadores);




    }

    public void setFragmentArguments(String item)
    {
        Bundle bundle=new Bundle();
        bundle.putString("VAL",item);
        Log.d("tag",item);
        fragmentResources=new FragmentResources();
        fragmentResources.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentResources).disallowAddToBackStack().commit();




    }


}
