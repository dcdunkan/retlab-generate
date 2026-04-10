package in.etuwa.app.data.model.quiz.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Quiz.kt */
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsStarted() {
        return this.isStarted;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsOnGoing() {
        return this.isOnGoing;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsResultPublished() {
        return this.isResultPublished;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTypeText() {
        return this.typeText;
    }

    /* renamed from: component9, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.maxMark.hashCode()) * 31) + this.type.hashCode()) * 31) + this.typeText.hashCode()) * 31) + this.statusText.hashCode()) * 31;
        boolean z = this.isStarted;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.isOnGoing;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.isCompleted;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.isResultPublished;
        return i6 + (z4 ? 1 : z4 ? 1 : 0);
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