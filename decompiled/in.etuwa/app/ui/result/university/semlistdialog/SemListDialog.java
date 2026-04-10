package in.etuwa.app.ui.result.university.semlistdialog;

import android.content.ComponentCallbacks;
import android.content.Context;
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
import in.etuwa.app.databinding.SemListDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.evaluation.EvaluationFragment;
import in.etuwa.app.ui.questionbank.QuestionBankFragment;
import in.etuwa.app.ui.result.ResultFragment;
import in.etuwa.app.ui.result.university.semlistdialog.SemListAdapter;
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

/* JADX INFO: compiled from: SemListDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SemListDialog extends BaseDialog implements SemListAdapter.SemCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SemListDialogBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private SemDialogCallBack listener;

    /* JADX INFO: renamed from: semListDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy semListDialogViewModel;

    /* JADX INFO: compiled from: SemListDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/result/university/semlistdialog/SemListDialog$SemDialogCallBack;", "", "loadSelectedSem", "", "id", "", "semName", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SemDialogCallBack {
        void loadSelectedSem(String id, String semName);
    }

    /* JADX INFO: compiled from: SemListDialog.kt */
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
    public static final SemListDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public SemListDialog() {
        final SemListDialog semListDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return semListDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(semListDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.semListDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(semListDialog, Reflection.getOrCreateKotlinClass(SemListDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SemListDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SemListDialog semListDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SemListAdapter>() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.result.university.semlistdialog.SemListAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemListAdapter invoke() {
                ComponentCallbacks componentCallbacks = semListDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemListAdapter.class), b2, b3);
            }
        });
    }

    private final SemListDialogViewModel getSemListDialogViewModel() {
        return (SemListDialogViewModel) this.semListDialogViewModel.getValue();
    }

    private final SemListAdapter getAdapter() {
        return (SemListAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final SemListDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: SemListDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/result/university/semlistdialog/SemListDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/university/semlistdialog/SemListDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SemListDialog newInstance() {
            return new SemListDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SemListDialogBinding.inflate(inflater, container, false);
        SemListDialogBinding semListDialogBinding = get_binding();
        if (semListDialogBinding != null) {
            semListDialogBinding.setSemListDialogViewModel(getSemListDialogViewModel());
        }
        SemListDialogBinding semListDialogBinding2 = get_binding();
        if (semListDialogBinding2 != null) {
            semListDialogBinding2.setLifecycleOwner(this);
        }
        SemListDialogBinding semListDialogBinding3 = get_binding();
        if (semListDialogBinding3 != null) {
            return semListDialogBinding3.getRoot();
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
        SemListDialogBinding semListDialogBinding = get_binding();
        RecyclerView recyclerView = semListDialogBinding != null ? semListDialogBinding.rvUnivSemList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenSemResponse();
        SemListDialogViewModel semListDialogViewModel = getSemListDialogViewModel();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        semListDialogViewModel.getSemester(contextRequireContext);
    }

    private final void listenSemResponse() {
        getSemListDialogViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemListDialog.listenSemResponse$lambda$1(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$1(SemListDialog this$0, Resource resource) {
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
        SemListDialogBinding semListDialogBinding = this$0.get_binding();
        if (semListDialogBinding == null || (recyclerView = semListDialogBinding.rvUnivSemList) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListAdapter.SemCallBack
    public void onSemSelected(String id, String semName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        SemDialogCallBack semDialogCallBack = this.listener;
        if (semDialogCallBack != null) {
            semDialogCallBack.loadSelectedSem(id, semName);
        }
        getAdapter().clearItems();
        dismiss();
    }

    public final void setCallBack(SemDialogCallBack context) {
        this.listener = context;
    }

    public final void setCallBack2(ResultFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack3(QuestionBankFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBackEvaluation(EvaluationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
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