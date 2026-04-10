package in.etuwa.app.ui.timetable.tableview;

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
import in.etuwa.app.data.model.timetable.TimeTable;
import in.etuwa.app.databinding.TimtableViewFragmentBinding;
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

/* compiled from: TimetableViewFragment.kt */
/* loaded from: classes5.dex */
public final class TimetableViewFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private TimtableViewFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<TimeTable> tables;

    /* renamed from: timetableViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy timetableViewViewModel;

    @JvmStatic
    public static final TimetableViewFragment newInstance(ArrayList<TimeTable> arrayList) {
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

    public TimetableViewFragment() {
        final TimetableViewFragment timetableViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.timetable.tableview.TimetableViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(timetableViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.timetableViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(timetableViewFragment, Reflection.getOrCreateKotlinClass(TimetableViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.timetable.tableview.TimetableViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.timetable.tableview.TimetableViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TimetableViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TimetableViewFragment timetableViewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TimetableViewAdapter>() { // from class: in.etuwa.app.ui.timetable.tableview.TimetableViewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.timetable.tableview.TimetableViewAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TimetableViewAdapter invoke() {
                ComponentCallbacks componentCallbacks = timetableViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TimetableViewAdapter.class), b2, b3);
            }
        });
    }

    private final TimetableViewViewModel getTimetableViewViewModel() {
        return (TimetableViewViewModel) this.timetableViewViewModel.getValue();
    }

    private final TimetableViewAdapter getAdapter() {
        return (TimetableViewAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final TimtableViewFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: TimetableViewFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/timetable/tableview/TimetableViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/timetable/tableview/TimetableViewFragment;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/timetable/TimeTable;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TimetableViewFragment newInstance(ArrayList<TimeTable> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            TimetableViewFragment timetableViewFragment = new TimetableViewFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("timetable", list);
            timetableViewFragment.setArguments(bundle);
            return timetableViewFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.tables = arguments.getParcelableArrayList("timetable");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TimtableViewFragmentBinding.inflate(inflater, container, false);
        TimtableViewFragmentBinding timtableViewFragmentBinding = get_binding();
        if (timtableViewFragmentBinding != null) {
            timtableViewFragmentBinding.setTimetableViewViewModel(getTimetableViewViewModel());
        }
        TimtableViewFragmentBinding timtableViewFragmentBinding2 = get_binding();
        if (timtableViewFragmentBinding2 != null) {
            timtableViewFragmentBinding2.setLifecycleOwner(this);
        }
        TimtableViewFragmentBinding timtableViewFragmentBinding3 = get_binding();
        if (timtableViewFragmentBinding3 != null) {
            return timtableViewFragmentBinding3.getRoot();
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
        TimtableViewFragmentBinding timtableViewFragmentBinding = get_binding();
        RecyclerView recyclerView = timtableViewFragmentBinding != null ? timtableViewFragmentBinding.rvTimetable : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        TimetableViewAdapter adapter = getAdapter();
        ArrayList<TimeTable> arrayList = this.tables;
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