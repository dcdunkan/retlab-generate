package in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
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
import in.etuwa.app.data.model.dash.daywisetimetaable.DayWiseResponse;
import in.etuwa.app.databinding.DialogSubjectPlanBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogKt;
import in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableFragment;
import in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanAdapter;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: SubjectPlanDialog.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002DEB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00109\u001a\u00020+H\u0016J\b\u0010:\u001a\u00020+H\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0016J\u001a\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u000e\u0010@\u001a\u00020+2\u0006\u0010.\u001a\u00020AJ\b\u0010B\u001a\u00020+H\u0015J\b\u0010C\u001a\u00020+H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(¨\u0006F"}, d2 = {"Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogSubjectPlanBinding;", "adapter", "Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanAdapter;", "getAdapter", "()Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogSubjectPlanBinding;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "hour", "", "getHour", "()Ljava/lang/Integer;", "setHour", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanDialog$StoreListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", CommonCssConstants.POSITION, "getPosition", "()I", "setPosition", "(I)V", "subjectPlanViewModel", "Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanViewModel;", "getSubjectPlanViewModel", "()Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanViewModel;", "subjectPlanViewModel$delegate", "hideProgress", "", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/dashboard/daywisetimetable/DayWiseTimeTableFragment;", "setUp", "showProgress", "Companion", "StoreListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubjectPlanDialog extends BaseDialog implements SubjectPlanAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogSubjectPlanBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String date;
    private Integer hour;
    private StoreListener listener;
    private MainCallBackListener listener2;
    private int position;

    /* renamed from: subjectPlanViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subjectPlanViewModel;

    /* compiled from: SubjectPlanDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanDialog$StoreListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StoreListener {
        void dismiss();
    }

    @JvmStatic
    public static final SubjectPlanDialog newInstance(int i, String str, int i2) {
        return INSTANCE.newInstance(i, str, i2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public SubjectPlanDialog() {
        final SubjectPlanDialog subjectPlanDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(subjectPlanDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.subjectPlanViewModel = FragmentViewModelLazyKt.createViewModelLazy(subjectPlanDialog, Reflection.getOrCreateKotlinClass(SubjectPlanViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SubjectPlanViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.date = "";
        final SubjectPlanDialog subjectPlanDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SubjectPlanAdapter>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SubjectPlanAdapter invoke() {
                ComponentCallbacks componentCallbacks = subjectPlanDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SubjectPlanAdapter.class), b2, b3);
            }
        });
    }

    private final SubjectPlanViewModel getSubjectPlanViewModel() {
        return (SubjectPlanViewModel) this.subjectPlanViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogSubjectPlanBinding get_binding() {
        return this._binding;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final Integer getHour() {
        return this.hour;
    }

    public final void setHour(Integer num) {
        this.hour = num;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubjectPlanAdapter getAdapter() {
        return (SubjectPlanAdapter) this.adapter.getValue();
    }

    /* compiled from: SubjectPlanDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/dashboard/daywisetimetable/subjectplan/SubjectPlanDialog;", CommonCssConstants.POSITION, "", "date", "", "hour", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubjectPlanDialog newInstance(int position, String date, int hour) {
            Intrinsics.checkNotNullParameter(date, "date");
            SubjectPlanDialog subjectPlanDialog = new SubjectPlanDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(CommentReplyDialogKt.ARG_NAME, position);
            bundle.putString("date", date);
            bundle.putInt(AttendanceDayDialogKt.ARG_SEM, hour);
            subjectPlanDialog.setArguments(bundle);
            return subjectPlanDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = arguments.getInt(CommentReplyDialogKt.ARG_NAME);
            String string = arguments.getString("date");
            Intrinsics.checkNotNull(string);
            this.date = string;
            this.hour = Integer.valueOf(arguments.getInt(AttendanceDayDialogKt.ARG_SEM));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogSubjectPlanBinding.inflate(inflater, container, false);
        DialogSubjectPlanBinding dialogSubjectPlanBinding = get_binding();
        if (dialogSubjectPlanBinding != null) {
            dialogSubjectPlanBinding.setSubjectPlanViewModel(getSubjectPlanViewModel());
        }
        DialogSubjectPlanBinding dialogSubjectPlanBinding2 = get_binding();
        if (dialogSubjectPlanBinding2 != null) {
            dialogSubjectPlanBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogSubjectPlanBinding dialogSubjectPlanBinding3 = get_binding();
        if (dialogSubjectPlanBinding3 != null) {
            return dialogSubjectPlanBinding3.getRoot();
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
        DialogSubjectPlanBinding dialogSubjectPlanBinding = get_binding();
        TextView textView = dialogSubjectPlanBinding != null ? dialogSubjectPlanBinding.dateTv : null;
        if (textView != null) {
            textView.setText(this.date + " ( Hour " + this.hour + " )");
        }
        DialogSubjectPlanBinding dialogSubjectPlanBinding2 = get_binding();
        RecyclerView recyclerView = dialogSubjectPlanBinding2 != null ? dialogSubjectPlanBinding2.rvSubjectPlan : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getSubjectPlanViewModel().getTableData(this.date);
        listenResponse();
    }

    private final void listenResponse() {
        getSubjectPlanViewModel().getTimeTableResponse().observe(getViewLifecycleOwner(), new SubjectPlanDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DayWiseResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog$listenResponse$1

            /* compiled from: SubjectPlanDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends DayWiseResponse> resource) {
                invoke2((Resource<DayWiseResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DayWiseResponse> resource) {
                SubjectPlanAdapter adapter;
                DialogSubjectPlanBinding dialogSubjectPlanBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    SubjectPlanDialog.this.hideProgress();
                    DayWiseResponse data = resource.getData();
                    if (data != null) {
                        SubjectPlanDialog subjectPlanDialog = SubjectPlanDialog.this;
                        adapter = subjectPlanDialog.getAdapter();
                        adapter.addItems(data.getTimetable().get(0).getSub().get(subjectPlanDialog.getPosition()).getTopic_name());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    SubjectPlanDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    SubjectPlanDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                SubjectPlanDialog.this.hideProgress();
                dialogSubjectPlanBinding = SubjectPlanDialog.this.get_binding();
                if (dialogSubjectPlanBinding == null || (recyclerView = dialogSubjectPlanBinding.rvSubjectPlan) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    public final void setCallBack(DayWiseTimeTableFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        StoreListener storeListener = this.listener;
        if (storeListener != null) {
            storeListener.dismiss();
        }
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
}