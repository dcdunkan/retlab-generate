package in.etuwa.app.data.model.quiz.result.mcq;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: McqQuestions.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B_\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011HÆ\u0003Js\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011HÆ\u0001J\b\u0010%\u001a\u00020&H\u0016J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020&HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020&H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u00060"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "questionNo", "", "isAttended", "", "isAnswerCorrect", "markObtained", "questionContent", "correctOptionId", "userOptedOptionId", "questionOptions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/result/mcq/McqOptions;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCorrectOptionId", "()Ljava/lang/String;", "()Z", "getMarkObtained", "getQuestionContent", "getQuestionNo", "getQuestionOptions", "()Ljava/util/ArrayList;", "getUserOptedOptionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", XfdfConstants.FLAGS, "CREATOR", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class McqQuestions implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
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

    /* renamed from: component1, reason: from getter */
    public final String getQuestionNo() {
        return this.questionNo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsAttended() {
        return this.isAttended;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsAnswerCorrect() {
        return this.isAnswerCorrect;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMarkObtained() {
        return this.markObtained;
    }

    /* renamed from: component5, reason: from getter */
    public final String getQuestionContent() {
        return this.questionContent;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCorrectOptionId() {
        return this.correctOptionId;
    }

    /* renamed from: component7, reason: from getter */
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
    public int hashCode() {
        String str = this.questionNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isAttended;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.isAnswerCorrect;
        int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        String str2 = this.markObtained;
        int hashCode2 = (i3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.questionContent;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.correctOptionId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userOptedOptionId;
        return ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.questionOptions.hashCode();
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public McqQuestions(android.os.Parcel r11) {
        /*
            r10 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r2 = r11.readString()
            byte r0 = r11.readByte()
            r1 = 1
            r3 = 0
            if (r0 == 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            byte r4 = r11.readByte()
            if (r4 == 0) goto L1c
            r4 = 1
            goto L1d
        L1c:
            r4 = 0
        L1d:
            java.lang.String r5 = r11.readString()
            java.lang.String r6 = r11.readString()
            java.lang.String r7 = r11.readString()
            java.lang.String r8 = r11.readString()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r1 = r9
            java.util.List r1 = (java.util.List) r1
            java.lang.Class<in.etuwa.app.data.model.quiz.result.mcq.McqOptions> r3 = in.etuwa.app.data.model.quiz.result.mcq.McqOptions.class
            java.lang.ClassLoader r3 = r3.getClassLoader()
            r11.readList(r1, r3)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r1 = r10
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.data.model.quiz.result.mcq.McqQuestions.<init>(android.os.Parcel):void");
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

    /* compiled from: McqQuestions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.quiz.result.mcq.McqQuestions$CREATOR, reason: from kotlin metadata */
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