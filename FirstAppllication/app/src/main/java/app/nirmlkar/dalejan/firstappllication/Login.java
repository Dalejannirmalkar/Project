package app.nirmlkar.dalejan.firstappllication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    IncredMysqliteDatabase database;
    AdapterRecycle adapterRecycle;
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        database = new IncredMysqliteDatabase(getApplicationContext());
        List<User> user=database.getAllUser();
        recycleview = findViewById(R.id.listView);
        adapterRecycle=new AdapterRecycle(user);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recycleview.setLayoutManager(layoutManager);
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setAdapter(adapterRecycle);


    }



}
