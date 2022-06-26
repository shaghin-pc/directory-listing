package com.example.traceroute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText ed1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textview);
        ed1=(EditText)findViewById(R.id.edittext);
        button=(Button)findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ip=ed1.getText().toString();

                runSystemCommand("tracert " +Ip);
            }
        });
    }

    private void runSystemCommand(String cmd) {

        try{
            Process p=Runtime.getRuntime().exec(cmd);
            BufferedReader InputStream=new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s=" ";
            while((s=InputStream.readLine())!=null)
            {
                //System.out.println(s);
                //textView.setText(s);
                s=s+"\n"+s;
            }
            textView.setText(s);
            Toast.makeText(getApplicationContext(),"cmplited",Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}