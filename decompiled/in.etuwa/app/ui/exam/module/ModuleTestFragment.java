package in.etuwa.app.ui.exam.module;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
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
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.data.model.exam.ModuleTestResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ModuleTestFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.ui.exam.questions.QuestionDialog;
import in.etuwa.app.ui.exam.submit.SubmitExamDialog;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ModuleTestFragment.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020$H\u0014J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0002J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u00020$H\u0016J\b\u00108\u001a\u00020$H\u0016J\u0010\u00109\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016J-\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020)2\u000e\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0=2\u0006\u0010>\u001a\u00020?H\u0016¢\u0006\u0002\u0010@J\u001a\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u000105H\u0016J \u0010C\u001a\u00020$2\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020E0\u0010j\b\u0012\u0004\u0012\u00020E`\u0012H\u0016J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0014J\b\u0010H\u001a\u00020$H\u0014J\b\u0010I\u001a\u00020$H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001d¨\u0006K"}, d2 = {"Lin/etuwa/app/ui/exam/module/ModuleTestFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/exam/ExamListener;", "()V", "_binding", "Lin/etuwa/app/databinding/ModuleTestFragmentBinding;", "adapter", "Lin/etuwa/app/ui/exam/module/ModuleTestAdapter;", "getAdapter", "()Lin/etuwa/app/ui/exam/module/ModuleTestAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ModuleTestFragmentBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "moduleTestViewModel", "Lin/etuwa/app/ui/exam/module/ModuleTestViewModel;", "getModuleTestViewModel", "()Lin/etuwa/app/ui/exam/module/ModuleTestViewModel;", "moduleTestViewModel$delegate", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "checkFileExistence", "", "fileName", "", "deleteExam", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onPickDoc", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "openDownloadDialog", "list", "Lin/etuwa/app/data/model/exam/ExamFiles;", "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ModuleTestFragment extends BaseFragment implements ExamListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ModuleTestFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;

    /* renamed from: moduleTestViewModel$delegate, reason: from kotlin metadata */
    private final Lazy moduleTestViewModel;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: ModuleTestFragment.kt */
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
    public static final ModuleTestFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ModuleTestFragment() {
        final ModuleTestFragment moduleTestFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(moduleTestFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.moduleTestViewModel = FragmentViewModelLazyKt.createViewModelLazy(moduleTestFragment, Reflection.getOrCreateKotlinClass(ModuleTestViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ModuleTestViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ModuleTestFragment moduleTestFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ModuleTestAdapter>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.exam.module.ModuleTestAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ModuleTestAdapter invoke() {
                ComponentCallbacks componentCallbacks = moduleTestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ModuleTestAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = moduleTestFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                ModuleTestAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = ModuleTestFragment.this.downList;
                    ModuleTestFragment moduleTestFragment3 = ModuleTestFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = moduleTestFragment3.getAdapter();
                            arrayList2 = moduleTestFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = moduleTestFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final ModuleTestViewModel getModuleTestViewModel() {
        return (ModuleTestViewModel) this.moduleTestViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModuleTestAdapter getAdapter() {
        return (ModuleTestAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ModuleTestFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: ModuleTestFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/exam/module/ModuleTestFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/exam/module/ModuleTestFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ModuleTestFragment newInstance() {
            return new ModuleTestFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ModuleTestFragmentBinding.inflate(inflater, container, false);
        ModuleTestFragmentBinding moduleTestFragmentBinding = get_binding();
        if (moduleTestFragmentBinding != null) {
            moduleTestFragmentBinding.setModuleTestViewModel(getModuleTestViewModel());
        }
        ModuleTestFragmentBinding moduleTestFragmentBinding2 = get_binding();
        if (moduleTestFragmentBinding2 != null) {
            moduleTestFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ModuleTestFragmentBinding moduleTestFragmentBinding3 = get_binding();
        if (moduleTestFragmentBinding3 != null) {
            return moduleTestFragmentBinding3.getRoot();
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
        TextView textView;
        TextView textView2;
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.module_test));
        }
        hideBaseView();
        ModuleTestFragmentBinding moduleTestFragmentBinding = get_binding();
        RecyclerView recyclerView2 = moduleTestFragmentBinding != null ? moduleTestFragmentBinding.rvExam : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        getAdapter().setExamListener(this);
        ModuleTestFragmentBinding moduleTestFragmentBinding2 = get_binding();
        if (moduleTestFragmentBinding2 != null && (recyclerView = moduleTestFragmentBinding2.rvExam) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool.setMaxRecycledViews(0, 0);
        }
        ModuleTestFragmentBinding moduleTestFragmentBinding3 = get_binding();
        if (moduleTestFragmentBinding3 != null && (textView2 = moduleTestFragmentBinding3.coveredModule) != null) {
            textView2.setBackgroundColor(Color.rgb(34, 139, 34));
        }
        ModuleTestFragmentBinding moduleTestFragmentBinding4 = get_binding();
        if (moduleTestFragmentBinding4 != null && (textView = moduleTestFragmentBinding4.notCoveredModule) != null) {
            textView.setBackgroundColor(Color.rgb(225, 51, 0));
        }
        getPreference().setNewLogin(false);
        listenResponse();
        ModuleTestFragmentBinding moduleTestFragmentBinding5 = get_binding();
        if (moduleTestFragmentBinding5 == null || (swipeRefreshLayout = moduleTestFragmentBinding5.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ModuleTestFragment.setUp$lambda$0(ModuleTestFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ModuleTestFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getModuleTestViewModel().getExams();
        ModuleTestFragmentBinding moduleTestFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = moduleTestFragmentBinding != null ? moduleTestFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getModuleTestViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModuleTestFragment.listenResponse$lambda$2(ModuleTestFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(ModuleTestFragment this$0, Resource resource) {
        RecyclerView rvExam;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ModuleTestResponse moduleTestResponse = (ModuleTestResponse) resource.getData();
            if (moduleTestResponse != null) {
                this$0.showBaseView();
                if (moduleTestResponse.getLogin()) {
                    this$0.getAdapter().addItems(moduleTestResponse.getModuleTest());
                    return;
                }
                ModuleTestFragmentBinding moduleTestFragmentBinding = this$0.get_binding();
                if (moduleTestFragmentBinding == null || (rvExam = moduleTestFragmentBinding.rvExam) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExam, "rvExam");
                ToastExtKt.showErrorToast(rvExam, moduleTestResponse.getError());
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
        ModuleTestFragmentBinding moduleTestFragmentBinding2 = this$0.get_binding();
        if (moduleTestFragmentBinding2 == null || (recyclerView = moduleTestFragmentBinding2.rvExam) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            SubmitExamDialog newInstance = SubmitExamDialog.INSTANCE.newInstance(id, 1);
            newInstance.setUploadCallBack(this);
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void downloadFile(String url, int position) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(replace)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.UPLOAD_MODULE_TEST_PATH);
                return;
            }
            try {
                ModuleTestFragmentBinding moduleTestFragmentBinding = get_binding();
                if (moduleTestFragmentBinding != null && (recyclerView = moduleTestFragmentBinding.rvExam) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.UPLOAD_MODULE_TEST_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.UPLOAD_MODULE_TEST_PATH);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void deleteExam(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.delete_exam_msg));
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ModuleTestFragment.deleteExam$lambda$3(ModuleTestFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$3(ModuleTestFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getModuleTestViewModel().deleteExam(id);
        this$0.listenDeleteResponse();
    }

    private final void listenDeleteResponse() {
        getModuleTestViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModuleTestFragment.listenDeleteResponse$lambda$5(ModuleTestFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$5(ModuleTestFragment this$0, Resource resource) {
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
            ModuleTestFragmentBinding moduleTestFragmentBinding = this$0.get_binding();
            if (moduleTestFragmentBinding == null || (recyclerView = moduleTestFragmentBinding.rvExam) == null) {
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
                ModuleTestFragmentBinding moduleTestFragmentBinding2 = this$0.get_binding();
                if (moduleTestFragmentBinding2 != null && (rvExam2 = moduleTestFragmentBinding2.rvExam) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvExam2, "rvExam");
                    ToastExtKt.showSuccessToast(rvExam2, successResponse.getMessage());
                }
                this$0.getModuleTestViewModel().getExams();
                return;
            }
            ModuleTestFragmentBinding moduleTestFragmentBinding3 = this$0.get_binding();
            if (moduleTestFragmentBinding3 == null || (rvExam = moduleTestFragmentBinding3.rvExam) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExam, "rvExam");
            ToastExtKt.showErrorToast(rvExam, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void openDownloadDialog(ArrayList<ExamFiles> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        QuestionDialog.INSTANCE.newInstance(list, false).show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void onDismiss() {
        getModuleTestViewModel().getExams();
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.exam.module.ModuleTestFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ModuleTestFragment.requestPermission$lambda$6(ModuleTestFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(ModuleTestFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            try {
                if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                    if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        new ValidChecker(requireContext).showPermissionDialog();
                    } else {
                        Toast.makeText(requireContext(), "Permission Denied, You cannot Upload Profile Image .", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        ModuleTestFragmentBinding moduleTestFragmentBinding = get_binding();
        if (moduleTestFragmentBinding == null || (recyclerView = moduleTestFragmentBinding.rvExam) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        ModuleTestFragmentBinding moduleTestFragmentBinding = get_binding();
        if (moduleTestFragmentBinding == null || (recyclerView = moduleTestFragmentBinding.rvExam) == null) {
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
}