package in.etuwa.app.helper;

import androidx.fragment.app.Fragment;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: MainCallBackListener.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bL\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\u0003H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0005H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0005H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\b\u0010.\u001a\u00020\u0003H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u001a\u00100\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020&H&J\b\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u0003H&J\b\u00104\u001a\u00020\u0003H&J\b\u00105\u001a\u00020\u0003H&J\b\u00106\u001a\u00020\u0003H&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020,H&J\b\u00109\u001a\u00020\u0003H&J\u001a\u0010:\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\b\u0010;\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J$\u0010=\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\b\u0010@\u001a\u00020\u0003H&J\u0010\u0010A\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&H&J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&H&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&H&J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&H&J\b\u0010F\u001a\u00020\u0003H&J\b\u0010G\u001a\u00020\u0003H&J\b\u0010H\u001a\u00020\u0003H&J\b\u0010I\u001a\u00020\u0003H&J\b\u0010J\u001a\u00020\u0003H&J\u001a\u0010K\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010L\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010M\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010N\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\b\u0010O\u001a\u00020\u0003H&J\b\u0010P\u001a\u00020\u0003H&J\b\u0010Q\u001a\u00020\u0003H&J\b\u0010R\u001a\u00020\u0003H&J\u0010\u0010S\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H&J\b\u0010T\u001a\u00020\u0003H&J\u0010\u0010U\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010V\u001a\u00020\u0003H&J\b\u0010W\u001a\u00020\u0003H&J\b\u0010X\u001a\u00020\u0003H&J\u0012\u0010Y\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&J\b\u0010Z\u001a\u00020\u0003H&J\"\u0010[\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\\\u001a\u00020&2\u0006\u0010]\u001a\u00020&H&J\u0010\u0010^\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010_\u001a\u00020\u0003H&J\u0010\u0010`\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H&J\u0018\u0010a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010a\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H&J\u0010\u0010c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010e\u001a\u00020\u0003H&J\u0010\u0010f\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u0010\u0010g\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010h\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010i\u001a\u00020\u0003H&J\u0018\u0010j\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020&H&J\u0018\u0010k\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020&H&J\b\u0010l\u001a\u00020\u0003H&J\b\u0010m\u001a\u00020\u0003H&J\u0010\u0010n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010o\u001a\u00020\u0003H&J\b\u0010p\u001a\u00020\u0003H&J\u0018\u0010q\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H&J\u0010\u0010r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010s\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u0005H&J\u0010\u0010u\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010v\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\b\u0010w\u001a\u00020\u0003H&J@\u0010x\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00050yj\b\u0012\u0004\u0012\u00020\u0005`z2\u0016\u0010{\u001a\u0012\u0012\u0004\u0012\u00020\u00050yj\b\u0012\u0004\u0012\u00020\u0005`z2\u0006\u0010\u0012\u001a\u00020&H&J\u0010\u0010|\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010}\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010~\u001a\u00020\u0003H&J\u0018\u0010\u007f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u0005H&J\t\u0010\u0080\u0001\u001a\u00020\u0003H&JZ\u0010\u0081\u0001\u001a\u00020\u00032\u0007\u0010\u0082\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0085\u0001\u001a\u00020\u00052\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0087\u0001\u001a\u00020\u00052\u0007\u0010\u0088\u0001\u001a\u00020\u00052\u0007\u0010\u0089\u0001\u001a\u00020\u00052\u0007\u0010\u008a\u0001\u001a\u00020\u0005H&J\t\u0010\u008b\u0001\u001a\u00020\u0003H&J\t\u0010\u008c\u0001\u001a\u00020\u0003H&J\t\u0010\u008d\u0001\u001a\u00020\u0003H&J\t\u0010\u008e\u0001\u001a\u00020\u0003H&J\u0011\u0010\u008f\u0001\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0090\u0001"}, d2 = {"Lin/etuwa/app/helper/MainCallBackListener;", "", "answerCourseSurvey", "", "id", "", "sessionId", "dismissView", "doGeneralSurvey", "doPOSurvey", "doTeacherSurvey", "teacherId", "subjectId", SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "subject", "editProfileBtnClicked", "examManagementMainClick", "flag", "examUniversityResult", "forceOpenPoSurvey", "forceOpenProfile", "gatewayDetailsClicked", "hostelFeeWeb", "url", "loadAcademicPay", "loadChangeTimetable", "loadHostelPay", "month", "year", "loadSpecialTimetable", "loadStoreView", StoreFragmentKt.SUB_ID, "makeLogout", "navigateToFragment", "newFragment", "Landroidx/fragment/app/Fragment;", "onAttendanceCardClicked", "", "onCourseSurveyCompleted", "surveyId", "onCourseSurveyCompletedFully", "onDashboardItemClick", CommonCssConstants.POSITION, "", "onDashboardParent", "onDismissProfile", "onExamDashboardItemClick", "onFinishSemRegistration", "edit", "onGradiateSurveyOpen", "onGraduateExitSurveyCompleted", "onHostelAttViewClicked", "onHostelMainAttViewClicked", "onHostelMessClicked", "onHostelNextClicked", FeeConfirmDialogKt.ARG_TOTAL, "onInfoClicked", "onLabEquipmentItemClick", "labId", "onLabMainItemClick", "onLabPracticalItemClick", "subPid", "onLibraryMainClicked", "onLiveClicked", "onMainChangeLogoutClick", "onMainDueClick", "onMainFeeClick", "onMainHostelClick", "onMainStoreClick", "onMarqueeClicked", "onMessOrderHistoryClicked", "onPOSurveyCompleted", "onPalaiHostelPayClick", "onQuizCompleted", "onSurveyCompleted", "onSurveyFullyCompleted", "onTeacherSurveyCompleted", "onTkmDashboardItemClick", "onTkmHostelPayClick", "onTkmHostelReceipt", "onTkmHostelRegistration", "openAsietSemReg", "openCoPage", "openCourseSurvey", "openCourseSurvey2", "openForceSemReg", "openForceToDoSurvey", "openManageActivity", "openPaymentPage", "openPoSurvey", "openSemRegisterPage", "isEdit", "feeStatus", "openSemRegisterViewPage", "openSpotRegistration", "openSubCovePage", "openSurvey", "openSyllabusPage", "openViewCounselling", "openViewGrievance", "profileLogoutClicked", "programOutcomeCells", "quizAttemptBtnClicked", "quizViewResult", "removeFragment", "revaluationClicked", "revaluationUpdateClicked", "showByDayAttendance", "showCourseSurvey", "showCourseSurveySubjects", "showDayWiseTable", "showDirectApplyFragment", "showDoGraduateSurvey", "showExamRegFragment", "showExamRegisterFragment", "category", "showExamResultFragment", "showKmeaHostelFragment", "showMissionDialog", "showRevaluationFee", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "id2", "showRevaluationReceipt", "showTeacherSurveyList", "showTransportHistory", "showUpdateRegisterFragment", "showVisionDialog", "spotRegistrationClicked", "name", "mobileNumber", "number", ClientCookie.PORT_ATTR, "zone", "type", "ton", "place", "distance", "transportBtnClicked", "transportBusPassBtnClicked", "transportReceiptBtnClicked", "transportRegBtnClicked", "viewRevaluationClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface MainCallBackListener {
    void answerCourseSurvey(String id, String sessionId);

    void dismissView();

    void doGeneralSurvey(String id);

    void doPOSurvey(String id);

    void doTeacherSurvey(String id, String teacherId, String subjectId, String image, String semester, String subject);

    void editProfileBtnClicked();

    void examManagementMainClick(String flag);

    void examUniversityResult();

    void forceOpenPoSurvey();

    void forceOpenProfile();

    void gatewayDetailsClicked();

    void hostelFeeWeb(String url);

    void loadAcademicPay(String id);

    void loadChangeTimetable();

    void loadHostelPay(String month, String year);

    void loadSpecialTimetable();

    void loadStoreView(String subId);

    void makeLogout();

    void navigateToFragment(Fragment newFragment);

    void onAttendanceCardClicked(boolean flag);

    void onCourseSurveyCompleted(String surveyId);

    void onCourseSurveyCompletedFully(String surveyId);

    void onDashboardItemClick(int position);

    void onDashboardParent(int position);

    void onDismissProfile();

    void onExamDashboardItemClick(int position);

    void onFinishSemRegistration(String id, boolean edit);

    void onGradiateSurveyOpen();

    void onGraduateExitSurveyCompleted();

    void onHostelAttViewClicked();

    void onHostelMainAttViewClicked();

    void onHostelMessClicked();

    void onHostelNextClicked(int total);

    void onInfoClicked();

    void onLabEquipmentItemClick(int position, String labId);

    void onLabMainItemClick(int position);

    void onLabPracticalItemClick(int position, String subId, String subPid);

    void onLibraryMainClicked(int position);

    void onLiveClicked();

    void onMainChangeLogoutClick(boolean flag);

    void onMainDueClick(boolean flag);

    void onMainFeeClick(boolean flag);

    void onMainHostelClick(boolean flag);

    void onMainStoreClick(boolean flag);

    void onMarqueeClicked();

    void onMessOrderHistoryClicked();

    void onPOSurveyCompleted();

    void onPalaiHostelPayClick();

    void onQuizCompleted();

    void onSurveyCompleted(boolean flag, String surveyId);

    void onSurveyFullyCompleted(boolean flag, String surveyId);

    void onTeacherSurveyCompleted(boolean flag, String surveyId);

    void onTkmDashboardItemClick(int position);

    void onTkmHostelPayClick();

    void onTkmHostelReceipt();

    void onTkmHostelRegistration();

    void openAsietSemReg();

    void openCoPage(String subId);

    void openCourseSurvey();

    void openCourseSurvey2(String id);

    void openForceSemReg();

    void openForceToDoSurvey();

    void openManageActivity();

    void openPaymentPage(String url);

    void openPoSurvey();

    void openSemRegisterPage(String id, boolean isEdit, boolean feeStatus);

    void openSemRegisterViewPage(String id);

    void openSpotRegistration();

    void openSubCovePage(String subId);

    void openSurvey(String surveyId, String teacherId, String subjectId);

    void openSurvey(boolean flag, String id);

    void openSyllabusPage(String subId);

    void openViewCounselling(String id);

    void openViewGrievance(String id);

    void profileLogoutClicked();

    void programOutcomeCells(int position);

    void quizAttemptBtnClicked(String id);

    void quizViewResult(String id);

    void removeFragment();

    void revaluationClicked(String id, boolean flag);

    void revaluationUpdateClicked(String id, boolean flag);

    void showByDayAttendance();

    void showCourseSurvey();

    void showCourseSurveySubjects(String id);

    void showDayWiseTable();

    void showDirectApplyFragment();

    void showDoGraduateSurvey(String sessionId, String surveyId);

    void showExamRegFragment(String id);

    void showExamRegisterFragment(String id, String category);

    void showExamResultFragment(String id);

    void showKmeaHostelFragment(int position);

    void showMissionDialog();

    void showRevaluationFee(ArrayList<String> id, ArrayList<String> id2, boolean flag);

    void showRevaluationReceipt(String id);

    void showTeacherSurveyList(String id);

    void showTransportHistory();

    void showUpdateRegisterFragment(String id, String category);

    void showVisionDialog();

    void spotRegistrationClicked(String name, String mobileNumber, String number, String port, String zone, String type, String ton, String place, String distance);

    void transportBtnClicked();

    void transportBusPassBtnClicked();

    void transportReceiptBtnClicked();

    void transportRegBtnClicked();

    void viewRevaluationClicked(String id);
}