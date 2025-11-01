package in.etuwa.app.helper;

import android.app.Activity;
import kotlin.Metadata;

/* compiled from: ValidCheckHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/helper/ValidCheckHelper;", "", "checkFileExistence", "", "title", "", "path", "checkPermission", "dateFormatter", "param", "isNetworkAvailable", "showPermissionDialog", "", "vibrate", "activity", "Landroid/app/Activity;", "time", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ValidCheckHelper {
    boolean checkFileExistence(String title, String path);

    boolean checkPermission();

    String dateFormatter(String param);

    boolean isNetworkAvailable();

    void showPermissionDialog();

    void vibrate(Activity activity, long time);
}