package in.etuwa.app.ui.exam.series;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SeriesExamFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.ui.exam.questions.QuestionDialog;
import in.etuwa.app.ui.exam.submit.SubmitExamDialog;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: SeriesExamFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SeriesExamFragment extends BaseFragment implements ExamListener, SemListDialogTwo.SemDialogCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int REQUEST_CODE;
    private SeriesExamFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String current;
    private ArrayList<DownloadModel> downList;
    private boolean flag;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* JADX INFO: renamed from: seriesExamViewModel$delegate, reason: from kotlin metadata */
    private final Lazy seriesExamViewModel;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: compiled from: SeriesExamFragment.kt */
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
    public static final SeriesExamFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SeriesExamFragment() {
        final SeriesExamFragment seriesExamFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return seriesExamFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(seriesExamFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.seriesExamViewModel = FragmentViewModelLazyKt.createViewModelLazy(seriesExamFragment, Reflection.getOrCreateKotlinClass(SeriesExamViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SeriesExamViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SeriesExamFragment seriesExamFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SeriesAdapter>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.exam.series.SeriesAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SeriesAdapter invoke() {
                ComponentCallbacks componentCallbacks = seriesExamFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SeriesAdapter.class), b2, b3);
            }
        });
        this.REQUEST_CODE = 1;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$spinnerAdapter$2
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
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = seriesExamFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = seriesExamFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
        this.downList = new ArrayList<>();
        this.current = "";
        this.semId = getPreference().getUserSemId();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    ArrayList arrayList = this.this$0.downList;
                    SeriesExamFragment seriesExamFragment3 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            seriesExamFragment3.getAdapter().notifyDataChanged(((DownloadModel) seriesExamFragment3.downList.get(i)).getPosition());
                            seriesExamFragment3.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SeriesExamViewModel getSeriesExamViewModel() {
        return (SeriesExamViewModel) this.seriesExamViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SeriesAdapter getAdapter() {
        return (SeriesAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final SeriesExamFragmentBinding get_binding() {
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

    public final String getSemId() {
        return this.semId;
    }

    public final void setSemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semId = str;
    }

    /* JADX INFO: compiled from: SeriesExamFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/exam/series/SeriesExamFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/exam/series/SeriesExamFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SeriesExamFragment newInstance() {
            return new SeriesExamFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SeriesExamFragmentBinding.inflate(inflater, container, false);
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        if (seriesExamFragmentBinding != null) {
            seriesExamFragmentBinding.setSeriesExamViewModel(getSeriesExamViewModel());
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding2 = get_binding();
        if (seriesExamFragmentBinding2 != null) {
            seriesExamFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding3 = get_binding();
        if (seriesExamFragmentBinding3 != null) {
            return seriesExamFragmentBinding3.getRoot();
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
        FloatingActionButton floatingActionButton;
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.series_exam));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        RecyclerView recyclerView2 = seriesExamFragmentBinding != null ? seriesExamFragmentBinding.rvExam : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        getAdapter().setExamListener(this);
        SeriesExamFragmentBinding seriesExamFragmentBinding2 = get_binding();
        if (seriesExamFragmentBinding2 != null && (recyclerView = seriesExamFragmentBinding2.rvExam) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool.setMaxRecycledViews(0, 0);
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding3 = get_binding();
        Spinner spinner = seriesExamFragmentBinding3 != null ? seriesExamFragmentBinding3.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSemResponse();
        listenResponse();
        SeriesExamFragmentBinding seriesExamFragmentBinding4 = get_binding();
        if (seriesExamFragmentBinding4 != null && (floatingActionButton = seriesExamFragmentBinding4.fabSeriesSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SeriesExamFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        getSeriesExamViewModel().getExams(this.semId);
        SeriesExamFragmentBinding seriesExamFragmentBinding5 = get_binding();
        Spinner spinner2 = seriesExamFragmentBinding5 != null ? seriesExamFragmentBinding5.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Spinner spinner3;
                    Semester semester = SeriesExamFragment.this.getSpinnerAdapter().getSemester(position);
                    if (SeriesExamFragment.this.flag) {
                        SeriesExamFragment.this.getSeriesExamViewModel().getExams(semester.getId());
                        SeriesExamFragment.this.current = semester.getId();
                        return;
                    }
                    SeriesExamFragment.this.flag = true;
                    int count = SeriesExamFragment.this.getSpinnerAdapter().getCount();
                    for (int i = 0; i < count; i++) {
                        if (Intrinsics.areEqual(SeriesExamFragment.this.getPreference().getUserSemId(), SeriesExamFragment.this.getSpinnerAdapter().getSemester(i).getId())) {
                            SeriesExamFragmentBinding seriesExamFragmentBinding6 = SeriesExamFragment.this.get_binding();
                            if (seriesExamFragmentBinding6 != null && (spinner3 = seriesExamFragmentBinding6.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                SeriesExamFragment.this.getSeriesExamViewModel().getExams(SeriesExamFragment.this.getPreference().getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding6 = get_binding();
        if (seriesExamFragmentBinding6 == null || (swipeRefreshLayout = seriesExamFragmentBinding6.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda6
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SeriesExamFragment.setUp$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(SeriesExamFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo semListDialogTwoNewInstance = SemListDialogTwo.INSTANCE.newInstance();
        semListDialogTwoNewInstance.setCallBack(this$0);
        semListDialogTwoNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SeriesExamFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSeriesExamViewModel().getSemester();
        this$0.getSeriesExamViewModel().getExams(this$0.getPreference().getUserSemId());
        SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = seriesExamFragmentBinding != null ? seriesExamFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
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
        getSeriesExamViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SeriesExamFragment.listenSemResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(SeriesExamFragment this$0, Resource resource) {
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
                SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
                if (seriesExamFragmentBinding != null && (swipeRefreshLayout2 = seriesExamFragmentBinding.swipeLayout) != null) {
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
            SeriesExamFragmentBinding seriesExamFragmentBinding2 = this$0.get_binding();
            if (seriesExamFragmentBinding2 == null || (recyclerView = seriesExamFragmentBinding2.rvExam) == null) {
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
            SeriesExamFragmentBinding seriesExamFragmentBinding3 = this$0.get_binding();
            Boolean boolValueOf2 = (seriesExamFragmentBinding3 == null || (swipeRefreshLayout = seriesExamFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue()) {
                SeriesExamFragmentBinding seriesExamFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = seriesExamFragmentBinding4 != null ? seriesExamFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        SeriesExamFragmentBinding seriesExamFragmentBinding5 = this$0.get_binding();
                        if (seriesExamFragmentBinding5 == null || (spinner = seriesExamFragmentBinding5.spinnerSem) == null) {
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
        getSeriesExamViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SeriesExamFragment.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(SeriesExamFragment this$0, Resource resource) {
        RecyclerView rvExam;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SeriesExamResponse seriesExamResponse = (SeriesExamResponse) resource.getData();
            if (seriesExamResponse != null) {
                this$0.showBaseView();
                if (seriesExamResponse.getLogin()) {
                    this$0.getAdapter().addItems(seriesExamResponse.getSeriesExams());
                    return;
                }
                SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
                if (seriesExamFragmentBinding == null || (rvExam = seriesExamFragmentBinding.rvExam) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExam, "rvExam");
                ToastExtKt.showErrorToast(rvExam, seriesExamResponse.getError());
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
        SeriesExamFragmentBinding seriesExamFragmentBinding2 = this$0.get_binding();
        if (seriesExamFragmentBinding2 == null || (recyclerView = seriesExamFragmentBinding2.rvExam) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter.TutorialListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            SubmitExamDialog submitExamDialogNewInstance = SubmitExamDialog.INSTANCE.newInstance(id, 0);
            submitExamDialogNewInstance.setUploadCallBack(this);
            submitExamDialogNewInstance.show(childFragmentManager, (String) null);
            return;
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public void downloadFile(String url, int position) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        if (checkPermissions()) {
            System.out.println((Object) "");
        } else {
            System.out.println((Object) "");
        }
        if (Build.VERSION.SDK_INT >= 34 || checkPermissions()) {
            if (checkFileExistence(strReplace)) {
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                new DownloadManagerHelper(contextRequireContext).openFile(strReplace, AppConstant.UPLOAD_SERIES_EXAM_PATH);
                return;
            }
            try {
                SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
                if (seriesExamFragmentBinding != null && (recyclerView = seriesExamFragmentBinding.rvExam) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext2).startDownloading(AppConstant.UPLOAD_SERIES_EXAM_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            } catch (Exception e) {
                Log.e("DownloadError", "Error during download: " + e.getMessage());
                return;
            }
        }
        requestPermission();
    }

    private final boolean checkPermissions() {
        int iCheckSelfPermission = ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_EXTERNAL_STORAGE");
        int iCheckSelfPermission2 = ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        Log.d("Permissions", "Read Permission: " + iCheckSelfPermission + ", Write Permission: " + iCheckSelfPermission2);
        return iCheckSelfPermission == 0 && iCheckSelfPermission2 == 0;
    }

    private final void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
            new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SeriesExamFragment.requestPermission$lambda$6(this.f$0, dialogInterface, i);
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(SeriesExamFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this$0.REQUEST_CODE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.REQUEST_CODE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                return;
            }
            Toast.makeText(requireContext(), "Permission denied. Unable to download files.", 0).show();
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.UPLOAD_SERIES_EXAM_PATH);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void deleteExam(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.delete_exam_msg));
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SeriesExamFragment.deleteExam$lambda$7(this.f$0, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$7(SeriesExamFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getSeriesExamViewModel().deleteExam(id);
        this$0.listenDeleteResponse();
    }

    private final void listenDeleteResponse() {
        getSeriesExamViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SeriesExamFragment.listenDeleteResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$9(SeriesExamFragment this$0, Resource resource) {
        RecyclerView rvExam;
        RecyclerView rvExam2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
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
            SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
            if (seriesExamFragmentBinding == null || (recyclerView = seriesExamFragmentBinding.rvExam) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getLogin() && successResponse.getSuccess()) {
                SeriesExamFragmentBinding seriesExamFragmentBinding2 = this$0.get_binding();
                if (seriesExamFragmentBinding2 != null && (rvExam2 = seriesExamFragmentBinding2.rvExam) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvExam2, "rvExam");
                    ToastExtKt.showSuccessToast(rvExam2, successResponse.getMessage());
                }
                this$0.getSeriesExamViewModel().getExams(this$0.current);
                return;
            }
            SeriesExamFragmentBinding seriesExamFragmentBinding3 = this$0.get_binding();
            if (seriesExamFragmentBinding3 == null || (rvExam = seriesExamFragmentBinding3.rvExam) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExam, "rvExam");
            ToastExtKt.showErrorToast(rvExam, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.HomeWorkListener
    public void openDownloadDialog(ArrayList<ExamFiles> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            QuestionDialog.INSTANCE.newInstance(list, true).show(childFragmentManager, (String) null);
        } catch (Exception unused) {
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener, in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog.UploadAssignmentCallBack
    public void onDismiss() {
        getSeriesExamViewModel().getExams(this.current);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        if (seriesExamFragmentBinding == null || (recyclerView = seriesExamFragmentBinding.rvExam) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        if (seriesExamFragmentBinding == null || (recyclerView = seriesExamFragmentBinding.rvExam) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setExamListener(null);
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
        getSeriesExamViewModel().getExams(id);
    }
}