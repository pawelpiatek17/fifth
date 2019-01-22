package com.example.pawe.fifth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Starting add activity",Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        int firstArgument = intent.getIntExtra(MainActivity.FIRST_ARGUMET,-9999);
        int secondArgument = intent.getIntExtra(MainActivity.SECOND_ARGUMENT,-9999);
        Intent intent1 = new Intent();
        intent1.putExtra(MainActivity.OPERATION_RESULT,firstArgument+secondArgument);
        intent1.putExtra(MainActivity.OPERATION_TYPE,"Addition");
        setResult(RESULT_OK,intent1);
        finish();
    }
}
