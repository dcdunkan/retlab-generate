package in.etuwa.app.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
/* loaded from: classes5.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final String getRealPathFromURI(Context context, Uri contentUri) {
        Matcher matcher;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        try {
            Pattern compile = Pattern.compile("(\\d+)$");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(\"(\\\\d+)$\")");
            matcher = compile.matcher(String.valueOf(contentUri));
            Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(contentUri.toString())");
        } catch (Exception unused) {
        }
        if (!matcher.find()) {
            return "";
        }
        String group = matcher.group();
        Intrinsics.checkNotNullExpressionValue(group, "m.group()");
        String[] strArr = {"_data"};
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{group}, null);
        Intrinsics.checkNotNull(query);
        int columnIndex = query.getColumnIndex(strArr[0]);
        if (query.moveToFirst()) {
            String string = query.getString(columnIndex);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnIndex)");
            str = string;
        }
        query.close();
        return str;
    }
}