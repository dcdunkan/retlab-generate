package in.etuwa.app.data.model.quiz.result;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.quiz.result.descriptive.DescriptiveQuestions;
import in.etuwa.app.data.model.quiz.result.filetype.FileTypeQuestions;
import in.etuwa.app.data.model.quiz.result.mcq.McqQuestions;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizResultResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasResultPublished() {
        return this.hasResultPublished;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasStudentAttended() {
        return this.hasStudentAttended;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMarksScored() {
        return this.marksScored;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.hasResultPublished;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.hasStudentAttended;
        return ((((((((((i2 + (z3 ? 1 : z3)) * 31) + this.marksScored.hashCode()) * 31) + this.questionSetName.hashCode()) * 31) + this.multipleChoiceQuestions.hashCode()) * 31) + this.descriptiveQuestions.hashCode()) * 31) + this.fileUploadQuestions.hashCode();
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