package com.example.blog;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONObject;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button_new_post);
        button.setOnClickListener(v -> {
            Context context = getApplicationContext();
            try {
                postRequest(context);
            } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void postRequest(Context context) throws Exception {
        JSONObject postDataParams = new JSONObject();
        postDataParams.put("title", "Manjeet");
        postDataParams.put("content", "manjeet@gmail.com");
        ApiCaller apiCaller = new ApiCaller();
        apiCaller.Submit(postDataParams.toString(), context);
    }
}