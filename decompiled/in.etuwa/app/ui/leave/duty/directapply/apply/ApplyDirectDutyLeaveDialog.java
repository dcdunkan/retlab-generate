package in.etuwa.app.ui.leave.duty.directapply.apply;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.messaging.Constants;
import com.itextpdf.forms.xfdf.XfdfConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveHeadResponse;
import in.etuwa.app.databinding.DialogApplyAddDirectLeaveBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ApplyDirectDutyLeaveDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\"\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0017J\u0012\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\b\u00105\u001a\u00020\u001fH\u0016J\u001a\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u000e\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020\u001fH\u0015J\b\u0010<\u001a\u00020\u001fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogApplyAddDirectLeaveBinding;", "applyDirectDutyLeaveViewModel", "Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveViewModel;", "getApplyDirectDutyLeaveViewModel", "()Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveViewModel;", "applyDirectDutyLeaveViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogApplyAddDirectLeaveBinding;", "fromDate", "", XfdfConstants.HEAD, "headId", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveDialog$NewDutyLeaveListener;", "pickFile", "Ljava/io/File;", "reason", "spinnerAdapter", "Lin/etuwa/app/ui/leave/duty/directapply/apply/DutyHeadSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/leave/duty/directapply/apply/DutyHeadSpinnerAdapter;", "spinnerAdapter$delegate", "toDate", "hideProgress", "", "listenApplyResponse", "listenProgressResponse", "listenProgressResponse2", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyFragment;", "setUp", "showProgress", "Companion", "NewDutyLeaveListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplyDirectDutyLeaveDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogApplyAddDirectLeaveBinding _binding;

    /* renamed from: applyDirectDutyLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy applyDirectDutyLeaveViewModel;
    private String fromDate;
    private String head;
    private String headId;
    private String id;
    private NewDutyLeaveListener listener;
    private File pickFile;
    private String reason;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String toDate;

    /* compiled from: ApplyDirectDutyLeaveDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveDialog$NewDutyLeaveListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NewDutyLeaveListener {
        void onDismiss();
    }

    /* compiled from: ApplyDirectDutyLeaveDialog.kt */
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
    public static final ApplyDirectDutyLeaveDialog newInstance(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ApplyDirectDutyLeaveDialog() {
        final ApplyDirectDutyLeaveDialog applyDirectDutyLeaveDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(applyDirectDutyLeaveDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.applyDirectDutyLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(applyDirectDutyLeaveDialog, Reflection.getOrCreateKotlinClass(ApplyDirectDutyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ApplyDirectDutyLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.headId = "";
        final ApplyDirectDutyLeaveDialog applyDirectDutyLeaveDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyDirectDutyLeaveDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DutyHeadSpinnerAdapter>() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.duty.directapply.apply.DutyHeadSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DutyHeadSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyDirectDutyLeaveDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DutyHeadSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final ApplyDirectDutyLeaveViewModel getApplyDirectDutyLeaveViewModel() {
        return (ApplyDirectDutyLeaveViewModel) this.applyDirectDutyLeaveViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogApplyAddDirectLeaveBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DutyHeadSpinnerAdapter getSpinnerAdapter() {
        return (DutyHeadSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: ApplyDirectDutyLeaveDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/directapply/apply/ApplyDirectDutyLeaveDialog;", "id", "", "reason", "fromDate", "toDate", XfdfConstants.HEAD, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ApplyDirectDutyLeaveDialog newInstance(String id, String reason, String fromDate, String toDate, String head) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(fromDate, "fromDate");
            Intrinsics.checkNotNullParameter(toDate, "toDate");
            Intrinsics.checkNotNullParameter(head, "head");
            ApplyDirectDutyLeaveDialog applyDirectDutyLeaveDialog = new ApplyDirectDutyLeaveDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, reason);
            bundle.putString("url", fromDate);
            bundle.putString("fine", toDate);
            bundle.putString("fixed", head);
            applyDirectDutyLeaveDialog.setArguments(bundle);
            return applyDirectDutyLeaveDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.reason = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.fromDate = arguments.getString("url");
            this.toDate = arguments.getString("fine");
            this.head = arguments.getString("fixed");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogApplyAddDirectLeaveBinding.inflate(inflater, container, false);
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = get_binding();
        if (dialogApplyAddDirectLeaveBinding != null) {
            dialogApplyAddDirectLeaveBinding.setApplyDirectDutyLeaveViewModel(getApplyDirectDutyLeaveViewModel());
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = get_binding();
        if (dialogApplyAddDirectLeaveBinding2 != null) {
            dialogApplyAddDirectLeaveBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = get_binding();
        if (dialogApplyAddDirectLeaveBinding3 != null) {
            return dialogApplyAddDirectLeaveBinding3.getRoot();
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
        TextView textView2;
        TextView textView3;
        TextView textView4;
        EditText editText;
        TextView textView5;
        EditText editText2;
        TextInputEditText textInputEditText;
        EditText editText3;
        EditText editText4;
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = get_binding();
        Spinner spinner = dialogApplyAddDirectLeaveBinding != null ? dialogApplyAddDirectLeaveBinding.spinnerDutyHead : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenApplyResponse();
        listenProgressResponse2();
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        getApplyDirectDutyLeaveViewModel().getHeadTypeData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = get_binding();
            TextView textView6 = dialogApplyAddDirectLeaveBinding2 != null ? dialogApplyAddDirectLeaveBinding2.applyBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = get_binding();
            TextView textView7 = dialogApplyAddDirectLeaveBinding3 != null ? dialogApplyAddDirectLeaveBinding3.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding4 = get_binding();
            TextView textView8 = dialogApplyAddDirectLeaveBinding4 != null ? dialogApplyAddDirectLeaveBinding4.applyBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding5 = get_binding();
            TextView textView9 = dialogApplyAddDirectLeaveBinding5 != null ? dialogApplyAddDirectLeaveBinding5.updateBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding6 = get_binding();
        if (dialogApplyAddDirectLeaveBinding6 != null && (editText4 = dialogApplyAddDirectLeaveBinding6.etFromDate) != null) {
            editText4.setText(this.fromDate);
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding7 = get_binding();
        if (dialogApplyAddDirectLeaveBinding7 != null && (editText3 = dialogApplyAddDirectLeaveBinding7.etToDate) != null) {
            editText3.setText(this.toDate);
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding8 = get_binding();
        if (dialogApplyAddDirectLeaveBinding8 != null && (textInputEditText = dialogApplyAddDirectLeaveBinding8.etReason) != null) {
            textInputEditText.setText(this.reason);
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding9 = get_binding();
        Spinner spinner2 = dialogApplyAddDirectLeaveBinding9 != null ? dialogApplyAddDirectLeaveBinding9.spinnerDutyHead : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    DutyHeadSpinnerAdapter spinnerAdapter;
                    ApplyDirectDutyLeaveDialog applyDirectDutyLeaveDialog = ApplyDirectDutyLeaveDialog.this;
                    spinnerAdapter = applyDirectDutyLeaveDialog.getSpinnerAdapter();
                    applyDirectDutyLeaveDialog.headId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding10 = get_binding();
        if (dialogApplyAddDirectLeaveBinding10 != null && (editText2 = dialogApplyAddDirectLeaveBinding10.etFromDate) != null) {
            editText2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyDirectDutyLeaveDialog.setUp$lambda$2(ApplyDirectDutyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding11 = get_binding();
        if (dialogApplyAddDirectLeaveBinding11 != null && (textView5 = dialogApplyAddDirectLeaveBinding11.etFromDate2) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyDirectDutyLeaveDialog.setUp$lambda$4(ApplyDirectDutyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding12 = get_binding();
        if (dialogApplyAddDirectLeaveBinding12 != null && (editText = dialogApplyAddDirectLeaveBinding12.etToDate) != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyDirectDutyLeaveDialog.setUp$lambda$6(ApplyDirectDutyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding13 = get_binding();
        if (dialogApplyAddDirectLeaveBinding13 != null && (textView4 = dialogApplyAddDirectLeaveBinding13.etToDate2) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyDirectDutyLeaveDialog.setUp$lambda$8(ApplyDirectDutyLeaveDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding14 = get_binding();
        if (dialogApplyAddDirectLeaveBinding14 != null && (textView3 = dialogApplyAddDirectLeaveBinding14.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyDirectDutyLeaveDialog.setUp$lambda$10(ApplyDirectDutyLeaveDialog.this, view);
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding15 = get_binding();
        if (dialogApplyAddDirectLeaveBinding15 != null && (textView2 = dialogApplyAddDirectLeaveBinding15.applyBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyDirectDutyLeaveDialog.setUp$lambda$11(ApplyDirectDutyLeaveDialog.this, view);
                }
            });
        }
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding16 = get_binding();
        if (dialogApplyAddDirectLeaveBinding16 == null || (textView = dialogApplyAddDirectLeaveBinding16.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyDirectDutyLeaveDialog.setUp$lambda$12(ApplyDirectDutyLeaveDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final ApplyDirectDutyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda3
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                ApplyDirectDutyLeaveDialog.setUp$lambda$2$lambda$1(ApplyDirectDutyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(ApplyDirectDutyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-M-d").parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3));
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
        if (dialogApplyAddDirectLeaveBinding == null || (editText = dialogApplyAddDirectLeaveBinding.etFromDate) == null) {
            return;
        }
        editText.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(final ApplyDirectDutyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                ApplyDirectDutyLeaveDialog.setUp$lambda$4$lambda$3(ApplyDirectDutyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4$lambda$3(ApplyDirectDutyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-M-d").parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3));
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
        if (dialogApplyAddDirectLeaveBinding == null || (editText = dialogApplyAddDirectLeaveBinding.etFromDate) == null) {
            return;
        }
        editText.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(final ApplyDirectDutyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda4
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                ApplyDirectDutyLeaveDialog.setUp$lambda$6$lambda$5(ApplyDirectDutyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6$lambda$5(ApplyDirectDutyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-M-d").parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3));
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
        if (dialogApplyAddDirectLeaveBinding == null || (editText = dialogApplyAddDirectLeaveBinding.etToDate) == null) {
            return;
        }
        editText.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(final ApplyDirectDutyLeaveDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda14
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                ApplyDirectDutyLeaveDialog.setUp$lambda$8$lambda$7(ApplyDirectDutyLeaveDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8$lambda$7(ApplyDirectDutyLeaveDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-M-d").parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3));
        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
        if (dialogApplyAddDirectLeaveBinding == null || (editText = dialogApplyAddDirectLeaveBinding.etToDate) == null) {
            return;
        }
        editText.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(ApplyDirectDutyLeaveDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(ApplyDirectDutyLeaveDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        File file;
        EditText editText;
        EditText editText2;
        TextInputEditText textInputEditText;
        TextView textView3;
        EditText editText3;
        TextView textView4;
        EditText editText4;
        TextView textView5;
        TextInputEditText textInputEditText2;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
            if (String.valueOf((dialogApplyAddDirectLeaveBinding == null || (textView6 = dialogApplyAddDirectLeaveBinding.completionFileName) == null) ? null : textView6.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 200) {
                    this$0.setCancelable(false);
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogApplyAddDirectLeaveBinding2 == null || (textInputEditText2 = dialogApplyAddDirectLeaveBinding2.etReason) == null) ? null : textInputEditText2.getText()), "")) {
                        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = this$0.get_binding();
                        if (dialogApplyAddDirectLeaveBinding3 == null || (textView5 = dialogApplyAddDirectLeaveBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Reason Cannot be empty");
                        return;
                    }
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding4 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogApplyAddDirectLeaveBinding4 == null || (editText4 = dialogApplyAddDirectLeaveBinding4.etFromDate) == null) ? null : editText4.getText()), "")) {
                        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding5 = this$0.get_binding();
                        if (dialogApplyAddDirectLeaveBinding5 == null || (textView4 = dialogApplyAddDirectLeaveBinding5.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "From date cannot be empty");
                        return;
                    }
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding6 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogApplyAddDirectLeaveBinding6 == null || (editText3 = dialogApplyAddDirectLeaveBinding6.etToDate) == null) ? null : editText3.getText()), "")) {
                        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding7 = this$0.get_binding();
                        if (dialogApplyAddDirectLeaveBinding7 == null || (textView3 = dialogApplyAddDirectLeaveBinding7.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "To date cannot be empty");
                        return;
                    }
                    ApplyDirectDutyLeaveViewModel applyDirectDutyLeaveViewModel = this$0.getApplyDirectDutyLeaveViewModel();
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding8 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogApplyAddDirectLeaveBinding8 == null || (textInputEditText = dialogApplyAddDirectLeaveBinding8.etReason) == null) ? null : textInputEditText.getText());
                    String str = this$0.headId;
                    Intrinsics.checkNotNull(str);
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding9 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogApplyAddDirectLeaveBinding9 == null || (editText2 = dialogApplyAddDirectLeaveBinding9.etFromDate) == null) ? null : editText2.getText());
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding10 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogApplyAddDirectLeaveBinding10 == null || (editText = dialogApplyAddDirectLeaveBinding10.etToDate) == null) ? null : editText.getText());
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    applyDirectDutyLeaveViewModel.applyDutyLeaveApiCall(valueOf, str, valueOf2, valueOf3, file);
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding11 = this$0.get_binding();
                    LinearLayout linearLayout = dialogApplyAddDirectLeaveBinding11 != null ? dialogApplyAddDirectLeaveBinding11.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding12 = this$0.get_binding();
                    CardView cardView = dialogApplyAddDirectLeaveBinding12 != null ? dialogApplyAddDirectLeaveBinding12.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding13 = this$0.get_binding();
                if (dialogApplyAddDirectLeaveBinding13 == null || (textView2 = dialogApplyAddDirectLeaveBinding13.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 200KB");
                return;
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding14 = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding14 == null || (textView = dialogApplyAddDirectLeaveBinding14.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(ApplyDirectDutyLeaveDialog this$0, View view) {
        File file;
        TextView textView;
        TextView textView2;
        File file2;
        TextView textView3;
        EditText editText;
        TextView textView4;
        EditText editText2;
        TextView textView5;
        TextInputEditText textInputEditText;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
            if (String.valueOf((dialogApplyAddDirectLeaveBinding == null || (textView6 = dialogApplyAddDirectLeaveBinding.completionFileName) == null) ? null : textView6.getText()).length() > 0) {
                File file3 = this$0.pickFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file3 = null;
                }
                if (file3.length() / 1024 <= 200) {
                    this$0.setCancelable(false);
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogApplyAddDirectLeaveBinding2 == null || (textInputEditText = dialogApplyAddDirectLeaveBinding2.etReason) == null) ? null : textInputEditText.getText()), "")) {
                        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = this$0.get_binding();
                        if (dialogApplyAddDirectLeaveBinding3 == null || (textView5 = dialogApplyAddDirectLeaveBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Reason Cannot be empty");
                        return;
                    }
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding4 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogApplyAddDirectLeaveBinding4 == null || (editText2 = dialogApplyAddDirectLeaveBinding4.etFromDate) == null) ? null : editText2.getText()), "")) {
                        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding5 = this$0.get_binding();
                        if (dialogApplyAddDirectLeaveBinding5 == null || (textView4 = dialogApplyAddDirectLeaveBinding5.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "From date cannot be empty");
                        return;
                    }
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding6 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogApplyAddDirectLeaveBinding6 == null || (editText = dialogApplyAddDirectLeaveBinding6.etToDate) == null) ? null : editText.getText()), "")) {
                        DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding7 = this$0.get_binding();
                        if (dialogApplyAddDirectLeaveBinding7 == null || (textView3 = dialogApplyAddDirectLeaveBinding7.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "To date cannot be empty");
                        return;
                    }
                    ApplyDirectDutyLeaveViewModel applyDirectDutyLeaveViewModel = this$0.getApplyDirectDutyLeaveViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    String str2 = this$0.reason;
                    Intrinsics.checkNotNull(str2);
                    String str3 = this$0.headId;
                    Intrinsics.checkNotNull(str3);
                    String str4 = this$0.fromDate;
                    Intrinsics.checkNotNull(str4);
                    String str5 = this$0.toDate;
                    Intrinsics.checkNotNull(str5);
                    File file4 = this$0.pickFile;
                    if (file4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file2 = null;
                    } else {
                        file2 = file4;
                    }
                    applyDirectDutyLeaveViewModel.updateDutyLeaveApiCall(str, str2, str3, str4, str5, file2);
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding8 = this$0.get_binding();
                    LinearLayout linearLayout = dialogApplyAddDirectLeaveBinding8 != null ? dialogApplyAddDirectLeaveBinding8.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding9 = this$0.get_binding();
                    CardView cardView = dialogApplyAddDirectLeaveBinding9 != null ? dialogApplyAddDirectLeaveBinding9.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding10 = this$0.get_binding();
                if (dialogApplyAddDirectLeaveBinding10 == null || (textView2 = dialogApplyAddDirectLeaveBinding10.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 200KB");
                return;
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding11 = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding11 == null || (textView = dialogApplyAddDirectLeaveBinding11.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        } catch (Exception unused) {
            ApplyDirectDutyLeaveViewModel applyDirectDutyLeaveViewModel2 = this$0.getApplyDirectDutyLeaveViewModel();
            String str6 = this$0.id;
            Intrinsics.checkNotNull(str6);
            String str7 = this$0.reason;
            Intrinsics.checkNotNull(str7);
            String str8 = this$0.headId;
            Intrinsics.checkNotNull(str8);
            String str9 = this$0.fromDate;
            Intrinsics.checkNotNull(str9);
            String str10 = this$0.toDate;
            Intrinsics.checkNotNull(str10);
            File file5 = this$0.pickFile;
            if (file5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            } else {
                file = file5;
            }
            applyDirectDutyLeaveViewModel2.updateDutyLeaveApiCall(str6, str7, str8, str9, str10, file);
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding12 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogApplyAddDirectLeaveBinding12 != null ? dialogApplyAddDirectLeaveBinding12.completionCard : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding13 = this$0.get_binding();
            CardView cardView2 = dialogApplyAddDirectLeaveBinding13 != null ? dialogApplyAddDirectLeaveBinding13.progressView : null;
            if (cardView2 == null) {
                return;
            }
            cardView2.setVisibility(0);
        }
    }

    private final void listenSpinnerResponse() {
        getApplyDirectDutyLeaveViewModel().getResponse().observe(getViewLifecycleOwner(), new ApplyDirectDutyLeaveDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DutyLeaveHeadResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$listenSpinnerResponse$1

            /* compiled from: ApplyDirectDutyLeaveDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DutyLeaveHeadResponse> resource) {
                invoke2((Resource<DutyLeaveHeadResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DutyLeaveHeadResponse> resource) {
                DutyHeadSpinnerAdapter spinnerAdapter;
                DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ApplyDirectDutyLeaveDialog.this.hideProgress();
                    DutyLeaveHeadResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter = ApplyDirectDutyLeaveDialog.this.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getData());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    ApplyDirectDutyLeaveDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ApplyDirectDutyLeaveDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                ApplyDirectDutyLeaveDialog.this.hideProgress();
                dialogApplyAddDirectLeaveBinding = ApplyDirectDutyLeaveDialog.this.get_binding();
                if (dialogApplyAddDirectLeaveBinding == null || (spinner = dialogApplyAddDirectLeaveBinding.spinnerDutyHead) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenUpdateResponse() {
        getApplyDirectDutyLeaveViewModel().getUpdateResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplyDirectDutyLeaveDialog.listenUpdateResponse$lambda$14(ApplyDirectDutyLeaveDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$14(ApplyDirectDutyLeaveDialog this$0, Resource resource) {
        TextView completionFileName;
        TextView completionFileName2;
        TextView textView;
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
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding != null && (textView = dialogApplyAddDirectLeaveBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            NewDutyLeaveListener newDutyLeaveListener = this$0.listener;
            if (newDutyLeaveListener != null) {
                newDutyLeaveListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = this$0.get_binding();
                if (dialogApplyAddDirectLeaveBinding2 != null && (completionFileName2 = dialogApplyAddDirectLeaveBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                NewDutyLeaveListener newDutyLeaveListener2 = this$0.listener;
                if (newDutyLeaveListener2 != null) {
                    newDutyLeaveListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding3 != null && (completionFileName = dialogApplyAddDirectLeaveBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            NewDutyLeaveListener newDutyLeaveListener3 = this$0.listener;
            if (newDutyLeaveListener3 != null) {
                newDutyLeaveListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenApplyResponse() {
        getApplyDirectDutyLeaveViewModel().getApplyResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplyDirectDutyLeaveDialog.listenApplyResponse$lambda$16(ApplyDirectDutyLeaveDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenApplyResponse$lambda$16(ApplyDirectDutyLeaveDialog this$0, Resource resource) {
        TextView completionFileName;
        TextView completionFileName2;
        TextView textView;
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
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding != null && (textView = dialogApplyAddDirectLeaveBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            NewDutyLeaveListener newDutyLeaveListener = this$0.listener;
            if (newDutyLeaveListener != null) {
                newDutyLeaveListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = this$0.get_binding();
                if (dialogApplyAddDirectLeaveBinding2 != null && (completionFileName2 = dialogApplyAddDirectLeaveBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                NewDutyLeaveListener newDutyLeaveListener2 = this$0.listener;
                if (newDutyLeaveListener2 != null) {
                    newDutyLeaveListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding3 != null && (completionFileName = dialogApplyAddDirectLeaveBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            NewDutyLeaveListener newDutyLeaveListener3 = this$0.listener;
            if (newDutyLeaveListener3 != null) {
                newDutyLeaveListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getApplyDirectDutyLeaveViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplyDirectDutyLeaveDialog.listenProgressResponse$lambda$18(ApplyDirectDutyLeaveDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$18(ApplyDirectDutyLeaveDialog this$0, Resource resource) {
        TextView textView;
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
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding == null || (textView = dialogApplyAddDirectLeaveBinding.completionFileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogApplyAddDirectLeaveBinding2 != null ? dialogApplyAddDirectLeaveBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = this$0.get_binding();
            TextView textView2 = dialogApplyAddDirectLeaveBinding3 != null ? dialogApplyAddDirectLeaveBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    private final void listenProgressResponse2() {
        getApplyDirectDutyLeaveViewModel().getProgressResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveDialog$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ApplyDirectDutyLeaveDialog.listenProgressResponse2$lambda$20(ApplyDirectDutyLeaveDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse2$lambda$20(ApplyDirectDutyLeaveDialog this$0, Resource resource) {
        TextView textView;
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
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = this$0.get_binding();
            if (dialogApplyAddDirectLeaveBinding == null || (textView = dialogApplyAddDirectLeaveBinding.completionFileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogApplyAddDirectLeaveBinding2 != null ? dialogApplyAddDirectLeaveBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding3 = this$0.get_binding();
            TextView textView2 = dialogApplyAddDirectLeaveBinding3 != null ? dialogApplyAddDirectLeaveBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        ParcelFileDescriptor openFileDescriptor;
        File file;
        ContentResolver contentResolver3;
        String fileName;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                DialogApplyAddDirectLeaveBinding dialogApplyAddDirectLeaveBinding = get_binding();
                TextView textView = dialogApplyAddDirectLeaveBinding != null ? dialogApplyAddDirectLeaveBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver = context.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver, data2);
                    }
                    textView.setText("File : " + str);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver2 = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver2.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    if (context3 == null || (contentResolver3 = context3.getContentResolver()) == null || (fileName = ResolvUtilKt.getFileName(contentResolver3, data2)) == null) {
                        file = null;
                    } else {
                        Context context4 = getContext();
                        file = new File(context4 != null ? context4.getCacheDir() : null, fileName);
                    }
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    if (file != null) {
                        this.pickFile = file;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setCallBack(DirectApplyFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
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