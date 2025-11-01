package in.etuwa.app.data.model.quiz.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Quiz.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\rHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rHÆ\u0001J\u0013\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00060"}, d2 = {"Lin/etuwa/app/data/model/quiz/list/Quiz;", "", "id", "", "name", PdfConst.Description, "startTime", "endTime", "maxMark", "type", "typeText", "statusText", "isStarted", "", "isOnGoing", "isCompleted", "isResultPublished", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getDescription", "()Ljava/lang/String;", "getEndTime", "getId", "()Z", "getMaxMark", "getName", "getStartTime", "getStatusText", "getType", "getTypeText", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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