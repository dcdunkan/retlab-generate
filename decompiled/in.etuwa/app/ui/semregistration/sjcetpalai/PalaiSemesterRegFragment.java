package in.etuwa.app.ui.semregistration.sjcetpalai;

import android.app.AlertDialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.semregistration.list.SemRegisterListResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentPalaiSemRegBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog;
import in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog;
import in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog;
import in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegAdapter;
import in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog;
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

/* compiled from: PalaiSemesterRegFragment.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001BB\u0005¢\u0006\u0002\u0010\bJ\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0014J\b\u0010*\u001a\u00020(H\u0014J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020(H\u0016J\b\u00108\u001a\u00020(H\u0016J\b\u00109\u001a\u00020(H\u0016J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020&H\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010;\u001a\u00020&H\u0016J\u001a\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010?\u001a\u00020(H\u0014J\b\u0010@\u001a\u00020(H\u0014J\b\u0010A\u001a\u00020(H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegAdapter$RegListCallBack;", "Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegDialog$AddCounsellingListener;", "Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegDialog$AddCounsellingListener;", "Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog$AddSemRegListener;", "Lin/etuwa/app/ui/semregistration/mea/MeaSemRegDialog$AddCounsellingListener;", "Lin/etuwa/app/ui/semregistration/mvjce/view/ViewMvjceSemRegDialog$SemRegCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentPalaiSemRegBinding;", "adapter", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegAdapter;", "getAdapter", "()Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentPalaiSemRegBinding;", "dueStatus", "", "feePaid", "feeStatus", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "palaiSemesterRegViewModel", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegViewModel;", "getPalaiSemesterRegViewModel", "()Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegViewModel;", "palaiSemesterRegViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "registrationActive", "statusMessage", "", "dismiss", "", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismissProfile", "onEditClick", "id", "onEditClicked", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PalaiSemesterRegFragment extends BaseFragment implements PalaiSemesterRegAdapter.RegListCallBack, PalaiNewSemRegDialog.AddCounsellingListener, MaceNewSemRegDialog.AddCounsellingListener, MvjceSemRegDialog.AddSemRegListener, MeaSemRegDialog.AddCounsellingListener, ViewMvjceSemRegDialog.SemRegCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentPalaiSemRegBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean dueStatus;
    private boolean feePaid;
    private boolean feeStatus;
    private MainCallBackListener listener;

    /* renamed from: palaiSemesterRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy palaiSemesterRegViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private boolean registrationActive;
    private String statusMessage;

    /* compiled from: PalaiSemesterRegFragment.kt */
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
    public static final PalaiSemesterRegFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(DialogInterface dialogInterface, int i) {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog.SemRegCallBack
    public void onDismissProfile() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public PalaiSemesterRegFragment() {
        final PalaiSemesterRegFragment palaiSemesterRegFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(palaiSemesterRegFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.palaiSemesterRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(palaiSemesterRegFragment, Reflection.getOrCreateKotlinClass(PalaiSemesterRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(PalaiSemesterRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final PalaiSemesterRegFragment palaiSemesterRegFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<PalaiSemesterRegAdapter>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PalaiSemesterRegAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiSemesterRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PalaiSemesterRegAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = palaiSemesterRegFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.statusMessage = "";
        this.feePaid = true;
    }

    private final PalaiSemesterRegViewModel getPalaiSemesterRegViewModel() {
        return (PalaiSemesterRegViewModel) this.palaiSemesterRegViewModel.getValue();
    }

    private final PalaiSemesterRegAdapter getAdapter() {
        return (PalaiSemesterRegAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentPalaiSemRegBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: PalaiSemesterRegFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PalaiSemesterRegFragment newInstance() {
            return new PalaiSemesterRegFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPalaiSemRegBinding.inflate(inflater, container, false);
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = get_binding();
        if (fragmentPalaiSemRegBinding != null) {
            fragmentPalaiSemRegBinding.setPalaiSemesterRegViewModel(getPalaiSemesterRegViewModel());
        }
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding2 = get_binding();
        if (fragmentPalaiSemRegBinding2 != null) {
            fragmentPalaiSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding3 = get_binding();
        if (fragmentPalaiSemRegBinding3 != null) {
            return fragmentPalaiSemRegBinding3.getRoot();
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
        TextView textView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.sem_registration));
        }
        hideBaseView();
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = get_binding();
        RecyclerView recyclerView = fragmentPalaiSemRegBinding != null ? fragmentPalaiSemRegBinding.rvRegistration : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setRegListCallBack(this);
        listenResponse();
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding2 = get_binding();
        if (fragmentPalaiSemRegBinding2 != null && (textView = fragmentPalaiSemRegBinding2.newRegistrationBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiSemesterRegFragment.setUp$lambda$1(PalaiSemesterRegFragment.this, view);
                }
            });
        }
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding3 = get_binding();
        if (fragmentPalaiSemRegBinding3 == null || (swipeRefreshLayout = fragmentPalaiSemRegBinding3.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$$ExternalSyntheticLambda3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                PalaiSemesterRegFragment.setUp$lambda$2(PalaiSemesterRegFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(PalaiSemesterRegFragment this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.registrationActive) {
            if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                MvjceSemRegDialog newInstance = MvjceSemRegDialog.INSTANCE.newInstance("");
                newInstance.setCallBack(this$0);
                newInstance.show(childFragmentManager, (String) null);
                return;
            }
            if (this$0.dueStatus) {
                if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                    FragmentManager childFragmentManager2 = this$0.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                    MaceNewSemRegDialog newInstance2 = MaceNewSemRegDialog.INSTANCE.newInstance();
                    newInstance2.setCallBack(this$0);
                    newInstance2.show(childFragmentManager2, (String) null);
                    return;
                }
                if (this$0.feePaid && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null)) {
                    return;
                }
                if (this$0.feePaid && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
                    return;
                }
                if (this$0.feePaid && StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    return;
                }
                if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "//meajj", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "//engnr", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                    FragmentManager childFragmentManager3 = this$0.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "childFragmentManager");
                    MeaSemRegDialog newInstance3 = MeaSemRegDialog.INSTANCE.newInstance("");
                    newInstance3.setCallBack(this$0);
                    newInstance3.show(childFragmentManager3, (String) null);
                    return;
                }
                FragmentManager childFragmentManager4 = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "childFragmentManager");
                PalaiNewSemRegDialog newInstance4 = PalaiNewSemRegDialog.INSTANCE.newInstance();
                newInstance4.setCallBack(this$0);
                newInstance4.show(childFragmentManager4, (String) null);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this$0.getContext());
            builder.setTitle("Clear Due !");
            builder.setMessage("Please clear all dues before registering for new semester");
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    PalaiSemesterRegFragment.setUp$lambda$1$lambda$0(dialogInterface, i);
                }
            });
            AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
            create.setCancelable(false);
            create.show();
            return;
        }
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = this$0.get_binding();
        if (fragmentPalaiSemRegBinding == null || (textView = fragmentPalaiSemRegBinding.newRegistrationBtn) == null) {
            return;
        }
        ToastExtKt.showInfoToast(textView, this$0.statusMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(PalaiSemesterRegFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPalaiSemesterRegViewModel().getData();
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentPalaiSemRegBinding != null ? fragmentPalaiSemRegBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getPalaiSemesterRegViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PalaiSemesterRegFragment.listenResponse$lambda$4(PalaiSemesterRegFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(PalaiSemesterRegFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
        MainCallBackListener mainCallBackListener2;
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
            FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = this$0.get_binding();
            if (fragmentPalaiSemRegBinding == null || (recyclerView = fragmentPalaiSemRegBinding.rvRegistration) == null) {
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
                this$0.feePaid = semRegisterListResponse.getFeePaid();
                if (semRegisterListResponse.getFeePaid() && !StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) && (mainCallBackListener2 = this$0.listener) != null) {
                    mainCallBackListener2.onMainFeeClick(true);
                }
                if (semRegisterListResponse.getFeePaid() && !StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null) && (mainCallBackListener = this$0.listener) != null) {
                    mainCallBackListener.onMainFeeClick(true);
                }
                if (semRegisterListResponse.getFeePaid()) {
                    StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null);
                }
                if (semRegisterListResponse.getFeePaid()) {
                    StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null);
                }
                this$0.getAdapter().addItems(semRegisterListResponse.getRegisterList());
                this$0.feeStatus = semRegisterListResponse.getFeeExemption();
                this$0.statusMessage = semRegisterListResponse.getSemRegistrationStatusMessage();
                this$0.registrationActive = semRegisterListResponse.getSemRegistrationStatus();
                this$0.dueStatus = semRegisterListResponse.getDueStatus();
            }
        } catch (NullPointerException unused) {
        }
    }

    @Override // in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegAdapter.RegListCallBack
    public void onEditClick(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            ViewMvjceSemRegDialog newInstance = ViewMvjceSemRegDialog.INSTANCE.newInstance(id);
            newInstance.setSemRegCallBack(this);
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openSemRegisterViewPage(id);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = get_binding();
        if (fragmentPalaiSemRegBinding == null || (recyclerView = fragmentPalaiSemRegBinding.rvRegistration) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentPalaiSemRegBinding fragmentPalaiSemRegBinding = get_binding();
        if (fragmentPalaiSemRegBinding == null || (recyclerView = fragmentPalaiSemRegBinding.rvRegistration) == null) {
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

    @Override // in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog.AddCounsellingListener, in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog.AddCounsellingListener, in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog.AddSemRegListener, in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog.AddCounsellingListener
    public void dismiss() {
        getPalaiSemesterRegViewModel().getData();
    }

    @Override // in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegDialog.SemRegCallBack
    public void onEditClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        MvjceSemRegDialog newInstance = MvjceSemRegDialog.INSTANCE.newInstance(id);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }
}