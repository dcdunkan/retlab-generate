package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.lab.Evaluation;
import in.etuwa.app.data.model.lab.LabDue;
import in.etuwa.app.data.model.lab.LabEquipRequest;
import in.etuwa.app.data.model.lab.LabEquipment;
import in.etuwa.app.data.model.lab.LabList;
import in.etuwa.app.data.model.lab.Practical;
import in.etuwa.app.data.model.lab.PracticalRequest;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LabRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LabRepository {
    private final ApiHelper apiHelper;

    public LabRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<ArrayList<LabDue>> getLabDueApiCall() {
        return this.apiHelper.getLabDueApiCall();
    }

    public final Single<ArrayList<LabList>> getLabListApiCall() {
        return this.apiHelper.getLabListApiCall();
    }

    public final Single<ArrayList<LabEquipment>> getEquipmentsApiCall(LabEquipRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getEquipmentsApiCall(request);
    }

    public final Single<ArrayList<String>> getSafetyApiCall(LabEquipRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getSafetyApiCall(request);
    }

    public final Single<ArrayList<Practical>> getPracticalsApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getPracticalsApiCall(request);
    }

    public final Single<ArrayList<String>> getExperimentApiCall(PracticalRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getExperimentApiCall(request);
    }

    public final Single<ArrayList<Evaluation>> getEvaluationApiCall(PracticalRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getEvaluationApiCall(request);
    }
}