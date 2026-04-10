package in.etuwa.app.ui.examregistration.examsubjects.register;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.examregister.ExamCourse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamMessage;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
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
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: ExamRegisterFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExamRegisterFragment extends BaseFragment implements ExamRegisterAdapter.CallBack, ExamSubjectDetailDialog.ExamDetailListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamRegistrationBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String admissionNo;
    private String batchId;
    private String category;

    /* JADX INFO: renamed from: examRegisterViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examRegisterViewModel;
    private boolean flag;
    private String id;
    private ArrayList<ExamCourse> list;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private double tot;
    private double total;
    private double totalSel;

    /* JADX INFO: compiled from: ExamRegisterFragment.kt */
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
    public static final ExamRegisterFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
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
                return examRegisterFragment;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ExamRegisterViewModel.class), qualifier, b, null, koinScope);
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

    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    /* JADX INFO: compiled from: ExamRegisterFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/register/ExamRegisterFragment;", "id", "", "category", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamRegisterFragment newInstance(String id, String category) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(category, "category");
            ExamRegisterFragment examRegisterFragment = new ExamRegisterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString("cat", category);
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

    /* JADX WARN: Removed duplicated region for block: B:80:0x0177  */
    @Override // in.etuwa.app.ui.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setUp() {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment.setUp():void");
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
        HashMap map = examFeeReceipt;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        map.put("id", str);
        String str2 = this$0.admissionNo;
        Intrinsics.checkNotNull(str2);
        map.put("admission_no", str2);
        String str3 = this$0.batchId;
        Intrinsics.checkNotNull(str3);
        map.put("batch_id", str3);
        map.put("Payment", "1");
        this$0.selected.size();
        System.out.println(this$0.selected);
        System.out.println(items);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).is_selected());
            if (items.get(i).is_selected()) {
                System.out.println();
                map.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        System.out.println(examFeeReceipt);
        this$0.getExamRegisterViewModel().getExamPay(map);
        this$0.listenPayResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ExamRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamCourse> items = this$0.getAdapter().getItems();
        HashMap map = examFeeReceipt;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        map.put("id", str);
        String str2 = this$0.admissionNo;
        Intrinsics.checkNotNull(str2);
        map.put("admission_no", str2);
        String str3 = this$0.batchId;
        Intrinsics.checkNotNull(str3);
        map.put("batch_id", str3);
        map.put("PayLater", "1");
        this$0.selected.size();
        System.out.println(this$0.selected);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                map.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        System.out.println(examFeeReceipt);
        this$0.getExamRegisterViewModel().getScStPay(map);
        this$0.listenScStPayResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ExamRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamCourse> items = this$0.getAdapter().getItems();
        HashMap map = examFeeReceipt;
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        map.put("id", str);
        String str2 = this$0.admissionNo;
        Intrinsics.checkNotNull(str2);
        map.put("admission_no", str2);
        String str3 = this$0.batchId;
        Intrinsics.checkNotNull(str3);
        map.put("batch_id", str3);
        map.put("RegisterExam", "1");
        this$0.selected.size();
        System.out.println(this$0.selected);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                map.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        this$0.getExamRegisterViewModel().getPioPay(map);
        this$0.listenPioPayResponse();
    }

    private final void listenResponse() {
        getExamRegisterViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamRegisterFragment.listenResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(ExamRegisterFragment this$0, Resource resource) {
        RecyclerView rvExamSubject;
        TextView textView;
        Double doubleOrNull;
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
                this$0.getAdapter().addItems(examCourseResponse.getCourse(), this$0.getPreference().getBaseUrl());
                int size = examCourseResponse.getCourse().size();
                double dDoubleValue = 0.0d;
                for (int i2 = 0; i2 < size; i2++) {
                    String amount = examCourseResponse.getCourse().get(i2).getAmount();
                    dDoubleValue += (amount == null || (doubleOrNull = StringsKt.toDoubleOrNull(amount)) == null) ? 0.0d : doubleOrNull.doubleValue();
                }
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
                TextView textView2 = fragmentExamRegistrationBinding2 != null ? fragmentExamRegistrationBinding2.tvHostelTotal : null;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(dDoubleValue));
                }
                this$0.total = dDoubleValue;
                this$0.totalSel = dDoubleValue;
                this$0.tot = dDoubleValue;
                if (dDoubleValue > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    FragmentExamRegistrationBinding fragmentExamRegistrationBinding3 = this$0.get_binding();
                    textView = fragmentExamRegistrationBinding3 != null ? fragmentExamRegistrationBinding3.payNowBtn : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
                FragmentExamRegistrationBinding fragmentExamRegistrationBinding4 = this$0.get_binding();
                textView = fragmentExamRegistrationBinding4 != null ? fragmentExamRegistrationBinding4.payNowBtn : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding5 = this$0.get_binding();
            if (fragmentExamRegistrationBinding5 == null || (rvExamSubject = fragmentExamRegistrationBinding5.rvExamSubject) == null) {
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
                ExamRegisterFragment.listenPayResponse$lambda$8(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPayResponse$lambda$8(ExamRegisterFragment this$0, Resource resource) {
        double dDoubleValue;
        double dDoubleValue2;
        Double doubleOrNull;
        Double doubleOrNull2;
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
        TextView textView;
        CharSequence text;
        String string;
        Double doubleOrNull3;
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
            boolean zIs_registered = examPayResponse.is_registered();
            double dDoubleValue3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (zIs_registered) {
                dDoubleValue2 = 0.0d;
                dDoubleValue = 0.0d;
            } else {
                String fineAmount = examPayResponse.getExam().get(0).getFineAmount();
                dDoubleValue = (fineAmount == null || (doubleOrNull2 = StringsKt.toDoubleOrNull(fineAmount)) == null) ? 0.0d : doubleOrNull2.doubleValue();
                String fixed_amount = examPayResponse.getExam().get(0).getFixed_amount();
                dDoubleValue2 = (fixed_amount == null || (doubleOrNull = StringsKt.toDoubleOrNull(fixed_amount)) == null) ? 0.0d : doubleOrNull.doubleValue();
            }
            FragmentExamRegistrationBinding fragmentExamRegistrationBinding2 = this$0.get_binding();
            if (fragmentExamRegistrationBinding2 != null && (textView = fragmentExamRegistrationBinding2.tvHostelTotal) != null && (text = textView.getText()) != null && (string = text.toString()) != null && (doubleOrNull3 = StringsKt.toDoubleOrNull(string)) != null) {
                dDoubleValue3 = doubleOrNull3.doubleValue();
            }
            this$0.tot = dDoubleValue3;
            double d = dDoubleValue3 + dDoubleValue + dDoubleValue2;
            String url = examPayResponse.getUrl();
            if (examPayResponse.getLogin() && !Intrinsics.areEqual(examPayResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(dDoubleValue3);
                System.out.println(dDoubleValue);
                System.out.println(dDoubleValue2);
                System.out.println(d);
                System.out.println((Object) url);
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                ExamSubjectDetailDialog examSubjectDetailDialogNewInstance = ExamSubjectDetailDialog.INSTANCE.newInstance(String.valueOf(dDoubleValue3), String.valueOf(dDoubleValue2), String.valueOf(dDoubleValue), String.valueOf(d), url);
                examSubjectDetailDialogNewInstance.setCallBack2(this$0);
                examSubjectDetailDialogNewInstance.show(childFragmentManager, (String) null);
                return;
            }
            if (examPayResponse.getLogin() && Intrinsics.areEqual(examPayResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d);
                System.out.println(dDoubleValue);
                System.out.println(dDoubleValue2);
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
                ExamRegisterFragment.listenPioPayResponse$lambda$10(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPioPayResponse$lambda$10(ExamRegisterFragment this$0, Resource resource) {
        double d;
        String fixed_amount;
        Double doubleOrNull;
        String fineAmount;
        Double doubleOrNull2;
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
            boolean zIs_registered = examMessageResponse.is_registered();
            double dDoubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (zIs_registered) {
                d = 0.0d;
            } else {
                ExamMessage examMessage = (ExamMessage) CollectionsKt.firstOrNull((List) examMessageResponse.getExam());
                double dDoubleValue2 = (examMessage == null || (fineAmount = examMessage.getFineAmount()) == null || (doubleOrNull2 = StringsKt.toDoubleOrNull(fineAmount)) == null) ? 0.0d : doubleOrNull2.doubleValue();
                if (examMessage != null && (fixed_amount = examMessage.getFixed_amount()) != null && (doubleOrNull = StringsKt.toDoubleOrNull(fixed_amount)) != null) {
                    dDoubleValue = doubleOrNull.doubleValue();
                }
                double d2 = dDoubleValue;
                dDoubleValue = dDoubleValue2;
                d = d2;
            }
            double d3 = this$0.tot;
            double d4 = d3 + dDoubleValue + d;
            if (examMessageResponse.getLogin() && !Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled") && examMessageResponse.getSuccess()) {
                System.out.println(d3);
                System.out.println(dDoubleValue);
                System.out.println(d);
                System.out.println(d4);
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
                System.out.println(d4);
                System.out.println(dDoubleValue);
                System.out.println(d);
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
                ExamRegisterFragment.listenScStPayResponse$lambda$12(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenScStPayResponse$lambda$12(ExamRegisterFragment this$0, Resource resource) {
        double d;
        String fixed_amount;
        Double doubleOrNull;
        String fineAmount;
        Double doubleOrNull2;
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
            boolean zIs_registered = examMessageResponse.is_registered();
            double dDoubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (zIs_registered) {
                d = 0.0d;
            } else {
                ExamMessage examMessage = (ExamMessage) CollectionsKt.firstOrNull((List) examMessageResponse.getExam());
                double dDoubleValue2 = (examMessage == null || (fineAmount = examMessage.getFineAmount()) == null || (doubleOrNull2 = StringsKt.toDoubleOrNull(fineAmount)) == null) ? 0.0d : doubleOrNull2.doubleValue();
                if (examMessage != null && (fixed_amount = examMessage.getFixed_amount()) != null && (doubleOrNull = StringsKt.toDoubleOrNull(fixed_amount)) != null) {
                    dDoubleValue = doubleOrNull.doubleValue();
                }
                double d2 = dDoubleValue;
                dDoubleValue = dDoubleValue2;
                d = d2;
            }
            double d3 = this$0.tot;
            double d4 = d3 + dDoubleValue + d;
            if (examMessageResponse.getLogin() && !Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled") && examMessageResponse.getSuccess()) {
                System.out.println(d3);
                System.out.println(dDoubleValue);
                System.out.println(d);
                System.out.println(d4);
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
                System.out.println(d4);
                System.out.println(dDoubleValue);
                System.out.println(d);
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
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        total.size();
        this.tot = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        new ArrayList();
        ArrayList<ExamCourse> items = getAdapter().getItems();
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                double d = this.tot;
                String amount = items.get(i).getAmount();
                this.tot = d + ((amount == null || (doubleOrNull = StringsKt.toDoubleOrNull(amount)) == null) ? 0.0d : doubleOrNull.doubleValue());
            }
        }
        this.selected = sel;
        System.out.println(sel);
        this.total = this.tot;
        FragmentExamRegistrationBinding fragmentExamRegistrationBinding = get_binding();
        TextView textView = fragmentExamRegistrationBinding != null ? fragmentExamRegistrationBinding.tvHostelTotal : null;
        if (textView != null) {
            textView.setText(String.valueOf(this.tot));
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
        if (this.tot <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
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