package in.etuwa.app.ui.subjectregistration.apply;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.subjectregistration.SubjectSpinnerResponse;
import in.etuwa.app.data.model.subjectregistration.ViewSubjectRegistrationResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogApplySubjectRegistrationBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ApplySubjectRegistrationDialog.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 §\u00012\u00020\u0001:\u0004§\u0001¨\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0014J\n\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0002J\n\u0010\u008a\u0001\u001a\u00030\u0088\u0001H\u0002J\n\u0010\u008b\u0001\u001a\u00030\u0088\u0001H\u0002J\n\u0010\u008c\u0001\u001a\u00030\u0088\u0001H\u0002J\n\u0010\u008d\u0001\u001a\u00030\u0088\u0001H\u0002J\u0014\u0010\u008e\u0001\u001a\u00030\u0088\u00012\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u0016\u0010\u0091\u0001\u001a\u00030\u0088\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J.\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\n\u0010\u009a\u0001\u001a\u00030\u0088\u0001H\u0016J\n\u0010\u009b\u0001\u001a\u00030\u0088\u0001H\u0016J\u0014\u0010\u009c\u0001\u001a\u00030\u0088\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J \u0010\u009f\u0001\u001a\u00030\u0088\u00012\b\u0010 \u0001\u001a\u00030\u0095\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0012\u0010¡\u0001\u001a\u00030\u0088\u00012\b\u0010\u008f\u0001\u001a\u00030¢\u0001J\u0012\u0010£\u0001\u001a\u00030\u0088\u00012\b\u0010\u008f\u0001\u001a\u00030¤\u0001J\n\u0010¥\u0001\u001a\u00030\u0088\u0001H\u0014J\n\u0010¦\u0001\u001a\u00030\u0088\u0001H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0011\u001a\u0004\b@\u0010AR\u000e\u0010C\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0011\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0011\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0011\u001a\u0004\bO\u0010LR\u001b\u0010Q\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0011\u001a\u0004\bR\u0010LR\u001b\u0010T\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0011\u001a\u0004\bU\u0010LR\u001b\u0010W\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0011\u001a\u0004\bX\u0010LR\u001b\u0010Z\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0011\u001a\u0004\b[\u0010LR\u001b\u0010]\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0011\u001a\u0004\b^\u0010LR\u001b\u0010`\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0011\u001a\u0004\ba\u0010LR\u001b\u0010c\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0011\u001a\u0004\bd\u0010LR\u001b\u0010f\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0011\u001a\u0004\bg\u0010LR\u001b\u0010i\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0011\u001a\u0004\bj\u0010LR\u001b\u0010l\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0011\u001a\u0004\bm\u0010LR\u001b\u0010o\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0011\u001a\u0004\bp\u0010LR\u001b\u0010r\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0011\u001a\u0004\bs\u0010LR\u001b\u0010u\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u0011\u001a\u0004\bv\u0010LR\u001b\u0010x\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u0011\u001a\u0004\by\u0010LR\u001b\u0010{\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\u0011\u001a\u0004\b|\u0010LR\u001c\u0010~\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\u0011\u001a\u0004\b\u007f\u0010LR\u001e\u0010\u0081\u0001\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u0011\u001a\u0005\b\u0082\u0001\u0010LR\u001e\u0010\u0084\u0001\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0011\u001a\u0005\b\u0085\u0001\u0010L¨\u0006©\u0001"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogApplySubjectRegistrationBinding;", "additionalElective1", "", "additionalElective2", "additionalElective3", "aec1", "aec2", "aec3", "applySubjectRegistrationViewModel", "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationViewModel;", "getApplySubjectRegistrationViewModel", "()Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationViewModel;", "applySubjectRegistrationViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogApplySubjectRegistrationBinding;", "dsc1", "dsc2", "dsc3", "elective1", "elective2", "elective3", "flag", "", "flagAdditionalElective1", "flagAdditionalElective2", "flagAdditionalElective3", "flagAec1", "flagAec2", "flagAec3", "flagDsc1", "flagDsc2", "flagDsc3", "flagElective1", "flagElective2", "flagElective3", "flagGlobalElective", "flagHonour", "flagMdc1", "flagMdc2", "flagMdc3", "flagMinor", "flagMinor2", "flagMinor3", "globalElective", "honour", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog$RegisterListener;", "listner2", "Lin/etuwa/app/helper/MainCallBackListener;", "mdc1", "mdc2", "mdc3", "minor", "minor2", "minor3", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semId", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdditionalElective1Adapter", "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationSpinnerAdapter;", "getSpinnerAdditionalElective1Adapter", "()Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationSpinnerAdapter;", "spinnerAdditionalElective1Adapter$delegate", "spinnerAdditionalElective2Adapter", "getSpinnerAdditionalElective2Adapter", "spinnerAdditionalElective2Adapter$delegate", "spinnerAdditionalElective3Adapter", "getSpinnerAdditionalElective3Adapter", "spinnerAdditionalElective3Adapter$delegate", "spinnerAec1Adapter", "getSpinnerAec1Adapter", "spinnerAec1Adapter$delegate", "spinnerAec2Adapter", "getSpinnerAec2Adapter", "spinnerAec2Adapter$delegate", "spinnerAec3Adapter", "getSpinnerAec3Adapter", "spinnerAec3Adapter$delegate", "spinnerDsc1Adapter", "getSpinnerDsc1Adapter", "spinnerDsc1Adapter$delegate", "spinnerDsc2Adapter", "getSpinnerDsc2Adapter", "spinnerDsc2Adapter$delegate", "spinnerDsc3Adapter", "getSpinnerDsc3Adapter", "spinnerDsc3Adapter$delegate", "spinnerElective1Adapter", "getSpinnerElective1Adapter", "spinnerElective1Adapter$delegate", "spinnerElective2Adapter", "getSpinnerElective2Adapter", "spinnerElective2Adapter$delegate", "spinnerElective3Adapter", "getSpinnerElective3Adapter", "spinnerElective3Adapter$delegate", "spinnerGlobalElectiveAdapter", "getSpinnerGlobalElectiveAdapter", "spinnerGlobalElectiveAdapter$delegate", "spinnerHonourAdapter", "getSpinnerHonourAdapter", "spinnerHonourAdapter$delegate", "spinnerMdc1Adapter", "getSpinnerMdc1Adapter", "spinnerMdc1Adapter$delegate", "spinnerMdc2Adapter", "getSpinnerMdc2Adapter", "spinnerMdc2Adapter$delegate", "spinnerMdc3Adapter", "getSpinnerMdc3Adapter", "spinnerMdc3Adapter$delegate", "spinnerMinor1Adapter", "getSpinnerMinor1Adapter", "spinnerMinor1Adapter$delegate", "spinnerMinor2Adapter", "getSpinnerMinor2Adapter", "spinnerMinor2Adapter$delegate", "spinnerMinor3Adapter", "getSpinnerMinor3Adapter", "spinnerMinor3Adapter$delegate", "hideProgress", "", "listenRegisterResponse", "listenResponse", "listenSemResponse", "listenSpinnerResponse", "listenUpdateResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment;", "setCallBack2", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog;", "setUp", "showProgress", "Companion", "RegisterListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplySubjectRegistrationDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogApplySubjectRegistrationBinding _binding;
    private String additionalElective1;
    private String additionalElective2;
    private String additionalElective3;
    private String aec1;
    private String aec2;
    private String aec3;

    /* renamed from: applySubjectRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy applySubjectRegistrationViewModel;
    private String dsc1;
    private String dsc2;
    private String dsc3;
    private String elective1;
    private String elective2;
    private String elective3;
    private boolean flag;
    private boolean flagAdditionalElective1;
    private boolean flagAdditionalElective2;
    private boolean flagAdditionalElective3;
    private boolean flagAec1;
    private boolean flagAec2;
    private boolean flagAec3;
    private boolean flagDsc1;
    private boolean flagDsc2;
    private boolean flagDsc3;
    private boolean flagElective1;
    private boolean flagElective2;
    private boolean flagElective3;
    private boolean flagGlobalElective;
    private boolean flagHonour;
    private boolean flagMdc1;
    private boolean flagMdc2;
    private boolean flagMdc3;
    private boolean flagMinor;
    private boolean flagMinor2;
    private boolean flagMinor3;
    private String globalElective;
    private String honour;
    private String id;
    private RegisterListener listener;
    private MainCallBackListener listner2;
    private String mdc1;
    private String mdc2;
    private String mdc3;
    private String minor;
    private String minor2;
    private String minor3;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdditionalElective1Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdditionalElective1Adapter;

    /* renamed from: spinnerAdditionalElective2Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdditionalElective2Adapter;

    /* renamed from: spinnerAdditionalElective3Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdditionalElective3Adapter;

    /* renamed from: spinnerAec1Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAec1Adapter;

    /* renamed from: spinnerAec2Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAec2Adapter;

    /* renamed from: spinnerAec3Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAec3Adapter;

    /* renamed from: spinnerDsc1Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerDsc1Adapter;

    /* renamed from: spinnerDsc2Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerDsc2Adapter;

    /* renamed from: spinnerDsc3Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerDsc3Adapter;

    /* renamed from: spinnerElective1Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerElective1Adapter;

    /* renamed from: spinnerElective2Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerElective2Adapter;

    /* renamed from: spinnerElective3Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerElective3Adapter;

    /* renamed from: spinnerGlobalElectiveAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerGlobalElectiveAdapter;

    /* renamed from: spinnerHonourAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerHonourAdapter;

    /* renamed from: spinnerMdc1Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMdc1Adapter;

    /* renamed from: spinnerMdc2Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMdc2Adapter;

    /* renamed from: spinnerMdc3Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMdc3Adapter;

    /* renamed from: spinnerMinor1Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMinor1Adapter;

    /* renamed from: spinnerMinor2Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMinor2Adapter;

    /* renamed from: spinnerMinor3Adapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMinor3Adapter;

    /* compiled from: ApplySubjectRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog$RegisterListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RegisterListener {
        void dismiss();
    }

    /* compiled from: ApplySubjectRegistrationDialog.kt */
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

    @JvmStatic
    public static final ApplySubjectRegistrationDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ApplySubjectRegistrationDialog() {
        final ApplySubjectRegistrationDialog applySubjectRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(applySubjectRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.applySubjectRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(applySubjectRegistrationDialog, Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerHonourAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerHonourAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b5, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerMinor1Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerMinor1Adapter = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b6, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerMinor2Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        this.spinnerMinor2Adapter = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b7, function05);
            }
        });
        final Function0<ParametersHolder> function06 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerMinor3Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        this.spinnerMinor3Adapter = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b8, function06);
            }
        });
        final Function0<ParametersHolder> function07 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerElective1Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode7 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b9 = 0 == true ? 1 : 0;
        this.spinnerElective1Adapter = LazyKt.lazy(lazyThreadSafetyMode7, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b9, function07);
            }
        });
        final Function0<ParametersHolder> function08 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerElective2Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode8 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        this.spinnerElective2Adapter = LazyKt.lazy(lazyThreadSafetyMode8, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b10, function08);
            }
        });
        final Function0<ParametersHolder> function09 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerElective3Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode9 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b11 = 0 == true ? 1 : 0;
        this.spinnerElective3Adapter = LazyKt.lazy(lazyThreadSafetyMode9, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b11, function09);
            }
        });
        final Function0<ParametersHolder> function010 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerGlobalElectiveAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode10 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        this.spinnerGlobalElectiveAdapter = LazyKt.lazy(lazyThreadSafetyMode10, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b12, function010);
            }
        });
        final Function0<ParametersHolder> function011 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAdditionalElective1Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode11 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b13 = 0 == true ? 1 : 0;
        this.spinnerAdditionalElective1Adapter = LazyKt.lazy(lazyThreadSafetyMode11, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b13, function011);
            }
        });
        final Function0<ParametersHolder> function012 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAdditionalElective2Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode12 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b14 = 0 == true ? 1 : 0;
        this.spinnerAdditionalElective2Adapter = LazyKt.lazy(lazyThreadSafetyMode12, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b14, function012);
            }
        });
        final Function0<ParametersHolder> function013 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAdditionalElective3Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode13 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b15 = 0 == true ? 1 : 0;
        this.spinnerAdditionalElective3Adapter = LazyKt.lazy(lazyThreadSafetyMode13, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b15, function013);
            }
        });
        final Function0<ParametersHolder> function014 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerMdc1Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode14 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b16 = 0 == true ? 1 : 0;
        this.spinnerMdc1Adapter = LazyKt.lazy(lazyThreadSafetyMode14, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b16, function014);
            }
        });
        final Function0<ParametersHolder> function015 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerMdc2Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode15 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b17 = 0 == true ? 1 : 0;
        this.spinnerMdc2Adapter = LazyKt.lazy(lazyThreadSafetyMode15, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b17, function015);
            }
        });
        final Function0<ParametersHolder> function016 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerMdc3Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode16 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b18 = 0 == true ? 1 : 0;
        this.spinnerMdc3Adapter = LazyKt.lazy(lazyThreadSafetyMode16, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b18, function016);
            }
        });
        final Function0<ParametersHolder> function017 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerDsc1Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode17 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b19 = 0 == true ? 1 : 0;
        this.spinnerDsc1Adapter = LazyKt.lazy(lazyThreadSafetyMode17, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b19, function017);
            }
        });
        final Function0<ParametersHolder> function018 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerDsc2Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode18 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b20 = 0 == true ? 1 : 0;
        this.spinnerDsc2Adapter = LazyKt.lazy(lazyThreadSafetyMode18, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b20, function018);
            }
        });
        final Function0<ParametersHolder> function019 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerDsc3Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode19 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b21 = 0 == true ? 1 : 0;
        this.spinnerDsc3Adapter = LazyKt.lazy(lazyThreadSafetyMode19, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b21, function019);
            }
        });
        final Function0<ParametersHolder> function020 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAec1Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode20 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b22 = 0 == true ? 1 : 0;
        this.spinnerAec1Adapter = LazyKt.lazy(lazyThreadSafetyMode20, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b22, function020);
            }
        });
        final Function0<ParametersHolder> function021 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAec2Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode21 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b23 = 0 == true ? 1 : 0;
        this.spinnerAec2Adapter = LazyKt.lazy(lazyThreadSafetyMode21, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$21
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b23, function021);
            }
        });
        final Function0<ParametersHolder> function022 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$spinnerAec3Adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplySubjectRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode22 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b24 = 0 == true ? 1 : 0;
        this.spinnerAec3Adapter = LazyKt.lazy(lazyThreadSafetyMode22, (Function0) new Function0<ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$special$$inlined$inject$default$22
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ApplySubjectRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applySubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), b24, function022);
            }
        });
        this.honour = "00000";
        this.minor = "00000";
        this.minor2 = "00000";
        this.minor3 = "00000";
        this.elective1 = "00000";
        this.elective2 = "00000";
        this.elective3 = "00000";
        this.globalElective = "00000";
        this.additionalElective1 = "00000";
        this.additionalElective2 = "00000";
        this.additionalElective3 = "00000";
        this.mdc1 = "00000";
        this.mdc2 = "00000";
        this.mdc3 = "00000";
        this.dsc1 = "00000";
        this.dsc2 = "00000";
        this.dsc3 = "00000";
        this.aec1 = "00000";
        this.aec2 = "00000";
        this.aec3 = "00000";
        this.semId = getPreference().getUserSemId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationViewModel getApplySubjectRegistrationViewModel() {
        return (ApplySubjectRegistrationViewModel) this.applySubjectRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogApplySubjectRegistrationBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerHonourAdapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerHonourAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerMinor1Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerMinor1Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerMinor2Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerMinor2Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerMinor3Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerMinor3Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerElective1Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerElective1Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerElective2Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerElective2Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerElective3Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerElective3Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerGlobalElectiveAdapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerGlobalElectiveAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerAdditionalElective1Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerAdditionalElective1Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerAdditionalElective2Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerAdditionalElective2Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerAdditionalElective3Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerAdditionalElective3Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerMdc1Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerMdc1Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerMdc2Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerMdc2Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerMdc3Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerMdc3Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerDsc1Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerDsc1Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerDsc2Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerDsc2Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerDsc3Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerDsc3Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerAec1Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerAec1Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerAec2Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerAec2Adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplySubjectRegistrationSpinnerAdapter getSpinnerAec3Adapter() {
        return (ApplySubjectRegistrationSpinnerAdapter) this.spinnerAec3Adapter.getValue();
    }

    /* compiled from: ApplySubjectRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ApplySubjectRegistrationDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ApplySubjectRegistrationDialog applySubjectRegistrationDialog = new ApplySubjectRegistrationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            applySubjectRegistrationDialog.setArguments(bundle);
            return applySubjectRegistrationDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogApplySubjectRegistrationBinding.inflate(inflater, container, false);
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding = get_binding();
        if (dialogApplySubjectRegistrationBinding != null) {
            dialogApplySubjectRegistrationBinding.setApplySubjectRegistrationViewModel(getApplySubjectRegistrationViewModel());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2 = get_binding();
        if (dialogApplySubjectRegistrationBinding2 != null) {
            dialogApplySubjectRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding3 = get_binding();
        if (dialogApplySubjectRegistrationBinding3 != null) {
            return dialogApplySubjectRegistrationBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        TextView textView;
        if (!Intrinsics.areEqual(this.id, "")) {
            ApplySubjectRegistrationViewModel applySubjectRegistrationViewModel = getApplySubjectRegistrationViewModel();
            String str = this.id;
            Intrinsics.checkNotNull(str);
            applySubjectRegistrationViewModel.getData(str);
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding = get_binding();
            TextView textView2 = dialogApplySubjectRegistrationBinding != null ? dialogApplySubjectRegistrationBinding.registerBtn : null;
            if (textView2 != null) {
                textView2.setText("Update");
            }
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2 = get_binding();
            LinearLayout linearLayout = dialogApplySubjectRegistrationBinding2 != null ? dialogApplySubjectRegistrationBinding2.semesterLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding3 = get_binding();
            TextView textView3 = dialogApplySubjectRegistrationBinding3 != null ? dialogApplySubjectRegistrationBinding3.semesterTv : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding4 = get_binding();
            TextView textView4 = dialogApplySubjectRegistrationBinding4 != null ? dialogApplySubjectRegistrationBinding4.registerBtn : null;
            if (textView4 != null) {
                textView4.setText("Register");
            }
            getApplySubjectRegistrationViewModel().getSemester();
            getApplySubjectRegistrationViewModel().getSpinnerData(getPreference().getUserSemId());
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding5 = get_binding();
            LinearLayout linearLayout2 = dialogApplySubjectRegistrationBinding5 != null ? dialogApplySubjectRegistrationBinding5.semesterLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding6 = get_binding();
            TextView textView5 = dialogApplySubjectRegistrationBinding6 != null ? dialogApplySubjectRegistrationBinding6.semesterTv : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding7 = get_binding();
        Spinner spinner = dialogApplySubjectRegistrationBinding7 != null ? dialogApplySubjectRegistrationBinding7.spinnerSemesterLastAttended : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding8 = get_binding();
        Spinner spinner2 = dialogApplySubjectRegistrationBinding8 != null ? dialogApplySubjectRegistrationBinding8.spinnerMinor : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerMinor1Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding9 = get_binding();
        Spinner spinner3 = dialogApplySubjectRegistrationBinding9 != null ? dialogApplySubjectRegistrationBinding9.spinnerMinor2 : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerMinor2Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding10 = get_binding();
        Spinner spinner4 = dialogApplySubjectRegistrationBinding10 != null ? dialogApplySubjectRegistrationBinding10.spinnerMinor3 : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getSpinnerMinor3Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding11 = get_binding();
        Spinner spinner5 = dialogApplySubjectRegistrationBinding11 != null ? dialogApplySubjectRegistrationBinding11.spinnerHonour : null;
        if (spinner5 != null) {
            spinner5.setAdapter((SpinnerAdapter) getSpinnerHonourAdapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding12 = get_binding();
        Spinner spinner6 = dialogApplySubjectRegistrationBinding12 != null ? dialogApplySubjectRegistrationBinding12.spinnerElective1 : null;
        if (spinner6 != null) {
            spinner6.setAdapter((SpinnerAdapter) getSpinnerElective1Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding13 = get_binding();
        Spinner spinner7 = dialogApplySubjectRegistrationBinding13 != null ? dialogApplySubjectRegistrationBinding13.spinnerElective2 : null;
        if (spinner7 != null) {
            spinner7.setAdapter((SpinnerAdapter) getSpinnerElective2Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding14 = get_binding();
        Spinner spinner8 = dialogApplySubjectRegistrationBinding14 != null ? dialogApplySubjectRegistrationBinding14.spinnerElective3 : null;
        if (spinner8 != null) {
            spinner8.setAdapter((SpinnerAdapter) getSpinnerElective3Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding15 = get_binding();
        Spinner spinner9 = dialogApplySubjectRegistrationBinding15 != null ? dialogApplySubjectRegistrationBinding15.spinnerAdditionalElective1 : null;
        if (spinner9 != null) {
            spinner9.setAdapter((SpinnerAdapter) getSpinnerAdditionalElective1Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding16 = get_binding();
        Spinner spinner10 = dialogApplySubjectRegistrationBinding16 != null ? dialogApplySubjectRegistrationBinding16.spinnerAdditionalElective2 : null;
        if (spinner10 != null) {
            spinner10.setAdapter((SpinnerAdapter) getSpinnerAdditionalElective2Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding17 = get_binding();
        Spinner spinner11 = dialogApplySubjectRegistrationBinding17 != null ? dialogApplySubjectRegistrationBinding17.spinnerAdditionalElective3 : null;
        if (spinner11 != null) {
            spinner11.setAdapter((SpinnerAdapter) getSpinnerAdditionalElective3Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding18 = get_binding();
        Spinner spinner12 = dialogApplySubjectRegistrationBinding18 != null ? dialogApplySubjectRegistrationBinding18.spinnerGlobalElective : null;
        if (spinner12 != null) {
            spinner12.setAdapter((SpinnerAdapter) getSpinnerGlobalElectiveAdapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding19 = get_binding();
        Spinner spinner13 = dialogApplySubjectRegistrationBinding19 != null ? dialogApplySubjectRegistrationBinding19.spinnerMdc1 : null;
        if (spinner13 != null) {
            spinner13.setAdapter((SpinnerAdapter) getSpinnerMdc1Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding20 = get_binding();
        Spinner spinner14 = dialogApplySubjectRegistrationBinding20 != null ? dialogApplySubjectRegistrationBinding20.spinnerMdc2 : null;
        if (spinner14 != null) {
            spinner14.setAdapter((SpinnerAdapter) getSpinnerMdc2Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding21 = get_binding();
        Spinner spinner15 = dialogApplySubjectRegistrationBinding21 != null ? dialogApplySubjectRegistrationBinding21.spinnerMdc3 : null;
        if (spinner15 != null) {
            spinner15.setAdapter((SpinnerAdapter) getSpinnerMdc3Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding22 = get_binding();
        Spinner spinner16 = dialogApplySubjectRegistrationBinding22 != null ? dialogApplySubjectRegistrationBinding22.spinnerDsc1 : null;
        if (spinner16 != null) {
            spinner16.setAdapter((SpinnerAdapter) getSpinnerDsc1Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding23 = get_binding();
        Spinner spinner17 = dialogApplySubjectRegistrationBinding23 != null ? dialogApplySubjectRegistrationBinding23.spinnerDsc2 : null;
        if (spinner17 != null) {
            spinner17.setAdapter((SpinnerAdapter) getSpinnerDsc2Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding24 = get_binding();
        Spinner spinner18 = dialogApplySubjectRegistrationBinding24 != null ? dialogApplySubjectRegistrationBinding24.spinnerDsc3 : null;
        if (spinner18 != null) {
            spinner18.setAdapter((SpinnerAdapter) getSpinnerDsc3Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding25 = get_binding();
        Spinner spinner19 = dialogApplySubjectRegistrationBinding25 != null ? dialogApplySubjectRegistrationBinding25.spinnerAec1 : null;
        if (spinner19 != null) {
            spinner19.setAdapter((SpinnerAdapter) getSpinnerAec1Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding26 = get_binding();
        Spinner spinner20 = dialogApplySubjectRegistrationBinding26 != null ? dialogApplySubjectRegistrationBinding26.spinnerAec2 : null;
        if (spinner20 != null) {
            spinner20.setAdapter((SpinnerAdapter) getSpinnerAec2Adapter());
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding27 = get_binding();
        Spinner spinner21 = dialogApplySubjectRegistrationBinding27 != null ? dialogApplySubjectRegistrationBinding27.spinnerAec3 : null;
        if (spinner21 != null) {
            spinner21.setAdapter((SpinnerAdapter) getSpinnerAec3Adapter());
        }
        listenSpinnerResponse();
        listenRegisterResponse();
        listenSemResponse();
        listenResponse();
        listenUpdateResponse();
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding28 = get_binding();
        Spinner spinner22 = dialogApplySubjectRegistrationBinding28 != null ? dialogApplySubjectRegistrationBinding28.spinnerSemesterLastAttended : null;
        if (spinner22 != null) {
            spinner22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    SemesterSpinnerAdapter spinnerAdapter;
                    String str2;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding29;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    Spinner spinner23;
                    SemesterSpinnerAdapter spinnerAdapter4;
                    ApplySubjectRegistrationViewModel applySubjectRegistrationViewModel2;
                    String str3;
                    z = ApplySubjectRegistrationDialog.this.flag;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flag = true;
                        spinnerAdapter = ApplySubjectRegistrationDialog.this.getSpinnerAdapter();
                        int count = spinnerAdapter.getCount();
                        for (int i = 0; i < count; i++) {
                            str2 = ApplySubjectRegistrationDialog.this.semId;
                            spinnerAdapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAdapter();
                            if (Intrinsics.areEqual(str2, spinnerAdapter2.getSemester(i).getId())) {
                                dialogApplySubjectRegistrationBinding29 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding29 != null && (spinner23 = dialogApplySubjectRegistrationBinding29.spinnerSemesterLastAttended) != null) {
                                    spinner23.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAdapter3 = applySubjectRegistrationDialog.getSpinnerAdapter();
                                applySubjectRegistrationDialog.semId = spinnerAdapter3.getSemester(position).getId();
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    spinnerAdapter4 = applySubjectRegistrationDialog2.getSpinnerAdapter();
                    applySubjectRegistrationDialog2.semId = spinnerAdapter4.getSemester(position).getId();
                    applySubjectRegistrationViewModel2 = ApplySubjectRegistrationDialog.this.getApplySubjectRegistrationViewModel();
                    str3 = ApplySubjectRegistrationDialog.this.semId;
                    applySubjectRegistrationViewModel2.getSpinnerData(str3);
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding29 = get_binding();
        Spinner spinner23 = dialogApplySubjectRegistrationBinding29 != null ? dialogApplySubjectRegistrationBinding29.spinnerMinor : null;
        if (spinner23 != null) {
            spinner23.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor1Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor1Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding30;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor1Adapter3;
                    Spinner spinner24;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor1Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagMinor;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagMinor = true;
                        str2 = ApplySubjectRegistrationDialog.this.minor;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.minor;
                        System.out.println((Object) str3);
                        spinnerMinor1Adapter = ApplySubjectRegistrationDialog.this.getSpinnerMinor1Adapter();
                        int count = spinnerMinor1Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerMinor1Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerMinor1Adapter();
                            String name = spinnerMinor1Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.minor;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding30 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding30 != null && (spinner24 = dialogApplySubjectRegistrationBinding30.spinnerMinor) != null) {
                                    spinner24.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerMinor1Adapter3 = applySubjectRegistrationDialog.getSpinnerMinor1Adapter();
                                applySubjectRegistrationDialog.minor = String.valueOf(spinnerMinor1Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerMinor1Adapter4 = applySubjectRegistrationDialog2.getSpinnerMinor1Adapter();
                        valueOf = String.valueOf(spinnerMinor1Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.minor = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding30 = get_binding();
        Spinner spinner24 = dialogApplySubjectRegistrationBinding30 != null ? dialogApplySubjectRegistrationBinding30.spinnerMinor2 : null;
        if (spinner24 != null) {
            spinner24.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor2Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor2Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding31;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor2Adapter3;
                    Spinner spinner25;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor2Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagMinor2;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagMinor2 = true;
                        str2 = ApplySubjectRegistrationDialog.this.minor2;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.minor2;
                        System.out.println((Object) str3);
                        spinnerMinor2Adapter = ApplySubjectRegistrationDialog.this.getSpinnerMinor2Adapter();
                        int count = spinnerMinor2Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerMinor2Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerMinor2Adapter();
                            String name = spinnerMinor2Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.minor2;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding31 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding31 != null && (spinner25 = dialogApplySubjectRegistrationBinding31.spinnerMinor2) != null) {
                                    spinner25.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerMinor2Adapter3 = applySubjectRegistrationDialog.getSpinnerMinor2Adapter();
                                applySubjectRegistrationDialog.minor2 = String.valueOf(spinnerMinor2Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerMinor2Adapter4 = applySubjectRegistrationDialog2.getSpinnerMinor2Adapter();
                        valueOf = String.valueOf(spinnerMinor2Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.minor2 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding31 = get_binding();
        Spinner spinner25 = dialogApplySubjectRegistrationBinding31 != null ? dialogApplySubjectRegistrationBinding31.spinnerMinor3 : null;
        if (spinner25 != null) {
            spinner25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor3Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor3Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding32;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor3Adapter3;
                    Spinner spinner26;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMinor3Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagMinor3;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagMinor3 = true;
                        str2 = ApplySubjectRegistrationDialog.this.minor3;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.minor3;
                        System.out.println((Object) str3);
                        spinnerMinor3Adapter = ApplySubjectRegistrationDialog.this.getSpinnerMinor3Adapter();
                        int count = spinnerMinor3Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerMinor3Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerMinor3Adapter();
                            String name = spinnerMinor3Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.minor3;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding32 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding32 != null && (spinner26 = dialogApplySubjectRegistrationBinding32.spinnerMinor3) != null) {
                                    spinner26.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerMinor3Adapter3 = applySubjectRegistrationDialog.getSpinnerMinor3Adapter();
                                applySubjectRegistrationDialog.minor3 = String.valueOf(spinnerMinor3Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerMinor3Adapter4 = applySubjectRegistrationDialog2.getSpinnerMinor3Adapter();
                        valueOf = String.valueOf(spinnerMinor3Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.minor3 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding32 = get_binding();
        Spinner spinner26 = dialogApplySubjectRegistrationBinding32 != null ? dialogApplySubjectRegistrationBinding32.spinnerHonour : null;
        if (spinner26 != null) {
            spinner26.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerHonourAdapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerHonourAdapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding33;
                    ApplySubjectRegistrationSpinnerAdapter spinnerHonourAdapter3;
                    Spinner spinner27;
                    ApplySubjectRegistrationSpinnerAdapter spinnerHonourAdapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagHonour;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagHonour = true;
                        spinnerHonourAdapter = ApplySubjectRegistrationDialog.this.getSpinnerHonourAdapter();
                        int count = spinnerHonourAdapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerHonourAdapter2 = ApplySubjectRegistrationDialog.this.getSpinnerHonourAdapter();
                            String name = spinnerHonourAdapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.honour;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding33 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding33 != null && (spinner27 = dialogApplySubjectRegistrationBinding33.spinnerHonour) != null) {
                                    spinner27.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerHonourAdapter3 = applySubjectRegistrationDialog.getSpinnerHonourAdapter();
                                applySubjectRegistrationDialog.honour = String.valueOf(spinnerHonourAdapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerHonourAdapter4 = applySubjectRegistrationDialog2.getSpinnerHonourAdapter();
                        valueOf = String.valueOf(spinnerHonourAdapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.honour = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding33 = get_binding();
        Spinner spinner27 = dialogApplySubjectRegistrationBinding33 != null ? dialogApplySubjectRegistrationBinding33.spinnerElective1 : null;
        if (spinner27 != null) {
            spinner27.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$6
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective1Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective1Adapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding34;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective1Adapter3;
                    Spinner spinner28;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective1Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagElective1;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagElective1 = true;
                        spinnerElective1Adapter = ApplySubjectRegistrationDialog.this.getSpinnerElective1Adapter();
                        int count = spinnerElective1Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerElective1Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerElective1Adapter();
                            String name = spinnerElective1Adapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.elective1;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding34 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding34 != null && (spinner28 = dialogApplySubjectRegistrationBinding34.spinnerElective1) != null) {
                                    spinner28.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerElective1Adapter3 = applySubjectRegistrationDialog.getSpinnerElective1Adapter();
                                applySubjectRegistrationDialog.elective1 = String.valueOf(spinnerElective1Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerElective1Adapter4 = applySubjectRegistrationDialog2.getSpinnerElective1Adapter();
                        valueOf = String.valueOf(spinnerElective1Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.elective1 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding34 = get_binding();
        Spinner spinner28 = dialogApplySubjectRegistrationBinding34 != null ? dialogApplySubjectRegistrationBinding34.spinnerElective2 : null;
        if (spinner28 != null) {
            spinner28.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$7
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective2Adapter;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective2Adapter2;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective2Adapter3;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding35;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective2Adapter4;
                    Spinner spinner29;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective2Adapter5;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagElective2;
                    if (!z) {
                        str2 = ApplySubjectRegistrationDialog.this.elective2;
                        System.out.println((Object) str2);
                        spinnerElective2Adapter = ApplySubjectRegistrationDialog.this.getSpinnerElective2Adapter();
                        System.out.println((Object) spinnerElective2Adapter.getSemester(1).getName());
                        str3 = ApplySubjectRegistrationDialog.this.elective2;
                        System.out.println((Object) str3);
                        ApplySubjectRegistrationDialog.this.flagElective2 = true;
                        spinnerElective2Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerElective2Adapter();
                        int count = spinnerElective2Adapter2.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerElective2Adapter3 = ApplySubjectRegistrationDialog.this.getSpinnerElective2Adapter();
                            String name = spinnerElective2Adapter3.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.elective2;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding35 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding35 != null && (spinner29 = dialogApplySubjectRegistrationBinding35.spinnerElective2) != null) {
                                    spinner29.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerElective2Adapter4 = applySubjectRegistrationDialog.getSpinnerElective2Adapter();
                                applySubjectRegistrationDialog.elective2 = String.valueOf(spinnerElective2Adapter4.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerElective2Adapter5 = applySubjectRegistrationDialog2.getSpinnerElective2Adapter();
                        valueOf = String.valueOf(spinnerElective2Adapter5.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.elective2 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding35 = get_binding();
        Spinner spinner29 = dialogApplySubjectRegistrationBinding35 != null ? dialogApplySubjectRegistrationBinding35.spinnerElective3 : null;
        if (spinner29 != null) {
            spinner29.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$8
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective3Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective3Adapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding36;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective3Adapter3;
                    Spinner spinner30;
                    ApplySubjectRegistrationSpinnerAdapter spinnerElective3Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagElective3;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagElective3 = true;
                        spinnerElective3Adapter = ApplySubjectRegistrationDialog.this.getSpinnerElective3Adapter();
                        int count = spinnerElective3Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerElective3Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerElective3Adapter();
                            String name = spinnerElective3Adapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.elective3;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding36 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding36 != null && (spinner30 = dialogApplySubjectRegistrationBinding36.spinnerElective3) != null) {
                                    spinner30.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerElective3Adapter3 = applySubjectRegistrationDialog.getSpinnerElective3Adapter();
                                applySubjectRegistrationDialog.elective3 = String.valueOf(spinnerElective3Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerElective3Adapter4 = applySubjectRegistrationDialog2.getSpinnerElective3Adapter();
                        valueOf = String.valueOf(spinnerElective3Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.elective3 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding36 = get_binding();
        Spinner spinner30 = dialogApplySubjectRegistrationBinding36 != null ? dialogApplySubjectRegistrationBinding36.spinnerGlobalElective : null;
        if (spinner30 != null) {
            spinner30.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$9
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerGlobalElectiveAdapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerGlobalElectiveAdapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding37;
                    ApplySubjectRegistrationSpinnerAdapter spinnerGlobalElectiveAdapter3;
                    Spinner spinner31;
                    ApplySubjectRegistrationSpinnerAdapter spinnerGlobalElectiveAdapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagGlobalElective;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagGlobalElective = true;
                        spinnerGlobalElectiveAdapter = ApplySubjectRegistrationDialog.this.getSpinnerGlobalElectiveAdapter();
                        int count = spinnerGlobalElectiveAdapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerGlobalElectiveAdapter2 = ApplySubjectRegistrationDialog.this.getSpinnerGlobalElectiveAdapter();
                            String name = spinnerGlobalElectiveAdapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.globalElective;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding37 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding37 != null && (spinner31 = dialogApplySubjectRegistrationBinding37.spinnerGlobalElective) != null) {
                                    spinner31.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerGlobalElectiveAdapter3 = applySubjectRegistrationDialog.getSpinnerGlobalElectiveAdapter();
                                applySubjectRegistrationDialog.globalElective = String.valueOf(spinnerGlobalElectiveAdapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerGlobalElectiveAdapter4 = applySubjectRegistrationDialog2.getSpinnerGlobalElectiveAdapter();
                        valueOf = String.valueOf(spinnerGlobalElectiveAdapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.globalElective = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding37 = get_binding();
        Spinner spinner31 = dialogApplySubjectRegistrationBinding37 != null ? dialogApplySubjectRegistrationBinding37.spinnerAdditionalElective1 : null;
        if (spinner31 != null) {
            spinner31.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$10
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective1Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective1Adapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding38;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective1Adapter3;
                    Spinner spinner32;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective1Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagAdditionalElective1;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagAdditionalElective1 = true;
                        spinnerAdditionalElective1Adapter = ApplySubjectRegistrationDialog.this.getSpinnerAdditionalElective1Adapter();
                        int count = spinnerAdditionalElective1Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerAdditionalElective1Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAdditionalElective1Adapter();
                            String name = spinnerAdditionalElective1Adapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.additionalElective1;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding38 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding38 != null && (spinner32 = dialogApplySubjectRegistrationBinding38.spinnerAdditionalElective1) != null) {
                                    spinner32.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAdditionalElective1Adapter3 = applySubjectRegistrationDialog.getSpinnerAdditionalElective1Adapter();
                                applySubjectRegistrationDialog.additionalElective1 = String.valueOf(spinnerAdditionalElective1Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerAdditionalElective1Adapter4 = applySubjectRegistrationDialog2.getSpinnerAdditionalElective1Adapter();
                        valueOf = String.valueOf(spinnerAdditionalElective1Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.additionalElective1 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding38 = get_binding();
        Spinner spinner32 = dialogApplySubjectRegistrationBinding38 != null ? dialogApplySubjectRegistrationBinding38.spinnerAdditionalElective2 : null;
        if (spinner32 != null) {
            spinner32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$11
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective2Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective2Adapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding39;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective2Adapter3;
                    Spinner spinner33;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective2Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagAdditionalElective2;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagAdditionalElective2 = true;
                        spinnerAdditionalElective2Adapter = ApplySubjectRegistrationDialog.this.getSpinnerAdditionalElective2Adapter();
                        int count = spinnerAdditionalElective2Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerAdditionalElective2Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAdditionalElective2Adapter();
                            String name = spinnerAdditionalElective2Adapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.additionalElective2;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding39 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding39 != null && (spinner33 = dialogApplySubjectRegistrationBinding39.spinnerAdditionalElective2) != null) {
                                    spinner33.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAdditionalElective2Adapter3 = applySubjectRegistrationDialog.getSpinnerAdditionalElective2Adapter();
                                applySubjectRegistrationDialog.additionalElective2 = String.valueOf(spinnerAdditionalElective2Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerAdditionalElective2Adapter4 = applySubjectRegistrationDialog2.getSpinnerAdditionalElective2Adapter();
                        valueOf = String.valueOf(spinnerAdditionalElective2Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.additionalElective2 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding39 = get_binding();
        Spinner spinner33 = dialogApplySubjectRegistrationBinding39 != null ? dialogApplySubjectRegistrationBinding39.spinnerAdditionalElective3 : null;
        if (spinner33 != null) {
            spinner33.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$12
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective3Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective3Adapter2;
                    String str2;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding40;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective3Adapter3;
                    Spinner spinner34;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective3Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagAdditionalElective3;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagAdditionalElective3 = true;
                        spinnerAdditionalElective3Adapter = ApplySubjectRegistrationDialog.this.getSpinnerAdditionalElective3Adapter();
                        int count = spinnerAdditionalElective3Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerAdditionalElective3Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAdditionalElective3Adapter();
                            String name = spinnerAdditionalElective3Adapter2.getSemester(i).getName();
                            str2 = ApplySubjectRegistrationDialog.this.additionalElective3;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding40 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding40 != null && (spinner34 = dialogApplySubjectRegistrationBinding40.spinnerAdditionalElective3) != null) {
                                    spinner34.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAdditionalElective3Adapter3 = applySubjectRegistrationDialog.getSpinnerAdditionalElective3Adapter();
                                applySubjectRegistrationDialog.additionalElective3 = String.valueOf(spinnerAdditionalElective3Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerAdditionalElective3Adapter4 = applySubjectRegistrationDialog2.getSpinnerAdditionalElective3Adapter();
                        valueOf = String.valueOf(spinnerAdditionalElective3Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.additionalElective3 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding40 = get_binding();
        Spinner spinner34 = dialogApplySubjectRegistrationBinding40 != null ? dialogApplySubjectRegistrationBinding40.spinnerMdc1 : null;
        if (spinner34 != null) {
            spinner34.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$13
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc1Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc1Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding41;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc1Adapter3;
                    Spinner spinner35;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc1Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagMdc1;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagMdc1 = true;
                        str2 = ApplySubjectRegistrationDialog.this.mdc1;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.mdc1;
                        System.out.println((Object) str3);
                        spinnerMdc1Adapter = ApplySubjectRegistrationDialog.this.getSpinnerMdc1Adapter();
                        int count = spinnerMdc1Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerMdc1Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerMdc1Adapter();
                            String name = spinnerMdc1Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.mdc1;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding41 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding41 != null && (spinner35 = dialogApplySubjectRegistrationBinding41.spinnerMdc1) != null) {
                                    spinner35.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerMdc1Adapter3 = applySubjectRegistrationDialog.getSpinnerMdc1Adapter();
                                applySubjectRegistrationDialog.mdc1 = String.valueOf(spinnerMdc1Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerMdc1Adapter4 = applySubjectRegistrationDialog2.getSpinnerMdc1Adapter();
                        valueOf = String.valueOf(spinnerMdc1Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.mdc1 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding41 = get_binding();
        Spinner spinner35 = dialogApplySubjectRegistrationBinding41 != null ? dialogApplySubjectRegistrationBinding41.spinnerMdc2 : null;
        if (spinner35 != null) {
            spinner35.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$14
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc2Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc2Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding42;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc2Adapter3;
                    Spinner spinner36;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc2Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagMdc2;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagMdc2 = true;
                        str2 = ApplySubjectRegistrationDialog.this.mdc2;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.mdc2;
                        System.out.println((Object) str3);
                        spinnerMdc2Adapter = ApplySubjectRegistrationDialog.this.getSpinnerMdc2Adapter();
                        int count = spinnerMdc2Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerMdc2Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerMdc2Adapter();
                            String name = spinnerMdc2Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.mdc2;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding42 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding42 != null && (spinner36 = dialogApplySubjectRegistrationBinding42.spinnerMdc2) != null) {
                                    spinner36.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerMdc2Adapter3 = applySubjectRegistrationDialog.getSpinnerMdc2Adapter();
                                applySubjectRegistrationDialog.mdc2 = String.valueOf(spinnerMdc2Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerMdc2Adapter4 = applySubjectRegistrationDialog2.getSpinnerMdc2Adapter();
                        valueOf = String.valueOf(spinnerMdc2Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.mdc2 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding42 = get_binding();
        Spinner spinner36 = dialogApplySubjectRegistrationBinding42 != null ? dialogApplySubjectRegistrationBinding42.spinnerMdc3 : null;
        if (spinner36 != null) {
            spinner36.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$15
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc3Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc3Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding43;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc3Adapter3;
                    Spinner spinner37;
                    ApplySubjectRegistrationSpinnerAdapter spinnerMdc3Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagMdc3;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagMdc3 = true;
                        str2 = ApplySubjectRegistrationDialog.this.mdc3;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.mdc3;
                        System.out.println((Object) str3);
                        spinnerMdc3Adapter = ApplySubjectRegistrationDialog.this.getSpinnerMdc3Adapter();
                        int count = spinnerMdc3Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerMdc3Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerMdc3Adapter();
                            String name = spinnerMdc3Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.mdc3;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding43 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding43 != null && (spinner37 = dialogApplySubjectRegistrationBinding43.spinnerMdc3) != null) {
                                    spinner37.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerMdc3Adapter3 = applySubjectRegistrationDialog.getSpinnerMdc3Adapter();
                                applySubjectRegistrationDialog.mdc3 = String.valueOf(spinnerMdc3Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerMdc3Adapter4 = applySubjectRegistrationDialog2.getSpinnerMdc3Adapter();
                        valueOf = String.valueOf(spinnerMdc3Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.mdc3 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding43 = get_binding();
        Spinner spinner37 = dialogApplySubjectRegistrationBinding43 != null ? dialogApplySubjectRegistrationBinding43.spinnerDsc1 : null;
        if (spinner37 != null) {
            spinner37.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$16
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc1Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc1Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding44;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc1Adapter3;
                    Spinner spinner38;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc1Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagDsc1;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagDsc1 = true;
                        str2 = ApplySubjectRegistrationDialog.this.dsc1;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.dsc1;
                        System.out.println((Object) str3);
                        spinnerDsc1Adapter = ApplySubjectRegistrationDialog.this.getSpinnerDsc1Adapter();
                        int count = spinnerDsc1Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerDsc1Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerDsc1Adapter();
                            String name = spinnerDsc1Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.dsc1;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding44 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding44 != null && (spinner38 = dialogApplySubjectRegistrationBinding44.spinnerDsc1) != null) {
                                    spinner38.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerDsc1Adapter3 = applySubjectRegistrationDialog.getSpinnerDsc1Adapter();
                                applySubjectRegistrationDialog.dsc1 = String.valueOf(spinnerDsc1Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerDsc1Adapter4 = applySubjectRegistrationDialog2.getSpinnerDsc1Adapter();
                        valueOf = String.valueOf(spinnerDsc1Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.dsc1 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding44 = get_binding();
        Spinner spinner38 = dialogApplySubjectRegistrationBinding44 != null ? dialogApplySubjectRegistrationBinding44.spinnerDsc2 : null;
        if (spinner38 != null) {
            spinner38.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$17
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc2Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc2Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding45;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc2Adapter3;
                    Spinner spinner39;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc2Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagDsc2;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagDsc2 = true;
                        str2 = ApplySubjectRegistrationDialog.this.dsc2;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.dsc2;
                        System.out.println((Object) str3);
                        spinnerDsc2Adapter = ApplySubjectRegistrationDialog.this.getSpinnerDsc2Adapter();
                        int count = spinnerDsc2Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerDsc2Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerDsc2Adapter();
                            String name = spinnerDsc2Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.dsc2;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding45 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding45 != null && (spinner39 = dialogApplySubjectRegistrationBinding45.spinnerDsc2) != null) {
                                    spinner39.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerDsc2Adapter3 = applySubjectRegistrationDialog.getSpinnerDsc2Adapter();
                                applySubjectRegistrationDialog.dsc2 = String.valueOf(spinnerDsc2Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerDsc2Adapter4 = applySubjectRegistrationDialog2.getSpinnerDsc2Adapter();
                        valueOf = String.valueOf(spinnerDsc2Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.dsc2 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding45 = get_binding();
        Spinner spinner39 = dialogApplySubjectRegistrationBinding45 != null ? dialogApplySubjectRegistrationBinding45.spinnerDsc3 : null;
        if (spinner39 != null) {
            spinner39.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$18
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc3Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc3Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding46;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc3Adapter3;
                    Spinner spinner40;
                    ApplySubjectRegistrationSpinnerAdapter spinnerDsc3Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagDsc3;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagDsc3 = true;
                        str2 = ApplySubjectRegistrationDialog.this.dsc3;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.dsc3;
                        System.out.println((Object) str3);
                        spinnerDsc3Adapter = ApplySubjectRegistrationDialog.this.getSpinnerDsc3Adapter();
                        int count = spinnerDsc3Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerDsc3Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerDsc3Adapter();
                            String name = spinnerDsc3Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.dsc3;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding46 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding46 != null && (spinner40 = dialogApplySubjectRegistrationBinding46.spinnerDsc3) != null) {
                                    spinner40.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerDsc3Adapter3 = applySubjectRegistrationDialog.getSpinnerDsc3Adapter();
                                applySubjectRegistrationDialog.dsc3 = String.valueOf(spinnerDsc3Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerDsc3Adapter4 = applySubjectRegistrationDialog2.getSpinnerDsc3Adapter();
                        valueOf = String.valueOf(spinnerDsc3Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.dsc3 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding46 = get_binding();
        Spinner spinner40 = dialogApplySubjectRegistrationBinding46 != null ? dialogApplySubjectRegistrationBinding46.spinnerAec1 : null;
        if (spinner40 != null) {
            spinner40.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$19
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec1Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec1Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding47;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec1Adapter3;
                    Spinner spinner41;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec1Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagAec1;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagAec1 = true;
                        str2 = ApplySubjectRegistrationDialog.this.aec1;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.aec1;
                        System.out.println((Object) str3);
                        spinnerAec1Adapter = ApplySubjectRegistrationDialog.this.getSpinnerAec1Adapter();
                        int count = spinnerAec1Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerAec1Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAec1Adapter();
                            String name = spinnerAec1Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.aec1;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding47 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding47 != null && (spinner41 = dialogApplySubjectRegistrationBinding47.spinnerAec1) != null) {
                                    spinner41.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAec1Adapter3 = applySubjectRegistrationDialog.getSpinnerAec1Adapter();
                                applySubjectRegistrationDialog.aec1 = String.valueOf(spinnerAec1Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerAec1Adapter4 = applySubjectRegistrationDialog2.getSpinnerAec1Adapter();
                        valueOf = String.valueOf(spinnerAec1Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.aec1 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding47 = get_binding();
        Spinner spinner41 = dialogApplySubjectRegistrationBinding47 != null ? dialogApplySubjectRegistrationBinding47.spinnerAec2 : null;
        if (spinner41 != null) {
            spinner41.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$20
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec2Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec2Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding48;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec2Adapter3;
                    Spinner spinner42;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec2Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagAec2;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagAec2 = true;
                        str2 = ApplySubjectRegistrationDialog.this.aec2;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.aec2;
                        System.out.println((Object) str3);
                        spinnerAec2Adapter = ApplySubjectRegistrationDialog.this.getSpinnerAec2Adapter();
                        int count = spinnerAec2Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerAec2Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAec2Adapter();
                            String name = spinnerAec2Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.aec2;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding48 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding48 != null && (spinner42 = dialogApplySubjectRegistrationBinding48.spinnerAec2) != null) {
                                    spinner42.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAec2Adapter3 = applySubjectRegistrationDialog.getSpinnerAec2Adapter();
                                applySubjectRegistrationDialog.aec2 = String.valueOf(spinnerAec2Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerAec2Adapter4 = applySubjectRegistrationDialog2.getSpinnerAec2Adapter();
                        valueOf = String.valueOf(spinnerAec2Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.aec2 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding48 = get_binding();
        Spinner spinner42 = dialogApplySubjectRegistrationBinding48 != null ? dialogApplySubjectRegistrationBinding48.spinnerAec3 : null;
        if (spinner42 != null) {
            spinner42.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$setUp$21
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    String str2;
                    String str3;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec3Adapter;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec3Adapter2;
                    String str4;
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding49;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec3Adapter3;
                    Spinner spinner43;
                    ApplySubjectRegistrationSpinnerAdapter spinnerAec3Adapter4;
                    String valueOf;
                    z = ApplySubjectRegistrationDialog.this.flagAec3;
                    if (!z) {
                        ApplySubjectRegistrationDialog.this.flagAec3 = true;
                        str2 = ApplySubjectRegistrationDialog.this.aec3;
                        System.out.println((Object) str2);
                        str3 = ApplySubjectRegistrationDialog.this.aec3;
                        System.out.println((Object) str3);
                        spinnerAec3Adapter = ApplySubjectRegistrationDialog.this.getSpinnerAec3Adapter();
                        int count = spinnerAec3Adapter.getCount();
                        for (int i = 0; i < count; i++) {
                            spinnerAec3Adapter2 = ApplySubjectRegistrationDialog.this.getSpinnerAec3Adapter();
                            String name = spinnerAec3Adapter2.getSemester(i).getName();
                            str4 = ApplySubjectRegistrationDialog.this.aec3;
                            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                                dialogApplySubjectRegistrationBinding49 = ApplySubjectRegistrationDialog.this.get_binding();
                                if (dialogApplySubjectRegistrationBinding49 != null && (spinner43 = dialogApplySubjectRegistrationBinding49.spinnerAec3) != null) {
                                    spinner43.setSelection(i);
                                }
                                ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                                spinnerAec3Adapter3 = applySubjectRegistrationDialog.getSpinnerAec3Adapter();
                                applySubjectRegistrationDialog.aec3 = String.valueOf(spinnerAec3Adapter3.getSemester(position).getId());
                                return;
                            }
                        }
                        return;
                    }
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog2 = ApplySubjectRegistrationDialog.this;
                    if (position == 0) {
                        valueOf = "00000";
                    } else {
                        spinnerAec3Adapter4 = applySubjectRegistrationDialog2.getSpinnerAec3Adapter();
                        valueOf = String.valueOf(spinnerAec3Adapter4.getSemester(position).getId());
                    }
                    applySubjectRegistrationDialog2.aec3 = valueOf;
                }
            });
        }
        DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding49 = get_binding();
        if (dialogApplySubjectRegistrationBinding49 == null || (textView = dialogApplySubjectRegistrationBinding49.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplySubjectRegistrationDialog.setUp$lambda$1(ApplySubjectRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ApplySubjectRegistrationDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        System.out.println((Object) this$0.minor);
        System.out.println((Object) this$0.minor);
        HashMap hashMap = new HashMap();
        hashMap.clear();
        if (!Intrinsics.areEqual(this$0.id, "")) {
            String str = this$0.id;
            Intrinsics.checkNotNull(str);
            hashMap.put("id", str);
        } else {
            hashMap.put("sem_id", this$0.semId);
        }
        HashMap hashMap2 = hashMap;
        hashMap2.put("register", "1");
        if (!Intrinsics.areEqual(this$0.minor, "00000")) {
            hashMap2.put("subject[minor][1]", this$0.minor);
        }
        if (!Intrinsics.areEqual(this$0.minor2, "00000")) {
            hashMap2.put("subject[minor][2]", this$0.minor2);
        }
        if (!Intrinsics.areEqual(this$0.minor3, "00000")) {
            hashMap2.put("subject[minor][3]", this$0.minor3);
        }
        if (!Intrinsics.areEqual(this$0.mdc1, "00000")) {
            hashMap2.put("subject[mdc][1]", this$0.mdc1);
        }
        if (!Intrinsics.areEqual(this$0.mdc2, "00000")) {
            hashMap2.put("subject[mdc][2]", this$0.mdc2);
        }
        if (!Intrinsics.areEqual(this$0.mdc3, "00000")) {
            hashMap2.put("subject[mdc][3]", this$0.mdc3);
        }
        if (!Intrinsics.areEqual(this$0.aec1, "00000")) {
            hashMap2.put("subject[aec][1]", this$0.aec1);
        }
        if (!Intrinsics.areEqual(this$0.aec2, "00000")) {
            hashMap2.put("subject[aec][2]", this$0.aec2);
        }
        if (!Intrinsics.areEqual(this$0.aec3, "00000")) {
            hashMap2.put("subject[aec][3]", this$0.aec3);
        }
        if (!Intrinsics.areEqual(this$0.dsc1, "00000")) {
            hashMap2.put("subject[dsc][1]", this$0.dsc1);
        }
        if (!Intrinsics.areEqual(this$0.dsc2, "00000")) {
            hashMap2.put("subject[dsc][2]", this$0.dsc2);
        }
        if (!Intrinsics.areEqual(this$0.dsc3, "00000")) {
            hashMap2.put("subject[dsc][3]", this$0.dsc3);
        }
        if (!Intrinsics.areEqual(this$0.honour, "00000")) {
            hashMap2.put("subject[honour][1]", this$0.honour);
        }
        if (!Intrinsics.areEqual(this$0.elective1, "00000")) {
            hashMap2.put("subject[elective][1]", this$0.elective1);
        }
        if (!Intrinsics.areEqual(this$0.elective2, "00000")) {
            hashMap2.put("subject[elective][2]", this$0.elective2);
        }
        if (!Intrinsics.areEqual(this$0.elective3, "00000")) {
            hashMap2.put("subject[elective][3]", this$0.elective3);
        }
        if (!Intrinsics.areEqual(this$0.globalElective, "00000")) {
            hashMap2.put("subject[globalelective][1]", this$0.globalElective);
        }
        if (!Intrinsics.areEqual(this$0.additionalElective1, "00000")) {
            hashMap2.put("subject[additionalelective][1]", this$0.additionalElective1);
        }
        if (!Intrinsics.areEqual(this$0.additionalElective2, "00000")) {
            hashMap2.put("subject[additionalelective][2]", this$0.additionalElective2);
        }
        if (!Intrinsics.areEqual(this$0.additionalElective3, "00000")) {
            hashMap2.put("subject[additionalelective][3]", this$0.additionalElective3);
        }
        System.out.println(hashMap);
        System.out.println(hashMap);
        if (!Intrinsics.areEqual(this$0.id, "")) {
            this$0.getApplySubjectRegistrationViewModel().getUpdateData(hashMap2);
            return;
        }
        System.out.println((Object) ("minor 1: " + this$0.minor));
        System.out.println((Object) ("honour 1: " + this$0.honour));
        System.out.println((Object) ("elective2 1: " + this$0.elective2));
        System.out.println((Object) ("globalElective 1: " + this$0.globalElective));
        System.out.println((Object) ("additionalElective2 1: " + this$0.additionalElective2));
        System.out.println((Object) this$0.honour);
        System.out.println((Object) this$0.elective2);
        System.out.println((Object) this$0.globalElective);
        System.out.println((Object) this$0.additionalElective2);
        if (Intrinsics.areEqual(this$0.honour, "00000") && Intrinsics.areEqual(this$0.minor, "00000") && Intrinsics.areEqual(this$0.minor2, "00000") && Intrinsics.areEqual(this$0.minor3, "00000") && Intrinsics.areEqual(this$0.elective1, "00000") && Intrinsics.areEqual(this$0.elective2, "00000") && Intrinsics.areEqual(this$0.elective3, "00000") && Intrinsics.areEqual(this$0.globalElective, "00000") && Intrinsics.areEqual(this$0.additionalElective1, "00000") && Intrinsics.areEqual(this$0.additionalElective2, "00000") && Intrinsics.areEqual(this$0.additionalElective3, "00000") && Intrinsics.areEqual(this$0.mdc1, "00000") && Intrinsics.areEqual(this$0.mdc2, "00000") && Intrinsics.areEqual(this$0.mdc3, "00000") && Intrinsics.areEqual(this$0.aec1, "00000") && Intrinsics.areEqual(this$0.aec2, "00000") && Intrinsics.areEqual(this$0.aec3, "00000") && Intrinsics.areEqual(this$0.dsc1, "00000") && Intrinsics.areEqual(this$0.dsc2, "00000") && Intrinsics.areEqual(this$0.dsc3, "00000")) {
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding = this$0.get_binding();
            if (dialogApplySubjectRegistrationBinding == null || (textView = dialogApplySubjectRegistrationBinding.registerBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Please choose at-least one subject before registering.");
            return;
        }
        System.out.println((Object) ("minor 1: " + this$0.minor));
        System.out.println((Object) ("honour 1: " + this$0.honour));
        System.out.println((Object) ("elective2 1: " + this$0.elective2));
        System.out.println((Object) ("globalElective 1: " + this$0.globalElective));
        System.out.println((Object) ("additionalElective2 1: " + this$0.additionalElective2));
        this$0.getApplySubjectRegistrationViewModel().getRegisterData(hashMap2);
    }

    private final void listenResponse() {
        getApplySubjectRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new ApplySubjectRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewSubjectRegistrationResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$listenResponse$1

            /* compiled from: ApplySubjectRegistrationDialog.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewSubjectRegistrationResponse> resource) {
                invoke2((Resource<ViewSubjectRegistrationResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewSubjectRegistrationResponse> resource) {
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding3;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding4;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding5;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding6;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding7;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding8;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding9;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding10;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding11;
                LinearLayout linearLayout;
                String str;
                String str2;
                ApplySubjectRegistrationViewModel applySubjectRegistrationViewModel;
                String str3;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding12;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding13;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding14;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding15;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding16;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding17;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding18;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding19;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding20;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding21;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding22;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ApplySubjectRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ApplySubjectRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ApplySubjectRegistrationDialog.this.hideProgress();
                    dialogApplySubjectRegistrationBinding22 = ApplySubjectRegistrationDialog.this.get_binding();
                    if (dialogApplySubjectRegistrationBinding22 == null || (textView = dialogApplySubjectRegistrationBinding22.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ApplySubjectRegistrationDialog.this.hideProgress();
                ViewSubjectRegistrationResponse data = resource.getData();
                if (data != null) {
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                    applySubjectRegistrationDialog.semId = data.getSem_id();
                    dialogApplySubjectRegistrationBinding = applySubjectRegistrationDialog.get_binding();
                    TextView textView2 = dialogApplySubjectRegistrationBinding != null ? dialogApplySubjectRegistrationBinding.semesterTv : null;
                    if (textView2 != null) {
                        textView2.setText(data.getSemester());
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding21 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout2 = dialogApplySubjectRegistrationBinding21 != null ? dialogApplySubjectRegistrationBinding21.minorLyt : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.minor = "";
                    } else {
                        dialogApplySubjectRegistrationBinding2 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout3 = dialogApplySubjectRegistrationBinding2 != null ? dialogApplySubjectRegistrationBinding2.minorLyt : null;
                        if (linearLayout3 != null) {
                            linearLayout3.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding20 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout4 = dialogApplySubjectRegistrationBinding20 != null ? dialogApplySubjectRegistrationBinding20.minor2Lyt : null;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.minor2 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding3 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout5 = dialogApplySubjectRegistrationBinding3 != null ? dialogApplySubjectRegistrationBinding3.minor2Lyt : null;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding19 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout6 = dialogApplySubjectRegistrationBinding19 != null ? dialogApplySubjectRegistrationBinding19.minor3Lyt : null;
                        if (linearLayout6 != null) {
                            linearLayout6.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.minor3 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding4 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout7 = dialogApplySubjectRegistrationBinding4 != null ? dialogApplySubjectRegistrationBinding4.minor3Lyt : null;
                        if (linearLayout7 != null) {
                            linearLayout7.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding18 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout8 = dialogApplySubjectRegistrationBinding18 != null ? dialogApplySubjectRegistrationBinding18.elective1Lyt : null;
                        if (linearLayout8 != null) {
                            linearLayout8.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.elective1 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding5 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout9 = dialogApplySubjectRegistrationBinding5 != null ? dialogApplySubjectRegistrationBinding5.elective1Lyt : null;
                        if (linearLayout9 != null) {
                            linearLayout9.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding17 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout10 = dialogApplySubjectRegistrationBinding17 != null ? dialogApplySubjectRegistrationBinding17.elective2Lyt : null;
                        if (linearLayout10 != null) {
                            linearLayout10.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.elective2 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding6 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout11 = dialogApplySubjectRegistrationBinding6 != null ? dialogApplySubjectRegistrationBinding6.elective2Lyt : null;
                        if (linearLayout11 != null) {
                            linearLayout11.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding16 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout12 = dialogApplySubjectRegistrationBinding16 != null ? dialogApplySubjectRegistrationBinding16.elective1Lyt : null;
                        if (linearLayout12 != null) {
                            linearLayout12.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.elective1 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding7 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout13 = dialogApplySubjectRegistrationBinding7 != null ? dialogApplySubjectRegistrationBinding7.elective1Lyt : null;
                        if (linearLayout13 != null) {
                            linearLayout13.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding15 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout14 = dialogApplySubjectRegistrationBinding15 != null ? dialogApplySubjectRegistrationBinding15.elective2Lyt : null;
                        if (linearLayout14 != null) {
                            linearLayout14.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.elective2 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding8 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout15 = dialogApplySubjectRegistrationBinding8 != null ? dialogApplySubjectRegistrationBinding8.elective2Lyt : null;
                        if (linearLayout15 != null) {
                            linearLayout15.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding14 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout16 = dialogApplySubjectRegistrationBinding14 != null ? dialogApplySubjectRegistrationBinding14.additionalElective1Lyt : null;
                        if (linearLayout16 != null) {
                            linearLayout16.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.additionalElective1 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding9 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout17 = dialogApplySubjectRegistrationBinding9 != null ? dialogApplySubjectRegistrationBinding9.additionalElective1Lyt : null;
                        if (linearLayout17 != null) {
                            linearLayout17.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding13 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout18 = dialogApplySubjectRegistrationBinding13 != null ? dialogApplySubjectRegistrationBinding13.additionalElective2Lyt : null;
                        if (linearLayout18 != null) {
                            linearLayout18.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.additionalElective2 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding10 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout19 = dialogApplySubjectRegistrationBinding10 != null ? dialogApplySubjectRegistrationBinding10.additionalElective2Lyt : null;
                        if (linearLayout19 != null) {
                            linearLayout19.setVisibility(8);
                        }
                    }
                    if (!Intrinsics.areEqual("", "")) {
                        dialogApplySubjectRegistrationBinding12 = applySubjectRegistrationDialog.get_binding();
                        linearLayout = dialogApplySubjectRegistrationBinding12 != null ? dialogApplySubjectRegistrationBinding12.additionalElective3Lyt : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                        applySubjectRegistrationDialog.additionalElective3 = "";
                    } else {
                        dialogApplySubjectRegistrationBinding11 = applySubjectRegistrationDialog.get_binding();
                        linearLayout = dialogApplySubjectRegistrationBinding11 != null ? dialogApplySubjectRegistrationBinding11.additionalElective3Lyt : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    }
                    str = applySubjectRegistrationDialog.elective1;
                    System.out.println((Object) str);
                    str2 = applySubjectRegistrationDialog.elective1;
                    System.out.println((Object) str2);
                    applySubjectRegistrationViewModel = applySubjectRegistrationDialog.getApplySubjectRegistrationViewModel();
                    str3 = applySubjectRegistrationDialog.semId;
                    applySubjectRegistrationViewModel.getSpinnerData(str3);
                }
            }
        }));
    }

    private final void listenSemResponse() {
        getApplySubjectRegistrationViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplySubjectRegistrationDialog.listenSemResponse$lambda$3(ApplySubjectRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(ApplySubjectRegistrationDialog this$0, Resource resource) {
        Spinner spinner;
        Spinner spinner2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding = this$0.get_binding();
            if (dialogApplySubjectRegistrationBinding == null || (spinner2 = dialogApplySubjectRegistrationBinding.spinnerSemesterLastAttended) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(spinner2, message);
            return;
        }
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            int count = this$0.getSpinnerAdapter().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                    DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2 = this$0.get_binding();
                    if (dialogApplySubjectRegistrationBinding2 == null || (spinner = dialogApplySubjectRegistrationBinding2.spinnerSemesterLastAttended) == null) {
                        return;
                    }
                    spinner.setSelection(i2);
                    return;
                }
            }
        }
    }

    private final void listenSpinnerResponse() {
        getApplySubjectRegistrationViewModel().getSpinnerResponse().observe(getViewLifecycleOwner(), new ApplySubjectRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SubjectSpinnerResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$listenSpinnerResponse$1

            /* compiled from: ApplySubjectRegistrationDialog.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SubjectSpinnerResponse> resource) {
                invoke2((Resource<SubjectSpinnerResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SubjectSpinnerResponse> resource) {
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding3;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding4;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding5;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding6;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding7;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding8;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding9;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding10;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding11;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding12;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding13;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding14;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding15;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding16;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding17;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding18;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding19;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding20;
                ApplySubjectRegistrationSpinnerAdapter spinnerHonourAdapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerGlobalElectiveAdapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerDsc3Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerDsc2Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerDsc1Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerAec3Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerAec2Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerAec1Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerMdc3Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerMdc2Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerMdc1Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective3Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective2Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerAdditionalElective1Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerElective3Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerElective2Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerElective1Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerMinor3Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerMinor2Adapter;
                ApplySubjectRegistrationSpinnerAdapter spinnerMinor1Adapter;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding21;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding22;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding23;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding24;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding25;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding26;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding27;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding28;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding29;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding30;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding31;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding32;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding33;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding34;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding35;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding36;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding37;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding38;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding39;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding40;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding41;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding42;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding43;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding44;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding45;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding46;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding47;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding48;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding49;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding50;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding51;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding52;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding53;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding54;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding55;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding56;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding57;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding58;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding59;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ApplySubjectRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ApplySubjectRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ApplySubjectRegistrationDialog.this.hideProgress();
                    dialogApplySubjectRegistrationBinding59 = ApplySubjectRegistrationDialog.this.get_binding();
                    if (dialogApplySubjectRegistrationBinding59 == null || (textView = dialogApplySubjectRegistrationBinding59.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ApplySubjectRegistrationDialog.this.hideProgress();
                SubjectSpinnerResponse data = resource.getData();
                if (data != null) {
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                    if (data.getHonour().size() == 0) {
                        dialogApplySubjectRegistrationBinding58 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout = dialogApplySubjectRegistrationBinding58 != null ? dialogApplySubjectRegistrationBinding58.honourLyt : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        dialogApplySubjectRegistrationBinding = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout2 = dialogApplySubjectRegistrationBinding != null ? dialogApplySubjectRegistrationBinding.honourLyt : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(0);
                        }
                    }
                    try {
                        if (data.getMinor_1().size() == 0) {
                            dialogApplySubjectRegistrationBinding57 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout3 = dialogApplySubjectRegistrationBinding57 != null ? dialogApplySubjectRegistrationBinding57.minorLyt : null;
                            if (linearLayout3 != null) {
                                linearLayout3.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding56 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout4 = dialogApplySubjectRegistrationBinding56 != null ? dialogApplySubjectRegistrationBinding56.minorLyt : null;
                            if (linearLayout4 != null) {
                                linearLayout4.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused) {
                        dialogApplySubjectRegistrationBinding2 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout5 = dialogApplySubjectRegistrationBinding2 != null ? dialogApplySubjectRegistrationBinding2.minorLyt : null;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getMinor_2().size() == 0) {
                            dialogApplySubjectRegistrationBinding55 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout6 = dialogApplySubjectRegistrationBinding55 != null ? dialogApplySubjectRegistrationBinding55.minor2Lyt : null;
                            if (linearLayout6 != null) {
                                linearLayout6.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding54 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout7 = dialogApplySubjectRegistrationBinding54 != null ? dialogApplySubjectRegistrationBinding54.minor2Lyt : null;
                            if (linearLayout7 != null) {
                                linearLayout7.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused2) {
                        dialogApplySubjectRegistrationBinding3 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout8 = dialogApplySubjectRegistrationBinding3 != null ? dialogApplySubjectRegistrationBinding3.minor2Lyt : null;
                        if (linearLayout8 != null) {
                            linearLayout8.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getMinor_3().size() == 0) {
                            dialogApplySubjectRegistrationBinding53 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout9 = dialogApplySubjectRegistrationBinding53 != null ? dialogApplySubjectRegistrationBinding53.minor3Lyt : null;
                            if (linearLayout9 != null) {
                                linearLayout9.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding52 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout10 = dialogApplySubjectRegistrationBinding52 != null ? dialogApplySubjectRegistrationBinding52.minor3Lyt : null;
                            if (linearLayout10 != null) {
                                linearLayout10.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused3) {
                        dialogApplySubjectRegistrationBinding4 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout11 = dialogApplySubjectRegistrationBinding4 != null ? dialogApplySubjectRegistrationBinding4.minor3Lyt : null;
                        if (linearLayout11 != null) {
                            linearLayout11.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getElective_1().size() == 0) {
                            dialogApplySubjectRegistrationBinding51 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout12 = dialogApplySubjectRegistrationBinding51 != null ? dialogApplySubjectRegistrationBinding51.elective1Lyt : null;
                            if (linearLayout12 != null) {
                                linearLayout12.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding50 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout13 = dialogApplySubjectRegistrationBinding50 != null ? dialogApplySubjectRegistrationBinding50.elective1Lyt : null;
                            if (linearLayout13 != null) {
                                linearLayout13.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused4) {
                        dialogApplySubjectRegistrationBinding5 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout14 = dialogApplySubjectRegistrationBinding5 != null ? dialogApplySubjectRegistrationBinding5.elective1Lyt : null;
                        if (linearLayout14 != null) {
                            linearLayout14.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getElective_2().size() == 0) {
                            dialogApplySubjectRegistrationBinding49 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout15 = dialogApplySubjectRegistrationBinding49 != null ? dialogApplySubjectRegistrationBinding49.elective2Lyt : null;
                            if (linearLayout15 != null) {
                                linearLayout15.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding48 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout16 = dialogApplySubjectRegistrationBinding48 != null ? dialogApplySubjectRegistrationBinding48.elective2Lyt : null;
                            if (linearLayout16 != null) {
                                linearLayout16.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused5) {
                        dialogApplySubjectRegistrationBinding6 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout17 = dialogApplySubjectRegistrationBinding6 != null ? dialogApplySubjectRegistrationBinding6.elective2Lyt : null;
                        if (linearLayout17 != null) {
                            linearLayout17.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getElective_3().size() == 0) {
                            dialogApplySubjectRegistrationBinding47 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout18 = dialogApplySubjectRegistrationBinding47 != null ? dialogApplySubjectRegistrationBinding47.elective3Lyt : null;
                            if (linearLayout18 != null) {
                                linearLayout18.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding46 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout19 = dialogApplySubjectRegistrationBinding46 != null ? dialogApplySubjectRegistrationBinding46.elective3Lyt : null;
                            if (linearLayout19 != null) {
                                linearLayout19.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused6) {
                        dialogApplySubjectRegistrationBinding7 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout20 = dialogApplySubjectRegistrationBinding7 != null ? dialogApplySubjectRegistrationBinding7.elective3Lyt : null;
                        if (linearLayout20 != null) {
                            linearLayout20.setVisibility(8);
                        }
                    }
                    if (data.getGlobalelective().size() == 0) {
                        dialogApplySubjectRegistrationBinding45 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout21 = dialogApplySubjectRegistrationBinding45 != null ? dialogApplySubjectRegistrationBinding45.globalElectiveLyt : null;
                        if (linearLayout21 != null) {
                            linearLayout21.setVisibility(8);
                        }
                    } else {
                        dialogApplySubjectRegistrationBinding8 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout22 = dialogApplySubjectRegistrationBinding8 != null ? dialogApplySubjectRegistrationBinding8.globalElectiveLyt : null;
                        if (linearLayout22 != null) {
                            linearLayout22.setVisibility(0);
                        }
                    }
                    try {
                        if (data.getAdditionalelective_1().size() == 0) {
                            dialogApplySubjectRegistrationBinding44 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout23 = dialogApplySubjectRegistrationBinding44 != null ? dialogApplySubjectRegistrationBinding44.additionalElective1Lyt : null;
                            if (linearLayout23 != null) {
                                linearLayout23.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding43 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout24 = dialogApplySubjectRegistrationBinding43 != null ? dialogApplySubjectRegistrationBinding43.additionalElective1Lyt : null;
                            if (linearLayout24 != null) {
                                linearLayout24.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused7) {
                        dialogApplySubjectRegistrationBinding9 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout25 = dialogApplySubjectRegistrationBinding9 != null ? dialogApplySubjectRegistrationBinding9.additionalElective1Lyt : null;
                        if (linearLayout25 != null) {
                            linearLayout25.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getAdditionalelective_2().size() == 0) {
                            dialogApplySubjectRegistrationBinding42 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout26 = dialogApplySubjectRegistrationBinding42 != null ? dialogApplySubjectRegistrationBinding42.additionalElective2Lyt : null;
                            if (linearLayout26 != null) {
                                linearLayout26.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding41 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout27 = dialogApplySubjectRegistrationBinding41 != null ? dialogApplySubjectRegistrationBinding41.additionalElective2Lyt : null;
                            if (linearLayout27 != null) {
                                linearLayout27.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused8) {
                        dialogApplySubjectRegistrationBinding10 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout28 = dialogApplySubjectRegistrationBinding10 != null ? dialogApplySubjectRegistrationBinding10.additionalElective2Lyt : null;
                        if (linearLayout28 != null) {
                            linearLayout28.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getAdditionalelective_3().size() == 0) {
                            dialogApplySubjectRegistrationBinding40 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout29 = dialogApplySubjectRegistrationBinding40 != null ? dialogApplySubjectRegistrationBinding40.additionalElective3Lyt : null;
                            if (linearLayout29 != null) {
                                linearLayout29.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding39 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout30 = dialogApplySubjectRegistrationBinding39 != null ? dialogApplySubjectRegistrationBinding39.additionalElective3Lyt : null;
                            if (linearLayout30 != null) {
                                linearLayout30.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused9) {
                        dialogApplySubjectRegistrationBinding11 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout31 = dialogApplySubjectRegistrationBinding11 != null ? dialogApplySubjectRegistrationBinding11.additionalElective3Lyt : null;
                        if (linearLayout31 != null) {
                            linearLayout31.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getMdc_1().size() == 0) {
                            dialogApplySubjectRegistrationBinding38 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout32 = dialogApplySubjectRegistrationBinding38 != null ? dialogApplySubjectRegistrationBinding38.mdc1Lyt : null;
                            if (linearLayout32 != null) {
                                linearLayout32.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding37 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout33 = dialogApplySubjectRegistrationBinding37 != null ? dialogApplySubjectRegistrationBinding37.mdc1Lyt : null;
                            if (linearLayout33 != null) {
                                linearLayout33.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused10) {
                        dialogApplySubjectRegistrationBinding12 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout34 = dialogApplySubjectRegistrationBinding12 != null ? dialogApplySubjectRegistrationBinding12.mdc1Lyt : null;
                        if (linearLayout34 != null) {
                            linearLayout34.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getMdc_2().size() == 0) {
                            dialogApplySubjectRegistrationBinding36 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout35 = dialogApplySubjectRegistrationBinding36 != null ? dialogApplySubjectRegistrationBinding36.mdc2Lyt : null;
                            if (linearLayout35 != null) {
                                linearLayout35.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding35 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout36 = dialogApplySubjectRegistrationBinding35 != null ? dialogApplySubjectRegistrationBinding35.mdc2Lyt : null;
                            if (linearLayout36 != null) {
                                linearLayout36.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused11) {
                        dialogApplySubjectRegistrationBinding13 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout37 = dialogApplySubjectRegistrationBinding13 != null ? dialogApplySubjectRegistrationBinding13.mdc2Lyt : null;
                        if (linearLayout37 != null) {
                            linearLayout37.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getMdc_3().size() == 0) {
                            dialogApplySubjectRegistrationBinding34 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout38 = dialogApplySubjectRegistrationBinding34 != null ? dialogApplySubjectRegistrationBinding34.mdc3Lyt : null;
                            if (linearLayout38 != null) {
                                linearLayout38.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding33 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout39 = dialogApplySubjectRegistrationBinding33 != null ? dialogApplySubjectRegistrationBinding33.mdc3Lyt : null;
                            if (linearLayout39 != null) {
                                linearLayout39.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused12) {
                        dialogApplySubjectRegistrationBinding14 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout40 = dialogApplySubjectRegistrationBinding14 != null ? dialogApplySubjectRegistrationBinding14.mdc3Lyt : null;
                        if (linearLayout40 != null) {
                            linearLayout40.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getAec_1().size() == 0) {
                            dialogApplySubjectRegistrationBinding32 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout41 = dialogApplySubjectRegistrationBinding32 != null ? dialogApplySubjectRegistrationBinding32.aec1Lyt : null;
                            if (linearLayout41 != null) {
                                linearLayout41.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding31 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout42 = dialogApplySubjectRegistrationBinding31 != null ? dialogApplySubjectRegistrationBinding31.aec1Lyt : null;
                            if (linearLayout42 != null) {
                                linearLayout42.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused13) {
                        dialogApplySubjectRegistrationBinding15 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout43 = dialogApplySubjectRegistrationBinding15 != null ? dialogApplySubjectRegistrationBinding15.aec1Lyt : null;
                        if (linearLayout43 != null) {
                            linearLayout43.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getAec_2().size() == 0) {
                            dialogApplySubjectRegistrationBinding30 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout44 = dialogApplySubjectRegistrationBinding30 != null ? dialogApplySubjectRegistrationBinding30.aec2Lyt : null;
                            if (linearLayout44 != null) {
                                linearLayout44.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding29 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout45 = dialogApplySubjectRegistrationBinding29 != null ? dialogApplySubjectRegistrationBinding29.aec2Lyt : null;
                            if (linearLayout45 != null) {
                                linearLayout45.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused14) {
                        dialogApplySubjectRegistrationBinding16 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout46 = dialogApplySubjectRegistrationBinding16 != null ? dialogApplySubjectRegistrationBinding16.aec2Lyt : null;
                        if (linearLayout46 != null) {
                            linearLayout46.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getAec_3().size() == 0) {
                            dialogApplySubjectRegistrationBinding28 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout47 = dialogApplySubjectRegistrationBinding28 != null ? dialogApplySubjectRegistrationBinding28.aec3Lyt : null;
                            if (linearLayout47 != null) {
                                linearLayout47.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding27 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout48 = dialogApplySubjectRegistrationBinding27 != null ? dialogApplySubjectRegistrationBinding27.aec3Lyt : null;
                            if (linearLayout48 != null) {
                                linearLayout48.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused15) {
                        dialogApplySubjectRegistrationBinding17 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout49 = dialogApplySubjectRegistrationBinding17 != null ? dialogApplySubjectRegistrationBinding17.aec3Lyt : null;
                        if (linearLayout49 != null) {
                            linearLayout49.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getDsc_1().size() == 0) {
                            dialogApplySubjectRegistrationBinding26 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout50 = dialogApplySubjectRegistrationBinding26 != null ? dialogApplySubjectRegistrationBinding26.dsc1Lyt : null;
                            if (linearLayout50 != null) {
                                linearLayout50.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding25 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout51 = dialogApplySubjectRegistrationBinding25 != null ? dialogApplySubjectRegistrationBinding25.dsc1Lyt : null;
                            if (linearLayout51 != null) {
                                linearLayout51.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused16) {
                        dialogApplySubjectRegistrationBinding18 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout52 = dialogApplySubjectRegistrationBinding18 != null ? dialogApplySubjectRegistrationBinding18.dsc1Lyt : null;
                        if (linearLayout52 != null) {
                            linearLayout52.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getDsc_2().size() == 0) {
                            dialogApplySubjectRegistrationBinding24 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout53 = dialogApplySubjectRegistrationBinding24 != null ? dialogApplySubjectRegistrationBinding24.dsc2Lyt : null;
                            if (linearLayout53 != null) {
                                linearLayout53.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding23 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout54 = dialogApplySubjectRegistrationBinding23 != null ? dialogApplySubjectRegistrationBinding23.dsc2Lyt : null;
                            if (linearLayout54 != null) {
                                linearLayout54.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused17) {
                        dialogApplySubjectRegistrationBinding19 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout55 = dialogApplySubjectRegistrationBinding19 != null ? dialogApplySubjectRegistrationBinding19.dsc2Lyt : null;
                        if (linearLayout55 != null) {
                            linearLayout55.setVisibility(8);
                        }
                    }
                    try {
                        if (data.getDsc_3().size() == 0) {
                            dialogApplySubjectRegistrationBinding22 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout56 = dialogApplySubjectRegistrationBinding22 != null ? dialogApplySubjectRegistrationBinding22.dsc3Lyt : null;
                            if (linearLayout56 != null) {
                                linearLayout56.setVisibility(8);
                            }
                        } else {
                            dialogApplySubjectRegistrationBinding21 = applySubjectRegistrationDialog.get_binding();
                            LinearLayout linearLayout57 = dialogApplySubjectRegistrationBinding21 != null ? dialogApplySubjectRegistrationBinding21.dsc3Lyt : null;
                            if (linearLayout57 != null) {
                                linearLayout57.setVisibility(0);
                            }
                        }
                    } catch (NullPointerException unused18) {
                        dialogApplySubjectRegistrationBinding20 = applySubjectRegistrationDialog.get_binding();
                        LinearLayout linearLayout58 = dialogApplySubjectRegistrationBinding20 != null ? dialogApplySubjectRegistrationBinding20.dsc3Lyt : null;
                        if (linearLayout58 != null) {
                            linearLayout58.setVisibility(8);
                        }
                    }
                    try {
                        spinnerMinor1Adapter = applySubjectRegistrationDialog.getSpinnerMinor1Adapter();
                        spinnerMinor1Adapter.addItems(data.getMinor_1());
                    } catch (NullPointerException unused19) {
                    }
                    try {
                        spinnerMinor2Adapter = applySubjectRegistrationDialog.getSpinnerMinor2Adapter();
                        spinnerMinor2Adapter.addItems(data.getMinor_2());
                    } catch (NullPointerException unused20) {
                    }
                    try {
                        spinnerMinor3Adapter = applySubjectRegistrationDialog.getSpinnerMinor3Adapter();
                        spinnerMinor3Adapter.addItems(data.getMinor_3());
                    } catch (NullPointerException unused21) {
                    }
                    spinnerHonourAdapter = applySubjectRegistrationDialog.getSpinnerHonourAdapter();
                    spinnerHonourAdapter.addItems(data.getHonour());
                    try {
                        spinnerElective1Adapter = applySubjectRegistrationDialog.getSpinnerElective1Adapter();
                        spinnerElective1Adapter.addItems(data.getElective_1());
                    } catch (NullPointerException unused22) {
                    }
                    try {
                        spinnerElective2Adapter = applySubjectRegistrationDialog.getSpinnerElective2Adapter();
                        spinnerElective2Adapter.addItems(data.getElective_2());
                    } catch (NullPointerException unused23) {
                    }
                    try {
                        spinnerElective3Adapter = applySubjectRegistrationDialog.getSpinnerElective3Adapter();
                        spinnerElective3Adapter.addItems(data.getElective_3());
                    } catch (NullPointerException unused24) {
                    }
                    spinnerGlobalElectiveAdapter = applySubjectRegistrationDialog.getSpinnerGlobalElectiveAdapter();
                    spinnerGlobalElectiveAdapter.addItems(data.getGlobalelective());
                    try {
                        spinnerAdditionalElective1Adapter = applySubjectRegistrationDialog.getSpinnerAdditionalElective1Adapter();
                        spinnerAdditionalElective1Adapter.addItems(data.getAdditionalelective_1());
                    } catch (NullPointerException unused25) {
                    }
                    try {
                        spinnerAdditionalElective2Adapter = applySubjectRegistrationDialog.getSpinnerAdditionalElective2Adapter();
                        spinnerAdditionalElective2Adapter.addItems(data.getAdditionalelective_2());
                    } catch (NullPointerException unused26) {
                    }
                    try {
                        spinnerAdditionalElective3Adapter = applySubjectRegistrationDialog.getSpinnerAdditionalElective3Adapter();
                        spinnerAdditionalElective3Adapter.addItems(data.getAdditionalelective_3());
                    } catch (NullPointerException unused27) {
                    }
                    try {
                        spinnerMdc1Adapter = applySubjectRegistrationDialog.getSpinnerMdc1Adapter();
                        spinnerMdc1Adapter.addItems(data.getMdc_1());
                    } catch (NullPointerException unused28) {
                    }
                    try {
                        spinnerMdc2Adapter = applySubjectRegistrationDialog.getSpinnerMdc2Adapter();
                        spinnerMdc2Adapter.addItems(data.getMdc_2());
                    } catch (NullPointerException unused29) {
                    }
                    try {
                        spinnerMdc3Adapter = applySubjectRegistrationDialog.getSpinnerMdc3Adapter();
                        spinnerMdc3Adapter.addItems(data.getMdc_3());
                    } catch (NullPointerException unused30) {
                    }
                    try {
                        spinnerAec1Adapter = applySubjectRegistrationDialog.getSpinnerAec1Adapter();
                        spinnerAec1Adapter.addItems(data.getAec_1());
                    } catch (NullPointerException unused31) {
                    }
                    try {
                        spinnerAec2Adapter = applySubjectRegistrationDialog.getSpinnerAec2Adapter();
                        spinnerAec2Adapter.addItems(data.getAec_2());
                    } catch (NullPointerException unused32) {
                    }
                    try {
                        spinnerAec3Adapter = applySubjectRegistrationDialog.getSpinnerAec3Adapter();
                        spinnerAec3Adapter.addItems(data.getAec_3());
                    } catch (NullPointerException unused33) {
                    }
                    try {
                        spinnerDsc1Adapter = applySubjectRegistrationDialog.getSpinnerDsc1Adapter();
                        spinnerDsc1Adapter.addItems(data.getDsc_1());
                    } catch (NullPointerException unused34) {
                    }
                    try {
                        spinnerDsc2Adapter = applySubjectRegistrationDialog.getSpinnerDsc2Adapter();
                        spinnerDsc2Adapter.addItems(data.getDsc_2());
                    } catch (NullPointerException unused35) {
                    }
                    try {
                        spinnerDsc3Adapter = applySubjectRegistrationDialog.getSpinnerDsc3Adapter();
                        spinnerDsc3Adapter.addItems(data.getDsc_3());
                    } catch (NullPointerException unused36) {
                    }
                }
            }
        }));
    }

    private final void listenRegisterResponse() {
        getApplySubjectRegistrationViewModel().getRegisterResponse().observe(getViewLifecycleOwner(), new ApplySubjectRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$listenRegisterResponse$1

            /* compiled from: ApplySubjectRegistrationDialog.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding;
                TextView registerBtn;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2;
                TextView registerBtn2;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ApplySubjectRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ApplySubjectRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ApplySubjectRegistrationDialog.this.hideProgress();
                    dialogApplySubjectRegistrationBinding3 = ApplySubjectRegistrationDialog.this.get_binding();
                    if (dialogApplySubjectRegistrationBinding3 == null || (textView = dialogApplySubjectRegistrationBinding3.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ApplySubjectRegistrationDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                    if (!data.getLogin() || !data.getSuccess()) {
                        dialogApplySubjectRegistrationBinding = applySubjectRegistrationDialog.get_binding();
                        if (dialogApplySubjectRegistrationBinding == null || (registerBtn = dialogApplySubjectRegistrationBinding.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn, data.getError());
                        return;
                    }
                    dialogApplySubjectRegistrationBinding2 = applySubjectRegistrationDialog.get_binding();
                    if (dialogApplySubjectRegistrationBinding2 != null && (registerBtn2 = dialogApplySubjectRegistrationBinding2.registerBtn) != null) {
                        Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                        ToastExtKt.showSuccessToast(registerBtn2, data.getMessage());
                    }
                    applySubjectRegistrationDialog.dismiss();
                }
            }
        }));
    }

    private final void listenUpdateResponse() {
        getApplySubjectRegistrationViewModel().getUpdateResponse().observe(getViewLifecycleOwner(), new ApplySubjectRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog$listenUpdateResponse$1

            /* compiled from: ApplySubjectRegistrationDialog.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding;
                TextView registerBtn;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding2;
                TextView registerBtn2;
                DialogApplySubjectRegistrationBinding dialogApplySubjectRegistrationBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ApplySubjectRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ApplySubjectRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ApplySubjectRegistrationDialog.this.hideProgress();
                    dialogApplySubjectRegistrationBinding3 = ApplySubjectRegistrationDialog.this.get_binding();
                    if (dialogApplySubjectRegistrationBinding3 == null || (textView = dialogApplySubjectRegistrationBinding3.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ApplySubjectRegistrationDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ApplySubjectRegistrationDialog applySubjectRegistrationDialog = ApplySubjectRegistrationDialog.this;
                    if (!data.getLogin() || !data.getSuccess()) {
                        dialogApplySubjectRegistrationBinding = applySubjectRegistrationDialog.get_binding();
                        if (dialogApplySubjectRegistrationBinding == null || (registerBtn = dialogApplySubjectRegistrationBinding.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn, data.getError());
                        return;
                    }
                    dialogApplySubjectRegistrationBinding2 = applySubjectRegistrationDialog.get_binding();
                    if (dialogApplySubjectRegistrationBinding2 != null && (registerBtn2 = dialogApplySubjectRegistrationBinding2.registerBtn) != null) {
                        Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                        ToastExtKt.showSuccessToast(registerBtn2, data.getMessage());
                    }
                    applySubjectRegistrationDialog.dismiss();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listner2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    public final void setCallBack(SubjectRegistrationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack2(ViewSubjectRegistrationDialog context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        RegisterListener registerListener = this.listener;
        if (registerListener != null) {
            registerListener.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}