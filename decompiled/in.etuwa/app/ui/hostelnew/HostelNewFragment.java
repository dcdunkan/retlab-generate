package in.etuwa.app.ui.hostelnew;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
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
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmission;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmissionResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewHistoryResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthly;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthlyResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewPay;
import in.etuwa.app.data.model.hostelnew.HostelStatusNew;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentHostelNewBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewHistory2Adapter;
import in.etuwa.app.ui.hostelnew.HostelNewHistoryAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter;
import in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog;
import in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: HostelNewFragment.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001oB\u0005¢\u0006\u0002\u0010\tJ\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020QH\u0016J\b\u0010T\u001a\u00020QH\u0014J\b\u0010U\u001a\u00020QH\u0014J\b\u0010V\u001a\u00020QH\u0002J\b\u0010W\u001a\u00020QH\u0002J\b\u0010X\u001a\u00020QH\u0002J\b\u0010Y\u001a\u00020QH\u0002J\b\u0010Z\u001a\u00020QH\u0002J&\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020QH\u0016J\u001a\u0010d\u001a\u00020Q2\u0006\u0010e\u001a\u00020\\2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020*H\u0016J\u0010\u0010h\u001a\u00020Q2\u0006\u0010g\u001a\u00020*H\u0016J\b\u0010i\u001a\u00020QH\u0014J\b\u0010j\u001a\u00020QH\u0014J\b\u0010k\u001a\u00020QH\u0014J\u0010\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u000200H\u0016J\u0010\u0010n\u001a\u00020Q2\u0006\u0010m\u001a\u000200H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00106\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u0012\u0012\u0004\u0012\u00020;07j\b\u0012\u0004\u0012\u00020;`9X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bC\u0010DR\u001e\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010M\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bN\u00102\"\u0004\bO\u00104¨\u0006p"}, d2 = {"Lin/etuwa/app/ui/hostelnew/HostelNewFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/hostelnew/HostelNewAdmissionAdapter$CallBack;", "Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter$CallBack;", "Lin/etuwa/app/ui/hostelnew/HostelNewReceiptAdapter$CallBack;", "Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsDialog$FeeDetailListner;", "Lin/etuwa/app/ui/hostelnew/confirm/HostelNewConfirmDialog$FeeDetailListner;", "Lin/etuwa/app/ui/hostelnew/HostelNewHistoryAdapter$CallBack;", "Lin/etuwa/app/ui/hostelnew/HostelNewHistory2Adapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentHostelNewBinding;", "adapterAdmission", "Lin/etuwa/app/ui/hostelnew/HostelNewAdmissionAdapter;", "getAdapterAdmission", "()Lin/etuwa/app/ui/hostelnew/HostelNewAdmissionAdapter;", "adapterAdmission$delegate", "Lkotlin/Lazy;", "adapterAdmissionHistory", "Lin/etuwa/app/ui/hostelnew/HostelNewHistoryAdapter;", "getAdapterAdmissionHistory", "()Lin/etuwa/app/ui/hostelnew/HostelNewHistoryAdapter;", "adapterAdmissionHistory$delegate", "adapterMonthly", "Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter;", "getAdapterMonthly", "()Lin/etuwa/app/ui/hostelnew/HostelNewMonthlyAdapter;", "adapterMonthly$delegate", "adapterMonthlyHistory", "Lin/etuwa/app/ui/hostelnew/HostelNewHistory2Adapter;", "getAdapterMonthlyHistory", "()Lin/etuwa/app/ui/hostelnew/HostelNewHistory2Adapter;", "adapterMonthlyHistory$delegate", "adapterReceipt", "Lin/etuwa/app/ui/hostelnew/HostelNewReceiptAdapter;", "getAdapterReceipt", "()Lin/etuwa/app/ui/hostelnew/HostelNewReceiptAdapter;", "adapterReceipt$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentHostelNewBinding;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "fine", "", "getFine", "()Ljava/lang/Integer;", "setFine", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hostelAdmission", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostelnew/HostelNewAdmission;", "Lkotlin/collections/ArrayList;", "hostelMonthly", "Lin/etuwa/app/data/model/hostelnew/HostelNewMonthly;", "hostelNewViewModel", "Lin/etuwa/app/ui/hostelnew/HostelNewViewModel;", "getHostelNewViewModel", "()Lin/etuwa/app/ui/hostelnew/HostelNewViewModel;", "hostelNewViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", NotificationCompat.CATEGORY_STATUS, "", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "subtotal", "getSubtotal", "setSubtotal", "dismiss", "", "feeClickedAdmission", "feeClickedMonthly", "hideBaseView", "hideProgress", "listenAdmissionResponse", "listenHistoryResponse", "listenMonthlyResponse", "listenPayResponse", "listenStatusResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "openPaymentPage", "url", "receiptDownload", "setUp", "showBaseView", "showProgress", "viewAdmissionBtnClicked", CommonCssConstants.POSITION, "viewMonthlyBtnClicked", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelNewFragment extends BaseFragment implements HostelNewAdmissionAdapter.CallBack, HostelNewMonthlyAdapter.CallBack, HostelNewReceiptAdapter.CallBack, HostelNewDetailsDialog.FeeDetailListner, HostelNewConfirmDialog.FeeDetailListner, HostelNewHistoryAdapter.CallBack, HostelNewHistory2Adapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentHostelNewBinding _binding;

    /* renamed from: adapterAdmission$delegate, reason: from kotlin metadata */
    private final Lazy adapterAdmission;

    /* renamed from: adapterAdmissionHistory$delegate, reason: from kotlin metadata */
    private final Lazy adapterAdmissionHistory;

    /* renamed from: adapterMonthly$delegate, reason: from kotlin metadata */
    private final Lazy adapterMonthly;

    /* renamed from: adapterMonthlyHistory$delegate, reason: from kotlin metadata */
    private final Lazy adapterMonthlyHistory;

    /* renamed from: adapterReceipt$delegate, reason: from kotlin metadata */
    private final Lazy adapterReceipt;
    private String date;
    private Integer fine;
    private ArrayList<HostelNewAdmission> hostelAdmission;
    private ArrayList<HostelNewMonthly> hostelMonthly;

    /* renamed from: hostelNewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelNewViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private Boolean status;
    private Integer subtotal;

    /* compiled from: HostelNewFragment.kt */
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
    public static final HostelNewFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog.FeeDetailListner
    public void dismiss() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter.CallBack
    public void receiptDownload(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public HostelNewFragment() {
        final HostelNewFragment hostelNewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelNewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelNewViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelNewFragment, Reflection.getOrCreateKotlinClass(HostelNewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelNewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelNewFragment hostelNewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapterMonthly = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelNewMonthlyAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewMonthlyAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewMonthlyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterAdmission = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<HostelNewAdmissionAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewAdmissionAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewAdmissionAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterReceipt = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<HostelNewReceiptAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewReceiptAdapter.class), b6, b7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        final byte b9 = 0 == true ? 1 : 0;
        this.adapterAdmissionHistory = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<HostelNewHistoryAdapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewHistoryAdapter.class), b8, b9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        final byte b11 = 0 == true ? 1 : 0;
        this.adapterMonthlyHistory = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<HostelNewHistory2Adapter>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.HostelNewHistory2Adapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewHistory2Adapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewHistory2Adapter.class), b10, b11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b12 = 0 == true ? 1 : 0;
        final byte b13 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = hostelNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b12, b13);
            }
        });
        this.hostelAdmission = new ArrayList<>();
        this.hostelMonthly = new ArrayList<>();
        this.status = false;
    }

    private final HostelNewViewModel getHostelNewViewModel() {
        return (HostelNewViewModel) this.hostelNewViewModel.getValue();
    }

    private final HostelNewMonthlyAdapter getAdapterMonthly() {
        return (HostelNewMonthlyAdapter) this.adapterMonthly.getValue();
    }

    private final HostelNewAdmissionAdapter getAdapterAdmission() {
        return (HostelNewAdmissionAdapter) this.adapterAdmission.getValue();
    }

    private final HostelNewReceiptAdapter getAdapterReceipt() {
        return (HostelNewReceiptAdapter) this.adapterReceipt.getValue();
    }

    private final HostelNewHistoryAdapter getAdapterAdmissionHistory() {
        return (HostelNewHistoryAdapter) this.adapterAdmissionHistory.getValue();
    }

    private final HostelNewHistory2Adapter getAdapterMonthlyHistory() {
        return (HostelNewHistory2Adapter) this.adapterMonthlyHistory.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentHostelNewBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final void setStatus(Boolean bool) {
        this.status = bool;
    }

    public final Integer getFine() {
        return this.fine;
    }

    public final void setFine(Integer num) {
        this.fine = num;
    }

    public final Integer getSubtotal() {
        return this.subtotal;
    }

    public final void setSubtotal(Integer num) {
        this.subtotal = num;
    }

    /* compiled from: HostelNewFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostelnew/HostelNewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostelnew/HostelNewFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelNewFragment newInstance() {
            return new HostelNewFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHostelNewBinding.inflate(inflater, container, false);
        FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
        if (fragmentHostelNewBinding != null) {
            fragmentHostelNewBinding.setHostelNewViewModel(getHostelNewViewModel());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
        if (fragmentHostelNewBinding2 != null) {
            fragmentHostelNewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        if (fragmentHostelNewBinding3 != null) {
            return fragmentHostelNewBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Hostel Fee");
        }
        hideBaseView();
        FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
        RecyclerView recyclerView = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.rvMonthly : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapterMonthly());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
        RecyclerView recyclerView2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.rvAdmission : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterAdmission());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        RecyclerView recyclerView3 = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.rvReceipts : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterReceipt());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding4 = get_binding();
        RecyclerView recyclerView4 = fragmentHostelNewBinding4 != null ? fragmentHostelNewBinding4.rvAdmissionHistory : null;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(getAdapterAdmissionHistory());
        }
        FragmentHostelNewBinding fragmentHostelNewBinding5 = get_binding();
        RecyclerView recyclerView5 = fragmentHostelNewBinding5 != null ? fragmentHostelNewBinding5.rvMonthlyHistory : null;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(getAdapterMonthlyHistory());
        }
        getAdapterMonthly().setCallBack(this);
        getAdapterAdmission().setCallBack(this);
        getPreference().setNewLogin(false);
        getHostelNewViewModel().getHostelStatus();
        listenAdmissionResponse();
        listenMonthlyResponse();
        listenHistoryResponse();
        listenPayResponse();
        listenStatusResponse();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        getHostelNewViewModel().getHostelAdmissionFee();
        getHostelNewViewModel().getHostelMonthlyFee();
        getHostelNewViewModel().getHostelHistory();
        FragmentHostelNewBinding fragmentHostelNewBinding6 = get_binding();
        if (fragmentHostelNewBinding6 != null && (textView3 = fragmentHostelNewBinding6.payOnlineBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelNewFragment.setUp$lambda$0(HostelNewFragment.this, view);
                }
            });
        }
        FragmentHostelNewBinding fragmentHostelNewBinding7 = get_binding();
        if (fragmentHostelNewBinding7 != null && (textView2 = fragmentHostelNewBinding7.receiptBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HostelNewFragment.setUp$lambda$1(HostelNewFragment.this, view);
                }
            });
        }
        FragmentHostelNewBinding fragmentHostelNewBinding8 = get_binding();
        if (fragmentHostelNewBinding8 == null || (textView = fragmentHostelNewBinding8.payFeeEngnrBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelNewFragment.setUp$lambda$2(hashMap2, hashMap, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(HostelNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding != null && (textView2 = fragmentHostelNewBinding.payOnlineBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = this$0.get_binding();
        if (fragmentHostelNewBinding2 != null && (textView = fragmentHostelNewBinding2.receiptBtn) != null) {
            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.swipeLayout : null;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(0);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding4 = this$0.get_binding();
        LinearLayout linearLayout = fragmentHostelNewBinding4 != null ? fragmentHostelNewBinding4.payBtnLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding5 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout2 = fragmentHostelNewBinding5 != null ? fragmentHostelNewBinding5.swipeLayoutHistory : null;
        if (swipeRefreshLayout2 == null) {
            return;
        }
        swipeRefreshLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding != null && (textView2 = fragmentHostelNewBinding.payOnlineBtn) != null) {
            textView2.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding2 = this$0.get_binding();
        if (fragmentHostelNewBinding2 != null && (textView = fragmentHostelNewBinding2.receiptBtn) != null) {
            textView.setBackgroundResource(R.drawable.shape_sharp_corner_fill_green);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.swipeLayout : null;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(8);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding4 = this$0.get_binding();
        LinearLayout linearLayout = fragmentHostelNewBinding4 != null ? fragmentHostelNewBinding4.payBtnLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentHostelNewBinding fragmentHostelNewBinding5 = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout2 = fragmentHostelNewBinding5 != null ? fragmentHostelNewBinding5.swipeLayoutHistory : null;
        if (swipeRefreshLayout2 == null) {
            return;
        }
        swipeRefreshLayout2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(HashMap feeReceipt, HashMap feeCollection, HostelNewFragment hostelNewFragment, View view) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        String str9;
        double d;
        String str10;
        Object obj2;
        String str11;
        String str12;
        String str13;
        String str14;
        Object obj3;
        String str15;
        String str16;
        int i2;
        String str17;
        String str18;
        String str19;
        Object obj4;
        String str20;
        String str21;
        Object obj5;
        String str22;
        String str23;
        String str24;
        int i3;
        int i4;
        String str25;
        String str26;
        HostelNewFragment hostelNewFragment2;
        int i5;
        String str27;
        String str28;
        HostelNewFragment this$0 = hostelNewFragment;
        Intrinsics.checkNotNullParameter(feeReceipt, "$feeReceipt");
        Intrinsics.checkNotNullParameter(feeCollection, "$feeCollection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        feeReceipt.clear();
        feeCollection.clear();
        this$0.hostelAdmission = hostelNewFragment.getAdapterAdmission().getItems();
        this$0.hostelMonthly = hostelNewFragment.getAdapterMonthly().getItems();
        int size = this$0.hostelAdmission.size();
        double d2 = 0.0d;
        for (int i6 = 0; i6 < size; i6++) {
            if (this$0.hostelAdmission.get(i6).is_selected()) {
                d2 += this$0.hostelAdmission.get(i6).getBalance();
            }
        }
        int size2 = this$0.hostelMonthly.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size2; i8++) {
            if (this$0.hostelMonthly.get(i8).is_selected()) {
                d2 += this$0.hostelMonthly.get(i8).getBalance();
                i7 += this$0.hostelMonthly.get(i8).getFine();
            }
        }
        int size3 = this$0.hostelAdmission.size();
        int i9 = 0;
        while (true) {
            i = i7;
            str = "Sub Total";
            str2 = "Fine";
            str3 = "HostelFeeReceipt[amount]";
            str4 = "HostelFeeReceipt[total_amount]";
            str5 = "HostelFeeReceipt[fine_amount]";
            str6 = "4";
            str7 = "][amount]";
            str8 = "payment";
            obj = "Total";
            str9 = "HostelFeeCollection[";
            if (i9 >= size3) {
                break;
            }
            int i10 = size3;
            if (this$0.hostelAdmission.get(i9).is_selected()) {
                ArrayList<HostelFee> payment = this$0.hostelAdmission.get(i9).getPayment();
                int size4 = payment.size();
                String str29 = "][";
                HashMap hashMap = feeReceipt;
                hashMap.put("payment", "1");
                hashMap.put("fee_group_type", "1");
                hashMap.put("Transaction[method]", "4");
                int parseInt = Integer.parseInt(payment.get(i9).getAmount()) - (payment.get(i9).getPayable() + payment.get(i9).getPaid());
                hashMap.put("HostelFeeReceipt[fine_amount]", String.valueOf(parseInt));
                hashMap.put("HostelFeeReceipt[total_amount]", String.valueOf(parseInt + d2));
                hashMap.put("HostelFeeReceipt[amount]", String.valueOf(d2));
                hashMap.put("fine_8", "0");
                int i11 = 0;
                while (i11 < size4) {
                    if (!Intrinsics.areEqual(payment.get(i11).getName(), "Fine") && !Intrinsics.areEqual(payment.get(i11).getName(), "Sub Total")) {
                        Object obj6 = obj;
                        if (Intrinsics.areEqual(payment.get(i11).getName(), obj6)) {
                            obj = obj6;
                        } else {
                            HashMap hashMap2 = feeCollection;
                            int installment = payment.get(i11).getInstallment();
                            String feegroup_id = payment.get(i11).getFeegroup_id();
                            String feehead_id = payment.get(i11).getFeehead_id();
                            int i12 = size4;
                            str28 = str9;
                            StringBuilder sb = new StringBuilder(str28);
                            sb.append(installment);
                            str27 = str29;
                            sb.append(str27);
                            sb.append(feegroup_id);
                            sb.append(str27);
                            sb.append(feehead_id);
                            String str30 = str7;
                            sb.append(str30);
                            hashMap2.put(sb.toString(), String.valueOf(payment.get(i11).getBalance()));
                            str7 = str30;
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][feegroup_id]", payment.get(i11).getFeegroup_id());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][feehead_id]", payment.get(i11).getFeehead_id());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][tenant_id]", payment.get(i11).getTenant_id());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][installment]", String.valueOf(payment.get(i11).getInstallment()));
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][user_id]", payment.get(i11).getUser_id());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][status]", String.valueOf(payment.get(i11).getStatus()));
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][hostel_id]", payment.get(i11).getHostel_id());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][month]", hostelNewFragment.hostelAdmission.get(i9).getM());
                            i5 = i12;
                            obj = obj6;
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][year]", hostelNewFragment.hostelAdmission.get(i9).getY());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][feeheadgroup_id]", payment.get(i11).getFeeheadgroup_id());
                            hashMap2.put(str28 + payment.get(i11).getInstallment() + str27 + payment.get(i11).getFeegroup_id() + str27 + payment.get(i11).getFeehead_id() + "][scholarship_amount]", String.valueOf(payment.get(i11).getAdjustment()));
                            i11++;
                            str29 = str27;
                            int i13 = i5;
                            str9 = str28;
                            size4 = i13;
                        }
                    }
                    str27 = str29;
                    String str31 = str9;
                    i5 = size4;
                    str28 = str31;
                    i11++;
                    str29 = str27;
                    int i132 = i5;
                    str9 = str28;
                    size4 = i132;
                }
                hostelNewFragment2 = hostelNewFragment;
            } else {
                hostelNewFragment2 = this$0;
            }
            i9++;
            this$0 = hostelNewFragment2;
            i7 = i;
            size3 = i10;
        }
        Object obj7 = "1";
        HostelNewFragment hostelNewFragment3 = this$0;
        String str32 = "][";
        Map<String, String> map = feeCollection;
        int size5 = hostelNewFragment3.hostelMonthly.size();
        int i14 = 0;
        while (i14 < size5) {
            int i15 = size5;
            if (hostelNewFragment3.hostelMonthly.get(i14).is_selected()) {
                ArrayList<HostelFee> payment2 = hostelNewFragment3.hostelMonthly.get(i14).getPayment();
                int size6 = payment2.size();
                String str33 = str;
                HashMap hashMap3 = feeReceipt;
                hashMap3.put(str8, obj7);
                hashMap3.put("Transaction[method]", str6);
                str10 = str8;
                hashMap3.put(str5, String.valueOf(i));
                str14 = str5;
                int i16 = i;
                str19 = str6;
                hashMap3.put(str4, String.valueOf(i16 + d2));
                hashMap3.put(str3, String.valueOf(d2));
                d = d2;
                hashMap3.put("fine_" + hostelNewFragment3.hostelMonthly.get(i14).getYear() + HelpFormatter.DEFAULT_OPT_PREFIX + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + "-01", String.valueOf(hostelNewFragment3.hostelMonthly.get(i14).getFine()));
                int i17 = 0;
                while (i17 < size6) {
                    if (Intrinsics.areEqual(payment2.get(i17).getName(), str2)) {
                        obj4 = obj7;
                        str20 = str2;
                        str21 = str3;
                        obj5 = obj;
                        str22 = str9;
                        str23 = str32;
                        str24 = str33;
                        i3 = size6;
                        i4 = i16;
                        str25 = str7;
                    } else {
                        String str34 = str33;
                        if (Intrinsics.areEqual(payment2.get(i17).getName(), str34)) {
                            i3 = size6;
                            obj4 = obj7;
                            str24 = str34;
                            str20 = str2;
                            str21 = str3;
                            obj5 = obj;
                            str22 = str9;
                            str23 = str32;
                            i4 = i16;
                        } else {
                            obj5 = obj;
                            if (Intrinsics.areEqual(payment2.get(i17).getName(), obj5)) {
                                i3 = size6;
                                i4 = i16;
                                obj4 = obj7;
                                str24 = str34;
                                str20 = str2;
                                str21 = str3;
                                str22 = str9;
                                str23 = str32;
                            } else {
                                HashMap hashMap4 = feeCollection;
                                i3 = size6;
                                int installment2 = payment2.get(i17).getInstallment();
                                i4 = i16;
                                String year = hostelNewFragment3.hostelMonthly.get(i14).getYear();
                                obj4 = obj7;
                                String month = hostelNewFragment3.hostelMonthly.get(i14).getMonth();
                                str24 = str34;
                                String feehead_id2 = payment2.get(i17).getFeehead_id();
                                str20 = str2;
                                str21 = str3;
                                str22 = str9;
                                StringBuilder sb2 = new StringBuilder(str22);
                                sb2.append(installment2);
                                str23 = str32;
                                sb2.append(str23);
                                sb2.append(year);
                                sb2.append(str23);
                                sb2.append(month);
                                sb2.append(str23);
                                sb2.append(feehead_id2);
                                String str35 = str7;
                                sb2.append(str35);
                                hashMap4.put(sb2.toString(), String.valueOf(payment2.get(i17).getBalance()));
                                str25 = str35;
                                str26 = str4;
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][feegroup_id]", payment2.get(i17).getFeegroup_id());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][feehead_id]", payment2.get(i17).getFeehead_id());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][feeheadgroup_id]", payment2.get(i17).getFeeheadgroup_id());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][tenant_id]", payment2.get(i17).getTenant_id());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][installment]", String.valueOf(payment2.get(i17).getInstallment()));
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][user_id]", payment2.get(i17).getUser_id());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][status]", String.valueOf(payment2.get(i17).getStatus()));
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][hostel_id]", payment2.get(i17).getHostel_id());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][month]", hostelNewFragment3.hostelMonthly.get(i14).getMonth());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][year]", hostelNewFragment3.hostelMonthly.get(i14).getYear());
                                hashMap4.put(str22 + payment2.get(i17).getInstallment() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getYear() + str23 + hostelNewFragment3.hostelMonthly.get(i14).getMonth() + str23 + payment2.get(i17).getFeehead_id() + "][scholarship_amount]", String.valueOf(payment2.get(i17).getAdjustment()));
                                i17++;
                                str32 = str23;
                                str4 = str26;
                                i16 = i4;
                                str7 = str25;
                                size6 = i3;
                                obj7 = obj4;
                                str2 = str20;
                                str33 = str24;
                                str9 = str22;
                                obj = obj5;
                                str3 = str21;
                            }
                        }
                        str25 = str7;
                    }
                    str26 = str4;
                    i17++;
                    str32 = str23;
                    str4 = str26;
                    i16 = i4;
                    str7 = str25;
                    size6 = i3;
                    obj7 = obj4;
                    str2 = str20;
                    str33 = str24;
                    str9 = str22;
                    obj = obj5;
                    str3 = str21;
                }
                map = feeCollection;
                obj2 = obj7;
                str12 = str2;
                str13 = str3;
                obj3 = obj;
                str15 = str9;
                str16 = str32;
                str11 = str33;
                i2 = i16;
                str17 = str7;
                str18 = str4;
            } else {
                d = d2;
                str10 = str8;
                obj2 = obj7;
                str11 = str;
                str12 = str2;
                str13 = str3;
                str14 = str5;
                obj3 = obj;
                str15 = str9;
                str16 = str32;
                i2 = i;
                str17 = str7;
                str18 = str4;
                str19 = str6;
            }
            i14++;
            str32 = str16;
            str6 = str19;
            str4 = str18;
            i = i2;
            str7 = str17;
            size5 = i15;
            str8 = str10;
            d2 = d;
            obj7 = obj2;
            str2 = str12;
            str = str11;
            str9 = str15;
            obj = obj3;
            str5 = str14;
            str3 = str13;
        }
        System.out.println(feeReceipt);
        System.out.println(map);
        hostelNewFragment.getHostelNewViewModel().getHostelPay(map, feeReceipt);
    }

    private final void listenAdmissionResponse() {
        getHostelNewViewModel().getAdmissionResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenAdmissionResponse$lambda$4(HostelNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAdmissionResponse$lambda$4(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewAdmissionResponse hostelNewAdmissionResponse = (HostelNewAdmissionResponse) resource.getData();
            if (hostelNewAdmissionResponse != null) {
                this$0.showBaseView();
                HostelNewAdmissionAdapter adapterAdmission = this$0.getAdapterAdmission();
                ArrayList<HostelNewAdmission> hostel = hostelNewAdmissionResponse.getHostel();
                Boolean bool = this$0.status;
                Intrinsics.checkNotNull(bool);
                adapterAdmission.addAdmsnItems(hostel, bool.booleanValue());
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenMonthlyResponse() {
        getHostelNewViewModel().getMonthlyResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenMonthlyResponse$lambda$6(HostelNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenMonthlyResponse$lambda$6(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewMonthlyResponse hostelNewMonthlyResponse = (HostelNewMonthlyResponse) resource.getData();
            if (hostelNewMonthlyResponse != null) {
                this$0.showBaseView();
                HostelNewMonthlyAdapter adapterMonthly = this$0.getAdapterMonthly();
                ArrayList<HostelNewMonthly> hostel = hostelNewMonthlyResponse.getHostel();
                Boolean bool = this$0.status;
                Intrinsics.checkNotNull(bool);
                adapterMonthly.addItems(hostel, bool.booleanValue());
                this$0.date = hostelNewMonthlyResponse.getDate();
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenHistoryResponse() {
        getHostelNewViewModel().getHistoryResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenHistoryResponse$lambda$8(HostelNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenHistoryResponse$lambda$8(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewHistoryResponse hostelNewHistoryResponse = (HostelNewHistoryResponse) resource.getData();
            if (hostelNewHistoryResponse != null) {
                this$0.showBaseView();
                this$0.getAdapterAdmissionHistory().addItems(hostelNewHistoryResponse.getAdmission_history());
                this$0.getAdapterMonthlyHistory().addItems(hostelNewHistoryResponse.getMonthly_history());
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenPayResponse() {
        getHostelNewViewModel().getHostelPayResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenPayResponse$lambda$10(HostelNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenPayResponse$lambda$10(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelNewPay hostelNewPay = (HostelNewPay) resource.getData();
            if (hostelNewPay != null) {
                this$0.showBaseView();
                System.out.println(hostelNewPay);
                FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                HostelNewConfirmDialog newInstance = HostelNewConfirmDialog.INSTANCE.newInstance(String.valueOf(this$0.subtotal), String.valueOf(this$0.fine), String.valueOf(hostelNewPay.getTotal_amount()), hostelNewPay.getUrl());
                newInstance.setCallBack(this$0);
                newInstance.show(childFragmentManager, (String) null);
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
        FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
        if (fragmentHostelNewBinding == null || (recyclerView = fragmentHostelNewBinding.rvMonthly) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenStatusResponse() {
        getHostelNewViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HostelNewFragment.listenStatusResponse$lambda$12(HostelNewFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenStatusResponse$lambda$12(HostelNewFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            HostelStatusNew hostelStatusNew = (HostelStatusNew) resource.getData();
            if (hostelStatusNew != null) {
                this$0.showBaseView();
                this$0.status = Boolean.valueOf(hostelStatusNew.getAllpayment());
                FragmentHostelNewBinding fragmentHostelNewBinding = this$0.get_binding();
                TextView textView = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.tvFeeEngnrTotal : null;
                if (textView != null) {
                    textView.setText(IdManager.DEFAULT_VERSION_NAME);
                }
                FragmentHostelNewBinding fragmentHostelNewBinding2 = this$0.get_binding();
                TextView textView2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.payFeeEngnrBtn : null;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                this$0.getHostelNewViewModel().getHostelAdmissionFee();
                this$0.getHostelNewViewModel().getHostelMonthlyFee();
                this$0.getHostelNewViewModel().getHostelHistory();
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
        FragmentHostelNewBinding fragmentHostelNewBinding3 = this$0.get_binding();
        if (fragmentHostelNewBinding3 == null || (recyclerView = fragmentHostelNewBinding3.rvMonthly) == null) {
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

    @Override // in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter.CallBack
    public void viewAdmissionBtnClicked(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelNewDetailsDialog newInstance = HostelNewDetailsDialog.INSTANCE.newInstance(position, 1);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter.CallBack
    public void viewMonthlyBtnClicked(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        HostelNewDetailsDialog newInstance = HostelNewDetailsDialog.INSTANCE.newInstance(position, 2);
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter.CallBack
    public void feeClickedAdmission() {
        Boolean bool = this.status;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            getAdapterMonthly().unCheckFees();
        }
        this.fine = 0;
        ArrayList<HostelNewAdmission> items = getAdapterAdmission().getItems();
        ArrayList<HostelNewMonthly> items2 = getAdapterMonthly().getItems();
        System.out.println(items);
        System.out.println(items2);
        int size = items.size();
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                d += items.get(i).getBalance() + items.get(i).getPayment().get(0).getFine();
                d2 += items.get(i).getBalance();
                Integer num = this.fine;
                Intrinsics.checkNotNull(num);
                this.fine = Integer.valueOf(num.intValue() + items.get(i).getPayment().get(0).getFine());
            }
        }
        int size2 = items2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (items2.get(i2).is_selected()) {
                d += items2.get(i2).getBalance() + items2.get(i2).getFine();
                Integer num2 = this.fine;
                Intrinsics.checkNotNull(num2);
                this.fine = Integer.valueOf(num2.intValue() + items2.get(i2).getFine());
                d2 += items2.get(i2).getBalance();
            }
        }
        this.subtotal = Integer.valueOf((int) d2);
        if (d > 0.0d) {
            FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
            TextView textView = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.payFeeEngnrBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
            TextView textView2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.payFeeEngnrBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        TextView textView3 = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.tvFeeEngnrTotal : null;
        if (textView3 == null) {
            return;
        }
        textView3.setText(String.valueOf(d));
    }

    @Override // in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter.CallBack
    public void feeClickedMonthly() {
        Boolean bool = this.status;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            getAdapterAdmission().unCheckFees();
        }
        this.fine = 0;
        ArrayList<HostelNewAdmission> items = getAdapterAdmission().getItems();
        ArrayList<HostelNewMonthly> items2 = getAdapterMonthly().getItems();
        System.out.println(items);
        System.out.println(items2);
        int size = items.size();
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i = 0; i < size; i++) {
            if (items.get(i).is_selected()) {
                d += items.get(i).getBalance() + items.get(i).getPayment().get(0).getFine();
                d2 += items.get(i).getBalance();
                Integer num = this.fine;
                Intrinsics.checkNotNull(num);
                this.fine = Integer.valueOf(num.intValue() + items.get(i).getPayment().get(0).getFine());
            }
        }
        int size2 = items2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (items2.get(i2).is_selected()) {
                d += items2.get(i2).getBalance() + items2.get(i2).getFine();
                Integer num2 = this.fine;
                Intrinsics.checkNotNull(num2);
                this.fine = Integer.valueOf(num2.intValue() + items2.get(i2).getFine());
                d2 += items2.get(i2).getBalance();
            }
        }
        this.subtotal = Integer.valueOf((int) d2);
        if (d > 0.0d) {
            FragmentHostelNewBinding fragmentHostelNewBinding = get_binding();
            TextView textView = fragmentHostelNewBinding != null ? fragmentHostelNewBinding.payFeeEngnrBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            FragmentHostelNewBinding fragmentHostelNewBinding2 = get_binding();
            TextView textView2 = fragmentHostelNewBinding2 != null ? fragmentHostelNewBinding2.payFeeEngnrBtn : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        FragmentHostelNewBinding fragmentHostelNewBinding3 = get_binding();
        TextView textView3 = fragmentHostelNewBinding3 != null ? fragmentHostelNewBinding3.tvFeeEngnrTotal : null;
        if (textView3 == null) {
            return;
        }
        textView3.setText(String.valueOf(d));
    }
}