package in.etuwa.app.ui.profile.positionheld.add;

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
import in.etuwa.app.databinding.DialogAddPositionHeldBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.ui.profile.positionheld.PositionHeldFragment;
import in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

/* compiled from: AddPositionHeldDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0002KLB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020-H\u0002J\"\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u000108H\u0017J\u0012\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J&\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010B\u001a\u00020-H\u0016J\b\u0010C\u001a\u00020-H\u0016J\u001a\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020=2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u000e\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u00020-H\u0015J\b\u0010J\u001a\u00020-H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddPositionHeldBinding;", "achievements", "", "addPositionHeldViewModel", "Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldViewModel;", "getAddPositionHeldViewModel", "()Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldViewModel;", "addPositionHeldViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddPositionHeldBinding;", "days", "days2", TypedValues.TransitionType.S_DURATION, "firstDate", "getFirstDate", "()Ljava/lang/String;", "setFirstDate", "(Ljava/lang/String;)V", "fromDate", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldDialog$AddPositionHeldListener;", HostelFeeConfirmFragmentKt.ARG_MONTHS, "months2", "name", "organised", "pickFile", "Ljava/io/File;", "secondDate", "getSecondDate", "setSecondDate", "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "toDate", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/positionheld/PositionHeldFragment;", "setUp", "showProgress", "AddPositionHeldListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddPositionHeldDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddPositionHeldBinding _binding;
    private String achievements;

    /* renamed from: addPositionHeldViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addPositionHeldViewModel;
    private String days;
    private String days2;
    private String duration;
    private String firstDate;
    private String fromDate;
    private String id;
    private AddPositionHeldListener listener;
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

    /* compiled from: AddPositionHeldDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldDialog$AddPositionHeldListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddPositionHeldListener {
        void onDismiss();
    }

    /* compiled from: AddPositionHeldDialog.kt */
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
    public static final AddPositionHeldDialog newInstance(String str, String str2, String str3, String str4) {
        return INSTANCE.newInstance(str, str2, str3, str4);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddPositionHeldDialog() {
        final AddPositionHeldDialog addPositionHeldDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addPositionHeldDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addPositionHeldViewModel = FragmentViewModelLazyKt.createViewModelLazy(addPositionHeldDialog, Reflection.getOrCreateKotlinClass(AddPositionHeldViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddPositionHeldViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.firstDate = "2022-10-22";
        this.secondDate = "2022-10-22";
        this.months = "";
        this.days = "";
        this.months2 = "";
        this.days2 = "";
        final AddPositionHeldDialog addPositionHeldDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddPositionHeldDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addPositionHeldDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final AddPositionHeldViewModel getAddPositionHeldViewModel() {
        return (AddPositionHeldViewModel) this.addPositionHeldViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddPositionHeldBinding get_binding() {
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

    /* compiled from: AddPositionHeldDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/positionheld/add/AddPositionHeldDialog;", "id", "", "name", "fromDate", "toDate", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddPositionHeldDialog newInstance(String id, String name, String fromDate, String toDate) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(fromDate, "fromDate");
            Intrinsics.checkNotNullParameter(toDate, "toDate");
            AddPositionHeldDialog addPositionHeldDialog = new AddPositionHeldDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, name);
            bundle.putString("fixed", fromDate);
            bundle.putString("url", toDate);
            addPositionHeldDialog.setArguments(bundle);
            return addPositionHeldDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.name = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.fromDate = arguments.getString("fixed");
            this.toDate = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddPositionHeldBinding.inflate(inflater, container, false);
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding = get_binding();
        if (dialogAddPositionHeldBinding != null) {
            dialogAddPositionHeldBinding.setAddPositionHeldViewModel(getAddPositionHeldViewModel());
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = get_binding();
        if (dialogAddPositionHeldBinding2 != null) {
            dialogAddPositionHeldBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = get_binding();
        if (dialogAddPositionHeldBinding3 != null) {
            return dialogAddPositionHeldBinding3.getRoot();
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
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding = get_binding();
        Spinner spinner = dialogAddPositionHeldBinding != null ? dialogAddPositionHeldBinding.spinnerYear : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddPositionHeldViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = get_binding();
            TextView textView6 = dialogAddPositionHeldBinding2 != null ? dialogAddPositionHeldBinding2.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = get_binding();
            TextView textView7 = dialogAddPositionHeldBinding3 != null ? dialogAddPositionHeldBinding3.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding4 = get_binding();
            TextView textView8 = dialogAddPositionHeldBinding4 != null ? dialogAddPositionHeldBinding4.addBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding5 = get_binding();
            TextView textView9 = dialogAddPositionHeldBinding5 != null ? dialogAddPositionHeldBinding5.updateBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding6 = get_binding();
        if (dialogAddPositionHeldBinding6 != null && (textInputEditText = dialogAddPositionHeldBinding6.etName) != null) {
            textInputEditText.setText(this.name);
        }
        if (!Intrinsics.areEqual(this.toDate, "")) {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding7 = get_binding();
            TextView textView10 = dialogAddPositionHeldBinding7 != null ? dialogAddPositionHeldBinding7.etEndDate : null;
            if (textView10 != null) {
                textView10.setText(this.toDate);
            }
        }
        if (!Intrinsics.areEqual(this.fromDate, "")) {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding8 = get_binding();
            TextView textView11 = dialogAddPositionHeldBinding8 != null ? dialogAddPositionHeldBinding8.etFromDate : null;
            if (textView11 != null) {
                textView11.setText(this.fromDate);
            }
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding9 = get_binding();
        if (dialogAddPositionHeldBinding9 != null && (textView5 = dialogAddPositionHeldBinding9.etFromDate) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddPositionHeldDialog.setUp$lambda$2(AddPositionHeldDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding10 = get_binding();
        if (dialogAddPositionHeldBinding10 != null && (textView4 = dialogAddPositionHeldBinding10.etEndDate) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddPositionHeldDialog.setUp$lambda$4(AddPositionHeldDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding11 = get_binding();
        Spinner spinner2 = dialogAddPositionHeldBinding11 != null ? dialogAddPositionHeldBinding11.spinnerYear : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddPositionHeldDialog addPositionHeldDialog = AddPositionHeldDialog.this;
                    spinnerAdapter = addPositionHeldDialog.getSpinnerAdapter();
                    addPositionHeldDialog.yearId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding12 = get_binding();
        if (dialogAddPositionHeldBinding12 != null && (textView3 = dialogAddPositionHeldBinding12.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddPositionHeldDialog.setUp$lambda$6(AddPositionHeldDialog.this, view);
                }
            });
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding13 = get_binding();
        if (dialogAddPositionHeldBinding13 != null && (textView2 = dialogAddPositionHeldBinding13.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddPositionHeldDialog.setUp$lambda$7(AddPositionHeldDialog.this, view);
                }
            });
        }
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding14 = get_binding();
        if (dialogAddPositionHeldBinding14 == null || (textView = dialogAddPositionHeldBinding14.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddPositionHeldDialog.setUp$lambda$8(AddPositionHeldDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final AddPositionHeldDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda3
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddPositionHeldDialog.setUp$lambda$2$lambda$1(AddPositionHeldDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(AddPositionHeldDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
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
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
        if (dialogAddPositionHeldBinding == null || (textView = dialogAddPositionHeldBinding.etFromDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(final AddPositionHeldDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddPositionHeldDialog.setUp$lambda$4$lambda$3(AddPositionHeldDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4$lambda$3(AddPositionHeldDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextView textView;
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
        DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
        if (dialogAddPositionHeldBinding != null && (textView = dialogAddPositionHeldBinding.etEndDate) != null) {
            textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months2 + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days2);
        }
        this$0.secondDate = i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months2 + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(AddPositionHeldDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(AddPositionHeldDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextInputEditText textInputEditText;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextInputEditText textInputEditText2;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        File file;
        TextView textView14;
        TextView textView15;
        TextInputEditText textInputEditText3;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextInputEditText textInputEditText4;
        TextView textView21;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
            if (String.valueOf((dialogAddPositionHeldBinding == null || (textView21 = dialogAddPositionHeldBinding.completionFileName) == null) ? null : textView21.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding2 == null || (textInputEditText4 = dialogAddPositionHeldBinding2.etName) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = this$0.get_binding();
                        if (dialogAddPositionHeldBinding3 == null || (textView20 = dialogAddPositionHeldBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView20, "Name of the Position Cannot be empty");
                        return;
                    }
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding4 == null || (textView19 = dialogAddPositionHeldBinding4.etFromDate) == null) ? null : textView19.getText()), "")) {
                        DialogAddPositionHeldBinding dialogAddPositionHeldBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding5 == null || (textView18 = dialogAddPositionHeldBinding5.etFromDate) == null) ? null : textView18.getText()), "From Date")) {
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding6 = this$0.get_binding();
                            if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding6 == null || (textView17 = dialogAddPositionHeldBinding6.etEndDate) == null) ? null : textView17.getText()), "")) {
                                DialogAddPositionHeldBinding dialogAddPositionHeldBinding7 = this$0.get_binding();
                                if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding7 == null || (textView16 = dialogAddPositionHeldBinding7.etEndDate) == null) ? null : textView16.getText()), "To Date")) {
                                    AddPositionHeldViewModel addPositionHeldViewModel = this$0.getAddPositionHeldViewModel();
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding8 = this$0.get_binding();
                                    String valueOf = String.valueOf((dialogAddPositionHeldBinding8 == null || (textInputEditText3 = dialogAddPositionHeldBinding8.etName) == null) ? null : textInputEditText3.getText());
                                    String str = this$0.yearId;
                                    Intrinsics.checkNotNull(str);
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding9 = this$0.get_binding();
                                    String valueOf2 = String.valueOf((dialogAddPositionHeldBinding9 == null || (textView15 = dialogAddPositionHeldBinding9.etFromDate) == null) ? null : textView15.getText());
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding10 = this$0.get_binding();
                                    String valueOf3 = String.valueOf((dialogAddPositionHeldBinding10 == null || (textView14 = dialogAddPositionHeldBinding10.etEndDate) == null) ? null : textView14.getText());
                                    File file3 = this$0.pickFile;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                        file = null;
                                    } else {
                                        file = file3;
                                    }
                                    addPositionHeldViewModel.addPositionHeldData(valueOf, str, valueOf2, valueOf3, file);
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding11 = this$0.get_binding();
                                    LinearLayout linearLayout = dialogAddPositionHeldBinding11 != null ? dialogAddPositionHeldBinding11.completionCard : null;
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding12 = this$0.get_binding();
                                    CardView cardView = dialogAddPositionHeldBinding12 != null ? dialogAddPositionHeldBinding12.progressView : null;
                                    if (cardView == null) {
                                        return;
                                    }
                                    cardView.setVisibility(0);
                                    return;
                                }
                            }
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding13 = this$0.get_binding();
                            if (dialogAddPositionHeldBinding13 == null || (textView13 = dialogAddPositionHeldBinding13.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView13, "Please choose to date.");
                            return;
                        }
                    }
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding14 = this$0.get_binding();
                    if (dialogAddPositionHeldBinding14 == null || (textView12 = dialogAddPositionHeldBinding14.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView12, "Please choose from date.");
                    return;
                }
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding15 = this$0.get_binding();
                if (dialogAddPositionHeldBinding15 == null || (textView11 = dialogAddPositionHeldBinding15.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView11, "File Size Limit Is 100KB");
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding16 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding16 == null || (textInputEditText2 = dialogAddPositionHeldBinding16.etName) == null) ? null : textInputEditText2.getText()), "")) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding17 = this$0.get_binding();
                if (dialogAddPositionHeldBinding17 == null || (textView10 = dialogAddPositionHeldBinding17.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView10, "Name of the Position Cannot be empty");
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding18 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding18 == null || (textView9 = dialogAddPositionHeldBinding18.etFromDate) == null) ? null : textView9.getText()), "")) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding19 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding19 == null || (textView8 = dialogAddPositionHeldBinding19.etFromDate) == null) ? null : textView8.getText()), "From Date")) {
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding20 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding20 == null || (textView7 = dialogAddPositionHeldBinding20.etEndDate) == null) ? null : textView7.getText()), "")) {
                        DialogAddPositionHeldBinding dialogAddPositionHeldBinding21 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding21 == null || (textView6 = dialogAddPositionHeldBinding21.etEndDate) == null) ? null : textView6.getText()), "To Date")) {
                            AddPositionHeldViewModel addPositionHeldViewModel2 = this$0.getAddPositionHeldViewModel();
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding22 = this$0.get_binding();
                            String valueOf4 = String.valueOf((dialogAddPositionHeldBinding22 == null || (textInputEditText = dialogAddPositionHeldBinding22.etName) == null) ? null : textInputEditText.getText());
                            String str2 = this$0.yearId;
                            Intrinsics.checkNotNull(str2);
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding23 = this$0.get_binding();
                            String valueOf5 = String.valueOf((dialogAddPositionHeldBinding23 == null || (textView5 = dialogAddPositionHeldBinding23.etFromDate) == null) ? null : textView5.getText());
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding24 = this$0.get_binding();
                            addPositionHeldViewModel2.addPositionHeldData(valueOf4, str2, valueOf5, String.valueOf((dialogAddPositionHeldBinding24 == null || (textView4 = dialogAddPositionHeldBinding24.etEndDate) == null) ? null : textView4.getText()));
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding25 = this$0.get_binding();
                            LinearLayout linearLayout2 = dialogAddPositionHeldBinding25 != null ? dialogAddPositionHeldBinding25.completionCard : null;
                            if (linearLayout2 == null) {
                                return;
                            }
                            linearLayout2.setVisibility(8);
                            return;
                        }
                    }
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding26 = this$0.get_binding();
                    if (dialogAddPositionHeldBinding26 == null || (textView3 = dialogAddPositionHeldBinding26.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView3, "Please choose to date.");
                    return;
                }
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding27 = this$0.get_binding();
            if (dialogAddPositionHeldBinding27 == null || (textView2 = dialogAddPositionHeldBinding27.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please choose from date.");
        } catch (Exception unused) {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding28 = this$0.get_binding();
            if (dialogAddPositionHeldBinding28 == null || (textView = dialogAddPositionHeldBinding28.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(AddPositionHeldDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextInputEditText textInputEditText;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextInputEditText textInputEditText2;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        File file;
        TextView textView13;
        TextView textView14;
        TextInputEditText textInputEditText3;
        TextView textView15;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextInputEditText textInputEditText4;
        TextView textView20;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
            CharSequence charSequence = null;
            charSequence = null;
            if (String.valueOf((dialogAddPositionHeldBinding == null || (textView20 = dialogAddPositionHeldBinding.completionFileName) == null) ? null : textView20.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding2 == null || (textInputEditText4 = dialogAddPositionHeldBinding2.etName) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = this$0.get_binding();
                        if (dialogAddPositionHeldBinding3 == null || (textView19 = dialogAddPositionHeldBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView19, "Name of the Position Cannot be empty");
                        return;
                    }
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding4 == null || (textView18 = dialogAddPositionHeldBinding4.etFromDate) == null) ? null : textView18.getText()), "")) {
                        DialogAddPositionHeldBinding dialogAddPositionHeldBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding5 == null || (textView17 = dialogAddPositionHeldBinding5.etFromDate) == null) ? null : textView17.getText()), "From Date")) {
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding6 = this$0.get_binding();
                            if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding6 == null || (textView16 = dialogAddPositionHeldBinding6.etEndDate) == null) ? null : textView16.getText()), "")) {
                                DialogAddPositionHeldBinding dialogAddPositionHeldBinding7 = this$0.get_binding();
                                if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding7 == null || (textView15 = dialogAddPositionHeldBinding7.etEndDate) == null) ? null : textView15.getText()), "To Date")) {
                                    AddPositionHeldViewModel addPositionHeldViewModel = this$0.getAddPositionHeldViewModel();
                                    String str = this$0.id;
                                    Intrinsics.checkNotNull(str);
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding8 = this$0.get_binding();
                                    String valueOf = String.valueOf((dialogAddPositionHeldBinding8 == null || (textInputEditText3 = dialogAddPositionHeldBinding8.etName) == null) ? null : textInputEditText3.getText());
                                    String str2 = this$0.yearId;
                                    Intrinsics.checkNotNull(str2);
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding9 = this$0.get_binding();
                                    String valueOf2 = String.valueOf((dialogAddPositionHeldBinding9 == null || (textView14 = dialogAddPositionHeldBinding9.etFromDate) == null) ? null : textView14.getText());
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding10 = this$0.get_binding();
                                    String valueOf3 = String.valueOf((dialogAddPositionHeldBinding10 == null || (textView13 = dialogAddPositionHeldBinding10.etEndDate) == null) ? null : textView13.getText());
                                    File file3 = this$0.pickFile;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                        file = null;
                                    } else {
                                        file = file3;
                                    }
                                    addPositionHeldViewModel.updatePositionHeldData(str, valueOf, str2, valueOf2, valueOf3, file);
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding11 = this$0.get_binding();
                                    LinearLayout linearLayout = dialogAddPositionHeldBinding11 != null ? dialogAddPositionHeldBinding11.completionCard : null;
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding12 = this$0.get_binding();
                                    CardView cardView = dialogAddPositionHeldBinding12 != null ? dialogAddPositionHeldBinding12.progressView : null;
                                    if (cardView == null) {
                                        return;
                                    }
                                    cardView.setVisibility(0);
                                    return;
                                }
                            }
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding13 = this$0.get_binding();
                            if (dialogAddPositionHeldBinding13 == null || (textView12 = dialogAddPositionHeldBinding13.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView12, "Please choose to date.");
                            return;
                        }
                    }
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding14 = this$0.get_binding();
                    if (dialogAddPositionHeldBinding14 == null || (textView11 = dialogAddPositionHeldBinding14.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView11, "Please choose from date.");
                    return;
                }
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding15 = this$0.get_binding();
                if (dialogAddPositionHeldBinding15 == null || (textView10 = dialogAddPositionHeldBinding15.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView10, "File Size Limit Is 100KB");
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding16 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding16 == null || (textInputEditText2 = dialogAddPositionHeldBinding16.etName) == null) ? null : textInputEditText2.getText()), "")) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding17 = this$0.get_binding();
                if (dialogAddPositionHeldBinding17 == null || (textView9 = dialogAddPositionHeldBinding17.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView9, "Name of the Position Cannot be empty");
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding18 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding18 == null || (textView8 = dialogAddPositionHeldBinding18.etFromDate) == null) ? null : textView8.getText()), "")) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding19 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding19 == null || (textView7 = dialogAddPositionHeldBinding19.etFromDate) == null) ? null : textView7.getText()), "From Date")) {
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding20 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding20 == null || (textView6 = dialogAddPositionHeldBinding20.etEndDate) == null) ? null : textView6.getText()), "")) {
                        DialogAddPositionHeldBinding dialogAddPositionHeldBinding21 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddPositionHeldBinding21 == null || (textView5 = dialogAddPositionHeldBinding21.etEndDate) == null) ? null : textView5.getText()), "To Date")) {
                            AddPositionHeldViewModel addPositionHeldViewModel2 = this$0.getAddPositionHeldViewModel();
                            String str3 = this$0.id;
                            Intrinsics.checkNotNull(str3);
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding22 = this$0.get_binding();
                            String valueOf4 = String.valueOf((dialogAddPositionHeldBinding22 == null || (textInputEditText = dialogAddPositionHeldBinding22.etName) == null) ? null : textInputEditText.getText());
                            String str4 = this$0.yearId;
                            Intrinsics.checkNotNull(str4);
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding23 = this$0.get_binding();
                            String valueOf5 = String.valueOf((dialogAddPositionHeldBinding23 == null || (textView4 = dialogAddPositionHeldBinding23.etFromDate) == null) ? null : textView4.getText());
                            DialogAddPositionHeldBinding dialogAddPositionHeldBinding24 = this$0.get_binding();
                            if (dialogAddPositionHeldBinding24 != null && (textView3 = dialogAddPositionHeldBinding24.etEndDate) != null) {
                                charSequence = textView3.getText();
                            }
                            addPositionHeldViewModel2.updatePositionHeldData(str3, valueOf4, str4, valueOf5, String.valueOf(charSequence));
                            return;
                        }
                    }
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding25 = this$0.get_binding();
                    if (dialogAddPositionHeldBinding25 == null || (textView2 = dialogAddPositionHeldBinding25.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView2, "Please choose to date.");
                    return;
                }
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding26 = this$0.get_binding();
            if (dialogAddPositionHeldBinding26 == null || (textView = dialogAddPositionHeldBinding26.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please choose from date.");
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddPositionHeldViewModel().getResponse().observe(getViewLifecycleOwner(), new AddPositionHeldDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$listenSpinnerResponse$1

            /* compiled from: AddPositionHeldDialog.kt */
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
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddPositionHeldDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter = AddPositionHeldDialog.this.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getYears());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddPositionHeldDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddPositionHeldDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddPositionHeldDialog.this.hideProgress();
                dialogAddPositionHeldBinding = AddPositionHeldDialog.this.get_binding();
                if (dialogAddPositionHeldBinding == null || (spinner = dialogAddPositionHeldBinding.spinnerYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddPositionHeldViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPositionHeldDialog.listenAddResponse$lambda$10(AddPositionHeldDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$10(AddPositionHeldDialog this$0, Resource resource) {
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
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
            if (dialogAddPositionHeldBinding != null && (textView = dialogAddPositionHeldBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddPositionHeldListener addPositionHeldListener = this$0.listener;
            if (addPositionHeldListener != null) {
                addPositionHeldListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = this$0.get_binding();
                if (dialogAddPositionHeldBinding2 != null && (addBtn2 = dialogAddPositionHeldBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddPositionHeldListener addPositionHeldListener2 = this$0.listener;
                if (addPositionHeldListener2 != null) {
                    addPositionHeldListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = this$0.get_binding();
            if (dialogAddPositionHeldBinding3 != null && (addBtn = dialogAddPositionHeldBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddPositionHeldListener addPositionHeldListener3 = this$0.listener;
            if (addPositionHeldListener3 != null) {
                addPositionHeldListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddPositionHeldViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPositionHeldDialog.listenAddResponse2$lambda$12(AddPositionHeldDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$12(AddPositionHeldDialog this$0, Resource resource) {
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
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
            if (dialogAddPositionHeldBinding != null && (textView = dialogAddPositionHeldBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddPositionHeldListener addPositionHeldListener = this$0.listener;
            if (addPositionHeldListener != null) {
                addPositionHeldListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = this$0.get_binding();
                if (dialogAddPositionHeldBinding2 != null && (addBtn2 = dialogAddPositionHeldBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddPositionHeldListener addPositionHeldListener2 = this$0.listener;
                if (addPositionHeldListener2 != null) {
                    addPositionHeldListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = this$0.get_binding();
            if (dialogAddPositionHeldBinding3 != null && (addBtn = dialogAddPositionHeldBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddPositionHeldListener addPositionHeldListener3 = this$0.listener;
            if (addPositionHeldListener3 != null) {
                addPositionHeldListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddPositionHeldViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPositionHeldDialog.listenUpdateResponse$lambda$14(AddPositionHeldDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$14(AddPositionHeldDialog this$0, Resource resource) {
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
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
            if (dialogAddPositionHeldBinding != null && (textView = dialogAddPositionHeldBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddPositionHeldListener addPositionHeldListener = this$0.listener;
            if (addPositionHeldListener != null) {
                addPositionHeldListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = this$0.get_binding();
                if (dialogAddPositionHeldBinding2 != null && (completionFileName2 = dialogAddPositionHeldBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddPositionHeldListener addPositionHeldListener2 = this$0.listener;
                if (addPositionHeldListener2 != null) {
                    addPositionHeldListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = this$0.get_binding();
            if (dialogAddPositionHeldBinding3 != null && (completionFileName = dialogAddPositionHeldBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddPositionHeldListener addPositionHeldListener3 = this$0.listener;
            if (addPositionHeldListener3 != null) {
                addPositionHeldListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddPositionHeldViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.positionheld.add.AddPositionHeldDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPositionHeldDialog.listenProgressResponse$lambda$16(AddPositionHeldDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$16(AddPositionHeldDialog this$0, Resource resource) {
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
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding = this$0.get_binding();
            if (dialogAddPositionHeldBinding == null || (textView = dialogAddPositionHeldBinding.completionFileName) == null) {
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
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddPositionHeldBinding2 != null ? dialogAddPositionHeldBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddPositionHeldBinding dialogAddPositionHeldBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddPositionHeldBinding3 != null ? dialogAddPositionHeldBinding3.progressText : null;
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
                    DialogAddPositionHeldBinding dialogAddPositionHeldBinding = get_binding();
                    if (dialogAddPositionHeldBinding == null || (completionFileName = dialogAddPositionHeldBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddPositionHeldBinding dialogAddPositionHeldBinding2 = get_binding();
                TextView textView = dialogAddPositionHeldBinding2 != null ? dialogAddPositionHeldBinding2.completionFileName : null;
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

    public final void setCallBack(PositionHeldFragment context) {
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