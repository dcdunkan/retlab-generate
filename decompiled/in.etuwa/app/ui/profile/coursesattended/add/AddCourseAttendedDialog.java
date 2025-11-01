package in.etuwa.app.ui.profile.coursesattended.add;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddCourseAttendedBinding;
import in.etuwa.app.helper.ValidChecker$$ExternalSyntheticApiModelOutline0;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.profile.coursesattended.CoursesAttendedFragment;
import in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
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

/* compiled from: AddCourseAttendedDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0002LMB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u00020-H\u0007J\"\u00104\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0017J\u0012\u0010:\u001a\u00020-2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010C\u001a\u00020-H\u0016J\b\u0010D\u001a\u00020-H\u0016J\u001a\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020>2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u000e\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u00020-H\u0015J\b\u0010K\u001a\u00020-H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddCourseAttendedBinding;", "achievements", "", "addCourseAttendedViewModel", "Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedViewModel;", "getAddCourseAttendedViewModel", "()Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedViewModel;", "addCourseAttendedViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddCourseAttendedBinding;", "days", "days2", TypedValues.TransitionType.S_DURATION, "firstDate", "getFirstDate", "()Ljava/lang/String;", "setFirstDate", "(Ljava/lang/String;)V", "fromDate", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedDialog$AddCourseListener;", HostelFeeConfirmFragmentKt.ARG_MONTHS, "months2", "name", "organised", "pickFile", "Ljava/io/File;", "secondDate", "getSecondDate", "setSecondDate", "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "toDate", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "noofdays", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/coursesattended/CoursesAttendedFragment;", "setUp", "showProgress", "AddCourseListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddCourseAttendedDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddCourseAttendedBinding _binding;
    private String achievements;

    /* renamed from: addCourseAttendedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addCourseAttendedViewModel;
    private String days;
    private String days2;
    private String duration;
    private String firstDate;
    private String fromDate;
    private String id;
    private AddCourseListener listener;
    private String months;
    private String months2;
    private String name;
    private String organised;
    private File pickFile;
    private String secondDate;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String toDate;
    private String yearId;

    /* compiled from: AddCourseAttendedDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedDialog$AddCourseListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCourseListener {
        void onDismiss();
    }

    /* compiled from: AddCourseAttendedDialog.kt */
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
    public static final AddCourseAttendedDialog newInstance(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddCourseAttendedDialog() {
        final AddCourseAttendedDialog addCourseAttendedDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addCourseAttendedDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addCourseAttendedViewModel = FragmentViewModelLazyKt.createViewModelLazy(addCourseAttendedDialog, Reflection.getOrCreateKotlinClass(AddCourseAttendedViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddCourseAttendedViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.firstDate = "2022-10-22";
        this.secondDate = "2022-10-22";
        this.months = "";
        this.days = "";
        this.months2 = "";
        this.days2 = "";
        final AddCourseAttendedDialog addCourseAttendedDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddCourseAttendedDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCourseAttendedDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final AddCourseAttendedViewModel getAddCourseAttendedViewModel() {
        return (AddCourseAttendedViewModel) this.addCourseAttendedViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddCourseAttendedBinding get_binding() {
        return this._binding;
    }

    public final String getFirstDate() {
        return this.firstDate;
    }

    public final void setFirstDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstDate = str;
    }

    public final String getSecondDate() {
        return this.secondDate;
    }

    public final void setSecondDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondDate = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter() {
        return (IndexSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: AddCourseAttendedDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/coursesattended/add/AddCourseAttendedDialog;", "id", "", "name", "organised", TypedValues.TransitionType.S_DURATION, "achievements", "fromDate", "toDate", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddCourseAttendedDialog newInstance(String id, String name, String organised, String duration, String achievements, String fromDate, String toDate) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(organised, "organised");
            Intrinsics.checkNotNullParameter(duration, "duration");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            Intrinsics.checkNotNullParameter(fromDate, "fromDate");
            Intrinsics.checkNotNullParameter(toDate, "toDate");
            AddCourseAttendedDialog addCourseAttendedDialog = new AddCourseAttendedDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, name);
            bundle.putString("fine", organised);
            bundle.putString(FullDayDialogKt.ARG_BTN, duration);
            bundle.putString("cat", achievements);
            bundle.putString("fixed", fromDate);
            bundle.putString("url", toDate);
            addCourseAttendedDialog.setArguments(bundle);
            return addCourseAttendedDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.name = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.organised = arguments.getString("fine");
            this.duration = arguments.getString(FullDayDialogKt.ARG_BTN);
            this.achievements = arguments.getString("cat");
            this.fromDate = arguments.getString("fixed");
            this.toDate = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddCourseAttendedBinding.inflate(inflater, container, false);
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = get_binding();
        if (dialogAddCourseAttendedBinding != null) {
            dialogAddCourseAttendedBinding.setAddCourseAttendedViewModel(getAddCourseAttendedViewModel());
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = get_binding();
        if (dialogAddCourseAttendedBinding2 != null) {
            dialogAddCourseAttendedBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = get_binding();
        if (dialogAddCourseAttendedBinding3 != null) {
            return dialogAddCourseAttendedBinding3.getRoot();
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
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = get_binding();
        Spinner spinner = dialogAddCourseAttendedBinding != null ? dialogAddCourseAttendedBinding.spinnerYear : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddCourseAttendedViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = get_binding();
            TextView textView6 = dialogAddCourseAttendedBinding2 != null ? dialogAddCourseAttendedBinding2.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = get_binding();
            TextView textView7 = dialogAddCourseAttendedBinding3 != null ? dialogAddCourseAttendedBinding3.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding4 = get_binding();
            TextView textView8 = dialogAddCourseAttendedBinding4 != null ? dialogAddCourseAttendedBinding4.addBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding5 = get_binding();
            TextView textView9 = dialogAddCourseAttendedBinding5 != null ? dialogAddCourseAttendedBinding5.updateBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding6 = get_binding();
        if (dialogAddCourseAttendedBinding6 != null && (textInputEditText4 = dialogAddCourseAttendedBinding6.etName) != null) {
            textInputEditText4.setText(this.name);
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding7 = get_binding();
        if (dialogAddCourseAttendedBinding7 != null && (textInputEditText3 = dialogAddCourseAttendedBinding7.etAchievements) != null) {
            textInputEditText3.setText(this.achievements);
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding8 = get_binding();
        if (dialogAddCourseAttendedBinding8 != null && (textInputEditText2 = dialogAddCourseAttendedBinding8.etDuration) != null) {
            textInputEditText2.setText(this.duration);
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding9 = get_binding();
        if (dialogAddCourseAttendedBinding9 != null && (textInputEditText = dialogAddCourseAttendedBinding9.etOrgaanisedBy) != null) {
            textInputEditText.setText(this.organised);
        }
        if (!Intrinsics.areEqual(this.toDate, "")) {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding10 = get_binding();
            TextView textView10 = dialogAddCourseAttendedBinding10 != null ? dialogAddCourseAttendedBinding10.etEndDate : null;
            if (textView10 != null) {
                textView10.setText(this.toDate);
            }
        }
        if (!Intrinsics.areEqual(this.fromDate, "")) {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding11 = get_binding();
            TextView textView11 = dialogAddCourseAttendedBinding11 != null ? dialogAddCourseAttendedBinding11.etFromDate : null;
            if (textView11 != null) {
                textView11.setText(this.fromDate);
            }
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding12 = get_binding();
        if (dialogAddCourseAttendedBinding12 != null && (textView5 = dialogAddCourseAttendedBinding12.etFromDate) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddCourseAttendedDialog.setUp$lambda$2(AddCourseAttendedDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding13 = get_binding();
        if (dialogAddCourseAttendedBinding13 != null && (textView4 = dialogAddCourseAttendedBinding13.etEndDate) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddCourseAttendedDialog.setUp$lambda$4(AddCourseAttendedDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding14 = get_binding();
        Spinner spinner2 = dialogAddCourseAttendedBinding14 != null ? dialogAddCourseAttendedBinding14.spinnerYear : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddCourseAttendedDialog addCourseAttendedDialog = AddCourseAttendedDialog.this;
                    spinnerAdapter = addCourseAttendedDialog.getSpinnerAdapter();
                    addCourseAttendedDialog.yearId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding15 = get_binding();
        if (dialogAddCourseAttendedBinding15 != null && (textView3 = dialogAddCourseAttendedBinding15.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddCourseAttendedDialog.setUp$lambda$6(AddCourseAttendedDialog.this, view);
                }
            });
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding16 = get_binding();
        if (dialogAddCourseAttendedBinding16 != null && (textView2 = dialogAddCourseAttendedBinding16.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddCourseAttendedDialog.setUp$lambda$7(AddCourseAttendedDialog.this, view);
                }
            });
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding17 = get_binding();
        if (dialogAddCourseAttendedBinding17 == null || (textView = dialogAddCourseAttendedBinding17.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCourseAttendedDialog.setUp$lambda$8(AddCourseAttendedDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final AddCourseAttendedDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda12
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddCourseAttendedDialog.setUp$lambda$2$lambda$1(AddCourseAttendedDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(AddCourseAttendedDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i4 = i2 + 1;
        if (Intrinsics.areEqual(String.valueOf(String.valueOf(i4).length()), "1")) {
            this$0.months = StringsKt.padStart(String.valueOf(i4), 2, '0');
        } else {
            this$0.months = String.valueOf(i4);
        }
        if (Intrinsics.areEqual(String.valueOf(String.valueOf(i3).length()), "1")) {
            this$0.days = StringsKt.padStart(String.valueOf(i3), 2, '0');
        } else {
            this$0.days = String.valueOf(i3);
        }
        this$0.firstDate = i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days;
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
        if (dialogAddCourseAttendedBinding != null && (textView3 = dialogAddCourseAttendedBinding.etFromDate) != null) {
            textView3.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days);
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
        CharSequence charSequence = null;
        if (Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding2 == null || (textView2 = dialogAddCourseAttendedBinding2.etEndDate) == null) ? null : textView2.getText()), "")) {
            return;
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
        if (dialogAddCourseAttendedBinding3 != null && (textView = dialogAddCourseAttendedBinding3.etEndDate) != null) {
            charSequence = textView.getText();
        }
        if (Intrinsics.areEqual(String.valueOf(charSequence), "To Date")) {
            return;
        }
        this$0.noofdays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(final AddCourseAttendedDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda10
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddCourseAttendedDialog.setUp$lambda$4$lambda$3(AddCourseAttendedDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4$lambda$3(AddCourseAttendedDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i4 = i2 + 1;
        if (Intrinsics.areEqual(String.valueOf(String.valueOf(i4).length()), "1")) {
            this$0.months2 = StringsKt.padStart(String.valueOf(i4), 2, '0');
        } else {
            this$0.months2 = String.valueOf(i4);
        }
        if (Intrinsics.areEqual(String.valueOf(String.valueOf(i3).length()), "1")) {
            this$0.days2 = StringsKt.padStart(String.valueOf(i3), 2, '0');
        } else {
            this$0.days2 = String.valueOf(i3);
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
        if (dialogAddCourseAttendedBinding != null && (textView3 = dialogAddCourseAttendedBinding.etEndDate) != null) {
            textView3.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months2 + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days2);
        }
        this$0.secondDate = i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months2 + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days2;
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
        CharSequence charSequence = null;
        if (Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding2 == null || (textView2 = dialogAddCourseAttendedBinding2.etFromDate) == null) ? null : textView2.getText()), "")) {
            return;
        }
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
        if (dialogAddCourseAttendedBinding3 != null && (textView = dialogAddCourseAttendedBinding3.etFromDate) != null) {
            charSequence = textView.getText();
        }
        if (Intrinsics.areEqual(String.valueOf(charSequence), "From Date")) {
            return;
        }
        this$0.noofdays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(AddCourseAttendedDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(AddCourseAttendedDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextInputEditText textInputEditText5;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        File file;
        TextView textView14;
        TextView textView15;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextInputEditText textInputEditText10;
        TextView textView21;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
            if (String.valueOf((dialogAddCourseAttendedBinding == null || (textView21 = dialogAddCourseAttendedBinding.completionFileName) == null) ? null : textView21.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding2 == null || (textInputEditText10 = dialogAddCourseAttendedBinding2.etName) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
                        if (dialogAddCourseAttendedBinding3 == null || (textView20 = dialogAddCourseAttendedBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView20, "Name of the course Cannot be empty");
                        return;
                    }
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding4 == null || (textView19 = dialogAddCourseAttendedBinding4.etFromDate) == null) ? null : textView19.getText()), "")) {
                        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding5 == null || (textView18 = dialogAddCourseAttendedBinding5.etFromDate) == null) ? null : textView18.getText()), "From Date")) {
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding6 = this$0.get_binding();
                            if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding6 == null || (textView17 = dialogAddCourseAttendedBinding6.etEndDate) == null) ? null : textView17.getText()), "")) {
                                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding7 = this$0.get_binding();
                                if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding7 == null || (textView16 = dialogAddCourseAttendedBinding7.etEndDate) == null) ? null : textView16.getText()), "To Date")) {
                                    AddCourseAttendedViewModel addCourseAttendedViewModel = this$0.getAddCourseAttendedViewModel();
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding8 = this$0.get_binding();
                                    String valueOf = String.valueOf((dialogAddCourseAttendedBinding8 == null || (textInputEditText9 = dialogAddCourseAttendedBinding8.etName) == null) ? null : textInputEditText9.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding9 = this$0.get_binding();
                                    String valueOf2 = String.valueOf((dialogAddCourseAttendedBinding9 == null || (textInputEditText8 = dialogAddCourseAttendedBinding9.etOrgaanisedBy) == null) ? null : textInputEditText8.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding10 = this$0.get_binding();
                                    String valueOf3 = String.valueOf((dialogAddCourseAttendedBinding10 == null || (textInputEditText7 = dialogAddCourseAttendedBinding10.etDuration) == null) ? null : textInputEditText7.getText());
                                    String str = this$0.yearId;
                                    Intrinsics.checkNotNull(str);
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding11 = this$0.get_binding();
                                    String valueOf4 = String.valueOf((dialogAddCourseAttendedBinding11 == null || (textInputEditText6 = dialogAddCourseAttendedBinding11.etAchievements) == null) ? null : textInputEditText6.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding12 = this$0.get_binding();
                                    String valueOf5 = String.valueOf((dialogAddCourseAttendedBinding12 == null || (textView15 = dialogAddCourseAttendedBinding12.etFromDate) == null) ? null : textView15.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding13 = this$0.get_binding();
                                    String valueOf6 = String.valueOf((dialogAddCourseAttendedBinding13 == null || (textView14 = dialogAddCourseAttendedBinding13.etEndDate) == null) ? null : textView14.getText());
                                    File file3 = this$0.pickFile;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                        file = null;
                                    } else {
                                        file = file3;
                                    }
                                    addCourseAttendedViewModel.addCourseData(valueOf, valueOf2, valueOf3, str, valueOf4, valueOf5, valueOf6, file);
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding14 = this$0.get_binding();
                                    LinearLayout linearLayout = dialogAddCourseAttendedBinding14 != null ? dialogAddCourseAttendedBinding14.completionCard : null;
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding15 = this$0.get_binding();
                                    CardView cardView = dialogAddCourseAttendedBinding15 != null ? dialogAddCourseAttendedBinding15.progressView : null;
                                    if (cardView == null) {
                                        return;
                                    }
                                    cardView.setVisibility(0);
                                    return;
                                }
                            }
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding16 = this$0.get_binding();
                            if (dialogAddCourseAttendedBinding16 == null || (textView13 = dialogAddCourseAttendedBinding16.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView13, "Please choose to date.");
                            return;
                        }
                    }
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding17 = this$0.get_binding();
                    if (dialogAddCourseAttendedBinding17 == null || (textView12 = dialogAddCourseAttendedBinding17.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView12, "Please choose from date.");
                    return;
                }
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding18 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding18 == null || (textView11 = dialogAddCourseAttendedBinding18.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView11, "File Size Limit Is 100KB");
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding19 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding19 == null || (textInputEditText5 = dialogAddCourseAttendedBinding19.etName) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding20 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding20 == null || (textView10 = dialogAddCourseAttendedBinding20.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView10, "Name of the course Cannot be empty");
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding21 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding21 == null || (textView9 = dialogAddCourseAttendedBinding21.etFromDate) == null) ? null : textView9.getText()), "")) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding22 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding22 == null || (textView8 = dialogAddCourseAttendedBinding22.etFromDate) == null) ? null : textView8.getText()), "From Date")) {
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding23 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding23 == null || (textView7 = dialogAddCourseAttendedBinding23.etEndDate) == null) ? null : textView7.getText()), "")) {
                        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding24 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding24 == null || (textView6 = dialogAddCourseAttendedBinding24.etEndDate) == null) ? null : textView6.getText()), "To Date")) {
                            AddCourseAttendedViewModel addCourseAttendedViewModel2 = this$0.getAddCourseAttendedViewModel();
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding25 = this$0.get_binding();
                            String valueOf7 = String.valueOf((dialogAddCourseAttendedBinding25 == null || (textInputEditText4 = dialogAddCourseAttendedBinding25.etName) == null) ? null : textInputEditText4.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding26 = this$0.get_binding();
                            String valueOf8 = String.valueOf((dialogAddCourseAttendedBinding26 == null || (textInputEditText3 = dialogAddCourseAttendedBinding26.etOrgaanisedBy) == null) ? null : textInputEditText3.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding27 = this$0.get_binding();
                            String valueOf9 = String.valueOf((dialogAddCourseAttendedBinding27 == null || (textInputEditText2 = dialogAddCourseAttendedBinding27.etDuration) == null) ? null : textInputEditText2.getText());
                            String str2 = this$0.yearId;
                            Intrinsics.checkNotNull(str2);
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding28 = this$0.get_binding();
                            String valueOf10 = String.valueOf((dialogAddCourseAttendedBinding28 == null || (textInputEditText = dialogAddCourseAttendedBinding28.etAchievements) == null) ? null : textInputEditText.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding29 = this$0.get_binding();
                            String valueOf11 = String.valueOf((dialogAddCourseAttendedBinding29 == null || (textView5 = dialogAddCourseAttendedBinding29.etFromDate) == null) ? null : textView5.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding30 = this$0.get_binding();
                            addCourseAttendedViewModel2.addCourseData(valueOf7, valueOf8, valueOf9, str2, valueOf10, valueOf11, String.valueOf((dialogAddCourseAttendedBinding30 == null || (textView4 = dialogAddCourseAttendedBinding30.etEndDate) == null) ? null : textView4.getText()));
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding31 = this$0.get_binding();
                            LinearLayout linearLayout2 = dialogAddCourseAttendedBinding31 != null ? dialogAddCourseAttendedBinding31.completionCard : null;
                            if (linearLayout2 == null) {
                                return;
                            }
                            linearLayout2.setVisibility(8);
                            return;
                        }
                    }
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding32 = this$0.get_binding();
                    if (dialogAddCourseAttendedBinding32 == null || (textView3 = dialogAddCourseAttendedBinding32.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView3, "Please choose to date.");
                    return;
                }
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding33 = this$0.get_binding();
            if (dialogAddCourseAttendedBinding33 == null || (textView2 = dialogAddCourseAttendedBinding33.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please choose from date.");
        } catch (Exception unused) {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding34 = this$0.get_binding();
            if (dialogAddCourseAttendedBinding34 == null || (textView = dialogAddCourseAttendedBinding34.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(AddCourseAttendedDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextInputEditText textInputEditText5;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        File file;
        TextView textView13;
        TextView textView14;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextView textView15;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextInputEditText textInputEditText10;
        TextView textView20;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
            CharSequence charSequence = null;
            charSequence = null;
            if (String.valueOf((dialogAddCourseAttendedBinding == null || (textView20 = dialogAddCourseAttendedBinding.completionFileName) == null) ? null : textView20.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding2 == null || (textInputEditText10 = dialogAddCourseAttendedBinding2.etName) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
                        if (dialogAddCourseAttendedBinding3 == null || (textView19 = dialogAddCourseAttendedBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView19, "Name of the course Cannot be empty");
                        return;
                    }
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding4 == null || (textView18 = dialogAddCourseAttendedBinding4.etFromDate) == null) ? null : textView18.getText()), "")) {
                        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding5 == null || (textView17 = dialogAddCourseAttendedBinding5.etFromDate) == null) ? null : textView17.getText()), "From Date")) {
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding6 = this$0.get_binding();
                            if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding6 == null || (textView16 = dialogAddCourseAttendedBinding6.etEndDate) == null) ? null : textView16.getText()), "")) {
                                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding7 = this$0.get_binding();
                                if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding7 == null || (textView15 = dialogAddCourseAttendedBinding7.etEndDate) == null) ? null : textView15.getText()), "To Date")) {
                                    AddCourseAttendedViewModel addCourseAttendedViewModel = this$0.getAddCourseAttendedViewModel();
                                    String str = this$0.id;
                                    Intrinsics.checkNotNull(str);
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding8 = this$0.get_binding();
                                    String valueOf = String.valueOf((dialogAddCourseAttendedBinding8 == null || (textInputEditText9 = dialogAddCourseAttendedBinding8.etName) == null) ? null : textInputEditText9.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding9 = this$0.get_binding();
                                    String valueOf2 = String.valueOf((dialogAddCourseAttendedBinding9 == null || (textInputEditText8 = dialogAddCourseAttendedBinding9.etOrgaanisedBy) == null) ? null : textInputEditText8.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding10 = this$0.get_binding();
                                    String valueOf3 = String.valueOf((dialogAddCourseAttendedBinding10 == null || (textInputEditText7 = dialogAddCourseAttendedBinding10.etDuration) == null) ? null : textInputEditText7.getText());
                                    String str2 = this$0.yearId;
                                    Intrinsics.checkNotNull(str2);
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding11 = this$0.get_binding();
                                    String valueOf4 = String.valueOf((dialogAddCourseAttendedBinding11 == null || (textInputEditText6 = dialogAddCourseAttendedBinding11.etAchievements) == null) ? null : textInputEditText6.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding12 = this$0.get_binding();
                                    String valueOf5 = String.valueOf((dialogAddCourseAttendedBinding12 == null || (textView14 = dialogAddCourseAttendedBinding12.etFromDate) == null) ? null : textView14.getText());
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding13 = this$0.get_binding();
                                    String valueOf6 = String.valueOf((dialogAddCourseAttendedBinding13 == null || (textView13 = dialogAddCourseAttendedBinding13.etEndDate) == null) ? null : textView13.getText());
                                    File file3 = this$0.pickFile;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                        file = null;
                                    } else {
                                        file = file3;
                                    }
                                    addCourseAttendedViewModel.updateCourseData(str, valueOf, valueOf2, valueOf3, str2, valueOf4, valueOf5, valueOf6, file);
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding14 = this$0.get_binding();
                                    LinearLayout linearLayout = dialogAddCourseAttendedBinding14 != null ? dialogAddCourseAttendedBinding14.completionCard : null;
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding15 = this$0.get_binding();
                                    CardView cardView = dialogAddCourseAttendedBinding15 != null ? dialogAddCourseAttendedBinding15.progressView : null;
                                    if (cardView == null) {
                                        return;
                                    }
                                    cardView.setVisibility(0);
                                    return;
                                }
                            }
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding16 = this$0.get_binding();
                            if (dialogAddCourseAttendedBinding16 == null || (textView12 = dialogAddCourseAttendedBinding16.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView12, "Please choose to date.");
                            return;
                        }
                    }
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding17 = this$0.get_binding();
                    if (dialogAddCourseAttendedBinding17 == null || (textView11 = dialogAddCourseAttendedBinding17.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView11, "Please choose from date.");
                    return;
                }
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding18 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding18 == null || (textView10 = dialogAddCourseAttendedBinding18.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView10, "File Size Limit Is 100KB");
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding19 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding19 == null || (textInputEditText5 = dialogAddCourseAttendedBinding19.etName) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding20 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding20 == null || (textView9 = dialogAddCourseAttendedBinding20.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView9, "Name of the course Cannot be empty");
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding21 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding21 == null || (textView8 = dialogAddCourseAttendedBinding21.etFromDate) == null) ? null : textView8.getText()), "")) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding22 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding22 == null || (textView7 = dialogAddCourseAttendedBinding22.etFromDate) == null) ? null : textView7.getText()), "From Date")) {
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding23 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding23 == null || (textView6 = dialogAddCourseAttendedBinding23.etEndDate) == null) ? null : textView6.getText()), "")) {
                        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding24 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddCourseAttendedBinding24 == null || (textView5 = dialogAddCourseAttendedBinding24.etEndDate) == null) ? null : textView5.getText()), "To Date")) {
                            AddCourseAttendedViewModel addCourseAttendedViewModel2 = this$0.getAddCourseAttendedViewModel();
                            String str3 = this$0.id;
                            Intrinsics.checkNotNull(str3);
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding25 = this$0.get_binding();
                            String valueOf7 = String.valueOf((dialogAddCourseAttendedBinding25 == null || (textInputEditText4 = dialogAddCourseAttendedBinding25.etName) == null) ? null : textInputEditText4.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding26 = this$0.get_binding();
                            String valueOf8 = String.valueOf((dialogAddCourseAttendedBinding26 == null || (textInputEditText3 = dialogAddCourseAttendedBinding26.etOrgaanisedBy) == null) ? null : textInputEditText3.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding27 = this$0.get_binding();
                            String valueOf9 = String.valueOf((dialogAddCourseAttendedBinding27 == null || (textInputEditText2 = dialogAddCourseAttendedBinding27.etDuration) == null) ? null : textInputEditText2.getText());
                            String str4 = this$0.yearId;
                            Intrinsics.checkNotNull(str4);
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding28 = this$0.get_binding();
                            String valueOf10 = String.valueOf((dialogAddCourseAttendedBinding28 == null || (textInputEditText = dialogAddCourseAttendedBinding28.etAchievements) == null) ? null : textInputEditText.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding29 = this$0.get_binding();
                            String valueOf11 = String.valueOf((dialogAddCourseAttendedBinding29 == null || (textView4 = dialogAddCourseAttendedBinding29.etFromDate) == null) ? null : textView4.getText());
                            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding30 = this$0.get_binding();
                            if (dialogAddCourseAttendedBinding30 != null && (textView3 = dialogAddCourseAttendedBinding30.etEndDate) != null) {
                                charSequence = textView3.getText();
                            }
                            addCourseAttendedViewModel2.updateCourseData(str3, valueOf7, valueOf8, valueOf9, str4, valueOf10, valueOf11, String.valueOf(charSequence));
                            return;
                        }
                    }
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding31 = this$0.get_binding();
                    if (dialogAddCourseAttendedBinding31 == null || (textView2 = dialogAddCourseAttendedBinding31.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView2, "Please choose to date.");
                    return;
                }
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding32 = this$0.get_binding();
            if (dialogAddCourseAttendedBinding32 == null || (textView = dialogAddCourseAttendedBinding32.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please choose from date.");
        } catch (Exception unused) {
        }
    }

    public final void noofdays() {
        DateTimeFormatter ofPattern;
        LocalDate parse;
        LocalDate parse2;
        ChronoUnit chronoUnit;
        long between;
        TextInputEditText textInputEditText;
        ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        parse = LocalDate.parse(this.firstDate, ofPattern);
        parse2 = LocalDate.parse(this.secondDate, ofPattern);
        chronoUnit = ChronoUnit.DAYS;
        between = chronoUnit.between(ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) parse), ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) parse2));
        DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = get_binding();
        if (dialogAddCourseAttendedBinding == null || (textInputEditText = dialogAddCourseAttendedBinding.etDuration) == null) {
            return;
        }
        textInputEditText.setText(String.valueOf(between + 1));
    }

    private final void listenSpinnerResponse() {
        getAddCourseAttendedViewModel().getResponse().observe(getViewLifecycleOwner(), new AddCourseAttendedDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$listenSpinnerResponse$1

            /* compiled from: AddCourseAttendedDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends PublicationDropDownResponse> resource) {
                invoke2((Resource<PublicationDropDownResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<PublicationDropDownResponse> resource) {
                IndexSpinnerAdapter spinnerAdapter;
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCourseAttendedDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter = AddCourseAttendedDialog.this.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getYears());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddCourseAttendedDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCourseAttendedDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCourseAttendedDialog.this.hideProgress();
                dialogAddCourseAttendedBinding = AddCourseAttendedDialog.this.get_binding();
                if (dialogAddCourseAttendedBinding == null || (spinner = dialogAddCourseAttendedBinding.spinnerYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddCourseAttendedViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddCourseAttendedDialog.listenAddResponse$lambda$10(AddCourseAttendedDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$10(AddCourseAttendedDialog this$0, Resource resource) {
        TextView addBtn;
        TextView addBtn2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
            if (dialogAddCourseAttendedBinding != null && (textView = dialogAddCourseAttendedBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddCourseListener addCourseListener = this$0.listener;
            if (addCourseListener != null) {
                addCourseListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding2 != null && (addBtn2 = dialogAddCourseAttendedBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddCourseListener addCourseListener2 = this$0.listener;
                if (addCourseListener2 != null) {
                    addCourseListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
            if (dialogAddCourseAttendedBinding3 != null && (addBtn = dialogAddCourseAttendedBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddCourseListener addCourseListener3 = this$0.listener;
            if (addCourseListener3 != null) {
                addCourseListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddCourseAttendedViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddCourseAttendedDialog.listenAddResponse2$lambda$12(AddCourseAttendedDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$12(AddCourseAttendedDialog this$0, Resource resource) {
        TextView addBtn;
        TextView addBtn2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
            if (dialogAddCourseAttendedBinding != null && (textView = dialogAddCourseAttendedBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddCourseListener addCourseListener = this$0.listener;
            if (addCourseListener != null) {
                addCourseListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding2 != null && (addBtn2 = dialogAddCourseAttendedBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddCourseListener addCourseListener2 = this$0.listener;
                if (addCourseListener2 != null) {
                    addCourseListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
            if (dialogAddCourseAttendedBinding3 != null && (addBtn = dialogAddCourseAttendedBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddCourseListener addCourseListener3 = this$0.listener;
            if (addCourseListener3 != null) {
                addCourseListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddCourseAttendedViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddCourseAttendedDialog.listenUpdateResponse$lambda$14(AddCourseAttendedDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$14(AddCourseAttendedDialog this$0, Resource resource) {
        TextView completionFileName;
        TextView completionFileName2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
            if (dialogAddCourseAttendedBinding != null && (textView = dialogAddCourseAttendedBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddCourseListener addCourseListener = this$0.listener;
            if (addCourseListener != null) {
                addCourseListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
                if (dialogAddCourseAttendedBinding2 != null && (completionFileName2 = dialogAddCourseAttendedBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddCourseListener addCourseListener2 = this$0.listener;
                if (addCourseListener2 != null) {
                    addCourseListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
            if (dialogAddCourseAttendedBinding3 != null && (completionFileName = dialogAddCourseAttendedBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddCourseListener addCourseListener3 = this$0.listener;
            if (addCourseListener3 != null) {
                addCourseListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddCourseAttendedViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.coursesattended.add.AddCourseAttendedDialog$$ExternalSyntheticLambda13
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddCourseAttendedDialog.listenProgressResponse$lambda$16(AddCourseAttendedDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$16(AddCourseAttendedDialog this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = this$0.get_binding();
            if (dialogAddCourseAttendedBinding == null || (textView = dialogAddCourseAttendedBinding.completionFileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddCourseAttendedBinding2 != null ? dialogAddCourseAttendedBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddCourseAttendedBinding3 != null ? dialogAddCourseAttendedBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        ParcelFileDescriptor openFileDescriptor;
        File file;
        ContentResolver contentResolver3;
        String fileName;
        TextView completionFileName;
        ContentResolver contentResolver4;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                Context context = getContext();
                String type = (context == null || (contentResolver4 = context.getContentResolver()) == null) ? null : contentResolver4.getType(data2);
                if (!Intrinsics.areEqual(type, "application/pdf") && !Intrinsics.areEqual(type, "image/jpeg")) {
                    DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding = get_binding();
                    if (dialogAddCourseAttendedBinding == null || (completionFileName = dialogAddCourseAttendedBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddCourseAttendedBinding dialogAddCourseAttendedBinding2 = get_binding();
                TextView textView = dialogAddCourseAttendedBinding2 != null ? dialogAddCourseAttendedBinding2.completionFileName : null;
                if (textView != null) {
                    Context context2 = getContext();
                    if (context2 == null || (contentResolver = context2.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver, data2);
                    }
                    textView.setText("File : " + str);
                }
                Context context3 = getContext();
                if (context3 != null && (contentResolver2 = context3.getContentResolver()) != null && (openFileDescriptor = contentResolver2.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…              ) ?: return");
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver3 = context4.getContentResolver()) == null || (fileName = ResolvUtilKt.getFileName(contentResolver3, data2)) == null) {
                        file = null;
                    } else {
                        Context context5 = getContext();
                        file = new File(context5 != null ? context5.getCacheDir() : null, fileName);
                    }
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    if (file != null) {
                        this.pickFile = file;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setCallBack(CoursesAttendedFragment context) {
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
}