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

/* compiled from: CounsellingFragment.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001AB\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u001fH\u0014J\b\u0010%\u001a\u00020\u001fH\u0014J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\u001a\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u00108\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010:\u001a\u00020\u001fH\u0014J\u001a\u0010;\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\u001fH\u0014J\b\u0010?\u001a\u00020\u001fH\u0014J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/counselling/CounsellingFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/counselling/CounsellingAdapter$CallBack;", "Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog$AddCounsellingListener;", "Lin/etuwa/app/ui/counselling/remind/ReminderDialog$RemindCounsellingListener;", "Lin/etuwa/app/ui/counselling/review/ReviewDialog$ReviewCounsellingListener;", "()V", "_binding", "Lin/etuwa/app/databinding/CounsellingFragmentBinding;", "adapter", "Lin/etuwa/app/ui/counselling/CounsellingAdapter;", "getAdapter", "()Lin/etuwa/app/ui/counselling/CounsellingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/CounsellingFragmentBinding;", "counsellingViewModel", "Lin/etuwa/app/ui/counselling/CounsellingViewModel;", "getCounsellingViewModel", "()Lin/etuwa/app/ui/counselling/CounsellingViewModel;", "counsellingViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "delete", "", "id", "", "dismiss", "editCounselling", "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "remind", "reopen", "review", "setUp", "showAddDialog", "isReopen", "", "showBaseView", "showProgress", "viewCounselling", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CounsellingFragment extends BaseFragment implements CounsellingAdapter.CallBack, AddCounsellingDialog.AddCounsellingListener, ReminderDialog.RemindCounsellingListener, ReviewDialog.ReviewCounsellingListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CounsellingFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: counsellingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy counsellingViewModel;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CounsellingViewModel.class), qualifier, b, null, koinScope);
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
    /* renamed from: getBinding, reason: from getter */
    public final CounsellingFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: CounsellingFragment.kt */
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
                    CounsellingFragment.setUp$lambda$0(CounsellingFragment.this, view);
                }
            });
        }
        CounsellingFragmentBinding counsellingFragmentBinding3 = get_binding();
        if (counsellingFragmentBinding3 != null && (swipeRefreshLayout = counsellingFragmentBinding3.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    CounsellingFragment.setUp$lambda$1(CounsellingFragment.this);
                }
            });
        }
        CounsellingFragmentBinding counsellingFragmentBinding4 = get_binding();
        if (counsellingFragmentBinding4 == null || (recyclerView = counsellingFragmentBinding4.rvCounselling) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$setUp$3
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
            
                r1 = r0.this$0.get_binding();
             */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onScrolled(androidx.recyclerview.widget.RecyclerView r1, int r2, int r3) {
                /*
                    r0 = this;
                    java.lang.String r2 = "recyclerView"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                    r1 = 0
                    if (r3 >= 0) goto L37
                    in.etuwa.app.ui.counselling.CounsellingFragment r2 = in.etuwa.app.ui.counselling.CounsellingFragment.this
                    in.etuwa.app.databinding.CounsellingFragmentBinding r2 = in.etuwa.app.ui.counselling.CounsellingFragment.access$getBinding(r2)
                    if (r2 == 0) goto L1d
                    com.google.android.material.floatingactionbutton.FloatingActionButton r2 = r2.fabAddCounselling
                    if (r2 == 0) goto L1d
                    boolean r2 = r2.isShown()
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                    goto L1e
                L1d:
                    r2 = r1
                L1e:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                    boolean r2 = r2.booleanValue()
                    if (r2 != 0) goto L37
                    in.etuwa.app.ui.counselling.CounsellingFragment r1 = in.etuwa.app.ui.counselling.CounsellingFragment.this
                    in.etuwa.app.databinding.CounsellingFragmentBinding r1 = in.etuwa.app.ui.counselling.CounsellingFragment.access$getBinding(r1)
                    if (r1 == 0) goto L65
                    com.google.android.material.floatingactionbutton.FloatingActionButton r1 = r1.fabAddCounselling
                    if (r1 == 0) goto L65
                    r1.show()
                    goto L65
                L37:
                    if (r3 <= 0) goto L65
                    in.etuwa.app.ui.counselling.CounsellingFragment r2 = in.etuwa.app.ui.counselling.CounsellingFragment.this
                    in.etuwa.app.databinding.CounsellingFragmentBinding r2 = in.etuwa.app.ui.counselling.CounsellingFragment.access$getBinding(r2)
                    if (r2 == 0) goto L4d
                    com.google.android.material.floatingactionbutton.FloatingActionButton r2 = r2.fabAddCounselling
                    if (r2 == 0) goto L4d
                    boolean r1 = r2.isShown()
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                L4d:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                    boolean r1 = r1.booleanValue()
                    if (r1 == 0) goto L65
                    in.etuwa.app.ui.counselling.CounsellingFragment r1 = in.etuwa.app.ui.counselling.CounsellingFragment.this
                    in.etuwa.app.databinding.CounsellingFragmentBinding r1 = in.etuwa.app.ui.counselling.CounsellingFragment.access$getBinding(r1)
                    if (r1 == 0) goto L65
                    com.google.android.material.floatingactionbutton.FloatingActionButton r1 = r1.fabAddCounselling
                    if (r1 == 0) goto L65
                    r1.hide()
                L65:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.counselling.CounsellingFragment$setUp$3.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
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
        AddCounsellingDialog newInstance = AddCounsellingDialog.INSTANCE.newInstance(id, isReopen);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getCounsellingViewModel().getResponse().observe(getViewLifecycleOwner(), new CounsellingFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$listenResponse$1

            /* compiled from: CounsellingFragment.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingResponse> resource) {
                CounsellingAdapter adapter;
                CounsellingFragmentBinding counsellingFragmentBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    CounsellingFragment.this.hideProgress();
                    CounsellingResponse data = resource.getData();
                    if (data != null) {
                        CounsellingFragment counsellingFragment = CounsellingFragment.this;
                        counsellingFragment.showBaseView();
                        adapter = counsellingFragment.getAdapter();
                        adapter.addItems(data.getRequests());
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
                counsellingFragmentBinding = CounsellingFragment.this.get_binding();
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
        getCounsellingViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new CounsellingFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingFragment$listenDeleteResponse$1

            /* compiled from: CounsellingFragment.kt */
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
                CounsellingFragmentBinding counsellingFragmentBinding;
                CounsellingViewModel counsellingViewModel;
                FloatingActionButton fabAddCounselling;
                CounsellingFragmentBinding counsellingFragmentBinding2;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    CounsellingFragment.this.hideProgress();
                    SuccessResponse data = resource.getData();
                    if (data != null) {
                        CounsellingFragment counsellingFragment = CounsellingFragment.this;
                        counsellingFragmentBinding = counsellingFragment.get_binding();
                        if (counsellingFragmentBinding != null && (fabAddCounselling = counsellingFragmentBinding.fabAddCounselling) != null) {
                            Intrinsics.checkNotNullExpressionValue(fabAddCounselling, "fabAddCounselling");
                            ToastExtKt.showInfoToast(fabAddCounselling, data.getMessage());
                        }
                        counsellingViewModel = counsellingFragment.getCounsellingViewModel();
                        counsellingViewModel.getCounselling();
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
                counsellingFragmentBinding2 = CounsellingFragment.this.get_binding();
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
                CounsellingFragment.delete$lambda$2(CounsellingFragment.this, id, dialogInterface, i);
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
        ReminderDialog newInstance = ReminderDialog.INSTANCE.newInstance(id);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.counselling.CounsellingAdapter.CallBack
    public void review(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ReviewDialog newInstance = ReviewDialog.INSTANCE.newInstance(id);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
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