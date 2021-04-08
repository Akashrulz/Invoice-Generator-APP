package com.example.akash.spm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class Homepage extends AppCompatActivity {


    @Override
    public void onBackPressed() {

        // Simply Do noting!
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        final ImageButton invoice,record,part,close;

        invoice=(ImageButton)findViewById(R.id.invoice);
        record=(ImageButton)findViewById(R.id.record);

        part=(ImageButton)findViewById(R.id.part);
        close=(ImageButton)findViewById(R.id.close);


        invoice.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                invoice.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), iteminfo1.class);

                startActivity(intent);

                finish();

            }
        });


        record.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                record.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), Fetch.class);

                startActivity(intent);

                finish();

            }
        });

        part.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                part.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), Part.class);

                startActivity(intent);

                finish();

            }
        });

        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });


    }

}



