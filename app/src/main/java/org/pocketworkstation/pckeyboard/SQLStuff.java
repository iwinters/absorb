package org.pocketworkstation.pckeyboard;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SQLStuff extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "dictionaries.db";
    private static final int DATABASE_VERSION = 1;

    public SQLStuff(Context context) {
        super(context, "dictionaries.db", null, DATABASE_VERSION);
    }

    public String SQLconnect(Context context, String input){
        String translation;
        String sql = "SELECT arabic FROM enar_dictionary WHERE english = '" + input + "' LIMIT 1;";
        SQLiteAssetHelper database = new SQLStuff(context);
        SQLiteDatabase db = database.getReadableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor res = db.rawQuery( sql, null );
        if (res.moveToFirst()){
            translation = res.getString(res.getColumnIndex("arabic"));
            return translation;}
        else {return null;}
    }
}

