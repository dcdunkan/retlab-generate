package in.etuwa.app.ui.result.session.semlistdialogsession;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.databinding.SemListDialogSessionBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListAdapterTwo;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: SemListDialogTwo.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002-.B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u001a\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u0010J\b\u0010+\u001a\u00020\u0017H\u0014J\b\u0010,\u001a\u00020\u0017H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006/"}, d2 = {"Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListAdapterTwo$SemCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/SemListDialogSessionBinding;", "adapter", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListAdapterTwo;", "getAdapter", "()Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListAdapterTwo;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SemListDialogSessionBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$SemDialogCallBack;", "semListDialogViewModelTwo", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogViewModelTwo;", "getSemListDialogViewModelTwo", "()Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogViewModelTwo;", "semListDialogViewModelTwo$delegate", "hideProgress", "", "listenSemResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onSemSelected", "id", "", "sem", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "setUp", "showProgress", "Companion", "SemDialogCallBack", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SemListDialogTwo extends BaseDialog implements SemListAdapterTwo.SemCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SemListDialogSessionBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private SemDialogCallBack listener;

    /* renamed from: semListDialogViewModelTwo$delegate, reason: from kotlin metadata */
    private final Lazy semListDialogViewModelTwo;

    /* compiled from: SemListDialogTwo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$SemDialogCallBack;", "", "loadSelectedSem", "", "id", "", "sem", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SemDialogCallBack {
        void loadSelectedSem(String id, String sem);
    }

    /* compiled from: SemListDialogTwo.kt */
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
    public static final SemListDialogTwo newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public SemListDialogTwo() {
        final SemListDialogTwo semListDialogTwo = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(semListDialogTwo);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.semListDialogViewModelTwo = FragmentViewModelLazyKt.createViewModelLazy(semListDialogTwo, Reflection.getOrCreateKotlinClass(SemListDialogViewModelTwo.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SemListDialogViewModelTwo.class), qualifier, b, null, koinScope);
            }
        });
        final SemListDialogTwo semListDialogTwo2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SemListAdapterTwo>() { // from class: in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.session.semlistdialogsession.SemListAdapterTwo, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemListAdapterTwo invoke() {
                ComponentCallbacks componentCallbacks = semListDialogTwo2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemListAdapterTwo.class), b2, b3);
            }
        });
    }

    private final SemListDialogViewModelTwo getSemListDialogViewModelTwo() {
        return (SemListDialogViewModelTwo) this.semListDialogViewModelTwo.getValue();
    }

    private final SemListAdapterTwo getAdapter() {
        return (SemListAdapterTwo) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final SemListDialogSessionBinding get_binding() {
        return this._binding;
    }

    /* compiled from: SemListDialogTwo.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SemListDialogTwo newInstance() {
            return new SemListDialogTwo();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SemListDialogSessionBinding.inflate(inflater, container, false);
        SemListDialogSessionBinding semListDialogSessionBinding = get_binding();
        if (semListDialogSessionBinding != null) {
            semListDialogSessionBinding.setSemListDialogViewModelTwo(getSemListDialogViewModelTwo());
        }
        SemListDialogSessionBinding semListDialogSessionBinding2 = get_binding();
        if (semListDialogSessionBinding2 != null) {
            semListDialogSessionBinding2.setLifecycleOwner(this);
        }
        SemListDialogSessionBinding semListDialogSessionBinding3 = get_binding();
        if (semListDialogSessionBinding3 != null) {
            return semListDialogSessionBinding3.getRoot();
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
        SemListDialogSessionBinding semListDialogSessionBinding = get_binding();
        RecyclerView recyclerView = semListDialogSessionBinding != null ? semListDialogSessionBinding.rvSessionSemList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenSemResponse();
    }

    private final void listenSemResponse() {
        getSemListDialogViewModelTwo().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemListDialogTwo.listenSemResponse$lambda$1(SemListDialogTwo.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$1(SemListDialogTwo this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Semester> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.getAdapter().addItems(arrayList);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        SemListDialogSessionBinding semListDialogSessionBinding = this$0.get_binding();
        if (semListDialogSessionBinding == null || (recyclerView = semListDialogSessionBinding.rvSessionSemList) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.result.session.semlistdialogsession.SemListAdapterTwo.SemCallBack
    public void onSemSelected(String id, String sem) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sem, "sem");
        SemDialogCallBack semDialogCallBack = this.listener;
        if (semDialogCallBack != null) {
            semDialogCallBack.loadSelectedSem(id, sem);
        }
        getAdapter().clearItems();
        dismiss();
    }

    public final void setCallBack(SemDialogCallBack context) {
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
        getAdapter().setCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}