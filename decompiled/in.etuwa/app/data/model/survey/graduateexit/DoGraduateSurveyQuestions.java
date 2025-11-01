package in.etuwa.app.data.model.survey.graduateexit;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoGraduateSurveyQuestions.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0002\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyQuestions;", "", "q_id", "", "question", "type", CommonCssConstants.REQUIRED, "", "answer_id", "option_id", "section", "options", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/graduateexit/GEOptions;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAnswer_id", "()Ljava/lang/String;", "setAnswer_id", "(Ljava/lang/String;)V", "getOption_id", "setOption_id", "getOptions", "()Ljava/util/ArrayList;", "getQ_id", "getQuestion", "getRequired", "()Z", "getSection", "getType", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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