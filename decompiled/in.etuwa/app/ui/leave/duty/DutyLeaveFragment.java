package in.etuwa.app.ui.leave.duty;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.leave.duty.DutyLeave;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DutyLeaveFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.leave.duty.DutyLeaveAdapter;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialog;
import in.etuwa.app.ui.leave.duty.hour.HourDialog;
import in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave;
import in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeave;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DutyLeaveFragment.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001HB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017H\u0016J8\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0019j\b\u0012\u0004\u0012\u00020\u0017`\u001bH\u0016J\b\u0010.\u001a\u00020)H\u0014J\b\u0010/\u001a\u00020)H\u0014J\b\u00100\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020)H\u0016J\b\u0010@\u001a\u00020)H\u0016J\b\u0010A\u001a\u00020)H\u0016J\u001a\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J \u0010D\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0017H\u0016J\b\u0010E\u001a\u00020)H\u0014J\b\u0010F\u001a\u00020)H\u0014J\b\u0010G\u001a\u00020)H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&¨\u0006I"}, d2 = {"Lin/etuwa/app/ui/leave/duty/DutyLeaveFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter$LeaveCallBack;", "Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeave$AddLeaveCallBack;", "Lin/etuwa/app/ui/leave/duty/proof/ViewProofDutyLeave$ViewProofDutyLeaveCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DutyLeaveFragmentBinding;", "adapter", "Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter;", "getAdapter", "()Lin/etuwa/app/ui/leave/duty/DutyLeaveAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DutyLeaveFragmentBinding;", "dutyLeaveViewModel", "Lin/etuwa/app/ui/leave/duty/DutyLeaveViewModel;", "getDutyLeaveViewModel", "()Lin/etuwa/app/ui/leave/duty/DutyLeaveViewModel;", "dutyLeaveViewModel$delegate", "id2", "", "leaveList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "applyBtnClick", "", "id", NotificationCompat.CATEGORY_STATUS, "url", "appDates", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onBtnClick", "leave", "Lin/etuwa/app/data/model/leave/duty/DutyLeave;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onViewCreated", SvgConstants.Tags.VIEW, "proofBtnClickd", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DutyLeaveFragment extends BaseFragment implements DutyLeaveAdapter.LeaveCallBack, ProofDutyLeave.AddLeaveCallBack, ViewProofDutyLeave.ViewProofDutyLeaveCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DutyLeaveFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: dutyLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dutyLeaveViewModel;
    private String id2;
    private final ArrayList<Semester> leaveList;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: DutyLeaveFragment.kt */
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
    public static final DutyLeaveFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public DutyLeaveFragment() {
        final DutyLeaveFragment dutyLeaveFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(dutyLeaveFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.dutyLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(dutyLeaveFragment, Reflection.getOrCreateKotlinClass(DutyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(DutyLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DutyLeaveFragment dutyLeaveFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DutyLeaveAdapter>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.duty.DutyLeaveAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DutyLeaveAdapter invoke() {
                ComponentCallbacks componentCallbacks = dutyLeaveFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DutyLeaveAdapter.class), b2, b3);
            }
        });
        this.id2 = "";
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = dutyLeaveFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(DutyLeaveFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = dutyLeaveFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b6, function02);
            }
        });
        this.leaveList = CollectionsKt.arrayListOf(new Semester("0", "All"), new Semester("1", "Full Day"), new Semester(ExifInterface.GPS_MEASUREMENT_2D, "Hour"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DutyLeaveViewModel getDutyLeaveViewModel() {
        return (DutyLeaveViewModel) this.dutyLeaveViewModel.getValue();
    }

    private final DutyLeaveAdapter getAdapter() {
        return (DutyLeaveAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DutyLeaveFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: DutyLeaveFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/leave/duty/DutyLeaveFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/DutyLeaveFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DutyLeaveFragment newInstance() {
            return new DutyLeaveFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DutyLeaveFragmentBinding.inflate(inflater, container, false);
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding = get_binding();
        if (dutyLeaveFragmentBinding != null) {
            dutyLeaveFragmentBinding.setDutyLeaveViewModel(getDutyLeaveViewModel());
        }
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding2 = get_binding();
        if (dutyLeaveFragmentBinding2 != null) {
            dutyLeaveFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding3 = get_binding();
        if (dutyLeaveFragmentBinding3 != null) {
            return dutyLeaveFragmentBinding3.getRoot();
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
        hideBaseView();
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding = get_binding();
        RecyclerView recyclerView = dutyLeaveFragmentBinding != null ? dutyLeaveFragmentBinding.rvDutyLeave : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setLeaveCallBack(this);
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding2 = get_binding();
        Spinner spinner = dutyLeaveFragmentBinding2 != null ? dutyLeaveFragmentBinding2.spinnerLeave : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getSpinnerAdapter().addItems(this.leaveList);
        listenResponse();
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mea", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) {
            DutyLeaveFragmentBinding dutyLeaveFragmentBinding3 = get_binding();
            TextView textView2 = dutyLeaveFragmentBinding3 != null ? dutyLeaveFragmentBinding3.directApplyBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            DutyLeaveFragmentBinding dutyLeaveFragmentBinding4 = get_binding();
            TextView textView3 = dutyLeaveFragmentBinding4 != null ? dutyLeaveFragmentBinding4.directApplyBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding5 = get_binding();
        Spinner spinner2 = dutyLeaveFragmentBinding5 != null ? dutyLeaveFragmentBinding5.spinnerLeave : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter;
                    DutyLeaveViewModel dutyLeaveViewModel;
                    spinnerAdapter = DutyLeaveFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    dutyLeaveViewModel = DutyLeaveFragment.this.getDutyLeaveViewModel();
                    dutyLeaveViewModel.getLeave(semester.getId());
                    DutyLeaveFragment.this.id2 = semester.getId();
                }
            });
        }
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding6 = get_binding();
        if (dutyLeaveFragmentBinding6 == null || (textView = dutyLeaveFragmentBinding6.directApplyBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DutyLeaveFragment.setUp$lambda$0(DutyLeaveFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(DutyLeaveFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showDirectApplyFragment();
        }
    }

    private final void listenResponse() {
        getDutyLeaveViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DutyLeaveFragment.listenResponse$lambda$2(DutyLeaveFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(DutyLeaveFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<DutyLeave> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(arrayList);
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
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding = this$0.get_binding();
        if (dutyLeaveFragmentBinding == null || (recyclerView = dutyLeaveFragmentBinding.rvDutyLeave) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.leave.duty.DutyLeaveAdapter.LeaveCallBack
    public void onBtnClick(DutyLeave leave) {
        HourDialog newInstance;
        Intrinsics.checkNotNullParameter(leave, "leave");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (Intrinsics.areEqual(leave.getType(), "1")) {
            newInstance = FullDayDialog.INSTANCE.newInstance(leave.getId(), leave.getBtnStatus());
        } else {
            newInstance = HourDialog.INSTANCE.newInstance(leave.getId(), leave.getBtnStatus());
        }
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.leave.duty.DutyLeaveAdapter.LeaveCallBack
    public void applyBtnClick(String id, String status, String url, ArrayList<String> appDates) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(appDates, "appDates");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (StringsKt.contains$default((CharSequence) status, (CharSequence) "Apply", false, 2, (Object) null)) {
            ProofDutyLeave.INSTANCE.newInstance(id, appDates).show(childFragmentManager, (String) null);
        } else {
            if (Intrinsics.areEqual(url, "")) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            startActivity(Intent.createChooser(intent, "Open With"));
        }
    }

    @Override // in.etuwa.app.ui.leave.duty.DutyLeaveAdapter.LeaveCallBack
    public void applyBtnClick(String id, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (StringsKt.contains$default((CharSequence) status, (CharSequence) "Apply", false, 2, (Object) null)) {
            ProofDutyLeave newInstance = ProofDutyLeave.INSTANCE.newInstance(id, new ArrayList<>());
            newInstance.setAddLeaveCallBack(this);
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    @Override // in.etuwa.app.ui.leave.duty.DutyLeaveAdapter.LeaveCallBack
    public void proofBtnClickd(String id, String status, String url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual(url, "")) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        startActivity(Intent.createChooser(intent, "Open With"));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding = get_binding();
        if (dutyLeaveFragmentBinding == null || (recyclerView = dutyLeaveFragmentBinding.rvDutyLeave) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        DutyLeaveFragmentBinding dutyLeaveFragmentBinding = get_binding();
        if (dutyLeaveFragmentBinding == null || (recyclerView = dutyLeaveFragmentBinding.rvDutyLeave) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setLeaveCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave.AddLeaveCallBack, in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeave.ViewProofDutyLeaveCallBack
    public void onDismiss() {
        getDutyLeaveViewModel().getLeave(this.id2);
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
}