package in.etuwa.app.data.model.chat.subjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chat.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSem() {
        return this.sem;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
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