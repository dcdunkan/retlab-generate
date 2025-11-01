package in.etuwa.app.data.model.quiz.result.descriptive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DescriptiveQuestions.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001aH\u0016R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006$"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/descriptive/DescriptiveQuestions;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "questionNo", "", "isAttended", "", "markObtained", "questionContent", "studentAnswer", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getMarkObtained", "()Ljava/lang/String;", "getQuestionContent", "getQuestionNo", "getStudentAnswer", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", XfdfConstants.FLAGS, "CREATOR", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DescriptiveQuestions implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("is_attended")
    private final boolean isAttended;

    @SerializedName("mark_obtained")
    private final String markObtained;

    @SerializedName("question_content")
    private final String questionContent;

    @SerializedName("question_no")
    private final String questionNo;

    @SerializedName("student_answer")
    private final String studentAnswer;

    public static /* synthetic */ DescriptiveQuestions copy$default(DescriptiveQuestions descriptiveQuestions, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = descriptiveQuestions.questionNo;
        }
        if ((i & 2) != 0) {
            z = descriptiveQuestions.isAttended;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = descriptiveQuestions.markObtained;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = descriptiveQuestions.questionContent;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = descriptiveQuestions.studentAnswer;
        }
        return descriptiveQuestions.copy(str, z2, str5, str6, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestionNo() {
        return this.questionNo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsAttended() {
        return this.isAttended;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMarkObtained() {
        return this.markObtained;
    }

    /* renamed from: component4, reason: from getter */
    public final String getQuestionContent() {
        return this.questionContent;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStudentAnswer() {
        return this.studentAnswer;
    }

    public final DescriptiveQuestions copy(String questionNo, boolean isAttended, String markObtained, String questionContent, String studentAnswer) {
        return new DescriptiveQuestions(questionNo, isAttended, markObtained, questionContent, studentAnswer);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DescriptiveQuestions)) {
            return false;
        }
        DescriptiveQuestions descriptiveQuestions = (DescriptiveQuestions) other;
        return Intrinsics.areEqual(this.questionNo, descriptiveQuestions.questionNo) && this.isAttended == descriptiveQuestions.isAttended && Intrinsics.areEqual(this.markObtained, descriptiveQuestions.markObtained) && Intrinsics.areEqual(this.questionContent, descriptiveQuestions.questionContent) && Intrinsics.areEqual(this.studentAnswer, descriptiveQuestions.studentAnswer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.questionNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isAttended;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str2 = this.markObtained;
        int hashCode2 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.questionContent;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.studentAnswer;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DescriptiveQuestions(questionNo=" + this.questionNo + ", isAttended=" + this.isAttended + ", markObtained=" + this.markObtained + ", questionContent=" + this.questionContent + ", studentAnswer=" + this.studentAnswer + ")";
    }

    public DescriptiveQuestions(String str, boolean z, String str2, String str3, String str4) {
        this.questionNo = str;
        this.isAttended = z;
        this.markObtained = str2;
        this.questionContent = str3;
        this.studentAnswer = str4;
    }

    public final String getQuestionNo() {
        return this.questionNo;
    }

    public final boolean isAttended() {
        return this.isAttended;
    }

    public final String getMarkObtained() {
        return this.markObtained;
    }

    public final String getQuestionContent() {
        return this.questionContent;
    }

    public final String getStudentAnswer() {
        return this.studentAnswer;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DescriptiveQuestions(Parcel parcel) {
        this(parcel.readString(), parcel.readByte() != 0, parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.questionNo);
        parcel.writeByte(this.isAttended ? (byte) 1 : (byte) 0);
        parcel.writeString(this.markObtained);
        parcel.writeString(this.questionContent);
        parcel.writeString(this.studentAnswer);
    }

    /* compiled from: DescriptiveQuestions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/descriptive/DescriptiveQuestions$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/result/descriptive/DescriptiveQuestions;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/result/descriptive/DescriptiveQuestions;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.quiz.result.descriptive.DescriptiveQuestions$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<DescriptiveQuestions> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DescriptiveQuestions createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DescriptiveQuestions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DescriptiveQuestions[] newArray(int size) {
            return new DescriptiveQuestions[size];
        }
    }
}