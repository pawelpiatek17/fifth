package com.example.pawe.fifth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final Integer REQUEST_CODE= 1233;
    public static final String OPERATION_RESULT = "com.example.pawe.fifth.operation_result";
    public static final String FIRST_ARGUMET = "com.example.pawe.fifth.first_argument";
    public static final String SECOND_ARGUMENT = "com.example.pawe.fifth.second_argument";
    public static final String OPERATION_TYPE = "com.example.pawe.fifth.operation_type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executeOnClick(View view) {
        String firstString = ((TextView)findViewById(R.id.editText_first_argument)).getText().toString();
        String secondString = ((TextView)findViewById(R.id.editText_second_argument)).getText().toString();
        if (!firstString.equals("") && !secondString.equals("")) {
            int firstArgument = Integer.parseInt(firstString);
            int secondArgument = Integer.parseInt(secondString);
            Intent intent = new Intent(Intent.ACTION_RUN);
            intent.putExtra(FIRST_ARGUMET, firstArgument);
            intent.putExtra(SECOND_ARGUMENT, secondArgument);
            startActivityForResult(intent, REQUEST_CODE);
        } else {
            Toast.makeText(this,"Check arguments",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                int operationResult = data.getIntExtra(OPERATION_RESULT,0);
                String operationType = data.getStringExtra(OPERATION_TYPE);
                ((TextView)findViewById(R.id.textView_result)).setText(String.valueOf(operationResult));
                ((TextView)findViewById(R.id.textView_operation)).setText(operationType);
            }
        }
    }
}
