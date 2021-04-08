package com.example.akash.spm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignupActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {

        // Simply Do noting!
    }

    EditText ET_NAME,ET_USER_EMAIL,ET_USER_PASS,et_name,et_address,et_email,et_mobile,et_password,et_repassword;
    String  user_name,user_email,user_pass,name,address,mobile;

    private static final String TAG = "SignupActivity";

    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.input_address) EditText _addressText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_mobile) EditText _mobileText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;



    Button button;
    TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ET_NAME=(EditText)findViewById(R.id.input_name);
        ET_USER_EMAIL=(EditText)findViewById(R.id.input_email);
        ET_USER_PASS=(EditText)findViewById(R.id.input_password);



        ButterKnife.bind(this);
        button=(Button)findViewById(R.id.btn_signup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        text=(TextView) findViewById(R.id.link_login);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void signup() {
        user_name=ET_NAME.getText().toString();
        user_email=ET_USER_EMAIL.getText().toString();
        user_pass=ET_USER_PASS.getText().toString();
        et_name =(EditText)findViewById(R.id.input_name);
        String name=et_name.getText().toString();

        et_address =(EditText)findViewById(R.id.input_address);
        address=et_address.getText().toString();

        et_mobile =(EditText)findViewById(R.id.input_mobile);
        mobile=et_mobile.getText().toString();

        et_email =(EditText)findViewById(R.id.input_email);
        String email=et_email.getText().toString();

        et_password =(EditText)findViewById(R.id.input_password);
        String password=et_password.getText().toString();

        et_repassword =(EditText)findViewById(R.id.input_reEnterPassword);
        String reEnterPassword=et_repassword.getText().toString();

        String method="register";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,user_name,user_pass,user_email,address,mobile);

        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        button.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();





        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        button.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        button.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        et_name =(EditText)findViewById(R.id.input_name);
        String name=et_name.getText().toString();

        et_address =(EditText)findViewById(R.id.input_address);
        String address=et_address.getText().toString();

        et_mobile =(EditText)findViewById(R.id.input_mobile);
        String mobile=et_mobile.getText().toString();

        et_email =(EditText)findViewById(R.id.input_email);
        String email=et_email.getText().toString();

        et_password =(EditText)findViewById(R.id.input_password);
        String password=et_password.getText().toString();

        et_repassword =(EditText)findViewById(R.id.input_reEnterPassword);
        String reEnterPassword=et_repassword.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            et_name.setError("at least 3 characters");
            valid = false;
        } else {
            et_name.setError(null);
        }

        if (address.isEmpty()) {
            et_address.setError("Enter Valid Address");
            valid = false;
        } else {
            et_address.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("enter a valid email address");
            valid = false;
        } else {
            et_email.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=10) {
            et_mobile.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            et_mobile.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            et_password.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            et_repassword.setError("Password Do not match");
            valid = false;
        } else {
            et_repassword.setError(null);
        }

        return valid;
    }
}