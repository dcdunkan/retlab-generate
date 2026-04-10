package in.etuwa.app.data.model.survey.graduateexit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GEOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class GEOptions {
    private final String option;
    private final String option_id;

    public static /* synthetic */ GEOptions copy$default(GEOptions gEOptions, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gEOptions.option_id;
        }
        if ((i & 2) != 0) {
            str2 = gEOptions.option;
        }
        return gEOptions.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOption_id() {
        return this.option_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    public final GEOptions copy(String option_id, String option) {
        Intrinsics.checkNotNullParameter(option_id, "option_id");
        Intrinsics.checkNotNullParameter(option, "option");
        return new GEOptions(option_id, option);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GEOptions)) {
            return false;
        }
        GEOptions gEOptions = (GEOptions) other;
        return Intrinsics.areEqual(this.option_id, gEOptions.option_id) && Intrinsics.areEqual(this.option, gEOptions.option);
    }

    public int hashCode() {
        return (this.option_id.hashCode() * 31) + this.option.hashCode();
    }

    public String toString() {
        return "GEOptions(option_id=" + this.option_id + ", option=" + this.option + ")";
    }

    public GEOptions(String option_id, String option) {
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