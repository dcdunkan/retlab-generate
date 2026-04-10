package in.etuwa.app.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final String getRealPathFromURI(Context context, Uri contentUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        try {
            Pattern patternCompile = Pattern.compile("(\\d+)$");
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(\"(\\\\d+)$\")");
            Matcher matcher = patternCompile.matcher(String.valueOf(contentUri));
            Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(contentUri.toString())");
            if (!matcher.find()) {
                return "";
            }
            String strGroup = matcher.group();
            Intrinsics.checkNotNullExpressionValue(strGroup, "m.group()");
            String[] strArr = {"_data"};
            Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{strGroup}, null);
            Intrinsics.checkNotNull(cursorQuery);
            int columnIndex = cursorQuery.getColumnIndex(strArr[0]);
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnIndex)");
                str = string;
            }
            cursorQuery.close();
        } catch (Exception unused) {
        }
        return str;
    }
}