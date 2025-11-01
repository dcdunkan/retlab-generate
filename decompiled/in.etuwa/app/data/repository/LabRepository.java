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

/* compiled from: LabRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t0\u00062\u0006\u0010\n\u001a\u00020\u000eJ$\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u0007j\b\u0012\u0004\u0012\u00020\u0010`\t0\u00062\u0006\u0010\n\u001a\u00020\u000eJ\u001c\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\t0\u0006J\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0007j\b\u0012\u0004\u0012\u00020\u0014`\t0\u0006J$\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0007j\b\u0012\u0004\u0012\u00020\u0016`\t0\u00062\u0006\u0010\n\u001a\u00020\u0017J$\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u0007j\b\u0012\u0004\u0012\u00020\u0010`\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u0007j\b\u0012\u0004\u0012\u00020\u001a`\t0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/repository/LabRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getEquipmentsApiCall", "Lio/reactivex/Single;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/lab/LabEquipment;", "Lkotlin/collections/ArrayList;", "request", "Lin/etuwa/app/data/model/lab/LabEquipRequest;", "getEvaluationApiCall", "Lin/etuwa/app/data/model/lab/Evaluation;", "Lin/etuwa/app/data/model/lab/PracticalRequest;", "getExperimentApiCall", "", "getLabDueApiCall", "Lin/etuwa/app/data/model/lab/LabDue;", "getLabListApiCall", "Lin/etuwa/app/data/model/lab/LabList;", "getPracticalsApiCall", "Lin/etuwa/app/data/model/lab/Practical;", "Lin/etuwa/app/data/model/attendance/AttendanceRequest;", "getSafetyApiCall", "getSemestersApiCall", "Lin/etuwa/app/data/model/Semester;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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