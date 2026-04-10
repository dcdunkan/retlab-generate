package in.etuwa.app.data.model.subjectregistration;

import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
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