package in.etuwa.app.ui.store;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.store.departmentlist.DepartmentListResponse;
import in.etuwa.app.databinding.StoreDialogBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.store.adapters.StoreDepartmentAdapter;
import in.etuwa.app.ui.store.adapters.StoreSemesterAdapter;
import in.etuwa.app.ui.store.adapters.StoreSubjectAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: StoreDialog.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0002ABB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u000e\u0010=\u001a\u00020&2\u0006\u0010+\u001a\u00020>J\b\u0010?\u001a\u00020&H\u0014J\b\u0010@\u001a\u00020&H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lin/etuwa/app/ui/store/StoreDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/StoreDialogBinding;", "after", "", "before", "binding", "getBinding", "()Lin/etuwa/app/databinding/StoreDialogBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/store/StoreDialog$StoreListener;", "listner2", "Lin/etuwa/app/helper/MainCallBackListener;", "spinnerAdapter", "Lin/etuwa/app/ui/store/adapters/StoreDepartmentAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/store/adapters/StoreDepartmentAdapter;", "spinnerAdapter$delegate", "Lkotlin/Lazy;", "spinnerAdapter2", "Lin/etuwa/app/ui/store/adapters/StoreSemesterAdapter;", "getSpinnerAdapter2", "()Lin/etuwa/app/ui/store/adapters/StoreSemesterAdapter;", "spinnerAdapter2$delegate", "spinnerAdapter3", "Lin/etuwa/app/ui/store/adapters/StoreSubjectAdapter;", "getSpinnerAdapter3", "()Lin/etuwa/app/ui/store/adapters/StoreSubjectAdapter;", "spinnerAdapter3$delegate", "storeDialogViewModel", "Lin/etuwa/app/ui/store/StoreDialogViewModel;", "getStoreDialogViewModel", "()Lin/etuwa/app/ui/store/StoreDialogViewModel;", "storeDialogViewModel$delegate", "type", "hideProgress", "", "listenSpinner", "listenSpinner2", "listenSpinner3", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/dashboard/DashboardFragment;", "setUp", "showProgress", "Companion", "StoreListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StoreDialogBinding _binding;
    private String after;
    private String before;
    private StoreListener listener;
    private MainCallBackListener listner2;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;

    /* renamed from: spinnerAdapter3$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter3;

    /* renamed from: storeDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy storeDialogViewModel;
    private String type;

    /* compiled from: StoreDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/store/StoreDialog$StoreListener;", "", "dismiss", "", "loadStoreView", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StoreListener {
        void dismiss();

        void loadStoreView();
    }

    @JvmStatic
    public static final StoreDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public StoreDialog() {
        final StoreDialog storeDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.store.StoreDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(storeDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.storeDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(storeDialog, Reflection.getOrCreateKotlinClass(StoreDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.store.StoreDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.store.StoreDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(StoreDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        this.before = "";
        this.after = "";
        final StoreDialog storeDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.store.StoreDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(StoreDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<StoreDepartmentAdapter>() { // from class: in.etuwa.app.ui.store.StoreDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.store.adapters.StoreDepartmentAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StoreDepartmentAdapter invoke() {
                ComponentCallbacks componentCallbacks = storeDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoreDepartmentAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.store.StoreDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(StoreDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<StoreSemesterAdapter>() { // from class: in.etuwa.app.ui.store.StoreDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.store.adapters.StoreSemesterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StoreSemesterAdapter invoke() {
                ComponentCallbacks componentCallbacks = storeDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoreSemesterAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.store.StoreDialog$spinnerAdapter3$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(StoreDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<StoreSubjectAdapter>() { // from class: in.etuwa.app.ui.store.StoreDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.store.adapters.StoreSubjectAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final StoreSubjectAdapter invoke() {
                ComponentCallbacks componentCallbacks = storeDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(StoreSubjectAdapter.class), b4, function04);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreDialogViewModel getStoreDialogViewModel() {
        return (StoreDialogViewModel) this.storeDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final StoreDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreDepartmentAdapter getSpinnerAdapter() {
        return (StoreDepartmentAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreSemesterAdapter getSpinnerAdapter2() {
        return (StoreSemesterAdapter) this.spinnerAdapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreSubjectAdapter getSpinnerAdapter3() {
        return (StoreSubjectAdapter) this.spinnerAdapter3.getValue();
    }

    /* compiled from: StoreDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/store/StoreDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/store/StoreDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StoreDialog newInstance() {
            StoreDialog storeDialog = new StoreDialog();
            storeDialog.setArguments(new Bundle());
            return storeDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = StoreDialogBinding.inflate(inflater, container, false);
        StoreDialogBinding storeDialogBinding = get_binding();
        if (storeDialogBinding != null) {
            storeDialogBinding.setStoreDialogViewModel(getStoreDialogViewModel());
        }
        StoreDialogBinding storeDialogBinding2 = get_binding();
        if (storeDialogBinding2 != null) {
            storeDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        StoreDialogBinding storeDialogBinding3 = get_binding();
        if (storeDialogBinding3 != null) {
            return storeDialogBinding3.getRoot();
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
        StoreDialogBinding storeDialogBinding = get_binding();
        Spinner spinner = storeDialogBinding != null ? storeDialogBinding.spinnerStoreSemester : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        StoreDialogBinding storeDialogBinding2 = get_binding();
        Spinner spinner2 = storeDialogBinding2 != null ? storeDialogBinding2.spinnerStoreDepartment : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        StoreDialogBinding storeDialogBinding3 = get_binding();
        Spinner spinner3 = storeDialogBinding3 != null ? storeDialogBinding3.spinnerCstoreSubject : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapter3());
        }
        listenSpinner();
        StoreDialogBinding storeDialogBinding4 = get_binding();
        Spinner spinner4 = storeDialogBinding4 != null ? storeDialogBinding4.spinnerStoreSemester : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.store.StoreDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    StoreDepartmentAdapter spinnerAdapter;
                    StoreDialogViewModel storeDialogViewModel;
                    String str;
                    StoreDialog storeDialog = StoreDialog.this;
                    spinnerAdapter = storeDialog.getSpinnerAdapter();
                    storeDialog.type = spinnerAdapter.getSemester(position).getId();
                    storeDialogViewModel = StoreDialog.this.getStoreDialogViewModel();
                    str = StoreDialog.this.type;
                    storeDialogViewModel.getSemester(str);
                    StoreDialog.this.listenSpinner2();
                }
            });
        }
        StoreDialogBinding storeDialogBinding5 = get_binding();
        Spinner spinner5 = storeDialogBinding5 != null ? storeDialogBinding5.spinnerStoreDepartment : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.store.StoreDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    StoreSemesterAdapter spinnerAdapter2;
                    StoreDialogViewModel storeDialogViewModel;
                    String str;
                    String str2;
                    StoreDialog storeDialog = StoreDialog.this;
                    spinnerAdapter2 = storeDialog.getSpinnerAdapter2();
                    storeDialog.before = spinnerAdapter2.getSemester(position).getId();
                    storeDialogViewModel = StoreDialog.this.getStoreDialogViewModel();
                    str = StoreDialog.this.type;
                    str2 = StoreDialog.this.before;
                    storeDialogViewModel.getSubject(str, str2);
                    StoreDialog.this.listenSpinner3();
                }
            });
        }
        StoreDialogBinding storeDialogBinding6 = get_binding();
        Spinner spinner6 = storeDialogBinding6 != null ? storeDialogBinding6.spinnerCstoreSubject : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.store.StoreDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    StoreSubjectAdapter spinnerAdapter3;
                    StoreDialog storeDialog = StoreDialog.this;
                    spinnerAdapter3 = storeDialog.getSpinnerAdapter3();
                    storeDialog.after = spinnerAdapter3.getSemester(position).getId();
                }
            });
        }
        StoreDialogBinding storeDialogBinding7 = get_binding();
        if (storeDialogBinding7 == null || (textView = storeDialogBinding7.nextStoreBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.store.StoreDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreDialog.setUp$lambda$1(StoreDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(StoreDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        MainCallBackListener mainCallBackListener = this$0.listner2;
        if (mainCallBackListener != null) {
            mainCallBackListener.loadStoreView(this$0.after);
        }
    }

    private final void listenSpinner() {
        getStoreDialogViewModel().getDepResponse().observe(getViewLifecycleOwner(), new StoreDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DepartmentListResponse>, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialog$listenSpinner$1

            /* compiled from: StoreDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DepartmentListResponse> resource) {
                invoke2((Resource<DepartmentListResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DepartmentListResponse> resource) {
                StoreDepartmentAdapter spinnerAdapter;
                StoreDialogBinding storeDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    StoreDialog.this.hideProgress();
                    DepartmentListResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = StoreDialog.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    StoreDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    StoreDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                StoreDialog.this.hideProgress();
                storeDialogBinding = StoreDialog.this.get_binding();
                if (storeDialogBinding == null || (spinner = storeDialogBinding.spinnerStoreSemester) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void listenSpinner2() {
        getStoreDialogViewModel().getSemResponse().observe(getViewLifecycleOwner(), new StoreDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DepartmentListResponse>, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialog$listenSpinner2$1

            /* compiled from: StoreDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DepartmentListResponse> resource) {
                invoke2((Resource<DepartmentListResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DepartmentListResponse> resource) {
                StoreSemesterAdapter spinnerAdapter2;
                StoreDialogBinding storeDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    StoreDialog.this.hideProgress();
                    DepartmentListResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter2 = StoreDialog.this.getSpinnerAdapter2();
                        spinnerAdapter2.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    StoreDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    StoreDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                StoreDialog.this.hideProgress();
                storeDialogBinding = StoreDialog.this.get_binding();
                if (storeDialogBinding == null || (spinner = storeDialogBinding.spinnerCstoreSubject) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void listenSpinner3() {
        getStoreDialogViewModel().getSubResponse().observe(getViewLifecycleOwner(), new StoreDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DepartmentListResponse>, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialog$listenSpinner3$1

            /* compiled from: StoreDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DepartmentListResponse> resource) {
                invoke2((Resource<DepartmentListResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DepartmentListResponse> resource) {
                StoreSubjectAdapter spinnerAdapter3;
                StoreDialogBinding storeDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    StoreDialog.this.hideProgress();
                    DepartmentListResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter3 = StoreDialog.this.getSpinnerAdapter3();
                        spinnerAdapter3.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    StoreDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    StoreDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                StoreDialog.this.hideProgress();
                storeDialogBinding = StoreDialog.this.get_binding();
                if (storeDialogBinding == null || (spinner = storeDialogBinding.spinnerStoreDepartment) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
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

    public final void setCallBack(DashboardFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        StoreListener storeListener = this.listener;
        if (storeListener != null) {
            storeListener.dismiss();
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