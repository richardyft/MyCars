package com.myapps.MyCars.data;

import android.provider.BaseColumns;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 7/13/14
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class CarContract {

    public CarContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class CarEntry implements BaseColumns {
        public static final String TABLE_NAME = "car";
        public static final String CAR_NAME = "carname";
        public static final String YEAR = "year";
        public static final String MANUFACTURE = "manufacture";
        public static final String MODEL = "model";
        public static final String MILEAGE = "mileage";
        public static final String COLOR = "color";
        public static final String NOTES = "notes";
    }
}
