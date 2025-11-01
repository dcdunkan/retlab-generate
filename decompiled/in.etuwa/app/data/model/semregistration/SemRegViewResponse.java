package in.etuwa.app.data.model.semregistration;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.Semester;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemRegViewResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bg\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0006\u00101\u001a\u00020\u0005\u0012\u0006\u00102\u001a\u00020\u0005\u0012\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6¢\u0006\u0002\u00107J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0005HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0005HÆ\u0003J\t\u0010w\u001a\u00020\u0005HÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005HÆ\u0003J\u001a\u0010\u0094\u0001\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0005HÆ\u0003Jú\u0003\u0010\u009a\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\u0018\b\u0002\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6HÆ\u0001J\u0015\u0010\u009b\u0001\u001a\u00020\u00032\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u009d\u0001\u001a\u00030\u009e\u0001HÖ\u0001J\n\u0010\u009f\u0001\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010#\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0016\u0010 \u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00109R\u0016\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00109R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00109R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00109R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00109R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00109R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00109R\u0016\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00109R\u0016\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00109R\u0016\u0010*\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0016\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00109R\u0016\u0010/\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00109R\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00109R\u0016\u0010\u001d\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00109R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00109R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u00109R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00109R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00109R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00109R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00109R\u0016\u0010.\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010ER\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u00109R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00109R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u00109R\u0016\u00100\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u00109R\u0016\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u00109R\u0016\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00109R\u0016\u0010)\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010ER\u0016\u00101\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u00109R\u0016\u00102\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u00109R\u0016\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u00109R\u0016\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u00109R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010ER\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\\\u00109R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u00109R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u00109R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u00109R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b`\u00109R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u00109R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u00109R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`68\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0016\u0010,\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010ER\u0016\u0010-\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u00109R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u00109R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u00109R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u0010E¨\u0006 \u0001"}, d2 = {"Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "admissionNo", "", "semAppliedFor", "update_btn", "name", "gender", "phone", "email", "examAppear", "uniRegNo", "examMonthYear", "backPaper", "backPaperCount", "earnedCredits", "feePaid", "bankName", "amountPaid", "paymentDate", "paymentReferenceNo", "paymentMode", "feeReceiptFile", "regSlipFile", "feeConcession", "feeConcessionCategory", "departmentDue", "departmentDueDetails", "libraryDue", "libraryDueDetails", "accountsDue", "accountsDueDetails", "academicDue", "academicDueDetails", "hostelDue", "hostelDueDetails", "busDue", "busDueDetails", NotificationCompat.CATEGORY_STATUS, "isApplied", "canEdit", "canEditMessage", "semRegistrationStatus", "semRegistrationStatusMessage", "feeExemption", "classTeacherRemark", "hodRemarks", "lastAttendedSem", "lastAttendedSemText", "semList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "(ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAcademicDue", "()Ljava/lang/String;", "getAcademicDueDetails", "getAccountsDue", "getAccountsDueDetails", "getAdmissionNo", "getAmountPaid", "getBackPaper", "getBackPaperCount", "getBankName", "getBusDue", "getBusDueDetails", "getCanEdit", "()Z", "getCanEditMessage", "getClassTeacherRemark", "getDepartmentDue", "getDepartmentDueDetails", "getEarnedCredits", "getEmail", "getExamAppear", "getExamMonthYear", "getFeeConcession", "getFeeConcessionCategory", "getFeeExemption", "getFeePaid", "getFeeReceiptFile", "getGender", "getHodRemarks", "getHostelDue", "getHostelDueDetails", "getLastAttendedSem", "getLastAttendedSemText", "getLibraryDue", "getLibraryDueDetails", "getLogin", "getName", "getPaymentDate", "getPaymentMode", "getPaymentReferenceNo", "getPhone", "getRegSlipFile", "getSemAppliedFor", "getSemList", "()Ljava/util/ArrayList;", "getSemRegistrationStatus", "getSemRegistrationStatusMessage", "getStatus", "getUniRegNo", "getUpdate_btn", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SemRegViewResponse {

    @SerializedName("academic_due")
    private final String academicDue;

    @SerializedName("academic_due_details")
    private final String academicDueDetails;

    @SerializedName("accounts_due")
    private final String accountsDue;

    @SerializedName("accounts_due_details")
    private final String accountsDueDetails;

    @SerializedName("admission_no")
    private final String admissionNo;

    @SerializedName("amount_paid")
    private final String amountPaid;

    @SerializedName("backpaper")
    private final String backPaper;

    @SerializedName("backlogs_count")
    private final String backPaperCount;

    @SerializedName("bank_name")
    private final String bankName;

    @SerializedName("bus_due")
    private final String busDue;

    @SerializedName("bus_due_details")
    private final String busDueDetails;

    @SerializedName("can_edit")
    private final boolean canEdit;

    @SerializedName("can_edit_message")
    private final String canEditMessage;

    @SerializedName("classteacher_remarks")
    private final String classTeacherRemark;

    @SerializedName("department_due")
    private final String departmentDue;

    @SerializedName("department_due_details")
    private final String departmentDueDetails;

    @SerializedName("earned_credits")
    private final String earnedCredits;
    private final String email;

    @SerializedName("exam_appear")
    private final String examAppear;

    @SerializedName("exam_month_year")
    private final String examMonthYear;

    @SerializedName("fee_concession")
    private final String feeConcession;

    @SerializedName("fee_concession_category")
    private final String feeConcessionCategory;

    @SerializedName("fee_exemption")
    private final boolean feeExemption;

    @SerializedName("fee_paid")
    private final String feePaid;

    @SerializedName("feereceipt_file")
    private final String feeReceiptFile;
    private final String gender;

    @SerializedName("hod_remarks")
    private final String hodRemarks;

    @SerializedName("hostel_due")
    private final String hostelDue;

    @SerializedName("hostel_due_details")
    private final String hostelDueDetails;

    @SerializedName("is_applied")
    private final boolean isApplied;

    @SerializedName("last_attended_sem")
    private final String lastAttendedSem;

    @SerializedName("last_attended_sem_text")
    private final String lastAttendedSemText;

    @SerializedName("library_due")
    private final String libraryDue;

    @SerializedName("librarary_due_details")
    private final String libraryDueDetails;
    private final boolean login;
    private final String name;

    @SerializedName("payment_date")
    private final String paymentDate;

    @SerializedName("payment_mode")
    private final String paymentMode;

    @SerializedName("payment_reference_no")
    private final String paymentReferenceNo;
    private final String phone;

    @SerializedName("regslip_file")
    private final String regSlipFile;

    @SerializedName("sem_applied_for")
    private final String semAppliedFor;

    @SerializedName("sem_list")
    private final ArrayList<Semester> semList;

    @SerializedName("sem_registration_status")
    private final boolean semRegistrationStatus;

    @SerializedName("sem_registration_status_message")
    private final String semRegistrationStatusMessage;
    private final String status;

    @SerializedName("unireg_no")
    private final String uniRegNo;
    private final boolean update_btn;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUniRegNo() {
        return this.uniRegNo;
    }

    /* renamed from: component11, reason: from getter */
    public final String getExamMonthYear() {
        return this.examMonthYear;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBackPaper() {
        return this.backPaper;
    }

    /* renamed from: component13, reason: from getter */
    public final String getBackPaperCount() {
        return this.backPaperCount;
    }

    /* renamed from: component14, reason: from getter */
    public final String getEarnedCredits() {
        return this.earnedCredits;
    }

    /* renamed from: component15, reason: from getter */
    public final String getFeePaid() {
        return this.feePaid;
    }

    /* renamed from: component16, reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: component17, reason: from getter */
    public final String getAmountPaid() {
        return this.amountPaid;
    }

    /* renamed from: component18, reason: from getter */
    public final String getPaymentDate() {
        return this.paymentDate;
    }

    /* renamed from: component19, reason: from getter */
    public final String getPaymentReferenceNo() {
        return this.paymentReferenceNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdmissionNo() {
        return this.admissionNo;
    }

    /* renamed from: component20, reason: from getter */
    public final String getPaymentMode() {
        return this.paymentMode;
    }

    /* renamed from: component21, reason: from getter */
    public final String getFeeReceiptFile() {
        return this.feeReceiptFile;
    }

    /* renamed from: component22, reason: from getter */
    public final String getRegSlipFile() {
        return this.regSlipFile;
    }

    /* renamed from: component23, reason: from getter */
    public final String getFeeConcession() {
        return this.feeConcession;
    }

    /* renamed from: component24, reason: from getter */
    public final String getFeeConcessionCategory() {
        return this.feeConcessionCategory;
    }

    /* renamed from: component25, reason: from getter */
    public final String getDepartmentDue() {
        return this.departmentDue;
    }

    /* renamed from: component26, reason: from getter */
    public final String getDepartmentDueDetails() {
        return this.departmentDueDetails;
    }

    /* renamed from: component27, reason: from getter */
    public final String getLibraryDue() {
        return this.libraryDue;
    }

    /* renamed from: component28, reason: from getter */
    public final String getLibraryDueDetails() {
        return this.libraryDueDetails;
    }

    /* renamed from: component29, reason: from getter */
    public final String getAccountsDue() {
        return this.accountsDue;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemAppliedFor() {
        return this.semAppliedFor;
    }

    /* renamed from: component30, reason: from getter */
    public final String getAccountsDueDetails() {
        return this.accountsDueDetails;
    }

    /* renamed from: component31, reason: from getter */
    public final String getAcademicDue() {
        return this.academicDue;
    }

    /* renamed from: component32, reason: from getter */
    public final String getAcademicDueDetails() {
        return this.academicDueDetails;
    }

    /* renamed from: component33, reason: from getter */
    public final String getHostelDue() {
        return this.hostelDue;
    }

    /* renamed from: component34, reason: from getter */
    public final String getHostelDueDetails() {
        return this.hostelDueDetails;
    }

    /* renamed from: component35, reason: from getter */
    public final String getBusDue() {
        return this.busDue;
    }

    /* renamed from: component36, reason: from getter */
    public final String getBusDueDetails() {
        return this.busDueDetails;
    }

    /* renamed from: component37, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component38, reason: from getter */
    public final boolean getIsApplied() {
        return this.isApplied;
    }

    /* renamed from: component39, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUpdate_btn() {
        return this.update_btn;
    }

    /* renamed from: component40, reason: from getter */
    public final String getCanEditMessage() {
        return this.canEditMessage;
    }

    /* renamed from: component41, reason: from getter */
    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    /* renamed from: component42, reason: from getter */
    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    /* renamed from: component43, reason: from getter */
    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    /* renamed from: component44, reason: from getter */
    public final String getClassTeacherRemark() {
        return this.classTeacherRemark;
    }

    /* renamed from: component45, reason: from getter */
    public final String getHodRemarks() {
        return this.hodRemarks;
    }

    /* renamed from: component46, reason: from getter */
    public final String getLastAttendedSem() {
        return this.lastAttendedSem;
    }

    /* renamed from: component47, reason: from getter */
    public final String getLastAttendedSemText() {
        return this.lastAttendedSemText;
    }

    public final ArrayList<Semester> component48() {
        return this.semList;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component8, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component9, reason: from getter */
    public final String getExamAppear() {
        return this.examAppear;
    }

    public final SemRegViewResponse copy(boolean login, String admissionNo, String semAppliedFor, boolean update_btn, String name, String gender, String phone, String email, String examAppear, String uniRegNo, String examMonthYear, String backPaper, String backPaperCount, String earnedCredits, String feePaid, String bankName, String amountPaid, String paymentDate, String paymentReferenceNo, String paymentMode, String feeReceiptFile, String regSlipFile, String feeConcession, String feeConcessionCategory, String departmentDue, String departmentDueDetails, String libraryDue, String libraryDueDetails, String accountsDue, String accountsDueDetails, String academicDue, String academicDueDetails, String hostelDue, String hostelDueDetails, String busDue, String busDueDetails, String status, boolean isApplied, boolean canEdit, String canEditMessage, boolean semRegistrationStatus, String semRegistrationStatusMessage, boolean feeExemption, String classTeacherRemark, String hodRemarks, String lastAttendedSem, String lastAttendedSemText, ArrayList<Semester> semList) {
        Intrinsics.checkNotNullParameter(admissionNo, "admissionNo");
        Intrinsics.checkNotNullParameter(semAppliedFor, "semAppliedFor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(examAppear, "examAppear");
        Intrinsics.checkNotNullParameter(uniRegNo, "uniRegNo");
        Intrinsics.checkNotNullParameter(examMonthYear, "examMonthYear");
        Intrinsics.checkNotNullParameter(backPaper, "backPaper");
        Intrinsics.checkNotNullParameter(backPaperCount, "backPaperCount");
        Intrinsics.checkNotNullParameter(earnedCredits, "earnedCredits");
        Intrinsics.checkNotNullParameter(feePaid, "feePaid");
        Intrinsics.checkNotNullParameter(bankName, "bankName");
        Intrinsics.checkNotNullParameter(amountPaid, "amountPaid");
        Intrinsics.checkNotNullParameter(paymentDate, "paymentDate");
        Intrinsics.checkNotNullParameter(paymentReferenceNo, "paymentReferenceNo");
        Intrinsics.checkNotNullParameter(paymentMode, "paymentMode");
        Intrinsics.checkNotNullParameter(feeReceiptFile, "feeReceiptFile");
        Intrinsics.checkNotNullParameter(regSlipFile, "regSlipFile");
        Intrinsics.checkNotNullParameter(feeConcession, "feeConcession");
        Intrinsics.checkNotNullParameter(feeConcessionCategory, "feeConcessionCategory");
        Intrinsics.checkNotNullParameter(departmentDue, "departmentDue");
        Intrinsics.checkNotNullParameter(departmentDueDetails, "departmentDueDetails");
        Intrinsics.checkNotNullParameter(libraryDue, "libraryDue");
        Intrinsics.checkNotNullParameter(libraryDueDetails, "libraryDueDetails");
        Intrinsics.checkNotNullParameter(accountsDue, "accountsDue");
        Intrinsics.checkNotNullParameter(accountsDueDetails, "accountsDueDetails");
        Intrinsics.checkNotNullParameter(academicDue, "academicDue");
        Intrinsics.checkNotNullParameter(academicDueDetails, "academicDueDetails");
        Intrinsics.checkNotNullParameter(hostelDue, "hostelDue");
        Intrinsics.checkNotNullParameter(hostelDueDetails, "hostelDueDetails");
        Intrinsics.checkNotNullParameter(busDue, "busDue");
        Intrinsics.checkNotNullParameter(busDueDetails, "busDueDetails");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(canEditMessage, "canEditMessage");
        Intrinsics.checkNotNullParameter(semRegistrationStatusMessage, "semRegistrationStatusMessage");
        Intrinsics.checkNotNullParameter(classTeacherRemark, "classTeacherRemark");
        Intrinsics.checkNotNullParameter(hodRemarks, "hodRemarks");
        Intrinsics.checkNotNullParameter(lastAttendedSem, "lastAttendedSem");
        Intrinsics.checkNotNullParameter(lastAttendedSemText, "lastAttendedSemText");
        Intrinsics.checkNotNullParameter(semList, "semList");
        return new SemRegViewResponse(login, admissionNo, semAppliedFor, update_btn, name, gender, phone, email, examAppear, uniRegNo, examMonthYear, backPaper, backPaperCount, earnedCredits, feePaid, bankName, amountPaid, paymentDate, paymentReferenceNo, paymentMode, feeReceiptFile, regSlipFile, feeConcession, feeConcessionCategory, departmentDue, departmentDueDetails, libraryDue, libraryDueDetails, accountsDue, accountsDueDetails, academicDue, academicDueDetails, hostelDue, hostelDueDetails, busDue, busDueDetails, status, isApplied, canEdit, canEditMessage, semRegistrationStatus, semRegistrationStatusMessage, feeExemption, classTeacherRemark, hodRemarks, lastAttendedSem, lastAttendedSemText, semList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemRegViewResponse)) {
            return false;
        }
        SemRegViewResponse semRegViewResponse = (SemRegViewResponse) other;
        return this.login == semRegViewResponse.login && Intrinsics.areEqual(this.admissionNo, semRegViewResponse.admissionNo) && Intrinsics.areEqual(this.semAppliedFor, semRegViewResponse.semAppliedFor) && this.update_btn == semRegViewResponse.update_btn && Intrinsics.areEqual(this.name, semRegViewResponse.name) && Intrinsics.areEqual(this.gender, semRegViewResponse.gender) && Intrinsics.areEqual(this.phone, semRegViewResponse.phone) && Intrinsics.areEqual(this.email, semRegViewResponse.email) && Intrinsics.areEqual(this.examAppear, semRegViewResponse.examAppear) && Intrinsics.areEqual(this.uniRegNo, semRegViewResponse.uniRegNo) && Intrinsics.areEqual(this.examMonthYear, semRegViewResponse.examMonthYear) && Intrinsics.areEqual(this.backPaper, semRegViewResponse.backPaper) && Intrinsics.areEqual(this.backPaperCount, semRegViewResponse.backPaperCount) && Intrinsics.areEqual(this.earnedCredits, semRegViewResponse.earnedCredits) && Intrinsics.areEqual(this.feePaid, semRegViewResponse.feePaid) && Intrinsics.areEqual(this.bankName, semRegViewResponse.bankName) && Intrinsics.areEqual(this.amountPaid, semRegViewResponse.amountPaid) && Intrinsics.areEqual(this.paymentDate, semRegViewResponse.paymentDate) && Intrinsics.areEqual(this.paymentReferenceNo, semRegViewResponse.paymentReferenceNo) && Intrinsics.areEqual(this.paymentMode, semRegViewResponse.paymentMode) && Intrinsics.areEqual(this.feeReceiptFile, semRegViewResponse.feeReceiptFile) && Intrinsics.areEqual(this.regSlipFile, semRegViewResponse.regSlipFile) && Intrinsics.areEqual(this.feeConcession, semRegViewResponse.feeConcession) && Intrinsics.areEqual(this.feeConcessionCategory, semRegViewResponse.feeConcessionCategory) && Intrinsics.areEqual(this.departmentDue, semRegViewResponse.departmentDue) && Intrinsics.areEqual(this.departmentDueDetails, semRegViewResponse.departmentDueDetails) && Intrinsics.areEqual(this.libraryDue, semRegViewResponse.libraryDue) && Intrinsics.areEqual(this.libraryDueDetails, semRegViewResponse.libraryDueDetails) && Intrinsics.areEqual(this.accountsDue, semRegViewResponse.accountsDue) && Intrinsics.areEqual(this.accountsDueDetails, semRegViewResponse.accountsDueDetails) && Intrinsics.areEqual(this.academicDue, semRegViewResponse.academicDue) && Intrinsics.areEqual(this.academicDueDetails, semRegViewResponse.academicDueDetails) && Intrinsics.areEqual(this.hostelDue, semRegViewResponse.hostelDue) && Intrinsics.areEqual(this.hostelDueDetails, semRegViewResponse.hostelDueDetails) && Intrinsics.areEqual(this.busDue, semRegViewResponse.busDue) && Intrinsics.areEqual(this.busDueDetails, semRegViewResponse.busDueDetails) && Intrinsics.areEqual(this.status, semRegViewResponse.status) && this.isApplied == semRegViewResponse.isApplied && this.canEdit == semRegViewResponse.canEdit && Intrinsics.areEqual(this.canEditMessage, semRegViewResponse.canEditMessage) && this.semRegistrationStatus == semRegViewResponse.semRegistrationStatus && Intrinsics.areEqual(this.semRegistrationStatusMessage, semRegViewResponse.semRegistrationStatusMessage) && this.feeExemption == semRegViewResponse.feeExemption && Intrinsics.areEqual(this.classTeacherRemark, semRegViewResponse.classTeacherRemark) && Intrinsics.areEqual(this.hodRemarks, semRegViewResponse.hodRemarks) && Intrinsics.areEqual(this.lastAttendedSem, semRegViewResponse.lastAttendedSem) && Intrinsics.areEqual(this.lastAttendedSemText, semRegViewResponse.lastAttendedSemText) && Intrinsics.areEqual(this.semList, semRegViewResponse.semList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v72, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v74, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v78, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((r0 * 31) + this.admissionNo.hashCode()) * 31) + this.semAppliedFor.hashCode()) * 31;
        ?? r2 = this.update_btn;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode + i) * 31) + this.name.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.email.hashCode()) * 31) + this.examAppear.hashCode()) * 31) + this.uniRegNo.hashCode()) * 31) + this.examMonthYear.hashCode()) * 31) + this.backPaper.hashCode()) * 31) + this.backPaperCount.hashCode()) * 31) + this.earnedCredits.hashCode()) * 31) + this.feePaid.hashCode()) * 31) + this.bankName.hashCode()) * 31) + this.amountPaid.hashCode()) * 31) + this.paymentDate.hashCode()) * 31) + this.paymentReferenceNo.hashCode()) * 31) + this.paymentMode.hashCode()) * 31) + this.feeReceiptFile.hashCode()) * 31) + this.regSlipFile.hashCode()) * 31) + this.feeConcession.hashCode()) * 31) + this.feeConcessionCategory.hashCode()) * 31) + this.departmentDue.hashCode()) * 31) + this.departmentDueDetails.hashCode()) * 31) + this.libraryDue.hashCode()) * 31) + this.libraryDueDetails.hashCode()) * 31) + this.accountsDue.hashCode()) * 31) + this.accountsDueDetails.hashCode()) * 31) + this.academicDue.hashCode()) * 31) + this.academicDueDetails.hashCode()) * 31) + this.hostelDue.hashCode()) * 31) + this.hostelDueDetails.hashCode()) * 31) + this.busDue.hashCode()) * 31) + this.busDueDetails.hashCode()) * 31) + this.status.hashCode()) * 31;
        ?? r22 = this.isApplied;
        int i2 = r22;
        if (r22 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        ?? r23 = this.canEdit;
        int i4 = r23;
        if (r23 != 0) {
            i4 = 1;
        }
        int hashCode3 = (((i3 + i4) * 31) + this.canEditMessage.hashCode()) * 31;
        ?? r24 = this.semRegistrationStatus;
        int i5 = r24;
        if (r24 != 0) {
            i5 = 1;
        }
        int hashCode4 = (((hashCode3 + i5) * 31) + this.semRegistrationStatusMessage.hashCode()) * 31;
        boolean z2 = this.feeExemption;
        return ((((((((((hashCode4 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.classTeacherRemark.hashCode()) * 31) + this.hodRemarks.hashCode()) * 31) + this.lastAttendedSem.hashCode()) * 31) + this.lastAttendedSemText.hashCode()) * 31) + this.semList.hashCode();
    }

    public String toString() {
        return "SemRegViewResponse(login=" + this.login + ", admissionNo=" + this.admissionNo + ", semAppliedFor=" + this.semAppliedFor + ", update_btn=" + this.update_btn + ", name=" + this.name + ", gender=" + this.gender + ", phone=" + this.phone + ", email=" + this.email + ", examAppear=" + this.examAppear + ", uniRegNo=" + this.uniRegNo + ", examMonthYear=" + this.examMonthYear + ", backPaper=" + this.backPaper + ", backPaperCount=" + this.backPaperCount + ", earnedCredits=" + this.earnedCredits + ", feePaid=" + this.feePaid + ", bankName=" + this.bankName + ", amountPaid=" + this.amountPaid + ", paymentDate=" + this.paymentDate + ", paymentReferenceNo=" + this.paymentReferenceNo + ", paymentMode=" + this.paymentMode + ", feeReceiptFile=" + this.feeReceiptFile + ", regSlipFile=" + this.regSlipFile + ", feeConcession=" + this.feeConcession + ", feeConcessionCategory=" + this.feeConcessionCategory + ", departmentDue=" + this.departmentDue + ", departmentDueDetails=" + this.departmentDueDetails + ", libraryDue=" + this.libraryDue + ", libraryDueDetails=" + this.libraryDueDetails + ", accountsDue=" + this.accountsDue + ", accountsDueDetails=" + this.accountsDueDetails + ", academicDue=" + this.academicDue + ", academicDueDetails=" + this.academicDueDetails + ", hostelDue=" + this.hostelDue + ", hostelDueDetails=" + this.hostelDueDetails + ", busDue=" + this.busDue + ", busDueDetails=" + this.busDueDetails + ", status=" + this.status + ", isApplied=" + this.isApplied + ", canEdit=" + this.canEdit + ", canEditMessage=" + this.canEditMessage + ", semRegistrationStatus=" + this.semRegistrationStatus + ", semRegistrationStatusMessage=" + this.semRegistrationStatusMessage + ", feeExemption=" + this.feeExemption + ", classTeacherRemark=" + this.classTeacherRemark + ", hodRemarks=" + this.hodRemarks + ", lastAttendedSem=" + this.lastAttendedSem + ", lastAttendedSemText=" + this.lastAttendedSemText + ", semList=" + this.semList + ")";
    }

    public SemRegViewResponse(boolean z, String admissionNo, String semAppliedFor, boolean z2, String name, String gender, String phone, String email, String examAppear, String uniRegNo, String examMonthYear, String backPaper, String backPaperCount, String earnedCredits, String feePaid, String bankName, String amountPaid, String paymentDate, String paymentReferenceNo, String paymentMode, String feeReceiptFile, String regSlipFile, String feeConcession, String feeConcessionCategory, String departmentDue, String departmentDueDetails, String libraryDue, String libraryDueDetails, String accountsDue, String accountsDueDetails, String academicDue, String academicDueDetails, String hostelDue, String hostelDueDetails, String busDue, String busDueDetails, String status, boolean z3, boolean z4, String canEditMessage, boolean z5, String semRegistrationStatusMessage, boolean z6, String classTeacherRemark, String hodRemarks, String lastAttendedSem, String lastAttendedSemText, ArrayList<Semester> semList) {
        Intrinsics.checkNotNullParameter(admissionNo, "admissionNo");
        Intrinsics.checkNotNullParameter(semAppliedFor, "semAppliedFor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(examAppear, "examAppear");
        Intrinsics.checkNotNullParameter(uniRegNo, "uniRegNo");
        Intrinsics.checkNotNullParameter(examMonthYear, "examMonthYear");
        Intrinsics.checkNotNullParameter(backPaper, "backPaper");
        Intrinsics.checkNotNullParameter(backPaperCount, "backPaperCount");
        Intrinsics.checkNotNullParameter(earnedCredits, "earnedCredits");
        Intrinsics.checkNotNullParameter(feePaid, "feePaid");
        Intrinsics.checkNotNullParameter(bankName, "bankName");
        Intrinsics.checkNotNullParameter(amountPaid, "amountPaid");
        Intrinsics.checkNotNullParameter(paymentDate, "paymentDate");
        Intrinsics.checkNotNullParameter(paymentReferenceNo, "paymentReferenceNo");
        Intrinsics.checkNotNullParameter(paymentMode, "paymentMode");
        Intrinsics.checkNotNullParameter(feeReceiptFile, "feeReceiptFile");
        Intrinsics.checkNotNullParameter(regSlipFile, "regSlipFile");
        Intrinsics.checkNotNullParameter(feeConcession, "feeConcession");
        Intrinsics.checkNotNullParameter(feeConcessionCategory, "feeConcessionCategory");
        Intrinsics.checkNotNullParameter(departmentDue, "departmentDue");
        Intrinsics.checkNotNullParameter(departmentDueDetails, "departmentDueDetails");
        Intrinsics.checkNotNullParameter(libraryDue, "libraryDue");
        Intrinsics.checkNotNullParameter(libraryDueDetails, "libraryDueDetails");
        Intrinsics.checkNotNullParameter(accountsDue, "accountsDue");
        Intrinsics.checkNotNullParameter(accountsDueDetails, "accountsDueDetails");
        Intrinsics.checkNotNullParameter(academicDue, "academicDue");
        Intrinsics.checkNotNullParameter(academicDueDetails, "academicDueDetails");
        Intrinsics.checkNotNullParameter(hostelDue, "hostelDue");
        Intrinsics.checkNotNullParameter(hostelDueDetails, "hostelDueDetails");
        Intrinsics.checkNotNullParameter(busDue, "busDue");
        Intrinsics.checkNotNullParameter(busDueDetails, "busDueDetails");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(canEditMessage, "canEditMessage");
        Intrinsics.checkNotNullParameter(semRegistrationStatusMessage, "semRegistrationStatusMessage");
        Intrinsics.checkNotNullParameter(classTeacherRemark, "classTeacherRemark");
        Intrinsics.checkNotNullParameter(hodRemarks, "hodRemarks");
        Intrinsics.checkNotNullParameter(lastAttendedSem, "lastAttendedSem");
        Intrinsics.checkNotNullParameter(lastAttendedSemText, "lastAttendedSemText");
        Intrinsics.checkNotNullParameter(semList, "semList");
        this.login = z;
        this.admissionNo = admissionNo;
        this.semAppliedFor = semAppliedFor;
        this.update_btn = z2;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.examAppear = examAppear;
        this.uniRegNo = uniRegNo;
        this.examMonthYear = examMonthYear;
        this.backPaper = backPaper;
        this.backPaperCount = backPaperCount;
        this.earnedCredits = earnedCredits;
        this.feePaid = feePaid;
        this.bankName = bankName;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.paymentReferenceNo = paymentReferenceNo;
        this.paymentMode = paymentMode;
        this.feeReceiptFile = feeReceiptFile;
        this.regSlipFile = regSlipFile;
        this.feeConcession = feeConcession;
        this.feeConcessionCategory = feeConcessionCategory;
        this.departmentDue = departmentDue;
        this.departmentDueDetails = departmentDueDetails;
        this.libraryDue = libraryDue;
        this.libraryDueDetails = libraryDueDetails;
        this.accountsDue = accountsDue;
        this.accountsDueDetails = accountsDueDetails;
        this.academicDue = academicDue;
        this.academicDueDetails = academicDueDetails;
        this.hostelDue = hostelDue;
        this.hostelDueDetails = hostelDueDetails;
        this.busDue = busDue;
        this.busDueDetails = busDueDetails;
        this.status = status;
        this.isApplied = z3;
        this.canEdit = z4;
        this.canEditMessage = canEditMessage;
        this.semRegistrationStatus = z5;
        this.semRegistrationStatusMessage = semRegistrationStatusMessage;
        this.feeExemption = z6;
        this.classTeacherRemark = classTeacherRemark;
        this.hodRemarks = hodRemarks;
        this.lastAttendedSem = lastAttendedSem;
        this.lastAttendedSemText = lastAttendedSemText;
        this.semList = semList;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getAdmissionNo() {
        return this.admissionNo;
    }

    public final String getSemAppliedFor() {
        return this.semAppliedFor;
    }

    public final boolean getUpdate_btn() {
        return this.update_btn;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getExamAppear() {
        return this.examAppear;
    }

    public final String getUniRegNo() {
        return this.uniRegNo;
    }

    public final String getExamMonthYear() {
        return this.examMonthYear;
    }

    public final String getBackPaper() {
        return this.backPaper;
    }

    public final String getBackPaperCount() {
        return this.backPaperCount;
    }

    public final String getEarnedCredits() {
        return this.earnedCredits;
    }

    public final String getFeePaid() {
        return this.feePaid;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getAmountPaid() {
        return this.amountPaid;
    }

    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final String getPaymentReferenceNo() {
        return this.paymentReferenceNo;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getFeeReceiptFile() {
        return this.feeReceiptFile;
    }

    public final String getRegSlipFile() {
        return this.regSlipFile;
    }

    public final String getFeeConcession() {
        return this.feeConcession;
    }

    public final String getFeeConcessionCategory() {
        return this.feeConcessionCategory;
    }

    public final String getDepartmentDue() {
        return this.departmentDue;
    }

    public final String getDepartmentDueDetails() {
        return this.departmentDueDetails;
    }

    public final String getLibraryDue() {
        return this.libraryDue;
    }

    public final String getLibraryDueDetails() {
        return this.libraryDueDetails;
    }

    public final String getAccountsDue() {
        return this.accountsDue;
    }

    public final String getAccountsDueDetails() {
        return this.accountsDueDetails;
    }

    public final String getAcademicDue() {
        return this.academicDue;
    }

    public final String getAcademicDueDetails() {
        return this.academicDueDetails;
    }

    public final String getHostelDue() {
        return this.hostelDue;
    }

    public final String getHostelDueDetails() {
        return this.hostelDueDetails;
    }

    public final String getBusDue() {
        return this.busDue;
    }

    public final String getBusDueDetails() {
        return this.busDueDetails;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final String getCanEditMessage() {
        return this.canEditMessage;
    }

    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    public final String getClassTeacherRemark() {
        return this.classTeacherRemark;
    }

    public final String getHodRemarks() {
        return this.hodRemarks;
    }

    public final String getLastAttendedSem() {
        return this.lastAttendedSem;
    }

    public final String getLastAttendedSemText() {
        return this.lastAttendedSemText;
    }

    public final ArrayList<Semester> getSemList() {
        return this.semList;
    }
}