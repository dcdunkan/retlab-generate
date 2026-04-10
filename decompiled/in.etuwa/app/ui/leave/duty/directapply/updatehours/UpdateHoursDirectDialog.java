package in.etuwa.app.ui.leave.duty.directapply.updatehours;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDate;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDateResponse;
import in.etuwa.app.databinding.DialogUpdateHoursBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyFragment;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.DateAdapter;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.HourAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class UpdateHoursDirectDialog extends BaseDialog implements HourAdapter.LeaveCallBack, DateAdapter.LeaveCallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogUpdateHoursBinding _binding;

    /* JADX INFO: renamed from: adapterDate$delegate, reason: from kotlin metadata */
    private final Lazy adapterDate;

    /* JADX INFO: renamed from: adapterHour$delegate, reason: from kotlin metadata */
    private final Lazy adapterHour;
    private String date;
    private ArrayList<DutyLeaveDate> datesd;
    private String id;
    private NewDutyLeaveListener listener;
    private int position;

    /* JADX INFO: renamed from: updateHoursDirectViewModel$delegate, reason: from kotlin metadata */
    private final Lazy updateHoursDirectViewModel;

    /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectDialog$NewDutyLeaveListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NewDutyLeaveListener {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHourView$lambda$7(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteDateView$lambda$3(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteHourView$lambda$5(DialogInterface dialogInterface, int i) {
    }

    @JvmStatic
    public static final UpdateHoursDirectDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public UpdateHoursDirectDialog() {
        final UpdateHoursDirectDialog updateHoursDirectDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return updateHoursDirectDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(updateHoursDirectDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.updateHoursDirectViewModel = FragmentViewModelLazyKt.createViewModelLazy(updateHoursDirectDialog, Reflection.getOrCreateKotlinClass(UpdateHoursDirectViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(UpdateHoursDirectViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final UpdateHoursDirectDialog updateHoursDirectDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapterDate = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DateAdapter>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.duty.directapply.updatehours.DateAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DateAdapter invoke() {
                ComponentCallbacks componentCallbacks = updateHoursDirectDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DateAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterHour = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<HourAdapter>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.duty.directapply.updatehours.HourAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HourAdapter invoke() {
                ComponentCallbacks componentCallbacks = updateHoursDirectDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HourAdapter.class), b4, b5);
            }
        });
        this.datesd = new ArrayList<>();
        this.date = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateHoursDirectViewModel getUpdateHoursDirectViewModel() {
        return (UpdateHoursDirectViewModel) this.updateHoursDirectViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogUpdateHoursBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DateAdapter getAdapterDate() {
        return (DateAdapter) this.adapterDate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HourAdapter getAdapterHour() {
        return (HourAdapter) this.adapterHour.getValue();
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UpdateHoursDirectDialog newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            UpdateHoursDirectDialog updateHoursDirectDialog = new UpdateHoursDirectDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            updateHoursDirectDialog.setArguments(bundle);
            return updateHoursDirectDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogUpdateHoursBinding.inflate(inflater, container, false);
        DialogUpdateHoursBinding dialogUpdateHoursBinding = get_binding();
        if (dialogUpdateHoursBinding != null) {
            dialogUpdateHoursBinding.setUpdateHoursDirectViewModel(getUpdateHoursDirectViewModel());
        }
        DialogUpdateHoursBinding dialogUpdateHoursBinding2 = get_binding();
        if (dialogUpdateHoursBinding2 != null) {
            dialogUpdateHoursBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogUpdateHoursBinding dialogUpdateHoursBinding3 = get_binding();
        if (dialogUpdateHoursBinding3 != null) {
            return dialogUpdateHoursBinding3.getRoot();
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
        TextView textView;
        DialogUpdateHoursBinding dialogUpdateHoursBinding = get_binding();
        RecyclerView recyclerView = dialogUpdateHoursBinding != null ? dialogUpdateHoursBinding.rvHours : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapterHour());
        }
        DialogUpdateHoursBinding dialogUpdateHoursBinding2 = get_binding();
        RecyclerView recyclerView2 = dialogUpdateHoursBinding2 != null ? dialogUpdateHoursBinding2.rvDates : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterDate());
        }
        getAdapterHour().setHourCallBack(this);
        getAdapterDate().setDatesCallBack(this);
        listenResponse();
        listenRemoveResponse();
        listenAddResponse();
        UpdateHoursDirectViewModel updateHoursDirectViewModel = getUpdateHoursDirectViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        updateHoursDirectViewModel.getDates(str);
        listenHoursResponse();
        listenRemoveDateResponse();
        DialogUpdateHoursBinding dialogUpdateHoursBinding3 = get_binding();
        if (dialogUpdateHoursBinding3 == null || (textView = dialogUpdateHoursBinding3.deleteBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpdateHoursDirectDialog.setUp$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(UpdateHoursDirectDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteDateView();
    }

    private final void listenResponse() {
        getUpdateHoursDirectViewModel().getResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DutyLeaveDateResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DutyLeaveDateResponse> resource) {
                invoke2((Resource<DutyLeaveDateResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DutyLeaveDateResponse> resource) {
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        UpdateHoursDirectDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        UpdateHoursDirectDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    UpdateHoursDirectDialog.this.hideProgress();
                    DialogUpdateHoursBinding dialogUpdateHoursBinding = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding == null || (recyclerView = dialogUpdateHoursBinding.rvHours) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                UpdateHoursDirectDialog.this.hideProgress();
                DutyLeaveDateResponse data = resource.getData();
                if (data != null) {
                    UpdateHoursDirectDialog updateHoursDirectDialog = UpdateHoursDirectDialog.this;
                    try {
                        updateHoursDirectDialog.getAdapterDate().addItems(data.getData());
                        updateHoursDirectDialog.datesd = data.getData();
                        if (data.getData().size() == 1) {
                            DialogUpdateHoursBinding dialogUpdateHoursBinding2 = updateHoursDirectDialog.get_binding();
                            RecyclerView recyclerView2 = dialogUpdateHoursBinding2 != null ? dialogUpdateHoursBinding2.rvDates : null;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                        }
                        UpdateHoursDirectViewModel updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                        String str = updateHoursDirectDialog.id;
                        Intrinsics.checkNotNull(str);
                        updateHoursDirectViewModel.getHours(str);
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenHoursResponse() {
        getUpdateHoursDirectViewModel().getHourResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DutyLeaveDateResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog.listenHoursResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenHoursResponse$1$WhenMappings */
            /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DutyLeaveDateResponse> resource) {
                invoke2((Resource<DutyLeaveDateResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DutyLeaveDateResponse> resource) {
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        UpdateHoursDirectDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        UpdateHoursDirectDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    UpdateHoursDirectDialog.this.hideProgress();
                    DialogUpdateHoursBinding dialogUpdateHoursBinding = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding == null || (recyclerView = dialogUpdateHoursBinding.rvHours) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                UpdateHoursDirectDialog.this.hideProgress();
                DutyLeaveDateResponse data = resource.getData();
                if (data != null) {
                    UpdateHoursDirectDialog updateHoursDirectDialog = UpdateHoursDirectDialog.this;
                    try {
                        if (data.getData().size() > 0) {
                            updateHoursDirectDialog.getAdapterHour().addItems(data.getData().get(updateHoursDirectDialog.getPosition()).getHours());
                            DialogUpdateHoursBinding dialogUpdateHoursBinding2 = updateHoursDirectDialog.get_binding();
                            TextView textView = dialogUpdateHoursBinding2 != null ? dialogUpdateHoursBinding2.tvDate : null;
                            if (textView != null) {
                                textView.setText("Date - " + data.getData().get(updateHoursDirectDialog.getPosition()).getDate());
                            }
                            updateHoursDirectDialog.setDate(data.getData().get(updateHoursDirectDialog.getPosition()).getDate());
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenAddResponse() {
        getUpdateHoursDirectViewModel().getAddResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog.listenAddResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenAddResponse$1$WhenMappings */
            /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                RecyclerView rvHours;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        UpdateHoursDirectDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        UpdateHoursDirectDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    UpdateHoursDirectDialog.this.hideProgress();
                    DialogUpdateHoursBinding dialogUpdateHoursBinding = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding == null || (recyclerView = dialogUpdateHoursBinding.rvHours) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                UpdateHoursDirectDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    UpdateHoursDirectDialog updateHoursDirectDialog = UpdateHoursDirectDialog.this;
                    try {
                        if (data.getSuccess()) {
                            DialogUpdateHoursBinding dialogUpdateHoursBinding2 = updateHoursDirectDialog.get_binding();
                            if (dialogUpdateHoursBinding2 != null && (rvHours = dialogUpdateHoursBinding2.rvHours) != null) {
                                Intrinsics.checkNotNullExpressionValue(rvHours, "rvHours");
                                ToastExtKt.showSuccessToast(rvHours, data.getMessage());
                            }
                            UpdateHoursDirectViewModel updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                            String str = updateHoursDirectDialog.id;
                            Intrinsics.checkNotNull(str);
                            updateHoursDirectViewModel.getHours(str);
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenRemoveResponse() {
        getUpdateHoursDirectViewModel().getRemoveResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog.listenRemoveResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenRemoveResponse$1$WhenMappings */
            /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                RecyclerView rvHours;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        UpdateHoursDirectDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        UpdateHoursDirectDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    UpdateHoursDirectDialog.this.hideProgress();
                    DialogUpdateHoursBinding dialogUpdateHoursBinding = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding == null || (recyclerView = dialogUpdateHoursBinding.rvHours) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                UpdateHoursDirectDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    UpdateHoursDirectDialog updateHoursDirectDialog = UpdateHoursDirectDialog.this;
                    try {
                        if (data.getSuccess()) {
                            DialogUpdateHoursBinding dialogUpdateHoursBinding2 = updateHoursDirectDialog.get_binding();
                            if (dialogUpdateHoursBinding2 != null && (rvHours = dialogUpdateHoursBinding2.rvHours) != null) {
                                Intrinsics.checkNotNullExpressionValue(rvHours, "rvHours");
                                ToastExtKt.showSuccessToast(rvHours, data.getMessage());
                            }
                            UpdateHoursDirectViewModel updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                            String str = updateHoursDirectDialog.id;
                            Intrinsics.checkNotNull(str);
                            updateHoursDirectViewModel.getHours(str);
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenRemoveDateResponse() {
        getUpdateHoursDirectViewModel().getRemoveDateResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog.listenRemoveDateResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenRemoveDateResponse$1$WhenMappings */
            /* JADX INFO: compiled from: UpdateHoursDirectDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                RecyclerView rvHours;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        UpdateHoursDirectDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        UpdateHoursDirectDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    UpdateHoursDirectDialog.this.hideProgress();
                    DialogUpdateHoursBinding dialogUpdateHoursBinding = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding == null || (recyclerView = dialogUpdateHoursBinding.rvHours) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(recyclerView, message);
                    return;
                }
                UpdateHoursDirectDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    UpdateHoursDirectDialog updateHoursDirectDialog = UpdateHoursDirectDialog.this;
                    try {
                        if (data.getSuccess()) {
                            DialogUpdateHoursBinding dialogUpdateHoursBinding2 = updateHoursDirectDialog.get_binding();
                            if (dialogUpdateHoursBinding2 != null && (rvHours = dialogUpdateHoursBinding2.rvHours) != null) {
                                Intrinsics.checkNotNullExpressionValue(rvHours, "rvHours");
                                ToastExtKt.showSuccessToast(rvHours, data.getMessage());
                            }
                            UpdateHoursDirectViewModel updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                            String str = updateHoursDirectDialog.id;
                            Intrinsics.checkNotNull(str);
                            updateHoursDirectViewModel.getHours(str);
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    public final void setCallBack(DirectApplyFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
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

    @Override // in.etuwa.app.ui.leave.duty.directapply.updatehours.HourAdapter.LeaveCallBack
    public void onHourClick(boolean flag, String hour) {
        Intrinsics.checkNotNullParameter(hour, "hour");
        if (flag) {
            addHourView(hour);
        } else {
            deleteHourView(hour);
        }
    }

    @Override // in.etuwa.app.ui.leave.duty.directapply.updatehours.DateAdapter.LeaveCallBack
    public void onDateClick(int position) {
        this.position = position;
        int size = this.datesd.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (position == i) {
                    this.datesd.get(i).setSelected(true);
                } else {
                    this.datesd.get(i).setSelected(false);
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        getAdapterDate().addItems(this.datesd);
        getAdapterHour().addItems(this.datesd.get(position).getHours());
        DialogUpdateHoursBinding dialogUpdateHoursBinding = get_binding();
        TextView textView = dialogUpdateHoursBinding != null ? dialogUpdateHoursBinding.tvDate : null;
        if (textView != null) {
            textView.setText("Date - " + this.datesd.get(position).getDate());
        }
        this.date = this.datesd.get(position).getDate();
    }

    private final void deleteDateView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Remove this date and all hours ?");
        builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateHoursDirectDialog.deleteDateView$lambda$2(this.f$0, dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateHoursDirectDialog.deleteDateView$lambda$3(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteDateView$lambda$2(UpdateHoursDirectDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpdateHoursDirectViewModel updateHoursDirectViewModel = this$0.getUpdateHoursDirectViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        updateHoursDirectViewModel.removeDateHour(str, this$0.date);
    }

    private final void deleteHourView(final String hour) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Remove this hour ?");
        builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateHoursDirectDialog.deleteHourView$lambda$4(this.f$0, hour, dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateHoursDirectDialog.deleteHourView$lambda$5(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteHourView$lambda$4(UpdateHoursDirectDialog this$0, String hour, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hour, "$hour");
        UpdateHoursDirectViewModel updateHoursDirectViewModel = this$0.getUpdateHoursDirectViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        updateHoursDirectViewModel.removeHour(str, this$0.date, hour);
    }

    private final void addHourView(final String hour) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Add this hour ?");
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateHoursDirectDialog.addHourView$lambda$6(this.f$0, hour, dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateHoursDirectDialog.addHourView$lambda$7(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHourView$lambda$6(UpdateHoursDirectDialog this$0, String hour, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hour, "$hour");
        UpdateHoursDirectViewModel updateHoursDirectViewModel = this$0.getUpdateHoursDirectViewModel();
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        updateHoursDirectViewModel.addHour(str, this$0.date, hour);
    }
}