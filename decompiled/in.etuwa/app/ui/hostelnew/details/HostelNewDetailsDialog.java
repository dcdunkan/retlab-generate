package in.etuwa.app.ui.hostelnew.details;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmission;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmissionResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthly;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthlyResponse;
import in.etuwa.app.databinding.DialogHostelNewDetailsBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostelnew.HostelNewFragment;
import in.etuwa.app.ui.hostelnew.details.HostelNewDetailsAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: HostelNewDetailsDialog.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0002<=B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020'H\u0016J\b\u00104\u001a\u00020'H\u0016J\u001a\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020'H\u0014J\b\u0010;\u001a\u00020'H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!¨\u0006>"}, d2 = {"Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogHostelNewDetailsBinding;", "adapter", "Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsAdapter;", "getAdapter", "()Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogHostelNewDetailsBinding;", "hostelNewDetailsViewModel", "Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsViewModel;", "getHostelNewDetailsViewModel", "()Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsViewModel;", "hostelNewDetailsViewModel$delegate", "installmentHead", "", "getInstallmentHead", "()Ljava/lang/String;", "setInstallmentHead", "(Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsDialog$FeeDetailListner;", "pos", "", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "type", "getType", "setType", "hideProgress", "", "listenResponse", "listenResponse2", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/hostelnew/HostelNewFragment;", "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelNewDetailsDialog extends BaseDialog implements HostelNewDetailsAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogHostelNewDetailsBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: hostelNewDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelNewDetailsViewModel;
    private String installmentHead;
    private FeeDetailListner listener;
    private Integer pos;
    private Integer type;

    /* compiled from: HostelNewDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsDialog$FeeDetailListner;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
    }

    @JvmStatic
    public static final HostelNewDetailsDialog newInstance(int i, int i2) {
        return INSTANCE.newInstance(i, i2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public HostelNewDetailsDialog() {
        final HostelNewDetailsDialog hostelNewDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelNewDetailsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelNewDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelNewDetailsDialog, Reflection.getOrCreateKotlinClass(HostelNewDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelNewDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelNewDetailsDialog hostelNewDetailsDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelNewDetailsAdapter>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostelnew.details.HostelNewDetailsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelNewDetailsAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelNewDetailsDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelNewDetailsAdapter.class), b2, b3);
            }
        });
    }

    private final HostelNewDetailsViewModel getHostelNewDetailsViewModel() {
        return (HostelNewDetailsViewModel) this.hostelNewDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HostelNewDetailsAdapter getAdapter() {
        return (HostelNewDetailsAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogHostelNewDetailsBinding get_binding() {
        return this._binding;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final void setPos(Integer num) {
        this.pos = num;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final String getInstallmentHead() {
        return this.installmentHead;
    }

    public final void setInstallmentHead(String str) {
        this.installmentHead = str;
    }

    /* compiled from: HostelNewDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostelnew/details/HostelNewDetailsDialog;", CommonCssConstants.POSITION, "", "type", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelNewDetailsDialog newInstance(int position, int type) {
            HostelNewDetailsDialog hostelNewDetailsDialog = new HostelNewDetailsDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("cat", position);
            bundle.putInt("type", type);
            hostelNewDetailsDialog.setArguments(bundle);
            return hostelNewDetailsDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt("cat"));
            this.type = Integer.valueOf(arguments.getInt("type"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogHostelNewDetailsBinding.inflate(inflater, container, false);
        DialogHostelNewDetailsBinding dialogHostelNewDetailsBinding = get_binding();
        if (dialogHostelNewDetailsBinding != null) {
            dialogHostelNewDetailsBinding.setHostelNewDetailsViewModel(getHostelNewDetailsViewModel());
        }
        DialogHostelNewDetailsBinding dialogHostelNewDetailsBinding2 = get_binding();
        if (dialogHostelNewDetailsBinding2 != null) {
            dialogHostelNewDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogHostelNewDetailsBinding dialogHostelNewDetailsBinding3 = get_binding();
        if (dialogHostelNewDetailsBinding3 != null) {
            return dialogHostelNewDetailsBinding3.getRoot();
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
        System.out.println((Object) "=====================");
        System.out.println(this.pos);
        DialogHostelNewDetailsBinding dialogHostelNewDetailsBinding = get_binding();
        RecyclerView recyclerView = dialogHostelNewDetailsBinding != null ? dialogHostelNewDetailsBinding.rvHostelFeeDetails : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        Integer num = this.type;
        if (num != null && num.intValue() == 2) {
            getHostelNewDetailsViewModel().getHostelMonthlyFee();
        } else {
            Integer num2 = this.type;
            if (num2 != null && num2.intValue() == 1) {
                getHostelNewDetailsViewModel().getHostelAdmissionFee();
            }
        }
        listenResponse();
        listenResponse2();
    }

    private final void listenResponse() {
        getHostelNewDetailsViewModel().getAdmissionResponse().observe(getViewLifecycleOwner(), new HostelNewDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelNewAdmissionResponse>, Unit>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog$listenResponse$1

            /* compiled from: HostelNewDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelNewAdmissionResponse> resource) {
                invoke2((Resource<HostelNewAdmissionResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelNewAdmissionResponse> resource) {
                HostelNewDetailsAdapter adapter;
                DialogHostelNewDetailsBinding dialogHostelNewDetailsBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelNewDetailsDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        HostelNewDetailsDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        HostelNewDetailsDialog.this.hideProgress();
                        return;
                    }
                }
                HostelNewDetailsDialog.this.hideProgress();
                HostelNewAdmissionResponse data = resource.getData();
                if (data != null) {
                    HostelNewDetailsDialog hostelNewDetailsDialog = HostelNewDetailsDialog.this;
                    try {
                        adapter = hostelNewDetailsDialog.getAdapter();
                        ArrayList<HostelNewAdmission> hostel = data.getHostel();
                        Integer pos = hostelNewDetailsDialog.getPos();
                        Intrinsics.checkNotNull(pos);
                        adapter.addItems(hostel.get(pos.intValue()).getPayment());
                        dialogHostelNewDetailsBinding = hostelNewDetailsDialog.get_binding();
                        TextView textView = dialogHostelNewDetailsBinding != null ? dialogHostelNewDetailsBinding.installmentHead : null;
                        if (textView == null) {
                            return;
                        }
                        ArrayList<HostelNewAdmission> hostel2 = data.getHostel();
                        Integer pos2 = hostelNewDetailsDialog.getPos();
                        Intrinsics.checkNotNull(pos2);
                        textView.setText(hostel2.get(pos2.intValue()).getInstallment());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenResponse2() {
        getHostelNewDetailsViewModel().getMonthlyResponse().observe(getViewLifecycleOwner(), new HostelNewDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelNewMonthlyResponse>, Unit>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsDialog$listenResponse2$1

            /* compiled from: HostelNewDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelNewMonthlyResponse> resource) {
                invoke2((Resource<HostelNewMonthlyResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelNewMonthlyResponse> resource) {
                HostelNewDetailsAdapter adapter;
                DialogHostelNewDetailsBinding dialogHostelNewDetailsBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        HostelNewDetailsDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        HostelNewDetailsDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        HostelNewDetailsDialog.this.hideProgress();
                        return;
                    }
                }
                HostelNewDetailsDialog.this.hideProgress();
                HostelNewMonthlyResponse data = resource.getData();
                if (data != null) {
                    HostelNewDetailsDialog hostelNewDetailsDialog = HostelNewDetailsDialog.this;
                    try {
                        adapter = hostelNewDetailsDialog.getAdapter();
                        ArrayList<HostelNewMonthly> hostel = data.getHostel();
                        Integer pos = hostelNewDetailsDialog.getPos();
                        Intrinsics.checkNotNull(pos);
                        adapter.addItems(hostel.get(pos.intValue()).getPayment());
                        dialogHostelNewDetailsBinding = hostelNewDetailsDialog.get_binding();
                        TextView textView = dialogHostelNewDetailsBinding != null ? dialogHostelNewDetailsBinding.installmentHead : null;
                        if (textView == null) {
                            return;
                        }
                        ArrayList<HostelNewMonthly> hostel2 = data.getHostel();
                        Integer pos2 = hostelNewDetailsDialog.getPos();
                        Intrinsics.checkNotNull(pos2);
                        textView.setText(hostel2.get(pos2.intValue()).getInstallment());
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    public final void setCallBack(HostelNewFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}