package in.etuwa.app.data.model.survey.courseevaluation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CourseSurveyOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CourseSurveyOptions {
    private final String option;
    private final String option_id;

    public static /* synthetic */ CourseSurveyOptions copy$default(CourseSurveyOptions courseSurveyOptions, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courseSurveyOptions.option_id;
        }
        if ((i & 2) != 0) {
            str2 = courseSurveyOptions.option;
        }
        return courseSurveyOptions.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOption_id() {
        return this.option_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    public final CourseSurveyOptions copy(String option_id, String option) {
        Intrinsics.checkNotNullParameter(option_id, "option_id");
        Intrinsics.checkNotNullParameter(option, "option");
        return new CourseSurveyOptions(option_id, option);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseSurveyOptions)) {
            return false;
        }
        CourseSurveyOptions courseSurveyOptions = (CourseSurveyOptions) other;
        return Intrinsics.areEqual(this.option_id, courseSurveyOptions.option_id) && Intrinsics.areEqual(this.option, courseSurveyOptions.option);
    }

    public int hashCode() {
        return (this.option_id.hashCode() * 31) + this.option.hashCode();
    }

    public String toString() {
        return "CourseSurveyOptions(option_id=" + this.option_id + ", option=" + this.option + ")";
    }

    public CourseSurveyOptions(String option_id, String option) {
        Intrinsics.checkNotNullParameter(option_id, "option_id");
        Intrinsics.checkNotNullParameter(option, "option");
        this.option_id = option_id;
        this.option = option;
    }

    public final String getOption_id() {
        return this.option_id;
    }

    public final String getOption() {
        return this.option;
    }
}