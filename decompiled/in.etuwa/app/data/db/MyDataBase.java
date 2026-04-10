package in.etuwa.app.data.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import in.etuwa.app.EtlabApp;
import in.etuwa.app.data.model.PushModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MyDataBase.kt */
/* loaded from: classes3.dex */
public final class MyDataBase extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyDataBase(EtlabApp app) {
        super(app, "MyDB", (SQLiteDatabase.CursorFactory) null, 1);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        if (db != null) {
            db.execSQL("CREATE TABLE IF NOT EXISTS Student(_id INTEGER PRIMARY KEY, title VARCHAR(256),msg VARCHAR(256), time VARCHAR(256))");
        }
    }

    public final void insertData(String title, String msg, String time) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(time, "time");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put(NotificationCompat.CATEGORY_MESSAGE, msg);
        contentValues.put("time", time);
        writableDatabase.insert("Student", null, contentValues);
        writableDatabase.close();
    }

    public final ArrayList<PushModel> queryMessages() {
        ArrayList<PushModel> arrayList = new ArrayList<>();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = readableDatabase.query("Student", null, null, null, null, null, "time DESC");
        Intrinsics.checkNotNullExpressionValue(query, "db.query(TABLE_NAME, nul…$COL_TIME DESC\"\n        )");
        query.moveToFirst();
        do {
            try {
                int i = query.getInt(query.getColumnIndex("_id"));
                String title = query.getString(query.getColumnIndex("title"));
                String msg = query.getString(query.getColumnIndex(NotificationCompat.CATEGORY_MESSAGE));
                String time = query.getString(query.getColumnIndex("time"));
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(msg, "msg");
                Intrinsics.checkNotNullExpressionValue(time, "time");
                arrayList.add(new PushModel(i, title, msg, time));
            } catch (Exception unused) {
            }
        } while (query.moveToNext());
        query.close();
        readableDatabase.close();
        return arrayList;
    }

    public final void deleteData(int id) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("Student", "_id=?", new String[]{String.valueOf(id)});
        writableDatabase.close();
    }

    public final void clearData() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("delete from Student");
        writableDatabase.close();
    }
}