package sg.edu.rp.c346.id22021506.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetSongs;

    EditText etSong;
    EditText etSinger;
    EditText etYear;

    RadioGroup radg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetSongs = findViewById(R.id.btnGetSongs);

        etSong = findViewById(R.id.etSong);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);

        radg = findViewById(R.id.radiog);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context


                // Insert a task
                String etSong = etSong.getText().toString();
                String etSinger = etSinger.getText().toString();
                int etYear = Integer.parseInt(etYear.getText().toString());
                int stars = checkRadioButton();

                DBhelper db = new DBhelper(MainActivity.this);

                db.insertSong(etSong, etSinger, etYear, stars);


            }
        });
        btnGetSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, song.class);
                startActivity(intent);
            }
        });
    }
        private int checkRadioButton(){
            int star = radg.getCheckedRadioButtonId();
            int value = 1;

            if (star == R.id.radioButton1) {
                value = 1;
            } else if (star == R.id.radioButton2) {
                value = 2;
            } else if (star == R.id.radioButton3) {
                value = 3;
            } else if (star == R.id.radioButton4) {
                value = 4;
            } else if (star == R.id.radioButton5) {
                value = 5;
            } else {
                value = 1;
            }
            return value;
    }
}
