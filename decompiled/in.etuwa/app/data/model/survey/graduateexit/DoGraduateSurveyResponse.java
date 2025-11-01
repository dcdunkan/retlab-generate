package in.etuwa.app.data.model.survey.graduateexit;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoGraduateSurveyResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyResponse;", "", "gequestions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyQuestions;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getGequestions", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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