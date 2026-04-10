package in.etuwa.app.data.model.quiz.questions;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Questions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Questions implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("answer_id")
    @Expose
    private final String answerId;

    @SerializedName("duration_in_seconds")
    @Expose
    private final String duration;

    @SerializedName("id")
    @Expose
    private String fileId;

    @SerializedName("file")
    @Expose
    private String fileUrl;

    @SerializedName("is_attended")
    @Expose
    private final boolean isAttended;
    private final List<Options> options;
    private final String qno;

    @SerializedName("question_text")
    @Expose
    private final String question;

    @SerializedName("question_type")
    @Expose
    private final String questionType;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("user_answer")
    @Expose
    private String userAnswer;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuestionType() {
        return this.questionType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    public final List<Options> component11() {
        return this.options;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQno() {
        return this.qno;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnswerId() {
        return this.answerId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsAttended() {
        return this.isAttended;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUserAnswer() {
        return this.userAnswer;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final Questions copy(String questionType, String qno, String sessionId, String question, String answerId, String duration, boolean isAttended, String userAnswer, String fileUrl, String fileId, List<Options> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return new Questions(questionType, qno, sessionId, question, answerId, duration, isAttended, userAnswer, fileUrl, fileId, options);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Questions)) {
            return false;
        }
        Questions questions = (Questions) other;
        return Intrinsics.areEqual(this.questionType, questions.questionType) && Intrinsics.areEqual(this.qno, questions.qno) && Intrinsics.areEqual(this.sessionId, questions.sessionId) && Intrinsics.areEqual(this.question, questions.question) && Intrinsics.areEqual(this.answerId, questions.answerId) && Intrinsics.areEqual(this.duration, questions.duration) && this.isAttended == questions.isAttended && Intrinsics.areEqual(this.userAnswer, questions.userAnswer) && Intrinsics.areEqual(this.fileUrl, questions.fileUrl) && Intrinsics.areEqual(this.fileId, questions.fileId) && Intrinsics.areEqual(this.options, questions.options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v32 */
    public int hashCode() {
        String str = this.questionType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.qno;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.question;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.answerId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.duration;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z = this.isAttended;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode6 + r2) * 31;
        String str7 = this.userAnswer;
        int iHashCode7 = (i + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.fileUrl;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.fileId;
        return ((iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "Questions(questionType=" + this.questionType + ", qno=" + this.qno + ", sessionId=" + this.sessionId + ", question=" + this.question + ", answerId=" + this.answerId + ", duration=" + this.duration + ", isAttended=" + this.isAttended + ", userAnswer=" + this.userAnswer + ", fileUrl=" + this.fileUrl + ", fileId=" + this.fileId + ", options=" + this.options + ")";
    }

    public Questions(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, List<Options> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.questionType = str;
        this.qno = str2;
        this.sessionId = str3;
        this.question = str4;
        this.answerId = str5;
        this.duration = str6;
        this.isAttended = z;
        this.userAnswer = str7;
        this.fileUrl = str8;
        this.fileId = str9;
        this.options = options;
    }

    public final String getQuestionType() {
        return this.questionType;
    }

    public final String getQno() {
        return this.qno;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getAnswerId() {
        return this.answerId;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final boolean isAttended() {
        return this.isAttended;
    }

    public final String getUserAnswer() {
        return this.userAnswer;
    }

    public final void setUserAnswer(String str) {
        this.userAnswer = str;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final void setFileId(String str) {
        this.fileId = str;
    }

    public final List<Options> getOptions() {
        return this.options;
    }

    public Questions(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        boolean z = parcel.readByte() != 0;
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Options.class.getClassLoader());
        Unit unit = Unit.INSTANCE;
        this(string, string2, string3, string4, string5, string6, z, string7, string8, string9, arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.questionType);
        parcel.writeString(this.qno);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.question);
        parcel.writeString(this.answerId);
        parcel.writeString(this.duration);
        parcel.writeByte(this.isAttended ? (byte) 1 : (byte) 0);
        parcel.writeString(this.userAnswer);
        parcel.writeString(this.fileUrl);
        parcel.writeString(this.fileId);
        parcel.writeList(this.options);
    }

    /* JADX INFO: renamed from: in.etuwa.app.data.model.quiz.questions.Questions$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Questions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/questions/Questions$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/questions/Questions;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/questions/Questions;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<Questions> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Questions createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Questions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    }
}