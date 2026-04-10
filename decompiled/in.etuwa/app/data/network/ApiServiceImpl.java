package in.etuwa.app.data.network;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.itextpdf.kernel.xmp.PdfConst;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.activitypoint.ActivityPointResponse;
import in.etuwa.app.data.model.activitypoint.manage.ActivityBatchResponse;
import in.etuwa.app.data.model.assignment.AssignmentRequest;
import in.etuwa.app.data.model.assignment.AssignmentResponse;
import in.etuwa.app.data.model.attendance.AttendanceDayRequest;
import in.etuwa.app.data.model.attendance.AttendanceDayResponse;
import in.etuwa.app.data.model.attendance.AttendanceNewResponse;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.attendance.AttendanceRequestNew;
import in.etuwa.app.data.model.attendance.AttendanceResponse;
import in.etuwa.app.data.model.calendar.CalendarResponse;
import in.etuwa.app.data.model.centralizedinfo.CentralizedInfoResponse;
import in.etuwa.app.data.model.certificaterequest.CertificateRequestResponse;
import in.etuwa.app.data.model.certificaterequest.CertificateTypeResponse;
import in.etuwa.app.data.model.chat.comment.CommentResponse;
import in.etuwa.app.data.model.chat.reply.ReplyResponse;
import in.etuwa.app.data.model.chat.subjects.ChatResponse;
import in.etuwa.app.data.model.common.Circular;
import in.etuwa.app.data.model.common.Remarks;
import in.etuwa.app.data.model.common.TeacherResponse;
import in.etuwa.app.data.model.counselling.CounsellingResponse;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.counselling.type.CounsellingTypesResponse;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.dash.LibraryResponse;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.model.dash.PendingSurvey;
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.data.model.dash.daywisetimetaable.DayWiseResponse;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.due.duepay.NoDueCertificateResponse;
import in.etuwa.app.data.model.due.duepaynew.DuePayNewResponse;
import in.etuwa.app.data.model.exam.ModuleTestResponse;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
import in.etuwa.app.data.model.examregister.ExamReceiptResponse;
import in.etuwa.app.data.model.examregister.ExamRegisterResponse;
import in.etuwa.app.data.model.examregister.ExamUpdateResponse;
import in.etuwa.app.data.model.examregister.ExamViewResponse;
import in.etuwa.app.data.model.examregister.RegistrationSlipResponse;
import in.etuwa.app.data.model.examregister.RevaluationApplyResponse;
import in.etuwa.app.data.model.examregister.RevaluationReceiptResponse;
import in.etuwa.app.data.model.examregister.RevaluationResponse;
import in.etuwa.app.data.model.examregister.RevaluationStatusResponse;
import in.etuwa.app.data.model.examregister.RevaluationUpdateResponse;
import in.etuwa.app.data.model.examregister.RevaluationViewResponse;
import in.etuwa.app.data.model.examschedules.ExamScheduleResponse;
import in.etuwa.app.data.model.fee.FeeResponse;
import in.etuwa.app.data.model.fee.FeeSreeChitraUrl;
import in.etuwa.app.data.model.fee.FeeUrlResponse;
import in.etuwa.app.data.model.fee.GatewayDetailsResponse;
import in.etuwa.app.data.model.fee.feeheadgroups.FeeHeadGroupResponse;
import in.etuwa.app.data.model.fee.installment.InstallmentResponse;
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemesterResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerUrlResponse;
import in.etuwa.app.data.model.feemedical.FeesMedResponse;
import in.etuwa.app.data.model.feepartial.InstallmentDetailsResponse;
import in.etuwa.app.data.model.feepartial.InstallmentListResponse;
import in.etuwa.app.data.model.grievance.GrievanceResponse;
import in.etuwa.app.data.model.grievance.type.GrievanceTypeResponse;
import in.etuwa.app.data.model.grievance.view.ViewGrievanceResponse;
import in.etuwa.app.data.model.homework.HomeWorkResponse;
import in.etuwa.app.data.model.hostel.HostelFeePalaiResponse;
import in.etuwa.app.data.model.hostel.HostelFeeResponse;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmissionResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiTypesResponse;
import in.etuwa.app.data.model.hostel.HostelResponse;
import in.etuwa.app.data.model.hostel.asiet.HostelAsietRegisterViewResponse;
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
import in.etuwa.app.data.model.institutions.Institution;
import in.etuwa.app.data.model.internship.InternshipResponse;
import in.etuwa.app.data.model.internship.companylist.CompanyListResponse;
import in.etuwa.app.data.model.lab.Evaluation;
import in.etuwa.app.data.model.lab.LabDue;
import in.etuwa.app.data.model.lab.LabEquipRequest;
import in.etuwa.app.data.model.lab.LabEquipment;
import in.etuwa.app.data.model.lab.LabList;
import in.etuwa.app.data.model.lab.Practical;
import in.etuwa.app.data.model.lab.PracticalRequest;
import in.etuwa.app.data.model.leave.duty.DutyLeave;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDateResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDirectApplyResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveHeadResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveViewRequest;
import in.etuwa.app.data.model.leave.medical.MedicalLeave;
import in.etuwa.app.data.model.leavemanagement.LeaveManagementResponse;
import in.etuwa.app.data.model.library.BookRecordResponse;
import in.etuwa.app.data.model.library.BooksResponse;
import in.etuwa.app.data.model.live.LiveResponse;
import in.etuwa.app.data.model.login.LoginRequest;
import in.etuwa.app.data.model.login.LoginResponse;
import in.etuwa.app.data.model.login.LogoutRequest;
import in.etuwa.app.data.model.main.ApplyHostelResponse;
import in.etuwa.app.data.model.main.CourseSurveyPending;
import in.etuwa.app.data.model.main.FeeStatusResponse;
import in.etuwa.app.data.model.main.POSurveyPending;
import in.etuwa.app.data.model.main.PushRequest;
import in.etuwa.app.data.model.main.PushResponse;
import in.etuwa.app.data.model.main.SurveyMandatory;
import in.etuwa.app.data.model.main.SurveyPending;
import in.etuwa.app.data.model.materials.DownloadMaterialResponse;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.materials.Materials;
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.data.model.mess.MessMenuResponse;
import in.etuwa.app.data.model.mess.MessResponse;
import in.etuwa.app.data.model.mess.MessTypeResponse;
import in.etuwa.app.data.model.mess.OrderHistoryResponse;
import in.etuwa.app.data.model.message.Inbox;
import in.etuwa.app.data.model.message.MsgHandleRequest;
import in.etuwa.app.data.model.message.Outbox;
import in.etuwa.app.data.model.message.ReplyRequest;
import in.etuwa.app.data.model.noticeboard.NoticeJeccResponse;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.onlineclass.OnlineClassResponse;
import in.etuwa.app.data.model.placement.Placement;
import in.etuwa.app.data.model.placement.PlacementRequest;
import in.etuwa.app.data.model.profileasiet.achievements.AchievementsResponse;
import in.etuwa.app.data.model.profileasiet.coursesattended.CoursesAttendedResponse;
import in.etuwa.app.data.model.profileasiet.fundedresearch.FundedResearchResponse;
import in.etuwa.app.data.model.profileasiet.membership.MembershipResponse;
import in.etuwa.app.data.model.profileasiet.mooccourse.MoocCourseResponse;
import in.etuwa.app.data.model.profileasiet.positionheld.PositionHeldResponse;
import in.etuwa.app.data.model.profileasiet.projectwork.ProjectWorkResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationResponse;
import in.etuwa.app.data.model.profileasiet.qualifiedexamination.QualifiedExaminationResponse;
import in.etuwa.app.data.model.profileasiet.scholarships.ScholarshipsResponse;
import in.etuwa.app.data.model.profileasiet.sport.SportResponse;
import in.etuwa.app.data.model.programoutcome.ProgramOutcomeResponse;
import in.etuwa.app.data.model.quiz.QuestionsNewResponse;
import in.etuwa.app.data.model.quiz.file.QuizDeleteFile;
import in.etuwa.app.data.model.quiz.file.QuizFileUploadResponse;
import in.etuwa.app.data.model.quiz.list.QuizResponse;
import in.etuwa.app.data.model.quiz.questions.QuestionResponse;
import in.etuwa.app.data.model.quiz.result.QuizResultResponse;
import in.etuwa.app.data.model.quiz.submit.QuizFinishRequest;
import in.etuwa.app.data.model.quiz.submit.QuizSubmitResponse;
import in.etuwa.app.data.model.quiz.submit.SubmitRequest;
import in.etuwa.app.data.model.resetpassword.ResetPassword;
import in.etuwa.app.data.model.result.ResultAssignment;
import in.etuwa.app.data.model.result.ResultInternal;
import in.etuwa.app.data.model.result.ResultSeasonal;
import in.etuwa.app.data.model.result.SeasonRequest;
import in.etuwa.app.data.model.result.moduletest.ResultModuleTestResponse;
import in.etuwa.app.data.model.result.tutorial.TutorialResultResponse;
import in.etuwa.app.data.model.result.univ.UnivResponse;
import in.etuwa.app.data.model.semregistration.AcademicYearResponse;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.model.semregistration.list.SemRegisterListResponse;
import in.etuwa.app.data.model.semregistration.view.SemRegSlip;
import in.etuwa.app.data.model.stationary.AdvancePaymentResponse;
import in.etuwa.app.data.model.stationary.StationaryItemResponse;
import in.etuwa.app.data.model.stationary.StationaryReceiptResponse;
import in.etuwa.app.data.model.store.StoreResponse;
import in.etuwa.app.data.model.store.departmentlist.DepartmentListResponse;
import in.etuwa.app.data.model.subject.Subjects;
import in.etuwa.app.data.model.subject.co.CoModel;
import in.etuwa.app.data.model.subject.co.CoSyllabusRequest;
import in.etuwa.app.data.model.subject.coverage.SubCoverageResponse;
import in.etuwa.app.data.model.subject.syllabus.SyllabusResponse;
import in.etuwa.app.data.model.subjectregistration.SubjectRegistrationResponse;
import in.etuwa.app.data.model.subjectregistration.SubjectSpinnerResponse;
import in.etuwa.app.data.model.subjectregistration.SubjectsListResponse;
import in.etuwa.app.data.model.subjectregistration.ViewSubjectRegistrationResponse;
import in.etuwa.app.data.model.survey.GenSurveyQuestionRequest;
import in.etuwa.app.data.model.survey.SubmitResponse;
import in.etuwa.app.data.model.survey.Survey;
import in.etuwa.app.data.model.survey.SurveyQuestion;
import in.etuwa.app.data.model.survey.SurveyRequest;
import in.etuwa.app.data.model.survey.TeacherList;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyQuestionsResponse;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyResponse;
import in.etuwa.app.data.model.survey.courseevaluation.DoCourseSurveyResponse;
import in.etuwa.app.data.model.survey.graduateexit.DoGraduateSurveyResponse;
import in.etuwa.app.data.model.survey.graduateexit.GraduateExitSurveyListResponse;
import in.etuwa.app.data.model.survey.posurvey.POSurveyResponse;
import in.etuwa.app.data.model.survey.posurvey.PoQuestionsResponse;
import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.model.timetable.change.ChangeTimeTableResponse;
import in.etuwa.app.data.model.timetable.special.SpecialResponse;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportHistoryResponse;
import in.etuwa.app.data.model.transport.TransportPayUrl;
import in.etuwa.app.data.model.transportpalai.BusPass;
import in.etuwa.app.data.model.transportpalai.registration.RegisterSucessResponse;
import in.etuwa.app.data.model.transportpalai.registration.RegisterViewResponse;
import in.etuwa.app.data.model.tutorial.TutorialResponse;
import in.etuwa.app.data.model.university.UniversityResultResponse;
import in.etuwa.app.data.model.updateprofile.UpdateProfile;
import in.etuwa.app.data.model.video.VideoResponse;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.bouncycastle.i18n.ErrorBundle;
import retrofit2.Response;

