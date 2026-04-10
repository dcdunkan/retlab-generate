package in.etuwa.app.data.model.survey.graduateexit;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DoGraduateSurveyQuestions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DoGraduateSurveyQuestions {
    private String answer_id;
    private String option_id;
    private final ArrayList<GEOptions> options;
    private final String q_id;
    private final String question;
    private final boolean required;
    private final String section;
    private final String type;

    public DoGraduateSurveyQuestions(String q_id, String question, String type, boolean z, String answer_id, String option_id, String section, ArrayList<GEOptions> options) {
        Intrinsics.checkNotNullParameter(q_id, "q_id");
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(answer_id, "answer_id");
        Intrinsics.checkNotNullParameter(option_id, "option_id");
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(options, "options");
        this.q_id = q_id;
        this.question = question;
        this.type = type;
        this.required = z;
        this.answer_id = answer_id;
        this.option_id = option_id;
        this.section = section;
        this.options = options;
    }

    public final String getQ_id() {
        return this.q_id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getType() {
        return this.type;
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

    public final String getOption_id() {
        return this.option_id;
    }

    public final void setOption_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.option_id = str;
    }

    public final String getSection() {
        return this.section;
    }

    public final ArrayList<GEOptions> getOptions() {
        return this.options;
    }
}