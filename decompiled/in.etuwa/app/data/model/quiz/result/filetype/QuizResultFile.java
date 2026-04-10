package in.etuwa.app.data.model.quiz.result.filetype;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizResultFile.kt */
/* loaded from: classes3.dex */
public final /* data */ class QuizResultFile implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final String path;

    public static /* synthetic */ QuizResultFile copy$default(QuizResultFile quizResultFile, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizResultFile.name;
        }
        if ((i & 2) != 0) {
            str2 = quizResultFile.path;
        }
        return quizResultFile.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final QuizResultFile copy(String name, String path) {
        return new QuizResultFile(name, path);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizResultFile)) {
            return false;
        }
        QuizResultFile quizResultFile = (QuizResultFile) other;
        return Intrinsics.areEqual(this.name, quizResultFile.name) && Intrinsics.areEqual(this.path, quizResultFile.path);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.path;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "QuizResultFile(name=" + this.name + ", path=" + this.path + ")";
    }

    public QuizResultFile(String str, String str2) {
        this.name = str;
        this.path = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuizResultFile(Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.path);
    }

    /* compiled from: QuizResultFile.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/filetype/QuizResultFile$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/quiz/result/filetype/QuizResultFile;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/quiz/result/filetype/QuizResultFile;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.quiz.result.filetype.QuizResultFile$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<QuizResultFile> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuizResultFile createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QuizResultFile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuizResultFile[] newArray(int size) {
            return new QuizResultFile[size];
        }
    }
}