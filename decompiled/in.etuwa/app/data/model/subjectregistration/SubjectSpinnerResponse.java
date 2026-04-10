package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectSpinnerResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class SubjectSpinnerResponse {
    private final ArrayList<SubjectSpinner> additionalelective_1;
    private final ArrayList<SubjectSpinner> additionalelective_2;
    private final ArrayList<SubjectSpinner> additionalelective_3;
    private final ArrayList<SubjectSpinner> aec_1;
    private final ArrayList<SubjectSpinner> aec_2;
    private final ArrayList<SubjectSpinner> aec_3;
    private final ArrayList<SubjectSpinner> dsc_1;
    private final ArrayList<SubjectSpinner> dsc_2;
    private final ArrayList<SubjectSpinner> dsc_3;
    private final ArrayList<SubjectSpinner> elective_1;
    private final ArrayList<SubjectSpinner> elective_2;
    private final ArrayList<SubjectSpinner> elective_3;
    private final ArrayList<SubjectSpinner> globalelective;
    private final ArrayList<SubjectSpinner> honour;
    private final ArrayList<SubjectSpinner> mdc_1;
    private final ArrayList<SubjectSpinner> mdc_2;
    private final ArrayList<SubjectSpinner> mdc_3;
    private final ArrayList<SubjectSpinner> minor_1;
    private final ArrayList<SubjectSpinner> minor_2;
    private final ArrayList<SubjectSpinner> minor_3;

    public final ArrayList<SubjectSpinner> component1() {
        return this.honour;
    }

    public final ArrayList<SubjectSpinner> component10() {
        return this.additionalelective_2;
    }

    public final ArrayList<SubjectSpinner> component11() {
        return this.additionalelective_3;
    }

    public final ArrayList<SubjectSpinner> component12() {
        return this.mdc_1;
    }

    public final ArrayList<SubjectSpinner> component13() {
        return this.mdc_2;
    }

    public final ArrayList<SubjectSpinner> component14() {
        return this.mdc_3;
    }

    public final ArrayList<SubjectSpinner> component15() {
        return this.aec_1;
    }

    public final ArrayList<SubjectSpinner> component16() {
        return this.aec_2;
    }

    public final ArrayList<SubjectSpinner> component17() {
        return this.aec_3;
    }

    public final ArrayList<SubjectSpinner> component18() {
        return this.dsc_1;
    }

    public final ArrayList<SubjectSpinner> component19() {
        return this.dsc_2;
    }

    public final ArrayList<SubjectSpinner> component2() {
        return this.minor_1;
    }

    public final ArrayList<SubjectSpinner> component20() {
        return this.dsc_3;
    }

    public final ArrayList<SubjectSpinner> component3() {
        return this.minor_2;
    }

    public final ArrayList<SubjectSpinner> component4() {
        return this.minor_3;
    }

    public final ArrayList<SubjectSpinner> component5() {
        return this.elective_1;
    }

    public final ArrayList<SubjectSpinner> component6() {
        return this.elective_2;
    }

    public final ArrayList<SubjectSpinner> component7() {
        return this.elective_3;
    }

    public final ArrayList<SubjectSpinner> component8() {
        return this.globalelective;
    }

    public final ArrayList<SubjectSpinner> component9() {
        return this.additionalelective_1;
    }

    public final SubjectSpinnerResponse copy(ArrayList<SubjectSpinner> honour, ArrayList<SubjectSpinner> minor_1, ArrayList<SubjectSpinner> minor_2, ArrayList<SubjectSpinner> minor_3, ArrayList<SubjectSpinner> elective_1, ArrayList<SubjectSpinner> elective_2, ArrayList<SubjectSpinner> elective_3, ArrayList<SubjectSpinner> globalelective, ArrayList<SubjectSpinner> additionalelective_1, ArrayList<SubjectSpinner> additionalelective_2, ArrayList<SubjectSpinner> additionalelective_3, ArrayList<SubjectSpinner> mdc_1, ArrayList<SubjectSpinner> mdc_2, ArrayList<SubjectSpinner> mdc_3, ArrayList<SubjectSpinner> aec_1, ArrayList<SubjectSpinner> aec_2, ArrayList<SubjectSpinner> aec_3, ArrayList<SubjectSpinner> dsc_1, ArrayList<SubjectSpinner> dsc_2, ArrayList<SubjectSpinner> dsc_3) {
        Intrinsics.checkNotNullParameter(honour, "honour");
        Intrinsics.checkNotNullParameter(minor_1, "minor_1");
        Intrinsics.checkNotNullParameter(minor_2, "minor_2");
        Intrinsics.checkNotNullParameter(minor_3, "minor_3");
        Intrinsics.checkNotNullParameter(elective_1, "elective_1");
        Intrinsics.checkNotNullParameter(elective_2, "elective_2");
        Intrinsics.checkNotNullParameter(elective_3, "elective_3");
        Intrinsics.checkNotNullParameter(globalelective, "globalelective");
        Intrinsics.checkNotNullParameter(additionalelective_1, "additionalelective_1");
        Intrinsics.checkNotNullParameter(additionalelective_2, "additionalelective_2");
        Intrinsics.checkNotNullParameter(additionalelective_3, "additionalelective_3");
        Intrinsics.checkNotNullParameter(mdc_1, "mdc_1");
        Intrinsics.checkNotNullParameter(mdc_2, "mdc_2");
        Intrinsics.checkNotNullParameter(mdc_3, "mdc_3");
        Intrinsics.checkNotNullParameter(aec_1, "aec_1");
        Intrinsics.checkNotNullParameter(aec_2, "aec_2");
        Intrinsics.checkNotNullParameter(aec_3, "aec_3");
        Intrinsics.checkNotNullParameter(dsc_1, "dsc_1");
        Intrinsics.checkNotNullParameter(dsc_2, "dsc_2");
        Intrinsics.checkNotNullParameter(dsc_3, "dsc_3");
        return new SubjectSpinnerResponse(honour, minor_1, minor_2, minor_3, elective_1, elective_2, elective_3, globalelective, additionalelective_1, additionalelective_2, additionalelective_3, mdc_1, mdc_2, mdc_3, aec_1, aec_2, aec_3, dsc_1, dsc_2, dsc_3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectSpinnerResponse)) {
            return false;
        }
        SubjectSpinnerResponse subjectSpinnerResponse = (SubjectSpinnerResponse) other;
        return Intrinsics.areEqual(this.honour, subjectSpinnerResponse.honour) && Intrinsics.areEqual(this.minor_1, subjectSpinnerResponse.minor_1) && Intrinsics.areEqual(this.minor_2, subjectSpinnerResponse.minor_2) && Intrinsics.areEqual(this.minor_3, subjectSpinnerResponse.minor_3) && Intrinsics.areEqual(this.elective_1, subjectSpinnerResponse.elective_1) && Intrinsics.areEqual(this.elective_2, subjectSpinnerResponse.elective_2) && Intrinsics.areEqual(this.elective_3, subjectSpinnerResponse.elective_3) && Intrinsics.areEqual(this.globalelective, subjectSpinnerResponse.globalelective) && Intrinsics.areEqual(this.additionalelective_1, subjectSpinnerResponse.additionalelective_1) && Intrinsics.areEqual(this.additionalelective_2, subjectSpinnerResponse.additionalelective_2) && Intrinsics.areEqual(this.additionalelective_3, subjectSpinnerResponse.additionalelective_3) && Intrinsics.areEqual(this.mdc_1, subjectSpinnerResponse.mdc_1) && Intrinsics.areEqual(this.mdc_2, subjectSpinnerResponse.mdc_2) && Intrinsics.areEqual(this.mdc_3, subjectSpinnerResponse.mdc_3) && Intrinsics.areEqual(this.aec_1, subjectSpinnerResponse.aec_1) && Intrinsics.areEqual(this.aec_2, subjectSpinnerResponse.aec_2) && Intrinsics.areEqual(this.aec_3, subjectSpinnerResponse.aec_3) && Intrinsics.areEqual(this.dsc_1, subjectSpinnerResponse.dsc_1) && Intrinsics.areEqual(this.dsc_2, subjectSpinnerResponse.dsc_2) && Intrinsics.areEqual(this.dsc_3, subjectSpinnerResponse.dsc_3);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.honour.hashCode() * 31) + this.minor_1.hashCode()) * 31) + this.minor_2.hashCode()) * 31) + this.minor_3.hashCode()) * 31) + this.elective_1.hashCode()) * 31) + this.elective_2.hashCode()) * 31) + this.elective_3.hashCode()) * 31) + this.globalelective.hashCode()) * 31) + this.additionalelective_1.hashCode()) * 31) + this.additionalelective_2.hashCode()) * 31) + this.additionalelective_3.hashCode()) * 31) + this.mdc_1.hashCode()) * 31) + this.mdc_2.hashCode()) * 31) + this.mdc_3.hashCode()) * 31) + this.aec_1.hashCode()) * 31) + this.aec_2.hashCode()) * 31) + this.aec_3.hashCode()) * 31) + this.dsc_1.hashCode()) * 31) + this.dsc_2.hashCode()) * 31) + this.dsc_3.hashCode();
    }

    public String toString() {
        return "SubjectSpinnerResponse(honour=" + this.honour + ", minor_1=" + this.minor_1 + ", minor_2=" + this.minor_2 + ", minor_3=" + this.minor_3 + ", elective_1=" + this.elective_1 + ", elective_2=" + this.elective_2 + ", elective_3=" + this.elective_3 + ", globalelective=" + this.globalelective + ", additionalelective_1=" + this.additionalelective_1 + ", additionalelective_2=" + this.additionalelective_2 + ", additionalelective_3=" + this.additionalelective_3 + ", mdc_1=" + this.mdc_1 + ", mdc_2=" + this.mdc_2 + ", mdc_3=" + this.mdc_3 + ", aec_1=" + this.aec_1 + ", aec_2=" + this.aec_2 + ", aec_3=" + this.aec_3 + ", dsc_1=" + this.dsc_1 + ", dsc_2=" + this.dsc_2 + ", dsc_3=" + this.dsc_3 + ")";
    }

    public SubjectSpinnerResponse(ArrayList<SubjectSpinner> honour, ArrayList<SubjectSpinner> minor_1, ArrayList<SubjectSpinner> minor_2, ArrayList<SubjectSpinner> minor_3, ArrayList<SubjectSpinner> elective_1, ArrayList<SubjectSpinner> elective_2, ArrayList<SubjectSpinner> elective_3, ArrayList<SubjectSpinner> globalelective, ArrayList<SubjectSpinner> additionalelective_1, ArrayList<SubjectSpinner> additionalelective_2, ArrayList<SubjectSpinner> additionalelective_3, ArrayList<SubjectSpinner> mdc_1, ArrayList<SubjectSpinner> mdc_2, ArrayList<SubjectSpinner> mdc_3, ArrayList<SubjectSpinner> aec_1, ArrayList<SubjectSpinner> aec_2, ArrayList<SubjectSpinner> aec_3, ArrayList<SubjectSpinner> dsc_1, ArrayList<SubjectSpinner> dsc_2, ArrayList<SubjectSpinner> dsc_3) {
        Intrinsics.checkNotNullParameter(honour, "honour");
        Intrinsics.checkNotNullParameter(minor_1, "minor_1");
        Intrinsics.checkNotNullParameter(minor_2, "minor_2");
        Intrinsics.checkNotNullParameter(minor_3, "minor_3");
        Intrinsics.checkNotNullParameter(elective_1, "elective_1");
        Intrinsics.checkNotNullParameter(elective_2, "elective_2");
        Intrinsics.checkNotNullParameter(elective_3, "elective_3");
        Intrinsics.checkNotNullParameter(globalelective, "globalelective");
        Intrinsics.checkNotNullParameter(additionalelective_1, "additionalelective_1");
        Intrinsics.checkNotNullParameter(additionalelective_2, "additionalelective_2");
        Intrinsics.checkNotNullParameter(additionalelective_3, "additionalelective_3");
        Intrinsics.checkNotNullParameter(mdc_1, "mdc_1");
        Intrinsics.checkNotNullParameter(mdc_2, "mdc_2");
        Intrinsics.checkNotNullParameter(mdc_3, "mdc_3");
        Intrinsics.checkNotNullParameter(aec_1, "aec_1");
        Intrinsics.checkNotNullParameter(aec_2, "aec_2");
        Intrinsics.checkNotNullParameter(aec_3, "aec_3");
        Intrinsics.checkNotNullParameter(dsc_1, "dsc_1");
        Intrinsics.checkNotNullParameter(dsc_2, "dsc_2");
        Intrinsics.checkNotNullParameter(dsc_3, "dsc_3");
        this.honour = honour;
        this.minor_1 = minor_1;
        this.minor_2 = minor_2;
        this.minor_3 = minor_3;
        this.elective_1 = elective_1;
        this.elective_2 = elective_2;
        this.elective_3 = elective_3;
        this.globalelective = globalelective;
        this.additionalelective_1 = additionalelective_1;
        this.additionalelective_2 = additionalelective_2;
        this.additionalelective_3 = additionalelective_3;
        this.mdc_1 = mdc_1;
        this.mdc_2 = mdc_2;
        this.mdc_3 = mdc_3;
        this.aec_1 = aec_1;
        this.aec_2 = aec_2;
        this.aec_3 = aec_3;
        this.dsc_1 = dsc_1;
        this.dsc_2 = dsc_2;
        this.dsc_3 = dsc_3;
    }

    public final ArrayList<SubjectSpinner> getHonour() {
        return this.honour;
    }

    public final ArrayList<SubjectSpinner> getMinor_1() {
        return this.minor_1;
    }

    public final ArrayList<SubjectSpinner> getMinor_2() {
        return this.minor_2;
    }

    public final ArrayList<SubjectSpinner> getMinor_3() {
        return this.minor_3;
    }

    public final ArrayList<SubjectSpinner> getElective_1() {
        return this.elective_1;
    }

    public final ArrayList<SubjectSpinner> getElective_2() {
        return this.elective_2;
    }

    public final ArrayList<SubjectSpinner> getElective_3() {
        return this.elective_3;
    }

    public final ArrayList<SubjectSpinner> getGlobalelective() {
        return this.globalelective;
    }

    public final ArrayList<SubjectSpinner> getAdditionalelective_1() {
        return this.additionalelective_1;
    }

    public final ArrayList<SubjectSpinner> getAdditionalelective_2() {
        return this.additionalelective_2;
    }

    public final ArrayList<SubjectSpinner> getAdditionalelective_3() {
        return this.additionalelective_3;
    }

    public final ArrayList<SubjectSpinner> getMdc_1() {
        return this.mdc_1;
    }

    public final ArrayList<SubjectSpinner> getMdc_2() {
        return this.mdc_2;
    }

    public final ArrayList<SubjectSpinner> getMdc_3() {
        return this.mdc_3;
    }

    public final ArrayList<SubjectSpinner> getAec_1() {
        return this.aec_1;
    }

    public final ArrayList<SubjectSpinner> getAec_2() {
        return this.aec_2;
    }

    public final ArrayList<SubjectSpinner> getAec_3() {
        return this.aec_3;
    }

    public final ArrayList<SubjectSpinner> getDsc_1() {
        return this.dsc_1;
    }

    public final ArrayList<SubjectSpinner> getDsc_2() {
        return this.dsc_2;
    }

    public final ArrayList<SubjectSpinner> getDsc_3() {
        return this.dsc_3;
    }
}