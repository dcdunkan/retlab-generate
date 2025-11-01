package in.etuwa.app.ui.profile.mooccourse.add;

import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import in.etuwa.app.databinding.DialogAddMoocCourseBinding;
import in.etuwa.app.helper.ValidChecker$$ExternalSyntheticApiModelOutline0;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.profile.mooccourse.MoocCourseFragment;
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
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddMoocCourseDialog.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u0001:\u0002FGB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0007J\"\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0017J\u0012\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010=\u001a\u00020(H\u0016J\b\u0010>\u001a\u00020(H\u0016J\u001a\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u000e\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u00020(H\u0015J\b\u0010E\u001a\u00020(H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddMoocCourseBinding;", "achievements", "", "addMoocCourseViewModel", "Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseViewModel;", "getAddMoocCourseViewModel", "()Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseViewModel;", "addMoocCourseViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddMoocCourseBinding;", "days", "days2", TypedValues.TransitionType.S_DURATION, "firstDate", "getFirstDate", "()Ljava/lang/String;", "setFirstDate", "(Ljava/lang/String;)V", "fromDate", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseDialog$AddMoocCourseListener;", HostelFeeConfirmFragmentKt.ARG_MONTHS, "months2", "name", "organised", "pickFile", "Ljava/io/File;", "secondDate", "getSecondDate", "setSecondDate", "toDate", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenUpdateResponse", "noofdays", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/mooccourse/MoocCourseFragment;", "setUp", "showProgress", "AddMoocCourseListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddMoocCourseDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddMoocCourseBinding _binding;
    private String achievements;

    /* renamed from: addMoocCourseViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addMoocCourseViewModel;
    private String days;
    private String days2;
    private String duration;
    private String firstDate;
    private String fromDate;
    private String id;
    private AddMoocCourseListener listener;
    private String months;
    private String months2;
    private String name;
    private String organised;
    private File pickFile;
    private String secondDate;
    private String toDate;
    private String yearId;

    /* compiled from: AddMoocCourseDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseDialog$AddMoocCourseListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddMoocCourseListener {
        void onDismiss();
    }

    /* compiled from: AddMoocCourseDialog.kt */
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
    public static final AddMoocCourseDialog newInstance(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddMoocCourseDialog() {
        final AddMoocCourseDialog addMoocCourseDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addMoocCourseDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addMoocCourseViewModel = FragmentViewModelLazyKt.createViewModelLazy(addMoocCourseDialog, Reflection.getOrCreateKotlinClass(AddMoocCourseViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddMoocCourseViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.firstDate = "2022-10-22";
        this.secondDate = "2022-10-22";
        this.months = "";
        this.days = "";
        this.months2 = "";
        this.days2 = "";
    }

    private final AddMoocCourseViewModel getAddMoocCourseViewModel() {
        return (AddMoocCourseViewModel) this.addMoocCourseViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogAddMoocCourseBinding get_binding() {
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

    /* compiled from: AddMoocCourseDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/mooccourse/add/AddMoocCourseDialog;", "id", "", "name", "organised", "fromDate", "toDate", TypedValues.TransitionType.S_DURATION, "achievements", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddMoocCourseDialog newInstance(String id, String name, String organised, String fromDate, String toDate, String duration, String achievements) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(organised, "organised");
            Intrinsics.checkNotNullParameter(fromDate, "fromDate");
            Intrinsics.checkNotNullParameter(toDate, "toDate");
            Intrinsics.checkNotNullParameter(duration, "duration");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            AddMoocCourseDialog addMoocCourseDialog = new AddMoocCourseDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, name);
            bundle.putString("fine", organised);
            bundle.putString(FullDayDialogKt.ARG_BTN, duration);
            bundle.putString("cat", achievements);
            bundle.putString("fixed", fromDate);
            bundle.putString("url", toDate);
            addMoocCourseDialog.setArguments(bundle);
            return addMoocCourseDialog;
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
        this._binding = DialogAddMoocCourseBinding.inflate(inflater, container, false);
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding = get_binding();
        if (dialogAddMoocCourseBinding != null) {
            dialogAddMoocCourseBinding.setAddMoocCourseViewModel(getAddMoocCourseViewModel());
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = get_binding();
        if (dialogAddMoocCourseBinding2 != null) {
            dialogAddMoocCourseBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = get_binding();
        if (dialogAddMoocCourseBinding3 != null) {
            return dialogAddMoocCourseBinding3.getRoot();
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
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = get_binding();
            TextView textView6 = dialogAddMoocCourseBinding != null ? dialogAddMoocCourseBinding.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = get_binding();
            TextView textView7 = dialogAddMoocCourseBinding2 != null ? dialogAddMoocCourseBinding2.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = get_binding();
            TextView textView8 = dialogAddMoocCourseBinding3 != null ? dialogAddMoocCourseBinding3.addBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding4 = get_binding();
            TextView textView9 = dialogAddMoocCourseBinding4 != null ? dialogAddMoocCourseBinding4.updateBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding5 = get_binding();
        if (dialogAddMoocCourseBinding5 != null && (textInputEditText4 = dialogAddMoocCourseBinding5.etTitle) != null) {
            textInputEditText4.setText(this.name);
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding6 = get_binding();
        if (dialogAddMoocCourseBinding6 != null && (textInputEditText3 = dialogAddMoocCourseBinding6.etAchievements) != null) {
            textInputEditText3.setText(this.achievements);
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding7 = get_binding();
        if (dialogAddMoocCourseBinding7 != null && (textInputEditText2 = dialogAddMoocCourseBinding7.etDuration) != null) {
            textInputEditText2.setText(this.duration);
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding8 = get_binding();
        if (dialogAddMoocCourseBinding8 != null && (textInputEditText = dialogAddMoocCourseBinding8.etOrgaanisedBy) != null) {
            textInputEditText.setText(this.organised);
        }
        if (!Intrinsics.areEqual(this.toDate, "")) {
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding9 = get_binding();
            TextView textView10 = dialogAddMoocCourseBinding9 != null ? dialogAddMoocCourseBinding9.etEndDate : null;
            if (textView10 != null) {
                textView10.setText(this.toDate);
            }
        }
        if (!Intrinsics.areEqual(this.fromDate, "")) {
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding10 = get_binding();
            TextView textView11 = dialogAddMoocCourseBinding10 != null ? dialogAddMoocCourseBinding10.etFromDate : null;
            if (textView11 != null) {
                textView11.setText(this.fromDate);
            }
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding11 = get_binding();
        if (dialogAddMoocCourseBinding11 != null && (textView5 = dialogAddMoocCourseBinding11.etFromDate) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMoocCourseDialog.setUp$lambda$2(AddMoocCourseDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding12 = get_binding();
        if (dialogAddMoocCourseBinding12 != null && (textView4 = dialogAddMoocCourseBinding12.etEndDate) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMoocCourseDialog.setUp$lambda$4(AddMoocCourseDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding13 = get_binding();
        if (dialogAddMoocCourseBinding13 != null && (textView3 = dialogAddMoocCourseBinding13.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMoocCourseDialog.setUp$lambda$6(AddMoocCourseDialog.this, view);
                }
            });
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding14 = get_binding();
        if (dialogAddMoocCourseBinding14 != null && (textView2 = dialogAddMoocCourseBinding14.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMoocCourseDialog.setUp$lambda$7(AddMoocCourseDialog.this, view);
                }
            });
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding15 = get_binding();
        if (dialogAddMoocCourseBinding15 == null || (textView = dialogAddMoocCourseBinding15.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddMoocCourseDialog.setUp$lambda$8(AddMoocCourseDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final AddMoocCourseDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda7
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddMoocCourseDialog.setUp$lambda$2$lambda$1(AddMoocCourseDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(AddMoocCourseDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
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
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
        if (dialogAddMoocCourseBinding != null && (textView3 = dialogAddMoocCourseBinding.etFromDate) != null) {
            textView3.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days);
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
        CharSequence charSequence = null;
        if (Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding2 == null || (textView2 = dialogAddMoocCourseBinding2.etEndDate) == null) ? null : textView2.getText()), "")) {
            return;
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
        if (dialogAddMoocCourseBinding3 != null && (textView = dialogAddMoocCourseBinding3.etEndDate) != null) {
            charSequence = textView.getText();
        }
        if (Intrinsics.areEqual(String.valueOf(charSequence), "To Date")) {
            return;
        }
        this$0.noofdays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(final AddMoocCourseDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda6
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddMoocCourseDialog.setUp$lambda$4$lambda$3(AddMoocCourseDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4$lambda$3(AddMoocCourseDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
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
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
        if (dialogAddMoocCourseBinding != null && (textView3 = dialogAddMoocCourseBinding.etEndDate) != null) {
            textView3.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months2 + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days2);
        }
        this$0.secondDate = i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months2 + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days2;
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
        CharSequence charSequence = null;
        if (Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding2 == null || (textView2 = dialogAddMoocCourseBinding2.etFromDate) == null) ? null : textView2.getText()), "")) {
            return;
        }
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
        if (dialogAddMoocCourseBinding3 != null && (textView = dialogAddMoocCourseBinding3.etFromDate) != null) {
            charSequence = textView.getText();
        }
        if (Intrinsics.areEqual(String.valueOf(charSequence), "From Date")) {
            return;
        }
        this$0.noofdays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(AddMoocCourseDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(AddMoocCourseDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextView textView4;
        TextView textView5;
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
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextView textView14;
        TextView textView15;
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
            if (String.valueOf((dialogAddMoocCourseBinding == null || (textView21 = dialogAddMoocCourseBinding.completionFileName) == null) ? null : textView21.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding2 == null || (textInputEditText10 = dialogAddMoocCourseBinding2.etTitle) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
                        if (dialogAddMoocCourseBinding3 == null || (textView20 = dialogAddMoocCourseBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView20, "Title Cannot be empty");
                        return;
                    }
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding4 == null || (textView19 = dialogAddMoocCourseBinding4.etFromDate) == null) ? null : textView19.getText()), "")) {
                        DialogAddMoocCourseBinding dialogAddMoocCourseBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding5 == null || (textView18 = dialogAddMoocCourseBinding5.etFromDate) == null) ? null : textView18.getText()), "From Date")) {
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding6 = this$0.get_binding();
                            if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding6 == null || (textView17 = dialogAddMoocCourseBinding6.etEndDate) == null) ? null : textView17.getText()), "")) {
                                DialogAddMoocCourseBinding dialogAddMoocCourseBinding7 = this$0.get_binding();
                                if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding7 == null || (textView16 = dialogAddMoocCourseBinding7.etEndDate) == null) ? null : textView16.getText()), "To Date")) {
                                    AddMoocCourseViewModel addMoocCourseViewModel = this$0.getAddMoocCourseViewModel();
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding8 = this$0.get_binding();
                                    String valueOf = String.valueOf((dialogAddMoocCourseBinding8 == null || (textInputEditText9 = dialogAddMoocCourseBinding8.etTitle) == null) ? null : textInputEditText9.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding9 = this$0.get_binding();
                                    String valueOf2 = String.valueOf((dialogAddMoocCourseBinding9 == null || (textInputEditText8 = dialogAddMoocCourseBinding9.etOrgaanisedBy) == null) ? null : textInputEditText8.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding10 = this$0.get_binding();
                                    String valueOf3 = String.valueOf((dialogAddMoocCourseBinding10 == null || (textView15 = dialogAddMoocCourseBinding10.etFromDate) == null) ? null : textView15.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding11 = this$0.get_binding();
                                    String valueOf4 = String.valueOf((dialogAddMoocCourseBinding11 == null || (textView14 = dialogAddMoocCourseBinding11.etEndDate) == null) ? null : textView14.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding12 = this$0.get_binding();
                                    String valueOf5 = String.valueOf((dialogAddMoocCourseBinding12 == null || (textInputEditText7 = dialogAddMoocCourseBinding12.etDuration) == null) ? null : textInputEditText7.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding13 = this$0.get_binding();
                                    String valueOf6 = String.valueOf((dialogAddMoocCourseBinding13 == null || (textInputEditText6 = dialogAddMoocCourseBinding13.etAchievements) == null) ? null : textInputEditText6.getText());
                                    File file3 = this$0.pickFile;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                        file = null;
                                    } else {
                                        file = file3;
                                    }
                                    addMoocCourseViewModel.addMoocCourseData(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, file);
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding14 = this$0.get_binding();
                                    LinearLayout linearLayout = dialogAddMoocCourseBinding14 != null ? dialogAddMoocCourseBinding14.completionCard : null;
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding15 = this$0.get_binding();
                                    CardView cardView = dialogAddMoocCourseBinding15 != null ? dialogAddMoocCourseBinding15.progressView : null;
                                    if (cardView == null) {
                                        return;
                                    }
                                    cardView.setVisibility(0);
                                    return;
                                }
                            }
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding16 = this$0.get_binding();
                            if (dialogAddMoocCourseBinding16 == null || (textView13 = dialogAddMoocCourseBinding16.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView13, "Please choose to date.");
                            return;
                        }
                    }
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding17 = this$0.get_binding();
                    if (dialogAddMoocCourseBinding17 == null || (textView12 = dialogAddMoocCourseBinding17.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView12, "Please choose from date.");
                    return;
                }
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding18 = this$0.get_binding();
                if (dialogAddMoocCourseBinding18 == null || (textView11 = dialogAddMoocCourseBinding18.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView11, "File Size Limit Is 100KB");
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding19 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding19 == null || (textInputEditText5 = dialogAddMoocCourseBinding19.etTitle) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding20 = this$0.get_binding();
                if (dialogAddMoocCourseBinding20 == null || (textView10 = dialogAddMoocCourseBinding20.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView10, "Title Cannot be empty");
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding21 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding21 == null || (textView9 = dialogAddMoocCourseBinding21.etFromDate) == null) ? null : textView9.getText()), "")) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding22 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding22 == null || (textView8 = dialogAddMoocCourseBinding22.etFromDate) == null) ? null : textView8.getText()), "From Date")) {
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding23 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding23 == null || (textView7 = dialogAddMoocCourseBinding23.etEndDate) == null) ? null : textView7.getText()), "")) {
                        DialogAddMoocCourseBinding dialogAddMoocCourseBinding24 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding24 == null || (textView6 = dialogAddMoocCourseBinding24.etEndDate) == null) ? null : textView6.getText()), "To Date")) {
                            AddMoocCourseViewModel addMoocCourseViewModel2 = this$0.getAddMoocCourseViewModel();
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding25 = this$0.get_binding();
                            String valueOf7 = String.valueOf((dialogAddMoocCourseBinding25 == null || (textInputEditText4 = dialogAddMoocCourseBinding25.etTitle) == null) ? null : textInputEditText4.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding26 = this$0.get_binding();
                            String valueOf8 = String.valueOf((dialogAddMoocCourseBinding26 == null || (textInputEditText3 = dialogAddMoocCourseBinding26.etOrgaanisedBy) == null) ? null : textInputEditText3.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding27 = this$0.get_binding();
                            String valueOf9 = String.valueOf((dialogAddMoocCourseBinding27 == null || (textView5 = dialogAddMoocCourseBinding27.etFromDate) == null) ? null : textView5.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding28 = this$0.get_binding();
                            String valueOf10 = String.valueOf((dialogAddMoocCourseBinding28 == null || (textView4 = dialogAddMoocCourseBinding28.etEndDate) == null) ? null : textView4.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding29 = this$0.get_binding();
                            String valueOf11 = String.valueOf((dialogAddMoocCourseBinding29 == null || (textInputEditText2 = dialogAddMoocCourseBinding29.etDuration) == null) ? null : textInputEditText2.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding30 = this$0.get_binding();
                            addMoocCourseViewModel2.addMoocCourseData(valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, String.valueOf((dialogAddMoocCourseBinding30 == null || (textInputEditText = dialogAddMoocCourseBinding30.etAchievements) == null) ? null : textInputEditText.getText()));
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding31 = this$0.get_binding();
                            LinearLayout linearLayout2 = dialogAddMoocCourseBinding31 != null ? dialogAddMoocCourseBinding31.completionCard : null;
                            if (linearLayout2 == null) {
                                return;
                            }
                            linearLayout2.setVisibility(8);
                            return;
                        }
                    }
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding32 = this$0.get_binding();
                    if (dialogAddMoocCourseBinding32 == null || (textView3 = dialogAddMoocCourseBinding32.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView3, "Please choose to date.");
                    return;
                }
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding33 = this$0.get_binding();
            if (dialogAddMoocCourseBinding33 == null || (textView2 = dialogAddMoocCourseBinding33.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please choose from date.");
        } catch (Exception unused) {
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding34 = this$0.get_binding();
            if (dialogAddMoocCourseBinding34 == null || (textView = dialogAddMoocCourseBinding34.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(AddMoocCourseDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextView textView3;
        TextView textView4;
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
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextView textView13;
        TextView textView14;
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddMoocCourseBinding == null || (textView20 = dialogAddMoocCourseBinding.completionFileName) == null) ? null : textView20.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding2 == null || (textInputEditText10 = dialogAddMoocCourseBinding2.etTitle) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
                        if (dialogAddMoocCourseBinding3 == null || (textView19 = dialogAddMoocCourseBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView19, "Title Cannot be empty");
                        return;
                    }
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding4 == null || (textView18 = dialogAddMoocCourseBinding4.etFromDate) == null) ? null : textView18.getText()), "")) {
                        DialogAddMoocCourseBinding dialogAddMoocCourseBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding5 == null || (textView17 = dialogAddMoocCourseBinding5.etFromDate) == null) ? null : textView17.getText()), "From Date")) {
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding6 = this$0.get_binding();
                            if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding6 == null || (textView16 = dialogAddMoocCourseBinding6.etEndDate) == null) ? null : textView16.getText()), "")) {
                                DialogAddMoocCourseBinding dialogAddMoocCourseBinding7 = this$0.get_binding();
                                if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding7 == null || (textView15 = dialogAddMoocCourseBinding7.etEndDate) == null) ? null : textView15.getText()), "To Date")) {
                                    AddMoocCourseViewModel addMoocCourseViewModel = this$0.getAddMoocCourseViewModel();
                                    String str = this$0.id;
                                    Intrinsics.checkNotNull(str);
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding8 = this$0.get_binding();
                                    String valueOf = String.valueOf((dialogAddMoocCourseBinding8 == null || (textInputEditText9 = dialogAddMoocCourseBinding8.etTitle) == null) ? null : textInputEditText9.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding9 = this$0.get_binding();
                                    String valueOf2 = String.valueOf((dialogAddMoocCourseBinding9 == null || (textInputEditText8 = dialogAddMoocCourseBinding9.etOrgaanisedBy) == null) ? null : textInputEditText8.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding10 = this$0.get_binding();
                                    String valueOf3 = String.valueOf((dialogAddMoocCourseBinding10 == null || (textView14 = dialogAddMoocCourseBinding10.etFromDate) == null) ? null : textView14.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding11 = this$0.get_binding();
                                    String valueOf4 = String.valueOf((dialogAddMoocCourseBinding11 == null || (textView13 = dialogAddMoocCourseBinding11.etEndDate) == null) ? null : textView13.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding12 = this$0.get_binding();
                                    String valueOf5 = String.valueOf((dialogAddMoocCourseBinding12 == null || (textInputEditText7 = dialogAddMoocCourseBinding12.etDuration) == null) ? null : textInputEditText7.getText());
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding13 = this$0.get_binding();
                                    String valueOf6 = String.valueOf((dialogAddMoocCourseBinding13 == null || (textInputEditText6 = dialogAddMoocCourseBinding13.etAchievements) == null) ? null : textInputEditText6.getText());
                                    File file3 = this$0.pickFile;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                        file = null;
                                    } else {
                                        file = file3;
                                    }
                                    addMoocCourseViewModel.updateMoocCourseData(str, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, file);
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding14 = this$0.get_binding();
                                    LinearLayout linearLayout = dialogAddMoocCourseBinding14 != null ? dialogAddMoocCourseBinding14.completionCard : null;
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding15 = this$0.get_binding();
                                    CardView cardView = dialogAddMoocCourseBinding15 != null ? dialogAddMoocCourseBinding15.progressView : null;
                                    if (cardView == null) {
                                        return;
                                    }
                                    cardView.setVisibility(0);
                                    return;
                                }
                            }
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding16 = this$0.get_binding();
                            if (dialogAddMoocCourseBinding16 == null || (textView12 = dialogAddMoocCourseBinding16.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView12, "Please choose to date.");
                            return;
                        }
                    }
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding17 = this$0.get_binding();
                    if (dialogAddMoocCourseBinding17 == null || (textView11 = dialogAddMoocCourseBinding17.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView11, "Please choose from date.");
                    return;
                }
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding18 = this$0.get_binding();
                if (dialogAddMoocCourseBinding18 == null || (textView10 = dialogAddMoocCourseBinding18.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView10, "File Size Limit Is 100KB");
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding19 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding19 == null || (textInputEditText5 = dialogAddMoocCourseBinding19.etTitle) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding20 = this$0.get_binding();
                if (dialogAddMoocCourseBinding20 == null || (textView9 = dialogAddMoocCourseBinding20.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView9, "Title Cannot be empty");
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding21 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding21 == null || (textView8 = dialogAddMoocCourseBinding21.etFromDate) == null) ? null : textView8.getText()), "")) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding22 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding22 == null || (textView7 = dialogAddMoocCourseBinding22.etFromDate) == null) ? null : textView7.getText()), "From Date")) {
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding23 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding23 == null || (textView6 = dialogAddMoocCourseBinding23.etEndDate) == null) ? null : textView6.getText()), "")) {
                        DialogAddMoocCourseBinding dialogAddMoocCourseBinding24 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddMoocCourseBinding24 == null || (textView5 = dialogAddMoocCourseBinding24.etEndDate) == null) ? null : textView5.getText()), "To Date")) {
                            AddMoocCourseViewModel addMoocCourseViewModel2 = this$0.getAddMoocCourseViewModel();
                            String str2 = this$0.id;
                            Intrinsics.checkNotNull(str2);
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding25 = this$0.get_binding();
                            String valueOf7 = String.valueOf((dialogAddMoocCourseBinding25 == null || (textInputEditText4 = dialogAddMoocCourseBinding25.etTitle) == null) ? null : textInputEditText4.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding26 = this$0.get_binding();
                            String valueOf8 = String.valueOf((dialogAddMoocCourseBinding26 == null || (textInputEditText3 = dialogAddMoocCourseBinding26.etOrgaanisedBy) == null) ? null : textInputEditText3.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding27 = this$0.get_binding();
                            String valueOf9 = String.valueOf((dialogAddMoocCourseBinding27 == null || (textView4 = dialogAddMoocCourseBinding27.etFromDate) == null) ? null : textView4.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding28 = this$0.get_binding();
                            String valueOf10 = String.valueOf((dialogAddMoocCourseBinding28 == null || (textView3 = dialogAddMoocCourseBinding28.etEndDate) == null) ? null : textView3.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding29 = this$0.get_binding();
                            String valueOf11 = String.valueOf((dialogAddMoocCourseBinding29 == null || (textInputEditText2 = dialogAddMoocCourseBinding29.etDuration) == null) ? null : textInputEditText2.getText());
                            DialogAddMoocCourseBinding dialogAddMoocCourseBinding30 = this$0.get_binding();
                            if (dialogAddMoocCourseBinding30 != null && (textInputEditText = dialogAddMoocCourseBinding30.etAchievements) != null) {
                                editable = textInputEditText.getText();
                            }
                            addMoocCourseViewModel2.updateMoocCourseData(str2, valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, String.valueOf(editable));
                            return;
                        }
                    }
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding31 = this$0.get_binding();
                    if (dialogAddMoocCourseBinding31 == null || (textView2 = dialogAddMoocCourseBinding31.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView2, "Please choose to date.");
                    return;
                }
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding32 = this$0.get_binding();
            if (dialogAddMoocCourseBinding32 == null || (textView = dialogAddMoocCourseBinding32.completionSelect) == null) {
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
        DialogAddMoocCourseBinding dialogAddMoocCourseBinding = get_binding();
        if (dialogAddMoocCourseBinding == null || (textInputEditText = dialogAddMoocCourseBinding.etDuration) == null) {
            return;
        }
        textInputEditText.setText(String.valueOf(between + 1));
    }

    private final void listenAddResponse() {
        getAddMoocCourseViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMoocCourseDialog.listenAddResponse$lambda$10(AddMoocCourseDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$10(AddMoocCourseDialog this$0, Resource resource) {
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
            if (dialogAddMoocCourseBinding != null && (textView = dialogAddMoocCourseBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddMoocCourseListener addMoocCourseListener = this$0.listener;
            if (addMoocCourseListener != null) {
                addMoocCourseListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
                if (dialogAddMoocCourseBinding2 != null && (addBtn2 = dialogAddMoocCourseBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddMoocCourseListener addMoocCourseListener2 = this$0.listener;
                if (addMoocCourseListener2 != null) {
                    addMoocCourseListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
            if (dialogAddMoocCourseBinding3 != null && (addBtn = dialogAddMoocCourseBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddMoocCourseListener addMoocCourseListener3 = this$0.listener;
            if (addMoocCourseListener3 != null) {
                addMoocCourseListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddMoocCourseViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMoocCourseDialog.listenAddResponse2$lambda$12(AddMoocCourseDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$12(AddMoocCourseDialog this$0, Resource resource) {
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
            if (dialogAddMoocCourseBinding != null && (textView = dialogAddMoocCourseBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddMoocCourseListener addMoocCourseListener = this$0.listener;
            if (addMoocCourseListener != null) {
                addMoocCourseListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
                if (dialogAddMoocCourseBinding2 != null && (addBtn2 = dialogAddMoocCourseBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddMoocCourseListener addMoocCourseListener2 = this$0.listener;
                if (addMoocCourseListener2 != null) {
                    addMoocCourseListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
            if (dialogAddMoocCourseBinding3 != null && (addBtn = dialogAddMoocCourseBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddMoocCourseListener addMoocCourseListener3 = this$0.listener;
            if (addMoocCourseListener3 != null) {
                addMoocCourseListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddMoocCourseViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMoocCourseDialog.listenUpdateResponse$lambda$14(AddMoocCourseDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$14(AddMoocCourseDialog this$0, Resource resource) {
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
            if (dialogAddMoocCourseBinding != null && (textView = dialogAddMoocCourseBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddMoocCourseListener addMoocCourseListener = this$0.listener;
            if (addMoocCourseListener != null) {
                addMoocCourseListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
                if (dialogAddMoocCourseBinding2 != null && (completionFileName2 = dialogAddMoocCourseBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddMoocCourseListener addMoocCourseListener2 = this$0.listener;
                if (addMoocCourseListener2 != null) {
                    addMoocCourseListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
            if (dialogAddMoocCourseBinding3 != null && (completionFileName = dialogAddMoocCourseBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddMoocCourseListener addMoocCourseListener3 = this$0.listener;
            if (addMoocCourseListener3 != null) {
                addMoocCourseListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddMoocCourseViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.mooccourse.add.AddMoocCourseDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMoocCourseDialog.listenProgressResponse$lambda$16(AddMoocCourseDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$16(AddMoocCourseDialog this$0, Resource resource) {
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding = this$0.get_binding();
            if (dialogAddMoocCourseBinding == null || (textView = dialogAddMoocCourseBinding.completionFileName) == null) {
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
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddMoocCourseBinding2 != null ? dialogAddMoocCourseBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddMoocCourseBinding dialogAddMoocCourseBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddMoocCourseBinding3 != null ? dialogAddMoocCourseBinding3.progressText : null;
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
                    DialogAddMoocCourseBinding dialogAddMoocCourseBinding = get_binding();
                    if (dialogAddMoocCourseBinding == null || (completionFileName = dialogAddMoocCourseBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddMoocCourseBinding dialogAddMoocCourseBinding2 = get_binding();
                TextView textView = dialogAddMoocCourseBinding2 != null ? dialogAddMoocCourseBinding2.completionFileName : null;
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

    public final void setCallBack(MoocCourseFragment context) {
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