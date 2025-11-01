package in.etuwa.app.data.model.profileasiet.publication;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PublicationDropDownResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J÷\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u00062"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/publication/PublicationDropDownResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "sem_id", "", "sem_name", "years", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/profileasiet/publication/PublicationDropDown;", "Lkotlin/collections/ArrayList;", FirebaseAnalytics.Param.INDEX, "membership", "project", "nature", "category", FirebaseAnalytics.Param.LEVEL, "scholarship", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getCategory", "()Ljava/util/ArrayList;", "getIndex", "getLevel", "getLogin", "()Z", "getMembership", "getNature", "getProject", "getScholarship", "getSem_id", "()Ljava/lang/String;", "getSem_name", "getYears", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PublicationDropDownResponse {
    private final ArrayList<PublicationDropDown> category;
    private final ArrayList<PublicationDropDown> index;
    private final ArrayList<PublicationDropDown> level;
    private final boolean login;
    private final ArrayList<PublicationDropDown> membership;
    private final ArrayList<PublicationDropDown> nature;
    private final ArrayList<PublicationDropDown> project;
    private final ArrayList<PublicationDropDown> scholarship;
    private final String sem_id;
    private final String sem_name;
    private final ArrayList<PublicationDropDown> years;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<PublicationDropDown> component10() {
        return this.level;
    }

    public final ArrayList<PublicationDropDown> component11() {
        return this.scholarship;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSem_name() {
        return this.sem_name;
    }

    public final ArrayList<PublicationDropDown> component4() {
        return this.years;
    }

    public final ArrayList<PublicationDropDown> component5() {
        return this.index;
    }

    public final ArrayList<PublicationDropDown> component6() {
        return this.membership;
    }

    public final ArrayList<PublicationDropDown> component7() {
        return this.project;
    }

    public final ArrayList<PublicationDropDown> component8() {
        return this.nature;
    }

    public final ArrayList<PublicationDropDown> component9() {
        return this.category;
    }

    public final PublicationDropDownResponse copy(boolean login, String sem_id, String sem_name, ArrayList<PublicationDropDown> years, ArrayList<PublicationDropDown> index, ArrayList<PublicationDropDown> membership, ArrayList<PublicationDropDown> project, ArrayList<PublicationDropDown> nature, ArrayList<PublicationDropDown> category, ArrayList<PublicationDropDown> level, ArrayList<PublicationDropDown> scholarship) {
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(sem_name, "sem_name");
        Intrinsics.checkNotNullParameter(years, "years");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(membership, "membership");
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(nature, "nature");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        return new PublicationDropDownResponse(login, sem_id, sem_name, years, index, membership, project, nature, category, level, scholarship);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicationDropDownResponse)) {
            return false;
        }
        PublicationDropDownResponse publicationDropDownResponse = (PublicationDropDownResponse) other;
        return this.login == publicationDropDownResponse.login && Intrinsics.areEqual(this.sem_id, publicationDropDownResponse.sem_id) && Intrinsics.areEqual(this.sem_name, publicationDropDownResponse.sem_name) && Intrinsics.areEqual(this.years, publicationDropDownResponse.years) && Intrinsics.areEqual(this.index, publicationDropDownResponse.index) && Intrinsics.areEqual(this.membership, publicationDropDownResponse.membership) && Intrinsics.areEqual(this.project, publicationDropDownResponse.project) && Intrinsics.areEqual(this.nature, publicationDropDownResponse.nature) && Intrinsics.areEqual(this.category, publicationDropDownResponse.category) && Intrinsics.areEqual(this.level, publicationDropDownResponse.level) && Intrinsics.areEqual(this.scholarship, publicationDropDownResponse.scholarship);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((((r0 * 31) + this.sem_id.hashCode()) * 31) + this.sem_name.hashCode()) * 31) + this.years.hashCode()) * 31) + this.index.hashCode()) * 31) + this.membership.hashCode()) * 31) + this.project.hashCode()) * 31) + this.nature.hashCode()) * 31) + this.category.hashCode()) * 31) + this.level.hashCode()) * 31) + this.scholarship.hashCode();
    }

    public String toString() {
        return "PublicationDropDownResponse(login=" + this.login + ", sem_id=" + this.sem_id + ", sem_name=" + this.sem_name + ", years=" + this.years + ", index=" + this.index + ", membership=" + this.membership + ", project=" + this.project + ", nature=" + this.nature + ", category=" + this.category + ", level=" + this.level + ", scholarship=" + this.scholarship + ")";
    }

    public PublicationDropDownResponse(boolean z, String sem_id, String sem_name, ArrayList<PublicationDropDown> years, ArrayList<PublicationDropDown> index, ArrayList<PublicationDropDown> membership, ArrayList<PublicationDropDown> project, ArrayList<PublicationDropDown> nature, ArrayList<PublicationDropDown> category, ArrayList<PublicationDropDown> level, ArrayList<PublicationDropDown> scholarship) {
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(sem_name, "sem_name");
        Intrinsics.checkNotNullParameter(years, "years");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(membership, "membership");
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(nature, "nature");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        this.login = z;
        this.sem_id = sem_id;
        this.sem_name = sem_name;
        this.years = years;
        this.index = index;
        this.membership = membership;
        this.project = project;
        this.nature = nature;
        this.category = category;
        this.level = level;
        this.scholarship = scholarship;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getSem_id() {
        return this.sem_id;
    }

    public final String getSem_name() {
        return this.sem_name;
    }

    public final ArrayList<PublicationDropDown> getYears() {
        return this.years;
    }

    public final ArrayList<PublicationDropDown> getIndex() {
        return this.index;
    }

    public final ArrayList<PublicationDropDown> getMembership() {
        return this.membership;
    }

    public final ArrayList<PublicationDropDown> getProject() {
        return this.project;
    }

    public final ArrayList<PublicationDropDown> getNature() {
        return this.nature;
    }

    public final ArrayList<PublicationDropDown> getCategory() {
        return this.category;
    }

    public final ArrayList<PublicationDropDown> getLevel() {
        return this.level;
    }

    public final ArrayList<PublicationDropDown> getScholarship() {
        return this.scholarship;
    }
}