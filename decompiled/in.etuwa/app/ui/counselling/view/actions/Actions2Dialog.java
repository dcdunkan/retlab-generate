package in.etuwa.app.ui.counselling.view.actions;

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
import in.etuwa.app.data.model.counselling.view.Actions2;
import in.etuwa.app.databinding.Actions2DialogBinding;
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

/* compiled from: Actions2Dialog.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020\u0018H\u0014J\b\u0010&\u001a\u00020\u0018H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lin/etuwa/app/ui/counselling/view/actions/Actions2Dialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/Actions2DialogBinding;", "actions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/counselling/view/Actions2;", "Lkotlin/collections/ArrayList;", "actions2DialogViewModel", "Lin/etuwa/app/ui/counselling/view/actions/Actions2DialogViewModel;", "getActions2DialogViewModel", "()Lin/etuwa/app/ui/counselling/view/actions/Actions2DialogViewModel;", "actions2DialogViewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lin/etuwa/app/ui/counselling/view/actions/Actions2Adapter;", "getAdapter", "()Lin/etuwa/app/ui/counselling/view/actions/Actions2Adapter;", "adapter$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/Actions2DialogBinding;", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Actions2Dialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Actions2DialogBinding _binding;
    private ArrayList<Actions2> actions;

    /* renamed from: actions2DialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy actions2DialogViewModel;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    @JvmStatic
    public static final Actions2Dialog newInstance(ArrayList<Actions2> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public Actions2Dialog() {
        final Actions2Dialog actions2Dialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.view.actions.Actions2Dialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(actions2Dialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.actions2DialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(actions2Dialog, Reflection.getOrCreateKotlinClass(Actions2DialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.view.actions.Actions2Dialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.view.actions.Actions2Dialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(Actions2DialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final Actions2Dialog actions2Dialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Actions2Adapter>() { // from class: in.etuwa.app.ui.counselling.view.actions.Actions2Dialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.view.actions.Actions2Adapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Actions2Adapter invoke() {
                ComponentCallbacks componentCallbacks = actions2Dialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(Actions2Adapter.class), b2, b3);
            }
        });
        this.actions = new ArrayList<>();
    }

    private final Actions2DialogViewModel getActions2DialogViewModel() {
        return (Actions2DialogViewModel) this.actions2DialogViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final Actions2DialogBinding get_binding() {
        return this._binding;
    }

    private final Actions2Adapter getAdapter() {
        return (Actions2Adapter) this.adapter.getValue();
    }

    /* compiled from: Actions2Dialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/counselling/view/actions/Actions2Dialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/view/actions/Actions2Dialog;", "actions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/counselling/view/Actions2;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Actions2Dialog newInstance(ArrayList<Actions2> actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            Actions2Dialog actions2Dialog = new Actions2Dialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("actions", actions);
            actions2Dialog.setArguments(bundle);
            return actions2Dialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<Actions2> parcelableArrayList = arguments.getParcelableArrayList("actions");
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
        this._binding = Actions2DialogBinding.inflate(inflater, container, false);
        Actions2DialogBinding actions2DialogBinding = get_binding();
        if (actions2DialogBinding != null) {
            actions2DialogBinding.setActionsDialogViewModel(getActions2DialogViewModel());
        }
        Actions2DialogBinding actions2DialogBinding2 = get_binding();
        if (actions2DialogBinding2 != null) {
            actions2DialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        Actions2DialogBinding actions2DialogBinding3 = get_binding();
        if (actions2DialogBinding3 != null) {
            return actions2DialogBinding3.getRoot();
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
        Actions2DialogBinding actions2DialogBinding = get_binding();
        RecyclerView recyclerView = actions2DialogBinding != null ? actions2DialogBinding.rvActionLevels : null;
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