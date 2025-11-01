package in.etuwa.app.ui.profile.fundedresearch;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.fundedresearch.FundedResearchResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFundedResearchBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.profile.fundedresearch.FundedResearchAdapter;
import in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog;
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

/* compiled from: FundedResearchFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dH\u0016J0\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001fH\u0014J\b\u0010+\u001a\u00020\u001fH\u0014J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u001fH\u0016J\b\u00107\u001a\u00020\u001fH\u0016J\u001a\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010:\u001a\u00020\u001fH\u0014J\b\u0010;\u001a\u00020\u001fH\u0014J\b\u0010<\u001a\u00020\u001fH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006>"}, d2 = {"Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchAdapter$ResearchListener;", "Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchDialog$AddFundedResearchListener;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentFundedResearchBinding;", "adapter", "Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchAdapter;", "getAdapter", "()Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentFundedResearchBinding;", "fundedResearchViewModel", "Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchViewModel;", "getFundedResearchViewModel", "()Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchViewModel;", "fundedResearchViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "deleteView", "downloadFile", "url", CommonCssConstants.POSITION, "editBtnClicked", "title", "agency", ExamSubjectDetailDialogKt.ARG_AMOUNT, TypedValues.TransitionType.S_DURATION, "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDismiss", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FundedResearchFragment extends BaseFragment implements FundedResearchAdapter.ResearchListener, AddFundedResearchDialog.AddFundedResearchListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFundedResearchBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: fundedResearchViewModel$delegate, reason: from kotlin metadata */
    private final Lazy fundedResearchViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: FundedResearchFragment.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteView$lambda$7(DialogInterface dialogInterface, int i) {
    }

    @JvmStatic
    public static final FundedResearchFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.profile.fundedresearch.FundedResearchAdapter.ResearchListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return true;
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FundedResearchFragment() {
        final FundedResearchFragment fundedResearchFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fundedResearchFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.fundedResearchViewModel = FragmentViewModelLazyKt.createViewModelLazy(fundedResearchFragment, Reflection.getOrCreateKotlinClass(FundedResearchViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FundedResearchViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FundedResearchFragment fundedResearchFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FundedResearchAdapter>() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.fundedresearch.FundedResearchAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FundedResearchAdapter invoke() {
                ComponentCallbacks componentCallbacks = fundedResearchFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FundedResearchAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = fundedResearchFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final FundedResearchViewModel getFundedResearchViewModel() {
        return (FundedResearchViewModel) this.fundedResearchViewModel.getValue();
    }

    private final FundedResearchAdapter getAdapter() {
        return (FundedResearchAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentFundedResearchBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: FundedResearchFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FundedResearchFragment newInstance() {
            return new FundedResearchFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFundedResearchBinding.inflate(inflater, container, false);
        FragmentFundedResearchBinding fragmentFundedResearchBinding = get_binding();
        if (fragmentFundedResearchBinding != null) {
            fragmentFundedResearchBinding.setFundedResearchViewModel(getFundedResearchViewModel());
        }
        FragmentFundedResearchBinding fragmentFundedResearchBinding2 = get_binding();
        if (fragmentFundedResearchBinding2 != null) {
            fragmentFundedResearchBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFundedResearchBinding fragmentFundedResearchBinding3 = get_binding();
        if (fragmentFundedResearchBinding3 != null) {
            return fragmentFundedResearchBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Funded Research");
        }
        hideBaseView();
        FragmentFundedResearchBinding fragmentFundedResearchBinding = get_binding();
        RecyclerView recyclerView = fragmentFundedResearchBinding != null ? fragmentFundedResearchBinding.rvResearch : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setResearchListener(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenDeleteResponse();
        getFundedResearchViewModel().getFundedResearchData();
        FragmentFundedResearchBinding fragmentFundedResearchBinding2 = get_binding();
        if (fragmentFundedResearchBinding2 != null && (swipeRefreshLayout = fragmentFundedResearchBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    FundedResearchFragment.setUp$lambda$0(FundedResearchFragment.this);
                }
            });
        }
        FragmentFundedResearchBinding fragmentFundedResearchBinding3 = get_binding();
        if (fragmentFundedResearchBinding3 == null || (textView = fragmentFundedResearchBinding3.addBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FundedResearchFragment.setUp$lambda$1(FundedResearchFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FundedResearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFundedResearchViewModel().getFundedResearchData();
        FragmentFundedResearchBinding fragmentFundedResearchBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentFundedResearchBinding != null ? fragmentFundedResearchBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(FundedResearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddFundedResearchDialog newInstance = AddFundedResearchDialog.INSTANCE.newInstance("", "", "", "", "");
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getFundedResearchViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FundedResearchFragment.listenResponse$lambda$3(FundedResearchFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(FundedResearchFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            FundedResearchResponse fundedResearchResponse = (FundedResearchResponse) resource.getData();
            if (fundedResearchResponse != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(fundedResearchResponse.getFunded());
                return;
            }
            return;
        }
        if (i == 2) {
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
        FragmentFundedResearchBinding fragmentFundedResearchBinding = this$0.get_binding();
        if (fragmentFundedResearchBinding == null || (recyclerView = fragmentFundedResearchBinding.rvResearch) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenDeleteResponse() {
        getFundedResearchViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FundedResearchFragment.listenDeleteResponse$lambda$5(FundedResearchFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$5(FundedResearchFragment this$0, Resource resource) {
        RecyclerView rvResearch;
        RecyclerView rvResearch2;
        RecyclerView recyclerView;
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
            FragmentFundedResearchBinding fragmentFundedResearchBinding = this$0.get_binding();
            if (fragmentFundedResearchBinding == null || (recyclerView = fragmentFundedResearchBinding.rvResearch) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                FragmentFundedResearchBinding fragmentFundedResearchBinding2 = this$0.get_binding();
                if (fragmentFundedResearchBinding2 != null && (rvResearch2 = fragmentFundedResearchBinding2.rvResearch) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvResearch2, "rvResearch");
                    ToastExtKt.showSuccessToast(rvResearch2, successResponse.getMessage());
                }
                this$0.getFundedResearchViewModel().getFundedResearchData();
                return;
            }
            FragmentFundedResearchBinding fragmentFundedResearchBinding3 = this$0.get_binding();
            if (fragmentFundedResearchBinding3 == null || (rvResearch = fragmentFundedResearchBinding3.rvResearch) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvResearch, "rvResearch");
            ToastExtKt.showErrorToast(rvResearch, successResponse.getMessage());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentFundedResearchBinding fragmentFundedResearchBinding = get_binding();
        if (fragmentFundedResearchBinding == null || (recyclerView = fragmentFundedResearchBinding.rvResearch) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentFundedResearchBinding fragmentFundedResearchBinding = get_binding();
        if (fragmentFundedResearchBinding == null || (recyclerView = fragmentFundedResearchBinding.rvResearch) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.profile.fundedresearch.FundedResearchAdapter.ResearchListener
    public void downloadFile(String url, String position) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(position, "position");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        startActivity(Intent.createChooser(intent, "Open With"));
    }

    @Override // in.etuwa.app.ui.profile.fundedresearch.FundedResearchAdapter.ResearchListener
    public void editBtnClicked(String id, String title, String agency, String amount, String duration) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(duration, "duration");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddFundedResearchDialog newInstance = AddFundedResearchDialog.INSTANCE.newInstance(id, title, agency, amount, duration);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void deleteView(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Are you sure you want to Delete?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FundedResearchFragment.deleteView$lambda$6(FundedResearchFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FundedResearchFragment.deleteView$lambda$7(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteView$lambda$6(FundedResearchFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getFundedResearchViewModel().deleteFundedResearchData(id);
    }

    @Override // in.etuwa.app.ui.profile.fundedresearch.FundedResearchAdapter.ResearchListener
    public void deleteBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        deleteView(id);
    }

    @Override // in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog.AddFundedResearchListener
    public void onDismiss() {
        getFundedResearchViewModel().getFundedResearchData();
    }
}