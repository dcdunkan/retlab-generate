package in.etuwa.app.data.model.quiz.questions;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Questions.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bu\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008f\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001J\b\u00102\u001a\u000203H\u0016J\u0013\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000203HÖ\u0001J\t\u00108\u001a\u00020\u0006HÖ\u0001J\u0018\u00109\u001a\u00020:2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u000203H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R \u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R \u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u001a¨\u0006="}, d2 = {"Lin/etuwa/app/data/model/quiz/questions/Questions;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "questionType", "", "qno", "sessionId", "question", "answerId", TypedValues.TransitionType.S_DURATION, "isAttended", "", "userAnswer", "fileUrl", "fileId", "options", "", "Lin/etuwa/app/data/model/quiz/questions/Options;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAnswerId", "()Ljava/lang/String;", "getDuration", "getFileId", "setFileId", "(Ljava/lang/String;)V", "getFileUrl", "setFileUrl", "()Z", "getOptions", "()Ljava/util/List;", "getQno", "getQuestion", "getQuestionType", "getSessionId", "getUserAnswer", "setUserAnswer", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", XfdfConstants.FLAGS, "CREATOR", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Questions implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
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

    /* renamed from: component1, reason: from getter */
    public final String getQuestionType() {
        return this.questionType;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    public final List<Options> component11() {
        return this.options;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQno() {
        return this.qno;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAnswerId() {
        return this.answerId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsAttended() {
        return this.isAttended;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUserAnswer() {
        return this.userAnswer;
    }

    /* renamed from: component9, reason: from getter */
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
    public int hashCode() {
        String str = this.questionType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.qno;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.question;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.answerId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.duration;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z = this.isAttended;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode6 + i) * 31;
        String str7 = this.userAnswer;
        int hashCode7 = (i2 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.fileUrl;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.fileId;
        return ((hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.options.hashCode();
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Questions(android.os.Parcel r14) {
        /*
            r13 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r2 = r14.readString()
            java.lang.String r3 = r14.readString()
            java.lang.String r4 = r14.readString()
            java.lang.String r5 = r14.readString()
            java.lang.String r6 = r14.readString()
            java.lang.String r7 = r14.readString()
            byte r0 = r14.readByte()
            if (r0 == 0) goto L26
            r0 = 1
            r8 = 1
            goto L28
        L26:
            r0 = 0
            r8 = 0
        L28:
            java.lang.String r9 = r14.readString()
            java.lang.String r10 = r14.readString()
            java.lang.String r11 = r14.readString()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r12 = r0
            java.util.List r12 = (java.util.List) r12
            java.lang.Class<in.etuwa.app.data.model.quiz.questions.Options> r0 = in.etuwa.app.data.model.quiz.questions.Options.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            r14.readList(r12, r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.data.model.quiz.questions.Questions.<init>(android.os.Parcel):void");
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

    /* compiled from: Questions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/questions/Questions$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/questions/Questions;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/questions/Questions;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.quiz.questions.Questions$CREATOR, reason: from kotlin metadata */
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