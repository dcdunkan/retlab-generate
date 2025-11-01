package in.etuwa.app.data.model.quiz.file;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizFileUploadResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/quiz/file/QuizFileUploadResponse;", "", "id", "", "name", "url", "delete_url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDelete_url", "()Ljava/lang/String;", "getId", "getName", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class QuizFileUploadResponse {
    private final String delete_url;
    private final String id;
    private final String name;
    private final String url;

    public static /* synthetic */ QuizFileUploadResponse copy$default(QuizFileUploadResponse quizFileUploadResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizFileUploadResponse.id;
        }
        if ((i & 2) != 0) {
            str2 = quizFileUploadResponse.name;
        }
        if ((i & 4) != 0) {
            str3 = quizFileUploadResponse.url;
        }
        if ((i & 8) != 0) {
            str4 = quizFileUploadResponse.delete_url;
        }
        return quizFileUploadResponse.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDelete_url() {
        return this.delete_url;
    }

    public final QuizFileUploadResponse copy(String id, String name, String url, String delete_url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(delete_url, "delete_url");
        return new QuizFileUploadResponse(id, name, url, delete_url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizFileUploadResponse)) {
            return false;
        }
        QuizFileUploadResponse quizFileUploadResponse = (QuizFileUploadResponse) other;
        return Intrinsics.areEqual(this.id, quizFileUploadResponse.id) && Intrinsics.areEqual(this.name, quizFileUploadResponse.name) && Intrinsics.areEqual(this.url, quizFileUploadResponse.url) && Intrinsics.areEqual(this.delete_url, quizFileUploadResponse.delete_url);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.url.hashCode()) * 31) + this.delete_url.hashCode();
    }

    public String toString() {
        return "QuizFileUploadResponse(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", delete_url=" + this.delete_url + ")";
    }

    public QuizFileUploadResponse(String id, String name, String url, String delete_url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(delete_url, "delete_url");
        this.id = id;
        this.name = name;
        this.url = url;
        this.delete_url = delete_url;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDelete_url() {
        return this.delete_url;
    }
}