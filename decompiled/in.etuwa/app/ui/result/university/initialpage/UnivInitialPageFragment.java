package in.etuwa.app.ui.result.university.initialpage;

import android.content.ComponentCallbacks;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.result.univ.UnivDetails;
import in.etuwa.app.data.model.result.univ.UnivSubjects;
import in.etuwa.app.databinding.UnivInitialPageFragmentBinding;
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
import org.bouncycastle.i18n.ErrorBundle;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: UnivInitialPageFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u001a\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010(\u001a\u00020\u001aH\u0014J\b\u0010)\u001a\u00020\u001aH\u0014J\b\u0010*\u001a\u00020\u001aH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/UnivInitialPageFragmentBinding;", "adapter", "Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageAdapter;", "getAdapter", "()Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/UnivInitialPageFragmentBinding;", ErrorBundle.DETAIL_ENTRY, "Lin/etuwa/app/data/model/result/univ/UnivDetails;", "subject", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivSubjects;", "Lkotlin/collections/ArrayList;", "univInitialPageViewModel", "Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageViewModel;", "getUnivInitialPageViewModel", "()Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageViewModel;", "univInitialPageViewModel$delegate", "hideBaseView", "", "hideProgress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnivInitialPageFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UnivInitialPageFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private UnivDetails details;
    private ArrayList<UnivSubjects> subject;

    /* renamed from: univInitialPageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy univInitialPageViewModel;

    @JvmStatic
    public static final UnivInitialPageFragment newInstance(UnivDetails univDetails, ArrayList<UnivSubjects> arrayList) {
        return INSTANCE.newInstance(univDetails, arrayList);
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

    public UnivInitialPageFragment() {
        final UnivInitialPageFragment univInitialPageFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.university.initialpage.UnivInitialPageFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(univInitialPageFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.univInitialPageViewModel = FragmentViewModelLazyKt.createViewModelLazy(univInitialPageFragment, Reflection.getOrCreateKotlinClass(UnivInitialPageViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.university.initialpage.UnivInitialPageFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.university.initialpage.UnivInitialPageFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(UnivInitialPageViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final UnivInitialPageFragment univInitialPageFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UnivInitialPageAdapter>() { // from class: in.etuwa.app.ui.result.university.initialpage.UnivInitialPageFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.university.initialpage.UnivInitialPageAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final UnivInitialPageAdapter invoke() {
                ComponentCallbacks componentCallbacks = univInitialPageFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UnivInitialPageAdapter.class), b2, b3);
            }
        });
    }

    private final UnivInitialPageViewModel getUnivInitialPageViewModel() {
        return (UnivInitialPageViewModel) this.univInitialPageViewModel.getValue();
    }

    private final UnivInitialPageAdapter getAdapter() {
        return (UnivInitialPageAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final UnivInitialPageFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: UnivInitialPageFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageFragment;", ErrorBundle.DETAIL_ENTRY, "Lin/etuwa/app/data/model/result/univ/UnivDetails;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivSubjects;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UnivInitialPageFragment newInstance(UnivDetails details, ArrayList<UnivSubjects> subjects) {
            Intrinsics.checkNotNullParameter(subjects, "subjects");
            UnivInitialPageFragment univInitialPageFragment = new UnivInitialPageFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ErrorBundle.DETAIL_ENTRY, details);
            bundle.putParcelableArrayList("subjects", subjects);
            univInitialPageFragment.setArguments(bundle);
            return univInitialPageFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.details = (UnivDetails) arguments.getParcelable(ErrorBundle.DETAIL_ENTRY);
            this.subject = arguments.getParcelableArrayList("subjects");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = UnivInitialPageFragmentBinding.inflate(inflater, container, false);
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding = get_binding();
        if (univInitialPageFragmentBinding != null) {
            univInitialPageFragmentBinding.setUnivInitialPageViewModel(getUnivInitialPageViewModel());
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding2 = get_binding();
        if (univInitialPageFragmentBinding2 != null) {
            univInitialPageFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding3 = get_binding();
        if (univInitialPageFragmentBinding3 != null) {
            return univInitialPageFragmentBinding3.getRoot();
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
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding = get_binding();
        RecyclerView recyclerView = univInitialPageFragmentBinding != null ? univInitialPageFragmentBinding.rvUnivSubjects : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        UnivInitialPageAdapter adapter = getAdapter();
        ArrayList<UnivSubjects> arrayList = this.subject;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        adapter.addItems(arrayList);
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding2 = get_binding();
        TextView textView4 = univInitialPageFragmentBinding2 != null ? univInitialPageFragmentBinding2.credits : null;
        if (textView4 != null) {
            UnivDetails univDetails = this.details;
            textView4.setText(univDetails != null ? univDetails.getCredit() : null);
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding3 = get_binding();
        TextView textView5 = univInitialPageFragmentBinding3 != null ? univInitialPageFragmentBinding3.internalMark : null;
        if (textView5 != null) {
            UnivDetails univDetails2 = this.details;
            textView5.setText(univDetails2 != null ? univDetails2.getTotalInternal() : null);
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding4 = get_binding();
        TextView textView6 = univInitialPageFragmentBinding4 != null ? univInitialPageFragmentBinding4.sgpa : null;
        if (textView6 != null) {
            UnivDetails univDetails3 = this.details;
            textView6.setText(univDetails3 != null ? univDetails3.getSgpa() : null);
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding5 = get_binding();
        TextView textView7 = univInitialPageFragmentBinding5 != null ? univInitialPageFragmentBinding5.cgpa : null;
        if (textView7 != null) {
            UnivDetails univDetails4 = this.details;
            textView7.setText(univDetails4 != null ? univDetails4.getCgpa() : null);
        }
        UnivDetails univDetails5 = this.details;
        String passStatus = univDetails5 != null ? univDetails5.getPassStatus() : null;
        if (Intrinsics.areEqual(passStatus, "PASSED")) {
            UnivInitialPageFragmentBinding univInitialPageFragmentBinding6 = get_binding();
            if (univInitialPageFragmentBinding6 != null && (textView3 = univInitialPageFragmentBinding6.resultStatus) != null) {
                textView3.setBackgroundColor(Color.parseColor("#266d19"));
            }
            UnivInitialPageFragmentBinding univInitialPageFragmentBinding7 = get_binding();
            TextView textView8 = univInitialPageFragmentBinding7 != null ? univInitialPageFragmentBinding7.resultStatus : null;
            if (textView8 == null) {
                return;
            }
            UnivDetails univDetails6 = this.details;
            textView8.setText(univDetails6 != null ? univDetails6.getPassStatus() : null);
            return;
        }
        if (Intrinsics.areEqual(passStatus, "FAILED")) {
            UnivInitialPageFragmentBinding univInitialPageFragmentBinding8 = get_binding();
            if (univInitialPageFragmentBinding8 != null && (textView2 = univInitialPageFragmentBinding8.resultStatus) != null) {
                textView2.setBackgroundColor(Color.parseColor("#E10000"));
            }
            UnivInitialPageFragmentBinding univInitialPageFragmentBinding9 = get_binding();
            TextView textView9 = univInitialPageFragmentBinding9 != null ? univInitialPageFragmentBinding9.resultStatus : null;
            if (textView9 == null) {
                return;
            }
            UnivDetails univDetails7 = this.details;
            textView9.setText(univDetails7 != null ? univDetails7.getPassStatus() : null);
            return;
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding10 = get_binding();
        if (univInitialPageFragmentBinding10 != null && (textView = univInitialPageFragmentBinding10.resultStatus) != null) {
            textView.setBackgroundColor(Color.parseColor("#808080"));
        }
        UnivInitialPageFragmentBinding univInitialPageFragmentBinding11 = get_binding();
        TextView textView10 = univInitialPageFragmentBinding11 != null ? univInitialPageFragmentBinding11.resultStatus : null;
        if (textView10 == null) {
            return;
        }
        textView10.setText("N/A");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}