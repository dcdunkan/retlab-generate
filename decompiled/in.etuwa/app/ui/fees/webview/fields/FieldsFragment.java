package in.etuwa.app.ui.fees.webview.fields;

import android.app.AlertDialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFieldsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
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

/* compiled from: FieldsFragment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 C2\u00020\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020*H\u0014J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00108\u001a\u00020*H\u0016J\u001a\u00109\u001a\u00020*2\u0006\u0010:\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010;\u001a\u00020*H\u0014J\u0018\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u000fH\u0002J\b\u0010?\u001a\u00020*H\u0014J\b\u0010@\u001a\u00020*H\u0014J\b\u0010A\u001a\u00020BH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010 \u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b!\u0010\u001bR\u001b\u0010#\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b$\u0010\u001bR\u0010\u0010&\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lin/etuwa/app/ui/fees/webview/fields/FieldsFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentFieldsBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentFieldsBinding;", "fieldsViewModel", "Lin/etuwa/app/ui/fees/webview/fields/FieldsViewModel;", "getFieldsViewModel", "()Lin/etuwa/app/ui/fees/webview/fields/FieldsViewModel;", "fieldsViewModel$delegate", "Lkotlin/Lazy;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", ClientCookie.PORT_ATTR, "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapterPort", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapterPort", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapterPort$delegate", "spinnerAdapterTon", "getSpinnerAdapterTon", "spinnerAdapterTon$delegate", "spinnerAdapterType", "getSpinnerAdapterType", "spinnerAdapterType$delegate", "spinnerAdapterZone", "getSpinnerAdapterZone", "spinnerAdapterZone$delegate", "ton", "type", "zone", "hideBaseView", "", "hideProgress", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showAlert", "title", "message", "showBaseView", "showProgress", "validateFields", "", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FieldsFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFieldsBinding _binding;

    /* renamed from: fieldsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy fieldsViewModel;
    private String id;
    private MainCallBackListener listener;
    private String port;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapterPort$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterPort;

    /* renamed from: spinnerAdapterTon$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterTon;

    /* renamed from: spinnerAdapterType$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterType;

    /* renamed from: spinnerAdapterZone$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterZone;
    private String ton;
    private String type;
    private String zone;

    @JvmStatic
    public static final FieldsFragment newInstance() {
        return INSTANCE.newInstance();
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

    public FieldsFragment() {
        final FieldsFragment fieldsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fieldsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.fieldsViewModel = FragmentViewModelLazyKt.createViewModelLazy(fieldsFragment, Reflection.getOrCreateKotlinClass(FieldsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FieldsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FieldsFragment fieldsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = fieldsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$spinnerAdapterPort$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FieldsFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapterPort = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = fieldsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$spinnerAdapterZone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FieldsFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerAdapterZone = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = fieldsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b5, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$spinnerAdapterTon$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FieldsFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerAdapterTon = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = fieldsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b6, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$spinnerAdapterType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FieldsFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        this.spinnerAdapterType = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = fieldsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b7, function05);
            }
        });
    }

    private final FieldsViewModel getFieldsViewModel() {
        return (FieldsViewModel) this.fieldsViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentFieldsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapterPort() {
        return (SemesterSpinnerAdapter) this.spinnerAdapterPort.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapterZone() {
        return (SemesterSpinnerAdapter) this.spinnerAdapterZone.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapterTon() {
        return (SemesterSpinnerAdapter) this.spinnerAdapterTon.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapterType() {
        return (SemesterSpinnerAdapter) this.spinnerAdapterType.getValue();
    }

    /* compiled from: FieldsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/webview/fields/FieldsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/webview/fields/FieldsFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FieldsFragment newInstance() {
            return new FieldsFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFieldsBinding.inflate(inflater, container, false);
        FragmentFieldsBinding fragmentFieldsBinding = get_binding();
        if (fragmentFieldsBinding != null) {
            fragmentFieldsBinding.setFieldsViewModel(getFieldsViewModel());
        }
        FragmentFieldsBinding fragmentFieldsBinding2 = get_binding();
        if (fragmentFieldsBinding2 != null) {
            fragmentFieldsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFieldsBinding fragmentFieldsBinding3 = get_binding();
        if (fragmentFieldsBinding3 != null) {
            return fragmentFieldsBinding3.getRoot();
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
        getPreference().setNewLogin(false);
        FragmentFieldsBinding fragmentFieldsBinding = get_binding();
        Spinner spinner = fragmentFieldsBinding != null ? fragmentFieldsBinding.spinnerPort : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapterPort());
        }
        FragmentFieldsBinding fragmentFieldsBinding2 = get_binding();
        Spinner spinner2 = fragmentFieldsBinding2 != null ? fragmentFieldsBinding2.spinnerZone : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapterZone());
        }
        FragmentFieldsBinding fragmentFieldsBinding3 = get_binding();
        Spinner spinner3 = fragmentFieldsBinding3 != null ? fragmentFieldsBinding3.spinnerTon : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapterTon());
        }
        FragmentFieldsBinding fragmentFieldsBinding4 = get_binding();
        Spinner spinner4 = fragmentFieldsBinding4 != null ? fragmentFieldsBinding4.spinnerVehicle : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getSpinnerAdapterType());
        }
        ArrayList<Semester> arrayListOf = CollectionsKt.arrayListOf(new Semester("654c59cbb5e9b226a8af97c7", "Kasargod"), new Semester("654b9b67b5e9b226a8af96ae", "Vatakara"), new Semester("654b985bb5e9b226a8af967f", "Kodungallur"), new Semester("654b8bf9b5e9b226a8af959f", "Beypore"));
        ArrayList<Semester> arrayListOf2 = CollectionsKt.arrayListOf(new Semester("654c5cf9b5e9b226a8af9813", "SHIRIYA-ARIKKADY"), new Semester("654c5c4bb5e9b226a8af980c", "MOGRALPUTHUR"), new Semester("654c5b93b5e9b226a8af9807", "MATTUMMAL"), new Semester("654c5b7cb5e9b226a8af9800", "ORIKKADAVU"), new Semester("654c5b48b5e9b226a8af97f9", "ACHAMTHURUTHI"), new Semester("654c5b33b5e9b226a8af97ed", "KAITHAKKAD"), new Semester("654c5b1db5e9b226a8af97e6", "MADAKKARA"), new Semester("654c5d0eb5e9b226a8af981a", "CHALIYAMCODE"), new Semester("654c5e88b5e9b226a8af9883", "SHIRIYA-OLAYAM"), new Semester("654c5d31b5e9b226a8af9828", "MANJESHWAR"), new Semester("654c5d21b5e9b226a8af9821", "THALANKARA"));
        final ArrayList arrayListOf3 = CollectionsKt.arrayListOf(new Semester("67ee276c91cd9664eb664d87", "5"), new Semester("67ee276c91cd9664eb664d86", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee276c91cd9664eb664d88", "7"), new Semester("67ee276c91cd9664eb664d89", "10"));
        final ArrayList arrayListOf4 = CollectionsKt.arrayListOf(new Semester("67ee272791cd9664eb664b7d", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee272791cd9664eb664b7e", "5"), new Semester("67ee272791cd9664eb664b7f", "7"), new Semester("67ee272791cd9664eb664b80", "10"));
        final ArrayList arrayListOf5 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee275491cd9664eb664d16", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee275491cd9664eb664d17", "5"));
        final ArrayList arrayListOf6 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee271191cd9664eb664ac1", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee271191cd9664eb664ac2", "5"));
        final ArrayList arrayListOf7 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee26ec91cd9664eb664a33", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee26ec91cd9664eb664a34", "5"), new Semester("67ee26ec91cd9664eb664a35", "7"), new Semester("67ee26ec91cd9664eb664a36", "10"));
        final ArrayList arrayListOf8 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee267e91cd9664eb664826", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee267e91cd9664eb664827", "5"));
        final ArrayList arrayListOf9 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee26a391cd9664eb66488e", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee26a391cd9664eb66488f", "5"));
        final ArrayList arrayListOf10 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee268f91cd9664eb664854", "5"), new Semester("67ee268f91cd9664eb664853", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee4d9c13786e892bc41147", "5"), new Semester("67ee4d9c13786e892bc41149", ExifInterface.GPS_MEASUREMENT_3D));
        final ArrayList arrayListOf11 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee266691cd9664eb6647c3", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee266691cd9664eb6647c4", "5"), new Semester("67ee2a867833f3f035554030", "5"), new Semester("67ee2a867833f3f03555402e", ExifInterface.GPS_MEASUREMENT_3D));
        final ArrayList arrayListOf12 = CollectionsKt.arrayListOf(new Semester("id", "Please select ton required"), new Semester("67ee273f91cd9664eb664c44", "5"), new Semester("67ee273f91cd9664eb664c45", "7"), new Semester("67ee273f91cd9664eb664c43", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee273f91cd9664eb664c46", "10"), new Semester("67ee2cdc844842249a8bbcee", ExifInterface.GPS_MEASUREMENT_3D), new Semester("67ee2cdc844842249a8bbcf0", "5"));
        ArrayList<Semester> arrayListOf13 = CollectionsKt.arrayListOf(new Semester("Lorry", "Lorry"));
        getSpinnerAdapterPort().addItems(arrayListOf);
        getSpinnerAdapterType().addItems(arrayListOf13);
        getSpinnerAdapterZone().addItems(arrayListOf2);
        FragmentFieldsBinding fragmentFieldsBinding5 = get_binding();
        Spinner spinner5 = fragmentFieldsBinding5 != null ? fragmentFieldsBinding5.spinnerPort : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapterPort;
                    FieldsFragment fieldsFragment = FieldsFragment.this;
                    spinnerAdapterPort = fieldsFragment.getSpinnerAdapterPort();
                    fieldsFragment.port = spinnerAdapterPort.getSemester(position).getId();
                }
            });
        }
        FragmentFieldsBinding fragmentFieldsBinding6 = get_binding();
        Spinner spinner6 = fragmentFieldsBinding6 != null ? fragmentFieldsBinding6.spinnerZone : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapterZone;
                    SemesterSpinnerAdapter spinnerAdapterZone2;
                    SemesterSpinnerAdapter spinnerAdapterZone3;
                    SemesterSpinnerAdapter spinnerAdapterZone4;
                    SemesterSpinnerAdapter spinnerAdapterZone5;
                    SemesterSpinnerAdapter spinnerAdapterZone6;
                    SemesterSpinnerAdapter spinnerAdapterZone7;
                    SemesterSpinnerAdapter spinnerAdapterZone8;
                    SemesterSpinnerAdapter spinnerAdapterZone9;
                    SemesterSpinnerAdapter spinnerAdapterZone10;
                    SemesterSpinnerAdapter spinnerAdapterZone11;
                    SemesterSpinnerAdapter spinnerAdapterTon;
                    SemesterSpinnerAdapter spinnerAdapterTon2;
                    SemesterSpinnerAdapter spinnerAdapterTon3;
                    SemesterSpinnerAdapter spinnerAdapterTon4;
                    SemesterSpinnerAdapter spinnerAdapterTon5;
                    SemesterSpinnerAdapter spinnerAdapterTon6;
                    SemesterSpinnerAdapter spinnerAdapterTon7;
                    SemesterSpinnerAdapter spinnerAdapterTon8;
                    SemesterSpinnerAdapter spinnerAdapterTon9;
                    SemesterSpinnerAdapter spinnerAdapterTon10;
                    FieldsFragment fieldsFragment = FieldsFragment.this;
                    spinnerAdapterZone = fieldsFragment.getSpinnerAdapterZone();
                    fieldsFragment.zone = spinnerAdapterZone.getSemester(position).getId();
                    spinnerAdapterZone2 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase = spinnerAdapterZone2.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "madakkara", false, 2, (Object) null)) {
                        spinnerAdapterTon10 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon10.addItems(arrayListOf11);
                        return;
                    }
                    spinnerAdapterZone3 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase2 = spinnerAdapterZone3.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "kaithakkad", false, 2, (Object) null)) {
                        spinnerAdapterTon9 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon9.addItems(arrayListOf10);
                        return;
                    }
                    spinnerAdapterZone4 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase3 = spinnerAdapterZone4.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "achamthuruthi", false, 2, (Object) null)) {
                        spinnerAdapterTon8 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon8.addItems(arrayListOf9);
                        return;
                    }
                    spinnerAdapterZone5 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase4 = spinnerAdapterZone5.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "orikkadavu", false, 2, (Object) null)) {
                        spinnerAdapterTon7 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon7.addItems(arrayListOf8);
                        return;
                    }
                    spinnerAdapterZone6 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase5 = spinnerAdapterZone6.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "mattummal", false, 2, (Object) null)) {
                        spinnerAdapterTon6 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon6.addItems(arrayListOf7);
                        return;
                    }
                    spinnerAdapterZone7 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase6 = spinnerAdapterZone7.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) "mogral", false, 2, (Object) null)) {
                        spinnerAdapterTon5 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon5.addItems(arrayListOf6);
                        return;
                    }
                    spinnerAdapterZone8 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase7 = spinnerAdapterZone8.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) "arikkady", false, 2, (Object) null)) {
                        spinnerAdapterTon4 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon4.addItems(arrayListOf5);
                        return;
                    }
                    spinnerAdapterZone9 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase8 = spinnerAdapterZone9.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase8, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase8, (CharSequence) "chaliyamcode", false, 2, (Object) null)) {
                        spinnerAdapterTon3 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon3.addItems(arrayListOf4);
                        return;
                    }
                    spinnerAdapterZone10 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase9 = spinnerAdapterZone10.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase9, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase9, (CharSequence) "thalankara", false, 2, (Object) null)) {
                        spinnerAdapterTon2 = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon2.addItems(arrayListOf12);
                        return;
                    }
                    spinnerAdapterZone11 = FieldsFragment.this.getSpinnerAdapterZone();
                    String lowerCase10 = spinnerAdapterZone11.getSemester(position).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase10, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase10, (CharSequence) "manjeshwar", false, 2, (Object) null)) {
                        spinnerAdapterTon = FieldsFragment.this.getSpinnerAdapterTon();
                        spinnerAdapterTon.addItems(arrayListOf3);
                    }
                }
            });
        }
        FragmentFieldsBinding fragmentFieldsBinding7 = get_binding();
        Spinner spinner7 = fragmentFieldsBinding7 != null ? fragmentFieldsBinding7.spinnerTon : null;
        if (spinner7 != null) {
            spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapterTon;
                    FieldsFragment fieldsFragment = FieldsFragment.this;
                    spinnerAdapterTon = fieldsFragment.getSpinnerAdapterTon();
                    fieldsFragment.ton = spinnerAdapterTon.getSemester(position).getId();
                }
            });
        }
        FragmentFieldsBinding fragmentFieldsBinding8 = get_binding();
        Spinner spinner8 = fragmentFieldsBinding8 != null ? fragmentFieldsBinding8.spinnerVehicle : null;
        if (spinner8 != null) {
            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$setUp$4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapterType;
                    FieldsFragment fieldsFragment = FieldsFragment.this;
                    spinnerAdapterType = fieldsFragment.getSpinnerAdapterType();
                    fieldsFragment.type = spinnerAdapterType.getSemester(position).getId();
                }
            });
        }
        FragmentFieldsBinding fragmentFieldsBinding9 = get_binding();
        TextView textView2 = fragmentFieldsBinding9 != null ? fragmentFieldsBinding9.nameTv : null;
        if (textView2 != null) {
            textView2.setText(Html.fromHtml("Name <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding10 = get_binding();
        TextView textView3 = fragmentFieldsBinding10 != null ? fragmentFieldsBinding10.mobileNumberTv : null;
        if (textView3 != null) {
            textView3.setText(Html.fromHtml("Mobile Number <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding11 = get_binding();
        TextView textView4 = fragmentFieldsBinding11 != null ? fragmentFieldsBinding11.numberTv : null;
        if (textView4 != null) {
            textView4.setText(Html.fromHtml("Aadhaar Number <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding12 = get_binding();
        TextView textView5 = fragmentFieldsBinding12 != null ? fragmentFieldsBinding12.portTv : null;
        if (textView5 != null) {
            textView5.setText(Html.fromHtml("Port <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding13 = get_binding();
        TextView textView6 = fragmentFieldsBinding13 != null ? fragmentFieldsBinding13.zoneTv : null;
        if (textView6 != null) {
            textView6.setText(Html.fromHtml("Preferred Zone <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding14 = get_binding();
        TextView textView7 = fragmentFieldsBinding14 != null ? fragmentFieldsBinding14.typeTv : null;
        if (textView7 != null) {
            textView7.setText(Html.fromHtml("Vehicle Type <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding15 = get_binding();
        TextView textView8 = fragmentFieldsBinding15 != null ? fragmentFieldsBinding15.tonTv : null;
        if (textView8 != null) {
            textView8.setText(Html.fromHtml("Ton Required <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding16 = get_binding();
        TextView textView9 = fragmentFieldsBinding16 != null ? fragmentFieldsBinding16.placeTv : null;
        if (textView9 != null) {
            textView9.setText(Html.fromHtml("Unloading Place <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding17 = get_binding();
        TextView textView10 = fragmentFieldsBinding17 != null ? fragmentFieldsBinding17.distanceTv : null;
        if (textView10 != null) {
            textView10.setText(Html.fromHtml("Distance <font color='#FF0000'>*</font>"));
        }
        FragmentFieldsBinding fragmentFieldsBinding18 = get_binding();
        if (fragmentFieldsBinding18 == null || (textView = fragmentFieldsBinding18.submitBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.webview.fields.FieldsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FieldsFragment.setUp$lambda$0(FieldsFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FieldsFragment this$0, View view) {
        MainCallBackListener mainCallBackListener;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.validateFields() || (mainCallBackListener = this$0.listener) == null) {
            return;
        }
        FragmentFieldsBinding fragmentFieldsBinding = this$0.get_binding();
        Editable editable = null;
        String valueOf = String.valueOf((fragmentFieldsBinding == null || (editText5 = fragmentFieldsBinding.nameEt) == null) ? null : editText5.getText());
        FragmentFieldsBinding fragmentFieldsBinding2 = this$0.get_binding();
        String valueOf2 = String.valueOf((fragmentFieldsBinding2 == null || (editText4 = fragmentFieldsBinding2.etMobileNumber) == null) ? null : editText4.getText());
        FragmentFieldsBinding fragmentFieldsBinding3 = this$0.get_binding();
        String valueOf3 = String.valueOf((fragmentFieldsBinding3 == null || (editText3 = fragmentFieldsBinding3.etAadhaarNumber) == null) ? null : editText3.getText());
        String str = this$0.port;
        Intrinsics.checkNotNull(str);
        String str2 = this$0.zone;
        Intrinsics.checkNotNull(str2);
        String str3 = this$0.type;
        Intrinsics.checkNotNull(str3);
        String str4 = this$0.ton;
        Intrinsics.checkNotNull(str4);
        FragmentFieldsBinding fragmentFieldsBinding4 = this$0.get_binding();
        String valueOf4 = String.valueOf((fragmentFieldsBinding4 == null || (editText2 = fragmentFieldsBinding4.placeEt) == null) ? null : editText2.getText());
        FragmentFieldsBinding fragmentFieldsBinding5 = this$0.get_binding();
        if (fragmentFieldsBinding5 != null && (editText = fragmentFieldsBinding5.distanceEt) != null) {
            editable = editText.getText();
        }
        mainCallBackListener.spotRegistrationClicked(valueOf, valueOf2, valueOf3, str, str2, str3, str4, valueOf4, String.valueOf(editable));
    }

    private final boolean validateFields() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        FragmentFieldsBinding fragmentFieldsBinding = get_binding();
        Editable editable = null;
        String obj = StringsKt.trim((CharSequence) String.valueOf((fragmentFieldsBinding == null || (editText5 = fragmentFieldsBinding.nameEt) == null) ? null : editText5.getText())).toString();
        FragmentFieldsBinding fragmentFieldsBinding2 = get_binding();
        String obj2 = StringsKt.trim((CharSequence) String.valueOf((fragmentFieldsBinding2 == null || (editText4 = fragmentFieldsBinding2.etMobileNumber) == null) ? null : editText4.getText())).toString();
        FragmentFieldsBinding fragmentFieldsBinding3 = get_binding();
        String obj3 = StringsKt.trim((CharSequence) String.valueOf((fragmentFieldsBinding3 == null || (editText3 = fragmentFieldsBinding3.etAadhaarNumber) == null) ? null : editText3.getText())).toString();
        FragmentFieldsBinding fragmentFieldsBinding4 = get_binding();
        String obj4 = StringsKt.trim((CharSequence) String.valueOf((fragmentFieldsBinding4 == null || (editText2 = fragmentFieldsBinding4.placeEt) == null) ? null : editText2.getText())).toString();
        FragmentFieldsBinding fragmentFieldsBinding5 = get_binding();
        if (fragmentFieldsBinding5 != null && (editText = fragmentFieldsBinding5.distanceEt) != null) {
            editable = editText.getText();
        }
        String obj5 = StringsKt.trim((CharSequence) String.valueOf(editable)).toString();
        if (obj.length() == 0) {
            showAlert("Validation Error", "Please enter your name");
            return false;
        }
        if ((obj2.length() == 0) || obj2.length() != 10) {
            showAlert("Validation Error", "Enter a valid 10-digit Mobile number");
            return false;
        }
        if ((obj3.length() == 0) || obj3.length() != 12) {
            showAlert("Validation Error", "Enter a valid 12-digit Aadhaar number");
            return false;
        }
        if (obj4.length() == 0) {
            showAlert("Validation Error", "Please enter unloading place");
            return false;
        }
        if (!(obj5.length() == 0)) {
            return true;
        }
        showAlert("Validation Error", "Please enter distance");
        return false;
    }

    private final void showAlert(String title, String message) {
        new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(message).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
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
}