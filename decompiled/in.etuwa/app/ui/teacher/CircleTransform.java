package in.etuwa.app.ui.teacher;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.squareup.picasso.Transformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TeacherAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class CircleTransform implements Transformation {
    @Override // com.squareup.picasso.Transformation
    public String key() {
        return "circle";
    }

    @Override // com.squareup.picasso.Transformation
    public Bitmap transform(Bitmap source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iMin = Math.min(source.getWidth(), source.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(source, (source.getWidth() - iMin) / 2, (source.getHeight() - iMin) / 2, iMin, iMin);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(source, x, y, size, size)");
        if (!Intrinsics.areEqual(bitmapCreateBitmap, source)) {
            source.recycle();
        }
        Bitmap.Config config = source.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, config);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(size, size,… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        bitmapCreateBitmap.recycle();
        return bitmapCreateBitmap2;
    }
}