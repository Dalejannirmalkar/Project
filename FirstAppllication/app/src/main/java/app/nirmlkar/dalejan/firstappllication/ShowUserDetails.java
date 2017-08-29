package app.nirmlkar.dalejan.firstappllication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ShowUserDetails extends AppCompatActivity {

    IncredMysqliteDatabase database;
    AdapterLogin adapterRecycle;
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_details);
        database = new IncredMysqliteDatabase(getApplicationContext());
        List<UserEdu> user=database.getAlledu();
        recycleview = findViewById(R.id.showloginuserdetails);
        adapterRecycle=new AdapterLogin(user);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recycleview.setLayoutManager(layoutManager);
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setAdapter(adapterRecycle);

    }
}
