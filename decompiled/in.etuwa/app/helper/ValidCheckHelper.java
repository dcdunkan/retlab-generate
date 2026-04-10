package in.etuwa.app.helper;

import android.app.Activity;
import kotlin.Metadata;

/* compiled from: ValidCheckHelper.kt */
/* loaded from: classes3.dex */
public interface ValidCheckHelper {
    boolean checkFileExistence(String title, String path);

    boolean checkPermission();

    String dateFormatter(String param);

    boolean isNetworkAvailable();

    void showPermissionDialog();

    void vibrate(Activity activity, long time);
}