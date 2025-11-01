package in.etuwa.app.data.repository;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.HostelFeePalaiResponse;
import in.etuwa.app.data.model.hostel.HostelFeeResponse;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmissionResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiTypesResponse;
import in.etuwa.app.data.model.hostel.HostelResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttCalResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttParentViewResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttViewResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelScanViewResponse;
import in.etuwa.app.data.model.hostel.attendance.LeaveTypeResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.newregistration.CategoryTypeResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.registration.RegistrationResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.registration.ViewRegistrationResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.reregistration.PresentHostelResponse;
import in.etuwa.app.data.model.hostel.mits.MitsFeePay;
import in.etuwa.app.data.model.hostel.partial.admission.HostelPartialAdmission;
import in.etuwa.app.data.model.hostel.receipt.HostelReceiptResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmissionResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewHistoryResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthlyResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewPay;
import in.etuwa.app.data.model.hostelnew.HostelStatusNew;
import in.etuwa.app.data.model.mess.MessMenuResponse;
import in.etuwa.app.data.model.mess.MessResponse;
import in.etuwa.app.data.model.mess.MessTypeResponse;
import in.etuwa.app.data.model.mess.OrderHistoryResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: HostelRepository.kt */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001eJ4\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001eJ4\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001eJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0006J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0006J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0006J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010.\u001a\u00020\tJ\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010.\u001a\u00020\tJ\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010.\u001a\u00020\tJ\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0006J\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0006J\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0006J\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0006J\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u0006J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0006J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0006J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0006J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0006J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0006J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0006J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0006J\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0006J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0006J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0006J\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0006J\u001c\u0010R\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020T0Sj\b\u0012\u0004\u0012\u00020T`U0\u0006J$\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\tJ\u0086\u0001\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020]2\u0006\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020]2\u0006\u0010b\u001a\u00020]2\u0006\u0010c\u001a\u00020]2\b\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020]2\u0006\u0010g\u001a\u00020]2\u0006\u0010h\u001a\u00020]2\u0006\u0010i\u001a\u00020]2\u0006\u0010j\u001a\u00020]2\u0006\u0010k\u001a\u00020]2\u0006\u0010l\u001a\u00020]JN\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00070[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020]2\u0006\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020]2\u0006\u0010b\u001a\u00020]2\u0006\u0010c\u001a\u00020]2\b\u0010d\u001a\u0004\u0018\u00010eJV\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00070[2\u0006\u0010\b\u001a\u00020]2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020]2\u0006\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020]2\u0006\u0010b\u001a\u00020]2\u0006\u0010c\u001a\u00020]2\b\u0010d\u001a\u0004\u0018\u00010eJ\u0014\u0010o\u001a\b\u0012\u0004\u0012\u00020p0\u00062\u0006\u0010\b\u001a\u00020]R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lin/etuwa/app/data/repository/HostelRepository;", "Lorg/koin/core/component/KoinComponent;", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "cancelMessOrderApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "checkAlreadyExitApiCall", "checkExitApiCall", "getCategoryTypeApiCall", "Lin/etuwa/app/data/model/hostel/gcekhostel/newregistration/CategoryTypeResponse;", "getHostelApiCall", "Lin/etuwa/app/data/model/hostel/HostelResponse;", "getHostelApplyLeaveApiCall", "leaveType", "fromDate", "toDate", "reason", "getHostelApproveLeaveParentApiCall", "getHostelAttCalApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttCalResponse;", "month", "year", "getHostelDeleteLeaveApiCall", "getHostelFeeConfirmApiCall", "Lin/etuwa/app/data/model/hostel/HostelFeeResponse;", "feeCollection", "", "feeReceipt", "getHostelFeeConfirmPalaiApiCall", "Lin/etuwa/app/data/model/hostel/HostelFeePalaiResponse;", "getHostelFeeNewPayApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewPay;", "getHostelFeeTypesApiCall", "Lin/etuwa/app/data/model/hostel/HostelPalaiTypesResponse;", "getHostelGatePassApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelScanViewResponse;", "getHostelHistoryNewApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewHistoryResponse;", "getHostelLeaveTypeApiCall", "Lin/etuwa/app/data/model/hostel/attendance/LeaveTypeResponse;", "getHostelLeaveViewParentApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttParentViewResponse;", "date", "getHostelLeaveViewParentApproveApiCall", "getHostelLeaveViewParentRejectApiCall", "getHostelMessApiCall", "Lin/etuwa/app/data/model/mess/MessResponse;", "getHostelNewAdmissionApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewAdmissionResponse;", "getHostelNewMonthlyApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewMonthlyResponse;", "getHostelReceiptNewApiCall", "Lin/etuwa/app/data/model/hostel/receipt/HostelReceiptResponse;", "getHostelReceiptTkmApiCall", "getHostelRegistrationData", "Lin/etuwa/app/data/model/hostel/gcekhostel/registration/RegistrationResponse;", "getHostelRejectLeaveParentApiCall", "getHostelRevokeLeaveParentApiCall", "getHostelStatusNewApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelStatusNew;", "getHostelTkmApiCall", "Lin/etuwa/app/data/model/hostel/HostelMonthResponse;", "getHostelViewLeaveApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttViewResponse;", "getMessMenuApiCall", "Lin/etuwa/app/data/model/mess/MessMenuResponse;", "getMessOrderHistoryApiCall", "Lin/etuwa/app/data/model/mess/OrderHistoryResponse;", "getMessTypeApiCall", "Lin/etuwa/app/data/model/mess/MessTypeResponse;", "getMitsFeePayUrl", "Lin/etuwa/app/data/model/hostel/mits/MitsFeePay;", "getPalaiHostelAdmsnApiCall", "Lin/etuwa/app/data/model/hostel/HostelPalaiAdmissionResponse;", "getPalaiHostelPartialAdmsnApiCall", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "getPresentHostelApiCall", "Lin/etuwa/app/data/model/hostel/gcekhostel/reregistration/PresentHostelResponse;", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "messBookingApiCall", "type", CommonCssConstants.MENU, "qty", "newHostelReRegistrationApiCall", "Lio/reactivex/Observable;", "reAdmission", "Lokhttp3/RequestBody;", "category", "localGuardian", "localGuardianPhone", "annualIncome", "distance", "semesterId", "uploadFile", "Lokhttp3/MultipartBody$Part;", "hostelId", "yearCount", "hostelDetails", "isFined", "fineDetails", "feeDefaulter", "feeDetails", "newHostelRegistrationApiCall", "updateHostelRegistrationApiCall", "viewRegistrationApiCall", "Lin/etuwa/app/data/model/hostel/gcekhostel/registration/ViewRegistrationResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HostelRepository implements KoinComponent {
    private final ApiHelper apiHelper;

    public HostelRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final Single<HostelResponse> getHostelApiCall() {
        return this.apiHelper.getHostelApiCall();
    }

    public final Single<HostelFeeResponse> getHostelFeeConfirmApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiHelper.getHostelFeeConfirmApiCall(feeCollection, feeReceipt);
    }

    public final Single<HostelFeePalaiResponse> getHostelFeeConfirmPalaiApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiHelper.getHostelFeeConfirmPalaiApiCall(feeCollection, feeReceipt);
    }

    public final Single<HostelMonthResponse> getHostelTkmApiCall() {
        return this.apiHelper.getHostelTkmApiCall();
    }

    public final Single<HostelReceiptResponse> getHostelReceiptTkmApiCall() {
        return this.apiHelper.getHostelReceiptTkmApiCall();
    }

    public final Single<RegistrationResponse> getHostelRegistrationData() {
        return this.apiHelper.getHostelRegistrationData();
    }

    public final Observable<SuccessResponse> newHostelRegistrationApiCall(RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        return this.apiHelper.newHostelRegistrationApiCall(reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile);
    }

    public final Single<CategoryTypeResponse> getCategoryTypeApiCall() {
        return this.apiHelper.getCategoryTypeApiCall();
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<PresentHostelResponse> getPresentHostelApiCall() {
        return this.apiHelper.getPresentHostelApiCall();
    }

    public final Observable<SuccessResponse> newHostelReRegistrationApiCall(RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile, RequestBody hostelId, RequestBody yearCount, RequestBody hostelDetails, RequestBody isFined, RequestBody fineDetails, RequestBody feeDefaulter, RequestBody feeDetails) {
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        Intrinsics.checkNotNullParameter(hostelId, "hostelId");
        Intrinsics.checkNotNullParameter(yearCount, "yearCount");
        Intrinsics.checkNotNullParameter(hostelDetails, "hostelDetails");
        Intrinsics.checkNotNullParameter(isFined, "isFined");
        Intrinsics.checkNotNullParameter(fineDetails, "fineDetails");
        Intrinsics.checkNotNullParameter(feeDefaulter, "feeDefaulter");
        Intrinsics.checkNotNullParameter(feeDetails, "feeDetails");
        return this.apiHelper.newHostelReRegistrationApiCall(reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile, hostelId, yearCount, hostelDetails, isFined, fineDetails, feeDefaulter, feeDetails);
    }

    public final Observable<SuccessResponse> updateHostelRegistrationApiCall(RequestBody id, RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        return this.apiHelper.updateHostelRegistrationApiCall(id, reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile);
    }

    public final Single<ViewRegistrationResponse> viewRegistrationApiCall(RequestBody id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.viewRegistrationApiCall(id);
    }

    public final Single<MessResponse> getHostelMessApiCall() {
        return this.apiHelper.getHostelMessApiCall();
    }

    public final Single<OrderHistoryResponse> getMessOrderHistoryApiCall() {
        return this.apiHelper.getMessOrderHistoryApiCall();
    }

    public final Single<SuccessResponse> cancelMessOrderApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.cancelMessOrderApiCall(id);
    }

    public final Single<SuccessResponse> messBookingApiCall(String type, String menu, String qty) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(qty, "qty");
        return this.apiHelper.messBookingApiCall(type, menu, qty);
    }

    public final Single<MessMenuResponse> getMessMenuApiCall() {
        return this.apiHelper.getMessMenuApiCall();
    }

    public final Single<MessTypeResponse> getMessTypeApiCall() {
        return this.apiHelper.getMessTypeApiCall();
    }

    public final Single<MessMenuResponse> getMessTypeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getMessTypeApiCall(id);
    }

    public final Single<HostelPalaiAdmissionResponse> getPalaiHostelAdmsnApiCall() {
        return this.apiHelper.getPalaiHostelAdmsnApiCall();
    }

    public final Single<HostelPalaiTypesResponse> getHostelFeeTypesApiCall() {
        return this.apiHelper.getHostelFeeTypesApiCall();
    }

    public final Single<HostelPartialAdmission> getPalaiHostelPartialAdmsnApiCall() {
        return this.apiHelper.getPalaiHostelPartialAdmsnApiCall();
    }

    public final Single<HostelAttViewResponse> getHostelViewLeaveApiCall() {
        return this.apiHelper.getHostelViewLeaveApiCall();
    }

    public final Single<LeaveTypeResponse> getHostelLeaveTypeApiCall() {
        return this.apiHelper.getHostelLeaveTypeApiCall();
    }

    public final Single<SuccessResponse> getHostelApplyLeaveApiCall(String leaveType, String fromDate, String toDate, String reason) {
        Intrinsics.checkNotNullParameter(leaveType, "leaveType");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return this.apiHelper.getHostelApplyLeaveApiCall(leaveType, fromDate, toDate, reason);
    }

    public final Single<HostelAttParentViewResponse> getHostelLeaveViewParentApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.getHostelLeaveViewParentApiCall(date);
    }

    public final Single<HostelAttParentViewResponse> getHostelLeaveViewParentApproveApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.getHostelLeaveViewParentApproveApiCall(date);
    }

    public final Single<HostelAttParentViewResponse> getHostelLeaveViewParentRejectApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.getHostelLeaveViewParentRejectApiCall(date);
    }

    public final Single<SuccessResponse> getHostelRevokeLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getHostelRevokeLeaveParentApiCall(id);
    }

    public final Single<SuccessResponse> getHostelApproveLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getHostelApproveLeaveParentApiCall(id);
    }

    public final Single<SuccessResponse> getHostelRejectLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getHostelRejectLeaveParentApiCall(id);
    }

    public final Single<HostelAttCalResponse> getHostelAttCalApiCall(String month, String year) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        return this.apiHelper.getHostelAttCalApiCall(month, year);
    }

    public final Single<SuccessResponse> getHostelDeleteLeaveApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getHostelDeleteLeaveApiCall(id);
    }

    public final Single<HostelScanViewResponse> getHostelGatePassApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getHostelGatePassApiCall(id);
    }

    public final Single<SuccessResponse> checkExitApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.checkExitApiCall(id);
    }

    public final Single<SuccessResponse> checkAlreadyExitApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.checkAlreadyExitApiCall(id);
    }

    public final Single<MitsFeePay> getMitsFeePayUrl() {
        return this.apiHelper.getMitsFeePayUrl();
    }

    public final Single<HostelNewMonthlyResponse> getHostelNewMonthlyApiCall() {
        return this.apiHelper.getHostelNewMonthlyApiCall();
    }

    public final Single<HostelNewAdmissionResponse> getHostelNewAdmissionApiCall() {
        return this.apiHelper.getHostelNewAdmissionApiCall();
    }

    public final Single<HostelReceiptResponse> getHostelReceiptNewApiCall() {
        return this.apiHelper.getHostelReceiptNewApiCall();
    }

    public final Single<HostelNewPay> getHostelFeeNewPayApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiHelper.getHostelFeeNewPayApiCall(feeCollection, feeReceipt);
    }

    public final Single<HostelStatusNew> getHostelStatusNewApiCall() {
        return this.apiHelper.getHostelStatusNewApiCall();
    }

    public final Single<HostelNewHistoryResponse> getHostelHistoryNewApiCall() {
        return this.apiHelper.getHostelHistoryNewApiCall();
    }
}