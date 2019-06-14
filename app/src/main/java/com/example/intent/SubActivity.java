package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    EditText firstnum, secondnum;
    TextView tv;
    Button btn;
    int first, second, results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        firstnum=findViewById(R.id.sub_first);
        secondnum=findViewById(R.id.sub_second);
        btn=findViewById(R.id.sub_gobtn);
        tv=findViewById(R.id.sub_tv1);
        final String s=getIntent().getStringExtra("input");
        tv.setText(s);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=Integer.parseInt(firstnum.getText().toString());
                second=Integer.parseInt(secondnum.getText().toString());
                switch (s){
                    case "+" :
                        results = first+second;
                        break;
                    case "-" :
                        results = first-second;
                        break;
                }

                Intent resultintent = new Intent();
                resultintent.putExtra("result","연산결과는"+results+"입니다.");
                setResult(RESULT_OK,resultintent);//resultcode
                finish();
            }
        });
    }
}
