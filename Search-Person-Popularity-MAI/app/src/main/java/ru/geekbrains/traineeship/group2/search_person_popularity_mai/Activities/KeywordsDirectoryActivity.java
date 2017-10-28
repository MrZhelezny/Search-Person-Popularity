package ru.geekbrains.traineeship.group2.search_person_popularity_mai.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.geekbrains.traineeship.group2.search_person_popularity_mai.R;

public class KeywordsDirectoryActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keywords_directory);

        final Button btnBackKeywordsDirectory = (Button) findViewById(R.id.btnBackKeywordsDirectory);
        btnBackKeywordsDirectory.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ){
            case R.id.btnBackKeywordsDirectory:
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
