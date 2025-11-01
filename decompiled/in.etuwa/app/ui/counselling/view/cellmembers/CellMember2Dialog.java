package in.etuwa.app.ui.counselling.view.cellmembers;

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
import in.etuwa.app.databinding.CellMember2DialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
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

/* compiled from: CellMember2Dialog.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020\u0018H\u0014J\b\u0010&\u001a\u00020\u0018H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2Dialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/CellMember2DialogBinding;", "adapter", "Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2Adapter;", "getAdapter", "()Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2Adapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/CellMember2DialogBinding;", "cellMember2DialogViewModel", "Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2DialogViewModel;", "getCellMember2DialogViewModel", "()Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2DialogViewModel;", "cellMember2DialogViewModel$delegate", "cellMembers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CellMember2Dialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CellMember2DialogBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: cellMember2DialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cellMember2DialogViewModel;
    private ArrayList<String> cellMembers;

    @JvmStatic
    public static final CellMember2Dialog newInstance(ArrayList<String> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public CellMember2Dialog() {
        final CellMember2Dialog cellMember2Dialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.view.cellmembers.CellMember2Dialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(cellMember2Dialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.cellMember2DialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(cellMember2Dialog, Reflection.getOrCreateKotlinClass(CellMember2DialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.view.cellmembers.CellMember2Dialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.view.cellmembers.CellMember2Dialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(CellMember2DialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CellMember2Dialog cellMember2Dialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CellMember2Adapter>() { // from class: in.etuwa.app.ui.counselling.view.cellmembers.CellMember2Dialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.view.cellmembers.CellMember2Adapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CellMember2Adapter invoke() {
                ComponentCallbacks componentCallbacks = cellMember2Dialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CellMember2Adapter.class), b2, b3);
            }
        });
        this.cellMembers = new ArrayList<>();
    }

    private final CellMember2DialogViewModel getCellMember2DialogViewModel() {
        return (CellMember2DialogViewModel) this.cellMember2DialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final CellMember2DialogBinding get_binding() {
        return this._binding;
    }

    private final CellMember2Adapter getAdapter() {
        return (CellMember2Adapter) this.adapter.getValue();
    }

    /* compiled from: CellMember2Dialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2Dialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/view/cellmembers/CellMember2Dialog;", "cellMembers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CellMember2Dialog newInstance(ArrayList<String> cellMembers) {
            Intrinsics.checkNotNullParameter(cellMembers, "cellMembers");
            CellMember2Dialog cellMember2Dialog = new CellMember2Dialog();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("cell", cellMembers);
            cellMember2Dialog.setArguments(bundle);
            return cellMember2Dialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<String> stringArrayList = arguments.getStringArrayList("cell");
            if (stringArrayList == null) {
                stringArrayList = new ArrayList<>();
            } else {
                Intrinsics.checkNotNullExpressionValue(stringArrayList, "it.getStringArrayList(AR…LL_MEMBERS)?: ArrayList()");
            }
            this.cellMembers = stringArrayList;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CellMember2DialogBinding.inflate(inflater, container, false);
        CellMember2DialogBinding cellMember2DialogBinding = get_binding();
        if (cellMember2DialogBinding != null) {
            cellMember2DialogBinding.setCellMember2DialogViewModel(getCellMember2DialogViewModel());
        }
        CellMember2DialogBinding cellMember2DialogBinding2 = get_binding();
        if (cellMember2DialogBinding2 != null) {
            cellMember2DialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CellMember2DialogBinding cellMember2DialogBinding3 = get_binding();
        if (cellMember2DialogBinding3 != null) {
            return cellMember2DialogBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        CellMember2DialogBinding cellMember2DialogBinding = get_binding();
        RecyclerView recyclerView = cellMember2DialogBinding != null ? cellMember2DialogBinding.rvCellMembers : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().addItems(this.cellMembers);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}