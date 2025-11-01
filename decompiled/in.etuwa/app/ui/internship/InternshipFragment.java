package in.etuwa.app.ui.internship;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.internship.InternshipResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentInternshipBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.internship.InternshipAdapter;
import in.etuwa.app.ui.internship.apply.ApplyInternship;
import in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: InternshipFragment.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001RB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020)H\u0014J\b\u0010.\u001a\u00020)H\u0014J\b\u0010/\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020&H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u000204H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020)H\u0016J\b\u0010>\u001a\u00020)H\u0016J\b\u0010?\u001a\u00020)H\u0016J\u0010\u0010@\u001a\u00020)2\u0006\u00101\u001a\u00020&H\u0016J-\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020,2\u000e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0D2\u0006\u0010E\u001a\u00020FH\u0016¢\u0006\u0002\u0010GJ\u001a\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010J\u001a\u00020)2\u0006\u0010*\u001a\u00020&H\u0016J\u0010\u0010K\u001a\u00020)2\u0006\u0010*\u001a\u00020&H\u0016J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u00020)H\u0014J\b\u0010N\u001a\u00020)H\u0014J\b\u0010O\u001a\u00020)H\u0016J\b\u0010P\u001a\u00020)H\u0014J\u0010\u0010Q\u001a\u00020)2\u0006\u00101\u001a\u00020&H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!¨\u0006S"}, d2 = {"Lin/etuwa/app/ui/internship/InternshipFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/internship/apply/ApplyInternship$ApplyInternshipCallBack;", "Lin/etuwa/app/ui/internship/InternshipAdapter$CallBack;", "Lin/etuwa/app/ui/internship/completioncertificate/CompletionCertificateDialog$UploadAssignmentCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentInternshipBinding;", "adapter", "Lin/etuwa/app/ui/internship/InternshipAdapter;", "getAdapter", "()Lin/etuwa/app/ui/internship/InternshipAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentInternshipBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "internshipViewModel", "Lin/etuwa/app/ui/internship/InternshipViewModel;", "getInternshipViewModel", "()Lin/etuwa/app/ui/internship/InternshipViewModel;", "internshipViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "checkFileExistence", "", "fileName", "", "flag", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenResponse", "loadPickerDialog", "id", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onPickDoc", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "onViewDoc", "openReport", "requestPermission", "setUp", "showBaseView", "showError", "showProgress", "upload", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InternshipFragment extends BaseFragment implements ApplyInternship.ApplyInternshipCallBack, InternshipAdapter.CallBack, CompletionCertificateDialog.UploadAssignmentCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentInternshipBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;

    /* renamed from: internshipViewModel$delegate, reason: from kotlin metadata */
    private final Lazy internshipViewModel;
    private MainCallBackListener listener;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final InternshipFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public void upload(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public InternshipFragment() {
        final InternshipFragment internshipFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.internship.InternshipFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(internshipFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.internshipViewModel = FragmentViewModelLazyKt.createViewModelLazy(internshipFragment, Reflection.getOrCreateKotlinClass(InternshipViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.internship.InternshipFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.internship.InternshipFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(InternshipViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final InternshipFragment internshipFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<InternshipAdapter>() { // from class: in.etuwa.app.ui.internship.InternshipFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.internship.InternshipAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InternshipAdapter invoke() {
                ComponentCallbacks componentCallbacks = internshipFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(InternshipAdapter.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.internship.InternshipFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = internshipFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.internship.InternshipFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                InternshipAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = InternshipFragment.this.downList;
                    InternshipFragment internshipFragment3 = InternshipFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = internshipFragment3.getAdapter();
                            arrayList2 = internshipFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = internshipFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final InternshipViewModel getInternshipViewModel() {
        return (InternshipViewModel) this.internshipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InternshipAdapter getAdapter() {
        return (InternshipAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentInternshipBinding get_binding() {
        return this._binding;
    }

    /* compiled from: InternshipFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/internship/InternshipFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/internship/InternshipFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InternshipFragment newInstance() {
            return new InternshipFragment();
        }
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentInternshipBinding.inflate(inflater, container, false);
        FragmentInternshipBinding fragmentInternshipBinding = get_binding();
        if (fragmentInternshipBinding != null) {
            fragmentInternshipBinding.setInternshipViewModel(getInternshipViewModel());
        }
        FragmentInternshipBinding fragmentInternshipBinding2 = get_binding();
        if (fragmentInternshipBinding2 != null) {
            fragmentInternshipBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentInternshipBinding fragmentInternshipBinding3 = get_binding();
        if (fragmentInternshipBinding3 != null) {
            return fragmentInternshipBinding3.getRoot();
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
        Button button;
        Button button2;
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Internship");
        }
        hideBaseView();
        FragmentInternshipBinding fragmentInternshipBinding = get_binding();
        RecyclerView recyclerView = fragmentInternshipBinding != null ? fragmentInternshipBinding.rvInternship : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        FragmentInternshipBinding fragmentInternshipBinding2 = get_binding();
        if (fragmentInternshipBinding2 != null && (swipeRefreshLayout = fragmentInternshipBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.internship.InternshipFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    InternshipFragment.setUp$lambda$0(InternshipFragment.this);
                }
            });
        }
        if (Intrinsics.areEqual(getPreference().getUserType(), ExifInterface.GPS_MEASUREMENT_2D)) {
            FragmentInternshipBinding fragmentInternshipBinding3 = get_binding();
            button = fragmentInternshipBinding3 != null ? fragmentInternshipBinding3.applyBtn : null;
            if (button != null) {
                button.setVisibility(8);
            }
        } else {
            FragmentInternshipBinding fragmentInternshipBinding4 = get_binding();
            button = fragmentInternshipBinding4 != null ? fragmentInternshipBinding4.applyBtn : null;
            if (button != null) {
                button.setVisibility(0);
            }
        }
        FragmentInternshipBinding fragmentInternshipBinding5 = get_binding();
        if (fragmentInternshipBinding5 == null || (button2 = fragmentInternshipBinding5.applyBtn) == null) {
            return;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.InternshipFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InternshipFragment.setUp$lambda$1(InternshipFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(InternshipFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getInternshipViewModel().getInternship();
        FragmentInternshipBinding fragmentInternshipBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentInternshipBinding != null ? fragmentInternshipBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(InternshipFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ApplyInternship.INSTANCE.newInstance().show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getInternshipViewModel().getResponse().observe(getViewLifecycleOwner(), new InternshipFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends InternshipResponse>, Unit>() { // from class: in.etuwa.app.ui.internship.InternshipFragment$listenResponse$1

            /* compiled from: InternshipFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends InternshipResponse> resource) {
                invoke2((Resource<InternshipResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<InternshipResponse> resource) {
                InternshipAdapter adapter;
                FragmentInternshipBinding fragmentInternshipBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    InternshipFragment.this.hideProgress();
                    InternshipResponse data = resource.getData();
                    if (data != null) {
                        InternshipFragment internshipFragment = InternshipFragment.this;
                        internshipFragment.showBaseView();
                        try {
                            adapter = internshipFragment.getAdapter();
                            adapter.addItems(data.getData());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    InternshipFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    InternshipFragment.this.hideProgress();
                    InternshipFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                InternshipFragment.this.hideProgress();
                InternshipFragment.this.showBaseView();
                fragmentInternshipBinding = InternshipFragment.this.get_binding();
                if (fragmentInternshipBinding == null || (recyclerView = fragmentInternshipBinding.rvInternship) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
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

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentInternshipBinding fragmentInternshipBinding = get_binding();
        if (fragmentInternshipBinding == null || (recyclerView = fragmentInternshipBinding.rvInternship) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentInternshipBinding fragmentInternshipBinding = get_binding();
        if (fragmentInternshipBinding == null || (recyclerView = fragmentInternshipBinding.rvInternship) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
        this.listener = null;
    }

    @Override // in.etuwa.app.ui.internship.apply.ApplyInternship.ApplyInternshipCallBack, in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialog.UploadAssignmentCallBack
    public void onDismiss() {
        getInternshipViewModel().getInternship();
    }

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public void downloadFile(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? AppConstant.INTERNSHIP_PATH : AppConstant.UPLOAD_INTERNSHIP_PATH;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(replace, flag)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, str);
                return;
            }
            try {
                FragmentInternshipBinding fragmentInternshipBinding = get_binding();
                if (fragmentInternshipBinding != null && (recyclerView = fragmentInternshipBinding.rvInternship) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(str, url);
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

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.INTERNSHIP_PATH);
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_INTERNSHIP_PATH);
    }

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            loadPickerDialog(id);
        } else {
            requestPermission();
        }
    }

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public void onViewDoc(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(getActivity(), (Class<?>) VerifiedCertificateActivity.class);
        intent.putExtra("url", url);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    private final void loadPickerDialog(String id) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        CompletionCertificateDialog newInstance = CompletionCertificateDialog.INSTANCE.newInstance(id);
        newInstance.setUploadCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public void openReport(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            if (Intrinsics.areEqual(url, "")) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            startActivity(Intent.createChooser(intent, "Open With"));
        } catch (NullPointerException unused) {
        }
    }

    @Override // in.etuwa.app.ui.internship.InternshipAdapter.CallBack
    public void showError() {
        Toast.makeText(requireContext(), "No File to View,Try again later.", 0).show();
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.internship.InternshipFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InternshipFragment.requestPermission$lambda$2(InternshipFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$2(InternshipFragment this$0, DialogInterface dialogInterface, int i) {
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
}