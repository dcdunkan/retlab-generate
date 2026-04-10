package in.etuwa.app.helper;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: DownloadManagerHelper.kt */
/* loaded from: classes3.dex */
public final class DownloadManagerHelper {
    private final Context context;
    private final Regex re;

    public DownloadManagerHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.re = new Regex("[^A-Za-z0-9.]");
    }

    public final Context getContext() {
        return this.context;
    }

    public final Regex getRe() {
        return this.re;
    }

    public final long startDownloading(String path, String url) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String replace = this.re.replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
            Object systemService = this.context.getSystemService("download");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
            DownloadManager downloadManager = (DownloadManager) systemService;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            if (Build.VERSION.SDK_INT >= 29) {
                request.setTitle(replace).setDestinationInExternalFilesDir(this.context, null, Environment.DIRECTORY_DOWNLOADS + path + replace).setNotificationVisibility(1);
            } else {
                request.setTitle(replace).setDestinationInExternalPublicDir(path, replace).setNotificationVisibility(1);
            }
            return downloadManager.enqueue(request);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final void openFile(String title, String path) {
        File file;
        Uri fromFile;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                file = new File(this.context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), path + title);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path, title);
            }
            if (!file.exists()) {
                Toast.makeText(this.context, "File not found", 0).show();
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(this.context, "in.etuwa.app.fileprovider", file);
                Intrinsics.checkNotNullExpressionValue(fromFile, "{\n                // ✅ M…\", newFile)\n            }");
            } else {
                fromFile = Uri.fromFile(file);
                Intrinsics.checkNotNullExpressionValue(fromFile, "{\n                Uri.fr…le(newFile)\n            }");
            }
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
            if (mimeTypeFromExtension == null) {
                mimeTypeFromExtension = "*/*";
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, mimeTypeFromExtension);
            intent.addFlags(1);
            intent.addFlags(67108864);
            List<ResolveInfo> queryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
            if (true ^ queryIntentActivities.isEmpty()) {
                this.context.startActivity(Intent.createChooser(intent, "Open with"));
            } else {
                Toast.makeText(this.context, "No app found to open this file", 0).show();
            }
        } catch (Exception e) {
            Log.e("OpenFile", "Error: " + e.getMessage(), e);
            Toast.makeText(this.context, "Error opening file", 0).show();
        }
    }
}