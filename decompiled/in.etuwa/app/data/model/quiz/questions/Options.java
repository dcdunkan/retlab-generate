package in.etuwa.app.data.model.quiz.questions;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Options.kt */
/* loaded from: classes3.dex */
public final /* data */ class Options implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final String option;

    public static /* synthetic */ Options copy$default(Options options, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = options.id;
        }
        if ((i & 2) != 0) {
            str2 = options.option;
        }
        return options.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    public final Options copy(String id, String option) {
        return new Options(id, option);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Options)) {
            return false;
        }
        Options options = (Options) other;
        return Intrinsics.areEqual(this.id, options.id) && Intrinsics.areEqual(this.option, options.option);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.option;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Options(id=" + this.id + ", option=" + this.option + ")";
    }

    public Options(String str, String str2) {
        this.id = str;
        this.option = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOption() {
        return this.option;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Options(Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.option);
    }

    /* compiled from: Options.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/questions/Options$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/questions/Options;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/questions/Options;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.quiz.questions.Options$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Options> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Options createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Options(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Options[] newArray(int size) {
            return new Options[size];
        }
    }
}