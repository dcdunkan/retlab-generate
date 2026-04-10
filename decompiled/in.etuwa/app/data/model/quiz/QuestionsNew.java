package in.etuwa.app.data.model.quiz;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuestionsNew.kt */
/* loaded from: classes3.dex */
public final /* data */ class QuestionsNew {

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
    private final List<OptionsNew> options;
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

    public final List<OptionsNew> component11() {
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

    public final QuestionsNew copy(String questionType, String qno, String sessionId, String question, String answerId, String duration, boolean isAttended, String userAnswer, String fileUrl, String fileId, List<OptionsNew> options) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(options, "options");
        return new QuestionsNew(questionType, qno, sessionId, question, answerId, duration, isAttended, userAnswer, fileUrl, fileId, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionsNew)) {
            return false;
        }
        QuestionsNew questionsNew = (QuestionsNew) other;
        return Intrinsics.areEqual(this.questionType, questionsNew.questionType) && Intrinsics.areEqual(this.qno, questionsNew.qno) && Intrinsics.areEqual(this.sessionId, questionsNew.sessionId) && Intrinsics.areEqual(this.question, questionsNew.question) && Intrinsics.areEqual(this.answerId, questionsNew.answerId) && Intrinsics.areEqual(this.duration, questionsNew.duration) && this.isAttended == questionsNew.isAttended && Intrinsics.areEqual(this.userAnswer, questionsNew.userAnswer) && Intrinsics.areEqual(this.fileUrl, questionsNew.fileUrl) && Intrinsics.areEqual(this.fileId, questionsNew.fileId) && Intrinsics.areEqual(this.options, questionsNew.options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.questionType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.qno;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionId;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.question.hashCode()) * 31;
        String str4 = this.answerId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.duration;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z = this.isAttended;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode5 + i) * 31;
        String str6 = this.userAnswer;
        int hashCode6 = (i2 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.fileUrl;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.fileId;
        return ((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "QuestionsNew(questionType=" + this.questionType + ", qno=" + this.qno + ", sessionId=" + this.sessionId + ", question=" + this.question + ", answerId=" + this.answerId + ", duration=" + this.duration + ", isAttended=" + this.isAttended + ", userAnswer=" + this.userAnswer + ", fileUrl=" + this.fileUrl + ", fileId=" + this.fileId + ", options=" + this.options + ")";
    }

    public QuestionsNew(String str, String str2, String str3, String question, String str4, String str5, boolean z, String str6, String str7, String str8, List<OptionsNew> options) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(options, "options");
        this.questionType = str;
        this.qno = str2;
        this.sessionId = str3;
        this.question = question;
        this.answerId = str4;
        this.duration = str5;
        this.isAttended = z;
        this.userAnswer = str6;
        this.fileUrl = str7;
        this.fileId = str8;
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

    public final List<OptionsNew> getOptions() {
        return this.options;
    }
}