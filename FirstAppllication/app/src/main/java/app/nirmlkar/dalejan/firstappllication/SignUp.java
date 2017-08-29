package app.nirmlkar.dalejan.firstappllication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {

    EditText username,email,password;
    Button btSignUp;

    IncredMysqliteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=findViewById(R.id.eusername);
        email=findViewById(R.id.eemail);
        password=findViewById(R.id.epassword);

        btSignUp = findViewById(R.id.signupdetail);

        database = new IncredMysqliteDatabase(getApplicationContext());


        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String uname = username.getText().toString();
                String uemail = email.getText().toString();
                String upassword = password.getText().toString();


                if( uname.equals("") && uemail.equals("") && upassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter All the Details",Toast.LENGTH_SHORT).show();

                    if(uname.equals("") )
                    {
                        username.setHint("Enter Username !");
                        username.setHintTextColor(Color.RED);
                    }
                    if (uemail.equals(""))
                    {
                        email.setHint("Enter Email Id !");
                        email.setHintTextColor(Color.RED);
                    }
                    if(upassword.equals(""))
                    {
                        password.setInputType(InputType.TYPE_CLASS_TEXT);
                        password.setHintTextColor(Color.RED);
                        password.setHint("Enter Password !");
                    }
                }
                else
                {

                    User user=new User();

                    user.setName(uname);
                    user.setEmail(uemail);
                    user.setPassword(upassword);

                    Toast.makeText(getApplicationContext(),uname+" "+" "+uemail+" "+upassword+"\n"+"Signup Success",Toast.LENGTH_SHORT).show();

                    database.addUser(user);




                }


            }
        });



    }
}
