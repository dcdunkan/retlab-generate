package in.etuwa.app.ui.result;

import android.content.ComponentCallbacks;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.forms.xfdf.XfdfConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.result.univ.UnivResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ResultFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.assignment.AssignmentResultFragment;
import in.etuwa.app.ui.result.internal.InternalResultFragment;
import in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment;
import in.etuwa.app.ui.result.session.SessionalFragment;
import in.etuwa.app.ui.result.tutorials.TutorialResultFragment;
import in.etuwa.app.ui.result.university.UniversityAdapter;
import in.etuwa.app.ui.result.university.UniversityFragment;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialog;
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

/* JADX INFO: compiled from: ResultFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ResultFragment extends BaseFragment implements SemListDialog.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ResultFragmentBinding _binding;
    private ResultAdapter adapter;
    private UniversityAdapter adapter2;
    private boolean flag;
    private String frag;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: resultViewModel$delegate, reason: from kotlin metadata */
    private final Lazy resultViewModel;
    private String semId;

    /* JADX INFO: compiled from: ResultFragment.kt */
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
    public static final ResultFragment newInstance(boolean z) {
        return INSTANCE.newInstance(z);
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

    public ResultFragment() {
        final ResultFragment resultFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.result.ResultFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return resultFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(resultFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.resultViewModel = FragmentViewModelLazyKt.createViewModelLazy(resultFragment, Reflection.getOrCreateKotlinClass(ResultViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.result.ResultFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.result.ResultFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ResultViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.frag = "result";
        final ResultFragment resultFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.result.ResultFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = resultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.semId = getPreference().getUserSemId();
    }

    private final ResultViewModel getResultViewModel() {
        return (ResultViewModel) this.resultViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final ResultFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getSemId() {
        return this.semId;
    }

    public final void setSemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semId = str;
    }

    /* JADX INFO: compiled from: ResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/result/ResultFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/result/ResultFragment;", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ResultFragment newInstance(boolean flag) {
            ResultFragment resultFragment = new ResultFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", flag);
            resultFragment.setArguments(bundle);
            return resultFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flag = arguments.getBoolean("flag");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ResultFragmentBinding.inflate(inflater, container, false);
        ResultFragmentBinding resultFragmentBinding = get_binding();
        if (resultFragmentBinding != null) {
            resultFragmentBinding.setResultViewModel(getResultViewModel());
        }
        ResultFragmentBinding resultFragmentBinding2 = get_binding();
        if (resultFragmentBinding2 != null) {
            resultFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ResultFragmentBinding resultFragmentBinding3 = get_binding();
        View root = resultFragmentBinding3 != null ? resultFragmentBinding3.getRoot() : null;
        Intrinsics.checkNotNull(root);
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        ImageView imageView;
        ViewPager2 viewPager2;
        TextView textView;
        TabLayout tabLayout;
        ViewPager2 viewPager22;
        TextView textView2;
        TextView textView3;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.result));
        }
        ResultFragmentBinding resultFragmentBinding = get_binding();
        TextView textView4 = resultFragmentBinding != null ? resultFragmentBinding.internalSemText : null;
        if (textView4 != null) {
            textView4.setText(getPreference().getUserSem());
        }
        listenResponse();
        getResultViewModel().getResult(this.semId);
        ResultFragmentBinding resultFragmentBinding2 = get_binding();
        if (resultFragmentBinding2 != null && (textView3 = resultFragmentBinding2.tvResults) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        ResultFragmentBinding resultFragmentBinding3 = get_binding();
        if (resultFragmentBinding3 != null && (textView2 = resultFragmentBinding3.tvUniResults) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        setTabActive(true);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        this.adapter = new ResultAdapter(childFragmentManager, getViewLifecycleOwner().getLifecycle());
        ResultFragmentBinding resultFragmentBinding4 = get_binding();
        if (resultFragmentBinding4 != null && (viewPager22 = resultFragmentBinding4.resultPager) != null) {
            ResultAdapter resultAdapter = this.adapter;
            if (resultAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                resultAdapter = null;
            }
            viewPager22.setAdapter(resultAdapter);
            viewPager22.setOffscreenPageLimit(1);
            viewPager22.setPageTransformer(new ViewPager2.PageTransformer() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda6
                @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                public final void transformPage(View view, float f) {
                    ResultFragment.setUp$lambda$5$lambda$4(view, f);
                }
            });
        }
        ResultFragmentBinding resultFragmentBinding5 = get_binding();
        if (resultFragmentBinding5 != null && (tabLayout = resultFragmentBinding5.univTabs) != null) {
            ResultFragmentBinding resultFragmentBinding6 = get_binding();
            tabLayout.setupWithViewPager(resultFragmentBinding6 != null ? resultFragmentBinding6.univPager : null);
        }
        setupChipSelection();
        if (this.flag) {
            this.frag = "university";
            ResultFragmentBinding resultFragmentBinding7 = get_binding();
            if (resultFragmentBinding7 != null && (textView = resultFragmentBinding7.tvUniResults) != null) {
                textView.performClick();
            }
            ResultFragmentBinding resultFragmentBinding8 = get_binding();
            if (resultFragmentBinding8 != null && (viewPager2 = resultFragmentBinding8.resultPager) != null) {
                viewPager2.post(new Runnable() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        ResultFragment.setUp$lambda$6(this.f$0);
                    }
                });
            }
        }
        ResultFragmentBinding resultFragmentBinding9 = get_binding();
        if (resultFragmentBinding9 != null && (imageView = resultFragmentBinding9.ivFilter) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultFragment.setUp$lambda$7(this.f$0, view);
                }
            });
        }
        getPreference().setNewLogin(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.frag = "result";
        ResultFragmentBinding resultFragmentBinding = this$0.get_binding();
        View view2 = resultFragmentBinding != null ? resultFragmentBinding.resultView : null;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ResultFragmentBinding resultFragmentBinding2 = this$0.get_binding();
        View view3 = resultFragmentBinding2 != null ? resultFragmentBinding2.uniView : null;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ResultFragmentBinding resultFragmentBinding3 = this$0.get_binding();
        HorizontalScrollView horizontalScrollView = resultFragmentBinding3 != null ? resultFragmentBinding3.hrView : null;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(0);
        }
        ResultFragmentBinding resultFragmentBinding4 = this$0.get_binding();
        ViewPager2 viewPager2 = resultFragmentBinding4 != null ? resultFragmentBinding4.resultPager : null;
        if (viewPager2 != null) {
            viewPager2.setVisibility(0);
        }
        ResultFragmentBinding resultFragmentBinding5 = this$0.get_binding();
        LinearLayout linearLayout = resultFragmentBinding5 != null ? resultFragmentBinding5.uniResultView : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this$0.setTabActive(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.frag = "university";
        ResultFragmentBinding resultFragmentBinding = this$0.get_binding();
        View view2 = resultFragmentBinding != null ? resultFragmentBinding.resultView : null;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ResultFragmentBinding resultFragmentBinding2 = this$0.get_binding();
        View view3 = resultFragmentBinding2 != null ? resultFragmentBinding2.uniView : null;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        ResultFragmentBinding resultFragmentBinding3 = this$0.get_binding();
        HorizontalScrollView horizontalScrollView = resultFragmentBinding3 != null ? resultFragmentBinding3.hrView : null;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        ResultFragmentBinding resultFragmentBinding4 = this$0.get_binding();
        ViewPager2 viewPager2 = resultFragmentBinding4 != null ? resultFragmentBinding4.resultPager : null;
        if (viewPager2 != null) {
            viewPager2.setVisibility(8);
        }
        ResultFragmentBinding resultFragmentBinding5 = this$0.get_binding();
        LinearLayout linearLayout = resultFragmentBinding5 != null ? resultFragmentBinding5.uniResultView : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        this$0.setTabActive(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5$lambda$4(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        float fAbs = Math.abs(f);
        page.setAlpha(1.0f - (0.3f * fAbs));
        page.setScaleY(((1.0f - fAbs) * 0.15f) + 0.85f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(ResultFragment this$0) {
        ViewPager2 viewPager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ResultFragmentBinding resultFragmentBinding = this$0.get_binding();
        if (resultFragmentBinding == null || (viewPager2 = resultFragmentBinding.resultPager) == null) {
            return;
        }
        viewPager2.setCurrentItem(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(ResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialog semListDialogNewInstance = SemListDialog.INSTANCE.newInstance();
        semListDialogNewInstance.setCallBack2(this$0);
        semListDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getResultViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultFragment.listenResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$9(ResultFragment this$0, Resource resource) {
        ImageView ivFilter;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            ResultFragmentBinding resultFragmentBinding = this$0.get_binding();
            if (resultFragmentBinding == null || (imageView = resultFragmentBinding.ivFilter) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(imageView, message);
            return;
        }
        this$0.hideProgress();
        UnivResponse univResponse = (UnivResponse) resource.getData();
        if (univResponse != null) {
            if (univResponse.getLogin()) {
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                this$0.adapter2 = new UniversityAdapter(childFragmentManager);
                ResultFragmentBinding resultFragmentBinding2 = this$0.get_binding();
                UniversityAdapter universityAdapter = null;
                ViewPager viewPager = resultFragmentBinding2 != null ? resultFragmentBinding2.univPager : null;
                if (viewPager != null) {
                    UniversityAdapter universityAdapter2 = this$0.adapter2;
                    if (universityAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter2");
                        universityAdapter2 = null;
                    }
                    viewPager.setAdapter(universityAdapter2);
                }
                UniversityAdapter universityAdapter3 = this$0.adapter2;
                if (universityAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter2");
                } else {
                    universityAdapter = universityAdapter3;
                }
                universityAdapter.addItems(univResponse.getDetails(), univResponse.getSubjects(), univResponse.getUnivExams());
                return;
            }
            ResultFragmentBinding resultFragmentBinding3 = this$0.get_binding();
            if (resultFragmentBinding3 == null || (ivFilter = resultFragmentBinding3.ivFilter) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(ivFilter, "ivFilter");
            ToastExtKt.showErrorToast(ivFilter, univResponse.getError());
        }
    }

    private final void setupChipSelection() {
        ViewPager2 viewPager2;
        ChipGroup chipGroup;
        ResultFragmentBinding resultFragmentBinding = get_binding();
        if (resultFragmentBinding != null && (chipGroup = resultFragmentBinding.chipGroupResults) != null) {
            chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.result.ResultFragment$$ExternalSyntheticLambda3
                @Override // com.google.android.material.chip.ChipGroup.OnCheckedChangeListener
                public final void onCheckedChanged(ChipGroup chipGroup2, int i) {
                    ResultFragment.setupChipSelection$lambda$10(this.f$0, chipGroup2, i);
                }
            });
        }
        ResultFragmentBinding resultFragmentBinding2 = get_binding();
        if (resultFragmentBinding2 == null || (viewPager2 = resultFragmentBinding2.resultPager) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: in.etuwa.app.ui.result.ResultFragment.setupChipSelection.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                int i;
                ChipGroup chipGroup2;
                Chip chip;
                ViewParent parent;
                ChipGroup chipGroup3;
                super.onPageSelected(position);
                if (position == 0) {
                    i = R.id.chip_assignment;
                } else if (position == 1) {
                    i = R.id.chip_series;
                } else if (position == 2) {
                    i = R.id.chip_module;
                } else if (position == 3) {
                    i = R.id.chip_tutorial;
                } else if (position == 4) {
                    i = R.id.chip_internal;
                } else if (position == 5) {
                    i = R.id.chip_university;
                } else {
                    i = R.id.chip_assignment;
                }
                ResultFragmentBinding resultFragmentBinding3 = ResultFragment.this.get_binding();
                if (resultFragmentBinding3 != null && (chipGroup3 = resultFragmentBinding3.chipGroupResults) != null) {
                    chipGroup3.check(i);
                }
                ResultFragmentBinding resultFragmentBinding4 = ResultFragment.this.get_binding();
                if (resultFragmentBinding4 == null || (chipGroup2 = resultFragmentBinding4.chipGroupResults) == null || (chip = (Chip) chipGroup2.findViewById(i)) == null || (parent = chip.getParent()) == null) {
                    return;
                }
                Chip chip2 = chip;
                parent.requestChildFocus(chip2, chip2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupChipSelection$lambda$10(ResultFragment this$0, ChipGroup group, int i) {
        ViewPager2 viewPager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(group, "group");
        int i2 = 0;
        if (i != R.id.chip_assignment) {
            if (i == R.id.chip_series) {
                i2 = 1;
            } else if (i == R.id.chip_module) {
                i2 = 2;
            } else if (i == R.id.chip_tutorial) {
                i2 = 3;
            } else if (i == R.id.chip_internal) {
                i2 = 4;
            } else if (i == R.id.chip_university) {
                i2 = 5;
            }
        }
        ResultFragmentBinding resultFragmentBinding = this$0.get_binding();
        if (resultFragmentBinding == null || (viewPager2 = resultFragmentBinding.resultPager) == null) {
            return;
        }
        viewPager2.setCurrentItem(i2, true);
    }

    private final void setTabActive(boolean isResults) {
        TextView textView;
        TextView textView2;
        ResultFragmentBinding resultFragmentBinding = get_binding();
        if (resultFragmentBinding != null && (textView2 = resultFragmentBinding.tvResults) != null) {
            textView2.setTextColor(requireContext().getColor(isResults ? R.color.colorPrimary : R.color.text_primary));
            textView2.setTypeface(Typeface.create(textView2.getResources().getFont(R.font.poppins_regular), isResults ? 1 : 0));
        }
        ResultFragmentBinding resultFragmentBinding2 = get_binding();
        if (resultFragmentBinding2 == null || (textView = resultFragmentBinding2.tvUniResults) == null) {
            return;
        }
        textView.setTextColor(requireContext().getColor(!isResults ? R.color.colorPrimary : R.color.text_primary));
        textView.setTypeface(Typeface.create(textView.getResources().getFont(R.font.poppins_regular), !isResults ? 1 : 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListDialog.SemDialogCallBack
    public void loadSelectedSem(String id, String semName) {
        ViewPager2 viewPager2;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semName, "semName");
        FragmentManager childFragmentManager = getChildFragmentManager();
        ResultFragmentBinding resultFragmentBinding = get_binding();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(XfdfConstants.F + ((resultFragmentBinding == null || (viewPager2 = resultFragmentBinding.resultPager) == null) ? null : Integer.valueOf(viewPager2.getCurrentItem())));
        if (Intrinsics.areEqual(this.frag, "result")) {
            if (fragmentFindFragmentByTag instanceof AssignmentResultFragment) {
                ((AssignmentResultFragment) fragmentFindFragmentByTag).onSemesterSelected(id, semName);
                return;
            }
            if (fragmentFindFragmentByTag instanceof SessionalFragment) {
                ((SessionalFragment) fragmentFindFragmentByTag).onSemesterSelected(id, semName);
                return;
            }
            if (fragmentFindFragmentByTag instanceof ResultModuleTestFragment) {
                ((ResultModuleTestFragment) fragmentFindFragmentByTag).onSemesterSelected(id, semName);
                return;
            }
            if (fragmentFindFragmentByTag instanceof TutorialResultFragment) {
                ((TutorialResultFragment) fragmentFindFragmentByTag).onSemesterSelected(id, semName);
                return;
            } else if (fragmentFindFragmentByTag instanceof InternalResultFragment) {
                ((InternalResultFragment) fragmentFindFragmentByTag).onSemesterSelected(id, semName);
                return;
            } else {
                if (fragmentFindFragmentByTag instanceof UniversityFragment) {
                    ((UniversityFragment) fragmentFindFragmentByTag).onSemesterSelected(id, semName);
                    return;
                }
                return;
            }
        }
        this.semId = id;
        getResultViewModel().getResult(id);
        ResultFragmentBinding resultFragmentBinding2 = get_binding();
        TextView textView = resultFragmentBinding2 != null ? resultFragmentBinding2.internalSemText : null;
        if (textView == null) {
            return;
        }
        textView.setText(semName);
    }
}