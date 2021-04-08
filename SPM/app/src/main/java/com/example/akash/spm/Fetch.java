package com.example.akash.spm;


        import android.content.Intent;
        import android.os.AsyncTask;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Toast;

        import org.apache.http.HttpResponse;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;


        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.URI;
        import java.net.URL;
        import java.sql.Connection;

        import static android.widget.Toast.*;


public class Fetch extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    Button btn1,btn2;
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, Homepage.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        btn1=(Button)findViewById(R.id.home);
        //btn2=(Button)findViewById(R.id.close);
        listView = (ListView)findViewById(R.id.ListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        new Connection().execute();



       // btn2.setOnClickListener(new View.OnClickListener() {

         //   @Override
           // public void onClick(View v) {
             //   // TODO Auto-generated method stub
               // finish();
                //System.exit(0);
            //}
      //  });
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //finish();
                //System.exit(0);
                btn1.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);

                finish();
            }
        });


    }
    class Connection extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {
            String result ="";
            String host ="http://192.168.43.213/cars.php";
            try{

                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer stringBuffer = new StringBuffer("");

                String line ="";
                while ((line = reader.readLine()) !=null){
                    stringBuffer.append(line);
                    break;
                }
                reader.close();
                result= stringBuffer.toString();




            }
            catch (Exception e){
                return new String("There exception: " + e.getMessage());

            }


            return result;
        }
        @Override
        protected void onPostExecute(String result){
            // parsing json data here
            try {
                JSONObject jsonResult = new JSONObject(result);
                int success = jsonResult.getInt("success");
                if(success ==1){
                    JSONArray cars = jsonResult.getJSONArray("cars");
                    for(int i=0;i< cars.length();i++){
                        JSONObject car = cars.getJSONObject(i);
                        String r_name = car.getString("r_name");
                        String r_address = car.getString("r_address");
                        double r_total = car.getDouble("r_total");
                        String r_date = car.getString("r_date");
                        String line = r_name + "\n"+ r_address+"\n"+r_total+"\n"+r_date;
                        adapter.add(line);

                    }
                }
                else
                    makeText(getApplicationContext(),"There is no car yet", LENGTH_SHORT).show();


            } catch (JSONException e) {
                //  e.printStackTrace();
                Toast.makeText(getApplicationContext(),e.getMessage(), LENGTH_SHORT).show();
            }
        }
    }

}
