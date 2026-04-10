package in.etuwa.app.data.model.survey.graduateexit;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoGraduateSurveyResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class DoGraduateSurveyResponse {
    private final ArrayList<DoGraduateSurveyQuestions> gequestions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoGraduateSurveyResponse copy$default(DoGraduateSurveyResponse doGraduateSurveyResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = doGraduateSurveyResponse.gequestions;
        }
        return doGraduateSurveyResponse.copy(arrayList);
    }

    public final ArrayList<DoGraduateSurveyQuestions> component1() {
        return this.gequestions;
    }

    public final DoGraduateSurveyResponse copy(ArrayList<DoGraduateSurveyQuestions> gequestions) {
        Intrinsics.checkNotNullParameter(gequestions, "gequestions");
        return new DoGraduateSurveyResponse(gequestions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DoGraduateSurveyResponse) && Intrinsics.areEqual(this.gequestions, ((DoGraduateSurveyResponse) other).gequestions);
    }

    public int hashCode() {
        return this.gequestions.hashCode();
    }

    public String toString() {
        return "DoGraduateSurveyResponse(gequestions=" + this.gequestions + ")";
    }

    public DoGraduateSurveyResponse(ArrayList<DoGraduateSurveyQuestions> gequestions) {
        Intrinsics.checkNotNullParameter(gequestions, "gequestions");
        this.gequestions = gequestions;
    }

    public final ArrayList<DoGraduateSurveyQuestions> getGequestions() {
        return this.gequestions;
    }
}