package in.etuwa.app.data.model.survey.graduateexit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GEOptions.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/survey/graduateexit/GEOptions;", "", "option_id", "", "option", "(Ljava/lang/String;Ljava/lang/String;)V", "getOption", "()Ljava/lang/String;", "getOption_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getOption_id() {
        return this.option_id;
    }

    /* renamed from: component2, reason: from getter */
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