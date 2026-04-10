package in.etuwa.app.data.model;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;

/* compiled from: DownloadModel.kt */
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