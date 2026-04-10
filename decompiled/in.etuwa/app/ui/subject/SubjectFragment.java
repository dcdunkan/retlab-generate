package in.etuwa.app.ui.subject;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.subject.Subjects;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SubjectFragmentBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.app.ui.subject.SubjectAdapter;
import in.etuwa.app.utils.RecycleExtKt;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: SubjectFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SubjectFragment extends BaseFragment implements SubjectAdapter.SubjectCallBack, SemListDialogTwo.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SubjectFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String current;
    private boolean flag;
    private boolean isSearchOpen;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: subjectViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subjectViewModel;

    /* JADX INFO: compiled from: SubjectFragment.kt */
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
    public static final SubjectFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SubjectFragment() {
        final SubjectFragment subjectFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return subjectFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(subjectFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.subjectViewModel = FragmentViewModelLazyKt.createViewModelLazy(subjectFragment, Reflection.getOrCreateKotlinClass(SubjectViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SubjectViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SubjectFragment subjectFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SubjectAdapter>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.subject.SubjectAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectAdapter invoke() {
                ComponentCallbacks componentCallbacks = subjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = subjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        this.current = "";
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.subject.SubjectFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = subjectFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectViewModel getSubjectViewModel() {
        return (SubjectViewModel) this.subjectViewModel.getValue();
    }

    private final SubjectAdapter getAdapter() {
        return (SubjectAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final SubjectFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: SubjectFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/subject/SubjectFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/subject/SubjectFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubjectFragment newInstance() {
            return new SubjectFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SubjectFragmentBinding.inflate(inflater, container, false);
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        if (subjectFragmentBinding != null) {
            subjectFragmentBinding.setSubjectViewModel(getSubjectViewModel());
        }
        SubjectFragmentBinding subjectFragmentBinding2 = get_binding();
        if (subjectFragmentBinding2 != null) {
            subjectFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SubjectFragmentBinding subjectFragmentBinding3 = get_binding();
        if (subjectFragmentBinding3 != null) {
            return subjectFragmentBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        ImageView imageView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.subjects));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        RecyclerView recyclerView = subjectFragmentBinding != null ? subjectFragmentBinding.rvSubject : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        SubjectFragmentBinding subjectFragmentBinding2 = get_binding();
        Spinner spinner = subjectFragmentBinding2 != null ? subjectFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getAdapter().setSubjectCallBack(this);
        getSubjectViewModel().getSubjects(getPreference().getUserSemId());
        listenSemResponse();
        listenResponse();
        setupSearch();
        SubjectFragmentBinding subjectFragmentBinding3 = get_binding();
        if (subjectFragmentBinding3 != null && (imageView = subjectFragmentBinding3.fabSubjectSemester) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subject.SubjectFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        SubjectFragmentBinding subjectFragmentBinding4 = get_binding();
        Spinner spinner2 = subjectFragmentBinding4 != null ? subjectFragmentBinding4.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subject.SubjectFragment.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Spinner spinner3;
                    Semester semester = SubjectFragment.this.getSpinnerAdapter().getSemester(position);
                    if (SubjectFragment.this.flag) {
                        SubjectFragment.this.getSubjectViewModel().getSubjects(semester.getId());
                        SubjectFragment.this.current = semester.getId();
                        return;
                    }
                    SubjectFragment.this.flag = true;
                    int count = SubjectFragment.this.getSpinnerAdapter().getCount();
                    for (int i = 0; i < count; i++) {
                        if (Intrinsics.areEqual(SubjectFragment.this.getPreference().getUserSemId(), SubjectFragment.this.getSpinnerAdapter().getSemester(i).getId())) {
                            SubjectFragmentBinding subjectFragmentBinding5 = SubjectFragment.this.get_binding();
                            if (subjectFragmentBinding5 != null && (spinner3 = subjectFragmentBinding5.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                SubjectFragment.this.getSubjectViewModel().getSubjects(SubjectFragment.this.getPreference().getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        SubjectFragmentBinding subjectFragmentBinding5 = get_binding();
        if (subjectFragmentBinding5 == null || (swipeRefreshLayout = subjectFragmentBinding5.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.subject.SubjectFragment$$ExternalSyntheticLambda5
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SubjectFragment.setUp$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(SubjectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo semListDialogTwoNewInstance = SemListDialogTwo.INSTANCE.newInstance();
        semListDialogTwoNewInstance.setCallBack(this$0);
        semListDialogTwoNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SubjectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSubjectViewModel().getSubjects(this$0.current);
        SubjectFragmentBinding subjectFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = subjectFragmentBinding != null ? subjectFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void setupSearch() {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        if (subjectFragmentBinding != null && (imageView2 = subjectFragmentBinding.ivSearch) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subject.SubjectFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectFragment.setupSearch$lambda$2(this.f$0, view);
                }
            });
        }
        SubjectFragmentBinding subjectFragmentBinding2 = get_binding();
        if (subjectFragmentBinding2 != null && (imageView = subjectFragmentBinding2.ivClearSearch) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subject.SubjectFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectFragment.setupSearch$lambda$3(this.f$0, view);
                }
            });
        }
        SubjectFragmentBinding subjectFragmentBinding3 = get_binding();
        if (subjectFragmentBinding3 == null || (editText = subjectFragmentBinding3.searchInput) == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.subject.SubjectFragment.setupSearch.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                SubjectFragmentBinding subjectFragmentBinding4 = SubjectFragment.this.get_binding();
                ImageView imageView3 = subjectFragmentBinding4 != null ? subjectFragmentBinding4.ivClearSearch : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(string.length() > 0 ? 0 : 8);
                }
                SubjectFragment.this.filterCurrentAdapter(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$2(SubjectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSearchOpen) {
            this$0.closeSearch();
        } else {
            this$0.openSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$3(SubjectFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SubjectFragmentBinding subjectFragmentBinding = this$0.get_binding();
        if (subjectFragmentBinding == null || (editText = subjectFragmentBinding.searchInput) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    private final void openSearch() {
        EditText editText;
        ImageView imageView;
        this.isSearchOpen = true;
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        CardView cardView = subjectFragmentBinding != null ? subjectFragmentBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        SubjectFragmentBinding subjectFragmentBinding2 = get_binding();
        if (subjectFragmentBinding2 != null && (imageView = subjectFragmentBinding2.ivSearch) != null) {
            imageView.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        }
        SubjectFragmentBinding subjectFragmentBinding3 = get_binding();
        ImageView imageView2 = subjectFragmentBinding3 != null ? subjectFragmentBinding3.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        SubjectFragmentBinding subjectFragmentBinding4 = get_binding();
        if (subjectFragmentBinding4 != null && (editText = subjectFragmentBinding4.searchInput) != null) {
            editText.requestFocus();
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        SubjectFragmentBinding subjectFragmentBinding5 = get_binding();
        inputMethodManager.showSoftInput(subjectFragmentBinding5 != null ? subjectFragmentBinding5.searchInput : null, 1);
    }

    private final void closeSearch() {
        EditText editText;
        ImageView imageView;
        EditText editText2;
        Editable text;
        this.isSearchOpen = false;
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        IBinder windowToken = null;
        CardView cardView = subjectFragmentBinding != null ? subjectFragmentBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        SubjectFragmentBinding subjectFragmentBinding2 = get_binding();
        if (subjectFragmentBinding2 != null && (editText2 = subjectFragmentBinding2.searchInput) != null && (text = editText2.getText()) != null) {
            text.clear();
        }
        SubjectFragmentBinding subjectFragmentBinding3 = get_binding();
        if (subjectFragmentBinding3 != null && (imageView = subjectFragmentBinding3.ivSearch) != null) {
            imageView.setImageResource(R.drawable.ic_search);
        }
        SubjectFragmentBinding subjectFragmentBinding4 = get_binding();
        ImageView imageView2 = subjectFragmentBinding4 != null ? subjectFragmentBinding4.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        SubjectFragmentBinding subjectFragmentBinding5 = get_binding();
        if (subjectFragmentBinding5 != null && (editText = subjectFragmentBinding5.searchInput) != null) {
            windowToken = editText.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        filterCurrentAdapter("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterCurrentAdapter(String query) {
        getAdapter().applyCombinedFilter(query);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.clear();
        inflater.inflate(R.menu.action_filter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final void listenSemResponse() {
        getSubjectViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subject.SubjectFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubjectFragment.listenSemResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$5(SubjectFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (i != 1) {
            if (i == 2) {
                SubjectFragmentBinding subjectFragmentBinding = this$0.get_binding();
                if (subjectFragmentBinding != null && (swipeRefreshLayout2 = subjectFragmentBinding.swipeLayout) != null) {
                    boolValueOf = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    return;
                }
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
            SubjectFragmentBinding subjectFragmentBinding2 = this$0.get_binding();
            if (subjectFragmentBinding2 == null || (recyclerView = subjectFragmentBinding2.rvSubject) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            SubjectFragmentBinding subjectFragmentBinding3 = this$0.get_binding();
            Boolean boolValueOf2 = (subjectFragmentBinding3 == null || (swipeRefreshLayout = subjectFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue()) {
                SubjectFragmentBinding subjectFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = subjectFragmentBinding4 != null ? subjectFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        SubjectFragmentBinding subjectFragmentBinding5 = this$0.get_binding();
                        if (subjectFragmentBinding5 == null || (spinner = subjectFragmentBinding5.spinnerSem) == null) {
                            return;
                        }
                        spinner.setSelection(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getSubjectViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.subject.SubjectFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubjectFragment.listenResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$7(SubjectFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Subjects> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
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
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        SubjectFragmentBinding subjectFragmentBinding = this$0.get_binding();
        if (subjectFragmentBinding == null || (recyclerView = subjectFragmentBinding.rvSubject) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.subject.SubjectAdapter.SubjectCallBack
    public void onSyllabusClicked(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openSyllabusPage(subId);
        }
    }

    @Override // in.etuwa.app.ui.subject.SubjectAdapter.SubjectCallBack
    public void onCoClicked(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openCoPage(subId);
        }
    }

    @Override // in.etuwa.app.ui.subject.SubjectAdapter.SubjectCallBack
    public void onCoverageClicked(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openSubCovePage(subId);
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        if (subjectFragmentBinding == null || (recyclerView = subjectFragmentBinding.rvSubject) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        SubjectFragmentBinding subjectFragmentBinding = get_binding();
        if (subjectFragmentBinding == null || (recyclerView = subjectFragmentBinding.rvSubject) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
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
        getAdapter().setSubjectCallBack(null);
        this.listener = null;
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo.SemDialogCallBack
    public void loadSelectedSem(String id, String sem) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sem, "sem");
        getSubjectViewModel().getSubjects(id);
    }
}