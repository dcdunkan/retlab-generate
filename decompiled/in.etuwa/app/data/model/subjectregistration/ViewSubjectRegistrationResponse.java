package in.etuwa.app.data.model.subjectregistration;

import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u0019\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000eHÆ\u0003J\u0083\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006-"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/ViewSubjectRegistrationResponse;", "", "admission_no", "", "full_name", AttendanceDayDialogKt.ARG_SEM, "sem_id", "path_way", "category", "can_update", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/Category;", "Lkotlin/collections/ArrayList;", "previousdata", "Lin/etuwa/app/data/model/subjectregistration/SemesterList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "getAdmission_no", "()Ljava/lang/String;", "getCan_update", "()Z", "getCategory", "getData", "()Ljava/util/ArrayList;", "getFull_name", "getPath_way", "getPreviousdata", "getSem_id", "getSemester", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ViewSubjectRegistrationResponse {
    private final String admission_no;
    private final boolean can_update;
    private final String category;
    private final ArrayList<Category> data;
    private final String full_name;
    private final String path_way;
    private final ArrayList<SemesterList> previousdata;
    private final String sem_id;
    private final String semester;

    /* renamed from: component1, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFull_name() {
        return this.full_name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPath_way() {
        return this.path_way;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCan_update() {
        return this.can_update;
    }

    public final ArrayList<Category> component8() {
        return this.data;
    }

    public final ArrayList<SemesterList> component9() {
        return this.previousdata;
    }

    public final ViewSubjectRegistrationResponse copy(String admission_no, String full_name, String semester, String sem_id, String path_way, String category, boolean can_update, ArrayList<Category> data, ArrayList<SemesterList> previousdata) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(path_way, "path_way");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(previousdata, "previousdata");
        return new ViewSubjectRegistrationResponse(admission_no, full_name, semester, sem_id, path_way, category, can_update, data, previousdata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewSubjectRegistrationResponse)) {
            return false;
        }
        ViewSubjectRegistrationResponse viewSubjectRegistrationResponse = (ViewSubjectRegistrationResponse) other;
        return Intrinsics.areEqual(this.admission_no, viewSubjectRegistrationResponse.admission_no) && Intrinsics.areEqual(this.full_name, viewSubjectRegistrationResponse.full_name) && Intrinsics.areEqual(this.semester, viewSubjectRegistrationResponse.semester) && Intrinsics.areEqual(this.sem_id, viewSubjectRegistrationResponse.sem_id) && Intrinsics.areEqual(this.path_way, viewSubjectRegistrationResponse.path_way) && Intrinsics.areEqual(this.category, viewSubjectRegistrationResponse.category) && this.can_update == viewSubjectRegistrationResponse.can_update && Intrinsics.areEqual(this.data, viewSubjectRegistrationResponse.data) && Intrinsics.areEqual(this.previousdata, viewSubjectRegistrationResponse.previousdata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.admission_no.hashCode() * 31) + this.full_name.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.sem_id.hashCode()) * 31) + this.path_way.hashCode()) * 31) + this.category.hashCode()) * 31;
        boolean z = this.can_update;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.data.hashCode()) * 31) + this.previousdata.hashCode();
    }

    public String toString() {
        return "ViewSubjectRegistrationResponse(admission_no=" + this.admission_no + ", full_name=" + this.full_name + ", semester=" + this.semester + ", sem_id=" + this.sem_id + ", path_way=" + this.path_way + ", category=" + this.category + ", can_update=" + this.can_update + ", data=" + this.data + ", previousdata=" + this.previousdata + ")";
    }

    public ViewSubjectRegistrationResponse(String admission_no, String full_name, String semester, String sem_id, String path_way, String category, boolean z, ArrayList<Category> data, ArrayList<SemesterList> previousdata) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(path_way, "path_way");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(previousdata, "previousdata");
        this.admission_no = admission_no;
        this.full_name = full_name;
        this.semester = semester;
        this.sem_id = sem_id;
        this.path_way = path_way;
        this.category = category;
        this.can_update = z;
        this.data = data;
        this.previousdata = previousdata;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getFull_name() {
        return this.full_name;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getSem_id() {
        return this.sem_id;
    }

    public final String getPath_way() {
        return this.path_way;
    }

    public final String getCategory() {
        return this.category;
    }

    public final boolean getCan_update() {
        return this.can_update;
    }

    public final ArrayList<Category> getData() {
        return this.data;
    }

    public final ArrayList<SemesterList> getPreviousdata() {
        return this.previousdata;
    }
}