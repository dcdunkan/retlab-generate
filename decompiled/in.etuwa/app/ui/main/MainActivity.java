package in.etuwa.app.ui.main;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.google.firebase.messaging.FirebaseMessaging;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.main.ApplyHostelResponse;
import in.etuwa.app.data.model.main.FeeStatusResponse;
import in.etuwa.app.data.model.main.PushResponse;
import in.etuwa.app.data.model.survey.SurveyAnswer;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ActivityMainBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.academicfee.AcademicFeeFragment;
import in.etuwa.app.ui.activitypoint.ActivityPointFragment;
import in.etuwa.app.ui.activitypoint.manage.ManageActivityFragment;
import in.etuwa.app.ui.assignment.AssignmentFragment;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.attendance.bysubject.AttendanceFragment;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewFragment;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.ui.calendar.CalendarFragment;
import in.etuwa.app.ui.centralizedinfo.CentralizedInfoFragment;
import in.etuwa.app.ui.certificate_request.CertificateRequestFragment;
import in.etuwa.app.ui.changepassword.ChangePasswordDialog;
import in.etuwa.app.ui.chat.comment.CommentDialog;
import in.etuwa.app.ui.circular.CircularFragment;
import in.etuwa.app.ui.counselling.CounsellingFragment;
import in.etuwa.app.ui.counselling.view.ViewCounsellingFragment;
import in.etuwa.app.ui.covidcertificate.CovidCertificateDialog;
import in.etuwa.app.ui.covidcertificate.CovidCertificateListMainFragment;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment;
import in.etuwa.app.ui.dashboard.missiondialog.MissionDialog;
import in.etuwa.app.ui.dashboard.visiondialog.VisionDialog;
import in.etuwa.app.ui.due.DueFragment;
import in.etuwa.app.ui.due.DueMainFragment;
import in.etuwa.app.ui.due.duepay.DuePayFragment;
import in.etuwa.app.ui.exam.module.ModuleTestFragment;
import in.etuwa.app.ui.exam.series.SeriesExamFragment;
import in.etuwa.app.ui.examregistration.exammain.ExamMainFragment;
import in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptFragment;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment;
import in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment;
import in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment;
import in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment;
import in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptFragment;
import in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateFragment;
import in.etuwa.app.ui.examschedules.ExamFragment;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.feepartial.kmea.FeeListFragment;
import in.etuwa.app.ui.fees.FeeMainFragment;
import in.etuwa.app.ui.fees.gateway.GatewayFragment;
import in.etuwa.app.ui.fees.payment.FeeFragment;
import in.etuwa.app.ui.fees.receipt.ReceiptFragment;
import in.etuwa.app.ui.fees.transport.TransportFeeFragment;
import in.etuwa.app.ui.fees.transport.receipt.TransportReceiptFragment;
import in.etuwa.app.ui.fees.webview.WebViewFragment;
import in.etuwa.app.ui.fees.webview.fields.FieldsFragment;
import in.etuwa.app.ui.grievance.GrievanceFragment;
import in.etuwa.app.ui.grievance.view.ViewGrievanceFragment;
import in.etuwa.app.ui.homework.HomeWorkFragment;
import in.etuwa.app.ui.hostel.HostelFragment;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceFragment;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentFragment;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment;
import in.etuwa.app.ui.hostel.fee.HostelFeeFragment;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment;
import in.etuwa.app.ui.hostel.mess.MessFragment;
import in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment;
import in.etuwa.app.ui.hostel.mits.MitsHostelView;
import in.etuwa.app.ui.hostel.tkmhostel.HostelMainFragment;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragment;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payweb.PayWebFragment;
import in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelFragment;
import in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptFragment;
import in.etuwa.app.ui.hostelnew.HostelNewFragment;
import in.etuwa.app.ui.internship.InternshipFragment;
import in.etuwa.app.ui.lab.LabFragment;
import in.etuwa.app.ui.lab.equipment.LabListFragment;
import in.etuwa.app.ui.lab.equipment.labequipments.EquipmentFragment;
import in.etuwa.app.ui.lab.equipment.labsafety.SafetyFragment;
import in.etuwa.app.ui.lab.labdue.LabDueFragment;
import in.etuwa.app.ui.lab.practical.LabPracticalFragment;
import in.etuwa.app.ui.lab.practical.evaluation.EvaluationFragment;
import in.etuwa.app.ui.lab.practical.experiment.ExperimentFragment;
import in.etuwa.app.ui.leave.LeaveFragment;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment;
import in.etuwa.app.ui.library.LibraryFragmeent;
import in.etuwa.app.ui.library.book.BookFragment;
import in.etuwa.app.ui.live.LiveTvFragment;
import in.etuwa.app.ui.message.inbox.MessageFragment;
import in.etuwa.app.ui.message.sentItems.SentItemsFragment;
import in.etuwa.app.ui.newquiz.NewQuizFragment;
import in.etuwa.app.ui.newquiz.questions.QuizQuestionsFragment;
import in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment;
import in.etuwa.app.ui.notice.NoticeFragment;
import in.etuwa.app.ui.onlineclass.OnlineClassFragment;
import in.etuwa.app.ui.placement.PlacementFragment;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.ui.profile.updateprofile.UpdateProfileWebView;
import in.etuwa.app.ui.programoutcome.ProgramOutcomeFragment;
import in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment;
import in.etuwa.app.ui.questionbank.QuestionBankFragment;
import in.etuwa.app.ui.remark.RemarkFragment;
import in.etuwa.app.ui.result.ResultFragment;
import in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegFragment;
import in.etuwa.app.ui.semregistration.edit.SemRegFragment;
import in.etuwa.app.ui.semregistration.list.SemRegisterListFragment;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment;
import in.etuwa.app.ui.semregistration.view.SemRegViewFragment;
import in.etuwa.app.ui.stationary.StationaryMainFragment;
import in.etuwa.app.ui.store.StoreDialog;
import in.etuwa.app.ui.store.storeview.StoreFragment;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.app.ui.studymaterials.MaterialFragment;
import in.etuwa.app.ui.subject.SubjectFragment;
import in.etuwa.app.ui.subject.co.CoFragment;
import in.etuwa.app.ui.subject.coverage.SubjectCoverageFragment;
import in.etuwa.app.ui.subject.syllabus.SyllabusFragment;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment;
import in.etuwa.app.ui.survey.SurveyFragment;
import in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyFragment;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsFragment;
import in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsFragment;
import in.etuwa.app.ui.survey.graduateexit.GraduateExitSurveyFragment;
import in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsFragment;
import in.etuwa.app.ui.survey.posurvey.POSurveyFragment;
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewFragment;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment;
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionFragment;
import in.etuwa.app.ui.teacher.TeacherFragment;
import in.etuwa.app.ui.timetable.TimeTableFragment;
import in.etuwa.app.ui.timetable.change.ChangeInTimetableFragment;
import in.etuwa.app.ui.timetable.special.SpecialClassFragment;
import in.etuwa.app.ui.transport.buspass.BusPassFragment;
import in.etuwa.app.ui.transport.history.TransportHistoryFragment;
import in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment;
import in.etuwa.app.ui.transport.registration.view.TransportRegHistoryFragment;
import in.etuwa.app.ui.tutorial.TutorialFragment;
import in.etuwa.app.ui.university.UniversityResultFragment;
import in.etuwa.app.ui.videoclass.VideoClassFragment;
import in.etuwa.app.utils.ActivityMediator;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordFragment;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 Ì\u00012\u00020\u00012\u00020\u0002:\u0002Ì\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J8\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001bH\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\b\u00100\u001a\u00020\u0019H\u0014J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\u0012\u00106\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u00107\u001a\u00020\u0019H\u0002J\u0010\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u0019H\u0016J\b\u0010<\u001a\u00020\u0019H\u0002J\b\u0010=\u001a\u00020\u0019H\u0002J\u0018\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001bH\u0016J\b\u0010A\u001a\u00020\u0019H\u0016J\u0010\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u001bH\u0016J\b\u0010D\u001a\u00020\u0019H\u0002J\u0010\u0010E\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0002J\b\u0010F\u001a\u00020\u0019H\u0002J\b\u0010G\u001a\u00020\u0019H\u0016J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020:H\u0016J\u0010\u0010J\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001eH\u0016J\b\u0010K\u001a\u00020\u0019H\u0016J\u0010\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u001bH\u0016J\u0010\u0010N\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u001bH\u0016J\u0012\u0010O\u001a\u00020\u00192\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\u0010\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010V\u001a\u00020\u0019H\u0014J\b\u0010W\u001a\u00020\u0019H\u0016J\u0010\u0010X\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\u001a\u0010Y\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010Z\u001a\u00020\u001eH\u0016J\b\u0010[\u001a\u00020\u0019H\u0016J\b\u0010\\\u001a\u00020\u0019H\u0016J\b\u0010]\u001a\u00020\u0019H\u0016J\b\u0010^\u001a\u00020\u0019H\u0016J\b\u0010_\u001a\u00020\u0019H\u0016J\u0010\u0010`\u001a\u00020\u00192\u0006\u0010a\u001a\u00020TH\u0016J\b\u0010b\u001a\u00020\u0019H\u0016J\u001a\u0010c\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020T2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u001a\u0010g\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\b\u0010h\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010i\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J$\u0010j\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\b\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010k\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010l\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010m\u001a\u00020\u0019H\u0016J\u0010\u0010n\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010o\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010p\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010q\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010r\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001eH\u0016J\b\u0010s\u001a\u00020\u0019H\u0016J\b\u0010t\u001a\u00020\u0019H\u0016J\u0010\u0010u\u001a\u00020\u001e2\u0006\u0010v\u001a\u00020wH\u0016J\b\u0010x\u001a\u00020\u0019H\u0016J\b\u0010y\u001a\u00020\u0019H\u0016J\b\u0010z\u001a\u00020\u0019H\u0016J/\u0010{\u001a\u00020\u00192\u0006\u0010|\u001a\u00020T2\u000e\u0010}\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016¢\u0006\u0003\u0010\u0081\u0001J\u001b\u0010\u0082\u0001\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001bH\u0016J\u001b\u0010\u0083\u0001\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001bH\u0016J\u001b\u0010\u0084\u0001\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001bH\u0016J\u0011\u0010\u0085\u0001\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\t\u0010\u0086\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0089\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010\u008a\u0001\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u001bH\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010\u008c\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u008e\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0019H\u0016J\u0013\u0010\u0090\u0001\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0091\u0001\u001a\u00020\u0019H\u0016J%\u0010\u0092\u0001\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u0093\u0001\u001a\u00020\u001e2\u0007\u0010\u0094\u0001\u001a\u00020\u001eH\u0016J\u0011\u0010\u0095\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u0096\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010\u0097\u0001\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u001bH\u0016J\u0019\u0010\u0098\u0001\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J#\u0010\u0098\u0001\u001a\u00020\u00192\b\u0010M\u001a\u0004\u0018\u00010\u001b2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u001bH\u0016J\u0011\u0010\u009a\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0011\u0010\u009b\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010\u009d\u0001\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\u0011\u0010\u009e\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0011\u0010\u009f\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010 \u0001\u001a\u00020\u0019H\u0016J\t\u0010¡\u0001\u001a\u00020\u0019H\u0002J\u0019\u0010¢\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0019\u0010£\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001eH\u0016J\t\u0010¤\u0001\u001a\u00020\u0019H\u0014J\t\u0010¥\u0001\u001a\u00020\u0019H\u0016J\t\u0010¦\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010§\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010¨\u0001\u001a\u00020\u0019H\u0016J\t\u0010©\u0001\u001a\u00020\u0019H\u0016J\u0019\u0010ª\u0001\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u001bH\u0016J\u0011\u0010«\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010¬\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0007\u0010\u00ad\u0001\u001a\u00020\u001bH\u0016J\u0011\u0010®\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0011\u0010¯\u0001\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0016J\t\u0010°\u0001\u001a\u00020\u0019H\u0016J\t\u0010±\u0001\u001a\u00020\u0019H\u0014JF\u0010²\u0001\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001b0³\u0001j\t\u0012\u0004\u0012\u00020\u001b`´\u00012\u0019\u0010µ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001b0³\u0001j\t\u0012\u0004\u0012\u00020\u001b`´\u00012\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0011\u0010¶\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010·\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010¸\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010¹\u0001\u001a\u00020\u0019H\u0016J\u001a\u0010º\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0007\u0010\u00ad\u0001\u001a\u00020\u001bH\u0016J\t\u0010»\u0001\u001a\u00020\u0019H\u0016JZ\u0010¼\u0001\u001a\u00020\u00192\u0007\u0010½\u0001\u001a\u00020\u001b2\u0007\u0010¾\u0001\u001a\u00020\u001b2\u0007\u0010¿\u0001\u001a\u00020\u001b2\u0007\u0010À\u0001\u001a\u00020\u001b2\u0007\u0010Á\u0001\u001a\u00020\u001b2\u0007\u0010Â\u0001\u001a\u00020\u001b2\u0007\u0010Ã\u0001\u001a\u00020\u001b2\u0007\u0010Ä\u0001\u001a\u00020\u001b2\u0007\u0010Å\u0001\u001a\u00020\u001bH\u0016J\t\u0010Æ\u0001\u001a\u00020\u0019H\u0002J\t\u0010Ç\u0001\u001a\u00020\u0019H\u0016J\t\u0010È\u0001\u001a\u00020\u0019H\u0016J\t\u0010É\u0001\u001a\u00020\u0019H\u0016J\t\u0010Ê\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010Ë\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016¨\u0006Í\u0001"}, d2 = {"Lin/etuwa/app/ui/main/MainActivity;", "Lin/etuwa/app/ui/base/BaseActivity;", "Lin/etuwa/app/helper/MainCallBackListener;", "()V", "binding", "Lin/etuwa/app/databinding/ActivityMainBinding;", "dataBase", "Lin/etuwa/app/data/db/MyDataBase;", "getDataBase", "()Lin/etuwa/app/data/db/MyDataBase;", "dataBase$delegate", "Lkotlin/Lazy;", "mainViewModel", "Lin/etuwa/app/ui/main/MainViewModel;", "getMainViewModel", "()Lin/etuwa/app/ui/main/MainViewModel;", "mainViewModel$delegate", "manager", "Landroidx/fragment/app/FragmentManager;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "answerCourseSurvey", "", "id", "", "sessionId", "checkNetworkAvailability", "", "dismissView", "doGeneralSurvey", "doLogout", "doPOSurvey", "doTeacherSurvey", "teacherId", "subjectId", SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "subject", "editProfileBtnClicked", "examManagementMainClick", "flag", "examUniversityResult", "forceOpenPoSurvey", "forceOpenProfile", "gatewayDetailsClicked", "hideProgress", "hostelFeeWeb", "url", "listenApplyResponse", "listenFeeResponse", "listenPushResponse", "loadAcademicPay", "loadApplyHostelView", "loadBottomItems", "fragment", "Landroidx/fragment/app/Fragment;", "loadChangeTimetable", "loadCommentDialog", "loadDashboard", "loadHostelPay", "month", "year", "loadSpecialTimetable", "loadStoreView", StoreFragmentKt.SUB_ID, "loadVaccineDialog", "loadView", "logoutView", "makeLogout", "navigateToFragment", "newFragment", "onAttendanceCardClicked", "onBackPressed", "onCourseSurveyCompleted", "surveyId", "onCourseSurveyCompletedFully", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDashboardItemClick", CommonCssConstants.POSITION, "", "onDashboardParent", "onDestroy", "onDismissProfile", "onExamDashboardItemClick", "onFinishSemRegistration", "edit", "onGradiateSurveyOpen", "onGraduateExitSurveyCompleted", "onHostelAttViewClicked", "onHostelMainAttViewClicked", "onHostelMessClicked", "onHostelNextClicked", FeeConfirmDialogKt.ARG_TOTAL, "onInfoClicked", "onKeyDown", "keyCode", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onLabEquipmentItemClick", "labId", "onLabMainItemClick", "onLabPracticalItemClick", "subPid", "onLibraryMainClicked", "onLiveClicked", "onMainChangeLogoutClick", "onMainDueClick", "onMainFeeClick", "onMainHostelClick", "onMainStoreClick", "onMarqueeClicked", "onMessOrderHistoryClicked", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPOSurveyCompleted", "onPalaiHostelPayClick", "onQuizCompleted", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSurveyCompleted", "onSurveyFullyCompleted", "onTeacherSurveyCompleted", "onTkmDashboardItemClick", "onTkmHostelPayClick", "onTkmHostelReceipt", "onTkmHostelRegistration", "openAsietSemReg", "openCoPage", "openCourseSurvey", "openCourseSurvey2", "openForceSemReg", "openForceToDoSurvey", "openManageActivity", "openPaymentPage", "openPoSurvey", "openSemRegisterPage", "isEdit", "feeStatus", "openSemRegisterViewPage", "openSpotRegistration", "openSubCovePage", "openSurvey", "openSyllabusPage", "openViewCounselling", "openViewGrievance", "profileLogoutClicked", "programOutcomeCells", "quizAttemptBtnClicked", "quizViewResult", "removeFragment", "requestPermission", "revaluationClicked", "revaluationUpdateClicked", "setUp", "showByDayAttendance", "showCourseSurvey", "showCourseSurveySubjects", "showDayWiseTable", "showDirectApplyFragment", "showDoGraduateSurvey", "showExamRegFragment", "showExamRegisterFragment", "category", "showExamResultFragment", "showKmeaHostelFragment", "showMissionDialog", "showProgress", "showRevaluationFee", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "id2", "showRevaluationReceipt", "showStoreDialog", "showTeacherSurveyList", "showTransportHistory", "showUpdateRegisterFragment", "showVisionDialog", "spotRegistrationClicked", "name", "mobileNumber", "number", ClientCookie.PORT_ATTR, "zone", "type", "ton", "place", "distance", "storePushToken", "transportBtnClicked", "transportBusPassBtnClicked", "transportReceiptBtnClicked", "transportRegBtnClicked", "viewRevaluationClicked", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainActivity extends BaseActivity implements MainCallBackListener {
    private static boolean flag;
    private ActivityMainBinding binding;

    /* renamed from: dataBase$delegate, reason: from kotlin metadata */
    private final Lazy dataBase;

    /* renamed from: mainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mainViewModel;
    private FragmentManager manager;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean surveyFlag = true;
    private static final ArrayList<SurveyAnswer> answerList = new ArrayList<>();

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.EXCEPTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logoutView$lambda$11(DialogInterface dialogInterface, int i) {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMainStoreClick(boolean flag2) {
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onTkmHostelRegistration() {
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openCourseSurvey2(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSurvey(String surveyId, String teacherId, String subjectId) {
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSurvey(boolean flag2, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    public MainActivity() {
        final MainActivity mainActivity = this;
        final MainActivity mainActivity2 = mainActivity;
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(mainActivity);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.mainViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.main.MainActivity$special$$inlined$viewModel$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.main.MainActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory(ViewModelStoreOwner.this, Reflection.getOrCreateKotlinClass(MainViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MainActivity mainActivity3 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.main.MainActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = mainActivity3;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.dataBase = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<MyDataBase>() { // from class: in.etuwa.app.ui.main.MainActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.db.MyDataBase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MyDataBase invoke() {
                ComponentCallbacks componentCallbacks = mainActivity3;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MyDataBase.class), b4, b5);
            }
        });
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    private final MyDataBase getDataBase() {
        return (MyDataBase) this.dataBase.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, R.layout.activity_main)");
        ActivityMainBinding activityMainBinding = (ActivityMainBinding) contentView;
        this.binding = activityMainBinding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.setMainViewModel(getMainViewModel());
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding3;
        }
        activityMainBinding2.setLifecycleOwner(this);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root), new OnApplyWindowInsetsListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda6
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat up$lambda$0;
                up$lambda$0 = MainActivity.setUp$lambda$0(view, windowInsetsCompat);
                return up$lambda$0;
            }
        });
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getPreference().setNewLogin(true);
        FirebaseCrashlytics.getInstance().log("base_url = " + getPreference().getBaseUrl() + "user type = " + getPreference().getUserType() + " \n user = " + getPreference().getUserName() + " \n pwd = " + getPreference().getPassword());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.manager = supportFragmentManager;
        if (checkNetworkAvailability() && !getPreference().getPushTokenServerStatus()) {
            storePushToken();
        }
        new ValidChecker(this).checkPermission();
        loadDashboard();
        ActivityMainBinding activityMainBinding = this.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.bottomNavNew.setOnItemSelected(new Function1<Integer, Unit>() { // from class: in.etuwa.app.ui.main.MainActivity$setUp$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i == 0) {
                    MainActivity.this.loadBottomItems(DashboardFragment.INSTANCE.newInstance(0));
                    return;
                }
                if (i == 1) {
                    MainActivity.this.loadBottomItems(CalendarFragment.INSTANCE.newInstance());
                    return;
                }
                if (i == 2) {
                    MainActivity.this.loadBottomItems(MessageFragment.Companion.newInstance());
                } else if (i != 3) {
                    MainActivity.this.loadBottomItems(DashboardFragment.INSTANCE.newInstance(0));
                } else {
                    MainActivity.this.loadBottomItems(ProfileFragment.INSTANCE.newInstance());
                }
            }
        });
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding3;
        }
        activityMainBinding2.bottomNavNew.setOnItemReselected(new Function1<Integer, Unit>() { // from class: in.etuwa.app.ui.main.MainActivity$setUp$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i == 0) {
                    MainActivity.this.loadBottomItems(DashboardFragment.INSTANCE.newInstance(0));
                    return;
                }
                if (i == 1) {
                    MainActivity.this.loadBottomItems(CalendarFragment.INSTANCE.newInstance());
                } else if (i == 2) {
                    MainActivity.this.loadBottomItems(MessageFragment.Companion.newInstance());
                } else {
                    if (i != 3) {
                        return;
                    }
                    MainActivity.this.loadBottomItems(ProfileFragment.INSTANCE.newInstance());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setUp$lambda$0(View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadBottomItems(Fragment fragment) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        FragmentManager fragmentManager3 = this.manager;
        if (fragmentManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager3 = null;
        }
        FragmentTransaction beginTransaction = fragmentManager3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        beginTransaction.add(R.id.main_container, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void loadDashboard() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        beginTransaction.add(R.id.main_container, DashboardFragment.INSTANCE.newInstance(0));
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.action_sent_item) {
            loadView(SentItemsFragment.INSTANCE.newInstance());
            return true;
        }
        if (itemId == R.id.action_filter) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.spin_layout);
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.series_layout);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.assignment_result_layout);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.internal_layout);
            LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.module_layout);
            LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.tutorial_result_layout);
            LinearLayout linearLayout7 = (LinearLayout) findViewById(R.id.video_layout);
            LinearLayout linearLayout8 = (LinearLayout) findViewById(R.id.question_layout);
            LinearLayout linearLayout9 = (LinearLayout) findViewById(R.id.subject_layout);
            TextView textView = (TextView) findViewById(R.id.tvassignment);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(0);
            }
            if (textView == null) {
                return true;
            }
            textView.setVisibility(8);
            return true;
        }
        super.onOptionsItemSelected(item);
        return true;
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onDashboardItemClick(int position) {
        ActivityMainBinding activityMainBinding = null;
        switch (position) {
            case 0:
                loadView(AttendanceFragment.INSTANCE.newInstance(false));
                break;
            case 1:
                loadView(AssignmentFragment.INSTANCE.newInstance());
                break;
            case 2:
                loadView(SeriesExamFragment.INSTANCE.newInstance());
                break;
            case 3:
                loadView(ResultFragment.INSTANCE.newInstance());
                break;
            case 4:
                loadView(MaterialFragment.INSTANCE.newInstance());
                break;
            case 5:
                loadView(ModuleTestFragment.INSTANCE.newInstance());
                break;
            case 6:
                loadView(ExamFragment.INSTANCE.newInstance());
                break;
            case 7:
                loadView(SubjectFragment.INSTANCE.newInstance());
                break;
            case 8:
                loadView(LeaveFragment.INSTANCE.newInstance());
                break;
            case 9:
                ActivityMainBinding activityMainBinding2 = this.binding;
                if (activityMainBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMainBinding = activityMainBinding2;
                }
                FrameLayout frameLayout = activityMainBinding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                ToastExtKt.showInfoToast(frameLayout, "Under Maintenance");
                break;
            case 10:
                loadView(ActivityPointFragment.INSTANCE.newInstance());
                break;
            case 11:
                loadView(CertificateRequestFragment.INSTANCE.newInstance());
                break;
            case 12:
                loadView(CircularFragment.INSTANCE.newInstance());
                break;
            case 13:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cev", false, 2, (Object) null)) {
                    loadView(CounsellingFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding3 = this.binding;
                    if (activityMainBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding3;
                    }
                    FrameLayout frameLayout2 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout2, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 14:
                if (StringsKt.contains$default((CharSequence) getPreference().getDueNew(), (CharSequence) "1", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
                    System.out.println((Object) getPreference().getDueNew());
                    loadView(DueMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(DueFragment.INSTANCE.newInstance());
                    break;
                }
                break;
            case 15:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "rgrege", false, 2, (Object) null)) {
                    loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcp", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeaarts", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmit", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "christ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "ukfcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "nssce", false, 2, (Object) null)) {
                    loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    break;
                } else if (getPreference().getFeeStatus()) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding4 = this.binding;
                    if (activityMainBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding4;
                    }
                    FrameLayout frameLayout3 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout3, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 16:
                loadView(GrievanceFragment.INSTANCE.newInstance());
                break;
            case 17:
                loadView(HomeWorkFragment.INSTANCE.newInstance());
                break;
            case 18:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                    loadView(InternshipFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding5 = this.binding;
                    if (activityMainBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding5;
                    }
                    FrameLayout frameLayout4 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout4, "You Do Not Have This Feature");
                    break;
                }
            case 19:
                loadView(LabFragment.INSTANCE.newInstance());
                break;
            case 20:
                loadView(NoticeFragment.INSTANCE.newInstance());
                break;
            case 21:
                ActivityMediator.INSTANCE.startPushActivity(this);
                break;
            case 22:
                loadView(OnlineClassFragment.INSTANCE.newInstance());
                break;
            case 23:
                loadView(PlacementFragment.INSTANCE.newInstance());
                break;
            case 24:
                loadView(ProgramOutcomeMainFragment.INSTANCE.newInstance());
                break;
            case 25:
                loadView(QuestionBankFragment.INSTANCE.newInstance());
                break;
            case 26:
                loadView(NewQuizFragment.INSTANCE.newInstance());
                break;
            case 27:
                loadView(RemarkFragment.INSTANCE.newInstance());
                break;
            case 28:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    loadView(PalaiSemesterRegFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(SemRegisterListFragment.INSTANCE.newInstance());
                    break;
                }
            case 29:
                loadView(SubjectRegistrationFragment.INSTANCE.newInstance());
                break;
            case 30:
                loadView(SurveyFragment.INSTANCE.newInstance(0));
                break;
            case 31:
                loadView(TeacherFragment.INSTANCE.newInstance());
                break;
            case 32:
                loadView(TimeTableFragment.INSTANCE.newInstance());
                break;
            case 33:
                loadView(TutorialFragment.INSTANCE.newInstance());
                break;
            case 34:
                loadView(CovidCertificateListMainFragment.INSTANCE.newInstance());
                break;
            case 35:
                loadView(new VideoClassFragment());
                break;
            case 36:
                loadView(new LibraryFragmeent());
                break;
            case 37:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
                    loadView(HostelMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "ukfcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tmc", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
                    loadView(HostelMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                    if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                        if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE") || Intrinsics.areEqual(getPreference().getHostelStatus(), "APPLIED")) {
                            loadView(HostelMainFragment.INSTANCE.newInstance());
                            break;
                        } else {
                            String hostelStatus = getPreference().getHostelStatus();
                            if (Intrinsics.areEqual(hostelStatus, "INACTIVE")) {
                                ActivityMainBinding activityMainBinding6 = this.binding;
                                if (activityMainBinding6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding6;
                                }
                                FrameLayout frameLayout5 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.mainContainer");
                                ToastExtKt.showWarningToast(frameLayout5, "Hostel Status Is INACTIVE...!");
                                break;
                            } else if (Intrinsics.areEqual(hostelStatus, "REJECTED")) {
                                ActivityMainBinding activityMainBinding7 = this.binding;
                                if (activityMainBinding7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding7;
                                }
                                FrameLayout frameLayout6 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout6, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        }
                    } else {
                        loadApplyHostelView();
                        break;
                    }
                } else if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                    if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE")) {
                        loadView(HostelMainFragment.INSTANCE.newInstance());
                        break;
                    } else {
                        String hostelStatus2 = getPreference().getHostelStatus();
                        int hashCode = hostelStatus2.hashCode();
                        if (hashCode == -75252643) {
                            if (hostelStatus2.equals("APPLIED")) {
                                ActivityMainBinding activityMainBinding8 = this.binding;
                                if (activityMainBinding8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding8;
                                }
                                FrameLayout frameLayout7 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout7, "Hostel Is Not Yet Activated...!");
                                break;
                            }
                        } else if (hashCode == 174130302) {
                            if (hostelStatus2.equals("REJECTED")) {
                                ActivityMainBinding activityMainBinding9 = this.binding;
                                if (activityMainBinding9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding9;
                                }
                                FrameLayout frameLayout8 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout8, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout8, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        } else if (hashCode == 807292011 && hostelStatus2.equals("INACTIVE")) {
                            ActivityMainBinding activityMainBinding10 = this.binding;
                            if (activityMainBinding10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                activityMainBinding = activityMainBinding10;
                            }
                            FrameLayout frameLayout9 = activityMainBinding.mainContainer;
                            Intrinsics.checkNotNullExpressionValue(frameLayout9, "binding.mainContainer");
                            ToastExtKt.showWarningToast(frameLayout9, "Hostel Status Is INACTIVE...!");
                            break;
                        }
                    }
                } else {
                    loadApplyHostelView();
                    break;
                }
                break;
            case 38:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo.", false, 2, (Object) null)) {
                    loadView(StationaryMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding11 = this.binding;
                    if (activityMainBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding11;
                    }
                    FrameLayout frameLayout10 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout10, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout10, "You Don't Have This Feature");
                    break;
                }
                break;
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onExamDashboardItemClick(int position) {
        ActivityMainBinding activityMainBinding = null;
        switch (position) {
            case 0:
                loadView(AttendanceFragment.INSTANCE.newInstance(false));
                break;
            case 1:
                loadView(AssignmentFragment.INSTANCE.newInstance());
                break;
            case 2:
                loadView(SeriesExamFragment.INSTANCE.newInstance());
                break;
            case 3:
                loadView(ResultFragment.INSTANCE.newInstance());
                break;
            case 4:
                loadView(ExamMainFragment.INSTANCE.newInstance());
                break;
            case 5:
                loadView(MaterialFragment.INSTANCE.newInstance());
                break;
            case 6:
                loadView(ModuleTestFragment.INSTANCE.newInstance());
                break;
            case 7:
                loadView(ExamFragment.INSTANCE.newInstance());
                break;
            case 8:
                loadView(SubjectFragment.INSTANCE.newInstance());
                break;
            case 9:
                loadView(LeaveFragment.INSTANCE.newInstance());
                break;
            case 10:
                ActivityMainBinding activityMainBinding2 = this.binding;
                if (activityMainBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMainBinding = activityMainBinding2;
                }
                FrameLayout frameLayout = activityMainBinding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                ToastExtKt.showInfoToast(frameLayout, "Under Maintenance");
                break;
            case 11:
                loadView(ActivityPointFragment.INSTANCE.newInstance());
                break;
            case 12:
                loadView(CertificateRequestFragment.INSTANCE.newInstance());
                break;
            case 13:
                loadView(CircularFragment.INSTANCE.newInstance());
                break;
            case 14:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cev", false, 2, (Object) null)) {
                    loadView(CounsellingFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding3 = this.binding;
                    if (activityMainBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding3;
                    }
                    FrameLayout frameLayout2 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout2, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 15:
                if (StringsKt.contains$default((CharSequence) getPreference().getDueNew(), (CharSequence) "1", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
                    System.out.println((Object) getPreference().getDueNew());
                    loadView(DueMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(DueFragment.INSTANCE.newInstance());
                    break;
                }
                break;
            case 16:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null)) {
                    loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcp", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeaarts", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmit", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmealotta", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "nssce", false, 2, (Object) null)) {
                    loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    break;
                } else if (getPreference().getFeeStatus()) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding4 = this.binding;
                    if (activityMainBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding4;
                    }
                    FrameLayout frameLayout3 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout3, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 17:
                loadView(GrievanceFragment.INSTANCE.newInstance());
                break;
            case 18:
                loadView(HomeWorkFragment.INSTANCE.newInstance());
                break;
            case 19:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                    loadView(InternshipFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding5 = this.binding;
                    if (activityMainBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding5;
                    }
                    FrameLayout frameLayout4 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout4, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 20:
                loadView(LabFragment.INSTANCE.newInstance());
                break;
            case 21:
                loadView(NoticeFragment.INSTANCE.newInstance());
                break;
            case 22:
                ActivityMediator.INSTANCE.startPushActivity(this);
                break;
            case 23:
                loadView(OnlineClassFragment.INSTANCE.newInstance());
                break;
            case 24:
                loadView(PlacementFragment.INSTANCE.newInstance());
                break;
            case 25:
                loadView(ProgramOutcomeMainFragment.INSTANCE.newInstance());
                break;
            case 26:
                loadView(QuestionBankFragment.INSTANCE.newInstance());
                break;
            case 27:
                loadView(NewQuizFragment.INSTANCE.newInstance());
                break;
            case 28:
                loadView(RemarkFragment.INSTANCE.newInstance());
                break;
            case 29:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    loadView(PalaiSemesterRegFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(SemRegisterListFragment.INSTANCE.newInstance());
                    break;
                }
            case 30:
                loadView(SurveyFragment.INSTANCE.newInstance(0));
                break;
            case 31:
                loadView(TeacherFragment.INSTANCE.newInstance());
                break;
            case 32:
                loadView(TimeTableFragment.INSTANCE.newInstance());
                break;
            case 33:
                loadView(TutorialFragment.INSTANCE.newInstance());
                break;
            case 34:
                loadView(CovidCertificateListMainFragment.INSTANCE.newInstance());
                break;
            case 35:
                loadView(new VideoClassFragment());
                break;
            case 36:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) MitsHostelView.class));
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tmc", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
                    loadView(HostelMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                    if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                        if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE") || Intrinsics.areEqual(getPreference().getHostelStatus(), "APPLIED")) {
                            loadView(HostelMainFragment.INSTANCE.newInstance());
                            break;
                        } else {
                            String hostelStatus = getPreference().getHostelStatus();
                            if (Intrinsics.areEqual(hostelStatus, "INACTIVE")) {
                                ActivityMainBinding activityMainBinding6 = this.binding;
                                if (activityMainBinding6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding6;
                                }
                                FrameLayout frameLayout5 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.mainContainer");
                                ToastExtKt.showWarningToast(frameLayout5, "Hostel Status Is INACTIVE...!");
                                break;
                            } else if (Intrinsics.areEqual(hostelStatus, "REJECTED")) {
                                ActivityMainBinding activityMainBinding7 = this.binding;
                                if (activityMainBinding7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding7;
                                }
                                FrameLayout frameLayout6 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout6, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        }
                    } else {
                        loadApplyHostelView();
                        break;
                    }
                } else if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                    if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE")) {
                        loadView(HostelMainFragment.INSTANCE.newInstance());
                        break;
                    } else {
                        String hostelStatus2 = getPreference().getHostelStatus();
                        int hashCode = hostelStatus2.hashCode();
                        if (hashCode == -75252643) {
                            if (hostelStatus2.equals("APPLIED")) {
                                ActivityMainBinding activityMainBinding8 = this.binding;
                                if (activityMainBinding8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding8;
                                }
                                FrameLayout frameLayout7 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout7, "Hostel Is Not Yet Activated...!");
                                break;
                            }
                        } else if (hashCode == 174130302) {
                            if (hostelStatus2.equals("REJECTED")) {
                                ActivityMainBinding activityMainBinding9 = this.binding;
                                if (activityMainBinding9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding9;
                                }
                                FrameLayout frameLayout8 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout8, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout8, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        } else if (hashCode == 807292011 && hostelStatus2.equals("INACTIVE")) {
                            ActivityMainBinding activityMainBinding10 = this.binding;
                            if (activityMainBinding10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                activityMainBinding = activityMainBinding10;
                            }
                            FrameLayout frameLayout9 = activityMainBinding.mainContainer;
                            Intrinsics.checkNotNullExpressionValue(frameLayout9, "binding.mainContainer");
                            ToastExtKt.showWarningToast(frameLayout9, "Hostel Status Is INACTIVE...!");
                            break;
                        }
                    }
                } else {
                    loadApplyHostelView();
                    break;
                }
                break;
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onTkmDashboardItemClick(int position) {
        ActivityMainBinding activityMainBinding = null;
        switch (position) {
            case 0:
                loadView(AttendanceFragment.INSTANCE.newInstance(false));
                break;
            case 1:
                loadView(AssignmentFragment.INSTANCE.newInstance());
                break;
            case 2:
                loadView(SeriesExamFragment.INSTANCE.newInstance());
                break;
            case 3:
                loadView(ResultFragment.INSTANCE.newInstance());
                break;
            case 4:
                loadView(ExamMainFragment.INSTANCE.newInstance());
                break;
            case 5:
                loadView(MaterialFragment.INSTANCE.newInstance());
                break;
            case 6:
                loadView(ModuleTestFragment.INSTANCE.newInstance());
                break;
            case 7:
                loadView(ExamFragment.INSTANCE.newInstance());
                break;
            case 8:
                loadView(SubjectFragment.INSTANCE.newInstance());
                break;
            case 9:
                loadView(LeaveFragment.INSTANCE.newInstance());
                break;
            case 10:
                ActivityMediator.INSTANCE.startAnalysisActivity(this);
                break;
            case 11:
                loadView(ActivityPointFragment.INSTANCE.newInstance());
                break;
            case 12:
                loadView(CertificateRequestFragment.INSTANCE.newInstance());
                break;
            case 13:
                loadView(CircularFragment.INSTANCE.newInstance());
                break;
            case 14:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cev", false, 2, (Object) null)) {
                    loadView(CounsellingFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding2 = this.binding;
                    if (activityMainBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding2;
                    }
                    FrameLayout frameLayout = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 15:
                if (StringsKt.contains$default((CharSequence) getPreference().getDueNew(), (CharSequence) "1", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null)) {
                    System.out.println((Object) getPreference().getDueNew());
                    loadView(DueMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(DueFragment.INSTANCE.newInstance());
                    break;
                }
                break;
            case 16:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null)) {
                    getMainViewModel().getFeeStatus();
                    listenFeeResponse();
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcp", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeaarts", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmealotta", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "nssce", false, 2, (Object) null)) {
                    loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    break;
                } else if (getPreference().getFeeStatus()) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding3 = this.binding;
                    if (activityMainBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding3;
                    }
                    FrameLayout frameLayout2 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout2, "You Do Not Have This Feature");
                    break;
                }
                break;
            case 17:
                loadView(GrievanceFragment.INSTANCE.newInstance());
                break;
            case 18:
                loadView(HomeWorkFragment.INSTANCE.newInstance());
                break;
            case 19:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                    loadView(InternshipFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding4 = this.binding;
                    if (activityMainBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding4;
                    }
                    FrameLayout frameLayout3 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout3, "You Do Not Have This Feature");
                    break;
                }
            case 20:
                loadView(LabFragment.INSTANCE.newInstance());
                break;
            case 21:
                loadView(NoticeFragment.INSTANCE.newInstance());
                break;
            case 22:
                ActivityMediator.INSTANCE.startPushActivity(this);
                break;
            case 23:
                loadView(OnlineClassFragment.INSTANCE.newInstance());
                break;
            case 24:
                loadView(PlacementFragment.INSTANCE.newInstance());
                break;
            case 25:
                loadView(ProgramOutcomeMainFragment.INSTANCE.newInstance());
                break;
            case 26:
                loadView(QuestionBankFragment.INSTANCE.newInstance());
                break;
            case 27:
                loadView(NewQuizFragment.INSTANCE.newInstance());
                break;
            case 28:
                loadView(RemarkFragment.INSTANCE.newInstance());
                break;
            case 29:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    loadView(PalaiSemesterRegFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(SemRegisterListFragment.INSTANCE.newInstance());
                    break;
                }
                break;
            case 30:
                loadView(SurveyFragment.INSTANCE.newInstance(0));
                break;
            case 31:
                loadView(TeacherFragment.INSTANCE.newInstance());
                break;
            case 32:
                loadView(TimeTableFragment.INSTANCE.newInstance());
                break;
            case 33:
                loadView(TutorialFragment.INSTANCE.newInstance());
                break;
            case 34:
                loadView(CovidCertificateListMainFragment.INSTANCE.newInstance());
                break;
            case 35:
                loadView(new VideoClassFragment());
                break;
            case 36:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
                    loadView(HostelMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                    if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                        if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE") || Intrinsics.areEqual(getPreference().getHostelStatus(), "APPLIED")) {
                            loadView(HostelMainFragment.INSTANCE.newInstance());
                            break;
                        } else {
                            String hostelStatus = getPreference().getHostelStatus();
                            if (Intrinsics.areEqual(hostelStatus, "INACTIVE")) {
                                ActivityMainBinding activityMainBinding5 = this.binding;
                                if (activityMainBinding5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding5;
                                }
                                FrameLayout frameLayout4 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.mainContainer");
                                ToastExtKt.showWarningToast(frameLayout4, "Hostel Status Is INACTIVE...!");
                                break;
                            } else if (Intrinsics.areEqual(hostelStatus, "REJECTED")) {
                                ActivityMainBinding activityMainBinding6 = this.binding;
                                if (activityMainBinding6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding6;
                                }
                                FrameLayout frameLayout5 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout5, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        }
                    } else {
                        loadApplyHostelView();
                        break;
                    }
                } else if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                    if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE")) {
                        loadView(HostelMainFragment.INSTANCE.newInstance());
                        break;
                    } else {
                        String hostelStatus2 = getPreference().getHostelStatus();
                        int hashCode = hostelStatus2.hashCode();
                        if (hashCode == -75252643) {
                            if (hostelStatus2.equals("APPLIED")) {
                                ActivityMainBinding activityMainBinding7 = this.binding;
                                if (activityMainBinding7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding7;
                                }
                                FrameLayout frameLayout6 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout6, "Hostel Is Not Yet Activated...!");
                                break;
                            }
                        } else if (hashCode == 174130302) {
                            if (hostelStatus2.equals("REJECTED")) {
                                ActivityMainBinding activityMainBinding8 = this.binding;
                                if (activityMainBinding8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding8;
                                }
                                FrameLayout frameLayout7 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout7, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        } else if (hashCode == 807292011 && hostelStatus2.equals("INACTIVE")) {
                            ActivityMainBinding activityMainBinding9 = this.binding;
                            if (activityMainBinding9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                activityMainBinding = activityMainBinding9;
                            }
                            FrameLayout frameLayout8 = activityMainBinding.mainContainer;
                            Intrinsics.checkNotNullExpressionValue(frameLayout8, "binding.mainContainer");
                            ToastExtKt.showWarningToast(frameLayout8, "Hostel Status Is INACTIVE...!");
                            break;
                        }
                    }
                } else {
                    loadApplyHostelView();
                    break;
                }
                break;
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onDashboardParent(int position) {
        ActivityMainBinding activityMainBinding = null;
        switch (position) {
            case 0:
                loadView(AttendanceFragment.INSTANCE.newInstance(false));
                break;
            case 1:
                loadView(AssignmentFragment.INSTANCE.newInstance());
                break;
            case 2:
                loadView(SeriesExamFragment.INSTANCE.newInstance());
                break;
            case 3:
                loadView(ResultFragment.INSTANCE.newInstance());
                break;
            case 4:
                loadView(MaterialFragment.INSTANCE.newInstance());
                break;
            case 5:
                loadView(ModuleTestFragment.INSTANCE.newInstance());
                break;
            case 6:
                loadView(ExamFragment.INSTANCE.newInstance());
                break;
            case 7:
                loadView(SubjectFragment.INSTANCE.newInstance());
                break;
            case 8:
                loadView(LeaveFragment.INSTANCE.newInstance());
                break;
            case 9:
                ActivityMediator.INSTANCE.startAnalysisActivity(this);
                break;
            case 10:
                loadView(ActivityPointFragment.INSTANCE.newInstance());
                break;
            case 11:
                loadView(CertificateRequestFragment.INSTANCE.newInstance());
                break;
            case 12:
                loadView(CircularFragment.INSTANCE.newInstance());
                break;
            case 13:
                if (StringsKt.contains$default((CharSequence) getPreference().getDueNew(), (CharSequence) "1", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null)) {
                    System.out.println((Object) getPreference().getDueNew());
                    loadView(DueMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    loadView(DueFragment.INSTANCE.newInstance());
                    break;
                }
            case 14:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null)) {
                    getMainViewModel().getFeeStatus();
                    listenFeeResponse();
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcp", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeaarts", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet.", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmealotta", false, 2, (Object) null)) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "nssce", false, 2, (Object) null)) {
                    loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    break;
                } else if (getPreference().getFeeStatus()) {
                    loadView(FeeMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding2 = this.binding;
                    if (activityMainBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding2;
                    }
                    FrameLayout frameLayout = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout, "You Do Not Have This Feature");
                    break;
                }
            case 15:
                loadView(HomeWorkFragment.INSTANCE.newInstance());
                break;
            case 16:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                    loadView(InternshipFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding3 = this.binding;
                    if (activityMainBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding3;
                    }
                    FrameLayout frameLayout2 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout2, "You Do Not Have This Feature");
                    break;
                }
            case 17:
                loadView(LabFragment.INSTANCE.newInstance());
                break;
            case 18:
                loadView(NoticeFragment.INSTANCE.newInstance());
                break;
            case 19:
                ActivityMediator.INSTANCE.startPushActivity(this);
                break;
            case 20:
                loadView(OnlineClassFragment.INSTANCE.newInstance());
                break;
            case 21:
                loadView(PlacementFragment.INSTANCE.newInstance());
                break;
            case 22:
                loadView(ProgramOutcomeMainFragment.INSTANCE.newInstance());
                break;
            case 23:
                loadView(QuestionBankFragment.INSTANCE.newInstance());
                break;
            case 24:
                loadView(NewQuizFragment.INSTANCE.newInstance());
                break;
            case 25:
                loadView(RemarkFragment.INSTANCE.newInstance());
                break;
            case 26:
                loadView(SurveyFragment.INSTANCE.newInstance(0));
                break;
            case 27:
                loadView(TeacherFragment.INSTANCE.newInstance());
                break;
            case 28:
                loadView(TimeTableFragment.INSTANCE.newInstance());
                break;
            case 29:
                loadView(TutorialFragment.INSTANCE.newInstance());
                break;
            case 30:
                loadView(CovidCertificateListMainFragment.INSTANCE.newInstance());
                break;
            case 31:
                loadView(new VideoClassFragment());
                break;
            case 32:
                loadView(new LibraryFragmeent());
                break;
            case 33:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tmc", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                    loadView(HostelMainFragment.INSTANCE.newInstance());
                    break;
                } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                    if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                        if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE") || Intrinsics.areEqual(getPreference().getHostelStatus(), "APPLIED")) {
                            loadView(HostelMainFragment.INSTANCE.newInstance());
                            break;
                        } else {
                            String hostelStatus = getPreference().getHostelStatus();
                            if (Intrinsics.areEqual(hostelStatus, "INACTIVE")) {
                                ActivityMainBinding activityMainBinding4 = this.binding;
                                if (activityMainBinding4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding4;
                                }
                                FrameLayout frameLayout3 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.mainContainer");
                                ToastExtKt.showWarningToast(frameLayout3, "Hostel Status Is INACTIVE...!");
                                break;
                            } else if (Intrinsics.areEqual(hostelStatus, "REJECTED")) {
                                ActivityMainBinding activityMainBinding5 = this.binding;
                                if (activityMainBinding5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding5;
                                }
                                FrameLayout frameLayout4 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout4, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        }
                    } else {
                        loadApplyHostelView();
                        break;
                    }
                } else if (getPreference().getHostel() == 1 || getPreference().getHostel() == 2) {
                    if (Intrinsics.areEqual(getPreference().getHostelStatus(), "ACTIVE")) {
                        loadView(HostelFragment.INSTANCE.newInstance());
                        break;
                    } else {
                        String hostelStatus2 = getPreference().getHostelStatus();
                        int hashCode = hostelStatus2.hashCode();
                        if (hashCode == -75252643) {
                            if (hostelStatus2.equals("APPLIED")) {
                                ActivityMainBinding activityMainBinding6 = this.binding;
                                if (activityMainBinding6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding6;
                                }
                                FrameLayout frameLayout5 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout5, "Hostel Is Not Yet Activated...!");
                                break;
                            }
                        } else if (hashCode == 174130302) {
                            if (hostelStatus2.equals("REJECTED")) {
                                ActivityMainBinding activityMainBinding7 = this.binding;
                                if (activityMainBinding7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityMainBinding = activityMainBinding7;
                                }
                                FrameLayout frameLayout6 = activityMainBinding.mainContainer;
                                Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.mainContainer");
                                ToastExtKt.showErrorToast(frameLayout6, "Hostel Status Is REJECTED...!");
                                break;
                            }
                        } else if (hashCode == 807292011 && hostelStatus2.equals("INACTIVE")) {
                            ActivityMainBinding activityMainBinding8 = this.binding;
                            if (activityMainBinding8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                activityMainBinding = activityMainBinding8;
                            }
                            FrameLayout frameLayout7 = activityMainBinding.mainContainer;
                            Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.mainContainer");
                            ToastExtKt.showWarningToast(frameLayout7, "Hostel Status Is INACTIVE...!");
                            break;
                        }
                    }
                } else {
                    loadApplyHostelView();
                    break;
                }
                break;
            case 34:
                if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    loadView(StationaryMainFragment.INSTANCE.newInstance());
                    break;
                } else {
                    ActivityMainBinding activityMainBinding9 = this.binding;
                    if (activityMainBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding = activityMainBinding9;
                    }
                    FrameLayout frameLayout8 = activityMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout8, "binding.mainContainer");
                    ToastExtKt.showInfoToast(frameLayout8, "You Don't Have This Feature");
                    break;
                }
        }
    }

    private final void showStoreDialog() {
        ActivityMainBinding activityMainBinding = null;
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "aisat", false, 2, (Object) null)) {
            StoreDialog newInstance = StoreDialog.INSTANCE.newInstance();
            FragmentManager fragmentManager = this.manager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager = null;
            }
            newInstance.show(fragmentManager, (String) null);
            return;
        }
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding2;
        }
        FrameLayout frameLayout = activityMainBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
        ToastExtKt.showInfoToast(frameLayout, "You Do Not Have This Feature");
    }

    private final void loadCommentDialog() {
        CommentDialog newInstance = CommentDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        newInstance.show(fragmentManager, (String) null);
    }

    private final void loadVaccineDialog() {
        CovidCertificateDialog newInstance = CovidCertificateDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        newInstance.show(fragmentManager, (String) null);
    }

    private final void listenFeeResponse() {
        getMainViewModel().getFeeResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.listenFeeResponse$lambda$3(MainActivity.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenFeeResponse$lambda$3(MainActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        ActivityMainBinding activityMainBinding = null;
        if (i == 1) {
            this$0.hideProgress();
            FeeStatusResponse feeStatusResponse = (FeeStatusResponse) resource.getData();
            if (feeStatusResponse != null) {
                if (feeStatusResponse.getStatus()) {
                    this$0.loadView(AcademicFeeFragment.INSTANCE.newInstance(null));
                    return;
                }
                ActivityMainBinding activityMainBinding2 = this$0.binding;
                if (activityMainBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMainBinding = activityMainBinding2;
                }
                FrameLayout frameLayout = activityMainBinding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                ToastExtKt.showErrorToast(frameLayout, "student cannot pay fees after last date of fee payment");
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        ActivityMainBinding activityMainBinding3 = this$0.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding3;
        }
        FrameLayout frameLayout2 = activityMainBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(frameLayout2, message);
    }

    private final void loadApplyHostelView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Apply For Hostel?");
        builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.loadApplyHostelView$lambda$4(MainActivity.this, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadApplyHostelView$lambda$4(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainViewModel().applyHostel();
        this$0.listenApplyResponse();
    }

    private final void listenApplyResponse() {
        getMainViewModel().getHostelResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.listenApplyResponse$lambda$6(MainActivity.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenApplyResponse$lambda$6(MainActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        ActivityMainBinding activityMainBinding = null;
        if (i == 1) {
            this$0.hideProgress();
            ApplyHostelResponse applyHostelResponse = (ApplyHostelResponse) resource.getData();
            if (applyHostelResponse != null) {
                if (applyHostelResponse.getLogin() && applyHostelResponse.getSuccess()) {
                    this$0.getMainViewModel().saveHostelStatus(applyHostelResponse.getHostel(), applyHostelResponse.getHostelStatus());
                    return;
                }
                ActivityMainBinding activityMainBinding2 = this$0.binding;
                if (activityMainBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMainBinding = activityMainBinding2;
                }
                FrameLayout frameLayout = activityMainBinding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                ToastExtKt.showErrorToast(frameLayout, applyHostelResponse.getError());
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        ActivityMainBinding activityMainBinding3 = this$0.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding3;
        }
        FrameLayout frameLayout2 = activityMainBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(frameLayout2, message);
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void loadChangeTimetable() {
        loadView(ChangeInTimetableFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void loadSpecialTimetable() {
        loadView(SpecialClassFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSyllabusPage(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        loadView(SyllabusFragment.INSTANCE.newInstance(subId));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openCoPage(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        loadView(CoFragment.INSTANCE.newInstance(subId));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSubCovePage(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        loadView(SubjectCoverageFragment.INSTANCE.newInstance(subId));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onLabMainItemClick(int position) {
        if (position == 0) {
            loadView(LabPracticalFragment.INSTANCE.newInstance());
        } else if (position == 1) {
            loadView(LabListFragment.INSTANCE.newInstance());
        } else {
            if (position != 2) {
                return;
            }
            loadView(LabDueFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onLabEquipmentItemClick(int position, String labId) {
        if (position == 0) {
            loadView(EquipmentFragment.INSTANCE.newInstance(labId));
        } else {
            if (position != 1) {
                return;
            }
            loadView(SafetyFragment.INSTANCE.newInstance(labId));
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onLabPracticalItemClick(int position, String subId, String subPid) {
        if (position == 0) {
            loadView(EvaluationFragment.INSTANCE.newInstance(subId));
        } else {
            if (position != 1) {
                return;
            }
            loadView(ExperimentFragment.INSTANCE.newInstance(subId, subPid));
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onSurveyCompleted(boolean flag2, String surveyId) {
        SurveyFragment newInstance;
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 2;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        if (flag2) {
            newInstance = TeacherSurveyFragment.INSTANCE.newInstance(surveyId);
        } else {
            newInstance = SurveyFragment.INSTANCE.newInstance(0);
        }
        loadView(newInstance);
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onSurveyFullyCompleted(boolean flag2, String surveyId) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        fragmentManager.popBackStack((String) null, 1);
        loadView(DashboardFragment.INSTANCE.newInstance(0));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onTeacherSurveyCompleted(boolean flag2, String surveyId) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        if (flag2) {
            loadView(TeacherSurveyFragment.INSTANCE.newInstance(surveyId));
        } else {
            loadView(SurveyFragment.INSTANCE.newInstance(0));
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onGradiateSurveyOpen() {
        loadView(GraduateExitSurveyFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showDoGraduateSurvey(String sessionId, String surveyId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        loadView(GraduateSurveyQuestionsFragment.INSTANCE.newInstance(surveyId, sessionId));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onGraduateExitSurveyCompleted() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(GraduateExitSurveyFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onCourseSurveyCompleted(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 2;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        if (Intrinsics.areEqual(surveyId, "")) {
            loadView(CourseEvaluationSurveyFragment.INSTANCE.newInstance(0));
        } else {
            loadView(CourseSurveySubjectsFragment.INSTANCE.newInstance(surveyId));
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onCourseSurveyCompletedFully(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        fragmentManager.popBackStack((String) null, 1);
        loadView(DashboardFragment.INSTANCE.newInstance(0));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onQuizCompleted() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(NewQuizFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showCourseSurvey() {
        loadView(CourseEvaluationSurveyFragment.INSTANCE.newInstance(0));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showCourseSurveySubjects(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(CourseSurveySubjectsFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void answerCourseSurvey(String id, String sessionId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        loadView(CourseSurveyQuestionsFragment.INSTANCE.newInstance(id, sessionId));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onPOSurveyCompleted() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(POSurveyFragment.INSTANCE.newInstance(1));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void forceOpenProfile() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(ProfileFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void quizAttemptBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(QuizQuestionsFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void quizViewResult(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(QuizResultFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void doGeneralSurvey(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(TeacherSurveyQuestionFragment.INSTANCE.newInstance(id, "", "", "", "", "", false));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showTeacherSurveyList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(TeacherSurveyFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void doTeacherSurvey(String id, String teacherId, String subjectId, String image, String semester, String subject) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(subject, "subject");
        loadView(TeacherSurveyQuestionFragment.INSTANCE.newInstance(id, teacherId, subjectId, image, semester, subject, true));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void editProfileBtnClicked() {
        startActivity(new Intent(getApplicationContext(), (Class<?>) UpdateProfileWebView.class));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openForceToDoSurvey() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(SurveyFragment.INSTANCE.newInstance(1));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onDismissProfile() {
        loadDashboard();
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showByDayAttendance() {
        loadView(AttendanceCalendarViewFragment.INSTANCE.newInstance(true));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void loadAcademicPay(String id) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(AcademicFeeFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void loadHostelPay(String month, String year) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        Bundle bundle = new Bundle();
        bundle.putString("month", month);
        bundle.putString("year", year);
        new HostelFeeFragment().setArguments(bundle);
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSemRegisterPage(String id, boolean isEdit, boolean feeStatus) {
        loadView(SemRegFragment.INSTANCE.newInstance(id, isEdit, feeStatus));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openForceSemReg() {
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            loadView(PalaiSemesterRegFragment.INSTANCE.newInstance());
        } else {
            loadView(SemRegisterListFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openAsietSemReg() {
        loadView(AsietSemRegFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSemRegisterViewPage(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(SemRegViewFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onFinishSemRegistration(String id, boolean edit) {
        FragmentManager fragmentManager = this.manager;
        FragmentManager fragmentManager2 = null;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        fragmentManager.popBackStack();
        FragmentManager fragmentManager3 = this.manager;
        if (fragmentManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
        } else {
            fragmentManager2 = fragmentManager3;
        }
        fragmentManager2.popBackStack();
        if (edit) {
            loadView(SemRegViewFragment.INSTANCE.newInstance(id));
        } else {
            loadView(SemRegisterListFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onInfoClicked() {
        loadView(CentralizedInfoFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMarqueeClicked() {
        loadView(NoticeFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onLiveClicked() {
        loadView(LiveTvFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMainFeeClick(boolean flag2) {
        if (flag2) {
            System.out.println(getPreference().getFeeEngnrNew());
            if (getPreference().getFeeEngnrNew() || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmit", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "christ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "ukfcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null)) {
                loadView(FeeEngineerFragment.INSTANCE.newInstance());
                return;
            }
            if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeaarts", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
                loadView(FeeArtsFragment.INSTANCE.newInstance());
                return;
            } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tmc", false, 2, (Object) null)) {
                loadView(FeeListFragment.INSTANCE.newInstance());
                return;
            } else {
                loadView(FeeFragment.INSTANCE.newInstance());
                return;
            }
        }
        loadView(ReceiptFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMainChangeLogoutClick(boolean flag2) {
        if (!flag2) {
            logoutView();
            return;
        }
        ChangePasswordDialog newInstance = ChangePasswordDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        newInstance.show(fragmentManager, (String) null);
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMainHostelClick(boolean flag2) {
        if (flag2) {
            loadView(RegistrationFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onTkmHostelPayClick() {
        loadView(HostelNewFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onPalaiHostelPayClick() {
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tmc", false, 2, (Object) null)) {
            loadView(HostelNewFragment.INSTANCE.newInstance());
        } else {
            loadView(HostelNewFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onHostelMessClicked() {
        loadView(MessFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onHostelNextClicked(int total) {
        loadView(HostelFeeConfirmFragment.INSTANCE.newInstance(total, 2));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMessOrderHistoryClicked() {
        loadView(OrderHistoryFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void hostelFeeWeb(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        loadView(PayWebFragment.INSTANCE.newInstance(url));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onTkmHostelReceipt() {
        loadView(TkmReceiptFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onHostelMainAttViewClicked() {
        if (StringsKt.contains$default((CharSequence) getPreference().getUserType(), (CharSequence) ExifInterface.GPS_MEASUREMENT_2D, false, 2, (Object) null)) {
            loadView(HostelAttendanceParentFragment.INSTANCE.newInstance());
        } else {
            loadView(HostelAttendanceFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void loadStoreView(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        loadView(StoreFragment.INSTANCE.newInstance(subId));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showVisionDialog() {
        VisionDialog newInstance = VisionDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        newInstance.show(fragmentManager, (String) null);
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showMissionDialog() {
        MissionDialog newInstance = MissionDialog.INSTANCE.newInstance();
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        newInstance.show(fragmentManager, (String) null);
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onAttendanceCardClicked(boolean flag2) {
        loadView(AttendanceFragment.INSTANCE.newInstance(flag2));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void programOutcomeCells(int position) {
        loadView(ProgramOutcomeFragment.INSTANCE.newInstance(position));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showKmeaHostelFragment(int position) {
        loadView(KmeaHostelFragment.INSTANCE.newInstance(position));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void examManagementMainClick(String flag2) {
        Intrinsics.checkNotNullParameter(flag2, "flag");
        if (Intrinsics.areEqual(flag2, "true")) {
            loadView(ExamSubjectFragment.INSTANCE.newInstance("true"));
        } else if (Intrinsics.areEqual(flag2, "false")) {
            loadView(ExamReceiptFragment.INSTANCE.newInstance());
        } else {
            loadView(ExamSubjectFragment.INSTANCE.newInstance("revaluation"));
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showExamRegFragment(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 2;
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        loadView(ExamViewFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showExamRegisterFragment(String id, String category) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(category, "category");
        loadView(ExamRegisterFragment.INSTANCE.newInstance(id, category, false, false));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showUpdateRegisterFragment(String id, String category) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(category, "category");
        loadView(UpdateRegisterFragment.INSTANCE.newInstance(id, category));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void examUniversityResult() {
        loadView(ExamSubjectFragment.INSTANCE.newInstance("false"));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void revaluationClicked(String id, boolean flag2) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(RevaluationFragment.INSTANCE.newInstance(id, flag2));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void viewRevaluationClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(RevaluationViewFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showExamResultFragment(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(UniversityResultFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showRevaluationFee(ArrayList<String> id, ArrayList<String> id2, boolean flag2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(id2, "id2");
        loadView(RevaluationFeeFragment.INSTANCE.newInstance(id, id2, flag2));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showRevaluationReceipt(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(RevaluationReceiptFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void revaluationUpdateClicked(String id, boolean flag2) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(RevaluationUpdateFragment.INSTANCE.newInstance(id, flag2));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onLibraryMainClicked(int position) {
        if (position == 0) {
            loadView(BookFragment.INSTANCE.newInstance());
        } else {
            if (position != 1) {
                return;
            }
            loadView(BookRecordFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showDirectApplyFragment() {
        loadView(DirectApplyFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onHostelAttViewClicked() {
        loadView(HostelViewLeaveFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openCourseSurvey() {
        loadView(CourseEvaluationSurveyFragment.INSTANCE.newInstance(1));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void forceOpenPoSurvey() {
        loadView(POSurveyFragment.INSTANCE.newInstance(1));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openSpotRegistration() {
        loadView(FieldsFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void spotRegistrationClicked(String name, String mobileNumber, String number, String port, String zone, String type, String ton, String place, String distance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(zone, "zone");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(ton, "ton");
        Intrinsics.checkNotNullParameter(place, "place");
        Intrinsics.checkNotNullParameter(distance, "distance");
        loadView(WebViewFragment.INSTANCE.newInstance(name, mobileNumber, number, port, zone, type, ton, place, distance));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openPoSurvey() {
        loadView(POSurveyFragment.INSTANCE.newInstance(0));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showDayWiseTable() {
        loadView(DayWiseTimeTableFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void dismissView() {
        finish();
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void doPOSurvey(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(PoSurveyQuestionsNewFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openPaymentPage(String url) {
        ActivityMainBinding activityMainBinding = null;
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
            build.launchUrl(this, Uri.parse(url));
            FragmentManager fragmentManager = this.manager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager = null;
            }
            fragmentManager.popBackStack();
        } catch (NullPointerException unused) {
            ActivityMainBinding activityMainBinding2 = this.binding;
            if (activityMainBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMainBinding = activityMainBinding2;
            }
            FrameLayout frameLayout = activityMainBinding.mainContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
            ToastExtKt.showErrorToast(frameLayout, "Error Occured, Please try again Later!");
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void onMainDueClick(boolean flag2) {
        if (flag2) {
            loadView(DuePayFragment.INSTANCE.newInstance());
        } else {
            loadView(DueFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void transportBtnClicked() {
        loadView(TransportFeeFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void transportRegBtnClicked() {
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            loadView(AsietTransRegFragment.INSTANCE.newInstance());
        } else {
            loadView(TransportRegHistoryFragment.INSTANCE.newInstance());
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void transportReceiptBtnClicked() {
        loadView(TransportReceiptFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void transportBusPassBtnClicked() {
        loadView(BusPassFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void gatewayDetailsClicked() {
        loadView(GatewayFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void showTransportHistory() {
        loadView(TransportHistoryFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openManageActivity() {
        loadView(ManageActivityFragment.INSTANCE.newInstance());
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openViewGrievance(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(ViewGrievanceFragment.INSTANCE.newInstance(id));
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void openViewCounselling(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        loadView(ViewCounsellingFragment.INSTANCE.newInstance(id));
    }

    private final void storePushToken() {
        if (getPreference().getPushTokenStatus()) {
            getMainViewModel().sendPushToken(getPreference().getPushToken());
        } else {
            try {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        MainActivity.storePushToken$lambda$7(task);
                    }
                });
            } catch (Exception unused) {
            }
        }
        listenPushResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void storePushToken$lambda$7(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful() || task.getResult() == null || TextUtils.isEmpty((CharSequence) task.getResult())) {
            return;
        }
        Object result = task.getResult();
        Intrinsics.checkNotNull(result);
    }

    private final void listenPushResponse() {
        getMainViewModel().getPushTokenResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.listenPushResponse$lambda$9(MainActivity.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPushResponse$lambda$9(MainActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        ActivityMainBinding activityMainBinding = null;
        if (i == 1) {
            this$0.hideProgress();
            PushResponse pushResponse = (PushResponse) resource.getData();
            if (pushResponse != null) {
                if (pushResponse.getLogin()) {
                    this$0.getMainViewModel().storePushResponse(pushResponse.getSuccess());
                    return;
                }
                ActivityMainBinding activityMainBinding2 = this$0.binding;
                if (activityMainBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMainBinding = activityMainBinding2;
                }
                FrameLayout frameLayout = activityMainBinding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                ToastExtKt.showErrorToast(frameLayout, pushResponse.getError());
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        ActivityMainBinding activityMainBinding3 = this$0.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding3;
        }
        FrameLayout frameLayout2 = activityMainBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(frameLayout2, message);
    }

    private final void logoutView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.logout_msg));
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.logoutView$lambda$10(MainActivity.this, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.logoutView$lambda$11(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logoutView$lambda$10(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doLogout();
    }

    private final void doLogout() {
        getMainViewModel().logout(getPreference().getPushToken());
        getMainViewModel().getLogoutResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.doLogout$lambda$13(MainActivity.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doLogout$lambda$13(MainActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        ActivityMainBinding activityMainBinding = null;
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            ActivityMainBinding activityMainBinding2 = this$0.binding;
            if (activityMainBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMainBinding = activityMainBinding2;
            }
            FrameLayout frameLayout = activityMainBinding.mainContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(frameLayout, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getLogin() && successResponse.getSuccess()) {
                this$0.getPreference().clearData();
                this$0.getDataBase().clearData();
                ActivityMediator.INSTANCE.startLoginActivity(this$0);
                this$0.finish();
                return;
            }
            ActivityMainBinding activityMainBinding3 = this$0.binding;
            if (activityMainBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMainBinding = activityMainBinding3;
            }
            FrameLayout frameLayout2 = activityMainBinding.mainContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.mainContainer");
            ToastExtKt.showErrorToast(frameLayout2, AppConstant.SERVER_ERROR_MSG);
        }
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void profileLogoutClicked() {
        logoutView();
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void makeLogout() {
        getPreference().clearData();
        getDataBase().clearData();
        ActivityMediator.INSTANCE.startLoginActivity(this);
        finish();
    }

    private final void loadView(Fragment fragment) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        fragmentManager.beginTransaction().replace(R.id.main_container, fragment).addToBackStack(null).commit();
    }

    private final boolean checkNetworkAvailability() {
        MainActivity mainActivity = this;
        if (new ValidChecker(mainActivity).isNetworkAvailable()) {
            return true;
        }
        new ValidChecker(mainActivity).vibrate(this, 500L);
        return false;
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(this).setTitle(getString(R.string.storage_permission_needed)).setMessage(getString(R.string.storage_msg)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.requestPermission$lambda$14(MainActivity.this, dialogInterface, i);
                    }
                }).create().show();
            } else if (Build.VERSION.SDK_INT >= 33) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$14(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 33) {
            ActivityCompat.requestPermissions(this$0, new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
        } else {
            ActivityCompat.requestPermissions(this$0, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean shouldShowRequestPermissionRationale;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            try {
                if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale(permissions[0]);
                    if (!shouldShowRequestPermissionRationale) {
                        new AlertDialog.Builder(this).setTitle(getString(R.string.storage_permission_needed)).setMessage(getString(R.string.storage_msg)).setPositiveButton("Settings", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.main.MainActivity$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.onRequestPermissionsResult$lambda$15(MainActivity.this, dialogInterface, i);
                            }
                        }).create().show();
                        return;
                    }
                }
                ActivityMainBinding activityMainBinding = this.binding;
                if (activityMainBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMainBinding = null;
                }
                FrameLayout frameLayout = activityMainBinding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
                ToastExtKt.showInfoToast(frameLayout, "Permission Denied, You cannot Download Files .");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestPermissionsResult$lambda$15(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + this$0.getPackageName()));
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        this$0.startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 1) {
            finish();
        }
        super.onBackPressed();
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void navigateToFragment(Fragment newFragment) {
        Intrinsics.checkNotNullParameter(newFragment, "newFragment");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.main_container, newFragment);
        beginTransaction.commit();
    }

    @Override // in.etuwa.app.helper.MainCallBackListener
    public void removeFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.main_container);
        if (findFragmentById != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
            beginTransaction.remove(findFragmentById);
            beginTransaction.commit();
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0011J&\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u000b\u001a\u00020\u0011R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/main/MainActivity$Companion;", "", "()V", "answerList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/SurveyAnswer;", "Lkotlin/collections/ArrayList;", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "surveyFlag", "getSurveyFlag", "setSurveyFlag", "clearIdLists", "", "deleteAnswer", "pos", "", "getAns", "getPosAns", "resetFlag", "saveAnswers", "qid", "", "option", "type", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getFlag() {
            return MainActivity.flag;
        }

        public final void setFlag(boolean z) {
            MainActivity.flag = z;
        }

        public final boolean getSurveyFlag() {
            return MainActivity.surveyFlag;
        }

        public final void setSurveyFlag(boolean z) {
            MainActivity.surveyFlag = z;
        }

        public final void setFlag() {
            setFlag(true);
        }

        public final void resetFlag() {
            setFlag(false);
        }

        public final void clearIdLists() {
            MainActivity.answerList.clear();
        }

        public final void saveAnswers(String qid, String option, String type, int pos) {
            Intrinsics.checkNotNullParameter(qid, "qid");
            Intrinsics.checkNotNullParameter(option, "option");
            Intrinsics.checkNotNullParameter(type, "type");
            MainActivity.answerList.add(pos, new SurveyAnswer(qid, option, type));
        }

        public final void deleteAnswer(int pos) {
            MainActivity.answerList.remove(pos);
        }

        public final ArrayList<SurveyAnswer> getAns() {
            return MainActivity.answerList;
        }

        public final SurveyAnswer getPosAns(int pos) {
            try {
                return (SurveyAnswer) MainActivity.answerList.get(pos);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 82) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}