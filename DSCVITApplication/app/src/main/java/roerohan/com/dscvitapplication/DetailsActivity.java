package roerohan.com.dscvitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView textt = (TextView)findViewById(R.id.textt);
        String Tempholder = getIntent().getStringExtra("version");
        String dirr = getIntent().getStringExtra("dir");
        textt.setText(textt.getText()+"\n"+ "App Version: "+ Tempholder+"\n");
        textt.setText(textt.getText()+"\n"+"Data Directory: "+ dirr);
        }
}
