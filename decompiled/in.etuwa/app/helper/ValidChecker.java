package in.etuwa.app.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ValidChecker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/helper/ValidChecker;", "Lin/etuwa/app/helper/ValidCheckHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "checkFileExistence", "", "title", "", "path", "checkPermission", "dateFormatter", "param", "isNetworkAvailable", "showPermissionDialog", "", "vibrate", "activity", "Landroid/app/Activity;", "time", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValidChecker implements ValidCheckHelper {
    private final Context context;

    public ValidChecker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // in.etuwa.app.helper.ValidCheckHelper
    public boolean isNetworkAvailable() {
        Object systemService = this.context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager.getActiveNetworkInfo() != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            Intrinsics.checkNotNull(activeNetworkInfo);
            if (activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    @Override // in.etuwa.app.helper.ValidCheckHelper
    public boolean checkPermission() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @Override // in.etuwa.app.helper.ValidCheckHelper
    public void showPermissionDialog() {
        Toast.makeText(this.context, "Go to Settings and Grant the permission to use this feature.", 0).show();
        new AlertDialog.Builder(this.context).setTitle("Storage Permission Needed").setMessage("This app needs the Storage permission to work properly, Please enable permission from settings").setPositiveButton("Settings", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.helper.ValidChecker$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ValidChecker.showPermissionDialog$lambda$0(ValidChecker.this, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$0(ValidChecker this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + this$0.context.getPackageName()));
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        this$0.context.startActivity(intent);
    }

    @Override // in.etuwa.app.helper.ValidCheckHelper
    public boolean checkFileExistence(String title, String path) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return new File(this.context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), path + title).exists();
            }
            return new File(Environment.getExternalStorageDirectory().toString() + path + title).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // in.etuwa.app.helper.ValidCheckHelper
    public void vibrate(Activity activity, long time) {
        VibrationEffect createOneShot;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Object systemService = activity.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                createOneShot = VibrationEffect.createOneShot(time, -1);
                vibrator.vibrate(createOneShot);
            } else {
                vibrator.vibrate(200L);
            }
        }
    }

    @Override // in.etuwa.app.helper.ValidCheckHelper
    public String dateFormatter(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        List split$default = StringsKt.split$default((CharSequence) param, new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
        return split$default.get(2) + HelpFormatter.DEFAULT_OPT_PREFIX + split$default.get(1) + HelpFormatter.DEFAULT_OPT_PREFIX + split$default.get(0);
    }
}