package diego.mora.efinal.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatosSQLite extends SQLiteOpenHelper {
    public DatosSQLite (@Nullable Context context){
        super(context,"sueldos",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE sueldos(" +
                "idsueldos INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Sueldobasico float," +
                "Bonificacion float," +
                "Sueldototal float)");
    }

    public int sueldosInsert(DatosSQLite datosSQLite, float Sueldobasico, float Bonificacion, float Sueldototal){
        SQLiteDatabase db= datosSQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Sueldobasico",Sueldobasico);
        contentValues.put("Bonificacion",Bonificacion);
        contentValues.put("Sueldototal",Sueldototal);

        int autonumerico = (int)db.insert("sueldos", null, contentValues);
        return autonumerico;
    }

    public Cursor mostrarTodo(DatosSQLite datosSQLite){
        SQLiteDatabase db = datosSQLite.getReadableDatabase();
        String sql = "select * from sueldos";
        return db.rawQuery(sql,null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
