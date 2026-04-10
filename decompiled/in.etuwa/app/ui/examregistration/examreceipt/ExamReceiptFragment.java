package in.etuwa.app.ui.examregistration.examreceipt;

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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.examregister.ExamReceiptResponse;
import in.etuwa.app.databinding.FragmentExamReceiptBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptAdapter;
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

/* compiled from: ExamReceiptFragment.kt */
/* loaded from: classes4.dex */
public final class ExamReceiptFragment extends BaseFragment implements ExamReceiptAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamReceiptBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: examReceiptViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examReceiptViewModel;
    private MainCallBackListener listener;

    /* compiled from: ExamReceiptFragment.kt */
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
    public static final ExamReceiptFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ExamReceiptFragment() {
        final ExamReceiptFragment examReceiptFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examReceiptFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examReceiptViewModel = FragmentViewModelLazyKt.createViewModelLazy(examReceiptFragment, Reflection.getOrCreateKotlinClass(ExamReceiptViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamReceiptViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamReceiptFragment examReceiptFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ExamReceiptAdapter>() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = examReceiptFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamReceiptAdapter.class), b2, b3);
            }
        });
    }

    private final ExamReceiptViewModel getExamReceiptViewModel() {
        return (ExamReceiptViewModel) this.examReceiptViewModel.getValue();
    }

    private final ExamReceiptAdapter getAdapter() {
        return (ExamReceiptAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentExamReceiptBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ExamReceiptFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/examregistration/examreceipt/ExamReceiptFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examreceipt/ExamReceiptFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamReceiptFragment newInstance() {
            ExamReceiptFragment examReceiptFragment = new ExamReceiptFragment();
            examReceiptFragment.setArguments(new Bundle());
            return examReceiptFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamReceiptBinding.inflate(inflater, container, false);
        FragmentExamReceiptBinding fragmentExamReceiptBinding = get_binding();
        if (fragmentExamReceiptBinding != null) {
            fragmentExamReceiptBinding.setExamReceiptViewModel(getExamReceiptViewModel());
        }
        FragmentExamReceiptBinding fragmentExamReceiptBinding2 = get_binding();
        if (fragmentExamReceiptBinding2 != null) {
            fragmentExamReceiptBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamReceiptBinding fragmentExamReceiptBinding3 = get_binding();
        if (fragmentExamReceiptBinding3 != null) {
            return fragmentExamReceiptBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("University Exams");
        }
        hideBaseView();
        FragmentExamReceiptBinding fragmentExamReceiptBinding = get_binding();
        RecyclerView recyclerView = fragmentExamReceiptBinding != null ? fragmentExamReceiptBinding.rvExamReceipt : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        getExamReceiptViewModel().getExamReceiptData();
    }

    private final void listenResponse() {
        getExamReceiptViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamReceiptFragment.listenResponse$lambda$2(ExamReceiptFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(ExamReceiptFragment this$0, Resource resource) {
        RecyclerView rvExamReceipt;
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
            FragmentExamReceiptBinding fragmentExamReceiptBinding = this$0.get_binding();
            if (fragmentExamReceiptBinding == null || (recyclerView = fragmentExamReceiptBinding.rvExamReceipt) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamReceiptResponse examReceiptResponse = (ExamReceiptResponse) resource.getData();
        if (examReceiptResponse != null) {
            this$0.showBaseView();
            if (examReceiptResponse.getLogin()) {
                try {
                    this$0.getAdapter().addItems(examReceiptResponse.getReceipts());
                    return;
                } catch (NullPointerException unused) {
                    FragmentExamReceiptBinding fragmentExamReceiptBinding2 = this$0.get_binding();
                    TextView textView = fragmentExamReceiptBinding2 != null ? fragmentExamReceiptBinding2.dataNoTv : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
            }
            FragmentExamReceiptBinding fragmentExamReceiptBinding3 = this$0.get_binding();
            if (fragmentExamReceiptBinding3 == null || (rvExamReceipt = fragmentExamReceiptBinding3.rvExamReceipt) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamReceipt, "rvExamReceipt");
            ToastExtKt.showErrorToast(rvExamReceipt, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentExamReceiptBinding fragmentExamReceiptBinding = get_binding();
        if (fragmentExamReceiptBinding == null || (recyclerView = fragmentExamReceiptBinding.rvExamReceipt) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentExamReceiptBinding fragmentExamReceiptBinding = get_binding();
        if (fragmentExamReceiptBinding == null || (recyclerView = fragmentExamReceiptBinding.rvExamReceipt) == null) {
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

    @Override // in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptAdapter.CallBack
    public void downloadBtnClicked(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPaymentPage(url);
        }
    }
}