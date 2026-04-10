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