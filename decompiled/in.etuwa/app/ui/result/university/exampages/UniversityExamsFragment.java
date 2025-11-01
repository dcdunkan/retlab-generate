package in.etuwa.app.ui.result.university.exampages;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.result.univ.UnivExamSubjects;
import in.etuwa.app.databinding.UniversityExamsFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import java.util.ArrayList;
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

/* compiled from: UniversityExamsFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010'\u001a\u00020\u001cH\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010*\u001a\u00020\u001cH\u0014J\b\u0010+\u001a\u00020\u001cH\u0014J\b\u0010,\u001a\u00020\u001cH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lin/etuwa/app/ui/result/university/exampages/UniversityExamsFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/UniversityExamsFragmentBinding;", "adapter", "Lin/etuwa/app/ui/result/university/exampages/UniversityExamAdapter;", "getAdapter", "()Lin/etuwa/app/ui/result/university/exampages/UniversityExamAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/UniversityExamsFragmentBinding;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivExamSubjects;", "Lkotlin/collections/ArrayList;", "getSubjects", "()Ljava/util/ArrayList;", "setSubjects", "(Ljava/util/ArrayList;)V", "universityExamsViewModel", "Lin/etuwa/app/ui/result/university/exampages/UniversityExamsViewModel;", "getUniversityExamsViewModel", "()Lin/etuwa/app/ui/result/university/exampages/UniversityExamsViewModel;", "universityExamsViewModel$delegate", "hideBaseView", "", "hideProgress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniversityExamsFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UniversityExamsFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<UnivExamSubjects> subjects;

    /* renamed from: universityExamsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy universityExamsViewModel;

    @JvmStatic
    public static final UniversityExamsFragment newInstance(ArrayList<UnivExamSubjects> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public UniversityExamsFragment() {
        final UniversityExamsFragment universityExamsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.university.exampages.UniversityExamsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(universityExamsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.universityExamsViewModel = FragmentViewModelLazyKt.createViewModelLazy(universityExamsFragment, Reflection.getOrCreateKotlinClass(UniversityExamsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.university.exampages.UniversityExamsFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.university.exampages.UniversityExamsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(UniversityExamsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final UniversityExamsFragment universityExamsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UniversityExamAdapter>() { // from class: in.etuwa.app.ui.result.university.exampages.UniversityExamsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.university.exampages.UniversityExamAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final UniversityExamAdapter invoke() {
                ComponentCallbacks componentCallbacks = universityExamsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UniversityExamAdapter.class), b2, b3);
            }
        });
    }

    private final UniversityExamsViewModel getUniversityExamsViewModel() {
        return (UniversityExamsViewModel) this.universityExamsViewModel.getValue();
    }

    private final UniversityExamAdapter getAdapter() {
        return (UniversityExamAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final UniversityExamsFragmentBinding get_binding() {
        return this._binding;
    }

    public final ArrayList<UnivExamSubjects> getSubjects() {
        return this.subjects;
    }

    public final void setSubjects(ArrayList<UnivExamSubjects> arrayList) {
        this.subjects = arrayList;
    }

    /* compiled from: UniversityExamsFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/result/university/exampages/UniversityExamsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/university/exampages/UniversityExamsFragment;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivExamSubjects;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UniversityExamsFragment newInstance(ArrayList<UnivExamSubjects> subjects) {
            Intrinsics.checkNotNullParameter(subjects, "subjects");
            UniversityExamsFragment universityExamsFragment = new UniversityExamsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("sub", subjects);
            universityExamsFragment.setArguments(bundle);
            return universityExamsFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subjects = arguments.getParcelableArrayList("sub");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = UniversityExamsFragmentBinding.inflate(inflater, container, false);
        UniversityExamsFragmentBinding universityExamsFragmentBinding = get_binding();
        if (universityExamsFragmentBinding != null) {
            universityExamsFragmentBinding.setUniversityExamsViewModel(getUniversityExamsViewModel());
        }
        UniversityExamsFragmentBinding universityExamsFragmentBinding2 = get_binding();
        if (universityExamsFragmentBinding2 != null) {
            universityExamsFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        UniversityExamsFragmentBinding universityExamsFragmentBinding3 = get_binding();
        if (universityExamsFragmentBinding3 != null) {
            return universityExamsFragmentBinding3.getRoot();
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
        UniversityExamsFragmentBinding universityExamsFragmentBinding = get_binding();
        RecyclerView recyclerView = universityExamsFragmentBinding != null ? universityExamsFragmentBinding.rvUnivExams : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().clearItems();
        UniversityExamAdapter adapter = getAdapter();
        ArrayList<UnivExamSubjects> arrayList = this.subjects;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        adapter.addItems(arrayList);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}