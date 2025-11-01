package in.etuwa.app.ui.examregistration.revaluation.fee;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.examregister.RevaluationApplyResponse;
import in.etuwa.app.databinding.FragmentRevaluationFeeBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
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

/* compiled from: RevaluationFeeFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020%H\u0014J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00105\u001a\u00020%H\u0016J\u001a\u00106\u001a\u00020%2\u0006\u00107\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00108\u001a\u00020%H\u0014J\b\u00109\u001a\u00020%H\u0014J\b\u0010:\u001a\u00020%H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b!\u0010\"¨\u0006<"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentRevaluationFeeBinding;", "adapter", "Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", ExamSubjectDetailDialogKt.ARG_AMOUNT, "", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentRevaluationFeeBinding;", "date", "flag", "", "Ljava/lang/Boolean;", "id", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "id2", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "revaluationCollection", "Ljava/util/HashMap;", "getRevaluationCollection", "()Ljava/util/HashMap;", "revaluationFeeViewModel", "Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeViewModel;", "getRevaluationFeeViewModel", "()Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeViewModel;", "revaluationFeeViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "listenUrlResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RevaluationFeeFragment extends BaseFragment implements RevaluationFeeAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentRevaluationFeeBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String amount;
    private String date;
    private Boolean flag;
    private ArrayList<String> id;
    private ArrayList<String> id2;
    private MainCallBackListener listener;
    private final HashMap<String, String> revaluationCollection;

    /* renamed from: revaluationFeeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy revaluationFeeViewModel;

    /* compiled from: RevaluationFeeFragment.kt */
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
    public static final RevaluationFeeFragment newInstance(ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z) {
        return INSTANCE.newInstance(arrayList, arrayList2, z);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public RevaluationFeeFragment() {
        final RevaluationFeeFragment revaluationFeeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(revaluationFeeFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.revaluationFeeViewModel = FragmentViewModelLazyKt.createViewModelLazy(revaluationFeeFragment, Reflection.getOrCreateKotlinClass(RevaluationFeeViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(RevaluationFeeViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final RevaluationFeeFragment revaluationFeeFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RevaluationFeeAdapter>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final RevaluationFeeAdapter invoke() {
                ComponentCallbacks componentCallbacks = revaluationFeeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(RevaluationFeeAdapter.class), b2, b3);
            }
        });
        this.revaluationCollection = new HashMap<>();
    }

    private final RevaluationFeeViewModel getRevaluationFeeViewModel() {
        return (RevaluationFeeViewModel) this.revaluationFeeViewModel.getValue();
    }

    private final RevaluationFeeAdapter getAdapter() {
        return (RevaluationFeeAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentRevaluationFeeBinding get_binding() {
        return this._binding;
    }

    public final HashMap<String, String> getRevaluationCollection() {
        return this.revaluationCollection;
    }

    /* compiled from: RevaluationFeeFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeFragment;", "id", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "id2", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RevaluationFeeFragment newInstance(ArrayList<String> id, ArrayList<String> id2, boolean flag) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(id2, "id2");
            RevaluationFeeFragment revaluationFeeFragment = new RevaluationFeeFragment();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("string", id);
            bundle.putStringArrayList(RevaluationFeeFragmentKt.ARG_STRING_ARRAY2, id2);
            bundle.putBoolean("flag", flag);
            revaluationFeeFragment.setArguments(bundle);
            return revaluationFeeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getStringArrayList("string");
            this.id2 = arguments.getStringArrayList(RevaluationFeeFragmentKt.ARG_STRING_ARRAY2);
            this.flag = Boolean.valueOf(arguments.getBoolean("flag"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentRevaluationFeeBinding.inflate(inflater, container, false);
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding = get_binding();
        if (fragmentRevaluationFeeBinding != null) {
            fragmentRevaluationFeeBinding.setRevaluationFeeViewModel(getRevaluationFeeViewModel());
        }
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding2 = get_binding();
        if (fragmentRevaluationFeeBinding2 != null) {
            fragmentRevaluationFeeBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding3 = get_binding();
        if (fragmentRevaluationFeeBinding3 != null) {
            return fragmentRevaluationFeeBinding3.getRoot();
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
            activity.setTitle("Payment");
        }
        hideBaseView();
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding = get_binding();
        RecyclerView recyclerView = fragmentRevaluationFeeBinding != null ? fragmentRevaluationFeeBinding.rvExamRevaluation : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        System.out.println((Object) "ArrayList down here");
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding2 = get_binding();
        if (fragmentRevaluationFeeBinding2 != null && (swipeRefreshLayout = fragmentRevaluationFeeBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    RevaluationFeeFragment.setUp$lambda$1(RevaluationFeeFragment.this);
                }
            });
        }
        ArrayList<String> arrayList = this.id;
        Intrinsics.checkNotNull(arrayList);
        System.out.println(arrayList);
        ArrayList<String> arrayList2 = this.id2;
        Intrinsics.checkNotNull(arrayList2);
        System.out.println(arrayList2);
        this.revaluationCollection.clear();
        this.revaluationCollection.put("exam_id", "1");
        ArrayList<String> arrayList3 = this.id;
        Intrinsics.checkNotNull(arrayList3);
        int size = arrayList3.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                ArrayList<String> arrayList4 = this.id;
                Intrinsics.checkNotNull(arrayList4);
                if (Intrinsics.areEqual(arrayList4.get(i), "true")) {
                    int i2 = i + 1;
                    this.revaluationCollection.put("revaluation[" + i2 + "]", String.valueOf(i2));
                }
                ArrayList<String> arrayList5 = this.id2;
                Intrinsics.checkNotNull(arrayList5);
                if (Intrinsics.areEqual(arrayList5.get(i), "true")) {
                    int i3 = i + 1;
                    this.revaluationCollection.put("asc[" + i3 + "]", String.valueOf(i3));
                    ArrayList<String> arrayList6 = this.id;
                    Intrinsics.checkNotNull(arrayList6);
                    if (i == arrayList6.size() - 1) {
                        if (Intrinsics.areEqual((Object) this.flag, (Object) true)) {
                            getRevaluationFeeViewModel().getExamRevaluationConfirm(this.revaluationCollection);
                        } else {
                            getRevaluationFeeViewModel().getExamRevaluationConfirmUpdate(this.revaluationCollection);
                        }
                    }
                } else {
                    ArrayList<String> arrayList7 = this.id;
                    Intrinsics.checkNotNull(arrayList7);
                    if (i == arrayList7.size() - 1) {
                        if (Intrinsics.areEqual((Object) this.flag, (Object) true)) {
                            getRevaluationFeeViewModel().getExamRevaluationConfirm(this.revaluationCollection);
                        } else {
                            getRevaluationFeeViewModel().getExamRevaluationConfirmUpdate(this.revaluationCollection);
                        }
                    }
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(this.revaluationCollection);
        listenResponse();
        listenUrlResponse();
        if (Intrinsics.areEqual((Object) this.flag, (Object) true)) {
            getRevaluationFeeViewModel().getExamRevaluationConfirm(this.revaluationCollection);
        } else {
            getRevaluationFeeViewModel().getExamRevaluationConfirmUpdate(this.revaluationCollection);
        }
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding3 = get_binding();
        if (fragmentRevaluationFeeBinding3 == null || (textView = fragmentRevaluationFeeBinding3.payNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RevaluationFeeFragment.setUp$lambda$2(RevaluationFeeFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(RevaluationFeeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentRevaluationFeeBinding != null ? fragmentRevaluationFeeBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(RevaluationFeeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, String> hashMap = this$0.revaluationCollection;
        String str = this$0.date;
        Intrinsics.checkNotNull(str);
        hashMap.put("UniversityExamRevaluation[applied_date]", str);
        HashMap<String, String> hashMap2 = this$0.revaluationCollection;
        String str2 = this$0.amount;
        Intrinsics.checkNotNull(str2);
        hashMap2.put("UniversityExamRevaluation[amount]", str2);
        HashMap<String, String> hashMap3 = this$0.revaluationCollection;
        String str3 = this$0.amount;
        Intrinsics.checkNotNull(str3);
        hashMap3.put("UniversityExamRevaluation[sub_total]", str3);
        this$0.revaluationCollection.put("Payment", "1");
        System.out.println(this$0.revaluationCollection);
        if (Intrinsics.areEqual((Object) this$0.flag, (Object) true)) {
            this$0.getRevaluationFeeViewModel().getExamRevaluationPay(this$0.revaluationCollection);
        } else {
            this$0.getRevaluationFeeViewModel().getExamRevaluationUpdatePay(this$0.revaluationCollection);
        }
    }

    private final void listenResponse() {
        getRevaluationFeeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RevaluationFeeFragment.listenResponse$lambda$4(RevaluationFeeFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(RevaluationFeeFragment this$0, Resource resource) {
        RecyclerView rvExamRevaluation;
        RecyclerView rvExamRevaluation2;
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
            FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding = this$0.get_binding();
            if (fragmentRevaluationFeeBinding == null || (recyclerView = fragmentRevaluationFeeBinding.rvExamRevaluation) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RevaluationApplyResponse revaluationApplyResponse = (RevaluationApplyResponse) resource.getData();
        if (revaluationApplyResponse != null) {
            this$0.showBaseView();
            if (revaluationApplyResponse.getRevaluation().size() > 0) {
                try {
                    this$0.getAdapter().addItems(revaluationApplyResponse.getRevaluation());
                    FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding2 = this$0.get_binding();
                    TextView textView = fragmentRevaluationFeeBinding2 != null ? fragmentRevaluationFeeBinding2.tvHostelTotal : null;
                    if (textView != null) {
                        textView.setText(revaluationApplyResponse.getRevaluation().get(0).getTotal());
                    }
                    this$0.date = revaluationApplyResponse.getRevaluation().get(0).getDate();
                    this$0.amount = revaluationApplyResponse.getRevaluation().get(0).getTotal();
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (NullPointerException unused) {
                    FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding3 = this$0.get_binding();
                    if (fragmentRevaluationFeeBinding3 == null || (rvExamRevaluation = fragmentRevaluationFeeBinding3.rvExamRevaluation) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvExamRevaluation, "rvExamRevaluation");
                    ToastExtKt.showErrorToast(rvExamRevaluation, "No Data Found");
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
            }
            FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding4 = this$0.get_binding();
            if (fragmentRevaluationFeeBinding4 == null || (rvExamRevaluation2 = fragmentRevaluationFeeBinding4.rvExamRevaluation) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamRevaluation2, "rvExamRevaluation");
            ToastExtKt.showErrorToast(rvExamRevaluation2, "netwok error");
        }
    }

    private final void listenUrlResponse() {
        getRevaluationFeeViewModel().getPayResponse().observe(getViewLifecycleOwner(), new RevaluationFeeFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DuePayUrl>, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$listenUrlResponse$1

            /* compiled from: RevaluationFeeFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DuePayUrl> resource) {
                invoke2((Resource<DuePayUrl>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
            
                r0 = r0.listener;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.due.duepay.DuePayUrl> r4) {
                /*
                    r3 = this;
                    in.etuwa.app.utils.Status r0 = r4.getStatus()
                    int[] r1 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$listenUrlResponse$1.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto L35
                    r4 = 2
                    if (r0 == r4) goto L2f
                    r4 = 3
                    if (r0 == r4) goto L24
                    r4 = 4
                    if (r0 == r4) goto L19
                    goto L69
                L19:
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r4 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r4 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r4.showBaseView()
                    goto L69
                L24:
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r4 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r4 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r4.showBaseView()
                    goto L69
                L2f:
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r4 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r4.showProgress()
                    goto L69
                L35:
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r0 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r0.hideProgress()
                    java.lang.Object r4 = r4.getData()
                    in.etuwa.app.data.model.due.duepay.DuePayUrl r4 = (in.etuwa.app.data.model.due.duepay.DuePayUrl) r4
                    if (r4 == 0) goto L69
                    in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment r0 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.this
                    r0.showBaseView()
                    java.lang.String r1 = r4.getUrl()
                    java.io.PrintStream r2 = java.lang.System.out
                    r2.println(r1)
                    java.lang.String r1 = r4.getUrl()
                    java.lang.String r2 = ""
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    if (r1 != 0) goto L69
                    in.etuwa.app.helper.MainCallBackListener r0 = in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment.access$getListener$p(r0)
                    if (r0 == 0) goto L69
                    java.lang.String r4 = r4.getUrl()
                    r0.openPaymentPage(r4)
                L69:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeFragment$listenUrlResponse$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding = get_binding();
        if (fragmentRevaluationFeeBinding == null || (recyclerView = fragmentRevaluationFeeBinding.rvExamRevaluation) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationFeeBinding fragmentRevaluationFeeBinding = get_binding();
        if (fragmentRevaluationFeeBinding == null || (recyclerView = fragmentRevaluationFeeBinding.rvExamRevaluation) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
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