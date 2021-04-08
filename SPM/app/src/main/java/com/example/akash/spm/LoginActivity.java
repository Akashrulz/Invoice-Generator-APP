package com.example.akash.spm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;

    Button button;
    TextView text;



    EditText ET_NAME,ET_PASS,et_email1,et_pass1;
    String login_name,login_pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_NAME = (EditText)findViewById(R.id.input_email);
        ET_PASS = (EditText)findViewById(R.id.input_password);

        ButterKnife.bind(this);
        button=(Button)findViewById(R.id.btn_login);


        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                login();
            }
        });



            text=(TextView) findViewById(R.id.link_signup);
        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity

                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });



    }

    public void login() {


        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        button.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

       // et_email =(EditText)findViewById(R.id.input_email);
        //String email=et_email.getText().toString();
        //ET_NAME = (EditText)findViewById(R.id.input_email);
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);



        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        button.setEnabled(true);
        Intent intent = new Intent(getApplicationContext(),Homepage.class);
        startActivity(intent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        button.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        et_email1 =(EditText)findViewById(R.id.input_email);
        String email=et_email1.getText().toString();

        et_pass1 =(EditText)findViewById(R.id.input_password);
        String password=et_pass1.getText().toString();



        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email1.setError("enter a valid email address");
            valid = false;
        } else {
            et_email1.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_pass1.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            et_pass1.setError(null);
        }

        return valid;
    }
}