package app.nirmlkar.dalejan.firstappllication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail,etPassword;
    IncredMysqliteDatabase database;
    Button btLogin,btSignUp,btdash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail=findViewById(R.id.input_email);
        etPassword=findViewById(R.id.input_password);
        btLogin=findViewById(R.id.login);
        btSignUp=findViewById(R.id.signup);
        btdash=findViewById(R.id.dashboard);
        btdash.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        btSignUp.setOnClickListener(this);

        database = new IncredMysqliteDatabase(getApplicationContext());



    }

    public boolean varification(String email,String pass){

        //check in the sqlitedatabase if user details exits and are correct
        boolean dEmail=database.checkUser(email,pass);
        if (dEmail){
            return true;
        }

return false;
    }


    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.login: //check for user login here
             {
                if (etEmail.getText().toString() != null && etPassword.getText().toString() != null)
                {
                 String email=etEmail.getText().toString();
                 String pass=etPassword.getText().toString();
                 if (varification(email,pass)){
                     startActivity(new Intent(getApplicationContext(),DetailsForm.class));

                 }

                }
                break;

         }

         case R.id.signup: //sign up user details here and save in sqlitedatabase
                {
           startActivity(new Intent(getApplicationContext(),SignUp.class));
           break;

         }
         case R.id.dashboard:{

             startActivity(new Intent(getApplicationContext(),Login.class));
         }

     }
    }
}