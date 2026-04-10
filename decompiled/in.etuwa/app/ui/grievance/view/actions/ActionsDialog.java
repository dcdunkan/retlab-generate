package in.etuwa.app.ui.grievance.view.actions;

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
import in.etuwa.app.data.model.grievance.view.Actions;
import in.etuwa.app.databinding.ActionsDialogBinding;
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

/* JADX INFO: compiled from: ActionsDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ActionsDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ActionsDialogBinding _binding;
    private ArrayList<Actions> actions;

    /* JADX INFO: renamed from: actionsDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy actionsDialogViewModel;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    @JvmStatic
    public static final ActionsDialog newInstance(ArrayList<Actions> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ActionsDialog() {
        final ActionsDialog actionsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.grievance.view.actions.ActionsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return actionsDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(actionsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.actionsDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(actionsDialog, Reflection.getOrCreateKotlinClass(ActionsDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.grievance.view.actions.ActionsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.grievance.view.actions.ActionsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ActionsDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ActionsDialog actionsDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ActionsAdapter>() { // from class: in.etuwa.app.ui.grievance.view.actions.ActionsDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.grievance.view.actions.ActionsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ActionsAdapter invoke() {
                ComponentCallbacks componentCallbacks = actionsDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ActionsAdapter.class), b2, b3);
            }
        });
        this.actions = new ArrayList<>();
    }

    private final ActionsDialogViewModel getActionsDialogViewModel() {
        return (ActionsDialogViewModel) this.actionsDialogViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final ActionsDialogBinding get_binding() {
        return this._binding;
    }

    private final ActionsAdapter getAdapter() {
        return (ActionsAdapter) this.adapter.getValue();
    }

    /* JADX INFO: compiled from: ActionsDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/grievance/view/actions/ActionsDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/grievance/view/actions/ActionsDialog;", "actions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/grievance/view/Actions;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ActionsDialog newInstance(ArrayList<Actions> actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            ActionsDialog actionsDialog = new ActionsDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("actions", actions);
            actionsDialog.setArguments(bundle);
            return actionsDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<Actions> parcelableArrayList = arguments.getParcelableArrayList("actions");
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            } else {
                Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "it.getParcelableArrayLis…RG_ACTIONS)?: ArrayList()");
            }
            this.actions = parcelableArrayList;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ActionsDialogBinding.inflate(inflater, container, false);
        ActionsDialogBinding actionsDialogBinding = get_binding();
        if (actionsDialogBinding != null) {
            actionsDialogBinding.setActionsDialogViewModel(getActionsDialogViewModel());
        }
        ActionsDialogBinding actionsDialogBinding2 = get_binding();
        if (actionsDialogBinding2 != null) {
            actionsDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ActionsDialogBinding actionsDialogBinding3 = get_binding();
        if (actionsDialogBinding3 != null) {
            return actionsDialogBinding3.getRoot();
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
        ActionsDialogBinding actionsDialogBinding = get_binding();
        RecyclerView recyclerView = actionsDialogBinding != null ? actionsDialogBinding.rvActionLevels : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().addItems(this.actions);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}