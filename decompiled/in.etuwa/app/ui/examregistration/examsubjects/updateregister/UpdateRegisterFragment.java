package in.etuwa.app.ui.examregistration.examsubjects.updateregister;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
import in.etuwa.app.data.model.examregister.ExamUpdate;
import in.etuwa.app.data.model.examregister.ExamUpdateResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentExamUpdateBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterAdapter;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

/* JADX INFO: compiled from: UpdateRegisterFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UpdateRegisterFragment extends BaseFragment implements UpdateRegisterAdapter.CallBack, ExamSubjectDetailDialog.ExamDetailListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamUpdateBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String admissionNo;
    private String batchId;
    private String category;
    private boolean flag;
    private String id;
    private ArrayList<ExamUpdate> list;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private double tot;
    private double total;

    /* JADX INFO: renamed from: updateRegisterViewModel$delegate, reason: from kotlin metadata */
    private final Lazy updateRegisterViewModel;

    /* JADX INFO: compiled from: UpdateRegisterFragment.kt */
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
    public static final UpdateRegisterFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public UpdateRegisterFragment() {
        final UpdateRegisterFragment updateRegisterFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return updateRegisterFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(updateRegisterFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.updateRegisterViewModel = FragmentViewModelLazyKt.createViewModelLazy(updateRegisterFragment, Reflection.getOrCreateKotlinClass(UpdateRegisterViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(UpdateRegisterViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final UpdateRegisterFragment updateRegisterFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UpdateRegisterAdapter>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final UpdateRegisterAdapter invoke() {
                ComponentCallbacks componentCallbacks = updateRegisterFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UpdateRegisterAdapter.class), b2, b3);
            }
        });
        this.selected = new ArrayList();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = updateRegisterFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.list = new ArrayList<>();
    }

    private final UpdateRegisterViewModel getUpdateRegisterViewModel() {
        return (UpdateRegisterViewModel) this.updateRegisterViewModel.getValue();
    }

    private final UpdateRegisterAdapter getAdapter() {
        return (UpdateRegisterAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentExamUpdateBinding get_binding() {
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

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final double getTot() {
        return this.tot;
    }

    public final void setTot(double d) {
        this.tot = d;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    /* JADX INFO: compiled from: UpdateRegisterFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterFragment;", "id", "", "category", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UpdateRegisterFragment newInstance(String id, String category) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(category, "category");
            UpdateRegisterFragment updateRegisterFragment = new UpdateRegisterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString("cat", category);
            updateRegisterFragment.setArguments(bundle);
            return updateRegisterFragment;
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
        this._binding = FragmentExamUpdateBinding.inflate(inflater, container, false);
        FragmentExamUpdateBinding fragmentExamUpdateBinding = get_binding();
        if (fragmentExamUpdateBinding != null) {
            fragmentExamUpdateBinding.setUpdateRegisterViewModel(getUpdateRegisterViewModel());
        }
        FragmentExamUpdateBinding fragmentExamUpdateBinding2 = get_binding();
        if (fragmentExamUpdateBinding2 != null) {
            fragmentExamUpdateBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamUpdateBinding fragmentExamUpdateBinding3 = get_binding();
        if (fragmentExamUpdateBinding3 != null) {
            return fragmentExamUpdateBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x016a  */
    @Override // in.etuwa.app.ui.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setUp() {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment.setUp():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(UpdateRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamUpdate> items = this$0.getAdapter().getItems();
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
        int size = items.size();
        System.out.println(this$0.selected);
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                map.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        System.out.println(examFeeReceipt);
        this$0.getUpdateRegisterViewModel().getExamPay(map);
        this$0.listenPayResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(UpdateRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamUpdate> items = this$0.getAdapter().getItems();
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
        int size = items.size();
        System.out.println(this$0.selected);
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                map.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        System.out.println(examFeeReceipt);
        this$0.getUpdateRegisterViewModel().getScStPay(map);
        this$0.listenScStPayResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(UpdateRegisterFragment this$0, HashMap examFeeReceipt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(examFeeReceipt, "$examFeeReceipt");
        new ArrayList();
        ArrayList<ExamUpdate> items = this$0.getAdapter().getItems();
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
        int size = items.size();
        System.out.println(this$0.selected);
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                map.put("feehead_id[" + items.get(i).getFeehead_id() + "]", items.get(i).getFeehead_id());
            }
        }
        System.out.println(examFeeReceipt);
        this$0.getUpdateRegisterViewModel().getPioPay(map);
        this$0.listenPioPayResponse();
    }

    private final void listenResponse() {
        getUpdateRegisterViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpdateRegisterFragment.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(UpdateRegisterFragment this$0, Resource resource) {
        RecyclerView rvExamSubject;
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
            FragmentExamUpdateBinding fragmentExamUpdateBinding = this$0.get_binding();
            if (fragmentExamUpdateBinding == null || (recyclerView = fragmentExamUpdateBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamUpdateResponse examUpdateResponse = (ExamUpdateResponse) resource.getData();
        if (examUpdateResponse != null) {
            this$0.showBaseView();
            if (examUpdateResponse.getLogin()) {
                this$0.batchId = examUpdateResponse.getBatch_id();
                this$0.admissionNo = examUpdateResponse.getAdmission_no();
                this$0.list = examUpdateResponse.getExam();
                this$0.getAdapter().addItems(examUpdateResponse.getExam());
                int size = examUpdateResponse.getExam().size();
                double d = 0.0d;
                for (int i2 = 0; i2 < size; i2++) {
                    String lowerCase = examUpdateResponse.getExam().get(i2).getMsg().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (!Intrinsics.areEqual(lowerCase, "registration submitted to college")) {
                        d += Double.parseDouble(examUpdateResponse.getExam().get(i2).getAmount());
                    }
                }
                FragmentExamUpdateBinding fragmentExamUpdateBinding2 = this$0.get_binding();
                TextView textView = fragmentExamUpdateBinding2 != null ? fragmentExamUpdateBinding2.tvHostelTotal : null;
                if (textView != null) {
                    textView.setText(String.valueOf(d));
                }
                this$0.total = d;
                this$0.tot = d;
                if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    FragmentExamUpdateBinding fragmentExamUpdateBinding3 = this$0.get_binding();
                    TextView textView2 = fragmentExamUpdateBinding3 != null ? fragmentExamUpdateBinding3.payNowBtn : null;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                } else {
                    FragmentExamUpdateBinding fragmentExamUpdateBinding4 = this$0.get_binding();
                    TextView textView3 = fragmentExamUpdateBinding4 != null ? fragmentExamUpdateBinding4.payNowBtn : null;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                }
                int size2 = examUpdateResponse.getExam().size() - 1;
                if (size2 >= 0) {
                    int i3 = 0;
                    while (true) {
                        String lowerCase2 = examUpdateResponse.getExam().get(i3).getMsg().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (Intrinsics.areEqual(lowerCase2, "not regsitered")) {
                            this$0.flag = true;
                            System.out.println((Object) "loly");
                        } else {
                            System.out.println((Object) "lol");
                        }
                        if (i3 == size2) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (this$0.flag) {
                    if (this$0.tot == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        FragmentExamUpdateBinding fragmentExamUpdateBinding5 = this$0.get_binding();
                        LinearLayout linearLayout = fragmentExamUpdateBinding5 != null ? fragmentExamUpdateBinding5.payLyt : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        FragmentExamUpdateBinding fragmentExamUpdateBinding6 = this$0.get_binding();
                        LinearLayout linearLayout2 = fragmentExamUpdateBinding6 != null ? fragmentExamUpdateBinding6.registerLyt : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(0);
                        }
                        FragmentExamUpdateBinding fragmentExamUpdateBinding7 = this$0.get_binding();
                        TextView textView4 = fragmentExamUpdateBinding7 != null ? fragmentExamUpdateBinding7.registerBtn : null;
                        if (textView4 == null) {
                            return;
                        }
                        textView4.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding8 = this$0.get_binding();
            if (fragmentExamUpdateBinding8 == null || (rvExamSubject = fragmentExamUpdateBinding8.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenPayResponse() {
        getUpdateRegisterViewModel().getPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpdateRegisterFragment.listenPayResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPayResponse$lambda$7(UpdateRegisterFragment this$0, Resource resource) {
        double d;
        double d2;
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
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
            FragmentExamUpdateBinding fragmentExamUpdateBinding = this$0.get_binding();
            if (fragmentExamUpdateBinding == null || (recyclerView = fragmentExamUpdateBinding.rvExamSubject) == null) {
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
                d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                d2 = 0.0d;
            } else {
                d = Double.parseDouble(examPayResponse.getExam().get(0).getFineAmount());
                d2 = Double.parseDouble(examPayResponse.getExam().get(0).getFixed_amount());
            }
            double d3 = this$0.tot;
            double d4 = d3 + d + d2;
            String url = examPayResponse.getUrl();
            if (examPayResponse.getLogin() && !Intrinsics.areEqual(examPayResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d3);
                System.out.println(d);
                System.out.println(d2);
                System.out.println(d4);
                System.out.println((Object) url);
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                ExamSubjectDetailDialog examSubjectDetailDialogNewInstance = ExamSubjectDetailDialog.INSTANCE.newInstance(String.valueOf(d3), String.valueOf(d2), String.valueOf(d), String.valueOf(d4), url);
                examSubjectDetailDialogNewInstance.setCallBackUpdate(this$0);
                examSubjectDetailDialogNewInstance.show(childFragmentManager, (String) null);
                return;
            }
            if (examPayResponse.getLogin() && Intrinsics.areEqual(examPayResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d4);
                System.out.println(d);
                System.out.println(d2);
                FragmentExamUpdateBinding fragmentExamUpdateBinding2 = this$0.get_binding();
                if (fragmentExamUpdateBinding2 == null || (rvExamSubject2 = fragmentExamUpdateBinding2.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                ToastExtKt.showErrorToast(rvExamSubject2, "Last Date for registration is over.");
                return;
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding3 = this$0.get_binding();
            if (fragmentExamUpdateBinding3 == null || (rvExamSubject = fragmentExamUpdateBinding3.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenPioPayResponse() {
        getUpdateRegisterViewModel().getPioPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpdateRegisterFragment.listenPioPayResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPioPayResponse$lambda$9(UpdateRegisterFragment this$0, Resource resource) {
        double d;
        double d2;
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
            FragmentExamUpdateBinding fragmentExamUpdateBinding = this$0.get_binding();
            if (fragmentExamUpdateBinding == null || (recyclerView = fragmentExamUpdateBinding.rvExamSubject) == null) {
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
                d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                d = 0.0d;
            } else {
                double d3 = Double.parseDouble(examMessageResponse.getExam().get(0).getFineAmount());
                d = Double.parseDouble(examMessageResponse.getExam().get(0).getFixed_amount());
                d2 = d3;
            }
            double d4 = this$0.tot;
            double d5 = d4 + d2 + d;
            if (examMessageResponse.getLogin() && !Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled") && examMessageResponse.getSuccess()) {
                System.out.println(d4);
                System.out.println(d2);
                System.out.println(d);
                System.out.println(d5);
                System.out.println((Object) "");
                FragmentExamUpdateBinding fragmentExamUpdateBinding2 = this$0.get_binding();
                if (fragmentExamUpdateBinding2 == null || (rvExamSubject3 = fragmentExamUpdateBinding2.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject3, "rvExamSubject");
                ToastExtKt.showSuccessToast(rvExamSubject3, examMessageResponse.getMessage());
                return;
            }
            if (Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d5);
                System.out.println(d2);
                System.out.println(d);
                FragmentExamUpdateBinding fragmentExamUpdateBinding3 = this$0.get_binding();
                if (fragmentExamUpdateBinding3 == null || (rvExamSubject2 = fragmentExamUpdateBinding3.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                ToastExtKt.showErrorToast(rvExamSubject2, "Last Date for registration is over.");
                return;
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding4 = this$0.get_binding();
            if (fragmentExamUpdateBinding4 == null || (rvExamSubject = fragmentExamUpdateBinding4.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenScStPayResponse() {
        getUpdateRegisterViewModel().getScStPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpdateRegisterFragment.listenScStPayResponse$lambda$11(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenScStPayResponse$lambda$11(UpdateRegisterFragment this$0, Resource resource) {
        double d;
        double d2;
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
            FragmentExamUpdateBinding fragmentExamUpdateBinding = this$0.get_binding();
            if (fragmentExamUpdateBinding == null || (recyclerView = fragmentExamUpdateBinding.rvExamSubject) == null) {
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
                d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                d = 0.0d;
            } else {
                double d3 = Double.parseDouble(examMessageResponse.getExam().get(0).getFineAmount());
                d = Double.parseDouble(examMessageResponse.getExam().get(0).getFixed_amount());
                d2 = d3;
            }
            double d4 = this$0.tot;
            double d5 = d4 + d2 + d;
            if (examMessageResponse.getLogin() && !Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled") && examMessageResponse.getSuccess()) {
                System.out.println(d4);
                System.out.println(d2);
                System.out.println(d);
                System.out.println(d5);
                System.out.println((Object) "");
                FragmentExamUpdateBinding fragmentExamUpdateBinding2 = this$0.get_binding();
                if (fragmentExamUpdateBinding2 == null || (rvExamSubject3 = fragmentExamUpdateBinding2.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject3, "rvExamSubject");
                ToastExtKt.showSuccessToast(rvExamSubject3, examMessageResponse.getMessage());
                return;
            }
            if (Intrinsics.areEqual(examMessageResponse.getError(), "Exam Registration is not enabled")) {
                System.out.println(d5);
                System.out.println(d2);
                System.out.println(d);
                FragmentExamUpdateBinding fragmentExamUpdateBinding3 = this$0.get_binding();
                if (fragmentExamUpdateBinding3 == null || (rvExamSubject2 = fragmentExamUpdateBinding3.rvExamSubject) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                ToastExtKt.showErrorToast(rvExamSubject2, "Last Date for registration is over.");
                return;
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding4 = this$0.get_binding();
            if (fragmentExamUpdateBinding4 == null || (rvExamSubject = fragmentExamUpdateBinding4.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentExamUpdateBinding fragmentExamUpdateBinding = get_binding();
        if (fragmentExamUpdateBinding == null || (recyclerView = fragmentExamUpdateBinding.rvExamSubject) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentExamUpdateBinding fragmentExamUpdateBinding = get_binding();
        if (fragmentExamUpdateBinding == null || (recyclerView = fragmentExamUpdateBinding.rvExamSubject) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        boolean z;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        total.size();
        this.tot = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        new ArrayList();
        ArrayList<ExamUpdate> items = getAdapter().getItems();
        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                this.tot += Double.parseDouble(items.get(i).getAmount());
            }
        }
        this.selected = sel;
        System.out.println(sel);
        this.total = this.tot;
        FragmentExamUpdateBinding fragmentExamUpdateBinding = get_binding();
        TextView textView = fragmentExamUpdateBinding != null ? fragmentExamUpdateBinding.tvHostelTotal : null;
        if (textView != null) {
            textView.setText(String.valueOf(this.tot));
        }
        int size2 = items.size() - 1;
        if (size2 >= 0) {
            int i2 = 0;
            z = false;
            while (true) {
                if (items.get(i2).is_selected()) {
                    z = true;
                }
                if (i2 == size2) {
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            z = false;
        }
        if (this.tot <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            FragmentExamUpdateBinding fragmentExamUpdateBinding2 = get_binding();
            TextView textView2 = fragmentExamUpdateBinding2 != null ? fragmentExamUpdateBinding2.payNowBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding3 = get_binding();
            TextView textView3 = fragmentExamUpdateBinding3 != null ? fragmentExamUpdateBinding3.registerBtn : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding4 = get_binding();
            TextView textView4 = fragmentExamUpdateBinding4 != null ? fragmentExamUpdateBinding4.payLaterBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        } else {
            FragmentExamUpdateBinding fragmentExamUpdateBinding5 = get_binding();
            TextView textView5 = fragmentExamUpdateBinding5 != null ? fragmentExamUpdateBinding5.payNowBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding6 = get_binding();
            TextView textView6 = fragmentExamUpdateBinding6 != null ? fragmentExamUpdateBinding6.registerBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding7 = get_binding();
            TextView textView7 = fragmentExamUpdateBinding7 != null ? fragmentExamUpdateBinding7.payLaterBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        }
        if (z) {
            if (this.tot == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                FragmentExamUpdateBinding fragmentExamUpdateBinding8 = get_binding();
                LinearLayout linearLayout2 = fragmentExamUpdateBinding8 != null ? fragmentExamUpdateBinding8.registerLyt : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FragmentExamUpdateBinding fragmentExamUpdateBinding9 = get_binding();
                TextView textView8 = fragmentExamUpdateBinding9 != null ? fragmentExamUpdateBinding9.registerBtn : null;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
                FragmentExamUpdateBinding fragmentExamUpdateBinding10 = get_binding();
                TextView textView9 = fragmentExamUpdateBinding10 != null ? fragmentExamUpdateBinding10.payNowBtn : null;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
                FragmentExamUpdateBinding fragmentExamUpdateBinding11 = get_binding();
                linearLayout = fragmentExamUpdateBinding11 != null ? fragmentExamUpdateBinding11.payLyt : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(8);
                return;
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding12 = get_binding();
            LinearLayout linearLayout3 = fragmentExamUpdateBinding12 != null ? fragmentExamUpdateBinding12.registerLyt : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding13 = get_binding();
            TextView textView10 = fragmentExamUpdateBinding13 != null ? fragmentExamUpdateBinding13.registerBtn : null;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding14 = get_binding();
            TextView textView11 = fragmentExamUpdateBinding14 != null ? fragmentExamUpdateBinding14.payNowBtn : null;
            if (textView11 != null) {
                textView11.setVisibility(0);
            }
            FragmentExamUpdateBinding fragmentExamUpdateBinding15 = get_binding();
            linearLayout = fragmentExamUpdateBinding15 != null ? fragmentExamUpdateBinding15.payLyt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        FragmentExamUpdateBinding fragmentExamUpdateBinding16 = get_binding();
        LinearLayout linearLayout4 = fragmentExamUpdateBinding16 != null ? fragmentExamUpdateBinding16.registerLyt : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        FragmentExamUpdateBinding fragmentExamUpdateBinding17 = get_binding();
        TextView textView12 = fragmentExamUpdateBinding17 != null ? fragmentExamUpdateBinding17.registerBtn : null;
        if (textView12 != null) {
            textView12.setVisibility(8);
        }
        FragmentExamUpdateBinding fragmentExamUpdateBinding18 = get_binding();
        TextView textView13 = fragmentExamUpdateBinding18 != null ? fragmentExamUpdateBinding18.payNowBtn : null;
        if (textView13 != null) {
            textView13.setVisibility(8);
        }
        FragmentExamUpdateBinding fragmentExamUpdateBinding19 = get_binding();
        linearLayout = fragmentExamUpdateBinding19 != null ? fragmentExamUpdateBinding19.payLyt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }
}