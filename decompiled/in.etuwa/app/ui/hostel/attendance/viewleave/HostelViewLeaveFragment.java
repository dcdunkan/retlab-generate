package in.etuwa.app.ui.hostel.attendance.viewleave;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
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
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttViewResponse;
import in.etuwa.app.databinding.FragmentHostelAttViewBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter;
import in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrDialog;
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

/* compiled from: HostelViewLeaveFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001cH\u0014J\b\u0010*\u001a\u00020\u001cH\u0014J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\u0012\u0010/\u001a\u00020\u001c2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\b\u00109\u001a\u00020\u001cH\u0016J\u001a\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010<\u001a\u00020\u001cH\u0002J\b\u0010=\u001a\u00020\u001cH\u0014J\b\u0010>\u001a\u00020\u001cH\u0014J\b\u0010?\u001a\u00020\u001cH\u0014J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter$CallBack;", "Lin/etuwa/app/ui/hostel/attendance/applyleave/HostelApplyLeaveDialog$ApplyLeaveCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentHostelAttViewBinding;", "adapter", "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter;", "getAdapter", "()Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentHostelAttViewBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "hostelViewLeaveViewModel", "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveViewModel;", "getHostelViewLeaveViewModel", "()Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveViewModel;", "hostelViewLeaveViewModel$delegate", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "alreadyExitBtnClicked", "", "id", "", "checkFileExistence", "", "fileName", "flag", "delBtnClicked", "downloadFile", "url", CommonCssConstants.POSITION, "", "exitBtnClicked", "hideBaseView", "hideProgress", "listenAlreadyExitResponse", "listenDeleteResponse", "listenExitResponse", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showBaseView", "showProgress", "viewBtnClicked", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelViewLeaveFragment extends BaseFragment implements HostelViewLeaveAdapter.CallBack, HostelApplyLeaveDialog.ApplyLeaveCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelAttViewBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;

    /* renamed from: hostelViewLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelViewLeaveViewModel;
    private final BroadcastReceiver onDownloadComplete;

    /* compiled from: HostelViewLeaveFragment.kt */
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
    public static final HostelViewLeaveFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public HostelViewLeaveFragment() {
        final HostelViewLeaveFragment hostelViewLeaveFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelViewLeaveFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelViewLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelViewLeaveFragment, Reflection.getOrCreateKotlinClass(HostelViewLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelViewLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelViewLeaveFragment hostelViewLeaveFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelViewLeaveAdapter>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelViewLeaveAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelViewLeaveFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelViewLeaveAdapter.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = HostelViewLeaveFragment.this.downList;
                    HostelViewLeaveFragment hostelViewLeaveFragment3 = HostelViewLeaveFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            arrayList2 = hostelViewLeaveFragment3.downList;
                            arrayList2.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final HostelViewLeaveViewModel getHostelViewLeaveViewModel() {
        return (HostelViewLeaveViewModel) this.hostelViewLeaveViewModel.getValue();
    }

    private final HostelViewLeaveAdapter getAdapter() {
        return (HostelViewLeaveAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentHostelAttViewBinding get_binding() {
        return this._binding;
    }

    /* compiled from: HostelViewLeaveFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelViewLeaveFragment newInstance() {
            HostelViewLeaveFragment hostelViewLeaveFragment = new HostelViewLeaveFragment();
            hostelViewLeaveFragment.setArguments(new Bundle());
            return hostelViewLeaveFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelAttViewBinding.inflate(inflater, container, false);
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding = get_binding();
        if (fragmentHostelAttViewBinding != null) {
            fragmentHostelAttViewBinding.setHostelViewLeaveViewModel(getHostelViewLeaveViewModel());
        }
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding2 = get_binding();
        if (fragmentHostelAttViewBinding2 != null) {
            fragmentHostelAttViewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding3 = get_binding();
        if (fragmentHostelAttViewBinding3 != null) {
            return fragmentHostelAttViewBinding3.getRoot();
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
        TextView textView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Leave View");
        }
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelAttViewBinding != null ? fragmentHostelAttViewBinding.rvHostelAttView : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        hideBaseView();
        listenResponse();
        listenDeleteResponse();
        listenExitResponse();
        listenAlreadyExitResponse();
        getHostelViewLeaveViewModel().getHostelAttView();
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding2 = get_binding();
        if (fragmentHostelAttViewBinding2 == null || (textView = fragmentHostelAttViewBinding2.applyNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelViewLeaveFragment.setUp$lambda$1(HostelViewLeaveFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelViewLeaveFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelApplyLeaveDialog newInstance = HostelApplyLeaveDialog.INSTANCE.newInstance();
        newInstance.setApplyLeaveCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getHostelViewLeaveViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelViewLeaveFragment.listenResponse$lambda$3(HostelViewLeaveFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$3(HostelViewLeaveFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        TextView textView;
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
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding = this$0.get_binding();
            if (fragmentHostelAttViewBinding == null || (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        HostelAttViewResponse hostelAttViewResponse = (HostelAttViewResponse) resource.getData();
        if (hostelAttViewResponse != null) {
            this$0.showBaseView();
            if (hostelAttViewResponse.getLogin()) {
                this$0.getAdapter().addItems(hostelAttViewResponse.getData());
                if (hostelAttViewResponse.getData().size() == 0) {
                    FragmentHostelAttViewBinding fragmentHostelAttViewBinding2 = this$0.get_binding();
                    CardView cardView = fragmentHostelAttViewBinding2 != null ? fragmentHostelAttViewBinding2.swipeLayout : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    FragmentHostelAttViewBinding fragmentHostelAttViewBinding3 = this$0.get_binding();
                    textView = fragmentHostelAttViewBinding3 != null ? fragmentHostelAttViewBinding3.noData : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                    return;
                }
                FragmentHostelAttViewBinding fragmentHostelAttViewBinding4 = this$0.get_binding();
                CardView cardView2 = fragmentHostelAttViewBinding4 != null ? fragmentHostelAttViewBinding4.swipeLayout : null;
                if (cardView2 != null) {
                    cardView2.setVisibility(0);
                }
                FragmentHostelAttViewBinding fragmentHostelAttViewBinding5 = this$0.get_binding();
                textView = fragmentHostelAttViewBinding5 != null ? fragmentHostelAttViewBinding5.noData : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding6 = this$0.get_binding();
            if (fragmentHostelAttViewBinding6 == null || (rvHostelAttView = fragmentHostelAttViewBinding6.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenDeleteResponse() {
        getHostelViewLeaveViewModel().getDelResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelViewLeaveFragment.listenDeleteResponse$lambda$5(HostelViewLeaveFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$5(HostelViewLeaveFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        RecyclerView rvHostelAttView2;
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
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding = this$0.get_binding();
            if (fragmentHostelAttViewBinding == null || (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) == null) {
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
            if (successResponse.getSuccess()) {
                FragmentHostelAttViewBinding fragmentHostelAttViewBinding2 = this$0.get_binding();
                if (fragmentHostelAttViewBinding2 != null && (rvHostelAttView2 = fragmentHostelAttViewBinding2.rvHostelAttView) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHostelAttView2, "rvHostelAttView");
                    ToastExtKt.showSuccessToast(rvHostelAttView2, successResponse.getMessage());
                }
                this$0.getHostelViewLeaveViewModel().getHostelAttView();
                return;
            }
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding3 = this$0.get_binding();
            if (fragmentHostelAttViewBinding3 == null || (rvHostelAttView = fragmentHostelAttViewBinding3.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, successResponse.getError());
        }
    }

    private final void listenExitResponse() {
        getHostelViewLeaveViewModel().getSecurityExitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelViewLeaveFragment.listenExitResponse$lambda$7(HostelViewLeaveFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenExitResponse$lambda$7(HostelViewLeaveFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        RecyclerView rvHostelAttView2;
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
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding = this$0.get_binding();
            if (fragmentHostelAttViewBinding == null || (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) == null) {
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
            if (successResponse.getLogin()) {
                FragmentHostelAttViewBinding fragmentHostelAttViewBinding2 = this$0.get_binding();
                if (fragmentHostelAttViewBinding2 != null && (rvHostelAttView2 = fragmentHostelAttViewBinding2.rvHostelAttView) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHostelAttView2, "rvHostelAttView");
                    ToastExtKt.showSuccessToast(rvHostelAttView2, successResponse.getMessage());
                }
                this$0.getHostelViewLeaveViewModel().getHostelAttView();
                return;
            }
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding3 = this$0.get_binding();
            if (fragmentHostelAttViewBinding3 == null || (rvHostelAttView = fragmentHostelAttViewBinding3.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    private final void listenAlreadyExitResponse() {
        getHostelViewLeaveViewModel().getSecurityAlreadyExitResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelViewLeaveFragment.listenAlreadyExitResponse$lambda$9(HostelViewLeaveFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAlreadyExitResponse$lambda$9(HostelViewLeaveFragment this$0, Resource resource) {
        RecyclerView rvHostelAttView;
        RecyclerView rvHostelAttView2;
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
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding = this$0.get_binding();
            if (fragmentHostelAttViewBinding == null || (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) == null) {
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
            if (successResponse.getLogin()) {
                FragmentHostelAttViewBinding fragmentHostelAttViewBinding2 = this$0.get_binding();
                if (fragmentHostelAttViewBinding2 != null && (rvHostelAttView2 = fragmentHostelAttViewBinding2.rvHostelAttView) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvHostelAttView2, "rvHostelAttView");
                    ToastExtKt.showSuccessToast(rvHostelAttView2, successResponse.getMessage());
                }
                this$0.getHostelViewLeaveViewModel().getHostelAttView();
                return;
            }
            FragmentHostelAttViewBinding fragmentHostelAttViewBinding3 = this$0.get_binding();
            if (fragmentHostelAttViewBinding3 == null || (rvHostelAttView = fragmentHostelAttViewBinding3.rvHostelAttView) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvHostelAttView, "rvHostelAttView");
            ToastExtKt.showErrorToast(rvHostelAttView, "netwok error");
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding = get_binding();
        if (fragmentHostelAttViewBinding == null || (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentHostelAttViewBinding fragmentHostelAttViewBinding = get_binding();
        if (fragmentHostelAttViewBinding == null || (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter.CallBack
    public void delBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getHostelViewLeaveViewModel().getDeleteLeave(id);
    }

    @Override // in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter.CallBack
    public void viewBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SecurityQrDialog.INSTANCE.newInstance(id).show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveDialog.ApplyLeaveCallBack
    public void onDismiss() {
        getHostelViewLeaveViewModel().getHostelAttView();
    }

    @Override // in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter.CallBack
    public void downloadFile(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(replace, flag)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, "/etlab/assignments/");
                return;
            }
            try {
                FragmentHostelAttViewBinding fragmentHostelAttViewBinding = get_binding();
                if (fragmentHostelAttViewBinding != null && (recyclerView = fragmentHostelAttViewBinding.rvHostelAttView) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading("/etlab/assignments/", url);
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

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        HostelViewLeaveFragment.requestPermission$lambda$10(HostelViewLeaveFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$10(HostelViewLeaveFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    @Override // in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter.CallBack
    public boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, "/etlab/assignments/");
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, "/etlab/assignments/");
    }

    @Override // in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter.CallBack
    public void exitBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getHostelViewLeaveViewModel().exitLeaveApproveSecurityData(id);
    }

    @Override // in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter.CallBack
    public void alreadyExitBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getHostelViewLeaveViewModel().alreadyExitLeaveApproveSecurityData(id);
    }
}