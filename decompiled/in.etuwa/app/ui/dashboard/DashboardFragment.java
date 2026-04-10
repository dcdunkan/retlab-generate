package in.etuwa.app.ui.dashboard;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.common.reflect.TypeToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.Gson;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.calendar.AttendanceDetails;
import in.etuwa.app.data.model.calendar.Birthday;
import in.etuwa.app.data.model.calendar.CalendarResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.dash.LibraryResponse;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.model.dash.PendingSurvey;
import in.etuwa.app.data.model.main.CourseSurveyPending;
import in.etuwa.app.data.model.main.POSurveyPending;
import in.etuwa.app.data.model.main.SurveyMandatory;
import in.etuwa.app.data.model.main.SurveyPending;
import in.etuwa.app.data.model.noticeboard.Notice;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.result.univ.UnivTotalResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentDashboardBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.helper.ValidChecker$$ExternalSyntheticApiModelOutline0;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.dashboard.DashBoardFiveAdapter;
import in.etuwa.app.ui.dashboard.DashBoardFourAdapter;
import in.etuwa.app.ui.dashboard.DashBoardSixAdapter;
import in.etuwa.app.ui.dashboard.DashBoardThreeAdapter;
import in.etuwa.app.ui.dashboard.DashBoardTwoAdapter;
import in.etuwa.app.ui.dashboard.DashBoardViewAllAdapter;
import in.etuwa.app.ui.dashboard.DashboardAdapter;
import in.etuwa.app.ui.dashboard.DashboardCalendarAdapter;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.dashboard.DashboardOneAdapter;
import in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog;
import in.etuwa.app.ui.dashboard.dashtable.BoundaryAwareViewPager;
import in.etuwa.app.ui.dashboard.dashtable.DashTimeTableAdapter;
import in.etuwa.app.ui.dashboard.dashtable.TimeTableMonthlyNewResponse;
import in.etuwa.app.ui.dashboard.dashtable.TimeTableNewResponse;
import in.etuwa.app.ui.dashboard.dashtable.TimetableDatePickerAdapter;
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
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.cleverpumpkin.calendar.adapter.CalendarAdapter;

