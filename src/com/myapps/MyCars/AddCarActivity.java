package com.myapps.MyCars;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.myapps.MyCars.data.CarDbHelper;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 7/13/14
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCarActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car);
        this.getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_car_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save_car:
                saveCar();
                return true;
            case R.id.action_settings:
//                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveCar() {
        final EditText carNameText = (EditText) findViewById(R.id.car_name);
        final EditText yearText = (EditText) findViewById(R.id.year);
        final EditText manufactureText = (EditText) findViewById(R.id.manufacture);
        final EditText modelText = (EditText) findViewById((R.id.model));
        final EditText mileageText = (EditText) findViewById(R.id.mileage);
        final EditText colorText = (EditText) findViewById(R.id.color);
        final EditText notesText = (EditText) findViewById(R.id.notes);

        final String carName = carNameText != null ? carNameText.getText().toString() : "";
        final long year = yearText != null ? Long.parseLong(yearText.getText().toString()) : Calendar.getInstance().get(Calendar.YEAR);
        final String manufacture = manufactureText != null ? manufactureText.getText().toString() : "";
        final String model = modelText != null ? modelText.getText().toString() : "";
        final long mileage = mileageText != null ? Long.parseLong(mileageText.getText().toString()) : 0;
        final String color = colorText != null ? colorText.getText().toString(): "";
        final String notes = notesText != null ? notesText.getText().toString(): "";

        final CarDbHelper dbHelper = new CarDbHelper(this);
        dbHelper.addCar(carName, year, manufacture, model, mileage, color, notes);

        this.startActivity(this.getParentActivityIntent());

    }

}