/* compiled from: ApiServiceImpl.kt */
/* loaded from: classes3.dex */
public final class ApiServiceImpl implements ApiService {
    @Override // in.etuwa.app.data.network.ApiService
    public Single<Institution> getInstitutionsApiCall() {
        return ApiClient.INSTANCE.getInstance().getInstitutionsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<Institution> getDebugInstitutionsApiCall() {
        return ApiClient.INSTANCE.getInstance().getDebugInstitutionsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<LoginResponse> doLoginApiCall(LoginRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().doLoginApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> doLogoutApiCall(LogoutRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().doLogoutApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateBankDetailsApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return ApiClient.INSTANCE.getInstance().updateBankDetailsApiCall(studentDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> verifyBankDetailsApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return ApiClient.INSTANCE.getInstance().verifyBankDetailsApiCall(studentDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PushResponse> sendPushTokenApiCall(PushRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().sendPushTokenApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Semester>> getSemestersApiCall() {
        return ApiClient.INSTANCE.getInstance().getSemestersApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CalendarResponse> getCalendarEventApiCall() {
        return ApiClient.INSTANCE.getInstance().getCalendarEventApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Inbox>> getInboxApiCall() {
        return ApiClient.INSTANCE.getInstance().getInboxApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> readMsgApiCall(MsgHandleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().readMsgApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Outbox>> getOutboxApiCall() {
        return ApiClient.INSTANCE.getInstance().getOutboxApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> composeMsgApiCall(ReplyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().composeMsgApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getDeleteMsgApiCall(MsgHandleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getDeleteMsgApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DashResponse> getDashApiCall() {
        return ApiClient.INSTANCE.getInstance().getDashApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ProfileResponse> getProfileApiCall() {
        return ApiClient.INSTANCE.getInstance().getProfileApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TimetableResponse> getTimetableApiCall() {
        return ApiClient.INSTANCE.getInstance().getTimetableApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<ChangeTimeTableResponse>> getChangeInTimetableApiCall() {
        return ApiClient.INSTANCE.getInstance().getChangeInTimetableApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<SpecialResponse>> getSpecialClassApiCall() {
        return ApiClient.INSTANCE.getInstance().getSpecialClassApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<NoticeResponse> getNoticeClassApiCall() {
        return ApiClient.INSTANCE.getInstance().getNoticeClassApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<NoticeJeccResponse> getNoticeClassJeccApiCall() {
        return ApiClient.INSTANCE.getInstance().getNoticeClassJeccApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Remarks>> getRemarksApiCall() {
        return ApiClient.INSTANCE.getInstance().getRemarksApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamScheduleResponse> getExamsApiCall() {
        return ApiClient.INSTANCE.getInstance().getExamsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Circular>> getCircularsApiCall() {
        return ApiClient.INSTANCE.getInstance().getCircularsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Placement>> getPlacementsApiCall() {
        return ApiClient.INSTANCE.getInstance().getPlacementsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> applyPlacementsApiCall(PlacementRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().applyPlacementsApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Subjects>> getSubjectsApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getSubjectsApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SyllabusResponse> getSyllabusApiCall(CoSyllabusRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getSyllabusApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<CoModel>> getCourseOutcomeApiCall(CoSyllabusRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getCourseOutcomeApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TeacherResponse> getTeacherApiCall() {
        return ApiClient.INSTANCE.getInstance().getTeacherApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<OnlineClassResponse> getOnlineClassApiCall() {
        return ApiClient.INSTANCE.getInstance().getOnlineClassApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<VideoResponse> getVideoClassApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getVideoClassApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getWatchVideoApiCall(String videoId, String youtubeId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(youtubeId, "youtubeId");
        return ApiClient.INSTANCE.getInstance().getWatchVideoApiCall(videoId, youtubeId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AttendanceResponse> getAttendanceBySubjectApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getAttendanceBySubjectApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AttendanceNewResponse> getAttendanceByDayNewApiCall(AttendanceRequestNew request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getAttendanceByDayNewApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AttendanceDayResponse> getAttendanceByDayApiCall(AttendanceDayRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getAttendanceByDayApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<LabDue>> getLabDueApiCall() {
        return ApiClient.INSTANCE.getInstance().getLabDueApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<LabList>> getLabListApiCall() {
        return ApiClient.INSTANCE.getInstance().getLabListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<LabEquipment>> getEquipmentsApiCall(LabEquipRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getEquipmentsApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<String>> getSafetyApiCall(LabEquipRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getSafetyApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Practical>> getPracticalsApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getPracticalsApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<String>> getExperimentApiCall(PracticalRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getExperimentApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Evaluation>> getEvaluationApiCall(PracticalRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getEvaluationApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ChatResponse> getChatSubjectsApiCall() {
        return ApiClient.INSTANCE.getInstance().getChatSubjectsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CommentResponse> getCommentsApiCall(String subId, String chat) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        return ApiClient.INSTANCE.getInstance().getCommentsApiCall(subId, chat);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> setCommentsApiCall(String subId, String batchId, String semId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        return ApiClient.INSTANCE.getInstance().setCommentsApiCall(subId, batchId, semId, comment);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CommentResponse> getParentCommentsApiCall(String batchId, String chat) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        return ApiClient.INSTANCE.getInstance().getParentCommentsApiCall(batchId, chat);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> setParentCommentsApiCall(String batchId, String semId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        return ApiClient.INSTANCE.getInstance().setParentCommentsApiCall(batchId, semId, comment);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ReplyResponse> getReplyApiCall(String subId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return ApiClient.INSTANCE.getInstance().getReplyApiCall(subId, commentId, reply);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> setReplyApiCall(String subId, String batchId, String semId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return ApiClient.INSTANCE.getInstance().setReplyApiCall(subId, batchId, semId, commentId, reply);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ReplyResponse> getParentReplyApiCall(String batchId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return ApiClient.INSTANCE.getInstance().getParentReplyApiCall(batchId, commentId, reply);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> setParentReplyApiCall(String batchId, String semId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return ApiClient.INSTANCE.getInstance().setParentReplyApiCall(batchId, semId, commentId, reply);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Survey>> getSurveyApiCall() {
        return ApiClient.INSTANCE.getInstance().getSurveyApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<SurveyQuestion>> getGenSurveyQuestionApiCall(GenSurveyQuestionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getGenSurveyQuestionApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SubmitResponse> submitGenSurveyApiCall(String surveyId, String remark, Map<String, String> option) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(option, "option");
        return ApiClient.INSTANCE.getInstance().submitGenSurveyApiCall(surveyId, remark, option);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<TeacherList>> getSurveyTeachersApiCall(GenSurveyQuestionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getSurveyTeachersApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<SurveyQuestion>> getSurveyQuestionApiCall(SurveyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getSurveyQuestionApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SubmitResponse> submitSurveyApiCall(String surveyId, String teacherId, String subjectId, String remark, String specialRemark, Map<String, String> option) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(specialRemark, "specialRemark");
        Intrinsics.checkNotNullParameter(option, "option");
        return ApiClient.INSTANCE.getInstance().submitSurveyApiCall(surveyId, teacherId, subjectId, remark, specialRemark, option);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ApplyHostelResponse> applyHostelApiCall() {
        return ApiClient.INSTANCE.getInstance().applyHostelApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeStatusResponse> getFeeStatusApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeeStatusApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<ResultAssignment>> getResultAssignmentApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getResultAssignmentApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<ResultSeasonal>> getResultSeasonalApiCall(SeasonRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getResultSeasonalApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ResultModuleTestResponse> getResultModuleTestApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getResultModuleTestApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TutorialResultResponse> getTutorialResultApiCall(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        return ApiClient.INSTANCE.getInstance().getTutorialResultApiCall(semId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<ResultInternal>> getResultInternalApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getResultInternalApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<UnivResponse> getResultUnivApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getResultUnivApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<MedicalLeave>> getMedicalLeaveApiCall() {
        return ApiClient.INSTANCE.getInstance().getMedicalLeaveApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<DutyLeave>> getDutyLeaveApiCall(DutyLeaveViewRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getDutyLeaveApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<MaterialsNew>> getStudyMaterialsApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getStudyMaterialsApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ArrayList<Materials>> getQuestionBankApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getQuestionBankApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SeriesExamResponse> getSeriesExamApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getSeriesExamApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ModuleTestResponse> getModuleTestApiCall(String r2) {
        Intrinsics.checkNotNullParameter(r2, "new");
        return ApiClient.INSTANCE.getInstance().getModuleTestApiCall(r2);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AssignmentResponse> getAssignmentApiCall(AssignmentRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().getAssignmentApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteAssignmentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteAssignmentApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteSeriesExamApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteSeriesExamApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteModuleTestApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteModuleTestApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> uploadAssignmentApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().uploadAssignmentApiCall(username, password, id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> uploadSeriesExamApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().uploadSeriesExamApiCall(username, password, id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> uploadModuleTestApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().uploadModuleTestApiCall(username, password, id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SemRegViewResponse> getSemRegDetailsApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().getSemRegDetailsApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SemRegViewResponse> getSemRegDetailsMvjceApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().getSemRegDetailsMvjceApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SemRegSuccessResponse> semRegisterApiCall(HashMap<String, RequestBody> partMap, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return ApiClient.INSTANCE.getInstance().semRegisterApiCall(partMap, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SemRegSuccessResponse> semRegisterApiCall(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        return ApiClient.INSTANCE.getInstance().semRegisterApiCall(semesterRegistration);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SemRegSuccessResponse> updateSemRegisterApiCall(RequestBody id, HashMap<String, RequestBody> partMap, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return ApiClient.INSTANCE.getInstance().updateSemRegisterApiCall(id, partMap, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SemRegSuccessResponse> updateSemRegisterApiCall(String id, Map<String, String> partMap) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return ApiClient.INSTANCE.getInstance().updateSemRegisterApiCall(id, partMap);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SemRegisterListResponse> getSemRegListApiCall() {
        return ApiClient.INSTANCE.getInstance().getSemRegListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CentralizedInfoResponse> getCentralizedInfoApiCall() {
        return ApiClient.INSTANCE.getInstance().getCentralizedInfoApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TutorialResponse> getTutorialsApiCall() {
        return ApiClient.INSTANCE.getInstance().getTutorialsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteTutorialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteTutorialApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> submitTutorialApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().submitTutorialApiCall(id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HomeWorkResponse> getHomeWorksApiCall() {
        return ApiClient.INSTANCE.getInstance().getHomeWorksApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteHomeWorkApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteHomeWorkApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> submitHomeWorkApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().submitHomeWorkApiCall(id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<InstallmentResponse> getFeeInstallmentsApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeeInstallmentsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeResponse> getFeesApiCall(String installment) {
        return ApiClient.INSTANCE.getInstance().getFeesApiCall(installment);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeUrlResponse> submitFeesApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return ApiClient.INSTANCE.getInstance().submitFeesApiCall(feeCollection, feeReceipt);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeUrlResponse> payFeesApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return ApiClient.INSTANCE.getInstance().payFeesApiCall(feeCollection, feeReceipt);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeSreeChitraUrl> payFeesSreeChitraApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt, Map<String, String> transaction, String payment, String installment) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(payment, "payment");
        Intrinsics.checkNotNullParameter(installment, "installment");
        return ApiClient.INSTANCE.getInstance().payFeesSreeChitraApiCall(feeCollection, feeReceipt, transaction, payment, installment);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ReceiptResponse> getFeeReceiptsApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeeReceiptsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ReceiptResponse> getTransportFeeReceiptsApiCall() {
        return ApiClient.INSTANCE.getInstance().getTransportFeeReceiptsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeHeadGroupResponse> getFeeHeadApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeeHeadApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<LiveResponse> getLiveTvApiCall() {
        return ApiClient.INSTANCE.getInstance().getLiveTvApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DuePayNewResponse> getDuesApiCall() {
        return ApiClient.INSTANCE.getInstance().getDuesApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizResponse> getQuizListApiCall() {
        return ApiClient.INSTANCE.getInstance().getQuizListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuestionResponse> getQuizQuestionsApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().getQuizQuestionsApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizSubmitResponse> submitQuizAnswersApiCall(String id, SubmitRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().submitQuizAnswersApiCall(id, request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizSubmitResponse> finishQuizAnswersApiCall(String id, QuizFinishRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().finishQuizAnswersApiCall(id, request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<ArrayList<QuizFileUploadResponse>> uploadQuizApiCall(String id, MultipartBody.Part file) {
        return ApiClient.INSTANCE.getInstance().uploadQuizApiCall(id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteQuizFileApiCall(QuizDeleteFile request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return ApiClient.INSTANCE.getInstance().deleteQuizFileApiCall(request);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizResultResponse> quizResultApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().quizResultApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizResultResponse> quizResultNewApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().quizResultNewApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> quizSaveStatusApiCall(String sessionId, String qId) {
        return ApiClient.INSTANCE.getInstance().quizSaveStatusApiCall(sessionId, qId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ActivityPointResponse> getActivityPointApiCall() {
        return ApiClient.INSTANCE.getInstance().getActivityPointApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ActivityBatchResponse> getManageActivityApiCall() {
        return ApiClient.INSTANCE.getInstance().getManageActivityApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> requestActivityApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().requestActivityApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> requestActivityApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().requestActivityApiCall(id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteRequestActivityApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().deleteRequestActivityApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SubCoverageResponse> getSubjectCoverageApiCall(String subId, String batchId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return ApiClient.INSTANCE.getInstance().getSubjectCoverageApiCall(subId, batchId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<GrievanceResponse> getGrievanceApiCall() {
        return ApiClient.INSTANCE.getInstance().getGrievanceApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<GrievanceTypeResponse> getGrievanceTypeApiCall() {
        return ApiClient.INSTANCE.getInstance().getGrievanceTypeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ViewGrievanceResponse> viewGrievanceApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().viewGrievanceApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> addGrievanceApiCall(HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return ApiClient.INSTANCE.getInstance().addGrievanceApiCall(partMap, images);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> updateGrievanceApiCall(RequestBody id, HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return ApiClient.INSTANCE.getInstance().updateGrievanceApiCall(id, partMap, images);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteGrievanceApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().deleteGrievanceApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> remindGrievanceApiCall(String id, String description) {
        return ApiClient.INSTANCE.getInstance().remindGrievanceApiCall(id, description);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> reopenGrievanceApiCall(HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return ApiClient.INSTANCE.getInstance().reopenGrievanceApiCall(partMap, images);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> updateProPicApiCall(MultipartBody.Part file, MultipartBody.Part sign) {
        return ApiClient.INSTANCE.getInstance().updateProPicApiCall(file, sign);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CertificateRequestResponse> getCertificateRequestApiCall() {
        return ApiClient.INSTANCE.getInstance().getCertificateRequestApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CertificateTypeResponse> getCertificateTypeRequestApiCall() {
        return ApiClient.INSTANCE.getInstance().getCertificateTypeRequestApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> applyCertificateApiCall(Map<String, String> certificateCollection) {
        Intrinsics.checkNotNullParameter(certificateCollection, "certificateCollection");
        return ApiClient.INSTANCE.getInstance().applyCertificateApiCall(certificateCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> applyCertificateApiCall(String certificate, String reason) {
        return ApiClient.INSTANCE.getInstance().applyCertificateApiCall(certificate, reason);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> applyCertificateApiCall(RequestBody certificate, RequestBody reason, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return ApiClient.INSTANCE.getInstance().applyCertificateApiCall(certificate, reason, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> uploadCovidCertificateApiCall(MultipartBody.Part vaccineFile) {
        return ApiClient.INSTANCE.getInstance().uploadCovidCertificateApiCall(vaccineFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> uploadCovidCertificateTwoApiCall(MultipartBody.Part vaccineFileTwo) {
        return ApiClient.INSTANCE.getInstance().uploadCovidCertificateTwoApiCall(vaccineFileTwo);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<Response<ResetPassword>> getResetPasswordApiCall() {
        return ApiClient.INSTANCE.getInstance().getResetPasswordApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ResetPassword> getRegistrationApiCall() {
        return ApiClient.INSTANCE.getInstance().getRegistrationApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CounsellingResponse> getCouncellingRequestApiCall() {
        return ApiClient.INSTANCE.getInstance().getCouncellingRequestApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ViewCounsellingResponse> viewCounsellingApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().viewCounsellingApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteCounsellingApiCall(String id) {
        return ApiClient.INSTANCE.getInstance().deleteCounsellingApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> updateCounsellingApiCall(RequestBody id, HashMap<String, RequestBody> partMap) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return ApiClient.INSTANCE.getInstance().updateCounsellingApiCall(id, partMap);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> addCounsellingApiCall(HashMap<String, RequestBody> partMap) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return ApiClient.INSTANCE.getInstance().addCounsellingApiCall(partMap);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CounsellingTypesResponse> getCounsellingTypeApiCall() {
        return ApiClient.INSTANCE.getInstance().getCounsellingTypeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CounsellingStatusResponse> getCounsellingStatusApiCall() {
        return ApiClient.INSTANCE.getInstance().getCounsellingStatusApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> remindCounsellingApiCall(String id, String description) {
        return ApiClient.INSTANCE.getInstance().remindCounsellingApiCall(id, description);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> reviewCounsellingApiCall(String id, String description) {
        return ApiClient.INSTANCE.getInstance().reviewCounsellingApiCall(id, description);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> reopenCounsellingApiCall(String id, String type, String concern, String home, String studies, String relationship, String physical, String history, String session, String comments) {
        return ApiClient.INSTANCE.getInstance().reopenCounsellingApiCall(id, type, concern, home, studies, relationship, physical, history, session, comments);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<InternshipResponse> getInternshipRequestApiCall() {
        return ApiClient.INSTANCE.getInstance().getInternshipRequestApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> applyInternshipApiCall(String name, String fromDate, String toDate) {
        return ApiClient.INSTANCE.getInstance().applyInternshipApiCall(name, fromDate, toDate);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> uploadInternshipApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().uploadInternshipApiCall(id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CompanyListResponse> getCompanyListApiCall() {
        return ApiClient.INSTANCE.getInstance().getCompanyListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addCompanyApiCall(String name, String address) {
        return ApiClient.INSTANCE.getInstance().addCompanyApiCall(name, address);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> applyMedicalLeaveApiCall(RequestBody reason, RequestBody fromDate, RequestBody toDate, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().applyMedicalLeaveApiCall(reason, fromDate, toDate, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> applyDutyLeaveApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().applyDutyLeaveApiCall(id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelResponse> getHostelApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelFeeResponse> getHostelFeeConfirmApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return ApiClient.INSTANCE.getInstance().getHostelFeeConfirmApiCall(feeCollection, feeReceipt);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelFeePalaiResponse> getHostelFeeConfirmPalaiApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return ApiClient.INSTANCE.getInstance().getHostelFeeConfirmPalaiApiCall(feeCollection, feeReceipt);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelMonthResponse> getHostelTkmApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelTkmApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelReceiptResponse> getHostelReceiptTkmApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelReceiptTkmApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DuePayNewResponse> getDuePay() {
        return ApiClient.INSTANCE.getInstance().getDuePay();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DuePayUrl> getDuePayUrlApiCall(Map<String, String> dueFeeCollection, Map<String, String> dueFeeReceipt) {
        Intrinsics.checkNotNullParameter(dueFeeCollection, "dueFeeCollection");
        Intrinsics.checkNotNullParameter(dueFeeReceipt, "dueFeeReceipt");
        return ApiClient.INSTANCE.getInstance().getDuePayUrlApiCall(dueFeeCollection, dueFeeReceipt);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<StoreResponse> getStoreDataApiCall(String subjectId) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        return ApiClientStore.INSTANCE.getInstance().getStoreDataApiCall(subjectId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeEngineerResponse> getFeeEngineerApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeeEngineerApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeEngineerResponse> getFeeKmeaEngineerApiCall(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return ApiClient.INSTANCE.getInstance().getFeeKmeaEngineerApiCall(batchId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DepartmentListResponse> getDepartmentApiCall() {
        return ApiClientStore.INSTANCE.getInstance().getDepartmentApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DepartmentListResponse> getSemesterListApiCall(String id) {
        return ApiClientStore.INSTANCE.getInstance().getSemesterListApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DepartmentListResponse> getSubjectListApiCall(String dept_id, String sem_id) {
        return ApiClientStore.INSTANCE.getInstance().getSubjectListApiCall(dept_id, sem_id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DepartmentListResponse> getCategoryApiCall() {
        return ApiClientStore.INSTANCE.getInstance().getCategoryApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ProgramOutcomeResponse> getProgramOutcomeApiCall() {
        return ApiClient.INSTANCE.getInstance().getProgramOutcomeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeEngineerUrlResponse> getEngineerFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return ApiClient.INSTANCE.getInstance().getEngineerFeePayUrlApiCall(FeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getMedicalFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return ApiClient.INSTANCE.getInstance().getMedicalFeePayUrlApiCall(FeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeArtsResponse> getFeeArtsApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeeArtsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeArtsResponse> getFeeArtsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getFeeArtsApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeArtsUrlResponse> getArtsFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return ApiClient.INSTANCE.getInstance().getArtsFeePayUrlApiCall(FeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<NoDueCertificateResponse> getNoDueCertificate() {
        return ApiClient.INSTANCE.getInstance().getNoDueCertificate();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RegistrationResponse> getHostelRegistrationData() {
        return ApiClient.INSTANCE.getInstance().getHostelRegistrationData();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> newHostelRegistrationApiCall(RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        return ApiClient.INSTANCE.getInstance().newHostelRegistrationApiCall(reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CategoryTypeResponse> getCategoryTypeApiCall() {
        return ApiClient.INSTANCE.getInstance().getCategoryTypeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PresentHostelResponse> getPresentHostelApiCall() {
        return ApiClient.INSTANCE.getInstance().getPresentHostelApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> newHostelReRegistrationApiCall(RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile, RequestBody hostelId, RequestBody yearCount, RequestBody hostelDetails, RequestBody isFined, RequestBody fineDetails, RequestBody feeDefaulter, RequestBody feeDetails) {
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
        return ApiClient.INSTANCE.getInstance().newHostelReRegistrationApiCall(reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile, hostelId, yearCount, hostelDetails, isFined, fineDetails, feeDefaulter, feeDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Observable<SuccessResponse> updateHostelRegistrationApiCall(RequestBody id, RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        return ApiClient.INSTANCE.getInstance().updateHostelRegistrationApiCall(id, reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ViewRegistrationResponse> viewRegistrationApiCall(RequestBody id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().viewRegistrationApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<LeaveManagementResponse> getLeaveManagementApiCall() {
        return ApiClientLeave.INSTANCE.getInstance().getLeaveManagementApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<LibraryResponse> getDigitalLibraryApiCall() {
        return ApiClient.INSTANCE.getInstance().getDigitalLibraryApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getChangePasswordApiCall(String oldPassword, String newPassword, String newPasswordRepeat) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(newPasswordRepeat, "newPasswordRepeat");
        return ApiClient.INSTANCE.getInstance().getChangePasswordApiCall(oldPassword, newPassword, newPasswordRepeat);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamRegisterResponse> getExamRegisterDataApiCall() {
        return ApiClient.INSTANCE.getInstance().getExamRegisterDataApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamCourseResponse> getExamCourseApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamCourseApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamPayResponse> getExamPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return ApiClient.INSTANCE.getInstance().getExamPayUrlApiCall(FeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamViewResponse> getExamViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamViewApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamUpdateResponse> getExamUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamUpdateApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RegistrationSlipResponse> getRegistrationSlipApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getRegistrationSlipApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamReceiptResponse> getExamReceiptApiCall() {
        return ApiClient.INSTANCE.getInstance().getExamReceiptApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamMessageResponse> getPioPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return ApiClient.INSTANCE.getInstance().getPioPayUrlApiCall(FeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ExamMessageResponse> getScStPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return ApiClient.INSTANCE.getInstance().getScStPayUrlApiCall(FeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AcademicYearResponse> getSemRegDropListApiCall() {
        return ApiClient.INSTANCE.getInstance().getSemRegDropListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> registerSemsterNewApiCall(Map<String, String> SemRegistration) {
        Intrinsics.checkNotNullParameter(SemRegistration, "SemRegistration");
        return ApiClient.INSTANCE.getInstance().registerSemsterNewApiCall(SemRegistration);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<UniversityResultResponse> getExamResult(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamResult(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationResponse> getExamRevaluationApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationApplyResponse> getExamRevaluationConfirmApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationConfirmApiCall(revaluationCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationApplyResponse> getExamRevaluationConfirmUpdateApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationConfirmUpdateApiCall(revaluationCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DuePayUrl> getExamRevaluationPayApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationPayApiCall(revaluationCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DuePayUrl> getExamRevaluationUpdatePayApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationUpdatePayApiCall(revaluationCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationViewResponse> getExamRevaluationViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationViewApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationReceiptResponse> getExamRevaluationReceiptApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationReceiptApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationStatusResponse> getExamRevaluationStatusApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationStatusApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RevaluationUpdateResponse> getExamRevaluationUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getExamRevaluationUpdateApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MessResponse> getHostelMessApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelMessApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<OrderHistoryResponse> getMessOrderHistoryApiCall() {
        return ApiClient.INSTANCE.getInstance().getMessOrderHistoryApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> cancelMessOrderApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().cancelMessOrderApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> messBookingApiCall(String type, String menu, String qty) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(qty, "qty");
        return ApiClient.INSTANCE.getInstance().messBookingApiCall(type, menu, qty);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MessMenuResponse> getMessMenuApiCall() {
        return ApiClient.INSTANCE.getInstance().getMessMenuApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MessTypeResponse> getMessTypeApiCall() {
        return ApiClient.INSTANCE.getInstance().getMessTypeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MessMenuResponse> getMessTypeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getMessTypeApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TransportFeeResponse> getTransportFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getTransportFeeApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TransportFeeResponse> getTransportFeeApiCall() {
        return ApiClient.INSTANCE.getInstance().getTransportFeeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TransportPayUrl> getTransportFeeUrlApiCall(Map<String, String> transportFeeCollection) {
        Intrinsics.checkNotNullParameter(transportFeeCollection, "transportFeeCollection");
        return ApiClient.INSTANCE.getInstance().getTransportFeeUrlApiCall(transportFeeCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AbcResponse> getAbcViewApiCall() {
        return ApiClient.INSTANCE.getInstance().getAbcViewApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getAbcUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getAbcUpdateApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> verifyAbcIdApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().verifyAbcIdApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelPalaiAdmissionResponse> getPalaiHostelAdmsnApiCall() {
        return ApiClient.INSTANCE.getInstance().getPalaiHostelAdmsnApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelPartialAdmission> getPalaiHostelPartialAdmsnApiCall() {
        return ApiClient.INSTANCE.getInstance().getPalaiHostelPartialAdmsnApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelPalaiTypesResponse> getHostelFeeTypesApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelFeeTypesApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<BooksResponse> getLibraryBooksApiCall() {
        return ApiClient.INSTANCE.getInstance().getLibraryBooksApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<BookRecordResponse> getLibraryBookRecordApiCall() {
        return ApiClient.INSTANCE.getInstance().getLibraryBookRecordApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> suggestBookApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return ApiClient.INSTANCE.getInstance().suggestBookApiCall(studentDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<GatewayDetailsResponse> getGatewayDetailsApiCall() {
        return ApiClient.INSTANCE.getInstance().getGatewayDetailsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RegisterViewResponse> getRegisterViewApiCall() {
        return ApiClient.INSTANCE.getInstance().getRegisterViewApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RegisterSucessResponse> addTransRegApiCall(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().addTransRegApiCall(id, date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<RegisterSucessResponse> addAsietTransRegApiCall(String id, String exactPoint, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exactPoint, "exactPoint");
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().addAsietTransRegApiCall(id, exactPoint, date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TransportFeeResponse> getTransFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getTransFeeApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<BusPass> getTransportBusPassApiCall() {
        return ApiClient.INSTANCE.getInstance().getTransportBusPassApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<UpdateProfile> getUpdateProfileApiCall() {
        return ApiClient.INSTANCE.getInstance().getUpdateProfileApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeesMedResponse> getFeesMedicalApiCall() {
        return ApiClient.INSTANCE.getInstance().getFeesMedicalApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DutyLeaveDirectApplyResponse> getDutyLeaveDirectViewApiCall() {
        return ApiClient.INSTANCE.getInstance().getDutyLeaveDirectViewApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteDutyLeaveDirectViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteDutyLeaveDirectViewApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> applyDutyLeaveDirectViewApiCall(RequestBody reason, RequestBody headId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(headId, "headId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().applyDutyLeaveDirectViewApiCall(reason, headId, fromDate, toDate, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateDutyLeaveDirectViewApiCall(RequestBody id, RequestBody reason, RequestBody headId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(headId, "headId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().updateDutyLeaveDirectViewApiCall(id, reason, headId, fromDate, toDate, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DutyLeaveHeadResponse> getDutyLeaveDirectHeadApiCall() {
        return ApiClient.INSTANCE.getInstance().getDutyLeaveDirectHeadApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DutyLeaveDateResponse> getDutyLeaveDirectDatesApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getDutyLeaveDirectDatesApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> removeDateHourDutyLeaveDirectDatesApiCall(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().removeDateHourDutyLeaveDirectDatesApiCall(id, date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addDutyLeaveDirectDatesApiCall(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        return ApiClient.INSTANCE.getInstance().addDutyLeaveDirectDatesApiCall(id, date, hour);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> removeDutyLeaveDirectDatesApiCall(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        return ApiClient.INSTANCE.getInstance().removeDutyLeaveDirectDatesApiCall(id, date, hour);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<InstallmentListResponse> getPartialInstallmentListApiCall() {
        return ApiClient.INSTANCE.getInstance().getPartialInstallmentListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<InstallmentDetailsResponse> getPartialInstallmentFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getPartialInstallmentFeeApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelAttViewResponse> getHostelViewLeaveApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelViewLeaveApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<LeaveTypeResponse> getHostelLeaveTypeApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelLeaveTypeApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getHostelApplyLeaveApiCall(String leaveType, String fromDate, String toDate, String reason) {
        Intrinsics.checkNotNullParameter(leaveType, "leaveType");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return ApiClient.INSTANCE.getInstance().getHostelApplyLeaveApiCall(leaveType, fromDate, toDate, reason);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelAttParentViewResponse> getHostelLeaveViewParentApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().getHostelLeaveViewParentApiCall(date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelAttParentViewResponse> getHostelLeaveViewParentApproveApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().getHostelLeaveViewParentApproveApiCall(date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelAttParentViewResponse> getHostelLeaveViewParentRejectApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().getHostelLeaveViewParentRejectApiCall(date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getHostelRevokeLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getHostelRevokeLeaveParentApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getHostelDeleteLeaveApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getHostelDeleteLeaveApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getHostelApproveLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getHostelApproveLeaveParentApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> getHostelRejectLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getHostelRejectLeaveParentApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelAttCalResponse> getHostelAttCalApiCall(String month, String year) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        return ApiClient.INSTANCE.getInstance().getHostelAttCalApiCall(month, year);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FeeArtsSemesterResponse> getFeeArtsSemList() {
        return ApiClient.INSTANCE.getInstance().getFeeArtsSemList();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelScanViewResponse> getHostelGatePassApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getHostelGatePassApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> checkExitApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().checkExitApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> checkAlreadyExitApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().checkAlreadyExitApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DownloadMaterialResponse> downloadMaterialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().downloadMaterialApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CourseSurveyResponse> getCourseSurveyList() {
        return ApiClient.INSTANCE.getInstance().getCourseSurveyList();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DoCourseSurveyResponse> getDoCourseSurveyList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getDoCourseSurveyList(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CourseSurveyQuestionsResponse> getDoCourseSurveyQuestionList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getDoCourseSurveyQuestionList(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> postCourseSurveyAnswer(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        return ApiClient.INSTANCE.getInstance().postCourseSurveyAnswer(answerCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DayWiseResponse> getDayWiseTimeTable(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return ApiClient.INSTANCE.getInstance().getDayWiseTimeTable(date);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MaintenanceResponse> getMaintenanceUrl() {
        return ApiClient.INSTANCE.getInstance().getMaintenanceUrl();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<POSurveyResponse> getPoSurveyUrl() {
        return ApiClient.INSTANCE.getInstance().getPoSurveyUrl();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PoQuestionsResponse> getPoQuestionsUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getPoQuestionsUrl(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> poAnswerSubmit(Map<String, String> answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        return ApiClient.INSTANCE.getInstance().poAnswerSubmit(answerDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PendingSurvey> getPendingSurveyUrl() {
        return ApiClient.INSTANCE.getInstance().getPendingSurveyUrl();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SemRegSlip> getRegistrationSlipUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getRegistrationSlipUrl(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MitsFeePay> getMitsFeePayUrl() {
        return ApiClient.INSTANCE.getInstance().getMitsFeePayUrl();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelAsietRegisterViewResponse> getAsietTransportRegistrationUrl() {
        return ApiClient.INSTANCE.getInstance().getAsietTransportRegistrationUrl();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuestionsNewResponse> getNewQuizQuestionsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getNewQuizQuestionsApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizSubmitResponse> newQuizAnswerSubmit(Map<String, String> answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        return ApiClient.INSTANCE.getInstance().newQuizAnswerSubmit(answerDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizSubmitResponse> newQuizAnswerUploadSubmit(RequestBody qNo, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().newQuizAnswerUploadSubmit(qNo, id, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QuizSubmitResponse> newQuizAnswerUploadFinalSubmit(RequestBody qNo, RequestBody id, RequestBody finalSubmit, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(finalSubmit, "finalSubmit");
        return ApiClient.INSTANCE.getInstance().newQuizAnswerUploadFinalSubmit(qNo, id, finalSubmit, file);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<GraduateExitSurveyListResponse> getGraduateSurveyListApiCall() {
        return ApiClient.INSTANCE.getInstance().getGraduateSurveyListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<DoGraduateSurveyResponse> getGraduateSurveyQuestionsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getGraduateSurveyQuestionsApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> postGESurveyAnswer(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        return ApiClient.INSTANCE.getInstance().postGESurveyAnswer(answerCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<StationaryItemResponse> getStationaryListApiCall() {
        return ApiClient.INSTANCE.getInstance().getStationaryListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<StationaryReceiptResponse> getStationaryReceiptsApiCall() {
        return ApiClient.INSTANCE.getInstance().getStationaryReceiptsApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AdvancePaymentResponse> getStationaryPaymentUrlApiCall(Map<String, String> productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        return ApiClient.INSTANCE.getInstance().getStationaryPaymentUrlApiCall(productDetails);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelNewMonthlyResponse> getHostelNewMonthlyApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelNewMonthlyApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelNewAdmissionResponse> getHostelNewAdmissionApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelNewAdmissionApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelReceiptResponse> getHostelReceiptNewApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelReceiptNewApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelNewPay> getHostelFeeNewPayApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return ApiClient.INSTANCE.getInstance().getHostelFeeNewPayApiCall(feeCollection, feeReceipt);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelStatusNew> getHostelStatusNewApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelStatusNewApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<HostelNewHistoryResponse> getHostelHistoryNewApiCall() {
        return ApiClient.INSTANCE.getInstance().getHostelHistoryNewApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SubjectRegistrationResponse> getSubjectRegistrationListApiCall() {
        return ApiClient.INSTANCE.getInstance().getSubjectRegistrationListApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ViewSubjectRegistrationResponse> getSubjectRegistrationViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getSubjectRegistrationViewApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SubjectSpinnerResponse> getSubjectRegistrationSpinnerApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getSubjectRegistrationSpinnerApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> registerSubjectRegistrationApiCall(Map<String, String> registerCollection) {
        Intrinsics.checkNotNullParameter(registerCollection, "registerCollection");
        return ApiClient.INSTANCE.getInstance().registerSubjectRegistrationApiCall(registerCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateSubjectRegistrationApiCall(Map<String, String> registerCollection) {
        Intrinsics.checkNotNullParameter(registerCollection, "registerCollection");
        return ApiClient.INSTANCE.getInstance().updateSubjectRegistrationApiCall(registerCollection);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PublicationResponse> getPublicationUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getPublicationUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addPublicationUrlApiCall(RequestBody title, RequestBody journal, RequestBody conference, RequestBody index, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addPublicationUrlApiCall(title, journal, conference, index, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addPublicationUrlApiCall(String title, String journal, String conference, String index, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addPublicationUrlApiCall(title, journal, conference, index, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updatePublicationUrlApiCall(RequestBody id, RequestBody title, RequestBody journal, RequestBody conference, RequestBody index, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updatePublicationUrlApiCall(id, title, journal, conference, index, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updatePublicationUrlApiCall(String id, String title, String journal, String conference, String index, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updatePublicationUrlApiCall(id, title, journal, conference, index, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deletePublicationUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deletePublicationUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PublicationDropDownResponse> getProfileDropListUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getProfileDropListUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<FundedResearchResponse> getFundedResearchUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getFundedResearchUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addRResearchUrlApiCall(RequestBody title, RequestBody amount, RequestBody agency, RequestBody duration, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addRResearchUrlApiCall(title, amount, agency, duration, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addRResearchUrlApiCall(String title, String amount, String agency, String duration, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addRResearchUrlApiCall(title, amount, agency, duration, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateResearchUrlApiCall(RequestBody id, RequestBody title, RequestBody amount, RequestBody agency, RequestBody duration, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateResearchUrlApiCall(id, title, amount, agency, duration, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateResearchUrlApiCall(String id, String title, String amount, String agency, String duration, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateResearchUrlApiCall(id, title, amount, agency, duration, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteResearchUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteResearchUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<QualifiedExaminationResponse> getQualifiedExaminationUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getQualifiedExaminationUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addQualifiedExaminationUrlApiCall(RequestBody name, RequestBody score, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addQualifiedExaminationUrlApiCall(name, score, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addQualifiedExaminationUrlApiCall(String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addQualifiedExaminationUrlApiCall(name, score, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(RequestBody id, RequestBody name, RequestBody score, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateQualifiedExaminationUrlApiCall(id, name, score, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(String id, String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateQualifiedExaminationUrlApiCall(id, name, score, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteQualifiedExaminationUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteQualifiedExaminationUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MoocCourseResponse> getMoocCourseUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getMoocCourseUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addMoocCoursesUrlApiCall(RequestBody title, RequestBody provider, RequestBody fromDate, RequestBody toDate, RequestBody duration, RequestBody achievements, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return ApiClient.INSTANCE.getInstance().addMoocCoursesUrlApiCall(title, provider, fromDate, toDate, duration, achievements, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addMoocCoursesUrlApiCall(String title, String provider, String fromDate, String toDate, String duration, String achievements) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return ApiClient.INSTANCE.getInstance().addMoocCoursesUrlApiCall(title, provider, fromDate, toDate, duration, achievements);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateMoocCoursesUrlApiCall(RequestBody id, RequestBody title, RequestBody provider, RequestBody fromDate, RequestBody toDate, RequestBody duration, RequestBody achievements, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return ApiClient.INSTANCE.getInstance().updateMoocCoursesUrlApiCall(id, title, provider, fromDate, toDate, duration, achievements, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateMoocCoursesUrlApiCall(String id, String title, String provider, String fromDate, String toDate, String duration, String achievements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return ApiClient.INSTANCE.getInstance().updateMoocCoursesUrlApiCall(id, title, provider, fromDate, toDate, duration, achievements);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteMoocCoursesUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteMoocCoursesUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CoursesAttendedResponse> getCoursesAttendedUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getCoursesAttendedUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addCoursesUrlApiCall(RequestBody title, RequestBody organizedBy, RequestBody duration, RequestBody yearId, RequestBody achievements, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().addCoursesUrlApiCall(title, organizedBy, duration, yearId, achievements, fromDate, toDate, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addCoursesUrlApiCall(String title, String organizedBy, String duration, String yearId, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().addCoursesUrlApiCall(title, organizedBy, duration, yearId, achievements, fromDate, toDate);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateCoursesUrlApiCall(RequestBody id, RequestBody title, RequestBody organizedBy, RequestBody duration, RequestBody yearId, RequestBody achievements, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().updateCoursesUrlApiCall(id, title, organizedBy, duration, yearId, achievements, fromDate, toDate, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateCoursesUrlApiCall(String id, String title, String organizedBy, String duration, String yearId, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().updateCoursesUrlApiCall(id, title, organizedBy, duration, yearId, achievements, fromDate, toDate);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteCoursesUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteCoursesUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ProjectWorkResponse> getProjectWorkUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getProjectWorkUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addProjectWorkUrlApiCall(RequestBody type, RequestBody yearId, RequestBody details, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return ApiClient.INSTANCE.getInstance().addProjectWorkUrlApiCall(type, yearId, details, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addProjectWorkUrlApiCall(String type, String yearId, String details) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return ApiClient.INSTANCE.getInstance().addProjectWorkUrlApiCall(type, yearId, details);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateProjectWorkUrlApiCall(RequestBody id, RequestBody type, RequestBody yearId, RequestBody details, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return ApiClient.INSTANCE.getInstance().updateProjectWorkUrlApiCall(id, type, yearId, details, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateProjectWorkUrlApiCall(String id, String type, String yearId, String details) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return ApiClient.INSTANCE.getInstance().updateProjectWorkUrlApiCall(id, type, yearId, details);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteProjectWorkUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteProjectWorkUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<ScholarshipsResponse> getScholarshipsUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getScholarshipsUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addScholarshipUrlApiCall(RequestBody type, RequestBody details, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addScholarshipUrlApiCall(type, details, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addScholarshipUrlApiCall(String type, String details, String yearId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addScholarshipUrlApiCall(type, details, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateScholarshipUrlApiCall(RequestBody id, RequestBody type, RequestBody details, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateScholarshipUrlApiCall(id, type, details, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateScholarshipUrlApiCall(String id, String type, String details, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateScholarshipUrlApiCall(id, type, details, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteScholarshipUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteScholarshipUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SportResponse> getSportUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getSportUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addSportUrlApiCall(RequestBody title, RequestBody eventName, RequestBody organizedBy, RequestBody eventType, RequestBody level, RequestBody date, RequestBody yearId, RequestBody awards, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return ApiClient.INSTANCE.getInstance().addSportUrlApiCall(title, eventName, organizedBy, eventType, level, date, yearId, awards, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addSportUrlApiCall(String title, String eventName, String organizedBy, String eventType, String level, String date, String yearId, String awards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return ApiClient.INSTANCE.getInstance().addSportUrlApiCall(title, eventName, organizedBy, eventType, level, date, yearId, awards);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateSportUrlApiCall(RequestBody id, RequestBody title, RequestBody eventName, RequestBody organizedBy, RequestBody eventType, RequestBody level, RequestBody date, RequestBody yearId, RequestBody awards, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return ApiClient.INSTANCE.getInstance().updateSportUrlApiCall(id, title, eventName, organizedBy, eventType, level, date, yearId, awards, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateSportUrlApiCall(String id, String title, String eventName, String organizedBy, String eventType, String level, String date, String yearId, String awards) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return ApiClient.INSTANCE.getInstance().updateSportUrlApiCall(id, title, eventName, organizedBy, eventType, level, date, yearId, awards);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteSportUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteSportUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<PositionHeldResponse> getPositionHeldUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getPositionHeldUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addPositionHeldUrlApiCall(RequestBody title, RequestBody yearId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().addPositionHeldUrlApiCall(title, yearId, fromDate, toDate, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addPositionHeldUrlApiCall(String title, String yearId, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().addPositionHeldUrlApiCall(title, yearId, fromDate, toDate);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updatePositionHeldUrlApiCall(RequestBody id, RequestBody title, RequestBody yearId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().updatePositionHeldUrlApiCall(id, title, yearId, fromDate, toDate, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updatePositionHeldUrlApiCall(String id, String title, String yearId, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return ApiClient.INSTANCE.getInstance().updatePositionHeldUrlApiCall(id, title, yearId, fromDate, toDate);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deletePositionHeldUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deletePositionHeldUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<MembershipResponse> getMembershipUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getMembershipUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addMembershipUrlApiCall(RequestBody title, RequestBody type, RequestBody yearId, RequestBody memberId, RequestBody description, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return ApiClient.INSTANCE.getInstance().addMembershipUrlApiCall(title, type, yearId, memberId, description, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addMembershipUrlApiCall(String title, String type, String yearId, String memberId, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return ApiClient.INSTANCE.getInstance().addMembershipUrlApiCall(title, type, yearId, memberId, description);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateMembershipUrlApiCall(RequestBody id, RequestBody title, RequestBody type, RequestBody yearId, RequestBody memberId, RequestBody description, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return ApiClient.INSTANCE.getInstance().updateMembershipUrlApiCall(id, title, type, yearId, memberId, description, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateMembershipUrlApiCall(String id, String title, String type, String yearId, String memberId, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return ApiClient.INSTANCE.getInstance().updateMembershipUrlApiCall(id, title, type, yearId, memberId, description);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteMembershipUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteMembershipUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<AchievementsResponse> getAchievementsUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getAchievementsUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addAchievementUrlApiCall(RequestBody title, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addAchievementUrlApiCall(title, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addAchievementUrlApiCall(String title, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().addAchievementUrlApiCall(title, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateAchievementUrlApiCall(RequestBody id, RequestBody title, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateAchievementUrlApiCall(id, title, yearId, uploadFile);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updateAchievementUrlApiCall(String id, String title, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return ApiClient.INSTANCE.getInstance().updateAchievementUrlApiCall(id, title, yearId);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> deleteAchievementUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().deleteAchievementUrlApiCall(id);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> addAsietSemRegApiCall(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        return ApiClient.INSTANCE.getInstance().addAsietSemRegApiCall(semesterRegistration);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SuccessResponse> updaateAsietSemRegApiCall(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        return ApiClient.INSTANCE.getInstance().updaateAsietSemRegApiCall(semesterRegistration);
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SurveyPending> getSurveyPendingStatusUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getSurveyPendingStatusUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<POSurveyPending> getPoSurveyPendingStatusUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getPoSurveyPendingStatusUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<CourseSurveyPending> getCourseSurveyPendingStatusUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getCourseSurveyPendingStatusUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SurveyMandatory> getSurveyMandatoryStatusUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getSurveyMandatoryStatusUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<TransportHistoryResponse> getTransportHistoryUrlApiCall() {
        return ApiClient.INSTANCE.getInstance().getTransportHistoryUrlApiCall();
    }

    @Override // in.etuwa.app.data.network.ApiService
    public Single<SubjectsListResponse> getSubjectsRegListApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return ApiClient.INSTANCE.getInstance().getSubjectsRegListApiCall(id);
    }
}