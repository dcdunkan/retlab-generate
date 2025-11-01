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
@Metadata(d1 = {"\u0000¬\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001bH\u0016JF\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016JP\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016JJ\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b0&j\b\u0012\u0004\u0012\u00020\u000b`'H\u0016J6\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016J@\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J>\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016JH\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J.\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016J8\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0016J0\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J@\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J@\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JN\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0016JX\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010B\u001a\u0004\u0018\u00010\u00072\b\u0010C\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J(\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J8\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010C\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016J,\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010C\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010N\u001a\u00020OH\u0016J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010N\u001a\u00020TH\u0016J\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010N\u001a\u00020dH\u0016J\u0018\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0016\u0010k\u001a\b\u0012\u0004\u0012\u00020l0\u00042\u0006\u0010N\u001a\u00020mH\u0016J\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010N\u001a\u00020oH\u0016J\u0016\u0010p\u001a\b\u0012\u0004\u0012\u00020q0\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J \u0010r\u001a\b\u0012\u0004\u0012\u00020s0\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010N\u001a\u00020tH\u0016J\u0016\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u000e\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u0004H\u0016J\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u0004H\u0016J\u000e\u0010z\u001a\b\u0012\u0004\u0012\u00020{0\u0004H\u0016J\"\u0010|\u001a\b\u0012\u0004\u0012\u00020}0\u00042\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u000f\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u0004H\u0016J\u0019\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010\u00042\u0007\u0010N\u001a\u00030\u0083\u0001H\u0016J\u0019\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u00042\u0007\u0010N\u001a\u00030\u0086\u0001H\u0016J\u0019\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u00042\u0007\u0010N\u001a\u00030\u0089\u0001H\u0016J\u0019\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J\u0010\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\u0004H\u0016J\u0010\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\u0004H\u0016J\u0010\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u0004H\u0016J\u0010\u0010\u0093\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u00010\u0004H\u0016J\u0010\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u0004H\u0016J\u0010\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010\u0004H\u0016J!\u0010\u0099\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u009a\u00010&j\t\u0012\u0005\u0012\u00030\u009a\u0001`'0\u0004H\u0016J*\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u0007H\u0016J\u0010\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030 \u00010\u0004H\u0016J!\u0010¡\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030¢\u00010&j\t\u0012\u0005\u0012\u00030¢\u0001`'0\u0004H\u0016J$\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00010\u00042\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010¦\u0001\u001a\u00020\u0007H\u0016J\u0010\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010\u0004H\u0016J\u0010\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030ª\u00010\u0004H\u0016J\u0010\u0010«\u0001\u001a\t\u0012\u0005\u0012\u00030¬\u00010\u0004H\u0016J\u0010\u0010\u00ad\u0001\u001a\t\u0012\u0005\u0012\u00030®\u00010\u0004H\u0016J*\u0010¯\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030°\u00010&j\t\u0012\u0005\u0012\u00030°\u0001`'0\u00042\u0007\u0010N\u001a\u00030±\u0001H\u0016J\u0010\u0010²\u0001\u001a\t\u0012\u0005\u0012\u00030³\u00010\u0004H\u0016J\u0010\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u00010\u0004H\u0016J\u0010\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030·\u00010\u0004H\u0016J\u0010\u0010¸\u0001\u001a\t\u0012\u0005\u0012\u00030¹\u00010\u0004H\u0016J\u0018\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030»\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010¼\u0001\u001a\t\u0012\u0005\u0012\u00030½\u00010\u0004H\u0016J\u0018\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0007\u0010N\u001a\u00030¿\u0001H\u0016J\u0010\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\u0004H\u0016J\u0010\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\u0004H\u0016J\u0018\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030Ä\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030Æ\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010Ç\u0001\u001a\t\u0012\u0005\u0012\u00030È\u00010\u0004H\u0016J:\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u00042\u0013\u0010Ë\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010Ì\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0010\u0010Í\u0001\u001a\t\u0012\u0005\u0012\u00030È\u00010\u0004H\u0016J*\u0010Î\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ï\u00010&j\t\u0012\u0005\u0012\u00030Ï\u0001`'0\u00042\u0007\u0010N\u001a\u00030Ð\u0001H\u0016J\u0018\u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ò\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010Ó\u0001\u001a\t\u0012\u0005\u0012\u00030Ô\u00010\u0004H\u0016J\u0010\u0010Õ\u0001\u001a\t\u0012\u0005\u0012\u00030Ö\u00010\u0004H\u0016J$\u0010×\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010\u00042\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J*\u0010Ù\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ú\u00010&j\t\u0012\u0005\u0012\u00030Ú\u0001`'0\u00042\u0007\u0010N\u001a\u00030Û\u0001H\u0016J*\u0010Ü\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ý\u00010&j\t\u0012\u0005\u0012\u00030Ý\u0001`'0\u00042\u0007\u0010N\u001a\u00030Þ\u0001H\u0016J\u0018\u0010ß\u0001\u001a\t\u0012\u0005\u0012\u00030à\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J$\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030â\u00010\u00042\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0010\u0010ã\u0001\u001a\t\u0012\u0005\u0012\u00030ä\u00010\u0004H\u0016J\u0010\u0010å\u0001\u001a\t\u0012\u0005\u0012\u00030æ\u00010\u0004H\u0016J\u0018\u0010ç\u0001\u001a\t\u0012\u0005\u0012\u00030è\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010é\u0001\u001a\t\u0012\u0005\u0012\u00030ê\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J%\u0010ë\u0001\u001a\t\u0012\u0005\u0012\u00030ì\u00010\u00042\u0013\u0010í\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J%\u0010î\u0001\u001a\t\u0012\u0005\u0012\u00030ì\u00010\u00042\u0013\u0010í\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J%\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u00042\u0013\u0010í\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0018\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030ñ\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010ò\u0001\u001a\t\u0012\u0005\u0012\u00030ó\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010ô\u0001\u001a\t\u0012\u0005\u0012\u00030õ\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J%\u0010ö\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u00042\u0013\u0010í\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0018\u0010÷\u0001\u001a\t\u0012\u0005\u0012\u00030ø\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010ù\u0001\u001a\t\u0012\u0005\u0012\u00030ú\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010û\u0001\u001a\t\u0012\u0005\u0012\u00030ü\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010ý\u0001\u001a\t\u0012\u0005\u0012\u00030þ\u00010\u0004H\u0016J(\u0010ÿ\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070&j\b\u0012\u0004\u0012\u00020\u0007`'0\u00042\u0007\u0010N\u001a\u00030Þ\u0001H\u0016J\u0010\u0010\u0080\u0002\u001a\t\u0012\u0005\u0012\u00030\u0081\u00020\u0004H\u0016J\u0018\u0010\u0080\u0002\u001a\t\u0012\u0005\u0012\u00030\u0081\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0082\u0002\u001a\t\u0012\u0005\u0012\u00030\u0083\u00020\u0004H\u0016J\u0010\u0010\u0084\u0002\u001a\t\u0012\u0005\u0012\u00030\u0085\u00020\u0004H\u0016J\u0010\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030\u0087\u00020\u0004H\u0016J\u0010\u0010\u0088\u0002\u001a\t\u0012\u0005\u0012\u00030\u0089\u00020\u0004H\u0016J\u0019\u0010\u008a\u0002\u001a\t\u0012\u0005\u0012\u00030\u0085\u00020\u00042\u0007\u0010\u008b\u0002\u001a\u00020\u0007H\u0016J\u0010\u0010\u008c\u0002\u001a\t\u0012\u0005\u0012\u00030\u008d\u00020\u0004H\u0016J\u0010\u0010\u008e\u0002\u001a\t\u0012\u0005\u0012\u00030\u008f\u00020\u0004H\u0016J\u001b\u0010\u0090\u0002\u001a\t\u0012\u0005\u0012\u00030\u0091\u00020\u00042\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0093\u0002\u001a\t\u0012\u0005\u0012\u00030\u0094\u00020\u0004H\u0016J\u0010\u0010\u0095\u0002\u001a\t\u0012\u0005\u0012\u00030\u0096\u00020\u0004H\u0016J\u0010\u0010\u0097\u0002\u001a\t\u0012\u0005\u0012\u00030\u0098\u00020\u0004H\u0016J*\u0010\u0099\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u009a\u00020&j\t\u0012\u0005\u0012\u00030\u009a\u0002`'0\u00042\u0007\u0010N\u001a\u00030\u009b\u0002H\u0016J\u0010\u0010\u009c\u0002\u001a\t\u0012\u0005\u0012\u00030\u009d\u00020\u0004H\u0016J\u0018\u0010\u009e\u0002\u001a\t\u0012\u0005\u0012\u00030\u009f\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010 \u0002\u001a\t\u0012\u0005\u0012\u00030¡\u00020\u0004H\u0016J\u0010\u0010¢\u0002\u001a\t\u0012\u0005\u0012\u00030£\u00020\u0004H\u0016J\u0010\u0010¤\u0002\u001a\t\u0012\u0005\u0012\u00030¥\u00020\u0004H\u0016J\u0010\u0010¦\u0002\u001a\t\u0012\u0005\u0012\u00030§\u00020\u0004H\u0016J0\u0010¨\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0007\u0010©\u0002\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0016J\u0017\u0010ª\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\"\u0010«\u0002\u001a\t\u0012\u0005\u0012\u00030¬\u00020\u00042\u0007\u0010\u00ad\u0002\u001a\u00020\u00072\u0007\u0010®\u0002\u001a\u00020\u0007H\u0016J\u0017\u0010¯\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J:\u0010°\u0002\u001a\t\u0012\u0005\u0012\u00030±\u00020\u00042\u0013\u0010²\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010³\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J:\u0010´\u0002\u001a\t\u0012\u0005\u0012\u00030µ\u00020\u00042\u0013\u0010²\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010³\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J:\u0010¶\u0002\u001a\t\u0012\u0005\u0012\u00030·\u00020\u00042\u0013\u0010²\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010³\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0010\u0010¸\u0002\u001a\t\u0012\u0005\u0012\u00030¹\u00020\u0004H\u0016J\u0018\u0010º\u0002\u001a\t\u0012\u0005\u0012\u00030»\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010¼\u0002\u001a\t\u0012\u0005\u0012\u00030½\u00020\u0004H\u0016J\u0010\u0010¾\u0002\u001a\t\u0012\u0005\u0012\u00030¿\u00020\u0004H\u0016J\u0018\u0010À\u0002\u001a\t\u0012\u0005\u0012\u00030Á\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010Â\u0002\u001a\t\u0012\u0005\u0012\u00030Á\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010Ã\u0002\u001a\t\u0012\u0005\u0012\u00030Á\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010Ä\u0002\u001a\t\u0012\u0005\u0012\u00030Å\u00020\u0004H\u0016J\u0010\u0010Æ\u0002\u001a\t\u0012\u0005\u0012\u00030Ç\u00020\u0004H\u0016J\u0010\u0010È\u0002\u001a\t\u0012\u0005\u0012\u00030É\u00020\u0004H\u0016J\u0010\u0010Ê\u0002\u001a\t\u0012\u0005\u0012\u00030Ë\u00020\u0004H\u0016J\u0010\u0010Ì\u0002\u001a\t\u0012\u0005\u0012\u00030Ë\u00020\u0004H\u0016J\u0010\u0010Í\u0002\u001a\t\u0012\u0005\u0012\u00030Î\u00020\u0004H\u0016J\u0017\u0010Ï\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0017\u0010Ð\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010Ñ\u0002\u001a\t\u0012\u0005\u0012\u00030Ò\u00020\u0004H\u0016J\u0010\u0010Ó\u0002\u001a\t\u0012\u0005\u0012\u00030Ô\u00020\u0004H\u0016J\u0010\u0010Õ\u0002\u001a\t\u0012\u0005\u0012\u00030Ö\u00020\u0004H\u0016J!\u0010×\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ø\u00020&j\t\u0012\u0005\u0012\u00030Ø\u0002`'0\u0004H\u0016J\u0010\u0010Ù\u0002\u001a\t\u0012\u0005\u0012\u00030½\u00010\u0004H\u0016J\u0010\u0010Ú\u0002\u001a\t\u0012\u0005\u0012\u00030Û\u00020\u0004H\u0016J!\u0010Ü\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ý\u00020&j\t\u0012\u0005\u0012\u00030Ý\u0002`'0\u0004H\u0016J!\u0010Þ\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030ß\u00020&j\t\u0012\u0005\u0012\u00030ß\u0002`'0\u0004H\u0016J\u0010\u0010à\u0002\u001a\t\u0012\u0005\u0012\u00030á\u00020\u0004H\u0016J\u0010\u0010â\u0002\u001a\t\u0012\u0005\u0012\u00030ã\u00020\u0004H\u0016J\u0010\u0010ä\u0002\u001a\t\u0012\u0005\u0012\u00030å\u00020\u0004H\u0016J\u0010\u0010æ\u0002\u001a\t\u0012\u0005\u0012\u00030ç\u00020\u0004H\u0016J\u0010\u0010è\u0002\u001a\t\u0012\u0005\u0012\u00030é\u00020\u0004H\u0016J\u0010\u0010ê\u0002\u001a\t\u0012\u0005\u0012\u00030ë\u00020\u0004H\u0016J#\u0010ì\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J!\u0010í\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030î\u00020&j\t\u0012\u0005\u0012\u00030î\u0002`'0\u0004H\u0016J\u0010\u0010ï\u0002\u001a\t\u0012\u0005\u0012\u00030ð\u00020\u0004H\u0016J\u0010\u0010ñ\u0002\u001a\t\u0012\u0005\u0012\u00030ò\u00020\u0004H\u0016J\u0010\u0010ó\u0002\u001a\t\u0012\u0005\u0012\u00030ô\u00020\u0004H\u0016J\u0010\u0010õ\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00020\u0004H\u0016J\u0018\u0010õ\u0002\u001a\t\u0012\u0005\u0012\u00030ò\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010÷\u0002\u001a\t\u0012\u0005\u0012\u00030ø\u00020\u0004H\u0016J\u0019\u0010ù\u0002\u001a\t\u0012\u0005\u0012\u00030ú\u00020\u00042\u0007\u0010û\u0002\u001a\u00020\u0007H\u0016J\u0010\u0010ü\u0002\u001a\t\u0012\u0005\u0012\u00030ý\u00020\u0004H\u0016J\u0018\u0010þ\u0002\u001a\t\u0012\u0005\u0012\u00030ÿ\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0080\u0003\u001a\t\u0012\u0005\u0012\u00030\u0081\u00030\u0004H\u0016J\u0010\u0010\u0082\u0003\u001a\t\u0012\u0005\u0012\u00030\u0083\u00030\u0004H\u0016J\u0010\u0010\u0084\u0003\u001a\t\u0012\u0005\u0012\u00030\u0085\u00030\u0004H\u0016J\u0010\u0010\u0086\u0003\u001a\t\u0012\u0005\u0012\u00030\u0087\u00030\u0004H\u0016J!\u0010\u0088\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u0089\u00030&j\t\u0012\u0005\u0012\u00030\u0089\u0003`'0\u0004H\u0016J\u0010\u0010\u008a\u0003\u001a\t\u0012\u0005\u0012\u00030\u008b\u00030\u0004H\u0016J\u0010\u0010\u008c\u0003\u001a\t\u0012\u0005\u0012\u00030\u008d\u00030\u0004H\u0016J$\u0010\u008e\u0003\u001a\t\u0012\u0005\u0012\u00030¤\u00010\u00042\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00072\u0007\u0010¦\u0001\u001a\u00020\u0007H\u0016J/\u0010\u008f\u0003\u001a\t\u0012\u0005\u0012\u00030\u0090\u00030\u00042\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00072\t\u0010\u0091\u0003\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0092\u0003\u001a\u00020\u0007H\u0016J\u0018\u0010\u0093\u0003\u001a\t\u0012\u0005\u0012\u00030\u0094\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0095\u0003\u001a\t\u0012\u0005\u0012\u00030\u0096\u00030\u0004H\u0016J\u0010\u0010\u0097\u0003\u001a\t\u0012\u0005\u0012\u00030\u0098\u00030\u0004H\u0016J$\u0010\u0099\u0003\u001a\t\u0012\u0005\u0012\u00030\u009a\u00030\u00042\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J!\u0010\u009b\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u009c\u00030&j\t\u0012\u0005\u0012\u00030\u009c\u0003`'0\u0004H\u0016J\u0018\u0010\u009d\u0003\u001a\t\u0012\u0005\u0012\u00030\u009e\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u009f\u0003\u001a\t\u0012\u0005\u0012\u00030 \u00030\u0004H\u0016J\u0010\u0010¡\u0003\u001a\t\u0012\u0005\u0012\u00030¢\u00030\u0004H\u0016J\u0010\u0010£\u0003\u001a\t\u0012\u0005\u0012\u00030¤\u00030\u0004H\u0016J*\u0010¥\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030¦\u00030&j\t\u0012\u0005\u0012\u00030¦\u0003`'0\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J\u0010\u0010§\u0003\u001a\t\u0012\u0005\u0012\u00030¨\u00030\u0004H\u0016J\u0010\u0010©\u0003\u001a\t\u0012\u0005\u0012\u00030ª\u00030\u0004H\u0016J\u0010\u0010«\u0003\u001a\t\u0012\u0005\u0012\u00030¬\u00030\u0004H\u0016J\u0010\u0010\u00ad\u0003\u001a\t\u0012\u0005\u0012\u00030®\u00030\u0004H\u0016J\u0010\u0010¯\u0003\u001a\t\u0012\u0005\u0012\u00030°\u00030\u0004H\u0016J\u0010\u0010±\u0003\u001a\t\u0012\u0005\u0012\u00030²\u00030\u0004H\u0016J\u0010\u0010³\u0003\u001a\t\u0012\u0005\u0012\u00030´\u00030\u0004H\u0016J*\u0010µ\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030¶\u00030&j\t\u0012\u0005\u0012\u00030¶\u0003`'0\u00042\u0007\u0010N\u001a\u00030·\u0003H\u0016J\u0010\u0010¸\u0003\u001a\t\u0012\u0005\u0012\u00030¹\u00030\u0004H\u0016J\u001a\u0010º\u0003\u001a\t\u0012\u0005\u0012\u00030»\u00030\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010¼\u0003\u001a\t\u0012\u0005\u0012\u00030½\u00030\u0004H\u0016J\u0010\u0010¾\u0003\u001a\t\u0012\u0005\u0012\u00030¿\u00030\u0004H\u0016J\u0018\u0010À\u0003\u001a\t\u0012\u0005\u0012\u00030Á\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010Â\u0003\u001a\t\u0012\u0005\u0012\u00030Ã\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J!\u0010Ä\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Å\u00030&j\t\u0012\u0005\u0012\u00030Å\u0003`'0\u0004H\u0016J/\u0010Æ\u0003\u001a\t\u0012\u0005\u0012\u00030\u0090\u00030\u00042\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0091\u0003\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0092\u0003\u001a\u00020\u0007H\u0016J\u0017\u0010Ç\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030¿\u00030È\u00030\u0004H\u0016J*\u0010É\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ê\u00030&j\t\u0012\u0005\u0012\u00030Ê\u0003`'0\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J*\u0010Ë\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ì\u00030&j\t\u0012\u0005\u0012\u00030Ì\u0003`'0\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J\u0019\u0010Í\u0003\u001a\t\u0012\u0005\u0012\u00030Î\u00030\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J*\u0010Ï\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ð\u00030&j\t\u0012\u0005\u0012\u00030Ð\u0003`'0\u00042\u0007\u0010N\u001a\u00030Ñ\u0003H\u0016J\u0019\u0010Ò\u0003\u001a\t\u0012\u0005\u0012\u00030Ó\u00030\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J(\u0010Ô\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070&j\b\u0012\u0004\u0012\u00020\u0007`'0\u00042\u0007\u0010N\u001a\u00030Û\u0001H\u0016J$\u0010Õ\u0003\u001a\t\u0012\u0005\u0012\u00030\u009a\u00030\u00042\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0010\u0010Ö\u0003\u001a\t\u0012\u0005\u0012\u00030×\u00030\u0004H\u0016J\u001a\u0010Ø\u0003\u001a\t\u0012\u0005\u0012\u00030Ù\u00030\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010Ú\u0003\u001a\t\u0012\u0005\u0012\u00030Ù\u00030\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010Û\u0003\u001a\t\u0012\u0005\u0012\u00030Ü\u00030\u0004H\u0016J\u0010\u0010Ý\u0003\u001a\t\u0012\u0005\u0012\u00030Þ\u00030\u0004H\u0016J\u001a\u0010ß\u0003\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J!\u0010à\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030á\u00030&j\t\u0012\u0005\u0012\u00030á\u0003`'0\u0004H\u0016J\u0019\u0010â\u0003\u001a\t\u0012\u0005\u0012\u00030ã\u00030\u00042\u0007\u0010N\u001a\u00030\u008c\u0001H\u0016J!\u0010ä\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030å\u00030&j\t\u0012\u0005\u0012\u00030å\u0003`'0\u0004H\u0016J\u0010\u0010æ\u0003\u001a\t\u0012\u0005\u0012\u00030ç\u00030\u0004H\u0016J\u0010\u0010è\u0003\u001a\t\u0012\u0005\u0012\u00030é\u00030\u0004H\u0016J%\u0010ê\u0003\u001a\t\u0012\u0005\u0012\u00030ë\u00030\u00042\u0013\u0010ì\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0010\u0010í\u0003\u001a\t\u0012\u0005\u0012\u00030î\u00030\u0004H\u0016J\u0019\u0010ï\u0003\u001a\t\u0012\u0005\u0012\u00030ð\u00030\u00042\u0007\u0010ñ\u0003\u001a\u00020\u0007H\u0016J*\u0010ò\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030ó\u00030&j\t\u0012\u0005\u0012\u00030ó\u0003`'0\u00042\u0007\u0010N\u001a\u00030·\u0003H\u0016J\"\u0010ô\u0003\u001a\t\u0012\u0005\u0012\u00030õ\u00030\u00042\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0002\u001a\u00020\u0007H\u0016J&\u0010ö\u0003\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\u00042\t\u0010÷\u0003\u001a\u0004\u0018\u00010\u00072\t\u0010ø\u0003\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010ù\u0003\u001a\t\u0012\u0005\u0012\u00030ú\u00030\u0004H\u0016J\u0018\u0010û\u0003\u001a\t\u0012\u0005\u0012\u00030ü\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010ý\u0003\u001a\t\u0012\u0005\u0012\u00030þ\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J*\u0010ÿ\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u0080\u00040&j\t\u0012\u0005\u0012\u00030\u0080\u0004`'0\u00042\u0007\u0010N\u001a\u00030·\u0003H\u0016J\u0018\u0010\u0081\u0004\u001a\t\u0012\u0005\u0012\u00030\u0082\u00040\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J!\u0010\u0083\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u0084\u00040&j\t\u0012\u0005\u0012\u00030\u0084\u0004`'0\u0004H\u0016J\u0010\u0010\u0085\u0004\u001a\t\u0012\u0005\u0012\u00030\u0086\u00040\u0004H\u0016J\u0010\u0010\u0087\u0004\u001a\t\u0012\u0005\u0012\u00030\u0088\u00040\u0004H\u0016J*\u0010\u0089\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u009a\u00020&j\t\u0012\u0005\u0012\u00030\u009a\u0002`'0\u00042\u0007\u0010N\u001a\u00030\u008a\u0004H\u0016J*\u0010\u008b\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030\u008c\u00040&j\t\u0012\u0005\u0012\u00030\u008c\u0004`'0\u00042\u0007\u0010N\u001a\u00030\u009b\u0002H\u0016J\u0019\u0010\u008d\u0004\u001a\t\u0012\u0005\u0012\u00030\u008e\u00040\u00042\u0007\u0010N\u001a\u00030±\u0001H\u0016J\u0010\u0010\u008f\u0004\u001a\t\u0012\u0005\u0012\u00030\u0090\u00040\u0004H\u0016J\u0010\u0010\u0091\u0004\u001a\t\u0012\u0005\u0012\u00030\u0092\u00040\u0004H\u0016J\u0018\u0010\u0093\u0004\u001a\t\u0012\u0005\u0012\u00030\u0094\u00040\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0095\u0004\u001a\t\u0012\u0005\u0012\u00030\u0096\u00040\u0004H\u0016J\u0010\u0010\u0097\u0004\u001a\t\u0012\u0005\u0012\u00030\u0094\u00040\u0004H\u0016J\u0018\u0010\u0097\u0004\u001a\t\u0012\u0005\u0012\u00030\u0094\u00040\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0098\u0004\u001a\t\u0012\u0005\u0012\u00030\u008d\u00020\u0004H\u0016J%\u0010\u0099\u0004\u001a\t\u0012\u0005\u0012\u00030\u009a\u00040\u00042\u0013\u0010\u009b\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0010\u0010\u009c\u0004\u001a\t\u0012\u0005\u0012\u00030\u009d\u00040\u0004H\u0016J\u0019\u0010\u009e\u0004\u001a\t\u0012\u0005\u0012\u00030\u009f\u00040\u00042\u0007\u0010 \u0004\u001a\u00020\u0007H\u0016J\u0010\u0010¡\u0004\u001a\t\u0012\u0005\u0012\u00030¢\u00040\u0004H\u0016J\u0010\u0010£\u0004\u001a\t\u0012\u0005\u0012\u00030¤\u00040\u0004H\u0016J\u0019\u0010¥\u0004\u001a\t\u0012\u0005\u0012\u00030¦\u00040\u00042\u0007\u0010N\u001a\u00030·\u0003H\u0016J!\u0010§\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0007\u0010¨\u0004\u001a\u00020\u00072\u0007\u0010©\u0004\u001a\u00020\u0007H\u0016J)\u0010ª\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020\u00072\u0007\u0010«\u0004\u001a\u00020\u00072\u0007\u0010¬\u0004\u001a\u00020\u0007H\u0016J\u0097\u0001\u0010\u00ad\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0007\u0010®\u0004\u001a\u00020\t2\u0007\u0010¯\u0004\u001a\u00020\t2\u0007\u0010°\u0004\u001a\u00020\t2\u0007\u0010±\u0004\u001a\u00020\t2\u0007\u0010²\u0004\u001a\u00020\t2\u0007\u0010³\u0004\u001a\u00020\t2\u0007\u0010´\u0004\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0007\u0010µ\u0004\u001a\u00020\t2\u0007\u0010¶\u0004\u001a\u00020\t2\u0007\u0010·\u0004\u001a\u00020\t2\u0007\u0010¸\u0004\u001a\u00020\t2\u0007\u0010¹\u0004\u001a\u00020\t2\u0007\u0010º\u0004\u001a\u00020\t2\u0007\u0010»\u0004\u001a\u00020\tH\u0016JX\u0010¼\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0007\u0010®\u0004\u001a\u00020\t2\u0007\u0010¯\u0004\u001a\u00020\t2\u0007\u0010°\u0004\u001a\u00020\t2\u0007\u0010±\u0004\u001a\u00020\t2\u0007\u0010²\u0004\u001a\u00020\t2\u0007\u0010³\u0004\u001a\u00020\t2\u0007\u0010´\u0004\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010½\u0004\u001a\b\u0012\u0004\u0012\u00020s0\u00042\u0013\u0010¾\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J3\u0010¿\u0004\u001a\b\u0012\u0004\u0012\u00020s0\u00042\u0007\u0010À\u0004\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0007\u0010Á\u0004\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010Â\u0004\u001a\b\u0012\u0004\u0012\u00020s0\u00042\u0007\u0010À\u0004\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J:\u0010Ã\u0004\u001a\t\u0012\u0005\u0012\u00030Ä\u00040\u00042\u0013\u0010²\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010³\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016Ja\u0010Å\u0004\u001a\t\u0012\u0005\u0012\u00030Æ\u00040\u00042\u0013\u0010²\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010³\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010Ç\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0007\u0010È\u0004\u001a\u00020\u00072\u0007\u0010\u0092\u0002\u001a\u00020\u0007H\u0016J$\u0010É\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010¾\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J$\u0010Ê\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010Ë\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J$\u0010Ì\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010Ë\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u001a\u0010Í\u0004\u001a\t\u0012\u0005\u0012\u00030Î\u00040\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010Ï\u0004\u001a\t\u0012\u0005\u0012\u00030Î\u00040\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J%\u0010Ð\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\t\u0010Ñ\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010Ò\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010Ó\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0007\u0010N\u001a\u00030¿\u0001H\u0016J$\u0010Ô\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010Õ\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J$\u0010Ö\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010×\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J#\u0010Ø\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0016J#\u0010Ù\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010Ú\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J'\u0010Û\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J{\u0010Ü\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00072\t\u0010Ý\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010Þ\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010ß\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010à\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010á\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010â\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010ã\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010ä\u0004\u001a\u0004\u0018\u00010\u0007H\u0016JK\u0010å\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b0&j\b\u0012\u0004\u0012\u00020\u000b`'H\u0016J\u0019\u0010æ\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J!\u0010æ\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J#\u0010ç\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0016J>\u0010è\u0004\u001a\t\u0012\u0005\u0012\u00030é\u00040\u00182\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001b2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010è\u0004\u001a\t\u0012\u0005\u0012\u00030é\u00040\u00182\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0019\u0010ê\u0004\u001a\t\u0012\u0005\u0012\u00030ë\u00040\u00042\u0007\u0010N\u001a\u00030ì\u0004H\u0016J9\u0010í\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00072\t\u0010 \u0004\u001a\u0004\u0018\u00010\u00072\u0007\u0010î\u0004\u001a\u00020\u0007H\u0016J.\u0010ï\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00072\t\u0010 \u0004\u001a\u0004\u0018\u00010\u00072\u0007\u0010î\u0004\u001a\u00020\u0007H\u0016J9\u0010ð\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00072\t\u0010 \u0004\u001a\u0004\u0018\u00010\u00072\t\u0010\u0091\u0003\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0092\u0003\u001a\u00020\u0007H\u0016JD\u0010ñ\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00072\t\u0010 \u0004\u001a\u0004\u0018\u00010\u00072\t\u0010\u0091\u0003\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0092\u0003\u001a\u00020\u0007H\u0016J:\u0010ò\u0004\u001a\t\u0012\u0005\u0012\u00030Ä\u00040\u00042\u0013\u0010²\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0013\u0010³\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J9\u0010ó\u0004\u001a\t\u0012\u0005\u0012\u00030ô\u00040\u00042\t\u0010õ\u0004\u001a\u0004\u0018\u00010\u00072\u0007\u0010ö\u0004\u001a\u00020\u00072\u0013\u0010÷\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J!\u0010ø\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010ù\u0004\u001a\b\u0012\u0004\u0012\u00020s0\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0007\u0010N\u001a\u00030ú\u0004H\u0016JX\u0010û\u0004\u001a\t\u0012\u0005\u0012\u00030ô\u00040\u00042\t\u0010õ\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010ü\u0004\u001a\u0004\u0018\u00010\u00072\t\u0010ñ\u0003\u001a\u0004\u0018\u00010\u00072\u0007\u0010ö\u0004\u001a\u00020\u00072\u0007\u0010ý\u0004\u001a\u00020\u00072\u0013\u0010÷\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J!\u0010þ\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010ÿ\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010\u0080\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J#\u0010\u0081\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J'\u0010\u0082\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J1\u0010\u0082\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0083\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010\u0080\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J;\u0010\u0084\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001bH\u0016JO\u0010\u0085\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016JY\u0010\u0085\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JA\u0010\u0086\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JS\u0010\u0087\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b0&j\b\u0012\u0004\u0012\u00020\u000b`'H\u0016J`\u0010\u0088\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\u0007\u0010®\u0004\u001a\u00020\t2\u0007\u0010¯\u0004\u001a\u00020\t2\u0007\u0010°\u0004\u001a\u00020\t2\u0007\u0010±\u0004\u001a\u00020\t2\u0007\u0010²\u0004\u001a\u00020\t2\u0007\u0010³\u0004\u001a\u00020\t2\u0007\u0010´\u0004\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J?\u0010\u0089\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016JI\u0010\u0089\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JG\u0010\u008a\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016JQ\u0010\u008a\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J7\u0010\u008b\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016JA\u0010\u008b\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u008c\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\b\u0010E\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008d\u0005\u001a\u0004\u0018\u00010\u000bH\u0016J/\u0010\u008e\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0016J9\u0010\u008e\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J?\u0010\u008f\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016JI\u0010\u008f\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J/\u0010\u0090\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J9\u0010\u0090\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J?\u0010\u0091\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016JI\u0010\u0091\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J/\u0010\u0092\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J9\u0010\u0092\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\u0093\u0005\u001a\t\u0012\u0005\u0012\u00030é\u00040\u00182\u0006\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016JF\u0010\u0093\u0005\u001a\t\u0012\u0005\u0012\u00030é\u00040\u00182\u0006\u0010\u0011\u001a\u00020\t2\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u001b2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016JW\u0010\u0094\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0016Ja\u0010\u0094\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0095\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010×\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J3\u0010\u0096\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0007\u0010\u0097\u0005\u001a\u00020\t2\u0007\u0010\u0098\u0005\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0099\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\t\u0010\u009a\u0005\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u009b\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\t\u0010\u009c\u0005\u001a\u0004\u0018\u00010\u000bH\u0016J!\u0010\u009d\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J3\u0010\u009e\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0007\u0010\u0097\u0005\u001a\u00020\t2\u0007\u0010\u0098\u0005\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J5\u0010\u009f\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030 \u00050&j\t\u0012\u0005\u0012\u00030 \u0005`'0\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J3\u0010¡\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0007\u0010\u0097\u0005\u001a\u00020\t2\u0007\u0010\u0098\u0005\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010¢\u0005\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0013\u0010\u0080\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u001a\u0010£\u0005\u001a\t\u0012\u0005\u0012\u00030¤\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010¥\u0005\u001a\t\u0012\u0005\u0012\u00030¦\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010§\u0005\u001a\t\u0012\u0005\u0012\u00030¨\u00050\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016¨\u0006©\u0005"}, d2 = {"Lin/etuwa/app/data/network/ApiServiceImpl;", "Lin/etuwa/app/data/network/ApiService;", "()V", "addAchievementUrlApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "title", "", "yearId", "Lokhttp3/RequestBody;", "uploadFile", "Lokhttp3/MultipartBody$Part;", "addAsietSemRegApiCall", "semesterRegistration", "", "addAsietTransRegApiCall", "Lin/etuwa/app/data/model/transportpalai/registration/RegisterSucessResponse;", "id", "exactPoint", "date", "addCompanyApiCall", "name", "address", "addCounsellingApiCall", "Lio/reactivex/Observable;", "partMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addCoursesUrlApiCall", "organizedBy", TypedValues.TransitionType.S_DURATION, "achievements", "fromDate", "toDate", "addDutyLeaveDirectDatesApiCall", "hour", "addGrievanceApiCall", "images", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMembershipUrlApiCall", "type", "memberId", PdfConst.Description, "addMoocCoursesUrlApiCall", "provider", "addPositionHeldUrlApiCall", "addProjectWorkUrlApiCall", ErrorBundle.DETAIL_ENTRY, "addPublicationUrlApiCall", "journal", "conference", FirebaseAnalytics.Param.INDEX, "addQualifiedExaminationUrlApiCall", FirebaseAnalytics.Param.SCORE, "addRResearchUrlApiCall", ExamSubjectDetailDialogKt.ARG_AMOUNT, "agency", "addScholarshipUrlApiCall", "addSportUrlApiCall", "eventName", "eventType", FirebaseAnalytics.Param.LEVEL, "awards", "addTransRegApiCall", "applyCertificateApiCall", "certificate", "reason", "certificateCollection", "file", "applyDutyLeaveApiCall", "applyDutyLeaveDirectViewApiCall", "headId", "applyHostelApiCall", "Lin/etuwa/app/data/model/main/ApplyHostelResponse;", "applyInternshipApiCall", "applyMedicalLeaveApiCall", "applyPlacementsApiCall", "request", "Lin/etuwa/app/data/model/placement/PlacementRequest;", "cancelMessOrderApiCall", "checkAlreadyExitApiCall", "checkExitApiCall", "composeMsgApiCall", "Lin/etuwa/app/data/model/message/ReplyRequest;", "deleteAchievementUrlApiCall", "deleteAssignmentApiCall", "deleteCounsellingApiCall", "deleteCoursesUrlApiCall", "deleteDutyLeaveDirectViewApiCall", "deleteGrievanceApiCall", "deleteHomeWorkApiCall", "deleteMembershipUrlApiCall", "deleteModuleTestApiCall", "deleteMoocCoursesUrlApiCall", "deletePositionHeldUrlApiCall", "deleteProjectWorkUrlApiCall", "deletePublicationUrlApiCall", "deleteQualifiedExaminationUrlApiCall", "deleteQuizFileApiCall", "Lin/etuwa/app/data/model/quiz/file/QuizDeleteFile;", "deleteRequestActivityApiCall", "deleteResearchUrlApiCall", "deleteScholarshipUrlApiCall", "deleteSeriesExamApiCall", "deleteSportUrlApiCall", "deleteTutorialApiCall", "doLoginApiCall", "Lin/etuwa/app/data/model/login/LoginResponse;", "Lin/etuwa/app/data/model/login/LoginRequest;", "doLogoutApiCall", "Lin/etuwa/app/data/model/login/LogoutRequest;", "downloadMaterialApiCall", "Lin/etuwa/app/data/model/materials/DownloadMaterialResponse;", "finishQuizAnswersApiCall", "Lin/etuwa/app/data/model/quiz/submit/QuizSubmitResponse;", "Lin/etuwa/app/data/model/quiz/submit/QuizFinishRequest;", "getAbcUpdateApiCall", "getAbcViewApiCall", "Lin/etuwa/app/data/model/dash/AbcResponse;", "getAchievementsUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/achievements/AchievementsResponse;", "getActivityPointApiCall", "Lin/etuwa/app/data/model/activitypoint/ActivityPointResponse;", "getArtsFeePayUrlApiCall", "Lin/etuwa/app/data/model/feearts/payment/FeeArtsUrlResponse;", "FeeCollection", "getAsietTransportRegistrationUrl", "Lin/etuwa/app/data/model/hostel/asiet/HostelAsietRegisterViewResponse;", "getAssignmentApiCall", "Lin/etuwa/app/data/model/assignment/AssignmentResponse;", "Lin/etuwa/app/data/model/assignment/AssignmentRequest;", "getAttendanceByDayApiCall", "Lin/etuwa/app/data/model/attendance/AttendanceDayResponse;", "Lin/etuwa/app/data/model/attendance/AttendanceDayRequest;", "getAttendanceByDayNewApiCall", "Lin/etuwa/app/data/model/attendance/AttendanceNewResponse;", "Lin/etuwa/app/data/model/attendance/AttendanceRequestNew;", "getAttendanceBySubjectApiCall", "Lin/etuwa/app/data/model/attendance/AttendanceResponse;", "Lin/etuwa/app/data/model/attendance/AttendanceRequest;", "getCalendarEventApiCall", "Lin/etuwa/app/data/model/calendar/CalendarResponse;", "getCategoryApiCall", "Lin/etuwa/app/data/model/store/departmentlist/DepartmentListResponse;", "getCategoryTypeApiCall", "Lin/etuwa/app/data/model/hostel/gcekhostel/newregistration/CategoryTypeResponse;", "getCentralizedInfoApiCall", "Lin/etuwa/app/data/model/centralizedinfo/CentralizedInfoResponse;", "getCertificateRequestApiCall", "Lin/etuwa/app/data/model/certificaterequest/CertificateRequestResponse;", "getCertificateTypeRequestApiCall", "Lin/etuwa/app/data/model/certificaterequest/CertificateTypeResponse;", "getChangeInTimetableApiCall", "Lin/etuwa/app/data/model/timetable/change/ChangeTimeTableResponse;", "getChangePasswordApiCall", "oldPassword", "newPassword", "newPasswordRepeat", "getChatSubjectsApiCall", "Lin/etuwa/app/data/model/chat/subjects/ChatResponse;", "getCircularsApiCall", "Lin/etuwa/app/data/model/common/Circular;", "getCommentsApiCall", "Lin/etuwa/app/data/model/chat/comment/CommentResponse;", StoreFragmentKt.SUB_ID, "chat", "getCompanyListApiCall", "Lin/etuwa/app/data/model/internship/companylist/CompanyListResponse;", "getCouncellingRequestApiCall", "Lin/etuwa/app/data/model/counselling/CounsellingResponse;", "getCounsellingStatusApiCall", "Lin/etuwa/app/data/model/counselling/status/CounsellingStatusResponse;", "getCounsellingTypeApiCall", "Lin/etuwa/app/data/model/counselling/type/CounsellingTypesResponse;", "getCourseOutcomeApiCall", "Lin/etuwa/app/data/model/subject/co/CoModel;", "Lin/etuwa/app/data/model/subject/co/CoSyllabusRequest;", "getCourseSurveyList", "Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyResponse;", "getCourseSurveyPendingStatusUrlApiCall", "Lin/etuwa/app/data/model/main/CourseSurveyPending;", "getCoursesAttendedUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/coursesattended/CoursesAttendedResponse;", "getDashApiCall", "Lin/etuwa/app/data/model/dash/DashResponse;", "getDayWiseTimeTable", "Lin/etuwa/app/data/model/dash/daywisetimetaable/DayWiseResponse;", "getDebugInstitutionsApiCall", "Lin/etuwa/app/data/model/institutions/Institution;", "getDeleteMsgApiCall", "Lin/etuwa/app/data/model/message/MsgHandleRequest;", "getDepartmentApiCall", "getDigitalLibraryApiCall", "Lin/etuwa/app/data/model/dash/LibraryResponse;", "getDoCourseSurveyList", "Lin/etuwa/app/data/model/survey/courseevaluation/DoCourseSurveyResponse;", "getDoCourseSurveyQuestionList", "Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyQuestionsResponse;", "getDuePay", "Lin/etuwa/app/data/model/due/duepaynew/DuePayNewResponse;", "getDuePayUrlApiCall", "Lin/etuwa/app/data/model/due/duepay/DuePayUrl;", "dueFeeCollection", "dueFeeReceipt", "getDuesApiCall", "getDutyLeaveApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeave;", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveViewRequest;", "getDutyLeaveDirectDatesApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveDateResponse;", "getDutyLeaveDirectHeadApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveHeadResponse;", "getDutyLeaveDirectViewApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveDirectApplyResponse;", "getEngineerFeePayUrlApiCall", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerUrlResponse;", "getEquipmentsApiCall", "Lin/etuwa/app/data/model/lab/LabEquipment;", "Lin/etuwa/app/data/model/lab/LabEquipRequest;", "getEvaluationApiCall", "Lin/etuwa/app/data/model/lab/Evaluation;", "Lin/etuwa/app/data/model/lab/PracticalRequest;", "getExamCourseApiCall", "Lin/etuwa/app/data/model/examregister/ExamCourseResponse;", "getExamPayUrlApiCall", "Lin/etuwa/app/data/model/examregister/ExamPayResponse;", "getExamReceiptApiCall", "Lin/etuwa/app/data/model/examregister/ExamReceiptResponse;", "getExamRegisterDataApiCall", "Lin/etuwa/app/data/model/examregister/ExamRegisterResponse;", "getExamResult", "Lin/etuwa/app/data/model/university/UniversityResultResponse;", "getExamRevaluationApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationResponse;", "getExamRevaluationConfirmApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationApplyResponse;", "revaluationCollection", "getExamRevaluationConfirmUpdateApiCall", "getExamRevaluationPayApiCall", "getExamRevaluationReceiptApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationReceiptResponse;", "getExamRevaluationStatusApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationStatusResponse;", "getExamRevaluationUpdateApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationUpdateResponse;", "getExamRevaluationUpdatePayApiCall", "getExamRevaluationViewApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationViewResponse;", "getExamUpdateApiCall", "Lin/etuwa/app/data/model/examregister/ExamUpdateResponse;", "getExamViewApiCall", "Lin/etuwa/app/data/model/examregister/ExamViewResponse;", "getExamsApiCall", "Lin/etuwa/app/data/model/examschedules/ExamScheduleResponse;", "getExperimentApiCall", "getFeeArtsApiCall", "Lin/etuwa/app/data/model/feearts/payment/FeeArtsResponse;", "getFeeArtsSemList", "Lin/etuwa/app/data/model/feearts/payment/FeeArtsSemesterResponse;", "getFeeEngineerApiCall", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerResponse;", "getFeeHeadApiCall", "Lin/etuwa/app/data/model/fee/feeheadgroups/FeeHeadGroupResponse;", "getFeeInstallmentsApiCall", "Lin/etuwa/app/data/model/fee/installment/InstallmentResponse;", "getFeeKmeaEngineerApiCall", "batchId", "getFeeReceiptsApiCall", "Lin/etuwa/app/data/model/fee/receipts/ReceiptResponse;", "getFeeStatusApiCall", "Lin/etuwa/app/data/model/main/FeeStatusResponse;", "getFeesApiCall", "Lin/etuwa/app/data/model/fee/FeeResponse;", "installment", "getFeesMedicalApiCall", "Lin/etuwa/app/data/model/feemedical/FeesMedResponse;", "getFundedResearchUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/fundedresearch/FundedResearchResponse;", "getGatewayDetailsApiCall", "Lin/etuwa/app/data/model/fee/GatewayDetailsResponse;", "getGenSurveyQuestionApiCall", "Lin/etuwa/app/data/model/survey/SurveyQuestion;", "Lin/etuwa/app/data/model/survey/GenSurveyQuestionRequest;", "getGraduateSurveyListApiCall", "Lin/etuwa/app/data/model/survey/graduateexit/GraduateExitSurveyListResponse;", "getGraduateSurveyQuestionsApiCall", "Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyResponse;", "getGrievanceApiCall", "Lin/etuwa/app/data/model/grievance/GrievanceResponse;", "getGrievanceTypeApiCall", "Lin/etuwa/app/data/model/grievance/type/GrievanceTypeResponse;", "getHomeWorksApiCall", "Lin/etuwa/app/data/model/homework/HomeWorkResponse;", "getHostelApiCall", "Lin/etuwa/app/data/model/hostel/HostelResponse;", "getHostelApplyLeaveApiCall", "leaveType", "getHostelApproveLeaveParentApiCall", "getHostelAttCalApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttCalResponse;", "month", "year", "getHostelDeleteLeaveApiCall", "getHostelFeeConfirmApiCall", "Lin/etuwa/app/data/model/hostel/HostelFeeResponse;", "feeCollection", "feeReceipt", "getHostelFeeConfirmPalaiApiCall", "Lin/etuwa/app/data/model/hostel/HostelFeePalaiResponse;", "getHostelFeeNewPayApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewPay;", "getHostelFeeTypesApiCall", "Lin/etuwa/app/data/model/hostel/HostelPalaiTypesResponse;", "getHostelGatePassApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelScanViewResponse;", "getHostelHistoryNewApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewHistoryResponse;", "getHostelLeaveTypeApiCall", "Lin/etuwa/app/data/model/hostel/attendance/LeaveTypeResponse;", "getHostelLeaveViewParentApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttParentViewResponse;", "getHostelLeaveViewParentApproveApiCall", "getHostelLeaveViewParentRejectApiCall", "getHostelMessApiCall", "Lin/etuwa/app/data/model/mess/MessResponse;", "getHostelNewAdmissionApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewAdmissionResponse;", "getHostelNewMonthlyApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelNewMonthlyResponse;", "getHostelReceiptNewApiCall", "Lin/etuwa/app/data/model/hostel/receipt/HostelReceiptResponse;", "getHostelReceiptTkmApiCall", "getHostelRegistrationData", "Lin/etuwa/app/data/model/hostel/gcekhostel/registration/RegistrationResponse;", "getHostelRejectLeaveParentApiCall", "getHostelRevokeLeaveParentApiCall", "getHostelStatusNewApiCall", "Lin/etuwa/app/data/model/hostelnew/HostelStatusNew;", "getHostelTkmApiCall", "Lin/etuwa/app/data/model/hostel/HostelMonthResponse;", "getHostelViewLeaveApiCall", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttViewResponse;", "getInboxApiCall", "Lin/etuwa/app/data/model/message/Inbox;", "getInstitutionsApiCall", "getInternshipRequestApiCall", "Lin/etuwa/app/data/model/internship/InternshipResponse;", "getLabDueApiCall", "Lin/etuwa/app/data/model/lab/LabDue;", "getLabListApiCall", "Lin/etuwa/app/data/model/lab/LabList;", "getLeaveManagementApiCall", "Lin/etuwa/app/data/model/leavemanagement/LeaveManagementResponse;", "getLibraryBookRecordApiCall", "Lin/etuwa/app/data/model/library/BookRecordResponse;", "getLibraryBooksApiCall", "Lin/etuwa/app/data/model/library/BooksResponse;", "getLiveTvApiCall", "Lin/etuwa/app/data/model/live/LiveResponse;", "getMaintenanceUrl", "Lin/etuwa/app/data/model/dash/MaintenanceResponse;", "getManageActivityApiCall", "Lin/etuwa/app/data/model/activitypoint/manage/ActivityBatchResponse;", "getMedicalFeePayUrlApiCall", "getMedicalLeaveApiCall", "Lin/etuwa/app/data/model/leave/medical/MedicalLeave;", "getMembershipUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/membership/MembershipResponse;", "getMessMenuApiCall", "Lin/etuwa/app/data/model/mess/MessMenuResponse;", "getMessOrderHistoryApiCall", "Lin/etuwa/app/data/model/mess/OrderHistoryResponse;", "getMessTypeApiCall", "Lin/etuwa/app/data/model/mess/MessTypeResponse;", "getMitsFeePayUrl", "Lin/etuwa/app/data/model/hostel/mits/MitsFeePay;", "getModuleTestApiCall", "Lin/etuwa/app/data/model/exam/ModuleTestResponse;", "new", "getMoocCourseUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/mooccourse/MoocCourseResponse;", "getNewQuizQuestionsApiCall", "Lin/etuwa/app/data/model/quiz/QuestionsNewResponse;", "getNoDueCertificate", "Lin/etuwa/app/data/model/due/duepay/NoDueCertificateResponse;", "getNoticeClassApiCall", "Lin/etuwa/app/data/model/noticeboard/NoticeResponse;", "getNoticeClassJeccApiCall", "Lin/etuwa/app/data/model/noticeboard/NoticeJeccResponse;", "getOnlineClassApiCall", "Lin/etuwa/app/data/model/onlineclass/OnlineClassResponse;", "getOutboxApiCall", "Lin/etuwa/app/data/model/message/Outbox;", "getPalaiHostelAdmsnApiCall", "Lin/etuwa/app/data/model/hostel/HostelPalaiAdmissionResponse;", "getPalaiHostelPartialAdmsnApiCall", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "getParentCommentsApiCall", "getParentReplyApiCall", "Lin/etuwa/app/data/model/chat/reply/ReplyResponse;", "commentId", "reply", "getPartialInstallmentFeeApiCall", "Lin/etuwa/app/data/model/feepartial/InstallmentDetailsResponse;", "getPartialInstallmentListApiCall", "Lin/etuwa/app/data/model/feepartial/InstallmentListResponse;", "getPendingSurveyUrl", "Lin/etuwa/app/data/model/dash/PendingSurvey;", "getPioPayUrlApiCall", "Lin/etuwa/app/data/model/examregister/ExamMessageResponse;", "getPlacementsApiCall", "Lin/etuwa/app/data/model/placement/Placement;", "getPoQuestionsUrl", "Lin/etuwa/app/data/model/survey/posurvey/PoQuestionsResponse;", "getPoSurveyPendingStatusUrlApiCall", "Lin/etuwa/app/data/model/main/POSurveyPending;", "getPoSurveyUrl", "Lin/etuwa/app/data/model/survey/posurvey/POSurveyResponse;", "getPositionHeldUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/positionheld/PositionHeldResponse;", "getPracticalsApiCall", "Lin/etuwa/app/data/model/lab/Practical;", "getPresentHostelApiCall", "Lin/etuwa/app/data/model/hostel/gcekhostel/reregistration/PresentHostelResponse;", "getProfileApiCall", "Lin/etuwa/app/data/model/dash/ProfileResponse;", "getProfileDropListUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/publication/PublicationDropDownResponse;", "getProgramOutcomeApiCall", "Lin/etuwa/app/data/model/programoutcome/ProgramOutcomeResponse;", "getProjectWorkUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/projectwork/ProjectWorkResponse;", "getPublicationUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/publication/PublicationResponse;", "getQualifiedExaminationUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/qualifiedexamination/QualifiedExaminationResponse;", "getQuestionBankApiCall", "Lin/etuwa/app/data/model/materials/Materials;", "Lin/etuwa/app/data/model/materials/MaterialRequest;", "getQuizListApiCall", "Lin/etuwa/app/data/model/quiz/list/QuizResponse;", "getQuizQuestionsApiCall", "Lin/etuwa/app/data/model/quiz/questions/QuestionResponse;", "getRegisterViewApiCall", "Lin/etuwa/app/data/model/transportpalai/registration/RegisterViewResponse;", "getRegistrationApiCall", "Lin/etuwa/app/data/model/resetpassword/ResetPassword;", "getRegistrationSlipApiCall", "Lin/etuwa/app/data/model/examregister/RegistrationSlipResponse;", "getRegistrationSlipUrl", "Lin/etuwa/app/data/model/semregistration/view/SemRegSlip;", "getRemarksApiCall", "Lin/etuwa/app/data/model/common/Remarks;", "getReplyApiCall", "getResetPasswordApiCall", "Lretrofit2/Response;", "getResultAssignmentApiCall", "Lin/etuwa/app/data/model/result/ResultAssignment;", "getResultInternalApiCall", "Lin/etuwa/app/data/model/result/ResultInternal;", "getResultModuleTestApiCall", "Lin/etuwa/app/data/model/result/moduletest/ResultModuleTestResponse;", "getResultSeasonalApiCall", "Lin/etuwa/app/data/model/result/ResultSeasonal;", "Lin/etuwa/app/data/model/result/SeasonRequest;", "getResultUnivApiCall", "Lin/etuwa/app/data/model/result/univ/UnivResponse;", "getSafetyApiCall", "getScStPayUrlApiCall", "getScholarshipsUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/scholarships/ScholarshipsResponse;", "getSemRegDetailsApiCall", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "getSemRegDetailsMvjceApiCall", "getSemRegDropListApiCall", "Lin/etuwa/app/data/model/semregistration/AcademicYearResponse;", "getSemRegListApiCall", "Lin/etuwa/app/data/model/semregistration/list/SemRegisterListResponse;", "getSemesterListApiCall", "getSemestersApiCall", "Lin/etuwa/app/data/model/Semester;", "getSeriesExamApiCall", "Lin/etuwa/app/data/model/exam/SeriesExamResponse;", "getSpecialClassApiCall", "Lin/etuwa/app/data/model/timetable/special/SpecialResponse;", "getSportUrlApiCall", "Lin/etuwa/app/data/model/profileasiet/sport/SportResponse;", "getStationaryListApiCall", "Lin/etuwa/app/data/model/stationary/StationaryItemResponse;", "getStationaryPaymentUrlApiCall", "Lin/etuwa/app/data/model/stationary/AdvancePaymentResponse;", "productDetails", "getStationaryReceiptsApiCall", "Lin/etuwa/app/data/model/stationary/StationaryReceiptResponse;", "getStoreDataApiCall", "Lin/etuwa/app/data/model/store/StoreResponse;", "subjectId", "getStudyMaterialsApiCall", "Lin/etuwa/app/data/model/materials/MaterialsNew;", "getSubjectCoverageApiCall", "Lin/etuwa/app/data/model/subject/coverage/SubCoverageResponse;", "getSubjectListApiCall", "dept_id", "sem_id", "getSubjectRegistrationListApiCall", "Lin/etuwa/app/data/model/subjectregistration/SubjectRegistrationResponse;", "getSubjectRegistrationSpinnerApiCall", "Lin/etuwa/app/data/model/subjectregistration/SubjectSpinnerResponse;", "getSubjectRegistrationViewApiCall", "Lin/etuwa/app/data/model/subjectregistration/ViewSubjectRegistrationResponse;", "getSubjectsApiCall", "Lin/etuwa/app/data/model/subject/Subjects;", "getSubjectsRegListApiCall", "Lin/etuwa/app/data/model/subjectregistration/SubjectsListResponse;", "getSurveyApiCall", "Lin/etuwa/app/data/model/survey/Survey;", "getSurveyMandatoryStatusUrlApiCall", "Lin/etuwa/app/data/model/main/SurveyMandatory;", "getSurveyPendingStatusUrlApiCall", "Lin/etuwa/app/data/model/main/SurveyPending;", "getSurveyQuestionApiCall", "Lin/etuwa/app/data/model/survey/SurveyRequest;", "getSurveyTeachersApiCall", "Lin/etuwa/app/data/model/survey/TeacherList;", "getSyllabusApiCall", "Lin/etuwa/app/data/model/subject/syllabus/SyllabusResponse;", "getTeacherApiCall", "Lin/etuwa/app/data/model/common/TeacherResponse;", "getTimetableApiCall", "Lin/etuwa/app/data/model/timetable/TimetableResponse;", "getTransFeeApiCall", "Lin/etuwa/app/data/model/transport/TransportFeeResponse;", "getTransportBusPassApiCall", "Lin/etuwa/app/data/model/transportpalai/BusPass;", "getTransportFeeApiCall", "getTransportFeeReceiptsApiCall", "getTransportFeeUrlApiCall", "Lin/etuwa/app/data/model/transport/TransportPayUrl;", "transportFeeCollection", "getTransportHistoryUrlApiCall", "Lin/etuwa/app/data/model/transport/TransportHistoryResponse;", "getTutorialResultApiCall", "Lin/etuwa/app/data/model/result/tutorial/TutorialResultResponse;", "semId", "getTutorialsApiCall", "Lin/etuwa/app/data/model/tutorial/TutorialResponse;", "getUpdateProfileApiCall", "Lin/etuwa/app/data/model/updateprofile/UpdateProfile;", "getVideoClassApiCall", "Lin/etuwa/app/data/model/video/VideoResponse;", "getWatchVideoApiCall", "videoId", "youtubeId", "messBookingApiCall", CommonCssConstants.MENU, "qty", "newHostelReRegistrationApiCall", "reAdmission", "category", "localGuardian", "localGuardianPhone", "annualIncome", "distance", "semesterId", "hostelId", "yearCount", "hostelDetails", "isFined", "fineDetails", "feeDefaulter", "feeDetails", "newHostelRegistrationApiCall", "newQuizAnswerSubmit", "answerDetails", "newQuizAnswerUploadFinalSubmit", "qNo", "finalSubmit", "newQuizAnswerUploadSubmit", "payFeesApiCall", "Lin/etuwa/app/data/model/fee/FeeUrlResponse;", "payFeesSreeChitraApiCall", "Lin/etuwa/app/data/model/fee/FeeSreeChitraUrl;", "transaction", "payment", "poAnswerSubmit", "postCourseSurveyAnswer", "answerCollection", "postGESurveyAnswer", "quizResultApiCall", "Lin/etuwa/app/data/model/quiz/result/QuizResultResponse;", "quizResultNewApiCall", "quizSaveStatusApiCall", "sessionId", "qId", "readMsgApiCall", "registerSemsterNewApiCall", "SemRegistration", "registerSubjectRegistrationApiCall", "registerCollection", "remindCounsellingApiCall", "remindGrievanceApiCall", "removeDateHourDutyLeaveDirectDatesApiCall", "removeDutyLeaveDirectDatesApiCall", "reopenCounsellingApiCall", "concern", "home", "studies", "relationship", "physical", "history", "session", "comments", "reopenGrievanceApiCall", "requestActivityApiCall", "reviewCounsellingApiCall", "semRegisterApiCall", "Lin/etuwa/app/data/model/SemRegSuccessResponse;", "sendPushTokenApiCall", "Lin/etuwa/app/data/model/main/PushResponse;", "Lin/etuwa/app/data/model/main/PushRequest;", "setCommentsApiCall", ClientCookie.COMMENT_ATTR, "setParentCommentsApiCall", "setParentReplyApiCall", "setReplyApiCall", "submitFeesApiCall", "submitGenSurveyApiCall", "Lin/etuwa/app/data/model/survey/SubmitResponse;", "surveyId", "remark", "option", "submitHomeWorkApiCall", "submitQuizAnswersApiCall", "Lin/etuwa/app/data/model/quiz/submit/SubmitRequest;", "submitSurveyApiCall", "teacherId", "specialRemark", "submitTutorialApiCall", "suggestBookApiCall", "studentDetails", "updaateAsietSemRegApiCall", "updateAchievementUrlApiCall", "updateBankDetailsApiCall", "updateCounsellingApiCall", "updateCoursesUrlApiCall", "updateDutyLeaveDirectViewApiCall", "updateGrievanceApiCall", "updateHostelRegistrationApiCall", "updateMembershipUrlApiCall", "updateMoocCoursesUrlApiCall", "updatePositionHeldUrlApiCall", "updateProPicApiCall", "sign", "updateProjectWorkUrlApiCall", "updatePublicationUrlApiCall", "updateQualifiedExaminationUrlApiCall", "updateResearchUrlApiCall", "updateScholarshipUrlApiCall", "updateSemRegisterApiCall", "updateSportUrlApiCall", "updateSubjectRegistrationApiCall", "uploadAssignmentApiCall", "username", "password", "uploadCovidCertificateApiCall", "vaccineFile", "uploadCovidCertificateTwoApiCall", "vaccineFileTwo", "uploadInternshipApiCall", "uploadModuleTestApiCall", "uploadQuizApiCall", "Lin/etuwa/app/data/model/quiz/file/QuizFileUploadResponse;", "uploadSeriesExamApiCall", "verifyBankDetailsApiCall", "viewCounsellingApiCall", "Lin/etuwa/app/data/model/counselling/view/ViewCounsellingResponse;", "viewGrievanceApiCall", "Lin/etuwa/app/data/model/grievance/view/ViewGrievanceResponse;", "viewRegistrationApiCall", "Lin/etuwa/app/data/model/hostel/gcekhostel/registration/ViewRegistrationResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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