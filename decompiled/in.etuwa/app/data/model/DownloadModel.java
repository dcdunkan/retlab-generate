package in.etuwa.app.data.model;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;

/* compiled from: DownloadModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/data/model/DownloadModel;", "", "id", "", CommonCssConstants.POSITION, "", "(JI)V", "getId", "()J", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DownloadModel {
    private final long id;
    private final int position;

    public static /* synthetic */ DownloadModel copy$default(DownloadModel downloadModel, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = downloadModel.id;
        }
        if ((i2 & 2) != 0) {
            i = downloadModel.position;
        }
        return downloadModel.copy(j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public final DownloadModel copy(long id, int position) {
        return new DownloadModel(id, position);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadModel)) {
            return false;
        }
        DownloadModel downloadModel = (DownloadModel) other;
        return this.id == downloadModel.id && this.position == downloadModel.position;
    }

    public int hashCode() {
        return (DownloadModel$$ExternalSyntheticBackport0.m(this.id) * 31) + this.position;
    }

    public String toString() {
        return "DownloadModel(id=" + this.id + ", position=" + this.position + ")";
    }

    public DownloadModel(long j, int i) {
        this.id = j;
        this.position = i;
    }

    public final long getId() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }
}