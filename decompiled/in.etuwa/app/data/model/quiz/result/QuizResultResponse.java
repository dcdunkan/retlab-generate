package in.etuwa.app.data.model.quiz.result;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.quiz.result.descriptive.DescriptiveQuestions;
import in.etuwa.app.data.model.quiz.result.filetype.FileTypeQuestions;
import in.etuwa.app.data.model.quiz.result.mcq.McqQuestions;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizResultResponse.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\f¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\fHÆ\u0003J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\fHÆ\u0003J\u0089\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\fHÆ\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001a¨\u0006+"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/QuizResultResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "hasResultPublished", "hasStudentAttended", "marksScored", "", "questionSetName", "multipleChoiceQuestions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/result/mcq/McqQuestions;", "Lkotlin/collections/ArrayList;", "descriptiveQuestions", "Lin/etuwa/app/data/model/quiz/result/descriptive/DescriptiveQuestions;", "fileUploadQuestions", "Lin/etuwa/app/data/model/quiz/result/filetype/FileTypeQuestions;", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getDescriptiveQuestions", "()Ljava/util/ArrayList;", "getFileUploadQuestions", "getHasResultPublished", "()Z", "getHasStudentAttended", "getLogin", "getMarksScored", "()Ljava/lang/String;", "getMultipleChoiceQuestions", "getQuestionSetName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class QuizResultResponse {

    @SerializedName("descriptive_questions")
    private final ArrayList<DescriptiveQuestions> descriptiveQuestions;

    @SerializedName("file_upload_questions")
    private final ArrayList<FileTypeQuestions> fileUploadQuestions;

    @SerializedName("has_result_published")
    private final boolean hasResultPublished;

    @SerializedName("has_student_attended")
    private final boolean hasStudentAttended;
    private final boolean login;

    @SerializedName("marks_scored")
    private final String marksScored;

    @SerializedName("multiple_choice_questions")
    private final ArrayList<McqQuestions> multipleChoiceQuestions;

    @SerializedName("question_set_name")
    private final String questionSetName;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasResultPublished() {
        return this.hasResultPublished;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasStudentAttended() {
        return this.hasStudentAttended;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMarksScored() {
        return this.marksScored;
    }

    /* renamed from: component5, reason: from getter */
    public final String getQuestionSetName() {
        return this.questionSetName;
    }

    public final ArrayList<McqQuestions> component6() {
        return this.multipleChoiceQuestions;
    }

    public final ArrayList<DescriptiveQuestions> component7() {
        return this.descriptiveQuestions;
    }

    public final ArrayList<FileTypeQuestions> component8() {
        return this.fileUploadQuestions;
    }

    public final QuizResultResponse copy(boolean login, boolean hasResultPublished, boolean hasStudentAttended, String marksScored, String questionSetName, ArrayList<McqQuestions> multipleChoiceQuestions, ArrayList<DescriptiveQuestions> descriptiveQuestions, ArrayList<FileTypeQuestions> fileUploadQuestions) {
        Intrinsics.checkNotNullParameter(marksScored, "marksScored");
        Intrinsics.checkNotNullParameter(questionSetName, "questionSetName");
        Intrinsics.checkNotNullParameter(multipleChoiceQuestions, "multipleChoiceQuestions");
        Intrinsics.checkNotNullParameter(descriptiveQuestions, "descriptiveQuestions");
        Intrinsics.checkNotNullParameter(fileUploadQuestions, "fileUploadQuestions");
        return new QuizResultResponse(login, hasResultPublished, hasStudentAttended, marksScored, questionSetName, multipleChoiceQuestions, descriptiveQuestions, fileUploadQuestions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizResultResponse)) {
            return false;
        }
        QuizResultResponse quizResultResponse = (QuizResultResponse) other;
        return this.login == quizResultResponse.login && this.hasResultPublished == quizResultResponse.hasResultPublished && this.hasStudentAttended == quizResultResponse.hasStudentAttended && Intrinsics.areEqual(this.marksScored, quizResultResponse.marksScored) && Intrinsics.areEqual(this.questionSetName, quizResultResponse.questionSetName) && Intrinsics.areEqual(this.multipleChoiceQuestions, quizResultResponse.multipleChoiceQuestions) && Intrinsics.areEqual(this.descriptiveQuestions, quizResultResponse.descriptiveQuestions) && Intrinsics.areEqual(this.fileUploadQuestions, quizResultResponse.fileUploadQuestions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.hasResultPublished;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.hasStudentAttended;
        return ((((((((((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.marksScored.hashCode()) * 31) + this.questionSetName.hashCode()) * 31) + this.multipleChoiceQuestions.hashCode()) * 31) + this.descriptiveQuestions.hashCode()) * 31) + this.fileUploadQuestions.hashCode();
    }

    public String toString() {
        return "QuizResultResponse(login=" + this.login + ", hasResultPublished=" + this.hasResultPublished + ", hasStudentAttended=" + this.hasStudentAttended + ", marksScored=" + this.marksScored + ", questionSetName=" + this.questionSetName + ", multipleChoiceQuestions=" + this.multipleChoiceQuestions + ", descriptiveQuestions=" + this.descriptiveQuestions + ", fileUploadQuestions=" + this.fileUploadQuestions + ")";
    }

    public QuizResultResponse(boolean z, boolean z2, boolean z3, String marksScored, String questionSetName, ArrayList<McqQuestions> multipleChoiceQuestions, ArrayList<DescriptiveQuestions> descriptiveQuestions, ArrayList<FileTypeQuestions> fileUploadQuestions) {
        Intrinsics.checkNotNullParameter(marksScored, "marksScored");
        Intrinsics.checkNotNullParameter(questionSetName, "questionSetName");
        Intrinsics.checkNotNullParameter(multipleChoiceQuestions, "multipleChoiceQuestions");
        Intrinsics.checkNotNullParameter(descriptiveQuestions, "descriptiveQuestions");
        Intrinsics.checkNotNullParameter(fileUploadQuestions, "fileUploadQuestions");
        this.login = z;
        this.hasResultPublished = z2;
        this.hasStudentAttended = z3;
        this.marksScored = marksScored;
        this.questionSetName = questionSetName;
        this.multipleChoiceQuestions = multipleChoiceQuestions;
        this.descriptiveQuestions = descriptiveQuestions;
        this.fileUploadQuestions = fileUploadQuestions;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getHasResultPublished() {
        return this.hasResultPublished;
    }

    public final boolean getHasStudentAttended() {
        return this.hasStudentAttended;
    }

    public final String getMarksScored() {
        return this.marksScored;
    }

    public final String getQuestionSetName() {
        return this.questionSetName;
    }

    public final ArrayList<McqQuestions> getMultipleChoiceQuestions() {
        return this.multipleChoiceQuestions;
    }

    public final ArrayList<DescriptiveQuestions> getDescriptiveQuestions() {
        return this.descriptiveQuestions;
    }

    public final ArrayList<FileTypeQuestions> getFileUploadQuestions() {
        return this.fileUploadQuestions;
    }
}