package in.etuwa.app.ui.examregistration;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentExamRegistrationMainBinding;
import in.etuwa.app.helper.MainCallBackListener;
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

/* compiled from: ExamRegistrationMainFragment.kt */
/* loaded from: classes4.dex */
public final class ExamRegistrationMainFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentExamRegistrationMainBinding _binding;

    /* renamed from: examRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy examRegistrationViewModel;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final ExamRegistrationMainFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public ExamRegistrationMainFragment() {
        final ExamRegistrationMainFragment examRegistrationMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(examRegistrationMainFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.examRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(examRegistrationMainFragment, Reflection.getOrCreateKotlinClass(ExamRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ExamRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ExamRegistrationMainFragment examRegistrationMainFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = examRegistrationMainFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final ExamRegistrationViewModel getExamRegistrationViewModel() {
        return (ExamRegistrationViewModel) this.examRegistrationViewModel.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ExamRegistrationMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/examregistration/ExamRegistrationMainFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/ExamRegistrationMainFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExamRegistrationMainFragment newInstance() {
            return new ExamRegistrationMainFragment();
        }
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentExamRegistrationMainBinding get_binding() {
        return this._binding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentExamRegistrationMainBinding.inflate(inflater, container, false);
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding = get_binding();
        if (fragmentExamRegistrationMainBinding != null) {
            fragmentExamRegistrationMainBinding.setExamRegistrationViewModel(getExamRegistrationViewModel());
        }
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding2 = get_binding();
        if (fragmentExamRegistrationMainBinding2 != null) {
            fragmentExamRegistrationMainBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding3 = get_binding();
        if (fragmentExamRegistrationMainBinding3 != null) {
            return fragmentExamRegistrationMainBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getPreference().setNewLogin(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("University Exam");
        }
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding = get_binding();
        if (fragmentExamRegistrationMainBinding != null && (linearLayout4 = fragmentExamRegistrationMainBinding.regLyt) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ExamRegistrationMainFragment.onViewCreated$lambda$0(ExamRegistrationMainFragment.this, view2);
                }
            });
        }
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding2 = get_binding();
        if (fragmentExamRegistrationMainBinding2 != null && (linearLayout3 = fragmentExamRegistrationMainBinding2.feeReceiptLyt) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ExamRegistrationMainFragment.onViewCreated$lambda$1(ExamRegistrationMainFragment.this, view2);
                }
            });
        }
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding3 = get_binding();
        if (fragmentExamRegistrationMainBinding3 != null && (linearLayout2 = fragmentExamRegistrationMainBinding3.examResultLyt) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ExamRegistrationMainFragment.onViewCreated$lambda$2(ExamRegistrationMainFragment.this, view2);
                }
            });
        }
        FragmentExamRegistrationMainBinding fragmentExamRegistrationMainBinding4 = get_binding();
        if (fragmentExamRegistrationMainBinding4 == null || (linearLayout = fragmentExamRegistrationMainBinding4.revaluationFeeLyt) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExamRegistrationMainFragment.onViewCreated$lambda$3(ExamRegistrationMainFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ExamRegistrationMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.examManagementMainClick("true");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ExamRegistrationMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.examManagementMainClick("false");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ExamRegistrationMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.examUniversityResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(ExamRegistrationMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.examManagementMainClick("revaluation");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }
}