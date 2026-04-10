package in.etuwa.app.ui.counselling;

import android.app.AlertDialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.CounsellingResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.CounsellingFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.counselling.CounsellingAdapter;
import in.etuwa.app.ui.counselling.add.AddCounsellingDialog;
import in.etuwa.app.ui.counselling.remind.ReminderDialog;
import in.etuwa.app.ui.counselling.review.ReviewDialog;
import in.etuwa.app.utils.RecycleExtKt;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: CounsellingFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CounsellingFragment extends BaseFragment implements CounsellingAdapter.CallBack, AddCounsellingDialog.AddCounsellingListener, ReminderDialog.RemindCounsellingListener, ReviewDialog.ReviewCounsellingListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CounsellingFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: counsellingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy counsellingViewModel;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final CounsellingFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public CounsellingFragment() {
        final CounsellingFragment counsellingFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return counsellingFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(counsellingFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.counsellingViewModel = FragmentViewModelLazyKt.createViewModelLazy(counsellingFragment, Reflection.getOrCreateKotlinClass(CounsellingViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(CounsellingViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CounsellingFragment counsellingFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CounsellingAdapter>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.CounsellingAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingAdapter invoke() {
                ComponentCallbacks componentCallbacks = counsellingFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = counsellingFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingViewModel getCounsellingViewModel() {
        return (CounsellingViewModel) this.counsellingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingAdapter getAdapter() {
        return (CounsellingAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final CounsellingFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: CounsellingFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/counselling/CounsellingFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/CounsellingFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CounsellingFragment newInstance() {
            return new CounsellingFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CounsellingFragmentBinding.inflate(inflater, container, false);
        CounsellingFragmentBinding counsellingFragmentBinding = get_binding();
        if (counsellingFragmentBinding != null) {
            counsellingFragmentBinding.setCounsellingViewModel(getCounsellingViewModel());
        }
        CounsellingFragmentBinding counsellingFragmentBinding2 = get_binding();
        if (counsellingFragmentBinding2 != null) {
            counsellingFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CounsellingFragmentBinding counsellingFragmentBinding3 = get_binding();
        if (counsellingFragmentBinding3 != null) {
            return counsellingFragmentBinding3.getRoot();
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
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        FloatingActionButton floatingActionButton;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Counselling");
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        CounsellingFragmentBinding counsellingFragmentBinding = get_binding();
        RecyclerView recyclerView2 = counsellingFragmentBinding != null ? counsellingFragmentBinding.rvCounselling : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenDeleteResponse();
        CounsellingFragmentBinding counsellingFragmentBinding2 = get_binding();
        if (counsellingFragmentBinding2 != null && (floatingActionButton = counsellingFragmentBinding2.fabAddCounselling) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CounsellingFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        CounsellingFragmentBinding counsellingFragmentBinding3 = get_binding();
        if (counsellingFragmentBinding3 != null && (swipeRefreshLayout = counsellingFragmentBinding3.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    CounsellingFragment.setUp$lambda$1(this.f$0);
                }
            });
        }
        CounsellingFragmentBinding counsellingFragmentBinding4 = get_binding();
        if (counsellingFragmentBinding4 == null || (recyclerView = counsellingFragmentBinding4.rvCounselling) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment.setUp.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                CounsellingFragmentBinding counsellingFragmentBinding5;
                FloatingActionButton floatingActionButton2;
                FloatingActionButton floatingActionButton3;
                FloatingActionButton floatingActionButton4;
                FloatingActionButton floatingActionButton5;
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                Boolean boolValueOf = null;
                if (dy < 0) {
                    CounsellingFragmentBinding counsellingFragmentBinding6 = CounsellingFragment.this.get_binding();
                    Boolean boolValueOf2 = (counsellingFragmentBinding6 == null || (floatingActionButton5 = counsellingFragmentBinding6.fabAddCounselling) == null) ? null : Boolean.valueOf(floatingActionButton5.isShown());
                    Intrinsics.checkNotNull(boolValueOf2);
                    if (!boolValueOf2.booleanValue()) {
                        CounsellingFragmentBinding counsellingFragmentBinding7 = CounsellingFragment.this.get_binding();
                        if (counsellingFragmentBinding7 == null || (floatingActionButton4 = counsellingFragmentBinding7.fabAddCounselling) == null) {
                            return;
                        }
                        floatingActionButton4.show();
                        return;
                    }
                }
                if (dy > 0) {
                    CounsellingFragmentBinding counsellingFragmentBinding8 = CounsellingFragment.this.get_binding();
                    if (counsellingFragmentBinding8 != null && (floatingActionButton3 = counsellingFragmentBinding8.fabAddCounselling) != null) {
                        boolValueOf = Boolean.valueOf(floatingActionButton3.isShown());
                    }
                    Intrinsics.checkNotNull(boolValueOf);
                    if (!boolValueOf.booleanValue() || (counsellingFragmentBinding5 = CounsellingFragment.this.get_binding()) == null || (floatingActionButton2 = counsellingFragmentBinding5.fabAddCounselling) == null) {
                        return;
                    }
                    floatingActionButton2.hide();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(CounsellingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAddDialog(null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CounsellingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCounsellingViewModel().getCounselling();
        CounsellingFragmentBinding counsellingFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = counsellingFragmentBinding != null ? counsellingFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void showAddDialog(String id, boolean isReopen) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddCounsellingDialog addCounsellingDialogNewInstance = AddCounsellingDialog.INSTANCE.newInstance(id, isReopen);
        addCounsellingDialogNewInstance.setCallBack(this);
        addCounsellingDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getCounsellingViewModel().getResponse().observe(getViewLifecycleOwner(), new CounsellingFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.CounsellingFragment$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: CounsellingFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingResponse> resource) {
                invoke2((Resource<CounsellingResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingResponse> resource) {
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    CounsellingFragment.this.hideProgress();
                    CounsellingResponse data = resource.getData();
                    if (data != null) {
                        CounsellingFragment counsellingFragment = CounsellingFragment.this;
                        counsellingFragment.showBaseView();
                        counsellingFragment.getAdapter().addItems(data.getRequests());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    CounsellingFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    CounsellingFragment.this.hideProgress();
                    CounsellingFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                CounsellingFragment.this.hideProgress();
                CounsellingFragment.this.showBaseView();
                CounsellingFragmentBinding counsellingFragmentBinding = CounsellingFragment.this.get_binding();
                if (counsellingFragmentBinding == null || (recyclerView = counsellingFragmentBinding.rvCounselling) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    private final void listenDeleteResponse() {
        getCounsellingViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new CounsellingFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment.listenDeleteResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.CounsellingFragment$listenDeleteResponse$1$WhenMappings */
            /* JADX INFO: compiled from: CounsellingFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                FloatingActionButton fabAddCounselling;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    CounsellingFragment.this.hideProgress();
                    SuccessResponse data = resource.getData();
                    if (data != null) {
                        CounsellingFragment counsellingFragment = CounsellingFragment.this;
                        CounsellingFragmentBinding counsellingFragmentBinding = counsellingFragment.get_binding();
                        if (counsellingFragmentBinding != null && (fabAddCounselling = counsellingFragmentBinding.fabAddCounselling) != null) {
                            Intrinsics.checkNotNullExpressionValue(fabAddCounselling, "fabAddCounselling");
                            ToastExtKt.showInfoToast(fabAddCounselling, data.getMessage());
                        }
                        counsellingFragment.getCounsellingViewModel().getCounselling();
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    CounsellingFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    CounsellingFragment.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                CounsellingFragment.this.hideProgress();
                CounsellingFragmentBinding counsellingFragmentBinding2 = CounsellingFragment.this.get_binding();
                if (counsellingFragmentBinding2 == null || (recyclerView = counsellingFragmentBinding2.rvCounselling) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void delete(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Are You Sure You Want To Delete This Counselling??");
        builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CounsellingFragment.delete$lambda$2(this.f$0, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton(getString(R.string.no), (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delete$lambda$2(CounsellingFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getCounsellingViewModel().deleteCounselling(id);
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void remind(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ReminderDialog reminderDialogNewInstance = ReminderDialog.INSTANCE.newInstance(id);
        reminderDialogNewInstance.setCallBack(this);
        reminderDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void review(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ReviewDialog reviewDialogNewInstance = ReviewDialog.INSTANCE.newInstance(id);
        reviewDialogNewInstance.setCallBack(this);
        reviewDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void viewCounselling(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openViewCounselling(id);
        }
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void editCounselling(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        showAddDialog(id, false);
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void reopen(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        showAddDialog(id, true);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        CounsellingFragmentBinding counsellingFragmentBinding = get_binding();
        if (counsellingFragmentBinding == null || (recyclerView = counsellingFragmentBinding.rvCounselling) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        CounsellingFragmentBinding counsellingFragmentBinding = get_binding();
        if (counsellingFragmentBinding == null || (recyclerView = counsellingFragmentBinding.rvCounselling) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.counselling.add.AddCounsellingDialog.AddCounsellingListener, in.etuwa.app.ui.counselling.remind.ReminderDialog.RemindCounsellingListener, in.etuwa.app.ui.counselling.review.ReviewDialog.ReviewCounsellingListener
    public void dismiss() {
        getCounsellingViewModel().getCounselling();
    }
}