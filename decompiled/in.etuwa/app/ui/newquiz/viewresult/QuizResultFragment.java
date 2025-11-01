package in.etuwa.app.ui.newquiz.viewresult;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import in.etuwa.app.R;
import in.etuwa.app.data.model.quiz.result.QuizResultResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentQuizResultBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.newquiz.viewresult.QuizDescriptiveResultAdapter;
import in.etuwa.app.ui.newquiz.viewresult.QuizMultipleResultAdapter;
import in.etuwa.app.ui.newquiz.viewresult.QuizUploadResultAdapter;
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

/* compiled from: QuizResultFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001@B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020(H\u0014J\b\u0010*\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00107\u001a\u00020(H\u0016J\b\u00108\u001a\u00020(H\u0016J\u001a\u00109\u001a\u00020(2\u0006\u0010:\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010;\u001a\u00020(H\u0014J\b\u0010<\u001a\u00020(H\u0014J\b\u0010=\u001a\u00020(H\u0014J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u001aH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%¨\u0006A"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizResultFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter$QuizInteraction;", "Lin/etuwa/app/ui/newquiz/viewresult/QuizUploadResultAdapter$QuizInteraction;", "Lin/etuwa/app/ui/newquiz/viewresult/QuizDescriptiveResultAdapter$QuizInteraction;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentQuizResultBinding;", "adapterDescriptive", "Lin/etuwa/app/ui/newquiz/viewresult/QuizUploadResultAdapter;", "getAdapterDescriptive", "()Lin/etuwa/app/ui/newquiz/viewresult/QuizUploadResultAdapter;", "adapterDescriptive$delegate", "Lkotlin/Lazy;", "adapterMultiple", "Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter;", "getAdapterMultiple", "()Lin/etuwa/app/ui/newquiz/viewresult/QuizMultipleResultAdapter;", "adapterMultiple$delegate", "adapterUpload", "getAdapterUpload", "adapterUpload$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentQuizResultBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "quizResultViewModel", "Lin/etuwa/app/ui/newquiz/viewresult/QuizResultViewModel;", "getQuizResultViewModel", "()Lin/etuwa/app/ui/newquiz/viewresult/QuizResultViewModel;", "quizResultViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "viewUploadClicked", "url", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuizResultFragment extends BaseFragment implements QuizMultipleResultAdapter.QuizInteraction, QuizUploadResultAdapter.QuizInteraction, QuizDescriptiveResultAdapter.QuizInteraction {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentQuizResultBinding _binding;

    /* renamed from: adapterDescriptive$delegate, reason: from kotlin metadata */
    private final Lazy adapterDescriptive;

    /* renamed from: adapterMultiple$delegate, reason: from kotlin metadata */
    private final Lazy adapterMultiple;

    /* renamed from: adapterUpload$delegate, reason: from kotlin metadata */
    private final Lazy adapterUpload;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: quizResultViewModel$delegate, reason: from kotlin metadata */
    private final Lazy quizResultViewModel;

    /* compiled from: QuizResultFragment.kt */
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
    public static final QuizResultFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    @Override // in.etuwa.app.ui.newquiz.viewresult.QuizUploadResultAdapter.QuizInteraction
    public void viewUploadClicked(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public QuizResultFragment() {
        final QuizResultFragment quizResultFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(quizResultFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.quizResultViewModel = FragmentViewModelLazyKt.createViewModelLazy(quizResultFragment, Reflection.getOrCreateKotlinClass(QuizResultViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(QuizResultViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final QuizResultFragment quizResultFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapterUpload = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QuizUploadResultAdapter>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.newquiz.viewresult.QuizUploadResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final QuizUploadResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = quizResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(QuizUploadResultAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterDescriptive = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<QuizUploadResultAdapter>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.newquiz.viewresult.QuizUploadResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final QuizUploadResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = quizResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(QuizUploadResultAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterMultiple = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<QuizMultipleResultAdapter>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.newquiz.viewresult.QuizMultipleResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final QuizMultipleResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = quizResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(QuizMultipleResultAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = quizResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b8, b9);
            }
        });
    }

    private final QuizResultViewModel getQuizResultViewModel() {
        return (QuizResultViewModel) this.quizResultViewModel.getValue();
    }

    private final QuizUploadResultAdapter getAdapterUpload() {
        return (QuizUploadResultAdapter) this.adapterUpload.getValue();
    }

    private final QuizUploadResultAdapter getAdapterDescriptive() {
        return (QuizUploadResultAdapter) this.adapterDescriptive.getValue();
    }

    private final QuizMultipleResultAdapter getAdapterMultiple() {
        return (QuizMultipleResultAdapter) this.adapterMultiple.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentQuizResultBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: QuizResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/newquiz/viewresult/QuizResultFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/newquiz/viewresult/QuizResultFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QuizResultFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            QuizResultFragment quizResultFragment = new QuizResultFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            quizResultFragment.setArguments(bundle);
            return quizResultFragment;
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
        this._binding = FragmentQuizResultBinding.inflate(inflater, container, false);
        FragmentQuizResultBinding fragmentQuizResultBinding = get_binding();
        if (fragmentQuizResultBinding != null) {
            fragmentQuizResultBinding.setQuizResultViewModel(getQuizResultViewModel());
        }
        FragmentQuizResultBinding fragmentQuizResultBinding2 = get_binding();
        if (fragmentQuizResultBinding2 != null) {
            fragmentQuizResultBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentQuizResultBinding fragmentQuizResultBinding3 = get_binding();
        if (fragmentQuizResultBinding3 != null) {
            return fragmentQuizResultBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.quiz));
        }
        hideBaseView();
        FragmentQuizResultBinding fragmentQuizResultBinding = get_binding();
        RecyclerView recyclerView = fragmentQuizResultBinding != null ? fragmentQuizResultBinding.rvMultipleQuiz : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapterMultiple());
        }
        FragmentQuizResultBinding fragmentQuizResultBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentQuizResultBinding2 != null ? fragmentQuizResultBinding2.rvUploadQuiz : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterUpload());
        }
        FragmentQuizResultBinding fragmentQuizResultBinding3 = get_binding();
        RecyclerView recyclerView3 = fragmentQuizResultBinding3 != null ? fragmentQuizResultBinding3.rvDescriptiveQuiz : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterDescriptive());
        }
        getAdapterUpload().setQuizInteraction(this);
        getAdapterMultiple().setQuizInteraction(this);
        getAdapterDescriptive().setQuizInteraction(this);
        getPreference().setNewLogin(false);
        listenResponse();
        QuizResultViewModel quizResultViewModel = getQuizResultViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        quizResultViewModel.getQuizList(str);
        FragmentQuizResultBinding fragmentQuizResultBinding4 = get_binding();
        if (fragmentQuizResultBinding4 == null || (swipeRefreshLayout = fragmentQuizResultBinding4.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                QuizResultFragment.setUp$lambda$1(QuizResultFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(QuizResultFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QuizResultViewModel quizResultViewModel = this$0.getQuizResultViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        quizResultViewModel.getQuizList(str);
        FragmentQuizResultBinding fragmentQuizResultBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentQuizResultBinding != null ? fragmentQuizResultBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getQuizResultViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuizResultFragment.listenResponse$lambda$3(QuizResultFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(QuizResultFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            QuizResultResponse quizResultResponse = (QuizResultResponse) resource.getData();
            if (quizResultResponse != null) {
                this$0.showBaseView();
                this$0.getAdapterMultiple().addItems(quizResultResponse.getMultipleChoiceQuestions());
                return;
            }
            return;
        }
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
        FragmentQuizResultBinding fragmentQuizResultBinding = this$0.get_binding();
        if (fragmentQuizResultBinding == null || (recyclerView = fragmentQuizResultBinding.rvMultipleQuiz) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentQuizResultBinding fragmentQuizResultBinding = get_binding();
        if (fragmentQuizResultBinding == null || (recyclerView = fragmentQuizResultBinding.rvMultipleQuiz) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentQuizResultBinding fragmentQuizResultBinding = get_binding();
        if (fragmentQuizResultBinding == null || (recyclerView = fragmentQuizResultBinding.rvMultipleQuiz) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapterMultiple().setQuizInteraction(null);
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
        } else {
            super.onAttach(context);
        }
    }
}