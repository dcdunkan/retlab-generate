package in.etuwa.app.ui.homework.files;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.databinding.HomeWorkFilesDialogBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter;
import in.etuwa.app.utils.AppConstant;
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

/* compiled from: HomeWorkFilesDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020 H\u0014J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0016J\u001a\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00102\u001a\u00020 H\u0014J\b\u00103\u001a\u00020 H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lin/etuwa/app/ui/homework/files/HomeWorkFilesDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/homework/files/HomeWorkFilesAdapter$DocListener;", "()V", "_binding", "Lin/etuwa/app/databinding/HomeWorkFilesDialogBinding;", "adapter", "Lin/etuwa/app/ui/homework/files/HomeWorkFilesAdapter;", "getAdapter", "()Lin/etuwa/app/ui/homework/files/HomeWorkFilesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/HomeWorkFilesDialogBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "homeWorkFilesDialogViewModel", "Lin/etuwa/app/ui/homework/files/HomeWorkFilesDialogViewModel;", "getHomeWorkFilesDialogViewModel", "()Lin/etuwa/app/ui/homework/files/HomeWorkFilesDialogViewModel;", "homeWorkFilesDialogViewModel$delegate", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "questions", "Lin/etuwa/app/data/model/exam/ExamFiles;", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "hideProgress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeWorkFilesDialog extends BaseDialog implements HomeWorkFilesAdapter.DocListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HomeWorkFilesDialogBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;

    /* renamed from: homeWorkFilesDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy homeWorkFilesDialogViewModel;
    private final BroadcastReceiver onDownloadComplete;
    private ArrayList<ExamFiles> questions;

    @JvmStatic
    public static final HomeWorkFilesDialog newInstance(ArrayList<ExamFiles> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public HomeWorkFilesDialog() {
        final HomeWorkFilesDialog homeWorkFilesDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.homework.files.HomeWorkFilesDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(homeWorkFilesDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.homeWorkFilesDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(homeWorkFilesDialog, Reflection.getOrCreateKotlinClass(HomeWorkFilesDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.homework.files.HomeWorkFilesDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.homework.files.HomeWorkFilesDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HomeWorkFilesDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HomeWorkFilesDialog homeWorkFilesDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HomeWorkFilesAdapter>() { // from class: in.etuwa.app.ui.homework.files.HomeWorkFilesDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HomeWorkFilesAdapter invoke() {
                ComponentCallbacks componentCallbacks = homeWorkFilesDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HomeWorkFilesAdapter.class), b2, b3);
            }
        });
        this.questions = new ArrayList<>();
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.homework.files.HomeWorkFilesDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                HomeWorkFilesAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = HomeWorkFilesDialog.this.downList;
                    HomeWorkFilesDialog homeWorkFilesDialog3 = HomeWorkFilesDialog.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = homeWorkFilesDialog3.getAdapter();
                            arrayList2 = homeWorkFilesDialog3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = homeWorkFilesDialog3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final HomeWorkFilesDialogViewModel getHomeWorkFilesDialogViewModel() {
        return (HomeWorkFilesDialogViewModel) this.homeWorkFilesDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeWorkFilesAdapter getAdapter() {
        return (HomeWorkFilesAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final HomeWorkFilesDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: HomeWorkFilesDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/homework/files/HomeWorkFilesDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/homework/files/HomeWorkFilesDialog;", "questions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/ExamFiles;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HomeWorkFilesDialog newInstance(ArrayList<ExamFiles> questions) {
            Intrinsics.checkNotNullParameter(questions, "questions");
            HomeWorkFilesDialog homeWorkFilesDialog = new HomeWorkFilesDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("questions", questions);
            homeWorkFilesDialog.setArguments(bundle);
            return homeWorkFilesDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<ExamFiles> parcelableArrayList = arguments.getParcelableArrayList("questions");
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            } else {
                Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "it.getParcelableArrayLis…G_QUESTION)?: ArrayList()");
            }
            this.questions = parcelableArrayList;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = HomeWorkFilesDialogBinding.inflate(inflater, container, false);
        HomeWorkFilesDialogBinding homeWorkFilesDialogBinding = get_binding();
        if (homeWorkFilesDialogBinding != null) {
            homeWorkFilesDialogBinding.setHomeWorkFilesDialogViewModel(getHomeWorkFilesDialogViewModel());
        }
        HomeWorkFilesDialogBinding homeWorkFilesDialogBinding2 = get_binding();
        if (homeWorkFilesDialogBinding2 != null) {
            homeWorkFilesDialogBinding2.setLifecycleOwner(this);
        }
        HomeWorkFilesDialogBinding homeWorkFilesDialogBinding3 = get_binding();
        if (homeWorkFilesDialogBinding3 != null) {
            return homeWorkFilesDialogBinding3.getRoot();
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
        HomeWorkFilesDialogBinding homeWorkFilesDialogBinding = get_binding();
        RecyclerView recyclerView = homeWorkFilesDialogBinding != null ? homeWorkFilesDialogBinding.rvHwDocs : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().addItems(this.questions);
        getAdapter().setCallBack(this);
    }

    @Override // in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter.DocListener
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
                new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.HOME_WORK_PATH);
                return;
            }
            try {
                HomeWorkFilesDialogBinding homeWorkFilesDialogBinding = get_binding();
                if (homeWorkFilesDialogBinding != null && (recyclerView = homeWorkFilesDialogBinding.rvHwDocs) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.HOME_WORK_PATH, url);
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
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        new ValidChecker(requireContext4).showPermissionDialog();
    }

    @Override // in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter.DocListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.HOME_WORK_PATH);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}