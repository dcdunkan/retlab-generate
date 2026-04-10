package in.etuwa.app.ui.notice;

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
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.noticeboard.NoticeJeccResponse;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.NoticeFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.notice.NoticeAdapter;
import in.etuwa.app.ui.notice.NoticeMainAdapter;
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

/* JADX INFO: compiled from: NoticeFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NoticeFragment extends BaseFragment implements NoticeAdapter.NoticeListener, NoticeMainAdapter.NoticeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int REQUEST_CODE;
    private NoticeFragmentBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapterMain$delegate, reason: from kotlin metadata */
    private final Lazy adapterMain;
    private ArrayList<DownloadModel> downList;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: noticeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy noticeViewModel;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: compiled from: NoticeFragment.kt */
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
    public static final NoticeFragment newInstance() {
        return INSTANCE.newInstance();
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

    public NoticeFragment() {
        final NoticeFragment noticeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.notice.NoticeFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return noticeFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(noticeFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.noticeViewModel = FragmentViewModelLazyKt.createViewModelLazy(noticeFragment, Reflection.getOrCreateKotlinClass(NoticeViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.notice.NoticeFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.notice.NoticeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(NoticeViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final NoticeFragment noticeFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<NoticeAdapter>() { // from class: in.etuwa.app.ui.notice.NoticeFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.notice.NoticeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final NoticeAdapter invoke() {
                ComponentCallbacks componentCallbacks = noticeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(NoticeAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterMain = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<NoticeMainAdapter>() { // from class: in.etuwa.app.ui.notice.NoticeFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.notice.NoticeMainAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final NoticeMainAdapter invoke() {
                ComponentCallbacks componentCallbacks = noticeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(NoticeMainAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.notice.NoticeFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = noticeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b6, b7);
            }
        });
        this.downList = new ArrayList<>();
        this.REQUEST_CODE = 1;
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.notice.NoticeFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    ArrayList arrayList = this.this$0.downList;
                    NoticeFragment noticeFragment3 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            noticeFragment3.getAdapter().notifyDataChanged(((DownloadModel) noticeFragment3.downList.get(i)).getPosition());
                            noticeFragment3.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final NoticeViewModel getNoticeViewModel() {
        return (NoticeViewModel) this.noticeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NoticeAdapter getAdapter() {
        return (NoticeAdapter) this.adapter.getValue();
    }

    private final NoticeMainAdapter getAdapterMain() {
        return (NoticeMainAdapter) this.adapterMain.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final NoticeFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: NoticeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/notice/NoticeFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/notice/NoticeFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NoticeFragment newInstance() {
            return new NoticeFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = NoticeFragmentBinding.inflate(inflater, container, false);
        NoticeFragmentBinding noticeFragmentBinding = get_binding();
        if (noticeFragmentBinding != null) {
            noticeFragmentBinding.setNoticeViewModel(getNoticeViewModel());
        }
        NoticeFragmentBinding noticeFragmentBinding2 = get_binding();
        if (noticeFragmentBinding2 != null) {
            noticeFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        NoticeFragmentBinding noticeFragmentBinding3 = get_binding();
        if (noticeFragmentBinding3 != null) {
            return noticeFragmentBinding3.getRoot();
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
        CardView cardView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.noticeborad));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "jecc", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "awh", false, 2, (Object) null)) {
            NoticeFragmentBinding noticeFragmentBinding = get_binding();
            RecyclerView recyclerView = noticeFragmentBinding != null ? noticeFragmentBinding.rvNotice : null;
            if (recyclerView != null) {
                recyclerView.setAdapter(getAdapter());
            }
            NoticeFragmentBinding noticeFragmentBinding2 = get_binding();
            RecyclerView recyclerView2 = noticeFragmentBinding2 != null ? noticeFragmentBinding2.rvNotice : null;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
            NoticeFragmentBinding noticeFragmentBinding3 = get_binding();
            RecyclerView recyclerView3 = noticeFragmentBinding3 != null ? noticeFragmentBinding3.rvNoticeMain : null;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
            }
            getAdapter().setNoticeListener(this);
            listenResponse();
            getNoticeViewModel().getNotice();
        } else {
            NoticeFragmentBinding noticeFragmentBinding4 = get_binding();
            RecyclerView recyclerView4 = noticeFragmentBinding4 != null ? noticeFragmentBinding4.rvNotice : null;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(8);
            }
            NoticeFragmentBinding noticeFragmentBinding5 = get_binding();
            RecyclerView recyclerView5 = noticeFragmentBinding5 != null ? noticeFragmentBinding5.rvNoticeMain : null;
            if (recyclerView5 != null) {
                recyclerView5.setVisibility(0);
            }
            NoticeFragmentBinding noticeFragmentBinding6 = get_binding();
            RecyclerView recyclerView6 = noticeFragmentBinding6 != null ? noticeFragmentBinding6.rvNoticeMain : null;
            if (recyclerView6 != null) {
                recyclerView6.setAdapter(getAdapterMain());
            }
            getAdapterMain().setNoticeListener(this);
            listenResponseMain();
            getNoticeViewModel().getNoticeMain();
        }
        NoticeFragmentBinding noticeFragmentBinding7 = get_binding();
        if (noticeFragmentBinding7 != null && (cardView = noticeFragmentBinding7.cardInfo) != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.notice.NoticeFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoticeFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://chinarts.etlab.in/androidapp/")) {
            NoticeFragmentBinding noticeFragmentBinding8 = get_binding();
            TextView textView = noticeFragmentBinding8 != null ? noticeFragmentBinding8.infoBtn : null;
            if (textView == null) {
                return;
            }
            textView.setText("Hobby");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(NoticeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onInfoClicked();
        }
    }

    private final void listenResponse() {
        getNoticeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.notice.NoticeFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NoticeFragment.listenResponse$lambda$2(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(NoticeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            NoticeJeccResponse noticeJeccResponse = (NoticeJeccResponse) resource.getData();
            if (noticeJeccResponse != null) {
                this$0.showBaseView();
                noticeJeccResponse.getLogin();
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
        NoticeFragmentBinding noticeFragmentBinding = this$0.get_binding();
        if (noticeFragmentBinding == null || (recyclerView = noticeFragmentBinding.rvNotice) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenResponseMain() {
        getNoticeViewModel().getResponseMain().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.notice.NoticeFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NoticeFragment.listenResponseMain$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponseMain$lambda$4(NoticeFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            NoticeResponse noticeResponse = (NoticeResponse) resource.getData();
            if (noticeResponse != null) {
                this$0.showBaseView();
                if (noticeResponse.getLogin()) {
                    this$0.getAdapterMain().addItems(noticeResponse.getNotice());
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
        NoticeFragmentBinding noticeFragmentBinding = this$0.get_binding();
        if (noticeFragmentBinding == null || (recyclerView = noticeFragmentBinding.rvNotice) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.notice.NoticeAdapter.NoticeListener, in.etuwa.app.ui.notice.NoticeMainAdapter.NoticeListener
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
                new DownloadManagerHelper(contextRequireContext).openFile(strReplace, AppConstant.NOTICE_BOARD_PATH);
                return;
            }
            try {
                NoticeFragmentBinding noticeFragmentBinding = get_binding();
                if (noticeFragmentBinding != null && (recyclerView = noticeFragmentBinding.rvNotice) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext2).startDownloading(AppConstant.NOTICE_BOARD_PATH, url);
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
            new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.notice.NoticeFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    NoticeFragment.requestPermission$lambda$5(this.f$0, dialogInterface, i);
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$5(NoticeFragment this$0, DialogInterface dialogInterface, int i) {
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

    @Override // in.etuwa.app.ui.notice.NoticeAdapter.NoticeListener, in.etuwa.app.ui.notice.NoticeMainAdapter.NoticeListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.NOTICE_BOARD_PATH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}