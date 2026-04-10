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
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.bouncycastle.i18n.ErrorBundle;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

/* compiled from: ApiService.kt */
/* loaded from: classes3.dex */
public interface ApiService {
    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_ACHIEVEMENTS)
    Single<SuccessResponse> addAchievementUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.ADD_ACHIEVEMENTS)
    @Multipart
    Single<SuccessResponse> addAchievementUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST("semreg/registration")
    Single<SuccessResponse> addAsietSemRegApiCall(@FieldMap Map<String, String> semesterRegistration);

    @FormUrlEncoded
    @POST(ApiEndPoints.TRANSPORT_REGISTER_NEW)
    Single<RegisterSucessResponse> addAsietTransRegApiCall(@Field("TransportRegistrationFee[point_id]") String id, @Field("TransportRegistrationFee[exactPoint]") String exactPoint, @Field("TransportRegistrationFee[start_date]") String date);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_COMPANY_INTERNSHIP)
    Single<SuccessResponse> addCompanyApiCall(@Field("InternshipCompany[name]") String name, @Field("InternshipCompany[address]") String address);

    @POST(ApiEndPoints.ADD_COUNSELLING)
    @Multipart
    Observable<SuccessResponse> addCounsellingApiCall(@PartMap HashMap<String, RequestBody> partMap);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_COURSE_ATTENDED)
    Single<SuccessResponse> addCoursesUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_5]") String organizedBy, @Field("StudentProfile[duration]") String duration, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_desc_3]") String achievements, @Field("StudentProfile[attr_date_1]") String fromDate, @Field("StudentProfile[attr_date_2]") String toDate);

    @POST(ApiEndPoints.ADD_COURSE_ATTENDED)
    @Multipart
    Single<SuccessResponse> addCoursesUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_5]") RequestBody organizedBy, @Part("StudentProfile[duration]") RequestBody duration, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_desc_3]") RequestBody achievements, @Part("StudentProfile[attr_date_1]") RequestBody fromDate, @Part("StudentProfile[attr_date_2]") RequestBody toDate, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_ADD_HOURS)
    Single<SuccessResponse> addDutyLeaveDirectDatesApiCall(@Field("id") String id, @Field("date") String date, @Field("hour") String hour);

    @POST(ApiEndPoints.ADD_GRIEVANCE)
    @Multipart
    Observable<SuccessResponse> addGrievanceApiCall(@PartMap HashMap<String, RequestBody> partMap, @Part ArrayList<MultipartBody.Part> images);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_MEMBERSHIP)
    Single<SuccessResponse> addMembershipUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_3]") String type, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_int_1]") String memberId, @Field("StudentProfile[attr_desc_6]") String description);

    @POST(ApiEndPoints.ADD_MEMBERSHIP)
    @Multipart
    Single<SuccessResponse> addMembershipUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_3]") RequestBody type, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_int_1]") RequestBody memberId, @Part("StudentProfile[attr_desc_6]") RequestBody description, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_MOOC_COURSE)
    Single<SuccessResponse> addMoocCoursesUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_4]") String provider, @Field("StudentProfile[attr_date_1]") String fromDate, @Field("StudentProfile[attr_date_2]") String toDate, @Field("StudentProfile[duration]") String duration, @Field("StudentProfile[attr_desc_5]") String achievements);

    @POST(ApiEndPoints.ADD_MOOC_COURSE)
    @Multipart
    Single<SuccessResponse> addMoocCoursesUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_4]") RequestBody provider, @Part("StudentProfile[attr_date_1]") RequestBody fromDate, @Part("StudentProfile[attr_date_2]") RequestBody toDate, @Part("StudentProfile[duration]") RequestBody duration, @Part("StudentProfile[attr_desc_5]") RequestBody achievements, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_POSITION)
    Single<SuccessResponse> addPositionHeldUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_date_1]") String fromDate, @Field("StudentProfile[attr_date_2]") String toDate);

    @POST(ApiEndPoints.ADD_POSITION)
    @Multipart
    Single<SuccessResponse> addPositionHeldUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_date_1]") RequestBody fromDate, @Part("StudentProfile[attr_date_2]") RequestBody toDate, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_PROJECT_WORK)
    Single<SuccessResponse> addProjectWorkUrlApiCall(@Field("StudentProfile[attr_desc_1]") String type, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_desc_2]") String details);

    @POST(ApiEndPoints.ADD_PROJECT_WORK)
    @Multipart
    Single<SuccessResponse> addProjectWorkUrlApiCall(@Part("StudentProfile[attr_desc_1]") RequestBody type, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_desc_2]") RequestBody details, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_PUBLICATION)
    Single<SuccessResponse> addPublicationUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_3]") String journal, @Field("StudentProfile[attr_desc_4]") String conference, @Field("StudentProfile[attr_desc_5]") String index, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.ADD_PUBLICATION)
    @Multipart
    Single<SuccessResponse> addPublicationUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_3]") RequestBody journal, @Part("StudentProfile[attr_desc_4]") RequestBody conference, @Part("StudentProfile[attr_desc_5]") RequestBody index, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_Q_EXAM)
    Single<SuccessResponse> addQualifiedExaminationUrlApiCall(@Field("StudentProfile[attr_desc_2]") String name, @Field("StudentProfile[attr_desc_1]") String score, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.ADD_Q_EXAM)
    @Multipart
    Single<SuccessResponse> addQualifiedExaminationUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody name, @Part("StudentProfile[attr_desc_1]") RequestBody score, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_RESEARCH)
    Single<SuccessResponse> addRResearchUrlApiCall(@Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_int_1]") String amount, @Field("StudentProfile[attr_desc_4]") String agency, @Field("StudentProfile[duration]") String duration, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.ADD_RESEARCH)
    @Multipart
    Single<SuccessResponse> addRResearchUrlApiCall(@Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_int_1]") RequestBody amount, @Part("StudentProfile[attr_desc_4]") RequestBody agency, @Part("StudentProfile[duration]") RequestBody duration, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_SCHOLARSHIPS)
    Single<SuccessResponse> addScholarshipUrlApiCall(@Field("StudentProfile[attr_desc_1]") String type, @Field("StudentProfile[attr_desc_2]") String details, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.ADD_SCHOLARSHIPS)
    @Multipart
    Single<SuccessResponse> addScholarshipUrlApiCall(@Part("StudentProfile[attr_desc_1]") RequestBody type, @Part("StudentProfile[attr_desc_2]") RequestBody details, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.ADD_SPORT)
    Single<SuccessResponse> addSportUrlApiCall(@Field("StudentProfile[attr_desc_1]") String title, @Field("StudentProfile[attr_desc_2]") String eventName, @Field("StudentProfile[attr_desc_5]") String organizedBy, @Field("StudentProfile[attr_desc_3]") String eventType, @Field("StudentProfile[attr_desc_4]") String level, @Field("StudentProfile[attr_date_1]") String date, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_desc_6]") String awards);

    @POST(ApiEndPoints.ADD_SPORT)
    @Multipart
    Single<SuccessResponse> addSportUrlApiCall(@Part("StudentProfile[attr_desc_1]") RequestBody title, @Part("StudentProfile[attr_desc_2]") RequestBody eventName, @Part("StudentProfile[attr_desc_5]") RequestBody organizedBy, @Part("StudentProfile[attr_desc_3]") RequestBody eventType, @Part("StudentProfile[attr_desc_4]") RequestBody level, @Part("StudentProfile[attr_date_1]") RequestBody date, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_desc_6]") RequestBody awards, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.TRANSPORT_REGISTER_NEW)
    Single<RegisterSucessResponse> addTransRegApiCall(@Field("TransportRegistrationFee[point_id]") String id, @Field("TransportRegistrationFee[start_date]") String date);

    @POST(ApiEndPoints.REQUEST_CERTIFICATE)
    @Multipart
    Observable<SuccessResponse> applyCertificateApiCall(@Part("certificate") RequestBody certificate, @Part("CertificateApplication[reason]") RequestBody reason, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ApiEndPoints.REQUEST_CERTIFICATE)
    Single<SuccessResponse> applyCertificateApiCall(@Field("certificate") String certificate, @Field("CertificateApplication[reason]") String reason);

    @FormUrlEncoded
    @POST(ApiEndPoints.REQUEST_CERTIFICATE)
    Single<SuccessResponse> applyCertificateApiCall(@FieldMap Map<String, String> certificateCollection);

    @POST(ApiEndPoints.DUTY_LEAVE_PROOF_APPLY)
    @Multipart
    Observable<SuccessResponse> applyDutyLeaveApiCall(@Part("request_id") RequestBody id, @Part MultipartBody.Part proofFile);

    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_APPLY)
    @Multipart
    Single<SuccessResponse> applyDutyLeaveDirectViewApiCall(@Part("DutyLeaveStudentApply[reason]") RequestBody reason, @Part("DutyLeaveStudentApply[dutyleavehead_id]") RequestBody headId, @Part("DutyLeaveStudentApply[from_date]") RequestBody fromDate, @Part("DutyLeaveStudentApply[to_date]") RequestBody toDate, @Part MultipartBody.Part uploadFile);

    @POST(ApiEndPoints.HOSTEL_APPLY_URL)
    Single<ApplyHostelResponse> applyHostelApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.INTERNSHIP_APPLY)
    Single<SuccessResponse> applyInternshipApiCall(@Field("Internship[company_id]") String name, @Field("Internship[from_date]") String fromDate, @Field("Internship[to_date]") String toDate);

    @POST(ApiEndPoints.APPLY_MEDICAL_LEAVE_URL)
    @Multipart
    Observable<SuccessResponse> applyMedicalLeaveApiCall(@Part("MedicalLeave[reason]") RequestBody reason, @Part("MedicalLeave[from_date]") RequestBody fromDate, @Part("MedicalLeave[to_date]") RequestBody toDate, @Part MultipartBody.Part proofFile);

    @POST(ApiEndPoints.REG_PLACEMENT_URL)
    Single<SuccessResponse> applyPlacementsApiCall(@Body PlacementRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.MESS_CANCEL_ORDER)
    Single<SuccessResponse> cancelMessOrderApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHECK_ALREADY_EXIT_SECURITY)
    Single<SuccessResponse> checkAlreadyExitApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHECK_EXIT_SECURITY)
    Single<SuccessResponse> checkExitApiCall(@Field("id") String id);

    @POST(ApiEndPoints.COMPOSE_MSG_URL)
    Single<SuccessResponse> composeMsgApiCall(@Body ReplyRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_ACHIEVEMENTS)
    Single<SuccessResponse> deleteAchievementUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_ASSIGNMENT_URL)
    Single<SuccessResponse> deleteAssignmentApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_COUNSELLING)
    Single<SuccessResponse> deleteCounsellingApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_COURSE_ATTENDED)
    Single<SuccessResponse> deleteCoursesUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_DELETE)
    Single<SuccessResponse> deleteDutyLeaveDirectViewApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_GRIEVANCE)
    Single<SuccessResponse> deleteGrievanceApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_HOMEWORK)
    Single<SuccessResponse> deleteHomeWorkApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_MEMBERSHIP)
    Single<SuccessResponse> deleteMembershipUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_MODULE_TEST)
    Single<SuccessResponse> deleteModuleTestApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_MOOC_COURSE)
    Single<SuccessResponse> deleteMoocCoursesUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_POSITION)
    Single<SuccessResponse> deletePositionHeldUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_PROJECT_WORK)
    Single<SuccessResponse> deleteProjectWorkUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_PUBLICATION)
    Single<SuccessResponse> deletePublicationUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_Q_EXAM)
    Single<SuccessResponse> deleteQualifiedExaminationUrlApiCall(@Field("id") String id);

    @POST(ApiEndPoints.QUIZ_DELETE_UPLOAD)
    Single<SuccessResponse> deleteQuizFileApiCall(@Body QuizDeleteFile request);

    @FormUrlEncoded
    @POST(ApiEndPoints.ACTIVITY_DELETE_REQUEST)
    Single<SuccessResponse> deleteRequestActivityApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_RESEARCH)
    Single<SuccessResponse> deleteResearchUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_SCHOLARSHIPS)
    Single<SuccessResponse> deleteScholarshipUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_SERIES_EXAM)
    Single<SuccessResponse> deleteSeriesExamApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_SPORT)
    Single<SuccessResponse> deleteSportUrlApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.DELETE_TUTORIALS)
    Single<SuccessResponse> deleteTutorialApiCall(@Field("id") String id);

    @POST(ApiEndPoints.LOGIN_URL)
    Single<LoginResponse> doLoginApiCall(@Body LoginRequest request);

    @POST(ApiEndPoints.LOGOUT_URL)
    Single<SuccessResponse> doLogoutApiCall(@Body LogoutRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.MATERIAL_DOWNLOAD_URL)
    Single<DownloadMaterialResponse> downloadMaterialApiCall(@Field("id") String id);

    @POST("quiz/answer/{id}")
    Single<QuizSubmitResponse> finishQuizAnswersApiCall(@Path("id") String id, @Body QuizFinishRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.TKMCE_ABC_UPDATE)
    Single<SuccessResponse> getAbcUpdateApiCall(@Field("Student[abc_id]") String id);

    @GET(ApiEndPoints.TKMCE_ABC_VIEW)
    Single<AbcResponse> getAbcViewApiCall();

    @GET(ApiEndPoints.VIEW_ACHIEVEMENTS)
    Single<AchievementsResponse> getAchievementsUrlApiCall();

    @GET(ApiEndPoints.ACTIVITY_POINT)
    Single<ActivityPointResponse> getActivityPointApiCall();

    @FormUrlEncoded
    @POST("fee/academicfeeconfirm")
    Single<FeeArtsUrlResponse> getArtsFeePayUrlApiCall(@FieldMap Map<String, String> FeeCollection);

    @GET("transport/registerview")
    Single<HostelAsietRegisterViewResponse> getAsietTransportRegistrationUrl();

    @POST(ApiEndPoints.ASSIGNMENT_URL)
    Single<AssignmentResponse> getAssignmentApiCall(@Body AssignmentRequest request);

    @POST(ApiEndPoints.ATTENDANCE_BY_DAY)
    Single<AttendanceDayResponse> getAttendanceByDayApiCall(@Body AttendanceDayRequest request);

    @POST(ApiEndPoints.ATTENDANCE_BY_DAY_URL_NEW)
    Single<AttendanceNewResponse> getAttendanceByDayNewApiCall(@Body AttendanceRequestNew request);

    @POST(ApiEndPoints.ATTENDANCE_BY_SUBJECT_URL)
    Single<AttendanceResponse> getAttendanceBySubjectApiCall(@Body AttendanceRequest request);

    @POST(ApiEndPoints.CALENDAR_EVENTS_URL)
    Single<CalendarResponse> getCalendarEventApiCall();

    @GET(ApiEndPoints.CATEGORY_FILTER)
    Single<DepartmentListResponse> getCategoryApiCall();

    @GET(ApiEndPoints.GCEK_CATEGORY_TYPE)
    Single<CategoryTypeResponse> getCategoryTypeApiCall();

    @POST(ApiEndPoints.CENTRALIZED_INFO)
    Single<CentralizedInfoResponse> getCentralizedInfoApiCall();

    @POST(ApiEndPoints.CERTIFICATE_REQUEST)
    Single<CertificateRequestResponse> getCertificateRequestApiCall();

    @POST(ApiEndPoints.CERTIFICATE_TYPE)
    Single<CertificateTypeResponse> getCertificateTypeRequestApiCall();

    @POST(ApiEndPoints.TIME_TABLE_CHANGE_URL)
    Single<ArrayList<ChangeTimeTableResponse>> getChangeInTimetableApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.CHANGE_PASSWORD)
    Single<SuccessResponse> getChangePasswordApiCall(@Field("User[old_password]") String oldPassword, @Field("User[new_password]") String newPassword, @Field("User[new_password_repeat]") String newPasswordRepeat);

    @POST(ApiEndPoints.CHAT_SUBJECTS)
    Single<ChatResponse> getChatSubjectsApiCall();

    @POST(ApiEndPoints.CIRCULAR_URL)
    Single<ArrayList<Circular>> getCircularsApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_STUDENT)
    Single<CommentResponse> getCommentsApiCall(@Field("sub_id") String subId, @Field("chat") String chat);

    @POST(ApiEndPoints.INTERNSHIP_COMPANY_LIST)
    Single<CompanyListResponse> getCompanyListApiCall();

    @GET(ApiEndPoints.COUNSELLING_REQUEST)
    Single<CounsellingResponse> getCouncellingRequestApiCall();

    @POST(ApiEndPoints.COUNSELLING_STATUS)
    Single<CounsellingStatusResponse> getCounsellingStatusApiCall();

    @POST(ApiEndPoints.COUNSELLING_TYPE)
    Single<CounsellingTypesResponse> getCounsellingTypeApiCall();

    @POST(ApiEndPoints.COURSE_OUTCOME_URL)
    Single<ArrayList<CoModel>> getCourseOutcomeApiCall(@Body CoSyllabusRequest request);

    @GET(ApiEndPoints.COURSE_EV_SURVEY_URL)
    Single<CourseSurveyResponse> getCourseSurveyList();

    @GET(ApiEndPoints.COURSE_SURVEY_PENDING_STATUS_API)
    Single<CourseSurveyPending> getCourseSurveyPendingStatusUrlApiCall();

    @GET(ApiEndPoints.VIEW_COURSE_ATTENDED)
    Single<CoursesAttendedResponse> getCoursesAttendedUrlApiCall();

    @GET(ApiEndPoints.DASH_URL)
    Single<DashResponse> getDashApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.DAY_WISE_TIMETABLE_URL)
    Single<DayWiseResponse> getDayWiseTimeTable(@Field("date") String date);

    @GET(ApiEndPoints.COLLEGE_LIST_DEBUG)
    Single<Institution> getDebugInstitutionsApiCall();

    @POST(ApiEndPoints.DELETE_MSG_URL)
    Single<SuccessResponse> getDeleteMsgApiCall(@Body MsgHandleRequest request);

    @GET(ApiEndPoints.DEPARTMENT_FILTER)
    Single<DepartmentListResponse> getDepartmentApiCall();

    @GET(ApiEndPoints.DIGITAL_LIBRARY)
    Single<LibraryResponse> getDigitalLibraryApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.COURSE_DO_SURVEY_URL)
    Single<DoCourseSurveyResponse> getDoCourseSurveyList(@Field("session_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.COURSE_SURVEY_QUESTIONS)
    Single<CourseSurveyQuestionsResponse> getDoCourseSurveyQuestionList(@Field("session_id") String id);

    @GET(ApiEndPoints.DUE_PAY)
    Single<DuePayNewResponse> getDuePay();

    @FormUrlEncoded
    @POST(ApiEndPoints.DUE_PAY_URL)
    Single<DuePayUrl> getDuePayUrlApiCall(@FieldMap Map<String, String> dueFeeCollection, @FieldMap Map<String, String> dueFeeReceipt);

    @POST(ApiEndPoints.DUE)
    Single<DuePayNewResponse> getDuesApiCall();

    @POST(ApiEndPoints.DUTY_LEAVE_URL)
    Single<ArrayList<DutyLeave>> getDutyLeaveApiCall(@Body DutyLeaveViewRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_HOURS)
    Single<DutyLeaveDateResponse> getDutyLeaveDirectDatesApiCall(@Field("id") String id);

    @GET(ApiEndPoints.DUTY_LEAVE_DIRECT_HEAD)
    Single<DutyLeaveHeadResponse> getDutyLeaveDirectHeadApiCall();

    @GET(ApiEndPoints.DUTY_LEAVE_DIRECT_VIEW)
    Single<DutyLeaveDirectApplyResponse> getDutyLeaveDirectViewApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.FEE_ENGINNEER_URL)
    Single<FeeEngineerUrlResponse> getEngineerFeePayUrlApiCall(@FieldMap Map<String, String> FeeCollection);

    @POST(ApiEndPoints.LAB_EQUIPMENTS)
    Single<ArrayList<LabEquipment>> getEquipmentsApiCall(@Body LabEquipRequest request);

    @POST(ApiEndPoints.LAB_EVALUATION)
    Single<ArrayList<Evaluation>> getEvaluationApiCall(@Body PracticalRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_COURSE)
    Single<ExamCourseResponse> getExamCourseApiCall(@Field("exam_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_PAY)
    Single<ExamPayResponse> getExamPayUrlApiCall(@FieldMap Map<String, String> FeeCollection);

    @GET(ApiEndPoints.EXAM_RECEIPT)
    Single<ExamReceiptResponse> getExamReceiptApiCall();

    @GET(ApiEndPoints.EXAM_REGISTER)
    Single<ExamRegisterResponse> getExamRegisterDataApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_RESULT)
    Single<UniversityResultResponse> getExamResult(@Field("exam_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION)
    Single<RevaluationResponse> getExamRevaluationApiCall(@Field("exam_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_CONFIRM)
    Single<RevaluationApplyResponse> getExamRevaluationConfirmApiCall(@FieldMap Map<String, String> revaluationCollection);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_CONFIRM_UPDATE)
    Single<RevaluationApplyResponse> getExamRevaluationConfirmUpdateApiCall(@FieldMap Map<String, String> revaluationCollection);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_URL)
    Single<DuePayUrl> getExamRevaluationPayApiCall(@FieldMap Map<String, String> revaluationCollection);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_RECEIPT)
    Single<RevaluationReceiptResponse> getExamRevaluationReceiptApiCall(@Field("revaluation_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_STATUS)
    Single<RevaluationStatusResponse> getExamRevaluationStatusApiCall(@Field("exam_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_UPDATE)
    Single<RevaluationUpdateResponse> getExamRevaluationUpdateApiCall(@Field("exam_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_UPDATE_URL)
    Single<DuePayUrl> getExamRevaluationUpdatePayApiCall(@FieldMap Map<String, String> revaluationCollection);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_REVALUATION_VIEW)
    Single<RevaluationViewResponse> getExamRevaluationViewApiCall(@Field("exam_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_UPDATE)
    Single<ExamUpdateResponse> getExamUpdateApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_VIEW)
    Single<ExamViewResponse> getExamViewApiCall(@Field("id") String id);

    @POST(ApiEndPoints.EXAM_SCHEDULE_URL)
    Single<ExamScheduleResponse> getExamsApiCall();

    @POST(ApiEndPoints.LAB_EXPERIMENTS)
    Single<ArrayList<String>> getExperimentApiCall(@Body PracticalRequest request);

    @GET("fee/academicfees")
    Single<FeeArtsResponse> getFeeArtsApiCall();

    @FormUrlEncoded
    @POST("fee/academicfees")
    Single<FeeArtsResponse> getFeeArtsApiCall(@Field("installment") String id);

    @GET("fee/installments")
    Single<FeeArtsSemesterResponse> getFeeArtsSemList();

    @GET("fee/installments")
    Single<FeeEngineerResponse> getFeeEngineerApiCall();

    @GET(ApiEndPoints.ACADEMIC_FEES_URL)
    Single<FeeHeadGroupResponse> getFeeHeadApiCall();

    @POST("fee/installments")
    Single<InstallmentResponse> getFeeInstallmentsApiCall();

    @FormUrlEncoded
    @POST("fee/installmentdetails")
    Single<FeeEngineerResponse> getFeeKmeaEngineerApiCall(@Field("batch_id") String batchId);

    @POST(ApiEndPoints.FEE_RECEIPTS_URL)
    Single<ReceiptResponse> getFeeReceiptsApiCall();

    @GET(ApiEndPoints.ACADEMIC_FEE_STATUS)
    Single<FeeStatusResponse> getFeeStatusApiCall();

    @FormUrlEncoded
    @POST("fee/academicfees")
    Single<FeeResponse> getFeesApiCall(@Field("installment") String installment);

    @GET("fee/installments")
    Single<FeesMedResponse> getFeesMedicalApiCall();

    @GET(ApiEndPoints.VIEW_RESEARCH)
    Single<FundedResearchResponse> getFundedResearchUrlApiCall();

    @GET(ApiEndPoints.FEE_GATEWAY_DETAILS)
    Single<GatewayDetailsResponse> getGatewayDetailsApiCall();

    @POST(ApiEndPoints.SURVEY_QUESTION_URL)
    Single<ArrayList<SurveyQuestion>> getGenSurveyQuestionApiCall(@Body GenSurveyQuestionRequest request);

    @GET(ApiEndPoints.GRADUATE_EXIT_SURVEY_LIST_URL)
    Single<GraduateExitSurveyListResponse> getGraduateSurveyListApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.GRADUATE_EXIT_SURVEY_QUESTION_URL)
    Single<DoGraduateSurveyResponse> getGraduateSurveyQuestionsApiCall(@Field("id") String id);

    @POST(ApiEndPoints.GRIEVANCE)
    Single<GrievanceResponse> getGrievanceApiCall();

    @POST(ApiEndPoints.GRIEVANCE_TYPE)
    Single<GrievanceTypeResponse> getGrievanceTypeApiCall();

    @POST(ApiEndPoints.HOMEWORK)
    Single<HomeWorkResponse> getHomeWorksApiCall();

    @GET(ApiEndPoints.HOSTEL_URL)
    Single<HostelResponse> getHostelApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_APPLY_LEAVE)
    Single<SuccessResponse> getHostelApplyLeaveApiCall(@Field("HostelStudentLeave[leavetype]") String leaveType, @Field("HostelStudentLeave[from_date]") String fromDate, @Field("HostelStudentLeave[to_date]") String toDate, @Field("HostelStudentLeave[reason]") String reason);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_APPROVE_LEAVE_PARENT)
    Single<SuccessResponse> getHostelApproveLeaveParentApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_ATT_CAL)
    Single<HostelAttCalResponse> getHostelAttCalApiCall(@Field("month") String month, @Field("year") String year);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_DEL_LEAVE)
    Single<SuccessResponse> getHostelDeleteLeaveApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_TKM_FEE_CONF_URL)
    Single<HostelFeeResponse> getHostelFeeConfirmApiCall(@FieldMap Map<String, String> feeCollection, @FieldMap Map<String, String> feeReceipt);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_PALAI_FEE_CONF_URL)
    Single<HostelFeePalaiResponse> getHostelFeeConfirmPalaiApiCall(@FieldMap Map<String, String> feeCollection, @FieldMap Map<String, String> feeReceipt);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_PAY_NEW_API_URL)
    Single<HostelNewPay> getHostelFeeNewPayApiCall(@FieldMap Map<String, String> feeCollection, @FieldMap Map<String, String> feeReceipt);

    @GET(ApiEndPoints.HOSTEL_PALAI_URL)
    Single<HostelPalaiTypesResponse> getHostelFeeTypesApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_GATE_PASS)
    Single<HostelScanViewResponse> getHostelGatePassApiCall(@Field("id") String id);

    @GET(ApiEndPoints.HOSTEL_PAY_HISTORY_API_URL)
    Single<HostelNewHistoryResponse> getHostelHistoryNewApiCall();

    @GET(ApiEndPoints.HOSTEL_LEAVE_TYPE)
    Single<LeaveTypeResponse> getHostelLeaveTypeApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_VIEW_LEAVE_PARENT)
    Single<HostelAttParentViewResponse> getHostelLeaveViewParentApiCall(@Field("date") String date);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_VIEW_LEAVE_PARENT_APPROVE)
    Single<HostelAttParentViewResponse> getHostelLeaveViewParentApproveApiCall(@Field("date") String date);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_VIEW_LEAVE_PARENT_REJECT)
    Single<HostelAttParentViewResponse> getHostelLeaveViewParentRejectApiCall(@Field("date") String date);

    @GET("hostel/messmenu")
    Single<MessResponse> getHostelMessApiCall();

    @GET("hostel/hosteladmission")
    Single<HostelNewAdmissionResponse> getHostelNewAdmissionApiCall();

    @GET(ApiEndPoints.HOSTEL_NEW_MONTHLY_API_URL)
    Single<HostelNewMonthlyResponse> getHostelNewMonthlyApiCall();

    @GET("hostel/hostelreceipt")
    Single<HostelReceiptResponse> getHostelReceiptNewApiCall();

    @GET("hostel/hostelreceipt")
    Single<HostelReceiptResponse> getHostelReceiptTkmApiCall();

    @GET(ApiEndPoints.GCEK_HOSTEL_REGISTRATION)
    Single<RegistrationResponse> getHostelRegistrationData();

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_REJECT_LEAVE_PARENT)
    Single<SuccessResponse> getHostelRejectLeaveParentApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.HOSTEL_REVOKE_LEAVE_PARENT)
    Single<SuccessResponse> getHostelRevokeLeaveParentApiCall(@Field("id") String id);

    @GET(ApiEndPoints.HOSTEL_PAY_STATUS_NEW_API_URL)
    Single<HostelStatusNew> getHostelStatusNewApiCall();

    @GET(ApiEndPoints.HOSTEL_TKM_URL)
    Single<HostelMonthResponse> getHostelTkmApiCall();

    @GET(ApiEndPoints.HOSTEL_VIEW_LEAVE)
    Single<HostelAttViewResponse> getHostelViewLeaveApiCall();

    @POST(ApiEndPoints.INBOX_URL)
    Single<ArrayList<Inbox>> getInboxApiCall();

    @GET(ApiEndPoints.COLLEGE_LIST)
    Single<Institution> getInstitutionsApiCall();

    @GET(ApiEndPoints.INTERNSHIP_DATA)
    Single<InternshipResponse> getInternshipRequestApiCall();

    @POST(ApiEndPoints.LAB_DUE)
    Single<ArrayList<LabDue>> getLabDueApiCall();

    @POST(ApiEndPoints.LIST_OF_LAB)
    Single<ArrayList<LabList>> getLabListApiCall();

    @GET(ApiEndPoints.LEAVE_TEST)
    Single<LeaveManagementResponse> getLeaveManagementApiCall();

    @GET(ApiEndPoints.LIBRARY_BOOK_RECORD)
    Single<BookRecordResponse> getLibraryBookRecordApiCall();

    @GET(ApiEndPoints.LIBRARY_BOOKS)
    Single<BooksResponse> getLibraryBooksApiCall();

    @POST(ApiEndPoints.LIVE_TV)
    Single<LiveResponse> getLiveTvApiCall();

    @GET(ApiEndPoints.MAINTENANCE_URL)
    Single<MaintenanceResponse> getMaintenanceUrl();

    @POST(ApiEndPoints.ACTIVITY_MANAGE)
    Single<ActivityBatchResponse> getManageActivityApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.FEE_MEDICAL_URL)
    Single<SuccessResponse> getMedicalFeePayUrlApiCall(@FieldMap Map<String, String> FeeCollection);

    @POST(ApiEndPoints.MEDICAL_LEAVE_URL)
    Single<ArrayList<MedicalLeave>> getMedicalLeaveApiCall();

    @GET(ApiEndPoints.VIEW_MEMBERSHIP)
    Single<MembershipResponse> getMembershipUrlApiCall();

    @GET("hostel/messmenu")
    Single<MessMenuResponse> getMessMenuApiCall();

    @GET(ApiEndPoints.MESS_ORDER_HISTORY)
    Single<OrderHistoryResponse> getMessOrderHistoryApiCall();

    @GET(ApiEndPoints.MESS_TYPE_RESPONSE)
    Single<MessTypeResponse> getMessTypeApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.MESS_TYPE_RESPONSE)
    Single<MessMenuResponse> getMessTypeApiCall(@Field("id") String id);

    @GET(ApiEndPoints.MITS_FEE_PAY_URL)
    Single<MitsFeePay> getMitsFeePayUrl();

    @FormUrlEncoded
    @POST(ApiEndPoints.MODULE_TEST)
    Single<ModuleTestResponse> getModuleTestApiCall(@Field("new") String r1);

    @GET(ApiEndPoints.VIEW_MOOC_COURSE)
    Single<MoocCourseResponse> getMoocCourseUrlApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.NEW_QUIZ_QUESTIONS)
    Single<QuestionsNewResponse> getNewQuizQuestionsApiCall(@Field("id") String id);

    @GET(ApiEndPoints.NO_DUE_CERTIFICATE)
    Single<NoDueCertificateResponse> getNoDueCertificate();

    @POST(ApiEndPoints.NOTICE_URL)
    Single<NoticeResponse> getNoticeClassApiCall();

    @POST(ApiEndPoints.NOTICE_URL_JECC)
    Single<NoticeJeccResponse> getNoticeClassJeccApiCall();

    @POST(ApiEndPoints.ONLINE_CLASS)
    Single<OnlineClassResponse> getOnlineClassApiCall();

    @GET(ApiEndPoints.SENT_ITEMS_URL)
    Single<ArrayList<Outbox>> getOutboxApiCall();

    @GET("hostel/hosteladmission")
    Single<HostelPalaiAdmissionResponse> getPalaiHostelAdmsnApiCall();

    @GET(ApiEndPoints.HOSTEL_PALAI_ADMSN_PARTIAL)
    Single<HostelPartialAdmission> getPalaiHostelPartialAdmsnApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_PARENT)
    Single<CommentResponse> getParentCommentsApiCall(@Field("batch_id") String batchId, @Field("chat") String chat);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_PARENT)
    Single<ReplyResponse> getParentReplyApiCall(@Field("batch_id") String batchId, @Field("comment_id") String commentId, @Field("view_reply") String reply);

    @FormUrlEncoded
    @POST("fee/installmentdetails")
    Single<InstallmentDetailsResponse> getPartialInstallmentFeeApiCall(@Field("install_id") String id);

    @GET(ApiEndPoints.FEE_INSTALLMENT_DROP_DOWN)
    Single<InstallmentListResponse> getPartialInstallmentListApiCall();

    @GET(ApiEndPoints.SURVEY_PENDING_STATUS)
    Single<PendingSurvey> getPendingSurveyUrl();

    @FormUrlEncoded
    @POST(ApiEndPoints.PIO_REGISTER)
    Single<ExamMessageResponse> getPioPayUrlApiCall(@FieldMap Map<String, String> FeeCollection);

    @POST(ApiEndPoints.PLACEMENT_URL)
    Single<ArrayList<Placement>> getPlacementsApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.PO_SURVEY_QUESTIONS_URL)
    Single<PoQuestionsResponse> getPoQuestionsUrl(@Field("id") String id);

    @GET(ApiEndPoints.PO_SURVEY_PENDING_STATUS_API)
    Single<POSurveyPending> getPoSurveyPendingStatusUrlApiCall();

    @GET(ApiEndPoints.PO_SURVEY_URL)
    Single<POSurveyResponse> getPoSurveyUrl();

    @GET(ApiEndPoints.VIEW_POSITION)
    Single<PositionHeldResponse> getPositionHeldUrlApiCall();

    @POST(ApiEndPoints.LIST_OF_LAB_PRACTICAL)
    Single<ArrayList<Practical>> getPracticalsApiCall(@Body AttendanceRequest request);

    @GET(ApiEndPoints.GCEK_PRESENT_HOSTEL)
    Single<PresentHostelResponse> getPresentHostelApiCall();

    @GET(ApiEndPoints.PROFILE_URL)
    Single<ProfileResponse> getProfileApiCall();

    @GET(ApiEndPoints.PROFILE_DROP_LIST)
    Single<PublicationDropDownResponse> getProfileDropListUrlApiCall();

    @GET(ApiEndPoints.PROGRAM_OUTCOME)
    Single<ProgramOutcomeResponse> getProgramOutcomeApiCall();

    @GET(ApiEndPoints.VIEW_PROJECT_WORK)
    Single<ProjectWorkResponse> getProjectWorkUrlApiCall();

    @GET(ApiEndPoints.VIEW_PUBLICATION)
    Single<PublicationResponse> getPublicationUrlApiCall();

    @GET(ApiEndPoints.VIEW_Q_EXAM)
    Single<QualifiedExaminationResponse> getQualifiedExaminationUrlApiCall();

    @POST(ApiEndPoints.QUESTION_BANK_URL)
    Single<ArrayList<Materials>> getQuestionBankApiCall(@Body MaterialRequest request);

    @GET(ApiEndPoints.QUIZ_LIST)
    Single<QuizResponse> getQuizListApiCall();

    @POST("quiz/questions/{id}")
    Single<QuestionResponse> getQuizQuestionsApiCall(@Path("id") String id);

    @GET("transport/registerview")
    Single<RegisterViewResponse> getRegisterViewApiCall();

    @GET(ApiEndPoints.COLLEGE_REGISTER_URL)
    Single<ResetPassword> getRegistrationApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_PAY_SLIP)
    Single<RegistrationSlipResponse> getRegistrationSlipApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.REGISTRATION_SLIP_URL)
    Single<SemRegSlip> getRegistrationSlipUrl(@Field("id") String id);

    @POST(ApiEndPoints.REMARK_URL)
    Single<ArrayList<Remarks>> getRemarksApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_STUDENT)
    Single<ReplyResponse> getReplyApiCall(@Field("sub_id") String subId, @Field("comment_id") String commentId, @Field("view_reply") String reply);

    @GET(ApiEndPoints.RESET_PASSWORD)
    Single<Response<ResetPassword>> getResetPasswordApiCall();

    @POST(ApiEndPoints.RESULT_ASSIGNMENT_URL)
    Single<ArrayList<ResultAssignment>> getResultAssignmentApiCall(@Body AttendanceRequest request);

    @POST(ApiEndPoints.RESULT_INTERNAL_URL)
    Single<ArrayList<ResultInternal>> getResultInternalApiCall(@Body AttendanceRequest request);

    @POST(ApiEndPoints.RESULT_MODULE_TEST_URL)
    Single<ResultModuleTestResponse> getResultModuleTestApiCall(@Body AttendanceRequest request);

    @POST(ApiEndPoints.RESULT_SEASONAL_URL)
    Single<ArrayList<ResultSeasonal>> getResultSeasonalApiCall(@Body SeasonRequest request);

    @POST(ApiEndPoints.RESULT_UNIV_URL)
    Single<UnivResponse> getResultUnivApiCall(@Body AttendanceRequest request);

    @POST(ApiEndPoints.LAB_SAFETY)
    Single<ArrayList<String>> getSafetyApiCall(@Body LabEquipRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.SCST_REGISTER)
    Single<ExamMessageResponse> getScStPayUrlApiCall(@FieldMap Map<String, String> FeeCollection);

    @GET(ApiEndPoints.VIEW_SCHOLARSHIPS)
    Single<ScholarshipsResponse> getScholarshipsUrlApiCall();

    @FormUrlEncoded
    @POST("semreg/viewregistration")
    Single<SemRegViewResponse> getSemRegDetailsApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.SEM_REGISTRATION_VIEW_MVJCE)
    Single<SemRegViewResponse> getSemRegDetailsMvjceApiCall(@Field("id") String id);

    @GET(ApiEndPoints.SEM_REG_DROP_LIST)
    Single<AcademicYearResponse> getSemRegDropListApiCall();

    @POST(ApiEndPoints.SEM_REGISTER_LIST)
    Single<SemRegisterListResponse> getSemRegListApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.SEMESTER_LIST)
    Single<DepartmentListResponse> getSemesterListApiCall(@Field("dept_id") String id);

    @GET(ApiEndPoints.SEM_LIST_URL)
    Single<ArrayList<Semester>> getSemestersApiCall();

    @POST(ApiEndPoints.SERIES_EXAM)
    Single<SeriesExamResponse> getSeriesExamApiCall(@Body AttendanceRequest request);

    @POST(ApiEndPoints.SPECIAL_CLASS_URL)
    Single<ArrayList<SpecialResponse>> getSpecialClassApiCall();

    @GET(ApiEndPoints.VIEW_SPORT)
    Single<SportResponse> getSportUrlApiCall();

    @GET(ApiEndPoints.STATIONARY_LIST_URL)
    Single<StationaryItemResponse> getStationaryListApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.STATIONARY_PAY_URL)
    Single<AdvancePaymentResponse> getStationaryPaymentUrlApiCall(@FieldMap Map<String, String> productDetails);

    @GET(ApiEndPoints.STATIONARY_RECEIPT_URL)
    Single<StationaryReceiptResponse> getStationaryReceiptsApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.STORE_DATA)
    Single<StoreResponse> getStoreDataApiCall(@Field("subject_id") String subjectId);

    @POST(ApiEndPoints.STUDY_MATERIAL_URL)
    Single<ArrayList<MaterialsNew>> getStudyMaterialsApiCall(@Body MaterialRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_COVERAGE)
    Single<SubCoverageResponse> getSubjectCoverageApiCall(@Field("sub_id") String subId, @Field("batch_id") String batchId);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_LIST)
    Single<DepartmentListResponse> getSubjectListApiCall(@Field("dept_id") String dept_id, @Field("sem_id") String sem_id);

    @GET(ApiEndPoints.SUBJECT_REGISTRATION_LIST_URL)
    Single<SubjectRegistrationResponse> getSubjectRegistrationListApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_REGISTRATION_SPINNER_URL)
    Single<SubjectSpinnerResponse> getSubjectRegistrationSpinnerApiCall(@Field("sem_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_REGISTRATION_VIEW_URL)
    Single<ViewSubjectRegistrationResponse> getSubjectRegistrationViewApiCall(@Field("id") String id);

    @POST(ApiEndPoints.SUBJECT_URL)
    Single<ArrayList<Subjects>> getSubjectsApiCall(@Body MaterialRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_REGISTRATION_SPINNER_URL)
    Single<SubjectsListResponse> getSubjectsRegListApiCall(@Field("sem_id") String id);

    @POST(ApiEndPoints.SURVEY_URL)
    Single<ArrayList<Survey>> getSurveyApiCall();

    @GET(ApiEndPoints.SURVEY_MANDATORY_STATUS_API)
    Single<SurveyMandatory> getSurveyMandatoryStatusUrlApiCall();

    @GET(ApiEndPoints.SURVEY_PENDING_STATUS_API)
    Single<SurveyPending> getSurveyPendingStatusUrlApiCall();

    @POST(ApiEndPoints.SURVEY_QUESTION_URL)
    Single<ArrayList<SurveyQuestion>> getSurveyQuestionApiCall(@Body SurveyRequest request);

    @POST(ApiEndPoints.SURVEY_TEACHER_LIST_URL)
    Single<ArrayList<TeacherList>> getSurveyTeachersApiCall(@Body GenSurveyQuestionRequest request);

    @POST(ApiEndPoints.SYLLABUS_URL)
    Single<SyllabusResponse> getSyllabusApiCall(@Body CoSyllabusRequest request);

    @POST(ApiEndPoints.TEACHER_URL)
    Single<TeacherResponse> getTeacherApiCall();

    @GET("app/timetable")
    Single<TimetableResponse> getTimetableApiCall();

    @FormUrlEncoded
    @POST("transport/installments")
    Single<TransportFeeResponse> getTransFeeApiCall(@Field("year_id") String id);

    @GET(ApiEndPoints.TRANSPORT_BUS_PASS)
    Single<BusPass> getTransportBusPassApiCall();

    @GET("transport/installments")
    Single<TransportFeeResponse> getTransportFeeApiCall();

    @FormUrlEncoded
    @POST("transport/installments")
    Single<TransportFeeResponse> getTransportFeeApiCall(@Field("year_id") String id);

    @POST(ApiEndPoints.TRANSPORT_FEE_RECEIPTS_URL)
    Single<ReceiptResponse> getTransportFeeReceiptsApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.TRANSPORT_FEE_URL)
    Single<TransportPayUrl> getTransportFeeUrlApiCall(@FieldMap Map<String, String> transportFeeCollection);

    @GET(ApiEndPoints.TRANSPORT_HISTORY)
    Single<TransportHistoryResponse> getTransportHistoryUrlApiCall();

    @FormUrlEncoded
    @POST(ApiEndPoints.RESULT_TUTORIAL_URL)
    Single<TutorialResultResponse> getTutorialResultApiCall(@Field("sem_id") String semId);

    @POST(ApiEndPoints.TUTORIALS)
    Single<TutorialResponse> getTutorialsApiCall();

    @GET(ApiEndPoints.PROFILE_UPDATE_URL)
    Single<UpdateProfile> getUpdateProfileApiCall();

    @POST(ApiEndPoints.VIDEO_LIST_URL)
    Single<VideoResponse> getVideoClassApiCall(@Body MaterialRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.WATCH_VIDEO_URL)
    Single<SuccessResponse> getWatchVideoApiCall(@Field("video_id") String videoId, @Field("youtubeId") String youtubeId);

    @FormUrlEncoded
    @POST(ApiEndPoints.APPLY_MESS_ORDER)
    Single<SuccessResponse> messBookingApiCall(@Field("type") String type, @Field("HostelOrderMenuItems[menu_items_id]") String menu, @Field("HostelOrderMenuItems[quantity]") String qty);

    @POST(ApiEndPoints.GCEK_NEW_RE_REGISTRATION)
    @Multipart
    Observable<SuccessResponse> newHostelReRegistrationApiCall(@Part("HostelRegistration[readmission]") RequestBody reAdmission, @Part("HostelRegistration[category]") RequestBody category, @Part("HostelRegistration[local_guardian]") RequestBody localGuardian, @Part("HostelRegistration[local_guardian_phone]") RequestBody localGuardianPhone, @Part("HostelRegistration[annual_income]") RequestBody annualIncome, @Part("HostelRegistration[distance]") RequestBody distance, @Part("HostelRegistration[semester_id]") RequestBody semesterId, @Part MultipartBody.Part uploadFile, @Part("HostelRegistration[hostel_id]") RequestBody hostelId, @Part("HostelRegistration[year_count]") RequestBody yearCount, @Part("HostelRegistration[hostel_details]") RequestBody hostelDetails, @Part("HostelRegistration[is_fined]") RequestBody isFined, @Part("HostelRegistration[fine_details]") RequestBody fineDetails, @Part("HostelRegistration[fee_defaulter]") RequestBody feeDefaulter, @Part("HostelRegistration[fee_details]") RequestBody feeDetails);

    @POST(ApiEndPoints.GCEK_NEW_REGISTRATION)
    @Multipart
    Observable<SuccessResponse> newHostelRegistrationApiCall(@Part("HostelRegistration[readmission]") RequestBody reAdmission, @Part("HostelRegistration[category]") RequestBody category, @Part("HostelRegistration[local_guardian]") RequestBody localGuardian, @Part("HostelRegistration[local_guardian_phone]") RequestBody localGuardianPhone, @Part("HostelRegistration[annual_income]") RequestBody annualIncome, @Part("HostelRegistration[distance]") RequestBody distance, @Part("HostelRegistration[semester_id]") RequestBody semesterId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.NEW_QUIZ_SUBMIT)
    Single<QuizSubmitResponse> newQuizAnswerSubmit(@FieldMap Map<String, String> answerDetails);

    @POST(ApiEndPoints.NEW_QUIZ_SUBMIT)
    @Multipart
    Single<QuizSubmitResponse> newQuizAnswerUploadFinalSubmit(@Part("qno") RequestBody qNo, @Part("id") RequestBody id, @Part("final_submit") RequestBody finalSubmit, @Part MultipartBody.Part file);

    @POST(ApiEndPoints.NEW_QUIZ_SUBMIT)
    @Multipart
    Single<QuizSubmitResponse> newQuizAnswerUploadSubmit(@Part("qno") RequestBody qNo, @Part("id") RequestBody id, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ApiEndPoints.ACADEMIC_FEE_URL)
    Single<FeeUrlResponse> payFeesApiCall(@FieldMap Map<String, String> feeCollection, @FieldMap Map<String, String> feeReceipt);

    @FormUrlEncoded
    @POST("fee/academicfeeconfirm")
    Single<FeeSreeChitraUrl> payFeesSreeChitraApiCall(@FieldMap Map<String, String> feeCollection, @FieldMap Map<String, String> feeReceipt, @FieldMap Map<String, String> transaction, @Field("payment") String payment, @Field("installment") String installment);

    @FormUrlEncoded
    @POST(ApiEndPoints.PO_ANSWER_SUBMIT)
    Single<SuccessResponse> poAnswerSubmit(@FieldMap Map<String, String> answerDetails);

    @FormUrlEncoded
    @POST(ApiEndPoints.COURSE_SURVEY_ANSWERS)
    Single<SuccessResponse> postCourseSurveyAnswer(@FieldMap Map<String, String> answerCollection);

    @FormUrlEncoded
    @POST(ApiEndPoints.GRADUATE_EXIT_SURVEY_ANSWERS)
    Single<SuccessResponse> postGESurveyAnswer(@FieldMap Map<String, String> answerCollection);

    @POST("quiz/result/{id}")
    Single<QuizResultResponse> quizResultApiCall(@Path("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.QUIZ_RESULT)
    Single<QuizResultResponse> quizResultNewApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.QUIZ_STATUS)
    Single<SuccessResponse> quizSaveStatusApiCall(@Field("session_id") String sessionId, @Field("qid") String qId);

    @POST(ApiEndPoints.READ_MSG_URL)
    Single<SuccessResponse> readMsgApiCall(@Body MsgHandleRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.SEM_REGISTER_NEW)
    Single<SuccessResponse> registerSemsterNewApiCall(@FieldMap Map<String, String> SemRegistration);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_REGISTRATION_APPLY_URL)
    Single<SuccessResponse> registerSubjectRegistrationApiCall(@FieldMap Map<String, String> registerCollection);

    @FormUrlEncoded
    @POST(ApiEndPoints.COUNSELLING_REMIND)
    Single<SuccessResponse> remindCounsellingApiCall(@Field("CounsellingRequests[id]") String id, @Field("CounsellingRequests[reminder_description]") String description);

    @FormUrlEncoded
    @POST(ApiEndPoints.GRIEVANCE_REMIND)
    Single<SuccessResponse> remindGrievanceApiCall(@Field("Grievance_id") String id, @Field("reminder_description") String description);

    @FormUrlEncoded
    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_REMOVE_DATE_HOURS)
    Single<SuccessResponse> removeDateHourDutyLeaveDirectDatesApiCall(@Field("id") String id, @Field("date") String date);

    @FormUrlEncoded
    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_REMOVE_HOURS)
    Single<SuccessResponse> removeDutyLeaveDirectDatesApiCall(@Field("id") String id, @Field("date") String date, @Field("hour") String hour);

    @FormUrlEncoded
    @POST(ApiEndPoints.COUNSELLING_REOPEN)
    Single<SuccessResponse> reopenCounsellingApiCall(@Field("CounsellingRequests[id]") String id, @Field("CounsellingRequests[counselling_type]") String type, @Field("CounsellingRequests[concern]") String concern, @Field("CounsellingRequests[impact_home]") String home, @Field("CounsellingRequests[impact_studies]") String studies, @Field("CounsellingRequests[impact_relationship]") String relationship, @Field("CounsellingRequests[impact_physically_emotionally]") String physical, @Field("CounsellingRequests[counselling_history]") String history, @Field("CounsellingRequests[counselling_session_required]") String session, @Field("CounsellingRequests[comments]") String comments);

    @FormUrlEncoded
    @POST(ApiEndPoints.GRIEVANCE_REOPEN)
    Single<SuccessResponse> reopenGrievanceApiCall(@PartMap HashMap<String, RequestBody> partMap, @Part ArrayList<MultipartBody.Part> images);

    @POST(ApiEndPoints.ACTIVITY_REQUEST)
    @Multipart
    Observable<SuccessResponse> requestActivityApiCall(@Part("id") RequestBody id, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ApiEndPoints.ACTIVITY_REQUEST)
    Single<SuccessResponse> requestActivityApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.COUNSELLING_REVIEW)
    Single<SuccessResponse> reviewCounsellingApiCall(@Field("CounsellingRequests[id]") String id, @Field("CounsellingRequests[remarks]") String description);

    @POST("semreg/registration")
    @Multipart
    Observable<SemRegSuccessResponse> semRegisterApiCall(@PartMap HashMap<String, RequestBody> partMap, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("semreg/registration")
    Observable<SemRegSuccessResponse> semRegisterApiCall(@FieldMap Map<String, String> SemesterRegistration);

    @POST(ApiEndPoints.PUSH_REGISTER_URL)
    Single<PushResponse> sendPushTokenApiCall(@Body PushRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_STUDENT)
    Single<SuccessResponse> setCommentsApiCall(@Field("sub_id") String subId, @Field("batch_id") String batchId, @Field("sem_id") String semId, @Field("comment") String comment);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_PARENT)
    Single<SuccessResponse> setParentCommentsApiCall(@Field("batch_id") String batchId, @Field("sem_id") String semId, @Field("comment") String comment);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_PARENT)
    Single<SuccessResponse> setParentReplyApiCall(@Field("batch_id") String batchId, @Field("sem_id") String semId, @Field("comment_id") String commentId, @Field("reply") String reply);

    @FormUrlEncoded
    @POST(ApiEndPoints.CHAT_STUDENT)
    Single<SuccessResponse> setReplyApiCall(@Field("sub_id") String subId, @Field("batch_id") String batchId, @Field("sem_id") String semId, @Field("comment_id") String commentId, @Field("reply") String reply);

    @FormUrlEncoded
    @POST(ApiEndPoints.ACADEMIC_FEE_URL)
    Single<FeeUrlResponse> submitFeesApiCall(@FieldMap Map<String, String> feeCollection, @FieldMap Map<String, String> feeReceipt);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBMIT_SURVEY_URL)
    Single<SubmitResponse> submitGenSurveyApiCall(@Field("survey_id") String surveyId, @Field("AnswerDetail[remark]") String remark, @FieldMap Map<String, String> descAnswer);

    @POST(ApiEndPoints.SUBMIT_HOMEWORK)
    @Multipart
    Observable<SuccessResponse> submitHomeWorkApiCall(@Part("id") RequestBody id, @Part MultipartBody.Part file);

    @POST("quiz/answer/{id}")
    Single<QuizSubmitResponse> submitQuizAnswersApiCall(@Path("id") String id, @Body SubmitRequest request);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBMIT_SURVEY_URL)
    Single<SubmitResponse> submitSurveyApiCall(@Field("survey_id") String surveyId, @Field("teacher_id") String teacherId, @Field("subject_id") String subjectId, @Field("AnswerDetail[remark]") String remark, @Field("AnswerDetail[special_remark]") String specialRemark, @FieldMap Map<String, String> option);

    @POST(ApiEndPoints.SUBMIT_TUTORIALS)
    @Multipart
    Observable<SuccessResponse> submitTutorialApiCall(@Part("id") RequestBody id, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ApiEndPoints.LIBRARY_SUGGEST_BOOK)
    Single<SuccessResponse> suggestBookApiCall(@FieldMap Map<String, String> studentDetails);

    @FormUrlEncoded
    @POST("semreg/update")
    Single<SuccessResponse> updaateAsietSemRegApiCall(@FieldMap Map<String, String> semesterRegistration);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_ACHIEVEMENTS)
    Single<SuccessResponse> updateAchievementUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.EDIT_ACHIEVEMENTS)
    @Multipart
    Single<SuccessResponse> updateAchievementUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.UPDATE_BANK_DETAILS)
    Single<SuccessResponse> updateBankDetailsApiCall(@FieldMap Map<String, String> studentDetails);

    @POST(ApiEndPoints.UPDATE_COUNSELLING)
    @Multipart
    Observable<SuccessResponse> updateCounsellingApiCall(@Part("id") RequestBody id, @PartMap HashMap<String, RequestBody> partMap);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_COURSE_ATTENDED)
    Single<SuccessResponse> updateCoursesUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_5]") String organizedBy, @Field("StudentProfile[duration]") String duration, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_desc_3]") String achievements, @Field("StudentProfile[attr_date_1]") String fromDate, @Field("StudentProfile[attr_date_2]") String toDate);

    @POST(ApiEndPoints.EDIT_COURSE_ATTENDED)
    @Multipart
    Single<SuccessResponse> updateCoursesUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_5]") RequestBody organizedBy, @Part("StudentProfile[duration]") RequestBody duration, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_desc_3]") RequestBody achievements, @Part("StudentProfile[attr_date_1]") RequestBody fromDate, @Part("StudentProfile[attr_date_2]") RequestBody toDate, @Part MultipartBody.Part uploadFile);

    @POST(ApiEndPoints.DUTY_LEAVE_DIRECT_UPDATE)
    @Multipart
    Single<SuccessResponse> updateDutyLeaveDirectViewApiCall(@Part("id") RequestBody id, @Part("DutyLeaveStudentApply[reason]") RequestBody reason, @Part("DutyLeaveStudentApply[dutyleavehead_id]") RequestBody headId, @Part("DutyLeaveStudentApply[from_date]") RequestBody fromDate, @Part("DutyLeaveStudentApply[to_date]") RequestBody toDate, @Part MultipartBody.Part uploadFile);

    @POST(ApiEndPoints.UPDATE_GRIEVANCE)
    @Multipart
    Observable<SuccessResponse> updateGrievanceApiCall(@Part("id") RequestBody id, @PartMap HashMap<String, RequestBody> partMap, @Part ArrayList<MultipartBody.Part> images);

    @POST(ApiEndPoints.GCEK_UPDATE_REGISTRATION)
    @Multipart
    Observable<SuccessResponse> updateHostelRegistrationApiCall(@Part("id") RequestBody id, @Part("HostelRegistration[readmission]") RequestBody reAdmission, @Part("HostelRegistration[category]") RequestBody category, @Part("HostelRegistration[local_guardian]") RequestBody localGuardian, @Part("HostelRegistration[local_guardian_phone]") RequestBody localGuardianPhone, @Part("HostelRegistration[annual_income]") RequestBody annualIncome, @Part("HostelRegistration[distance]") RequestBody distance, @Part("HostelRegistration[semester_id]") RequestBody semesterId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_MEMBERSHIP)
    Single<SuccessResponse> updateMembershipUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_3]") String type, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_int_1]") String memberId, @Field("StudentProfile[attr_desc_6]") String description);

    @POST(ApiEndPoints.EDIT_MEMBERSHIP)
    @Multipart
    Single<SuccessResponse> updateMembershipUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_3]") RequestBody type, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_int_1]") RequestBody memberId, @Part("StudentProfile[attr_desc_6]") RequestBody description, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_MOOC_COURSE)
    Single<SuccessResponse> updateMoocCoursesUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_4]") String provider, @Field("StudentProfile[attr_date_1]") String fromDate, @Field("StudentProfile[attr_date_2]") String toDate, @Field("StudentProfile[duration]") String duration, @Field("StudentProfile[attr_desc_5]") String achievements);

    @POST(ApiEndPoints.EDIT_MOOC_COURSE)
    @Multipart
    Single<SuccessResponse> updateMoocCoursesUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_4]") RequestBody provider, @Part("StudentProfile[attr_date_1]") RequestBody fromDate, @Part("StudentProfile[attr_date_2]") RequestBody toDate, @Part("StudentProfile[duration]") RequestBody duration, @Part("StudentProfile[attr_desc_5]") RequestBody achievements, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_POSITION)
    Single<SuccessResponse> updatePositionHeldUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_date_1]") String fromDate, @Field("StudentProfile[attr_date_2]") String toDate);

    @POST(ApiEndPoints.EDIT_POSITION)
    @Multipart
    Single<SuccessResponse> updatePositionHeldUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_date_1]") RequestBody fromDate, @Part("StudentProfile[attr_date_2]") RequestBody toDate, @Part MultipartBody.Part uploadFile);

    @POST(ApiEndPoints.UPDATE_PROFILE_URL)
    @Multipart
    Observable<SuccessResponse> updateProPicApiCall(@Part MultipartBody.Part file, @Part MultipartBody.Part sign);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_PROJECT_WORK)
    Single<SuccessResponse> updateProjectWorkUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_1]") String type, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_desc_2]") String details);

    @POST(ApiEndPoints.EDIT_PROJECT_WORK)
    @Multipart
    Single<SuccessResponse> updateProjectWorkUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_1]") RequestBody type, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_desc_2]") RequestBody details, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_PUBLICATION)
    Single<SuccessResponse> updatePublicationUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_desc_3]") String journal, @Field("StudentProfile[attr_desc_4]") String conference, @Field("StudentProfile[attr_desc_5]") String index, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.EDIT_PUBLICATION)
    @Multipart
    Single<SuccessResponse> updatePublicationUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_desc_3]") RequestBody journal, @Part("StudentProfile[attr_desc_4]") RequestBody conference, @Part("StudentProfile[attr_desc_5]") RequestBody index, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_Q_EXAM)
    Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String name, @Field("StudentProfile[attr_desc_1]") String score, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.EDIT_Q_EXAM)
    @Multipart
    Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody name, @Part("StudentProfile[attr_desc_1]") RequestBody score, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_RESEARCH)
    Single<SuccessResponse> updateResearchUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_2]") String title, @Field("StudentProfile[attr_int_1]") String amount, @Field("StudentProfile[attr_desc_4]") String agency, @Field("StudentProfile[duration]") String duration, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.EDIT_RESEARCH)
    @Multipart
    Single<SuccessResponse> updateResearchUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_2]") RequestBody title, @Part("StudentProfile[attr_int_1]") RequestBody amount, @Part("StudentProfile[attr_desc_4]") RequestBody agency, @Part("StudentProfile[duration]") RequestBody duration, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_SCHOLARSHIPS)
    Single<SuccessResponse> updateScholarshipUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_1]") String type, @Field("StudentProfile[attr_desc_2]") String details, @Field("StudentProfile[year_id]") String yearId);

    @POST(ApiEndPoints.EDIT_SCHOLARSHIPS)
    @Multipart
    Single<SuccessResponse> updateScholarshipUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_1]") RequestBody type, @Part("StudentProfile[attr_desc_2]") RequestBody details, @Part("StudentProfile[year_id]") RequestBody yearId, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST("semreg/update")
    Observable<SemRegSuccessResponse> updateSemRegisterApiCall(@Field("id") String id, @FieldMap Map<String, String> partMap);

    @POST("semreg/update")
    @Multipart
    Observable<SemRegSuccessResponse> updateSemRegisterApiCall(@Part("id") RequestBody id, @PartMap HashMap<String, RequestBody> partMap, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ApiEndPoints.EDIT_SPORT)
    Single<SuccessResponse> updateSportUrlApiCall(@Field("id") String id, @Field("StudentProfile[attr_desc_1]") String title, @Field("StudentProfile[attr_desc_2]") String eventName, @Field("StudentProfile[attr_desc_5]") String organizedBy, @Field("StudentProfile[attr_desc_3]") String eventType, @Field("StudentProfile[attr_desc_4]") String level, @Field("StudentProfile[attr_date_1]") String date, @Field("StudentProfile[year_id]") String yearId, @Field("StudentProfile[attr_desc_6]") String awards);

    @POST(ApiEndPoints.EDIT_SPORT)
    @Multipart
    Single<SuccessResponse> updateSportUrlApiCall(@Part("id") RequestBody id, @Part("StudentProfile[attr_desc_1]") RequestBody title, @Part("StudentProfile[attr_desc_2]") RequestBody eventName, @Part("StudentProfile[attr_desc_5]") RequestBody organizedBy, @Part("StudentProfile[attr_desc_3]") RequestBody eventType, @Part("StudentProfile[attr_desc_4]") RequestBody level, @Part("StudentProfile[attr_date_1]") RequestBody date, @Part("StudentProfile[year_id]") RequestBody yearId, @Part("StudentProfile[attr_desc_6]") RequestBody awards, @Part MultipartBody.Part uploadFile);

    @FormUrlEncoded
    @POST(ApiEndPoints.SUBJECT_REGISTRATION_UPDATE_URL)
    Single<SuccessResponse> updateSubjectRegistrationApiCall(@FieldMap Map<String, String> registerCollection);

    @POST(ApiEndPoints.UPLOAD_ASSIGNMENT_URL)
    @Multipart
    Observable<SuccessResponse> uploadAssignmentApiCall(@Part("LoginForm[username]") RequestBody username, @Part("LoginForm[password]") RequestBody password, @Part("assignment_id") RequestBody id, @Part MultipartBody.Part file);

    @POST(ApiEndPoints.UPLOAD_COVID_CERTIFICATE_URL)
    @Multipart
    Observable<SuccessResponse> uploadCovidCertificateApiCall(@Part MultipartBody.Part vaccineFile);

    @POST(ApiEndPoints.UPLOAD_COVID_CERTIFICATE_TWO_URL)
    @Multipart
    Observable<SuccessResponse> uploadCovidCertificateTwoApiCall(@Part MultipartBody.Part vaccineFileTwo);

    @POST(ApiEndPoints.INTERNSHIP_UPLOAD)
    @Multipart
    Observable<SuccessResponse> uploadInternshipApiCall(@Part("id") RequestBody id, @Part MultipartBody.Part file);

    @POST(ApiEndPoints.SUBMIT_MODULE_TEST)
    @Multipart
    Observable<SuccessResponse> uploadModuleTestApiCall(@Part("LoginForm[username]") RequestBody username, @Part("LoginForm[password]") RequestBody password, @Part("id") RequestBody id, @Part MultipartBody.Part file);

    @POST("quiz/upload/{id}")
    @Multipart
    Observable<ArrayList<QuizFileUploadResponse>> uploadQuizApiCall(@Path("id") String id, @Part MultipartBody.Part file);

    @POST(ApiEndPoints.SUBMIT_SERIES_EXAM)
    @Multipart
    Observable<SuccessResponse> uploadSeriesExamApiCall(@Part("LoginForm[username]") RequestBody username, @Part("LoginForm[password]") RequestBody password, @Part("id") RequestBody id, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ApiEndPoints.EXAM_VERIFY_ABC_ID)
    Single<SuccessResponse> verifyAbcIdApiCall(@Field("abc_id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.VERIFY_BANK_DETAILS)
    Single<SuccessResponse> verifyBankDetailsApiCall(@FieldMap Map<String, String> studentDetails);

    @FormUrlEncoded
    @POST(ApiEndPoints.COUNSELLING_VIEW)
    Single<ViewCounsellingResponse> viewCounsellingApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST(ApiEndPoints.VIEW_GRIEVANCE)
    Single<ViewGrievanceResponse> viewGrievanceApiCall(@Field("id") String id);

    @POST(ApiEndPoints.GCEK_VIEW_REGISTRATION)
    @Multipart
    Single<ViewRegistrationResponse> viewRegistrationApiCall(@Part("id") RequestBody id);
}