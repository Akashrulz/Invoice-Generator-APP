
package com.example.akash.spm;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;


public class Part extends AppCompatActivity {



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
        setContentView(R.layout.activity_parts);





    }

    }





