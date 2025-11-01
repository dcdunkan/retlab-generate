package in.etuwa.app.ui.subjectregistration.statusview;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.subjectregistration.SubjectRegistration;
import in.etuwa.app.data.model.subjectregistration.SubjectRegistrationResponse;
import in.etuwa.app.databinding.DialogSubRegStatusBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment;
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog;
import in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusAdapter;
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

/* compiled from: SubjectRegStatusDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u000234B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u001a\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010/\u001a\u00020\u001d2\u0006\u0010 \u001a\u000200J\b\u00101\u001a\u00020\u001dH\u0014J\b\u00102\u001a\u00020\u001dH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a¨\u00065"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog$RegisterListener;", "Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusAdapter$StatusListCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogSubRegStatusBinding;", "adapter", "Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusAdapter;", "getAdapter", "()Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogSubRegStatusBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusDialog$RegisterListener;", "listner2", "Lin/etuwa/app/helper/MainCallBackListener;", CommonCssConstants.POSITION, "", "Ljava/lang/Integer;", "subjectRegStatusViewModel", "Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusViewModel;", "getSubjectRegStatusViewModel", "()Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusViewModel;", "subjectRegStatusViewModel$delegate", "hideProgress", "", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment;", "setUp", "showProgress", "Companion", "RegisterListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubjectRegStatusDialog extends BaseDialog implements ApplySubjectRegistrationDialog.RegisterListener, SubjectRegStatusAdapter.StatusListCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogSubRegStatusBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private RegisterListener listener;
    private MainCallBackListener listner2;
    private Integer position;

    /* renamed from: subjectRegStatusViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subjectRegStatusViewModel;

    /* compiled from: SubjectRegStatusDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusDialog$RegisterListener;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RegisterListener {
    }

    @JvmStatic
    public static final SubjectRegStatusDialog newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public SubjectRegStatusDialog() {
        final SubjectRegStatusDialog subjectRegStatusDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(subjectRegStatusDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.subjectRegStatusViewModel = FragmentViewModelLazyKt.createViewModelLazy(subjectRegStatusDialog, Reflection.getOrCreateKotlinClass(SubjectRegStatusViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SubjectRegStatusViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SubjectRegStatusDialog subjectRegStatusDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SubjectRegStatusAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegStatusAdapter invoke() {
                ComponentCallbacks componentCallbacks = subjectRegStatusDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegStatusAdapter.class), b2, b3);
            }
        });
    }

    private final SubjectRegStatusViewModel getSubjectRegStatusViewModel() {
        return (SubjectRegStatusViewModel) this.subjectRegStatusViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectRegStatusAdapter getAdapter() {
        return (SubjectRegStatusAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogSubRegStatusBinding get_binding() {
        return this._binding;
    }

    /* compiled from: SubjectRegStatusDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusDialog;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubjectRegStatusDialog newInstance(int position) {
            SubjectRegStatusDialog subjectRegStatusDialog = new SubjectRegStatusDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("id", position);
            subjectRegStatusDialog.setArguments(bundle);
            return subjectRegStatusDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = Integer.valueOf(arguments.getInt("id"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogSubRegStatusBinding.inflate(inflater, container, false);
        DialogSubRegStatusBinding dialogSubRegStatusBinding = get_binding();
        if (dialogSubRegStatusBinding != null) {
            dialogSubRegStatusBinding.setSubjectRegStatusViewModel(getSubjectRegStatusViewModel());
        }
        DialogSubRegStatusBinding dialogSubRegStatusBinding2 = get_binding();
        if (dialogSubRegStatusBinding2 != null) {
            dialogSubRegStatusBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogSubRegStatusBinding dialogSubRegStatusBinding3 = get_binding();
        if (dialogSubRegStatusBinding3 != null) {
            return dialogSubRegStatusBinding3.getRoot();
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
        DialogSubRegStatusBinding dialogSubRegStatusBinding = get_binding();
        RecyclerView recyclerView = dialogSubRegStatusBinding != null ? dialogSubRegStatusBinding.rvSubStatus : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setStatusListCallBack(this);
        getSubjectRegStatusViewModel().getData();
        listenResponse();
    }

    private final void listenResponse() {
        getSubjectRegStatusViewModel().getResponse().observe(getViewLifecycleOwner(), new SubjectRegStatusDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SubjectRegistrationResponse>, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusDialog$listenResponse$1

            /* compiled from: SubjectRegStatusDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SubjectRegistrationResponse> resource) {
                invoke2((Resource<SubjectRegistrationResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SubjectRegistrationResponse> resource) {
                SubjectRegStatusAdapter adapter;
                Integer num;
                DialogSubRegStatusBinding dialogSubRegStatusBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    SubjectRegStatusDialog.this.hideProgress();
                    SubjectRegistrationResponse data = resource.getData();
                    if (data != null) {
                        SubjectRegStatusDialog subjectRegStatusDialog = SubjectRegStatusDialog.this;
                        adapter = subjectRegStatusDialog.getAdapter();
                        ArrayList<SubjectRegistration> data2 = data.getData();
                        num = subjectRegStatusDialog.position;
                        Intrinsics.checkNotNull(num);
                        adapter.addItems(data2.get(num.intValue()).getStatus());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    SubjectRegStatusDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    SubjectRegStatusDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                SubjectRegStatusDialog.this.hideProgress();
                dialogSubRegStatusBinding = SubjectRegStatusDialog.this.get_binding();
                if (dialogSubRegStatusBinding == null || (recyclerView = dialogSubRegStatusBinding.rvSubStatus) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
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