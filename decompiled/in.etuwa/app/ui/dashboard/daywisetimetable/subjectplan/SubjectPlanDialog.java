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

/* JADX INFO: compiled from: SubjectPlanDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SubjectPlanDialog extends BaseDialog implements SubjectPlanAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogSubjectPlanBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String date;
    private Integer hour;
    private StoreListener listener;
    private MainCallBackListener listener2;
    private int position;

    /* JADX INFO: renamed from: subjectPlanViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subjectPlanViewModel;

    /* JADX INFO: compiled from: SubjectPlanDialog.kt */
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
                return subjectPlanDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(SubjectPlanViewModel.class), qualifier, b, null, koinScope);
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
    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    /* JADX INFO: compiled from: SubjectPlanDialog.kt */
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
        getSubjectPlanViewModel().getTimeTableResponse().observe(getViewLifecycleOwner(), new SubjectPlanDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends DayWiseResponse>, Unit>() { // from class: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: SubjectPlanDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<DayWiseResponse> resource) {
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    SubjectPlanDialog.this.hideProgress();
                    DayWiseResponse data = resource.getData();
                    if (data != null) {
                        SubjectPlanDialog subjectPlanDialog = SubjectPlanDialog.this;
                        subjectPlanDialog.getAdapter().addItems(data.getTimetable().get(0).getSub().get(subjectPlanDialog.getPosition()).getTopic_name());
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
                DialogSubjectPlanBinding dialogSubjectPlanBinding = SubjectPlanDialog.this.get_binding();
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