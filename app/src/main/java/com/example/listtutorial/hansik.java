package com.example.listtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.content.Intent;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hansik extends AppCompatActivity {
    final String url = "http://192.168.0.2/get_sensor.php";

    /** for webSever data **/
    String dataJSON;
    String lines = "";
    String lines2 = "";
    private static final String TAG_RESULTS = "result";
    private static final String TAG_DISTANT = "distant";
    private static final String TAG_TOUCH = "touch";

    JSONArray sensors = null;

    ArrayList<HashMap<String, String>> personList;
    ArrayList<HashMap<String, String>> distantList;
    ArrayList<HashMap<String, String>> touchList;

    // test //
    Button refreshedButton;
    TextView text;
    TextView text2;
    /****************************/

    /** back_Button **/
    Button back;
    /*****************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansik);

        /** networking **/
        // list = (ListView)findViewById(R.id.values);
        text = (TextView)findViewById(R.id.values);
        text2 = (TextView)findViewById(R.id.values2);
        refreshedButton = findViewById(R.id.refreshed);
        distantList = new ArrayList<HashMap<String, String>>();
        touchList = new ArrayList<HashMap<String, String>>();

        getData(url);

        /** refreshed button event trigger.. **/
        refreshedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lines = "";
                lines2 = "";
                getData(url);
            }
        });
        /*****************/

        back = findViewById (R.id.button);
        back.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (hansik.this, MainActivity.class);
                startActivity (intent);
            }
        });

    }

    protected void showList() {
        try {
            JSONObject jsonObj = new JSONObject(dataJSON);
            sensors = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < sensors.length(); i++) {
                JSONObject c = sensors.getJSONObject(i);
                // String id = c.getString(TAG_ID);
                String distant = c.getString(TAG_DISTANT);
                String touch = c.getString(TAG_TOUCH);
                lines += distant + " ";
                lines2 += touch + " ";

                HashMap<String, String> distants = new HashMap<String, String>();
                HashMap<String, String> touchs = new HashMap<String, String>();

                //  distants.put(TAG_ID, id);
                distants.put(TAG_DISTANT, distant);
                distants.put(TAG_TOUCH, touch);

                distantList.add(distants);
                distantList.add(touchs);
            }

            text.setText(lines);
            text2.setText(lines2);

            /*
            ListAdapter adapter = new SimpleAdapter(
                    hansik.this, distantList, R.layout.list_item,
                    new String[]{TAG_DISTANT},
                    new int[]{R.id.values}
            );
            list.setAdapter(adapter);
            */
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    // getData("http://172.31.40.215/get_sensor.php");
    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }


            }

            @Override
            protected void onPostExecute(String result) {
                dataJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }
}
