package in.etuwa.app.ui.grievance.view.doc;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import in.etuwa.app.data.model.grievance.view.GrievanceDoc;
import in.etuwa.app.databinding.GrievanceDocDialogBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.grievance.view.doc.GrievanceDocAdapter;
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

/* compiled from: GrievanceDocDialog.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0005H\u0017J\b\u0010)\u001a\u00020&H\u0014J\u0012\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020&H\u0016J\b\u00104\u001a\u00020&H\u0016J-\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u00052\u000e\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020!082\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;J\u001a\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0014J\b\u0010@\u001a\u00020&H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocAdapter$GrievanceDocListener;", "()V", "REQUEST_CODE", "", "_binding", "Lin/etuwa/app/databinding/GrievanceDocDialogBinding;", "adapter", "Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocAdapter;", "getAdapter", "()Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/GrievanceDocDialogBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "fileType", "", "Ljava/lang/Boolean;", "grDocs", "Lin/etuwa/app/data/model/grievance/view/GrievanceDoc;", "grievanceDocDialogViewModel", "Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocDialogViewModel;", "getGrievanceDocDialogViewModel", "()Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocDialogViewModel;", "grievanceDocDialogViewModel$delegate", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "path", "", "checkFileExistence", "fileName", "checkPermissions", "downloadFile", "", "url", CommonCssConstants.POSITION, "hideProgress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GrievanceDocDialog extends BaseDialog implements GrievanceDocAdapter.GrievanceDocListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int REQUEST_CODE;
    private GrievanceDocDialogBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private Boolean fileType;
    private ArrayList<GrievanceDoc> grDocs;

    /* renamed from: grievanceDocDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy grievanceDocDialogViewModel;
    private final BroadcastReceiver onDownloadComplete;
    private String path;

    @JvmStatic
    public static final GrievanceDocDialog newInstance(ArrayList<GrievanceDoc> arrayList, boolean z) {
        return INSTANCE.newInstance(arrayList, z);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public GrievanceDocDialog() {
        final GrievanceDocDialog grievanceDocDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(grievanceDocDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.grievanceDocDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(grievanceDocDialog, Reflection.getOrCreateKotlinClass(GrievanceDocDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(GrievanceDocDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final GrievanceDocDialog grievanceDocDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GrievanceDocAdapter>() { // from class: in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.grievance.view.doc.GrievanceDocAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GrievanceDocAdapter invoke() {
                ComponentCallbacks componentCallbacks = grievanceDocDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(GrievanceDocAdapter.class), b2, b3);
            }
        });
        this.REQUEST_CODE = 1;
        this.grDocs = new ArrayList<>();
        this.downList = new ArrayList<>();
        this.path = "";
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                GrievanceDocAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = GrievanceDocDialog.this.downList;
                    GrievanceDocDialog grievanceDocDialog3 = GrievanceDocDialog.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = grievanceDocDialog3.getAdapter();
                            arrayList2 = grievanceDocDialog3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = grievanceDocDialog3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final GrievanceDocDialogViewModel getGrievanceDocDialogViewModel() {
        return (GrievanceDocDialogViewModel) this.grievanceDocDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GrievanceDocAdapter getAdapter() {
        return (GrievanceDocAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final GrievanceDocDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: GrievanceDocDialog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/grievance/view/doc/GrievanceDocDialog;", "docs", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/grievance/view/GrievanceDoc;", "type", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GrievanceDocDialog newInstance(ArrayList<GrievanceDoc> docs, boolean type) {
            Intrinsics.checkNotNullParameter(docs, "docs");
            GrievanceDocDialog grievanceDocDialog = new GrievanceDocDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(GrievanceDocDialogKt.ARG_GR_DOCS, docs);
            bundle.putBoolean("type", type);
            grievanceDocDialog.setArguments(bundle);
            return grievanceDocDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<GrievanceDoc> parcelableArrayList = arguments.getParcelableArrayList(GrievanceDocDialogKt.ARG_GR_DOCS);
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            } else {
                Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "it.getParcelableArrayLis…RG_GR_DOCS)?: ArrayList()");
            }
            this.grDocs = parcelableArrayList;
            this.fileType = Boolean.valueOf(arguments.getBoolean("type"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = GrievanceDocDialogBinding.inflate(inflater, container, false);
        GrievanceDocDialogBinding grievanceDocDialogBinding = get_binding();
        if (grievanceDocDialogBinding != null) {
            grievanceDocDialogBinding.setGrievanceDocDialogViewModel(getGrievanceDocDialogViewModel());
        }
        GrievanceDocDialogBinding grievanceDocDialogBinding2 = get_binding();
        if (grievanceDocDialogBinding2 != null) {
            grievanceDocDialogBinding2.setLifecycleOwner(this);
        }
        GrievanceDocDialogBinding grievanceDocDialogBinding3 = get_binding();
        if (grievanceDocDialogBinding3 != null) {
            return grievanceDocDialogBinding3.getRoot();
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
        GrievanceDocDialogBinding grievanceDocDialogBinding = get_binding();
        RecyclerView recyclerView = grievanceDocDialogBinding != null ? grievanceDocDialogBinding.rvGrDocs : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().addItems(this.grDocs);
        getAdapter().setGrievanceDocListener(this);
        try {
            Boolean bool = this.fileType;
            Intrinsics.checkNotNull(bool);
            this.path = bool.booleanValue() ? AppConstant.GRIEVANCE_PATH : AppConstant.GRIEVANCE_REPLY_PATH;
        } catch (Exception unused) {
        }
    }

    @Override // in.etuwa.app.ui.grievance.view.doc.GrievanceDocAdapter.GrievanceDocListener
    public void downloadFile(String url, int position) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        if (checkPermissions()) {
            System.out.println((Object) "");
        } else {
            System.out.println((Object) "");
        }
        if (Build.VERSION.SDK_INT >= 34 || checkPermissions()) {
            if (checkFileExistence(replace)) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                new DownloadManagerHelper(requireContext).openFile(replace, AppConstant.GRIEVANCE_PATH);
                return;
            }
            try {
                GrievanceDocDialogBinding grievanceDocDialogBinding = get_binding();
                if (grievanceDocDialogBinding != null && (recyclerView = grievanceDocDialogBinding.rvGrDocs) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext2).startDownloading(AppConstant.UPLOAD_SERIES_EXAM_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception e) {
                Log.e("DownloadError", "Error during download: " + e.getMessage());
                return;
            }
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.grievance.view.doc.GrievanceDocAdapter.GrievanceDocListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.GRIEVANCE_PATH);
    }

    private final boolean checkPermissions() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_EXTERNAL_STORAGE");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        Log.d("Permissions", "Read Permission: " + checkSelfPermission + ", Write Permission: " + checkSelfPermission2);
        return checkSelfPermission == 0 && checkSelfPermission2 == 0;
    }

    private final void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
            new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GrievanceDocDialog.requestPermission$lambda$1(GrievanceDocDialog.this, dialogInterface, i);
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$1(GrievanceDocDialog this$0, DialogInterface dialogInterface, int i) {
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setGrievanceDocListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}