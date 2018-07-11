package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etname, etGPA;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //step1a: Get the user input from the EditText and store it in a variable
        String name = etname.getText().toString();
        Float gpa = Float.parseFloat(etGPA.getText().toString());
        Integer gender = rgGender.getCheckedRadioButtonId();
        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 1c: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 1d: Add the key value pair
        prefEdit.putString("name", name);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("gender", gender);
        //Step 1e: Call commit() method to save the changes into the SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2b: Retrieve the saved data with the key "greeting" from the SharedPreference object
        String msg = prefs.getString("name", "Name");
        Float gpa = prefs.getFloat("gpa", 0);
        Integer gender = prefs.getInt("gender", 1);
        etname.setText(msg);
        etGPA.setText(String.valueOf(gpa));
        rgGender.check(gender);
    }
}
