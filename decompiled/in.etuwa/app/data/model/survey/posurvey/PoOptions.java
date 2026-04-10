package in.etuwa.app.data.model.survey.posurvey;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PoOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class PoOptions {
    private final String option_id;
    private final String option_name;

    public static /* synthetic */ PoOptions copy$default(PoOptions poOptions, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = poOptions.option_id;
        }
        if ((i & 2) != 0) {
            str2 = poOptions.option_name;
        }
        return poOptions.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOption_id() {
        return this.option_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOption_name() {
        return this.option_name;
    }

    public final PoOptions copy(String option_id, String option_name) {
        Intrinsics.checkNotNullParameter(option_id, "option_id");
        Intrinsics.checkNotNullParameter(option_name, "option_name");
        return new PoOptions(option_id, option_name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoOptions)) {
            return false;
        }
        PoOptions poOptions = (PoOptions) other;
        return Intrinsics.areEqual(this.option_id, poOptions.option_id) && Intrinsics.areEqual(this.option_name, poOptions.option_name);
    }

    public int hashCode() {
        return (this.option_id.hashCode() * 31) + this.option_name.hashCode();
    }

    public String toString() {
        return "PoOptions(option_id=" + this.option_id + ", option_name=" + this.option_name + ")";
    }

    public PoOptions(String option_id, String option_name) {
        Intrinsics.checkNotNullParameter(option_id, "option_id");
        Intrinsics.checkNotNullParameter(option_name, "option_name");
        this.option_id = option_id;
        this.option_name = option_name;
    }

    public final String getOption_id() {
        return this.option_id;
    }

    public final String getOption_name() {
        return this.option_name;
    }
}