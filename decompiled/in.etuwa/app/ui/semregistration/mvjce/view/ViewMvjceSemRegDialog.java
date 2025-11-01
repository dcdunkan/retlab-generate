package in.etuwa.app.ui.semregistration.mvjce.view;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ViewMvjceSemRegDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewMvjceSemRegDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00104\u001a\u00020&H\u0016J\u001a\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u000e\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020&H\u0014J\b\u0010;\u001a\u00020&H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#¨\u0006>"}, d2 = {"Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/ViewMvjceSemRegDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ViewMvjceSemRegDialogBinding;", "canEdit", "", "editMessage", "", "feeStatus", "file", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog$SemRegCallBack;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "receiptId", "", "registrationActive", "slipFile", "statusMessage", "viewMvjceSemRegViewModel", "Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegViewModel;", "getViewMvjceSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegViewModel;", "viewMvjceSemRegViewModel$delegate", "hideProgress", "", "listenResponse", "loadView", "response", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setSemRegCallBack", "context", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "setUp", "showProgress", "Companion", "SemRegCallBack", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewMvjceSemRegDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ViewMvjceSemRegDialogBinding _binding;
    private boolean canEdit;
    private String editMessage;
    private boolean feeStatus;
    private String file;
    private String id;
    private SemRegCallBack listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private long receiptId;
    private boolean registrationActive;
    private String slipFile;
    private String statusMessage;

    /* renamed from: viewMvjceSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewMvjceSemRegViewModel;

    /* compiled from: ViewMvjceSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog$SemRegCallBack;", "", "onDismissProfile", "", "onEditClicked", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SemRegCallBack {
        void onDismissProfile();

        void onEditClicked(String id);
    }

    /* compiled from: ViewMvjceSemRegDialog.kt */
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
    public static final ViewMvjceSemRegDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ViewMvjceSemRegDialog() {
        final ViewMvjceSemRegDialog viewMvjceSemRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewMvjceSemRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewMvjceSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewMvjceSemRegDialog, Reflection.getOrCreateKotlinClass(ViewMvjceSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewMvjceSemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ViewMvjceSemRegDialog viewMvjceSemRegDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = viewMvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.file = "";
        this.slipFile = "";
        this.editMessage = "";
        this.statusMessage = "";
    }

    private final ViewMvjceSemRegViewModel getViewMvjceSemRegViewModel() {
        return (ViewMvjceSemRegViewModel) this.viewMvjceSemRegViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ViewMvjceSemRegDialogBinding get_binding() {
        return this._binding;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ViewMvjceSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewMvjceSemRegDialog newInstance(String id) {
            ViewMvjceSemRegDialog viewMvjceSemRegDialog = new ViewMvjceSemRegDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            viewMvjceSemRegDialog.setArguments(bundle);
            return viewMvjceSemRegDialog;
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
        this._binding = ViewMvjceSemRegDialogBinding.inflate(inflater, container, false);
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding = get_binding();
        if (viewMvjceSemRegDialogBinding != null) {
            viewMvjceSemRegDialogBinding.setViewMvjceSemRegViewModel(getViewMvjceSemRegViewModel());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding2 = get_binding();
        if (viewMvjceSemRegDialogBinding2 != null) {
            viewMvjceSemRegDialogBinding2.setLifecycleOwner(this);
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding3 = get_binding();
        if (viewMvjceSemRegDialogBinding3 != null) {
            return viewMvjceSemRegDialogBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        TextView textView;
        if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding = get_binding();
            LinearLayout linearLayout = viewMvjceSemRegDialogBinding != null ? viewMvjceSemRegDialogBinding.dueLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding2 = get_binding();
            LinearLayout linearLayout2 = viewMvjceSemRegDialogBinding2 != null ? viewMvjceSemRegDialogBinding2.dueLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            ViewMvjceSemRegViewModel viewMvjceSemRegViewModel = getViewMvjceSemRegViewModel();
            String str = this.id;
            Intrinsics.checkNotNull(str);
            viewMvjceSemRegViewModel.getRegistrationSlip(str);
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            getViewMvjceSemRegViewModel().getData2(this.id);
        } else if (this.id != null) {
            getViewMvjceSemRegViewModel().getData(this.id);
        } else {
            getViewMvjceSemRegViewModel().getData(null);
        }
        listenResponse();
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding3 = get_binding();
        if (viewMvjceSemRegDialogBinding3 != null && (textView = viewMvjceSemRegDialogBinding3.semEditBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewMvjceSemRegDialog.setUp$lambda$1(ViewMvjceSemRegDialog.this, view);
                }
            });
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding4 = get_binding();
        if (viewMvjceSemRegDialogBinding4 == null || (swipeRefreshLayout = viewMvjceSemRegDialogBinding4.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ViewMvjceSemRegDialog.setUp$lambda$2(ViewMvjceSemRegDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ViewMvjceSemRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SemRegCallBack semRegCallBack = this$0.listener;
        if (semRegCallBack != null) {
            semRegCallBack.onEditClicked(String.valueOf(this$0.id));
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ViewMvjceSemRegDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            this$0.getViewMvjceSemRegViewModel().getData2(this$0.id);
        } else if (this$0.id != null) {
            this$0.getViewMvjceSemRegViewModel().getData(this$0.id);
        } else {
            this$0.getViewMvjceSemRegViewModel().getData(null);
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = viewMvjceSemRegDialogBinding != null ? viewMvjceSemRegDialogBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getViewMvjceSemRegViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewMvjceSemRegDialog.listenResponse$lambda$4(ViewMvjceSemRegDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(ViewMvjceSemRegDialog this$0, Resource resource) {
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
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding = this$0.get_binding();
        if (viewMvjceSemRegDialogBinding == null || (textView = viewMvjceSemRegDialogBinding.semRegAcademic) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    private final void loadView(SemRegViewResponse response) {
        TextView textView;
        System.out.println(response);
        if (response.isApplied()) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding = get_binding();
            TextView textView2 = viewMvjceSemRegDialogBinding != null ? viewMvjceSemRegDialogBinding.semEditBtn : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.edit));
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding2 = get_binding();
            TextView textView3 = viewMvjceSemRegDialogBinding2 != null ? viewMvjceSemRegDialogBinding2.semEditBtn : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.apply));
            }
        }
        if ((response.getUpdate_btn() && StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) || ((response.getUpdate_btn() && StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) || (response.getUpdate_btn() && StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null)))) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding3 = get_binding();
            TextView textView4 = viewMvjceSemRegDialogBinding3 != null ? viewMvjceSemRegDialogBinding3.semEditBtn : null;
            if (textView4 != null) {
                textView4.setText("Update");
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding4 = get_binding();
            TextView textView5 = viewMvjceSemRegDialogBinding4 != null ? viewMvjceSemRegDialogBinding4.semEditBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        this.canEdit = response.getCanEdit();
        this.editMessage = response.getCanEditMessage();
        this.registrationActive = response.getSemRegistrationStatus();
        this.statusMessage = response.getSemRegistrationStatusMessage();
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding5 = get_binding();
        TextView textView6 = viewMvjceSemRegDialogBinding5 != null ? viewMvjceSemRegDialogBinding5.semRegStatus : null;
        if (textView6 != null) {
            textView6.setText(response.getStatus());
        }
        if (Intrinsics.areEqual(response.getHodRemarks(), "") || Intrinsics.areEqual(response.getStatus(), "FORWADED TO HOD")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding6 = get_binding();
            LinearLayout linearLayout = viewMvjceSemRegDialogBinding6 != null ? viewMvjceSemRegDialogBinding6.hodRemarkLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding7 = get_binding();
        TextView textView7 = viewMvjceSemRegDialogBinding7 != null ? viewMvjceSemRegDialogBinding7.semRegRemarkByHod : null;
        if (textView7 != null) {
            textView7.setText(response.getHodRemarks());
        }
        if (Intrinsics.areEqual(response.getClassTeacherRemark(), "")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding8 = get_binding();
            LinearLayout linearLayout2 = viewMvjceSemRegDialogBinding8 != null ? viewMvjceSemRegDialogBinding8.teacherRemarkLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding9 = get_binding();
        TextView textView8 = viewMvjceSemRegDialogBinding9 != null ? viewMvjceSemRegDialogBinding9.semRegRemarkByTeacher : null;
        if (textView8 != null) {
            textView8.setText(response.getClassTeacherRemark());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding10 = get_binding();
        TextView textView9 = viewMvjceSemRegDialogBinding10 != null ? viewMvjceSemRegDialogBinding10.semRegAdmNo : null;
        if (textView9 != null) {
            textView9.setText(response.getAdmissionNo());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding11 = get_binding();
        TextView textView10 = viewMvjceSemRegDialogBinding11 != null ? viewMvjceSemRegDialogBinding11.semRegAppliedFor : null;
        if (textView10 != null) {
            textView10.setText(response.getSemAppliedFor());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding12 = get_binding();
        TextView textView11 = viewMvjceSemRegDialogBinding12 != null ? viewMvjceSemRegDialogBinding12.semRegName : null;
        if (textView11 != null) {
            textView11.setText(response.getName());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding13 = get_binding();
        TextView textView12 = viewMvjceSemRegDialogBinding13 != null ? viewMvjceSemRegDialogBinding13.semRegGender : null;
        if (textView12 != null) {
            textView12.setText(response.getGender());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding14 = get_binding();
        TextView textView13 = viewMvjceSemRegDialogBinding14 != null ? viewMvjceSemRegDialogBinding14.semRegPhone : null;
        if (textView13 != null) {
            textView13.setText(response.getPhone());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding15 = get_binding();
        TextView textView14 = viewMvjceSemRegDialogBinding15 != null ? viewMvjceSemRegDialogBinding15.semRegEmail : null;
        if (textView14 != null) {
            textView14.setText(response.getEmail());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding16 = get_binding();
        TextView textView15 = viewMvjceSemRegDialogBinding16 != null ? viewMvjceSemRegDialogBinding16.semRegExamAppear : null;
        if (textView15 != null) {
            textView15.setText(response.getExamAppear());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding17 = get_binding();
        TextView textView16 = viewMvjceSemRegDialogBinding17 != null ? viewMvjceSemRegDialogBinding17.semRegUnivNo : null;
        if (textView16 != null) {
            textView16.setText(response.getUniRegNo());
        }
        if (Intrinsics.areEqual(response.getExamAppear(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding18 = get_binding();
            TextView textView17 = viewMvjceSemRegDialogBinding18 != null ? viewMvjceSemRegDialogBinding18.semRegMonthYear : null;
            if (textView17 != null) {
                textView17.setText(response.getExamMonthYear());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding19 = get_binding();
            TextView textView18 = viewMvjceSemRegDialogBinding19 != null ? viewMvjceSemRegDialogBinding19.semRegMonthYear : null;
            if (textView18 != null) {
                textView18.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding20 = get_binding();
        TextView textView19 = viewMvjceSemRegDialogBinding20 != null ? viewMvjceSemRegDialogBinding20.semRegBackPaper : null;
        if (textView19 != null) {
            textView19.setText(response.getBackPaper());
        }
        if (Intrinsics.areEqual(response.getBackPaper(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding21 = get_binding();
            TextView textView20 = viewMvjceSemRegDialogBinding21 != null ? viewMvjceSemRegDialogBinding21.semRegBackPaperCount : null;
            if (textView20 != null) {
                textView20.setText(response.getBackPaperCount());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding22 = get_binding();
            TextView textView21 = viewMvjceSemRegDialogBinding22 != null ? viewMvjceSemRegDialogBinding22.semRegBackPaperCount : null;
            if (textView21 != null) {
                textView21.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding23 = get_binding();
        TextView textView22 = viewMvjceSemRegDialogBinding23 != null ? viewMvjceSemRegDialogBinding23.semRegEarnedCredit : null;
        if (textView22 != null) {
            textView22.setText(response.getEarnedCredits());
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding24 = get_binding();
        TextView textView23 = viewMvjceSemRegDialogBinding24 != null ? viewMvjceSemRegDialogBinding24.semRegDepartment : null;
        if (textView23 != null) {
            textView23.setText(response.getDepartmentDue());
        }
        if (Intrinsics.areEqual(response.getDepartmentDue(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding25 = get_binding();
            TextView textView24 = viewMvjceSemRegDialogBinding25 != null ? viewMvjceSemRegDialogBinding25.semRegDepartmentDue : null;
            if (textView24 != null) {
                textView24.setText(response.getDepartmentDueDetails());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding26 = get_binding();
            TextView textView25 = viewMvjceSemRegDialogBinding26 != null ? viewMvjceSemRegDialogBinding26.semRegDepartmentDue : null;
            if (textView25 != null) {
                textView25.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding27 = get_binding();
        TextView textView26 = viewMvjceSemRegDialogBinding27 != null ? viewMvjceSemRegDialogBinding27.semRegLibrary : null;
        if (textView26 != null) {
            textView26.setText(response.getLibraryDue());
        }
        if (Intrinsics.areEqual(response.getLibraryDue(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding28 = get_binding();
            TextView textView27 = viewMvjceSemRegDialogBinding28 != null ? viewMvjceSemRegDialogBinding28.semRegLibraryDue : null;
            if (textView27 != null) {
                textView27.setText(response.getLibraryDueDetails());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding29 = get_binding();
            TextView textView28 = viewMvjceSemRegDialogBinding29 != null ? viewMvjceSemRegDialogBinding29.semRegLibraryDue : null;
            if (textView28 != null) {
                textView28.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding30 = get_binding();
        TextView textView29 = viewMvjceSemRegDialogBinding30 != null ? viewMvjceSemRegDialogBinding30.semRegAccount : null;
        if (textView29 != null) {
            textView29.setText(response.getAccountsDue());
        }
        if (Intrinsics.areEqual(response.getAccountsDue(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding31 = get_binding();
            TextView textView30 = viewMvjceSemRegDialogBinding31 != null ? viewMvjceSemRegDialogBinding31.semRegAccountDue : null;
            if (textView30 != null) {
                textView30.setText(response.getAccountsDueDetails());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding32 = get_binding();
            TextView textView31 = viewMvjceSemRegDialogBinding32 != null ? viewMvjceSemRegDialogBinding32.semRegAccountDue : null;
            if (textView31 != null) {
                textView31.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding33 = get_binding();
        TextView textView32 = viewMvjceSemRegDialogBinding33 != null ? viewMvjceSemRegDialogBinding33.semRegAcademic : null;
        if (textView32 != null) {
            textView32.setText(response.getAcademicDue());
        }
        if (Intrinsics.areEqual(response.getAcademicDue(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding34 = get_binding();
            TextView textView33 = viewMvjceSemRegDialogBinding34 != null ? viewMvjceSemRegDialogBinding34.semRegAcademicDue : null;
            if (textView33 != null) {
                textView33.setText(response.getAcademicDueDetails());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding35 = get_binding();
            TextView textView34 = viewMvjceSemRegDialogBinding35 != null ? viewMvjceSemRegDialogBinding35.semRegAcademicDue : null;
            if (textView34 != null) {
                textView34.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding36 = get_binding();
        TextView textView35 = viewMvjceSemRegDialogBinding36 != null ? viewMvjceSemRegDialogBinding36.semRegHostel : null;
        if (textView35 != null) {
            textView35.setText(response.getHostelDue());
        }
        if (Intrinsics.areEqual(response.getLibraryDue(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding37 = get_binding();
            TextView textView36 = viewMvjceSemRegDialogBinding37 != null ? viewMvjceSemRegDialogBinding37.semRegHostelDue : null;
            if (textView36 != null) {
                textView36.setText(response.getHostelDueDetails());
            }
        } else {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding38 = get_binding();
            TextView textView37 = viewMvjceSemRegDialogBinding38 != null ? viewMvjceSemRegDialogBinding38.semRegHostelDue : null;
            if (textView37 != null) {
                textView37.setText("");
            }
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding39 = get_binding();
        TextView textView38 = viewMvjceSemRegDialogBinding39 != null ? viewMvjceSemRegDialogBinding39.semRegBus : null;
        if (textView38 != null) {
            textView38.setText(response.getBusDue());
        }
        if (Intrinsics.areEqual(response.getBusDue(), "Yes")) {
            ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding40 = get_binding();
            textView = viewMvjceSemRegDialogBinding40 != null ? viewMvjceSemRegDialogBinding40.semRegBusDue : null;
            if (textView == null) {
                return;
            }
            textView.setText(response.getBusDueDetails());
            return;
        }
        ViewMvjceSemRegDialogBinding viewMvjceSemRegDialogBinding41 = get_binding();
        textView = viewMvjceSemRegDialogBinding41 != null ? viewMvjceSemRegDialogBinding41.semRegBusDue : null;
        if (textView == null) {
            return;
        }
        textView.setText("");
    }

    public final void setSemRegCallBack(PalaiSemesterRegFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}