package com.example.david.rubikscubedemo;

//import android.net.http.RequestQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RubiksCube cube;
    TextView tempTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZE BUTTONS///////////////////////////////////////////////////////////////////////
        Button one = (Button) findViewById(R.id.button);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this); // calling onClick() method
        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(this); // calling onClick() method
        Button eight = (Button) findViewById(R.id.button8);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.button9);
        nine.setOnClickListener(this);
        Button ten = (Button) findViewById(R.id.button10);
        ten.setOnClickListener(this); // calling onClick() method
        Button eleven = (Button) findViewById(R.id.button11);
        eleven.setOnClickListener(this);
        Button twelve = (Button) findViewById(R.id.button12);
        twelve.setOnClickListener(this);

        tempTextView = (TextView) findViewById(R.id.textView);


        cube = new RubiksCube();
        tempTextView.setText(cube.getCube());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.button:
                tempTextView.setText(cube.Turn(1));
                break;
            case R.id.button2:
                tempTextView.setText(cube.Turn(2));
                break;
            case R.id.button3:
                tempTextView.setText(cube.Turn(3));
                break;
            case R.id.button4:
                tempTextView.setText(cube.Turn(4));
                break;
            case R.id.button5:
                tempTextView.setText(cube.Turn(5));
                break;
            case R.id.button6:
                tempTextView.setText(cube.Turn(6));
                break;
            case R.id.button7:
                tempTextView.setText(cube.Turn(7));
                break;
            case R.id.button8:
                tempTextView.setText(cube.Turn(8));
                break;
            case R.id.button9:
                tempTextView.setText(cube.Turn(9));
                break;
            case R.id.button10:
                tempTextView.setText(cube.Turn(10));
                break;
            case R.id.button11:
                tempTextView.setText(cube.Turn(11));
                break;
            case R.id.button12:
                tempTextView.setText(cube.Turn(12));
                break;
            case R.id.post:
//                try {
//                    String urlParameters = "param=FromTablet";
//                    byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
//                    int postDataLength = postData.length;
//                    String request = "192.168.42.215/index1.php";
//                    URL url = new URL(request);
//
//                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//                    conn.setDoOutput(true);
//                    conn.setInstanceFollowRedirects(false);
//                    conn.setRequestMethod("GET");
//                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//                    conn.setRequestProperty("charset", "utf-8");
//                    conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
//                    conn.setUseCaches(false);
//                    try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
//                        wr.write(postData);
//                    }

                    /*URL url = new URL("192.168.42.215/index1.php");
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setReadTimeout(15000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.write("Upload from Tablet");

                    writer.flush();
                    writer.close();
                    os.close();
                    int responseCode = conn.getResponseCode();
                    String response = "";
                    if(responseCode == HttpURLConnection.HTTP_OK){
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while((line=br.readLine()) != null){
                            response+=line;
                        }

                    }*/

//                }
//                   catch(Exception e){
//
//                }
                // Instantiate the RequestQueue.
                com.android.volley.RequestQueue queue = Volley.newRequestQueue(this);
                String url ="http://192.168.1.182/index1.php?param=" + cube.getCube();
                //String url ="http://www.google.com";

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                tempTextView.setText("Response is: "+ response.substring(0,10));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tempTextView.setText("That didn't work!");
                    }
                });
// Add the request to the RequestQueue.
                queue.add(stringRequest);

                break;
        }

    }
}
