package in.etuwa.app.ui.transport.registration.asiet.registration;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.hostel.asiet.HostelAsietRegisterViewResponse;
import in.etuwa.app.data.model.transportpalai.registration.RegisterSucessResponse;
import in.etuwa.app.databinding.DialogAsietTransportRegistrationBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog;
import in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegFragment;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: AsietTransRegDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AsietTransRegDialog extends BaseDialog implements AddCompanyDialog.AddCompanyListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAsietTransportRegistrationBinding _binding;

    /* JADX INFO: renamed from: asietTransRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy asietTransRegViewModel;
    private ArrayList<DownloadModel> downList;
    private AddRegistrationCallBack listener;
    private final BroadcastReceiver onDownloadComplete;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String type;
    private String url;

    /* JADX INFO: compiled from: AsietTransRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/transport/registration/asiet/registration/AsietTransRegDialog$AddRegistrationCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddRegistrationCallBack {
        void onDismiss();
    }

    @JvmStatic
    public static final AsietTransRegDialog newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(View view) {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AsietTransRegDialog() {
        final AsietTransRegDialog asietTransRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return asietTransRegDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(asietTransRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.asietTransRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(asietTransRegDialog, Reflection.getOrCreateKotlinClass(AsietTransRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AsietTransRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        final AsietTransRegDialog asietTransRegDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AsietBoardingSpinnerAdapter>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.asiet.registration.AsietBoardingSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AsietBoardingSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = asietTransRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AsietBoardingSpinnerAdapter.class), b2, function02);
            }
        });
        this.downList = new ArrayList<>();
        this.url = "";
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                TextView textView;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = this.this$0.get_binding();
                if (dialogAsietTransportRegistrationBinding != null && (textView = dialogAsietTransportRegistrationBinding.busDetailsBtn) != null) {
                    ToastExtKt.showInfoToast(textView, "Download Completed");
                }
                try {
                    ArrayList arrayList = this.this$0.downList;
                    AsietTransRegDialog asietTransRegDialog3 = this.this$0;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            asietTransRegDialog3.downList.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final AsietTransRegViewModel getAsietTransRegViewModel() {
        return (AsietTransRegViewModel) this.asietTransRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogAsietTransportRegistrationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AsietBoardingSpinnerAdapter getSpinnerAdapter() {
        return (AsietBoardingSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: compiled from: AsietTransRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/transport/registration/asiet/registration/AsietTransRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/transport/registration/asiet/registration/AsietTransRegDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AsietTransRegDialog newInstance() {
            return new AsietTransRegDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAsietTransportRegistrationBinding.inflate(inflater, container, false);
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = get_binding();
        if (dialogAsietTransportRegistrationBinding != null) {
            dialogAsietTransportRegistrationBinding.setAsietTransRegViewModel(getAsietTransRegViewModel());
        }
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding2 = get_binding();
        if (dialogAsietTransportRegistrationBinding2 != null) {
            dialogAsietTransportRegistrationBinding2.setLifecycleOwner(this);
        }
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding3 = get_binding();
        if (dialogAsietTransportRegistrationBinding3 != null) {
            return dialogAsietTransportRegistrationBinding3.getRoot();
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
        EditText editText;
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = get_binding();
        Spinner spinner = dialogAsietTransportRegistrationBinding != null ? dialogAsietTransportRegistrationBinding.spinnerBoarding : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        listenResponse();
        listenSpinner();
        getAsietTransRegViewModel().getRegHistory();
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding2 = get_binding();
        Spinner spinner2 = dialogAsietTransportRegistrationBinding2 != null ? dialogAsietTransportRegistrationBinding2.spinnerBoarding : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TextInputEditText textInputEditText;
                    AsietTransRegDialog asietTransRegDialog = AsietTransRegDialog.this;
                    asietTransRegDialog.type = asietTransRegDialog.getSpinnerAdapter().getType(position).getId().toString();
                    DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding3 = AsietTransRegDialog.this.get_binding();
                    if (dialogAsietTransportRegistrationBinding3 == null || (textInputEditText = dialogAsietTransportRegistrationBinding3.etAmount) == null) {
                        return;
                    }
                    textInputEditText.setText(AsietTransRegDialog.this.getSpinnerAdapter().getType(position).getAmount());
                }
            });
        }
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding3 = get_binding();
        if (dialogAsietTransportRegistrationBinding3 != null && (editText = dialogAsietTransportRegistrationBinding3.etDate) != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AsietTransRegDialog.setUp$lambda$1(this.f$0, i, i2, i3, view);
                }
            });
        }
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding4 = get_binding();
        if (dialogAsietTransportRegistrationBinding4 != null && (textView3 = dialogAsietTransportRegistrationBinding4.etDate2) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AsietTransRegDialog.setUp$lambda$3(this.f$0, i, i2, i3, view);
                }
            });
        }
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding5 = get_binding();
        if (dialogAsietTransportRegistrationBinding5 != null && (textView2 = dialogAsietTransportRegistrationBinding5.registerBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AsietTransRegDialog.setUp$lambda$4(view);
                }
            });
        }
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding6 = get_binding();
        if (dialogAsietTransportRegistrationBinding6 == null || (textView = dialogAsietTransportRegistrationBinding6.busDetailsBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AsietTransRegDialog.setUp$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final AsietTransRegDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$$ExternalSyntheticLambda4
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AsietTransRegDialog.setUp$lambda$1$lambda$0(this.f$0, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(AsietTransRegDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = this$0.get_binding();
        if (dialogAsietTransportRegistrationBinding == null || (editText = dialogAsietTransportRegistrationBinding.etDate) == null) {
            return;
        }
        editText.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(final AsietTransRegDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$$ExternalSyntheticLambda5
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AsietTransRegDialog.setUp$lambda$3$lambda$2(this.f$0, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$2(AsietTransRegDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = this$0.get_binding();
        if (dialogAsietTransportRegistrationBinding == null || (editText = dialogAsietTransportRegistrationBinding.etDate) == null) {
            return;
        }
        editText.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(AsietTransRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.downloadFile(this$0.url, 1);
    }

    private final void listenResponse() {
        getAsietTransRegViewModel().getAddResponse().observe(getViewLifecycleOwner(), new AsietTransRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends RegisterSucessResponse>, Unit>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AsietTransRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends RegisterSucessResponse> resource) {
                invoke2((Resource<RegisterSucessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<RegisterSucessResponse> resource) {
                TextView registerBtn;
                TextView registerBtn2;
                TextView registerBtn3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AsietTransRegDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AsietTransRegDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AsietTransRegDialog.this.hideProgress();
                    DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = AsietTransRegDialog.this.get_binding();
                    if (dialogAsietTransportRegistrationBinding == null || (textView = dialogAsietTransportRegistrationBinding.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                AsietTransRegDialog.this.hideProgress();
                RegisterSucessResponse data = resource.getData();
                if (data != null) {
                    AsietTransRegDialog asietTransRegDialog = AsietTransRegDialog.this;
                    try {
                        if (data.getSuccess()) {
                            DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding2 = asietTransRegDialog.get_binding();
                            if (dialogAsietTransportRegistrationBinding2 != null && (registerBtn3 = dialogAsietTransportRegistrationBinding2.registerBtn) != null) {
                                Intrinsics.checkNotNullExpressionValue(registerBtn3, "registerBtn");
                                ToastExtKt.showSuccessToast(registerBtn3, data.getMessage());
                            }
                            asietTransRegDialog.dismiss();
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding3 = asietTransRegDialog.get_binding();
                        if (dialogAsietTransportRegistrationBinding3 == null || (registerBtn2 = dialogAsietTransportRegistrationBinding3.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn2, data.getError());
                        Unit unit2 = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding4 = asietTransRegDialog.get_binding();
                        if (dialogAsietTransportRegistrationBinding4 == null || (registerBtn = dialogAsietTransportRegistrationBinding4.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn, "Your request for transport registration is pending for approval.");
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenSpinner() {
        getAsietTransRegViewModel().getResponse().observe(getViewLifecycleOwner(), new AsietTransRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends HostelAsietRegisterViewResponse>, Unit>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog.listenSpinner.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegDialog$listenSpinner$1$WhenMappings */
            /* JADX INFO: compiled from: AsietTransRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HostelAsietRegisterViewResponse> resource) {
                invoke2((Resource<HostelAsietRegisterViewResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<HostelAsietRegisterViewResponse> resource) {
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AsietTransRegDialog.this.hideProgress();
                    HostelAsietRegisterViewResponse data = resource.getData();
                    if (data != null) {
                        AsietTransRegDialog asietTransRegDialog = AsietTransRegDialog.this;
                        asietTransRegDialog.getSpinnerAdapter().addItems(data.getBoardings());
                        asietTransRegDialog.url = data.getRoute_url();
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AsietTransRegDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AsietTransRegDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AsietTransRegDialog.this.hideProgress();
                DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = AsietTransRegDialog.this.get_binding();
                if (dialogAsietTransportRegistrationBinding == null || (textView = dialogAsietTransportRegistrationBinding.registerBtn) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
        }));
    }

    private final void downloadFile(String url, int position) {
        Context context;
        TextView textView;
        TextView textView2;
        String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        if (new ValidChecker(contextRequireContext).checkPermission()) {
            if (checkFileExistence(strReplace)) {
                DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding = get_binding();
                if (dialogAsietTransportRegistrationBinding != null && (textView2 = dialogAsietTransportRegistrationBinding.busDetailsBtn) != null) {
                    ToastExtKt.showInfoToast(textView2, "Download Started");
                }
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                long jStartDownloading = new DownloadManagerHelper(contextRequireContext2).startDownloading(AppConstant.BUSS_PASS_PATH, url);
                Context context2 = getContext();
                if (context2 != null) {
                    context2.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
                }
                this.downList.add(new DownloadModel(jStartDownloading, position));
                return;
            }
            try {
                DialogAsietTransportRegistrationBinding dialogAsietTransportRegistrationBinding2 = get_binding();
                if (dialogAsietTransportRegistrationBinding2 != null && (textView = dialogAsietTransportRegistrationBinding2.busDetailsBtn) != null) {
                    ToastExtKt.showInfoToast(textView, "Download Started");
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                long jStartDownloading2 = new DownloadManagerHelper(contextRequireContext3).startDownloading(AppConstant.BUSS_PASS_PATH, url);
                if (Build.VERSION.SDK_INT >= 33 && (context = getContext()) != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
                }
                this.downList.add(new DownloadModel(jStartDownloading2, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
        new ValidChecker(contextRequireContext4).showPermissionDialog();
    }

    private final boolean checkFileExistence(String fileName) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new ValidChecker(contextRequireContext).checkFileExistence(fileName, AppConstant.BUSS_PASS_PATH);
    }

    public final void setAddRegistrationCallBack(AsietTransRegFragment context) {
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

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        AddRegistrationCallBack addRegistrationCallBack = this.listener;
        if (addRegistrationCallBack != null) {
            addRegistrationCallBack.onDismiss();
        }
    }
}