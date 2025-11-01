package in.etuwa.app.ui.programoutcome.main;

import android.content.Context;
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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.ProgramOutcomeMainFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import kotlin.Lazy;
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

/* compiled from: ProgramOutcomeMainFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u0011H\u0014J\b\u0010\"\u001a\u00020\u0011H\u0014J\b\u0010#\u001a\u00020\u0011H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lin/etuwa/app/ui/programoutcome/main/ProgramOutcomeMainFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/ProgramOutcomeMainFragmentBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ProgramOutcomeMainFragmentBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "programOutcomeMainViewModel", "Lin/etuwa/app/ui/programoutcome/main/ProgramOutcomeMainViewModel;", "getProgramOutcomeMainViewModel", "()Lin/etuwa/app/ui/programoutcome/main/ProgramOutcomeMainViewModel;", "programOutcomeMainViewModel$delegate", "Lkotlin/Lazy;", "hideBaseView", "", "hideProgress", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProgramOutcomeMainFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ProgramOutcomeMainFragmentBinding _binding;
    private MainCallBackListener listener;

    /* renamed from: programOutcomeMainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy programOutcomeMainViewModel;

    @JvmStatic
    public static final ProgramOutcomeMainFragment newInstance() {
        return INSTANCE.newInstance();
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

    public ProgramOutcomeMainFragment() {
        final ProgramOutcomeMainFragment programOutcomeMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(programOutcomeMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.programOutcomeMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(programOutcomeMainFragment, Reflection.getOrCreateKotlinClass(ProgramOutcomeMainViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ProgramOutcomeMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ProgramOutcomeMainViewModel getProgramOutcomeMainViewModel() {
        return (ProgramOutcomeMainViewModel) this.programOutcomeMainViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ProgramOutcomeMainFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ProgramOutcomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/programoutcome/main/ProgramOutcomeMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/programoutcome/main/ProgramOutcomeMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProgramOutcomeMainFragment newInstance() {
            return new ProgramOutcomeMainFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ProgramOutcomeMainFragmentBinding.inflate(inflater, container, false);
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding = get_binding();
        if (programOutcomeMainFragmentBinding != null) {
            programOutcomeMainFragmentBinding.setProgramOutcomeMainViewModel(getProgramOutcomeMainViewModel());
        }
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding2 = get_binding();
        if (programOutcomeMainFragmentBinding2 != null) {
            programOutcomeMainFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding3 = get_binding();
        if (programOutcomeMainFragmentBinding3 != null) {
            return programOutcomeMainFragmentBinding3.getRoot();
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
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding = get_binding();
        if (programOutcomeMainFragmentBinding != null && (textView3 = programOutcomeMainFragmentBinding.outcomeBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProgramOutcomeMainFragment.setUp$lambda$0(ProgramOutcomeMainFragment.this, view);
                }
            });
        }
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding2 = get_binding();
        if (programOutcomeMainFragmentBinding2 != null && (textView2 = programOutcomeMainFragmentBinding2.educationalBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProgramOutcomeMainFragment.setUp$lambda$1(ProgramOutcomeMainFragment.this, view);
                }
            });
        }
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding3 = get_binding();
        if (programOutcomeMainFragmentBinding3 == null || (textView = programOutcomeMainFragmentBinding3.specificBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgramOutcomeMainFragment.setUp$lambda$2(ProgramOutcomeMainFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ProgramOutcomeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.programOutcomeCells(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ProgramOutcomeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.programOutcomeCells(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ProgramOutcomeMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.programOutcomeCells(2);
        }
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }
}