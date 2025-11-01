package in.etuwa.app.ui.examregistration.revaluation.view;

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
import in.etuwa.app.data.model.examregister.RevaluationView;
import in.etuwa.app.data.model.examregister.RevaluationViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentRevaluationViewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RevaluationViewFragment.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020%H\u0014J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00104\u001a\u00020%H\u0016J\u001a\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u00108\u001a\u00020%H\u0014J\b\u00109\u001a\u00020%H\u0014J\b\u0010:\u001a\u00020%H\u0014J$\u0010;\u001a\u00020%2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0=H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b!\u0010\"¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentRevaluationViewBinding;", "adapter", "Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "arrayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getArrayList", "()Ljava/util/ArrayList;", "setArrayList", "(Ljava/util/ArrayList;)V", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentRevaluationViewBinding;", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "revaluationViewViewModel", "Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewViewModel;", "getRevaluationViewViewModel", "()Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewViewModel;", "revaluationViewViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "receiptBtnClicked", "setUp", "showBaseView", "showProgress", "updateSelected", "revaluationSel", "", "answerSheetSel", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RevaluationViewFragment extends BaseFragment implements RevaluationViewAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentRevaluationViewBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<String> arrayList;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: revaluationViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy revaluationViewViewModel;

    /* compiled from: RevaluationViewFragment.kt */
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
    public static final RevaluationViewFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    @Override // in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewAdapter.CallBack
    public void updateSelected(List<String> revaluationSel, List<String> answerSheetSel) {
        Intrinsics.checkNotNullParameter(revaluationSel, "revaluationSel");
        Intrinsics.checkNotNullParameter(answerSheetSel, "answerSheetSel");
    }

    public RevaluationViewFragment() {
        final RevaluationViewFragment revaluationViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(revaluationViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.revaluationViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(revaluationViewFragment, Reflection.getOrCreateKotlinClass(RevaluationViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(RevaluationViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final RevaluationViewFragment revaluationViewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RevaluationViewAdapter>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final RevaluationViewAdapter invoke() {
                ComponentCallbacks componentCallbacks = revaluationViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(RevaluationViewAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = revaluationViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final RevaluationViewViewModel getRevaluationViewViewModel() {
        return (RevaluationViewViewModel) this.revaluationViewViewModel.getValue();
    }

    private final RevaluationViewAdapter getAdapter() {
        return (RevaluationViewAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentRevaluationViewBinding get_binding() {
        return this._binding;
    }

    public final ArrayList<String> getArrayList() {
        return this.arrayList;
    }

    public final void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: RevaluationViewFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/revaluation/view/RevaluationViewFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RevaluationViewFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            RevaluationViewFragment revaluationViewFragment = new RevaluationViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            revaluationViewFragment.setArguments(bundle);
            return revaluationViewFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentRevaluationViewBinding.inflate(inflater, container, false);
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding = get_binding();
        if (fragmentRevaluationViewBinding != null) {
            fragmentRevaluationViewBinding.setRevaluationViewViewModel(getRevaluationViewViewModel());
        }
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding2 = get_binding();
        if (fragmentRevaluationViewBinding2 != null) {
            fragmentRevaluationViewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding3 = get_binding();
        if (fragmentRevaluationViewBinding3 != null) {
            return fragmentRevaluationViewBinding3.getRoot();
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
            activity.setTitle("Revaluation");
        }
        hideBaseView();
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding = get_binding();
        RecyclerView recyclerView = fragmentRevaluationViewBinding != null ? fragmentRevaluationViewBinding.rvExamRevaluation : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        getPreference().setNewLogin(false);
        RevaluationViewViewModel revaluationViewViewModel = getRevaluationViewViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        revaluationViewViewModel.getExamData(str);
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding2 = get_binding();
        if (fragmentRevaluationViewBinding2 != null && (swipeRefreshLayout = fragmentRevaluationViewBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    RevaluationViewFragment.setUp$lambda$1(RevaluationViewFragment.this);
                }
            });
        }
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding3 = get_binding();
        if (fragmentRevaluationViewBinding3 == null || (textView = fragmentRevaluationViewBinding3.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RevaluationViewFragment.setUp$lambda$2(RevaluationViewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(RevaluationViewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RevaluationViewViewModel revaluationViewViewModel = this$0.getRevaluationViewViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        revaluationViewViewModel.getExamData(str);
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentRevaluationViewBinding != null ? fragmentRevaluationViewBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(RevaluationViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            String str = this$0.id;
            Intrinsics.checkNotNull(str);
            mainCallBackListener.revaluationUpdateClicked(str, false);
        }
    }

    private final void listenResponse() {
        getRevaluationViewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RevaluationViewFragment.listenResponse$lambda$4(RevaluationViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlin.Unit] */
    public static final void listenResponse$lambda$4(RevaluationViewFragment this$0, Resource resource) {
        RecyclerView rvExamRevaluation;
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
            FragmentRevaluationViewBinding fragmentRevaluationViewBinding = this$0.get_binding();
            if (fragmentRevaluationViewBinding == null || (recyclerView = fragmentRevaluationViewBinding.rvExamRevaluation) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RevaluationViewResponse revaluationViewResponse = (RevaluationViewResponse) resource.getData();
        if (revaluationViewResponse != null) {
            this$0.showBaseView();
            try {
                if (revaluationViewResponse.getRevaluation().size() > 0) {
                    RevaluationViewAdapter adapter = this$0.getAdapter();
                    ArrayList<RevaluationView> revaluation = revaluationViewResponse.getRevaluation();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(revaluation, requireContext);
                    this$0 = Unit.INSTANCE;
                } else {
                    FragmentRevaluationViewBinding fragmentRevaluationViewBinding2 = this$0.get_binding();
                    this$0 = this$0;
                    if (fragmentRevaluationViewBinding2 != null) {
                        RecyclerView rvExamRevaluation2 = fragmentRevaluationViewBinding2.rvExamRevaluation;
                        this$0 = this$0;
                        if (rvExamRevaluation2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rvExamRevaluation2, "rvExamRevaluation");
                            ToastExtKt.showErrorToast(rvExamRevaluation2, "No Data Found");
                            this$0 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                FragmentRevaluationViewBinding fragmentRevaluationViewBinding3 = this$0.get_binding();
                if (fragmentRevaluationViewBinding3 == null || (rvExamRevaluation = fragmentRevaluationViewBinding3.rvExamRevaluation) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExamRevaluation, "rvExamRevaluation");
                ToastExtKt.showErrorToast(rvExamRevaluation, "No Data Found");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding = get_binding();
        if (fragmentRevaluationViewBinding == null || (recyclerView = fragmentRevaluationViewBinding.rvExamRevaluation) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationViewBinding fragmentRevaluationViewBinding = get_binding();
        if (fragmentRevaluationViewBinding == null || (recyclerView = fragmentRevaluationViewBinding.rvExamRevaluation) == null) {
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

    @Override // in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewAdapter.CallBack
    public void receiptBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showRevaluationReceipt(id);
        }
    }
}