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

import java.util.Date;


public class Namespace extends AppCompatActivity {
    Button bt_next;
    EditText et_name, et_address;
     String name,add;
    int i=1;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, Homepage.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        bt_next = (Button) findViewById(R.id.next);

        et_name = (EditText) findViewById(R.id.tname);
        et_address = (EditText) findViewById(R.id.taddress);

        name=et_name.getText().toString();
        add=et_address.getText().toString();

        final String[] a=new String[1];
        final String[] b=new String[1];



        bt_next.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {


                a[0]=et_name.getText().toString();
                b[0]=et_address.getText().toString();



                bt_next.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), pdf1.class);
                intent.putExtra("name",a[0]);
                intent.putExtra("add",b[0]);

                startActivity(intent);

                finish();

            }
        });



    }
}
