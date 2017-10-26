package ru.geekbrains.traineeship.group2.search_person_popularity_mai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonsDirectoryActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons_directory);

        final Button btnBackPersonsDirectory = (Button) findViewById(R.id.btnBackPersonsDirectory);
        btnBackPersonsDirectory.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ){
            case R.id.btnBackPersonsDirectory:
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
