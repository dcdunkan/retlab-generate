package in.etuwa.app.data.model.survey.courseevaluation;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CourseSurveyQuestions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyQuestions;", "", "slno", "", "q_id", "", "question", CommonCssConstants.REQUIRED, "", "answer_id", "options", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyOptions;", "Lkotlin/collections/ArrayList;", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/ArrayList;)V", "getAnswer_id", "()Ljava/lang/String;", "setAnswer_id", "(Ljava/lang/String;)V", "getOptions", "()Ljava/util/ArrayList;", "getQ_id", "getQuestion", "getRequired", "()Z", "getSlno", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CourseSurveyQuestions {
    private String answer_id;
    private final ArrayList<CourseSurveyOptions> options;
    private final String q_id;
    private final String question;
    private final boolean required;
    private final int slno;

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

    /* renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQ_id() {
        return this.q_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* renamed from: component5, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((this.slno * 31) + this.q_id.hashCode()) * 31) + this.question.hashCode()) * 31;
        boolean z = this.required;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.answer_id.hashCode()) * 31) + this.options.hashCode();
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