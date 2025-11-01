package in.etuwa.app.ui.studymaterials.download;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogMaterialDownloadBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.studymaterials.download.MaterialDownloadAdapter;
import in.etuwa.app.utils.AppConstant;
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

/* compiled from: MaterialDownloadDialog.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u001dH\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020*H\u0014J\b\u0010.\u001a\u00020*H\u0002J\u0012\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00108\u001a\u00020*H\u0016J\b\u00109\u001a\u00020*H\u0016J\u001a\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010<\u001a\u00020*H\u0014J\b\u0010=\u001a\u00020*H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadAdapter$QuestionListener;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogMaterialDownloadBinding;", "adapter", "Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadAdapter;", "getAdapter", "()Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogMaterialDownloadBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "examType", "", "Ljava/lang/Boolean;", "materialDownloadViewModel", "Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadViewModel;", "getMaterialDownloadViewModel", "()Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadViewModel;", "materialDownloadViewModel$delegate", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "path", "", "pos", "", "Ljava/lang/Integer;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semId", "checkFileExistence", "fileName", "downloadFile", "", "url", CommonCssConstants.POSITION, "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MaterialDownloadDialog extends BaseDialog implements MaterialDownloadAdapter.QuestionListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogMaterialDownloadBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private Boolean examType;

    /* renamed from: materialDownloadViewModel$delegate, reason: from kotlin metadata */
    private final Lazy materialDownloadViewModel;
    private final BroadcastReceiver onDownloadComplete;
    private String path;
    private Integer pos;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* compiled from: MaterialDownloadDialog.kt */
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
    public static final MaterialDownloadDialog newInstance(int i, String str) {
        return INSTANCE.newInstance(i, str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public MaterialDownloadDialog() {
        final MaterialDownloadDialog materialDownloadDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(materialDownloadDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.materialDownloadViewModel = FragmentViewModelLazyKt.createViewModelLazy(materialDownloadDialog, Reflection.getOrCreateKotlinClass(MaterialDownloadViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MaterialDownloadViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MaterialDownloadDialog materialDownloadDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MaterialDownloadAdapter>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.studymaterials.download.MaterialDownloadAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDownloadAdapter invoke() {
                ComponentCallbacks componentCallbacks = materialDownloadDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MaterialDownloadAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = materialDownloadDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.downList = new ArrayList<>();
        this.path = "";
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                MaterialDownloadAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = MaterialDownloadDialog.this.downList;
                    MaterialDownloadDialog materialDownloadDialog3 = MaterialDownloadDialog.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = materialDownloadDialog3.getAdapter();
                            arrayList2 = materialDownloadDialog3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = materialDownloadDialog3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final MaterialDownloadViewModel getMaterialDownloadViewModel() {
        return (MaterialDownloadViewModel) this.materialDownloadViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MaterialDownloadAdapter getAdapter() {
        return (MaterialDownloadAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogMaterialDownloadBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: MaterialDownloadDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadDialog;", CommonCssConstants.POSITION, "", "semId", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MaterialDownloadDialog newInstance(int position, String semId) {
            Intrinsics.checkNotNullParameter(semId, "semId");
            MaterialDownloadDialog materialDownloadDialog = new MaterialDownloadDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("questions", position);
            bundle.putString("actions", semId);
            materialDownloadDialog.setArguments(bundle);
            return materialDownloadDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt("questions"));
            this.semId = arguments.getString("actions");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogMaterialDownloadBinding.inflate(inflater, container, false);
        DialogMaterialDownloadBinding dialogMaterialDownloadBinding = get_binding();
        if (dialogMaterialDownloadBinding != null) {
            dialogMaterialDownloadBinding.setMaterialDownloadViewModel(getMaterialDownloadViewModel());
        }
        DialogMaterialDownloadBinding dialogMaterialDownloadBinding2 = get_binding();
        if (dialogMaterialDownloadBinding2 != null) {
            dialogMaterialDownloadBinding2.setLifecycleOwner(this);
        }
        DialogMaterialDownloadBinding dialogMaterialDownloadBinding3 = get_binding();
        if (dialogMaterialDownloadBinding3 != null) {
            return dialogMaterialDownloadBinding3.getRoot();
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
        getPreference().setNewLogin(false);
        DialogMaterialDownloadBinding dialogMaterialDownloadBinding = get_binding();
        RecyclerView recyclerView = dialogMaterialDownloadBinding != null ? dialogMaterialDownloadBinding.rvExamDocs : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setQuestionListener(this);
        listenResponse();
        MaterialDownloadViewModel materialDownloadViewModel = getMaterialDownloadViewModel();
        String str = this.semId;
        Intrinsics.checkNotNull(str);
        materialDownloadViewModel.getMaterials(str);
        try {
            Boolean bool = this.examType;
            Intrinsics.checkNotNull(bool);
            bool.booleanValue();
            this.path = AppConstant.MATERIALS_PATH;
        } catch (Exception unused) {
        }
    }

    private final void listenResponse() {
        getMaterialDownloadViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaterialDownloadDialog.listenResponse$lambda$2(MaterialDownloadDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(MaterialDownloadDialog this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                MaterialDownloadAdapter adapter = this$0.getAdapter();
                Integer num = this$0.pos;
                Intrinsics.checkNotNull(num);
                adapter.addItems(((MaterialsNew) arrayList.get(num.intValue())).getUrl());
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
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        DialogMaterialDownloadBinding dialogMaterialDownloadBinding = this$0.get_binding();
        if (dialogMaterialDownloadBinding == null || (recyclerView = dialogMaterialDownloadBinding.rvExamDocs) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.studymaterials.download.MaterialDownloadAdapter.QuestionListener
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
                new DownloadManagerHelper(requireContext2).openFile(replace, this.path);
                return;
            }
            try {
                DialogMaterialDownloadBinding dialogMaterialDownloadBinding = get_binding();
                if (dialogMaterialDownloadBinding != null && (recyclerView = dialogMaterialDownloadBinding.rvExamDocs) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(this.path, url);
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

    @Override // in.etuwa.app.ui.studymaterials.download.MaterialDownloadAdapter.QuestionListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, this.path);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setQuestionListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}