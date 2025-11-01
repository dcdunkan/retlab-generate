package in.etuwa.app.data.model.quiz;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuestionsNew.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0017¨\u00064"}, d2 = {"Lin/etuwa/app/data/model/quiz/QuestionsNew;", "", "questionType", "", "qno", "sessionId", "question", "answerId", TypedValues.TransitionType.S_DURATION, "isAttended", "", "userAnswer", "fileUrl", "fileId", "options", "", "Lin/etuwa/app/data/model/quiz/OptionsNew;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAnswerId", "()Ljava/lang/String;", "getDuration", "getFileId", "setFileId", "(Ljava/lang/String;)V", "getFileUrl", "setFileUrl", "()Z", "getOptions", "()Ljava/util/List;", "getQno", "getQuestion", "getQuestionType", "getSessionId", "getUserAnswer", "setUserAnswer", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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