package in.etuwa.app.data.model.quiz.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Quiz.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Quiz {
    private final String description;

    @SerializedName("end_time")
    @Expose
    private final String endTime;
    private final String id;
    private final boolean isCompleted;
    private final boolean isOnGoing;
    private final boolean isResultPublished;
    private final boolean isStarted;

    @SerializedName("max_mark")
    @Expose
    private final String maxMark;
    private final String name;

    @SerializedName("start_time")
    @Expose
    private final String startTime;
    private final String statusText;
    private final String type;
    private final String typeText;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsStarted() {
        return this.isStarted;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsOnGoing() {
        return this.isOnGoing;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsResultPublished() {
        return this.isResultPublished;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTypeText() {
        return this.typeText;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    public final Quiz copy(String id, String name, String description, String startTime, String endTime, String maxMark, String type, String typeText, String statusText, boolean isStarted, boolean isOnGoing, boolean isCompleted, boolean isResultPublished) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeText, "typeText");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        return new Quiz(id, name, description, startTime, endTime, maxMark, type, typeText, statusText, isStarted, isOnGoing, isCompleted, isResultPublished);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quiz)) {
            return false;
        }
        Quiz quiz = (Quiz) other;
        return Intrinsics.areEqual(this.id, quiz.id) && Intrinsics.areEqual(this.name, quiz.name) && Intrinsics.areEqual(this.description, quiz.description) && Intrinsics.areEqual(this.startTime, quiz.startTime) && Intrinsics.areEqual(this.endTime, quiz.endTime) && Intrinsics.areEqual(this.maxMark, quiz.maxMark) && Intrinsics.areEqual(this.type, quiz.type) && Intrinsics.areEqual(this.typeText, quiz.typeText) && Intrinsics.areEqual(this.statusText, quiz.statusText) && this.isStarted == quiz.isStarted && this.isOnGoing == quiz.isOnGoing && this.isCompleted == quiz.isCompleted && this.isResultPublished == quiz.isResultPublished;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.maxMark.hashCode()) * 31) + this.type.hashCode()) * 31) + this.typeText.hashCode()) * 31) + this.statusText.hashCode()) * 31;
        boolean z = this.isStarted;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isOnGoing;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        boolean z3 = this.isCompleted;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int i3 = (i2 + r13) * 31;
        boolean z4 = this.isResultPublished;
        return i3 + (z4 ? 1 : z4);
    }

    public String toString() {
        return "Quiz(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", maxMark=" + this.maxMark + ", type=" + this.type + ", typeText=" + this.typeText + ", statusText=" + this.statusText + ", isStarted=" + this.isStarted + ", isOnGoing=" + this.isOnGoing + ", isCompleted=" + this.isCompleted + ", isResultPublished=" + this.isResultPublished + ")";
    }

    public Quiz(String id, String name, String description, String startTime, String endTime, String maxMark, String type, String typeText, String statusText, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeText, "typeText");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        this.id = id;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxMark = maxMark;
        this.type = type;
        this.typeText = typeText;
        this.statusText = statusText;
        this.isStarted = z;
        this.isOnGoing = z2;
        this.isCompleted = z3;
        this.isResultPublished = z4;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getMaxMark() {
        return this.maxMark;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTypeText() {
        return this.typeText;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final boolean isStarted() {
        return this.isStarted;
    }

    public final boolean isOnGoing() {
        return this.isOnGoing;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final boolean isResultPublished() {
        return this.isResultPublished;
    }
}