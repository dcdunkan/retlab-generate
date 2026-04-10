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

/* JADX INFO: compiled from: ProgramOutcomeMainFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ProgramOutcomeMainFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ProgramOutcomeMainFragmentBinding _binding;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: programOutcomeMainViewModel$delegate, reason: from kotlin metadata */
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
                return programOutcomeMainFragment;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ProgramOutcomeMainViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ProgramOutcomeMainViewModel getProgramOutcomeMainViewModel() {
        return (ProgramOutcomeMainViewModel) this.programOutcomeMainViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final ProgramOutcomeMainFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: ProgramOutcomeMainFragment.kt */
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
                    ProgramOutcomeMainFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        ProgramOutcomeMainFragmentBinding programOutcomeMainFragmentBinding2 = get_binding();
        if (programOutcomeMainFragmentBinding2 != null && (textView2 = programOutcomeMainFragmentBinding2.educationalBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProgramOutcomeMainFragment.setUp$lambda$1(this.f$0, view);
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
                ProgramOutcomeMainFragment.setUp$lambda$2(this.f$0, view);
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