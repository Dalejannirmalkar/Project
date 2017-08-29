package app.nirmlkar.dalejan.firstappllication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailsForm extends AppCompatActivity {
EditText etpm,etsec,etgr,etpgr,etdip,etphd,etname;
Button submit;
IncredMysqliteDatabase databse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_form);
        etpm=findViewById(R.id.eprimary);
        etsec=findViewById(R.id.esecondary);
        etgr=findViewById(R.id.egraduation);
        etpgr=findViewById(R.id.epostgr);
        etdip=findViewById(R.id.ediploma);
        etphd=findViewById(R.id.ephd);
        etname=findViewById(R.id.edname);
        submit=findViewById(R.id.enteredudetails);
        databse=new IncredMysqliteDatabase(getApplicationContext());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String primary = etpm.getText().toString();
                String secondary = etsec.getText().toString();
                String graduation = etgr.getText().toString();
                String postgraduation = etpgr.getText().toString();
                String dioloma = etdip.getText().toString();
                String phd = etphd.getText().toString();
                String name = etname.getText().toString();

                if (name.equals("") && primary.equals("") && secondary.equals("")) {

                    Toast.makeText(getApplicationContext(),"Enter All the Details",Toast.LENGTH_SHORT).show();

                    if(name.equals("") )
                    {
                        etname.setHint("Enter Name !");
                       etname.setHintTextColor(Color.RED);
                    }
                    if (etpm.equals(""))
                    {
                        etpm.setHint("Enter Primary Education !");
                        etpm.setHintTextColor(Color.RED);
                    }
                    if(etsec.equals(""))
                    {
                        etsec.setInputType(InputType.TYPE_CLASS_TEXT);
                        etsec.setHintTextColor(Color.RED);
                        etsec.setHint("Enter Secondary Education !");
                    }

                }

                else{
                    UserEdu user=new UserEdu();
                    user.setName(name);
                    user.setPm(primary);
                    user.setSec(secondary);
                    user.setGr(graduation);
                    user.setPgr(postgraduation);
                    user.setDip(dioloma);
                    user.setPhd(phd);


                    databse.addUseredu(user);
                }
            }
        });



    }
}
