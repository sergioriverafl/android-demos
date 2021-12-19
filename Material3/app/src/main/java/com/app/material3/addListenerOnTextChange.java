package com.app.material3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.databinding.ObservableArrayMap;


public class addListenerOnTextChange implements TextWatcher {

    private Context mContext;
    EditText mEdittextview;
    ObservableArrayMap<String, Object> mInfoDatabase = new ObservableArrayMap<>();

    String myDb, myTable;
    Integer myAutoincrementable;

    public addListenerOnTextChange(Context context, EditText edittextview, ObservableArrayMap infoDatabase) {
        super();
        this.mContext = context;
        this.mEdittextview = edittextview;
        this.mInfoDatabase = infoDatabase;

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override
    public void afterTextChanged(Editable ValueCampo) {
        System.out.println(ValueCampo.toString() + ".com");
        System.out.println(mInfoDatabase.toString());

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.mContext, "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put("codigo", "1");
        registro.put("descripcion", "Sergio");
        registro.put("precio", "Rivera");

        bd.insert("users", null, registro);
        bd.close();

    }
}
