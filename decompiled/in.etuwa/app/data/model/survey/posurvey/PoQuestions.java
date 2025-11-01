package in.etuwa.app.data.model.survey.posurvey;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PoQuestions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lin/etuwa/app/data/model/survey/posurvey/PoQuestions;", "", "q_id", "", "q_name", "answer", CommonCssConstants.REQUIRED, "", "options", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/posurvey/PoOptions;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;)V", "getAnswer", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "getOptions", "()Ljava/util/ArrayList;", "getQ_id", "getQ_name", "getRequired", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PoQuestions {
    private String answer;
    private final ArrayList<PoOptions> options;
    private final String q_id;
    private final String q_name;
    private final boolean required;

    public static /* synthetic */ PoQuestions copy$default(PoQuestions poQuestions, String str, String str2, String str3, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = poQuestions.q_id;
        }
        if ((i & 2) != 0) {
            str2 = poQuestions.q_name;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = poQuestions.answer;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = poQuestions.required;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            arrayList = poQuestions.options;
        }
        return poQuestions.copy(str, str4, str5, z2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQ_id() {
        return this.q_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQ_name() {
        return this.q_name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    public final ArrayList<PoOptions> component5() {
        return this.options;
    }

    public final PoQuestions copy(String q_id, String q_name, String answer, boolean required, ArrayList<PoOptions> options) {
        Intrinsics.checkNotNullParameter(q_id, "q_id");
        Intrinsics.checkNotNullParameter(q_name, "q_name");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PoQuestions(q_id, q_name, answer, required, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoQuestions)) {
            return false;
        }
        PoQuestions poQuestions = (PoQuestions) other;
        return Intrinsics.areEqual(this.q_id, poQuestions.q_id) && Intrinsics.areEqual(this.q_name, poQuestions.q_name) && Intrinsics.areEqual(this.answer, poQuestions.answer) && this.required == poQuestions.required && Intrinsics.areEqual(this.options, poQuestions.options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.q_id.hashCode() * 31) + this.q_name.hashCode()) * 31) + this.answer.hashCode()) * 31;
        boolean z = this.required;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "PoQuestions(q_id=" + this.q_id + ", q_name=" + this.q_name + ", answer=" + this.answer + ", required=" + this.required + ", options=" + this.options + ")";
    }

    public PoQuestions(String q_id, String q_name, String answer, boolean z, ArrayList<PoOptions> options) {
        Intrinsics.checkNotNullParameter(q_id, "q_id");
        Intrinsics.checkNotNullParameter(q_name, "q_name");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(options, "options");
        this.q_id = q_id;
        this.q_name = q_name;
        this.answer = answer;
        this.required = z;
        this.options = options;
    }

    public final String getQ_id() {
        return this.q_id;
    }

    public final String getQ_name() {
        return this.q_name;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final void setAnswer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.answer = str;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final ArrayList<PoOptions> getOptions() {
        return this.options;
    }
}