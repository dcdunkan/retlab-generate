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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0007¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/db/MyDataBase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "app", "Lin/etuwa/app/EtlabApp;", "(Lin/etuwa/app/EtlabApp;)V", "clearData", "", "deleteData", "id", "", "insertData", "title", "", NotificationCompat.CATEGORY_MESSAGE, "time", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "queryMessages", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/PushModel;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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