package in.etuwa.app.ui.semregistration.view;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.svg.SvgConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.model.semregistration.view.SemRegSlip;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SemRegViewFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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

/* compiled from: SemRegViewFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\fH\u0002J\b\u0010.\u001a\u00020+H\u0014J\b\u0010/\u001a\u00020+H\u0014J\b\u00100\u001a\u00020+H\u0002J\b\u00101\u001a\u00020+H\u0002J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020+2\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010A\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020+H\u0016J\u001a\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010E\u001a\u00020+H\u0014J\b\u0010F\u001a\u00020+H\u0014J\b\u0010G\u001a\u00020+H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lin/etuwa/app/ui/semregistration/view/SemRegViewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog$AddSemRegListener;", "()V", "_binding", "Lin/etuwa/app/databinding/SemRegViewFragmentBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SemRegViewFragmentBinding;", "canEdit", "", "editMessage", "", "feeStatus", "file", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "receiptId", "", "registrationActive", "semRegViewViewModel", "Lin/etuwa/app/ui/semregistration/view/SemRegViewViewModel;", "getSemRegViewViewModel", "()Lin/etuwa/app/ui/semregistration/view/SemRegViewViewModel;", "semRegViewViewModel$delegate", "slipFile", "statusMessage", "checkFileExistence", "fileName", "dismiss", "", "downloadFile", "url", "hideBaseView", "hideProgress", "listenResponse", "listenSlipResponse", "loadView", "response", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SemRegViewFragment extends BaseFragment implements MvjceSemRegDialog.AddSemRegListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SemRegViewFragmentBinding _binding;
    private boolean canEdit;
    private String editMessage;
    private boolean feeStatus;
    private String file;
    private String id;
    private MainCallBackListener listener;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private long receiptId;
    private boolean registrationActive;

    /* renamed from: semRegViewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy semRegViewViewModel;
    private String slipFile;
    private String statusMessage;

    /* compiled from: SemRegViewFragment.kt */
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
    public static final SemRegViewFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
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

    public SemRegViewFragment() {
        final SemRegViewFragment semRegViewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(semRegViewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.semRegViewViewModel = FragmentViewModelLazyKt.createViewModelLazy(semRegViewFragment, Reflection.getOrCreateKotlinClass(SemRegViewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SemRegViewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SemRegViewFragment semRegViewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = semRegViewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.file = "";
        this.slipFile = "";
        this.editMessage = "";
        this.statusMessage = "";
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                long j;
                SemRegViewFragmentBinding semRegViewFragmentBinding;
                SemRegViewFragmentBinding semRegViewFragmentBinding2;
                TextView textView;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                j = SemRegViewFragment.this.receiptId;
                if (longExtra == j) {
                    semRegViewFragmentBinding = SemRegViewFragment.this.get_binding();
                    if (semRegViewFragmentBinding != null && (textView = semRegViewFragmentBinding.semRegFeeReceipt) != null) {
                        ToastExtKt.showInfoToast(textView, "Download Completed");
                    }
                    semRegViewFragmentBinding2 = SemRegViewFragment.this.get_binding();
                    TextView textView2 = semRegViewFragmentBinding2 != null ? semRegViewFragmentBinding2.semRegFeeReceipt : null;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setText("Open");
                }
            }
        };
    }

    private final SemRegViewViewModel getSemRegViewViewModel() {
        return (SemRegViewViewModel) this.semRegViewViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final SemRegViewFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    /* compiled from: SemRegViewFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/semregistration/view/SemRegViewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/view/SemRegViewFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SemRegViewFragment newInstance(String id) {
            SemRegViewFragment semRegViewFragment = new SemRegViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            semRegViewFragment.setArguments(bundle);
            return semRegViewFragment;
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
        this._binding = SemRegViewFragmentBinding.inflate(inflater, container, false);
        SemRegViewFragmentBinding semRegViewFragmentBinding = get_binding();
        if (semRegViewFragmentBinding != null) {
            semRegViewFragmentBinding.setSemRegViewViewModel(getSemRegViewViewModel());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding2 = get_binding();
        if (semRegViewFragmentBinding2 != null) {
            semRegViewFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding3 = get_binding();
        if (semRegViewFragmentBinding3 != null) {
            return semRegViewFragmentBinding3.getRoot();
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
        TextView textView2;
        TextView textView3;
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.sem_registration));
        }
        try {
            if (getPreference().getUserImg().length() > 0) {
                RequestBuilder<Drawable> load = Glide.with(requireActivity()).load(getPreference().getUserImg());
                SemRegViewFragmentBinding semRegViewFragmentBinding = get_binding();
                CircleImageView circleImageView = semRegViewFragmentBinding != null ? semRegViewFragmentBinding.semRegProfileImage : null;
                Intrinsics.checkNotNull(circleImageView);
                load.into(circleImageView);
            }
        } catch (Exception unused) {
        }
        if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://tkmce.etlab.in/androidapp/")) {
            SemRegViewFragmentBinding semRegViewFragmentBinding2 = get_binding();
            LinearLayout linearLayout = semRegViewFragmentBinding2 != null ? semRegViewFragmentBinding2.dueLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            SemRegViewFragmentBinding semRegViewFragmentBinding3 = get_binding();
            LinearLayout linearLayout2 = semRegViewFragmentBinding3 != null ? semRegViewFragmentBinding3.dueLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            SemRegViewViewModel semRegViewViewModel = getSemRegViewViewModel();
            String str = this.id;
            Intrinsics.checkNotNull(str);
            semRegViewViewModel.getRegistrationSlip(str);
            listenSlipResponse();
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            getSemRegViewViewModel().getData2(this.id);
        } else if (this.id != null) {
            getSemRegViewViewModel().getData(this.id);
        } else {
            getSemRegViewViewModel().getData(null);
        }
        listenResponse();
        SemRegViewFragmentBinding semRegViewFragmentBinding4 = get_binding();
        if (semRegViewFragmentBinding4 != null && (swipeRefreshLayout = semRegViewFragmentBinding4.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    SemRegViewFragment.setUp$lambda$1(SemRegViewFragment.this);
                }
            });
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding5 = get_binding();
        if (semRegViewFragmentBinding5 != null && (textView3 = semRegViewFragmentBinding5.semRegFeeReceipt) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SemRegViewFragment.setUp$lambda$2(SemRegViewFragment.this, view);
                }
            });
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding6 = get_binding();
        if (semRegViewFragmentBinding6 != null && (textView2 = semRegViewFragmentBinding6.semEditBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SemRegViewFragment.setUp$lambda$3(SemRegViewFragment.this, view);
                }
            });
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding7 = get_binding();
        if (semRegViewFragmentBinding7 == null || (textView = semRegViewFragmentBinding7.regSlipBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SemRegViewFragment.setUp$lambda$4(SemRegViewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SemRegViewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            this$0.getSemRegViewViewModel().getData2(this$0.id);
        } else if (this$0.id != null) {
            this$0.getSemRegViewViewModel().getData(this$0.id);
        } else {
            this$0.getSemRegViewViewModel().getData(null);
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = semRegViewFragmentBinding != null ? semRegViewFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(SemRegViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.file.length() > 0) {
                this$0.downloadFile(this$0.file);
            }
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(SemRegViewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) && this$0.registrationActive) || ((StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) && this$0.registrationActive) || (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null) && this$0.registrationActive))) {
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            MvjceSemRegDialog newInstance = MvjceSemRegDialog.INSTANCE.newInstance(this$0.id);
            newInstance.setCallBack2(this$0);
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        if (this$0.registrationActive) {
            SemRegViewFragmentBinding semRegViewFragmentBinding = this$0.get_binding();
            if (Intrinsics.areEqual((semRegViewFragmentBinding == null || (textView3 = semRegViewFragmentBinding.semEditBtn) == null) ? null : textView3.getText(), this$0.getString(R.string.apply))) {
                MainCallBackListener mainCallBackListener = this$0.listener;
                if (mainCallBackListener != null) {
                    mainCallBackListener.openSemRegisterPage(null, false, this$0.feeStatus);
                    return;
                }
                return;
            }
            if (this$0.canEdit) {
                MainCallBackListener mainCallBackListener2 = this$0.listener;
                if (mainCallBackListener2 != null) {
                    mainCallBackListener2.openSemRegisterPage(this$0.id, true, this$0.feeStatus);
                    return;
                }
                return;
            }
            SemRegViewFragmentBinding semRegViewFragmentBinding2 = this$0.get_binding();
            if (semRegViewFragmentBinding2 == null || (textView2 = semRegViewFragmentBinding2.semEditBtn) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, this$0.editMessage);
            return;
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding3 = this$0.get_binding();
        if (semRegViewFragmentBinding3 == null || (textView = semRegViewFragmentBinding3.semEditBtn) == null) {
            return;
        }
        ToastExtKt.showInfoToast(textView, this$0.statusMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(SemRegViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(this$0.slipFile, "")) {
            this$0.downloadFile(this$0.slipFile);
            System.out.println((Object) this$0.slipFile);
        } else {
            System.out.println((Object) this$0.slipFile);
        }
    }

    private final void listenResponse() {
        getSemRegViewViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegViewFragment.listenResponse$lambda$6(SemRegViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(SemRegViewFragment this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SemRegViewResponse semRegViewResponse = (SemRegViewResponse) resource.getData();
            if (semRegViewResponse != null) {
                this$0.loadView(semRegViewResponse);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        SemRegViewFragmentBinding semRegViewFragmentBinding = this$0.get_binding();
        if (semRegViewFragmentBinding == null || (textView = semRegViewFragmentBinding.semRegAcademic) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    private final void listenSlipResponse() {
        getSemRegViewViewModel().getSlipResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.view.SemRegViewFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SemRegViewFragment.listenSlipResponse$lambda$8(SemRegViewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSlipResponse$lambda$8(SemRegViewFragment this$0, Resource resource) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            SemRegViewFragmentBinding semRegViewFragmentBinding = this$0.get_binding();
            if (semRegViewFragmentBinding == null || (textView2 = semRegViewFragmentBinding.semRegAcademic) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView2, message);
            return;
        }
        this$0.hideProgress();
        SemRegSlip semRegSlip = (SemRegSlip) resource.getData();
        if (semRegSlip != null) {
            this$0.slipFile = semRegSlip.getRegslip_file();
            System.out.println((Object) "lol");
            System.out.println((Object) semRegSlip.getRegslip_file());
            System.out.println((Object) "lol");
            if (!Intrinsics.areEqual(this$0.slipFile, "") && (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                SemRegViewFragmentBinding semRegViewFragmentBinding2 = this$0.get_binding();
                textView = semRegViewFragmentBinding2 != null ? semRegViewFragmentBinding2.regSlipBtn : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(0);
                return;
            }
            SemRegViewFragmentBinding semRegViewFragmentBinding3 = this$0.get_binding();
            textView = semRegViewFragmentBinding3 != null ? semRegViewFragmentBinding3.regSlipBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    private final void loadView(SemRegViewResponse response) {
        TextView textView;
        System.out.println(response);
        if (response.isApplied()) {
            SemRegViewFragmentBinding semRegViewFragmentBinding = get_binding();
            TextView textView2 = semRegViewFragmentBinding != null ? semRegViewFragmentBinding.semEditBtn : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.edit));
            }
        } else {
            SemRegViewFragmentBinding semRegViewFragmentBinding2 = get_binding();
            TextView textView3 = semRegViewFragmentBinding2 != null ? semRegViewFragmentBinding2.semEditBtn : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.apply));
            }
        }
        if ((response.getUpdate_btn() && StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) || ((response.getUpdate_btn() && StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) || (response.getUpdate_btn() && StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null)))) {
            SemRegViewFragmentBinding semRegViewFragmentBinding3 = get_binding();
            TextView textView4 = semRegViewFragmentBinding3 != null ? semRegViewFragmentBinding3.semEditBtn : null;
            if (textView4 != null) {
                textView4.setText("Update");
            }
        } else {
            SemRegViewFragmentBinding semRegViewFragmentBinding4 = get_binding();
            TextView textView5 = semRegViewFragmentBinding4 != null ? semRegViewFragmentBinding4.semEditBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        this.canEdit = response.getCanEdit();
        this.editMessage = response.getCanEditMessage();
        this.registrationActive = response.getSemRegistrationStatus();
        this.statusMessage = response.getSemRegistrationStatusMessage();
        SemRegViewFragmentBinding semRegViewFragmentBinding5 = get_binding();
        TextView textView6 = semRegViewFragmentBinding5 != null ? semRegViewFragmentBinding5.semRegStatus : null;
        if (textView6 != null) {
            textView6.setText(response.getStatus());
        }
        if (Intrinsics.areEqual(response.getHodRemarks(), "")) {
            SemRegViewFragmentBinding semRegViewFragmentBinding6 = get_binding();
            LinearLayout linearLayout = semRegViewFragmentBinding6 != null ? semRegViewFragmentBinding6.hodRemarkLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding7 = get_binding();
        TextView textView7 = semRegViewFragmentBinding7 != null ? semRegViewFragmentBinding7.semRegRemarkByHod : null;
        if (textView7 != null) {
            textView7.setText(response.getHodRemarks());
        }
        if (Intrinsics.areEqual(response.getClassTeacherRemark(), "")) {
            SemRegViewFragmentBinding semRegViewFragmentBinding8 = get_binding();
            LinearLayout linearLayout2 = semRegViewFragmentBinding8 != null ? semRegViewFragmentBinding8.teacherRemarkLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding9 = get_binding();
        TextView textView8 = semRegViewFragmentBinding9 != null ? semRegViewFragmentBinding9.semRegRemarkByTeacher : null;
        if (textView8 != null) {
            textView8.setText(response.getClassTeacherRemark());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding10 = get_binding();
        TextView textView9 = semRegViewFragmentBinding10 != null ? semRegViewFragmentBinding10.semRegAdmNo : null;
        if (textView9 != null) {
            textView9.setText(response.getAdmissionNo());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding11 = get_binding();
        TextView textView10 = semRegViewFragmentBinding11 != null ? semRegViewFragmentBinding11.semRegAppliedFor : null;
        if (textView10 != null) {
            textView10.setText(response.getSemAppliedFor());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding12 = get_binding();
        TextView textView11 = semRegViewFragmentBinding12 != null ? semRegViewFragmentBinding12.semRegName : null;
        if (textView11 != null) {
            textView11.setText(response.getName());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding13 = get_binding();
        TextView textView12 = semRegViewFragmentBinding13 != null ? semRegViewFragmentBinding13.semRegGender : null;
        if (textView12 != null) {
            textView12.setText(response.getGender());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding14 = get_binding();
        TextView textView13 = semRegViewFragmentBinding14 != null ? semRegViewFragmentBinding14.semRegPhone : null;
        if (textView13 != null) {
            textView13.setText(response.getPhone());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding15 = get_binding();
        TextView textView14 = semRegViewFragmentBinding15 != null ? semRegViewFragmentBinding15.semRegEmail : null;
        if (textView14 != null) {
            textView14.setText(response.getEmail());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding16 = get_binding();
        TextView textView15 = semRegViewFragmentBinding16 != null ? semRegViewFragmentBinding16.semRegExamAppear : null;
        if (textView15 != null) {
            textView15.setText(response.getExamAppear());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding17 = get_binding();
        TextView textView16 = semRegViewFragmentBinding17 != null ? semRegViewFragmentBinding17.semRegUnivNo : null;
        if (textView16 != null) {
            textView16.setText(response.getUniRegNo());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding18 = get_binding();
        TextView textView17 = semRegViewFragmentBinding18 != null ? semRegViewFragmentBinding18.semRegMonthYear : null;
        if (textView17 != null) {
            textView17.setText(response.getExamMonthYear());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding19 = get_binding();
        TextView textView18 = semRegViewFragmentBinding19 != null ? semRegViewFragmentBinding19.semRegBackPaper : null;
        if (textView18 != null) {
            textView18.setText(response.getBackPaper());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding20 = get_binding();
        TextView textView19 = semRegViewFragmentBinding20 != null ? semRegViewFragmentBinding20.semRegBackPaperCount : null;
        if (textView19 != null) {
            textView19.setText(response.getBackPaperCount());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding21 = get_binding();
        TextView textView20 = semRegViewFragmentBinding21 != null ? semRegViewFragmentBinding21.semRegEarnedCredit : null;
        if (textView20 != null) {
            textView20.setText(response.getEarnedCredits());
        }
        boolean feeExemption = response.getFeeExemption();
        this.feeStatus = feeExemption;
        if (feeExemption) {
            SemRegViewFragmentBinding semRegViewFragmentBinding22 = get_binding();
            LinearLayout linearLayout3 = semRegViewFragmentBinding22 != null ? semRegViewFragmentBinding22.feeLayout : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding23 = get_binding();
        TextView textView21 = semRegViewFragmentBinding23 != null ? semRegViewFragmentBinding23.semRegFeePaid : null;
        if (textView21 != null) {
            textView21.setText(response.getFeePaid());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding24 = get_binding();
        TextView textView22 = semRegViewFragmentBinding24 != null ? semRegViewFragmentBinding24.semRegBank : null;
        if (textView22 != null) {
            textView22.setText(response.getBankName());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding25 = get_binding();
        TextView textView23 = semRegViewFragmentBinding25 != null ? semRegViewFragmentBinding25.semRegAmount : null;
        if (textView23 != null) {
            textView23.setText(response.getAmountPaid());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding26 = get_binding();
        TextView textView24 = semRegViewFragmentBinding26 != null ? semRegViewFragmentBinding26.semRegPaymentMode : null;
        if (textView24 != null) {
            textView24.setText(response.getPaymentMode());
        }
        String feeReceiptFile = response.getFeeReceiptFile();
        this.file = feeReceiptFile;
        try {
            if (feeReceiptFile.length() == 0) {
                SemRegViewFragmentBinding semRegViewFragmentBinding27 = get_binding();
                TextView textView25 = semRegViewFragmentBinding27 != null ? semRegViewFragmentBinding27.semRegFeeReceipt : null;
                if (textView25 != null) {
                    textView25.setText("No File");
                }
                SemRegViewFragmentBinding semRegViewFragmentBinding28 = get_binding();
                if (semRegViewFragmentBinding28 != null && (textView = semRegViewFragmentBinding28.semRegFeeReceipt) != null) {
                    textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
            } else if (checkFileExistence(new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(this.file, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), ""))) {
                SemRegViewFragmentBinding semRegViewFragmentBinding29 = get_binding();
                TextView textView26 = semRegViewFragmentBinding29 != null ? semRegViewFragmentBinding29.semRegFeeReceipt : null;
                if (textView26 != null) {
                    textView26.setText("Open");
                }
            }
        } catch (NullPointerException unused) {
            SemRegViewFragmentBinding semRegViewFragmentBinding30 = get_binding();
            TextView textView27 = semRegViewFragmentBinding30 != null ? semRegViewFragmentBinding30.semRegFeeReceipt : null;
            if (textView27 != null) {
                textView27.setText("No File");
            }
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding31 = get_binding();
        TextView textView28 = semRegViewFragmentBinding31 != null ? semRegViewFragmentBinding31.semRegRefNo : null;
        if (textView28 != null) {
            textView28.setText(response.getPaymentReferenceNo());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding32 = get_binding();
        TextView textView29 = semRegViewFragmentBinding32 != null ? semRegViewFragmentBinding32.semRegEGrand : null;
        if (textView29 != null) {
            textView29.setText(response.getFeeConcession());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding33 = get_binding();
        TextView textView30 = semRegViewFragmentBinding33 != null ? semRegViewFragmentBinding33.semRegFeeConcession : null;
        if (textView30 != null) {
            textView30.setText(response.getFeeConcessionCategory());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding34 = get_binding();
        TextView textView31 = semRegViewFragmentBinding34 != null ? semRegViewFragmentBinding34.semRegDepartment : null;
        if (textView31 != null) {
            textView31.setText(response.getDepartmentDue());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding35 = get_binding();
        TextView textView32 = semRegViewFragmentBinding35 != null ? semRegViewFragmentBinding35.semRegDepartmentDue : null;
        if (textView32 != null) {
            textView32.setText(response.getDepartmentDueDetails());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding36 = get_binding();
        TextView textView33 = semRegViewFragmentBinding36 != null ? semRegViewFragmentBinding36.semRegLibrary : null;
        if (textView33 != null) {
            textView33.setText(response.getLibraryDue());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding37 = get_binding();
        TextView textView34 = semRegViewFragmentBinding37 != null ? semRegViewFragmentBinding37.semRegLibraryDue : null;
        if (textView34 != null) {
            textView34.setText(response.getLibraryDueDetails());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding38 = get_binding();
        TextView textView35 = semRegViewFragmentBinding38 != null ? semRegViewFragmentBinding38.semRegAccount : null;
        if (textView35 != null) {
            textView35.setText(response.getAccountsDue());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding39 = get_binding();
        TextView textView36 = semRegViewFragmentBinding39 != null ? semRegViewFragmentBinding39.semRegAccountDue : null;
        if (textView36 != null) {
            textView36.setText(response.getAccountsDueDetails());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding40 = get_binding();
        TextView textView37 = semRegViewFragmentBinding40 != null ? semRegViewFragmentBinding40.semRegAcademic : null;
        if (textView37 != null) {
            textView37.setText(response.getAcademicDue());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding41 = get_binding();
        TextView textView38 = semRegViewFragmentBinding41 != null ? semRegViewFragmentBinding41.semRegAcademicDue : null;
        if (textView38 != null) {
            textView38.setText(response.getAcademicDueDetails());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding42 = get_binding();
        TextView textView39 = semRegViewFragmentBinding42 != null ? semRegViewFragmentBinding42.semRegHostel : null;
        if (textView39 != null) {
            textView39.setText(response.getHostelDue());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding43 = get_binding();
        TextView textView40 = semRegViewFragmentBinding43 != null ? semRegViewFragmentBinding43.semRegHostelDue : null;
        if (textView40 != null) {
            textView40.setText(response.getHostelDueDetails());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding44 = get_binding();
        TextView textView41 = semRegViewFragmentBinding44 != null ? semRegViewFragmentBinding44.semRegBus : null;
        if (textView41 != null) {
            textView41.setText(response.getBusDue());
        }
        SemRegViewFragmentBinding semRegViewFragmentBinding45 = get_binding();
        TextView textView42 = semRegViewFragmentBinding45 != null ? semRegViewFragmentBinding45.semRegBusDue : null;
        if (textView42 == null) {
            return;
        }
        textView42.setText(response.getBusDueDetails());
    }

    private final void downloadFile(String url) {
        TextView textView;
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission()) {
            if (checkFileExistence(replace)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, AppConstant.SEM_REG_PATH);
                return;
            }
            try {
                SemRegViewFragmentBinding semRegViewFragmentBinding = get_binding();
                if (semRegViewFragmentBinding != null && (textView = semRegViewFragmentBinding.semRegFeeReceipt) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(textView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                this.receiptId = new DownloadManagerHelper(requireContext3).startDownloading(AppConstant.SEM_REG_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        new ValidChecker(requireContext4).showPermissionDialog();
    }

    private final boolean checkFileExistence(String fileName) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.SEM_REG_PATH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog.AddSemRegListener, in.etuwa.app.ui.semregistration.mea.MeaSemRegDialog.AddCounsellingListener
    public void dismiss() {
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            getSemRegViewViewModel().getData2(this.id);
        } else if (this.id != null) {
            getSemRegViewViewModel().getData(this.id);
        } else {
            getSemRegViewViewModel().getData(null);
        }
    }
}