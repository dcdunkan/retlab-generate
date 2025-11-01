package in.etuwa.app.ui.examregistration.examsubjects.view;

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
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamViewResponse;
import in.etuwa.app.data.model.examregister.RegistrationSlipResponse;
import in.etuwa.app.databinding.FragmentExamViewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewAdapter;
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

/* compiled from: ExamViewFragment.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0014J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00101\u001a\u00020 H\u0016J\b\u00102\u001a\u00020 H\u0016J\u001a\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00105\u001a\u00020 H\u0003J\b\u00106\u001a\u00020 H\u0014J\b\u00107\u001a\u00020 H\u0014J\b\u00108\u001a\u00020 H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentExamViewBinding;", "adapter", "Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentExamViewBinding;", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "examViewViewModel", "Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewViewModel;", "getExamViewViewModel", "()Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewViewModel;", "examViewViewModel$delegate", "id", "getId", "setId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "hideBaseView", "", "hideProgress", "listenResponse", "listenSlipResponse", "listenViewResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onResume", "onViewCreated", SvgConstants.Tags.VIEW, "reloadFragment", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExamViewFragment extends BaseFragment implements ExamViewAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamViewBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String category;

    /* renamed from: examViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examViewViewModel;
    private String id;
    private MainCallBackListener listener;

    /* compiled from: ExamViewFragment.kt */
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
    public static final ExamViewFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ExamViewFragment() {
        final ExamViewFragment examViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(examViewFragment, Reflection.getOrCreateKotlinClass(ExamViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamViewFragment examViewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ExamViewAdapter>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ExamViewAdapter invoke() {
                ComponentCallbacks componentCallbacks = examViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ExamViewAdapter.class), b2, b3);
            }
        });
    }

    private final ExamViewViewModel getExamViewViewModel() {
        return (ExamViewViewModel) this.examViewViewModel.getValue();
    }

    private final ExamViewAdapter getAdapter() {
        return (ExamViewAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentExamViewBinding get_binding() {
        return this._binding;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        reloadFragment();
        setUp();
    }

    private final void reloadFragment() {
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        ExamViewFragment examViewFragment = this;
        beginTransaction.detach(examViewFragment);
        beginTransaction.attach(examViewFragment);
        beginTransaction.commit();
    }

    /* compiled from: ExamViewFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamViewFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ExamViewFragment examViewFragment = new ExamViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            examViewFragment.setArguments(bundle);
            return examViewFragment;
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
        this._binding = FragmentExamViewBinding.inflate(inflater, container, false);
        FragmentExamViewBinding fragmentExamViewBinding = get_binding();
        if (fragmentExamViewBinding != null) {
            fragmentExamViewBinding.setExamViewViewModel(getExamViewViewModel());
        }
        FragmentExamViewBinding fragmentExamViewBinding2 = get_binding();
        if (fragmentExamViewBinding2 != null) {
            fragmentExamViewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamViewBinding fragmentExamViewBinding3 = get_binding();
        if (fragmentExamViewBinding3 != null) {
            return fragmentExamViewBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Exam Registration");
        }
        hideBaseView();
        FragmentExamViewBinding fragmentExamViewBinding = get_binding();
        RecyclerView recyclerView = fragmentExamViewBinding != null ? fragmentExamViewBinding.rvRegHistory : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenViewResponse();
        ExamViewViewModel examViewViewModel = getExamViewViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        examViewViewModel.getExamDetails(str);
        ExamViewViewModel examViewViewModel2 = getExamViewViewModel();
        String str2 = this.id;
        Intrinsics.checkNotNull(str2);
        examViewViewModel2.getExamView(str2);
        FragmentExamViewBinding fragmentExamViewBinding2 = get_binding();
        if (fragmentExamViewBinding2 != null && (textView3 = fragmentExamViewBinding2.updationBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamViewFragment.setUp$lambda$2(ExamViewFragment.this, view);
                }
            });
        }
        FragmentExamViewBinding fragmentExamViewBinding3 = get_binding();
        if (fragmentExamViewBinding3 != null && (textView2 = fragmentExamViewBinding3.registerBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamViewFragment.setUp$lambda$3(ExamViewFragment.this, view);
                }
            });
        }
        FragmentExamViewBinding fragmentExamViewBinding4 = get_binding();
        if (fragmentExamViewBinding4 == null || (textView = fragmentExamViewBinding4.paySlipBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamViewFragment.setUp$lambda$4(ExamViewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ExamViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            String str = this$0.id;
            Intrinsics.checkNotNull(str);
            String str2 = this$0.category;
            Intrinsics.checkNotNull(str2);
            mainCallBackListener.showUpdateRegisterFragment(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ExamViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            String str = this$0.id;
            Intrinsics.checkNotNull(str);
            String str2 = this$0.category;
            Intrinsics.checkNotNull(str2);
            mainCallBackListener.showExamRegisterFragment(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ExamViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenSlipResponse();
        ExamViewViewModel examViewViewModel = this$0.getExamViewViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        examViewViewModel.getExamSlip(str);
    }

    private final void listenResponse() {
        getExamViewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamViewFragment.listenResponse$lambda$6(ExamViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(ExamViewFragment this$0, Resource resource) {
        RecyclerView rvRegHistory;
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
            FragmentExamViewBinding fragmentExamViewBinding = this$0.get_binding();
            if (fragmentExamViewBinding == null || (recyclerView = fragmentExamViewBinding.rvRegHistory) == null) {
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
                this$0.category = examCourseResponse.getCategory();
                if (examCourseResponse.is_registered()) {
                    ExamViewViewModel examViewViewModel = this$0.getExamViewViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    examViewViewModel.getExamView(str);
                    FragmentExamViewBinding fragmentExamViewBinding2 = this$0.get_binding();
                    LinearLayout linearLayout = fragmentExamViewBinding2 != null ? fragmentExamViewBinding2.registerLayout : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    FragmentExamViewBinding fragmentExamViewBinding3 = this$0.get_binding();
                    LinearLayout linearLayout2 = fragmentExamViewBinding3 != null ? fragmentExamViewBinding3.updationLayout : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    FragmentExamViewBinding fragmentExamViewBinding4 = this$0.get_binding();
                    RecyclerView recyclerView2 = fragmentExamViewBinding4 != null ? fragmentExamViewBinding4.rvRegHistory : null;
                    if (recyclerView2 != null) {
                        recyclerView2.setVisibility(0);
                    }
                } else {
                    FragmentExamViewBinding fragmentExamViewBinding5 = this$0.get_binding();
                    RecyclerView recyclerView3 = fragmentExamViewBinding5 != null ? fragmentExamViewBinding5.rvRegHistory : null;
                    if (recyclerView3 != null) {
                        recyclerView3.setVisibility(8);
                    }
                    FragmentExamViewBinding fragmentExamViewBinding6 = this$0.get_binding();
                    LinearLayout linearLayout3 = fragmentExamViewBinding6 != null ? fragmentExamViewBinding6.registerLayout : null;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                    FragmentExamViewBinding fragmentExamViewBinding7 = this$0.get_binding();
                    LinearLayout linearLayout4 = fragmentExamViewBinding7 != null ? fragmentExamViewBinding7.updationLayout : null;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                }
                if (examCourseResponse.getCan_update()) {
                    FragmentExamViewBinding fragmentExamViewBinding8 = this$0.get_binding();
                    TextView textView = fragmentExamViewBinding8 != null ? fragmentExamViewBinding8.updationBtn : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                } else {
                    FragmentExamViewBinding fragmentExamViewBinding9 = this$0.get_binding();
                    TextView textView2 = fragmentExamViewBinding9 != null ? fragmentExamViewBinding9.updationBtn : null;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                }
                if (examCourseResponse.getRegistration_slip()) {
                    FragmentExamViewBinding fragmentExamViewBinding10 = this$0.get_binding();
                    TextView textView3 = fragmentExamViewBinding10 != null ? fragmentExamViewBinding10.paySlipBtn : null;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                } else {
                    FragmentExamViewBinding fragmentExamViewBinding11 = this$0.get_binding();
                    TextView textView4 = fragmentExamViewBinding11 != null ? fragmentExamViewBinding11.paySlipBtn : null;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                }
                FragmentExamViewBinding fragmentExamViewBinding12 = this$0.get_binding();
                TextView textView5 = fragmentExamViewBinding12 != null ? fragmentExamViewBinding12.tvSubName : null;
                if (textView5 != null) {
                    textView5.setText(examCourseResponse.getName());
                }
                FragmentExamViewBinding fragmentExamViewBinding13 = this$0.get_binding();
                TextView textView6 = fragmentExamViewBinding13 != null ? fragmentExamViewBinding13.tvDegree : null;
                if (textView6 != null) {
                    textView6.setText(examCourseResponse.getDegree());
                }
                FragmentExamViewBinding fragmentExamViewBinding14 = this$0.get_binding();
                TextView textView7 = fragmentExamViewBinding14 != null ? fragmentExamViewBinding14.tvSemester : null;
                if (textView7 != null) {
                    textView7.setText(examCourseResponse.getSemester());
                }
                FragmentExamViewBinding fragmentExamViewBinding15 = this$0.get_binding();
                TextView textView8 = fragmentExamViewBinding15 != null ? fragmentExamViewBinding15.tvStartDate : null;
                if (textView8 != null) {
                    textView8.setText(examCourseResponse.getStart_date());
                }
                FragmentExamViewBinding fragmentExamViewBinding16 = this$0.get_binding();
                TextView textView9 = fragmentExamViewBinding16 != null ? fragmentExamViewBinding16.tvEndDate : null;
                if (textView9 != null) {
                    textView9.setText(examCourseResponse.getEnd_date());
                }
                FragmentExamViewBinding fragmentExamViewBinding17 = this$0.get_binding();
                TextView textView10 = fragmentExamViewBinding17 != null ? fragmentExamViewBinding17.tvAcademicYear : null;
                if (textView10 != null) {
                    textView10.setText(examCourseResponse.getAcademicyear());
                }
                FragmentExamViewBinding fragmentExamViewBinding18 = this$0.get_binding();
                TextView textView11 = fragmentExamViewBinding18 != null ? fragmentExamViewBinding18.tvMonth : null;
                if (textView11 != null) {
                    textView11.setText(examCourseResponse.getMonth());
                }
                FragmentExamViewBinding fragmentExamViewBinding19 = this$0.get_binding();
                TextView textView12 = fragmentExamViewBinding19 != null ? fragmentExamViewBinding19.tvYear : null;
                if (textView12 == null) {
                    return;
                }
                textView12.setText(examCourseResponse.getExam_year());
                return;
            }
            FragmentExamViewBinding fragmentExamViewBinding20 = this$0.get_binding();
            if (fragmentExamViewBinding20 == null || (rvRegHistory = fragmentExamViewBinding20.rvRegHistory) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvRegHistory, "rvRegHistory");
            ToastExtKt.showErrorToast(rvRegHistory, "netwok error");
        }
    }

    private final void listenViewResponse() {
        getExamViewViewModel().getViewResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamViewFragment.listenViewResponse$lambda$8(ExamViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenViewResponse$lambda$8(ExamViewFragment this$0, Resource resource) {
        RecyclerView rvRegHistory;
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
            FragmentExamViewBinding fragmentExamViewBinding = this$0.get_binding();
            if (fragmentExamViewBinding == null || (recyclerView = fragmentExamViewBinding.rvRegHistory) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ExamViewResponse examViewResponse = (ExamViewResponse) resource.getData();
        if (examViewResponse != null) {
            this$0.showBaseView();
            if (examViewResponse.getLogin()) {
                this$0.getAdapter().addItems(examViewResponse.getExam());
            } else {
                FragmentExamViewBinding fragmentExamViewBinding2 = this$0.get_binding();
                if (fragmentExamViewBinding2 != null && (rvRegHistory = fragmentExamViewBinding2.rvRegHistory) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvRegHistory, "rvRegHistory");
                    ToastExtKt.showErrorToast(rvRegHistory, "netwok error");
                }
            }
            if (examViewResponse.getLogin() && examViewResponse.getExam().size() > 0) {
                FragmentExamViewBinding fragmentExamViewBinding3 = this$0.get_binding();
                LinearLayout linearLayout = fragmentExamViewBinding3 != null ? fragmentExamViewBinding3.swipeLayout : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                FragmentExamViewBinding fragmentExamViewBinding4 = this$0.get_binding();
                LinearLayout linearLayout2 = fragmentExamViewBinding4 != null ? fragmentExamViewBinding4.errorLyt : null;
                if (linearLayout2 == null) {
                    return;
                }
                linearLayout2.setVisibility(8);
                return;
            }
            FragmentExamViewBinding fragmentExamViewBinding5 = this$0.get_binding();
            LinearLayout linearLayout3 = fragmentExamViewBinding5 != null ? fragmentExamViewBinding5.swipeLayout : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FragmentExamViewBinding fragmentExamViewBinding6 = this$0.get_binding();
            LinearLayout linearLayout4 = fragmentExamViewBinding6 != null ? fragmentExamViewBinding6.errorLyt : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            FragmentExamViewBinding fragmentExamViewBinding7 = this$0.get_binding();
            TextView textView = fragmentExamViewBinding7 != null ? fragmentExamViewBinding7.errorTv : null;
            if (textView == null) {
                return;
            }
            textView.setText(examViewResponse.getError());
        }
    }

    private final void listenSlipResponse() {
        getExamViewViewModel().getSlipResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamViewFragment.listenSlipResponse$lambda$10(ExamViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSlipResponse$lambda$10(ExamViewFragment this$0, Resource resource) {
        RecyclerView rvRegHistory;
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
            FragmentExamViewBinding fragmentExamViewBinding = this$0.get_binding();
            if (fragmentExamViewBinding == null || (recyclerView = fragmentExamViewBinding.rvRegHistory) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RegistrationSlipResponse registrationSlipResponse = (RegistrationSlipResponse) resource.getData();
        if (registrationSlipResponse != null) {
            this$0.showBaseView();
            if (registrationSlipResponse.getLogin() && !Intrinsics.areEqual(registrationSlipResponse.getFile_url(), "")) {
                String replace$default = StringsKt.replace$default(registrationSlipResponse.getFile_url(), "\\", "", false, 4, (Object) null);
                System.out.println((Object) replace$default);
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.openPaymentPage(replace$default);
                    return;
                }
                return;
            }
            FragmentExamViewBinding fragmentExamViewBinding2 = this$0.get_binding();
            if (fragmentExamViewBinding2 == null || (rvRegHistory = fragmentExamViewBinding2.rvRegHistory) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvRegHistory, "rvRegHistory");
            ToastExtKt.showErrorToast(rvRegHistory, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentExamViewBinding fragmentExamViewBinding = get_binding();
        if (fragmentExamViewBinding == null || (recyclerView = fragmentExamViewBinding.rvRegHistory) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentExamViewBinding fragmentExamViewBinding = get_binding();
        if (fragmentExamViewBinding == null || (recyclerView = fragmentExamViewBinding.rvRegHistory) == null) {
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