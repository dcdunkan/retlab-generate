package in.etuwa.app;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.databinding.Actions2DialogBindingImpl;
import in.etuwa.app.databinding.ActionsDialogBindingImpl;
import in.etuwa.app.databinding.ActivityLoginBindingImpl;
import in.etuwa.app.databinding.ActivityMainBindingImpl;
import in.etuwa.app.databinding.ActivityPointFragmentBindingImpl;
import in.etuwa.app.databinding.ActivityPushBindingImpl;
import in.etuwa.app.databinding.AddCompanyDialogBindingImpl;
import in.etuwa.app.databinding.AddCounsellingDialogBindingImpl;
import in.etuwa.app.databinding.AddGrievanceDialogBindingImpl;
import in.etuwa.app.databinding.AddMedicalLeaveBindingImpl;
import in.etuwa.app.databinding.AddRequestDialogBindingImpl;
import in.etuwa.app.databinding.ApplyInternshipBindingImpl;
import in.etuwa.app.databinding.AssignmentFragmentBindingImpl;
import in.etuwa.app.databinding.AssignmentResultFragmentBindingImpl;
import in.etuwa.app.databinding.AssignmentSemListDialogBindingImpl;
import in.etuwa.app.databinding.AttendanceByDayDialogBindingImpl;
import in.etuwa.app.databinding.AttendanceFragmentBindingImpl;
import in.etuwa.app.databinding.CellMember2DialogBindingImpl;
import in.etuwa.app.databinding.CellMemberDialogBindingImpl;
import in.etuwa.app.databinding.CentralizedInfoFragmentBindingImpl;
import in.etuwa.app.databinding.CertificateRequestFragmentBindingImpl;
import in.etuwa.app.databinding.ChangeInTimetableFragmentBindingImpl;
import in.etuwa.app.databinding.ChangeProPicDialogBindingImpl;
import in.etuwa.app.databinding.ChatFragmentBindingImpl;
import in.etuwa.app.databinding.CircularFragmentBindingImpl;
import in.etuwa.app.databinding.CoFragmentBindingImpl;
import in.etuwa.app.databinding.CommentDialogBindingImpl;
import in.etuwa.app.databinding.CommentReplyDialogBindingImpl;
import in.etuwa.app.databinding.CompletionCertificateDialogBindingImpl;
import in.etuwa.app.databinding.CounsellingFragmentBindingImpl;
import in.etuwa.app.databinding.CovidCertificateDialogBindingImpl;
import in.etuwa.app.databinding.CovidCertificateListMainFragmentBindingImpl;
import in.etuwa.app.databinding.CovidCertificateTwoDialogBindingImpl;
import in.etuwa.app.databinding.DialogAbcUpdateBindingImpl;
import in.etuwa.app.databinding.DialogAddAchievementsBindingImpl;
import in.etuwa.app.databinding.DialogAddCourseAttendedBindingImpl;
import in.etuwa.app.databinding.DialogAddFundedResearchBindingImpl;
import in.etuwa.app.databinding.DialogAddMembershipBindingImpl;
import in.etuwa.app.databinding.DialogAddMoocCourseBindingImpl;
import in.etuwa.app.databinding.DialogAddPositionHeldBindingImpl;
import in.etuwa.app.databinding.DialogAddProjectWorkBindingImpl;
import in.etuwa.app.databinding.DialogAddQualifiedExaminationBindingImpl;
import in.etuwa.app.databinding.DialogAddScholarshipBindingImpl;
import in.etuwa.app.databinding.DialogAddSportBindingImpl;
import in.etuwa.app.databinding.DialogAddTransRegBindingImpl;
import in.etuwa.app.databinding.DialogAddUpdateBankBindingImpl;
import in.etuwa.app.databinding.DialogAddUpdatePublicationBindingImpl;
import in.etuwa.app.databinding.DialogApplyAddDirectLeaveBindingImpl;
import in.etuwa.app.databinding.DialogApplyHostelAttendanceBindingImpl;
import in.etuwa.app.databinding.DialogApplyPreferenceSubRegBindingImpl;
import in.etuwa.app.databinding.DialogApplySubjectRegistrationBindingImpl;
import in.etuwa.app.databinding.DialogAsietTransportRegistrationBindingImpl;
import in.etuwa.app.databinding.DialogBankDetailsBindingImpl;
import in.etuwa.app.databinding.DialogBooksDetailsBindingImpl;
import in.etuwa.app.databinding.DialogCekSemRegBindingImpl;
import in.etuwa.app.databinding.DialogChangePasswordBindingImpl;
import in.etuwa.app.databinding.DialogChristSemRegBindingImpl;
import in.etuwa.app.databinding.DialogContactDetailsBindingImpl;
import in.etuwa.app.databinding.DialogDutyLeaveBindingImpl;
import in.etuwa.app.databinding.DialogEditRegistrationBindingImpl;
import in.etuwa.app.databinding.DialogEngineerFeeEtailBindingImpl;
import in.etuwa.app.databinding.DialogExamSubjectDetailsBindingImpl;
import in.etuwa.app.databinding.DialogFeeConfirmBindingImpl;
import in.etuwa.app.databinding.DialogGatewayTwoBindingImpl;
import in.etuwa.app.databinding.DialogHostelNewConfirmBindingImpl;
import in.etuwa.app.databinding.DialogHostelNewDetailsBindingImpl;
import in.etuwa.app.databinding.DialogHostelPartialEditBindingImpl;
import in.etuwa.app.databinding.DialogMaceSemRegBindingImpl;
import in.etuwa.app.databinding.DialogMaterialDownloadBindingImpl;
import in.etuwa.app.databinding.DialogMeaSemRegBindingImpl;
import in.etuwa.app.databinding.DialogMessBookingBindingImpl;
import in.etuwa.app.databinding.DialogMissionBindingImpl;
import in.etuwa.app.databinding.DialogMmaintenanceBindingImpl;
import in.etuwa.app.databinding.DialogMvjceSemRegBindingImpl;
import in.etuwa.app.databinding.DialogNewRegistrationAisatBindingImpl;
import in.etuwa.app.databinding.DialogNewRegistrationBindingImpl;
import in.etuwa.app.databinding.DialogPalaiSemRegBindingImpl;
import in.etuwa.app.databinding.DialogParentApproveBindingImpl;
import in.etuwa.app.databinding.DialogParentDetailsBindingImpl;
import in.etuwa.app.databinding.DialogPersonalDetailsBindingImpl;
import in.etuwa.app.databinding.DialogProfileUpdateBindingImpl;
import in.etuwa.app.databinding.DialogQrFullScreenBindingImpl;
import in.etuwa.app.databinding.DialogReRegistrationBindingImpl;
import in.etuwa.app.databinding.DialogSecurityQrBindingImpl;
import in.etuwa.app.databinding.DialogStationaryPayBindingImpl;
import in.etuwa.app.databinding.DialogSubRegStatusBindingImpl;
import in.etuwa.app.databinding.DialogSubjectPlanBindingImpl;
import in.etuwa.app.databinding.DialogSuggestBookBindingImpl;
import in.etuwa.app.databinding.DialogTransportFeePayBindingImpl;
import in.etuwa.app.databinding.DialogUpdateHoursBindingImpl;
import in.etuwa.app.databinding.DialogViewProofBindingImpl;
import in.etuwa.app.databinding.DialogViewProofDutyLeaveBindingImpl;
import in.etuwa.app.databinding.DialogViewSubjectRegistrationBindingImpl;
import in.etuwa.app.databinding.DialogViewregistrationDialogBindingImpl;
import in.etuwa.app.databinding.DialogVisionBindingImpl;
import in.etuwa.app.databinding.DueFragmentBindingImpl;
import in.etuwa.app.databinding.DuePayFragmentBindingImpl;
import in.etuwa.app.databinding.DutyLeaveFragmentBindingImpl;
import in.etuwa.app.databinding.EquipmentFragmentBindingImpl;
import in.etuwa.app.databinding.EvaluationFragmentBindingImpl;
import in.etuwa.app.databinding.ExamFragmentBindingImpl;
import in.etuwa.app.databinding.ExperementFragmentBindingImpl;
import in.etuwa.app.databinding.FeeFragmentBindingImpl;
import in.etuwa.app.databinding.FragmentAchievementsBindingImpl;
import in.etuwa.app.databinding.FragmentAsietSemRegBindingImpl;
import in.etuwa.app.databinding.FragmentAsietTransRegHistoryBindingImpl;
import in.etuwa.app.databinding.FragmentAttendanceByDayBindingImpl;
import in.etuwa.app.databinding.FragmentAttendanceCalendarViewBindingImpl;
import in.etuwa.app.databinding.FragmentAttendanceDayWiseBindingImpl;
import in.etuwa.app.databinding.FragmentBookingBindingImpl;
import in.etuwa.app.databinding.FragmentBookingHistoryBindingImpl;
import in.etuwa.app.databinding.FragmentBooksBindingImpl;
import in.etuwa.app.databinding.FragmentBooksRecordsBindingImpl;
import in.etuwa.app.databinding.FragmentCalendarBindingImpl;
import in.etuwa.app.databinding.FragmentCourseAttendedBindingImpl;
import in.etuwa.app.databinding.FragmentCourseSurveyBindingImpl;
import in.etuwa.app.databinding.FragmentCourseSurveyQuestionsBindingImpl;
import in.etuwa.app.databinding.FragmentCourseSurveySubjectsBindingImpl;
import in.etuwa.app.databinding.FragmentDashTableViewBindingImpl;
import in.etuwa.app.databinding.FragmentDashboardBindingImpl;
import in.etuwa.app.databinding.FragmentDayWiseTimeTableBindingImpl;
import in.etuwa.app.databinding.FragmentDirectApplyBindingImpl;
import in.etuwa.app.databinding.FragmentDuesMainBindingImpl;
import in.etuwa.app.databinding.FragmentEvaluationBindingImpl;
import in.etuwa.app.databinding.FragmentExamMainBindingImpl;
import in.etuwa.app.databinding.FragmentExamReceiptBindingImpl;
import in.etuwa.app.databinding.FragmentExamRegistrationBindingImpl;
import in.etuwa.app.databinding.FragmentExamRegistrationMainBindingImpl;
import in.etuwa.app.databinding.FragmentExamRegistrationNewBindingImpl;
import in.etuwa.app.databinding.FragmentExamSubjectBindingImpl;
import in.etuwa.app.databinding.FragmentExamUpdateBindingImpl;
import in.etuwa.app.databinding.FragmentExamViewBindingImpl;
import in.etuwa.app.databinding.FragmentFeeArtsBindingImpl;
import in.etuwa.app.databinding.FragmentFeeEngineerBindingImpl;
import in.etuwa.app.databinding.FragmentFeeListBindingImpl;
import in.etuwa.app.databinding.FragmentFeeMainBindingImpl;
import in.etuwa.app.databinding.FragmentFeeMainNewBindingImpl;
import in.etuwa.app.databinding.FragmentFeeMedicalBindingImpl;
import in.etuwa.app.databinding.FragmentFeePartialBindingImpl;
import in.etuwa.app.databinding.FragmentFieldsBindingImpl;
import in.etuwa.app.databinding.FragmentFundedResearchBindingImpl;
import in.etuwa.app.databinding.FragmentGatewayDetailsBindingImpl;
import in.etuwa.app.databinding.FragmentGraduateExitSurveyListBindingImpl;
import in.etuwa.app.databinding.FragmentGraduateExitSurveyQuestionsBindingImpl;
import in.etuwa.app.databinding.FragmentHostelAttViewBindingImpl;
import in.etuwa.app.databinding.FragmentHostelAttendanceBindingImpl;
import in.etuwa.app.databinding.FragmentHostelAttendanceParentFragmentBindingImpl;
import in.etuwa.app.databinding.FragmentHostelFeeConfirmFragmentBindingImpl;
import in.etuwa.app.databinding.FragmentHostelFeePalaiBindingImpl;
import in.etuwa.app.databinding.FragmentHostelFeeTkmBindingImpl;
import in.etuwa.app.databinding.FragmentHostelMitsBindingImpl;
import in.etuwa.app.databinding.FragmentHostelNewBindingImpl;
import in.etuwa.app.databinding.FragmentHostelNonMitsBindingImpl;
import in.etuwa.app.databinding.FragmentHostelPartialBindingImpl;
import in.etuwa.app.databinding.FragmentHostelReceiptBindingImpl;
import in.etuwa.app.databinding.FragmentInstructionsPageBindingImpl;
import in.etuwa.app.databinding.FragmentInternshipBindingImpl;
import in.etuwa.app.databinding.FragmentKmeaBindingImpl;
import in.etuwa.app.databinding.FragmentLabBindingImpl;
import in.etuwa.app.databinding.FragmentLeaveBindingImpl;
import in.etuwa.app.databinding.FragmentLeaveManagementBindingImpl;
import in.etuwa.app.databinding.FragmentMembershipBindingImpl;
import in.etuwa.app.databinding.FragmentMessBindingImpl;
import in.etuwa.app.databinding.FragmentMessageBindingImpl;
import in.etuwa.app.databinding.FragmentMoocCourseBindingImpl;
import in.etuwa.app.databinding.FragmentOrderHistoryBindingImpl;
import in.etuwa.app.databinding.FragmentPalaiSemRegBindingImpl;
import in.etuwa.app.databinding.FragmentPayWebBindingImpl;
import in.etuwa.app.databinding.FragmentPaymentWebviewBindingImpl;
import in.etuwa.app.databinding.FragmentPoQuestionsNewBindingImpl;
import in.etuwa.app.databinding.FragmentPoSurveyBindingImpl;
import in.etuwa.app.databinding.FragmentPoSurveyQuestionsBindingImpl;
import in.etuwa.app.databinding.FragmentPositionHeldBindingImpl;
import in.etuwa.app.databinding.FragmentProfileBindingImpl;
import in.etuwa.app.databinding.FragmentProgramOutcomeBindingImpl;
import in.etuwa.app.databinding.FragmentProjectWorkBindingImpl;
import in.etuwa.app.databinding.FragmentPublicationBindingImpl;
import in.etuwa.app.databinding.FragmentQualifiedExaminationBindingImpl;
import in.etuwa.app.databinding.FragmentQuizBindingImpl;
import in.etuwa.app.databinding.FragmentQuizQuestionsBindingImpl;
import in.etuwa.app.databinding.FragmentQuizResultBindingImpl;
import in.etuwa.app.databinding.FragmentRegistrationBindingImpl;
import in.etuwa.app.databinding.FragmentRevaluationBindingImpl;
import in.etuwa.app.databinding.FragmentRevaluationFeeBindingImpl;
import in.etuwa.app.databinding.FragmentRevaluationReceiptBindingImpl;
import in.etuwa.app.databinding.FragmentRevaluationUpdateBindingImpl;
import in.etuwa.app.databinding.FragmentRevaluationViewBindingImpl;
import in.etuwa.app.databinding.FragmentScholarshipBindingImpl;
import in.etuwa.app.databinding.FragmentSentItemsBindingImpl;
import in.etuwa.app.databinding.FragmentSportBindingImpl;
import in.etuwa.app.databinding.FragmentStationaryMainBindingImpl;
import in.etuwa.app.databinding.FragmentStoreBindingImpl;
import in.etuwa.app.databinding.FragmentSubjectRegistrationBindingImpl;
import in.etuwa.app.databinding.FragmentSurveyBindingImpl;
import in.etuwa.app.databinding.FragmentTeacherSurveyListBindingImpl;
import in.etuwa.app.databinding.FragmentTeacherSurveyQuestionsBindingImpl;
import in.etuwa.app.databinding.FragmentTransportBindingImpl;
import in.etuwa.app.databinding.FragmentTransportBuspassBindingImpl;
import in.etuwa.app.databinding.FragmentTransportFeeBindingImpl;
import in.etuwa.app.databinding.FragmentTransportHistoryBindingImpl;
import in.etuwa.app.databinding.FragmentTransportMainBindingImpl;
import in.etuwa.app.databinding.FragmentTransportReceiptBindingImpl;
import in.etuwa.app.databinding.FragmentTransportRegHistoryBindingImpl;
import in.etuwa.app.databinding.FragmentWebviewBindingImpl;
import in.etuwa.app.databinding.GrievanceDocDialogBindingImpl;
import in.etuwa.app.databinding.GrievanceFragmentBindingImpl;
import in.etuwa.app.databinding.HomeWorkFilesDialogBindingImpl;
import in.etuwa.app.databinding.HomeWorkFragmentBindingImpl;
import in.etuwa.app.databinding.HostelFragmentTkmBindingImpl;
import in.etuwa.app.databinding.InternalResultFragmentBindingImpl;
import in.etuwa.app.databinding.LabDueFragmentBindingImpl;
import in.etuwa.app.databinding.LabListFragmentBindingImpl;
import in.etuwa.app.databinding.LabPracticalFragmentBindingImpl;
import in.etuwa.app.databinding.LiveTvFragmentBindingImpl;
import in.etuwa.app.databinding.LogoutChangePasswordFragmentBindingImpl;
import in.etuwa.app.databinding.ManageActivityFragmentBindingImpl;
import in.etuwa.app.databinding.MaterialFragmentBindingImpl;
import in.etuwa.app.databinding.MedicalFragmentBindingImpl;
import in.etuwa.app.databinding.ModuleTestFragmentBindingImpl;
import in.etuwa.app.databinding.NoticeFragmentBindingImpl;
import in.etuwa.app.databinding.OnlineClassFragmentBindingImpl;
import in.etuwa.app.databinding.PlacementFragmentBindingImpl;
import in.etuwa.app.databinding.ProgramOutcomeMainFragmentBindingImpl;
import in.etuwa.app.databinding.ProofFileDialogBindingImpl;
import in.etuwa.app.databinding.QuestionBankFragmentBindingImpl;
import in.etuwa.app.databinding.QuestionDialogBindingImpl;
import in.etuwa.app.databinding.ReceiptFragmentBindingImpl;
import in.etuwa.app.databinding.RemarkFragmentBindingImpl;
import in.etuwa.app.databinding.RemindDialog2BindingImpl;
import in.etuwa.app.databinding.RemindDialogBindingImpl;
import in.etuwa.app.databinding.ReplyDialogBindingImpl;
import in.etuwa.app.databinding.ResultFragmentBindingImpl;
import in.etuwa.app.databinding.ResultModuleTestFragmentBindingImpl;
import in.etuwa.app.databinding.ResultTutorialFragmentBindingImpl;
import in.etuwa.app.databinding.ReviewDialogBindingImpl;
import in.etuwa.app.databinding.SafetyFragmentBindingImpl;
import in.etuwa.app.databinding.SemListDialogBindingImpl;
import in.etuwa.app.databinding.SemListDialogSessionBindingImpl;
import in.etuwa.app.databinding.SemRegFragmentBindingImpl;
import in.etuwa.app.databinding.SemRegViewFragmentBindingImpl;
import in.etuwa.app.databinding.SemRegisterListFragmentBindingImpl;
import in.etuwa.app.databinding.SeriesExamFragmentBindingImpl;
import in.etuwa.app.databinding.SessionalFragmentBindingImpl;
import in.etuwa.app.databinding.SpecialClassFragmentBindingImpl;
import in.etuwa.app.databinding.StoreDialogBindingImpl;
import in.etuwa.app.databinding.SubjectCoverageFragmentBindingImpl;
import in.etuwa.app.databinding.SubjectFragmentBindingImpl;
import in.etuwa.app.databinding.SubmitExamDialogBindingImpl;
import in.etuwa.app.databinding.SubmitHomeWorkDialogBindingImpl;
import in.etuwa.app.databinding.SyllabusFragmentBindingImpl;
import in.etuwa.app.databinding.TeacherFragmentBindingImpl;
import in.etuwa.app.databinding.TimeTableFragmentBindingImpl;
import in.etuwa.app.databinding.TimtableViewFragmentBindingImpl;
import in.etuwa.app.databinding.TutorialFragmentBindingImpl;
import in.etuwa.app.databinding.UnivInitialPageFragmentBindingImpl;
import in.etuwa.app.databinding.UniversityExamsFragmentBindingImpl;
import in.etuwa.app.databinding.UniversityFragmentBindingImpl;
import in.etuwa.app.databinding.UniversityResultFragmentBindingImpl;
import in.etuwa.app.databinding.UploadAssignmentDialogBindingImpl;
import in.etuwa.app.databinding.UploadTutorialDialogBindingImpl;
import in.etuwa.app.databinding.VideoClassFragmentBindingImpl;
import in.etuwa.app.databinding.ViewCounsellingFragmentBindingImpl;
import in.etuwa.app.databinding.ViewGrievanceFragmentBindingImpl;
import in.etuwa.app.databinding.ViewMvjceSemRegDialogBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIONS2DIALOG = 1;
    private static final int LAYOUT_ACTIONSDIALOG = 2;
    private static final int LAYOUT_ACTIVITYLOGIN = 3;
    private static final int LAYOUT_ACTIVITYMAIN = 4;
    private static final int LAYOUT_ACTIVITYPOINTFRAGMENT = 5;
    private static final int LAYOUT_ACTIVITYPUSH = 6;
    private static final int LAYOUT_ADDCOMPANYDIALOG = 7;
    private static final int LAYOUT_ADDCOUNSELLINGDIALOG = 8;
    private static final int LAYOUT_ADDGRIEVANCEDIALOG = 9;
    private static final int LAYOUT_ADDMEDICALLEAVE = 10;
    private static final int LAYOUT_ADDREQUESTDIALOG = 11;
    private static final int LAYOUT_APPLYINTERNSHIP = 12;
    private static final int LAYOUT_ASSIGNMENTFRAGMENT = 13;
    private static final int LAYOUT_ASSIGNMENTRESULTFRAGMENT = 14;
    private static final int LAYOUT_ASSIGNMENTSEMLISTDIALOG = 15;
    private static final int LAYOUT_ATTENDANCEBYDAYDIALOG = 16;
    private static final int LAYOUT_ATTENDANCEFRAGMENT = 17;
    private static final int LAYOUT_CELLMEMBER2DIALOG = 18;
    private static final int LAYOUT_CELLMEMBERDIALOG = 19;
    private static final int LAYOUT_CENTRALIZEDINFOFRAGMENT = 20;
    private static final int LAYOUT_CERTIFICATEREQUESTFRAGMENT = 21;
    private static final int LAYOUT_CHANGEINTIMETABLEFRAGMENT = 22;
    private static final int LAYOUT_CHANGEPROPICDIALOG = 23;
    private static final int LAYOUT_CHATFRAGMENT = 24;
    private static final int LAYOUT_CIRCULARFRAGMENT = 25;
    private static final int LAYOUT_COFRAGMENT = 26;
    private static final int LAYOUT_COMMENTDIALOG = 27;
    private static final int LAYOUT_COMMENTREPLYDIALOG = 28;
    private static final int LAYOUT_COMPLETIONCERTIFICATEDIALOG = 29;
    private static final int LAYOUT_COUNSELLINGFRAGMENT = 30;
    private static final int LAYOUT_COVIDCERTIFICATEDIALOG = 31;
    private static final int LAYOUT_COVIDCERTIFICATELISTMAINFRAGMENT = 32;
    private static final int LAYOUT_COVIDCERTIFICATETWODIALOG = 33;
    private static final int LAYOUT_DIALOGABCUPDATE = 34;
    private static final int LAYOUT_DIALOGADDACHIEVEMENTS = 35;
    private static final int LAYOUT_DIALOGADDCOURSEATTENDED = 36;
    private static final int LAYOUT_DIALOGADDFUNDEDRESEARCH = 37;
    private static final int LAYOUT_DIALOGADDMEMBERSHIP = 38;
    private static final int LAYOUT_DIALOGADDMOOCCOURSE = 39;
    private static final int LAYOUT_DIALOGADDPOSITIONHELD = 40;
    private static final int LAYOUT_DIALOGADDPROJECTWORK = 41;
    private static final int LAYOUT_DIALOGADDQUALIFIEDEXAMINATION = 42;
    private static final int LAYOUT_DIALOGADDSCHOLARSHIP = 43;
    private static final int LAYOUT_DIALOGADDSPORT = 44;
    private static final int LAYOUT_DIALOGADDTRANSREG = 45;
    private static final int LAYOUT_DIALOGADDUPDATEBANK = 46;
    private static final int LAYOUT_DIALOGADDUPDATEPUBLICATION = 47;
    private static final int LAYOUT_DIALOGAPPLYADDDIRECTLEAVE = 48;
    private static final int LAYOUT_DIALOGAPPLYHOSTELATTENDANCE = 49;
    private static final int LAYOUT_DIALOGAPPLYPREFERENCESUBREG = 50;
    private static final int LAYOUT_DIALOGAPPLYSUBJECTREGISTRATION = 51;
    private static final int LAYOUT_DIALOGASIETTRANSPORTREGISTRATION = 52;
    private static final int LAYOUT_DIALOGBANKDETAILS = 53;
    private static final int LAYOUT_DIALOGBOOKSDETAILS = 54;
    private static final int LAYOUT_DIALOGCEKSEMREG = 55;
    private static final int LAYOUT_DIALOGCHANGEPASSWORD = 56;
    private static final int LAYOUT_DIALOGCHRISTSEMREG = 57;
    private static final int LAYOUT_DIALOGCONTACTDETAILS = 58;
    private static final int LAYOUT_DIALOGDUTYLEAVE = 59;
    private static final int LAYOUT_DIALOGEDITREGISTRATION = 60;
    private static final int LAYOUT_DIALOGENGINEERFEEETAIL = 61;
    private static final int LAYOUT_DIALOGEXAMSUBJECTDETAILS = 62;
    private static final int LAYOUT_DIALOGFEECONFIRM = 63;
    private static final int LAYOUT_DIALOGGATEWAYTWO = 64;
    private static final int LAYOUT_DIALOGHOSTELNEWCONFIRM = 65;
    private static final int LAYOUT_DIALOGHOSTELNEWDETAILS = 66;
    private static final int LAYOUT_DIALOGHOSTELPARTIALEDIT = 67;
    private static final int LAYOUT_DIALOGMACESEMREG = 68;
    private static final int LAYOUT_DIALOGMATERIALDOWNLOAD = 69;
    private static final int LAYOUT_DIALOGMEASEMREG = 70;
    private static final int LAYOUT_DIALOGMESSBOOKING = 71;
    private static final int LAYOUT_DIALOGMISSION = 72;
    private static final int LAYOUT_DIALOGMMAINTENANCE = 73;
    private static final int LAYOUT_DIALOGMVJCESEMREG = 74;
    private static final int LAYOUT_DIALOGNEWREGISTRATION = 75;
    private static final int LAYOUT_DIALOGNEWREGISTRATIONAISAT = 76;
    private static final int LAYOUT_DIALOGPALAISEMREG = 77;
    private static final int LAYOUT_DIALOGPARENTAPPROVE = 78;
    private static final int LAYOUT_DIALOGPARENTDETAILS = 79;
    private static final int LAYOUT_DIALOGPERSONALDETAILS = 80;
    private static final int LAYOUT_DIALOGPROFILEUPDATE = 81;
    private static final int LAYOUT_DIALOGQRFULLSCREEN = 82;
    private static final int LAYOUT_DIALOGREREGISTRATION = 83;
    private static final int LAYOUT_DIALOGSECURITYQR = 84;
    private static final int LAYOUT_DIALOGSTATIONARYPAY = 85;
    private static final int LAYOUT_DIALOGSUBJECTPLAN = 87;
    private static final int LAYOUT_DIALOGSUBREGSTATUS = 86;
    private static final int LAYOUT_DIALOGSUGGESTBOOK = 88;
    private static final int LAYOUT_DIALOGTRANSPORTFEEPAY = 89;
    private static final int LAYOUT_DIALOGUPDATEHOURS = 90;
    private static final int LAYOUT_DIALOGVIEWPROOF = 91;
    private static final int LAYOUT_DIALOGVIEWPROOFDUTYLEAVE = 92;
    private static final int LAYOUT_DIALOGVIEWREGISTRATIONDIALOG = 94;
    private static final int LAYOUT_DIALOGVIEWSUBJECTREGISTRATION = 93;
    private static final int LAYOUT_DIALOGVISION = 95;
    private static final int LAYOUT_DUEFRAGMENT = 96;
    private static final int LAYOUT_DUEPAYFRAGMENT = 97;
    private static final int LAYOUT_DUTYLEAVEFRAGMENT = 98;
    private static final int LAYOUT_EQUIPMENTFRAGMENT = 99;
    private static final int LAYOUT_EVALUATIONFRAGMENT = 100;
    private static final int LAYOUT_EXAMFRAGMENT = 101;
    private static final int LAYOUT_EXPEREMENTFRAGMENT = 102;
    private static final int LAYOUT_FEEFRAGMENT = 103;
    private static final int LAYOUT_FRAGMENTACHIEVEMENTS = 104;
    private static final int LAYOUT_FRAGMENTASIETSEMREG = 105;
    private static final int LAYOUT_FRAGMENTASIETTRANSREGHISTORY = 106;
    private static final int LAYOUT_FRAGMENTATTENDANCEBYDAY = 107;
    private static final int LAYOUT_FRAGMENTATTENDANCECALENDARVIEW = 108;
    private static final int LAYOUT_FRAGMENTATTENDANCEDAYWISE = 109;
    private static final int LAYOUT_FRAGMENTBOOKING = 110;
    private static final int LAYOUT_FRAGMENTBOOKINGHISTORY = 111;
    private static final int LAYOUT_FRAGMENTBOOKS = 112;
    private static final int LAYOUT_FRAGMENTBOOKSRECORDS = 113;
    private static final int LAYOUT_FRAGMENTCALENDAR = 114;
    private static final int LAYOUT_FRAGMENTCOURSEATTENDED = 115;
    private static final int LAYOUT_FRAGMENTCOURSESURVEY = 116;
    private static final int LAYOUT_FRAGMENTCOURSESURVEYQUESTIONS = 117;
    private static final int LAYOUT_FRAGMENTCOURSESURVEYSUBJECTS = 118;
    private static final int LAYOUT_FRAGMENTDASHBOARD = 120;
    private static final int LAYOUT_FRAGMENTDASHTABLEVIEW = 119;
    private static final int LAYOUT_FRAGMENTDAYWISETIMETABLE = 121;
    private static final int LAYOUT_FRAGMENTDIRECTAPPLY = 122;
    private static final int LAYOUT_FRAGMENTDUESMAIN = 123;
    private static final int LAYOUT_FRAGMENTEVALUATION = 124;
    private static final int LAYOUT_FRAGMENTEXAMMAIN = 125;
    private static final int LAYOUT_FRAGMENTEXAMRECEIPT = 126;
    private static final int LAYOUT_FRAGMENTEXAMREGISTRATION = 127;
    private static final int LAYOUT_FRAGMENTEXAMREGISTRATIONMAIN = 128;
    private static final int LAYOUT_FRAGMENTEXAMREGISTRATIONNEW = 129;
    private static final int LAYOUT_FRAGMENTEXAMSUBJECT = 130;
    private static final int LAYOUT_FRAGMENTEXAMUPDATE = 131;
    private static final int LAYOUT_FRAGMENTEXAMVIEW = 132;
    private static final int LAYOUT_FRAGMENTFEEARTS = 133;
    private static final int LAYOUT_FRAGMENTFEEENGINEER = 134;
    private static final int LAYOUT_FRAGMENTFEELIST = 135;
    private static final int LAYOUT_FRAGMENTFEEMAIN = 136;
    private static final int LAYOUT_FRAGMENTFEEMAINNEW = 137;
    private static final int LAYOUT_FRAGMENTFEEMEDICAL = 138;
    private static final int LAYOUT_FRAGMENTFEEPARTIAL = 139;
    private static final int LAYOUT_FRAGMENTFIELDS = 140;
    private static final int LAYOUT_FRAGMENTFUNDEDRESEARCH = 141;
    private static final int LAYOUT_FRAGMENTGATEWAYDETAILS = 142;
    private static final int LAYOUT_FRAGMENTGRADUATEEXITSURVEYLIST = 143;
    private static final int LAYOUT_FRAGMENTGRADUATEEXITSURVEYQUESTIONS = 144;
    private static final int LAYOUT_FRAGMENTHOSTELATTENDANCE = 146;
    private static final int LAYOUT_FRAGMENTHOSTELATTENDANCEPARENTFRAGMENT = 147;
    private static final int LAYOUT_FRAGMENTHOSTELATTVIEW = 145;
    private static final int LAYOUT_FRAGMENTHOSTELFEECONFIRMFRAGMENT = 148;
    private static final int LAYOUT_FRAGMENTHOSTELFEEPALAI = 149;
    private static final int LAYOUT_FRAGMENTHOSTELFEETKM = 150;
    private static final int LAYOUT_FRAGMENTHOSTELMITS = 151;
    private static final int LAYOUT_FRAGMENTHOSTELNEW = 152;
    private static final int LAYOUT_FRAGMENTHOSTELNONMITS = 153;
    private static final int LAYOUT_FRAGMENTHOSTELPARTIAL = 154;
    private static final int LAYOUT_FRAGMENTHOSTELRECEIPT = 155;
    private static final int LAYOUT_FRAGMENTINSTRUCTIONSPAGE = 156;
    private static final int LAYOUT_FRAGMENTINTERNSHIP = 157;
    private static final int LAYOUT_FRAGMENTKMEA = 158;
    private static final int LAYOUT_FRAGMENTLAB = 159;
    private static final int LAYOUT_FRAGMENTLEAVE = 160;
    private static final int LAYOUT_FRAGMENTLEAVEMANAGEMENT = 161;
    private static final int LAYOUT_FRAGMENTMEMBERSHIP = 162;
    private static final int LAYOUT_FRAGMENTMESS = 163;
    private static final int LAYOUT_FRAGMENTMESSAGE = 164;
    private static final int LAYOUT_FRAGMENTMOOCCOURSE = 165;
    private static final int LAYOUT_FRAGMENTORDERHISTORY = 166;
    private static final int LAYOUT_FRAGMENTPALAISEMREG = 167;
    private static final int LAYOUT_FRAGMENTPAYMENTWEBVIEW = 169;
    private static final int LAYOUT_FRAGMENTPAYWEB = 168;
    private static final int LAYOUT_FRAGMENTPOQUESTIONSNEW = 170;
    private static final int LAYOUT_FRAGMENTPOSITIONHELD = 173;
    private static final int LAYOUT_FRAGMENTPOSURVEY = 171;
    private static final int LAYOUT_FRAGMENTPOSURVEYQUESTIONS = 172;
    private static final int LAYOUT_FRAGMENTPROFILE = 174;
    private static final int LAYOUT_FRAGMENTPROGRAMOUTCOME = 175;
    private static final int LAYOUT_FRAGMENTPROJECTWORK = 176;
    private static final int LAYOUT_FRAGMENTPUBLICATION = 177;
    private static final int LAYOUT_FRAGMENTQUALIFIEDEXAMINATION = 178;
    private static final int LAYOUT_FRAGMENTQUIZ = 179;
    private static final int LAYOUT_FRAGMENTQUIZQUESTIONS = 180;
    private static final int LAYOUT_FRAGMENTQUIZRESULT = 181;
    private static final int LAYOUT_FRAGMENTREGISTRATION = 182;
    private static final int LAYOUT_FRAGMENTREVALUATION = 183;
    private static final int LAYOUT_FRAGMENTREVALUATIONFEE = 184;
    private static final int LAYOUT_FRAGMENTREVALUATIONRECEIPT = 185;
    private static final int LAYOUT_FRAGMENTREVALUATIONUPDATE = 186;
    private static final int LAYOUT_FRAGMENTREVALUATIONVIEW = 187;
    private static final int LAYOUT_FRAGMENTSCHOLARSHIP = 188;
    private static final int LAYOUT_FRAGMENTSENTITEMS = 189;
    private static final int LAYOUT_FRAGMENTSPORT = 190;
    private static final int LAYOUT_FRAGMENTSTATIONARYMAIN = 191;
    private static final int LAYOUT_FRAGMENTSTORE = 192;
    private static final int LAYOUT_FRAGMENTSUBJECTREGISTRATION = 193;
    private static final int LAYOUT_FRAGMENTSURVEY = 194;
    private static final int LAYOUT_FRAGMENTTEACHERSURVEYLIST = 195;
    private static final int LAYOUT_FRAGMENTTEACHERSURVEYQUESTIONS = 196;
    private static final int LAYOUT_FRAGMENTTRANSPORT = 197;
    private static final int LAYOUT_FRAGMENTTRANSPORTBUSPASS = 198;
    private static final int LAYOUT_FRAGMENTTRANSPORTFEE = 199;
    private static final int LAYOUT_FRAGMENTTRANSPORTHISTORY = 200;
    private static final int LAYOUT_FRAGMENTTRANSPORTMAIN = 201;
    private static final int LAYOUT_FRAGMENTTRANSPORTRECEIPT = 202;
    private static final int LAYOUT_FRAGMENTTRANSPORTREGHISTORY = 203;
    private static final int LAYOUT_FRAGMENTWEBVIEW = 204;
    private static final int LAYOUT_GRIEVANCEDOCDIALOG = 205;
    private static final int LAYOUT_GRIEVANCEFRAGMENT = 206;
    private static final int LAYOUT_HOMEWORKFILESDIALOG = 207;
    private static final int LAYOUT_HOMEWORKFRAGMENT = 208;
    private static final int LAYOUT_HOSTELFRAGMENTTKM = 209;
    private static final int LAYOUT_INTERNALRESULTFRAGMENT = 210;
    private static final int LAYOUT_LABDUEFRAGMENT = 211;
    private static final int LAYOUT_LABLISTFRAGMENT = 212;
    private static final int LAYOUT_LABPRACTICALFRAGMENT = 213;
    private static final int LAYOUT_LIVETVFRAGMENT = 214;
    private static final int LAYOUT_LOGOUTCHANGEPASSWORDFRAGMENT = 215;
    private static final int LAYOUT_MANAGEACTIVITYFRAGMENT = 216;
    private static final int LAYOUT_MATERIALFRAGMENT = 217;
    private static final int LAYOUT_MEDICALFRAGMENT = 218;
    private static final int LAYOUT_MODULETESTFRAGMENT = 219;
    private static final int LAYOUT_NOTICEFRAGMENT = 220;
    private static final int LAYOUT_ONLINECLASSFRAGMENT = 221;
    private static final int LAYOUT_PLACEMENTFRAGMENT = 222;
    private static final int LAYOUT_PROGRAMOUTCOMEMAINFRAGMENT = 223;
    private static final int LAYOUT_PROOFFILEDIALOG = 224;
    private static final int LAYOUT_QUESTIONBANKFRAGMENT = 225;
    private static final int LAYOUT_QUESTIONDIALOG = 226;
    private static final int LAYOUT_RECEIPTFRAGMENT = 227;
    private static final int LAYOUT_REMARKFRAGMENT = 228;
    private static final int LAYOUT_REMINDDIALOG = 229;
    private static final int LAYOUT_REMINDDIALOG2 = 230;
    private static final int LAYOUT_REPLYDIALOG = 231;
    private static final int LAYOUT_RESULTFRAGMENT = 232;
    private static final int LAYOUT_RESULTMODULETESTFRAGMENT = 233;
    private static final int LAYOUT_RESULTTUTORIALFRAGMENT = 234;
    private static final int LAYOUT_REVIEWDIALOG = 235;
    private static final int LAYOUT_SAFETYFRAGMENT = 236;
    private static final int LAYOUT_SEMLISTDIALOG = 237;
    private static final int LAYOUT_SEMLISTDIALOGSESSION = 238;
    private static final int LAYOUT_SEMREGFRAGMENT = 239;
    private static final int LAYOUT_SEMREGISTERLISTFRAGMENT = 241;
    private static final int LAYOUT_SEMREGVIEWFRAGMENT = 240;
    private static final int LAYOUT_SERIESEXAMFRAGMENT = 242;
    private static final int LAYOUT_SESSIONALFRAGMENT = 243;
    private static final int LAYOUT_SPECIALCLASSFRAGMENT = 244;
    private static final int LAYOUT_STOREDIALOG = 245;
    private static final int LAYOUT_SUBJECTCOVERAGEFRAGMENT = 246;
    private static final int LAYOUT_SUBJECTFRAGMENT = 247;
    private static final int LAYOUT_SUBMITEXAMDIALOG = 248;
    private static final int LAYOUT_SUBMITHOMEWORKDIALOG = 249;
    private static final int LAYOUT_SYLLABUSFRAGMENT = 250;
    private static final int LAYOUT_TEACHERFRAGMENT = 251;
    private static final int LAYOUT_TIMETABLEFRAGMENT = 252;
    private static final int LAYOUT_TIMTABLEVIEWFRAGMENT = 253;
    private static final int LAYOUT_TUTORIALFRAGMENT = 254;
    private static final int LAYOUT_UNIVERSITYEXAMSFRAGMENT = 256;
    private static final int LAYOUT_UNIVERSITYFRAGMENT = 257;
    private static final int LAYOUT_UNIVERSITYRESULTFRAGMENT = 258;
    private static final int LAYOUT_UNIVINITIALPAGEFRAGMENT = 255;
    private static final int LAYOUT_UPLOADASSIGNMENTDIALOG = 259;
    private static final int LAYOUT_UPLOADTUTORIALDIALOG = 260;
    private static final int LAYOUT_VIDEOCLASSFRAGMENT = 261;
    private static final int LAYOUT_VIEWCOUNSELLINGFRAGMENT = 262;
    private static final int LAYOUT_VIEWGRIEVANCEFRAGMENT = 263;
    private static final int LAYOUT_VIEWMVJCESEMREGDIALOG = 264;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(264);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.actions2_dialog, 1);
        sparseIntArray.put(R.layout.actions_dialog, 2);
        sparseIntArray.put(R.layout.activity_login, 3);
        sparseIntArray.put(R.layout.activity_main, 4);
        sparseIntArray.put(R.layout.activity_point_fragment, 5);
        sparseIntArray.put(R.layout.activity_push, 6);
        sparseIntArray.put(R.layout.add_company_dialog, 7);
        sparseIntArray.put(R.layout.add_counselling_dialog, 8);
        sparseIntArray.put(R.layout.add_grievance_dialog, 9);
        sparseIntArray.put(R.layout.add_medical_leave, 10);
        sparseIntArray.put(R.layout.add_request_dialog, 11);
        sparseIntArray.put(R.layout.apply_internship, 12);
        sparseIntArray.put(R.layout.assignment_fragment, 13);
        sparseIntArray.put(R.layout.assignment_result_fragment, 14);
        sparseIntArray.put(R.layout.assignment_sem_list_dialog, 15);
        sparseIntArray.put(R.layout.attendance_by_day_dialog, 16);
        sparseIntArray.put(R.layout.attendance_fragment, 17);
        sparseIntArray.put(R.layout.cell_member2_dialog, 18);
        sparseIntArray.put(R.layout.cell_member_dialog, 19);
        sparseIntArray.put(R.layout.centralized_info_fragment, 20);
        sparseIntArray.put(R.layout.certificate_request_fragment, 21);
        sparseIntArray.put(R.layout.change_in_timetable_fragment, 22);
        sparseIntArray.put(R.layout.change_pro_pic_dialog, 23);
        sparseIntArray.put(R.layout.chat_fragment, 24);
        sparseIntArray.put(R.layout.circular_fragment, 25);
        sparseIntArray.put(R.layout.co_fragment, 26);
        sparseIntArray.put(R.layout.comment_dialog, 27);
        sparseIntArray.put(R.layout.comment_reply_dialog, 28);
        sparseIntArray.put(R.layout.completion_certificate_dialog, 29);
        sparseIntArray.put(R.layout.counselling_fragment, 30);
        sparseIntArray.put(R.layout.covid_certificate_dialog, 31);
        sparseIntArray.put(R.layout.covid_certificate_list_main_fragment, 32);
        sparseIntArray.put(R.layout.covid_certificate_two_dialog, 33);
        sparseIntArray.put(R.layout.dialog_abc_update, 34);
        sparseIntArray.put(R.layout.dialog_add_achievements, 35);
        sparseIntArray.put(R.layout.dialog_add_course_attended, 36);
        sparseIntArray.put(R.layout.dialog_add_funded_research, 37);
        sparseIntArray.put(R.layout.dialog_add_membership, 38);
        sparseIntArray.put(R.layout.dialog_add_mooc_course, 39);
        sparseIntArray.put(R.layout.dialog_add_position_held, 40);
        sparseIntArray.put(R.layout.dialog_add_project_work, 41);
        sparseIntArray.put(R.layout.dialog_add_qualified_examination, 42);
        sparseIntArray.put(R.layout.dialog_add_scholarship, 43);
        sparseIntArray.put(R.layout.dialog_add_sport, 44);
        sparseIntArray.put(R.layout.dialog_add_trans_reg, 45);
        sparseIntArray.put(R.layout.dialog_add_update_bank, 46);
        sparseIntArray.put(R.layout.dialog_add_update_publication, 47);
        sparseIntArray.put(R.layout.dialog_apply_add_direct_leave, 48);
        sparseIntArray.put(R.layout.dialog_apply_hostel_attendance, 49);
        sparseIntArray.put(R.layout.dialog_apply_preference_sub_reg, 50);
        sparseIntArray.put(R.layout.dialog_apply_subject_registration, 51);
        sparseIntArray.put(R.layout.dialog_asiet_transport_registration, 52);
        sparseIntArray.put(R.layout.dialog_bank_details, 53);
        sparseIntArray.put(R.layout.dialog_books_details, 54);
        sparseIntArray.put(R.layout.dialog_cek_sem_reg, 55);
        sparseIntArray.put(R.layout.dialog_change_password, 56);
        sparseIntArray.put(R.layout.dialog_christ_sem_reg, 57);
        sparseIntArray.put(R.layout.dialog_contact_details, 58);
        sparseIntArray.put(R.layout.dialog_duty_leave, 59);
        sparseIntArray.put(R.layout.dialog_edit_registration, 60);
        sparseIntArray.put(R.layout.dialog_engineer_fee_etail, 61);
        sparseIntArray.put(R.layout.dialog_exam_subject_details, 62);
        sparseIntArray.put(R.layout.dialog_fee_confirm, 63);
        sparseIntArray.put(R.layout.dialog_gateway_two, 64);
        sparseIntArray.put(R.layout.dialog_hostel_new_confirm, 65);
        sparseIntArray.put(R.layout.dialog_hostel_new_details, 66);
        sparseIntArray.put(R.layout.dialog_hostel_partial_edit, 67);
        sparseIntArray.put(R.layout.dialog_mace_sem_reg, 68);
        sparseIntArray.put(R.layout.dialog_material_download, 69);
        sparseIntArray.put(R.layout.dialog_mea_sem_reg, 70);
        sparseIntArray.put(R.layout.dialog_mess_booking, 71);
        sparseIntArray.put(R.layout.dialog_mission, 72);
        sparseIntArray.put(R.layout.dialog_mmaintenance, 73);
        sparseIntArray.put(R.layout.dialog_mvjce_sem_reg, 74);
        sparseIntArray.put(R.layout.dialog_new_registration, 75);
        sparseIntArray.put(R.layout.dialog_new_registration_aisat, 76);
        sparseIntArray.put(R.layout.dialog_palai_sem_reg, 77);
        sparseIntArray.put(R.layout.dialog_parent_approve, 78);
        sparseIntArray.put(R.layout.dialog_parent_details, 79);
        sparseIntArray.put(R.layout.dialog_personal_details, 80);
        sparseIntArray.put(R.layout.dialog_profile_update, 81);
        sparseIntArray.put(R.layout.dialog_qr_full_screen, 82);
        sparseIntArray.put(R.layout.dialog_re_registration, 83);
        sparseIntArray.put(R.layout.dialog_security_qr, 84);
        sparseIntArray.put(R.layout.dialog_stationary_pay, 85);
        sparseIntArray.put(R.layout.dialog_sub_reg_status, 86);
        sparseIntArray.put(R.layout.dialog_subject_plan, 87);
        sparseIntArray.put(R.layout.dialog_suggest_book, 88);
        sparseIntArray.put(R.layout.dialog_transport_fee_pay, 89);
        sparseIntArray.put(R.layout.dialog_update_hours, 90);
        sparseIntArray.put(R.layout.dialog_view_proof, 91);
        sparseIntArray.put(R.layout.dialog_view_proof_duty_leave, 92);
        sparseIntArray.put(R.layout.dialog_view_subject_registration, 93);
        sparseIntArray.put(R.layout.dialog_viewregistration_dialog, 94);
        sparseIntArray.put(R.layout.dialog_vision, 95);
        sparseIntArray.put(R.layout.due_fragment, 96);
        sparseIntArray.put(R.layout.due_pay_fragment, 97);
        sparseIntArray.put(R.layout.duty_leave_fragment, 98);
        sparseIntArray.put(R.layout.equipment_fragment, 99);
        sparseIntArray.put(R.layout.evaluation_fragment, 100);
        sparseIntArray.put(R.layout.exam_fragment, 101);
        sparseIntArray.put(R.layout.experement_fragment, 102);
        sparseIntArray.put(R.layout.fee_fragment, 103);
        sparseIntArray.put(R.layout.fragment_achievements, 104);
        sparseIntArray.put(R.layout.fragment_asiet_sem_reg, 105);
        sparseIntArray.put(R.layout.fragment_asiet_trans_reg_history, 106);
        sparseIntArray.put(R.layout.fragment_attendance_by_day, 107);
        sparseIntArray.put(R.layout.fragment_attendance_calendar_view, 108);
        sparseIntArray.put(R.layout.fragment_attendance_day_wise, 109);
        sparseIntArray.put(R.layout.fragment_booking, 110);
        sparseIntArray.put(R.layout.fragment_booking_history, 111);
        sparseIntArray.put(R.layout.fragment_books, 112);
        sparseIntArray.put(R.layout.fragment_books_records, 113);
        sparseIntArray.put(R.layout.fragment_calendar, 114);
        sparseIntArray.put(R.layout.fragment_course_attended, 115);
        sparseIntArray.put(R.layout.fragment_course_survey, 116);
        sparseIntArray.put(R.layout.fragment_course_survey_questions, 117);
        sparseIntArray.put(R.layout.fragment_course_survey_subjects, 118);
        sparseIntArray.put(R.layout.fragment_dash_table_view, 119);
        sparseIntArray.put(R.layout.fragment_dashboard, 120);
        sparseIntArray.put(R.layout.fragment_day_wise_time_table, 121);
        sparseIntArray.put(R.layout.fragment_direct_apply, 122);
        sparseIntArray.put(R.layout.fragment_dues_main, 123);
        sparseIntArray.put(R.layout.fragment_evaluation, 124);
        sparseIntArray.put(R.layout.fragment_exam_main, 125);
        sparseIntArray.put(R.layout.fragment_exam_receipt, 126);
        sparseIntArray.put(R.layout.fragment_exam_registration, 127);
        sparseIntArray.put(R.layout.fragment_exam_registration_main, 128);
        sparseIntArray.put(R.layout.fragment_exam_registration_new, 129);
        sparseIntArray.put(R.layout.fragment_exam_subject, 130);
        sparseIntArray.put(R.layout.fragment_exam_update, 131);
        sparseIntArray.put(R.layout.fragment_exam_view, 132);
        sparseIntArray.put(R.layout.fragment_fee_arts, 133);
        sparseIntArray.put(R.layout.fragment_fee_engineer, 134);
        sparseIntArray.put(R.layout.fragment_fee_list, 135);
        sparseIntArray.put(R.layout.fragment_fee_main, 136);
        sparseIntArray.put(R.layout.fragment_fee_main_new, 137);
        sparseIntArray.put(R.layout.fragment_fee_medical, 138);
        sparseIntArray.put(R.layout.fragment_fee_partial, 139);
        sparseIntArray.put(R.layout.fragment_fields, 140);
        sparseIntArray.put(R.layout.fragment_funded_research, 141);
        sparseIntArray.put(R.layout.fragment_gateway_details, 142);
        sparseIntArray.put(R.layout.fragment_graduate_exit_survey_list, 143);
        sparseIntArray.put(R.layout.fragment_graduate_exit_survey_questions, 144);
        sparseIntArray.put(R.layout.fragment_hostel_att_view, 145);
        sparseIntArray.put(R.layout.fragment_hostel_attendance, 146);
        sparseIntArray.put(R.layout.fragment_hostel_attendance_parent_fragment, 147);
        sparseIntArray.put(R.layout.fragment_hostel_fee_confirm_fragment, 148);
        sparseIntArray.put(R.layout.fragment_hostel_fee_palai, 149);
        sparseIntArray.put(R.layout.fragment_hostel_fee_tkm, 150);
        sparseIntArray.put(R.layout.fragment_hostel_mits, 151);
        sparseIntArray.put(R.layout.fragment_hostel_new, 152);
        sparseIntArray.put(R.layout.fragment_hostel_non_mits, 153);
        sparseIntArray.put(R.layout.fragment_hostel_partial, 154);
        sparseIntArray.put(R.layout.fragment_hostel_receipt, 155);
        sparseIntArray.put(R.layout.fragment_instructions_page, 156);
        sparseIntArray.put(R.layout.fragment_internship, 157);
        sparseIntArray.put(R.layout.fragment_kmea, 158);
        sparseIntArray.put(R.layout.fragment_lab, 159);
        sparseIntArray.put(R.layout.fragment_leave, 160);
        sparseIntArray.put(R.layout.fragment_leave_management, 161);
        sparseIntArray.put(R.layout.fragment_membership, 162);
        sparseIntArray.put(R.layout.fragment_mess, 163);
        sparseIntArray.put(R.layout.fragment_message, 164);
        sparseIntArray.put(R.layout.fragment_mooc_course, 165);
        sparseIntArray.put(R.layout.fragment_order_history, 166);
        sparseIntArray.put(R.layout.fragment_palai_sem_reg, 167);
        sparseIntArray.put(R.layout.fragment_pay_web, 168);
        sparseIntArray.put(R.layout.fragment_payment_webview, 169);
        sparseIntArray.put(R.layout.fragment_po_questions_new, 170);
        sparseIntArray.put(R.layout.fragment_po_survey, 171);
        sparseIntArray.put(R.layout.fragment_po_survey_questions, 172);
        sparseIntArray.put(R.layout.fragment_position_held, 173);
        sparseIntArray.put(R.layout.fragment_profile, 174);
        sparseIntArray.put(R.layout.fragment_program_outcome, 175);
        sparseIntArray.put(R.layout.fragment_project_work, 176);
        sparseIntArray.put(R.layout.fragment_publication, 177);
        sparseIntArray.put(R.layout.fragment_qualified_examination, 178);
        sparseIntArray.put(R.layout.fragment_quiz, 179);
        sparseIntArray.put(R.layout.fragment_quiz_questions, 180);
        sparseIntArray.put(R.layout.fragment_quiz_result, 181);
        sparseIntArray.put(R.layout.fragment_registration, 182);
        sparseIntArray.put(R.layout.fragment_revaluation, 183);
        sparseIntArray.put(R.layout.fragment_revaluation_fee, 184);
        sparseIntArray.put(R.layout.fragment_revaluation_receipt, 185);
        sparseIntArray.put(R.layout.fragment_revaluation_update, 186);
        sparseIntArray.put(R.layout.fragment_revaluation_view, 187);
        sparseIntArray.put(R.layout.fragment_scholarship, 188);
        sparseIntArray.put(R.layout.fragment_sent_items, 189);
        sparseIntArray.put(R.layout.fragment_sport, 190);
        sparseIntArray.put(R.layout.fragment_stationary_main, 191);
        sparseIntArray.put(R.layout.fragment_store, 192);
        sparseIntArray.put(R.layout.fragment_subject_registration, 193);
        sparseIntArray.put(R.layout.fragment_survey, 194);
        sparseIntArray.put(R.layout.fragment_teacher_survey_list, 195);
        sparseIntArray.put(R.layout.fragment_teacher_survey_questions, 196);
        sparseIntArray.put(R.layout.fragment_transport, 197);
        sparseIntArray.put(R.layout.fragment_transport_buspass, 198);
        sparseIntArray.put(R.layout.fragment_transport_fee, 199);
        sparseIntArray.put(R.layout.fragment_transport_history, 200);
        sparseIntArray.put(R.layout.fragment_transport_main, 201);
        sparseIntArray.put(R.layout.fragment_transport_receipt, 202);
        sparseIntArray.put(R.layout.fragment_transport_reg_history, 203);
        sparseIntArray.put(R.layout.fragment_webview, 204);
        sparseIntArray.put(R.layout.grievance_doc_dialog, 205);
        sparseIntArray.put(R.layout.grievance_fragment, 206);
        sparseIntArray.put(R.layout.home_work_files_dialog, 207);
        sparseIntArray.put(R.layout.home_work_fragment, 208);
        sparseIntArray.put(R.layout.hostel_fragment_tkm, 209);
        sparseIntArray.put(R.layout.internal_result_fragment, 210);
        sparseIntArray.put(R.layout.lab_due_fragment, 211);
        sparseIntArray.put(R.layout.lab_list_fragment, 212);
        sparseIntArray.put(R.layout.lab_practical_fragment, 213);
        sparseIntArray.put(R.layout.live_tv_fragment, 214);
        sparseIntArray.put(R.layout.logout_change_password_fragment, 215);
        sparseIntArray.put(R.layout.manage_activity_fragment, 216);
        sparseIntArray.put(R.layout.material_fragment, 217);
        sparseIntArray.put(R.layout.medical_fragment, 218);
        sparseIntArray.put(R.layout.module_test_fragment, 219);
        sparseIntArray.put(R.layout.notice_fragment, 220);
        sparseIntArray.put(R.layout.online_class_fragment, 221);
        sparseIntArray.put(R.layout.placement_fragment, 222);
        sparseIntArray.put(R.layout.program_outcome_main_fragment, 223);
        sparseIntArray.put(R.layout.proof_file_dialog, 224);
        sparseIntArray.put(R.layout.question_bank_fragment, 225);
        sparseIntArray.put(R.layout.question_dialog, 226);
        sparseIntArray.put(R.layout.receipt_fragment, 227);
        sparseIntArray.put(R.layout.remark_fragment, 228);
        sparseIntArray.put(R.layout.remind_dialog, 229);
        sparseIntArray.put(R.layout.remind_dialog2, 230);
        sparseIntArray.put(R.layout.reply_dialog, 231);
        sparseIntArray.put(R.layout.result_fragment, 232);
        sparseIntArray.put(R.layout.result_module_test_fragment, 233);
        sparseIntArray.put(R.layout.result_tutorial_fragment, 234);
        sparseIntArray.put(R.layout.review_dialog, 235);
        sparseIntArray.put(R.layout.safety_fragment, 236);
        sparseIntArray.put(R.layout.sem_list_dialog, 237);
        sparseIntArray.put(R.layout.sem_list_dialog_session, 238);
        sparseIntArray.put(R.layout.sem_reg_fragment, 239);
        sparseIntArray.put(R.layout.sem_reg_view_fragment, 240);
        sparseIntArray.put(R.layout.sem_register_list_fragment, 241);
        sparseIntArray.put(R.layout.series_exam_fragment, 242);
        sparseIntArray.put(R.layout.sessional_fragment, 243);
        sparseIntArray.put(R.layout.special_class_fragment, 244);
        sparseIntArray.put(R.layout.store_dialog, 245);
        sparseIntArray.put(R.layout.subject_coverage_fragment, 246);
        sparseIntArray.put(R.layout.subject_fragment, 247);
        sparseIntArray.put(R.layout.submit_exam_dialog, 248);
        sparseIntArray.put(R.layout.submit_home_work_dialog, 249);
        sparseIntArray.put(R.layout.syllabus_fragment, 250);
        sparseIntArray.put(R.layout.teacher_fragment, 251);
        sparseIntArray.put(R.layout.time_table_fragment, 252);
        sparseIntArray.put(R.layout.timtable_view_fragment, LAYOUT_TIMTABLEVIEWFRAGMENT);
        sparseIntArray.put(R.layout.tutorial_fragment, 254);
        sparseIntArray.put(R.layout.univ_initial_page_fragment, 255);
        sparseIntArray.put(R.layout.university_exams_fragment, 256);
        sparseIntArray.put(R.layout.university_fragment, 257);
        sparseIntArray.put(R.layout.university_result_fragment, 258);
        sparseIntArray.put(R.layout.upload_assignment_dialog, 259);
        sparseIntArray.put(R.layout.upload_tutorial_dialog, 260);
        sparseIntArray.put(R.layout.video_class_fragment, 261);
        sparseIntArray.put(R.layout.view_counselling_fragment, 262);
        sparseIntArray.put(R.layout.view_grievance_fragment, 263);
        sparseIntArray.put(R.layout.view_mvjce_sem_reg_dialog, 264);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/actions2_dialog_0".equals(tag)) {
                    return new Actions2DialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for actions2_dialog is invalid. Received: " + tag);
            case 2:
                if ("layout/actions_dialog_0".equals(tag)) {
                    return new ActionsDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for actions_dialog is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_login_0".equals(tag)) {
                    return new ActivityLoginBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_main_0".equals(tag)) {
                    return new ActivityMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_point_fragment_0".equals(tag)) {
                    return new ActivityPointFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_point_fragment is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_push_0".equals(tag)) {
                    return new ActivityPushBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_push is invalid. Received: " + tag);
            case 7:
                if ("layout/add_company_dialog_0".equals(tag)) {
                    return new AddCompanyDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for add_company_dialog is invalid. Received: " + tag);
            case 8:
                if ("layout/add_counselling_dialog_0".equals(tag)) {
                    return new AddCounsellingDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for add_counselling_dialog is invalid. Received: " + tag);
            case 9:
                if ("layout/add_grievance_dialog_0".equals(tag)) {
                    return new AddGrievanceDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for add_grievance_dialog is invalid. Received: " + tag);
            case 10:
                if ("layout/add_medical_leave_0".equals(tag)) {
                    return new AddMedicalLeaveBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for add_medical_leave is invalid. Received: " + tag);
            case 11:
                if ("layout/add_request_dialog_0".equals(tag)) {
                    return new AddRequestDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for add_request_dialog is invalid. Received: " + tag);
            case 12:
                if ("layout/apply_internship_0".equals(tag)) {
                    return new ApplyInternshipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for apply_internship is invalid. Received: " + tag);
            case 13:
                if ("layout/assignment_fragment_0".equals(tag)) {
                    return new AssignmentFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for assignment_fragment is invalid. Received: " + tag);
            case 14:
                if ("layout/assignment_result_fragment_0".equals(tag)) {
                    return new AssignmentResultFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for assignment_result_fragment is invalid. Received: " + tag);
            case 15:
                if ("layout/assignment_sem_list_dialog_0".equals(tag)) {
                    return new AssignmentSemListDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for assignment_sem_list_dialog is invalid. Received: " + tag);
            case 16:
                if ("layout/attendance_by_day_dialog_0".equals(tag)) {
                    return new AttendanceByDayDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for attendance_by_day_dialog is invalid. Received: " + tag);
            case 17:
                if ("layout/attendance_fragment_0".equals(tag)) {
                    return new AttendanceFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for attendance_fragment is invalid. Received: " + tag);
            case 18:
                if ("layout/cell_member2_dialog_0".equals(tag)) {
                    return new CellMember2DialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for cell_member2_dialog is invalid. Received: " + tag);
            case 19:
                if ("layout/cell_member_dialog_0".equals(tag)) {
                    return new CellMemberDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for cell_member_dialog is invalid. Received: " + tag);
            case 20:
                if ("layout/centralized_info_fragment_0".equals(tag)) {
                    return new CentralizedInfoFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for centralized_info_fragment is invalid. Received: " + tag);
            case 21:
                if ("layout/certificate_request_fragment_0".equals(tag)) {
                    return new CertificateRequestFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for certificate_request_fragment is invalid. Received: " + tag);
            case 22:
                if ("layout/change_in_timetable_fragment_0".equals(tag)) {
                    return new ChangeInTimetableFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for change_in_timetable_fragment is invalid. Received: " + tag);
            case 23:
                if ("layout/change_pro_pic_dialog_0".equals(tag)) {
                    return new ChangeProPicDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for change_pro_pic_dialog is invalid. Received: " + tag);
            case 24:
                if ("layout/chat_fragment_0".equals(tag)) {
                    return new ChatFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for chat_fragment is invalid. Received: " + tag);
            case 25:
                if ("layout/circular_fragment_0".equals(tag)) {
                    return new CircularFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for circular_fragment is invalid. Received: " + tag);
            case 26:
                if ("layout/co_fragment_0".equals(tag)) {
                    return new CoFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for co_fragment is invalid. Received: " + tag);
            case 27:
                if ("layout/comment_dialog_0".equals(tag)) {
                    return new CommentDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for comment_dialog is invalid. Received: " + tag);
            case 28:
                if ("layout/comment_reply_dialog_0".equals(tag)) {
                    return new CommentReplyDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for comment_reply_dialog is invalid. Received: " + tag);
            case 29:
                if ("layout/completion_certificate_dialog_0".equals(tag)) {
                    return new CompletionCertificateDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for completion_certificate_dialog is invalid. Received: " + tag);
            case 30:
                if ("layout/counselling_fragment_0".equals(tag)) {
                    return new CounsellingFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for counselling_fragment is invalid. Received: " + tag);
            case 31:
                if ("layout/covid_certificate_dialog_0".equals(tag)) {
                    return new CovidCertificateDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for covid_certificate_dialog is invalid. Received: " + tag);
            case 32:
                if ("layout/covid_certificate_list_main_fragment_0".equals(tag)) {
                    return new CovidCertificateListMainFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for covid_certificate_list_main_fragment is invalid. Received: " + tag);
            case 33:
                if ("layout/covid_certificate_two_dialog_0".equals(tag)) {
                    return new CovidCertificateTwoDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for covid_certificate_two_dialog is invalid. Received: " + tag);
            case 34:
                if ("layout/dialog_abc_update_0".equals(tag)) {
                    return new DialogAbcUpdateBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_abc_update is invalid. Received: " + tag);
            case 35:
                if ("layout/dialog_add_achievements_0".equals(tag)) {
                    return new DialogAddAchievementsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_achievements is invalid. Received: " + tag);
            case 36:
                if ("layout/dialog_add_course_attended_0".equals(tag)) {
                    return new DialogAddCourseAttendedBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_course_attended is invalid. Received: " + tag);
            case 37:
                if ("layout/dialog_add_funded_research_0".equals(tag)) {
                    return new DialogAddFundedResearchBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_funded_research is invalid. Received: " + tag);
            case 38:
                if ("layout/dialog_add_membership_0".equals(tag)) {
                    return new DialogAddMembershipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_membership is invalid. Received: " + tag);
            case 39:
                if ("layout/dialog_add_mooc_course_0".equals(tag)) {
                    return new DialogAddMoocCourseBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_mooc_course is invalid. Received: " + tag);
            case 40:
                if ("layout/dialog_add_position_held_0".equals(tag)) {
                    return new DialogAddPositionHeldBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_position_held is invalid. Received: " + tag);
            case 41:
                if ("layout/dialog_add_project_work_0".equals(tag)) {
                    return new DialogAddProjectWorkBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_project_work is invalid. Received: " + tag);
            case 42:
                if ("layout/dialog_add_qualified_examination_0".equals(tag)) {
                    return new DialogAddQualifiedExaminationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_qualified_examination is invalid. Received: " + tag);
            case 43:
                if ("layout/dialog_add_scholarship_0".equals(tag)) {
                    return new DialogAddScholarshipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_scholarship is invalid. Received: " + tag);
            case 44:
                if ("layout/dialog_add_sport_0".equals(tag)) {
                    return new DialogAddSportBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_sport is invalid. Received: " + tag);
            case 45:
                if ("layout/dialog_add_trans_reg_0".equals(tag)) {
                    return new DialogAddTransRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_trans_reg is invalid. Received: " + tag);
            case 46:
                if ("layout/dialog_add_update_bank_0".equals(tag)) {
                    return new DialogAddUpdateBankBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_update_bank is invalid. Received: " + tag);
            case 47:
                if ("layout/dialog_add_update_publication_0".equals(tag)) {
                    return new DialogAddUpdatePublicationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_update_publication is invalid. Received: " + tag);
            case 48:
                if ("layout/dialog_apply_add_direct_leave_0".equals(tag)) {
                    return new DialogApplyAddDirectLeaveBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_apply_add_direct_leave is invalid. Received: " + tag);
            case 49:
                if ("layout/dialog_apply_hostel_attendance_0".equals(tag)) {
                    return new DialogApplyHostelAttendanceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_apply_hostel_attendance is invalid. Received: " + tag);
            case 50:
                if ("layout/dialog_apply_preference_sub_reg_0".equals(tag)) {
                    return new DialogApplyPreferenceSubRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_apply_preference_sub_reg is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/dialog_apply_subject_registration_0".equals(tag)) {
                    return new DialogApplySubjectRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_apply_subject_registration is invalid. Received: " + tag);
            case 52:
                if ("layout/dialog_asiet_transport_registration_0".equals(tag)) {
                    return new DialogAsietTransportRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_asiet_transport_registration is invalid. Received: " + tag);
            case 53:
                if ("layout/dialog_bank_details_0".equals(tag)) {
                    return new DialogBankDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_bank_details is invalid. Received: " + tag);
            case 54:
                if ("layout/dialog_books_details_0".equals(tag)) {
                    return new DialogBooksDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_books_details is invalid. Received: " + tag);
            case 55:
                if ("layout/dialog_cek_sem_reg_0".equals(tag)) {
                    return new DialogCekSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_cek_sem_reg is invalid. Received: " + tag);
            case 56:
                if ("layout/dialog_change_password_0".equals(tag)) {
                    return new DialogChangePasswordBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_change_password is invalid. Received: " + tag);
            case 57:
                if ("layout/dialog_christ_sem_reg_0".equals(tag)) {
                    return new DialogChristSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_christ_sem_reg is invalid. Received: " + tag);
            case 58:
                if ("layout/dialog_contact_details_0".equals(tag)) {
                    return new DialogContactDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_contact_details is invalid. Received: " + tag);
            case 59:
                if ("layout/dialog_duty_leave_0".equals(tag)) {
                    return new DialogDutyLeaveBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_duty_leave is invalid. Received: " + tag);
            case 60:
                if ("layout/dialog_edit_registration_0".equals(tag)) {
                    return new DialogEditRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_edit_registration is invalid. Received: " + tag);
            case 61:
                if ("layout/dialog_engineer_fee_etail_0".equals(tag)) {
                    return new DialogEngineerFeeEtailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_engineer_fee_etail is invalid. Received: " + tag);
            case 62:
                if ("layout/dialog_exam_subject_details_0".equals(tag)) {
                    return new DialogExamSubjectDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_exam_subject_details is invalid. Received: " + tag);
            case 63:
                if ("layout/dialog_fee_confirm_0".equals(tag)) {
                    return new DialogFeeConfirmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_fee_confirm is invalid. Received: " + tag);
            case 64:
                if ("layout/dialog_gateway_two_0".equals(tag)) {
                    return new DialogGatewayTwoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_gateway_two is invalid. Received: " + tag);
            case 65:
                if ("layout/dialog_hostel_new_confirm_0".equals(tag)) {
                    return new DialogHostelNewConfirmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_hostel_new_confirm is invalid. Received: " + tag);
            case 66:
                if ("layout/dialog_hostel_new_details_0".equals(tag)) {
                    return new DialogHostelNewDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_hostel_new_details is invalid. Received: " + tag);
            case 67:
                if ("layout/dialog_hostel_partial_edit_0".equals(tag)) {
                    return new DialogHostelPartialEditBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_hostel_partial_edit is invalid. Received: " + tag);
            case 68:
                if ("layout/dialog_mace_sem_reg_0".equals(tag)) {
                    return new DialogMaceSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mace_sem_reg is invalid. Received: " + tag);
            case 69:
                if ("layout/dialog_material_download_0".equals(tag)) {
                    return new DialogMaterialDownloadBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_material_download is invalid. Received: " + tag);
            case 70:
                if ("layout/dialog_mea_sem_reg_0".equals(tag)) {
                    return new DialogMeaSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mea_sem_reg is invalid. Received: " + tag);
            case 71:
                if ("layout/dialog_mess_booking_0".equals(tag)) {
                    return new DialogMessBookingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mess_booking is invalid. Received: " + tag);
            case 72:
                if ("layout/dialog_mission_0".equals(tag)) {
                    return new DialogMissionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mission is invalid. Received: " + tag);
            case 73:
                if ("layout/dialog_mmaintenance_0".equals(tag)) {
                    return new DialogMmaintenanceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mmaintenance is invalid. Received: " + tag);
            case 74:
                if ("layout/dialog_mvjce_sem_reg_0".equals(tag)) {
                    return new DialogMvjceSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mvjce_sem_reg is invalid. Received: " + tag);
            case 75:
                if ("layout/dialog_new_registration_0".equals(tag)) {
                    return new DialogNewRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_new_registration is invalid. Received: " + tag);
            case 76:
                if ("layout/dialog_new_registration_aisat_0".equals(tag)) {
                    return new DialogNewRegistrationAisatBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_new_registration_aisat is invalid. Received: " + tag);
            case 77:
                if ("layout/dialog_palai_sem_reg_0".equals(tag)) {
                    return new DialogPalaiSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_palai_sem_reg is invalid. Received: " + tag);
            case 78:
                if ("layout/dialog_parent_approve_0".equals(tag)) {
                    return new DialogParentApproveBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_parent_approve is invalid. Received: " + tag);
            case 79:
                if ("layout/dialog_parent_details_0".equals(tag)) {
                    return new DialogParentDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_parent_details is invalid. Received: " + tag);
            case 80:
                if ("layout/dialog_personal_details_0".equals(tag)) {
                    return new DialogPersonalDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_personal_details is invalid. Received: " + tag);
            case 81:
                if ("layout/dialog_profile_update_0".equals(tag)) {
                    return new DialogProfileUpdateBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_profile_update is invalid. Received: " + tag);
            case 82:
                if ("layout/dialog_qr_full_screen_0".equals(tag)) {
                    return new DialogQrFullScreenBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_qr_full_screen is invalid. Received: " + tag);
            case 83:
                if ("layout/dialog_re_registration_0".equals(tag)) {
                    return new DialogReRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_re_registration is invalid. Received: " + tag);
            case 84:
                if ("layout/dialog_security_qr_0".equals(tag)) {
                    return new DialogSecurityQrBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_security_qr is invalid. Received: " + tag);
            case 85:
                if ("layout/dialog_stationary_pay_0".equals(tag)) {
                    return new DialogStationaryPayBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_stationary_pay is invalid. Received: " + tag);
            case 86:
                if ("layout/dialog_sub_reg_status_0".equals(tag)) {
                    return new DialogSubRegStatusBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_sub_reg_status is invalid. Received: " + tag);
            case 87:
                if ("layout/dialog_subject_plan_0".equals(tag)) {
                    return new DialogSubjectPlanBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_subject_plan is invalid. Received: " + tag);
            case 88:
                if ("layout/dialog_suggest_book_0".equals(tag)) {
                    return new DialogSuggestBookBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_suggest_book is invalid. Received: " + tag);
            case 89:
                if ("layout/dialog_transport_fee_pay_0".equals(tag)) {
                    return new DialogTransportFeePayBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_transport_fee_pay is invalid. Received: " + tag);
            case 90:
                if ("layout/dialog_update_hours_0".equals(tag)) {
                    return new DialogUpdateHoursBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_update_hours is invalid. Received: " + tag);
            case 91:
                if ("layout/dialog_view_proof_0".equals(tag)) {
                    return new DialogViewProofBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_view_proof is invalid. Received: " + tag);
            case 92:
                if ("layout/dialog_view_proof_duty_leave_0".equals(tag)) {
                    return new DialogViewProofDutyLeaveBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_view_proof_duty_leave is invalid. Received: " + tag);
            case 93:
                if ("layout/dialog_view_subject_registration_0".equals(tag)) {
                    return new DialogViewSubjectRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_view_subject_registration is invalid. Received: " + tag);
            case 94:
                if ("layout/dialog_viewregistration_dialog_0".equals(tag)) {
                    return new DialogViewregistrationDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_viewregistration_dialog is invalid. Received: " + tag);
            case 95:
                if ("layout/dialog_vision_0".equals(tag)) {
                    return new DialogVisionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_vision is invalid. Received: " + tag);
            case 96:
                if ("layout/due_fragment_0".equals(tag)) {
                    return new DueFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for due_fragment is invalid. Received: " + tag);
            case 97:
                if ("layout/due_pay_fragment_0".equals(tag)) {
                    return new DuePayFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for due_pay_fragment is invalid. Received: " + tag);
            case 98:
                if ("layout/duty_leave_fragment_0".equals(tag)) {
                    return new DutyLeaveFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for duty_leave_fragment is invalid. Received: " + tag);
            case 99:
                if ("layout/equipment_fragment_0".equals(tag)) {
                    return new EquipmentFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for equipment_fragment is invalid. Received: " + tag);
            case 100:
                if ("layout/evaluation_fragment_0".equals(tag)) {
                    return new EvaluationFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for evaluation_fragment is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 101:
                if ("layout/exam_fragment_0".equals(tag)) {
                    return new ExamFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for exam_fragment is invalid. Received: " + tag);
            case 102:
                if ("layout/experement_fragment_0".equals(tag)) {
                    return new ExperementFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for experement_fragment is invalid. Received: " + tag);
            case 103:
                if ("layout/fee_fragment_0".equals(tag)) {
                    return new FeeFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fee_fragment is invalid. Received: " + tag);
            case 104:
                if ("layout/fragment_achievements_0".equals(tag)) {
                    return new FragmentAchievementsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_achievements is invalid. Received: " + tag);
            case 105:
                if ("layout/fragment_asiet_sem_reg_0".equals(tag)) {
                    return new FragmentAsietSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_asiet_sem_reg is invalid. Received: " + tag);
            case 106:
                if ("layout/fragment_asiet_trans_reg_history_0".equals(tag)) {
                    return new FragmentAsietTransRegHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_asiet_trans_reg_history is invalid. Received: " + tag);
            case 107:
                if ("layout/fragment_attendance_by_day_0".equals(tag)) {
                    return new FragmentAttendanceByDayBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_attendance_by_day is invalid. Received: " + tag);
            case 108:
                if ("layout/fragment_attendance_calendar_view_0".equals(tag)) {
                    return new FragmentAttendanceCalendarViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_attendance_calendar_view is invalid. Received: " + tag);
            case 109:
                if ("layout/fragment_attendance_day_wise_0".equals(tag)) {
                    return new FragmentAttendanceDayWiseBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_attendance_day_wise is invalid. Received: " + tag);
            case 110:
                if ("layout/fragment_booking_0".equals(tag)) {
                    return new FragmentBookingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_booking is invalid. Received: " + tag);
            case 111:
                if ("layout/fragment_booking_history_0".equals(tag)) {
                    return new FragmentBookingHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_booking_history is invalid. Received: " + tag);
            case 112:
                if ("layout/fragment_books_0".equals(tag)) {
                    return new FragmentBooksBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_books is invalid. Received: " + tag);
            case 113:
                if ("layout/fragment_books_records_0".equals(tag)) {
                    return new FragmentBooksRecordsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_books_records is invalid. Received: " + tag);
            case 114:
                if ("layout/fragment_calendar_0".equals(tag)) {
                    return new FragmentCalendarBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_calendar is invalid. Received: " + tag);
            case 115:
                if ("layout/fragment_course_attended_0".equals(tag)) {
                    return new FragmentCourseAttendedBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_course_attended is invalid. Received: " + tag);
            case 116:
                if ("layout/fragment_course_survey_0".equals(tag)) {
                    return new FragmentCourseSurveyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_course_survey is invalid. Received: " + tag);
            case 117:
                if ("layout/fragment_course_survey_questions_0".equals(tag)) {
                    return new FragmentCourseSurveyQuestionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_course_survey_questions is invalid. Received: " + tag);
            case 118:
                if ("layout/fragment_course_survey_subjects_0".equals(tag)) {
                    return new FragmentCourseSurveySubjectsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_course_survey_subjects is invalid. Received: " + tag);
            case 119:
                if ("layout/fragment_dash_table_view_0".equals(tag)) {
                    return new FragmentDashTableViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dash_table_view is invalid. Received: " + tag);
            case 120:
                if ("layout/fragment_dashboard_0".equals(tag)) {
                    return new FragmentDashboardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dashboard is invalid. Received: " + tag);
            case 121:
                if ("layout/fragment_day_wise_time_table_0".equals(tag)) {
                    return new FragmentDayWiseTimeTableBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_day_wise_time_table is invalid. Received: " + tag);
            case 122:
                if ("layout/fragment_direct_apply_0".equals(tag)) {
                    return new FragmentDirectApplyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_direct_apply is invalid. Received: " + tag);
            case 123:
                if ("layout/fragment_dues_main_0".equals(tag)) {
                    return new FragmentDuesMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dues_main is invalid. Received: " + tag);
            case 124:
                if ("layout/fragment_evaluation_0".equals(tag)) {
                    return new FragmentEvaluationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_evaluation is invalid. Received: " + tag);
            case 125:
                if ("layout/fragment_exam_main_0".equals(tag)) {
                    return new FragmentExamMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_main is invalid. Received: " + tag);
            case 126:
                if ("layout/fragment_exam_receipt_0".equals(tag)) {
                    return new FragmentExamReceiptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_receipt is invalid. Received: " + tag);
            case 127:
                if ("layout/fragment_exam_registration_0".equals(tag)) {
                    return new FragmentExamRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_registration is invalid. Received: " + tag);
            case 128:
                if ("layout/fragment_exam_registration_main_0".equals(tag)) {
                    return new FragmentExamRegistrationMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_registration_main is invalid. Received: " + tag);
            case 129:
                if ("layout/fragment_exam_registration_new_0".equals(tag)) {
                    return new FragmentExamRegistrationNewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_registration_new is invalid. Received: " + tag);
            case 130:
                if ("layout/fragment_exam_subject_0".equals(tag)) {
                    return new FragmentExamSubjectBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_subject is invalid. Received: " + tag);
            case 131:
                if ("layout/fragment_exam_update_0".equals(tag)) {
                    return new FragmentExamUpdateBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_update is invalid. Received: " + tag);
            case 132:
                if ("layout/fragment_exam_view_0".equals(tag)) {
                    return new FragmentExamViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_view is invalid. Received: " + tag);
            case 133:
                if ("layout/fragment_fee_arts_0".equals(tag)) {
                    return new FragmentFeeArtsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_arts is invalid. Received: " + tag);
            case 134:
                if ("layout/fragment_fee_engineer_0".equals(tag)) {
                    return new FragmentFeeEngineerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_engineer is invalid. Received: " + tag);
            case 135:
                if ("layout/fragment_fee_list_0".equals(tag)) {
                    return new FragmentFeeListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_list is invalid. Received: " + tag);
            case 136:
                if ("layout/fragment_fee_main_0".equals(tag)) {
                    return new FragmentFeeMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_main is invalid. Received: " + tag);
            case 137:
                if ("layout/fragment_fee_main_new_0".equals(tag)) {
                    return new FragmentFeeMainNewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_main_new is invalid. Received: " + tag);
            case 138:
                if ("layout/fragment_fee_medical_0".equals(tag)) {
                    return new FragmentFeeMedicalBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_medical is invalid. Received: " + tag);
            case 139:
                if ("layout/fragment_fee_partial_0".equals(tag)) {
                    return new FragmentFeePartialBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fee_partial is invalid. Received: " + tag);
            case 140:
                if ("layout/fragment_fields_0".equals(tag)) {
                    return new FragmentFieldsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fields is invalid. Received: " + tag);
            case 141:
                if ("layout/fragment_funded_research_0".equals(tag)) {
                    return new FragmentFundedResearchBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_funded_research is invalid. Received: " + tag);
            case 142:
                if ("layout/fragment_gateway_details_0".equals(tag)) {
                    return new FragmentGatewayDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_gateway_details is invalid. Received: " + tag);
            case 143:
                if ("layout/fragment_graduate_exit_survey_list_0".equals(tag)) {
                    return new FragmentGraduateExitSurveyListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_graduate_exit_survey_list is invalid. Received: " + tag);
            case 144:
                if ("layout/fragment_graduate_exit_survey_questions_0".equals(tag)) {
                    return new FragmentGraduateExitSurveyQuestionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_graduate_exit_survey_questions is invalid. Received: " + tag);
            case 145:
                if ("layout/fragment_hostel_att_view_0".equals(tag)) {
                    return new FragmentHostelAttViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_att_view is invalid. Received: " + tag);
            case 146:
                if ("layout/fragment_hostel_attendance_0".equals(tag)) {
                    return new FragmentHostelAttendanceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_attendance is invalid. Received: " + tag);
            case 147:
                if ("layout/fragment_hostel_attendance_parent_fragment_0".equals(tag)) {
                    return new FragmentHostelAttendanceParentFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_attendance_parent_fragment is invalid. Received: " + tag);
            case 148:
                if ("layout/fragment_hostel_fee_confirm_fragment_0".equals(tag)) {
                    return new FragmentHostelFeeConfirmFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_fee_confirm_fragment is invalid. Received: " + tag);
            case 149:
                if ("layout/fragment_hostel_fee_palai_0".equals(tag)) {
                    return new FragmentHostelFeePalaiBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_fee_palai is invalid. Received: " + tag);
            case 150:
                if ("layout/fragment_hostel_fee_tkm_0".equals(tag)) {
                    return new FragmentHostelFeeTkmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_fee_tkm is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding3(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 151:
                if ("layout/fragment_hostel_mits_0".equals(tag)) {
                    return new FragmentHostelMitsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_mits is invalid. Received: " + tag);
            case 152:
                if ("layout/fragment_hostel_new_0".equals(tag)) {
                    return new FragmentHostelNewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_new is invalid. Received: " + tag);
            case 153:
                if ("layout/fragment_hostel_non_mits_0".equals(tag)) {
                    return new FragmentHostelNonMitsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_non_mits is invalid. Received: " + tag);
            case 154:
                if ("layout/fragment_hostel_partial_0".equals(tag)) {
                    return new FragmentHostelPartialBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_partial is invalid. Received: " + tag);
            case 155:
                if ("layout/fragment_hostel_receipt_0".equals(tag)) {
                    return new FragmentHostelReceiptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hostel_receipt is invalid. Received: " + tag);
            case 156:
                if ("layout/fragment_instructions_page_0".equals(tag)) {
                    return new FragmentInstructionsPageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_instructions_page is invalid. Received: " + tag);
            case 157:
                if ("layout/fragment_internship_0".equals(tag)) {
                    return new FragmentInternshipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_internship is invalid. Received: " + tag);
            case 158:
                if ("layout/fragment_kmea_0".equals(tag)) {
                    return new FragmentKmeaBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_kmea is invalid. Received: " + tag);
            case 159:
                if ("layout/fragment_lab_0".equals(tag)) {
                    return new FragmentLabBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_lab is invalid. Received: " + tag);
            case 160:
                if ("layout/fragment_leave_0".equals(tag)) {
                    return new FragmentLeaveBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_leave is invalid. Received: " + tag);
            case 161:
                if ("layout/fragment_leave_management_0".equals(tag)) {
                    return new FragmentLeaveManagementBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_leave_management is invalid. Received: " + tag);
            case 162:
                if ("layout/fragment_membership_0".equals(tag)) {
                    return new FragmentMembershipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_membership is invalid. Received: " + tag);
            case 163:
                if ("layout/fragment_mess_0".equals(tag)) {
                    return new FragmentMessBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_mess is invalid. Received: " + tag);
            case 164:
                if ("layout/fragment_message_0".equals(tag)) {
                    return new FragmentMessageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_message is invalid. Received: " + tag);
            case 165:
                if ("layout/fragment_mooc_course_0".equals(tag)) {
                    return new FragmentMoocCourseBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_mooc_course is invalid. Received: " + tag);
            case 166:
                if ("layout/fragment_order_history_0".equals(tag)) {
                    return new FragmentOrderHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_order_history is invalid. Received: " + tag);
            case 167:
                if ("layout/fragment_palai_sem_reg_0".equals(tag)) {
                    return new FragmentPalaiSemRegBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_palai_sem_reg is invalid. Received: " + tag);
            case 168:
                if ("layout/fragment_pay_web_0".equals(tag)) {
                    return new FragmentPayWebBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_pay_web is invalid. Received: " + tag);
            case 169:
                if ("layout/fragment_payment_webview_0".equals(tag)) {
                    return new FragmentPaymentWebviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_payment_webview is invalid. Received: " + tag);
            case 170:
                if ("layout/fragment_po_questions_new_0".equals(tag)) {
                    return new FragmentPoQuestionsNewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_po_questions_new is invalid. Received: " + tag);
            case 171:
                if ("layout/fragment_po_survey_0".equals(tag)) {
                    return new FragmentPoSurveyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_po_survey is invalid. Received: " + tag);
            case 172:
                if ("layout/fragment_po_survey_questions_0".equals(tag)) {
                    return new FragmentPoSurveyQuestionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_po_survey_questions is invalid. Received: " + tag);
            case 173:
                if ("layout/fragment_position_held_0".equals(tag)) {
                    return new FragmentPositionHeldBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_position_held is invalid. Received: " + tag);
            case 174:
                if ("layout/fragment_profile_0".equals(tag)) {
                    return new FragmentProfileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
            case 175:
                if ("layout/fragment_program_outcome_0".equals(tag)) {
                    return new FragmentProgramOutcomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_program_outcome is invalid. Received: " + tag);
            case 176:
                if ("layout/fragment_project_work_0".equals(tag)) {
                    return new FragmentProjectWorkBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_project_work is invalid. Received: " + tag);
            case 177:
                if ("layout/fragment_publication_0".equals(tag)) {
                    return new FragmentPublicationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_publication is invalid. Received: " + tag);
            case 178:
                if ("layout/fragment_qualified_examination_0".equals(tag)) {
                    return new FragmentQualifiedExaminationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_qualified_examination is invalid. Received: " + tag);
            case 179:
                if ("layout/fragment_quiz_0".equals(tag)) {
                    return new FragmentQuizBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_quiz is invalid. Received: " + tag);
            case 180:
                if ("layout/fragment_quiz_questions_0".equals(tag)) {
                    return new FragmentQuizQuestionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_quiz_questions is invalid. Received: " + tag);
            case 181:
                if ("layout/fragment_quiz_result_0".equals(tag)) {
                    return new FragmentQuizResultBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_quiz_result is invalid. Received: " + tag);
            case 182:
                if ("layout/fragment_registration_0".equals(tag)) {
                    return new FragmentRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_registration is invalid. Received: " + tag);
            case 183:
                if ("layout/fragment_revaluation_0".equals(tag)) {
                    return new FragmentRevaluationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_revaluation is invalid. Received: " + tag);
            case 184:
                if ("layout/fragment_revaluation_fee_0".equals(tag)) {
                    return new FragmentRevaluationFeeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_revaluation_fee is invalid. Received: " + tag);
            case 185:
                if ("layout/fragment_revaluation_receipt_0".equals(tag)) {
                    return new FragmentRevaluationReceiptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_revaluation_receipt is invalid. Received: " + tag);
            case 186:
                if ("layout/fragment_revaluation_update_0".equals(tag)) {
                    return new FragmentRevaluationUpdateBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_revaluation_update is invalid. Received: " + tag);
            case 187:
                if ("layout/fragment_revaluation_view_0".equals(tag)) {
                    return new FragmentRevaluationViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_revaluation_view is invalid. Received: " + tag);
            case 188:
                if ("layout/fragment_scholarship_0".equals(tag)) {
                    return new FragmentScholarshipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_scholarship is invalid. Received: " + tag);
            case 189:
                if ("layout/fragment_sent_items_0".equals(tag)) {
                    return new FragmentSentItemsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sent_items is invalid. Received: " + tag);
            case 190:
                if ("layout/fragment_sport_0".equals(tag)) {
                    return new FragmentSportBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sport is invalid. Received: " + tag);
            case 191:
                if ("layout/fragment_stationary_main_0".equals(tag)) {
                    return new FragmentStationaryMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_stationary_main is invalid. Received: " + tag);
            case 192:
                if ("layout/fragment_store_0".equals(tag)) {
                    return new FragmentStoreBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_store is invalid. Received: " + tag);
            case 193:
                if ("layout/fragment_subject_registration_0".equals(tag)) {
                    return new FragmentSubjectRegistrationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_subject_registration is invalid. Received: " + tag);
            case 194:
                if ("layout/fragment_survey_0".equals(tag)) {
                    return new FragmentSurveyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_survey is invalid. Received: " + tag);
            case 195:
                if ("layout/fragment_teacher_survey_list_0".equals(tag)) {
                    return new FragmentTeacherSurveyListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_teacher_survey_list is invalid. Received: " + tag);
            case 196:
                if ("layout/fragment_teacher_survey_questions_0".equals(tag)) {
                    return new FragmentTeacherSurveyQuestionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_teacher_survey_questions is invalid. Received: " + tag);
            case 197:
                if ("layout/fragment_transport_0".equals(tag)) {
                    return new FragmentTransportBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport is invalid. Received: " + tag);
            case 198:
                if ("layout/fragment_transport_buspass_0".equals(tag)) {
                    return new FragmentTransportBuspassBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport_buspass is invalid. Received: " + tag);
            case 199:
                if ("layout/fragment_transport_fee_0".equals(tag)) {
                    return new FragmentTransportFeeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport_fee is invalid. Received: " + tag);
            case 200:
                if ("layout/fragment_transport_history_0".equals(tag)) {
                    return new FragmentTransportHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport_history is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding4(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 201:
                if ("layout/fragment_transport_main_0".equals(tag)) {
                    return new FragmentTransportMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport_main is invalid. Received: " + tag);
            case 202:
                if ("layout/fragment_transport_receipt_0".equals(tag)) {
                    return new FragmentTransportReceiptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport_receipt is invalid. Received: " + tag);
            case 203:
                if ("layout/fragment_transport_reg_history_0".equals(tag)) {
                    return new FragmentTransportRegHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transport_reg_history is invalid. Received: " + tag);
            case 204:
                if ("layout/fragment_webview_0".equals(tag)) {
                    return new FragmentWebviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_webview is invalid. Received: " + tag);
            case 205:
                if ("layout/grievance_doc_dialog_0".equals(tag)) {
                    return new GrievanceDocDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for grievance_doc_dialog is invalid. Received: " + tag);
            case 206:
                if ("layout/grievance_fragment_0".equals(tag)) {
                    return new GrievanceFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for grievance_fragment is invalid. Received: " + tag);
            case 207:
                if ("layout/home_work_files_dialog_0".equals(tag)) {
                    return new HomeWorkFilesDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for home_work_files_dialog is invalid. Received: " + tag);
            case 208:
                if ("layout/home_work_fragment_0".equals(tag)) {
                    return new HomeWorkFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for home_work_fragment is invalid. Received: " + tag);
            case 209:
                if ("layout/hostel_fragment_tkm_0".equals(tag)) {
                    return new HostelFragmentTkmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for hostel_fragment_tkm is invalid. Received: " + tag);
            case 210:
                if ("layout/internal_result_fragment_0".equals(tag)) {
                    return new InternalResultFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for internal_result_fragment is invalid. Received: " + tag);
            case 211:
                if ("layout/lab_due_fragment_0".equals(tag)) {
                    return new LabDueFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for lab_due_fragment is invalid. Received: " + tag);
            case 212:
                if ("layout/lab_list_fragment_0".equals(tag)) {
                    return new LabListFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for lab_list_fragment is invalid. Received: " + tag);
            case 213:
                if ("layout/lab_practical_fragment_0".equals(tag)) {
                    return new LabPracticalFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for lab_practical_fragment is invalid. Received: " + tag);
            case 214:
                if ("layout/live_tv_fragment_0".equals(tag)) {
                    return new LiveTvFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for live_tv_fragment is invalid. Received: " + tag);
            case 215:
                if ("layout/logout_change_password_fragment_0".equals(tag)) {
                    return new LogoutChangePasswordFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for logout_change_password_fragment is invalid. Received: " + tag);
            case 216:
                if ("layout/manage_activity_fragment_0".equals(tag)) {
                    return new ManageActivityFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for manage_activity_fragment is invalid. Received: " + tag);
            case 217:
                if ("layout/material_fragment_0".equals(tag)) {
                    return new MaterialFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for material_fragment is invalid. Received: " + tag);
            case 218:
                if ("layout/medical_fragment_0".equals(tag)) {
                    return new MedicalFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for medical_fragment is invalid. Received: " + tag);
            case 219:
                if ("layout/module_test_fragment_0".equals(tag)) {
                    return new ModuleTestFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for module_test_fragment is invalid. Received: " + tag);
            case 220:
                if ("layout/notice_fragment_0".equals(tag)) {
                    return new NoticeFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for notice_fragment is invalid. Received: " + tag);
            case 221:
                if ("layout/online_class_fragment_0".equals(tag)) {
                    return new OnlineClassFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for online_class_fragment is invalid. Received: " + tag);
            case 222:
                if ("layout/placement_fragment_0".equals(tag)) {
                    return new PlacementFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for placement_fragment is invalid. Received: " + tag);
            case 223:
                if ("layout/program_outcome_main_fragment_0".equals(tag)) {
                    return new ProgramOutcomeMainFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for program_outcome_main_fragment is invalid. Received: " + tag);
            case 224:
                if ("layout/proof_file_dialog_0".equals(tag)) {
                    return new ProofFileDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for proof_file_dialog is invalid. Received: " + tag);
            case 225:
                if ("layout/question_bank_fragment_0".equals(tag)) {
                    return new QuestionBankFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for question_bank_fragment is invalid. Received: " + tag);
            case 226:
                if ("layout/question_dialog_0".equals(tag)) {
                    return new QuestionDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for question_dialog is invalid. Received: " + tag);
            case 227:
                if ("layout/receipt_fragment_0".equals(tag)) {
                    return new ReceiptFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for receipt_fragment is invalid. Received: " + tag);
            case 228:
                if ("layout/remark_fragment_0".equals(tag)) {
                    return new RemarkFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for remark_fragment is invalid. Received: " + tag);
            case 229:
                if ("layout/remind_dialog_0".equals(tag)) {
                    return new RemindDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for remind_dialog is invalid. Received: " + tag);
            case 230:
                if ("layout/remind_dialog2_0".equals(tag)) {
                    return new RemindDialog2BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for remind_dialog2 is invalid. Received: " + tag);
            case 231:
                if ("layout/reply_dialog_0".equals(tag)) {
                    return new ReplyDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for reply_dialog is invalid. Received: " + tag);
            case 232:
                if ("layout/result_fragment_0".equals(tag)) {
                    return new ResultFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for result_fragment is invalid. Received: " + tag);
            case 233:
                if ("layout/result_module_test_fragment_0".equals(tag)) {
                    return new ResultModuleTestFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for result_module_test_fragment is invalid. Received: " + tag);
            case 234:
                if ("layout/result_tutorial_fragment_0".equals(tag)) {
                    return new ResultTutorialFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for result_tutorial_fragment is invalid. Received: " + tag);
            case 235:
                if ("layout/review_dialog_0".equals(tag)) {
                    return new ReviewDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for review_dialog is invalid. Received: " + tag);
            case 236:
                if ("layout/safety_fragment_0".equals(tag)) {
                    return new SafetyFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for safety_fragment is invalid. Received: " + tag);
            case 237:
                if ("layout/sem_list_dialog_0".equals(tag)) {
                    return new SemListDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for sem_list_dialog is invalid. Received: " + tag);
            case 238:
                if ("layout/sem_list_dialog_session_0".equals(tag)) {
                    return new SemListDialogSessionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for sem_list_dialog_session is invalid. Received: " + tag);
            case 239:
                if ("layout/sem_reg_fragment_0".equals(tag)) {
                    return new SemRegFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for sem_reg_fragment is invalid. Received: " + tag);
            case 240:
                if ("layout/sem_reg_view_fragment_0".equals(tag)) {
                    return new SemRegViewFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for sem_reg_view_fragment is invalid. Received: " + tag);
            case 241:
                if ("layout/sem_register_list_fragment_0".equals(tag)) {
                    return new SemRegisterListFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for sem_register_list_fragment is invalid. Received: " + tag);
            case 242:
                if ("layout/series_exam_fragment_0".equals(tag)) {
                    return new SeriesExamFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for series_exam_fragment is invalid. Received: " + tag);
            case 243:
                if ("layout/sessional_fragment_0".equals(tag)) {
                    return new SessionalFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for sessional_fragment is invalid. Received: " + tag);
            case 244:
                if ("layout/special_class_fragment_0".equals(tag)) {
                    return new SpecialClassFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for special_class_fragment is invalid. Received: " + tag);
            case 245:
                if ("layout/store_dialog_0".equals(tag)) {
                    return new StoreDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for store_dialog is invalid. Received: " + tag);
            case 246:
                if ("layout/subject_coverage_fragment_0".equals(tag)) {
                    return new SubjectCoverageFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for subject_coverage_fragment is invalid. Received: " + tag);
            case 247:
                if ("layout/subject_fragment_0".equals(tag)) {
                    return new SubjectFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for subject_fragment is invalid. Received: " + tag);
            case 248:
                if ("layout/submit_exam_dialog_0".equals(tag)) {
                    return new SubmitExamDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for submit_exam_dialog is invalid. Received: " + tag);
            case 249:
                if ("layout/submit_home_work_dialog_0".equals(tag)) {
                    return new SubmitHomeWorkDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for submit_home_work_dialog is invalid. Received: " + tag);
            case 250:
                if ("layout/syllabus_fragment_0".equals(tag)) {
                    return new SyllabusFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for syllabus_fragment is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding5(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 251:
                if ("layout/teacher_fragment_0".equals(tag)) {
                    return new TeacherFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for teacher_fragment is invalid. Received: " + tag);
            case 252:
                if ("layout/time_table_fragment_0".equals(tag)) {
                    return new TimeTableFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for time_table_fragment is invalid. Received: " + tag);
            case LAYOUT_TIMTABLEVIEWFRAGMENT /* 253 */:
                if ("layout/timtable_view_fragment_0".equals(tag)) {
                    return new TimtableViewFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for timtable_view_fragment is invalid. Received: " + tag);
            case 254:
                if ("layout/tutorial_fragment_0".equals(tag)) {
                    return new TutorialFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for tutorial_fragment is invalid. Received: " + tag);
            case 255:
                if ("layout/univ_initial_page_fragment_0".equals(tag)) {
                    return new UnivInitialPageFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for univ_initial_page_fragment is invalid. Received: " + tag);
            case 256:
                if ("layout/university_exams_fragment_0".equals(tag)) {
                    return new UniversityExamsFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for university_exams_fragment is invalid. Received: " + tag);
            case 257:
                if ("layout/university_fragment_0".equals(tag)) {
                    return new UniversityFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for university_fragment is invalid. Received: " + tag);
            case 258:
                if ("layout/university_result_fragment_0".equals(tag)) {
                    return new UniversityResultFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for university_result_fragment is invalid. Received: " + tag);
            case 259:
                if ("layout/upload_assignment_dialog_0".equals(tag)) {
                    return new UploadAssignmentDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for upload_assignment_dialog is invalid. Received: " + tag);
            case 260:
                if ("layout/upload_tutorial_dialog_0".equals(tag)) {
                    return new UploadTutorialDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for upload_tutorial_dialog is invalid. Received: " + tag);
            case 261:
                if ("layout/video_class_fragment_0".equals(tag)) {
                    return new VideoClassFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for video_class_fragment is invalid. Received: " + tag);
            case 262:
                if ("layout/view_counselling_fragment_0".equals(tag)) {
                    return new ViewCounsellingFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_counselling_fragment is invalid. Received: " + tag);
            case 263:
                if ("layout/view_grievance_fragment_0".equals(tag)) {
                    return new ViewGrievanceFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_grievance_fragment is invalid. Received: " + tag);
            case 264:
                if ("layout/view_mvjce_sem_reg_dialog_0".equals(tag)) {
                    return new ViewMvjceSemRegDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_mvjce_sem_reg_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (i <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i2 = (i - 1) / 50;
        if (i2 == 0) {
            return internalGetViewDataBinding0(component, view, i, tag);
        }
        if (i2 == 1) {
            return internalGetViewDataBinding1(component, view, i, tag);
        }
        if (i2 == 2) {
            return internalGetViewDataBinding2(component, view, i, tag);
        }
        if (i2 == 3) {
            return internalGetViewDataBinding3(component, view, i, tag);
        }
        if (i2 == 4) {
            return internalGetViewDataBinding4(component, view, i, tag);
        }
        if (i2 != 5) {
            return null;
        }
        return internalGetViewDataBinding5(component, view, i, tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return InnerBrLookup.sKeys.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(DataBinderMapperImpl.LAYOUT_TIMTABLEVIEWFRAGMENT);
            sKeys = sparseArray;
            sparseArray.put(1, "HostelNewDetailsViewModel");
            sparseArray.put(2, "MaintenanceViewModel");
            sparseArray.put(3, "TeacherSurveyQuestionViewModel");
            sparseArray.put(0, "_all");
            sparseArray.put(4, "achievementsViewModel");
            sparseArray.put(5, "actionsDialogViewModel");
            sparseArray.put(6, "activityPointViewModel");
            sparseArray.put(7, "addAchievementsViewModel");
            sparseArray.put(8, "addCompanyDialogViewModel");
            sparseArray.put(9, "addCounsellingDialogViewModel");
            sparseArray.put(10, "addCourseAttendedViewModel");
            sparseArray.put(11, "addFundedResearchViewModel");
            sparseArray.put(12, "addGrievanceDialogViewModel");
            sparseArray.put(13, "addMedicalLeaveViewModel");
            sparseArray.put(14, "addMembershipViewModel");
            sparseArray.put(15, "addMoocCourseViewModel");
            sparseArray.put(16, "addPositionHeldViewModel");
            sparseArray.put(17, "addProjectWorkViewModel");
            sparseArray.put(18, "addPublicationViewModel");
            sparseArray.put(19, "addQualifiedExaminationViewModel");
            sparseArray.put(20, "addRequestDialogViewModel");
            sparseArray.put(21, "addScholarshipViewModel");
            sparseArray.put(22, "addSportViewModel");
            sparseArray.put(23, "addUpdateBankViewModel");
            sparseArray.put(24, "applyDirectDutyLeaveViewModel");
            sparseArray.put(25, "applyInternshipViewModel");
            sparseArray.put(26, "applyPreferenceSubRegViewModel");
            sparseArray.put(27, "applySubjectRegistrationViewModel");
            sparseArray.put(28, "asietSemRegViewModel");
            sparseArray.put(29, "asietTransRegViewModel");
            sparseArray.put(30, "assignmentResultViewModel");
            sparseArray.put(31, "assignmentSemListDialogViewModel");
            sparseArray.put(32, "assignmentViewModel");
            sparseArray.put(33, "attendanceByDayViewModel");
            sparseArray.put(34, "attendanceCalendarViewViewModel");
            sparseArray.put(35, "attendanceDayDialogViewModel");
            sparseArray.put(36, "attendanceViewModel");
            sparseArray.put(37, "bankDetailsViewModel");
            sparseArray.put(38, "bookRecordViewModel");
            sparseArray.put(39, "bookingHistoryViewModel");
            sparseArray.put(40, "bookingViewModel");
            sparseArray.put(41, "booksDetailsViewModel");
            sparseArray.put(42, "booksViewModel");
            sparseArray.put(43, "busPassViewModel");
            sparseArray.put(44, "calendarViewModel");
            sparseArray.put(45, "cellMember2DialogViewModel");
            sparseArray.put(46, "cellMemberDialogViewModel");
            sparseArray.put(47, "centralizedInfoViewModel");
            sparseArray.put(48, "certificateRequestViewModel");
            sparseArray.put(49, "changeInTimetableViewModel");
            sparseArray.put(50, "changePasswordDialogViewModel");
            sparseArray.put(51, "changeProPicDialogViewModel");
            sparseArray.put(52, "chatViewModel");
            sparseArray.put(53, "christSemRegViewModel");
            sparseArray.put(54, "circularViewModel");
            sparseArray.put(55, "coViewModel");
            sparseArray.put(56, "commentDialogViewModel");
            sparseArray.put(57, "commentReplyDialogViewModel");
            sparseArray.put(58, "completionCertificateDialogViewModel");
            sparseArray.put(59, "contactDetailsViewModel");
            sparseArray.put(60, "counsellingViewModel");
            sparseArray.put(61, "courseSurveyQuestionsViewModel");
            sparseArray.put(62, "courseSurveySubjectsViewModel");
            sparseArray.put(63, "coursesAttendedViewModel");
            sparseArray.put(64, "covidCertificateDialogViewModel");
            sparseArray.put(65, "covidCertificateListMainViewModel");
            sparseArray.put(66, "covidCertificateTwoDialogViewModel");
            sparseArray.put(67, "dashTableViewViewModel");
            sparseArray.put(68, "dashboardViewModel");
            sparseArray.put(69, "dayWiseTimeTableViewModel");
            sparseArray.put(70, "directApplyViewModel");
            sparseArray.put(71, "dueMainViewModel");
            sparseArray.put(72, "duePayViewModel");
            sparseArray.put(73, "dueViewModel");
            sparseArray.put(74, "dutyLeaveViewModel");
            sparseArray.put(75, "editRegistrationViewModel");
            sparseArray.put(76, "equipmentViewModel");
            sparseArray.put(77, "evaluationViewModel");
            sparseArray.put(78, "examMainViewModel");
            sparseArray.put(79, "examReceiptViewModel");
            sparseArray.put(80, "examRegisterViewModel");
            sparseArray.put(81, "examRegistrationMainNewViewModel");
            sparseArray.put(82, "examRegistrationViewModel");
            sparseArray.put(83, "examSubjectDetailViewModel");
            sparseArray.put(84, "examSubjectViewModel");
            sparseArray.put(85, "examViewModel");
            sparseArray.put(86, "examViewViewModel");
            sparseArray.put(87, "experimentViewModel");
            sparseArray.put(88, "feeArtsViewModel");
            sparseArray.put(89, "feeConfirmViewModel");
            sparseArray.put(90, "feeDetailViewModelViewModel");
            sparseArray.put(91, "feeEngineeringViewModel");
            sparseArray.put(92, "feeListViewModel");
            sparseArray.put(93, "feeMainNewViewModel");
            sparseArray.put(94, "feeMainViewModel");
            sparseArray.put(95, "feeMedicalViewModel");
            sparseArray.put(96, "feeViewModel");
            sparseArray.put(97, "fieldsViewModel");
            sparseArray.put(98, "fundedResearchViewModel");
            sparseArray.put(99, "gatewayTwoViewModel");
            sparseArray.put(100, "gatewayViewModel");
            sparseArray.put(101, "graduateExitSurveyViewModel");
            sparseArray.put(102, "graduateSurveyQuestionsViewModel");
            sparseArray.put(103, "grievanceDocDialogViewModel");
            sparseArray.put(104, "grievanceViewModel");
            sparseArray.put(105, "homeWorkFilesDialogViewModel");
            sparseArray.put(106, "homeWorkViewModel");
            sparseArray.put(107, "hostelApplyLeaveViewModel");
            sparseArray.put(108, "hostelAttendanceParentViewModel");
            sparseArray.put(109, "hostelAttendanceViewModel");
            sparseArray.put(110, "hostelFeeConfirmViewModel");
            sparseArray.put(111, "hostelFeeTkmViewModel");
            sparseArray.put(112, "hostelMainViewModel");
            sparseArray.put(113, "hostelMitsViewModel");
            sparseArray.put(114, "hostelNewConfirmViewModel");
            sparseArray.put(115, "hostelNewViewModel");
            sparseArray.put(116, "hostelNonMitsViewModel");
            sparseArray.put(117, "hostelPartialEditViewModel");
            sparseArray.put(118, "hostelPartialViewModel");
            sparseArray.put(119, "hostelViewLeaveViewModel");
            sparseArray.put(120, "instructionsPageViewModel");
            sparseArray.put(121, "internalResultViewModel");
            sparseArray.put(122, "internshipViewModel");
            sparseArray.put(123, "kmeaHostelViewModel");
            sparseArray.put(124, "labDueViewModel");
            sparseArray.put(125, "labListViewModel");
            sparseArray.put(126, "labPracticalViewModel");
            sparseArray.put(127, "labViewModel");
            sparseArray.put(128, "leaveManagementViewModel");
            sparseArray.put(129, "leaveViewModel");
            sparseArray.put(130, "liveTvViewModel");
            sparseArray.put(131, "loginViewModel");
            sparseArray.put(132, "logoutChangePasswordViewModel");
            sparseArray.put(133, "maceNewSemRegViewModel");
            sparseArray.put(134, "mainViewModel");
            sparseArray.put(135, "manageActivityViewModel");
            sparseArray.put(136, "materialDownloadViewModel");
            sparseArray.put(137, "materialViewModel");
            sparseArray.put(138, "meaSemRegViewModel");
            sparseArray.put(139, "medicalViewModel");
            sparseArray.put(140, "membershipViewModel");
            sparseArray.put(141, "messBookingViewModel");
            sparseArray.put(142, "messViewModel");
            sparseArray.put(143, "messageViewModel");
            sparseArray.put(144, "missionDialogViewModel");
            sparseArray.put(145, "moduleTestViewModel");
            sparseArray.put(146, "moocCourseViewModel");
            sparseArray.put(147, "mvjceSemRegViewModel");
            sparseArray.put(148, "newQuizViewModel");
            sparseArray.put(149, "newRegistrationViewModel");
            sparseArray.put(150, "noticeViewModel");
            sparseArray.put(151, "onlineClassViewModel");
            sparseArray.put(152, "orderHistoryViewModel");
            sparseArray.put(153, "orderPageViewModel");
            sparseArray.put(154, "pOSurveyViewModel");
            sparseArray.put(155, "palaiHostelViewModel");
            sparseArray.put(156, "palaiNewSemRegViewModel");
            sparseArray.put(157, "palaiSemesterRegViewModel");
            sparseArray.put(158, "parentApproveViewModel");
            sparseArray.put(159, "parentDetailsViewModel");
            sparseArray.put(160, "payWebViewModel");
            sparseArray.put(161, "paymentWebViewViewModel");
            sparseArray.put(162, "personalDetailsViewModel");
            sparseArray.put(163, "placementViewModel");
            sparseArray.put(164, "poSurveyQuestionsNewViewModel");
            sparseArray.put(165, "poSurveyQuestionsViewModel");
            sparseArray.put(166, "positionHeldViewModel");
            sparseArray.put(167, "profileViewModel");
            sparseArray.put(168, "programOutcomeMainViewModel");
            sparseArray.put(169, "programOutcomeViewModel");
            sparseArray.put(170, "projectWorkViewModel");
            sparseArray.put(171, "proofDutyLeaveViewModel");
            sparseArray.put(172, "proofFileDialogViewModel");
            sparseArray.put(173, "publicationViewModel");
            sparseArray.put(174, "pushViewModel");
            sparseArray.put(175, "qrFullScreenViewModel");
            sparseArray.put(176, "qualifiedExaminationViewModel");
            sparseArray.put(177, "questionBankViewModel");
            sparseArray.put(178, "questionDialogViewModel");
            sparseArray.put(179, "quizQuestionsViewModel");
            sparseArray.put(180, "quizResultViewModel");
            sparseArray.put(181, "reRegistrationViewModel");
            sparseArray.put(182, "receiptViewModel");
            sparseArray.put(183, "registrationViewModel");
            sparseArray.put(184, "remarkViewModel");
            sparseArray.put(185, "remindDialogViewModel");
            sparseArray.put(186, "reminderDialogViewModel");
            sparseArray.put(187, "replyViewModel");
            sparseArray.put(188, "resultModuleTestViewModel");
            sparseArray.put(189, "resultViewModel");
            sparseArray.put(190, "revaluationFeeViewModel");
            sparseArray.put(191, "revaluationReceiptViewModel");
            sparseArray.put(192, "revaluationUpdateViewModel");
            sparseArray.put(193, "revaluationViewModel");
            sparseArray.put(194, "revaluationViewViewModel");
            sparseArray.put(195, "reviewDialogViewModel");
            sparseArray.put(196, "safetyViewModel");
            sparseArray.put(197, "scholarshipViewModel");
            sparseArray.put(198, "securityQrViewModel");
            sparseArray.put(199, "semListDialogViewModel");
            sparseArray.put(200, "semListDialogViewModelTwo");
            sparseArray.put(201, "semRegViewModel");
            sparseArray.put(202, "semRegViewViewModel");
            sparseArray.put(203, "semRegisterListViewModel");
            sparseArray.put(204, "sentItemViewModel");
            sparseArray.put(205, "seriesExamViewModel");
            sparseArray.put(206, "sessionalViewModel");
            sparseArray.put(207, "specialClassViewModel");
            sparseArray.put(208, "sportViewModel");
            sparseArray.put(209, "stationaryMainViewModel");
            sparseArray.put(210, "storeDialogViewModel");
            sparseArray.put(211, "storeViewModel");
            sparseArray.put(212, "subjectCoverageViewModel");
            sparseArray.put(213, "subjectPlanViewModel");
            sparseArray.put(214, "subjectRegStatusViewModel");
            sparseArray.put(215, "subjectRegistrationViewModel");
            sparseArray.put(216, "subjectViewModel");
            sparseArray.put(217, "submitExamDialogViewModel");
            sparseArray.put(218, "submitHomeWorkDialogViewModel");
            sparseArray.put(219, "suggestBookViewModel");
            sparseArray.put(220, "surveyViewModel");
            sparseArray.put(221, "syllabusViewModel");
            sparseArray.put(222, "teacherSurveyViewModel");
            sparseArray.put(223, "teacherViewModel");
            sparseArray.put(224, "timetableViewViewModel");
            sparseArray.put(225, "tkmReceiptViewModel");
            sparseArray.put(226, "transportFeeViewModel");
            sparseArray.put(227, "transportHistoryViewModel");
            sparseArray.put(228, "transportMainViewModel");
            sparseArray.put(229, "transportRegHistoryViewModel");
            sparseArray.put(230, "transportRegistrationViewModel");
            sparseArray.put(231, "trasportFeePayViewModel");
            sparseArray.put(232, "tutorialResultViewModel");
            sparseArray.put(233, "tutorialViewModel");
            sparseArray.put(234, "univInitialPageViewModel");
            sparseArray.put(235, "universityExamsViewModel");
            sparseArray.put(236, "universityResultViewModel");
            sparseArray.put(237, "universityViewModel");
            sparseArray.put(238, "updateAbcViewModel");
            sparseArray.put(239, "updateHoursDirectViewModel");
            sparseArray.put(240, "updateRegisterViewModel");
            sparseArray.put(241, "uploadAssignmentDialogViewModel");
            sparseArray.put(242, "uploadTutorialDialogViewModel");
            sparseArray.put(243, "videoClassViewModel");
            sparseArray.put(244, "viewCounsellingViewModel");
            sparseArray.put(245, "viewGrievanceViewModel");
            sparseArray.put(246, "viewMvjceSemRegViewModel");
            sparseArray.put(247, "viewProofDutyLeaveViewModel");
            sparseArray.put(248, "viewProofViewModel");
            sparseArray.put(249, "viewRegistrationViewModel");
            sparseArray.put(250, "viewSubjectRegistrationViewModel");
            sparseArray.put(251, "visionDialogViewModel");
            sparseArray.put(252, "webViewViewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(264);
            sKeys = map;
            map.put("layout/actions2_dialog_0", Integer.valueOf(R.layout.actions2_dialog));
            map.put("layout/actions_dialog_0", Integer.valueOf(R.layout.actions_dialog));
            map.put("layout/activity_login_0", Integer.valueOf(R.layout.activity_login));
            map.put("layout/activity_main_0", Integer.valueOf(R.layout.activity_main));
            map.put("layout/activity_point_fragment_0", Integer.valueOf(R.layout.activity_point_fragment));
            map.put("layout/activity_push_0", Integer.valueOf(R.layout.activity_push));
            map.put("layout/add_company_dialog_0", Integer.valueOf(R.layout.add_company_dialog));
            map.put("layout/add_counselling_dialog_0", Integer.valueOf(R.layout.add_counselling_dialog));
            map.put("layout/add_grievance_dialog_0", Integer.valueOf(R.layout.add_grievance_dialog));
            map.put("layout/add_medical_leave_0", Integer.valueOf(R.layout.add_medical_leave));
            map.put("layout/add_request_dialog_0", Integer.valueOf(R.layout.add_request_dialog));
            map.put("layout/apply_internship_0", Integer.valueOf(R.layout.apply_internship));
            map.put("layout/assignment_fragment_0", Integer.valueOf(R.layout.assignment_fragment));
            map.put("layout/assignment_result_fragment_0", Integer.valueOf(R.layout.assignment_result_fragment));
            map.put("layout/assignment_sem_list_dialog_0", Integer.valueOf(R.layout.assignment_sem_list_dialog));
            map.put("layout/attendance_by_day_dialog_0", Integer.valueOf(R.layout.attendance_by_day_dialog));
            map.put("layout/attendance_fragment_0", Integer.valueOf(R.layout.attendance_fragment));
            map.put("layout/cell_member2_dialog_0", Integer.valueOf(R.layout.cell_member2_dialog));
            map.put("layout/cell_member_dialog_0", Integer.valueOf(R.layout.cell_member_dialog));
            map.put("layout/centralized_info_fragment_0", Integer.valueOf(R.layout.centralized_info_fragment));
            map.put("layout/certificate_request_fragment_0", Integer.valueOf(R.layout.certificate_request_fragment));
            map.put("layout/change_in_timetable_fragment_0", Integer.valueOf(R.layout.change_in_timetable_fragment));
            map.put("layout/change_pro_pic_dialog_0", Integer.valueOf(R.layout.change_pro_pic_dialog));
            map.put("layout/chat_fragment_0", Integer.valueOf(R.layout.chat_fragment));
            map.put("layout/circular_fragment_0", Integer.valueOf(R.layout.circular_fragment));
            map.put("layout/co_fragment_0", Integer.valueOf(R.layout.co_fragment));
            map.put("layout/comment_dialog_0", Integer.valueOf(R.layout.comment_dialog));
            map.put("layout/comment_reply_dialog_0", Integer.valueOf(R.layout.comment_reply_dialog));
            map.put("layout/completion_certificate_dialog_0", Integer.valueOf(R.layout.completion_certificate_dialog));
            map.put("layout/counselling_fragment_0", Integer.valueOf(R.layout.counselling_fragment));
            map.put("layout/covid_certificate_dialog_0", Integer.valueOf(R.layout.covid_certificate_dialog));
            map.put("layout/covid_certificate_list_main_fragment_0", Integer.valueOf(R.layout.covid_certificate_list_main_fragment));
            map.put("layout/covid_certificate_two_dialog_0", Integer.valueOf(R.layout.covid_certificate_two_dialog));
            map.put("layout/dialog_abc_update_0", Integer.valueOf(R.layout.dialog_abc_update));
            map.put("layout/dialog_add_achievements_0", Integer.valueOf(R.layout.dialog_add_achievements));
            map.put("layout/dialog_add_course_attended_0", Integer.valueOf(R.layout.dialog_add_course_attended));
            map.put("layout/dialog_add_funded_research_0", Integer.valueOf(R.layout.dialog_add_funded_research));
            map.put("layout/dialog_add_membership_0", Integer.valueOf(R.layout.dialog_add_membership));
            map.put("layout/dialog_add_mooc_course_0", Integer.valueOf(R.layout.dialog_add_mooc_course));
            map.put("layout/dialog_add_position_held_0", Integer.valueOf(R.layout.dialog_add_position_held));
            map.put("layout/dialog_add_project_work_0", Integer.valueOf(R.layout.dialog_add_project_work));
            map.put("layout/dialog_add_qualified_examination_0", Integer.valueOf(R.layout.dialog_add_qualified_examination));
            map.put("layout/dialog_add_scholarship_0", Integer.valueOf(R.layout.dialog_add_scholarship));
            map.put("layout/dialog_add_sport_0", Integer.valueOf(R.layout.dialog_add_sport));
            map.put("layout/dialog_add_trans_reg_0", Integer.valueOf(R.layout.dialog_add_trans_reg));
            map.put("layout/dialog_add_update_bank_0", Integer.valueOf(R.layout.dialog_add_update_bank));
            map.put("layout/dialog_add_update_publication_0", Integer.valueOf(R.layout.dialog_add_update_publication));
            map.put("layout/dialog_apply_add_direct_leave_0", Integer.valueOf(R.layout.dialog_apply_add_direct_leave));
            map.put("layout/dialog_apply_hostel_attendance_0", Integer.valueOf(R.layout.dialog_apply_hostel_attendance));
            map.put("layout/dialog_apply_preference_sub_reg_0", Integer.valueOf(R.layout.dialog_apply_preference_sub_reg));
            map.put("layout/dialog_apply_subject_registration_0", Integer.valueOf(R.layout.dialog_apply_subject_registration));
            map.put("layout/dialog_asiet_transport_registration_0", Integer.valueOf(R.layout.dialog_asiet_transport_registration));
            map.put("layout/dialog_bank_details_0", Integer.valueOf(R.layout.dialog_bank_details));
            map.put("layout/dialog_books_details_0", Integer.valueOf(R.layout.dialog_books_details));
            map.put("layout/dialog_cek_sem_reg_0", Integer.valueOf(R.layout.dialog_cek_sem_reg));
            map.put("layout/dialog_change_password_0", Integer.valueOf(R.layout.dialog_change_password));
            map.put("layout/dialog_christ_sem_reg_0", Integer.valueOf(R.layout.dialog_christ_sem_reg));
            map.put("layout/dialog_contact_details_0", Integer.valueOf(R.layout.dialog_contact_details));
            map.put("layout/dialog_duty_leave_0", Integer.valueOf(R.layout.dialog_duty_leave));
            map.put("layout/dialog_edit_registration_0", Integer.valueOf(R.layout.dialog_edit_registration));
            map.put("layout/dialog_engineer_fee_etail_0", Integer.valueOf(R.layout.dialog_engineer_fee_etail));
            map.put("layout/dialog_exam_subject_details_0", Integer.valueOf(R.layout.dialog_exam_subject_details));
            map.put("layout/dialog_fee_confirm_0", Integer.valueOf(R.layout.dialog_fee_confirm));
            map.put("layout/dialog_gateway_two_0", Integer.valueOf(R.layout.dialog_gateway_two));
            map.put("layout/dialog_hostel_new_confirm_0", Integer.valueOf(R.layout.dialog_hostel_new_confirm));
            map.put("layout/dialog_hostel_new_details_0", Integer.valueOf(R.layout.dialog_hostel_new_details));
            map.put("layout/dialog_hostel_partial_edit_0", Integer.valueOf(R.layout.dialog_hostel_partial_edit));
            map.put("layout/dialog_mace_sem_reg_0", Integer.valueOf(R.layout.dialog_mace_sem_reg));
            map.put("layout/dialog_material_download_0", Integer.valueOf(R.layout.dialog_material_download));
            map.put("layout/dialog_mea_sem_reg_0", Integer.valueOf(R.layout.dialog_mea_sem_reg));
            map.put("layout/dialog_mess_booking_0", Integer.valueOf(R.layout.dialog_mess_booking));
            map.put("layout/dialog_mission_0", Integer.valueOf(R.layout.dialog_mission));
            map.put("layout/dialog_mmaintenance_0", Integer.valueOf(R.layout.dialog_mmaintenance));
            map.put("layout/dialog_mvjce_sem_reg_0", Integer.valueOf(R.layout.dialog_mvjce_sem_reg));
            map.put("layout/dialog_new_registration_0", Integer.valueOf(R.layout.dialog_new_registration));
            map.put("layout/dialog_new_registration_aisat_0", Integer.valueOf(R.layout.dialog_new_registration_aisat));
            map.put("layout/dialog_palai_sem_reg_0", Integer.valueOf(R.layout.dialog_palai_sem_reg));
            map.put("layout/dialog_parent_approve_0", Integer.valueOf(R.layout.dialog_parent_approve));
            map.put("layout/dialog_parent_details_0", Integer.valueOf(R.layout.dialog_parent_details));
            map.put("layout/dialog_personal_details_0", Integer.valueOf(R.layout.dialog_personal_details));
            map.put("layout/dialog_profile_update_0", Integer.valueOf(R.layout.dialog_profile_update));
            map.put("layout/dialog_qr_full_screen_0", Integer.valueOf(R.layout.dialog_qr_full_screen));
            map.put("layout/dialog_re_registration_0", Integer.valueOf(R.layout.dialog_re_registration));
            map.put("layout/dialog_security_qr_0", Integer.valueOf(R.layout.dialog_security_qr));
            map.put("layout/dialog_stationary_pay_0", Integer.valueOf(R.layout.dialog_stationary_pay));
            map.put("layout/dialog_sub_reg_status_0", Integer.valueOf(R.layout.dialog_sub_reg_status));
            map.put("layout/dialog_subject_plan_0", Integer.valueOf(R.layout.dialog_subject_plan));
            map.put("layout/dialog_suggest_book_0", Integer.valueOf(R.layout.dialog_suggest_book));
            map.put("layout/dialog_transport_fee_pay_0", Integer.valueOf(R.layout.dialog_transport_fee_pay));
            map.put("layout/dialog_update_hours_0", Integer.valueOf(R.layout.dialog_update_hours));
            map.put("layout/dialog_view_proof_0", Integer.valueOf(R.layout.dialog_view_proof));
            map.put("layout/dialog_view_proof_duty_leave_0", Integer.valueOf(R.layout.dialog_view_proof_duty_leave));
            map.put("layout/dialog_view_subject_registration_0", Integer.valueOf(R.layout.dialog_view_subject_registration));
            map.put("layout/dialog_viewregistration_dialog_0", Integer.valueOf(R.layout.dialog_viewregistration_dialog));
            map.put("layout/dialog_vision_0", Integer.valueOf(R.layout.dialog_vision));
            map.put("layout/due_fragment_0", Integer.valueOf(R.layout.due_fragment));
            map.put("layout/due_pay_fragment_0", Integer.valueOf(R.layout.due_pay_fragment));
            map.put("layout/duty_leave_fragment_0", Integer.valueOf(R.layout.duty_leave_fragment));
            map.put("layout/equipment_fragment_0", Integer.valueOf(R.layout.equipment_fragment));
            map.put("layout/evaluation_fragment_0", Integer.valueOf(R.layout.evaluation_fragment));
            map.put("layout/exam_fragment_0", Integer.valueOf(R.layout.exam_fragment));
            map.put("layout/experement_fragment_0", Integer.valueOf(R.layout.experement_fragment));
            map.put("layout/fee_fragment_0", Integer.valueOf(R.layout.fee_fragment));
            map.put("layout/fragment_achievements_0", Integer.valueOf(R.layout.fragment_achievements));
            map.put("layout/fragment_asiet_sem_reg_0", Integer.valueOf(R.layout.fragment_asiet_sem_reg));
            map.put("layout/fragment_asiet_trans_reg_history_0", Integer.valueOf(R.layout.fragment_asiet_trans_reg_history));
            map.put("layout/fragment_attendance_by_day_0", Integer.valueOf(R.layout.fragment_attendance_by_day));
            map.put("layout/fragment_attendance_calendar_view_0", Integer.valueOf(R.layout.fragment_attendance_calendar_view));
            map.put("layout/fragment_attendance_day_wise_0", Integer.valueOf(R.layout.fragment_attendance_day_wise));
            map.put("layout/fragment_booking_0", Integer.valueOf(R.layout.fragment_booking));
            map.put("layout/fragment_booking_history_0", Integer.valueOf(R.layout.fragment_booking_history));
            map.put("layout/fragment_books_0", Integer.valueOf(R.layout.fragment_books));
            map.put("layout/fragment_books_records_0", Integer.valueOf(R.layout.fragment_books_records));
            map.put("layout/fragment_calendar_0", Integer.valueOf(R.layout.fragment_calendar));
            map.put("layout/fragment_course_attended_0", Integer.valueOf(R.layout.fragment_course_attended));
            map.put("layout/fragment_course_survey_0", Integer.valueOf(R.layout.fragment_course_survey));
            map.put("layout/fragment_course_survey_questions_0", Integer.valueOf(R.layout.fragment_course_survey_questions));
            map.put("layout/fragment_course_survey_subjects_0", Integer.valueOf(R.layout.fragment_course_survey_subjects));
            map.put("layout/fragment_dash_table_view_0", Integer.valueOf(R.layout.fragment_dash_table_view));
            map.put("layout/fragment_dashboard_0", Integer.valueOf(R.layout.fragment_dashboard));
            map.put("layout/fragment_day_wise_time_table_0", Integer.valueOf(R.layout.fragment_day_wise_time_table));
            map.put("layout/fragment_direct_apply_0", Integer.valueOf(R.layout.fragment_direct_apply));
            map.put("layout/fragment_dues_main_0", Integer.valueOf(R.layout.fragment_dues_main));
            map.put("layout/fragment_evaluation_0", Integer.valueOf(R.layout.fragment_evaluation));
            map.put("layout/fragment_exam_main_0", Integer.valueOf(R.layout.fragment_exam_main));
            map.put("layout/fragment_exam_receipt_0", Integer.valueOf(R.layout.fragment_exam_receipt));
            map.put("layout/fragment_exam_registration_0", Integer.valueOf(R.layout.fragment_exam_registration));
            map.put("layout/fragment_exam_registration_main_0", Integer.valueOf(R.layout.fragment_exam_registration_main));
            map.put("layout/fragment_exam_registration_new_0", Integer.valueOf(R.layout.fragment_exam_registration_new));
            map.put("layout/fragment_exam_subject_0", Integer.valueOf(R.layout.fragment_exam_subject));
            map.put("layout/fragment_exam_update_0", Integer.valueOf(R.layout.fragment_exam_update));
            map.put("layout/fragment_exam_view_0", Integer.valueOf(R.layout.fragment_exam_view));
            map.put("layout/fragment_fee_arts_0", Integer.valueOf(R.layout.fragment_fee_arts));
            map.put("layout/fragment_fee_engineer_0", Integer.valueOf(R.layout.fragment_fee_engineer));
            map.put("layout/fragment_fee_list_0", Integer.valueOf(R.layout.fragment_fee_list));
            map.put("layout/fragment_fee_main_0", Integer.valueOf(R.layout.fragment_fee_main));
            map.put("layout/fragment_fee_main_new_0", Integer.valueOf(R.layout.fragment_fee_main_new));
            map.put("layout/fragment_fee_medical_0", Integer.valueOf(R.layout.fragment_fee_medical));
            map.put("layout/fragment_fee_partial_0", Integer.valueOf(R.layout.fragment_fee_partial));
            map.put("layout/fragment_fields_0", Integer.valueOf(R.layout.fragment_fields));
            map.put("layout/fragment_funded_research_0", Integer.valueOf(R.layout.fragment_funded_research));
            map.put("layout/fragment_gateway_details_0", Integer.valueOf(R.layout.fragment_gateway_details));
            map.put("layout/fragment_graduate_exit_survey_list_0", Integer.valueOf(R.layout.fragment_graduate_exit_survey_list));
            map.put("layout/fragment_graduate_exit_survey_questions_0", Integer.valueOf(R.layout.fragment_graduate_exit_survey_questions));
            map.put("layout/fragment_hostel_att_view_0", Integer.valueOf(R.layout.fragment_hostel_att_view));
            map.put("layout/fragment_hostel_attendance_0", Integer.valueOf(R.layout.fragment_hostel_attendance));
            map.put("layout/fragment_hostel_attendance_parent_fragment_0", Integer.valueOf(R.layout.fragment_hostel_attendance_parent_fragment));
            map.put("layout/fragment_hostel_fee_confirm_fragment_0", Integer.valueOf(R.layout.fragment_hostel_fee_confirm_fragment));
            map.put("layout/fragment_hostel_fee_palai_0", Integer.valueOf(R.layout.fragment_hostel_fee_palai));
            map.put("layout/fragment_hostel_fee_tkm_0", Integer.valueOf(R.layout.fragment_hostel_fee_tkm));
            map.put("layout/fragment_hostel_mits_0", Integer.valueOf(R.layout.fragment_hostel_mits));
            map.put("layout/fragment_hostel_new_0", Integer.valueOf(R.layout.fragment_hostel_new));
            map.put("layout/fragment_hostel_non_mits_0", Integer.valueOf(R.layout.fragment_hostel_non_mits));
            map.put("layout/fragment_hostel_partial_0", Integer.valueOf(R.layout.fragment_hostel_partial));
            map.put("layout/fragment_hostel_receipt_0", Integer.valueOf(R.layout.fragment_hostel_receipt));
            map.put("layout/fragment_instructions_page_0", Integer.valueOf(R.layout.fragment_instructions_page));
            map.put("layout/fragment_internship_0", Integer.valueOf(R.layout.fragment_internship));
            map.put("layout/fragment_kmea_0", Integer.valueOf(R.layout.fragment_kmea));
            map.put("layout/fragment_lab_0", Integer.valueOf(R.layout.fragment_lab));
            map.put("layout/fragment_leave_0", Integer.valueOf(R.layout.fragment_leave));
            map.put("layout/fragment_leave_management_0", Integer.valueOf(R.layout.fragment_leave_management));
            map.put("layout/fragment_membership_0", Integer.valueOf(R.layout.fragment_membership));
            map.put("layout/fragment_mess_0", Integer.valueOf(R.layout.fragment_mess));
            map.put("layout/fragment_message_0", Integer.valueOf(R.layout.fragment_message));
            map.put("layout/fragment_mooc_course_0", Integer.valueOf(R.layout.fragment_mooc_course));
            map.put("layout/fragment_order_history_0", Integer.valueOf(R.layout.fragment_order_history));
            map.put("layout/fragment_palai_sem_reg_0", Integer.valueOf(R.layout.fragment_palai_sem_reg));
            map.put("layout/fragment_pay_web_0", Integer.valueOf(R.layout.fragment_pay_web));
            map.put("layout/fragment_payment_webview_0", Integer.valueOf(R.layout.fragment_payment_webview));
            map.put("layout/fragment_po_questions_new_0", Integer.valueOf(R.layout.fragment_po_questions_new));
            map.put("layout/fragment_po_survey_0", Integer.valueOf(R.layout.fragment_po_survey));
            map.put("layout/fragment_po_survey_questions_0", Integer.valueOf(R.layout.fragment_po_survey_questions));
            map.put("layout/fragment_position_held_0", Integer.valueOf(R.layout.fragment_position_held));
            map.put("layout/fragment_profile_0", Integer.valueOf(R.layout.fragment_profile));
            map.put("layout/fragment_program_outcome_0", Integer.valueOf(R.layout.fragment_program_outcome));
            map.put("layout/fragment_project_work_0", Integer.valueOf(R.layout.fragment_project_work));
            map.put("layout/fragment_publication_0", Integer.valueOf(R.layout.fragment_publication));
            map.put("layout/fragment_qualified_examination_0", Integer.valueOf(R.layout.fragment_qualified_examination));
            map.put("layout/fragment_quiz_0", Integer.valueOf(R.layout.fragment_quiz));
            map.put("layout/fragment_quiz_questions_0", Integer.valueOf(R.layout.fragment_quiz_questions));
            map.put("layout/fragment_quiz_result_0", Integer.valueOf(R.layout.fragment_quiz_result));
            map.put("layout/fragment_registration_0", Integer.valueOf(R.layout.fragment_registration));
            map.put("layout/fragment_revaluation_0", Integer.valueOf(R.layout.fragment_revaluation));
            map.put("layout/fragment_revaluation_fee_0", Integer.valueOf(R.layout.fragment_revaluation_fee));
            map.put("layout/fragment_revaluation_receipt_0", Integer.valueOf(R.layout.fragment_revaluation_receipt));
            map.put("layout/fragment_revaluation_update_0", Integer.valueOf(R.layout.fragment_revaluation_update));
            map.put("layout/fragment_revaluation_view_0", Integer.valueOf(R.layout.fragment_revaluation_view));
            map.put("layout/fragment_scholarship_0", Integer.valueOf(R.layout.fragment_scholarship));
            map.put("layout/fragment_sent_items_0", Integer.valueOf(R.layout.fragment_sent_items));
            map.put("layout/fragment_sport_0", Integer.valueOf(R.layout.fragment_sport));
            map.put("layout/fragment_stationary_main_0", Integer.valueOf(R.layout.fragment_stationary_main));
            map.put("layout/fragment_store_0", Integer.valueOf(R.layout.fragment_store));
            map.put("layout/fragment_subject_registration_0", Integer.valueOf(R.layout.fragment_subject_registration));
            map.put("layout/fragment_survey_0", Integer.valueOf(R.layout.fragment_survey));
            map.put("layout/fragment_teacher_survey_list_0", Integer.valueOf(R.layout.fragment_teacher_survey_list));
            map.put("layout/fragment_teacher_survey_questions_0", Integer.valueOf(R.layout.fragment_teacher_survey_questions));
            map.put("layout/fragment_transport_0", Integer.valueOf(R.layout.fragment_transport));
            map.put("layout/fragment_transport_buspass_0", Integer.valueOf(R.layout.fragment_transport_buspass));
            map.put("layout/fragment_transport_fee_0", Integer.valueOf(R.layout.fragment_transport_fee));
            map.put("layout/fragment_transport_history_0", Integer.valueOf(R.layout.fragment_transport_history));
            map.put("layout/fragment_transport_main_0", Integer.valueOf(R.layout.fragment_transport_main));
            map.put("layout/fragment_transport_receipt_0", Integer.valueOf(R.layout.fragment_transport_receipt));
            map.put("layout/fragment_transport_reg_history_0", Integer.valueOf(R.layout.fragment_transport_reg_history));
            map.put("layout/fragment_webview_0", Integer.valueOf(R.layout.fragment_webview));
            map.put("layout/grievance_doc_dialog_0", Integer.valueOf(R.layout.grievance_doc_dialog));
            map.put("layout/grievance_fragment_0", Integer.valueOf(R.layout.grievance_fragment));
            map.put("layout/home_work_files_dialog_0", Integer.valueOf(R.layout.home_work_files_dialog));
            map.put("layout/home_work_fragment_0", Integer.valueOf(R.layout.home_work_fragment));
            map.put("layout/hostel_fragment_tkm_0", Integer.valueOf(R.layout.hostel_fragment_tkm));
            map.put("layout/internal_result_fragment_0", Integer.valueOf(R.layout.internal_result_fragment));
            map.put("layout/lab_due_fragment_0", Integer.valueOf(R.layout.lab_due_fragment));
            map.put("layout/lab_list_fragment_0", Integer.valueOf(R.layout.lab_list_fragment));
            map.put("layout/lab_practical_fragment_0", Integer.valueOf(R.layout.lab_practical_fragment));
            map.put("layout/live_tv_fragment_0", Integer.valueOf(R.layout.live_tv_fragment));
            map.put("layout/logout_change_password_fragment_0", Integer.valueOf(R.layout.logout_change_password_fragment));
            map.put("layout/manage_activity_fragment_0", Integer.valueOf(R.layout.manage_activity_fragment));
            map.put("layout/material_fragment_0", Integer.valueOf(R.layout.material_fragment));
            map.put("layout/medical_fragment_0", Integer.valueOf(R.layout.medical_fragment));
            map.put("layout/module_test_fragment_0", Integer.valueOf(R.layout.module_test_fragment));
            map.put("layout/notice_fragment_0", Integer.valueOf(R.layout.notice_fragment));
            map.put("layout/online_class_fragment_0", Integer.valueOf(R.layout.online_class_fragment));
            map.put("layout/placement_fragment_0", Integer.valueOf(R.layout.placement_fragment));
            map.put("layout/program_outcome_main_fragment_0", Integer.valueOf(R.layout.program_outcome_main_fragment));
            map.put("layout/proof_file_dialog_0", Integer.valueOf(R.layout.proof_file_dialog));
            map.put("layout/question_bank_fragment_0", Integer.valueOf(R.layout.question_bank_fragment));
            map.put("layout/question_dialog_0", Integer.valueOf(R.layout.question_dialog));
            map.put("layout/receipt_fragment_0", Integer.valueOf(R.layout.receipt_fragment));
            map.put("layout/remark_fragment_0", Integer.valueOf(R.layout.remark_fragment));
            map.put("layout/remind_dialog_0", Integer.valueOf(R.layout.remind_dialog));
            map.put("layout/remind_dialog2_0", Integer.valueOf(R.layout.remind_dialog2));
            map.put("layout/reply_dialog_0", Integer.valueOf(R.layout.reply_dialog));
            map.put("layout/result_fragment_0", Integer.valueOf(R.layout.result_fragment));
            map.put("layout/result_module_test_fragment_0", Integer.valueOf(R.layout.result_module_test_fragment));
            map.put("layout/result_tutorial_fragment_0", Integer.valueOf(R.layout.result_tutorial_fragment));
            map.put("layout/review_dialog_0", Integer.valueOf(R.layout.review_dialog));
            map.put("layout/safety_fragment_0", Integer.valueOf(R.layout.safety_fragment));
            map.put("layout/sem_list_dialog_0", Integer.valueOf(R.layout.sem_list_dialog));
            map.put("layout/sem_list_dialog_session_0", Integer.valueOf(R.layout.sem_list_dialog_session));
            map.put("layout/sem_reg_fragment_0", Integer.valueOf(R.layout.sem_reg_fragment));
            map.put("layout/sem_reg_view_fragment_0", Integer.valueOf(R.layout.sem_reg_view_fragment));
            map.put("layout/sem_register_list_fragment_0", Integer.valueOf(R.layout.sem_register_list_fragment));
            map.put("layout/series_exam_fragment_0", Integer.valueOf(R.layout.series_exam_fragment));
            map.put("layout/sessional_fragment_0", Integer.valueOf(R.layout.sessional_fragment));
            map.put("layout/special_class_fragment_0", Integer.valueOf(R.layout.special_class_fragment));
            map.put("layout/store_dialog_0", Integer.valueOf(R.layout.store_dialog));
            map.put("layout/subject_coverage_fragment_0", Integer.valueOf(R.layout.subject_coverage_fragment));
            map.put("layout/subject_fragment_0", Integer.valueOf(R.layout.subject_fragment));
            map.put("layout/submit_exam_dialog_0", Integer.valueOf(R.layout.submit_exam_dialog));
            map.put("layout/submit_home_work_dialog_0", Integer.valueOf(R.layout.submit_home_work_dialog));
            map.put("layout/syllabus_fragment_0", Integer.valueOf(R.layout.syllabus_fragment));
            map.put("layout/teacher_fragment_0", Integer.valueOf(R.layout.teacher_fragment));
            map.put("layout/time_table_fragment_0", Integer.valueOf(R.layout.time_table_fragment));
            map.put("layout/timtable_view_fragment_0", Integer.valueOf(R.layout.timtable_view_fragment));
            map.put("layout/tutorial_fragment_0", Integer.valueOf(R.layout.tutorial_fragment));
            map.put("layout/univ_initial_page_fragment_0", Integer.valueOf(R.layout.univ_initial_page_fragment));
            map.put("layout/university_exams_fragment_0", Integer.valueOf(R.layout.university_exams_fragment));
            map.put("layout/university_fragment_0", Integer.valueOf(R.layout.university_fragment));
            map.put("layout/university_result_fragment_0", Integer.valueOf(R.layout.university_result_fragment));
            map.put("layout/upload_assignment_dialog_0", Integer.valueOf(R.layout.upload_assignment_dialog));
            map.put("layout/upload_tutorial_dialog_0", Integer.valueOf(R.layout.upload_tutorial_dialog));
            map.put("layout/video_class_fragment_0", Integer.valueOf(R.layout.video_class_fragment));
            map.put("layout/view_counselling_fragment_0", Integer.valueOf(R.layout.view_counselling_fragment));
            map.put("layout/view_grievance_fragment_0", Integer.valueOf(R.layout.view_grievance_fragment));
            map.put("layout/view_mvjce_sem_reg_dialog_0", Integer.valueOf(R.layout.view_mvjce_sem_reg_dialog));
        }
    }
}