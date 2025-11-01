package in.etuwa.app.ui.subjectregistration;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.messaging.Constants;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.subjectregistration.SubjectRegistrationResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentSubjectRegistrationBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationAdapter;
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog;
import in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusDialog;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog;
import in.etuwa.app.utils.RecycleExtKt;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SubjectRegistrationFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001>B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0014J\b\u0010$\u001a\u00020\"H\u0014J\b\u0010%\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\"H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\u0014H\u0016J\u001a\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010;\u001a\u00020\"H\u0014J\b\u0010<\u001a\u00020\"H\u0014J\b\u0010=\u001a\u00020\"H\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b\u001e\u0010\u001f¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationAdapter$RegListCallBack;", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog$RegisterListener;", "Lin/etuwa/app/ui/subjectregistration/apply/ApplySubjectRegistrationDialog$RegisterListener;", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog$AddPublicationListener;", "Lin/etuwa/app/ui/subjectregistration/statusview/SubjectRegStatusDialog$RegisterListener;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentSubjectRegistrationBinding;", "adapter", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationAdapter;", "getAdapter", "()Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentSubjectRegistrationBinding;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "subjectRegistrationViewModel", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationViewModel;", "getSubjectRegistrationViewModel", "()Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationViewModel;", "subjectRegistrationViewModel$delegate", "dismiss", "", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onStatusClick", CommonCssConstants.POSITION, "", "onViewClick", "id", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubjectRegistrationFragment extends BaseFragment implements SubjectRegistrationAdapter.RegListCallBack, ViewSubjectRegistrationDialog.RegisterListener, ApplySubjectRegistrationDialog.RegisterListener, ApplyPreferenceSubRegDialog.AddPublicationListener, SubjectRegStatusDialog.RegisterListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentSubjectRegistrationBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String error;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: subjectRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subjectRegistrationViewModel;

    /* compiled from: SubjectRegistrationFragment.kt */
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
    public static final SubjectRegistrationFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SubjectRegistrationFragment() {
        final SubjectRegistrationFragment subjectRegistrationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(subjectRegistrationFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.subjectRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(subjectRegistrationFragment, Reflection.getOrCreateKotlinClass(SubjectRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SubjectRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SubjectRegistrationFragment subjectRegistrationFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SubjectRegistrationAdapter>() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subjectregistration.SubjectRegistrationAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectRegistrationAdapter invoke() {
                ComponentCallbacks componentCallbacks = subjectRegistrationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectRegistrationAdapter.class), b2, b3);
            }
        });
        this.error = "";
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = subjectRegistrationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final SubjectRegistrationViewModel getSubjectRegistrationViewModel() {
        return (SubjectRegistrationViewModel) this.subjectRegistrationViewModel.getValue();
    }

    private final SubjectRegistrationAdapter getAdapter() {
        return (SubjectRegistrationAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentSubjectRegistrationBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: SubjectRegistrationFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subjectregistration/SubjectRegistrationFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubjectRegistrationFragment newInstance() {
            return new SubjectRegistrationFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSubjectRegistrationBinding.inflate(inflater, container, false);
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding = get_binding();
        if (fragmentSubjectRegistrationBinding != null) {
            fragmentSubjectRegistrationBinding.setSubjectRegistrationViewModel(getSubjectRegistrationViewModel());
        }
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding2 = get_binding();
        if (fragmentSubjectRegistrationBinding2 != null) {
            fragmentSubjectRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding3 = get_binding();
        if (fragmentSubjectRegistrationBinding3 != null) {
            return fragmentSubjectRegistrationBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FloatingActionButton floatingActionButton;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Subject Registration");
        }
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding = get_binding();
        RecyclerView recyclerView = fragmentSubjectRegistrationBinding != null ? fragmentSubjectRegistrationBinding.rvRegList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setRegListCallBack(this);
        getSubjectRegistrationViewModel().getData();
        listenResponse();
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding2 = get_binding();
        if (fragmentSubjectRegistrationBinding2 != null && (floatingActionButton = fragmentSubjectRegistrationBinding2.fabAddSubReg) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectRegistrationFragment.setUp$lambda$0(SubjectRegistrationFragment.this, view);
                }
            });
        }
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding3 = get_binding();
        if (fragmentSubjectRegistrationBinding3 == null || (swipeRefreshLayout = fragmentSubjectRegistrationBinding3.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SubjectRegistrationFragment.setUp$lambda$1(SubjectRegistrationFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(SubjectRegistrationFragment this$0, View view) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.error, "")) {
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            ApplyPreferenceSubRegDialog newInstance = ApplyPreferenceSubRegDialog.INSTANCE.newInstance("");
            newInstance.setCallBack(this$0);
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding = this$0.get_binding();
        if (fragmentSubjectRegistrationBinding == null || (recyclerView = fragmentSubjectRegistrationBinding.rvRegList) == null) {
            return;
        }
        ToastExtKt.showErrorToast(recyclerView, this$0.error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SubjectRegistrationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSubjectRegistrationViewModel().getData();
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentSubjectRegistrationBinding != null ? fragmentSubjectRegistrationBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getSubjectRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subjectregistration.SubjectRegistrationFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubjectRegistrationFragment.listenResponse$lambda$3(SubjectRegistrationFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(SubjectRegistrationFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SubjectRegistrationResponse subjectRegistrationResponse = (SubjectRegistrationResponse) resource.getData();
            if (subjectRegistrationResponse != null) {
                this$0.getAdapter().addItems(subjectRegistrationResponse.getData());
                this$0.error = subjectRegistrationResponse.getError();
                return;
            }
            return;
        }
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
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding = this$0.get_binding();
        if (fragmentSubjectRegistrationBinding == null || (recyclerView = fragmentSubjectRegistrationBinding.rvRegList) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.subjectregistration.SubjectRegistrationAdapter.RegListCallBack
    public void onViewClick(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ViewSubjectRegistrationDialog newInstance = ViewSubjectRegistrationDialog.INSTANCE.newInstance(id);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.subjectregistration.SubjectRegistrationAdapter.RegListCallBack
    public void onStatusClick(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SubjectRegStatusDialog newInstance = SubjectRegStatusDialog.INSTANCE.newInstance(position);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentSubjectRegistrationBinding fragmentSubjectRegistrationBinding = get_binding();
        if (fragmentSubjectRegistrationBinding == null || (recyclerView = fragmentSubjectRegistrationBinding.rvRegList) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
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
        getAdapter().setRegListCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationDialog.RegisterListener, in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationDialog.RegisterListener
    public void dismiss() {
        getSubjectRegistrationViewModel().getData();
    }

    @Override // in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegDialog.AddPublicationListener
    public void onDismiss() {
        getSubjectRegistrationViewModel().getData();
    }
}