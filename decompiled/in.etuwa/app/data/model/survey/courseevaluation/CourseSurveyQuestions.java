package in.etuwa.app.data.model.survey.courseevaluation;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CourseSurveyQuestions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CourseSurveyQuestions {
    private String answer_id;
    private final ArrayList<CourseSurveyOptions> options;
    private final String q_id;
    private final String question;
    private final boolean required;
    private final int slno;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CourseSurveyQuestions copy$default(CourseSurveyQuestions courseSurveyQuestions, int i, String str, String str2, boolean z, String str3, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = courseSurveyQuestions.slno;
        }
        if ((i2 & 2) != 0) {
            str = courseSurveyQuestions.q_id;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = courseSurveyQuestions.question;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            z = courseSurveyQuestions.required;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str3 = courseSurveyQuestions.answer_id;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            arrayList = courseSurveyQuestions.options;
        }
        return courseSurveyQuestions.copy(i, str4, str5, z2, str6, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQ_id() {
        return this.q_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnswer_id() {
        return this.answer_id;
    }

    public final ArrayList<CourseSurveyOptions> component6() {
        return this.options;
    }

    public final CourseSurveyQuestions copy(int slno, String q_id, String question, boolean required, String answer_id, ArrayList<CourseSurveyOptions> options) {
        Intrinsics.checkNotNullParameter(q_id, "q_id");
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer_id, "answer_id");
        Intrinsics.checkNotNullParameter(options, "options");
        return new CourseSurveyQuestions(slno, q_id, question, required, answer_id, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseSurveyQuestions)) {
            return false;
        }
        CourseSurveyQuestions courseSurveyQuestions = (CourseSurveyQuestions) other;
        return this.slno == courseSurveyQuestions.slno && Intrinsics.areEqual(this.q_id, courseSurveyQuestions.q_id) && Intrinsics.areEqual(this.question, courseSurveyQuestions.question) && this.required == courseSurveyQuestions.required && Intrinsics.areEqual(this.answer_id, courseSurveyQuestions.answer_id) && Intrinsics.areEqual(this.options, courseSurveyQuestions.options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.slno * 31) + this.q_id.hashCode()) * 31) + this.question.hashCode()) * 31;
        boolean z = this.required;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.answer_id.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "CourseSurveyQuestions(slno=" + this.slno + ", q_id=" + this.q_id + ", question=" + this.question + ", required=" + this.required + ", answer_id=" + this.answer_id + ", options=" + this.options + ")";
    }

    public CourseSurveyQuestions(int i, String q_id, String question, boolean z, String answer_id, ArrayList<CourseSurveyOptions> options) {
        Intrinsics.checkNotNullParameter(q_id, "q_id");
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer_id, "answer_id");
        Intrinsics.checkNotNullParameter(options, "options");
        this.slno = i;
        this.q_id = q_id;
        this.question = question;
        this.required = z;
        this.answer_id = answer_id;
        this.options = options;
    }

    public final int getSlno() {
        return this.slno;
    }

    public final String getQ_id() {
        return this.q_id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getAnswer_id() {
        return this.answer_id;
    }

    public final void setAnswer_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.answer_id = str;
    }

    public final ArrayList<CourseSurveyOptions> getOptions() {
        return this.options;
    }
}