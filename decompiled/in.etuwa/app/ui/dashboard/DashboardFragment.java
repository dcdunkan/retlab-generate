package in.etuwa.app.ui.dashboard;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
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
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.dash.LibraryResponse;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.model.dash.PendingSurvey;
import in.etuwa.app.data.model.main.CourseSurveyPending;
import in.etuwa.app.data.model.main.POSurveyPending;
import in.etuwa.app.data.model.main.SurveyMandatory;
import in.etuwa.app.data.model.main.SurveyPending;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentDashboardBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.WrapContentViewPager;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.dashboard.DashboardAdapter;
import in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog;
import in.etuwa.app.ui.dashboard.dashtable.DashTimeTableAdapter;
import in.etuwa.app.ui.dashboard.maintenance.MaintenanceDialog;
import in.etuwa.app.ui.dashboard.missiondialog.MissionDialog;
import in.etuwa.app.ui.dashboard.visiondialog.VisionDialog;
import in.etuwa.app.ui.store.StoreDialog;
import in.etuwa.app.ui.timetable.TimetableListener;
import in.etuwa.app.utils.DashboardItems;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DashboardFragment.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u0084\u0001B\u0005¢\u0006\u0002\u0010\tJ\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020QH\u0016J\u0010\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020-H\u0002J\b\u0010U\u001a\u00020QH\u0002J\b\u0010V\u001a\u00020QH\u0002J\b\u0010W\u001a\u00020QH\u0014J\b\u0010X\u001a\u00020QH\u0014J\b\u0010Y\u001a\u00020QH\u0002J\b\u0010Z\u001a\u00020QH\u0002J\b\u0010[\u001a\u00020QH\u0002J\b\u0010\\\u001a\u00020QH\u0003J\b\u0010]\u001a\u00020QH\u0002J\b\u0010^\u001a\u00020QH\u0002J\b\u0010_\u001a\u00020QH\u0002J\b\u0010`\u001a\u00020QH\u0002J\b\u0010a\u001a\u00020QH\u0002J\b\u0010b\u001a\u00020QH\u0002J\b\u0010c\u001a\u00020QH\u0016J\b\u0010d\u001a\u00020QH\u0016J\u0010\u0010e\u001a\u00020Q2\u0006\u0010f\u001a\u00020gH\u0016J\u0012\u0010h\u001a\u00020Q2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J&\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010p2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0010\u0010q\u001a\u00020Q2\u0006\u0010r\u001a\u00020-H\u0016J\b\u0010s\u001a\u00020QH\u0016J\b\u0010t\u001a\u00020QH\u0016J\b\u0010u\u001a\u00020QH\u0016J\b\u0010v\u001a\u00020QH\u0016J\b\u0010w\u001a\u00020QH\u0016J\b\u0010x\u001a\u00020QH\u0016J\u001a\u0010y\u001a\u00020Q2\u0006\u0010z\u001a\u00020l2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\b\u0010{\u001a\u00020QH\u0014J\b\u0010|\u001a\u00020QH\u0014J\u0010\u0010}\u001a\u00020Q2\u0006\u0010~\u001a\u000205H\u0002J\u0011\u0010\u007f\u001a\u00020Q2\u0007\u0010\u0080\u0001\u001a\u000205H\u0002J\t\u0010\u0081\u0001\u001a\u00020QH\u0014J\t\u0010\u0082\u0001\u001a\u00020QH\u0002J\t\u0010\u0083\u0001\u001a\u00020QH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001a\u0010=\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\u001a\u0010@\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0011\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00107\"\u0004\bJ\u00109R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0011\u001a\u0004\bM\u0010N¨\u0006\u0085\u0001"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/dashboard/DashboardAdapter$CallBack;", "Lin/etuwa/app/ui/timetable/TimetableListener;", "Lin/etuwa/app/ui/dashboard/changepic/ChangeProPicDialog$ProfileCallBack;", "Lin/etuwa/app/ui/store/StoreDialog$StoreListener;", "Lin/etuwa/app/ui/dashboard/visiondialog/VisionDialog$StoreListener;", "Lin/etuwa/app/ui/dashboard/missiondialog/MissionDialog$StoreListener;", "Lin/etuwa/app/ui/dashboard/maintenance/MaintenanceDialog$StoreListener;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentDashboardBinding;", "adapter", "Lin/etuwa/app/ui/dashboard/DashboardAdapter;", "getAdapter", "()Lin/etuwa/app/ui/dashboard/DashboardAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentDashboardBinding;", "dashboardViewModel", "Lin/etuwa/app/ui/dashboard/DashboardViewModel;", "getDashboardViewModel", "()Lin/etuwa/app/ui/dashboard/DashboardViewModel;", "dashboardViewModel$delegate", "flag1", "", "getFlag1", "()Z", "setFlag1", "(Z)V", "flag2", "getFlag2", "setFlag2", "flag3", "getFlag3", "setFlag3", "flag4", "getFlag4", "setFlag4", "flag5", "getFlag5", "setFlag5", "i", "", "getI", "()I", "setI", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "liveTvLink", "", "getLiveTvLink", "()Ljava/lang/String;", "setLiveTvLink", "(Ljava/lang/String;)V", "liveTvType", "getLiveTvType", "setLiveTvType", "noticeTV", "getNoticeTV", "setNoticeTV", "noticeTv2", "getNoticeTv2", "setNoticeTv2", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "statusPending", "getStatusPending", "setStatusPending", "tableAdapter", "Lin/etuwa/app/ui/dashboard/dashtable/DashTimeTableAdapter;", "getTableAdapter", "()Lin/etuwa/app/ui/dashboard/dashtable/DashTimeTableAdapter;", "tableAdapter$delegate", "dismiss", "", "dismissView", "forceupdate", "versionCode", "gotToPlaystore", "gotToPlaystore2", "hideBaseView", "hideProgress", "listenCourseSurveyStatus", "listenMaintenanceResponse", "listenPoSurveyStatus", "listenResponse", "listenResponse2", "listenSurveyMandatoryStatus", "listenSurveyStatus", "listenSurveyStatusResponse", "listenTableResponse", "listenUrlResponse", "loadPage", "loadStoreView", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDashItemClicked", CommonCssConstants.POSITION, "onDestroy", "onDetach", "onDismissProfile", "onPause", "onResume", "onStop", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showInfoDialog", "infoMsg", "showPendingDialog", "message", "showProgress", "showUpdateDialog", "showUpdateDialog2", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DashboardFragment extends BaseFragment implements DashboardAdapter.CallBack, TimetableListener, ChangeProPicDialog.ProfileCallBack, StoreDialog.StoreListener, VisionDialog.StoreListener, MissionDialog.StoreListener, MaintenanceDialog.StoreListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentDashboardBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: dashboardViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dashboardViewModel;
    private boolean flag1;
    private boolean flag2;
    private boolean flag3;
    private boolean flag4;
    private boolean flag5;
    private int i;
    private MainCallBackListener listener;
    private String liveTvLink;
    private String liveTvType;
    private String noticeTV;
    private String noticeTv2;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String statusPending;

    /* renamed from: tableAdapter$delegate, reason: from kotlin metadata */
    private final Lazy tableAdapter;

    /* compiled from: DashboardFragment.kt */
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
    public static final DashboardFragment newInstance(Integer num) {
        return INSTANCE.newInstance(num);
    }

    @Override // in.etuwa.app.ui.store.StoreDialog.StoreListener, in.etuwa.app.ui.dashboard.visiondialog.VisionDialog.StoreListener, in.etuwa.app.ui.dashboard.missiondialog.MissionDialog.StoreListener
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.store.StoreDialog.StoreListener
    public void loadStoreView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public DashboardFragment() {
        final DashboardFragment dashboardFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(dashboardFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.dashboardViewModel = FragmentViewModelLazyKt.createViewModelLazy(dashboardFragment, Reflection.getOrCreateKotlinClass(DashboardViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(DashboardViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final DashboardFragment dashboardFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DashboardAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashboardAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashboardAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashboardAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$tableAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(DashboardFragment.this.getChildFragmentManager());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.tableAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<DashTimeTableAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.dashtable.DashTimeTableAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashTimeTableAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashTimeTableAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
        this.noticeTV = "";
        this.noticeTv2 = "";
        this.liveTvLink = "";
        this.liveTvType = "";
        this.statusPending = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DashboardViewModel getDashboardViewModel() {
        return (DashboardViewModel) this.dashboardViewModel.getValue();
    }

    private final DashboardAdapter getAdapter() {
        return (DashboardAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DashTimeTableAdapter getTableAdapter() {
        return (DashTimeTableAdapter) this.tableAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentDashboardBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final String getNoticeTV() {
        return this.noticeTV;
    }

    public final void setNoticeTV(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noticeTV = str;
    }

    public final String getNoticeTv2() {
        return this.noticeTv2;
    }

    public final void setNoticeTv2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noticeTv2 = str;
    }

    public final String getLiveTvLink() {
        return this.liveTvLink;
    }

    public final void setLiveTvLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveTvLink = str;
    }

    public final String getLiveTvType() {
        return this.liveTvType;
    }

    public final void setLiveTvType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveTvType = str;
    }

    public final boolean getFlag1() {
        return this.flag1;
    }

    public final void setFlag1(boolean z) {
        this.flag1 = z;
    }

    public final boolean getFlag2() {
        return this.flag2;
    }

    public final void setFlag2(boolean z) {
        this.flag2 = z;
    }

    public final boolean getFlag3() {
        return this.flag3;
    }

    public final void setFlag3(boolean z) {
        this.flag3 = z;
    }

    public final boolean getFlag4() {
        return this.flag4;
    }

    public final void setFlag4(boolean z) {
        this.flag4 = z;
    }

    public final boolean getFlag5() {
        return this.flag5;
    }

    public final void setFlag5(boolean z) {
        this.flag5 = z;
    }

    public final String getStatusPending() {
        return this.statusPending;
    }

    public final void setStatusPending(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusPending = str;
    }

    /* compiled from: DashboardFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/dashboard/DashboardFragment;", "id", "", "(Ljava/lang/Integer;)Lin/etuwa/app/ui/dashboard/DashboardFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DashboardFragment newInstance(Integer id) {
            DashboardFragment dashboardFragment = new DashboardFragment();
            Bundle bundle = new Bundle();
            Intrinsics.checkNotNull(id);
            bundle.putInt("id", id.intValue());
            dashboardFragment.setArguments(bundle);
            return dashboardFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getInt("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ActionBar supportActionBar;
        super.onResume();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.hide();
        }
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        CardView cardView = fragmentDashboardBinding != null ? fragmentDashboardBinding.cvDash : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        CardView cardView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.attendanceCv : null;
        if (cardView2 != null) {
            cardView2.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        CardView cardView3 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noticeCv : null;
        if (cardView3 != null) {
            cardView3.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
        CardView cardView4 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.cvVisionMission : null;
        if (cardView4 != null) {
            cardView4.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
        CardView cardView5 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvTimetable : null;
        if (cardView5 == null) {
            return;
        }
        cardView5.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ActionBar supportActionBar;
        super.onStop();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.show();
        }
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        CardView cardView = fragmentDashboardBinding != null ? fragmentDashboardBinding.cvDash : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        CardView cardView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.attendanceCv : null;
        if (cardView2 != null) {
            cardView2.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        CardView cardView3 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noticeCv : null;
        if (cardView3 != null) {
            cardView3.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
        CardView cardView4 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.cvVisionMission : null;
        if (cardView4 != null) {
            cardView4.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
        CardView cardView5 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvTimetable : null;
        if (cardView5 == null) {
            return;
        }
        cardView5.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ActionBar supportActionBar;
        super.onPause();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.show();
        }
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        CardView cardView = fragmentDashboardBinding != null ? fragmentDashboardBinding.cvDash : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        CardView cardView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.attendanceCv : null;
        if (cardView2 != null) {
            cardView2.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        CardView cardView3 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noticeCv : null;
        if (cardView3 != null) {
            cardView3.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
        CardView cardView4 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.cvVisionMission : null;
        if (cardView4 != null) {
            cardView4.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
        CardView cardView5 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvTimetable : null;
        if (cardView5 == null) {
            return;
        }
        cardView5.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentDashboardBinding.inflate(inflater, container, false);
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        if (fragmentDashboardBinding != null) {
            fragmentDashboardBinding.setDashboardViewModel(getDashboardViewModel());
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        if (fragmentDashboardBinding2 != null) {
            fragmentDashboardBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        if (fragmentDashboardBinding3 != null) {
            return fragmentDashboardBinding3.getRoot();
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
        CircleProgressView circleProgressView;
        TextView textView;
        TextView textView2;
        CardView cardView;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        CardView cardView2;
        TextView textView7;
        SwipeRefreshLayout swipeRefreshLayout;
        TabLayout tabLayout;
        ImageView imageView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.home));
        }
        Log.d("DashboardFragment", "setUp() called");
        if (!getPreference().getLogin()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setMessage("This application is going to logout, Please Re-login again\n If you don't remember your login details please contact collage etlab admin");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DashboardFragment.setUp$lambda$1(DashboardFragment.this, dialogInterface, i);
                }
            });
            builder.setCancelable(false);
            builder.show();
        }
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        if (fragmentDashboardBinding != null && (imageView = fragmentDashboardBinding.infoTimeTableHome) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$2(DashboardFragment.this, view);
                }
            });
        }
        getDashboardViewModel().getMaintenance();
        listenResponse2();
        listenTableResponse();
        getDashboardViewModel().getTableData();
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        TextView textView8 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.dashUserName : null;
        if (textView8 != null) {
            textView8.setText(getPreference().getUserProName());
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        TextView textView9 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.dashUserSem : null;
        if (textView9 != null) {
            textView9.setText(getPreference().getUserSem());
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
        TextView textView10 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.dashUserDept : null;
        if (textView10 != null) {
            textView10.setText(getPreference().getUserCourse());
        }
        System.out.println((Object) getPreference().getUserProName());
        FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
        RecyclerView recyclerView = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.rvDash : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        if (Intrinsics.areEqual(getPreference().getUserType(), ExifInterface.GPS_MEASUREMENT_2D)) {
            getAdapter().addItems(DashboardItems.INSTANCE.getTitleParent(), DashboardItems.INSTANCE.getIconsParents());
        } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null)) {
            getAdapter().addItems(DashboardItems.INSTANCE.getTitleTkm(), DashboardItems.INSTANCE.getIconsTkm());
        } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sbce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sahrdaya", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null)) {
            getAdapter().addItems(DashboardItems.INSTANCE.getTitleTkm(), DashboardItems.INSTANCE.getIconsTkm());
        } else {
            getAdapter().addItems(DashboardItems.INSTANCE.getTitle(), DashboardItems.INSTANCE.getIcons());
        }
        getAdapter().setCallBack(this);
        FragmentDashboardBinding fragmentDashboardBinding6 = get_binding();
        WrapContentViewPager wrapContentViewPager = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.dashTimeTablePager : null;
        if (wrapContentViewPager != null) {
            wrapContentViewPager.setAdapter(getTableAdapter());
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = get_binding();
        if (fragmentDashboardBinding7 != null && (tabLayout = fragmentDashboardBinding7.dashTabs) != null) {
            FragmentDashboardBinding fragmentDashboardBinding8 = get_binding();
            tabLayout.setupWithViewPager(fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.dashTimeTablePager : null);
        }
        getTableAdapter().setCallBack(this);
        if (getPreference().getNewLogin()) {
            this.i = 0;
            if (Intrinsics.areEqual(getPreference().getBaseUrl(), "https://nssce.etlab.in/androidapp/mobile/")) {
                getDashboardViewModel().getDashData("99");
            } else {
                getDashboardViewModel().getDashData(null);
            }
            listenSurveyStatus();
            listenResponse();
            listenPoSurveyStatus();
            listenCourseSurveyStatus();
            listenSurveyMandatoryStatus();
            getDashboardViewModel().getSurveyMandatoryStatus();
        } else {
            this.i = 0;
            try {
                if (getPreference().getUserImg().length() > 0) {
                    RequestCreator centerCrop = Picasso.get().load(getPreference().getUserImg()).placeholder(R.drawable.ic_user_profile).error(R.drawable.ic_user_profile).resize(90, 90).centerCrop();
                    FragmentDashboardBinding fragmentDashboardBinding9 = get_binding();
                    CircleImageView circleImageView = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.userIcon : null;
                    Intrinsics.checkNotNull(circleImageView);
                    centerCrop.into(circleImageView);
                }
                FragmentDashboardBinding fragmentDashboardBinding10 = get_binding();
                if (fragmentDashboardBinding10 != null && (circleProgressView = fragmentDashboardBinding10.dashAttendanceForSem) != null) {
                    circleProgressView.setValueAnimated(Float.parseFloat(getPreference().getAttendancePercentage()));
                }
                FragmentDashboardBinding fragmentDashboardBinding11 = get_binding();
                TextView textView11 = fragmentDashboardBinding11 != null ? fragmentDashboardBinding11.noticeText : null;
                if (textView11 != null) {
                    textView11.setSelected(true);
                }
                FragmentDashboardBinding fragmentDashboardBinding12 = get_binding();
                TextView textView12 = fragmentDashboardBinding12 != null ? fragmentDashboardBinding12.noticeText : null;
                if (textView12 != null) {
                    textView12.setText("       " + getPreference().getNoticeOne() + "                 " + getPreference().getNoticeTwo() + "                    " + getPreference().getNoticeThree() + "        ");
                }
                if (357 < Integer.parseInt(getPreference().getVersionCode())) {
                    showUpdateDialog2();
                }
            } catch (NumberFormatException unused) {
            }
        }
        FragmentDashboardBinding fragmentDashboardBinding13 = get_binding();
        if (fragmentDashboardBinding13 != null && (swipeRefreshLayout = fragmentDashboardBinding13.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda14
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    DashboardFragment.setUp$lambda$3(DashboardFragment.this);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding14 = get_binding();
        if (fragmentDashboardBinding14 != null && (textView7 = fragmentDashboardBinding14.libraryBtn) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$4(DashboardFragment.this, view);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding15 = get_binding();
        if (fragmentDashboardBinding15 != null && (cardView2 = fragmentDashboardBinding15.attendanceCv) != null) {
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$5(DashboardFragment.this, view);
                }
            });
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gecwyd", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
            FragmentDashboardBinding fragmentDashboardBinding16 = get_binding();
            CardView cardView3 = fragmentDashboardBinding16 != null ? fragmentDashboardBinding16.libraryCard : null;
            if (cardView3 != null) {
                cardView3.setVisibility(0);
            }
            getDashboardViewModel().getLibrary();
        } else {
            FragmentDashboardBinding fragmentDashboardBinding17 = get_binding();
            CardView cardView4 = fragmentDashboardBinding17 != null ? fragmentDashboardBinding17.libraryCard : null;
            if (cardView4 != null) {
                cardView4.setVisibility(8);
            }
        }
        FragmentDashboardBinding fragmentDashboardBinding18 = get_binding();
        if (fragmentDashboardBinding18 != null && (textView6 = fragmentDashboardBinding18.visionBtn) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$6(DashboardFragment.this, view);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding19 = get_binding();
        if (fragmentDashboardBinding19 != null && (textView5 = fragmentDashboardBinding19.missionBtn) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$7(DashboardFragment.this, view);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding20 = get_binding();
        if (fragmentDashboardBinding20 != null && (textView4 = fragmentDashboardBinding20.live) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$8(DashboardFragment.this, view);
                }
            });
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
            FragmentDashboardBinding fragmentDashboardBinding21 = get_binding();
            TextView textView13 = fragmentDashboardBinding21 != null ? fragmentDashboardBinding21.changeBtn : null;
            if (textView13 != null) {
                textView13.setVisibility(8);
            }
        }
        FragmentDashboardBinding fragmentDashboardBinding22 = get_binding();
        if (fragmentDashboardBinding22 != null && (textView3 = fragmentDashboardBinding22.changeBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$9(DashboardFragment.this, view);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding23 = get_binding();
        if (fragmentDashboardBinding23 != null && (cardView = fragmentDashboardBinding23.noticeCv) != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$10(DashboardFragment.this, view);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding24 = get_binding();
        if (fragmentDashboardBinding24 != null && (textView2 = fragmentDashboardBinding24.downBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.setUp$lambda$11(DashboardFragment.this, view);
                }
            });
        }
        FragmentDashboardBinding fragmentDashboardBinding25 = get_binding();
        if (fragmentDashboardBinding25 == null || (textView = fragmentDashboardBinding25.upBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.setUp$lambda$12(DashboardFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(DashboardFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.makeLogout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showDayWiseTable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(DashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.getPreference().getBaseUrl(), "https://nssce.etlab.in/androidapp/mobile/")) {
            this$0.getDashboardViewModel().getDashData("99");
        } else {
            this$0.getDashboardViewModel().getDashData(null);
        }
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentDashboardBinding != null ? fragmentDashboardBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenUrlResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onAttendanceCardClicked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showVisionDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showMissionDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLiveClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChangeProPicDialog newInstance = ChangeProPicDialog.INSTANCE.newInstance();
        newInstance.setProfileCallBack(this$0);
        newInstance.show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onMarqueeClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        TextView textView = fragmentDashboardBinding != null ? fragmentDashboardBinding.downBtn : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        TextView textView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.dashUserRollNo : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        TextView textView3 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.dashUserSem : null;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        TextView textView4 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.dashUserDept : null;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        TextView textView5 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.upBtn : null;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        TextView textView6 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.changeBtn : null;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        CircleImageView circleImageView = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.userIcon : null;
        if (circleImageView == null) {
            return;
        }
        circleImageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        TextView textView = fragmentDashboardBinding != null ? fragmentDashboardBinding.downBtn : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        TextView textView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.dashUserRollNo : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        TextView textView3 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.dashUserSem : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        TextView textView4 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.dashUserDept : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        TextView textView5 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.upBtn : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        TextView textView6 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.changeBtn : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        CircleImageView circleImageView = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.userIcon : null;
        if (circleImageView == null) {
            return;
        }
        circleImageView.setVisibility(8);
    }

    private final void forceupdate(int versionCode) {
        System.out.println(versionCode);
        System.out.println(357);
        System.out.println(357);
        if (357 < versionCode) {
            showUpdateDialog2();
        }
    }

    private final void listenMaintenanceResponse() {
        getDashboardViewModel().getMaintenanceResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends MaintenanceResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenMaintenanceResponse$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends MaintenanceResponse> resource) {
                invoke2((Resource<MaintenanceResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<MaintenanceResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    DashboardFragment.this.hideProgress();
                    MaintenanceResponse data = resource.getData();
                    if (data != null) {
                        DashboardFragment dashboardFragment = DashboardFragment.this;
                        if (data.getSuccess()) {
                            return;
                        }
                        FragmentManager childFragmentManager = dashboardFragment.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        MaintenanceDialog newInstance = MaintenanceDialog.INSTANCE.newInstance();
                        newInstance.setCallBack(dashboardFragment);
                        newInstance.show(childFragmentManager, (String) null);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    System.out.println((Object) resource.getMessage());
                    DashboardFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    String message = resource.getMessage();
                    if (message != null) {
                        System.out.println((Object) ("Error message: " + message));
                        return;
                    }
                    return;
                }
                if (i != 4) {
                    return;
                }
                DashboardFragment.this.hideProgress();
                System.out.println((Object) "Exception");
                String message2 = resource.getMessage();
                if (message2 != null) {
                    DashboardFragment dashboardFragment2 = DashboardFragment.this;
                    if (StringsKt.contains$default((CharSequence) message2, (CharSequence) "403", false, 2, (Object) null)) {
                        FragmentManager childFragmentManager2 = dashboardFragment2.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                        MaintenanceDialog newInstance2 = MaintenanceDialog.INSTANCE.newInstance();
                        newInstance2.setCancelable(false);
                        newInstance2.setCallBack(dashboardFragment2);
                        newInstance2.show(childFragmentManager2, (String) null);
                        return;
                    }
                    System.out.println((Object) "Anuuu Unknown error occurred");
                }
            }
        }));
    }

    private final void listenSurveyStatusResponse() {
        getDashboardViewModel().getSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PendingSurvey>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyStatusResponse$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends PendingSurvey> resource) {
                invoke2((Resource<PendingSurvey>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<PendingSurvey> resource) {
                FragmentDashboardBinding fragmentDashboardBinding;
                FragmentDashboardBinding fragmentDashboardBinding2;
                FragmentDashboardBinding fragmentDashboardBinding3;
                FragmentDashboardBinding fragmentDashboardBinding4;
                FragmentDashboardBinding fragmentDashboardBinding5;
                CardView cardView;
                MainCallBackListener mainCallBackListener;
                FragmentDashboardBinding fragmentDashboardBinding6;
                FragmentDashboardBinding fragmentDashboardBinding7;
                FragmentDashboardBinding fragmentDashboardBinding8;
                FragmentDashboardBinding fragmentDashboardBinding9;
                FragmentDashboardBinding fragmentDashboardBinding10;
                FragmentDashboardBinding fragmentDashboardBinding11;
                TextView dashUserRollNo;
                MainCallBackListener mainCallBackListener2;
                FragmentDashboardBinding fragmentDashboardBinding12;
                FragmentDashboardBinding fragmentDashboardBinding13;
                FragmentDashboardBinding fragmentDashboardBinding14;
                FragmentDashboardBinding fragmentDashboardBinding15;
                FragmentDashboardBinding fragmentDashboardBinding16;
                FragmentDashboardBinding fragmentDashboardBinding17;
                TextView dashUserRollNo2;
                MainCallBackListener mainCallBackListener3;
                FragmentDashboardBinding fragmentDashboardBinding18;
                FragmentDashboardBinding fragmentDashboardBinding19;
                FragmentDashboardBinding fragmentDashboardBinding20;
                FragmentDashboardBinding fragmentDashboardBinding21;
                FragmentDashboardBinding fragmentDashboardBinding22;
                FragmentDashboardBinding fragmentDashboardBinding23;
                TextView dashUserRollNo3;
                SharedPrefManager preference;
                MainCallBackListener mainCallBackListener4;
                FragmentDashboardBinding fragmentDashboardBinding24;
                FragmentDashboardBinding fragmentDashboardBinding25;
                FragmentDashboardBinding fragmentDashboardBinding26;
                FragmentDashboardBinding fragmentDashboardBinding27;
                FragmentDashboardBinding fragmentDashboardBinding28;
                FragmentDashboardBinding fragmentDashboardBinding29;
                TextView dashUserRollNo4;
                FragmentDashboardBinding fragmentDashboardBinding30;
                FragmentDashboardBinding fragmentDashboardBinding31;
                FragmentDashboardBinding fragmentDashboardBinding32;
                FragmentDashboardBinding fragmentDashboardBinding33;
                FragmentDashboardBinding fragmentDashboardBinding34;
                FragmentDashboardBinding fragmentDashboardBinding35;
                MainCallBackListener mainCallBackListener5;
                RecyclerView rvDash;
                FragmentDashboardBinding fragmentDashboardBinding36;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        DashboardFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        DashboardFragment.this.hideProgress();
                        DashboardFragment.this.showBaseView();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    DashboardFragment.this.hideProgress();
                    DashboardFragment.this.showBaseView();
                    fragmentDashboardBinding36 = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding36 == null || (recyclerView = fragmentDashboardBinding36.rvDash) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                DashboardFragment.this.hideProgress();
                PendingSurvey data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    if (!data.getSemreg_default()) {
                        fragmentDashboardBinding30 = dashboardFragment.get_binding();
                        CardView cardView2 = fragmentDashboardBinding30 != null ? fragmentDashboardBinding30.cvDash : null;
                        if (cardView2 != null) {
                            cardView2.setVisibility(8);
                        }
                        fragmentDashboardBinding31 = dashboardFragment.get_binding();
                        CardView cardView3 = fragmentDashboardBinding31 != null ? fragmentDashboardBinding31.attendanceCv : null;
                        if (cardView3 != null) {
                            cardView3.setVisibility(8);
                        }
                        fragmentDashboardBinding32 = dashboardFragment.get_binding();
                        CardView cardView4 = fragmentDashboardBinding32 != null ? fragmentDashboardBinding32.noticeCv : null;
                        if (cardView4 != null) {
                            cardView4.setVisibility(8);
                        }
                        fragmentDashboardBinding33 = dashboardFragment.get_binding();
                        CardView cardView5 = fragmentDashboardBinding33 != null ? fragmentDashboardBinding33.cvVisionMission : null;
                        if (cardView5 != null) {
                            cardView5.setVisibility(8);
                        }
                        fragmentDashboardBinding34 = dashboardFragment.get_binding();
                        cardView = fragmentDashboardBinding34 != null ? fragmentDashboardBinding34.cvTimetable : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        fragmentDashboardBinding35 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding35 != null && (rvDash = fragmentDashboardBinding35.rvDash) != null) {
                            Intrinsics.checkNotNullExpressionValue(rvDash, "rvDash");
                            ToastExtKt.showErrorToast(rvDash, "Complete your Semester Registration for accessing Etlab!!!");
                        }
                        mainCallBackListener5 = dashboardFragment.listener;
                        if (mainCallBackListener5 != null) {
                            mainCallBackListener5.openForceSemReg();
                            return;
                        }
                        return;
                    }
                    if (data.getProfile_status()) {
                        preference = dashboardFragment.getPreference();
                        if (StringsKt.contains$default((CharSequence) preference.getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
                            mainCallBackListener4 = dashboardFragment.listener;
                            if (mainCallBackListener4 != null) {
                                mainCallBackListener4.forceOpenProfile();
                            }
                            fragmentDashboardBinding24 = dashboardFragment.get_binding();
                            CardView cardView6 = fragmentDashboardBinding24 != null ? fragmentDashboardBinding24.cvDash : null;
                            if (cardView6 != null) {
                                cardView6.setVisibility(8);
                            }
                            fragmentDashboardBinding25 = dashboardFragment.get_binding();
                            CardView cardView7 = fragmentDashboardBinding25 != null ? fragmentDashboardBinding25.attendanceCv : null;
                            if (cardView7 != null) {
                                cardView7.setVisibility(8);
                            }
                            fragmentDashboardBinding26 = dashboardFragment.get_binding();
                            CardView cardView8 = fragmentDashboardBinding26 != null ? fragmentDashboardBinding26.noticeCv : null;
                            if (cardView8 != null) {
                                cardView8.setVisibility(8);
                            }
                            fragmentDashboardBinding27 = dashboardFragment.get_binding();
                            CardView cardView9 = fragmentDashboardBinding27 != null ? fragmentDashboardBinding27.cvVisionMission : null;
                            if (cardView9 != null) {
                                cardView9.setVisibility(8);
                            }
                            fragmentDashboardBinding28 = dashboardFragment.get_binding();
                            cardView = fragmentDashboardBinding28 != null ? fragmentDashboardBinding28.cvTimetable : null;
                            if (cardView != null) {
                                cardView.setVisibility(8);
                            }
                            fragmentDashboardBinding29 = dashboardFragment.get_binding();
                            if (fragmentDashboardBinding29 == null || (dashUserRollNo4 = fragmentDashboardBinding29.dashUserRollNo) == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(dashUserRollNo4, "dashUserRollNo");
                            ToastExtKt.showInfoToast(dashUserRollNo4, "Please complete the Profile to access dashboard");
                            return;
                        }
                    }
                    if (data.getSurvey_status()) {
                        mainCallBackListener3 = dashboardFragment.listener;
                        if (mainCallBackListener3 != null) {
                            mainCallBackListener3.openForceToDoSurvey();
                        }
                        fragmentDashboardBinding18 = dashboardFragment.get_binding();
                        CardView cardView10 = fragmentDashboardBinding18 != null ? fragmentDashboardBinding18.cvDash : null;
                        if (cardView10 != null) {
                            cardView10.setVisibility(8);
                        }
                        fragmentDashboardBinding19 = dashboardFragment.get_binding();
                        CardView cardView11 = fragmentDashboardBinding19 != null ? fragmentDashboardBinding19.attendanceCv : null;
                        if (cardView11 != null) {
                            cardView11.setVisibility(8);
                        }
                        fragmentDashboardBinding20 = dashboardFragment.get_binding();
                        CardView cardView12 = fragmentDashboardBinding20 != null ? fragmentDashboardBinding20.noticeCv : null;
                        if (cardView12 != null) {
                            cardView12.setVisibility(8);
                        }
                        fragmentDashboardBinding21 = dashboardFragment.get_binding();
                        CardView cardView13 = fragmentDashboardBinding21 != null ? fragmentDashboardBinding21.cvVisionMission : null;
                        if (cardView13 != null) {
                            cardView13.setVisibility(8);
                        }
                        fragmentDashboardBinding22 = dashboardFragment.get_binding();
                        cardView = fragmentDashboardBinding22 != null ? fragmentDashboardBinding22.cvTimetable : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        fragmentDashboardBinding23 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding23 == null || (dashUserRollNo3 = fragmentDashboardBinding23.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo3, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo3, "Please complete the pending Survey to access dashboard");
                        return;
                    }
                    if (data.getPosurvey_status()) {
                        mainCallBackListener2 = dashboardFragment.listener;
                        if (mainCallBackListener2 != null) {
                            mainCallBackListener2.openPoSurvey();
                        }
                        fragmentDashboardBinding12 = dashboardFragment.get_binding();
                        CardView cardView14 = fragmentDashboardBinding12 != null ? fragmentDashboardBinding12.cvDash : null;
                        if (cardView14 != null) {
                            cardView14.setVisibility(8);
                        }
                        fragmentDashboardBinding13 = dashboardFragment.get_binding();
                        CardView cardView15 = fragmentDashboardBinding13 != null ? fragmentDashboardBinding13.attendanceCv : null;
                        if (cardView15 != null) {
                            cardView15.setVisibility(8);
                        }
                        fragmentDashboardBinding14 = dashboardFragment.get_binding();
                        CardView cardView16 = fragmentDashboardBinding14 != null ? fragmentDashboardBinding14.noticeCv : null;
                        if (cardView16 != null) {
                            cardView16.setVisibility(8);
                        }
                        fragmentDashboardBinding15 = dashboardFragment.get_binding();
                        CardView cardView17 = fragmentDashboardBinding15 != null ? fragmentDashboardBinding15.cvVisionMission : null;
                        if (cardView17 != null) {
                            cardView17.setVisibility(8);
                        }
                        fragmentDashboardBinding16 = dashboardFragment.get_binding();
                        cardView = fragmentDashboardBinding16 != null ? fragmentDashboardBinding16.cvTimetable : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        fragmentDashboardBinding17 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding17 == null || (dashUserRollNo2 = fragmentDashboardBinding17.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo2, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo2, "Please complete the pending PO Survey to access dashboard");
                        return;
                    }
                    if (data.getCoursesurvey_status()) {
                        mainCallBackListener = dashboardFragment.listener;
                        if (mainCallBackListener != null) {
                            mainCallBackListener.openCourseSurvey();
                        }
                        fragmentDashboardBinding6 = dashboardFragment.get_binding();
                        CardView cardView18 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.cvDash : null;
                        if (cardView18 != null) {
                            cardView18.setVisibility(8);
                        }
                        fragmentDashboardBinding7 = dashboardFragment.get_binding();
                        CardView cardView19 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.attendanceCv : null;
                        if (cardView19 != null) {
                            cardView19.setVisibility(8);
                        }
                        fragmentDashboardBinding8 = dashboardFragment.get_binding();
                        CardView cardView20 = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.noticeCv : null;
                        if (cardView20 != null) {
                            cardView20.setVisibility(8);
                        }
                        fragmentDashboardBinding9 = dashboardFragment.get_binding();
                        CardView cardView21 = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.cvVisionMission : null;
                        if (cardView21 != null) {
                            cardView21.setVisibility(8);
                        }
                        fragmentDashboardBinding10 = dashboardFragment.get_binding();
                        cardView = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.cvTimetable : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        fragmentDashboardBinding11 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding11 == null || (dashUserRollNo = fragmentDashboardBinding11.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo, "Please complete the pending Course Survey to access dashboard");
                        return;
                    }
                    fragmentDashboardBinding = dashboardFragment.get_binding();
                    CardView cardView22 = fragmentDashboardBinding != null ? fragmentDashboardBinding.cvDash : null;
                    if (cardView22 != null) {
                        cardView22.setVisibility(0);
                    }
                    fragmentDashboardBinding2 = dashboardFragment.get_binding();
                    CardView cardView23 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.attendanceCv : null;
                    if (cardView23 != null) {
                        cardView23.setVisibility(0);
                    }
                    fragmentDashboardBinding3 = dashboardFragment.get_binding();
                    CardView cardView24 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noticeCv : null;
                    if (cardView24 != null) {
                        cardView24.setVisibility(0);
                    }
                    fragmentDashboardBinding4 = dashboardFragment.get_binding();
                    CardView cardView25 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.cvVisionMission : null;
                    if (cardView25 != null) {
                        cardView25.setVisibility(0);
                    }
                    fragmentDashboardBinding5 = dashboardFragment.get_binding();
                    cardView = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvTimetable : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                }
            }
        }));
    }

    private final void showUpdateDialog2() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setMessage(getString(R.string.update_msg));
            builder.setPositiveButton("Update", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DashboardFragment.showUpdateDialog2$lambda$13(DashboardFragment.this, dialogInterface, i);
                }
            });
            builder.setCancelable(false);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUpdateDialog2$lambda$13(DashboardFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotToPlaystore2();
    }

    private final void gotToPlaystore2() {
        if (!isAdded() || getActivity() == null) {
            return;
        }
        String packageName = requireActivity().getPackageName();
        Uri parse = Uri.parse("market://details?id=" + packageName);
        Uri parse2 = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName);
        try {
            startActivity(new Intent("android.intent.action.VIEW", parse));
        } catch (ActivityNotFoundException unused) {
            if (!isAdded() || getActivity() == null) {
                return;
            }
            startActivity(new Intent("android.intent.action.VIEW", parse2));
        }
    }

    @Override // in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog.ProfileCallBack
    public void onDismissProfile() {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onDismissProfile();
        }
    }

    private final void listenTableResponse() {
        getDashboardViewModel().getTimeTableResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends TimetableResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenTableResponse$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends TimetableResponse> resource) {
                invoke2((Resource<TimetableResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<TimetableResponse> resource) {
                FragmentDashboardBinding fragmentDashboardBinding;
                CardView attendanceCv;
                DashTimeTableAdapter tableAdapter;
                FragmentDashboardBinding fragmentDashboardBinding2;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    DashboardFragment.this.hideProgress();
                    TimetableResponse data = resource.getData();
                    if (data != null) {
                        DashboardFragment dashboardFragment = DashboardFragment.this;
                        dashboardFragment.showBaseView();
                        try {
                            tableAdapter = dashboardFragment.getTableAdapter();
                            tableAdapter.addItems(data.getTimetable());
                            Unit unit = Unit.INSTANCE;
                            return;
                        } catch (NullPointerException unused) {
                            fragmentDashboardBinding = dashboardFragment.get_binding();
                            if (fragmentDashboardBinding == null || (attendanceCv = fragmentDashboardBinding.attendanceCv) == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(attendanceCv, "attendanceCv");
                            ToastExtKt.showErrorToast(attendanceCv, "Some Error Occured.Try again later!!");
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    DashboardFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    DashboardFragment.this.hideProgress();
                    DashboardFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                DashboardFragment.this.hideProgress();
                DashboardFragment.this.showBaseView();
                fragmentDashboardBinding2 = DashboardFragment.this.get_binding();
                if (fragmentDashboardBinding2 == null || (recyclerView = fragmentDashboardBinding2.rvDash) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    private final void listenSurveyMandatoryStatus() {
        getDashboardViewModel().getSurveyMandatoryStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SurveyMandatory>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyMandatoryStatus$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SurveyMandatory> resource) {
                invoke2((Resource<SurveyMandatory>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SurveyMandatory> resource) {
                FragmentDashboardBinding fragmentDashboardBinding;
                CardView attendanceCv;
                FragmentDashboardBinding fragmentDashboardBinding2;
                FragmentDashboardBinding fragmentDashboardBinding3;
                FragmentDashboardBinding fragmentDashboardBinding4;
                FragmentDashboardBinding fragmentDashboardBinding5;
                FragmentDashboardBinding fragmentDashboardBinding6;
                DashboardViewModel dashboardViewModel;
                FragmentDashboardBinding fragmentDashboardBinding7;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        DashboardFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        DashboardFragment.this.hideProgress();
                        DashboardFragment.this.showBaseView();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    DashboardFragment.this.hideProgress();
                    DashboardFragment.this.showBaseView();
                    fragmentDashboardBinding7 = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding7 == null || (recyclerView = fragmentDashboardBinding7.rvDash) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                DashboardFragment.this.hideProgress();
                SurveyMandatory data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    try {
                        if (!data.getLogin() || !data.getSurvey_mandatory()) {
                            fragmentDashboardBinding2 = dashboardFragment.get_binding();
                            CardView cardView = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.cvDash : null;
                            if (cardView != null) {
                                cardView.setVisibility(0);
                            }
                            fragmentDashboardBinding3 = dashboardFragment.get_binding();
                            CardView cardView2 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.attendanceCv : null;
                            if (cardView2 != null) {
                                cardView2.setVisibility(0);
                            }
                            fragmentDashboardBinding4 = dashboardFragment.get_binding();
                            CardView cardView3 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.noticeCv : null;
                            if (cardView3 != null) {
                                cardView3.setVisibility(0);
                            }
                            fragmentDashboardBinding5 = dashboardFragment.get_binding();
                            CardView cardView4 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvVisionMission : null;
                            if (cardView4 != null) {
                                cardView4.setVisibility(0);
                            }
                            fragmentDashboardBinding6 = dashboardFragment.get_binding();
                            CardView cardView5 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.cvTimetable : null;
                            if (cardView5 != null) {
                                cardView5.setVisibility(0);
                            }
                        } else {
                            dashboardViewModel = dashboardFragment.getDashboardViewModel();
                            dashboardViewModel.getPendingSurveyStatus();
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        fragmentDashboardBinding = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding == null || (attendanceCv = fragmentDashboardBinding.attendanceCv) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(attendanceCv, "attendanceCv");
                        ToastExtKt.showErrorToast(attendanceCv, "Some Error Occured.Try again later!!");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenCourseSurveyStatus() {
        getDashboardViewModel().getCourseSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CourseSurveyPending>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenCourseSurveyStatus$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CourseSurveyPending> resource) {
                invoke2((Resource<CourseSurveyPending>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CourseSurveyPending> resource) {
                FragmentDashboardBinding fragmentDashboardBinding;
                CardView attendanceCv;
                FragmentDashboardBinding fragmentDashboardBinding2;
                FragmentDashboardBinding fragmentDashboardBinding3;
                FragmentDashboardBinding fragmentDashboardBinding4;
                FragmentDashboardBinding fragmentDashboardBinding5;
                FragmentDashboardBinding fragmentDashboardBinding6;
                CardView cardView;
                FragmentDashboardBinding fragmentDashboardBinding7;
                FragmentDashboardBinding fragmentDashboardBinding8;
                FragmentDashboardBinding fragmentDashboardBinding9;
                FragmentDashboardBinding fragmentDashboardBinding10;
                FragmentDashboardBinding fragmentDashboardBinding11;
                FragmentDashboardBinding fragmentDashboardBinding12;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        DashboardFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        DashboardFragment.this.hideProgress();
                        DashboardFragment.this.showBaseView();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    DashboardFragment.this.hideProgress();
                    DashboardFragment.this.showBaseView();
                    fragmentDashboardBinding12 = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding12 == null || (recyclerView = fragmentDashboardBinding12.rvDash) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                DashboardFragment.this.hideProgress();
                CourseSurveyPending data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    try {
                        if (data.getCoursesurvey_status()) {
                            fragmentDashboardBinding7 = dashboardFragment.get_binding();
                            CardView cardView2 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.cvDash : null;
                            if (cardView2 != null) {
                                cardView2.setVisibility(8);
                            }
                            fragmentDashboardBinding8 = dashboardFragment.get_binding();
                            CardView cardView3 = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.attendanceCv : null;
                            if (cardView3 != null) {
                                cardView3.setVisibility(8);
                            }
                            fragmentDashboardBinding9 = dashboardFragment.get_binding();
                            CardView cardView4 = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.noticeCv : null;
                            if (cardView4 != null) {
                                cardView4.setVisibility(8);
                            }
                            fragmentDashboardBinding10 = dashboardFragment.get_binding();
                            CardView cardView5 = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.cvVisionMission : null;
                            if (cardView5 != null) {
                                cardView5.setVisibility(8);
                            }
                            fragmentDashboardBinding11 = dashboardFragment.get_binding();
                            cardView = fragmentDashboardBinding11 != null ? fragmentDashboardBinding11.cvTimetable : null;
                            if (cardView != null) {
                                cardView.setVisibility(8);
                            }
                            dashboardFragment.showPendingDialog("Please complete the pending Course Survey to access dashboard");
                        } else {
                            fragmentDashboardBinding2 = dashboardFragment.get_binding();
                            CardView cardView6 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.cvDash : null;
                            if (cardView6 != null) {
                                cardView6.setVisibility(0);
                            }
                            fragmentDashboardBinding3 = dashboardFragment.get_binding();
                            CardView cardView7 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.attendanceCv : null;
                            if (cardView7 != null) {
                                cardView7.setVisibility(0);
                            }
                            fragmentDashboardBinding4 = dashboardFragment.get_binding();
                            CardView cardView8 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.noticeCv : null;
                            if (cardView8 != null) {
                                cardView8.setVisibility(0);
                            }
                            fragmentDashboardBinding5 = dashboardFragment.get_binding();
                            CardView cardView9 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvVisionMission : null;
                            if (cardView9 != null) {
                                cardView9.setVisibility(0);
                            }
                            fragmentDashboardBinding6 = dashboardFragment.get_binding();
                            cardView = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.cvTimetable : null;
                            if (cardView != null) {
                                cardView.setVisibility(0);
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        fragmentDashboardBinding = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding == null || (attendanceCv = fragmentDashboardBinding.attendanceCv) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(attendanceCv, "attendanceCv");
                        ToastExtKt.showErrorToast(attendanceCv, "Some Error Occured.Try again later!!");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenPoSurveyStatus() {
        getDashboardViewModel().getPoSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends POSurveyPending>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenPoSurveyStatus$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends POSurveyPending> resource) {
                invoke2((Resource<POSurveyPending>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<POSurveyPending> resource) {
                FragmentDashboardBinding fragmentDashboardBinding;
                CardView attendanceCv;
                SharedPrefManager preference;
                DashboardViewModel dashboardViewModel;
                SharedPrefManager preference2;
                FragmentDashboardBinding fragmentDashboardBinding2;
                FragmentDashboardBinding fragmentDashboardBinding3;
                FragmentDashboardBinding fragmentDashboardBinding4;
                FragmentDashboardBinding fragmentDashboardBinding5;
                FragmentDashboardBinding fragmentDashboardBinding6;
                CardView cardView;
                FragmentDashboardBinding fragmentDashboardBinding7;
                FragmentDashboardBinding fragmentDashboardBinding8;
                FragmentDashboardBinding fragmentDashboardBinding9;
                FragmentDashboardBinding fragmentDashboardBinding10;
                FragmentDashboardBinding fragmentDashboardBinding11;
                FragmentDashboardBinding fragmentDashboardBinding12;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        DashboardFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        DashboardFragment.this.hideProgress();
                        DashboardFragment.this.showBaseView();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    DashboardFragment.this.hideProgress();
                    DashboardFragment.this.showBaseView();
                    fragmentDashboardBinding12 = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding12 == null || (recyclerView = fragmentDashboardBinding12.rvDash) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                DashboardFragment.this.hideProgress();
                POSurveyPending data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    try {
                        if (data.getPosurvey_status()) {
                            fragmentDashboardBinding7 = dashboardFragment.get_binding();
                            CardView cardView2 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.cvDash : null;
                            if (cardView2 != null) {
                                cardView2.setVisibility(8);
                            }
                            fragmentDashboardBinding8 = dashboardFragment.get_binding();
                            CardView cardView3 = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.attendanceCv : null;
                            if (cardView3 != null) {
                                cardView3.setVisibility(8);
                            }
                            fragmentDashboardBinding9 = dashboardFragment.get_binding();
                            CardView cardView4 = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.noticeCv : null;
                            if (cardView4 != null) {
                                cardView4.setVisibility(8);
                            }
                            fragmentDashboardBinding10 = dashboardFragment.get_binding();
                            CardView cardView5 = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.cvVisionMission : null;
                            if (cardView5 != null) {
                                cardView5.setVisibility(8);
                            }
                            fragmentDashboardBinding11 = dashboardFragment.get_binding();
                            cardView = fragmentDashboardBinding11 != null ? fragmentDashboardBinding11.cvTimetable : null;
                            if (cardView != null) {
                                cardView.setVisibility(8);
                            }
                            dashboardFragment.showPendingDialog("Please complete the pending PO Survey to access dashboard");
                        } else {
                            preference = dashboardFragment.getPreference();
                            if (!StringsKt.contains$default((CharSequence) preference.getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null)) {
                                preference2 = dashboardFragment.getPreference();
                                if (!StringsKt.contains$default((CharSequence) preference2.getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                                    fragmentDashboardBinding2 = dashboardFragment.get_binding();
                                    CardView cardView6 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.cvDash : null;
                                    if (cardView6 != null) {
                                        cardView6.setVisibility(0);
                                    }
                                    fragmentDashboardBinding3 = dashboardFragment.get_binding();
                                    CardView cardView7 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.attendanceCv : null;
                                    if (cardView7 != null) {
                                        cardView7.setVisibility(0);
                                    }
                                    fragmentDashboardBinding4 = dashboardFragment.get_binding();
                                    CardView cardView8 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.noticeCv : null;
                                    if (cardView8 != null) {
                                        cardView8.setVisibility(0);
                                    }
                                    fragmentDashboardBinding5 = dashboardFragment.get_binding();
                                    CardView cardView9 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvVisionMission : null;
                                    if (cardView9 != null) {
                                        cardView9.setVisibility(0);
                                    }
                                    fragmentDashboardBinding6 = dashboardFragment.get_binding();
                                    cardView = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.cvTimetable : null;
                                    if (cardView != null) {
                                        cardView.setVisibility(0);
                                    }
                                }
                            }
                            dashboardViewModel = dashboardFragment.getDashboardViewModel();
                            dashboardViewModel.getCourseSurveyStatus();
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        fragmentDashboardBinding = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding == null || (attendanceCv = fragmentDashboardBinding.attendanceCv) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(attendanceCv, "attendanceCv");
                        ToastExtKt.showErrorToast(attendanceCv, "Some Error Occured.Try again later!!");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenSurveyStatus() {
        getDashboardViewModel().getPendingSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SurveyPending>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyStatus$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SurveyPending> resource) {
                invoke2((Resource<SurveyPending>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:100:0x0162, code lost:
            
                if (r8 == null) goto L111;
             */
            /* JADX WARN: Code restructure failed: missing block: B:101:0x0164, code lost:
            
                r8 = r8.attendanceCv;
             */
            /* JADX WARN: Code restructure failed: missing block: B:102:0x0168, code lost:
            
                if (r8 != null) goto L114;
             */
            /* JADX WARN: Code restructure failed: missing block: B:103:0x016b, code lost:
            
                r8.setVisibility(8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x016e, code lost:
            
                r8 = r0.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:105:0x0172, code lost:
            
                if (r8 == null) goto L118;
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x0174, code lost:
            
                r8 = r8.noticeCv;
             */
            /* JADX WARN: Code restructure failed: missing block: B:107:0x0178, code lost:
            
                if (r8 != null) goto L121;
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x017b, code lost:
            
                r8.setVisibility(8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:109:0x017e, code lost:
            
                r8 = r0.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:110:0x0182, code lost:
            
                if (r8 == null) goto L125;
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x0184, code lost:
            
                r8 = r8.cvVisionMission;
             */
            /* JADX WARN: Code restructure failed: missing block: B:112:0x0188, code lost:
            
                if (r8 != null) goto L128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:113:0x018b, code lost:
            
                r8.setVisibility(8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x018e, code lost:
            
                r8 = r0.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x0192, code lost:
            
                if (r8 == null) goto L132;
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0194, code lost:
            
                r4 = r8.cvTimetable;
             */
            /* JADX WARN: Code restructure failed: missing block: B:117:0x0196, code lost:
            
                if (r4 != null) goto L134;
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x0199, code lost:
            
                r4.setVisibility(8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x019c, code lost:
            
                r0.showPendingDialog("Please complete the Profile to access dashboard");
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x0187, code lost:
            
                r8 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x0177, code lost:
            
                r8 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:123:0x0167, code lost:
            
                r8 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0157, code lost:
            
                r8 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x014c, code lost:
            
                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8.getBaseUrl(), (java.lang.CharSequence) "demo", false, 2, (java.lang.Object) null) != false) goto L101;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x0132, code lost:
            
                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1.getBaseUrl(), (java.lang.CharSequence) "mvjce", false, 2, (java.lang.Object) null) == false) goto L97;
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x014e, code lost:
            
                r8 = r0.get_binding();
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x0152, code lost:
            
                if (r8 == null) goto L104;
             */
            /* JADX WARN: Code restructure failed: missing block: B:96:0x0154, code lost:
            
                r8 = r8.cvDash;
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x0158, code lost:
            
                if (r8 != null) goto L107;
             */
            /* JADX WARN: Code restructure failed: missing block: B:98:0x015b, code lost:
            
                r8.setVisibility(8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:99:0x015e, code lost:
            
                r8 = r0.get_binding();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.main.SurveyPending> r8) {
                /*
                    Method dump skipped, instructions count: 426
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyStatus$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    private final void listenResponse() {
        getDashboardViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DashboardFragment.listenResponse$lambda$15(DashboardFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$15(DashboardFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
        CircleProgressView circleProgressView;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
        }
        this$0.hideProgress();
        DashResponse dashResponse = (DashResponse) resource.getData();
        if (dashResponse != null) {
            try {
                this$0.getDashboardViewModel().storeUpdateResponse(dashResponse.getBatchId(), dashResponse.getSemId(), dashResponse.getCurnt_sem(), dashResponse.getHostelStatus(), dashResponse.getHostel(), dashResponse.getCourse(), dashResponse.getUrl(), dashResponse.getLogout_status());
                this$0.getPreference().setSurveyStatus(dashResponse.getSurveyStatus());
                this$0.getPreference().setVersionCode(String.valueOf(dashResponse.getVersionCode()));
                if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeEngnr());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "sctce", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeSctce());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "aisat", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeAisat());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cep", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCep());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cetkr", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCetkr());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "coet", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCoet());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "cev", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCev());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "gcekkd", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGcekkd());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGcek());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "gcei", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGcei());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "gecskp", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGecskp());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "gectr", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGectcr());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "gecwyd", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGecwyd());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "jecc", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeJecc());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "kmeacoa", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeKmeacoa());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeKmea());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeMace());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "marian", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeMarian());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mdit", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeMdit());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "nssce", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeNssce());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeSjcetPalai());
                } else if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeTkmce());
                } else {
                    this$0.forceupdate(dashResponse.getVersionCode());
                }
                if (this$0.getPreference().getUserImg().length() > 0) {
                    RequestCreator centerCrop = Picasso.get().load(this$0.getPreference().getUserImg()).placeholder(R.drawable.ic_user_profile).error(R.drawable.ic_user_profile).resize(90, 90).centerCrop();
                    FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
                    CircleImageView circleImageView = fragmentDashboardBinding != null ? fragmentDashboardBinding.userIcon : null;
                    Intrinsics.checkNotNull(circleImageView);
                    centerCrop.into(circleImageView);
                }
                int size = dashResponse.getNotices().size();
                try {
                    String lowerCase = dashResponse.getNotices().get(0).getContent().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase, "no new notice available right now")) {
                        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
                        TextView textView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.noticeText : null;
                        if (textView2 != null) {
                            textView2.setSelected(true);
                        }
                        String obj = Html.fromHtml(dashResponse.getNotices().get(0).getContent()).toString();
                        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
                        textView = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noticeText : null;
                        if (textView != null) {
                            textView.setText("       " + obj);
                        }
                        this$0.getPreference().setNoticeOne(obj);
                    } else if (size == 1) {
                        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
                        TextView textView3 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.noticeText : null;
                        if (textView3 != null) {
                            textView3.setSelected(true);
                        }
                        this$0.noticeTv2 = dashResponse.getNotices().get(0).getContent();
                        String obj2 = Html.fromHtml(dashResponse.getNotices().get(0).getContent()).toString();
                        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
                        textView = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.noticeText : null;
                        if (textView != null) {
                            textView.setText(obj2);
                        }
                        this$0.getPreference().setNoticeOne(obj2);
                    } else if (size == 2) {
                        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
                        TextView textView4 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.noticeText : null;
                        if (textView4 != null) {
                            textView4.setSelected(true);
                        }
                        String obj3 = Html.fromHtml(dashResponse.getNotices().get(0).getContent()).toString();
                        String obj4 = Html.fromHtml(dashResponse.getNotices().get(1).getContent()).toString();
                        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
                        textView = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.noticeText : null;
                        if (textView != null) {
                            textView.setText("                 " + obj3 + "              " + obj4 + "      ");
                        }
                        this$0.getPreference().setNoticeOne(obj3);
                        this$0.getPreference().setNoticeTwo(obj4);
                    } else {
                        int i2 = size - 1;
                        if (!Intrinsics.areEqual(dashResponse.getNotices().get(i2).getContent(), "")) {
                            int i3 = size - 2;
                            if (!Intrinsics.areEqual(dashResponse.getNotices().get(i3).getContent(), "")) {
                                int i4 = size - 3;
                                if (!Intrinsics.areEqual(dashResponse.getNotices().get(i4).getContent(), "")) {
                                    FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
                                    TextView textView5 = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.noticeText : null;
                                    if (textView5 != null) {
                                        textView5.setSelected(true);
                                    }
                                    String obj5 = Html.fromHtml(dashResponse.getNotices().get(i2).getContent()).toString();
                                    String obj6 = Html.fromHtml(dashResponse.getNotices().get(i3).getContent()).toString();
                                    String obj7 = Html.fromHtml(dashResponse.getNotices().get(i4).getContent()).toString();
                                    FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
                                    textView = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.noticeText : null;
                                    if (textView != null) {
                                        textView.setText("       " + obj5 + "                  " + obj6 + "                    " + obj7 + "        ");
                                    }
                                    this$0.getPreference().setNoticeOne(obj5);
                                    this$0.getPreference().setNoticeTwo(obj6);
                                    this$0.getPreference().setNoticeThree(obj7);
                                }
                            }
                        }
                        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
                        textView = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.noticeText : null;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                    }
                } catch (NullPointerException unused) {
                }
                this$0.getPreference().setFeeStatus(dashResponse.getFeeStatus());
                this$0.getPreference().setDueNew(dashResponse.getDueNew());
                this$0.getPreference().setFeeEngnrNew(dashResponse.getFeeEngnrStatus());
                if (!Intrinsics.areEqual(dashResponse.getAttendance_forthesem(), "N/A")) {
                    FragmentDashboardBinding fragmentDashboardBinding11 = this$0.get_binding();
                    if (fragmentDashboardBinding11 != null && (circleProgressView = fragmentDashboardBinding11.dashAttendanceForSem) != null) {
                        circleProgressView.setValueAnimated(Float.parseFloat(dashResponse.getAttendance_forthesem()));
                    }
                    this$0.getPreference().setAttendancePercentage(dashResponse.getAttendance_forthesem());
                }
                this$0.liveTvLink = dashResponse.getLiveTvLink();
                this$0.liveTvType = dashResponse.getLiveTvType();
                if (dashResponse.getPasswordChanged() && (mainCallBackListener = this$0.listener) != null) {
                    mainCallBackListener.makeLogout();
                }
            } catch (Exception unused2) {
            }
            if (357 < dashResponse.getCurrentVersion()) {
                this$0.showUpdateDialog();
                return;
            }
            try {
                if (dashResponse.getInfoMsg().length() <= 0) {
                    z = false;
                }
                if (z) {
                    this$0.showInfoDialog(dashResponse.getInfoMsg());
                }
            } catch (NullPointerException unused3) {
            }
        }
    }

    private final void showInfoDialog(String infoMsg) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            View inflate = getLayoutInflater().inflate(R.layout.info_layout, (ViewGroup) null);
            builder.setView(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.info_dialog);
            builder.setTitle("INFO");
            textView.setText(infoMsg);
            builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) null);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.show();
        } catch (Exception unused) {
        }
    }

    private final void showUpdateDialog() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setMessage(getString(R.string.update_msg));
            builder.setPositiveButton("Update", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DashboardFragment.showUpdateDialog$lambda$16(DashboardFragment.this, dialogInterface, i);
                }
            });
            builder.setCancelable(false);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUpdateDialog$lambda$16(DashboardFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotToPlaystore();
    }

    private final void gotToPlaystore() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + requireActivity().getPackageName())));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + requireActivity().getPackageName())));
        }
    }

    @Override // in.etuwa.app.ui.dashboard.DashboardAdapter.CallBack
    public void onDashItemClicked(int position) {
        if (Intrinsics.areEqual(getPreference().getUserType(), ExifInterface.GPS_MEASUREMENT_2D)) {
            MainCallBackListener mainCallBackListener = this.listener;
            if (mainCallBackListener != null) {
                mainCallBackListener.onDashboardParent(position);
                return;
            }
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener2 = this.listener;
            if (mainCallBackListener2 != null) {
                mainCallBackListener2.onTkmDashboardItemClick(position);
                return;
            }
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sbce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sahrdaya", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "uat", false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener3 = this.listener;
            if (mainCallBackListener3 != null) {
                mainCallBackListener3.onExamDashboardItemClick(position);
                return;
            }
            return;
        }
        MainCallBackListener mainCallBackListener4 = this.listener;
        if (mainCallBackListener4 != null) {
            mainCallBackListener4.onDashboardItemClick(position);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // in.etuwa.app.ui.timetable.TimetableListener
    public void loadPage() {
        WrapContentViewPager wrapContentViewPager;
        WrapContentViewPager wrapContentViewPager2;
        WrapContentViewPager wrapContentViewPager3;
        WrapContentViewPager wrapContentViewPager4;
        WrapContentViewPager wrapContentViewPager5;
        WrapContentViewPager wrapContentViewPager6;
        WrapContentViewPager wrapContentViewPager7;
        WrapContentViewPager wrapContentViewPager8;
        WrapContentViewPager wrapContentViewPager9;
        WrapContentViewPager wrapContentViewPager10;
        WrapContentViewPager wrapContentViewPager11;
        WrapContentViewPager wrapContentViewPager12;
        WrapContentViewPager wrapContentViewPager13;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
        if (getPreference().getClgId() != 15 && getPreference().getClgId() != 5 && getPreference().getClgId() != 2) {
            String format = simpleDateFormat.format(Calendar.getInstance().getTime());
            if (format != null) {
                switch (format.hashCode()) {
                    case 70909:
                        if (format.equals("Fri")) {
                            FragmentDashboardBinding fragmentDashboardBinding = get_binding();
                            if (fragmentDashboardBinding == null || (wrapContentViewPager9 = fragmentDashboardBinding.dashTimeTablePager) == null) {
                                return;
                            }
                            wrapContentViewPager9.setCurrentItem(4, true);
                            return;
                        }
                        break;
                    case 77548:
                        if (format.equals("Mon")) {
                            FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
                            if (fragmentDashboardBinding2 == null || (wrapContentViewPager10 = fragmentDashboardBinding2.dashTimeTablePager) == null) {
                                return;
                            }
                            wrapContentViewPager10.setCurrentItem(0, true);
                            return;
                        }
                        break;
                    case 84065:
                        if (format.equals("Thu")) {
                            FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
                            if (fragmentDashboardBinding3 == null || (wrapContentViewPager11 = fragmentDashboardBinding3.dashTimeTablePager) == null) {
                                return;
                            }
                            wrapContentViewPager11.setCurrentItem(3, true);
                            return;
                        }
                        break;
                    case 84452:
                        if (format.equals("Tue")) {
                            FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
                            if (fragmentDashboardBinding4 == null || (wrapContentViewPager12 = fragmentDashboardBinding4.dashTimeTablePager) == null) {
                                return;
                            }
                            wrapContentViewPager12.setCurrentItem(1, true);
                            return;
                        }
                        break;
                    case 86838:
                        if (format.equals("Wed")) {
                            FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
                            if (fragmentDashboardBinding5 == null || (wrapContentViewPager13 = fragmentDashboardBinding5.dashTimeTablePager) == null) {
                                return;
                            }
                            wrapContentViewPager13.setCurrentItem(2, true);
                            return;
                        }
                        break;
                }
            }
            FragmentDashboardBinding fragmentDashboardBinding6 = get_binding();
            if (fragmentDashboardBinding6 == null || (wrapContentViewPager8 = fragmentDashboardBinding6.dashTimeTablePager) == null) {
                return;
            }
            wrapContentViewPager8.setCurrentItem(0, true);
            return;
        }
        String format2 = simpleDateFormat.format(Calendar.getInstance().getTime());
        if (format2 != null) {
            switch (format2.hashCode()) {
                case 70909:
                    if (format2.equals("Fri")) {
                        FragmentDashboardBinding fragmentDashboardBinding7 = get_binding();
                        if (fragmentDashboardBinding7 == null || (wrapContentViewPager2 = fragmentDashboardBinding7.dashTimeTablePager) == null) {
                            return;
                        }
                        wrapContentViewPager2.setCurrentItem(4, true);
                        return;
                    }
                    break;
                case 77548:
                    if (format2.equals("Mon")) {
                        FragmentDashboardBinding fragmentDashboardBinding8 = get_binding();
                        if (fragmentDashboardBinding8 == null || (wrapContentViewPager3 = fragmentDashboardBinding8.dashTimeTablePager) == null) {
                            return;
                        }
                        wrapContentViewPager3.setCurrentItem(0, true);
                        return;
                    }
                    break;
                case 82886:
                    if (format2.equals("Sat")) {
                        FragmentDashboardBinding fragmentDashboardBinding9 = get_binding();
                        if (fragmentDashboardBinding9 == null || (wrapContentViewPager4 = fragmentDashboardBinding9.dashTimeTablePager) == null) {
                            return;
                        }
                        wrapContentViewPager4.setCurrentItem(5, true);
                        return;
                    }
                    break;
                case 84065:
                    if (format2.equals("Thu")) {
                        FragmentDashboardBinding fragmentDashboardBinding10 = get_binding();
                        if (fragmentDashboardBinding10 == null || (wrapContentViewPager5 = fragmentDashboardBinding10.dashTimeTablePager) == null) {
                            return;
                        }
                        wrapContentViewPager5.setCurrentItem(3, true);
                        return;
                    }
                    break;
                case 84452:
                    if (format2.equals("Tue")) {
                        FragmentDashboardBinding fragmentDashboardBinding11 = get_binding();
                        if (fragmentDashboardBinding11 == null || (wrapContentViewPager6 = fragmentDashboardBinding11.dashTimeTablePager) == null) {
                            return;
                        }
                        wrapContentViewPager6.setCurrentItem(1, true);
                        return;
                    }
                    break;
                case 86838:
                    if (format2.equals("Wed")) {
                        FragmentDashboardBinding fragmentDashboardBinding12 = get_binding();
                        if (fragmentDashboardBinding12 == null || (wrapContentViewPager7 = fragmentDashboardBinding12.dashTimeTablePager) == null) {
                            return;
                        }
                        wrapContentViewPager7.setCurrentItem(2, true);
                        return;
                    }
                    break;
            }
        }
        FragmentDashboardBinding fragmentDashboardBinding13 = get_binding();
        if (fragmentDashboardBinding13 == null || (wrapContentViewPager = fragmentDashboardBinding13.dashTimeTablePager) == null) {
            return;
        }
        wrapContentViewPager.setCurrentItem(0, true);
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

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
        getAdapter().setCallBack(null);
        getTableAdapter().setCallBack(null);
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        CardView cardView = fragmentDashboardBinding != null ? fragmentDashboardBinding.cvDash : null;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        CardView cardView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.attendanceCv : null;
        if (cardView2 != null) {
            cardView2.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        CardView cardView3 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noticeCv : null;
        if (cardView3 != null) {
            cardView3.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
        CardView cardView4 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.cvVisionMission : null;
        if (cardView4 != null) {
            cardView4.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
        CardView cardView5 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.cvTimetable : null;
        if (cardView5 == null) {
            return;
        }
        cardView5.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void listenUrlResponse() {
        getDashboardViewModel().getLibraryResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends LibraryResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenUrlResponse$1

            /* compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends LibraryResponse> resource) {
                invoke2((Resource<LibraryResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
            
                r0 = r0.listener;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.dash.LibraryResponse> r4) {
                /*
                    r3 = this;
                    in.etuwa.app.utils.Status r0 = r4.getStatus()
                    int[] r1 = in.etuwa.app.ui.dashboard.DashboardFragment$listenUrlResponse$1.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto L35
                    r4 = 2
                    if (r0 == r4) goto L2f
                    r4 = 3
                    if (r0 == r4) goto L24
                    r4 = 4
                    if (r0 == r4) goto L19
                    goto L69
                L19:
                    in.etuwa.app.ui.dashboard.DashboardFragment r4 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.dashboard.DashboardFragment r4 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r4.showBaseView()
                    goto L69
                L24:
                    in.etuwa.app.ui.dashboard.DashboardFragment r4 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.dashboard.DashboardFragment r4 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r4.showBaseView()
                    goto L69
                L2f:
                    in.etuwa.app.ui.dashboard.DashboardFragment r4 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r4.showProgress()
                    goto L69
                L35:
                    in.etuwa.app.ui.dashboard.DashboardFragment r0 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r0.hideProgress()
                    java.lang.Object r4 = r4.getData()
                    in.etuwa.app.data.model.dash.LibraryResponse r4 = (in.etuwa.app.data.model.dash.LibraryResponse) r4
                    if (r4 == 0) goto L69
                    in.etuwa.app.ui.dashboard.DashboardFragment r0 = in.etuwa.app.ui.dashboard.DashboardFragment.this
                    r0.showBaseView()
                    java.lang.String r1 = r4.getUrl()
                    java.io.PrintStream r2 = java.lang.System.out
                    r2.println(r1)
                    java.lang.String r1 = r4.getUrl()
                    java.lang.String r2 = ""
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    if (r1 != 0) goto L69
                    in.etuwa.app.helper.MainCallBackListener r0 = in.etuwa.app.ui.dashboard.DashboardFragment.access$getListener$p(r0)
                    if (r0 == 0) goto L69
                    java.lang.String r4 = r4.getUrl()
                    r0.openPaymentPage(r4)
                L69:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardFragment$listenUrlResponse$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    private final void listenResponse2() {
        getDashboardViewModel().getResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DashboardFragment.listenResponse2$lambda$18(DashboardFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse2$lambda$18(DashboardFragment this$0, Resource resource) {
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
            } else {
                if (i != 4) {
                    return;
                }
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
        }
        this$0.hideProgress();
        NoticeResponse noticeResponse = (NoticeResponse) resource.getData();
        if (noticeResponse != null) {
            this$0.showBaseView();
            if (noticeResponse.getLogin()) {
                try {
                    int size = noticeResponse.getNotice().size();
                    if (size != 0) {
                        this$0.noticeTV = noticeResponse.getNotice().get(size - 1).getContent();
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    System.out.println((Object) "");
                }
            }
        }
    }

    @Override // in.etuwa.app.ui.dashboard.maintenance.MaintenanceDialog.StoreListener
    public void dismissView() {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.dismissView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPendingDialog(final String message) {
        if (this.i == 0) {
            this.i = 1;
            final Dialog dialog = new Dialog(requireContext());
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.custom_alert_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            dialog.setCancelable(false);
            TextView textView = (TextView) inflate.findViewById(R.id.tvMessage);
            Button button = (Button) inflate.findViewById(R.id.btnOk);
            textView.setText(message);
            button.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.showPendingDialog$lambda$19(dialog, message, this, view);
                }
            });
            dialog.show();
            return;
        }
        System.out.println((Object) "lol");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPendingDialog$lambda$19(Dialog dialog, String message, DashboardFragment this$0, View view) {
        MainCallBackListener mainCallBackListener;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(message, "$message");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        String lowerCase = message.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "po", false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener2 = this$0.listener;
            if (mainCallBackListener2 != null) {
                mainCallBackListener2.forceOpenPoSurvey();
                return;
            }
            return;
        }
        String lowerCase2 = message.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "course", false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener3 = this$0.listener;
            if (mainCallBackListener3 != null) {
                mainCallBackListener3.openCourseSurvey();
                return;
            }
            return;
        }
        String lowerCase3 = message.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "survey", false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener4 = this$0.listener;
            if (mainCallBackListener4 != null) {
                mainCallBackListener4.openForceToDoSurvey();
                return;
            }
            return;
        }
        String lowerCase4 = message.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) Scopes.PROFILE, false, 2, (Object) null)) {
            MainCallBackListener mainCallBackListener5 = this$0.listener;
            if (mainCallBackListener5 != null) {
                mainCallBackListener5.forceOpenProfile();
                return;
            }
            return;
        }
        String lowerCase5 = message.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
        if (!StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "sem", false, 2, (Object) null) || (mainCallBackListener = this$0.listener) == null) {
            return;
        }
        mainCallBackListener.openForceSemReg();
    }
}