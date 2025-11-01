package in.etuwa.app.data.model.chat.subjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/chat/subjects/Chat;", "", "subjectId", "", "subject", "sem", "batchId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBatchId", "()Ljava/lang/String;", "getSem", "getSubject", "getSubjectId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Chat {

    @SerializedName("batch_id")
    @Expose
    private final String batchId;
    private final String sem;
    private final String subject;

    @SerializedName("subject_id")
    @Expose
    private final String subjectId;

    public static /* synthetic */ Chat copy$default(Chat chat, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chat.subjectId;
        }
        if ((i & 2) != 0) {
            str2 = chat.subject;
        }
        if ((i & 4) != 0) {
            str3 = chat.sem;
        }
        if ((i & 8) != 0) {
            str4 = chat.batchId;
        }
        return chat.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSem() {
        return this.sem;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    public final Chat copy(String subjectId, String subject, String sem, String batchId) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(sem, "sem");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return new Chat(subjectId, subject, sem, batchId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) other;
        return Intrinsics.areEqual(this.subjectId, chat.subjectId) && Intrinsics.areEqual(this.subject, chat.subject) && Intrinsics.areEqual(this.sem, chat.sem) && Intrinsics.areEqual(this.batchId, chat.batchId);
    }

    public int hashCode() {
        return (((((this.subjectId.hashCode() * 31) + this.subject.hashCode()) * 31) + this.sem.hashCode()) * 31) + this.batchId.hashCode();
    }

    public String toString() {
        return "Chat(subjectId=" + this.subjectId + ", subject=" + this.subject + ", sem=" + this.sem + ", batchId=" + this.batchId + ")";
    }

    public Chat(String subjectId, String subject, String sem, String batchId) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(sem, "sem");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        this.subjectId = subjectId;
        this.subject = subject;
        this.sem = sem;
        this.batchId = batchId;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSem() {
        return this.sem;
    }

    public final String getBatchId() {
        return this.batchId;
    }
}