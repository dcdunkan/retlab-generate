package in.etuwa.app.ui.teacher;

import android.animation.ValueAnimator;
import android.content.ComponentCallbacks;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.common.TeacherResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.TeacherFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* JADX INFO: compiled from: TeacherFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private TeacherFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: teacherViewModel$delegate, reason: from kotlin metadata */
    private final Lazy teacherViewModel;

    /* JADX INFO: compiled from: TeacherFragment.kt */
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
    public static final TeacherFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TeacherFragment() {
        final TeacherFragment teacherFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return teacherFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(teacherFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.teacherViewModel = FragmentViewModelLazyKt.createViewModelLazy(teacherFragment, Reflection.getOrCreateKotlinClass(TeacherViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TeacherViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TeacherFragment teacherFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TeacherAdapter>() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.teacher.TeacherAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TeacherAdapter invoke() {
                ComponentCallbacks componentCallbacks = teacherFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TeacherAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = teacherFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final TeacherViewModel getTeacherViewModel() {
        return (TeacherViewModel) this.teacherViewModel.getValue();
    }

    private final TeacherAdapter getAdapter() {
        return (TeacherAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final TeacherFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    /* JADX INFO: compiled from: TeacherFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/teacher/TeacherFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/teacher/TeacherFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TeacherFragment newInstance() {
            return new TeacherFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TeacherFragmentBinding.inflate(inflater, container, false);
        TeacherFragmentBinding teacherFragmentBinding = get_binding();
        if (teacherFragmentBinding != null) {
            teacherFragmentBinding.setTeacherViewModel(getTeacherViewModel());
        }
        TeacherFragmentBinding teacherFragmentBinding2 = get_binding();
        if (teacherFragmentBinding2 != null) {
            teacherFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        TeacherFragmentBinding teacherFragmentBinding3 = get_binding();
        if (teacherFragmentBinding3 != null) {
            return teacherFragmentBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.teacher));
        }
        hideBaseView();
        TeacherFragmentBinding teacherFragmentBinding = get_binding();
        RecyclerView recyclerView = teacherFragmentBinding != null ? teacherFragmentBinding.rvTeacher : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getPreference().setNewLogin(false);
        listenResponse();
        TeacherFragmentBinding teacherFragmentBinding2 = get_binding();
        if (teacherFragmentBinding2 != null && (swipeRefreshLayout = teacherFragmentBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    TeacherFragment.setUp$lambda$0(this.f$0);
                }
            });
        }
        TeacherFragmentBinding teacherFragmentBinding3 = get_binding();
        if (teacherFragmentBinding3 != null && (textView2 = teacherFragmentBinding3.btnSubjectTeacher) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        TeacherFragmentBinding teacherFragmentBinding4 = get_binding();
        if (teacherFragmentBinding4 == null || (textView = teacherFragmentBinding4.btnStaffAdvisor) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeacherFragment.setUp$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TeacherFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTeacherViewModel().getTeacher();
        TeacherFragmentBinding teacherFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = teacherFragmentBinding != null ? teacherFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TeacherFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherFragmentBinding teacherFragmentBinding = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding);
        TextView textView5 = teacherFragmentBinding.btnSubjectTeacher;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding!!.btnSubjectTeacher");
        TeacherFragmentBinding teacherFragmentBinding2 = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding2);
        TextView textView6 = teacherFragmentBinding2.btnStaffAdvisor;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding!!.btnStaffAdvisor");
        this$0.updateSelection(textView5, textView6);
        TeacherFragmentBinding teacherFragmentBinding3 = this$0.get_binding();
        if (teacherFragmentBinding3 != null && (textView4 = teacherFragmentBinding3.btnSubjectTeacher) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_selected);
        }
        TeacherFragmentBinding teacherFragmentBinding4 = this$0.get_binding();
        if (teacherFragmentBinding4 != null && (textView3 = teacherFragmentBinding4.btnStaffAdvisor) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        TeacherFragmentBinding teacherFragmentBinding5 = this$0.get_binding();
        if (teacherFragmentBinding5 != null && (textView2 = teacherFragmentBinding5.btnSubjectTeacher) != null) {
            textView2.setTextColor(-1);
        }
        TeacherFragmentBinding teacherFragmentBinding6 = this$0.get_binding();
        if (teacherFragmentBinding6 != null && (textView = teacherFragmentBinding6.btnStaffAdvisor) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        TeacherFragmentBinding teacherFragmentBinding7 = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding7);
        TextView textView7 = teacherFragmentBinding7.btnSubjectTeacher;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding!!.btnSubjectTeacher");
        this$0.animateHeight(textView7, 40);
        TeacherFragmentBinding teacherFragmentBinding8 = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding8);
        TextView textView8 = teacherFragmentBinding8.btnStaffAdvisor;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding!!.btnStaffAdvisor");
        this$0.animateHeight(textView8, 36);
        this$0.flag = false;
        this$0.listenResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(TeacherFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherFragmentBinding teacherFragmentBinding = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding);
        TextView textView5 = teacherFragmentBinding.btnStaffAdvisor;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding!!.btnStaffAdvisor");
        TeacherFragmentBinding teacherFragmentBinding2 = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding2);
        TextView textView6 = teacherFragmentBinding2.btnSubjectTeacher;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding!!.btnSubjectTeacher");
        this$0.updateSelection(textView5, textView6);
        TeacherFragmentBinding teacherFragmentBinding3 = this$0.get_binding();
        if (teacherFragmentBinding3 != null && (textView4 = teacherFragmentBinding3.btnStaffAdvisor) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_selected);
        }
        TeacherFragmentBinding teacherFragmentBinding4 = this$0.get_binding();
        if (teacherFragmentBinding4 != null && (textView3 = teacherFragmentBinding4.btnSubjectTeacher) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        TeacherFragmentBinding teacherFragmentBinding5 = this$0.get_binding();
        if (teacherFragmentBinding5 != null && (textView2 = teacherFragmentBinding5.btnStaffAdvisor) != null) {
            textView2.setTextColor(-1);
        }
        TeacherFragmentBinding teacherFragmentBinding6 = this$0.get_binding();
        if (teacherFragmentBinding6 != null && (textView = teacherFragmentBinding6.btnSubjectTeacher) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        TeacherFragmentBinding teacherFragmentBinding7 = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding7);
        TextView textView7 = teacherFragmentBinding7.btnStaffAdvisor;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding!!.btnStaffAdvisor");
        this$0.animateHeight(textView7, 40);
        TeacherFragmentBinding teacherFragmentBinding8 = this$0.get_binding();
        Intrinsics.checkNotNull(teacherFragmentBinding8);
        TextView textView8 = teacherFragmentBinding8.btnSubjectTeacher;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding!!.btnSubjectTeacher");
        this$0.animateHeight(textView8, 36);
        this$0.flag = true;
        this$0.listenResponse();
    }

    public final void updateSelection(TextView selected, TextView unselected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(unselected, "unselected");
        Typeface font = ResourcesCompat.getFont(selected.getContext(), R.font.poppins_semibold);
        Typeface font2 = ResourcesCompat.getFont(selected.getContext(), R.font.poppins_regular);
        selected.setBackgroundResource(R.drawable.shape_round_selected);
        selected.setTextColor(-1);
        selected.setTypeface(font);
        unselected.setBackgroundResource(R.drawable.shape_round_unselected);
        unselected.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        unselected.setTypeface(font2);
    }

    public final void animateHeight(final View view, int targetDp) {
        Intrinsics.checkNotNullParameter(view, "view");
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(view.getHeight(), (int) (targetDp * view.getContext().getResources().getDisplayMetrics().density));
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TeacherFragment.animateHeight$lambda$5(view, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateHeight$lambda$5(View view, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = iIntValue;
        view.setLayoutParams(layoutParams);
    }

    private final void listenResponse() {
        getTeacherViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.teacher.TeacherFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherFragment.listenResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$7(TeacherFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            TeacherFragmentBinding teacherFragmentBinding = this$0.get_binding();
            if (teacherFragmentBinding == null || (recyclerView = teacherFragmentBinding.rvTeacher) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        TeacherResponse teacherResponse = (TeacherResponse) resource.getData();
        if (teacherResponse != null) {
            this$0.showBaseView();
            TeacherFragmentBinding teacherFragmentBinding2 = this$0.get_binding();
            TextView textView = teacherFragmentBinding2 != null ? teacherFragmentBinding2.hodName : null;
            if (textView != null) {
                textView.setText(teacherResponse.getHod().get(0).getTeacher());
            }
            TeacherFragmentBinding teacherFragmentBinding3 = this$0.get_binding();
            TextView textView2 = teacherFragmentBinding3 != null ? teacherFragmentBinding3.hodEmail : null;
            if (textView2 != null) {
                textView2.setText(teacherResponse.getHod().get(0).getMail());
            }
            if (Intrinsics.areEqual(teacherResponse.getHod().get(0).getSubject(), "hod")) {
                TeacherFragmentBinding teacherFragmentBinding4 = this$0.get_binding();
                TextView textView3 = teacherFragmentBinding4 != null ? teacherFragmentBinding4.hodSubject : null;
                if (textView3 != null) {
                    textView3.setText("HoD");
                }
            } else {
                TeacherFragmentBinding teacherFragmentBinding5 = this$0.get_binding();
                TextView textView4 = teacherFragmentBinding5 != null ? teacherFragmentBinding5.hodSubject : null;
                if (textView4 != null) {
                    textView4.setText(teacherResponse.getHod().get(0).getSubject());
                }
            }
            String phone = teacherResponse.getHod().get(0).getPhone();
            if (phone != null && phone.length() != 0) {
                z = false;
            }
            if (z) {
                TeacherFragmentBinding teacherFragmentBinding6 = this$0.get_binding();
                TextView textView5 = teacherFragmentBinding6 != null ? teacherFragmentBinding6.hodPhone : null;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            } else {
                TeacherFragmentBinding teacherFragmentBinding7 = this$0.get_binding();
                TextView textView6 = teacherFragmentBinding7 != null ? teacherFragmentBinding7.hodPhone : null;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TeacherFragmentBinding teacherFragmentBinding8 = this$0.get_binding();
                TextView textView7 = teacherFragmentBinding8 != null ? teacherFragmentBinding8.hodPhone : null;
                if (textView7 != null) {
                    textView7.setText(teacherResponse.getHod().get(0).getPhone());
                }
            }
            RequestCreator requestCreatorLoad = Picasso.get().load(teacherResponse.getHod().get(0).getImage());
            TeacherFragmentBinding teacherFragmentBinding9 = this$0.get_binding();
            requestCreatorLoad.into(teacherFragmentBinding9 != null ? teacherFragmentBinding9.hodImage : null);
            if (!this$0.flag) {
                this$0.getAdapter().addItems(teacherResponse.getSub_teacher());
            } else {
                this$0.getAdapter().addItems(teacherResponse.getStaffadvisor());
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        TeacherFragmentBinding teacherFragmentBinding = get_binding();
        if (teacherFragmentBinding == null || (recyclerView = teacherFragmentBinding.rvTeacher) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        TeacherFragmentBinding teacherFragmentBinding = get_binding();
        if (teacherFragmentBinding == null || (recyclerView = teacherFragmentBinding.rvTeacher) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}