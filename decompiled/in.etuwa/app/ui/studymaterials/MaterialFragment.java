package in.etuwa.app.ui.studymaterials;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.MaterialFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialog;
import in.etuwa.app.ui.studymaterials.MaterialAdapter;
import in.etuwa.app.ui.studymaterials.download.MaterialDownloadDialog;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

/* compiled from: MaterialFragment.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001ZB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020$H\u0016J8\u00107\u001a\u0002082\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020$0\u0011j\b\u0012\u0004\u0012\u00020$`\u00132\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000205H\u0017J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020$H\u0002J\u0010\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u000208H\u0014J\b\u0010C\u001a\u000208H\u0014J\b\u0010D\u001a\u000208H\u0002J \u0010E\u001a\u0002082\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013H\u0002J\u0010\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020$H\u0016J&\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u000208H\u0016J\b\u0010R\u001a\u000208H\u0016J\u0010\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020$H\u0016J\u001a\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010W\u001a\u000208H\u0014J\b\u0010X\u001a\u000208H\u0014J\b\u0010Y\u001a\u000208H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b0\u00101R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lin/etuwa/app/ui/studymaterials/MaterialFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/studymaterials/MaterialAdapter$MaterialDownload;", "Lin/etuwa/app/ui/result/university/semlistdialog/SemListDialog$SemDialogCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/MaterialFragmentBinding;", "adapter", "Lin/etuwa/app/ui/studymaterials/MaterialAdapter;", "getAdapter", "()Lin/etuwa/app/ui/studymaterials/MaterialAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/MaterialFragmentBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "fillList", "Lin/etuwa/app/data/model/materials/MaterialsNew;", "materialViewModel", "Lin/etuwa/app/ui/studymaterials/MaterialViewModel;", "getMaterialViewModel", "()Lin/etuwa/app/ui/studymaterials/MaterialViewModel;", "materialViewModel$delegate", "modList", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semId", "", "getSemId", "()Ljava/lang/String;", "setSemId", "(Ljava/lang/String;)V", "spinnerFillAdapter", "Lin/etuwa/app/ui/studymaterials/MaterialFilterAdapter;", "getSpinnerFillAdapter", "()Lin/etuwa/app/ui/studymaterials/MaterialFilterAdapter;", "spinnerFillAdapter$delegate", "spinnerModuleAdapter", "Lin/etuwa/app/ui/studymaterials/MaterialModuleAdapter;", "getSpinnerModuleAdapter", "()Lin/etuwa/app/ui/studymaterials/MaterialModuleAdapter;", "spinnerModuleAdapter$delegate", "subList", "checkFileExistence", "", "fileName", "downloadFile", "", "url", "url2", CommonCssConstants.POSITION, "", "flag", SvgConstants.Tags.FILTER, "text", "filterModule", "module", "hideBaseView", "hideProgress", "listenResponse", "loadFilter", "response", "loadSelectedSem", "id", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onLinkClick", "link", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MaterialFragment extends BaseFragment implements MaterialAdapter.MaterialDownload, SemListDialog.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MaterialFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private final ArrayList<MaterialsNew> fillList;

    /* renamed from: materialViewModel$delegate, reason: from kotlin metadata */
    private final Lazy materialViewModel;
    private final ArrayList<MaterialsNew> modList;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* renamed from: spinnerFillAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerFillAdapter;

    /* renamed from: spinnerModuleAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerModuleAdapter;
    private final ArrayList<MaterialsNew> subList;

    /* compiled from: MaterialFragment.kt */
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
    public static final MaterialFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public MaterialFragment() {
        final MaterialFragment materialFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(materialFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.materialViewModel = FragmentViewModelLazyKt.createViewModelLazy(materialFragment, Reflection.getOrCreateKotlinClass(MaterialViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MaterialViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MaterialFragment materialFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MaterialAdapter>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.studymaterials.MaterialAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialAdapter invoke() {
                ComponentCallbacks componentCallbacks = materialFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MaterialAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$spinnerFillAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MaterialFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerFillAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<MaterialFilterAdapter>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.studymaterials.MaterialFilterAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialFilterAdapter invoke() {
                ComponentCallbacks componentCallbacks = materialFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MaterialFilterAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$spinnerModuleAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MaterialFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerModuleAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<MaterialModuleAdapter>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.studymaterials.MaterialModuleAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialModuleAdapter invoke() {
                ComponentCallbacks componentCallbacks = materialFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MaterialModuleAdapter.class), b5, function03);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = materialFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b6, b7);
            }
        });
        this.fillList = new ArrayList<>();
        this.modList = new ArrayList<>();
        this.subList = new ArrayList<>();
        this.semId = getPreference().getUserSemId();
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                MaterialAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = MaterialFragment.this.downList;
                    MaterialFragment materialFragment3 = MaterialFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = materialFragment3.getAdapter();
                            arrayList2 = materialFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = materialFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final MaterialViewModel getMaterialViewModel() {
        return (MaterialViewModel) this.materialViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MaterialAdapter getAdapter() {
        return (MaterialAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final MaterialFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MaterialFilterAdapter getSpinnerFillAdapter() {
        return (MaterialFilterAdapter) this.spinnerFillAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MaterialModuleAdapter getSpinnerModuleAdapter() {
        return (MaterialModuleAdapter) this.spinnerModuleAdapter.getValue();
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

    /* compiled from: MaterialFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/studymaterials/MaterialFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/studymaterials/MaterialFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MaterialFragment newInstance() {
            return new MaterialFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = MaterialFragmentBinding.inflate(inflater, container, false);
        MaterialFragmentBinding materialFragmentBinding = get_binding();
        if (materialFragmentBinding != null) {
            materialFragmentBinding.setMaterialViewModel(getMaterialViewModel());
        }
        MaterialFragmentBinding materialFragmentBinding2 = get_binding();
        if (materialFragmentBinding2 != null) {
            materialFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        MaterialFragmentBinding materialFragmentBinding3 = get_binding();
        if (materialFragmentBinding3 != null) {
            return materialFragmentBinding3.getRoot();
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
        FloatingActionButton floatingActionButton;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.studymaterials));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        MaterialFragmentBinding materialFragmentBinding = get_binding();
        RecyclerView recyclerView2 = materialFragmentBinding != null ? materialFragmentBinding.rvMaterials : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        MaterialFragmentBinding materialFragmentBinding2 = get_binding();
        if (materialFragmentBinding2 != null && (recyclerView = materialFragmentBinding2.rvMaterials) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool.setMaxRecycledViews(0, 0);
        }
        MaterialFragmentBinding materialFragmentBinding3 = get_binding();
        Spinner spinner = materialFragmentBinding3 != null ? materialFragmentBinding3.spinnerFill : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerFillAdapter());
        }
        MaterialFragmentBinding materialFragmentBinding4 = get_binding();
        Spinner spinner2 = materialFragmentBinding4 != null ? materialFragmentBinding4.spinnerModule : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerModuleAdapter());
        }
        getAdapter().setMaterialDownload(this);
        getMaterialViewModel().getMaterials(getPreference().getUserSemId());
        listenResponse();
        MaterialFragmentBinding materialFragmentBinding5 = get_binding();
        Spinner spinner3 = materialFragmentBinding5 != null ? materialFragmentBinding5.spinnerFill : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MaterialFilterAdapter spinnerFillAdapter;
                    spinnerFillAdapter = MaterialFragment.this.getSpinnerFillAdapter();
                    MaterialFragment.this.filter(spinnerFillAdapter.getData(position).getSubject());
                }
            });
        }
        MaterialFragmentBinding materialFragmentBinding6 = get_binding();
        Spinner spinner4 = materialFragmentBinding6 != null ? materialFragmentBinding6.spinnerModule : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MaterialModuleAdapter spinnerModuleAdapter;
                    spinnerModuleAdapter = MaterialFragment.this.getSpinnerModuleAdapter();
                    MaterialFragment.this.filterModule(spinnerModuleAdapter.getData(position).getModule());
                }
            });
        }
        MaterialFragmentBinding materialFragmentBinding7 = get_binding();
        if (materialFragmentBinding7 != null && (swipeRefreshLayout = materialFragmentBinding7.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    MaterialFragment.setUp$lambda$0(MaterialFragment.this);
                }
            });
        }
        MaterialFragmentBinding materialFragmentBinding8 = get_binding();
        if (materialFragmentBinding8 == null || (floatingActionButton = materialFragmentBinding8.fabUniv) == null) {
            return;
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialFragment.setUp$lambda$1(MaterialFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(MaterialFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMaterialViewModel().getMaterials(this$0.getPreference().getUserSemId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(MaterialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialog newInstance = SemListDialog.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.result.university.semlistdialog.SemListDialog.SemDialogCallBack
    public void loadSelectedSem(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getMaterialViewModel().getMaterials(id);
        this.semId = id;
    }

    private final void listenResponse() {
        getMaterialViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.studymaterials.MaterialFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaterialFragment.listenResponse$lambda$3(MaterialFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(MaterialFragment this$0, Resource resource) {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<MaterialsNew> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                MaterialFragmentBinding materialFragmentBinding = this$0.get_binding();
                Boolean valueOf = (materialFragmentBinding == null || (swipeRefreshLayout = materialFragmentBinding.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    MaterialFragmentBinding materialFragmentBinding2 = this$0.get_binding();
                    SwipeRefreshLayout swipeRefreshLayout2 = materialFragmentBinding2 != null ? materialFragmentBinding2.swipeLayout : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                this$0.showBaseView();
                this$0.loadFilter(arrayList);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        MaterialFragmentBinding materialFragmentBinding3 = this$0.get_binding();
        if (materialFragmentBinding3 != null && (recyclerView = materialFragmentBinding3.rvMaterials) != null) {
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
        }
        System.out.println((Object) resource.getMessage());
        System.out.println((Object) "it");
        System.out.println((Object) resource.getMessage());
    }

    private final void loadFilter(ArrayList<MaterialsNew> response) {
        this.subList.clear();
        this.subList.addAll(response);
        this.fillList.clear();
        this.fillList.add(new MaterialsNew("All", "All", "All", new ArrayList(), "", "All", "All", "All"));
        this.modList.clear();
        this.modList.add(new MaterialsNew("All", "All", "All", new ArrayList(), "", "All", "All", "All"));
        ArrayList<MaterialsNew> arrayList = this.fillList;
        ArrayList<MaterialsNew> arrayList2 = response;
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (hashSet.add(((MaterialsNew) obj).getSubject())) {
                arrayList3.add(obj);
            }
        }
        arrayList.addAll(arrayList3);
        ArrayList<MaterialsNew> arrayList4 = this.modList;
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (hashSet2.add(((MaterialsNew) obj2).getModule())) {
                arrayList5.add(obj2);
            }
        }
        arrayList4.addAll(arrayList5);
        getSpinnerFillAdapter().addItems(this.fillList);
        getSpinnerModuleAdapter().addItems(this.modList);
        filter("All");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filter(String text) {
        ArrayList<MaterialsNew> arrayList = new ArrayList<>();
        if (Intrinsics.areEqual(text, "All")) {
            Iterator<T> it = this.subList.iterator();
            while (it.hasNext()) {
                arrayList.add((MaterialsNew) it.next());
            }
        } else {
            for (MaterialsNew materialsNew : this.subList) {
                String lowerCase = materialsNew.getSubject().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = text.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    arrayList.add(materialsNew);
                }
            }
        }
        arrayList.remove(new MaterialsNew("All", "All", "All", new ArrayList(), "", "All", "All", "All"));
        getAdapter().addItems(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterModule(String module) {
        ArrayList<MaterialsNew> arrayList = new ArrayList<>();
        if (Intrinsics.areEqual(module, "All")) {
            Iterator<T> it = this.subList.iterator();
            while (it.hasNext()) {
                arrayList.add((MaterialsNew) it.next());
            }
        } else {
            for (MaterialsNew materialsNew : this.subList) {
                if (StringsKt.equals(materialsNew.getModule(), module, true)) {
                    arrayList.add(materialsNew);
                }
            }
        }
        arrayList.remove(new MaterialsNew("All", "All", "All", new ArrayList(), "", "All", "All", "All"));
        getAdapter().addItems(arrayList);
    }

    @Override // in.etuwa.app.ui.studymaterials.MaterialAdapter.MaterialDownload
    public void downloadFile(ArrayList<String> url, String url2, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(url2, "url2");
        Regex regex = new Regex("[^A-Za-z0-9.]");
        if (!flag) {
            String replace = regex.replace(StringsKt.substringAfterLast$default(url2, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
                if (checkFileExistence(replace)) {
                    Context requireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                    new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.MATERIALS_PATH);
                    return;
                }
                try {
                    MaterialFragmentBinding materialFragmentBinding = get_binding();
                    if (materialFragmentBinding != null && (recyclerView = materialFragmentBinding.rvMaterials) != null) {
                        String string = getString(R.string.download_started);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                        ToastExtKt.showInfoToast(recyclerView, string);
                    }
                    Context requireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                    long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.MATERIALS_PATH, url2);
                    Context context = getContext();
                    if (context != null) {
                        context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
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
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        MaterialDownloadDialog.INSTANCE.newInstance(position, this.semId).show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.studymaterials.MaterialAdapter.MaterialDownload
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.MATERIALS_PATH);
    }

    @Override // in.etuwa.app.ui.studymaterials.MaterialAdapter.MaterialDownload
    public void onLinkClick(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(link));
            startActivity(Intent.createChooser(intent, "Open With"));
        } catch (Exception unused) {
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        MaterialFragmentBinding materialFragmentBinding = get_binding();
        if (materialFragmentBinding == null || (recyclerView = materialFragmentBinding.rvMaterials) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        MaterialFragmentBinding materialFragmentBinding = get_binding();
        if (materialFragmentBinding == null || (recyclerView = materialFragmentBinding.rvMaterials) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setMaterialDownload(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}