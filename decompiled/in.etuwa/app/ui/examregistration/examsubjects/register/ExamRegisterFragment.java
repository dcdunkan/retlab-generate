package in.etuwa.app.ui.examregistration.examsubjects.register;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.examregister.ExamCourse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
import in.etuwa.app.data.model.examregister.FixedHeadGroup;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentExamRegistrationBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

/* compiled from: ExamRegisterFragment.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001gB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010K\u001a\u00020LH\u0014J\b\u0010M\u001a\u00020LH\u0014J\b\u0010N\u001a\u00020LH\u0002J\b\u0010O\u001a\u00020LH\u0002J\b\u0010P\u001a\u00020LH\u0003J\b\u0010Q\u001a\u00020LH\u0002J\u0010\u0010R\u001a\u00020L2\u0006\u0010S\u001a\u00020TH\u0016J\u0012\u0010U\u001a\u00020L2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J&\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010^\u001a\u00020LH\u0016J\u001a\u0010_\u001a\u00020L2\u0006\u0010`\u001a\u00020Y2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010a\u001a\u00020LH\u0014J\b\u0010b\u001a\u00020LH\u0014J\b\u0010c\u001a\u00020LH\u0014J$\u0010d\u001a\u00020L2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00180=2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180=H\u0016J$\u0010f\u001a\u00020L2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00180=2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180=H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010(R\u001e\u0010*\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010-\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u0002040\u0014j\b\u0012\u0004\u0012\u000204`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\f\u001a\u0004\b9\u0010:R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R\u001a\u0010E\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012R\u001a\u0010H\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012¨\u0006h"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter$CallBack;", "Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog$ExamDetailListner;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentExamRegistrationBinding;", "adapter", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "additionalFee", "", "getAdditionalFee", "()D", "setAdditionalFee", "(D)V", "additionalFees", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/FixedHeadGroup;", "Lkotlin/collections/ArrayList;", "admissionNo", "", "batchId", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentExamRegistrationBinding;", "category", "checkBoxStatus", "", "getCheckBoxStatus", "()Ljava/lang/Boolean;", "setCheckBoxStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "examRegisterViewModel", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterViewModel;", "getExamRegisterViewModel", "()Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterViewModel;", "examRegisterViewModel$delegate", "feeStatus", "getFeeStatus", "setFeeStatus", "flag", "getFlag", "()Z", "setFlag", "(Z)V", "id", "list", "Lin/etuwa/app/data/model/examregister/ExamCourse;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "selected", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", ExamSubjectDetailDialogKt.ARG_TOTAL, "getTot", "setTot", FeeConfirmDialogKt.ARG_TOTAL, "getTotal", "setTotal", "totalSel", "getTotalSel", "setTotalSel", "hideBaseView", "", "hideProgress", "listenPayResponse", "listenPioPayResponse", "listenResponse", "listenScStPayResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "updateSelected", "sel", "updateSelected2", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExamRegisterFragment extends BaseFragment implements ExamRegisterAdapter.CallBack, ExamSubjectDetailDialog.ExamDetailListner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamRegistrationBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private double additionalFee;
    private ArrayList<FixedHeadGroup> additionalFees;
    private String admissionNo;
    private String batchId;
    private String category;
    private Boolean checkBoxStatus;

    /* renamed from: examRegisterViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examRegisterViewModel;
    private Boolean feeStatus;
    private boolean flag;
    private String id;
    private ArrayList<ExamCourse> list;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private double tot;
    private double total;
    private double totalSel;

    /* compiled from: ExamRegisterFragment.kt */
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
    public static final ExamRegisterFragment newInstance(String str, String str2, boolean z, boolean z2) {
        return INSTANCE.newInstance(str, str2, z, z2);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ExamRegisterFragment() {
        final ExamRegisterFragment examRegisterFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examRegisterFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examRegisterViewModel = FragmentViewModelLazyKt.createViewModelLazy(examRegisterFragment, Reflection.getOrCreateKotlinClass(ExamRegisterViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamRegisterViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamRegisterFragment examRegisterFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ExamRegisterAdapter>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamRegisterAdapter invoke() {
                ComponentCallbacks componentCallbacks = examRegisterFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamRegisterAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = examRegisterFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.selected = new ArrayList();
        this.list = new ArrayList<>();
        this.additionalFees = new ArrayList<>();
        this.flag = true;
    }

    private final ExamRegisterViewModel getExamRegisterViewModel() {
        return (ExamRegisterViewModel) this.examRegisterViewModel.getValue();
    }

    private final ExamRegisterAdapter getAdapter() {
        return (ExamRegisterAdapter) this.adapter.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentExamRegistrationBinding get_binding() {
        return this._binding;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    public final double getTot() {
        return this.tot;
    }

    public final void setTot(double d) {
        this.tot = d;
    }

    public final double getAdditionalFee() {
        return this.additionalFee;
    }

    public final void setAdditionalFee(double d) {
        this.additionalFee = d;
    }

    public final double getTotalSel() {
        return this.totalSel;
    }

    public final void setTotalSel(double d) {
        this.totalSel = d;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    public final Boolean getFeeStatus() {
        return this.feeStatus;
    }

    public final void setFeeStatus(Boolean bool) {
        this.feeStatus = bool;
    }

    public final Boolean getCheckBoxStatus() {
        return this.checkBoxStatus;
    }

    public final void setCheckBoxStatus(Boolean bool) {
        this.checkBoxStatus = bool;
    }

    /* compiled from: ExamRegisterFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment;", "id", "", "category", "feeStatus", "", "checkBoxStatus", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamRegisterFragment newInstance(String id, String category, boolean feeStatus, boolean checkBoxStatus) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(category, "category");
            ExamRegisterFragment examRegisterFragment = new ExamRegisterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString("cat", category);
            bundle.putBoolean("flag", feeStatus);
            bundle.putBoolean("cell", checkBoxStatus);
            examRegisterFragment.setArguments(bundle);
            return examRegisterFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.category = arguments.getString("cat");
            this.feeStatus = Boolean.valueOf(arguments.getBoolean("flag"));
            this.checkBoxStatus = Boolean.valueOf(arguments.getBoolean("cell"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamRegistrationBinding.inflate(inflater, container, false);
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
        if (fragmentExamRegistrationBinding != null) {
            fragmentExamRegistrationBinding.setExamRegisterViewModel(getExamRegisterViewModel());
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = get_binding();
        if (fragmentExamRegistrationBinding2 != null) {
            fragmentExamRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = get_binding();
        if (fragmentExamRegistrationBinding3 != null) {
            return fragmentExamRegistrationBinding3.getRoot();
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
        TextView textView2;
        TextView textView3;
        CheckBox checkBox;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Exam Registration");
        }
        hideBaseView();
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
        RecyclerView recyclerView = fragmentExamRegistrationBinding != null ? fragmentExamRegistrationBinding.rvExamSubject : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        ExamRegisterViewModel examRegisterViewModel = getExamRegisterViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        examRegisterViewModel.getExamDetails(str);
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = get_binding();
        if (fragmentExamRegistrationBinding2 != null && (checkBox = fragmentExamRegistrationBinding2.selectAllCheckBox) != null) {
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRegisterFragment.setUp$lambda$1(ExamRegisterFragment.this, view);
                }
            });
        }
        final HashMap hashMap = new HashMap();
        new HashMap();
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = get_binding();
        if (fragmentExamRegistrationBinding3 != null && (textView3 = fragmentExamRegistrationBinding3.payNowBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRegisterFragment.setUp$lambda$2(ExamRegisterFragment.this, hashMap, view);
                }
            });
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = get_binding();
        if (fragmentExamRegistrationBinding4 != null && (textView2 = fragmentExamRegistrationBinding4.payLaterBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRegisterFragment.setUp$lambda$3(ExamRegisterFragment.this, hashMap, view);
                }
            });
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding5 = get_binding();
        if (fragmentExamRegistrationBinding5 == null || (textView = fragmentExamRegistrationBinding5.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamRegisterFragment.setUp$lambda$4(ExamRegisterFragment.this, hashMap, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ExamRegisterFragment this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.flag) {
            this$0.flag = false;
            this$0.getAdapter().selectAll(this$0.flag);
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding = this$0.get_binding();
            TextView textView2 = fragmentExamRegistrationBinding != null ? fragmentExamRegistrationBinding.registerBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
            TextView textView3 = fragmentExamRegistrationBinding2 != null ? fragmentExamRegistrationBinding2.payLaterBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = this$0.get_binding();
            TextView textView4 = fragmentExamRegistrationBinding3 != null ? fragmentExamRegistrationBinding3.payNowBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = this$0.get_binding();
            textView = fragmentExamRegistrationBinding4 != null ? fragmentExamRegistrationBinding4.tvHostelTotal : null;
            if (textView == null) {
                return;
            }
            textView.setText(IdManager.DEFAULT_VERSION_NAME);
            return;
        }
        this$0.flag = true;
        this$0.getAdapter().selectAll(this$0.flag);
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding5 = this$0.get_binding();
        TextView textView5 = fragmentExamRegistrationBinding5 != null ? fragmentExamRegistrationBinding5.registerBtn : null;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding6 = this$0.get_binding();
        TextView textView6 = fragmentExamRegistrationBinding6 != null ? fragmentExamRegistrationBinding6.payLaterBtn : null;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding7 = this$0.get_binding();
        TextView textView7 = fragmentExamRegistrationBinding7 != null ? fragmentExamRegistrationBinding7.payNowBtn : null;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding8 = this$0.get_binding();
        textView = fragmentExamRegistrationBinding8 != null ? fragmentExamRegistrationBinding8.tvHostelTotal : null;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(this$0.totalSel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ExamRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamCourse> items = this$0.getAdapter().getItems();
        examFeeReceipt.clear();
        HashMap hashMap = examFeeReceipt;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        hashMap.put("id", str);
        String str2 = this$0.admissionNo;
        Intrinsics.checkNotNull(str2);
        hashMap.put("admission_no", str2);
        String str3 = this$0.batchId;
        Intrinsics.checkNotNull(str3);
        hashMap.put("batch_id", str3);
        hashMap.put("Payment", "1");
        this$0.selected.size();
        System.out.println(this$0.selected);
        System.out.println(items);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).is_selected());
            if (items.get(i).is_selected()) {
                System.out.println();
                hashMap.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        int size2 = this$0.additionalFees.size();
        for (int i2 = 0; i2 < size2; i2++) {
            hashMap.put("fixedHeadGrpId[" + this$0.additionalFees.get(i2).getFixedHeadGrpId() + "]", this$0.additionalFees.get(i2).getFixedHeadGrpId());
        }
        this$0.getExamRegisterViewModel().getExamPay(hashMap);
        this$0.listenPayResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ExamRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamCourse> items = this$0.getAdapter().getItems();
        HashMap hashMap = examFeeReceipt;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        hashMap.put("id", str);
        String str2 = this$0.admissionNo;
        Intrinsics.checkNotNull(str2);
        hashMap.put("admission_no", str2);
        String str3 = this$0.batchId;
        Intrinsics.checkNotNull(str3);
        hashMap.put("batch_id", str3);
        hashMap.put("PayLater", "1");
        this$0.selected.size();
        System.out.println(this$0.selected);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                hashMap.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        System.out.println(examFeeReceipt);
        this$0.getExamRegisterViewModel().getScStPay(hashMap);
        this$0.listenScStPayResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ExamRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamCourse> items = this$0.getAdapter().getItems();
        examFeeReceipt.clear();
        HashMap hashMap = examFeeReceipt;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        hashMap.put("id", str);
        String str2 = this$0.admissionNo;
        Intrinsics.checkNotNull(str2);
        hashMap.put("admission_no", str2);
        String str3 = this$0.batchId;
        Intrinsics.checkNotNull(str3);
        hashMap.put("batch_id", str3);
        hashMap.put("RegisterExam", "1");
        this$0.selected.size();
        System.out.println(this$0.selected);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                hashMap.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        int size2 = this$0.additionalFees.size();
        for (int i2 = 0; i2 < size2; i2++) {
            hashMap.put("fixedHeadGrpId[" + this$0.additionalFees.get(i2).getFixedHeadGrpId() + "]", this$0.additionalFees.get(i2).getFixedHeadGrpId());
        }
        this$0.getExamRegisterViewModel().getPioPay(hashMap);
        this$0.listenPioPayResponse();
    }

    private final void listenResponse() {
        getExamRegisterViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegisterFragment.listenResponse$lambda$6(ExamRegisterFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(ExamRegisterFragment this$0, Resource resource) {
        RecyclerView rvExamSubject;
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding = this$0.get_binding();
            if (fragmentExamRegistrationBinding == null || (recyclerView = fragmentExamRegistrationBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamCourseResponse examCourseResponse = (ExamCourseResponse) resource.getData();
        if (examCourseResponse != null) {
            this$0.showBaseView();
            if (examCourseResponse.getLogin()) {
                this$0.list = examCourseResponse.getCourse();
                this$0.batchId = examCourseResponse.getBatch_id();
                this$0.admissionNo = examCourseResponse.getAdmission_no();
                this$0.getAdapter().addItems(examCourseResponse.getCourse(), this$0.getPreference().getBaseUrl(), examCourseResponse.getCheck_box_status());
                this$0.feeStatus = Boolean.valueOf(examCourseResponse.getFee_status());
                this$0.checkBoxStatus = Boolean.valueOf(examCourseResponse.getCheck_box_status());
                this$0.additionalFees = examCourseResponse.getFixedHeadGroup();
                int size = examCourseResponse.getCourse().size();
                double d = 0.0d;
                double d2 = 0.0d;
                for (int i2 = 0; i2 < size; i2++) {
                    d2 += Double.parseDouble(examCourseResponse.getCourse().get(i2).getAmount());
                }
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
                TextView textView = fragmentExamRegistrationBinding2 != null ? fragmentExamRegistrationBinding2.tvHostelTotal : null;
                if (textView != null) {
                    textView.setText(String.valueOf(d2));
                }
                this$0.total = d2;
                this$0.totalSel = d2;
                this$0.tot = d2;
                if (d2 > 0.0d) {
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = this$0.get_binding();
                    TextView textView2 = fragmentExamRegistrationBinding3 != null ? fragmentExamRegistrationBinding3.payNowBtn : null;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                } else {
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = this$0.get_binding();
                    TextView textView3 = fragmentExamRegistrationBinding4 != null ? fragmentExamRegistrationBinding4.payNowBtn : null;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                }
                int size2 = examCourseResponse.getFixedHeadGroup().size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d += Double.parseDouble(examCourseResponse.getFixedHeadGroup().get(i3).getAmount());
                }
                this$0.additionalFee = d;
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding5 = this$0.get_binding();
                TextView textView4 = fragmentExamRegistrationBinding5 != null ? fragmentExamRegistrationBinding5.tvHostelTotal : null;
                if (textView4 != null) {
                    textView4.setText(String.valueOf(d2 + d));
                }
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding6 = this$0.get_binding();
                TextView textView5 = fragmentExamRegistrationBinding6 != null ? fragmentExamRegistrationBinding6.tvAdditionalFees : null;
                if (textView5 != null) {
                    textView5.setText(String.valueOf(d));
                }
                if (Intrinsics.areEqual((Object) this$0.feeStatus, (Object) false)) {
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding7 = this$0.get_binding();
                    LinearLayout linearLayout2 = fragmentExamRegistrationBinding7 != null ? fragmentExamRegistrationBinding7.payLyt : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding8 = this$0.get_binding();
                    LinearLayout linearLayout3 = fragmentExamRegistrationBinding8 != null ? fragmentExamRegistrationBinding8.registerLyt : null;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                } else {
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding9 = this$0.get_binding();
                    LinearLayout linearLayout4 = fragmentExamRegistrationBinding9 != null ? fragmentExamRegistrationBinding9.payLyt : null;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(0);
                    }
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding10 = this$0.get_binding();
                    LinearLayout linearLayout5 = fragmentExamRegistrationBinding10 != null ? fragmentExamRegistrationBinding10.registerLyt : null;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(8);
                    }
                }
                if (Intrinsics.areEqual((Object) this$0.checkBoxStatus, (Object) false)) {
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding11 = this$0.get_binding();
                    linearLayout = fragmentExamRegistrationBinding11 != null ? fragmentExamRegistrationBinding11.selectLyt : null;
                    if (linearLayout == null) {
                        return;
                    }
                    linearLayout.setVisibility(8);
                    return;
                }
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding12 = this$0.get_binding();
                linearLayout = fragmentExamRegistrationBinding12 != null ? fragmentExamRegistrationBinding12.selectLyt : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding13 = this$0.get_binding();
            if (fragmentExamRegistrationBinding13 == null || (rvExamSubject = fragmentExamRegistrationBinding13.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenPayResponse() {
        getExamRegisterViewModel().getPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegisterFragment.listenPayResponse$lambda$8(ExamRegisterFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPayResponse$lambda$8(ExamRegisterFragment this$0, Resource resource) {
        double parseDouble;
        double parseDouble2;
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
        TextView textView;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding = this$0.get_binding();
            if (fragmentExamRegistrationBinding == null || (recyclerView = fragmentExamRegistrationBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamPayResponse examPayResponse = (ExamPayResponse) resource.getData();
        if (examPayResponse != null) {
            this$0.showBaseView();
            if (examPayResponse.is_registered()) {
                parseDouble = 0.0d;
                parseDouble2 = 0.0d;
            } else {
                parseDouble = Double.parseDouble(examPayResponse.getExam().get(0).getFineAmount());
                parseDouble2 = Double.parseDouble(examPayResponse.getExam().get(0).getFixed_amount());
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
            double parseDouble3 = Double.parseDouble(String.valueOf((fragmentExamRegistrationBinding2 == null || (textView = fragmentExamRegistrationBinding2.tvHostelTotal) == null) ? null : textView.getText()));
            this$0.tot = parseDouble3;
            double d = parseDouble3 + parseDouble + parseDouble2;
            String url = examPayResponse.getUrl();
            if (examPayResponse.getLogin() && !Intrinsics.areEqual(examPayResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(parseDouble3);
                System.out.println(parseDouble);
                System.out.println(parseDouble2);
                System.out.println(d);
                System.out.println((Object) url);
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                ExamSubjectDetailDialog newInstance = ExamSubjectDetailDialog.INSTANCE.newInstance(String.valueOf(parseDouble3), String.valueOf(parseDouble2), String.valueOf(parseDouble), String.valueOf(d), url);
                newInstance.setCallBack2(this$0);
                newInstance.show(childFragmentManager, (String) null);
                return;
            }
            if (examPayResponse.getLogin() && Intrinsics.areEqual(examPayResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d);
                System.out.println(parseDouble);
                System.out.println(parseDouble2);
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = this$0.get_binding();
                if (fragmentExamRegistrationBinding3 == null || (rvExamSubject2 = fragmentExamRegistrationBinding3.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                ToastExtKt.showErrorToast(rvExamSubject2, "Last Date for registration is over.");
                return;
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = this$0.get_binding();
            if (fragmentExamRegistrationBinding4 == null || (rvExamSubject = fragmentExamRegistrationBinding4.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenPioPayResponse() {
        getExamRegisterViewModel().getPioPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegisterFragment.listenPioPayResponse$lambda$10(ExamRegisterFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPioPayResponse$lambda$10(ExamRegisterFragment this$0, Resource resource) {
        double parseDouble;
        double d;
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
        RecyclerView rvExamSubject3;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding = this$0.get_binding();
            if (fragmentExamRegistrationBinding == null || (recyclerView = fragmentExamRegistrationBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamMessageResponse examMessageResponse = (ExamMessageResponse) resource.getData();
        if (examMessageResponse != null) {
            this$0.showBaseView();
            if (examMessageResponse.is_registered()) {
                d = 0.0d;
                parseDouble = 0.0d;
            } else {
                double parseDouble2 = Double.parseDouble(examMessageResponse.getExam().get(0).getFineAmount());
                parseDouble = Double.parseDouble(examMessageResponse.getExam().get(0).getFixed_amount());
                d = parseDouble2;
            }
            double d2 = this$0.tot;
            double d3 = d2 + d + parseDouble;
            if (examMessageResponse.getLogin() && !Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled") && examMessageResponse.getSuccess()) {
                System.out.println(d2);
                System.out.println(d);
                System.out.println(parseDouble);
                System.out.println(d3);
                System.out.println((Object) "");
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
                if (fragmentExamRegistrationBinding2 != null && (rvExamSubject3 = fragmentExamRegistrationBinding2.rvExamSubject) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvExamSubject3, "rvExamSubject");
                    ToastExtKt.showSuccessToast(rvExamSubject3, examMessageResponse.getMessage());
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    mainCallBackListener.showExamRegFragment(str);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d3);
                System.out.println(d);
                System.out.println(parseDouble);
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = this$0.get_binding();
                if (fragmentExamRegistrationBinding3 == null || (rvExamSubject2 = fragmentExamRegistrationBinding3.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                ToastExtKt.showErrorToast(rvExamSubject2, "Last Date for registration is over.");
                return;
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = this$0.get_binding();
            if (fragmentExamRegistrationBinding4 == null || (rvExamSubject = fragmentExamRegistrationBinding4.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenScStPayResponse() {
        getExamRegisterViewModel().getScStPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegisterFragment.listenScStPayResponse$lambda$12(ExamRegisterFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenScStPayResponse$lambda$12(ExamRegisterFragment this$0, Resource resource) {
        double parseDouble;
        double d;
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
        RecyclerView rvExamSubject3;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding = this$0.get_binding();
            if (fragmentExamRegistrationBinding == null || (recyclerView = fragmentExamRegistrationBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamMessageResponse examMessageResponse = (ExamMessageResponse) resource.getData();
        if (examMessageResponse != null) {
            this$0.showBaseView();
            if (examMessageResponse.is_registered()) {
                d = 0.0d;
                parseDouble = 0.0d;
            } else {
                double parseDouble2 = Double.parseDouble(examMessageResponse.getExam().get(0).getFineAmount());
                parseDouble = Double.parseDouble(examMessageResponse.getExam().get(0).getFixed_amount());
                d = parseDouble2;
            }
            double d2 = this$0.tot;
            double d3 = d2 + d + parseDouble;
            if (examMessageResponse.getLogin() && !Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled") && examMessageResponse.getSuccess()) {
                System.out.println(d2);
                System.out.println(d);
                System.out.println(parseDouble);
                System.out.println(d3);
                System.out.println((Object) "");
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
                if (fragmentExamRegistrationBinding2 == null || (rvExamSubject3 = fragmentExamRegistrationBinding2.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject3, "rvExamSubject");
                ToastExtKt.showSuccessToast(rvExamSubject3, examMessageResponse.getMessage());
                return;
            }
            if (Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d3);
                System.out.println(d);
                System.out.println(parseDouble);
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = this$0.get_binding();
                if (fragmentExamRegistrationBinding3 == null || (rvExamSubject2 = fragmentExamRegistrationBinding3.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                ToastExtKt.showErrorToast(rvExamSubject2, "Last Date for registration is over.");
                return;
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = this$0.get_binding();
            if (fragmentExamRegistrationBinding4 == null || (rvExamSubject = fragmentExamRegistrationBinding4.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
        if (fragmentExamRegistrationBinding == null || (recyclerView = fragmentExamRegistrationBinding.rvExamSubject) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
        if (fragmentExamRegistrationBinding == null || (recyclerView = fragmentExamRegistrationBinding.rvExamSubject) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        boolean z;
        boolean z2;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        total.size();
        this.tot = 0.0d;
        new ArrayList();
        ArrayList<ExamCourse> items = getAdapter().getItems();
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                this.tot += Double.parseDouble(items.get(i).getAmount());
            }
        }
        this.selected = sel;
        System.out.println(sel);
        this.total = this.tot;
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
        TextView textView = fragmentExamRegistrationBinding != null ? fragmentExamRegistrationBinding.tvHostelTotal : null;
        if (textView != null) {
            textView.setText(String.valueOf(this.tot + this.additionalFee));
        }
        int size2 = items.size() - 1;
        if (size2 >= 0) {
            int i2 = 0;
            z = false;
            z2 = true;
            while (true) {
                if (items.get(i2).is_selected()) {
                    z = true;
                } else {
                    z2 = false;
                }
                if (i2 == size2) {
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            z = false;
            z2 = true;
        }
        if (this.tot <= 0.0d) {
            if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sbce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null)) {
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = get_binding();
                TextView textView2 = fragmentExamRegistrationBinding2 != null ? fragmentExamRegistrationBinding2.payNowBtn : null;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
        } else {
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = get_binding();
            TextView textView3 = fragmentExamRegistrationBinding3 != null ? fragmentExamRegistrationBinding3.payNowBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        }
        if (z) {
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = get_binding();
            TextView textView4 = fragmentExamRegistrationBinding4 != null ? fragmentExamRegistrationBinding4.payNowBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        } else {
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding5 = get_binding();
            TextView textView5 = fragmentExamRegistrationBinding5 != null ? fragmentExamRegistrationBinding5.payNowBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        if (z2) {
            this.flag = true;
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding6 = get_binding();
            checkBox = fragmentExamRegistrationBinding6 != null ? fragmentExamRegistrationBinding6.selectAllCheckBox : null;
            if (checkBox == null) {
                return;
            }
            checkBox.setChecked(true);
            return;
        }
        this.flag = false;
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding7 = get_binding();
        checkBox = fragmentExamRegistrationBinding7 != null ? fragmentExamRegistrationBinding7.selectAllCheckBox : null;
        if (checkBox == null) {
            return;
        }
        checkBox.setChecked(false);
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter.CallBack
    public void updateSelected2(List<String> sel, List<String> total) {
        boolean z;
        TextView textView;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        new ArrayList();
        ArrayList<ExamCourse> items = getAdapter().getItems();
        this.selected = sel;
        int size = items.size() - 1;
        if (size >= 0) {
            int i = 0;
            z = false;
            while (true) {
                if (items.get(i).is_selected()) {
                    z = true;
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
            textView = fragmentExamRegistrationBinding != null ? fragmentExamRegistrationBinding.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = get_binding();
        textView = fragmentExamRegistrationBinding2 != null ? fragmentExamRegistrationBinding2.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
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
}