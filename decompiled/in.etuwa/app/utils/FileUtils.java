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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lin/etuwa/app/utils/FileUtils;", "", "()V", "getRealPathFromURI", "", "context", "Landroid/content/Context;", "contentUri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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