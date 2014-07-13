package com.myapps.MyCars.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 7/13/14
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class CarDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyCars.db";
    private static final String TEXT_TYPE = " TEXT ";
    private static final String INT_TYPE = " INTEGER ";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CarContract.CarEntry.TABLE_NAME + " (" +
                    CarContract.CarEntry._ID + " INTEGER PRIMARY KEY," +
                    CarContract.CarEntry.CAR_NAME + TEXT_TYPE + COMMA_SEP +
                    CarContract.CarEntry.YEAR + INT_TYPE + COMMA_SEP +
                    CarContract.CarEntry.MANUFACTURE + TEXT_TYPE + COMMA_SEP +
                    CarContract.CarEntry.MODEL + TEXT_TYPE + COMMA_SEP +
                    CarContract.CarEntry.MILEAGE + INT_TYPE + COMMA_SEP +
                    CarContract.CarEntry.COLOR + TEXT_TYPE + COMMA_SEP +
                    CarContract.CarEntry.NOTES + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CarContract.CarEntry.TABLE_NAME;

    public static final String[] CAR_PROJECTION = new String[]{
            CarContract.CarEntry._ID,
            CarContract.CarEntry.CAR_NAME,
            CarContract.CarEntry.YEAR,
            CarContract.CarEntry.MANUFACTURE,
            CarContract.CarEntry.MODEL,
            CarContract.CarEntry.MILEAGE,
            CarContract.CarEntry.COLOR,
            CarContract.CarEntry.NOTES
    };
    public static final String CAR_SORT_ORDER = CarContract.CarEntry._ID + " DESC";

    public CarDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public List<Car> getAllCars() {
        Cursor c = getAllCarsCursor();

        final List<Car> cars = new ArrayList<Car>();
        if (c.moveToFirst()) {
            do {
                Car car = new Car();
                car.setId(c.getLong(c.getColumnIndexOrThrow(CarContract.CarEntry._ID)));
                car.setName(c.getString(c.getColumnIndexOrThrow(CarContract.CarEntry.CAR_NAME)));
                car.setManufacture(c.getString(c.getColumnIndexOrThrow(CarContract.CarEntry.MANUFACTURE)));
                car.setModel(c.getString(c.getColumnIndexOrThrow(CarContract.CarEntry.MODEL)));
                cars.add(car);
            } while (c.moveToNext());
        }

        return cars;
    }

    public Cursor getAllCarsCursor() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(CarContract.CarEntry.TABLE_NAME, CAR_PROJECTION, null, null, null, null, CAR_SORT_ORDER);
    }


    public void addCar(String carName, long year, String manufacture, String model, long mileage, String color, String notes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CarContract.CarEntry.CAR_NAME, carName);
        values.put(CarContract.CarEntry.YEAR, year);
        values.put(CarContract.CarEntry.MANUFACTURE, manufacture);
        values.put(CarContract.CarEntry.MODEL, model);
        values.put(CarContract.CarEntry.MILEAGE, mileage);
        values.put(CarContract.CarEntry.COLOR, color);
        values.put(CarContract.CarEntry.NOTES, notes);

        db.insert(
                CarContract.CarEntry.TABLE_NAME,
                "null",
                values);

    }
}
