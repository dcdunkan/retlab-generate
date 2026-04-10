package in.etuwa.app.helper;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: ProgressRequestBody.kt */
/* loaded from: classes3.dex */
public final class ProgressRequestBody extends RequestBody {
    private final int DEFAULT_BUFFER_SIZE;
    private final String contentType;
    private final PublishSubject<Float> getProgressSubject;
    private final int ignoreFirstNumberOfWriteToCalls;
    private final File mFile;
    private int numWriteToCalls;

    public ProgressRequestBody(File mFile, String contentType, int i) {
        Intrinsics.checkNotNullParameter(mFile, "mFile");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.mFile = mFile;
        this.contentType = contentType;
        this.ignoreFirstNumberOfWriteToCalls = i;
        this.DEFAULT_BUFFER_SIZE = 2048;
        PublishSubject<Float> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.getProgressSubject = create;
    }

    public final Observable<Float> getProgressSubject() {
        return this.getProgressSubject;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public MediaType getContentType() {
        return MediaType.INSTANCE.parse(this.contentType + "/*");
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.mFile.length();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.numWriteToCalls++;
        long length = this.mFile.length();
        byte[] bArr = new byte[this.DEFAULT_BUFFER_SIZE];
        FileInputStream fileInputStream = new FileInputStream(this.mFile);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            int read = fileInputStream2.read(bArr);
            long j = 0;
            float f = 0.0f;
            while (read != -1) {
                j += read;
                sink.write(bArr, 0, read);
                read = fileInputStream2.read(bArr);
                if (this.numWriteToCalls > this.ignoreFirstNumberOfWriteToCalls) {
                    float f2 = (j / length) * 100.0f;
                    if (f2 - f <= 1.0f) {
                        if (f2 == 100.0f) {
                        }
                    }
                    this.getProgressSubject.onNext(Float.valueOf(f2));
                    f = f2;
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
        } finally {
        }
    }
}