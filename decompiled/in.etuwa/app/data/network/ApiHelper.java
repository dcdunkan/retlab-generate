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
import in.etuwa.app.data.model.calendar.AttendanceDetails;
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
import in.etuwa.app.data.model.due.DueResponse;
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
import in.etuwa.app.data.model.result.univ.UnivTotalResponse;
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
import in.etuwa.app.data.model.survey.SubmitTeacherResponse;
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
import in.etuwa.app.ui.dashboard.dashtable.TimeTableMonthlyNewResponse;
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

/* JADX INFO: compiled from: ApiHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ApiHelper {
    private final ApiService apiService;

    public ApiHelper(ApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    public final Single<Institution> getInstitutions() {
        return this.apiService.getInstitutionsApiCall();
    }

    public final Single<Institution> getDebugInstitutionsApiCall() {
        return this.apiService.getDebugInstitutionsApiCall();
    }

    public final Single<LoginResponse> doLogin(LoginRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.doLoginApiCall(request);
    }

    public final Single<SuccessResponse> doLogoutApiCall(LogoutRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.doLogoutApiCall(request);
    }

    public final Single<PushResponse> sendPushToken(PushRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.sendPushTokenApiCall(request);
    }

    public final Single<CalendarResponse> getCalendarEventApiCall() {
        return this.apiService.getCalendarEventApiCall();
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiService.getSemestersApiCall();
    }

    public final Single<CalendarResponse> getCalendarEvents() {
        return this.apiService.getCalendarEventApiCall();
    }

    public final Single<TimeTableMonthlyNewResponse> getTimeTableMonthlyApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.getTimeTableMonthlyApiCall(date);
    }

    public final Single<AttendanceDetails> getAttendanceDetails() {
        return this.apiService.getAttendanceDetails();
    }

    public final Single<ArrayList<Inbox>> getInboxApiCall() {
        return this.apiService.getInboxApiCall();
    }

    public final Single<ProfileResponse> getProfileApiCall() {
        return this.apiService.getProfileApiCall();
    }

    public final Single<SuccessResponse> readMsgApiCall(MsgHandleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.readMsgApiCall(request);
    }

    public final Single<ArrayList<Outbox>> getOutboxApiCall() {
        return this.apiService.getOutboxApiCall();
    }

    public final Single<SuccessResponse> composeMsgApiCall(ReplyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.composeMsgApiCall(request);
    }

    public final Single<SuccessResponse> getDeleteMsgApiCall(MsgHandleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getDeleteMsgApiCall(request);
    }

    public final Single<DashResponse> getDashApiCall() {
        return this.apiService.getDashApiCall();
    }

    public final Single<ArrayList<ChangeTimeTableResponse>> getChangeInTimetableApiCall() {
        return this.apiService.getChangeInTimetableApiCall();
    }

    public final Single<ArrayList<SpecialResponse>> getSpecialClassApiCall() {
        return this.apiService.getSpecialClassApiCall();
    }

    public final Single<NoticeResponse> getNoticeClassApiCall() {
        return this.apiService.getNoticeClassApiCall();
    }

    public final Single<NoticeJeccResponse> getNoticeClassJeccApiCall() {
        return this.apiService.getNoticeClassJeccApiCall();
    }

    public final Single<ArrayList<Remarks>> getRemarksApiCall() {
        return this.apiService.getRemarksApiCall();
    }

    public final Single<ExamScheduleResponse> getExamsApiCall() {
        return this.apiService.getExamsApiCall();
    }

    public final Single<ArrayList<Circular>> getCircularsApiCall() {
        return this.apiService.getCircularsApiCall();
    }

    public final Single<ArrayList<Placement>> getPlacementsApiCall() {
        return this.apiService.getPlacementsApiCall();
    }

    public final Single<SuccessResponse> applyPlacementsApiCall(PlacementRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.applyPlacementsApiCall(request);
    }

    public final Single<ArrayList<Subjects>> getSubjectsApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getSubjectsApiCall(request);
    }

    public final Single<SyllabusResponse> getSyllabusApiCall(CoSyllabusRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getSyllabusApiCall(request);
    }

    public final Single<ArrayList<CoModel>> getCourseOutcomeApiCall(CoSyllabusRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getCourseOutcomeApiCall(request);
    }

    public final Single<TeacherResponse> getTeacherApiCall() {
        return this.apiService.getTeacherApiCall();
    }

    public final Single<OnlineClassResponse> getOnlineClassApiCall() {
        return this.apiService.getOnlineClassApiCall();
    }

    public final Single<VideoResponse> getVideoClassApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getVideoClassApiCall(request);
    }

    public final Single<SuccessResponse> getWatchVideoApiCall(String videoId, String youtubeId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(youtubeId, "youtubeId");
        return this.apiService.getWatchVideoApiCall(videoId, youtubeId);
    }

    public final Single<AttendanceResponse> getAttendanceBySubjectApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getAttendanceBySubjectApiCall(request);
    }

    public final Single<AttendanceNewResponse> getAttendanceByDayNewApiCall(AttendanceRequestNew request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getAttendanceByDayNewApiCall(request);
    }

    public final Single<AttendanceDayResponse> getAttendanceByDayApiCall(AttendanceDayRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getAttendanceByDayApiCall(request);
    }

    public final Single<ArrayList<LabDue>> getLabDueApiCall() {
        return this.apiService.getLabDueApiCall();
    }

    public final Single<ArrayList<LabList>> getLabListApiCall() {
        return this.apiService.getLabListApiCall();
    }

    public final Single<ArrayList<LabEquipment>> getEquipmentsApiCall(LabEquipRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getEquipmentsApiCall(request);
    }

    public final Single<ArrayList<String>> getSafetyApiCall(LabEquipRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getSafetyApiCall(request);
    }

    public final Single<ArrayList<Practical>> getPracticalsApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getPracticalsApiCall(request);
    }

    public final Single<ArrayList<String>> getExperimentApiCall(PracticalRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getExperimentApiCall(request);
    }

    public final Single<ArrayList<Evaluation>> getEvaluationApiCall(PracticalRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getEvaluationApiCall(request);
    }

    public final Single<ChatResponse> getChatSubjectsApiCall() {
        return this.apiService.getChatSubjectsApiCall();
    }

    public final Single<CommentResponse> getCommentsApiCall(String subId, String chat) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        return this.apiService.getCommentsApiCall(subId, chat);
    }

    public final Single<SuccessResponse> setCommentsApiCall(String subId, String batchId, String semId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        return this.apiService.setCommentsApiCall(subId, batchId, semId, comment);
    }

    public final Single<CommentResponse> getParentCommentsApiCall(String batchId, String chat) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        return this.apiService.getParentCommentsApiCall(batchId, chat);
    }

    public final Single<SuccessResponse> setParentCommentsApiCall(String batchId, String semId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        return this.apiService.setParentCommentsApiCall(batchId, semId, comment);
    }

    public final Single<ReplyResponse> getReplyApiCall(String subId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiService.getReplyApiCall(subId, commentId, reply);
    }

    public final Single<SuccessResponse> setReplyApiCall(String subId, String batchId, String semId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiService.setReplyApiCall(subId, batchId, semId, commentId, reply);
    }

    public final Single<ReplyResponse> getParentReplyApiCall(String batchId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiService.getParentReplyApiCall(batchId, commentId, reply);
    }

    public final Single<SuccessResponse> setParentReplyApiCall(String batchId, String semId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiService.setParentReplyApiCall(batchId, semId, commentId, reply);
    }

    public final Single<ArrayList<Survey>> getSurveyApiCall() {
        return this.apiService.getSurveyApiCall();
    }

    public final Single<ArrayList<SurveyQuestion>> getSurveyQuestionApiCall(GenSurveyQuestionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getGenSurveyQuestionApiCall(request);
    }

    public final Single<SubmitResponse> submitGenSurveyApiCall(String surveyId, String remark, Map<String, String> option) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(option, "option");
        return this.apiService.submitGenSurveyApiCall(surveyId, remark, option);
    }

    public final Single<SubmitTeacherResponse> submitTeacherSurveyApiCall(String questionId, String optionId, String teacherId, String subjectId, String sessionId) {
        Intrinsics.checkNotNullParameter(questionId, "questionId");
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return this.apiService.submitTeacherSurveyApiCall(questionId, optionId, teacherId, subjectId, sessionId);
    }

    public final Single<ArrayList<TeacherList>> getSurveyTeachersApiCall(GenSurveyQuestionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getSurveyTeachersApiCall(request);
    }

    public final Single<ArrayList<SurveyQuestion>> getSurveyQuestionApiCall(SurveyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getSurveyQuestionApiCall(request);
    }

    public final Single<SubmitResponse> submitSurveyApiCall(String surveyId, String teacherId, String subjectId, String remark, String specialRemark, Map<String, String> option) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(specialRemark, "specialRemark");
        Intrinsics.checkNotNullParameter(option, "option");
        return this.apiService.submitSurveyApiCall(surveyId, teacherId, subjectId, remark, specialRemark, option);
    }

    public final Single<ApplyHostelResponse> applyHostelApiCall() {
        return this.apiService.applyHostelApiCall();
    }

    public final Single<FeeStatusResponse> getFeeStatusApiCall() {
        return this.apiService.getFeeStatusApiCall();
    }

    public final Single<ArrayList<ResultAssignment>> getResultAssignmentApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getResultAssignmentApiCall(request);
    }

    public final Single<ArrayList<ResultSeasonal>> getResultSeasonalApiCall(SeasonRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getResultSeasonalApiCall(request);
    }

    public final Single<ResultModuleTestResponse> getResultModuleTestApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getResultModuleTestApiCall(request);
    }

    public final Single<TutorialResultResponse> getTutorialResultApiCall(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        return this.apiService.getTutorialResultApiCall(semId);
    }

    public final Single<ArrayList<ResultInternal>> getResultInternalApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getResultInternalApiCall(request);
    }

    public final Single<UnivResponse> getResultUnivApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getResultUnivApiCall(request);
    }

    public final Single<UnivTotalResponse> getResultUnivApiCall() {
        return this.apiService.getResultUnivApiCall();
    }

    public final Single<ArrayList<MedicalLeave>> getMedicalLeaveApiCall() {
        return this.apiService.getMedicalLeaveApiCall();
    }

    public final Single<ArrayList<DutyLeave>> getDutyLeaveApiCall(DutyLeaveViewRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getDutyLeaveApiCall(request);
    }

    public final Single<ArrayList<MaterialsNew>> getStudyMaterialsApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getStudyMaterialsApiCall(request);
    }

    public final Single<ArrayList<Materials>> getQuestionBankApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getQuestionBankApiCall(request);
    }

    public final Single<SeriesExamResponse> getSeriesExamApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getSeriesExamApiCall(request);
    }

    public final Single<ModuleTestResponse> getModuleTestApiCall(String str) {
        Intrinsics.checkNotNullParameter(str, "new");
        return this.apiService.getModuleTestApiCall(str);
    }

    public final Single<AssignmentResponse> getAssignmentApiCall(AssignmentRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.getAssignmentApiCall(request);
    }

    public final Single<SuccessResponse> deleteAssignmentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteAssignmentApiCall(id);
    }

    public final Single<SuccessResponse> deleteSeriesExamApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteSeriesExamApiCall(id);
    }

    public final Single<SuccessResponse> deleteModuleTestApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteModuleTestApiCall(id);
    }

    public final Observable<SuccessResponse> uploadAssignmentApiCall(RequestBody username, RequestBody password, RequestBody id, RequestBody link, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(link, "link");
        return this.apiService.uploadAssignmentApiCall(username, password, id, link, file);
    }

    public final Observable<SuccessResponse> uploadSeriesExamApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.uploadSeriesExamApiCall(username, password, id, file);
    }

    public final Observable<SuccessResponse> uploadModuleTestApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.uploadModuleTestApiCall(username, password, id, file);
    }

    public final Single<SemRegViewResponse> getSemRegDetailsApiCall(String id) {
        return this.apiService.getSemRegDetailsApiCall(id);
    }

    public final Observable<SemRegSuccessResponse> semRegisterApiCall(HashMap<String, RequestBody> partMap, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiService.semRegisterApiCall(partMap, file);
    }

    public final Observable<SemRegSuccessResponse> semRegisterApiCall(Map<String, String> partMap) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiService.semRegisterApiCall(partMap);
    }

    public final Single<SemRegViewResponse> getSemRegDetailsMvjceApiCall(String id) {
        return this.apiService.getSemRegDetailsMvjceApiCall(id);
    }

    public final Observable<SemRegSuccessResponse> updateSemRegisterApiCall(RequestBody id, HashMap<String, RequestBody> partMap, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiService.updateSemRegisterApiCall(id, partMap, file);
    }

    public final Observable<SemRegSuccessResponse> updateSemRegisterApiCall(String id, Map<String, String> partMap) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiService.updateSemRegisterApiCall(id, partMap);
    }

    public final Single<SemRegisterListResponse> getSemRegListApiCall() {
        return this.apiService.getSemRegListApiCall();
    }

    public final Single<CentralizedInfoResponse> getCentralizedInfoApiCall() {
        return this.apiService.getCentralizedInfoApiCall();
    }

    public final Single<TutorialResponse> getTutorialsApiCall() {
        return this.apiService.getTutorialsApiCall();
    }

    public final Single<SuccessResponse> deleteTutorialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteTutorialApiCall(id);
    }

    public final Observable<SuccessResponse> submitTutorialApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.submitTutorialApiCall(id, file);
    }

    public final Single<HomeWorkResponse> getHomeWorksApiCall() {
        return this.apiService.getHomeWorksApiCall();
    }

    public final Single<SuccessResponse> deleteHomeWorkApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteHomeWorkApiCall(id);
    }

    public final Observable<SuccessResponse> submitHomeWorkApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.submitHomeWorkApiCall(id, file);
    }

    public final Single<InstallmentResponse> getFeeInstallmentsApiCall() {
        return this.apiService.getFeeInstallmentsApiCall();
    }

    public final Single<FeeResponse> getFeesApiCall(String installment) {
        return this.apiService.getFeesApiCall(installment);
    }

    public final Single<FeeUrlResponse> submitFeesApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiService.submitFeesApiCall(feeCollection, feeReceipt);
    }

    public final Single<FeeUrlResponse> payFeesApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiService.submitFeesApiCall(feeCollection, feeReceipt);
    }

    public final Single<FeeSreeChitraUrl> payFeesSreeChitraApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt, Map<String, String> transaction, String payment, String installment) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(payment, "payment");
        Intrinsics.checkNotNullParameter(installment, "installment");
        return this.apiService.payFeesSreeChitraApiCall(feeCollection, feeReceipt, transaction, payment, installment);
    }

    public final Single<ReceiptResponse> getFeeReceiptsApiCall() {
        return this.apiService.getFeeReceiptsApiCall();
    }

    public final Single<ReceiptResponse> getTransportFeeReceiptsApiCall() {
        return this.apiService.getTransportFeeReceiptsApiCall();
    }

    public final Single<FeeHeadGroupResponse> getFeeHeadApiCall() {
        return this.apiService.getFeeHeadApiCall();
    }

    public final Single<LiveResponse> getLiveTvApiCall() {
        return this.apiService.getLiveTvApiCall();
    }

    public final Single<DueResponse> getDuesApiCall() {
        return this.apiService.getDuesApiCall();
    }

    public final Single<QuizResponse> getQuizListApiCall() {
        return this.apiService.getQuizListApiCall();
    }

    public final Single<QuestionResponse> getQuizQuestionsApiCall(String id) {
        return this.apiService.getQuizQuestionsApiCall(id);
    }

    public final Single<QuizSubmitResponse> submitQuizAnswersApiCall(String id, SubmitRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.submitQuizAnswersApiCall(id, request);
    }

    public final Single<QuizSubmitResponse> finishQuizAnswersApiCall(String id, QuizFinishRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.finishQuizAnswersApiCall(id, request);
    }

    public final Observable<ArrayList<QuizFileUploadResponse>> uploadQuizApiCall(String id, MultipartBody.Part file) {
        return this.apiService.uploadQuizApiCall(id, file);
    }

    public final Single<SuccessResponse> deleteQuizFileApiCall(QuizDeleteFile request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiService.deleteQuizFileApiCall(request);
    }

    public final Single<QuizResultResponse> quizResultApiCall(String id) {
        return this.apiService.quizResultApiCall(id);
    }

    public final Single<SuccessResponse> quizSaveStatusApiCall(String sessionId, String qId) {
        return this.apiService.quizSaveStatusApiCall(sessionId, qId);
    }

    public final Single<ActivityPointResponse> getActivityPointApiCall() {
        return this.apiService.getActivityPointApiCall();
    }

    public final Single<ActivityBatchResponse> getManageActivityApiCall() {
        return this.apiService.getManageActivityApiCall();
    }

    public final Single<SuccessResponse> requestActivityApiCall(String id) {
        return this.apiService.requestActivityApiCall(id);
    }

    public final Observable<SuccessResponse> requestActivityApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.requestActivityApiCall(id, file);
    }

    public final Single<SuccessResponse> deleteRequestActivityApiCall(String id) {
        return this.apiService.deleteRequestActivityApiCall(id);
    }

    public final Single<SubCoverageResponse> getSubjectCoverageApiCall(String subId, String batchId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return this.apiService.getSubjectCoverageApiCall(subId, batchId);
    }

    public final Single<GrievanceResponse> getGrievanceApiCall() {
        return this.apiService.getGrievanceApiCall();
    }

    public final Single<GrievanceTypeResponse> getGrievanceTypeApiCall() {
        return this.apiService.getGrievanceTypeApiCall();
    }

    public final Single<ViewGrievanceResponse> viewGrievanceApiCall(String id) {
        return this.apiService.viewGrievanceApiCall(id);
    }

    public final Observable<SuccessResponse> addGrievanceApiCall(HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return this.apiService.addGrievanceApiCall(partMap, images);
    }

    public final Observable<SuccessResponse> updateGrievanceApiCall(RequestBody id, HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return this.apiService.updateGrievanceApiCall(id, partMap, images);
    }

    public final Single<SuccessResponse> deleteGrievanceApiCall(String id) {
        return this.apiService.deleteGrievanceApiCall(id);
    }

    public final Single<SuccessResponse> remindGrievanceApiCall(String id, String description) {
        return this.apiService.remindGrievanceApiCall(id, description);
    }

    public final Single<SuccessResponse> reopenGrievanceApiCall(HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return this.apiService.reopenGrievanceApiCall(partMap, images);
    }

    public final Observable<SuccessResponse> updateProPicApiCall(MultipartBody.Part file, MultipartBody.Part sign) {
        return this.apiService.updateProPicApiCall(file, sign);
    }

    public final Single<CertificateRequestResponse> getCertificateRequestApiCall() {
        return this.apiService.getCertificateRequestApiCall();
    }

    public final Single<CertificateTypeResponse> getCertificateTypeRequestApiCall() {
        return this.apiService.getCertificateTypeRequestApiCall();
    }

    public final Single<SuccessResponse> applyCertificateApiCall(String certificate, String reason) {
        return this.apiService.applyCertificateApiCall(certificate, reason);
    }

    public final Single<SuccessResponse> applyCertificateApiCall(Map<String, String> certificateCollection) {
        Intrinsics.checkNotNullParameter(certificateCollection, "certificateCollection");
        return this.apiService.applyCertificateApiCall(certificateCollection);
    }

    public final Observable<SuccessResponse> applyCertificateApiCall(RequestBody certificate, RequestBody reason, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return this.apiService.applyCertificateApiCall(certificate, reason, file);
    }

    public final Observable<SuccessResponse> uploadCovidCertificateApiCall(MultipartBody.Part vaccineFile) {
        return this.apiService.uploadCovidCertificateApiCall(vaccineFile);
    }

    public final Observable<SuccessResponse> uploadCovidCertificateTwoApiCall(MultipartBody.Part vaccineFileTwo) {
        return this.apiService.uploadCovidCertificateTwoApiCall(vaccineFileTwo);
    }

    public final Single<ResetPassword> getResetPasswordApiCall() {
        return this.apiService.getResetPasswordApiCall();
    }

    public final Single<ResetPassword> getRegistrationApiCall() {
        return this.apiService.getRegistrationApiCall();
    }

    public final Single<CounsellingResponse> getCounsellingRequestApiCall() {
        return this.apiService.getCouncellingRequestApiCall();
    }

    public final Single<ViewCounsellingResponse> viewCounsellingApiCall(String id) {
        return this.apiService.viewCounsellingApiCall(id);
    }

    public final Single<SuccessResponse> deleteCounsellingApiCall(String id) {
        return this.apiService.deleteCounsellingApiCall(id);
    }

    public final Observable<SuccessResponse> updateCounsellingApiCall(RequestBody id, HashMap<String, RequestBody> partMap) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiService.updateCounsellingApiCall(id, partMap);
    }

    public final Observable<SuccessResponse> addCounsellingApiCall(HashMap<String, RequestBody> partMap) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiService.addCounsellingApiCall(partMap);
    }

    public final Single<CounsellingTypesResponse> getCounsellingTypeApiCall() {
        return this.apiService.getCounsellingTypeApiCall();
    }

    public final Single<CounsellingStatusResponse> getCounsellingStatusApiCall() {
        return this.apiService.getCounsellingStatusApiCall();
    }

    public final Single<SuccessResponse> remindCounsellingApiCall(String id, String description) {
        return this.apiService.remindCounsellingApiCall(id, description);
    }

    public final Single<SuccessResponse> reviewCounsellingApiCall(String id, String description) {
        return this.apiService.reviewCounsellingApiCall(id, description);
    }

    public final Single<SuccessResponse> reopenCounsellingApiCall(String id, String type, String concern, String home, String studies, String relationship, String physical, String history, String session, String comments) {
        return this.apiService.reopenCounsellingApiCall(id, type, concern, home, studies, relationship, physical, history, session, comments);
    }

    public final Single<InternshipResponse> getInternshipRequestApiCall() {
        return this.apiService.getInternshipRequestApiCall();
    }

    public final Single<SuccessResponse> applyInternshipApiCall(String name, String fromDate, String toDate) {
        return this.apiService.applyInternshipApiCall(name, fromDate, toDate);
    }

    public final Observable<SuccessResponse> uploadInternshipApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.uploadInternshipApiCall(id, file);
    }

    public final Single<CompanyListResponse> getCompanyListApiCall() {
        return this.apiService.getCompanyListApiCall();
    }

    public final Single<SuccessResponse> addCompanyApiCall(String name, String address) {
        return this.apiService.addCompanyApiCall(name, address);
    }

    public final Observable<SuccessResponse> applyMedicalLeaveApiCall(RequestBody reason, RequestBody fromDate, RequestBody toDate, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.applyMedicalLeaveApiCall(reason, fromDate, toDate, file);
    }

    public final Observable<SuccessResponse> applyDutyLeaveApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.applyDutyLeaveApiCall(id, file);
    }

    public final Single<HostelResponse> getHostelApiCall() {
        return this.apiService.getHostelApiCall();
    }

    public final Single<HostelFeeResponse> getHostelFeeConfirmApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiService.getHostelFeeConfirmApiCall(feeCollection, feeReceipt);
    }

    public final Single<HostelFeePalaiResponse> getHostelFeeConfirmPalaiApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiService.getHostelFeeConfirmPalaiApiCall(feeCollection, feeReceipt);
    }

    public final Single<HostelMonthResponse> getHostelTkmApiCall() {
        return this.apiService.getHostelTkmApiCall();
    }

    public final Single<HostelReceiptResponse> getHostelReceiptTkmApiCall() {
        return this.apiService.getHostelReceiptTkmApiCall();
    }

    public final Single<DuePayNewResponse> getDuePay() {
        return this.apiService.getDuePay();
    }

    public final Single<DuePayUrl> getDuePayUrlApiCall(Map<String, String> dueFeeCollection, Map<String, String> dueFeeReceipt) {
        Intrinsics.checkNotNullParameter(dueFeeCollection, "dueFeeCollection");
        Intrinsics.checkNotNullParameter(dueFeeReceipt, "dueFeeReceipt");
        return this.apiService.getDuePayUrlApiCall(dueFeeCollection, dueFeeReceipt);
    }

    public final Single<StoreResponse> getStoreDataApiCall(String subjectId) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        return this.apiService.getStoreDataApiCall(subjectId);
    }

    public final Single<FeeEngineerResponse> getFeeEngineerApiCall() {
        return this.apiService.getFeeEngineerApiCall();
    }

    public final Single<DepartmentListResponse> getDepartmentApiCall() {
        return this.apiService.getDepartmentApiCall();
    }

    public final Single<DepartmentListResponse> getSemesterListApiCall(String dept_id) {
        Intrinsics.checkNotNullParameter(dept_id, "dept_id");
        return this.apiService.getSemesterListApiCall(dept_id);
    }

    public final Single<DepartmentListResponse> getSubjectListApiCall(String dept_id, String sem_id) {
        Intrinsics.checkNotNullParameter(dept_id, "dept_id");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        return this.apiService.getSubjectListApiCall(dept_id, sem_id);
    }

    public final Single<DepartmentListResponse> getCategoryApiCall() {
        return this.apiService.getCategoryApiCall();
    }

    public final Single<ProgramOutcomeResponse> getProgramOutcomeApiCall() {
        return this.apiService.getProgramOutcomeApiCall();
    }

    public final Single<FeeEngineerResponse> getFeeKmeaEngineerApiCall(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return this.apiService.getFeeKmeaEngineerApiCall(batchId);
    }

    public final Single<FeeEngineerUrlResponse> getEngineerFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiService.getEngineerFeePayUrlApiCall(FeeCollection);
    }

    public final Single<SuccessResponse> getMedicalFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiService.getMedicalFeePayUrlApiCall(FeeCollection);
    }

    public final Single<FeeArtsResponse> getFeeArtsApiCall() {
        return this.apiService.getFeeArtsApiCall();
    }

    public final Single<FeeArtsResponse> getFeeArtsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getFeeArtsApiCall(id);
    }

    public final Single<FeeArtsUrlResponse> getArtsFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiService.getArtsFeePayUrlApiCall(FeeCollection);
    }

    public final Single<NoDueCertificateResponse> getNoDueCertificate() {
        return this.apiService.getNoDueCertificate();
    }

    public final Single<RegistrationResponse> getHostelRegistrationData() {
        return this.apiService.getHostelRegistrationData();
    }

    public final Observable<SuccessResponse> newHostelRegistrationApiCall(RequestBody reAdmission, RequestBody category, RequestBody localGuardian, RequestBody localGuardianPhone, RequestBody annualIncome, RequestBody distance, RequestBody semesterId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(reAdmission, "reAdmission");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(localGuardian, "localGuardian");
        Intrinsics.checkNotNullParameter(localGuardianPhone, "localGuardianPhone");
        Intrinsics.checkNotNullParameter(annualIncome, "annualIncome");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(semesterId, "semesterId");
        return this.apiService.newHostelRegistrationApiCall(reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile);
    }

    public final Single<CategoryTypeResponse> getCategoryTypeApiCall() {
        return this.apiService.getCategoryTypeApiCall();
    }

    public final Single<PresentHostelResponse> getPresentHostelApiCall() {
        return this.apiService.getPresentHostelApiCall();
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
        return this.apiService.newHostelReRegistrationApiCall(reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile, hostelId, yearCount, hostelDetails, isFined, fineDetails, feeDefaulter, feeDetails);
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
        return this.apiService.updateHostelRegistrationApiCall(id, reAdmission, category, localGuardian, localGuardianPhone, annualIncome, distance, semesterId, uploadFile);
    }

    public final Single<ViewRegistrationResponse> viewRegistrationApiCall(RequestBody id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.viewRegistrationApiCall(id);
    }

    public final Single<LeaveManagementResponse> getLeaveManagementApiCall() {
        return this.apiService.getLeaveManagementApiCall();
    }

    public final Single<LibraryResponse> getDigitalLibraryApiCall() {
        return this.apiService.getDigitalLibraryApiCall();
    }

    public final Single<SuccessResponse> getChangePasswordApiCall(String oldPassword, String newPassword, String newPasswordRepeat) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(newPasswordRepeat, "newPasswordRepeat");
        return this.apiService.getChangePasswordApiCall(oldPassword, newPassword, newPasswordRepeat);
    }

    public final Single<ExamRegisterResponse> getExamRegisterDataApiCall() {
        return this.apiService.getExamRegisterDataApiCall();
    }

    public final Single<ExamCourseResponse> getExamCourseApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamCourseApiCall(id);
    }

    public final Single<ExamPayResponse> getExamPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiService.getExamPayUrlApiCall(FeeCollection);
    }

    public final Single<ExamViewResponse> getExamViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamViewApiCall(id);
    }

    public final Single<ExamUpdateResponse> getExamUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamUpdateApiCall(id);
    }

    public final Single<RegistrationSlipResponse> getRegistrationSlipApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getRegistrationSlipApiCall(id);
    }

    public final Single<ExamReceiptResponse> getExamReceiptApiCall() {
        return this.apiService.getExamReceiptApiCall();
    }

    public final Single<ExamMessageResponse> getPioPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiService.getPioPayUrlApiCall(FeeCollection);
    }

    public final Single<ExamMessageResponse> getScStPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiService.getScStPayUrlApiCall(FeeCollection);
    }

    public final Single<AcademicYearResponse> getSemRegDropListApiCall() {
        return this.apiService.getSemRegDropListApiCall();
    }

    public final Single<SuccessResponse> registerSemsterNewApiCall(Map<String, String> SemRegistration) {
        Intrinsics.checkNotNullParameter(SemRegistration, "SemRegistration");
        return this.apiService.registerSemsterNewApiCall(SemRegistration);
    }

    public final Single<SuccessResponse> updateBankDetailsApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return this.apiService.updateBankDetailsApiCall(studentDetails);
    }

    public final Single<SuccessResponse> verifyBankDetailsApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return this.apiService.verifyBankDetailsApiCall(studentDetails);
    }

    public final Single<UniversityResultResponse> getExamResult(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamResult(id);
    }

    public final Single<RevaluationResponse> getExamRevaluationApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamRevaluationApiCall(id);
    }

    public final Single<RevaluationApplyResponse> getExamRevaluationConfirmApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiService.getExamRevaluationConfirmApiCall(revaluationCollection);
    }

    public final Single<RevaluationApplyResponse> getExamRevaluationConfirmUpdateApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiService.getExamRevaluationConfirmUpdateApiCall(revaluationCollection);
    }

    public final Single<DuePayUrl> getExamRevaluationPayApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiService.getExamRevaluationPayApiCall(revaluationCollection);
    }

    public final Single<DuePayUrl> getExamRevaluationUpdatePayApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiService.getExamRevaluationUpdatePayApiCall(revaluationCollection);
    }

    public final Single<RevaluationViewResponse> getExamRevaluationViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamRevaluationViewApiCall(id);
    }

    public final Single<RevaluationReceiptResponse> getExamRevaluationReceiptApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamRevaluationReceiptApiCall(id);
    }

    public final Single<RevaluationStatusResponse> getExamRevaluationStatusApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamRevaluationStatusApiCall(id);
    }

    public final Single<RevaluationUpdateResponse> getExamRevaluationUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getExamRevaluationUpdateApiCall(id);
    }

    public final Single<MessResponse> getHostelMessApiCall() {
        return this.apiService.getHostelMessApiCall();
    }

    public final Single<OrderHistoryResponse> getMessOrderHistoryApiCall() {
        return this.apiService.getMessOrderHistoryApiCall();
    }

    public final Single<SuccessResponse> cancelMessOrderApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.cancelMessOrderApiCall(id);
    }

    public final Single<SuccessResponse> messBookingApiCall(String type, String menu, String qty) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(qty, "qty");
        return this.apiService.messBookingApiCall(type, menu, qty);
    }

    public final Single<MessMenuResponse> getMessMenuApiCall() {
        return this.apiService.getMessMenuApiCall();
    }

    public final Single<MessTypeResponse> getMessTypeApiCall() {
        return this.apiService.getMessTypeApiCall();
    }

    public final Single<MessMenuResponse> getMessTypeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getMessTypeApiCall(id);
    }

    public final Single<TransportFeeResponse> getTransportFeeApiCall() {
        return this.apiService.getTransportFeeApiCall();
    }

    public final Single<TransportFeeResponse> getTransportFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getTransportFeeApiCall(id);
    }

    public final Single<TransportPayUrl> getTransportFeeUrlApiCall(Map<String, String> transportFeeCollection) {
        Intrinsics.checkNotNullParameter(transportFeeCollection, "transportFeeCollection");
        return this.apiService.getTransportFeeUrlApiCall(transportFeeCollection);
    }

    public final Single<AbcResponse> getAbcViewApiCall() {
        return this.apiService.getAbcViewApiCall();
    }

    public final Single<SuccessResponse> getAbcUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getAbcUpdateApiCall(id);
    }

    public final Single<HostelPalaiTypesResponse> getHostelFeeTypesApiCall() {
        return this.apiService.getHostelFeeTypesApiCall();
    }

    public final Single<HostelPalaiAdmissionResponse> getPalaiHostelAdmsnApiCall() {
        return this.apiService.getPalaiHostelAdmsnApiCall();
    }

    public final Single<BooksResponse> getLibraryBooksApiCall() {
        return this.apiService.getLibraryBooksApiCall();
    }

    public final Single<BookRecordResponse> getLibraryBookRecordApiCall() {
        return this.apiService.getLibraryBookRecordApiCall();
    }

    public final Single<SuccessResponse> suggestBookApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return this.apiService.suggestBookApiCall(studentDetails);
    }

    public final Single<GatewayDetailsResponse> getGatewayDetailsApiCall() {
        return this.apiService.getGatewayDetailsApiCall();
    }

    public final Single<RegisterViewResponse> getRegisterViewApiCall() {
        return this.apiService.getRegisterViewApiCall();
    }

    public final Single<RegisterSucessResponse> addTransRegApiCall(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.addTransRegApiCall(id, date);
    }

    public final Single<RegisterSucessResponse> addAsietTransRegApiCall(String id, String exactPoint, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exactPoint, "exactPoint");
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.addAsietTransRegApiCall(id, exactPoint, date);
    }

    public final Single<TransportFeeResponse> getTransFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getTransFeeApiCall(id);
    }

    public final Single<BusPass> getTransportBusPassApiCall() {
        return this.apiService.getTransportBusPassApiCall();
    }

    public final Single<UpdateProfile> getUpdateProfileApiCall() {
        return this.apiService.getUpdateProfileApiCall();
    }

    public final Single<FeesMedResponse> getFeesMedicalApiCall() {
        return this.apiService.getFeesMedicalApiCall();
    }

    public final Single<DutyLeaveDirectApplyResponse> getDutyLeaveDirectViewApiCall() {
        return this.apiService.getDutyLeaveDirectViewApiCall();
    }

    public final Single<SuccessResponse> deleteDutyLeaveDirectViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteDutyLeaveDirectViewApiCall(id);
    }

    public final Single<DutyLeaveDateResponse> getDutyLeaveDirectDatesApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getDutyLeaveDirectDatesApiCall(id);
    }

    public final Single<SuccessResponse> removeDateHourDutyLeaveDirectDatesApiCall(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.removeDateHourDutyLeaveDirectDatesApiCall(id, date);
    }

    public final Single<SuccessResponse> addDutyLeaveDirectDatesApiCall(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        return this.apiService.addDutyLeaveDirectDatesApiCall(id, date, hour);
    }

    public final Single<SuccessResponse> removeDutyLeaveDirectDatesApiCall(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        return this.apiService.removeDutyLeaveDirectDatesApiCall(id, date, hour);
    }

    public final Single<SuccessResponse> applyDutyLeaveDirectViewApiCall(RequestBody reason, RequestBody headId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(headId, "headId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.applyDutyLeaveDirectViewApiCall(reason, headId, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> updateDutyLeaveDirectViewApiCall(RequestBody id, RequestBody reason, RequestBody headId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(headId, "headId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.updateDutyLeaveDirectViewApiCall(id, reason, headId, fromDate, toDate, uploadFile);
    }

    public final Single<DutyLeaveHeadResponse> getDutyLeaveDirectHeadApiCall() {
        return this.apiService.getDutyLeaveDirectHeadApiCall();
    }

    public final Single<InstallmentListResponse> getPartialInstallmentListApiCall() {
        return this.apiService.getPartialInstallmentListApiCall();
    }

    public final Single<InstallmentDetailsResponse> getPartialInstallmentFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getPartialInstallmentFeeApiCall(id);
    }

    public final Single<HostelPartialAdmission> getPalaiHostelPartialAdmsnApiCall() {
        return this.apiService.getPalaiHostelPartialAdmsnApiCall();
    }

    public final Single<HostelAttViewResponse> getHostelViewLeaveApiCall() {
        return this.apiService.getHostelViewLeaveApiCall();
    }

    public final Single<LeaveTypeResponse> getHostelLeaveTypeApiCall() {
        return this.apiService.getHostelLeaveTypeApiCall();
    }

    public final Single<SuccessResponse> getHostelApplyLeaveApiCall(String leaveType, String fromDate, String toDate, String reason) {
        Intrinsics.checkNotNullParameter(leaveType, "leaveType");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return this.apiService.getHostelApplyLeaveApiCall(leaveType, fromDate, toDate, reason);
    }

    public final Single<SuccessResponse> getHostelApplyLeaveNewApiCall(String leaveType, String fromDate, String toDate, String fromDateTime, String toDateTime, String reason) {
        Intrinsics.checkNotNullParameter(leaveType, "leaveType");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(fromDateTime, "fromDateTime");
        Intrinsics.checkNotNullParameter(toDateTime, "toDateTime");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return this.apiService.getHostelApplyLeaveNewApiCall(leaveType, fromDate, toDate, fromDateTime, toDateTime, reason);
    }

    public final Single<HostelAttParentViewResponse> getHostelLeaveViewParentApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.getHostelLeaveViewParentApiCall(date);
    }

    public final Single<HostelAttParentViewResponse> getHostelLeaveViewParentApproveApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.getHostelLeaveViewParentApproveApiCall(date);
    }

    public final Single<HostelAttParentViewResponse> getHostelLeaveViewParentRejectApiCall(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.getHostelLeaveViewParentRejectApiCall(date);
    }

    public final Single<SuccessResponse> getHostelDeleteLeaveApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getHostelDeleteLeaveApiCall(id);
    }

    public final Single<SuccessResponse> getHostelRevokeLeaveParentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getHostelRevokeLeaveParentApiCall(id);
    }

    public final Single<SuccessResponse> getHostelApproveLeaveParentApiCall(Map<String, String> approveDetails) {
        Intrinsics.checkNotNullParameter(approveDetails, "approveDetails");
        return this.apiService.getHostelApproveLeaveParentApiCall(approveDetails);
    }

    public final Single<SuccessResponse> getHostelRejectLeaveParentApiCall(Map<String, String> rejectDetails) {
        Intrinsics.checkNotNullParameter(rejectDetails, "rejectDetails");
        return this.apiService.getHostelRejectLeaveParentApiCall(rejectDetails);
    }

    public final Single<HostelAttCalResponse> getHostelAttCalApiCall(String month, String year) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        return this.apiService.getHostelAttCalApiCall(month, year);
    }

    public final Single<FeeArtsSemesterResponse> getFeeArtsSemList() {
        return this.apiService.getFeeArtsSemList();
    }

    public final Single<HostelScanViewResponse> getHostelGatePassApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getHostelGatePassApiCall(id);
    }

    public final Single<SuccessResponse> checkExitApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.checkExitApiCall(id);
    }

    public final Single<SuccessResponse> checkAlreadyExitApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.checkAlreadyExitApiCall(id);
    }

    public final Single<DownloadMaterialResponse> downloadMaterialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.downloadMaterialApiCall(id);
    }

    public final Single<CourseSurveyResponse> getCourseSurveyList() {
        return this.apiService.getCourseSurveyList();
    }

    public final Single<DoCourseSurveyResponse> getDoCourseSurveyList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getDoCourseSurveyList(id);
    }

    public final Single<CourseSurveyQuestionsResponse> getDoCourseSurveyQuestionList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getDoCourseSurveyQuestionList(id);
    }

    public final Single<SuccessResponse> postCourseSurveyAnswer(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        return this.apiService.postCourseSurveyAnswer(answerCollection);
    }

    public final Single<DayWiseResponse> getDayWiseTimeTable(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiService.getDayWiseTimeTable(date);
    }

    public final Single<MaintenanceResponse> getMaintenanceUrl() {
        return this.apiService.getMaintenanceUrl();
    }

    public final Single<POSurveyResponse> getPoSurveyUrl() {
        return this.apiService.getPoSurveyUrl();
    }

    public final Single<PoQuestionsResponse> getPoQuestionsUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getPoQuestionsUrl(id);
    }

    public final Single<SuccessResponse> poAnswerSubmit(Map<String, String> answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        return this.apiService.poAnswerSubmit(answerDetails);
    }

    public final Single<PendingSurvey> getPendingSurveyUrl() {
        return this.apiService.getPendingSurveyUrl();
    }

    public final Single<SemRegSlip> getRegistrationSlipUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getRegistrationSlipUrl(id);
    }

    public final Single<MitsFeePay> getMitsFeePayUrl() {
        return this.apiService.getMitsFeePayUrl();
    }

    public final Single<HostelAsietRegisterViewResponse> getAsietTransportRegistrationUrl() {
        return this.apiService.getAsietTransportRegistrationUrl();
    }

    public final Single<QuestionsNewResponse> getNewQuizQuestionsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getNewQuizQuestionsApiCall(id);
    }

    public final Single<QuizSubmitResponse> newQuizAnswerSubmit(Map<String, String> answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        return this.apiService.newQuizAnswerSubmit(answerDetails);
    }

    public final Single<QuizSubmitResponse> newQuizAnswerUploadSubmit(RequestBody qNo, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.newQuizAnswerUploadSubmit(qNo, id, file);
    }

    public final Single<QuizSubmitResponse> newQuizAnswerUploadFinalSubmit(RequestBody qNo, RequestBody id, RequestBody finalSubmit, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(finalSubmit, "finalSubmit");
        return this.apiService.newQuizAnswerUploadFinalSubmit(qNo, id, finalSubmit, file);
    }

    public final Single<QuizResultResponse> quizResultNewApiCall(String id) {
        return this.apiService.quizResultNewApiCall(id);
    }

    public final Single<GraduateExitSurveyListResponse> getGraduateSurveyListApiCall() {
        return this.apiService.getGraduateSurveyListApiCall();
    }

    public final Single<DoGraduateSurveyResponse> getGraduateSurveyQuestionsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getGraduateSurveyQuestionsApiCall(id);
    }

    public final Single<SuccessResponse> postGESurveyAnswer(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        return this.apiService.postGESurveyAnswer(answerCollection);
    }

    public final Single<StationaryItemResponse> getStationaryListApiCall() {
        return this.apiService.getStationaryListApiCall();
    }

    public final Single<StationaryReceiptResponse> getStationaryReceiptsApiCall() {
        return this.apiService.getStationaryReceiptsApiCall();
    }

    public final Single<AdvancePaymentResponse> getStationaryPaymentUrlApiCall(Map<String, String> productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        return this.apiService.getStationaryPaymentUrlApiCall(productDetails);
    }

    public final Single<HostelNewMonthlyResponse> getHostelNewMonthlyApiCall() {
        return this.apiService.getHostelNewMonthlyApiCall();
    }

    public final Single<HostelNewAdmissionResponse> getHostelNewAdmissionApiCall() {
        return this.apiService.getHostelNewAdmissionApiCall();
    }

    public final Single<HostelReceiptResponse> getHostelReceiptNewApiCall() {
        return this.apiService.getHostelReceiptNewApiCall();
    }

    public final Single<HostelNewPay> getHostelFeeNewPayApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiService.getHostelFeeNewPayApiCall(feeCollection, feeReceipt);
    }

    public final Single<HostelStatusNew> getHostelStatusNewApiCall() {
        return this.apiService.getHostelStatusNewApiCall();
    }

    public final Single<HostelNewHistoryResponse> getHostelHistoryNewApiCall() {
        return this.apiService.getHostelHistoryNewApiCall();
    }

    public final Single<SubjectRegistrationResponse> getSubjectRegistrationListApiCall() {
        return this.apiService.getSubjectRegistrationListApiCall();
    }

    public final Single<ViewSubjectRegistrationResponse> getSubjectRegistrationViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getSubjectRegistrationViewApiCall(id);
    }

    public final Single<SubjectSpinnerResponse> getSubjectRegistrationSpinnerApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getSubjectRegistrationSpinnerApiCall(id);
    }

    public final Single<SuccessResponse> registerSubjectRegistrationApiCall(Map<String, String> registerCollection) {
        Intrinsics.checkNotNullParameter(registerCollection, "registerCollection");
        return this.apiService.registerSubjectRegistrationApiCall(registerCollection);
    }

    public final Single<SuccessResponse> updateSubjectRegistrationApiCall(Map<String, String> registerCollection) {
        Intrinsics.checkNotNullParameter(registerCollection, "registerCollection");
        return this.apiService.updateSubjectRegistrationApiCall(registerCollection);
    }

    public final Single<PublicationResponse> getPublicationUrlApiCall() {
        return this.apiService.getPublicationUrlApiCall();
    }

    public final Single<SuccessResponse> addPublicationUrlApiCall(RequestBody title, RequestBody journal, RequestBody conference, RequestBody index, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addPublicationUrlApiCall(title, journal, conference, index, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updatePublicationUrlApiCall(RequestBody id, RequestBody title, RequestBody journal, RequestBody conference, RequestBody index, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updatePublicationUrlApiCall(id, title, journal, conference, index, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addPublicationUrlApiCall(String title, String journal, String conference, String index, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addPublicationUrlApiCall(title, journal, conference, index, yearId);
    }

    public final Single<SuccessResponse> updatePublicationUrlApiCall(String id, String title, String journal, String conference, String index, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updatePublicationUrlApiCall(id, title, journal, conference, index, yearId);
    }

    public final Single<PublicationDropDownResponse> getProfileDropListUrlApiCall() {
        return this.apiService.getProfileDropListUrlApiCall();
    }

    public final Single<SuccessResponse> deletePublicationUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deletePublicationUrlApiCall(id);
    }

    public final Single<FundedResearchResponse> getFundedResearchUrlApiCall() {
        return this.apiService.getFundedResearchUrlApiCall();
    }

    public final Single<SuccessResponse> addRResearchUrlApiCall(RequestBody title, RequestBody amount, RequestBody agency, RequestBody duration, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addRResearchUrlApiCall(title, amount, agency, duration, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addRResearchUrlApiCall(String title, String amount, String agency, String duration, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addRResearchUrlApiCall(title, amount, agency, duration, yearId);
    }

    public final Single<SuccessResponse> updateResearchUrlApiCall(RequestBody id, RequestBody title, RequestBody amount, RequestBody agency, RequestBody duration, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateResearchUrlApiCall(id, title, amount, agency, duration, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateResearchUrlApiCall(String id, String title, String amount, String agency, String duration, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateResearchUrlApiCall(id, title, amount, agency, duration, yearId);
    }

    public final Single<SuccessResponse> deleteResearchUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteResearchUrlApiCall(id);
    }

    public final Single<QualifiedExaminationResponse> getQualifiedExaminationUrlApiCall() {
        return this.apiService.getQualifiedExaminationUrlApiCall();
    }

    public final Single<SuccessResponse> addQualifiedExaminationUrlApiCall(RequestBody name, RequestBody score, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addQualifiedExaminationUrlApiCall(name, score, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addQualifiedExaminationUrlApiCall(String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addQualifiedExaminationUrlApiCall(name, score, yearId);
    }

    public final Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(RequestBody id, RequestBody name, RequestBody score, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateQualifiedExaminationUrlApiCall(id, name, score, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(String id, String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateQualifiedExaminationUrlApiCall(id, name, score, yearId);
    }

    public final Single<SuccessResponse> deleteQualifiedExaminationUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteQualifiedExaminationUrlApiCall(id);
    }

    public final Single<MoocCourseResponse> getMoocCourseUrlApiCall() {
        return this.apiService.getMoocCourseUrlApiCall();
    }

    public final Single<SuccessResponse> addMoocCoursesUrlApiCall(RequestBody title, RequestBody provider, RequestBody fromDate, RequestBody toDate, RequestBody duration, RequestBody achievements, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiService.addMoocCoursesUrlApiCall(title, provider, fromDate, toDate, duration, achievements, uploadFile);
    }

    public final Single<SuccessResponse> addMoocCoursesUrlApiCall(String title, String provider, String fromDate, String toDate, String duration, String achievements) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiService.addMoocCoursesUrlApiCall(title, provider, fromDate, toDate, duration, achievements);
    }

    public final Single<SuccessResponse> updateMoocCoursesUrlApiCall(RequestBody id, RequestBody title, RequestBody provider, RequestBody fromDate, RequestBody toDate, RequestBody duration, RequestBody achievements, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiService.updateMoocCoursesUrlApiCall(id, title, provider, fromDate, toDate, duration, achievements, uploadFile);
    }

    public final Single<SuccessResponse> updateMoocCoursesUrlApiCall(String id, String title, String provider, String fromDate, String toDate, String duration, String achievements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiService.updateMoocCoursesUrlApiCall(id, title, provider, fromDate, toDate, duration, achievements);
    }

    public final Single<SuccessResponse> deleteMoocCoursesUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteMoocCoursesUrlApiCall(id);
    }

    public final Single<CoursesAttendedResponse> getCoursesAttendedUrlApiCall() {
        return this.apiService.getCoursesAttendedUrlApiCall();
    }

    public final Single<SuccessResponse> addCoursesUrlApiCall(RequestBody title, RequestBody organizedBy, RequestBody duration, RequestBody yearId, RequestBody achievements, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.addCoursesUrlApiCall(title, organizedBy, duration, yearId, achievements, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> addCoursesUrlApiCall(String title, String organizedBy, String duration, String yearId, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.addCoursesUrlApiCall(title, organizedBy, duration, yearId, achievements, fromDate, toDate);
    }

    public final Single<SuccessResponse> updateCoursesUrlApiCall(RequestBody id, RequestBody title, RequestBody organizedBy, RequestBody duration, RequestBody yearId, RequestBody achievements, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.updateCoursesUrlApiCall(id, title, organizedBy, duration, yearId, achievements, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> updateCoursesUrlApiCall(String id, String title, String organizedBy, String duration, String yearId, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.updateCoursesUrlApiCall(id, title, organizedBy, duration, yearId, achievements, fromDate, toDate);
    }

    public final Single<SuccessResponse> deleteCoursesUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteCoursesUrlApiCall(id);
    }

    public final Single<ProjectWorkResponse> getProjectWorkUrlApiCall() {
        return this.apiService.getProjectWorkUrlApiCall();
    }

    public final Single<SuccessResponse> addProjectWorkUrlApiCall(RequestBody type, RequestBody yearId, RequestBody details, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiService.addProjectWorkUrlApiCall(type, yearId, details, uploadFile);
    }

    public final Single<SuccessResponse> addProjectWorkUrlApiCall(String type, String yearId, String details) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiService.addProjectWorkUrlApiCall(type, yearId, details);
    }

    public final Single<SuccessResponse> updateProjectWorkUrlApiCall(RequestBody id, RequestBody type, RequestBody yearId, RequestBody details, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiService.updateProjectWorkUrlApiCall(id, type, yearId, details, uploadFile);
    }

    public final Single<SuccessResponse> updateProjectWorkUrlApiCall(String id, String type, String yearId, String details) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiService.updateProjectWorkUrlApiCall(id, type, yearId, details);
    }

    public final Single<SuccessResponse> deleteProjectWorkUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteProjectWorkUrlApiCall(id);
    }

    public final Single<ScholarshipsResponse> getScholarshipsUrlApiCall() {
        return this.apiService.getScholarshipsUrlApiCall();
    }

    public final Single<SuccessResponse> addScholarshipUrlApiCall(RequestBody type, RequestBody details, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addScholarshipUrlApiCall(type, details, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addScholarshipUrlApiCall(String type, String details, String yearId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addScholarshipUrlApiCall(type, details, yearId);
    }

    public final Single<SuccessResponse> updateScholarshipUrlApiCall(RequestBody id, RequestBody type, RequestBody details, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateScholarshipUrlApiCall(id, type, details, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateScholarshipUrlApiCall(String id, String type, String details, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateScholarshipUrlApiCall(id, type, details, yearId);
    }

    public final Single<SuccessResponse> deleteScholarshipUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteScholarshipUrlApiCall(id);
    }

    public final Single<SportResponse> getSportUrlApiCall() {
        return this.apiService.getSportUrlApiCall();
    }

    public final Single<SuccessResponse> addSportUrlApiCall(RequestBody title, RequestBody eventName, RequestBody organizedBy, RequestBody eventType, RequestBody level, RequestBody date, RequestBody yearId, RequestBody awards, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiService.addSportUrlApiCall(title, eventName, organizedBy, eventType, level, date, yearId, awards, uploadFile);
    }

    public final Single<SuccessResponse> addSportUrlApiCall(String title, String eventName, String organizedBy, String eventType, String level, String date, String yearId, String awards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiService.addSportUrlApiCall(title, eventName, organizedBy, eventType, level, date, yearId, awards);
    }

    public final Single<SuccessResponse> updateSportUrlApiCall(RequestBody id, RequestBody title, RequestBody eventName, RequestBody organizedBy, RequestBody eventType, RequestBody level, RequestBody date, RequestBody yearId, RequestBody awards, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiService.updateSportUrlApiCall(id, title, eventName, organizedBy, eventType, level, date, yearId, awards, uploadFile);
    }

    public final Single<SuccessResponse> updateSportUrlApiCall(String id, String title, String eventName, String organizedBy, String eventType, String level, String date, String yearId, String awards) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiService.updateSportUrlApiCall(id, title, eventName, organizedBy, eventType, level, date, yearId, awards);
    }

    public final Single<SuccessResponse> deleteSportUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteSportUrlApiCall(id);
    }

    public final Single<PositionHeldResponse> getPositionHeldUrlApiCall() {
        return this.apiService.getPositionHeldUrlApiCall();
    }

    public final Single<SuccessResponse> addPositionHeldUrlApiCall(RequestBody title, RequestBody yearId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.addPositionHeldUrlApiCall(title, yearId, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> addPositionHeldUrlApiCall(String title, String yearId, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.addPositionHeldUrlApiCall(title, yearId, fromDate, toDate);
    }

    public final Single<SuccessResponse> updatePositionHeldUrlApiCall(RequestBody id, RequestBody title, RequestBody yearId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.updatePositionHeldUrlApiCall(id, title, yearId, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> updatePositionHeldUrlApiCall(String id, String title, String yearId, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiService.updatePositionHeldUrlApiCall(id, title, yearId, fromDate, toDate);
    }

    public final Single<SuccessResponse> deletePositionHeldUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deletePositionHeldUrlApiCall(id);
    }

    public final Single<MembershipResponse> getMembershipUrlApiCall() {
        return this.apiService.getMembershipUrlApiCall();
    }

    public final Single<SuccessResponse> addMembershipUrlApiCall(RequestBody title, RequestBody type, RequestBody yearId, RequestBody memberId, RequestBody description, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiService.addMembershipUrlApiCall(title, type, yearId, memberId, description, uploadFile);
    }

    public final Single<SuccessResponse> addMembershipUrlApiCall(String title, String type, String yearId, String memberId, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiService.addMembershipUrlApiCall(title, type, yearId, memberId, description);
    }

    public final Single<SuccessResponse> updateMembershipUrlApiCall(RequestBody id, RequestBody title, RequestBody type, RequestBody yearId, RequestBody memberId, RequestBody description, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiService.updateMembershipUrlApiCall(id, title, type, yearId, memberId, description, uploadFile);
    }

    public final Single<SuccessResponse> updateMembershipUrlApiCall(String id, String title, String type, String yearId, String memberId, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiService.updateMembershipUrlApiCall(id, title, type, yearId, memberId, description);
    }

    public final Single<SuccessResponse> deleteMembershipUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteMembershipUrlApiCall(id);
    }

    public final Single<AchievementsResponse> getAchievementsUrlApiCall() {
        return this.apiService.getAchievementsUrlApiCall();
    }

    public final Single<SuccessResponse> addAchievementUrlApiCall(RequestBody title, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addAchievementUrlApiCall(title, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addAchievementUrlApiCall(String title, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.addAchievementUrlApiCall(title, yearId);
    }

    public final Single<SuccessResponse> updateAchievementUrlApiCall(RequestBody id, RequestBody title, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateAchievementUrlApiCall(id, title, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateAchievementUrlApiCall(String id, String title, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiService.updateAchievementUrlApiCall(id, title, yearId);
    }

    public final Single<SuccessResponse> deleteAchievementUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.deleteAchievementUrlApiCall(id);
    }

    public final Single<SuccessResponse> addAsietSemRegApiCall(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        return this.apiService.addAsietSemRegApiCall(semesterRegistration);
    }

    public final Single<SuccessResponse> updaateAsietSemRegApiCall(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        return this.apiService.updaateAsietSemRegApiCall(semesterRegistration);
    }

    public final Single<SurveyPending> getSurveyPendingStatusUrlApiCall() {
        return this.apiService.getSurveyPendingStatusUrlApiCall();
    }

    public final Single<POSurveyPending> getPoSurveyPendingStatusUrlApiCall() {
        return this.apiService.getPoSurveyPendingStatusUrlApiCall();
    }

    public final Single<CourseSurveyPending> getCourseSurveyPendingStatusUrlApiCall() {
        return this.apiService.getCourseSurveyPendingStatusUrlApiCall();
    }

    public final Single<SurveyMandatory> getSurveyMandatoryStatusUrlApiCall() {
        return this.apiService.getSurveyMandatoryStatusUrlApiCall();
    }

    public final Single<TransportHistoryResponse> getTransportHistoryUrlApiCall() {
        return this.apiService.getTransportHistoryUrlApiCall();
    }

    public final Single<SubjectsListResponse> getSubjectsRegListApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiService.getSubjectsRegListApiCall(id);
    }
}