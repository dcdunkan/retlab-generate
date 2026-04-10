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

/* JADX INFO: compiled from: HostelRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    public final Single<SuccessResponse> getHostelApplyLeaveNewApiCall(String leaveType, String fromDate, String toDate, String fromDateTime, String toDateTime, String reason) {
        Intrinsics.checkNotNullParameter(leaveType, "leaveType");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(fromDateTime, "fromDateTime");
        Intrinsics.checkNotNullParameter(toDateTime, "toDateTime");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return this.apiHelper.getHostelApplyLeaveNewApiCall(leaveType, fromDate, toDate, fromDateTime, toDateTime, reason);
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

    public final Single<SuccessResponse> getHostelApproveLeaveParentApiCall(Map<String, String> approveDetails) {
        Intrinsics.checkNotNullParameter(approveDetails, "approveDetails");
        return this.apiHelper.getHostelApproveLeaveParentApiCall(approveDetails);
    }

    public final Single<SuccessResponse> getHostelRejectLeaveParentApiCall(Map<String, String> approveDetails) {
        Intrinsics.checkNotNullParameter(approveDetails, "approveDetails");
        return this.apiHelper.getHostelRejectLeaveParentApiCall(approveDetails);
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