/* JADX INFO: compiled from: DashboardFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashboardFragment extends BaseFragment implements DashboardAdapter.CallBack, TimetableListener, ChangeProPicDialog.ProfileCallBack, StoreDialog.StoreListener, VisionDialog.StoreListener, MissionDialog.StoreListener, MaintenanceDialog.StoreListener, DashboardOneAdapter.CallBack, DashBoardTwoAdapter.CallBack, DashBoardThreeAdapter.CallBack, DashBoardFourAdapter.CallBack, DashBoardFiveAdapter.CallBack, DashBoardSixAdapter.CallBack, DashboardCalendarAdapter.DayClickListener, DashBoardViewAllAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int SWIPE_THRESHOLD;
    private FragmentDashboardBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapterCalendar$delegate, reason: from kotlin metadata */
    private final Lazy adapterCalendar;

    /* JADX INFO: renamed from: adapterDashAcademics$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashAcademics;

    /* JADX INFO: renamed from: adapterDashAll$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashAll;

    /* JADX INFO: renamed from: adapterDashFees$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashFees;

    /* JADX INFO: renamed from: adapterDashInfo$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashInfo;

    /* JADX INFO: renamed from: adapterDashOffice$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashOffice;

    /* JADX INFO: renamed from: adapterDashOne$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashOne;

    /* JADX INFO: renamed from: adapterDashPlacement$delegate, reason: from kotlin metadata */
    private final Lazy adapterDashPlacement;
    private final List<String> categories;
    private LocalDate currentDate;
    private String currentMonth;
    private int currentTabIndex;
    private String currentYear;

    /* JADX INFO: renamed from: dashboardViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dashboardViewModel;
    private String date;
    private BottomSheetDialog forceUpdateDialog;
    private GestureDetector gestureDetector;
    private int i;
    private Boolean isEngnr;
    private Boolean isExam;
    private boolean isLoadingWeek;
    private MainCallBackListener listener;
    private String liveTvLink;
    private String liveTvType;
    private String mainView;
    private final DateTimeFormatter monthFormatter;
    private int navigationDirection;
    private String noticeTV;
    private String noticeTv2;
    private String pendingScrollToDate;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private List<String> selected;
    private float startX;
    private float startY;
    private String subView;
    private DashTimeTableAdapter tableAdapter;
    private List<? extends TextView> tabs;
    private ArrayList<String> title;

    /* JADX INFO: compiled from: DashboardFragment.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showUpdateDialog$lambda$31(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showUpdateDialog2$lambda$28(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
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

    @Override // in.etuwa.app.ui.timetable.TimetableListener
    public void loadPage() {
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
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$sharedViewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentActivity invoke() {
                FragmentActivity fragmentActivityRequireActivity = dashboardFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                return fragmentActivityRequireActivity;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(dashboardFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.dashboardViewModel = FragmentViewModelLazyKt.createViewModelLazy(dashboardFragment, Reflection.getOrCreateKotlinClass(DashboardViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$sharedViewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$sharedViewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(DashboardViewModel.class), qualifier, b, null, koinScope);
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
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterDashOne = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<DashboardOneAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashboardOneAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashboardOneAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashboardOneAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterDashAll = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<DashBoardViewAllAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashBoardViewAllAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashBoardViewAllAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashBoardViewAllAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterDashAcademics = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<DashBoardTwoAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashBoardTwoAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashBoardTwoAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashBoardTwoAdapter.class), b8, b9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        final byte b11 = 0 == true ? 1 : 0;
        this.adapterDashFees = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<DashBoardThreeAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashBoardThreeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashBoardThreeAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashBoardThreeAdapter.class), b10, b11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        final byte b13 = 0 == true ? 1 : 0;
        this.adapterDashInfo = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<DashBoardFourAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashBoardFourAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashBoardFourAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashBoardFourAdapter.class), b12, b13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode7 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b14 = 0 == true ? 1 : 0;
        final byte b15 = 0 == true ? 1 : 0;
        this.adapterDashOffice = LazyKt.lazy(lazyThreadSafetyMode7, (Function0) new Function0<DashBoardFiveAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashBoardFiveAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashBoardFiveAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashBoardFiveAdapter.class), b14, b15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode8 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b16 = 0 == true ? 1 : 0;
        final byte b17 = 0 == true ? 1 : 0;
        this.adapterDashPlacement = LazyKt.lazy(lazyThreadSafetyMode8, (Function0) new Function0<DashBoardSixAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashBoardSixAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashBoardSixAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashBoardSixAdapter.class), b16, b17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode9 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b18 = 0 == true ? 1 : 0;
        final byte b19 = 0 == true ? 1 : 0;
        this.adapterCalendar = LazyKt.lazy(lazyThreadSafetyMode9, (Function0) new Function0<DashboardCalendarAdapter>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.DashboardCalendarAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DashboardCalendarAdapter invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DashboardCalendarAdapter.class), b18, b19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode10 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b20 = 0 == true ? 1 : 0;
        final byte b21 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode10, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = dashboardFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b20, b21);
            }
        });
        this.SWIPE_THRESHOLD = 100;
        this.categories = CollectionsKt.listOf((Object[]) new String[]{"Academics", "Fees", "Information", "Office", "Placement"});
        this.noticeTV = "";
        this.noticeTv2 = "";
        this.date = "";
        this.selected = new ArrayList();
        this.title = new ArrayList<>();
        this.liveTvLink = "";
        this.liveTvType = "";
        this.mainView = "one";
        this.subView = "one";
        this.monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DashboardViewModel getDashboardViewModel() {
        return (DashboardViewModel) this.dashboardViewModel.getValue();
    }

    private final DashboardAdapter getAdapter() {
        return (DashboardAdapter) this.adapter.getValue();
    }

    private final DashboardOneAdapter getAdapterDashOne() {
        return (DashboardOneAdapter) this.adapterDashOne.getValue();
    }

    private final DashBoardViewAllAdapter getAdapterDashAll() {
        return (DashBoardViewAllAdapter) this.adapterDashAll.getValue();
    }

    private final DashBoardTwoAdapter getAdapterDashAcademics() {
        return (DashBoardTwoAdapter) this.adapterDashAcademics.getValue();
    }

    private final DashBoardThreeAdapter getAdapterDashFees() {
        return (DashBoardThreeAdapter) this.adapterDashFees.getValue();
    }

    private final DashBoardFourAdapter getAdapterDashInfo() {
        return (DashBoardFourAdapter) this.adapterDashInfo.getValue();
    }

    private final DashBoardFiveAdapter getAdapterDashOffice() {
        return (DashBoardFiveAdapter) this.adapterDashOffice.getValue();
    }

    private final DashBoardSixAdapter getAdapterDashPlacement() {
        return (DashBoardSixAdapter) this.adapterDashPlacement.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DashboardCalendarAdapter getAdapterCalendar() {
        return (DashboardCalendarAdapter) this.adapterCalendar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final ArrayList<String> getTitle() {
        return this.title;
    }

    public final void setTitle(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.title = arrayList;
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

    private final void updateMonthTitle() {
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        LocalDate localDate = null;
        TextView textView = fragmentDashboardBinding != null ? fragmentDashboardBinding.monthTv : null;
        if (textView == null) {
            return;
        }
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        } else {
            localDate = localDate2;
        }
        textView.setText(localDate.format(this.monthFormatter));
    }

    /* JADX INFO: compiled from: DashboardFragment.kt */
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
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ActionBar supportActionBar;
        super.onResume();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.hide();
        }
        if (Intrinsics.areEqual(this.mainView, "one")) {
            FragmentDashboardBinding fragmentDashboardBinding = get_binding();
            RecyclerView recyclerView = fragmentDashboardBinding != null ? fragmentDashboardBinding.rvDashOne : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
            LinearLayout linearLayout = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.rvDashTwo : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
            RecyclerView recyclerView2 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.rvDashAll : null;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
            HorizontalScrollView horizontalScrollView = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.hrView : null;
            if (horizontalScrollView != null) {
                horizontalScrollView.setVisibility(0);
            }
            FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
            if (fragmentDashboardBinding5 != null && (imageView10 = fragmentDashboardBinding5.viewOneBtn) != null) {
                imageView10.setBackgroundResource(R.drawable.round_white_backgroundd);
            }
            FragmentDashboardBinding fragmentDashboardBinding6 = get_binding();
            if (fragmentDashboardBinding6 != null && (imageView9 = fragmentDashboardBinding6.viewTwoBtn) != null) {
                imageView9.setBackgroundResource(R.color.transparent);
            }
            FragmentDashboardBinding fragmentDashboardBinding7 = get_binding();
            if (fragmentDashboardBinding7 != null && (imageView8 = fragmentDashboardBinding7.viewThreeBtn) != null) {
                imageView8.setBackgroundResource(R.color.transparent);
            }
            FragmentDashboardBinding fragmentDashboardBinding8 = get_binding();
            ImageView imageView11 = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.viewOneBtn : null;
            if (imageView11 != null) {
                imageView11.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorBlack)));
            }
            FragmentDashboardBinding fragmentDashboardBinding9 = get_binding();
            ImageView imageView12 = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.viewTwoBtn : null;
            if (imageView12 != null) {
                imageView12.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorWhite)));
            }
            FragmentDashboardBinding fragmentDashboardBinding10 = get_binding();
            imageView = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.viewThreeBtn : null;
            if (imageView != null) {
                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorWhite)));
            }
            if (Intrinsics.areEqual(this.subView, "one")) {
                updateDataForTab(0);
            } else if (Intrinsics.areEqual(this.subView, "two")) {
                updateDataForTab(1);
            } else if (Intrinsics.areEqual(this.subView, "three")) {
                updateDataForTab(2);
            } else if (Intrinsics.areEqual(this.subView, "four")) {
                updateDataForTab(3);
            } else if (Intrinsics.areEqual(this.subView, "five")) {
                updateDataForTab(4);
            } else {
                updateDataForTab(0);
            }
        } else if (Intrinsics.areEqual(this.mainView, "two")) {
            FragmentDashboardBinding fragmentDashboardBinding11 = get_binding();
            RecyclerView recyclerView3 = fragmentDashboardBinding11 != null ? fragmentDashboardBinding11.rvDashOne : null;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding12 = get_binding();
            LinearLayout linearLayout2 = fragmentDashboardBinding12 != null ? fragmentDashboardBinding12.rvDashTwo : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentDashboardBinding fragmentDashboardBinding13 = get_binding();
            RecyclerView recyclerView4 = fragmentDashboardBinding13 != null ? fragmentDashboardBinding13.rvDashAll : null;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding14 = get_binding();
            HorizontalScrollView horizontalScrollView2 = fragmentDashboardBinding14 != null ? fragmentDashboardBinding14.hrView : null;
            if (horizontalScrollView2 != null) {
                horizontalScrollView2.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding15 = get_binding();
            if (fragmentDashboardBinding15 != null && (imageView7 = fragmentDashboardBinding15.viewTwoBtn) != null) {
                imageView7.setBackgroundResource(R.drawable.round_white_backgroundd);
            }
            FragmentDashboardBinding fragmentDashboardBinding16 = get_binding();
            if (fragmentDashboardBinding16 != null && (imageView6 = fragmentDashboardBinding16.viewOneBtn) != null) {
                imageView6.setBackgroundResource(R.color.transparent);
            }
            FragmentDashboardBinding fragmentDashboardBinding17 = get_binding();
            if (fragmentDashboardBinding17 != null && (imageView5 = fragmentDashboardBinding17.viewThreeBtn) != null) {
                imageView5.setBackgroundResource(R.color.transparent);
            }
            FragmentDashboardBinding fragmentDashboardBinding18 = get_binding();
            ImageView imageView13 = fragmentDashboardBinding18 != null ? fragmentDashboardBinding18.viewTwoBtn : null;
            if (imageView13 != null) {
                imageView13.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorBlack)));
            }
            FragmentDashboardBinding fragmentDashboardBinding19 = get_binding();
            ImageView imageView14 = fragmentDashboardBinding19 != null ? fragmentDashboardBinding19.viewOneBtn : null;
            if (imageView14 != null) {
                imageView14.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorWhite)));
            }
            FragmentDashboardBinding fragmentDashboardBinding20 = get_binding();
            imageView = fragmentDashboardBinding20 != null ? fragmentDashboardBinding20.viewThreeBtn : null;
            if (imageView != null) {
                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorWhite)));
            }
        } else if (Intrinsics.areEqual(this.mainView, "three")) {
            FragmentDashboardBinding fragmentDashboardBinding21 = get_binding();
            RecyclerView recyclerView5 = fragmentDashboardBinding21 != null ? fragmentDashboardBinding21.rvDashOne : null;
            if (recyclerView5 != null) {
                recyclerView5.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding22 = get_binding();
            LinearLayout linearLayout3 = fragmentDashboardBinding22 != null ? fragmentDashboardBinding22.rvDashTwo : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding23 = get_binding();
            RecyclerView recyclerView6 = fragmentDashboardBinding23 != null ? fragmentDashboardBinding23.rvDashAll : null;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(0);
            }
            FragmentDashboardBinding fragmentDashboardBinding24 = get_binding();
            HorizontalScrollView horizontalScrollView3 = fragmentDashboardBinding24 != null ? fragmentDashboardBinding24.hrView : null;
            if (horizontalScrollView3 != null) {
                horizontalScrollView3.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding25 = get_binding();
            if (fragmentDashboardBinding25 != null && (imageView4 = fragmentDashboardBinding25.viewThreeBtn) != null) {
                imageView4.setBackgroundResource(R.drawable.round_white_backgroundd);
            }
            FragmentDashboardBinding fragmentDashboardBinding26 = get_binding();
            if (fragmentDashboardBinding26 != null && (imageView3 = fragmentDashboardBinding26.viewTwoBtn) != null) {
                imageView3.setBackgroundResource(R.color.transparent);
            }
            FragmentDashboardBinding fragmentDashboardBinding27 = get_binding();
            if (fragmentDashboardBinding27 != null && (imageView2 = fragmentDashboardBinding27.viewOneBtn) != null) {
                imageView2.setBackgroundResource(R.color.transparent);
            }
            FragmentDashboardBinding fragmentDashboardBinding28 = get_binding();
            ImageView imageView15 = fragmentDashboardBinding28 != null ? fragmentDashboardBinding28.viewThreeBtn : null;
            if (imageView15 != null) {
                imageView15.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorBlack)));
            }
            FragmentDashboardBinding fragmentDashboardBinding29 = get_binding();
            ImageView imageView16 = fragmentDashboardBinding29 != null ? fragmentDashboardBinding29.viewTwoBtn : null;
            if (imageView16 != null) {
                imageView16.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorWhite)));
            }
            FragmentDashboardBinding fragmentDashboardBinding30 = get_binding();
            imageView = fragmentDashboardBinding30 != null ? fragmentDashboardBinding30.viewOneBtn : null;
            if (imageView != null) {
                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.colorWhite)));
            }
        }
        Integer intOrNull = StringsKt.toIntOrNull(getPreference().getVersionCode());
        if (intOrNull == null || 405 >= intOrNull.intValue()) {
            return;
        }
        showUpdateDialog2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ActionBar supportActionBar;
        super.onStop();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity == null || (supportActionBar = appCompatActivity.getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ActionBar supportActionBar;
        super.onPause();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity == null || (supportActionBar = appCompatActivity.getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.show();
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
        listenResponse();
        setUp();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x027e  */
    @Override // in.etuwa.app.ui.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setUp() {
        /*
            Method dump skipped, instruction units count: 2616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardFragment.setUp():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showResults();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this$0.showMissionVisionBottomSheet(contextRequireContext, "", "", new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$2$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onLiveClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onNewDashItemClicked("notifications");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalDate localDate = this$0.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        LocalDate localDateMinusMonths = localDate.minusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(localDateMinusMonths, "currentDate.minusMonths(1)");
        this$0.currentDate = localDateMinusMonths;
        this$0.updateMonthTitle();
        this$0.listenEventsResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocalDate localDate = this$0.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        LocalDate localDatePlusMonths = localDate.plusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(localDatePlusMonths, "currentDate.plusMonths(1)");
        this$0.currentDate = localDatePlusMonths;
        this$0.updateMonthTitle();
        this$0.listenEventsResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onAttendanceCardClicked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this$0.showMissionVisionBottomSheet(contextRequireContext, "vision", "vision", new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$9$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(DashboardFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.makeLogout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setUp$lambda$10(DashboardFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GestureDetector gestureDetector = this$0.gestureDetector;
        if (gestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            gestureDetector = null;
        }
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(DashboardFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainView = "one";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        HorizontalScrollView horizontalScrollView = fragmentDashboardBinding != null ? fragmentDashboardBinding.hrView : null;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (imageView3 = fragmentDashboardBinding2.viewOneBtn) != null) {
            imageView3.setBackgroundResource(R.drawable.round_white_backgroundd);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (imageView2 = fragmentDashboardBinding3.viewTwoBtn) != null) {
            imageView2.setBackgroundResource(R.color.transparent);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (imageView = fragmentDashboardBinding4.viewThreeBtn) != null) {
            imageView.setBackgroundResource(R.color.transparent);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        ImageView imageView4 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.viewOneBtn : null;
        if (imageView4 != null) {
            imageView4.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorBlack)));
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        ImageView imageView5 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.viewTwoBtn : null;
        if (imageView5 != null) {
            imageView5.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite)));
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        ImageView imageView6 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.viewThreeBtn : null;
        if (imageView6 != null) {
            imageView6.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite)));
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        RecyclerView recyclerView = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.rvDashOne : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        LinearLayout linearLayout = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.rvDashTwo : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.rvDashAll : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onNoticeBoardClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$13(DashboardFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainView = "two";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        HorizontalScrollView horizontalScrollView = fragmentDashboardBinding != null ? fragmentDashboardBinding.hrView : null;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (imageView3 = fragmentDashboardBinding2.viewTwoBtn) != null) {
            imageView3.setBackgroundResource(R.drawable.round_white_backgroundd);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (imageView2 = fragmentDashboardBinding3.viewOneBtn) != null) {
            imageView2.setBackgroundResource(R.color.transparent);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (imageView = fragmentDashboardBinding4.viewThreeBtn) != null) {
            imageView.setBackgroundResource(R.color.transparent);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        ImageView imageView4 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.viewOneBtn : null;
        if (imageView4 != null) {
            imageView4.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite)));
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        ImageView imageView5 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.viewTwoBtn : null;
        if (imageView5 != null) {
            imageView5.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorBlack)));
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        ImageView imageView6 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.viewThreeBtn : null;
        if (imageView6 != null) {
            imageView6.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite)));
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        RecyclerView recyclerView = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.rvDashOne : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        LinearLayout linearLayout = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.rvDashTwo : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.rvDashAll : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(DashboardFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainView = "three";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        HorizontalScrollView horizontalScrollView = fragmentDashboardBinding != null ? fragmentDashboardBinding.hrView : null;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (imageView3 = fragmentDashboardBinding2.viewThreeBtn) != null) {
            imageView3.setBackgroundResource(R.drawable.round_white_backgroundd);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (imageView2 = fragmentDashboardBinding3.viewTwoBtn) != null) {
            imageView2.setBackgroundResource(R.color.transparent);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (imageView = fragmentDashboardBinding4.viewOneBtn) != null) {
            imageView.setBackgroundResource(R.color.transparent);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        ImageView imageView4 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.viewOneBtn : null;
        if (imageView4 != null) {
            imageView4.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite)));
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        ImageView imageView5 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.viewTwoBtn : null;
        if (imageView5 != null) {
            imageView5.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorWhite)));
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        ImageView imageView6 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.viewThreeBtn : null;
        if (imageView6 != null) {
            imageView6.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.colorBlack)));
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        RecyclerView recyclerView = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.rvDashOne : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        LinearLayout linearLayout = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.rvDashTwo : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        RecyclerView recyclerView2 = fragmentDashboardBinding10 != null ? fragmentDashboardBinding10.rvDashAll : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15(final DashboardFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.subView = "one";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        if (fragmentDashboardBinding != null && (textView12 = fragmentDashboardBinding.academicsBtn) != null) {
            textView12.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (textView11 = fragmentDashboardBinding2.feesBtn) != null) {
            textView11.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (textView10 = fragmentDashboardBinding3.informationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (textView9 = fragmentDashboardBinding4.officeBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        if (fragmentDashboardBinding5 != null && (textView8 = fragmentDashboardBinding5.placementBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        if (fragmentDashboardBinding6 != null && (textView7 = fragmentDashboardBinding6.placementBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        if (fragmentDashboardBinding7 != null && (textView6 = fragmentDashboardBinding7.academicsBtn) != null) {
            textView6.setTextColor(-1);
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        if (fragmentDashboardBinding8 != null && (textView5 = fragmentDashboardBinding8.feesBtn) != null) {
            textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        if (fragmentDashboardBinding9 != null && (textView4 = fragmentDashboardBinding9.informationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        if (fragmentDashboardBinding10 != null && (textView3 = fragmentDashboardBinding10.officeBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding11 = this$0.get_binding();
        if (fragmentDashboardBinding11 != null && (textView2 = fragmentDashboardBinding11.placementBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding12 = this$0.get_binding();
        if (fragmentDashboardBinding12 != null && (textView = fragmentDashboardBinding12.placementBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this$0.currentTabIndex = 0;
        this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$18$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DashboardFragment dashboardFragment = this.this$0;
                dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$16(final DashboardFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.subView = "two";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        if (fragmentDashboardBinding != null && (textView10 = fragmentDashboardBinding.feesBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (textView9 = fragmentDashboardBinding2.informationBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (textView8 = fragmentDashboardBinding3.officeBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (textView7 = fragmentDashboardBinding4.placementBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        if (fragmentDashboardBinding5 != null && (textView6 = fragmentDashboardBinding5.academicsBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        if (fragmentDashboardBinding6 != null && (textView5 = fragmentDashboardBinding6.feesBtn) != null) {
            textView5.setTextColor(-1);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        if (fragmentDashboardBinding7 != null && (textView4 = fragmentDashboardBinding7.informationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        if (fragmentDashboardBinding8 != null && (textView3 = fragmentDashboardBinding8.officeBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        if (fragmentDashboardBinding9 != null && (textView2 = fragmentDashboardBinding9.placementBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        if (fragmentDashboardBinding10 != null && (textView = fragmentDashboardBinding10.academicsBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this$0.currentTabIndex > 1) {
            this$0.currentTabIndex = 1;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$19$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        } else {
            this$0.currentTabIndex = 1;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$19$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$17(final DashboardFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.subView = "three";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        if (fragmentDashboardBinding != null && (textView10 = fragmentDashboardBinding.informationBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (textView9 = fragmentDashboardBinding2.feesBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (textView8 = fragmentDashboardBinding3.officeBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (textView7 = fragmentDashboardBinding4.placementBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        if (fragmentDashboardBinding5 != null && (textView6 = fragmentDashboardBinding5.academicsBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        if (fragmentDashboardBinding6 != null && (textView5 = fragmentDashboardBinding6.informationBtn) != null) {
            textView5.setTextColor(-1);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        if (fragmentDashboardBinding7 != null && (textView4 = fragmentDashboardBinding7.feesBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        if (fragmentDashboardBinding8 != null && (textView3 = fragmentDashboardBinding8.officeBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        if (fragmentDashboardBinding9 != null && (textView2 = fragmentDashboardBinding9.placementBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        if (fragmentDashboardBinding10 != null && (textView = fragmentDashboardBinding10.academicsBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this$0.currentTabIndex > 2) {
            this$0.currentTabIndex = 2;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$20$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        } else {
            this$0.currentTabIndex = 2;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$20$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$18(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 26) {
            this$0.showDatePickerSheet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$19(final DashboardFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.subView = "four";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        if (fragmentDashboardBinding != null && (textView10 = fragmentDashboardBinding.officeBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (textView9 = fragmentDashboardBinding2.informationBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (textView8 = fragmentDashboardBinding3.feesBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (textView7 = fragmentDashboardBinding4.placementBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        if (fragmentDashboardBinding5 != null && (textView6 = fragmentDashboardBinding5.academicsBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        if (fragmentDashboardBinding6 != null && (textView5 = fragmentDashboardBinding6.officeBtn) != null) {
            textView5.setTextColor(-1);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        if (fragmentDashboardBinding7 != null && (textView4 = fragmentDashboardBinding7.informationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        if (fragmentDashboardBinding8 != null && (textView3 = fragmentDashboardBinding8.feesBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        if (fragmentDashboardBinding9 != null && (textView2 = fragmentDashboardBinding9.placementBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        if (fragmentDashboardBinding10 != null && (textView = fragmentDashboardBinding10.academicsBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this$0.currentTabIndex > 3) {
            this$0.currentTabIndex = 3;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$22$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        } else {
            this$0.currentTabIndex = 3;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$22$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$20(final DashboardFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.subView = "five";
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        if (fragmentDashboardBinding != null && (textView10 = fragmentDashboardBinding.placementBtn) != null) {
            textView10.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        if (fragmentDashboardBinding2 != null && (textView9 = fragmentDashboardBinding2.informationBtn) != null) {
            textView9.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = this$0.get_binding();
        if (fragmentDashboardBinding3 != null && (textView8 = fragmentDashboardBinding3.officeBtn) != null) {
            textView8.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = this$0.get_binding();
        if (fragmentDashboardBinding4 != null && (textView7 = fragmentDashboardBinding4.feesBtn) != null) {
            textView7.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = this$0.get_binding();
        if (fragmentDashboardBinding5 != null && (textView6 = fragmentDashboardBinding5.academicsBtn) != null) {
            textView6.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = this$0.get_binding();
        if (fragmentDashboardBinding6 != null && (textView5 = fragmentDashboardBinding6.placementBtn) != null) {
            textView5.setTextColor(-1);
        }
        FragmentDashboardBinding fragmentDashboardBinding7 = this$0.get_binding();
        if (fragmentDashboardBinding7 != null && (textView4 = fragmentDashboardBinding7.informationBtn) != null) {
            textView4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding8 = this$0.get_binding();
        if (fragmentDashboardBinding8 != null && (textView3 = fragmentDashboardBinding8.officeBtn) != null) {
            textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding9 = this$0.get_binding();
        if (fragmentDashboardBinding9 != null && (textView2 = fragmentDashboardBinding9.feesBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentDashboardBinding fragmentDashboardBinding10 = this$0.get_binding();
        if (fragmentDashboardBinding10 != null && (textView = fragmentDashboardBinding10.academicsBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this$0.currentTabIndex > 4) {
            this$0.currentTabIndex = 4;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$23$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        } else {
            this$0.currentTabIndex = 4;
            this$0.animateRecyclerViewFadeSlide(true, new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$setUp$23$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = this.this$0;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$21(DashboardFragment this$0, String outputDateStr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardViewModel dashboardViewModel = this$0.getDashboardViewModel();
        Intrinsics.checkNotNullExpressionValue(outputDateStr, "outputDateStr");
        dashboardViewModel.loadDashboardSequentially(outputDateStr, null);
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentDashboardBinding != null ? fragmentDashboardBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shiftWeek(int days) {
        showTimetableLoading(days < 0 ? "← Loading previous week..." : "Loading next week... →");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = simpleDateFormat.parse(this.date);
            if (date == null) {
                date = new Date();
            }
            calendar.setTime(date);
        } catch (Exception unused) {
            calendar.setTime(new Date());
        }
        calendar.add(5, days);
        String str = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "inputFormat.format(cal.time)");
        this.date = str;
        DashboardViewModel.getTimeTableData$default(getDashboardViewModel(), this.date, false, 2, null);
    }

    private final void listenSemResponse() {
        getDashboardViewModel().getSemesterResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ArrayList<Semester>>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenSemResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenSemResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ArrayList<Semester>> resource) {
                invoke2(resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<? extends ArrayList<Semester>> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    DashboardFragment.this.hideProgress();
                    ArrayList<Semester> data = resource.getData();
                    if (data != null) {
                        DashboardFragment dashboardFragment = DashboardFragment.this;
                        dashboardFragment.showBaseView();
                        Context contextRequireContext = dashboardFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        dashboardFragment.saveSemesterList(contextRequireContext, data);
                        return;
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
                } else {
                    if (i != 4) {
                        return;
                    }
                    DashboardFragment.this.hideProgress();
                    DashboardFragment.this.showBaseView();
                }
            }
        }));
    }

    private final void updateMonthYearDisplay() {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern(CalendarAdapter.YEAR_FORMAT);
        LocalDate localDate = this.currentDate;
        if (localDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate = null;
        }
        this.currentMonth = localDate.format(dateTimeFormatterOfPattern);
        LocalDate localDate2 = this.currentDate;
        if (localDate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate2 = null;
        }
        this.currentYear = localDate2.format(dateTimeFormatterOfPattern2);
        System.out.println((Object) this.currentMonth);
        System.out.println((Object) this.currentYear);
        DateTimeFormatter dateTimeFormatterOfPattern3 = DateTimeFormatter.ofPattern("MMMM yyyy");
        LocalDate localDate3 = this.currentDate;
        if (localDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            localDate3 = null;
        }
        String str = localDate3.format(dateTimeFormatterOfPattern3);
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        TextView textView = fragmentDashboardBinding != null ? fragmentDashboardBinding.monthTv : null;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    private final List<String> generateDaysInMonth(LocalDate date) {
        ArrayList arrayList = new ArrayList();
        YearMonth yearMonthOf = YearMonth.of(date.getYear(), date.getMonth());
        int i = 1;
        LocalDate localDateWithDayOfMonth = date.withDayOfMonth(1);
        LocalDate localDateWithDayOfMonth2 = date.withDayOfMonth(yearMonthOf.lengthOfMonth());
        int value = localDateWithDayOfMonth.getDayOfWeek().getValue() % 7;
        System.out.println((Object) "firstDayOfMonth");
        System.out.println(value);
        System.out.println((Object) "firstDayOfMonth");
        int i2 = value != 0 ? value : 7;
        for (int i3 = 1; i3 < i2; i3++) {
            arrayList.add("");
        }
        int dayOfMonth = localDateWithDayOfMonth2.getDayOfMonth();
        if (1 <= dayOfMonth) {
            while (true) {
                arrayList.add(String.valueOf(i));
                if (i == dayOfMonth) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private final void forceupdate(int versionCode) {
        System.out.println(versionCode);
        System.out.println(405);
        System.out.println(405);
        if (405 < versionCode) {
            showUpdateDialog2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDateUI(String date) {
        try {
            this.date = date;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE, yyyy-MM-dd", Locale.getDefault());
            Date date2 = simpleDateFormat.parse(date);
            String str = date2 != null ? simpleDateFormat2.format(date2) : null;
            if (str == null) {
                str = date;
            }
            FragmentDashboardBinding fragmentDashboardBinding = get_binding();
            TextView textView = fragmentDashboardBinding != null ? fragmentDashboardBinding.dateTv : null;
            if (textView == null) {
                return;
            }
            textView.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
            FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
            TextView textView2 = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.dateTv : null;
            if (textView2 == null) {
                return;
            }
            textView2.setText(date);
        }
    }

    private final void listenResponse() {
        getDashboardViewModel().getDashResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DashboardFragment.listenResponse$lambda$26(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void listenResponse$lambda$26(DashboardFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
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
                this$0.isEngnr = Boolean.valueOf(dashResponse.isEngnr());
                String baseUrl = this$0.getPreference().getBaseUrl();
                Boolean boolValueOf = Boolean.valueOf(StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "sbce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "sahrdaya", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "sjcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "uat", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "vjcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "jecc", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "demo", false, 2, (Object) null));
                this$0.isExam = boolValueOf;
                if (Intrinsics.areEqual((Object) boolValueOf, (Object) true)) {
                    DashBoardViewAllAdapter adapterDashAll = this$0.getAdapterDashAll();
                    ArrayList<String> titleTkm = DashboardItems.INSTANCE.getTitleTkm();
                    ArrayList<Integer> iconsTkm = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                    adapterDashAll.addItems(titleTkm, iconsTkm, fragmentActivityRequireActivity);
                    DashBoardSixAdapter adapterDashPlacement = this$0.getAdapterDashPlacement();
                    ArrayList<String> titlePlacement = DashboardItems.INSTANCE.getTitlePlacement();
                    ArrayList<Integer> iconsTkm2 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity2 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
                    adapterDashPlacement.addItems(titlePlacement, iconsTkm2, fragmentActivityRequireActivity2);
                    DashBoardThreeAdapter adapterDashFees = this$0.getAdapterDashFees();
                    ArrayList<String> titleFees = DashboardItems.INSTANCE.getTitleFees();
                    ArrayList<Integer> iconFees = DashboardItems.INSTANCE.getIconFees();
                    FragmentActivity fragmentActivityRequireActivity3 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity()");
                    adapterDashFees.addItems(titleFees, iconFees, fragmentActivityRequireActivity3);
                    DashBoardFourAdapter adapterDashInfo = this$0.getAdapterDashInfo();
                    ArrayList<String> titleInfo = DashboardItems.INSTANCE.getTitleInfo();
                    ArrayList<Integer> iconsTkm3 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity4 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity4, "requireActivity()");
                    adapterDashInfo.addItems(titleInfo, iconsTkm3, fragmentActivityRequireActivity4);
                    DashBoardFiveAdapter adapterDashOffice = this$0.getAdapterDashOffice();
                    ArrayList<String> titleOffice = DashboardItems.INSTANCE.getTitleOffice();
                    ArrayList<Integer> iconsTkm4 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity5 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity5, "requireActivity()");
                    adapterDashOffice.addItems(titleOffice, iconsTkm4, fragmentActivityRequireActivity5);
                    DashBoardTwoAdapter adapterDashAcademics = this$0.getAdapterDashAcademics();
                    ArrayList<String> titleAcademics = DashboardItems.INSTANCE.getTitleAcademics();
                    ArrayList<Integer> iconsAcademics = DashboardItems.INSTANCE.getIconsAcademics();
                    FragmentActivity fragmentActivityRequireActivity6 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity6, "requireActivity()");
                    adapterDashAcademics.addItems(titleAcademics, iconsAcademics, fragmentActivityRequireActivity6);
                } else if (Intrinsics.areEqual((Object) this$0.isEngnr, (Object) true)) {
                    DashBoardViewAllAdapter adapterDashAll2 = this$0.getAdapterDashAll();
                    ArrayList<String> title = DashboardItems.INSTANCE.getTitle();
                    ArrayList<Integer> icons = DashboardItems.INSTANCE.getIcons();
                    FragmentActivity fragmentActivityRequireActivity7 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity7, "requireActivity()");
                    adapterDashAll2.addItems(title, icons, fragmentActivityRequireActivity7);
                    DashBoardSixAdapter adapterDashPlacement2 = this$0.getAdapterDashPlacement();
                    ArrayList<String> titlePlacement2 = DashboardItems.INSTANCE.getTitlePlacement();
                    ArrayList<Integer> iconsTkm5 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity8 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity8, "requireActivity()");
                    adapterDashPlacement2.addItems(titlePlacement2, iconsTkm5, fragmentActivityRequireActivity8);
                    DashBoardThreeAdapter adapterDashFees2 = this$0.getAdapterDashFees();
                    ArrayList<String> titleFees2 = DashboardItems.INSTANCE.getTitleFees();
                    ArrayList<Integer> iconFees2 = DashboardItems.INSTANCE.getIconFees();
                    FragmentActivity fragmentActivityRequireActivity9 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity9, "requireActivity()");
                    adapterDashFees2.addItems(titleFees2, iconFees2, fragmentActivityRequireActivity9);
                    DashBoardFourAdapter adapterDashInfo2 = this$0.getAdapterDashInfo();
                    ArrayList<String> titleInfo2 = DashboardItems.INSTANCE.getTitleInfo();
                    ArrayList<Integer> iconsTkm6 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity10 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity10, "requireActivity()");
                    adapterDashInfo2.addItems(titleInfo2, iconsTkm6, fragmentActivityRequireActivity10);
                    DashBoardFiveAdapter adapterDashOffice2 = this$0.getAdapterDashOffice();
                    ArrayList<String> titleOffice2 = DashboardItems.INSTANCE.getTitleOffice();
                    ArrayList<Integer> iconsTkm7 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity11 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity11, "requireActivity()");
                    adapterDashOffice2.addItems(titleOffice2, iconsTkm7, fragmentActivityRequireActivity11);
                    DashBoardTwoAdapter adapterDashAcademics2 = this$0.getAdapterDashAcademics();
                    ArrayList<String> titleAcademicsArts = DashboardItems.INSTANCE.getTitleAcademicsArts();
                    ArrayList<Integer> iconsAcademicsArts = DashboardItems.INSTANCE.getIconsAcademicsArts();
                    FragmentActivity fragmentActivityRequireActivity12 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity12, "requireActivity()");
                    adapterDashAcademics2.addItems(titleAcademicsArts, iconsAcademicsArts, fragmentActivityRequireActivity12);
                } else {
                    DashBoardViewAllAdapter adapterDashAll3 = this$0.getAdapterDashAll();
                    ArrayList<String> titleArts = DashboardItems.INSTANCE.getTitleArts();
                    ArrayList<Integer> iconsArts = DashboardItems.INSTANCE.getIconsArts();
                    FragmentActivity fragmentActivityRequireActivity13 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity13, "requireActivity()");
                    adapterDashAll3.addItems(titleArts, iconsArts, fragmentActivityRequireActivity13);
                    DashBoardSixAdapter adapterDashPlacement3 = this$0.getAdapterDashPlacement();
                    ArrayList<String> titlePlacementArts = DashboardItems.INSTANCE.getTitlePlacementArts();
                    ArrayList<Integer> iconsTkm8 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity14 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity14, "requireActivity()");
                    adapterDashPlacement3.addItems(titlePlacementArts, iconsTkm8, fragmentActivityRequireActivity14);
                    DashBoardThreeAdapter adapterDashFees3 = this$0.getAdapterDashFees();
                    ArrayList<String> titleFeesArts = DashboardItems.INSTANCE.getTitleFeesArts();
                    ArrayList<Integer> iconFeesArts = DashboardItems.INSTANCE.getIconFeesArts();
                    FragmentActivity fragmentActivityRequireActivity15 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity15, "requireActivity()");
                    adapterDashFees3.addItems(titleFeesArts, iconFeesArts, fragmentActivityRequireActivity15);
                    DashBoardFourAdapter adapterDashInfo3 = this$0.getAdapterDashInfo();
                    ArrayList<String> titleInfo3 = DashboardItems.INSTANCE.getTitleInfo();
                    ArrayList<Integer> iconsTkm9 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity16 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity16, "requireActivity()");
                    adapterDashInfo3.addItems(titleInfo3, iconsTkm9, fragmentActivityRequireActivity16);
                    DashBoardFiveAdapter adapterDashOffice3 = this$0.getAdapterDashOffice();
                    ArrayList<String> titleOfficeArts = DashboardItems.INSTANCE.getTitleOfficeArts();
                    ArrayList<Integer> iconsTkm10 = DashboardItems.INSTANCE.getIconsTkm();
                    FragmentActivity fragmentActivityRequireActivity17 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity17, "requireActivity()");
                    adapterDashOffice3.addItems(titleOfficeArts, iconsTkm10, fragmentActivityRequireActivity17);
                    DashBoardTwoAdapter adapterDashAcademics3 = this$0.getAdapterDashAcademics();
                    ArrayList<String> titleAcademicsArts2 = DashboardItems.INSTANCE.getTitleAcademicsArts();
                    ArrayList<Integer> iconsAcademics2 = DashboardItems.INSTANCE.getIconsAcademics();
                    FragmentActivity fragmentActivityRequireActivity18 = this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity18, "requireActivity()");
                    adapterDashAcademics3.addItems(titleAcademicsArts2, iconsAcademics2, fragmentActivityRequireActivity18);
                }
                String str = this$0.subView;
                switch (str.hashCode()) {
                    case 110182:
                        if (str.equals("one")) {
                            this$0.updateDataForTab(0);
                        }
                        break;
                    case 115276:
                        if (str.equals("two")) {
                            this$0.updateDataForTab(1);
                        }
                        break;
                    case 3143346:
                        if (str.equals("five")) {
                            this$0.updateDataForTab(4);
                        }
                        break;
                    case 3149094:
                        if (str.equals("four")) {
                            this$0.updateDataForTab(3);
                        }
                        break;
                    case 110339486:
                        if (str.equals("three")) {
                            this$0.updateDataForTab(2);
                        }
                        break;
                }
                this$0.getPreference().setSurveyStatus(dashResponse.getSurveyStatus());
                this$0.getPreference().setVersionCode(String.valueOf(dashResponse.getVersionCode()));
                FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
                TextView textView = fragmentDashboardBinding != null ? fragmentDashboardBinding.dashUserRollNo : null;
                if (textView != null) {
                    textView.setText("Roll No " + dashResponse.getRollNo());
                }
                String baseUrl2 = this$0.getPreference().getBaseUrl();
                if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "engnr", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeEngnr());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "sctce", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeSctce());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "aisat", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeAisat());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "cep", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCep());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "cetkr", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCetkr());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "coet", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCoet());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "cev", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeCev());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "gcekkd", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGcekkd());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "gcek", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGcek());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "gcei", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGcei());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "gecskp", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGecskp());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "gectr", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGectcr());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "gecwyd", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeGecwyd());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "jecc", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeJecc());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "kmeacoa", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeKmeacoa());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "kmea", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeKmea());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "mace", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeMace());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "marian", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeMarian());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "mdit", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeMdit());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "nssce", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeNssce());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "sjcetpalai", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeSjcetPalai());
                } else if (StringsKt.contains$default((CharSequence) baseUrl2, (CharSequence) "tkmce", false, 2, (Object) null)) {
                    this$0.forceupdate(dashResponse.getVersionCodeTkmce());
                } else {
                    this$0.forceupdate(dashResponse.getVersionCode());
                }
                if (this$0.getPreference().getUserImg().length() > 0) {
                    RequestCreator requestCreatorCenterCrop = Picasso.get().load(this$0.getPreference().getUserImg()).placeholder(R.drawable.ic_user_profile).error(R.drawable.ic_user_profile).resize(90, 90).centerCrop();
                    FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
                    ShapeableImageView shapeableImageView = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.userIcon : null;
                    Intrinsics.checkNotNull(shapeableImageView);
                    requestCreatorCenterCrop.into(shapeableImageView);
                }
                this$0.getPreference().setUserSemId(dashResponse.getSemId());
                this$0.getPreference().setFeeStatus(dashResponse.getFeeStatus());
                this$0.getPreference().setDueNew(dashResponse.getDueNew());
                this$0.getPreference().setFeeEngnrNew(dashResponse.getFeeEngnrStatus());
                this$0.liveTvLink = dashResponse.getLiveTvLink();
                this$0.liveTvType = dashResponse.getLiveTvType();
                if (dashResponse.getPasswordChanged() && (mainCallBackListener = this$0.listener) != null) {
                    mainCallBackListener.makeLogout();
                }
            } catch (Exception unused) {
            }
            if (405 < dashResponse.getCurrentVersion()) {
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
            } catch (NullPointerException unused2) {
                System.out.println((Object) "ooo");
            }
        }
    }

    private final void listenEventsResponse() {
        getDashboardViewModel().getEventsResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CalendarResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenEventsResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenEventsResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CalendarResponse> resource) {
                invoke2((Resource<CalendarResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CalendarResponse> resource) {
                LocalDate localDate;
                LocalDate localDate2;
                CalendarEventType calendarEventType;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
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
                        DashboardFragment dashboardFragment = DashboardFragment.this;
                        if (StringsKt.contains$default((CharSequence) message2, (CharSequence) "403", false, 2, (Object) null)) {
                            FragmentManager childFragmentManager = dashboardFragment.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                            MaintenanceDialog maintenanceDialogNewInstance = MaintenanceDialog.INSTANCE.newInstance();
                            maintenanceDialogNewInstance.setCancelable(false);
                            maintenanceDialogNewInstance.setCallBack(dashboardFragment);
                            maintenanceDialogNewInstance.show(childFragmentManager, (String) null);
                            return;
                        }
                        System.out.println((Object) "Anuuu Unknown error occurred");
                        return;
                    }
                    return;
                }
                DashboardFragment.this.hideProgress();
                CalendarResponse data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment2 = DashboardFragment.this;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    LocalDate localDate3 = dashboardFragment2.currentDate;
                    if (localDate3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                        localDate3 = null;
                    }
                    int year = localDate3.getYear();
                    LocalDate localDate4 = dashboardFragment2.currentDate;
                    if (localDate4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                        localDate4 = null;
                    }
                    YearMonth yearMonthOf = YearMonth.of(year, localDate4.getMonth());
                    LocalDate localDate5 = dashboardFragment2.currentDate;
                    if (localDate5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                        localDate5 = null;
                    }
                    LocalDate localDateWithDayOfMonth = localDate5.withDayOfMonth(1);
                    LocalDate localDate6 = dashboardFragment2.currentDate;
                    if (localDate6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                        localDate6 = null;
                    }
                    LocalDate localDateWithDayOfMonth2 = localDate6.withDayOfMonth(yearMonthOf.lengthOfMonth());
                    int value = localDateWithDayOfMonth.getDayOfWeek().getValue() % 7;
                    System.out.println((Object) "firstDayOfWeek");
                    System.out.println(value);
                    System.out.println((Object) "firstDayOfWeek");
                    int i2 = value == 0 ? 7 : value;
                    for (int i3 = 1; i3 < i2; i3++) {
                        arrayList.add("");
                        arrayList2.add("");
                        arrayList3.add("");
                        arrayList4.add("");
                        arrayList5.add(0);
                        arrayList6.add(false);
                    }
                    int dayOfMonth = localDateWithDayOfMonth2.getDayOfMonth();
                    if (1 <= dayOfMonth) {
                        int i4 = 1;
                        while (true) {
                            arrayList.add(String.valueOf(i4));
                            if (i4 == dayOfMonth) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList<Birthday> birthday = data.getBirthday();
                    ArrayList<in.etuwa.app.data.model.calendar.Calendar> data2 = data.getData();
                    if (data2 != null) {
                        for (in.etuwa.app.data.model.calendar.Calendar calendar : data2) {
                            try {
                                localDate2 = LocalDate.parse(calendar.getDate());
                            } catch (Exception unused) {
                                Log.e("Calendar", "Invalid date: " + calendar.getDate());
                                localDate2 = null;
                            }
                            if (localDate2 != null) {
                                if (StringsKt.contains((CharSequence) calendar.getSubject(), (CharSequence) "Assignment", true)) {
                                    calendarEventType = CalendarEventType.ASSIGNMENT;
                                } else if (StringsKt.contains((CharSequence) calendar.getSubject(), (CharSequence) "Holiday", true)) {
                                    calendarEventType = CalendarEventType.HOLIDAY;
                                } else {
                                    calendarEventType = (StringsKt.contains((CharSequence) calendar.getSubject(), (CharSequence) "Exam", true) || StringsKt.contains((CharSequence) calendar.getSubject(), (CharSequence) "Examschedules", true)) ? CalendarEventType.EXAM : null;
                                }
                                if (calendarEventType != null) {
                                    if (!linkedHashMap.containsKey(localDate2)) {
                                        linkedHashMap.put(localDate2, new ArrayList());
                                    }
                                    List<CalendarEvent> list = linkedHashMap.get(localDate2);
                                    if (list != null) {
                                        list.add(new CalendarEvent(localDate2, calendar.getSubject(), calendarEventType));
                                    }
                                }
                            }
                        }
                    }
                    if (birthday != null) {
                        for (Birthday birthday2 : birthday) {
                            try {
                                localDate = LocalDate.parse(birthday2.getDob());
                            } catch (Exception unused2) {
                                Log.e("Calendar", "Invalid birthday date: " + birthday2.getDob());
                                localDate = null;
                            }
                            if (localDate != null) {
                                if (!linkedHashMap.containsKey(localDate)) {
                                    linkedHashMap.put(localDate, new ArrayList());
                                }
                                List<CalendarEvent> list2 = linkedHashMap.get(localDate);
                                if (list2 != null) {
                                    list2.add(new CalendarEvent(localDate, "Birthday : " + birthday2.getName(), CalendarEventType.BIRTHDAY));
                                }
                            }
                        }
                    }
                    DashboardCalendarAdapter adapterCalendar = dashboardFragment2.getAdapterCalendar();
                    LocalDate localDate7 = dashboardFragment2.currentDate;
                    if (localDate7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                        localDate7 = null;
                    }
                    adapterCalendar.addItems(arrayList, linkedHashMap, localDate7);
                }
            }
        }));
    }

    private final void listenExamStatusResponse() {
        getDashboardViewModel().getResultResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends UnivTotalResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenExamStatusResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenExamStatusResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends UnivTotalResponse> resource) {
                invoke2((Resource<UnivTotalResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<UnivTotalResponse> resource) {
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
                    FragmentDashboardBinding fragmentDashboardBinding = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding == null || (recyclerView = fragmentDashboardBinding.rvDashOne) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                DashboardFragment.this.hideProgress();
                UnivTotalResponse data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    FragmentDashboardBinding fragmentDashboardBinding2 = dashboardFragment.get_binding();
                    TextView textView = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.cgpaTv : null;
                    if (textView != null) {
                        textView.setText(String.valueOf(data.getCgpa()));
                    }
                    FragmentDashboardBinding fragmentDashboardBinding3 = dashboardFragment.get_binding();
                    TextView textView2 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.earnedCreditTv : null;
                    if (textView2 != null) {
                        textView2.setText(data.getEarned_credit() + RemoteSettings.FORWARD_SLASH_STRING + data.getTotal_credit());
                    }
                    FragmentDashboardBinding fragmentDashboardBinding4 = dashboardFragment.get_binding();
                    TextView textView3 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.totalPassedTv : null;
                    if (textView3 != null) {
                        textView3.setText(data.getTotal_passed() + RemoteSettings.FORWARD_SLASH_STRING + data.getTotal_exams());
                    }
                    FragmentDashboardBinding fragmentDashboardBinding5 = dashboardFragment.get_binding();
                    TextView textView4 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.totalFailedTv : null;
                    if (textView4 == null) {
                        return;
                    }
                    textView4.setText(data.getTotal_backlogs() + RemoteSettings.FORWARD_SLASH_STRING + data.getTotal_exams());
                }
            }
        }));
    }

    private final void listenAttResponse() {
        getDashboardViewModel().getAttResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AttendanceDetails>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenAttResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenAttResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AttendanceDetails> resource) {
                invoke2((Resource<AttendanceDetails>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AttendanceDetails> resource) {
                CircleProgressView circleProgressView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    DashboardFragment.this.hideProgress();
                    AttendanceDetails data = resource.getData();
                    if (data != null) {
                        DashboardFragment dashboardFragment = DashboardFragment.this;
                        if (Intrinsics.areEqual(data.getAttendance_forthesem(), "N/A")) {
                            return;
                        }
                        FragmentDashboardBinding fragmentDashboardBinding = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding != null && (circleProgressView = fragmentDashboardBinding.dashAttendanceForSem) != null) {
                            circleProgressView.setValueAnimated(Float.parseFloat(data.getAttendance_forthesem()));
                        }
                        dashboardFragment.getPreference().setAttendancePercentage(data.getAttendance_forthesem());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    System.out.println((Object) resource.getMessage());
                    DashboardFragment.this.showProgress();
                    return;
                }
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    DashboardFragment.this.hideProgress();
                } else {
                    String message = resource.getMessage();
                    if (message != null) {
                        System.out.println((Object) ("Error message: " + message));
                    }
                }
            }
        }));
    }

    private final void listenMaintenanceResponse() {
        getDashboardViewModel().getMaintenanceResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends MaintenanceResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenMaintenanceResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenMaintenanceResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
                        MaintenanceDialog maintenanceDialogNewInstance = MaintenanceDialog.INSTANCE.newInstance();
                        maintenanceDialogNewInstance.setCallBack(dashboardFragment);
                        maintenanceDialogNewInstance.show(childFragmentManager, (String) null);
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
                        MaintenanceDialog maintenanceDialogNewInstance2 = MaintenanceDialog.INSTANCE.newInstance();
                        maintenanceDialogNewInstance2.setCancelable(false);
                        maintenanceDialogNewInstance2.setCallBack(dashboardFragment2);
                        maintenanceDialogNewInstance2.show(childFragmentManager2, (String) null);
                        return;
                    }
                    System.out.println((Object) "Auuu Unknown error occurred");
                }
            }
        }));
    }

    private final void listenSurveyStatusResponse() {
        getDashboardViewModel().getSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PendingSurvey>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenSurveyStatusResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyStatusResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<PendingSurvey> resource) {
                TextView dashUserRollNo;
                TextView dashUserRollNo2;
                TextView dashUserRollNo3;
                TextView dashUserRollNo4;
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
                    FragmentDashboardBinding fragmentDashboardBinding = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding == null || (recyclerView = fragmentDashboardBinding.rvDashOne) == null) {
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
                        MainCallBackListener mainCallBackListener = dashboardFragment.listener;
                        if (mainCallBackListener != null) {
                            mainCallBackListener.openForceSemReg();
                            return;
                        }
                        return;
                    }
                    if (data.getProfile_status() && StringsKt.contains$default((CharSequence) dashboardFragment.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) {
                        MainCallBackListener mainCallBackListener2 = dashboardFragment.listener;
                        if (mainCallBackListener2 != null) {
                            mainCallBackListener2.forceOpenProfile();
                        }
                        FragmentDashboardBinding fragmentDashboardBinding2 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding2 == null || (dashUserRollNo4 = fragmentDashboardBinding2.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo4, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo4, "Please complete the Profile to access dashboard");
                        return;
                    }
                    if (data.getSurvey_status()) {
                        MainCallBackListener mainCallBackListener3 = dashboardFragment.listener;
                        if (mainCallBackListener3 != null) {
                            mainCallBackListener3.openForceToDoSurvey();
                        }
                        FragmentDashboardBinding fragmentDashboardBinding3 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding3 == null || (dashUserRollNo3 = fragmentDashboardBinding3.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo3, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo3, "Please complete the pending Survey to access dashboard");
                        return;
                    }
                    if (data.getPosurvey_status()) {
                        MainCallBackListener mainCallBackListener4 = dashboardFragment.listener;
                        if (mainCallBackListener4 != null) {
                            mainCallBackListener4.openPoSurvey();
                        }
                        FragmentDashboardBinding fragmentDashboardBinding4 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding4 == null || (dashUserRollNo2 = fragmentDashboardBinding4.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo2, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo2, "Please complete the pending PO Survey to access dashboard");
                        return;
                    }
                    if (data.getCoursesurvey_status()) {
                        MainCallBackListener mainCallBackListener5 = dashboardFragment.listener;
                        if (mainCallBackListener5 != null) {
                            mainCallBackListener5.openCourseSurvey();
                        }
                        FragmentDashboardBinding fragmentDashboardBinding5 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding5 == null || (dashUserRollNo = fragmentDashboardBinding5.dashUserRollNo) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(dashUserRollNo, "dashUserRollNo");
                        ToastExtKt.showInfoToast(dashUserRollNo, "Please complete the pending Course Survey to access dashboard");
                    }
                }
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showUpdateDialog2() {
        /*
            r5 = this;
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = r5.forceUpdateDialog
            r1 = 0
            if (r0 == 0) goto Ld
            boolean r0 = r0.isShowing()
            r2 = 1
            if (r0 != r2) goto Ld
            goto Le
        Ld:
            r2 = 0
        Le:
            if (r2 == 0) goto L11
            return
        L11:
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = new com.google.android.material.bottomsheet.BottomSheetDialog
            android.content.Context r2 = r5.requireContext()
            int r3 = in.etuwa.app.R.style.TransparentBottomSheetDialog
            r0.<init>(r2, r3)
            android.view.LayoutInflater r2 = r5.getLayoutInflater()
            int r3 = in.etuwa.app.R.layout.bottom_sheet_force_update
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            r0.setContentView(r2)
            r0.setCancelable(r1)
            r0.setCanceledOnTouchOutside(r1)
            int r3 = com.google.android.material.R.id.design_bottom_sheet
            android.view.View r3 = r0.findViewById(r3)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            if (r3 == 0) goto L4c
            android.view.View r3 = (android.view.View) r3
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r3)
            java.lang.String r4 = "from(it)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r3.setDraggable(r1)
            r1 = 3
            r3.setState(r1)
        L4c:
            in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda34 r1 = new in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda34
            r1.<init>()
            r0.setOnKeyListener(r1)
            int r1 = in.etuwa.app.R.id.btnUpdate
            android.view.View r1 = r2.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda35 r2 = new in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda35
            r2.<init>()
            r1.setOnClickListener(r2)
            r0.show()
            r5.forceUpdateDialog = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardFragment.showUpdateDialog2():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUpdateDialog2$lambda$29(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotToPlaystore2();
    }

    private final void gotToPlaystore2() {
        if (!isAdded() || getActivity() == null) {
            return;
        }
        String packageName = requireActivity().getPackageName();
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Uri uri2 = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName);
        try {
            startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException unused) {
            if (!isAdded() || getActivity() == null) {
                return;
            }
            startActivity(new Intent("android.intent.action.VIEW", uri2));
        }
    }

    @Override // in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialog.ProfileCallBack
    public void onDismissProfile() {
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onDismissProfile();
        }
    }

    /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenTableResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DashboardFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/ui/dashboard/dashtable/TimeTableMonthlyNewResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02211 extends Lambda implements Function1<Resource<? extends TimeTableMonthlyNewResponse>, Unit> {

        /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenTableResponse$1$WhenMappings */
        /* JADX INFO: compiled from: DashboardFragment.kt */
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

        C02211() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends TimeTableMonthlyNewResponse> resource) {
            invoke2((Resource<TimeTableMonthlyNewResponse>) resource);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Resource<TimeTableMonthlyNewResponse> resource) {
            RecyclerView rvDashOne;
            BoundaryAwareViewPager boundaryAwareViewPager;
            RecyclerView recyclerView;
            int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
            if (i == 1) {
                DashboardFragment.this.hideProgress();
                final TimeTableMonthlyNewResponse data = resource.getData();
                if (data != null) {
                    final DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    try {
                        dashboardFragment.getSelected().clear();
                        Iterator<T> it = data.getTimetable().iterator();
                        while (it.hasNext()) {
                            dashboardFragment.getSelected().add(((TimeTableNewResponse) it.next()).getDate());
                        }
                        dashboardFragment.getTitle().clear();
                        dashboardFragment.getTitle().addAll(dashboardFragment.getSelected());
                        FragmentDashboardBinding fragmentDashboardBinding = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding != null && (boundaryAwareViewPager = fragmentDashboardBinding.timetablePagerHome) != null) {
                            boundaryAwareViewPager.post(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$listenTableResponse$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DashboardFragment.C02211.invoke$lambda$5$lambda$4(dashboardFragment, data);
                                }
                            });
                        }
                    } catch (NullPointerException unused) {
                        dashboardFragment.hideTimetableLoading();
                        FragmentDashboardBinding fragmentDashboardBinding2 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding2 != null && (rvDashOne = fragmentDashboardBinding2.rvDashOne) != null) {
                            Intrinsics.checkNotNullExpressionValue(rvDashOne, "rvDashOne");
                            ToastExtKt.showErrorToast(rvDashOne, "Some Error Occurred. Try again later!!");
                        }
                    }
                    dashboardFragment.isLoadingWeek = false;
                    return;
                }
                return;
            }
            if (i == 2) {
                DashboardFragment.this.showProgress();
                if (!DashboardFragment.this.isLoadingWeek) {
                    FragmentDashboardBinding fragmentDashboardBinding3 = DashboardFragment.this.get_binding();
                    BoundaryAwareViewPager boundaryAwareViewPager2 = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.timetablePagerHome : null;
                    if (boundaryAwareViewPager2 == null) {
                        return;
                    }
                    boundaryAwareViewPager2.setVisibility(8);
                    return;
                }
                DashboardFragment.showTimetableLoading$default(DashboardFragment.this, null, 1, null);
                return;
            }
            if (i == 3) {
                DashboardFragment.this.hideProgress();
                DashboardFragment.this.hideTimetableLoading();
                DashboardFragment.this.showBaseView();
                FragmentDashboardBinding fragmentDashboardBinding4 = DashboardFragment.this.get_binding();
                BoundaryAwareViewPager boundaryAwareViewPager3 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.timetablePagerHome : null;
                if (boundaryAwareViewPager3 != null) {
                    boundaryAwareViewPager3.setVisibility(8);
                }
                FragmentDashboardBinding fragmentDashboardBinding5 = DashboardFragment.this.get_binding();
                TextView textView = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.noTimetableTv : null;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                FragmentDashboardBinding fragmentDashboardBinding6 = DashboardFragment.this.get_binding();
                TextView textView2 = fragmentDashboardBinding6 != null ? fragmentDashboardBinding6.noTimetableTv : null;
                if (textView2 != null) {
                    textView2.setText("Error while loading timetable");
                }
                DashboardFragment.this.isLoadingWeek = false;
                return;
            }
            if (i != 4) {
                return;
            }
            DashboardFragment.this.hideProgress();
            DashboardFragment.this.hideTimetableLoading();
            DashboardFragment.this.showBaseView();
            FragmentDashboardBinding fragmentDashboardBinding7 = DashboardFragment.this.get_binding();
            BoundaryAwareViewPager boundaryAwareViewPager4 = fragmentDashboardBinding7 != null ? fragmentDashboardBinding7.timetablePagerHome : null;
            if (boundaryAwareViewPager4 != null) {
                boundaryAwareViewPager4.setVisibility(8);
            }
            FragmentDashboardBinding fragmentDashboardBinding8 = DashboardFragment.this.get_binding();
            TextView textView3 = fragmentDashboardBinding8 != null ? fragmentDashboardBinding8.noTimetableTv : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            FragmentDashboardBinding fragmentDashboardBinding9 = DashboardFragment.this.get_binding();
            TextView textView4 = fragmentDashboardBinding9 != null ? fragmentDashboardBinding9.noTimetableTv : null;
            if (textView4 != null) {
                textView4.setText("Error while loading timetable");
            }
            FragmentDashboardBinding fragmentDashboardBinding10 = DashboardFragment.this.get_binding();
            if (fragmentDashboardBinding10 != null && (recyclerView = fragmentDashboardBinding10.rvDashOne) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
            DashboardFragment.this.isLoadingWeek = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final void invoke$lambda$5$lambda$4(in.etuwa.app.ui.dashboard.DashboardFragment r7, in.etuwa.app.ui.dashboard.dashtable.TimeTableMonthlyNewResponse r8) {
            /*
                Method dump skipped, instruction units count: 336
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardFragment.C02211.invoke$lambda$5$lambda$4(in.etuwa.app.ui.dashboard.DashboardFragment, in.etuwa.app.ui.dashboard.dashtable.TimeTableMonthlyNewResponse):void");
        }
    }

    private final void listenTableResponse() {
        getDashboardViewModel().getResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new C02211()));
    }

    private final void listenSurveyMandatoryStatus() {
        getDashboardViewModel().getSurveyMandatoryStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SurveyMandatory>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenSurveyMandatoryStatus.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyMandatoryStatus$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SurveyMandatory> resource) {
                RecyclerView rvDashOne;
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
                    FragmentDashboardBinding fragmentDashboardBinding = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding == null || (recyclerView = fragmentDashboardBinding.rvDashOne) == null) {
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
                        if (data.getLogin() && data.getSurvey_mandatory()) {
                            DashboardViewModel.getPendingSurveyStatus$default(dashboardFragment.getDashboardViewModel(), false, 1, null);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        FragmentDashboardBinding fragmentDashboardBinding2 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding2 == null || (rvDashOne = fragmentDashboardBinding2.rvDashOne) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(rvDashOne, "rvDashOne");
                        ToastExtKt.showErrorToast(rvDashOne, "Some Error Occured.Try again later!!");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenCourseSurveyStatus() {
        getDashboardViewModel().getCourseSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CourseSurveyPending>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenCourseSurveyStatus.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenCourseSurveyStatus$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CourseSurveyPending> resource) {
                RecyclerView rvDashOne;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    DashboardFragment.this.hideProgress();
                    CourseSurveyPending data = resource.getData();
                    if (data != null) {
                        DashboardFragment dashboardFragment = DashboardFragment.this;
                        dashboardFragment.showBaseView();
                        try {
                            if (data.getCoursesurvey_status()) {
                                dashboardFragment.showPendingDialog("Please complete the pending Course Survey to access dashboard");
                            }
                            Unit unit = Unit.INSTANCE;
                            return;
                        } catch (NullPointerException unused) {
                            FragmentDashboardBinding fragmentDashboardBinding = dashboardFragment.get_binding();
                            if (fragmentDashboardBinding == null || (rvDashOne = fragmentDashboardBinding.rvDashOne) == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(rvDashOne, "rvDashOne");
                            ToastExtKt.showErrorToast(rvDashOne, "Some Error Occured.Try again later!!");
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
                FragmentDashboardBinding fragmentDashboardBinding2 = DashboardFragment.this.get_binding();
                if (fragmentDashboardBinding2 == null || (recyclerView = fragmentDashboardBinding2.rvDashOne) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    private final void listenPoSurveyStatus() {
        getDashboardViewModel().getPoSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends POSurveyPending>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenPoSurveyStatus.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenPoSurveyStatus$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<POSurveyPending> resource) {
                RecyclerView rvDashOne;
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
                    FragmentDashboardBinding fragmentDashboardBinding = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding == null || (recyclerView = fragmentDashboardBinding.rvDashInfo) == null) {
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
                            dashboardFragment.showPendingDialog("Please complete the pending PO Survey to access dashboard");
                        } else if (StringsKt.contains$default((CharSequence) dashboardFragment.getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) dashboardFragment.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
                            DashboardViewModel.getCourseSurveyStatus$default(dashboardFragment.getDashboardViewModel(), false, 1, null);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        FragmentDashboardBinding fragmentDashboardBinding2 = dashboardFragment.get_binding();
                        if (fragmentDashboardBinding2 == null || (rvDashOne = fragmentDashboardBinding2.rvDashOne) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(rvDashOne, "rvDashOne");
                        ToastExtKt.showErrorToast(rvDashOne, "Some Error Occured.Try again later!!");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenSurveyStatus() {
        getDashboardViewModel().getPendingSurveyStatusResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SurveyPending>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenSurveyStatus.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenSurveyStatus$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SurveyPending> resource) {
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
                    FragmentDashboardBinding fragmentDashboardBinding = DashboardFragment.this.get_binding();
                    if (fragmentDashboardBinding == null || (recyclerView = fragmentDashboardBinding.rvDashOne) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                DashboardFragment.this.hideProgress();
                SurveyPending data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    if (data.getSurvey_status()) {
                        dashboardFragment.showPendingDialog("Please complete the pending Survey to access dashboard");
                        return;
                    }
                    if (!data.getSemreg_default()) {
                        dashboardFragment.showPendingDialog("Complete your Semester Registration for accessing Etlab!!!");
                        return;
                    }
                    if ((!data.getProfile_status() || !StringsKt.contains$default((CharSequence) dashboardFragment.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null)) && (!data.getProfile_status() || !StringsKt.contains$default((CharSequence) dashboardFragment.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                        DashboardViewModel.getPoSurveyStatus$default(dashboardFragment.getDashboardViewModel(), false, 1, null);
                    } else {
                        dashboardFragment.showPendingDialog("Please complete the Profile to access dashboard");
                    }
                }
            }
        }));
    }

    private final void showInfoDialog(String infoMsg) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            View viewInflate = getLayoutInflater().inflate(R.layout.info_layout, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(R.id.info_dialog);
            builder.setTitle("INFO");
            textView.setText(infoMsg);
            builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) null);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showUpdateDialog() {
        /*
            r5 = this;
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = r5.forceUpdateDialog     // Catch: java.lang.Exception -> L69
            r1 = 0
            if (r0 == 0) goto Ld
            boolean r0 = r0.isShowing()     // Catch: java.lang.Exception -> L69
            r2 = 1
            if (r0 != r2) goto Ld
            goto Le
        Ld:
            r2 = 0
        Le:
            if (r2 == 0) goto L11
            return
        L11:
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = new com.google.android.material.bottomsheet.BottomSheetDialog     // Catch: java.lang.Exception -> L69
            android.content.Context r2 = r5.requireContext()     // Catch: java.lang.Exception -> L69
            int r3 = in.etuwa.app.R.style.TransparentBottomSheetDialog     // Catch: java.lang.Exception -> L69
            r0.<init>(r2, r3)     // Catch: java.lang.Exception -> L69
            android.view.LayoutInflater r2 = r5.getLayoutInflater()     // Catch: java.lang.Exception -> L69
            int r3 = in.etuwa.app.R.layout.bottom_sheet_force_update     // Catch: java.lang.Exception -> L69
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)     // Catch: java.lang.Exception -> L69
            r0.setContentView(r2)     // Catch: java.lang.Exception -> L69
            r0.setCancelable(r1)     // Catch: java.lang.Exception -> L69
            r0.setCanceledOnTouchOutside(r1)     // Catch: java.lang.Exception -> L69
            int r3 = com.google.android.material.R.id.design_bottom_sheet     // Catch: java.lang.Exception -> L69
            android.view.View r3 = r0.findViewById(r3)     // Catch: java.lang.Exception -> L69
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3     // Catch: java.lang.Exception -> L69
            if (r3 == 0) goto L4c
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Exception -> L69
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r3)     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "from(it)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.Exception -> L69
            r3.setDraggable(r1)     // Catch: java.lang.Exception -> L69
            r1 = 3
            r3.setState(r1)     // Catch: java.lang.Exception -> L69
        L4c:
            in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda36 r1 = new in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda36     // Catch: java.lang.Exception -> L69
            r1.<init>()     // Catch: java.lang.Exception -> L69
            r0.setOnKeyListener(r1)     // Catch: java.lang.Exception -> L69
            int r1 = in.etuwa.app.R.id.btnUpdate     // Catch: java.lang.Exception -> L69
            android.view.View r1 = r2.findViewById(r1)     // Catch: java.lang.Exception -> L69
            android.widget.Button r1 = (android.widget.Button) r1     // Catch: java.lang.Exception -> L69
            in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda37 r2 = new in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda37     // Catch: java.lang.Exception -> L69
            r2.<init>()     // Catch: java.lang.Exception -> L69
            r1.setOnClickListener(r2)     // Catch: java.lang.Exception -> L69
            r0.show()     // Catch: java.lang.Exception -> L69
            r5.forceUpdateDialog = r0     // Catch: java.lang.Exception -> L69
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.dashboard.DashboardFragment.showUpdateDialog():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUpdateDialog$lambda$32(DashboardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotToPlaystore2();
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
        DashTimeTableAdapter dashTimeTableAdapter = this.tableAdapter;
        if (dashTimeTableAdapter != null) {
            if (dashTimeTableAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tableAdapter");
                dashTimeTableAdapter = null;
            }
            dashTimeTableAdapter.setCallBack(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void listenUrlResponse() {
        getDashboardViewModel().getLibraryResponse().observe(getViewLifecycleOwner(), new DashboardFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends LibraryResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.listenUrlResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.DashboardFragment$listenUrlResponse$1$WhenMappings */
            /* JADX INFO: compiled from: DashboardFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<LibraryResponse> resource) {
                MainCallBackListener mainCallBackListener;
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
                    } else {
                        if (i != 4) {
                            return;
                        }
                        DashboardFragment.this.hideProgress();
                        DashboardFragment.this.showBaseView();
                        return;
                    }
                }
                DashboardFragment.this.hideProgress();
                LibraryResponse data = resource.getData();
                if (data != null) {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    if (Intrinsics.areEqual(data.getUrl(), "") || (mainCallBackListener = dashboardFragment.listener) == null) {
                        return;
                    }
                    mainCallBackListener.openPaymentPage(data.getUrl());
                }
            }
        }));
    }

    private final void listenResponse2() {
        getDashboardViewModel().getResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DashboardFragment.listenResponse2$lambda$35(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse2$lambda$35(DashboardFragment this$0, Resource resource) {
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
                    ArrayList<Notice> notice = noticeResponse.getNotice();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(notice, 10));
                    Iterator<T> it = notice.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Html.fromHtml(((Notice) it.next()).getContent()).toString());
                    }
                    ArrayList arrayList2 = arrayList;
                    Context contextRequireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    this$0.saveNoticeList(contextRequireContext, arrayList2);
                    if (!arrayList2.isEmpty()) {
                        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
                        Intrinsics.checkNotNull(fragmentDashboardBinding);
                        ScrollView scrollView = fragmentDashboardBinding.noticeScrollView;
                        Intrinsics.checkNotNullExpressionValue(scrollView, "binding!!.noticeScrollView");
                        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
                        Intrinsics.checkNotNull(fragmentDashboardBinding2);
                        LinearLayout linearLayout = fragmentDashboardBinding2.noticeContainer;
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding!!.noticeContainer");
                        this$0.setupAutoScrollingNotices(scrollView, linearLayout, arrayList2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.custom_alert_dialog, (ViewGroup) null);
            dialog.setContentView(viewInflate);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            dialog.setCancelable(false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvMessage);
            Button button = (Button) viewInflate.findViewById(R.id.btnOk);
            textView.setText(message);
            button.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardFragment.showPendingDialog$lambda$36(dialog, message, this, view);
                }
            });
            dialog.show();
            return;
        }
        System.out.println((Object) "lol");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPendingDialog$lambda$36(Dialog dialog, String message, DashboardFragment this$0, View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSwipeLeft() {
        if (this.currentTabIndex < this.categories.size() - 1) {
            this.currentTabIndex++;
            animateFadeTransition(new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.onSwipeLeft.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSwipeRight() {
        int i = this.currentTabIndex;
        if (i > 0) {
            this.currentTabIndex = i - 1;
            animateFadeTransition(new Function0<Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment.onSwipeRight.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DashboardFragment dashboardFragment = DashboardFragment.this;
                    dashboardFragment.updateDataForTab(dashboardFragment.currentTabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDataForTab(int index) {
        this.categories.get(index);
        highlightSelectedTab(index);
    }

    private final void highlightSelectedTab(int index) {
        resetTabs();
        List<? extends TextView> list = this.tabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
            list = null;
        }
        TextView textView = list.get(index);
        if (textView != null) {
            textView.setBackgroundResource(R.drawable.bg_gradient_button);
            textView.setTextColor(-1);
            textView.setTextSize(2, 15.0f);
        }
        if (Intrinsics.areEqual((Object) this.isExam, (Object) true)) {
            if (index == 0) {
                DashboardOneAdapter adapterDashOne = getAdapterDashOne();
                ArrayList<String> titleAcademics = DashboardItems.INSTANCE.getTitleAcademics();
                ArrayList<Integer> iconsAcademics = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                adapterDashOne.addItems(titleAcademics, iconsAcademics, fragmentActivityRequireActivity);
            } else if (index == 1) {
                DashboardOneAdapter adapterDashOne2 = getAdapterDashOne();
                ArrayList<String> titleFees = DashboardItems.INSTANCE.getTitleFees();
                ArrayList<Integer> iconFees = DashboardItems.INSTANCE.getIconFees();
                FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
                adapterDashOne2.addItems(titleFees, iconFees, fragmentActivityRequireActivity2);
            } else if (index == 2) {
                DashboardOneAdapter adapterDashOne3 = getAdapterDashOne();
                ArrayList<String> titleInfo = DashboardItems.INSTANCE.getTitleInfo();
                ArrayList<Integer> iconsAcademics2 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity()");
                adapterDashOne3.addItems(titleInfo, iconsAcademics2, fragmentActivityRequireActivity3);
            } else if (index == 3) {
                DashboardOneAdapter adapterDashOne4 = getAdapterDashOne();
                ArrayList<String> titleOffice = DashboardItems.INSTANCE.getTitleOffice();
                ArrayList<Integer> iconsAcademics3 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity4 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity4, "requireActivity()");
                adapterDashOne4.addItems(titleOffice, iconsAcademics3, fragmentActivityRequireActivity4);
            } else if (index == 4) {
                DashboardOneAdapter adapterDashOne5 = getAdapterDashOne();
                ArrayList<String> titlePlacement = DashboardItems.INSTANCE.getTitlePlacement();
                ArrayList<Integer> iconsAcademics4 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity5 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity5, "requireActivity()");
                adapterDashOne5.addItems(titlePlacement, iconsAcademics4, fragmentActivityRequireActivity5);
            }
        } else if (Intrinsics.areEqual((Object) this.isEngnr, (Object) true)) {
            if (index == 0) {
                DashboardOneAdapter adapterDashOne6 = getAdapterDashOne();
                ArrayList<String> titleAcademicsArts = DashboardItems.INSTANCE.getTitleAcademicsArts();
                ArrayList<Integer> iconsAcademics5 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity6 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity6, "requireActivity()");
                adapterDashOne6.addItems(titleAcademicsArts, iconsAcademics5, fragmentActivityRequireActivity6);
            } else if (index == 1) {
                DashboardOneAdapter adapterDashOne7 = getAdapterDashOne();
                ArrayList<String> titleFees2 = DashboardItems.INSTANCE.getTitleFees();
                ArrayList<Integer> iconFees2 = DashboardItems.INSTANCE.getIconFees();
                FragmentActivity fragmentActivityRequireActivity7 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity7, "requireActivity()");
                adapterDashOne7.addItems(titleFees2, iconFees2, fragmentActivityRequireActivity7);
            } else if (index == 2) {
                DashboardOneAdapter adapterDashOne8 = getAdapterDashOne();
                ArrayList<String> titleInfo2 = DashboardItems.INSTANCE.getTitleInfo();
                ArrayList<Integer> iconsAcademics6 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity8 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity8, "requireActivity()");
                adapterDashOne8.addItems(titleInfo2, iconsAcademics6, fragmentActivityRequireActivity8);
            } else if (index == 3) {
                DashboardOneAdapter adapterDashOne9 = getAdapterDashOne();
                ArrayList<String> titleOffice2 = DashboardItems.INSTANCE.getTitleOffice();
                ArrayList<Integer> iconsAcademics7 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity9 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity9, "requireActivity()");
                adapterDashOne9.addItems(titleOffice2, iconsAcademics7, fragmentActivityRequireActivity9);
            } else if (index == 4) {
                DashboardOneAdapter adapterDashOne10 = getAdapterDashOne();
                ArrayList<String> titlePlacement2 = DashboardItems.INSTANCE.getTitlePlacement();
                ArrayList<Integer> iconsAcademics8 = DashboardItems.INSTANCE.getIconsAcademics();
                FragmentActivity fragmentActivityRequireActivity10 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity10, "requireActivity()");
                adapterDashOne10.addItems(titlePlacement2, iconsAcademics8, fragmentActivityRequireActivity10);
            }
        } else if (index == 0) {
            DashboardOneAdapter adapterDashOne11 = getAdapterDashOne();
            ArrayList<String> titleAcademicsArts2 = DashboardItems.INSTANCE.getTitleAcademicsArts();
            ArrayList<Integer> iconsAcademicsArts = DashboardItems.INSTANCE.getIconsAcademicsArts();
            FragmentActivity fragmentActivityRequireActivity11 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity11, "requireActivity()");
            adapterDashOne11.addItems(titleAcademicsArts2, iconsAcademicsArts, fragmentActivityRequireActivity11);
        } else if (index == 1) {
            DashboardOneAdapter adapterDashOne12 = getAdapterDashOne();
            ArrayList<String> titleFeesArts = DashboardItems.INSTANCE.getTitleFeesArts();
            ArrayList<Integer> iconsAcademicsArts2 = DashboardItems.INSTANCE.getIconsAcademicsArts();
            FragmentActivity fragmentActivityRequireActivity12 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity12, "requireActivity()");
            adapterDashOne12.addItems(titleFeesArts, iconsAcademicsArts2, fragmentActivityRequireActivity12);
        } else if (index == 2) {
            DashboardOneAdapter adapterDashOne13 = getAdapterDashOne();
            ArrayList<String> titleInfo3 = DashboardItems.INSTANCE.getTitleInfo();
            ArrayList<Integer> iconsAcademics9 = DashboardItems.INSTANCE.getIconsAcademics();
            FragmentActivity fragmentActivityRequireActivity13 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity13, "requireActivity()");
            adapterDashOne13.addItems(titleInfo3, iconsAcademics9, fragmentActivityRequireActivity13);
        } else if (index == 3) {
            DashboardOneAdapter adapterDashOne14 = getAdapterDashOne();
            ArrayList<String> titleOfficeArts = DashboardItems.INSTANCE.getTitleOfficeArts();
            ArrayList<Integer> iconsAcademicsArts3 = DashboardItems.INSTANCE.getIconsAcademicsArts();
            FragmentActivity fragmentActivityRequireActivity14 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity14, "requireActivity()");
            adapterDashOne14.addItems(titleOfficeArts, iconsAcademicsArts3, fragmentActivityRequireActivity14);
        } else if (index == 4) {
            DashboardOneAdapter adapterDashOne15 = getAdapterDashOne();
            ArrayList<String> titlePlacementArts = DashboardItems.INSTANCE.getTitlePlacementArts();
            ArrayList<Integer> iconsAcademicsArts4 = DashboardItems.INSTANCE.getIconsAcademicsArts();
            FragmentActivity fragmentActivityRequireActivity15 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity15, "requireActivity()");
            adapterDashOne15.addItems(titlePlacementArts, iconsAcademicsArts4, fragmentActivityRequireActivity15);
        }
        centerSelectedTab(textView);
    }

    private final void resetTabs() {
        List<? extends TextView> list = this.tabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
            list = null;
        }
        for (TextView textView : list) {
            if (textView != null) {
                textView.setBackgroundTintList(null);
                textView.setBackgroundResource(R.drawable.shape_round_unselected);
                textView.setTextColor(Color.parseColor("#000000"));
                textView.setTextSize(2, 13.0f);
            }
        }
    }

    private final void centerSelectedTab(final View tab) {
        FragmentDashboardBinding fragmentDashboardBinding;
        HorizontalScrollView horizontalScrollView;
        if (tab == null || (fragmentDashboardBinding = get_binding()) == null || (horizontalScrollView = fragmentDashboardBinding.hrView) == null) {
            return;
        }
        horizontalScrollView.post(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                DashboardFragment.centerSelectedTab$lambda$40(this.f$0, tab);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void centerSelectedTab$lambda$40(DashboardFragment this$0, View view) {
        HorizontalScrollView horizontalScrollView;
        View childAt;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        if (fragmentDashboardBinding == null || (horizontalScrollView = fragmentDashboardBinding.hrView) == null || (childAt = horizontalScrollView.getChildAt(0)) == null) {
            return;
        }
        horizontalScrollView.smoothScrollTo(RangesKt.coerceIn((view.getLeft() + (view.getWidth() / 2)) - (horizontalScrollView.getWidth() / 2), 0, RangesKt.coerceAtLeast(childAt.getWidth() - horizontalScrollView.getWidth(), 0)), 0);
    }

    private final int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    private final void animateRecyclerViewFadeSlide(boolean toLeft, final Function0<Unit> onAnimationEnd) {
        int i = toLeft ? -1 : 1;
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        Intrinsics.checkNotNull(fragmentDashboardBinding);
        final int width = fragmentDashboardBinding.rvDashOne.getWidth() * i;
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        Intrinsics.checkNotNull(fragmentDashboardBinding2);
        fragmentDashboardBinding2.rvDashOne.animate().alpha(0.0f).translationX(width / 2).setDuration(250L).withEndAction(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DashboardFragment.animateRecyclerViewFadeSlide$lambda$41(this.f$0, width, onAnimationEnd);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateRecyclerViewFadeSlide$lambda$41(DashboardFragment this$0, int i, Function0 onAnimationEnd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "$onAnimationEnd");
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        Intrinsics.checkNotNull(fragmentDashboardBinding);
        fragmentDashboardBinding.rvDashOne.setTranslationX((-i) / 2);
        onAnimationEnd.invoke();
        FragmentDashboardBinding fragmentDashboardBinding2 = this$0.get_binding();
        Intrinsics.checkNotNull(fragmentDashboardBinding2);
        fragmentDashboardBinding2.rvDashOne.animate().alpha(1.0f).translationX(0.0f).setDuration(250L).start();
    }

    private final void animateFadeTransition(final Function0<Unit> onAnimationEnd) {
        RecyclerView recyclerView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        if (fragmentDashboardBinding == null || (recyclerView = fragmentDashboardBinding.rvDashOne) == null || (viewPropertyAnimatorAnimate = recyclerView.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(200L)) == null || (viewPropertyAnimatorWithEndAction = duration.withEndAction(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                DashboardFragment.animateFadeTransition$lambda$42(onAnimationEnd, this);
            }
        })) == null) {
            return;
        }
        viewPropertyAnimatorWithEndAction.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateFadeTransition$lambda$42(Function0 onAnimationEnd, DashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(onAnimationEnd, "$onAnimationEnd");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onAnimationEnd.invoke();
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        Intrinsics.checkNotNull(fragmentDashboardBinding);
        fragmentDashboardBinding.rvDashOne.animate().alpha(1.0f).setDuration(200L).start();
    }

    private final void showMissionVisionBottomSheet(final Context context, String title, String message, Function0<Unit> onConfirm) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.TransparentBottomSheetDialog);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_mission_vission, (ViewGroup) null);
        bottomSheetDialog.setContentView(viewInflate);
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(0);
        }
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = bottomSheetDialog.getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.5f);
        }
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.button_scale);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.visionBtn);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.missionBtn);
        final LinearLayout missionLyt = (LinearLayout) viewInflate.findViewById(R.id.mission_lyt);
        final LinearLayout visionLyt = (LinearLayout) viewInflate.findViewById(R.id.vision_lyt);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.btnCancel);
        AnimationUtils.loadAnimation(context, R.anim.fade_in_slide_up);
        AnimationUtils.loadAnimation(context, R.anim.fade_out_slide_down);
        if (Intrinsics.areEqual(message, "vision")) {
            showMissionVisionBottomSheet$selectVision(textView, context, textView2, missionLyt, visionLyt, animationLoadAnimation);
            Intrinsics.checkNotNullExpressionValue(visionLyt, "visionLyt");
            Intrinsics.checkNotNullExpressionValue(missionLyt, "missionLyt");
            showMissionVisionBottomSheet$crossFade(visionLyt, missionLyt);
        } else {
            showMissionVisionBottomSheet$selectMission(textView2, context, textView, missionLyt, visionLyt, animationLoadAnimation);
            Intrinsics.checkNotNullExpressionValue(missionLyt, "missionLyt");
            Intrinsics.checkNotNullExpressionValue(visionLyt, "visionLyt");
            showMissionVisionBottomSheet$crossFade(missionLyt, visionLyt);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.showMissionVisionBottomSheet$lambda$44(missionLyt, visionLyt, textView2, context, textView, animationLoadAnimation, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.showMissionVisionBottomSheet$lambda$45(visionLyt, missionLyt, textView, context, textView2, animationLoadAnimation, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.showMissionVisionBottomSheet$lambda$46(bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void showMissionVisionBottomSheet$selectMission(TextView textView, Context context, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, Animation animation) {
        textView.setBackgroundResource(R.drawable.shape_round_selected);
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        textView2.setBackground(null);
        textView.animate().scaleX(1.05f).scaleY(1.05f).setDuration(150L).start();
        textView2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).start();
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        textView.setTextSize(2, 14.0f);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
        textView.startAnimation(animation);
    }

    private static final void showMissionVisionBottomSheet$selectVision(TextView textView, Context context, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, Animation animation) {
        textView.setBackgroundResource(R.drawable.shape_round_selected);
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        textView2.setBackground(null);
        textView.animate().scaleX(1.05f).scaleY(1.05f).setDuration(150L).start();
        textView2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).start();
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        textView2.setTextSize(2, 12.0f);
        textView.setTextSize(2, 14.0f);
        textView2.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
        textView.startAnimation(animation);
    }

    private static final void showMissionVisionBottomSheet$crossFade(View view, final View view2) {
        view2.animate().alpha(0.0f).translationY(30.0f).setDuration(600L).withEndAction(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                DashboardFragment.showMissionVisionBottomSheet$crossFade$lambda$43(view2);
            }
        }).start();
        view.setAlpha(0.0f);
        view.setTranslationY(30.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).translationY(0.0f).setDuration(600L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMissionVisionBottomSheet$crossFade$lambda$43(View hideView) {
        Intrinsics.checkNotNullParameter(hideView, "$hideView");
        hideView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMissionVisionBottomSheet$lambda$44(LinearLayout missionLyt, LinearLayout visionLyt, TextView textView, Context context, TextView textView2, Animation animation, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        showMissionVisionBottomSheet$selectMission(textView, context, textView2, missionLyt, visionLyt, animation);
        Intrinsics.checkNotNullExpressionValue(missionLyt, "missionLyt");
        Intrinsics.checkNotNullExpressionValue(visionLyt, "visionLyt");
        showMissionVisionBottomSheet$crossFade(missionLyt, visionLyt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMissionVisionBottomSheet$lambda$45(LinearLayout visionLyt, LinearLayout missionLyt, TextView textView, Context context, TextView textView2, Animation animation, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        showMissionVisionBottomSheet$selectVision(textView, context, textView2, missionLyt, visionLyt, animation);
        Intrinsics.checkNotNullExpressionValue(visionLyt, "visionLyt");
        Intrinsics.checkNotNullExpressionValue(missionLyt, "missionLyt");
        showMissionVisionBottomSheet$crossFade(visionLyt, missionLyt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMissionVisionBottomSheet$lambda$46(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void setupAutoScrollingNotices(ScrollView scrollView, final LinearLayout container, List<String> notices) {
        container.removeAllViews();
        int i = (int) ((8 * scrollView.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        List<String> list = notices;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            container.addView(setupAutoScrollingNotices$createNoticeTextView(scrollView, i, (String) it.next()));
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            container.addView(setupAutoScrollingNotices$createNoticeTextView(scrollView, i, (String) it2.next()));
        }
        container.post(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                DashboardFragment.setupAutoScrollingNotices$lambda$51(container);
            }
        });
    }

    private static final TextView setupAutoScrollingNotices$createNoticeTextView(ScrollView scrollView, int i, String str) {
        TextView textView = new TextView(scrollView.getContext());
        textView.setText(str);
        textView.setTextSize(13.0f);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.colorBlack));
        textView.setTypeface(ResourcesCompat.getFont(textView.getContext(), R.font.poppins_regular));
        textView.setGravity(17);
        textView.setPadding(5, 8, 5, 8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAutoScrollingNotices$lambda$51(LinearLayout container) {
        Intrinsics.checkNotNullParameter(container, "$container");
        float height = container.getHeight() / 2.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(container, "translationY", 0.0f, -height);
        objectAnimatorOfFloat.setDuration((long) ((height / 30.0f) * 1000));
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
    }

    @Override // in.etuwa.app.ui.dashboard.DashboardOneAdapter.CallBack, in.etuwa.app.ui.dashboard.DashBoardTwoAdapter.CallBack, in.etuwa.app.ui.dashboard.DashBoardThreeAdapter.CallBack, in.etuwa.app.ui.dashboard.DashBoardFourAdapter.CallBack, in.etuwa.app.ui.dashboard.DashBoardFiveAdapter.CallBack, in.etuwa.app.ui.dashboard.DashBoardSixAdapter.CallBack, in.etuwa.app.ui.dashboard.DashBoardViewAllAdapter.CallBack
    public void onDashItemClickedNew(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onNewDashItemClicked(title);
        }
    }

    @Override // in.etuwa.app.ui.dashboard.DashboardCalendarAdapter.DayClickListener
    public void onDateClicked(LocalDate date, List<CalendarEvent> events) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(events, "events");
        if (!isAdded() || getChildFragmentManager().isStateSaved()) {
            return;
        }
        CalendarDayBottomSheet.INSTANCE.newInstance(date, events).show(getChildFragmentManager(), "CalendarSheet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveSemesterList(Context context, ArrayList<Semester> semesterList) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_prefs", 0).edit();
        editorEdit.putString("semester_list", new Gson().toJson(semesterList));
        editorEdit.putLong("semester_cache_time", System.currentTimeMillis());
        editorEdit.apply();
    }

    private final ArrayList<Semester> getSavedSemesterList(Context context) {
        return (ArrayList) new Gson().fromJson(context.getSharedPreferences("app_prefs", 0).getString("semester_list", null), new TypeToken<ArrayList<Semester>>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$getSavedSemesterList$type$1
        }.getType());
    }

    private final boolean isSemesterCacheExpired(Context context) {
        long j = context.getSharedPreferences("app_prefs", 0).getLong("semester_cache_time", 0L);
        return j == 0 || (System.currentTimeMillis() - j) / ((long) 86400000) >= 10;
    }

    private final boolean isSemesterCached(Context context) {
        return context.getSharedPreferences("app_prefs", 0).contains("semester_list");
    }

    private final boolean isNoticeCached(Context context) {
        return context.getSharedPreferences("app_prefs", 0).contains("notice_list");
    }

    private final void saveNoticeList(Context context, List<String> noticeList) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_prefs", 0).edit();
        editorEdit.putString("notice_list", new Gson().toJson(noticeList));
        editorEdit.putLong("notice_cache_time", System.currentTimeMillis());
        editorEdit.apply();
    }

    private final ArrayList<String> getSavedNotices(Context context) {
        return (ArrayList) new Gson().fromJson(context.getSharedPreferences("app_prefs", 0).getString("notice_list", null), new TypeToken<ArrayList<String>>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$getSavedNotices$type$1
        }.getType());
    }

    private final boolean isNoticeCacheExpired(Context context) {
        long j = context.getSharedPreferences("app_prefs", 0).getLong("notice_cache_time", 0L);
        return j == 0 || (System.currentTimeMillis() - j) / ((long) 86400000) >= 2;
    }

    public final boolean is24hCacheValid(long savedTime) {
        return savedTime != 0 && System.currentTimeMillis() - savedTime < 86400000;
    }

    public final void onPreviousWeekRequested() {
        if (this.isLoadingWeek) {
            return;
        }
        this.isLoadingWeek = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        Date date = simpleDateFormat.parse(this.date);
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        calendar.add(5, -7);
        String str = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "inputFormat.format(cal.time)");
        this.date = str;
        DashboardViewModel.getTimeTableData$default(getDashboardViewModel(), this.date, false, 2, null);
    }

    public final void onNextWeekRequested() {
        if (this.isLoadingWeek) {
            return;
        }
        this.isLoadingWeek = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        Date date = simpleDateFormat.parse(this.date);
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        calendar.add(5, 7);
        String str = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "inputFormat.format(cal.time)");
        this.date = str;
        DashboardViewModel.getTimeTableData$default(getDashboardViewModel(), this.date, false, 2, null);
    }

    static /* synthetic */ void showTimetableLoading$default(DashboardFragment dashboardFragment, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Loading timetable...";
        }
        dashboardFragment.showTimetableLoading(str);
    }

    private final void showTimetableLoading(String message) {
        FrameLayout frameLayout;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        FrameLayout frameLayout2 = fragmentDashboardBinding != null ? fragmentDashboardBinding.timetableLoadingOverlay : null;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        FragmentDashboardBinding fragmentDashboardBinding2 = get_binding();
        BoundaryAwareViewPager boundaryAwareViewPager = fragmentDashboardBinding2 != null ? fragmentDashboardBinding2.timetablePagerHome : null;
        if (boundaryAwareViewPager != null) {
            boundaryAwareViewPager.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding3 = get_binding();
        TextView textView = fragmentDashboardBinding3 != null ? fragmentDashboardBinding3.noTimetableTv : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentDashboardBinding fragmentDashboardBinding4 = get_binding();
        TextView textView2 = fragmentDashboardBinding4 != null ? fragmentDashboardBinding4.timetableLoadingTv : null;
        if (textView2 != null) {
            textView2.setText(message);
        }
        FragmentDashboardBinding fragmentDashboardBinding5 = get_binding();
        FrameLayout frameLayout3 = fragmentDashboardBinding5 != null ? fragmentDashboardBinding5.timetableLoadingOverlay : null;
        if (frameLayout3 != null) {
            frameLayout3.setAlpha(0.0f);
        }
        FragmentDashboardBinding fragmentDashboardBinding6 = get_binding();
        if (fragmentDashboardBinding6 == null || (frameLayout = fragmentDashboardBinding6.timetableLoadingOverlay) == null || (viewPropertyAnimatorAnimate = frameLayout.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(1.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(200L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTimetableLoading() {
        FrameLayout frameLayout;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        FragmentDashboardBinding fragmentDashboardBinding = get_binding();
        if (fragmentDashboardBinding == null || (frameLayout = fragmentDashboardBinding.timetableLoadingOverlay) == null || (viewPropertyAnimatorAnimate = frameLayout.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(200L)) == null || (viewPropertyAnimatorWithEndAction = duration.withEndAction(new Runnable() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                DashboardFragment.hideTimetableLoading$lambda$52(this.f$0);
            }
        })) == null) {
            return;
        }
        viewPropertyAnimatorWithEndAction.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideTimetableLoading$lambda$52(DashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentDashboardBinding fragmentDashboardBinding = this$0.get_binding();
        FrameLayout frameLayout = fragmentDashboardBinding != null ? fragmentDashboardBinding.timetableLoadingOverlay : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showDatePickerSheet() {
        T tWithDayOfMonth;
        LocalDate localDateNow;
        LocalDate localDateNow2;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.TransparentBottomSheetDialog);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_date_picker, (ViewGroup) null);
        bottomSheetDialog.setContentView(viewInflate);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = bottomSheetDialog.getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.4f);
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.picker_rv_calendar);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.picker_month_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.picker_month_prev);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.picker_month_next);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.picker_today_btn);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            Date date = simpleDateFormat.parse(this.date);
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNull(date);
            calendar.setTime(date);
            tWithDayOfMonth = LocalDate.of(calendar.get(1), calendar.get(2) + 1, 1);
        } catch (Exception unused) {
            tWithDayOfMonth = LocalDate.now().withDayOfMonth(1);
        }
        objectRef.element = tWithDayOfMonth;
        try {
            localDateNow = LocalDate.parse(this.date);
        } catch (Exception unused2) {
            localDateNow = LocalDate.now();
        }
        LocalDate localDateMinusDays = localDateNow.minusDays(localDateNow.getDayOfWeek().getValue() - 1);
        IntRange intRange = new IntRange(0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(localDateMinusDays.plusDays(((IntIterator) it).nextInt()));
        }
        final Set set = CollectionsKt.toSet(arrayList);
        try {
            localDateNow2 = LocalDate.parse(this.date);
        } catch (Exception unused3) {
            localDateNow2 = LocalDate.now();
        }
        final LocalDate localDate = localDateNow2;
        final TimetableDatePickerAdapter timetableDatePickerAdapter = new TimetableDatePickerAdapter(new Function1<LocalDate, Unit>() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$showDatePickerSheet$pickerAdapter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalDate localDate2) {
                invoke2(ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) localDate2));
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalDate pickedDate) {
                Intrinsics.checkNotNullParameter(pickedDate, "pickedDate");
                bottomSheetDialog.dismiss();
                this.handleDatePickedFromSheet(pickedDate, set);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        recyclerView.setAdapter(timetableDatePickerAdapter);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.showDatePickerSheet$lambda$56(objectRef, textView, timetableDatePickerAdapter, localDate, set, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.showDatePickerSheet$lambda$57(objectRef, textView, timetableDatePickerAdapter, localDate, set, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardFragment$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardFragment.showDatePickerSheet$lambda$58(bottomSheetDialog, this, set, view);
            }
        });
        showDatePickerSheet$refreshCalendar(textView, objectRef, timetableDatePickerAdapter, localDate, set);
        bottomSheetDialog.show();
    }

    private static final void showDatePickerSheet$refreshCalendar(TextView textView, Ref.ObjectRef<LocalDate> objectRef, TimetableDatePickerAdapter timetableDatePickerAdapter, LocalDate selectedLocalDate, Set<LocalDate> set) {
        textView.setText(ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) objectRef.element).format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        int year = ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) objectRef.element).getYear();
        int monthValue = ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) objectRef.element).getMonthValue();
        Intrinsics.checkNotNullExpressionValue(selectedLocalDate, "selectedLocalDate");
        timetableDatePickerAdapter.submitMonth(year, monthValue, selectedLocalDate, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, java.time.LocalDate] */
    public static final void showDatePickerSheet$lambda$56(Ref.ObjectRef displayMonth, TextView textView, TimetableDatePickerAdapter pickerAdapter, LocalDate localDate, Set currentWeekDates, View view) {
        Intrinsics.checkNotNullParameter(displayMonth, "$displayMonth");
        Intrinsics.checkNotNullParameter(pickerAdapter, "$pickerAdapter");
        Intrinsics.checkNotNullParameter(currentWeekDates, "$currentWeekDates");
        displayMonth.element = ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) displayMonth.element).minusMonths(1L);
        showDatePickerSheet$refreshCalendar(textView, displayMonth, pickerAdapter, localDate, currentWeekDates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, java.time.LocalDate] */
    public static final void showDatePickerSheet$lambda$57(Ref.ObjectRef displayMonth, TextView textView, TimetableDatePickerAdapter pickerAdapter, LocalDate localDate, Set currentWeekDates, View view) {
        Intrinsics.checkNotNullParameter(displayMonth, "$displayMonth");
        Intrinsics.checkNotNullParameter(pickerAdapter, "$pickerAdapter");
        Intrinsics.checkNotNullParameter(currentWeekDates, "$currentWeekDates");
        displayMonth.element = ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) displayMonth.element).plusMonths(1L);
        showDatePickerSheet$refreshCalendar(textView, displayMonth, pickerAdapter, localDate, currentWeekDates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDatePickerSheet$lambda$58(BottomSheetDialog dialog, DashboardFragment this$0, Set currentWeekDates, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentWeekDates, "$currentWeekDates");
        dialog.dismiss();
        LocalDate localDateNow = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow, "now()");
        this$0.handleDatePickedFromSheet(localDateNow, currentWeekDates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDatePickedFromSheet(LocalDate pickedDate, Set<LocalDate> currentWeekDates) {
        BoundaryAwareViewPager boundaryAwareViewPager;
        new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String string = pickedDate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "pickedDate.toString()");
        int i = 0;
        if (!currentWeekDates.contains(pickedDate)) {
            String string2 = pickedDate.minusDays(pickedDate.getDayOfWeek().getValue() - 1).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "monday.toString()");
            this.navigationDirection = 0;
            this.isLoadingWeek = true;
            this.pendingScrollToDate = string;
            this.date = string2;
            showTimetableLoading("Loading week of " + pickedDate.format(DateTimeFormatter.ofPattern("MMM d")) + "...");
            DashboardViewModel.getTimeTableData$default(getDashboardViewModel(), string2, false, 2, null);
            return;
        }
        Iterator<String> it = this.title.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next(), string)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            FragmentDashboardBinding fragmentDashboardBinding = get_binding();
            if (fragmentDashboardBinding != null && (boundaryAwareViewPager = fragmentDashboardBinding.timetablePagerHome) != null) {
                boundaryAwareViewPager.setCurrentItem(i, true);
            }
            updateDateUI(string);
        }
    }
}