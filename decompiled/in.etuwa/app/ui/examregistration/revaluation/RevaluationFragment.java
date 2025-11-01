package in.etuwa.app.ui.examregistration.revaluation;

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
import in.etuwa.app.data.model.examregister.Revaluation;
import in.etuwa.app.data.model.examregister.RevaluationResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentRevaluationBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter;
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

/* compiled from: RevaluationFragment.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\u0005¢\u0006\u0002\u0010\u0003J\b\u00106\u001a\u000207H\u0014J\b\u00108\u001a\u000207H\u0014J\b\u00109\u001a\u000207H\u0002J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010=\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010F\u001a\u000207H\u0016J\u001a\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020A2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010I\u001a\u000207H\u0014J\b\u0010J\u001a\u000207H\u0014J\b\u0010K\u001a\u000207H\u0014J$\u0010L\u001a\u0002072\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R \u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b3\u00104¨\u0006P"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/RevaluationFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/examregistration/revaluation/RevaluationAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentRevaluationBinding;", "adapter", "Lin/etuwa/app/ui/examregistration/revaluation/RevaluationAdapter;", "getAdapter", "()Lin/etuwa/app/ui/examregistration/revaluation/RevaluationAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "answerSheetPosition", "", "", "getAnswerSheetPosition", "()Ljava/util/List;", "setAnswerSheetPosition", "(Ljava/util/List;)V", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getArrayList", "()Ljava/util/ArrayList;", "setArrayList", "(Ljava/util/ArrayList;)V", "arrayList2", "getArrayList2", "setArrayList2", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentRevaluationBinding;", "flag", "", "Ljava/lang/Boolean;", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "revaluationPosition", "getRevaluationPosition", "setRevaluationPosition", "revaluationPosition2", "getRevaluationPosition2", "setRevaluationPosition2", "revaluationViewModel", "Lin/etuwa/app/ui/examregistration/revaluation/RevaluationViewModel;", "getRevaluationViewModel", "()Lin/etuwa/app/ui/examregistration/revaluation/RevaluationViewModel;", "revaluationViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "updateSelected", "revaluationSel", "answerSheetSel", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RevaluationFragment extends BaseFragment implements RevaluationAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentRevaluationBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private List<String> answerSheetPosition;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayList2;
    private Boolean flag;
    private String id;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> revaluationPosition;
    private List<String> revaluationPosition2;

    /* renamed from: revaluationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy revaluationViewModel;

    /* compiled from: RevaluationFragment.kt */
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
    public static final RevaluationFragment newInstance(String str, boolean z) {
        return INSTANCE.newInstance(str, z);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public RevaluationFragment() {
        final RevaluationFragment revaluationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(revaluationFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.revaluationViewModel = FragmentViewModelLazyKt.createViewModelLazy(revaluationFragment, Reflection.getOrCreateKotlinClass(RevaluationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(RevaluationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final RevaluationFragment revaluationFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RevaluationAdapter>() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final RevaluationAdapter invoke() {
                ComponentCallbacks componentCallbacks = revaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(RevaluationAdapter.class), b2, b3);
            }
        });
        this.revaluationPosition = new ArrayList();
        this.revaluationPosition2 = new ArrayList();
        this.answerSheetPosition = new ArrayList();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = revaluationFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final RevaluationViewModel getRevaluationViewModel() {
        return (RevaluationViewModel) this.revaluationViewModel.getValue();
    }

    private final RevaluationAdapter getAdapter() {
        return (RevaluationAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentRevaluationBinding get_binding() {
        return this._binding;
    }

    public final List<String> getRevaluationPosition() {
        return this.revaluationPosition;
    }

    public final void setRevaluationPosition(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.revaluationPosition = list;
    }

    public final List<String> getRevaluationPosition2() {
        return this.revaluationPosition2;
    }

    public final void setRevaluationPosition2(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.revaluationPosition2 = list;
    }

    public final List<String> getAnswerSheetPosition() {
        return this.answerSheetPosition;
    }

    public final void setAnswerSheetPosition(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.answerSheetPosition = list;
    }

    public final ArrayList<String> getArrayList() {
        return this.arrayList;
    }

    public final void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public final ArrayList<String> getArrayList2() {
        return this.arrayList2;
    }

    public final void setArrayList2(ArrayList<String> arrayList) {
        this.arrayList2 = arrayList;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: RevaluationFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/RevaluationFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/revaluation/RevaluationFragment;", "id", "", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RevaluationFragment newInstance(String id, boolean flag) {
            Intrinsics.checkNotNullParameter(id, "id");
            RevaluationFragment revaluationFragment = new RevaluationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("flag", flag);
            revaluationFragment.setArguments(bundle);
            return revaluationFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.flag = Boolean.valueOf(arguments.getBoolean("flag"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentRevaluationBinding.inflate(inflater, container, false);
        FragmentRevaluationBinding fragmentRevaluationBinding = get_binding();
        if (fragmentRevaluationBinding != null) {
            fragmentRevaluationBinding.setRevaluationViewModel(getRevaluationViewModel());
        }
        FragmentRevaluationBinding fragmentRevaluationBinding2 = get_binding();
        if (fragmentRevaluationBinding2 != null) {
            fragmentRevaluationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentRevaluationBinding fragmentRevaluationBinding3 = get_binding();
        if (fragmentRevaluationBinding3 != null) {
            return fragmentRevaluationBinding3.getRoot();
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
        getPreference().setNewLogin(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Apply Revaluation");
        }
        hideBaseView();
        FragmentRevaluationBinding fragmentRevaluationBinding = get_binding();
        RecyclerView recyclerView = fragmentRevaluationBinding != null ? fragmentRevaluationBinding.rvExamRevaluation : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        RevaluationViewModel revaluationViewModel = getRevaluationViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        revaluationViewModel.getExamData(str);
        FragmentRevaluationBinding fragmentRevaluationBinding2 = get_binding();
        if (fragmentRevaluationBinding2 == null || (textView = fragmentRevaluationBinding2.payNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RevaluationFragment.setUp$lambda$1(RevaluationFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(RevaluationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<String> arrayList = this$0.arrayList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<String> arrayList2 = this$0.arrayList2;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this$0.arrayList = new ArrayList<>(this$0.revaluationPosition);
        this$0.arrayList2 = new ArrayList<>(this$0.answerSheetPosition);
        System.out.println(this$0.arrayList);
        System.out.println(this$0.arrayList2);
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            ArrayList<String> arrayList3 = this$0.arrayList;
            Intrinsics.checkNotNull(arrayList3);
            ArrayList<String> arrayList4 = this$0.arrayList2;
            Intrinsics.checkNotNull(arrayList4);
            mainCallBackListener.showRevaluationFee(arrayList3, arrayList4, true);
        }
    }

    private final void listenResponse() {
        getRevaluationViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.examregistration.revaluation.RevaluationFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RevaluationFragment.listenResponse$lambda$3(RevaluationFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlin.Unit] */
    public static final void listenResponse$lambda$3(RevaluationFragment this$0, Resource resource) {
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
            FragmentRevaluationBinding fragmentRevaluationBinding = this$0.get_binding();
            if (fragmentRevaluationBinding == null || (recyclerView = fragmentRevaluationBinding.rvExamRevaluation) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        RevaluationResponse revaluationResponse = (RevaluationResponse) resource.getData();
        if (revaluationResponse != null) {
            this$0.showBaseView();
            try {
                if (revaluationResponse.getRevaluation().size() > 0) {
                    RevaluationAdapter adapter = this$0.getAdapter();
                    ArrayList<Revaluation> revaluation = revaluationResponse.getRevaluation();
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    adapter.addItems(revaluation, requireContext);
                    this$0 = Unit.INSTANCE;
                } else {
                    FragmentRevaluationBinding fragmentRevaluationBinding2 = this$0.get_binding();
                    this$0 = this$0;
                    if (fragmentRevaluationBinding2 != null) {
                        RecyclerView rvExamRevaluation2 = fragmentRevaluationBinding2.rvExamRevaluation;
                        this$0 = this$0;
                        if (rvExamRevaluation2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rvExamRevaluation2, "rvExamRevaluation");
                            ToastExtKt.showErrorToast(rvExamRevaluation2, "No Data Found");
                            this$0 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                FragmentRevaluationBinding fragmentRevaluationBinding3 = this$0.get_binding();
                if (fragmentRevaluationBinding3 == null || (rvExamRevaluation = fragmentRevaluationBinding3.rvExamRevaluation) == null) {
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
        FragmentRevaluationBinding fragmentRevaluationBinding = get_binding();
        if (fragmentRevaluationBinding == null || (recyclerView = fragmentRevaluationBinding.rvExamRevaluation) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentRevaluationBinding fragmentRevaluationBinding = get_binding();
        if (fragmentRevaluationBinding == null || (recyclerView = fragmentRevaluationBinding.rvExamRevaluation) == null) {
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

    @Override // in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter.CallBack
    public void updateSelected(List<String> revaluationSel, List<String> answerSheetSel) {
        Intrinsics.checkNotNullParameter(revaluationSel, "revaluationSel");
        Intrinsics.checkNotNullParameter(answerSheetSel, "answerSheetSel");
        this.answerSheetPosition.clear();
        this.revaluationPosition.clear();
        this.answerSheetPosition.addAll(answerSheetSel);
        this.revaluationPosition.addAll(revaluationSel);
    }
}