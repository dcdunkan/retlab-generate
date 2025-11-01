package in.etuwa.app.ui.subjectregistration.view;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subjectregistration.Category;
import in.etuwa.app.data.model.subjectregistration.SemesterList;
import in.etuwa.app.data.model.subjectregistration.ViewSubjectRegistrationResponse;
import in.etuwa.app.databinding.DialogViewSubjectRegistrationBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment;
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog;
import in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewSubjectRegistrationDialog.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002;<B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u000e\u00107\u001a\u00020\"2\u0006\u0010%\u001a\u000208J\b\u00109\u001a\u00020\"H\u0014J\b\u0010:\u001a\u00020\"H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u001f¨\u0006="}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog$RegisterListener;", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter$StatusListCallBack;", "Lin/etuwa/app/ui/subjectregistration/view/ViewSemSubHistoryAdapter$StatusListCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogViewSubjectRegistrationBinding;", "adapter", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter;", "getAdapter", "()Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "adapter2", "Lin/etuwa/app/ui/subjectregistration/view/ViewSemSubHistoryAdapter;", "getAdapter2", "()Lin/etuwa/app/ui/subjectregistration/view/ViewSemSubHistoryAdapter;", "adapter2$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogViewSubjectRegistrationBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog$RegisterListener;", "listner2", "Lin/etuwa/app/helper/MainCallBackListener;", "viewSubjectRegistrationViewModel", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationViewModel;", "getViewSubjectRegistrationViewModel", "()Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationViewModel;", "viewSubjectRegistrationViewModel$delegate", "hideProgress", "", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment;", "setUp", "showProgress", "Companion", "RegisterListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewSubjectRegistrationDialog extends BaseDialog implements ApplySubjectRegistrationDialog.RegisterListener, ViewSubjectRegistrationAdapter.StatusListCallBack, ViewSemSubHistoryAdapter.StatusListCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogViewSubjectRegistrationBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: adapter2$delegate, reason: from kotlin metadata */
    private final Lazy adapter2;
    private String id;
    private RegisterListener listener;
    private MainCallBackListener listner2;

    /* renamed from: viewSubjectRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewSubjectRegistrationViewModel;

    /* compiled from: ViewSubjectRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog$RegisterListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RegisterListener {
        void dismiss();
    }

    @JvmStatic
    public static final ViewSubjectRegistrationDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ViewSubjectRegistrationDialog() {
        final ViewSubjectRegistrationDialog viewSubjectRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewSubjectRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewSubjectRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewSubjectRegistrationDialog, Reflection.getOrCreateKotlinClass(ViewSubjectRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewSubjectRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ViewSubjectRegistrationDialog viewSubjectRegistrationDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ViewSubjectRegistrationAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSubjectRegistrationAdapter invoke() {
                ComponentCallbacks componentCallbacks = viewSubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ViewSubjectRegistrationAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<ViewSemSubHistoryAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSemSubHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = viewSubjectRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ViewSemSubHistoryAdapter.class), b4, b5);
            }
        });
    }

    private final ViewSubjectRegistrationViewModel getViewSubjectRegistrationViewModel() {
        return (ViewSubjectRegistrationViewModel) this.viewSubjectRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogViewSubjectRegistrationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewSubjectRegistrationAdapter getAdapter() {
        return (ViewSubjectRegistrationAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewSemSubHistoryAdapter getAdapter2() {
        return (ViewSemSubHistoryAdapter) this.adapter2.getValue();
    }

    /* compiled from: ViewSubjectRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewSubjectRegistrationDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ViewSubjectRegistrationDialog viewSubjectRegistrationDialog = new ViewSubjectRegistrationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            viewSubjectRegistrationDialog.setArguments(bundle);
            return viewSubjectRegistrationDialog;
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
        this._binding = DialogViewSubjectRegistrationBinding.inflate(inflater, container, false);
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding = get_binding();
        if (dialogViewSubjectRegistrationBinding != null) {
            dialogViewSubjectRegistrationBinding.setViewSubjectRegistrationViewModel(getViewSubjectRegistrationViewModel());
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding2 = get_binding();
        if (dialogViewSubjectRegistrationBinding2 != null) {
            dialogViewSubjectRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding3 = get_binding();
        if (dialogViewSubjectRegistrationBinding3 != null) {
            return dialogViewSubjectRegistrationBinding3.getRoot();
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
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding = get_binding();
        RecyclerView recyclerView = dialogViewSubjectRegistrationBinding != null ? dialogViewSubjectRegistrationBinding.rvSubStatus : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding2 = get_binding();
        RecyclerView recyclerView2 = dialogViewSubjectRegistrationBinding2 != null ? dialogViewSubjectRegistrationBinding2.rvSemHistory : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter2());
        }
        ViewSubjectRegistrationViewModel viewSubjectRegistrationViewModel = getViewSubjectRegistrationViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        viewSubjectRegistrationViewModel.getData(str);
        listenResponse();
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding3 = get_binding();
        if (dialogViewSubjectRegistrationBinding3 != null && (textView2 = dialogViewSubjectRegistrationBinding3.subjectsBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewSubjectRegistrationDialog.setUp$lambda$1(ViewSubjectRegistrationDialog.this, view);
                }
            });
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding4 = get_binding();
        if (dialogViewSubjectRegistrationBinding4 == null || (textView = dialogViewSubjectRegistrationBinding4.semHistoryBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewSubjectRegistrationDialog.setUp$lambda$2(ViewSubjectRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ViewSubjectRegistrationDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding = this$0.get_binding();
        RecyclerView recyclerView = dialogViewSubjectRegistrationBinding != null ? dialogViewSubjectRegistrationBinding.rvSubStatus : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding2 = this$0.get_binding();
        RecyclerView recyclerView2 = dialogViewSubjectRegistrationBinding2 != null ? dialogViewSubjectRegistrationBinding2.rvSemHistory : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding3 = this$0.get_binding();
        if (dialogViewSubjectRegistrationBinding3 != null && (textView2 = dialogViewSubjectRegistrationBinding3.semHistoryBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_new_unselected);
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding4 = this$0.get_binding();
        if (dialogViewSubjectRegistrationBinding4 == null || (textView = dialogViewSubjectRegistrationBinding4.subjectsBtn) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_new_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ViewSubjectRegistrationDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding = this$0.get_binding();
        RecyclerView recyclerView = dialogViewSubjectRegistrationBinding != null ? dialogViewSubjectRegistrationBinding.rvSubStatus : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding2 = this$0.get_binding();
        RecyclerView recyclerView2 = dialogViewSubjectRegistrationBinding2 != null ? dialogViewSubjectRegistrationBinding2.rvSemHistory : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding3 = this$0.get_binding();
        if (dialogViewSubjectRegistrationBinding3 != null && (textView2 = dialogViewSubjectRegistrationBinding3.semHistoryBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_new_selected);
        }
        DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding4 = this$0.get_binding();
        if (dialogViewSubjectRegistrationBinding4 == null || (textView = dialogViewSubjectRegistrationBinding4.subjectsBtn) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_new_unselected);
    }

    private final void listenResponse() {
        getViewSubjectRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new ViewSubjectRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewSubjectRegistrationResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog$listenResponse$1

            /* compiled from: ViewSubjectRegistrationDialog.kt */
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
                DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding;
                DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding2;
                DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding3;
                ViewSubjectRegistrationAdapter adapter;
                ViewSemSubHistoryAdapter adapter2;
                DialogViewSubjectRegistrationBinding dialogViewSubjectRegistrationBinding4;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ViewSubjectRegistrationDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ViewSubjectRegistrationDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ViewSubjectRegistrationDialog.this.hideProgress();
                    dialogViewSubjectRegistrationBinding4 = ViewSubjectRegistrationDialog.this.get_binding();
                    if (dialogViewSubjectRegistrationBinding4 == null || (textView = dialogViewSubjectRegistrationBinding4.updateBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ViewSubjectRegistrationDialog.this.hideProgress();
                ViewSubjectRegistrationResponse data = resource.getData();
                if (data != null) {
                    ViewSubjectRegistrationDialog viewSubjectRegistrationDialog = ViewSubjectRegistrationDialog.this;
                    dialogViewSubjectRegistrationBinding = viewSubjectRegistrationDialog.get_binding();
                    TextView textView2 = dialogViewSubjectRegistrationBinding != null ? dialogViewSubjectRegistrationBinding.semTv : null;
                    if (textView2 != null) {
                        textView2.setText(data.getSemester());
                    }
                    dialogViewSubjectRegistrationBinding2 = viewSubjectRegistrationDialog.get_binding();
                    TextView textView3 = dialogViewSubjectRegistrationBinding2 != null ? dialogViewSubjectRegistrationBinding2.pathwayTv : null;
                    if (textView3 != null) {
                        textView3.setText(data.getPath_way());
                    }
                    dialogViewSubjectRegistrationBinding3 = viewSubjectRegistrationDialog.get_binding();
                    TextView textView4 = dialogViewSubjectRegistrationBinding3 != null ? dialogViewSubjectRegistrationBinding3.categoryTv : null;
                    if (textView4 != null) {
                        textView4.setText(data.getCategory());
                    }
                    adapter = viewSubjectRegistrationDialog.getAdapter();
                    ArrayList<Category> data2 = data.getData();
                    Context requireContext = viewSubjectRegistrationDialog.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(data2, requireContext);
                    adapter2 = viewSubjectRegistrationDialog.getAdapter2();
                    ArrayList<SemesterList> previousdata = data.getPreviousdata();
                    Context requireContext2 = viewSubjectRegistrationDialog.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                    adapter2.addItems(previousdata, requireContext2);
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