package com.example.blog;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;
import android.os.Bundle;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button_new_post);
        final EditText textViewTitle = findViewById(R.id.editTextTitle);
        final EditText textViewContent = findViewById(R.id.editTextContent);

        button.setOnClickListener(v -> {
            Context context = getApplicationContext();
            try {
                String titleString = textViewTitle.getText().toString();
                String contentString = textViewContent.getText().toString();
                postRequest(context, titleString, contentString);
            } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void postRequest(Context context, String title, String content) throws Exception {
        // replace with your host server URI
        String URL="http://192.168.1.87:3000/api/v1/posts";

        JSONObject postDataParams = new JSONObject();
        postDataParams.put("title", title);
        postDataParams.put("content", content);

        ApiCaller apiCaller = new ApiCaller();
        apiCaller.Submit(URL, postDataParams.toString(), context);
    }
}