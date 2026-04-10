package in.etuwa.app.data.model.quiz;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptionsNew.kt */
/* loaded from: classes3.dex */
public final /* data */ class OptionsNew {
    private final String id;
    private final String option;

    public static /* synthetic */ OptionsNew copy$default(OptionsNew optionsNew, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = optionsNew.id;
        }
        if ((i & 2) != 0) {
            str2 = optionsNew.option;
        }
        return optionsNew.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    public final OptionsNew copy(String id, String option) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(option, "option");
        return new OptionsNew(id, option);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionsNew)) {
            return false;
        }
        OptionsNew optionsNew = (OptionsNew) other;
        return Intrinsics.areEqual(this.id, optionsNew.id) && Intrinsics.areEqual(this.option, optionsNew.option);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.option.hashCode();
    }

    public String toString() {
        return "OptionsNew(id=" + this.id + ", option=" + this.option + ")";
    }

    public OptionsNew(String id, String option) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(option, "option");
        this.id = id;
        this.option = option;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOption() {
        return this.option;
    }
}