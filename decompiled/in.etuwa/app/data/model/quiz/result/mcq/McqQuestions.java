package in.etuwa.app.data.model.quiz.result.mcq;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: McqQuestions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class McqQuestions implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("correct_option_id")
    private final String correctOptionId;

    @SerializedName("is_answer_correct")
    private final boolean isAnswerCorrect;

    @SerializedName("is_attended")
    private final boolean isAttended;

    @SerializedName("mark_obtained")
    private final String markObtained;

    @SerializedName("question_content")
    private final String questionContent;

    @SerializedName("question_no")
    private final String questionNo;

    @SerializedName("question_options")
    private final ArrayList<McqOptions> questionOptions;

    @SerializedName("user_opted_option_id")
    private final String userOptedOptionId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuestionNo() {
        return this.questionNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAttended() {
        return this.isAttended;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAnswerCorrect() {
        return this.isAnswerCorrect;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMarkObtained() {
        return this.markObtained;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getQuestionContent() {
        return this.questionContent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCorrectOptionId() {
        return this.correctOptionId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUserOptedOptionId() {
        return this.userOptedOptionId;
    }

    public final ArrayList<McqOptions> component8() {
        return this.questionOptions;
    }

    public final McqQuestions copy(String questionNo, boolean isAttended, boolean isAnswerCorrect, String markObtained, String questionContent, String correctOptionId, String userOptedOptionId, ArrayList<McqOptions> questionOptions) {
        Intrinsics.checkNotNullParameter(questionOptions, "questionOptions");
        return new McqQuestions(questionNo, isAttended, isAnswerCorrect, markObtained, questionContent, correctOptionId, userOptedOptionId, questionOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McqQuestions)) {
            return false;
        }
        McqQuestions mcqQuestions = (McqQuestions) other;
        return Intrinsics.areEqual(this.questionNo, mcqQuestions.questionNo) && this.isAttended == mcqQuestions.isAttended && this.isAnswerCorrect == mcqQuestions.isAnswerCorrect && Intrinsics.areEqual(this.markObtained, mcqQuestions.markObtained) && Intrinsics.areEqual(this.questionContent, mcqQuestions.questionContent) && Intrinsics.areEqual(this.correctOptionId, mcqQuestions.correctOptionId) && Intrinsics.areEqual(this.userOptedOptionId, mcqQuestions.userOptedOptionId) && Intrinsics.areEqual(this.questionOptions, mcqQuestions.questionOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.questionNo;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isAttended;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z2 = this.isAnswerCorrect;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        String str2 = this.markObtained;
        int iHashCode2 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.questionContent;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.correctOptionId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userOptedOptionId;
        return ((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.questionOptions.hashCode();
    }

    public String toString() {
        return "McqQuestions(questionNo=" + this.questionNo + ", isAttended=" + this.isAttended + ", isAnswerCorrect=" + this.isAnswerCorrect + ", markObtained=" + this.markObtained + ", questionContent=" + this.questionContent + ", correctOptionId=" + this.correctOptionId + ", userOptedOptionId=" + this.userOptedOptionId + ", questionOptions=" + this.questionOptions + ")";
    }

    public McqQuestions(String str, boolean z, boolean z2, String str2, String str3, String str4, String str5, ArrayList<McqOptions> questionOptions) {
        Intrinsics.checkNotNullParameter(questionOptions, "questionOptions");
        this.questionNo = str;
        this.isAttended = z;
        this.isAnswerCorrect = z2;
        this.markObtained = str2;
        this.questionContent = str3;
        this.correctOptionId = str4;
        this.userOptedOptionId = str5;
        this.questionOptions = questionOptions;
    }

    public final String getQuestionNo() {
        return this.questionNo;
    }

    public final boolean isAttended() {
        return this.isAttended;
    }

    public final boolean isAnswerCorrect() {
        return this.isAnswerCorrect;
    }

    public final String getMarkObtained() {
        return this.markObtained;
    }

    public final String getQuestionContent() {
        return this.questionContent;
    }

    public final String getCorrectOptionId() {
        return this.correctOptionId;
    }

    public final String getUserOptedOptionId() {
        return this.userOptedOptionId;
    }

    public final ArrayList<McqOptions> getQuestionOptions() {
        return this.questionOptions;
    }

    public McqQuestions(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        boolean z = parcel.readByte() != 0;
        boolean z2 = parcel.readByte() != 0;
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, McqOptions.class.getClassLoader());
        Unit unit = Unit.INSTANCE;
        this(string, z, z2, string2, string3, string4, string5, arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.questionNo);
        parcel.writeByte(this.isAttended ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAnswerCorrect ? (byte) 1 : (byte) 0);
        parcel.writeString(this.markObtained);
        parcel.writeString(this.questionContent);
        parcel.writeString(this.correctOptionId);
        parcel.writeString(this.userOptedOptionId);
        parcel.writeList(this.questionOptions);
    }

    /* JADX INFO: renamed from: in.etuwa.app.data.model.quiz.result.mcq.McqQuestions$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: McqQuestions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<McqQuestions> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public McqQuestions createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new McqQuestions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public McqQuestions[] newArray(int size) {
            return new McqQuestions[size];
        }
    }
}