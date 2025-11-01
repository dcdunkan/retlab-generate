package in.etuwa.app.ui.counselling.add;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.counselling.type.CounsellingTypesResponse;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.databinding.AddCounsellingDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.counselling.CounsellingFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddCounsellingDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 C2\u00020\u0001:\u0002BCB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020%H\u0002J\u0012\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u00020%H\u0016J\b\u00107\u001a\u00020%H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u000e\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020%H\u0014J\b\u0010A\u001a\u00020%H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\u001eR\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/AddCounsellingDialogBinding;", "addCounsellingViewModel", "Lin/etuwa/app/ui/counselling/add/AddCounsellingViewModel;", "getAddCounsellingViewModel", "()Lin/etuwa/app/ui/counselling/add/AddCounsellingViewModel;", "addCounsellingViewModel$delegate", "Lkotlin/Lazy;", "after", "", "before", "binding", "getBinding", "()Lin/etuwa/app/databinding/AddCounsellingDialogBinding;", "id", "isReOpen", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog$AddCounsellingListener;", "spinnerAdapter", "Lin/etuwa/app/ui/counselling/add/CounsellingTypeSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/counselling/add/CounsellingTypeSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "Lin/etuwa/app/ui/counselling/add/CounsellingStatusSpinnerAdapter;", "getSpinnerAdapter2", "()Lin/etuwa/app/ui/counselling/add/CounsellingStatusSpinnerAdapter;", "spinnerAdapter2$delegate", "spinnerAdapter3", "getSpinnerAdapter3", "spinnerAdapter3$delegate", "type", "hideProgress", "", "listenAddResponse", "listenProgressResponse", "listenReopenResponse", "listenSpinner", "listenSpinner2", "listenSpinner3", "listenViewCounselling", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/counselling/CounsellingFragment;", "setUp", "showProgress", "AddCounsellingListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddCounsellingDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddCounsellingDialogBinding _binding;

    /* renamed from: addCounsellingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addCounsellingViewModel;
    private String after;
    private String before;
    private String id;
    private boolean isReOpen;
    private AddCounsellingListener listener;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;

    /* renamed from: spinnerAdapter3$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter3;
    private String type;

    /* compiled from: AddCounsellingDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog$AddCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCounsellingListener {
        void dismiss();
    }

    @JvmStatic
    public static final AddCounsellingDialog newInstance(String str, boolean z) {
        return INSTANCE.newInstance(str, z);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddCounsellingDialog() {
        final AddCounsellingDialog addCounsellingDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addCounsellingDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addCounsellingViewModel = FragmentViewModelLazyKt.createViewModelLazy(addCounsellingDialog, Reflection.getOrCreateKotlinClass(AddCounsellingViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddCounsellingViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        this.before = "";
        this.after = "";
        final AddCounsellingDialog addCounsellingDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddCounsellingDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CounsellingTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCounsellingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingTypeSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddCounsellingDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingStatusSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCounsellingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$spinnerAdapter3$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddCounsellingDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingStatusSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCounsellingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), b4, function04);
            }
        });
    }

    private final AddCounsellingViewModel getAddCounsellingViewModel() {
        return (AddCounsellingViewModel) this.addCounsellingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final AddCounsellingDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingTypeSpinnerAdapter getSpinnerAdapter() {
        return (CounsellingTypeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingStatusSpinnerAdapter getSpinnerAdapter2() {
        return (CounsellingStatusSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingStatusSpinnerAdapter getSpinnerAdapter3() {
        return (CounsellingStatusSpinnerAdapter) this.spinnerAdapter3.getValue();
    }

    /* compiled from: AddCounsellingDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog;", "id", "", "isReOpen", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddCounsellingDialog newInstance(String id, boolean isReOpen) {
            AddCounsellingDialog addCounsellingDialog = new AddCounsellingDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("reopen", isReOpen);
            addCounsellingDialog.setArguments(bundle);
            return addCounsellingDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.isReOpen = arguments.getBoolean("reopen");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AddCounsellingDialogBinding.inflate(inflater, container, false);
        AddCounsellingDialogBinding addCounsellingDialogBinding = get_binding();
        if (addCounsellingDialogBinding != null) {
            addCounsellingDialogBinding.setAddCounsellingDialogViewModel(getAddCounsellingViewModel());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = get_binding();
        if (addCounsellingDialogBinding2 != null) {
            addCounsellingDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = get_binding();
        if (addCounsellingDialogBinding3 != null) {
            return addCounsellingDialogBinding3.getRoot();
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
        AddCounsellingDialogBinding addCounsellingDialogBinding = get_binding();
        Spinner spinner = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.spinnerCouncellingType : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = get_binding();
        Spinner spinner2 = addCounsellingDialogBinding2 != null ? addCounsellingDialogBinding2.spinnerCouncellingBefore : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = get_binding();
        Spinner spinner3 = addCounsellingDialogBinding3 != null ? addCounsellingDialogBinding3.spinnerCouncellingMeet : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapter3());
        }
        listenSpinner();
        listenSpinner2();
        listenSpinner3();
        listenAddResponse();
        listenViewCounselling();
        listenProgressResponse();
        listenReopenResponse();
        if (this.id != null) {
            getAddCounsellingViewModel().viewGrievance(this.id);
            AddCounsellingDialogBinding addCounsellingDialogBinding4 = get_binding();
            TextView textView2 = addCounsellingDialogBinding4 != null ? addCounsellingDialogBinding4.councTitle : null;
            if (textView2 != null) {
                textView2.setText("Edit Counselling");
            }
            AddCounsellingDialogBinding addCounsellingDialogBinding5 = get_binding();
            TextView textView3 = addCounsellingDialogBinding5 != null ? addCounsellingDialogBinding5.addCounsellingBtn : null;
            if (textView3 != null) {
                textView3.setText("Update Counselling");
            }
        }
        if (this.isReOpen) {
            AddCounsellingDialogBinding addCounsellingDialogBinding6 = get_binding();
            TextInputLayout textInputLayout = addCounsellingDialogBinding6 != null ? addCounsellingDialogBinding6.comntLayout : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            getAddCounsellingViewModel().viewGrievance(this.id);
            AddCounsellingDialogBinding addCounsellingDialogBinding7 = get_binding();
            TextView textView4 = addCounsellingDialogBinding7 != null ? addCounsellingDialogBinding7.councTitle : null;
            if (textView4 != null) {
                textView4.setText("Reopen Counselling");
            }
            AddCounsellingDialogBinding addCounsellingDialogBinding8 = get_binding();
            TextView textView5 = addCounsellingDialogBinding8 != null ? addCounsellingDialogBinding8.addCounsellingBtn : null;
            if (textView5 != null) {
                textView5.setText("Repost Counselling");
            }
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding9 = get_binding();
        Spinner spinner4 = addCounsellingDialogBinding9 != null ? addCounsellingDialogBinding9.spinnerCouncellingType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CounsellingTypeSpinnerAdapter spinnerAdapter;
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    spinnerAdapter = addCounsellingDialog.getSpinnerAdapter();
                    addCounsellingDialog.type = spinnerAdapter.getType(position).getId();
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding10 = get_binding();
        Spinner spinner5 = addCounsellingDialogBinding10 != null ? addCounsellingDialogBinding10.spinnerCouncellingBefore : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CounsellingStatusSpinnerAdapter spinnerAdapter2;
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    spinnerAdapter2 = addCounsellingDialog.getSpinnerAdapter2();
                    addCounsellingDialog.before = spinnerAdapter2.getType(position).getId();
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding11 = get_binding();
        Spinner spinner6 = addCounsellingDialogBinding11 != null ? addCounsellingDialogBinding11.spinnerCouncellingMeet : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CounsellingStatusSpinnerAdapter spinnerAdapter3;
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    spinnerAdapter3 = addCounsellingDialog.getSpinnerAdapter3();
                    addCounsellingDialog.after = spinnerAdapter3.getType(position).getId();
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding12 = get_binding();
        if (addCounsellingDialogBinding12 == null || (textView = addCounsellingDialogBinding12.addCounsellingBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCounsellingDialog.setUp$lambda$1(AddCounsellingDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AddCounsellingDialog this$0, View view) {
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
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, RequestBody> hashMap = new HashMap<>();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType mediaType = MultipartBody.FORM;
        String str = this$0.id;
        if (str == null) {
            str = "";
        }
        RequestBody create = companion.create(mediaType, str);
        HashMap<String, RequestBody> hashMap2 = hashMap;
        hashMap2.put("CounsellingRequests[counselling_type]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.type));
        RequestBody.Companion companion2 = RequestBody.INSTANCE;
        MediaType mediaType2 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding = this$0.get_binding();
        Editable editable = null;
        hashMap2.put("CounsellingRequests[concern]", companion2.create(mediaType2, String.valueOf((addCounsellingDialogBinding == null || (textInputEditText11 = addCounsellingDialogBinding.etCsConcern) == null) ? null : textInputEditText11.getText())));
        RequestBody.Companion companion3 = RequestBody.INSTANCE;
        MediaType mediaType3 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = this$0.get_binding();
        hashMap2.put("CounsellingRequests[impact_home]", companion3.create(mediaType3, String.valueOf((addCounsellingDialogBinding2 == null || (textInputEditText10 = addCounsellingDialogBinding2.etCsConcernHome) == null) ? null : textInputEditText10.getText())));
        RequestBody.Companion companion4 = RequestBody.INSTANCE;
        MediaType mediaType4 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = this$0.get_binding();
        hashMap2.put("CounsellingRequests[impact_studies]", companion4.create(mediaType4, String.valueOf((addCounsellingDialogBinding3 == null || (textInputEditText9 = addCounsellingDialogBinding3.csConcernStudies) == null) ? null : textInputEditText9.getText())));
        RequestBody.Companion companion5 = RequestBody.INSTANCE;
        MediaType mediaType5 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding4 = this$0.get_binding();
        hashMap2.put("CounsellingRequests[impact_relationship]", companion5.create(mediaType5, String.valueOf((addCounsellingDialogBinding4 == null || (textInputEditText8 = addCounsellingDialogBinding4.csRelationship) == null) ? null : textInputEditText8.getText())));
        RequestBody.Companion companion6 = RequestBody.INSTANCE;
        MediaType mediaType6 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding5 = this$0.get_binding();
        hashMap2.put("CounsellingRequests[impact_physically_emotionally]", companion6.create(mediaType6, String.valueOf((addCounsellingDialogBinding5 == null || (textInputEditText7 = addCounsellingDialogBinding5.csPhisical) == null) ? null : textInputEditText7.getText())));
        hashMap2.put("CounsellingRequests[counselling_session_required]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.after));
        hashMap2.put("CounsellingRequests[counselling_history]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.before));
        String str2 = this$0.id;
        if (str2 == null || str2.length() == 0) {
            this$0.getAddCounsellingViewModel().addCouselling(hashMap);
            return;
        }
        if (this$0.isReOpen) {
            AddCounsellingViewModel addCounsellingViewModel = this$0.getAddCounsellingViewModel();
            String str3 = this$0.id;
            String str4 = this$0.type;
            AddCounsellingDialogBinding addCounsellingDialogBinding6 = this$0.get_binding();
            String valueOf = String.valueOf((addCounsellingDialogBinding6 == null || (textInputEditText6 = addCounsellingDialogBinding6.etCsConcern) == null) ? null : textInputEditText6.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding7 = this$0.get_binding();
            String valueOf2 = String.valueOf((addCounsellingDialogBinding7 == null || (textInputEditText5 = addCounsellingDialogBinding7.etCsConcernHome) == null) ? null : textInputEditText5.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding8 = this$0.get_binding();
            String valueOf3 = String.valueOf((addCounsellingDialogBinding8 == null || (textInputEditText4 = addCounsellingDialogBinding8.csConcernStudies) == null) ? null : textInputEditText4.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding9 = this$0.get_binding();
            String valueOf4 = String.valueOf((addCounsellingDialogBinding9 == null || (textInputEditText3 = addCounsellingDialogBinding9.csRelationship) == null) ? null : textInputEditText3.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding10 = this$0.get_binding();
            String valueOf5 = String.valueOf((addCounsellingDialogBinding10 == null || (textInputEditText2 = addCounsellingDialogBinding10.csPhisical) == null) ? null : textInputEditText2.getText());
            String str5 = this$0.before;
            String str6 = this$0.after;
            AddCounsellingDialogBinding addCounsellingDialogBinding11 = this$0.get_binding();
            if (addCounsellingDialogBinding11 != null && (textInputEditText = addCounsellingDialogBinding11.csComment) != null) {
                editable = textInputEditText.getText();
            }
            addCounsellingViewModel.reopenCounselling(str3, str4, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, str5, str6, String.valueOf(editable));
            return;
        }
        this$0.getAddCounsellingViewModel().updateCounselling(create, hashMap);
    }

    private final void listenSpinner() {
        getAddCounsellingViewModel().getTypeResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingTypesResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenSpinner$1

            /* compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingTypesResponse> resource) {
                invoke2((Resource<CounsellingTypesResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingTypesResponse> resource) {
                CounsellingTypeSpinnerAdapter spinnerAdapter;
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCounsellingDialog.this.hideProgress();
                    CounsellingTypesResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = AddCounsellingDialog.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getCTypes());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddCounsellingDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCounsellingDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSpinner2() {
        getAddCounsellingViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingStatusResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenSpinner2$1

            /* compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingStatusResponse> resource) {
                invoke2((Resource<CounsellingStatusResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingStatusResponse> resource) {
                CounsellingStatusSpinnerAdapter spinnerAdapter2;
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCounsellingDialog.this.hideProgress();
                    CounsellingStatusResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter2 = AddCounsellingDialog.this.getSpinnerAdapter2();
                        spinnerAdapter2.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddCounsellingDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCounsellingDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSpinner3() {
        getAddCounsellingViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingStatusResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenSpinner3$1

            /* compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingStatusResponse> resource) {
                invoke2((Resource<CounsellingStatusResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingStatusResponse> resource) {
                CounsellingStatusSpinnerAdapter spinnerAdapter3;
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCounsellingDialog.this.hideProgress();
                    CounsellingStatusResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter3 = AddCounsellingDialog.this.getSpinnerAdapter3();
                        spinnerAdapter3.addItems(data.getData());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddCounsellingDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCounsellingDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenViewCounselling() {
        getAddCounsellingViewModel().getViewResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewCounsellingResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenViewCounselling$1

            /* compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewCounsellingResponse> resource) {
                invoke2((Resource<ViewCounsellingResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewCounsellingResponse> resource) {
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                AddCounsellingDialogBinding addCounsellingDialogBinding2;
                AddCounsellingDialogBinding addCounsellingDialogBinding3;
                AddCounsellingDialogBinding addCounsellingDialogBinding4;
                AddCounsellingDialogBinding addCounsellingDialogBinding5;
                TextInputEditText textInputEditText;
                TextInputEditText textInputEditText2;
                TextInputEditText textInputEditText3;
                TextInputEditText textInputEditText4;
                TextInputEditText textInputEditText5;
                AddCounsellingDialogBinding addCounsellingDialogBinding6;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCounsellingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCounsellingDialog.this.hideProgress();
                    addCounsellingDialogBinding6 = AddCounsellingDialog.this.get_binding();
                    if (addCounsellingDialogBinding6 == null || (spinner = addCounsellingDialogBinding6.spinnerCouncellingType) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(spinner, message);
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                ViewCounsellingResponse data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    addCounsellingDialogBinding = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding != null && (textInputEditText5 = addCounsellingDialogBinding.etCsConcern) != null) {
                        textInputEditText5.setText(data.getRequests().getConcern());
                    }
                    addCounsellingDialogBinding2 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding2 != null && (textInputEditText4 = addCounsellingDialogBinding2.etCsConcernHome) != null) {
                        textInputEditText4.setText(data.getRequests().getImpactHome());
                    }
                    addCounsellingDialogBinding3 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding3 != null && (textInputEditText3 = addCounsellingDialogBinding3.csConcernStudies) != null) {
                        textInputEditText3.setText(data.getRequests().getImpactStudies());
                    }
                    addCounsellingDialogBinding4 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding4 != null && (textInputEditText2 = addCounsellingDialogBinding4.csRelationship) != null) {
                        textInputEditText2.setText(data.getRequests().getImpactRelationship());
                    }
                    addCounsellingDialogBinding5 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding5 == null || (textInputEditText = addCounsellingDialogBinding5.csPhisical) == null) {
                        return;
                    }
                    textInputEditText.setText(data.getRequests().getImpactPhysicallyEmotionally());
                }
            }
        }));
    }

    private final void listenProgressResponse() {
        getAddCounsellingViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends Float>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenProgressResponse$1

            /* compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends Float> resource) {
                invoke2((Resource<Float>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<Float> resource) {
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                AddCounsellingDialogBinding addCounsellingDialogBinding2;
                AddCounsellingDialogBinding addCounsellingDialogBinding3;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        AddCounsellingDialog.this.hideProgress();
                        return;
                    }
                }
                AddCounsellingDialog.this.hideProgress();
                Float data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    float floatValue = data.floatValue();
                    addCounsellingDialogBinding = addCounsellingDialog.get_binding();
                    ProgressBar progressBar = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.uploadProgressbar : null;
                    if (progressBar != null) {
                        progressBar.setProgress((int) floatValue);
                    }
                    addCounsellingDialogBinding2 = addCounsellingDialog.get_binding();
                    TextView textView = addCounsellingDialogBinding2 != null ? addCounsellingDialogBinding2.progressText : null;
                    if (textView != null) {
                        textView.setText(((int) floatValue) + " %");
                    }
                    if (((int) floatValue) == 100) {
                        addCounsellingDialog.showProgress();
                        addCounsellingDialogBinding3 = addCounsellingDialog.get_binding();
                        CardView cardView = addCounsellingDialogBinding3 != null ? addCounsellingDialogBinding3.progressView : null;
                        if (cardView == null) {
                            return;
                        }
                        cardView.setVisibility(8);
                    }
                }
            }
        }));
    }

    private final void listenAddResponse() {
        getAddCounsellingViewModel().getAddCounsellingResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenAddResponse$1

            /* compiled from: AddCounsellingDialog.kt */
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
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                CardView cardView;
                AddCounsellingDialogBinding addCounsellingDialogBinding2;
                TextInputEditText etCsConcern;
                AddCounsellingDialogBinding addCounsellingDialogBinding3;
                AddCounsellingDialogBinding addCounsellingDialogBinding4;
                TextInputEditText etCsConcern2;
                AddCounsellingDialogBinding addCounsellingDialogBinding5;
                AddCounsellingDialogBinding addCounsellingDialogBinding6;
                AddCounsellingDialogBinding addCounsellingDialogBinding7;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCounsellingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        addCounsellingDialogBinding5 = AddCounsellingDialog.this.get_binding();
                        cardView = addCounsellingDialogBinding5 != null ? addCounsellingDialogBinding5.progressView : null;
                        if (cardView == null) {
                            return;
                        }
                        cardView.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCounsellingDialog.this.hideProgress();
                    addCounsellingDialogBinding6 = AddCounsellingDialog.this.get_binding();
                    cardView = addCounsellingDialogBinding6 != null ? addCounsellingDialogBinding6.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    addCounsellingDialogBinding7 = AddCounsellingDialog.this.get_binding();
                    if (addCounsellingDialogBinding7 == null || (textInputEditText = addCounsellingDialogBinding7.csRelationship) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textInputEditText, message);
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    if (data.getSuccess()) {
                        addCounsellingDialogBinding3 = addCounsellingDialog.get_binding();
                        cardView = addCounsellingDialogBinding3 != null ? addCounsellingDialogBinding3.progressView : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        addCounsellingDialogBinding4 = addCounsellingDialog.get_binding();
                        if (addCounsellingDialogBinding4 != null && (etCsConcern2 = addCounsellingDialogBinding4.etCsConcern) != null) {
                            Intrinsics.checkNotNullExpressionValue(etCsConcern2, "etCsConcern");
                            ToastExtKt.showSuccessToast(etCsConcern2, data.getMessage());
                        }
                        addCounsellingDialog.dismiss();
                        return;
                    }
                    addCounsellingDialogBinding = addCounsellingDialog.get_binding();
                    cardView = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    addCounsellingDialogBinding2 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding2 == null || (etCsConcern = addCounsellingDialogBinding2.etCsConcern) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(etCsConcern, "etCsConcern");
                    ToastExtKt.showSuccessToast(etCsConcern, data.getError());
                }
            }
        }));
    }

    private final void listenReopenResponse() {
        getAddCounsellingViewModel().getReopenCounsellingResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenReopenResponse$1

            /* compiled from: AddCounsellingDialog.kt */
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
                AddCounsellingDialogBinding addCounsellingDialogBinding;
                CardView cardView;
                AddCounsellingDialogBinding addCounsellingDialogBinding2;
                TextInputEditText etCsConcern;
                AddCounsellingDialogBinding addCounsellingDialogBinding3;
                AddCounsellingDialogBinding addCounsellingDialogBinding4;
                TextInputEditText etCsConcern2;
                AddCounsellingDialogBinding addCounsellingDialogBinding5;
                AddCounsellingDialogBinding addCounsellingDialogBinding6;
                AddCounsellingDialogBinding addCounsellingDialogBinding7;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCounsellingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        addCounsellingDialogBinding5 = AddCounsellingDialog.this.get_binding();
                        cardView = addCounsellingDialogBinding5 != null ? addCounsellingDialogBinding5.progressView : null;
                        if (cardView == null) {
                            return;
                        }
                        cardView.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCounsellingDialog.this.hideProgress();
                    addCounsellingDialogBinding6 = AddCounsellingDialog.this.get_binding();
                    cardView = addCounsellingDialogBinding6 != null ? addCounsellingDialogBinding6.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    addCounsellingDialogBinding7 = AddCounsellingDialog.this.get_binding();
                    if (addCounsellingDialogBinding7 == null || (textInputEditText = addCounsellingDialogBinding7.csRelationship) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textInputEditText, message);
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    if (data.getSuccess()) {
                        addCounsellingDialogBinding3 = addCounsellingDialog.get_binding();
                        cardView = addCounsellingDialogBinding3 != null ? addCounsellingDialogBinding3.progressView : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        addCounsellingDialogBinding4 = addCounsellingDialog.get_binding();
                        if (addCounsellingDialogBinding4 != null && (etCsConcern2 = addCounsellingDialogBinding4.etCsConcern) != null) {
                            Intrinsics.checkNotNullExpressionValue(etCsConcern2, "etCsConcern");
                            ToastExtKt.showSuccessToast(etCsConcern2, data.getMessage());
                        }
                        addCounsellingDialog.dismiss();
                        return;
                    }
                    addCounsellingDialogBinding = addCounsellingDialog.get_binding();
                    cardView = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    addCounsellingDialogBinding2 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding2 == null || (etCsConcern = addCounsellingDialogBinding2.etCsConcern) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(etCsConcern, "etCsConcern");
                    ToastExtKt.showSuccessToast(etCsConcern, data.getError());
                }
            }
        }));
    }

    public final void setCallBack(CounsellingFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddCounsellingListener addCounsellingListener = this.listener;
        if (addCounsellingListener != null) {
            addCounsellingListener.dismiss();
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