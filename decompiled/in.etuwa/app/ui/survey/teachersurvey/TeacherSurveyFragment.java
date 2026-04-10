package in.etuwa.app.ui.survey.teachersurvey;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.chip.ChipGroup;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentTeacherSurveyListBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: TeacherSurveyFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherSurveyFragment extends BaseFragment implements TeacherSurveyAdapter.SurveyCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTeacherSurveyListBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String currentFilter;
    private boolean flag;
    private String id;
    private boolean isSearchOpen;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: teacherSurveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy teacherSurveyViewModel;

    /* JADX INFO: compiled from: TeacherSurveyFragment.kt */
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
    public static final TeacherSurveyFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TeacherSurveyFragment() {
        final TeacherSurveyFragment teacherSurveyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return teacherSurveyFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(teacherSurveyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.teacherSurveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(teacherSurveyFragment, Reflection.getOrCreateKotlinClass(TeacherSurveyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TeacherSurveyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TeacherSurveyFragment teacherSurveyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TeacherSurveyAdapter>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TeacherSurveyAdapter invoke() {
                ComponentCallbacks componentCallbacks = teacherSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TeacherSurveyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = teacherSurveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.currentFilter = "pending";
    }

    private final TeacherSurveyViewModel getTeacherSurveyViewModel() {
        return (TeacherSurveyViewModel) this.teacherSurveyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TeacherSurveyAdapter getAdapter() {
        return (TeacherSurveyAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentTeacherSurveyListBinding get_binding() {
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

    /* JADX INFO: compiled from: TeacherSurveyFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TeacherSurveyFragment newInstance(String id) {
            TeacherSurveyFragment teacherSurveyFragment = new TeacherSurveyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            teacherSurveyFragment.setArguments(bundle);
            return teacherSurveyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTeacherSurveyListBinding.inflate(inflater, container, false);
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding != null) {
            fragmentTeacherSurveyListBinding.setTeacherSurveyViewModel(getTeacherSurveyViewModel());
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 != null) {
            fragmentTeacherSurveyListBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding3 = get_binding();
        if (fragmentTeacherSurveyListBinding3 != null) {
            return fragmentTeacherSurveyListBinding3.getRoot();
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
        ImageView imageView;
        ChipGroup chipGroup;
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Teacher Survey");
        }
        hideBaseView();
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        RecyclerView recyclerView = fragmentTeacherSurveyListBinding != null ? fragmentTeacherSurveyListBinding.rvTeacherSurvey : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        listenResponse();
        setupSearch();
        TeacherSurveyViewModel teacherSurveyViewModel = getTeacherSurveyViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        teacherSurveyViewModel.getSurveyList(str);
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 != null && (swipeRefreshLayout = fragmentTeacherSurveyListBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    TeacherSurveyFragment.setUp$lambda$1(this.f$0);
                }
            });
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding3 = get_binding();
        if (fragmentTeacherSurveyListBinding3 != null && (chipGroup = fragmentTeacherSurveyListBinding3.chipGroupFilter) != null) {
            chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda3
                @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
                public final void onCheckedChanged(ChipGroup chipGroup2, List list) {
                    TeacherSurveyFragment.setUp$lambda$2(this.f$0, chipGroup2, list);
                }
            });
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding4 = get_binding();
        if (fragmentTeacherSurveyListBinding4 == null || (imageView = fragmentTeacherSurveyListBinding4.ivFilter) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeacherSurveyFragment.setUp$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(TeacherSurveyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherSurveyViewModel teacherSurveyViewModel = this$0.getTeacherSurveyViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        teacherSurveyViewModel.getSurveyList(str);
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentTeacherSurveyListBinding != null ? fragmentTeacherSurveyListBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(TeacherSurveyFragment this$0, ChipGroup chipGroup, List checkedIds) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chipGroup, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(checkedIds, "checkedIds");
        Integer num = (Integer) CollectionsKt.firstOrNull(checkedIds);
        int i = R.id.chip_pending;
        if (num != null && num.intValue() == i) {
            str = "pending";
        } else {
            str = (num != null && num.intValue() == R.id.chip_completed) ? "completed" : "all";
        }
        this$0.currentFilter = str;
        this$0.getAdapter().setFilter(this$0.currentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(TeacherSurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAdapter().toggleSort();
    }

    private final void listenResponse() {
        getTeacherSurveyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TeacherSurveyFragment.listenResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void listenResponse$lambda$6(in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment r4, in.etuwa.app.utils.Resource r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            in.etuwa.app.utils.Status r0 = r5.getStatus()
            int[] r1 = in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L48
            r1 = 2
            if (r0 == r1) goto L44
            r1 = 3
            if (r0 == r1) goto L3d
            r1 = 4
            if (r0 == r1) goto L1f
            goto Laf
        L1f:
            r4.hideProgress()
            r4.showBaseView()
            in.etuwa.app.databinding.FragmentTeacherSurveyListBinding r4 = r4.get_binding()
            if (r4 == 0) goto Laf
            androidx.recyclerview.widget.RecyclerView r4 = r4.rvTeacherSurvey
            if (r4 == 0) goto Laf
            android.view.View r4 = (android.view.View) r4
            java.lang.String r5 = r5.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            in.etuwa.app.utils.ToastExtKt.showErrorToast(r4, r5)
            goto Laf
        L3d:
            r4.hideProgress()
            r4.showBaseView()
            goto Laf
        L44:
            r4.showProgress()
            goto Laf
        L48:
            r4.hideProgress()
            java.lang.Object r5 = r5.getData()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 == 0) goto Laf
            r4.showBaseView()
            in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter r0 = r4.getAdapter()
            r0.addItems(r5)
            in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter r0 = r4.getAdapter()
            r2 = 0
            in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter.applyCombinedFilter$default(r0, r2, r1, r2)
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            r2 = 0
            if (r0 == 0) goto La1
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r0 = r5 instanceof java.util.Collection
            if (r0 == 0) goto L81
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L81
        L7f:
            r5 = 1
            goto L9e
        L81:
            java.util.Iterator r5 = r5.iterator()
        L85:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L7f
            java.lang.Object r0 = r5.next()
            in.etuwa.app.data.model.survey.TeacherList r0 = (in.etuwa.app.data.model.survey.TeacherList) r0
            java.lang.String r0 = r0.getStatus()
            java.lang.String r3 = "Completed"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 != 0) goto L85
            r5 = 0
        L9e:
            if (r5 == 0) goto La1
            goto La2
        La1:
            r1 = 0
        La2:
            r4.flag = r1
            if (r1 == 0) goto Laf
            in.etuwa.app.helper.MainCallBackListener r5 = r4.listener
            if (r5 == 0) goto Laf
            java.lang.String r4 = r4.id
            r5.onSurveyCompleted(r2, r4)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment.listenResponse$lambda$6(in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment, in.etuwa.app.utils.Resource):void");
    }

    private final void setupSearch() {
        EditText editText;
        ImageView imageView;
        ImageView imageView2;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding != null && (imageView2 = fragmentTeacherSurveyListBinding.ivSearch) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherSurveyFragment.setupSearch$lambda$7(this.f$0, view);
                }
            });
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 != null && (imageView = fragmentTeacherSurveyListBinding2.ivClearSearch) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeacherSurveyFragment.setupSearch$lambda$8(this.f$0, view);
                }
            });
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding3 = get_binding();
        if (fragmentTeacherSurveyListBinding3 == null || (editText = fragmentTeacherSurveyListBinding3.searchInput) == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyFragment.setupSearch.3
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
                FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding4 = TeacherSurveyFragment.this.get_binding();
                ImageView imageView3 = fragmentTeacherSurveyListBinding4 != null ? fragmentTeacherSurveyListBinding4.ivClearSearch : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(string.length() > 0 ? 0 : 8);
                }
                TeacherSurveyFragment.this.getAdapter().applyCombinedFilter(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$7(TeacherSurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSearchOpen) {
            this$0.closeSearch();
        } else {
            this$0.openSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearch$lambda$8(TeacherSurveyFragment this$0, View view) {
        EditText editText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = this$0.get_binding();
        if (fragmentTeacherSurveyListBinding == null || (editText = fragmentTeacherSurveyListBinding.searchInput) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    private final void openSearch() {
        EditText editText;
        ImageView imageView;
        this.isSearchOpen = true;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        CardView cardView = fragmentTeacherSurveyListBinding != null ? fragmentTeacherSurveyListBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 != null && (imageView = fragmentTeacherSurveyListBinding2.ivSearch) != null) {
            imageView.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding3 = get_binding();
        ImageView imageView2 = fragmentTeacherSurveyListBinding3 != null ? fragmentTeacherSurveyListBinding3.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding4 = get_binding();
        if (fragmentTeacherSurveyListBinding4 != null && (editText = fragmentTeacherSurveyListBinding4.searchInput) != null) {
            editText.requestFocus();
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding5 = get_binding();
        inputMethodManager.showSoftInput(fragmentTeacherSurveyListBinding5 != null ? fragmentTeacherSurveyListBinding5.searchInput : null, 1);
    }

    private final void closeSearch() {
        EditText editText;
        ImageView imageView;
        EditText editText2;
        Editable text;
        this.isSearchOpen = false;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        IBinder windowToken = null;
        CardView cardView = fragmentTeacherSurveyListBinding != null ? fragmentTeacherSurveyListBinding.searchCard : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding2 = get_binding();
        if (fragmentTeacherSurveyListBinding2 != null && (editText2 = fragmentTeacherSurveyListBinding2.searchInput) != null && (text = editText2.getText()) != null) {
            text.clear();
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding3 = get_binding();
        if (fragmentTeacherSurveyListBinding3 != null && (imageView = fragmentTeacherSurveyListBinding3.ivSearch) != null) {
            imageView.setImageResource(R.drawable.ic_search);
        }
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding4 = get_binding();
        ImageView imageView2 = fragmentTeacherSurveyListBinding4 != null ? fragmentTeacherSurveyListBinding4.ivSearch : null;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding5 = get_binding();
        if (fragmentTeacherSurveyListBinding5 != null && (editText = fragmentTeacherSurveyListBinding5.searchInput) != null) {
            windowToken = editText.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        getAdapter().applyCombinedFilter("");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding == null || (recyclerView = fragmentTeacherSurveyListBinding.rvTeacherSurvey) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTeacherSurveyListBinding fragmentTeacherSurveyListBinding = get_binding();
        if (fragmentTeacherSurveyListBinding == null || (recyclerView = fragmentTeacherSurveyListBinding.rvTeacherSurvey) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter.SurveyCallBack
    public void doTheSurvey(String teacherId, String subjectId, String image, String semester, String subject, String teacherName) {
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(teacherName, "teacherName");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            String str = this.id;
            Intrinsics.checkNotNull(str);
            mainCallBackListener.doTeacherSurvey(str, teacherId, subjectId, image, semester, subject, teacherName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        }
    }
}