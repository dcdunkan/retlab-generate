package in.etuwa.app.ui.grievance.view.cellmembers;

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
import in.etuwa.app.databinding.CellMemberDialogBinding;
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

/* JADX INFO: compiled from: CellMemberDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class CellMemberDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CellMemberDialogBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: cellMemberDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cellMemberDialogViewModel;
    private ArrayList<String> cellMembers;

    @JvmStatic
    public static final CellMemberDialog newInstance(ArrayList<String> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public CellMemberDialog() {
        final CellMemberDialog cellMemberDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return cellMemberDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(cellMemberDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.cellMemberDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(cellMemberDialog, Reflection.getOrCreateKotlinClass(CellMemberDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialog$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(CellMemberDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CellMemberDialog cellMemberDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CellMemberAdapter>() { // from class: in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.grievance.view.cellmembers.CellMemberAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CellMemberAdapter invoke() {
                ComponentCallbacks componentCallbacks = cellMemberDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CellMemberAdapter.class), b2, b3);
            }
        });
        this.cellMembers = new ArrayList<>();
    }

    private final CellMemberDialogViewModel getCellMemberDialogViewModel() {
        return (CellMemberDialogViewModel) this.cellMemberDialogViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final CellMemberDialogBinding get_binding() {
        return this._binding;
    }

    private final CellMemberAdapter getAdapter() {
        return (CellMemberAdapter) this.adapter.getValue();
    }

    /* JADX INFO: compiled from: CellMemberDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/grievance/view/cellmembers/CellMemberDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/grievance/view/cellmembers/CellMemberDialog;", "cellMembers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CellMemberDialog newInstance(ArrayList<String> cellMembers) {
            Intrinsics.checkNotNullParameter(cellMembers, "cellMembers");
            CellMemberDialog cellMemberDialog = new CellMemberDialog();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("cell", cellMembers);
            cellMemberDialog.setArguments(bundle);
            return cellMemberDialog;
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
        this._binding = CellMemberDialogBinding.inflate(inflater, container, false);
        CellMemberDialogBinding cellMemberDialogBinding = get_binding();
        if (cellMemberDialogBinding != null) {
            cellMemberDialogBinding.setCellMemberDialogViewModel(getCellMemberDialogViewModel());
        }
        CellMemberDialogBinding cellMemberDialogBinding2 = get_binding();
        if (cellMemberDialogBinding2 != null) {
            cellMemberDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CellMemberDialogBinding cellMemberDialogBinding3 = get_binding();
        if (cellMemberDialogBinding3 != null) {
            return cellMemberDialogBinding3.getRoot();
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
        CellMemberDialogBinding cellMemberDialogBinding = get_binding();
        RecyclerView recyclerView = cellMemberDialogBinding != null ? cellMemberDialogBinding.rvCellMembers : null;
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