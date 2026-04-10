package in.etuwa.app.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResolvUtil.kt */
/* loaded from: classes5.dex */
public final class ResolvUtilKt {
    public static final String getFileName(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query == null) {
            return "";
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            cursor2.moveToFirst();
            String string = query.getString(cursor2.getColumnIndex("_display_name"));
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(it.getC…bleColumns.DISPLAY_NAME))");
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }
}