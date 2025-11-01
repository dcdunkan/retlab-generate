package in.etuwa.app.ui.semregistration.mea;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.semregistration.AcademicYearResponse;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogMeaSemRegBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.semregistration.mvjce.CurrentSemSpinnerAdapter;
import in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: MeaSemRegDialog.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0002J\"\u0010/\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u00105\u001a\u00020'2\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010>\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020'H\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u001a\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u0002092\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u000e\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020GJ\b\u0010H\u001a\u00020'H\u0014J\b\u0010I\u001a\u00020'H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b#\u0010$¨\u0006L"}, d2 = {"Lin/etuwa/app/ui/semregistration/mea/MeaSemRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogMeaSemRegBinding;", "back", "", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogMeaSemRegBinding;", "feeConcession", "feePaid", "finalPage", "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog$AddSemRegListener;", "meaSemRegViewModel", "Lin/etuwa/app/ui/semregistration/mea/MeaSemRegViewModel;", "getMeaSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/mea/MeaSemRegViewModel;", "meaSemRegViewModel$delegate", "Lkotlin/Lazy;", "pickFile", "Ljava/io/File;", "pickedFile", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "reg", "semester_id", "spinnerAdapter", "Lin/etuwa/app/ui/semregistration/mvjce/CurrentSemSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/semregistration/mvjce/CurrentSemSpinnerAdapter;", "spinnerAdapter$delegate", "hideProgress", "", "listenResponse", "listenResponse2", "listenSpinners", "listenViewResponse", "loadView", "response", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "setUp", "showProgress", "AddCounsellingListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MeaSemRegDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogMeaSemRegBinding _binding;
    private String back;
    private String feeConcession;
    private String feePaid;
    private boolean finalPage;
    private String id;
    private MvjceSemRegDialog.AddSemRegListener listener;

    /* renamed from: meaSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy meaSemRegViewModel;
    private File pickFile;
    private boolean pickedFile;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String reg;
    private String semester_id;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: MeaSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/semregistration/mea/MeaSemRegDialog$AddCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCounsellingListener {
        void dismiss();
    }

    /* compiled from: MeaSemRegDialog.kt */
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
    public static final MeaSemRegDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public MeaSemRegDialog() {
        final MeaSemRegDialog meaSemRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(meaSemRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.meaSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(meaSemRegDialog, Reflection.getOrCreateKotlinClass(MeaSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MeaSemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MeaSemRegDialog meaSemRegDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = meaSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.id = "";
        this.reg = "Yes";
        this.back = "Yes";
        this.feeConcession = "Yes";
        this.feePaid = "Yes";
        this.semester_id = "";
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MeaSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CurrentSemSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mvjce.CurrentSemSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CurrentSemSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = meaSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CurrentSemSpinnerAdapter.class), b4, function02);
            }
        });
    }

    private final MeaSemRegViewModel getMeaSemRegViewModel() {
        return (MeaSemRegViewModel) this.meaSemRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogMeaSemRegBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CurrentSemSpinnerAdapter getSpinnerAdapter() {
        return (CurrentSemSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: MeaSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/semregistration/mea/MeaSemRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/mea/MeaSemRegDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MeaSemRegDialog newInstance(String id) {
            MeaSemRegDialog meaSemRegDialog = new MeaSemRegDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            meaSemRegDialog.setArguments(bundle);
            return meaSemRegDialog;
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
        this._binding = DialogMeaSemRegBinding.inflate(inflater, container, false);
        DialogMeaSemRegBinding dialogMeaSemRegBinding = get_binding();
        if (dialogMeaSemRegBinding != null) {
            dialogMeaSemRegBinding.setMeaSemRegViewModel(getMeaSemRegViewModel());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = get_binding();
        if (dialogMeaSemRegBinding2 != null) {
            dialogMeaSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding3 = get_binding();
        if (dialogMeaSemRegBinding3 != null) {
            return dialogMeaSemRegBinding3.getRoot();
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
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        TextView textView2;
        TextView textView3;
        listenResponse();
        listenResponse2();
        listenViewResponse();
        listenSpinners();
        if (!Intrinsics.areEqual(this.id, "")) {
            getMeaSemRegViewModel().getData(this.id);
        }
        getMeaSemRegViewModel().getDropDowns();
        DialogMeaSemRegBinding dialogMeaSemRegBinding = get_binding();
        Spinner spinner = dialogMeaSemRegBinding != null ? dialogMeaSemRegBinding.spinnerSemesterLastAttended : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = get_binding();
        if (dialogMeaSemRegBinding2 != null && (textView3 = dialogMeaSemRegBinding2.nextOne) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MeaSemRegDialog.setUp$lambda$1(MeaSemRegDialog.this, view);
                }
            });
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding3 = get_binding();
        if (dialogMeaSemRegBinding3 != null && (textView2 = dialogMeaSemRegBinding3.backTwo) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MeaSemRegDialog.setUp$lambda$2(MeaSemRegDialog.this, view);
                }
            });
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding4 = get_binding();
        if (dialogMeaSemRegBinding4 != null && (radioGroup2 = dialogMeaSemRegBinding4.examGroup) != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i) {
                    MeaSemRegDialog.setUp$lambda$3(MeaSemRegDialog.this, radioGroup3, i);
                }
            });
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding5 = get_binding();
        if (dialogMeaSemRegBinding5 != null && (radioGroup = dialogMeaSemRegBinding5.backGroup) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$$ExternalSyntheticLambda3
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i) {
                    MeaSemRegDialog.setUp$lambda$4(MeaSemRegDialog.this, radioGroup3, i);
                }
            });
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding6 = get_binding();
        if (dialogMeaSemRegBinding6 == null || (textView = dialogMeaSemRegBinding6.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MeaSemRegDialog.setUp$lambda$5(MeaSemRegDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(MeaSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMeaSemRegBinding dialogMeaSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMeaSemRegBinding != null ? dialogMeaSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMeaSemRegBinding2 != null ? dialogMeaSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMeaSemRegBinding3 != null ? dialogMeaSemRegBinding3.universityPreviousLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMeaSemRegBinding4 != null ? dialogMeaSemRegBinding4.feeDetailsLt : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        if (this$0.finalPage) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding5 = this$0.get_binding();
            textView = dialogMeaSemRegBinding5 != null ? dialogMeaSemRegBinding5.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding6 = this$0.get_binding();
        textView = dialogMeaSemRegBinding6 != null ? dialogMeaSemRegBinding6.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(MeaSemRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMeaSemRegBinding dialogMeaSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMeaSemRegBinding != null ? dialogMeaSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMeaSemRegBinding2 != null ? dialogMeaSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMeaSemRegBinding3 != null ? dialogMeaSemRegBinding3.universityPreviousLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMeaSemRegBinding4 != null ? dialogMeaSemRegBinding4.feeDetailsLt : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        this$0.finalPage = true;
        DialogMeaSemRegBinding dialogMeaSemRegBinding5 = this$0.get_binding();
        TextView textView = dialogMeaSemRegBinding5 != null ? dialogMeaSemRegBinding5.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(MeaSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.exam_yes) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMeaSemRegBinding != null ? dialogMeaSemRegBinding.mtMonthYear : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMeaSemRegBinding2 != null ? dialogMeaSemRegBinding2.mtMonthYear : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(MeaSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMeaSemRegBinding != null ? dialogMeaSemRegBinding.mtBackPapers : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.back = string;
            return;
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMeaSemRegBinding2 != null ? dialogMeaSemRegBinding2.mtBackPapers : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.back = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(MeaSemRegDialog this$0, View view) {
        File file;
        File file2;
        HashMap<String, RequestBody> hashMap;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        Object obj;
        String str;
        TextView textView;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        TextInputEditText textInputEditText16;
        TextView textView2;
        TextView textView3;
        TextInputEditText textInputEditText17;
        TextView textView4;
        TextInputEditText textInputEditText18;
        TextView textView5;
        TextInputEditText textInputEditText19;
        TextView textView6;
        TextInputEditText textInputEditText20;
        TextInputEditText textInputEditText21;
        TextInputEditText textInputEditText22;
        TextInputEditText textInputEditText23;
        TextInputEditText textInputEditText24;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap2 = new HashMap();
        HashMap<String, RequestBody> hashMap3 = new HashMap<>();
        hashMap2.clear();
        hashMap3.clear();
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMeaSemRegBinding == null || (textInputEditText24 = dialogMeaSemRegBinding.etMonthYear) == null) ? null : textInputEditText24.getText()), "")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding2 = this$0.get_binding();
                if (dialogMeaSemRegBinding2 == null || (textInputEditText23 = dialogMeaSemRegBinding2.etMonthYear) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textInputEditText23, "Please Fill Registered Month and year!!");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding3 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMeaSemRegBinding3 == null || (textInputEditText22 = dialogMeaSemRegBinding3.etBackPaperCount) == null) ? null : textInputEditText22.getText()), "")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding4 = this$0.get_binding();
                if (dialogMeaSemRegBinding4 == null || (textInputEditText21 = dialogMeaSemRegBinding4.etBackPaperCount) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textInputEditText21, "Please specify number of back papers!!");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.feePaid, "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding5 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMeaSemRegBinding5 == null || (textInputEditText20 = dialogMeaSemRegBinding5.etBankName) == null) ? null : textInputEditText20.getText()), "")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding6 = this$0.get_binding();
                if (dialogMeaSemRegBinding6 == null || (textView6 = dialogMeaSemRegBinding6.registerBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView6, "If fee is paid \"Bank Name\" should not be blank.");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.feePaid, "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding7 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMeaSemRegBinding7 == null || (textInputEditText19 = dialogMeaSemRegBinding7.etAmountPaid) == null) ? null : textInputEditText19.getText()), "")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding8 = this$0.get_binding();
                if (dialogMeaSemRegBinding8 == null || (textView5 = dialogMeaSemRegBinding8.registerBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView5, "If fee is paid \"Amount Paid\" should not be blank.");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.feePaid, "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding9 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMeaSemRegBinding9 == null || (textInputEditText18 = dialogMeaSemRegBinding9.etModePayment) == null) ? null : textInputEditText18.getText()), "")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding10 = this$0.get_binding();
                if (dialogMeaSemRegBinding10 == null || (textView4 = dialogMeaSemRegBinding10.registerBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView4, "If fee is paid \"Mode Of Payment\" should not be blank.");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.feePaid, "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding11 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMeaSemRegBinding11 == null || (textInputEditText17 = dialogMeaSemRegBinding11.etDatePayment) == null) ? null : textInputEditText17.getText()), "")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding12 = this$0.get_binding();
                if (dialogMeaSemRegBinding12 == null || (textView3 = dialogMeaSemRegBinding12.registerBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView3, "If fee is paid \"Date Of Payment\" should not be blank.");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.feePaid, "Yes") && !this$0.pickedFile) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding13 = this$0.get_binding();
            if (dialogMeaSemRegBinding13 == null || (textView2 = dialogMeaSemRegBinding13.registerBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView2, "If fee is paid then the Receipt should be uploaded");
            return;
        }
        if (Intrinsics.areEqual(this$0.feePaid, "No")) {
            if (Intrinsics.areEqual(this$0.id, "")) {
                obj = "";
                str = "SemesterRegistration[payment_reference_no]";
            } else {
                obj = "";
                String str2 = this$0.id;
                Intrinsics.checkNotNull(str2);
                str = "SemesterRegistration[payment_reference_no]";
                hashMap2.put("id", str2);
            }
            HashMap hashMap4 = hashMap2;
            hashMap4.put("SemesterRegistration[semester_id]", this$0.semester_id);
            hashMap4.put("SemesterRegistration[exam_appear]", this$0.reg);
            hashMap4.put("SemesterRegistration[backpaper]", this$0.back);
            if (Intrinsics.areEqual(this$0.reg, "Yes")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding14 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[exam_month_year]", String.valueOf((dialogMeaSemRegBinding14 == null || (textInputEditText16 = dialogMeaSemRegBinding14.etMonthYear) == null) ? null : textInputEditText16.getText()));
            }
            if (Intrinsics.areEqual(this$0.back, "Yes")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding15 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[backlogs_count]", String.valueOf((dialogMeaSemRegBinding15 == null || (textInputEditText15 = dialogMeaSemRegBinding15.etBackPaperCount) == null) ? null : textInputEditText15.getText()));
            }
            hashMap4.put("SemesterRegistration[fee_paid]", this$0.feePaid);
            if (Intrinsics.areEqual(this$0.feePaid, "Yes")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding16 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[bank_name]", String.valueOf((dialogMeaSemRegBinding16 == null || (textInputEditText14 = dialogMeaSemRegBinding16.etBankName) == null) ? null : textInputEditText14.getText()));
                DialogMeaSemRegBinding dialogMeaSemRegBinding17 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[amount_paid]", String.valueOf((dialogMeaSemRegBinding17 == null || (textInputEditText13 = dialogMeaSemRegBinding17.etAmountPaid) == null) ? null : textInputEditText13.getText()));
                DialogMeaSemRegBinding dialogMeaSemRegBinding18 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[payment_date]", String.valueOf((dialogMeaSemRegBinding18 == null || (textInputEditText12 = dialogMeaSemRegBinding18.etDatePayment) == null) ? null : textInputEditText12.getText()));
                DialogMeaSemRegBinding dialogMeaSemRegBinding19 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[payment_mode]", String.valueOf((dialogMeaSemRegBinding19 == null || (textInputEditText11 = dialogMeaSemRegBinding19.etModePayment) == null) ? null : textInputEditText11.getText()));
                DialogMeaSemRegBinding dialogMeaSemRegBinding20 = this$0.get_binding();
                hashMap4.put(str, String.valueOf((dialogMeaSemRegBinding20 == null || (textInputEditText10 = dialogMeaSemRegBinding20.etRefNo) == null) ? null : textInputEditText10.getText()));
            }
            hashMap4.put("SemesterRegistration[fee_concession]", this$0.feeConcession);
            if (Intrinsics.areEqual(this$0.feeConcession, "Yes")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding21 = this$0.get_binding();
                hashMap4.put("SemesterRegistration[fee_concession_category]", String.valueOf((dialogMeaSemRegBinding21 == null || (textInputEditText9 = dialogMeaSemRegBinding21.etConcessionDetails) == null) ? null : textInputEditText9.getText()));
            }
            if (Intrinsics.areEqual(this$0.feePaid, "No") && Intrinsics.areEqual(this$0.feeConcession, "No")) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding22 = this$0.get_binding();
                if (dialogMeaSemRegBinding22 == null || (textView = dialogMeaSemRegBinding22.registerBtn) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textView, "You should either have concesion or fee sshould be paid. Both cannot be selected 'No' at the same time");
                return;
            }
            if (Intrinsics.areEqual(this$0.feePaid, "No") && !Intrinsics.areEqual(this$0.id, obj)) {
                MeaSemRegViewModel meaSemRegViewModel = this$0.getMeaSemRegViewModel();
                String str3 = this$0.id;
                Intrinsics.checkNotNull(str3);
                meaSemRegViewModel.registerWithoutReceipt(str3, hashMap4);
                return;
            }
            System.out.println(hashMap2);
            this$0.getMeaSemRegViewModel().registerWithoutReceipt(hashMap4);
            return;
        }
        HashMap<String, RequestBody> hashMap5 = hashMap3;
        hashMap5.put("SemesterRegistration[semester_id]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.semester_id));
        hashMap5.put("SemesterRegistration[exam_appear]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.reg));
        hashMap5.put("SemesterRegistration[backpaper]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.back));
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            RequestBody.Companion companion = RequestBody.INSTANCE;
            MediaType mediaType = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding23 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[exam_month_year]", companion.create(mediaType, String.valueOf((dialogMeaSemRegBinding23 == null || (textInputEditText8 = dialogMeaSemRegBinding23.etMonthYear) == null) ? null : textInputEditText8.getText())));
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            RequestBody.Companion companion2 = RequestBody.INSTANCE;
            MediaType mediaType2 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding24 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[backlogs_count]", companion2.create(mediaType2, String.valueOf((dialogMeaSemRegBinding24 == null || (textInputEditText7 = dialogMeaSemRegBinding24.etBackPaperCount) == null) ? null : textInputEditText7.getText())));
        }
        hashMap5.put("SemesterRegistration[fee_paid]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.feePaid));
        if (Intrinsics.areEqual(this$0.feePaid, "Yes")) {
            RequestBody.Companion companion3 = RequestBody.INSTANCE;
            MediaType mediaType3 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding25 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[bank_name]", companion3.create(mediaType3, String.valueOf((dialogMeaSemRegBinding25 == null || (textInputEditText6 = dialogMeaSemRegBinding25.etBankName) == null) ? null : textInputEditText6.getText())));
            RequestBody.Companion companion4 = RequestBody.INSTANCE;
            MediaType mediaType4 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding26 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[amount_paid]", companion4.create(mediaType4, String.valueOf((dialogMeaSemRegBinding26 == null || (textInputEditText5 = dialogMeaSemRegBinding26.etAmountPaid) == null) ? null : textInputEditText5.getText())));
            RequestBody.Companion companion5 = RequestBody.INSTANCE;
            MediaType mediaType5 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding27 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[payment_date]", companion5.create(mediaType5, String.valueOf((dialogMeaSemRegBinding27 == null || (textInputEditText4 = dialogMeaSemRegBinding27.etDatePayment) == null) ? null : textInputEditText4.getText())));
            RequestBody.Companion companion6 = RequestBody.INSTANCE;
            MediaType mediaType6 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding28 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[payment_mode]", companion6.create(mediaType6, String.valueOf((dialogMeaSemRegBinding28 == null || (textInputEditText3 = dialogMeaSemRegBinding28.etModePayment) == null) ? null : textInputEditText3.getText())));
            RequestBody.Companion companion7 = RequestBody.INSTANCE;
            MediaType mediaType7 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding29 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[payment_reference_no]", companion7.create(mediaType7, String.valueOf((dialogMeaSemRegBinding29 == null || (textInputEditText2 = dialogMeaSemRegBinding29.etRefNo) == null) ? null : textInputEditText2.getText())));
        }
        hashMap5.put("SemesterRegistration[fee_concession]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.feeConcession));
        if (Intrinsics.areEqual(this$0.feeConcession, "Yes")) {
            RequestBody.Companion companion8 = RequestBody.INSTANCE;
            MediaType mediaType8 = MultipartBody.FORM;
            DialogMeaSemRegBinding dialogMeaSemRegBinding30 = this$0.get_binding();
            hashMap5.put("SemesterRegistration[fee_concession_category]", companion8.create(mediaType8, String.valueOf((dialogMeaSemRegBinding30 == null || (textInputEditText = dialogMeaSemRegBinding30.etConcessionDetails) == null) ? null : textInputEditText.getText())));
        }
        if (Intrinsics.areEqual(this$0.feePaid, "Yes") && !Intrinsics.areEqual(this$0.id, "")) {
            RequestBody.Companion companion9 = RequestBody.INSTANCE;
            MediaType mediaType9 = MultipartBody.FORM;
            String str4 = this$0.id;
            Intrinsics.checkNotNull(str4);
            RequestBody create = companion9.create(mediaType9, str4);
            MeaSemRegViewModel meaSemRegViewModel2 = this$0.getMeaSemRegViewModel();
            File file3 = this$0.pickFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                hashMap = hashMap3;
                file2 = null;
            } else {
                file2 = file3;
                hashMap = hashMap3;
            }
            meaSemRegViewModel2.registerWithReceipt(create, hashMap, file2);
            return;
        }
        MeaSemRegViewModel meaSemRegViewModel3 = this$0.getMeaSemRegViewModel();
        File file4 = this$0.pickFile;
        if (file4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
            file = null;
        } else {
            file = file4;
        }
        meaSemRegViewModel3.registerWithReceipt(hashMap3, file);
    }

    private final void listenViewResponse() {
        getMeaSemRegViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MeaSemRegDialog.listenViewResponse$lambda$7(MeaSemRegDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenViewResponse$lambda$7(MeaSemRegDialog this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SemRegViewResponse semRegViewResponse = (SemRegViewResponse) resource.getData();
            if (semRegViewResponse != null) {
                this$0.loadView(semRegViewResponse);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        DialogMeaSemRegBinding dialogMeaSemRegBinding = this$0.get_binding();
        if (dialogMeaSemRegBinding == null || (textView = dialogMeaSemRegBinding.registerBtn) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    private final void loadView(SemRegViewResponse response) {
        TextInputLayout textInputLayout;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        DialogMeaSemRegBinding dialogMeaSemRegBinding = get_binding();
        if (dialogMeaSemRegBinding != null && (textInputEditText9 = dialogMeaSemRegBinding.etBackPaperCount) != null) {
            textInputEditText9.setText(response.getBackPaperCount());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding2 = get_binding();
        if (dialogMeaSemRegBinding2 != null && (textInputEditText8 = dialogMeaSemRegBinding2.etMonthYear) != null) {
            textInputEditText8.setText(response.getExamMonthYear());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding3 = get_binding();
        if (dialogMeaSemRegBinding3 != null && (textInputEditText7 = dialogMeaSemRegBinding3.etEarnedCredits) != null) {
            textInputEditText7.setText(response.getEarnedCredits());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding4 = get_binding();
        if (dialogMeaSemRegBinding4 != null && (textInputEditText6 = dialogMeaSemRegBinding4.etBankName) != null) {
            textInputEditText6.setText(response.getBankName());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding5 = get_binding();
        if (dialogMeaSemRegBinding5 != null && (textInputEditText5 = dialogMeaSemRegBinding5.etAmountPaid) != null) {
            textInputEditText5.setText(response.getAmountPaid());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding6 = get_binding();
        if (dialogMeaSemRegBinding6 != null && (textInputEditText4 = dialogMeaSemRegBinding6.etModePayment) != null) {
            textInputEditText4.setText(response.getPaymentMode());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding7 = get_binding();
        if (dialogMeaSemRegBinding7 != null && (textInputEditText3 = dialogMeaSemRegBinding7.etDatePayment) != null) {
            textInputEditText3.setText(response.getPaymentDate());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding8 = get_binding();
        if (dialogMeaSemRegBinding8 != null && (textInputEditText2 = dialogMeaSemRegBinding8.etRefNo) != null) {
            textInputEditText2.setText(response.getPaymentReferenceNo());
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding9 = get_binding();
        if (dialogMeaSemRegBinding9 != null && (textInputEditText = dialogMeaSemRegBinding9.etConcessionDetails) != null) {
            textInputEditText.setText(response.getFeeConcessionCategory());
        }
        if (Intrinsics.areEqual(response.getFeePaid(), "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding10 = get_binding();
            RadioButton radioButton = dialogMeaSemRegBinding10 != null ? dialogMeaSemRegBinding10.feeYes : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding11 = get_binding();
            RadioButton radioButton2 = dialogMeaSemRegBinding11 != null ? dialogMeaSemRegBinding11.feeNo : null;
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding12 = get_binding();
            TextInputLayout textInputLayout2 = dialogMeaSemRegBinding12 != null ? dialogMeaSemRegBinding12.mtBankName : null;
            if (textInputLayout2 != null) {
                textInputLayout2.setVisibility(0);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding13 = get_binding();
            TextInputLayout textInputLayout3 = dialogMeaSemRegBinding13 != null ? dialogMeaSemRegBinding13.mtAmountPaid : null;
            if (textInputLayout3 != null) {
                textInputLayout3.setVisibility(0);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding14 = get_binding();
            TextInputLayout textInputLayout4 = dialogMeaSemRegBinding14 != null ? dialogMeaSemRegBinding14.mtDatePayment : null;
            if (textInputLayout4 != null) {
                textInputLayout4.setVisibility(0);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding15 = get_binding();
            TextInputLayout textInputLayout5 = dialogMeaSemRegBinding15 != null ? dialogMeaSemRegBinding15.mtModePayment : null;
            if (textInputLayout5 != null) {
                textInputLayout5.setVisibility(0);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding16 = get_binding();
            TextInputLayout textInputLayout6 = dialogMeaSemRegBinding16 != null ? dialogMeaSemRegBinding16.mtRefNo : null;
            if (textInputLayout6 != null) {
                textInputLayout6.setVisibility(0);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding17 = get_binding();
            TextView textView = dialogMeaSemRegBinding17 != null ? dialogMeaSemRegBinding17.completionFileName : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding18 = get_binding();
            LinearLayout linearLayout = dialogMeaSemRegBinding18 != null ? dialogMeaSemRegBinding18.uploadLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            DialogMeaSemRegBinding dialogMeaSemRegBinding19 = get_binding();
            RadioButton radioButton3 = dialogMeaSemRegBinding19 != null ? dialogMeaSemRegBinding19.feeYes : null;
            if (radioButton3 != null) {
                radioButton3.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding20 = get_binding();
            RadioButton radioButton4 = dialogMeaSemRegBinding20 != null ? dialogMeaSemRegBinding20.feeNo : null;
            if (radioButton4 != null) {
                radioButton4.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding21 = get_binding();
            TextInputLayout textInputLayout7 = dialogMeaSemRegBinding21 != null ? dialogMeaSemRegBinding21.mtBankName : null;
            if (textInputLayout7 != null) {
                textInputLayout7.setVisibility(8);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding22 = get_binding();
            TextInputLayout textInputLayout8 = dialogMeaSemRegBinding22 != null ? dialogMeaSemRegBinding22.mtAmountPaid : null;
            if (textInputLayout8 != null) {
                textInputLayout8.setVisibility(8);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding23 = get_binding();
            TextInputLayout textInputLayout9 = dialogMeaSemRegBinding23 != null ? dialogMeaSemRegBinding23.mtDatePayment : null;
            if (textInputLayout9 != null) {
                textInputLayout9.setVisibility(8);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding24 = get_binding();
            TextInputLayout textInputLayout10 = dialogMeaSemRegBinding24 != null ? dialogMeaSemRegBinding24.mtModePayment : null;
            if (textInputLayout10 != null) {
                textInputLayout10.setVisibility(8);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding25 = get_binding();
            TextInputLayout textInputLayout11 = dialogMeaSemRegBinding25 != null ? dialogMeaSemRegBinding25.mtRefNo : null;
            if (textInputLayout11 != null) {
                textInputLayout11.setVisibility(8);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding26 = get_binding();
            TextView textView2 = dialogMeaSemRegBinding26 != null ? dialogMeaSemRegBinding26.completionFileName : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding27 = get_binding();
            LinearLayout linearLayout2 = dialogMeaSemRegBinding27 != null ? dialogMeaSemRegBinding27.uploadLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getFeeConcession(), "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding28 = get_binding();
            RadioButton radioButton5 = dialogMeaSemRegBinding28 != null ? dialogMeaSemRegBinding28.concessionYes : null;
            if (radioButton5 != null) {
                radioButton5.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding29 = get_binding();
            RadioButton radioButton6 = dialogMeaSemRegBinding29 != null ? dialogMeaSemRegBinding29.concessionNo : null;
            if (radioButton6 != null) {
                radioButton6.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding30 = get_binding();
            TextInputLayout textInputLayout12 = dialogMeaSemRegBinding30 != null ? dialogMeaSemRegBinding30.mtConcessionDetsils : null;
            if (textInputLayout12 != null) {
                textInputLayout12.setVisibility(0);
            }
        } else {
            DialogMeaSemRegBinding dialogMeaSemRegBinding31 = get_binding();
            RadioButton radioButton7 = dialogMeaSemRegBinding31 != null ? dialogMeaSemRegBinding31.concessionYes : null;
            if (radioButton7 != null) {
                radioButton7.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding32 = get_binding();
            RadioButton radioButton8 = dialogMeaSemRegBinding32 != null ? dialogMeaSemRegBinding32.concessionNo : null;
            if (radioButton8 != null) {
                radioButton8.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding33 = get_binding();
            TextInputLayout textInputLayout13 = dialogMeaSemRegBinding33 != null ? dialogMeaSemRegBinding33.mtConcessionDetsils : null;
            if (textInputLayout13 != null) {
                textInputLayout13.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getExamAppear(), "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding34 = get_binding();
            RadioButton radioButton9 = dialogMeaSemRegBinding34 != null ? dialogMeaSemRegBinding34.examYes : null;
            if (radioButton9 != null) {
                radioButton9.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding35 = get_binding();
            RadioButton radioButton10 = dialogMeaSemRegBinding35 != null ? dialogMeaSemRegBinding35.examNo : null;
            if (radioButton10 != null) {
                radioButton10.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding36 = get_binding();
            TextInputLayout textInputLayout14 = dialogMeaSemRegBinding36 != null ? dialogMeaSemRegBinding36.mtMonthYear : null;
            if (textInputLayout14 != null) {
                textInputLayout14.setVisibility(0);
            }
        } else {
            DialogMeaSemRegBinding dialogMeaSemRegBinding37 = get_binding();
            RadioButton radioButton11 = dialogMeaSemRegBinding37 != null ? dialogMeaSemRegBinding37.examYes : null;
            if (radioButton11 != null) {
                radioButton11.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding38 = get_binding();
            RadioButton radioButton12 = dialogMeaSemRegBinding38 != null ? dialogMeaSemRegBinding38.examNo : null;
            if (radioButton12 != null) {
                radioButton12.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding39 = get_binding();
            TextInputLayout textInputLayout15 = dialogMeaSemRegBinding39 != null ? dialogMeaSemRegBinding39.mtMonthYear : null;
            if (textInputLayout15 != null) {
                textInputLayout15.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getBackPaper(), "Yes")) {
            DialogMeaSemRegBinding dialogMeaSemRegBinding40 = get_binding();
            RadioButton radioButton13 = dialogMeaSemRegBinding40 != null ? dialogMeaSemRegBinding40.backYes : null;
            if (radioButton13 != null) {
                radioButton13.setChecked(true);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding41 = get_binding();
            RadioButton radioButton14 = dialogMeaSemRegBinding41 != null ? dialogMeaSemRegBinding41.backNo : null;
            if (radioButton14 != null) {
                radioButton14.setChecked(false);
            }
            DialogMeaSemRegBinding dialogMeaSemRegBinding42 = get_binding();
            textInputLayout = dialogMeaSemRegBinding42 != null ? dialogMeaSemRegBinding42.mtBackPapers : null;
            if (textInputLayout == null) {
                return;
            }
            textInputLayout.setVisibility(0);
            return;
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding43 = get_binding();
        RadioButton radioButton15 = dialogMeaSemRegBinding43 != null ? dialogMeaSemRegBinding43.backYes : null;
        if (radioButton15 != null) {
            radioButton15.setChecked(false);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding44 = get_binding();
        RadioButton radioButton16 = dialogMeaSemRegBinding44 != null ? dialogMeaSemRegBinding44.backNo : null;
        if (radioButton16 != null) {
            radioButton16.setChecked(true);
        }
        DialogMeaSemRegBinding dialogMeaSemRegBinding45 = get_binding();
        textInputLayout = dialogMeaSemRegBinding45 != null ? dialogMeaSemRegBinding45.mtBackPapers : null;
        if (textInputLayout == null) {
            return;
        }
        textInputLayout.setVisibility(8);
    }

    private final void listenSpinners() {
        getMeaSemRegViewModel().getDropResponse().observe(getViewLifecycleOwner(), new MeaSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AcademicYearResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$listenSpinners$1

            /* compiled from: MeaSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AcademicYearResponse> resource) {
                invoke2((Resource<AcademicYearResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AcademicYearResponse> resource) {
                CurrentSemSpinnerAdapter spinnerAdapter;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    MeaSemRegDialog.this.hideProgress();
                    AcademicYearResponse data = resource.getData();
                    if (data != null) {
                        MeaSemRegDialog meaSemRegDialog = MeaSemRegDialog.this;
                        meaSemRegDialog.semester_id = data.getSemester_id();
                        spinnerAdapter = meaSemRegDialog.getSpinnerAdapter();
                        spinnerAdapter.addItems(CollectionsKt.arrayListOf(data.getSemester()));
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    MeaSemRegDialog.this.showProgress();
                } else if (i == 3) {
                    MeaSemRegDialog.this.hideProgress();
                } else {
                    if (i != 4) {
                        return;
                    }
                    MeaSemRegDialog.this.hideProgress();
                }
            }
        }));
    }

    private final void listenResponse() {
        getMeaSemRegViewModel().getRegisterResponse().observe(getViewLifecycleOwner(), new MeaSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SemRegSuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$listenResponse$1

            /* compiled from: MeaSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SemRegSuccessResponse> resource) {
                invoke2((Resource<SemRegSuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SemRegSuccessResponse> resource) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding;
                TextView registerBtn;
                DialogMeaSemRegBinding dialogMeaSemRegBinding2;
                MvjceSemRegDialog.AddSemRegListener addSemRegListener;
                TextView registerBtn2;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MeaSemRegDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        MeaSemRegDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        MeaSemRegDialog.this.hideProgress();
                        return;
                    }
                }
                MeaSemRegDialog.this.hideProgress();
                SemRegSuccessResponse data = resource.getData();
                if (data != null) {
                    MeaSemRegDialog meaSemRegDialog = MeaSemRegDialog.this;
                    if (data.getSuccess()) {
                        dialogMeaSemRegBinding2 = meaSemRegDialog.get_binding();
                        if (dialogMeaSemRegBinding2 != null && (registerBtn2 = dialogMeaSemRegBinding2.registerBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                            ToastExtKt.showSuccessToast(registerBtn2, data.getMessage());
                        }
                        addSemRegListener = meaSemRegDialog.listener;
                        if (addSemRegListener != null) {
                            addSemRegListener.dismiss();
                        }
                        meaSemRegDialog.dismiss();
                        return;
                    }
                    dialogMeaSemRegBinding = meaSemRegDialog.get_binding();
                    if (dialogMeaSemRegBinding == null || (registerBtn = dialogMeaSemRegBinding.registerBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                    ToastExtKt.showErrorToast(registerBtn, data.getError());
                }
            }
        }));
    }

    private final void listenResponse2() {
        getMeaSemRegViewModel().getRegResponse().observe(getViewLifecycleOwner(), new MeaSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SemRegSuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog$listenResponse2$1

            /* compiled from: MeaSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SemRegSuccessResponse> resource) {
                invoke2((Resource<SemRegSuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SemRegSuccessResponse> resource) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding;
                TextView registerBtn;
                DialogMeaSemRegBinding dialogMeaSemRegBinding2;
                MvjceSemRegDialog.AddSemRegListener addSemRegListener;
                TextView registerBtn2;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MeaSemRegDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        MeaSemRegDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        MeaSemRegDialog.this.hideProgress();
                        return;
                    }
                }
                MeaSemRegDialog.this.hideProgress();
                SemRegSuccessResponse data = resource.getData();
                if (data != null) {
                    MeaSemRegDialog meaSemRegDialog = MeaSemRegDialog.this;
                    if (data.getSuccess()) {
                        dialogMeaSemRegBinding2 = meaSemRegDialog.get_binding();
                        if (dialogMeaSemRegBinding2 != null && (registerBtn2 = dialogMeaSemRegBinding2.registerBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                            ToastExtKt.showSuccessToast(registerBtn2, data.getMessage());
                        }
                        addSemRegListener = meaSemRegDialog.listener;
                        if (addSemRegListener != null) {
                            addSemRegListener.dismiss();
                        }
                        meaSemRegDialog.dismiss();
                        return;
                    }
                    dialogMeaSemRegBinding = meaSemRegDialog.get_binding();
                    if (dialogMeaSemRegBinding == null || (registerBtn = dialogMeaSemRegBinding.registerBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                    ToastExtKt.showErrorToast(registerBtn, data.getError());
                }
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str;
        ContentResolver contentResolver2;
        String str2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                DialogMeaSemRegBinding dialogMeaSemRegBinding = get_binding();
                TextView textView = dialogMeaSemRegBinding != null ? dialogMeaSemRegBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + str2);
                }
                DialogMeaSemRegBinding dialogMeaSemRegBinding2 = get_binding();
                TextView textView2 = dialogMeaSemRegBinding2 != null ? dialogMeaSemRegBinding2.completionFileName : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                this.pickedFile = true;
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str);
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setCallBack(PalaiSemesterRegFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        MvjceSemRegDialog.AddSemRegListener addSemRegListener = this.listener;
        if (addSemRegListener != null) {
            addSemRegListener.dismiss();
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