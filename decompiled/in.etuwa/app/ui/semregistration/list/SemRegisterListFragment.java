package in.etuwa.app.ui.semregistration.list;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.semregistration.list.SemRegisterListResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SemRegisterListFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog;
import in.etuwa.app.ui.semregistration.list.SemRegisterListAdapter;
import in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SemRegisterListFragment.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001@B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020&H\u0014J\b\u0010)\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020&H\u0016J\b\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u0014H\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u00109\u001a\u00020\u0014H\u0016J\u001a\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010=\u001a\u00020&H\u0014J\b\u0010>\u001a\u00020&H\u0014J\b\u0010?\u001a\u00020&H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lin/etuwa/app/ui/semregistration/list/SemRegisterListFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/semregistration/list/SemRegisterListAdapter$RegListCallBack;", "Lin/etuwa/app/ui/semregistration/christ/ChristSemRegDialog$AddCounsellingListener;", "Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog$SemRegCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/SemRegisterListFragmentBinding;", "adapter", "Lin/etuwa/app/ui/semregistration/list/SemRegisterListAdapter;", "getAdapter", "()Lin/etuwa/app/ui/semregistration/list/SemRegisterListAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SemRegisterListFragmentBinding;", "dueStatus", "", "errorMessage", "", "feePaid", "feeStatus", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "registrationActive", "semRegisterListViewModel", "Lin/etuwa/app/ui/semregistration/list/SemRegisterListViewModel;", "getSemRegisterListViewModel", "()Lin/etuwa/app/ui/semregistration/list/SemRegisterListViewModel;", "semRegisterListViewModel$delegate", "statusMessage", "dismiss", "", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismissProfile", "onEditClick", "id", "onEditClicked", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SemRegisterListFragment extends BaseFragment implements SemRegisterListAdapter.RegListCallBack, ChristSemRegDialog.AddCounsellingListener, ViewMvjceSemRegDialog.SemRegCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SemRegisterListFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean dueStatus;
    private String errorMessage;
    private boolean feePaid;
    private boolean feeStatus;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private boolean registrationActive;

    /* renamed from: semRegisterListViewModel$delegate, reason: from kotlin metadata */
    private final Lazy semRegisterListViewModel;
    private String statusMessage;

    /* compiled from: SemRegisterListFragment.kt */
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
    public static final SemRegisterListFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$2(DialogInterface dialogInterface, int i) {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog.SemRegCallBack
    public void onDismissProfile() {
    }

    @Override // in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog.SemRegCallBack
    public void onEditClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SemRegisterListFragment() {
        final SemRegisterListFragment semRegisterListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(semRegisterListFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.semRegisterListViewModel = FragmentViewModelLazyKt.createViewModelLazy(semRegisterListFragment, Reflection.getOrCreateKotlinClass(SemRegisterListViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SemRegisterListViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SemRegisterListFragment semRegisterListFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SemRegisterListAdapter>() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.list.SemRegisterListAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemRegisterListAdapter invoke() {
                ComponentCallbacks componentCallbacks = semRegisterListFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemRegisterListAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = semRegisterListFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.statusMessage = "";
        this.errorMessage = "";
    }

    private final SemRegisterListViewModel getSemRegisterListViewModel() {
        return (SemRegisterListViewModel) this.semRegisterListViewModel.getValue();
    }

    private final SemRegisterListAdapter getAdapter() {
        return (SemRegisterListAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final SemRegisterListFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: SemRegisterListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/semregistration/list/SemRegisterListFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/list/SemRegisterListFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SemRegisterListFragment newInstance() {
            return new SemRegisterListFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SemRegisterListFragmentBinding.inflate(inflater, container, false);
        SemRegisterListFragmentBinding semRegisterListFragmentBinding = get_binding();
        if (semRegisterListFragmentBinding != null) {
            semRegisterListFragmentBinding.setSemRegisterListViewModel(getSemRegisterListViewModel());
        }
        SemRegisterListFragmentBinding semRegisterListFragmentBinding2 = get_binding();
        if (semRegisterListFragmentBinding2 != null) {
            semRegisterListFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SemRegisterListFragmentBinding semRegisterListFragmentBinding3 = get_binding();
        if (semRegisterListFragmentBinding3 != null) {
            return semRegisterListFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.sem_registration));
        }
        hideBaseView();
        SemRegisterListFragmentBinding semRegisterListFragmentBinding = get_binding();
        RecyclerView recyclerView = semRegisterListFragmentBinding != null ? semRegisterListFragmentBinding.rvRegList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setRegListCallBack(this);
        getSemRegisterListViewModel().getData();
        listenResponse();
        SemRegisterListFragmentBinding semRegisterListFragmentBinding2 = get_binding();
        if (semRegisterListFragmentBinding2 != null && (floatingActionButton = semRegisterListFragmentBinding2.fabAddSemReg) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SemRegisterListFragment.setUp$lambda$3(SemRegisterListFragment.this, view);
                }
            });
        }
        SemRegisterListFragmentBinding semRegisterListFragmentBinding3 = get_binding();
        if (semRegisterListFragmentBinding3 == null || (swipeRefreshLayout = semRegisterListFragmentBinding3.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SemRegisterListFragment.setUp$lambda$4(SemRegisterListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(final SemRegisterListFragment this$0, View view) {
        FloatingActionButton floatingActionButton;
        MainCallBackListener mainCallBackListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.registrationActive) {
            if (StringsKt.contains$default((CharSequence) this$0.errorMessage, (CharSequence) "dues", false, 2, (Object) null)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this$0.getContext());
                builder.setTitle("Clear Due !");
                builder.setMessage("Please clear all dues before registering for new semester");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SemRegisterListFragment.setUp$lambda$3$lambda$0(SemRegisterListFragment.this, dialogInterface, i);
                    }
                });
                AlertDialog create = builder.create();
                Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
                create.setCancelable(false);
                create.show();
                return;
            }
            if (StringsKt.contains$default((CharSequence) this$0.errorMessage, (CharSequence) "fee", false, 2, (Object) null)) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this$0.getContext());
                builder2.setTitle("Clear Fees !");
                builder2.setMessage("Please clear all fees before registering for new semester");
                builder2.setIcon(android.R.drawable.ic_dialog_alert);
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SemRegisterListFragment.setUp$lambda$3$lambda$1(SemRegisterListFragment.this, dialogInterface, i);
                    }
                });
                AlertDialog create2 = builder2.create();
                Intrinsics.checkNotNullExpressionValue(create2, "builder.create()");
                create2.setCancelable(false);
                create2.show();
                return;
            }
            if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                MainCallBackListener mainCallBackListener2 = this$0.listener;
                if (mainCallBackListener2 != null) {
                    mainCallBackListener2.openAsietSemReg();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(this$0.statusMessage, "") || !StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null)) {
                if (!Intrinsics.areEqual(this$0.statusMessage, "")) {
                    System.out.println((Object) "");
                    return;
                }
                if (this$0.dueStatus) {
                    if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "christ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        ChristSemRegDialog newInstance = ChristSemRegDialog.INSTANCE.newInstance();
                        newInstance.setCallBack(this$0);
                        newInstance.show(childFragmentManager, (String) null);
                        return;
                    }
                    if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cek", false, 2, (Object) null) || (mainCallBackListener = this$0.listener) == null) {
                        return;
                    }
                    mainCallBackListener.openSemRegisterPage(null, false, this$0.feeStatus);
                    return;
                }
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this$0.getContext());
                builder3.setTitle("Clear Due !");
                builder3.setMessage("Please clear all dues before registering for new semester");
                builder3.setIcon(android.R.drawable.ic_dialog_alert);
                builder3.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SemRegisterListFragment.setUp$lambda$3$lambda$2(dialogInterface, i);
                    }
                });
                AlertDialog create3 = builder3.create();
                Intrinsics.checkNotNullExpressionValue(create3, "builder.create()");
                create3.setCancelable(false);
                create3.show();
                return;
            }
            return;
        }
        SemRegisterListFragmentBinding semRegisterListFragmentBinding = this$0.get_binding();
        if (semRegisterListFragmentBinding == null || (floatingActionButton = semRegisterListFragmentBinding.fabAddSemReg) == null) {
            return;
        }
        ToastExtKt.showInfoToast(floatingActionButton, "Registration is not Active");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$0(SemRegisterListFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainDueClick(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$1(SemRegisterListFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMainFeeClick(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(SemRegisterListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSemRegisterListViewModel().getData();
        SemRegisterListFragmentBinding semRegisterListFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = semRegisterListFragmentBinding != null ? semRegisterListFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getSemRegisterListViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.list.SemRegisterListFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegisterListFragment.listenResponse$lambda$6(SemRegisterListFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(SemRegisterListFragment this$0, Resource resource) {
        RecyclerView rvRegList;
        RecyclerView rvRegList2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            SemRegisterListFragmentBinding semRegisterListFragmentBinding = this$0.get_binding();
            if (semRegisterListFragmentBinding == null || (recyclerView = semRegisterListFragmentBinding.rvRegList) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        try {
            SemRegisterListResponse semRegisterListResponse = (SemRegisterListResponse) resource.getData();
            if (semRegisterListResponse != null) {
                this$0.showBaseView();
                if (!semRegisterListResponse.getFeePaid() && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    SemRegisterListFragmentBinding semRegisterListFragmentBinding2 = this$0.get_binding();
                    if (semRegisterListFragmentBinding2 != null && (rvRegList2 = semRegisterListFragmentBinding2.rvRegList) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvRegList2, "rvRegList");
                        ToastExtKt.showErrorToast(rvRegList2, "Please clear all fees before registering for new semester!!!");
                    }
                    MainCallBackListener mainCallBackListener = this$0.listener;
                    if (mainCallBackListener != null) {
                        mainCallBackListener.onMainFeeClick(true);
                    }
                }
                if (!semRegisterListResponse.getHostelDueStatus()) {
                    SemRegisterListFragmentBinding semRegisterListFragmentBinding3 = this$0.get_binding();
                    if (semRegisterListFragmentBinding3 != null && (rvRegList = semRegisterListFragmentBinding3.rvRegList) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvRegList, "rvRegList");
                        ToastExtKt.showErrorToast(rvRegList, semRegisterListResponse.getHostelDueMessage());
                    }
                    MainCallBackListener mainCallBackListener2 = this$0.listener;
                    if (mainCallBackListener2 != null) {
                        mainCallBackListener2.onTkmHostelPayClick();
                    }
                }
                this$0.getAdapter().addItems(semRegisterListResponse.getRegisterList());
                this$0.feeStatus = semRegisterListResponse.getFeeExemption();
                this$0.statusMessage = semRegisterListResponse.getSemRegistrationStatusMessage();
                this$0.registrationActive = semRegisterListResponse.getSemRegistrationStatus();
                this$0.dueStatus = semRegisterListResponse.getDueStatus();
                this$0.feePaid = semRegisterListResponse.getFeePaid();
                this$0.errorMessage = semRegisterListResponse.getSemRegistrationStatusMessage();
            }
        } catch (NullPointerException unused) {
        }
    }

    @Override // in.etuwa.app.ui.semregistration.list.SemRegisterListAdapter.RegListCallBack
    public void onEditClick(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openSemRegisterViewPage(id);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        SemRegisterListFragmentBinding semRegisterListFragmentBinding = get_binding();
        if (semRegisterListFragmentBinding == null || (recyclerView = semRegisterListFragmentBinding.rvRegList) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        SemRegisterListFragmentBinding semRegisterListFragmentBinding = get_binding();
        if (semRegisterListFragmentBinding == null || (recyclerView = semRegisterListFragmentBinding.rvRegList) == null) {
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

    @Override // in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog.AddCounsellingListener
    public void dismiss() {
        getSemRegisterListViewModel().getData();
    }
}