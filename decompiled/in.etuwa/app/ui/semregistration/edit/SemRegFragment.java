package in.etuwa.app.ui.semregistration.edit;

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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SemRegFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SemRegFragment.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0005¢\u0006\u0002\u0010\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u000205H\u0014J\b\u00109\u001a\u000205H\u0014J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J\b\u0010<\u001a\u000205H\u0002J\u0010\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020?H\u0002J\"\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u0002052\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J&\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010Q\u001a\u000205H\u0016J\b\u0010R\u001a\u000205H\u0016J\u001a\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020L2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010U\u001a\u000205H\u0014J\b\u0010V\u001a\u000205H\u0014J\b\u0010W\u001a\u000205H\u0002J\b\u0010X\u001a\u000205H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b1\u00102¨\u0006Z"}, d2 = {"Lin/etuwa/app/ui/semregistration/edit/SemRegFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/SemRegFragmentBinding;", "academicCheck", "", "accountCheck", "backPaperCheck", "binding", "getBinding", "()Lin/etuwa/app/databinding/SemRegFragmentBinding;", "busCheck", "departmentCheck", "eGrandCheck", "edit", "", "examCheck", "feePaidCheck", "feeStatus", "flag", "hostelCheck", "id", "libraryCheck", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "mCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "mDay", "", "mMonth", "mYear", "pickFile", "Ljava/io/File;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "semId", "semRegViewModel", "Lin/etuwa/app/ui/semregistration/edit/SemRegViewModel;", "getSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/edit/SemRegViewModel;", "semRegViewModel$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "checkRegister", "", "doRegister", "getData", "hideBaseView", "hideProgress", "listenProgressResponse", "listenResponse", "listenSemResponse", "loadView", "response", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showDatePicker", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SemRegFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SemRegFragmentBinding _binding;
    private String academicCheck;
    private String accountCheck;
    private String backPaperCheck;
    private String busCheck;
    private String departmentCheck;
    private String eGrandCheck;
    private boolean edit;
    private String examCheck;
    private String feePaidCheck;
    private boolean feeStatus;
    private boolean flag;
    private String hostelCheck;
    private String id;
    private String libraryCheck;
    private MainCallBackListener listener;
    private final Calendar mCalendar;
    private int mDay;
    private int mMonth;
    private int mYear;
    private File pickFile;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* renamed from: semRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy semRegViewModel;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: SemRegFragment.kt */
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
    public static final SemRegFragment newInstance(String str, boolean z, boolean z2) {
        return INSTANCE.newInstance(str, z, z2);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SemRegFragment() {
        final SemRegFragment semRegFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(semRegFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.semRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(semRegFragment, Reflection.getOrCreateKotlinClass(SemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SemRegFragment semRegFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = semRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(SemRegFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = semRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        Calendar calendar = Calendar.getInstance();
        this.mCalendar = calendar;
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2) + 1;
        this.mDay = calendar.get(5);
        this.examCheck = "Yes";
        this.backPaperCheck = "Yes";
        this.feePaidCheck = "Yes";
        this.eGrandCheck = "Yes";
        this.departmentCheck = "Yes";
        this.libraryCheck = "Yes";
        this.accountCheck = "Yes";
        this.academicCheck = "Yes";
        this.hostelCheck = "Yes";
        this.busCheck = "Yes";
        this.semId = "";
    }

    private final SemRegViewModel getSemRegViewModel() {
        return (SemRegViewModel) this.semRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final SemRegFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: SemRegFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/semregistration/edit/SemRegFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/edit/SemRegFragment;", "id", "", "edit", "", "feeStatus", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SemRegFragment newInstance(String id, boolean edit, boolean feeStatus) {
            SemRegFragment semRegFragment = new SemRegFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("edit", edit);
            bundle.putBoolean("fee", feeStatus);
            bundle.putString("id", id);
            semRegFragment.setArguments(bundle);
            return semRegFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.edit = arguments.getBoolean("edit");
            this.feeStatus = arguments.getBoolean("fee");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SemRegFragmentBinding.inflate(inflater, container, false);
        SemRegFragmentBinding semRegFragmentBinding = get_binding();
        if (semRegFragmentBinding != null) {
            semRegFragmentBinding.setSemRegViewModel(getSemRegViewModel());
        }
        SemRegFragmentBinding semRegFragmentBinding2 = get_binding();
        if (semRegFragmentBinding2 != null) {
            semRegFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SemRegFragmentBinding semRegFragmentBinding3 = get_binding();
        if (semRegFragmentBinding3 != null) {
            return semRegFragmentBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        TextView textView;
        TextView textView2;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        RadioGroup radioGroup5;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        RadioGroup radioGroup8;
        TextInputEditText textInputEditText;
        RadioGroup radioGroup9;
        RadioGroup radioGroup10;
        TextView textView3;
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.sem_registration));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (window = activity2.getWindow()) != null) {
            window.addFlags(128);
        }
        SemRegFragmentBinding semRegFragmentBinding = get_binding();
        Spinner spinner = semRegFragmentBinding != null ? semRegFragmentBinding.spinnerSemReg : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        System.out.println((Object) ("Edit value is " + this.edit));
        listenResponse();
        listenProgressResponse();
        listenSemResponse();
        if (this.edit) {
            getData();
        } else {
            SemRegFragmentBinding semRegFragmentBinding2 = get_binding();
            LinearLayout linearLayout = semRegFragmentBinding2 != null ? semRegFragmentBinding2.spinnerLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SemRegFragmentBinding semRegFragmentBinding3 = get_binding();
            TextView textView4 = semRegFragmentBinding3 != null ? semRegFragmentBinding3.semLastAttended : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            SemRegFragmentBinding semRegFragmentBinding4 = get_binding();
            TextView textView5 = semRegFragmentBinding4 != null ? semRegFragmentBinding4.semLastAttended : null;
            if (textView5 != null) {
                textView5.setText(getPreference().getUserSem());
            }
            this.semId = getPreference().getUserSemId();
        }
        getSemRegViewModel().getSemester();
        SemRegFragmentBinding semRegFragmentBinding5 = get_binding();
        Spinner spinner2 = semRegFragmentBinding5 != null ? semRegFragmentBinding5.spinnerSemReg : null;
        if (spinner2 != null) {
            spinner2.setClickable(false);
        }
        SemRegFragmentBinding semRegFragmentBinding6 = get_binding();
        Spinner spinner3 = semRegFragmentBinding6 != null ? semRegFragmentBinding6.spinnerSemReg : null;
        if (spinner3 != null) {
            spinner3.setFocusable(false);
        }
        if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding7 = get_binding();
            CardView cardView = semRegFragmentBinding7 != null ? semRegFragmentBinding7.cardDue : null;
            if (cardView != null) {
                cardView.setVisibility(8);
            }
        } else {
            SemRegFragmentBinding semRegFragmentBinding8 = get_binding();
            CardView cardView2 = semRegFragmentBinding8 != null ? semRegFragmentBinding8.cardDue : null;
            if (cardView2 != null) {
                cardView2.setVisibility(0);
            }
        }
        if (this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding9 = get_binding();
            CardView cardView3 = semRegFragmentBinding9 != null ? semRegFragmentBinding9.cardFeeDetails : null;
            if (cardView3 != null) {
                cardView3.setVisibility(8);
            }
        }
        SemRegFragmentBinding semRegFragmentBinding10 = get_binding();
        if (semRegFragmentBinding10 != null && (textView3 = semRegFragmentBinding10.payFeeBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SemRegFragment.setUp$lambda$1(SemRegFragment.this, view);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding11 = get_binding();
        Spinner spinner4 = semRegFragmentBinding11 != null ? semRegFragmentBinding11.spinnerSemReg : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    boolean z;
                    SemesterSpinnerAdapter spinnerAdapter;
                    String str;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    SemRegFragmentBinding semRegFragmentBinding12;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    Spinner spinner5;
                    SemesterSpinnerAdapter spinnerAdapter4;
                    z = SemRegFragment.this.flag;
                    if (!z) {
                        SemRegFragment.this.flag = true;
                        spinnerAdapter = SemRegFragment.this.getSpinnerAdapter();
                        int count = spinnerAdapter.getCount();
                        for (int i = 0; i < count; i++) {
                            str = SemRegFragment.this.semId;
                            spinnerAdapter2 = SemRegFragment.this.getSpinnerAdapter();
                            if (Intrinsics.areEqual(str, spinnerAdapter2.getSemester(i).getId())) {
                                semRegFragmentBinding12 = SemRegFragment.this.get_binding();
                                if (semRegFragmentBinding12 != null && (spinner5 = semRegFragmentBinding12.spinnerSemReg) != null) {
                                    spinner5.setSelection(i);
                                }
                                SemRegFragment semRegFragment = SemRegFragment.this;
                                spinnerAdapter3 = semRegFragment.getSpinnerAdapter();
                                semRegFragment.semId = spinnerAdapter3.getSemester(position).getId();
                                return;
                            }
                        }
                        return;
                    }
                    SemRegFragment semRegFragment2 = SemRegFragment.this;
                    spinnerAdapter4 = semRegFragment2.getSpinnerAdapter();
                    semRegFragment2.semId = spinnerAdapter4.getSemester(position).getId();
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding12 = get_binding();
        if (semRegFragmentBinding12 != null && (radioGroup10 = semRegFragmentBinding12.examGroup) != null) {
            radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda17
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$2(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding13 = get_binding();
        if (semRegFragmentBinding13 != null && (radioGroup9 = semRegFragmentBinding13.backPaperGroup) != null) {
            radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda18
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$3(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding14 = get_binding();
        if (semRegFragmentBinding14 != null && (textInputEditText = semRegFragmentBinding14.etSemPaidDate) != null) {
            textInputEditText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SemRegFragment.setUp$lambda$4(SemRegFragment.this, view);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding15 = get_binding();
        if (semRegFragmentBinding15 != null && (radioGroup8 = semRegFragmentBinding15.feePaidGroup) != null) {
            radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$5(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding16 = get_binding();
        if (semRegFragmentBinding16 != null && (radioGroup7 = semRegFragmentBinding16.eGrandGroup) != null) {
            radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda3
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$6(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding17 = get_binding();
        if (semRegFragmentBinding17 != null && (radioGroup6 = semRegFragmentBinding17.departmentGroup) != null) {
            radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda4
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$7(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding18 = get_binding();
        if (semRegFragmentBinding18 != null && (radioGroup5 = semRegFragmentBinding18.libraryGroup) != null) {
            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda5
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$8(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding19 = get_binding();
        if (semRegFragmentBinding19 != null && (radioGroup4 = semRegFragmentBinding19.accountsGroup) != null) {
            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda6
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$9(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding20 = get_binding();
        if (semRegFragmentBinding20 != null && (radioGroup3 = semRegFragmentBinding20.academicGroup) != null) {
            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda7
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$10(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding21 = get_binding();
        if (semRegFragmentBinding21 != null && (radioGroup2 = semRegFragmentBinding21.hostelGroup) != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda13
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$11(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding22 = get_binding();
        if (semRegFragmentBinding22 != null && (radioGroup = semRegFragmentBinding22.busGroup) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda14
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    SemRegFragment.setUp$lambda$12(SemRegFragment.this, radioGroup11, i);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding23 = get_binding();
        if (semRegFragmentBinding23 != null && (textView2 = semRegFragmentBinding23.chooseFileBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SemRegFragment.setUp$lambda$14(SemRegFragment.this, view);
                }
            });
        }
        SemRegFragmentBinding semRegFragmentBinding24 = get_binding();
        if (semRegFragmentBinding24 == null || (textView = semRegFragmentBinding24.etSemSubmitBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SemRegFragment.setUp$lambda$15(SemRegFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SemRegFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://www.onlinesbi.com/sbicollect/icollecthome.htm?corpID=64644"));
            this$0.startActivity(Intent.createChooser(intent, "Open With"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.exam_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemMonthYear : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.examCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemMonthYear : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.examCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemCountBackPaper : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.backPaperCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemCountBackPaper : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.backPaperCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(SemRegFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDatePicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.fee_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            LinearLayout linearLayout = semRegFragmentBinding != null ? semRegFragmentBinding.feeLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.feePaidCheck = string;
            if (Intrinsics.areEqual(this$0.getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
                SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
                textView = semRegFragmentBinding2 != null ? semRegFragmentBinding2.payFeeBtn : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding3 = this$0.get_binding();
        LinearLayout linearLayout2 = semRegFragmentBinding3 != null ? semRegFragmentBinding3.feeLayout : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.feePaidCheck = string2;
        if (Intrinsics.areEqual(this$0.getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding4 = this$0.get_binding();
            textView = semRegFragmentBinding4 != null ? semRegFragmentBinding4.payFeeBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.e_grand_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemFeeConcessionCategory : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.eGrandCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemFeeConcessionCategory : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.eGrandCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.department_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemDepartmentDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.departmentCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemDepartmentDue : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.departmentCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.library_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemLibraryDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.libraryCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemLibraryDue : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.libraryCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.accounts_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemAccountDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.accountCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemAccountDue : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.accountCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.academic_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemAcademicDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.academicCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemAcademicDue : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.academicCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.hostel_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemHostelDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.hostelCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemHostelDue : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.hostelCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(SemRegFragment this$0, RadioGroup radioGroup, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            textInputEditText = semRegFragmentBinding != null ? semRegFragmentBinding.etSemBusDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.busCheck = string;
            return;
        }
        SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
        textInputEditText = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemBusDue : null;
        if (textInputEditText != null) {
            textInputEditText.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.busCheck = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(SemRegFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15(SemRegFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkRegister();
    }

    private final void checkRegister() {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        RadioGroup radioGroup;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        RadioGroup radioGroup2;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        RadioGroup radioGroup3;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        RadioGroup radioGroup4;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        RadioGroup radioGroup5;
        TextInputEditText textInputEditText16;
        TextInputEditText textInputEditText17;
        TextInputEditText textInputEditText18;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        TextInputEditText textInputEditText19;
        TextInputEditText textInputEditText20;
        RadioGroup radioGroup8;
        RadioGroup radioGroup9;
        TextInputEditText textInputEditText21;
        TextView textView;
        RadioGroup radioGroup10;
        TextInputEditText textInputEditText22;
        TextInputEditText textInputEditText23;
        TextInputEditText textInputEditText24;
        RadioGroup radioGroup11;
        TextInputEditText textInputEditText25;
        TextInputEditText textInputEditText26;
        TextInputEditText textInputEditText27;
        RadioGroup radioGroup12;
        TextInputEditText textInputEditText28;
        TextInputEditText textInputEditText29;
        TextInputEditText textInputEditText30;
        RadioGroup radioGroup13;
        TextInputEditText textInputEditText31;
        TextInputEditText textInputEditText32;
        TextInputEditText textInputEditText33;
        RadioGroup radioGroup14;
        TextInputEditText textInputEditText34;
        TextInputEditText textInputEditText35;
        TextInputEditText textInputEditText36;
        RadioGroup radioGroup15;
        RadioGroup radioGroup16;
        TextInputEditText textInputEditText37;
        TextInputEditText textInputEditText38;
        RadioGroup radioGroup17;
        TextInputEditText textInputEditText39;
        TextInputEditText textInputEditText40;
        RadioGroup radioGroup18;
        RadioGroup radioGroup19;
        TextInputEditText textInputEditText41;
        TextInputEditText textInputEditText42;
        RadioGroup radioGroup20;
        String baseUrl = getPreference().getBaseUrl();
        SemRegFragmentBinding semRegFragmentBinding = get_binding();
        CharSequence charSequence = null;
        if ((semRegFragmentBinding == null || (radioGroup20 = semRegFragmentBinding.examGroup) == null || radioGroup20.getCheckedRadioButtonId() != R.id.exam_yes) ? false : true) {
            SemRegFragmentBinding semRegFragmentBinding2 = get_binding();
            if (String.valueOf((semRegFragmentBinding2 == null || (textInputEditText42 = semRegFragmentBinding2.etSemMonthYear) == null) ? null : textInputEditText42.getText()).length() == 0) {
                SemRegFragmentBinding semRegFragmentBinding3 = get_binding();
                if (semRegFragmentBinding3 == null || (radioGroup19 = semRegFragmentBinding3.examGroup) == null) {
                    return;
                }
                RadioGroup radioGroup21 = radioGroup19;
                SemRegFragmentBinding semRegFragmentBinding4 = get_binding();
                if (semRegFragmentBinding4 != null && (textInputEditText41 = semRegFragmentBinding4.etSemMonthYear) != null) {
                    charSequence = textInputEditText41.getHint();
                }
                ToastExtKt.showWarningToast(radioGroup21, "Please Fill " + ((Object) charSequence));
                return;
            }
        }
        SemRegFragmentBinding semRegFragmentBinding5 = get_binding();
        if ((semRegFragmentBinding5 == null || (radioGroup18 = semRegFragmentBinding5.backPaperGroup) == null || radioGroup18.getCheckedRadioButtonId() != R.id.back_yes) ? false : true) {
            SemRegFragmentBinding semRegFragmentBinding6 = get_binding();
            if (String.valueOf((semRegFragmentBinding6 == null || (textInputEditText40 = semRegFragmentBinding6.etSemCountBackPaper) == null) ? null : textInputEditText40.getText()).length() == 0) {
                SemRegFragmentBinding semRegFragmentBinding7 = get_binding();
                if (semRegFragmentBinding7 == null || (radioGroup17 = semRegFragmentBinding7.examGroup) == null) {
                    return;
                }
                RadioGroup radioGroup22 = radioGroup17;
                SemRegFragmentBinding semRegFragmentBinding8 = get_binding();
                if (semRegFragmentBinding8 != null && (textInputEditText39 = semRegFragmentBinding8.etSemCountBackPaper) != null) {
                    charSequence = textInputEditText39.getHint();
                }
                ToastExtKt.showWarningToast(radioGroup22, "Please Fill " + ((Object) charSequence));
                return;
            }
        }
        SemRegFragmentBinding semRegFragmentBinding9 = get_binding();
        if (String.valueOf((semRegFragmentBinding9 == null || (textInputEditText38 = semRegFragmentBinding9.etSemEarnedCredit) == null) ? null : textInputEditText38.getText()).length() == 0) {
            SemRegFragmentBinding semRegFragmentBinding10 = get_binding();
            if (semRegFragmentBinding10 == null || (radioGroup16 = semRegFragmentBinding10.examGroup) == null) {
                return;
            }
            RadioGroup radioGroup23 = radioGroup16;
            SemRegFragmentBinding semRegFragmentBinding11 = get_binding();
            if (semRegFragmentBinding11 != null && (textInputEditText37 = semRegFragmentBinding11.etSemEarnedCredit) != null) {
                charSequence = textInputEditText37.getHint();
            }
            ToastExtKt.showWarningToast(radioGroup23, "Please Fill " + ((Object) charSequence));
            return;
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding12 = get_binding();
            if ((semRegFragmentBinding12 == null || (radioGroup15 = semRegFragmentBinding12.feePaidGroup) == null || radioGroup15.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding13 = get_binding();
                if (String.valueOf((semRegFragmentBinding13 == null || (textInputEditText36 = semRegFragmentBinding13.etSemBankName) == null) ? null : textInputEditText36.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding14 = get_binding();
                    if (semRegFragmentBinding14 == null || (textInputEditText34 = semRegFragmentBinding14.etSemBankName) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText43 = textInputEditText34;
                    SemRegFragmentBinding semRegFragmentBinding15 = get_binding();
                    if (semRegFragmentBinding15 != null && (textInputEditText35 = semRegFragmentBinding15.etSemBankName) != null) {
                        charSequence = textInputEditText35.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText43, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding16 = get_binding();
            if ((semRegFragmentBinding16 == null || (radioGroup14 = semRegFragmentBinding16.feePaidGroup) == null || radioGroup14.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding17 = get_binding();
                if (String.valueOf((semRegFragmentBinding17 == null || (textInputEditText33 = semRegFragmentBinding17.etSemAmount) == null) ? null : textInputEditText33.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding18 = get_binding();
                    if (semRegFragmentBinding18 == null || (textInputEditText31 = semRegFragmentBinding18.etSemAmount) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText44 = textInputEditText31;
                    SemRegFragmentBinding semRegFragmentBinding19 = get_binding();
                    if (semRegFragmentBinding19 != null && (textInputEditText32 = semRegFragmentBinding19.etSemAmount) != null) {
                        charSequence = textInputEditText32.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText44, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding20 = get_binding();
            if ((semRegFragmentBinding20 == null || (radioGroup13 = semRegFragmentBinding20.feePaidGroup) == null || radioGroup13.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding21 = get_binding();
                if (String.valueOf((semRegFragmentBinding21 == null || (textInputEditText30 = semRegFragmentBinding21.etSemPaidDate) == null) ? null : textInputEditText30.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding22 = get_binding();
                    if (semRegFragmentBinding22 == null || (textInputEditText28 = semRegFragmentBinding22.etSemPaidDate) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText45 = textInputEditText28;
                    SemRegFragmentBinding semRegFragmentBinding23 = get_binding();
                    if (semRegFragmentBinding23 != null && (textInputEditText29 = semRegFragmentBinding23.etSemPaidDate) != null) {
                        charSequence = textInputEditText29.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText45, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding24 = get_binding();
            if ((semRegFragmentBinding24 == null || (radioGroup12 = semRegFragmentBinding24.feePaidGroup) == null || radioGroup12.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding25 = get_binding();
                if (String.valueOf((semRegFragmentBinding25 == null || (textInputEditText27 = semRegFragmentBinding25.etSemModeOfPayment) == null) ? null : textInputEditText27.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding26 = get_binding();
                    if (semRegFragmentBinding26 == null || (textInputEditText25 = semRegFragmentBinding26.etSemModeOfPayment) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText46 = textInputEditText25;
                    SemRegFragmentBinding semRegFragmentBinding27 = get_binding();
                    if (semRegFragmentBinding27 != null && (textInputEditText26 = semRegFragmentBinding27.etSemModeOfPayment) != null) {
                        charSequence = textInputEditText26.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText46, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding28 = get_binding();
            if ((semRegFragmentBinding28 == null || (radioGroup11 = semRegFragmentBinding28.feePaidGroup) == null || radioGroup11.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding29 = get_binding();
                if (String.valueOf((semRegFragmentBinding29 == null || (textInputEditText24 = semRegFragmentBinding29.etSemRefNo) == null) ? null : textInputEditText24.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding30 = get_binding();
                    if (semRegFragmentBinding30 == null || (textInputEditText22 = semRegFragmentBinding30.etSemRefNo) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText47 = textInputEditText22;
                    SemRegFragmentBinding semRegFragmentBinding31 = get_binding();
                    if (semRegFragmentBinding31 != null && (textInputEditText23 = semRegFragmentBinding31.etSemRefNo) != null) {
                        charSequence = textInputEditText23.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText47, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding32 = get_binding();
            if ((semRegFragmentBinding32 == null || (radioGroup10 = semRegFragmentBinding32.feePaidGroup) == null || radioGroup10.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding33 = get_binding();
                if (String.valueOf((semRegFragmentBinding33 == null || (textView = semRegFragmentBinding33.tvSemRegFilePath) == null) ? null : textView.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding34 = get_binding();
                    if (semRegFragmentBinding34 == null || (textInputEditText21 = semRegFragmentBinding34.etSemAmount) == null) {
                        return;
                    }
                    ToastExtKt.showWarningToast(textInputEditText21, "Please Upload Receipt");
                    return;
                }
            }
        }
        if (!this.feeStatus) {
            SemRegFragmentBinding semRegFragmentBinding35 = get_binding();
            if ((semRegFragmentBinding35 == null || (radioGroup9 = semRegFragmentBinding35.feePaidGroup) == null || radioGroup9.getCheckedRadioButtonId() != R.id.fee_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding36 = get_binding();
                if ((semRegFragmentBinding36 == null || (radioGroup8 = semRegFragmentBinding36.eGrandGroup) == null || radioGroup8.getCheckedRadioButtonId() != R.id.e_grand_yes) ? false : true) {
                    SemRegFragmentBinding semRegFragmentBinding37 = get_binding();
                    if (String.valueOf((semRegFragmentBinding37 == null || (textInputEditText20 = semRegFragmentBinding37.etSemFeeConcessionCategory) == null) ? null : textInputEditText20.getText()).length() == 0) {
                        SemRegFragmentBinding semRegFragmentBinding38 = get_binding();
                        if (semRegFragmentBinding38 == null || (radioGroup7 = semRegFragmentBinding38.examGroup) == null) {
                            return;
                        }
                        RadioGroup radioGroup24 = radioGroup7;
                        SemRegFragmentBinding semRegFragmentBinding39 = get_binding();
                        if (semRegFragmentBinding39 != null && (textInputEditText19 = semRegFragmentBinding39.etSemFeeConcessionCategory) != null) {
                            charSequence = textInputEditText19.getHint();
                        }
                        ToastExtKt.showWarningToast(radioGroup24, "Please Fill " + ((Object) charSequence));
                        return;
                    }
                }
            }
        }
        if (!Intrinsics.areEqual(baseUrl, "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding40 = get_binding();
            if ((semRegFragmentBinding40 == null || (radioGroup6 = semRegFragmentBinding40.departmentGroup) == null || radioGroup6.getCheckedRadioButtonId() != R.id.department_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding41 = get_binding();
                if (String.valueOf((semRegFragmentBinding41 == null || (textInputEditText18 = semRegFragmentBinding41.etSemDepartmentDue) == null) ? null : textInputEditText18.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding42 = get_binding();
                    if (semRegFragmentBinding42 == null || (textInputEditText16 = semRegFragmentBinding42.etSemDepartmentDue) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText48 = textInputEditText16;
                    SemRegFragmentBinding semRegFragmentBinding43 = get_binding();
                    if (semRegFragmentBinding43 != null && (textInputEditText17 = semRegFragmentBinding43.etSemDepartmentDue) != null) {
                        charSequence = textInputEditText17.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText48, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!Intrinsics.areEqual(baseUrl, "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding44 = get_binding();
            if ((semRegFragmentBinding44 == null || (radioGroup5 = semRegFragmentBinding44.libraryGroup) == null || radioGroup5.getCheckedRadioButtonId() != R.id.library_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding45 = get_binding();
                if (String.valueOf((semRegFragmentBinding45 == null || (textInputEditText15 = semRegFragmentBinding45.etSemLibraryDue) == null) ? null : textInputEditText15.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding46 = get_binding();
                    if (semRegFragmentBinding46 == null || (textInputEditText13 = semRegFragmentBinding46.etSemLibraryDue) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText49 = textInputEditText13;
                    SemRegFragmentBinding semRegFragmentBinding47 = get_binding();
                    if (semRegFragmentBinding47 != null && (textInputEditText14 = semRegFragmentBinding47.etSemLibraryDue) != null) {
                        charSequence = textInputEditText14.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText49, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!Intrinsics.areEqual(baseUrl, "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding48 = get_binding();
            if ((semRegFragmentBinding48 == null || (radioGroup4 = semRegFragmentBinding48.accountsGroup) == null || radioGroup4.getCheckedRadioButtonId() != R.id.accounts_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding49 = get_binding();
                if (String.valueOf((semRegFragmentBinding49 == null || (textInputEditText12 = semRegFragmentBinding49.etSemAccountDue) == null) ? null : textInputEditText12.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding50 = get_binding();
                    if (semRegFragmentBinding50 == null || (textInputEditText10 = semRegFragmentBinding50.etSemAccountDue) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText50 = textInputEditText10;
                    SemRegFragmentBinding semRegFragmentBinding51 = get_binding();
                    if (semRegFragmentBinding51 != null && (textInputEditText11 = semRegFragmentBinding51.etSemAccountDue) != null) {
                        charSequence = textInputEditText11.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText50, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!Intrinsics.areEqual(baseUrl, "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding52 = get_binding();
            if ((semRegFragmentBinding52 == null || (radioGroup3 = semRegFragmentBinding52.academicGroup) == null || radioGroup3.getCheckedRadioButtonId() != R.id.academic_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding53 = get_binding();
                if (String.valueOf((semRegFragmentBinding53 == null || (textInputEditText9 = semRegFragmentBinding53.etSemAcademicDue) == null) ? null : textInputEditText9.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding54 = get_binding();
                    if (semRegFragmentBinding54 == null || (textInputEditText7 = semRegFragmentBinding54.etSemAcademicDue) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText51 = textInputEditText7;
                    SemRegFragmentBinding semRegFragmentBinding55 = get_binding();
                    if (semRegFragmentBinding55 != null && (textInputEditText8 = semRegFragmentBinding55.etSemAcademicDue) != null) {
                        charSequence = textInputEditText8.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText51, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!Intrinsics.areEqual(baseUrl, "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding56 = get_binding();
            if ((semRegFragmentBinding56 == null || (radioGroup2 = semRegFragmentBinding56.hostelGroup) == null || radioGroup2.getCheckedRadioButtonId() != R.id.hostel_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding57 = get_binding();
                if (String.valueOf((semRegFragmentBinding57 == null || (textInputEditText6 = semRegFragmentBinding57.etSemHostelDue) == null) ? null : textInputEditText6.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding58 = get_binding();
                    if (semRegFragmentBinding58 == null || (textInputEditText4 = semRegFragmentBinding58.etSemHostelDue) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText52 = textInputEditText4;
                    SemRegFragmentBinding semRegFragmentBinding59 = get_binding();
                    if (semRegFragmentBinding59 != null && (textInputEditText5 = semRegFragmentBinding59.etSemHostelDue) != null) {
                        charSequence = textInputEditText5.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText52, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        if (!Intrinsics.areEqual(baseUrl, "https://tkmce.etlab.in/androidapp/")) {
            SemRegFragmentBinding semRegFragmentBinding60 = get_binding();
            if ((semRegFragmentBinding60 == null || (radioGroup = semRegFragmentBinding60.busGroup) == null || radioGroup.getCheckedRadioButtonId() != R.id.bus_yes) ? false : true) {
                SemRegFragmentBinding semRegFragmentBinding61 = get_binding();
                if (String.valueOf((semRegFragmentBinding61 == null || (textInputEditText3 = semRegFragmentBinding61.etSemBusDue) == null) ? null : textInputEditText3.getText()).length() == 0) {
                    SemRegFragmentBinding semRegFragmentBinding62 = get_binding();
                    if (semRegFragmentBinding62 == null || (textInputEditText = semRegFragmentBinding62.etSemBusDue) == null) {
                        return;
                    }
                    TextInputEditText textInputEditText53 = textInputEditText;
                    SemRegFragmentBinding semRegFragmentBinding63 = get_binding();
                    if (semRegFragmentBinding63 != null && (textInputEditText2 = semRegFragmentBinding63.etSemBusDue) != null) {
                        charSequence = textInputEditText2.getHint();
                    }
                    ToastExtKt.showWarningToast(textInputEditText53, "Please Fill " + ((Object) charSequence));
                    return;
                }
            }
        }
        doRegister();
    }

    private final void doRegister() {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        HashMap<String, RequestBody> hashMap = new HashMap<>();
        HashMap<String, RequestBody> hashMap2 = hashMap;
        hashMap2.put("SemesterRegistration[semester_id]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.semId));
        hashMap2.put("SemesterRegistration[exam_appear]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.examCheck));
        if (Intrinsics.areEqual(this.examCheck, getString(R.string.yes))) {
            RequestBody.Companion companion = RequestBody.INSTANCE;
            MediaType mediaType = MultipartBody.FORM;
            SemRegFragmentBinding semRegFragmentBinding = get_binding();
            hashMap2.put("SemesterRegistration[exam_month_year]", companion.create(mediaType, String.valueOf((semRegFragmentBinding == null || (textInputEditText15 = semRegFragmentBinding.etSemMonthYear) == null) ? null : textInputEditText15.getText())));
        } else {
            hashMap2.put("SemesterRegistration[exam_month_year]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
        }
        hashMap2.put("SemesterRegistration[backpaper]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.backPaperCheck));
        if (Intrinsics.areEqual(this.backPaperCheck, getString(R.string.yes))) {
            RequestBody.Companion companion2 = RequestBody.INSTANCE;
            MediaType mediaType2 = MultipartBody.FORM;
            SemRegFragmentBinding semRegFragmentBinding2 = get_binding();
            hashMap2.put("SemesterRegistration[backlogs_count]", companion2.create(mediaType2, String.valueOf((semRegFragmentBinding2 == null || (textInputEditText14 = semRegFragmentBinding2.etSemCountBackPaper) == null) ? null : textInputEditText14.getText())));
        } else {
            hashMap2.put("SemesterRegistration[backlogs_count]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
        }
        RequestBody.Companion companion3 = RequestBody.INSTANCE;
        MediaType mediaType3 = MultipartBody.FORM;
        SemRegFragmentBinding semRegFragmentBinding3 = get_binding();
        hashMap2.put("SemesterRegistration[earned_credits]", companion3.create(mediaType3, String.valueOf((semRegFragmentBinding3 == null || (textInputEditText13 = semRegFragmentBinding3.etSemEarnedCredit) == null) ? null : textInputEditText13.getText())));
        if (!this.feeStatus) {
            hashMap2.put("SemesterRegistration[fee_paid]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.feePaidCheck));
            if (Intrinsics.areEqual(this.feePaidCheck, getString(R.string.yes))) {
                RequestBody.Companion companion4 = RequestBody.INSTANCE;
                MediaType mediaType4 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding4 = get_binding();
                hashMap2.put("SemesterRegistration[bank_name]", companion4.create(mediaType4, String.valueOf((semRegFragmentBinding4 == null || (textInputEditText12 = semRegFragmentBinding4.etSemBankName) == null) ? null : textInputEditText12.getText())));
                RequestBody.Companion companion5 = RequestBody.INSTANCE;
                MediaType mediaType5 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding5 = get_binding();
                hashMap2.put("SemesterRegistration[amount_paid]", companion5.create(mediaType5, String.valueOf((semRegFragmentBinding5 == null || (textInputEditText11 = semRegFragmentBinding5.etSemAmount) == null) ? null : textInputEditText11.getText())));
                RequestBody.Companion companion6 = RequestBody.INSTANCE;
                MediaType mediaType6 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding6 = get_binding();
                hashMap2.put("SemesterRegistration[payment_date]", companion6.create(mediaType6, String.valueOf((semRegFragmentBinding6 == null || (textInputEditText10 = semRegFragmentBinding6.etSemPaidDate) == null) ? null : textInputEditText10.getText())));
                RequestBody.Companion companion7 = RequestBody.INSTANCE;
                MediaType mediaType7 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding7 = get_binding();
                hashMap2.put("SemesterRegistration[payment_mode]", companion7.create(mediaType7, String.valueOf((semRegFragmentBinding7 == null || (textInputEditText9 = semRegFragmentBinding7.etSemModeOfPayment) == null) ? null : textInputEditText9.getText())));
                RequestBody.Companion companion8 = RequestBody.INSTANCE;
                MediaType mediaType8 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding8 = get_binding();
                hashMap2.put("SemesterRegistration[payment_reference_no]", companion8.create(mediaType8, String.valueOf((semRegFragmentBinding8 == null || (textInputEditText8 = semRegFragmentBinding8.etSemRefNo) == null) ? null : textInputEditText8.getText())));
            } else {
                hashMap2.put("SemesterRegistration[bank_name]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
                hashMap2.put("SemesterRegistration[amount_paid]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
                hashMap2.put("SemesterRegistration[payment_date]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
                hashMap2.put("SemesterRegistration[payment_mode]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
                hashMap2.put("SemesterRegistration[payment_reference_no]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
            hashMap2.put("SemesterRegistration[fee_concession]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.eGrandCheck));
            if (Intrinsics.areEqual(this.eGrandCheck, getString(R.string.yes))) {
                RequestBody.Companion companion9 = RequestBody.INSTANCE;
                MediaType mediaType9 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding9 = get_binding();
                hashMap2.put("SemesterRegistration[fee_concession_category]", companion9.create(mediaType9, String.valueOf((semRegFragmentBinding9 == null || (textInputEditText7 = semRegFragmentBinding9.etSemFeeConcessionCategory) == null) ? null : textInputEditText7.getText())));
            } else {
                hashMap2.put("SemesterRegistration[fee_concession_category]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
        }
        if (!Intrinsics.areEqual(getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
            hashMap2.put("SemesterRegistration[department_due]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.departmentCheck));
            if (Intrinsics.areEqual(this.departmentCheck, getString(R.string.yes))) {
                RequestBody.Companion companion10 = RequestBody.INSTANCE;
                MediaType mediaType10 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding10 = get_binding();
                hashMap2.put("SemesterRegistration[department_due_details]", companion10.create(mediaType10, String.valueOf((semRegFragmentBinding10 == null || (textInputEditText6 = semRegFragmentBinding10.etSemDepartmentDue) == null) ? null : textInputEditText6.getText())));
            } else {
                hashMap2.put("SemesterRegistration[department_due_details]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
            hashMap2.put("SemesterRegistration[library_due]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.libraryCheck));
            if (Intrinsics.areEqual(this.libraryCheck, getString(R.string.yes))) {
                RequestBody.Companion companion11 = RequestBody.INSTANCE;
                MediaType mediaType11 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding11 = get_binding();
                hashMap2.put("SemesterRegistration[librarary_due_details]", companion11.create(mediaType11, String.valueOf((semRegFragmentBinding11 == null || (textInputEditText5 = semRegFragmentBinding11.etSemLibraryDue) == null) ? null : textInputEditText5.getText())));
            } else {
                hashMap2.put("SemesterRegistration[librarary_due_details]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
            hashMap2.put("SemesterRegistration[accounts_due]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.accountCheck));
            if (Intrinsics.areEqual(this.accountCheck, getString(R.string.yes))) {
                RequestBody.Companion companion12 = RequestBody.INSTANCE;
                MediaType mediaType12 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding12 = get_binding();
                hashMap2.put("SemesterRegistration[accounts_due_details]", companion12.create(mediaType12, String.valueOf((semRegFragmentBinding12 == null || (textInputEditText4 = semRegFragmentBinding12.etSemAccountDue) == null) ? null : textInputEditText4.getText())));
            } else {
                hashMap2.put("SemesterRegistration[accounts_due_details]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
            hashMap2.put("SemesterRegistration[academic_due]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.academicCheck));
            if (Intrinsics.areEqual(this.academicCheck, getString(R.string.yes))) {
                RequestBody.Companion companion13 = RequestBody.INSTANCE;
                MediaType mediaType13 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding13 = get_binding();
                hashMap2.put("SemesterRegistration[academic_due_details]", companion13.create(mediaType13, String.valueOf((semRegFragmentBinding13 == null || (textInputEditText3 = semRegFragmentBinding13.etSemAcademicDue) == null) ? null : textInputEditText3.getText())));
            } else {
                hashMap2.put("SemesterRegistration[academic_due_details]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
            hashMap2.put("SemesterRegistration[hostel_due]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.hostelCheck));
            if (Intrinsics.areEqual(this.hostelCheck, getString(R.string.yes))) {
                RequestBody.Companion companion14 = RequestBody.INSTANCE;
                MediaType mediaType14 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding14 = get_binding();
                hashMap2.put("SemesterRegistration[hostel_due_details]", companion14.create(mediaType14, String.valueOf((semRegFragmentBinding14 == null || (textInputEditText2 = semRegFragmentBinding14.etSemHostelDue) == null) ? null : textInputEditText2.getText())));
            } else {
                hashMap2.put("SemesterRegistration[hostel_due_details]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
            hashMap2.put("SemesterRegistration[bus_due]", RequestBody.INSTANCE.create(MultipartBody.FORM, this.busCheck));
            if (Intrinsics.areEqual(this.busCheck, getString(R.string.yes))) {
                RequestBody.Companion companion15 = RequestBody.INSTANCE;
                MediaType mediaType15 = MultipartBody.FORM;
                SemRegFragmentBinding semRegFragmentBinding15 = get_binding();
                hashMap2.put("SemesterRegistration[bus_due_details]", companion15.create(mediaType15, String.valueOf((semRegFragmentBinding15 == null || (textInputEditText = semRegFragmentBinding15.etSemBusDue) == null) ? null : textInputEditText.getText())));
            } else {
                hashMap2.put("SemesterRegistration[bus_due_details]", RequestBody.INSTANCE.create(MultipartBody.FORM, ""));
            }
        }
        try {
            if (this.pickFile != null) {
                SemRegFragmentBinding semRegFragmentBinding16 = get_binding();
                LinearLayout linearLayout = semRegFragmentBinding16 != null ? semRegFragmentBinding16.progressView : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            }
            if (this.edit) {
                RequestBody.Companion companion16 = RequestBody.INSTANCE;
                MediaType mediaType16 = MultipartBody.FORM;
                String str = this.id;
                Intrinsics.checkNotNull(str);
                getSemRegViewModel().updateRegister(companion16.create(mediaType16, str), hashMap, this.pickFile);
                return;
            }
            getSemRegViewModel().register(hashMap, this.pickFile);
        } catch (Exception e) {
            System.out.println((Object) ("================================================ " + e.getMessage()));
        }
    }

    private final void showDatePicker() {
        new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda8
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                SemRegFragment.showDatePicker$lambda$17(SemRegFragment.this, datePicker, i, i2, i3);
            }
        }, this.mCalendar.get(1), this.mCalendar.get(2), this.mCalendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDatePicker$lambda$17(SemRegFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(datePicker, "<anonymous parameter 0>");
        this$0.mDay = i3;
        this$0.mMonth = i2;
        this$0.mYear = i;
        SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
        if (semRegFragmentBinding == null || (textInputEditText = semRegFragmentBinding.etSemPaidDate) == null) {
            return;
        }
        textInputEditText.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    private final void listenProgressResponse() {
        getSemRegViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegFragment.listenProgressResponse$lambda$19(SemRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$19(SemRegFragment this$0, Resource resource) {
        TextInputEditText textInputEditText;
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
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            if (semRegFragmentBinding == null || (textInputEditText = semRegFragmentBinding.etSemPaidDate) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textInputEditText, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
            ProgressBar progressBar = semRegFragmentBinding2 != null ? semRegFragmentBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            SemRegFragmentBinding semRegFragmentBinding3 = this$0.get_binding();
            TextView textView = semRegFragmentBinding3 != null ? semRegFragmentBinding3.progressText : null;
            if (textView != null) {
                textView.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                SemRegFragmentBinding semRegFragmentBinding4 = this$0.get_binding();
                LinearLayout linearLayout = semRegFragmentBinding4 != null ? semRegFragmentBinding4.progressView : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this$0.showProgress();
            }
        }
    }

    private final void listenResponse() {
        getSemRegViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegFragment.listenResponse$lambda$21(SemRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$21(SemRegFragment this$0, Resource resource) {
        LinearLayout linearLayout;
        TextInputEditText etSemPaidDate;
        TextInputEditText etSemPaidDate2;
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
                linearLayout = semRegFragmentBinding != null ? semRegFragmentBinding.progressView : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(8);
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
            linearLayout = semRegFragmentBinding2 != null ? semRegFragmentBinding2.progressView : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SemRegFragmentBinding semRegFragmentBinding3 = this$0.get_binding();
            if (semRegFragmentBinding3 == null || (textInputEditText = semRegFragmentBinding3.etSemPaidDate) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textInputEditText, message);
            return;
        }
        this$0.hideProgress();
        SemRegSuccessResponse semRegSuccessResponse = (SemRegSuccessResponse) resource.getData();
        if (semRegSuccessResponse != null) {
            if (semRegSuccessResponse.getSuccess()) {
                SemRegFragmentBinding semRegFragmentBinding4 = this$0.get_binding();
                linearLayout = semRegFragmentBinding4 != null ? semRegFragmentBinding4.progressView : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                SemRegFragmentBinding semRegFragmentBinding5 = this$0.get_binding();
                if (semRegFragmentBinding5 != null && (etSemPaidDate2 = semRegFragmentBinding5.etSemPaidDate) != null) {
                    Intrinsics.checkNotNullExpressionValue(etSemPaidDate2, "etSemPaidDate");
                    ToastExtKt.showSuccessToast(etSemPaidDate2, semRegSuccessResponse.getMessage());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.onFinishSemRegistration(this$0.id, this$0.edit);
                    return;
                }
                return;
            }
            SemRegFragmentBinding semRegFragmentBinding6 = this$0.get_binding();
            linearLayout = semRegFragmentBinding6 != null ? semRegFragmentBinding6.progressView : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SemRegFragmentBinding semRegFragmentBinding7 = this$0.get_binding();
            if (semRegFragmentBinding7 == null || (etSemPaidDate = semRegFragmentBinding7.etSemPaidDate) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(etSemPaidDate, "etSemPaidDate");
            ToastExtKt.showErrorToast(etSemPaidDate, semRegSuccessResponse.getMessage());
        }
    }

    private final void getData() {
        getSemRegViewModel().getData(this.id);
        getSemRegViewModel().getDataResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegFragment.getData$lambda$23(SemRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$23(SemRegFragment this$0, Resource resource) {
        TextView textView;
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.hideBaseView();
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            if (semRegFragmentBinding == null || (textInputEditText = semRegFragmentBinding.etSemPaidDate) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textInputEditText, message);
            return;
        }
        this$0.hideProgress();
        SemRegViewResponse semRegViewResponse = (SemRegViewResponse) resource.getData();
        if (semRegViewResponse != null) {
            if (this$0.edit) {
                SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
                LinearLayout linearLayout = semRegFragmentBinding2 != null ? semRegFragmentBinding2.spinnerLayout : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                SemRegFragmentBinding semRegFragmentBinding3 = this$0.get_binding();
                TextView textView2 = semRegFragmentBinding3 != null ? semRegFragmentBinding3.semLastAttended : null;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                this$0.semId = semRegViewResponse.getLastAttendedSem();
                this$0.getSpinnerAdapter().addItems(semRegViewResponse.getSemList());
                SemRegFragmentBinding semRegFragmentBinding4 = this$0.get_binding();
                textView = semRegFragmentBinding4 != null ? semRegFragmentBinding4.semLastAttended : null;
                if (textView != null) {
                    textView.setText(semRegViewResponse.getLastAttendedSemText());
                }
                this$0.semId = semRegViewResponse.getLastAttendedSem();
                this$0.loadView(semRegViewResponse);
                return;
            }
            SemRegFragmentBinding semRegFragmentBinding5 = this$0.get_binding();
            LinearLayout linearLayout2 = semRegFragmentBinding5 != null ? semRegFragmentBinding5.spinnerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            SemRegFragmentBinding semRegFragmentBinding6 = this$0.get_binding();
            textView = semRegFragmentBinding6 != null ? semRegFragmentBinding6.semLastAttended : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
            this$0.semId = semRegViewResponse.getLastAttendedSem();
            this$0.getSpinnerAdapter().addItems(semRegViewResponse.getSemList());
        }
    }

    private final void loadView(SemRegViewResponse response) {
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        RadioGroup radioGroup5;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        RadioGroup radioGroup8;
        RadioGroup radioGroup9;
        TextInputEditText textInputEditText;
        RadioGroup radioGroup10;
        TextInputEditText textInputEditText2;
        RadioGroup radioGroup11;
        TextInputEditText textInputEditText3;
        RadioGroup radioGroup12;
        TextInputEditText textInputEditText4;
        RadioGroup radioGroup13;
        TextInputEditText textInputEditText5;
        RadioGroup radioGroup14;
        TextInputEditText textInputEditText6;
        RadioGroup radioGroup15;
        TextInputEditText textInputEditText7;
        RadioGroup radioGroup16;
        TextInputEditText textInputEditText8;
        RadioGroup radioGroup17;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        RadioGroup radioGroup18;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        RadioGroup radioGroup19;
        TextInputEditText textInputEditText16;
        RadioGroup radioGroup20;
        if (StringsKt.equals(response.getExamAppear(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding = get_binding();
            if (semRegFragmentBinding != null && (radioGroup20 = semRegFragmentBinding.examGroup) != null) {
                radioGroup20.check(R.id.exam_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding2 = get_binding();
            TextInputEditText textInputEditText17 = semRegFragmentBinding2 != null ? semRegFragmentBinding2.etSemMonthYear : null;
            if (textInputEditText17 != null) {
                textInputEditText17.setVisibility(0);
            }
            String string = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this.examCheck = string;
        } else {
            SemRegFragmentBinding semRegFragmentBinding3 = get_binding();
            if (semRegFragmentBinding3 != null && (radioGroup = semRegFragmentBinding3.examGroup) != null) {
                radioGroup.check(R.id.exam_no);
            }
            SemRegFragmentBinding semRegFragmentBinding4 = get_binding();
            TextInputEditText textInputEditText18 = semRegFragmentBinding4 != null ? semRegFragmentBinding4.etSemMonthYear : null;
            if (textInputEditText18 != null) {
                textInputEditText18.setVisibility(8);
            }
            String string2 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
            this.examCheck = string2;
        }
        SemRegFragmentBinding semRegFragmentBinding5 = get_binding();
        if (semRegFragmentBinding5 != null && (textInputEditText16 = semRegFragmentBinding5.etSemMonthYear) != null) {
            textInputEditText16.setText(response.getExamMonthYear());
        }
        if (StringsKt.equals(response.getBackPaper(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding6 = get_binding();
            if (semRegFragmentBinding6 != null && (radioGroup19 = semRegFragmentBinding6.backPaperGroup) != null) {
                radioGroup19.check(R.id.back_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding7 = get_binding();
            TextInputEditText textInputEditText19 = semRegFragmentBinding7 != null ? semRegFragmentBinding7.etSemCountBackPaper : null;
            if (textInputEditText19 != null) {
                textInputEditText19.setVisibility(0);
            }
            String string3 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.yes)");
            this.backPaperCheck = string3;
        } else {
            SemRegFragmentBinding semRegFragmentBinding8 = get_binding();
            if (semRegFragmentBinding8 != null && (radioGroup2 = semRegFragmentBinding8.backPaperGroup) != null) {
                radioGroup2.check(R.id.back_no);
            }
            SemRegFragmentBinding semRegFragmentBinding9 = get_binding();
            TextInputEditText textInputEditText20 = semRegFragmentBinding9 != null ? semRegFragmentBinding9.etSemCountBackPaper : null;
            if (textInputEditText20 != null) {
                textInputEditText20.setVisibility(8);
            }
            String string4 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.no)");
            this.backPaperCheck = string4;
        }
        SemRegFragmentBinding semRegFragmentBinding10 = get_binding();
        if (semRegFragmentBinding10 != null && (textInputEditText15 = semRegFragmentBinding10.etSemCountBackPaper) != null) {
            textInputEditText15.setText(response.getBackPaperCount());
        }
        SemRegFragmentBinding semRegFragmentBinding11 = get_binding();
        if (semRegFragmentBinding11 != null && (textInputEditText14 = semRegFragmentBinding11.etSemEarnedCredit) != null) {
            textInputEditText14.setText(response.getEarnedCredits());
        }
        if (StringsKt.equals(response.getFeePaid(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding12 = get_binding();
            if (semRegFragmentBinding12 != null && (radioGroup18 = semRegFragmentBinding12.feePaidGroup) != null) {
                radioGroup18.check(R.id.fee_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding13 = get_binding();
            LinearLayout linearLayout = semRegFragmentBinding13 != null ? semRegFragmentBinding13.feeLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            String string5 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.yes)");
            this.feePaidCheck = string5;
            if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
                SemRegFragmentBinding semRegFragmentBinding14 = get_binding();
                TextView textView = semRegFragmentBinding14 != null ? semRegFragmentBinding14.payFeeBtn : null;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
        } else {
            SemRegFragmentBinding semRegFragmentBinding15 = get_binding();
            if (semRegFragmentBinding15 != null && (radioGroup3 = semRegFragmentBinding15.feePaidGroup) != null) {
                radioGroup3.check(R.id.fee_no);
            }
            SemRegFragmentBinding semRegFragmentBinding16 = get_binding();
            LinearLayout linearLayout2 = semRegFragmentBinding16 != null ? semRegFragmentBinding16.feeLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            String string6 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.no)");
            this.feePaidCheck = string6;
            if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
                SemRegFragmentBinding semRegFragmentBinding17 = get_binding();
                TextView textView2 = semRegFragmentBinding17 != null ? semRegFragmentBinding17.payFeeBtn : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
        }
        SemRegFragmentBinding semRegFragmentBinding18 = get_binding();
        if (semRegFragmentBinding18 != null && (textInputEditText13 = semRegFragmentBinding18.etSemBankName) != null) {
            textInputEditText13.setText(response.getBankName());
        }
        SemRegFragmentBinding semRegFragmentBinding19 = get_binding();
        if (semRegFragmentBinding19 != null && (textInputEditText12 = semRegFragmentBinding19.etSemAmount) != null) {
            textInputEditText12.setText(response.getAmountPaid());
        }
        SemRegFragmentBinding semRegFragmentBinding20 = get_binding();
        if (semRegFragmentBinding20 != null && (textInputEditText11 = semRegFragmentBinding20.etSemPaidDate) != null) {
            textInputEditText11.setText(response.getPaymentDate());
        }
        SemRegFragmentBinding semRegFragmentBinding21 = get_binding();
        if (semRegFragmentBinding21 != null && (textInputEditText10 = semRegFragmentBinding21.etSemModeOfPayment) != null) {
            textInputEditText10.setText(response.getPaymentMode());
        }
        SemRegFragmentBinding semRegFragmentBinding22 = get_binding();
        if (semRegFragmentBinding22 != null && (textInputEditText9 = semRegFragmentBinding22.etSemRefNo) != null) {
            textInputEditText9.setText(response.getPaymentReferenceNo());
        }
        SemRegFragmentBinding semRegFragmentBinding23 = get_binding();
        TextView textView3 = semRegFragmentBinding23 != null ? semRegFragmentBinding23.tvSemRegFilePath : null;
        if (textView3 != null) {
            String substring = response.getFeeReceiptFile().substring(StringsKt.lastIndexOf$default((CharSequence) response.getFeeReceiptFile(), RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            textView3.setText(substring);
        }
        if (StringsKt.equals(response.getFeeConcession(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding24 = get_binding();
            if (semRegFragmentBinding24 != null && (radioGroup17 = semRegFragmentBinding24.eGrandGroup) != null) {
                radioGroup17.check(R.id.e_grand_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding25 = get_binding();
            TextInputEditText textInputEditText21 = semRegFragmentBinding25 != null ? semRegFragmentBinding25.etSemFeeConcessionCategory : null;
            if (textInputEditText21 != null) {
                textInputEditText21.setVisibility(0);
            }
            String string7 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.yes)");
            this.eGrandCheck = string7;
        } else {
            SemRegFragmentBinding semRegFragmentBinding26 = get_binding();
            if (semRegFragmentBinding26 != null && (radioGroup4 = semRegFragmentBinding26.eGrandGroup) != null) {
                radioGroup4.check(R.id.e_grand_no);
            }
            SemRegFragmentBinding semRegFragmentBinding27 = get_binding();
            TextInputEditText textInputEditText22 = semRegFragmentBinding27 != null ? semRegFragmentBinding27.etSemFeeConcessionCategory : null;
            if (textInputEditText22 != null) {
                textInputEditText22.setVisibility(8);
            }
            String string8 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(R.string.no)");
            this.eGrandCheck = string8;
        }
        SemRegFragmentBinding semRegFragmentBinding28 = get_binding();
        if (semRegFragmentBinding28 != null && (textInputEditText8 = semRegFragmentBinding28.etSemFeeConcessionCategory) != null) {
            textInputEditText8.setText(response.getFeeConcessionCategory());
        }
        if (StringsKt.equals(response.getDepartmentDue(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding29 = get_binding();
            if (semRegFragmentBinding29 != null && (radioGroup16 = semRegFragmentBinding29.departmentGroup) != null) {
                radioGroup16.check(R.id.department_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding30 = get_binding();
            TextInputEditText textInputEditText23 = semRegFragmentBinding30 != null ? semRegFragmentBinding30.etSemDepartmentDue : null;
            if (textInputEditText23 != null) {
                textInputEditText23.setVisibility(0);
            }
            String string9 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(R.string.yes)");
            this.departmentCheck = string9;
        } else {
            SemRegFragmentBinding semRegFragmentBinding31 = get_binding();
            if (semRegFragmentBinding31 != null && (radioGroup5 = semRegFragmentBinding31.departmentGroup) != null) {
                radioGroup5.check(R.id.department_no);
            }
            SemRegFragmentBinding semRegFragmentBinding32 = get_binding();
            TextInputEditText textInputEditText24 = semRegFragmentBinding32 != null ? semRegFragmentBinding32.etSemDepartmentDue : null;
            if (textInputEditText24 != null) {
                textInputEditText24.setVisibility(8);
            }
            String string10 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(R.string.no)");
            this.departmentCheck = string10;
        }
        SemRegFragmentBinding semRegFragmentBinding33 = get_binding();
        if (semRegFragmentBinding33 != null && (textInputEditText7 = semRegFragmentBinding33.etSemDepartmentDue) != null) {
            textInputEditText7.setText(response.getDepartmentDueDetails());
        }
        if (StringsKt.equals(response.getLibraryDue(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding34 = get_binding();
            if (semRegFragmentBinding34 != null && (radioGroup15 = semRegFragmentBinding34.libraryGroup) != null) {
                radioGroup15.check(R.id.library_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding35 = get_binding();
            TextInputEditText textInputEditText25 = semRegFragmentBinding35 != null ? semRegFragmentBinding35.etSemLibraryDue : null;
            if (textInputEditText25 != null) {
                textInputEditText25.setVisibility(0);
            }
            String string11 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(R.string.yes)");
            this.libraryCheck = string11;
        } else {
            SemRegFragmentBinding semRegFragmentBinding36 = get_binding();
            if (semRegFragmentBinding36 != null && (radioGroup6 = semRegFragmentBinding36.libraryGroup) != null) {
                radioGroup6.check(R.id.library_no);
            }
            SemRegFragmentBinding semRegFragmentBinding37 = get_binding();
            TextInputEditText textInputEditText26 = semRegFragmentBinding37 != null ? semRegFragmentBinding37.etSemLibraryDue : null;
            if (textInputEditText26 != null) {
                textInputEditText26.setVisibility(8);
            }
            String string12 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(R.string.no)");
            this.libraryCheck = string12;
        }
        SemRegFragmentBinding semRegFragmentBinding38 = get_binding();
        if (semRegFragmentBinding38 != null && (textInputEditText6 = semRegFragmentBinding38.etSemLibraryDue) != null) {
            textInputEditText6.setText(response.getLibraryDueDetails());
        }
        if (StringsKt.equals(response.getAccountsDue(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding39 = get_binding();
            if (semRegFragmentBinding39 != null && (radioGroup14 = semRegFragmentBinding39.accountsGroup) != null) {
                radioGroup14.check(R.id.accounts_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding40 = get_binding();
            TextInputEditText textInputEditText27 = semRegFragmentBinding40 != null ? semRegFragmentBinding40.etSemAccountDue : null;
            if (textInputEditText27 != null) {
                textInputEditText27.setVisibility(0);
            }
            String string13 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(R.string.yes)");
            this.accountCheck = string13;
        } else {
            SemRegFragmentBinding semRegFragmentBinding41 = get_binding();
            if (semRegFragmentBinding41 != null && (radioGroup7 = semRegFragmentBinding41.accountsGroup) != null) {
                radioGroup7.check(R.id.accounts_no);
            }
            SemRegFragmentBinding semRegFragmentBinding42 = get_binding();
            TextInputEditText textInputEditText28 = semRegFragmentBinding42 != null ? semRegFragmentBinding42.etSemAccountDue : null;
            if (textInputEditText28 != null) {
                textInputEditText28.setVisibility(8);
            }
            String string14 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(R.string.no)");
            this.accountCheck = string14;
        }
        SemRegFragmentBinding semRegFragmentBinding43 = get_binding();
        if (semRegFragmentBinding43 != null && (textInputEditText5 = semRegFragmentBinding43.etSemAccountDue) != null) {
            textInputEditText5.setText(response.getAccountsDueDetails());
        }
        if (StringsKt.equals(response.getAcademicDue(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding44 = get_binding();
            if (semRegFragmentBinding44 != null && (radioGroup13 = semRegFragmentBinding44.academicGroup) != null) {
                radioGroup13.check(R.id.academic_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding45 = get_binding();
            TextInputEditText textInputEditText29 = semRegFragmentBinding45 != null ? semRegFragmentBinding45.etSemAcademicDue : null;
            if (textInputEditText29 != null) {
                textInputEditText29.setVisibility(0);
            }
            String string15 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(R.string.yes)");
            this.academicCheck = string15;
        } else {
            SemRegFragmentBinding semRegFragmentBinding46 = get_binding();
            if (semRegFragmentBinding46 != null && (radioGroup8 = semRegFragmentBinding46.academicGroup) != null) {
                radioGroup8.check(R.id.academic_no);
            }
            SemRegFragmentBinding semRegFragmentBinding47 = get_binding();
            TextInputEditText textInputEditText30 = semRegFragmentBinding47 != null ? semRegFragmentBinding47.etSemAcademicDue : null;
            if (textInputEditText30 != null) {
                textInputEditText30.setVisibility(8);
            }
            String string16 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string16, "getString(R.string.no)");
            this.academicCheck = string16;
        }
        SemRegFragmentBinding semRegFragmentBinding48 = get_binding();
        if (semRegFragmentBinding48 != null && (textInputEditText4 = semRegFragmentBinding48.etSemAcademicDue) != null) {
            textInputEditText4.setText(response.getAcademicDueDetails());
        }
        if (StringsKt.equals(response.getHostelDue(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding49 = get_binding();
            if (semRegFragmentBinding49 != null && (radioGroup12 = semRegFragmentBinding49.hostelGroup) != null) {
                radioGroup12.check(R.id.hostel_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding50 = get_binding();
            TextInputEditText textInputEditText31 = semRegFragmentBinding50 != null ? semRegFragmentBinding50.etSemHostelDue : null;
            if (textInputEditText31 != null) {
                textInputEditText31.setVisibility(0);
            }
            String string17 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string17, "getString(R.string.yes)");
            this.hostelCheck = string17;
        } else {
            SemRegFragmentBinding semRegFragmentBinding51 = get_binding();
            if (semRegFragmentBinding51 != null && (radioGroup9 = semRegFragmentBinding51.hostelGroup) != null) {
                radioGroup9.check(R.id.hostel_no);
            }
            SemRegFragmentBinding semRegFragmentBinding52 = get_binding();
            TextInputEditText textInputEditText32 = semRegFragmentBinding52 != null ? semRegFragmentBinding52.etSemHostelDue : null;
            if (textInputEditText32 != null) {
                textInputEditText32.setVisibility(8);
            }
            String string18 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string18, "getString(R.string.no)");
            this.hostelCheck = string18;
        }
        SemRegFragmentBinding semRegFragmentBinding53 = get_binding();
        if (semRegFragmentBinding53 != null && (textInputEditText3 = semRegFragmentBinding53.etSemHostelDue) != null) {
            textInputEditText3.setText(response.getHostelDueDetails());
        }
        if (StringsKt.equals(response.getBusDue(), "Yes", true)) {
            SemRegFragmentBinding semRegFragmentBinding54 = get_binding();
            if (semRegFragmentBinding54 != null && (radioGroup11 = semRegFragmentBinding54.busGroup) != null) {
                radioGroup11.check(R.id.bus_yes);
            }
            SemRegFragmentBinding semRegFragmentBinding55 = get_binding();
            textInputEditText = semRegFragmentBinding55 != null ? semRegFragmentBinding55.etSemBusDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(0);
            }
            String string19 = getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string19, "getString(R.string.yes)");
            this.busCheck = string19;
        } else {
            SemRegFragmentBinding semRegFragmentBinding56 = get_binding();
            if (semRegFragmentBinding56 != null && (radioGroup10 = semRegFragmentBinding56.busGroup) != null) {
                radioGroup10.check(R.id.bus_no);
            }
            SemRegFragmentBinding semRegFragmentBinding57 = get_binding();
            textInputEditText = semRegFragmentBinding57 != null ? semRegFragmentBinding57.etSemBusDue : null;
            if (textInputEditText != null) {
                textInputEditText.setVisibility(8);
            }
            String string20 = getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string20, "getString(R.string.no)");
            this.busCheck = string20;
        }
        SemRegFragmentBinding semRegFragmentBinding58 = get_binding();
        if (semRegFragmentBinding58 == null || (textInputEditText2 = semRegFragmentBinding58.etSemBusDue) == null) {
            return;
        }
        textInputEditText2.setText(response.getBusDueDetails());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context;
        ContentResolver contentResolver;
        String str;
        TextView tvSemRegFilePath;
        TextView tvSemRegFilePath2;
        ContentResolver contentResolver2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 == null || (context = getContext()) == null || (contentResolver = context.getContentResolver()) == null) {
                return;
            }
            String str2 = null;
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null);
            if (openFileDescriptor == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
            Context context2 = getContext();
            File cacheDir = context2 != null ? context2.getCacheDir() : null;
            Context context3 = getContext();
            if (context3 == null || (contentResolver3 = context3.getContentResolver()) == null) {
                str = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                str = ResolvUtilKt.getFileName(contentResolver3, data2);
            }
            File file = new File(cacheDir, str);
            ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
            if (!file.exists()) {
                SemRegFragmentBinding semRegFragmentBinding = get_binding();
                if (semRegFragmentBinding == null || (tvSemRegFilePath = semRegFragmentBinding.tvSemRegFilePath) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(tvSemRegFilePath, "tvSemRegFilePath");
                ToastExtKt.showInfoToast(tvSemRegFilePath, "Please Select A File");
                return;
            }
            long j = 1024;
            if ((file.length() / j) / j <= 5) {
                SemRegFragmentBinding semRegFragmentBinding2 = get_binding();
                TextView textView = semRegFragmentBinding2 != null ? semRegFragmentBinding2.tvSemRegFilePath : null;
                if (textView != null) {
                    Context context4 = getContext();
                    if (context4 != null && (contentResolver2 = context4.getContentResolver()) != null) {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    textView.setText("File : " + str2);
                }
                this.pickFile = file;
                return;
            }
            SemRegFragmentBinding semRegFragmentBinding3 = get_binding();
            if (semRegFragmentBinding3 == null || (tvSemRegFilePath2 = semRegFragmentBinding3.tvSemRegFilePath) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(tvSemRegFilePath2, "tvSemRegFilePath");
            ToastExtKt.showInfoToast(tvSemRegFilePath2, "File Size Limit Is 5MB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void listenSemResponse() {
        getSemRegViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.edit.SemRegFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegFragment.listenSemResponse$lambda$26(SemRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$26(SemRegFragment this$0, Resource resource) {
        Spinner spinner;
        Spinner spinner2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            SemRegFragmentBinding semRegFragmentBinding = this$0.get_binding();
            if (semRegFragmentBinding == null || (spinner2 = semRegFragmentBinding.spinnerSemReg) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(spinner2, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            int count = this$0.getSpinnerAdapter().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                    SemRegFragmentBinding semRegFragmentBinding2 = this$0.get_binding();
                    if (semRegFragmentBinding2 == null || (spinner = semRegFragmentBinding2.spinnerSemReg) == null) {
                        return;
                    }
                    spinner.setSelection(i2);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
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