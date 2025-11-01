package in.etuwa.app.data.model.survey;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyQuestion.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0081\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0003J\u0093\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0001J\b\u0010!\u001a\u00020\"H\u0016J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\u0018\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\"H\u0016R%\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006-"}, d2 = {"Lin/etuwa/app/data/model/survey/SurveyQuestion;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "qid", "", "question", "type", "option", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "id", CommonCssConstants.REQUIRED, "check", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCheck", "()Ljava/util/ArrayList;", "getId", "getOption", "getQid", "()Ljava/lang/String;", "getQuestion", "getRequired", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", XfdfConstants.FLAGS, "CREATOR", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SurveyQuestion implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ArrayList<String> check;
    private final ArrayList<String> id;
    private final ArrayList<String> option;
    private final String qid;
    private final String question;
    private final String required;
    private final String type;

    public static /* synthetic */ SurveyQuestion copy$default(SurveyQuestion surveyQuestion, String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2, String str4, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyQuestion.qid;
        }
        if ((i & 2) != 0) {
            str2 = surveyQuestion.question;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = surveyQuestion.type;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            arrayList = surveyQuestion.option;
        }
        ArrayList arrayList4 = arrayList;
        if ((i & 16) != 0) {
            arrayList2 = surveyQuestion.id;
        }
        ArrayList arrayList5 = arrayList2;
        if ((i & 32) != 0) {
            str4 = surveyQuestion.required;
        }
        String str7 = str4;
        if ((i & 64) != 0) {
            arrayList3 = surveyQuestion.check;
        }
        return surveyQuestion.copy(str, str5, str6, arrayList4, arrayList5, str7, arrayList3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQid() {
        return this.qid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ArrayList<String> component4() {
        return this.option;
    }

    public final ArrayList<String> component5() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRequired() {
        return this.required;
    }

    public final ArrayList<String> component7() {
        return this.check;
    }

    public final SurveyQuestion copy(String qid, String question, String type, ArrayList<String> option, ArrayList<String> id, String required, ArrayList<String> check) {
        return new SurveyQuestion(qid, question, type, option, id, required, check);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyQuestion)) {
            return false;
        }
        SurveyQuestion surveyQuestion = (SurveyQuestion) other;
        return Intrinsics.areEqual(this.qid, surveyQuestion.qid) && Intrinsics.areEqual(this.question, surveyQuestion.question) && Intrinsics.areEqual(this.type, surveyQuestion.type) && Intrinsics.areEqual(this.option, surveyQuestion.option) && Intrinsics.areEqual(this.id, surveyQuestion.id) && Intrinsics.areEqual(this.required, surveyQuestion.required) && Intrinsics.areEqual(this.check, surveyQuestion.check);
    }

    public int hashCode() {
        String str = this.qid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.question;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ArrayList<String> arrayList = this.option;
        int hashCode4 = (hashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<String> arrayList2 = this.id;
        int hashCode5 = (hashCode4 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        String str4 = this.required;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ArrayList<String> arrayList3 = this.check;
        return hashCode6 + (arrayList3 != null ? arrayList3.hashCode() : 0);
    }

    public String toString() {
        return "SurveyQuestion(qid=" + this.qid + ", question=" + this.question + ", type=" + this.type + ", option=" + this.option + ", id=" + this.id + ", required=" + this.required + ", check=" + this.check + ")";
    }

    public SurveyQuestion(String str, String str2, String str3, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str4, ArrayList<String> arrayList3) {
        this.qid = str;
        this.question = str2;
        this.type = str3;
        this.option = arrayList;
        this.id = arrayList2;
        this.required = str4;
        this.check = arrayList3;
    }

    public final String getQid() {
        return this.qid;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getType() {
        return this.type;
    }

    public final ArrayList<String> getOption() {
        return this.option;
    }

    public final ArrayList<String> getId() {
        return this.id;
    }

    public final String getRequired() {
        return this.required;
    }

    public final ArrayList<String> getCheck() {
        return this.check;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurveyQuestion(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString(), parcel.createStringArrayList());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.qid);
        parcel.writeString(this.question);
        parcel.writeString(this.type);
        parcel.writeStringList(this.option);
        parcel.writeStringList(this.id);
        parcel.writeString(this.required);
        parcel.writeStringList(this.check);
    }

    /* compiled from: SurveyQuestion.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/survey/SurveyQuestion$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/survey/SurveyQuestion;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/survey/SurveyQuestion;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.survey.SurveyQuestion$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<SurveyQuestion> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SurveyQuestion createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyQuestion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SurveyQuestion[] newArray(int size) {
            return new SurveyQuestion[size];
        }
    }
}