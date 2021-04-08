package com.example.akash.spm;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class iteminfo1 extends AppCompatActivity {

    static String value1,text,text1,value2,value3,text2;

    static int count=0;

    Button bt_inext,add,generate;

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
        setContentView(R.layout.activity_iteminfo1);

        bt_inext=(Button)findViewById(R.id.inext);

        generate=(Button)findViewById(R.id.inext1);


        final String[] h =new String[1];
        final String[] i =new String[1];


        Spinner spinner = findViewById(R.id.Spinner);

         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.q1, android.R.layout.simple_spinner_item);

         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(adapter);

        Spinner spinner1 = findViewById(R.id.Spinner1);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.q2, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);

        Spinner spinner2 = findViewById(R.id.Spinner2);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.q3, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text



                Spinner spinner = (Spinner)findViewById(R.id.Spinner);
                text = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text



                Spinner spinner1 = (Spinner)findViewById(R.id.Spinner1);
                text1 = spinner1.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text



                Spinner spinner2 = (Spinner)findViewById(R.id.Spinner2);
                text2 = spinner2.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        value1=String.valueOf(text);
        value2=String.valueOf(text1);
        value3=String.valueOf(text2);
                final String a, b, c;
                Intent z = getIntent();
                a = z.getStringExtra("name");
                b = z.getStringExtra("add");


        bt_inext.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {


                pdf1 obj1=new pdf1();
                obj1.myfun(count,value1,value2,value3);

                        bt_inext.setEnabled(true);
                        Intent intent = new Intent(getApplicationContext(), iteminfo1.class);

                        intent.putExtra("name",h[0]);
                        intent.putExtra("add",i[0]);

                        startActivity(intent);

                        finish();
                        count++;
                    }
                });




        generate.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {

                h[0]=  a;
                i[0]=  b;
                pdf1 obj1 = new pdf1();
                obj1.myfun(count, value1, value2, value3);

                bt_inext.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), Namespace.class);
                intent.putExtra("name",h[0]);
                intent.putExtra("add",i[0]);
                startActivity(intent);

                finish();

            }
        });
                    }

    }



