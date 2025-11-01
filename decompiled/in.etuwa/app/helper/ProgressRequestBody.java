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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0016J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/helper/ProgressRequestBody;", "Lokhttp3/RequestBody;", "mFile", "Ljava/io/File;", CMSAttributeTableGenerator.CONTENT_TYPE, "", "ignoreFirstNumberOfWriteToCalls", "", "(Ljava/io/File;Ljava/lang/String;I)V", "DEFAULT_BUFFER_SIZE", "getProgressSubject", "Lio/reactivex/subjects/PublishSubject;", "", "numWriteToCalls", "contentLength", "", "Lokhttp3/MediaType;", "Lio/reactivex/Observable;", "writeTo", "", "sink", "Lokio/BufferedSink;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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