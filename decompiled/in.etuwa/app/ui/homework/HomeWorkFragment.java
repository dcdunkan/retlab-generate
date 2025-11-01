package in.etuwa.app.ui.homework;

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
import in.etuwa.app.data.model.homework.HomeWorkResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.HomeWorkFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.homework.HomeWorkAdapter;
import in.etuwa.app.ui.homework.files.HomeWorkFilesDialog;
import in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog;
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

/* compiled from: HomeWorkFragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020%H\u0014J\b\u0010,\u001a\u00020%H\u0014J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0002J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020%H\u0016J\b\u00108\u001a\u00020%H\u0016J\b\u00109\u001a\u00020%H\u0016J\u0010\u0010:\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J-\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020*2\u000e\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0>2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ\u001a\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J \u0010D\u001a\u00020%2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020F0\u0011j\b\u0012\u0004\u0012\u00020F`\u0013H\u0016J\b\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u00020%H\u0014J\b\u0010I\u001a\u00020%H\u0014J\b\u0010J\u001a\u00020%H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001d\u0010\u001e¨\u0006L"}, d2 = {"Lin/etuwa/app/ui/homework/HomeWorkFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/homework/HomeWorkAdapter$HomeWorkListener;", "Lin/etuwa/app/ui/homework/submit/SubmitHomeWorkDialog$SubmitHomeWorkCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/HomeWorkFragmentBinding;", "adapter", "Lin/etuwa/app/ui/homework/HomeWorkAdapter;", "getAdapter", "()Lin/etuwa/app/ui/homework/HomeWorkAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/HomeWorkFragmentBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "homeWorkViewModel", "Lin/etuwa/app/ui/homework/HomeWorkViewModel;", "getHomeWorkViewModel", "()Lin/etuwa/app/ui/homework/HomeWorkViewModel;", "homeWorkViewModel$delegate", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "checkFileExistence", "", "fileName", "", "deleteHomeWork", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onPickDoc", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "openDownloadDialog", "list", "Lin/etuwa/app/data/model/exam/ExamFiles;", "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeWorkFragment extends BaseFragment implements HomeWorkAdapter.HomeWorkListener, SubmitHomeWorkDialog.SubmitHomeWorkCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HomeWorkFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;

    /* renamed from: homeWorkViewModel$delegate, reason: from kotlin metadata */
    private final Lazy homeWorkViewModel;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: HomeWorkFragment.kt */
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
    public static final HomeWorkFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public HomeWorkFragment() {
        final HomeWorkFragment homeWorkFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(homeWorkFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.homeWorkViewModel = FragmentViewModelLazyKt.createViewModelLazy(homeWorkFragment, Reflection.getOrCreateKotlinClass(HomeWorkViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HomeWorkViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HomeWorkFragment homeWorkFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HomeWorkAdapter>() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.homework.HomeWorkAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HomeWorkAdapter invoke() {
                ComponentCallbacks componentCallbacks = homeWorkFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HomeWorkAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = homeWorkFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                HomeWorkAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = HomeWorkFragment.this.downList;
                    HomeWorkFragment homeWorkFragment3 = HomeWorkFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = homeWorkFragment3.getAdapter();
                            arrayList2 = homeWorkFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = homeWorkFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final HomeWorkViewModel getHomeWorkViewModel() {
        return (HomeWorkViewModel) this.homeWorkViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeWorkAdapter getAdapter() {
        return (HomeWorkAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final HomeWorkFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: HomeWorkFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/homework/HomeWorkFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/homework/HomeWorkFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HomeWorkFragment newInstance() {
            return new HomeWorkFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = HomeWorkFragmentBinding.inflate(inflater, container, false);
        HomeWorkFragmentBinding homeWorkFragmentBinding = get_binding();
        if (homeWorkFragmentBinding != null) {
            homeWorkFragmentBinding.setHomeWorkViewModel(getHomeWorkViewModel());
        }
        HomeWorkFragmentBinding homeWorkFragmentBinding2 = get_binding();
        if (homeWorkFragmentBinding2 != null) {
            homeWorkFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        HomeWorkFragmentBinding homeWorkFragmentBinding3 = get_binding();
        if (homeWorkFragmentBinding3 != null) {
            return homeWorkFragmentBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.home_works));
        }
        hideBaseView();
        HomeWorkFragmentBinding homeWorkFragmentBinding = get_binding();
        RecyclerView recyclerView = homeWorkFragmentBinding != null ? homeWorkFragmentBinding.rvHomeWork : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        HomeWorkFragmentBinding homeWorkFragmentBinding2 = get_binding();
        if (homeWorkFragmentBinding2 != null && (textView2 = homeWorkFragmentBinding2.coveredHome) != null) {
            textView2.setBackgroundColor(Color.rgb(34, 139, 34));
        }
        HomeWorkFragmentBinding homeWorkFragmentBinding3 = get_binding();
        if (homeWorkFragmentBinding3 != null && (textView = homeWorkFragmentBinding3.notCoveredHome) != null) {
            textView.setBackgroundColor(Color.rgb(225, 51, 0));
        }
        getPreference().setNewLogin(false);
        listenResponse();
        HomeWorkFragmentBinding homeWorkFragmentBinding4 = get_binding();
        if (homeWorkFragmentBinding4 == null || (swipeRefreshLayout = homeWorkFragmentBinding4.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$$ExternalSyntheticLambda4
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeWorkFragment.setUp$lambda$0(HomeWorkFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(HomeWorkFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getHomeWorkViewModel().getHomeWork();
        HomeWorkFragmentBinding homeWorkFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = homeWorkFragmentBinding != null ? homeWorkFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getHomeWorkViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeWorkFragment.listenResponse$lambda$2(HomeWorkFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(HomeWorkFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HomeWorkResponse homeWorkResponse = (HomeWorkResponse) resource.getData();
            if (homeWorkResponse != null) {
                this$0.showBaseView();
                if (homeWorkResponse.getLogin()) {
                    this$0.getAdapter().addItems(homeWorkResponse.getHomeworks());
                    return;
                }
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
        HomeWorkFragmentBinding homeWorkFragmentBinding = this$0.get_binding();
        if (homeWorkFragmentBinding == null || (recyclerView = homeWorkFragmentBinding.rvHomeWork) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.homework.HomeWorkAdapter.HomeWorkListener
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            SubmitHomeWorkDialog newInstance = SubmitHomeWorkDialog.INSTANCE.newInstance(id);
            newInstance.setSubmitHomeWorkCallBack(this);
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialog.SubmitHomeWorkCallBack
    public void onDismiss() {
        getHomeWorkViewModel().getHomeWork();
    }

    @Override // in.etuwa.app.ui.homework.HomeWorkAdapter.HomeWorkListener
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
                new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.UPLOAD_HOME_WORK_PATH);
                return;
            }
            try {
                HomeWorkFragmentBinding homeWorkFragmentBinding = get_binding();
                if (homeWorkFragmentBinding != null && (recyclerView = homeWorkFragmentBinding.rvHomeWork) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.UPLOAD_HOME_WORK_PATH, url);
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

    @Override // in.etuwa.app.ui.homework.HomeWorkAdapter.HomeWorkListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.UPLOAD_HOME_WORK_PATH);
    }

    @Override // in.etuwa.app.ui.homework.HomeWorkAdapter.HomeWorkListener
    public void deleteHomeWork(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.delete_assignment_msg));
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                HomeWorkFragment.deleteHomeWork$lambda$3(HomeWorkFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteHomeWork$lambda$3(HomeWorkFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getHomeWorkViewModel().deleteHomeWork(id);
        this$0.listenDeleteResponse();
    }

    private final void listenDeleteResponse() {
        getHomeWorkViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeWorkFragment.listenDeleteResponse$lambda$5(HomeWorkFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$5(HomeWorkFragment this$0, Resource resource) {
        RecyclerView rvHomeWork;
        RecyclerView rvHomeWork2;
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
            HomeWorkFragmentBinding homeWorkFragmentBinding = this$0.get_binding();
            if (homeWorkFragmentBinding == null || (recyclerView = homeWorkFragmentBinding.rvHomeWork) == null) {
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
                HomeWorkFragmentBinding homeWorkFragmentBinding2 = this$0.get_binding();
                if (homeWorkFragmentBinding2 != null && (rvHomeWork2 = homeWorkFragmentBinding2.rvHomeWork) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHomeWork2, "rvHomeWork");
                    ToastExtKt.showSuccessToast(rvHomeWork2, successResponse.getMessage());
                }
                this$0.getHomeWorkViewModel().getHomeWork();
                return;
            }
            HomeWorkFragmentBinding homeWorkFragmentBinding3 = this$0.get_binding();
            if (homeWorkFragmentBinding3 == null || (rvHomeWork = homeWorkFragmentBinding3.rvHomeWork) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHomeWork, "rvHomeWork");
            ToastExtKt.showErrorToast(rvHomeWork, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.homework.HomeWorkAdapter.HomeWorkListener
    public void openDownloadDialog(ArrayList<ExamFiles> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            HomeWorkFilesDialog.INSTANCE.newInstance(list).show(childFragmentManager, (String) null);
        } catch (Exception unused) {
        }
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        HomeWorkFragment.requestPermission$lambda$6(HomeWorkFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(HomeWorkFragment this$0, DialogInterface dialogInterface, int i) {
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
        HomeWorkFragmentBinding homeWorkFragmentBinding = get_binding();
        if (homeWorkFragmentBinding == null || (recyclerView = homeWorkFragmentBinding.rvHomeWork) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        HomeWorkFragmentBinding homeWorkFragmentBinding = get_binding();
        if (homeWorkFragmentBinding == null || (recyclerView = homeWorkFragmentBinding.rvHomeWork) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
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