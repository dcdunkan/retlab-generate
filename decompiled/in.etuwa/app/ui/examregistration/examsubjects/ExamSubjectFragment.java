package in.etuwa.app.ui.examregistration.examsubjects;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import in.etuwa.app.R;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamRegister;
import in.etuwa.app.data.model.examregister.ExamRegisterResponse;
import in.etuwa.app.data.model.examregister.RevaluationStatusResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentExamSubjectBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ExamSubjectFragment.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001LB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020/H\u0014J\b\u00101\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020/2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020/2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020/H\u0002J\b\u00105\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u00020/2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J&\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010B\u001a\u00020/H\u0016J\u001a\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020=2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010E\u001a\u00020/H\u0014J\b\u0010F\u001a\u00020/H\u0014J\b\u0010G\u001a\u00020/H\u0014J\u0010\u0010H\u001a\u00020/2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010I\u001a\u00020/2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010J\u001a\u00020/2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010K\u001a\u00020/2\u0006\u0010$\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter$CallBack;", "Lin/etuwa/app/ui/examregistration/examsubjects/detaildialog/ExamSubjectDetailDialog$ExamDetailListner;", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter2$CallBack;", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter3$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentExamSubjectBinding;", "abcId", "", "adapter", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "adapter2", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter2;", "getAdapter2", "()Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter2;", "adapter2$delegate", "adapter3", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter3;", "getAdapter3", "()Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectAdapter3;", "adapter3$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentExamSubjectBinding;", "examSubjectViewModel", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectViewModel;", "getExamSubjectViewModel", "()Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectViewModel;", "examSubjectViewModel$delegate", "flag", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "regFlag", "", "hideBaseView", "", "hideProgress", "listenAbcResponse", "listenDueResponse", "listenErrorResponse", "listenResponse", "listenStatusResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "viewBtnClicked", "viewRegisterBtnClicked", "viewResultBtnClicked", "viewRevaatuation", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExamSubjectFragment extends BaseFragment implements ExamSubjectAdapter.CallBack, ExamSubjectDetailDialog.ExamDetailListner, ExamSubjectAdapter2.CallBack, ExamSubjectAdapter3.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamSubjectBinding _binding;
    private String abcId;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: adapter2$delegate, reason: from kotlin metadata */
    private final Lazy adapter2;

    /* renamed from: adapter3$delegate, reason: from kotlin metadata */
    private final Lazy adapter3;

    /* renamed from: examSubjectViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examSubjectViewModel;
    private String flag;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private boolean regFlag;

    /* compiled from: ExamSubjectFragment.kt */
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
    public static final ExamSubjectFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3.CallBack
    public void viewBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public ExamSubjectFragment() {
        final ExamSubjectFragment examSubjectFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examSubjectFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examSubjectViewModel = FragmentViewModelLazyKt.createViewModelLazy(examSubjectFragment, Reflection.getOrCreateKotlinClass(ExamSubjectViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamSubjectViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamSubjectFragment examSubjectFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ExamSubjectAdapter>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamSubjectAdapter invoke() {
                ComponentCallbacks componentCallbacks = examSubjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamSubjectAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<ExamSubjectAdapter2>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamSubjectAdapter2 invoke() {
                ComponentCallbacks componentCallbacks = examSubjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamSubjectAdapter2.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<ExamSubjectAdapter3>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamSubjectAdapter3 invoke() {
                ComponentCallbacks componentCallbacks = examSubjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamSubjectAdapter3.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = examSubjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b8, b9);
            }
        });
    }

    private final ExamSubjectViewModel getExamSubjectViewModel() {
        return (ExamSubjectViewModel) this.examSubjectViewModel.getValue();
    }

    private final ExamSubjectAdapter getAdapter() {
        return (ExamSubjectAdapter) this.adapter.getValue();
    }

    private final ExamSubjectAdapter2 getAdapter2() {
        return (ExamSubjectAdapter2) this.adapter2.getValue();
    }

    private final ExamSubjectAdapter3 getAdapter3() {
        return (ExamSubjectAdapter3) this.adapter3.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentExamSubjectBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ExamSubjectFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/ExamSubjectFragment;", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamSubjectFragment newInstance(String flag) {
            Intrinsics.checkNotNullParameter(flag, "flag");
            ExamSubjectFragment examSubjectFragment = new ExamSubjectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", flag);
            examSubjectFragment.setArguments(bundle);
            return examSubjectFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flag = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamSubjectBinding.inflate(inflater, container, false);
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        if (fragmentExamSubjectBinding != null) {
            fragmentExamSubjectBinding.setExamSubjectViewModel(getExamSubjectViewModel());
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding2 = get_binding();
        if (fragmentExamSubjectBinding2 != null) {
            fragmentExamSubjectBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding3 = get_binding();
        if (fragmentExamSubjectBinding3 != null) {
            return fragmentExamSubjectBinding3.getRoot();
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
        TextView textView2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("University Exams");
        }
        hideBaseView();
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        RecyclerView recyclerView = fragmentExamSubjectBinding != null ? fragmentExamSubjectBinding.rvExamSubject : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenAbcResponse();
        getExamSubjectViewModel().getExamData();
        FragmentExamSubjectBinding fragmentExamSubjectBinding2 = get_binding();
        LinearLayout linearLayout = fragmentExamSubjectBinding2 != null ? fragmentExamSubjectBinding2.regLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding3 = get_binding();
        if (fragmentExamSubjectBinding3 != null && (textView2 = fragmentExamSubjectBinding3.registeredBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamSubjectFragment.setUp$lambda$1(ExamSubjectFragment.this, view);
                }
            });
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding4 = get_binding();
        if (fragmentExamSubjectBinding4 != null && (textView = fragmentExamSubjectBinding4.notRegisteredBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamSubjectFragment.setUp$lambda$2(ExamSubjectFragment.this, view);
                }
            });
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding5 = get_binding();
        if (fragmentExamSubjectBinding5 == null || (swipeRefreshLayout = fragmentExamSubjectBinding5.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ExamSubjectFragment.setUp$lambda$3(ExamSubjectFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ExamSubjectFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.regFlag = true;
        this$0.getExamSubjectViewModel().getExamData();
        FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
        if (fragmentExamSubjectBinding != null && (textView2 = fragmentExamSubjectBinding.registeredBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding2 = this$0.get_binding();
        if (fragmentExamSubjectBinding2 == null || (textView = fragmentExamSubjectBinding2.notRegisteredBtn) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ExamSubjectFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.regFlag = false;
        this$0.getExamSubjectViewModel().getExamData();
        FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
        if (fragmentExamSubjectBinding != null && (textView2 = fragmentExamSubjectBinding.notRegisteredBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
        }
        FragmentExamSubjectBinding fragmentExamSubjectBinding2 = this$0.get_binding();
        if (fragmentExamSubjectBinding2 == null || (textView = fragmentExamSubjectBinding2.registeredBtn) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ExamSubjectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getExamSubjectViewModel().getExamData();
        FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentExamSubjectBinding != null ? fragmentExamSubjectBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenAbcResponse() {
        getExamSubjectViewModel().getAbcResponse().observe(getViewLifecycleOwner(), new ExamSubjectFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AbcResponse>, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$listenAbcResponse$1

            /* compiled from: ExamSubjectFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AbcResponse> resource) {
                invoke2((Resource<AbcResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AbcResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ExamSubjectFragment.this.hideProgress();
                    AbcResponse data = resource.getData();
                    if (data != null) {
                        ExamSubjectFragment examSubjectFragment = ExamSubjectFragment.this;
                        examSubjectFragment.showBaseView();
                        String abc_id = data.getAbc_id();
                        if (abc_id == null) {
                            abc_id = "";
                        }
                        examSubjectFragment.abcId = abc_id;
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    ExamSubjectFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ExamSubjectFragment.this.hideProgress();
                    ExamSubjectFragment.this.showBaseView();
                } else {
                    if (i != 4) {
                        return;
                    }
                    ExamSubjectFragment.this.hideProgress();
                    ExamSubjectFragment.this.showBaseView();
                }
            }
        }));
    }

    private final void listenResponse() {
        getExamSubjectViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSubjectFragment.listenResponse$lambda$5(ExamSubjectFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(ExamSubjectFragment this$0, Resource resource) {
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
            FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
            if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamRegisterResponse examRegisterResponse = (ExamRegisterResponse) resource.getData();
        if (examRegisterResponse != null) {
            this$0.showBaseView();
            if (examRegisterResponse.getLogin()) {
                try {
                    if (this$0.regFlag) {
                        ExamSubjectAdapter adapter = this$0.getAdapter();
                        ArrayList<ExamRegister> regexam = examRegisterResponse.getRegexam();
                        String str = this$0.flag;
                        Intrinsics.checkNotNull(str);
                        adapter.addItems(regexam, str);
                    } else {
                        ExamSubjectAdapter adapter2 = this$0.getAdapter();
                        ArrayList<ExamRegister> notregexam = examRegisterResponse.getNotregexam();
                        String str2 = this$0.flag;
                        Intrinsics.checkNotNull(str2);
                        adapter2.addItems(notregexam, str2);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (NullPointerException unused) {
                    FragmentExamSubjectBinding fragmentExamSubjectBinding2 = this$0.get_binding();
                    if (fragmentExamSubjectBinding2 == null || (rvExamSubject = fragmentExamSubjectBinding2.rvExamSubject) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
                    ToastExtKt.showErrorToast(rvExamSubject, "No Data Found");
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
            }
            FragmentExamSubjectBinding fragmentExamSubjectBinding3 = this$0.get_binding();
            if (fragmentExamSubjectBinding3 == null || (rvExamSubject2 = fragmentExamSubjectBinding3.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject2, "netwok error");
        }
    }

    private final void listenStatusResponse() {
        getExamSubjectViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSubjectFragment.listenStatusResponse$lambda$7(ExamSubjectFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenStatusResponse$lambda$7(ExamSubjectFragment this$0, Resource resource) {
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
            FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
            if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RevaluationStatusResponse revaluationStatusResponse = (RevaluationStatusResponse) resource.getData();
        if (revaluationStatusResponse != null) {
            this$0.showBaseView();
            if (revaluationStatusResponse.getStatus()) {
                try {
                    MainCallBackListener mainCallBackListener = this$0.listener;
                    if (mainCallBackListener != null) {
                        String str = this$0.id;
                        Intrinsics.checkNotNull(str);
                        mainCallBackListener.viewRevaluationClicked(str);
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                } catch (NullPointerException unused) {
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
            }
            MainCallBackListener mainCallBackListener2 = this$0.listener;
            if (mainCallBackListener2 != null) {
                String str2 = this$0.id;
                Intrinsics.checkNotNull(str2);
                mainCallBackListener2.revaluationClicked(str2, true);
            }
        }
    }

    private final void listenDueResponse(final String id) {
        getExamSubjectViewModel().getDueResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSubjectFragment.listenDueResponse$lambda$9(ExamSubjectFragment.this, id, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDueResponse$lambda$9(ExamSubjectFragment this$0, String id, Resource resource) {
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
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
            FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
            if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
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
                if (Intrinsics.areEqual(examCourseResponse.getError(), "You have a pending due. Please clear it to proceed with registering for this exam.")) {
                    FragmentExamSubjectBinding fragmentExamSubjectBinding2 = this$0.get_binding();
                    if (fragmentExamSubjectBinding2 == null || (rvExamSubject2 = fragmentExamSubjectBinding2.rvExamSubject) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                    ToastExtKt.showErrorToast(rvExamSubject2, examCourseResponse.getError());
                    return;
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.showExamRegFragment(id);
                    return;
                }
                return;
            }
            FragmentExamSubjectBinding fragmentExamSubjectBinding3 = this$0.get_binding();
            if (fragmentExamSubjectBinding3 == null || (rvExamSubject = fragmentExamSubjectBinding3.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    private final void listenErrorResponse(final String id) {
        getExamSubjectViewModel().getDueResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSubjectFragment.listenErrorResponse$lambda$11(ExamSubjectFragment.this, id, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenErrorResponse$lambda$11(ExamSubjectFragment this$0, String id, Resource resource) {
        RecyclerView rvExamSubject;
        RecyclerView rvExamSubject2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
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
            FragmentExamSubjectBinding fragmentExamSubjectBinding = this$0.get_binding();
            if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
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
                if (!Intrinsics.areEqual(examCourseResponse.getError(), "")) {
                    FragmentExamSubjectBinding fragmentExamSubjectBinding2 = this$0.get_binding();
                    if (fragmentExamSubjectBinding2 == null || (rvExamSubject2 = fragmentExamSubjectBinding2.rvExamSubject) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvExamSubject2, "rvExamSubject");
                    ToastExtKt.showErrorToast(rvExamSubject2, examCourseResponse.getError());
                    return;
                }
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.showExamRegFragment(id);
                    return;
                }
                return;
            }
            FragmentExamSubjectBinding fragmentExamSubjectBinding3 = this$0.get_binding();
            if (fragmentExamSubjectBinding3 == null || (rvExamSubject = fragmentExamSubjectBinding3.rvExamSubject) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExamSubject, "rvExamSubject");
            ToastExtKt.showErrorToast(rvExamSubject, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentExamSubjectBinding fragmentExamSubjectBinding = get_binding();
        if (fragmentExamSubjectBinding == null || (recyclerView = fragmentExamSubjectBinding.rvExamSubject) == null) {
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

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3.CallBack
    public void viewRegisterBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.areEqual(this.abcId, "");
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sbce", false, 2, (Object) null)) {
            getExamSubjectViewModel().getExamDetails(id);
            listenDueResponse(id);
        } else {
            getExamSubjectViewModel().getExamDetails(id);
            listenErrorResponse(id);
        }
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3.CallBack
    public void viewResultBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showExamResultFragment(id);
        }
    }

    @Override // in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2.CallBack, in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3.CallBack
    public void viewRevaatuation(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        listenStatusResponse();
        getExamSubjectViewModel().getExamStatusData(id);
    }
}