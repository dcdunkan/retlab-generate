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

/* compiled from: UpdateHoursDirectDialog.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002MNB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016H\u0002J\b\u0010/\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020-H\u0014J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020-H\u0002J\b\u00105\u001a\u00020-H\u0002J\b\u00106\u001a\u00020-H\u0003J\u0012\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u000109H\u0016J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u0010!\u001a\u00020\"H\u0017J\b\u0010A\u001a\u00020-H\u0016J\b\u0010B\u001a\u00020-H\u0016J\u0018\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020E2\u0006\u0010.\u001a\u00020\u0016H\u0016J\u001a\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020;2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u000e\u0010H\u001a\u00020-2\u0006\u0010I\u001a\u00020JJ\b\u0010K\u001a\u00020-H\u0015J\b\u0010L\u001a\u00020-H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b)\u0010*¨\u0006O"}, d2 = {"Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/HourAdapter$LeaveCallBack;", "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/DateAdapter$LeaveCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogUpdateHoursBinding;", "adapterDate", "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/DateAdapter;", "getAdapterDate", "()Lin/etuwa/app/ui/leave/duty/directapply/updatehours/DateAdapter;", "adapterDate$delegate", "Lkotlin/Lazy;", "adapterHour", "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/HourAdapter;", "getAdapterHour", "()Lin/etuwa/app/ui/leave/duty/directapply/updatehours/HourAdapter;", "adapterHour$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogUpdateHoursBinding;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "datesd", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveDate;", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectDialog$NewDutyLeaveListener;", CommonCssConstants.POSITION, "", "getPosition", "()I", "setPosition", "(I)V", "updateHoursDirectViewModel", "Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectViewModel;", "getUpdateHoursDirectViewModel", "()Lin/etuwa/app/ui/leave/duty/directapply/updatehours/UpdateHoursDirectViewModel;", "updateHoursDirectViewModel$delegate", "addHourView", "", "hour", "deleteDateView", "deleteHourView", "hideProgress", "listenAddResponse", "listenHoursResponse", "listenRemoveDateResponse", "listenRemoveResponse", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDateClick", "onDestroy", "onDetach", "onHourClick", "flag", "", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/leave/duty/directapply/DirectApplyFragment;", "setUp", "showProgress", "Companion", "NewDutyLeaveListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateHoursDirectDialog extends BaseDialog implements HourAdapter.LeaveCallBack, DateAdapter.LeaveCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogUpdateHoursBinding _binding;

    /* renamed from: adapterDate$delegate, reason: from kotlin metadata */
    private final Lazy adapterDate;

    /* renamed from: adapterHour$delegate, reason: from kotlin metadata */
    private final Lazy adapterHour;
    private String date;
    private ArrayList<DutyLeaveDate> datesd;
    private String id;
    private NewDutyLeaveListener listener;
    private int position;

    /* renamed from: updateHoursDirectViewModel$delegate, reason: from kotlin metadata */
    private final Lazy updateHoursDirectViewModel;

    /* compiled from: UpdateHoursDirectDialog.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(UpdateHoursDirectViewModel.class), qualifier, b, null, koinScope);
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
    /* renamed from: getBinding, reason: from getter */
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

    /* compiled from: UpdateHoursDirectDialog.kt */
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
                UpdateHoursDirectDialog.setUp$lambda$1(UpdateHoursDirectDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(UpdateHoursDirectDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteDateView();
    }

    private final void listenResponse() {
        getUpdateHoursDirectViewModel().getResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DutyLeaveDateResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenResponse$1

            /* compiled from: UpdateHoursDirectDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DutyLeaveDateResponse> resource) {
                DateAdapter adapterDate;
                UpdateHoursDirectViewModel updateHoursDirectViewModel;
                String str;
                DialogUpdateHoursBinding dialogUpdateHoursBinding;
                DialogUpdateHoursBinding dialogUpdateHoursBinding2;
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
                    dialogUpdateHoursBinding2 = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding2 == null || (recyclerView = dialogUpdateHoursBinding2.rvHours) == null) {
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
                        adapterDate = updateHoursDirectDialog.getAdapterDate();
                        adapterDate.addItems(data.getData());
                        updateHoursDirectDialog.datesd = data.getData();
                        if (data.getData().size() == 1) {
                            dialogUpdateHoursBinding = updateHoursDirectDialog.get_binding();
                            RecyclerView recyclerView2 = dialogUpdateHoursBinding != null ? dialogUpdateHoursBinding.rvDates : null;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                        }
                        updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                        str = updateHoursDirectDialog.id;
                        Intrinsics.checkNotNull(str);
                        updateHoursDirectViewModel.getHours(str);
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }));
    }

    private final void listenHoursResponse() {
        getUpdateHoursDirectViewModel().getHourResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DutyLeaveDateResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenHoursResponse$1

            /* compiled from: UpdateHoursDirectDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DutyLeaveDateResponse> resource) {
                HourAdapter adapterHour;
                DialogUpdateHoursBinding dialogUpdateHoursBinding;
                DialogUpdateHoursBinding dialogUpdateHoursBinding2;
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
                    dialogUpdateHoursBinding2 = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding2 == null || (recyclerView = dialogUpdateHoursBinding2.rvHours) == null) {
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
                            adapterHour = updateHoursDirectDialog.getAdapterHour();
                            adapterHour.addItems(data.getData().get(updateHoursDirectDialog.getPosition()).getHours());
                            dialogUpdateHoursBinding = updateHoursDirectDialog.get_binding();
                            TextView textView = dialogUpdateHoursBinding != null ? dialogUpdateHoursBinding.tvDate : null;
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
        getUpdateHoursDirectViewModel().getAddResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenAddResponse$1

            /* compiled from: UpdateHoursDirectDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogUpdateHoursBinding dialogUpdateHoursBinding;
                UpdateHoursDirectViewModel updateHoursDirectViewModel;
                String str;
                RecyclerView rvHours;
                DialogUpdateHoursBinding dialogUpdateHoursBinding2;
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
                    dialogUpdateHoursBinding2 = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding2 == null || (recyclerView = dialogUpdateHoursBinding2.rvHours) == null) {
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
                            dialogUpdateHoursBinding = updateHoursDirectDialog.get_binding();
                            if (dialogUpdateHoursBinding != null && (rvHours = dialogUpdateHoursBinding.rvHours) != null) {
                                Intrinsics.checkNotNullExpressionValue(rvHours, "rvHours");
                                ToastExtKt.showSuccessToast(rvHours, data.getMessage());
                            }
                            updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                            str = updateHoursDirectDialog.id;
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
        getUpdateHoursDirectViewModel().getRemoveResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenRemoveResponse$1

            /* compiled from: UpdateHoursDirectDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogUpdateHoursBinding dialogUpdateHoursBinding;
                UpdateHoursDirectViewModel updateHoursDirectViewModel;
                String str;
                RecyclerView rvHours;
                DialogUpdateHoursBinding dialogUpdateHoursBinding2;
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
                    dialogUpdateHoursBinding2 = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding2 == null || (recyclerView = dialogUpdateHoursBinding2.rvHours) == null) {
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
                            dialogUpdateHoursBinding = updateHoursDirectDialog.get_binding();
                            if (dialogUpdateHoursBinding != null && (rvHours = dialogUpdateHoursBinding.rvHours) != null) {
                                Intrinsics.checkNotNullExpressionValue(rvHours, "rvHours");
                                ToastExtKt.showSuccessToast(rvHours, data.getMessage());
                            }
                            updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                            str = updateHoursDirectDialog.id;
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
        getUpdateHoursDirectViewModel().getRemoveDateResponse().observe(getViewLifecycleOwner(), new UpdateHoursDirectDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectDialog$listenRemoveDateResponse$1

            /* compiled from: UpdateHoursDirectDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogUpdateHoursBinding dialogUpdateHoursBinding;
                UpdateHoursDirectViewModel updateHoursDirectViewModel;
                String str;
                RecyclerView rvHours;
                DialogUpdateHoursBinding dialogUpdateHoursBinding2;
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
                    dialogUpdateHoursBinding2 = UpdateHoursDirectDialog.this.get_binding();
                    if (dialogUpdateHoursBinding2 == null || (recyclerView = dialogUpdateHoursBinding2.rvHours) == null) {
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
                            dialogUpdateHoursBinding = updateHoursDirectDialog.get_binding();
                            if (dialogUpdateHoursBinding != null && (rvHours = dialogUpdateHoursBinding.rvHours) != null) {
                                Intrinsics.checkNotNullExpressionValue(rvHours, "rvHours");
                                ToastExtKt.showSuccessToast(rvHours, data.getMessage());
                            }
                            updateHoursDirectViewModel = updateHoursDirectDialog.getUpdateHoursDirectViewModel();
                            str = updateHoursDirectDialog.id;
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
                UpdateHoursDirectDialog.deleteDateView$lambda$2(UpdateHoursDirectDialog.this, dialogInterface, i);
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
                UpdateHoursDirectDialog.deleteHourView$lambda$4(UpdateHoursDirectDialog.this, hour, dialogInterface, i);
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
                UpdateHoursDirectDialog.addHourView$lambda$6(UpdateHoursDirectDialog.this, hour, dialogInterface, i);
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