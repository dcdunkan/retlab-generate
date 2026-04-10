package in.etuwa.app.ui.certificate_request.add_request_dialog;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextUtils;
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
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.certificaterequest.CertificateTypeResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.AddRequestDialogBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.certificate_request.CertificateRequestFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
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

/* JADX INFO: compiled from: AddRequestDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AddRequestDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddRequestDialogBinding _binding;

    /* JADX INFO: renamed from: addRequestDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addRequestDialogViewModel;
    private String certificate;
    private String certificateName;
    private String isHostler;
    private AddRequestListener listener;
    private File pickFile;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String reason;
    private String sem;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: spinnerAdapterClass$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterClass;

    /* JADX INFO: renamed from: spinnerAdapterFee$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterFee;

    /* JADX INFO: renamed from: spinnerAdapterItr$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterItr;

    /* JADX INFO: renamed from: spinnerIsHostler$delegate, reason: from kotlin metadata */
    private final Lazy spinnerIsHostler;

    /* JADX INFO: renamed from: spinnerSemAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerSemAdapter;
    private String subType;
    private AddRequestDialogViewModel viewModel;

    /* JADX INFO: compiled from: AddRequestDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialog$AddRequestListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddRequestListener {
        void dismiss();
    }

    /* JADX INFO: compiled from: AddRequestDialog.kt */
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

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddRequestDialog() {
        final AddRequestDialog addRequestDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return addRequestDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addRequestDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addRequestDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(addRequestDialog, Reflection.getOrCreateKotlinClass(AddRequestDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AddRequestDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.certificate = "";
        this.certificateName = "";
        this.subType = "";
        final AddRequestDialog addRequestDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.sem = "";
        this.isHostler = "1";
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CertificateTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.certificate_request.add_request_dialog.CertificateTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CertificateTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CertificateTypeSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$spinnerSemAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerSemAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b5, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$spinnerAdapterClass$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerAdapterClass = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<CertioficateType2SpinnerAdapter>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.certificate_request.add_request_dialog.CertioficateType2SpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CertioficateType2SpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CertioficateType2SpinnerAdapter.class), b6, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$spinnerAdapterItr$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        this.spinnerAdapterItr = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<CertioficateType2SpinnerAdapter>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.certificate_request.add_request_dialog.CertioficateType2SpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CertioficateType2SpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CertioficateType2SpinnerAdapter.class), b7, function05);
            }
        });
        final Function0<ParametersHolder> function06 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$spinnerAdapterFee$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        this.spinnerAdapterFee = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<CertioficateType2SpinnerAdapter>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.certificate_request.add_request_dialog.CertioficateType2SpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CertioficateType2SpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CertioficateType2SpinnerAdapter.class), b8, function06);
            }
        });
        final Function0<ParametersHolder> function07 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$spinnerIsHostler$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode7 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b9 = 0 == true ? 1 : 0;
        this.spinnerIsHostler = LazyKt.lazy(lazyThreadSafetyMode7, (Function0) new Function0<CertificateIsHostlerSpinnerAdapter>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.certificate_request.add_request_dialog.CertificateIsHostlerSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CertificateIsHostlerSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addRequestDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CertificateIsHostlerSpinnerAdapter.class), b9, function07);
            }
        });
    }

    private final AddRequestDialogViewModel getAddRequestDialogViewModel() {
        return (AddRequestDialogViewModel) this.addRequestDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final AddRequestDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: AddRequestDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddRequestDialog newInstance() {
            return new AddRequestDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CertificateTypeSpinnerAdapter getSpinnerAdapter() {
        return (CertificateTypeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerSemAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerSemAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CertioficateType2SpinnerAdapter getSpinnerAdapterClass() {
        return (CertioficateType2SpinnerAdapter) this.spinnerAdapterClass.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CertioficateType2SpinnerAdapter getSpinnerAdapterItr() {
        return (CertioficateType2SpinnerAdapter) this.spinnerAdapterItr.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CertioficateType2SpinnerAdapter getSpinnerAdapterFee() {
        return (CertioficateType2SpinnerAdapter) this.spinnerAdapterFee.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CertificateIsHostlerSpinnerAdapter getSpinnerIsHostler() {
        return (CertificateIsHostlerSpinnerAdapter) this.spinnerIsHostler.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AddRequestDialogBinding.inflate(inflater, container, false);
        AddRequestDialogBinding addRequestDialogBinding = get_binding();
        if (addRequestDialogBinding != null) {
            addRequestDialogBinding.setAddRequestDialogViewModel(getAddRequestDialogViewModel());
        }
        AddRequestDialogBinding addRequestDialogBinding2 = get_binding();
        if (addRequestDialogBinding2 != null) {
            addRequestDialogBinding2.setLifecycleOwner(this);
        }
        AddRequestDialogBinding addRequestDialogBinding3 = get_binding();
        if (addRequestDialogBinding3 != null) {
            return addRequestDialogBinding3.getRoot();
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
        TextInputEditText textInputEditText;
        AddRequestDialogBinding addRequestDialogBinding = get_binding();
        Spinner spinner = addRequestDialogBinding != null ? addRequestDialogBinding.spinnerCertificateList : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        AddRequestDialogBinding addRequestDialogBinding2 = get_binding();
        Spinner spinner2 = addRequestDialogBinding2 != null ? addRequestDialogBinding2.spinnerRequestOpted : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapterItr());
        }
        AddRequestDialogBinding addRequestDialogBinding3 = get_binding();
        Spinner spinner3 = addRequestDialogBinding3 != null ? addRequestDialogBinding3.spinnerOriginalCert : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapterClass());
        }
        AddRequestDialogBinding addRequestDialogBinding4 = get_binding();
        Spinner spinner4 = addRequestDialogBinding4 != null ? addRequestDialogBinding4.spinnerSemester2 : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getSpinnerSemAdapter());
        }
        AddRequestDialogBinding addRequestDialogBinding5 = get_binding();
        Spinner spinner5 = addRequestDialogBinding5 != null ? addRequestDialogBinding5.spinnerHostler : null;
        if (spinner5 != null) {
            spinner5.setAdapter((SpinnerAdapter) getSpinnerIsHostler());
        }
        certificateTypeSpinnerResponse();
        listenApplyResponse();
        listenProgressResponse();
        semSpinnerResponse();
        getAddRequestDialogViewModel().getSemester();
        getSpinnerIsHostler().addItems(CollectionsKt.arrayListOf("Yes", "No"));
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "//mea", false, 2, (Object) null)) {
            AddRequestDialogBinding addRequestDialogBinding6 = get_binding();
            LinearLayout linearLayout = addRequestDialogBinding6 != null ? addRequestDialogBinding6.completionCard : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            AddRequestDialogBinding addRequestDialogBinding7 = get_binding();
            LinearLayout linearLayout2 = addRequestDialogBinding7 != null ? addRequestDialogBinding7.completionCard : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        AddRequestDialogBinding addRequestDialogBinding8 = get_binding();
        Spinner spinner6 = addRequestDialogBinding8 != null ? addRequestDialogBinding8.spinnerCertificateList : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Spinner spinner7;
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    addRequestDialog.certificate = addRequestDialog.getSpinnerAdapter().getType(position).getId();
                    if ((!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Tuition", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) && (!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Tuition", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                        if ((!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Bank", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) && (!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Bank", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                            if ((!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Original", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) && (!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Original", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                                if ((!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Fee Change", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) && (!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Fee Change", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                                    if ((!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Bonafide", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null)) && (!StringsKt.contains$default((CharSequence) AddRequestDialog.this.getSpinnerAdapter().getType(position).getType(), (CharSequence) "Bonafide", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) AddRequestDialog.this.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null))) {
                                        AddRequestDialog.this.certificateName = "";
                                        AddRequestDialogBinding addRequestDialogBinding9 = AddRequestDialog.this.get_binding();
                                        TextInputEditText textInputEditText2 = addRequestDialogBinding9 != null ? addRequestDialogBinding9.reasonText : null;
                                        if (textInputEditText2 != null) {
                                            textInputEditText2.setVisibility(0);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding10 = AddRequestDialog.this.get_binding();
                                        TextInputEditText textInputEditText3 = addRequestDialogBinding10 != null ? addRequestDialogBinding10.bankNameText : null;
                                        if (textInputEditText3 != null) {
                                            textInputEditText3.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding11 = AddRequestDialog.this.get_binding();
                                        TextInputEditText textInputEditText4 = addRequestDialogBinding11 != null ? addRequestDialogBinding11.bankAdressText : null;
                                        if (textInputEditText4 != null) {
                                            textInputEditText4.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding12 = AddRequestDialog.this.get_binding();
                                        LinearLayout linearLayout3 = addRequestDialogBinding12 != null ? addRequestDialogBinding12.originalCertLyt : null;
                                        if (linearLayout3 != null) {
                                            linearLayout3.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding13 = AddRequestDialog.this.get_binding();
                                        LinearLayout linearLayout4 = addRequestDialogBinding13 != null ? addRequestDialogBinding13.itrLyt : null;
                                        if (linearLayout4 != null) {
                                            linearLayout4.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding14 = AddRequestDialog.this.get_binding();
                                        LinearLayout linearLayout5 = addRequestDialogBinding14 != null ? addRequestDialogBinding14.feeLyt : null;
                                        if (linearLayout5 != null) {
                                            linearLayout5.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding15 = AddRequestDialog.this.get_binding();
                                        LinearLayout linearLayout6 = addRequestDialogBinding15 != null ? addRequestDialogBinding15.cgpaLyt : null;
                                        if (linearLayout6 != null) {
                                            linearLayout6.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding16 = AddRequestDialog.this.get_binding();
                                        TextView textView3 = addRequestDialogBinding16 != null ? addRequestDialogBinding16.isHostlerTv : null;
                                        if (textView3 != null) {
                                            textView3.setVisibility(8);
                                        }
                                        AddRequestDialogBinding addRequestDialogBinding17 = AddRequestDialog.this.get_binding();
                                        spinner7 = addRequestDialogBinding17 != null ? addRequestDialogBinding17.spinnerHostler : null;
                                        if (spinner7 == null) {
                                            return;
                                        }
                                        spinner7.setVisibility(8);
                                        return;
                                    }
                                    AddRequestDialog.this.certificateName = "Bonafide";
                                    AddRequestDialogBinding addRequestDialogBinding18 = AddRequestDialog.this.get_binding();
                                    TextInputEditText textInputEditText5 = addRequestDialogBinding18 != null ? addRequestDialogBinding18.bankNameText : null;
                                    if (textInputEditText5 != null) {
                                        textInputEditText5.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding19 = AddRequestDialog.this.get_binding();
                                    TextInputEditText textInputEditText6 = addRequestDialogBinding19 != null ? addRequestDialogBinding19.bankAdressText : null;
                                    if (textInputEditText6 != null) {
                                        textInputEditText6.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding20 = AddRequestDialog.this.get_binding();
                                    LinearLayout linearLayout7 = addRequestDialogBinding20 != null ? addRequestDialogBinding20.originalCertLyt : null;
                                    if (linearLayout7 != null) {
                                        linearLayout7.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding21 = AddRequestDialog.this.get_binding();
                                    LinearLayout linearLayout8 = addRequestDialogBinding21 != null ? addRequestDialogBinding21.itrLyt : null;
                                    if (linearLayout8 != null) {
                                        linearLayout8.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding22 = AddRequestDialog.this.get_binding();
                                    LinearLayout linearLayout9 = addRequestDialogBinding22 != null ? addRequestDialogBinding22.feeLyt : null;
                                    if (linearLayout9 != null) {
                                        linearLayout9.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding23 = AddRequestDialog.this.get_binding();
                                    LinearLayout linearLayout10 = addRequestDialogBinding23 != null ? addRequestDialogBinding23.commonLayout : null;
                                    if (linearLayout10 != null) {
                                        linearLayout10.setVisibility(0);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding24 = AddRequestDialog.this.get_binding();
                                    LinearLayout linearLayout11 = addRequestDialogBinding24 != null ? addRequestDialogBinding24.cgpaLyt : null;
                                    if (linearLayout11 != null) {
                                        linearLayout11.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding25 = AddRequestDialog.this.get_binding();
                                    TextInputEditText textInputEditText7 = addRequestDialogBinding25 != null ? addRequestDialogBinding25.reasonText : null;
                                    if (textInputEditText7 != null) {
                                        textInputEditText7.setVisibility(0);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding26 = AddRequestDialog.this.get_binding();
                                    TextView textView4 = addRequestDialogBinding26 != null ? addRequestDialogBinding26.isHostlerTv : null;
                                    if (textView4 != null) {
                                        textView4.setVisibility(8);
                                    }
                                    AddRequestDialogBinding addRequestDialogBinding27 = AddRequestDialog.this.get_binding();
                                    spinner7 = addRequestDialogBinding27 != null ? addRequestDialogBinding27.spinnerHostler : null;
                                    if (spinner7 == null) {
                                        return;
                                    }
                                    spinner7.setVisibility(8);
                                    return;
                                }
                                AddRequestDialog.this.certificateName = "Fee Change";
                                AddRequestDialogBinding addRequestDialogBinding28 = AddRequestDialog.this.get_binding();
                                TextInputEditText textInputEditText8 = addRequestDialogBinding28 != null ? addRequestDialogBinding28.bankNameText : null;
                                if (textInputEditText8 != null) {
                                    textInputEditText8.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding29 = AddRequestDialog.this.get_binding();
                                TextInputEditText textInputEditText9 = addRequestDialogBinding29 != null ? addRequestDialogBinding29.bankAdressText : null;
                                if (textInputEditText9 != null) {
                                    textInputEditText9.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding30 = AddRequestDialog.this.get_binding();
                                LinearLayout linearLayout12 = addRequestDialogBinding30 != null ? addRequestDialogBinding30.originalCertLyt : null;
                                if (linearLayout12 != null) {
                                    linearLayout12.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding31 = AddRequestDialog.this.get_binding();
                                LinearLayout linearLayout13 = addRequestDialogBinding31 != null ? addRequestDialogBinding31.itrLyt : null;
                                if (linearLayout13 != null) {
                                    linearLayout13.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding32 = AddRequestDialog.this.get_binding();
                                LinearLayout linearLayout14 = addRequestDialogBinding32 != null ? addRequestDialogBinding32.feeLyt : null;
                                if (linearLayout14 != null) {
                                    linearLayout14.setVisibility(0);
                                }
                                AddRequestDialogBinding addRequestDialogBinding33 = AddRequestDialog.this.get_binding();
                                LinearLayout linearLayout15 = addRequestDialogBinding33 != null ? addRequestDialogBinding33.commonLayout : null;
                                if (linearLayout15 != null) {
                                    linearLayout15.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding34 = AddRequestDialog.this.get_binding();
                                LinearLayout linearLayout16 = addRequestDialogBinding34 != null ? addRequestDialogBinding34.cgpaLyt : null;
                                if (linearLayout16 != null) {
                                    linearLayout16.setVisibility(0);
                                }
                                AddRequestDialogBinding addRequestDialogBinding35 = AddRequestDialog.this.get_binding();
                                TextInputEditText textInputEditText10 = addRequestDialogBinding35 != null ? addRequestDialogBinding35.reasonText : null;
                                if (textInputEditText10 != null) {
                                    textInputEditText10.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding36 = AddRequestDialog.this.get_binding();
                                TextView textView5 = addRequestDialogBinding36 != null ? addRequestDialogBinding36.isHostlerTv : null;
                                if (textView5 != null) {
                                    textView5.setVisibility(8);
                                }
                                AddRequestDialogBinding addRequestDialogBinding37 = AddRequestDialog.this.get_binding();
                                spinner7 = addRequestDialogBinding37 != null ? addRequestDialogBinding37.spinnerHostler : null;
                                if (spinner7 == null) {
                                    return;
                                }
                                spinner7.setVisibility(8);
                                return;
                            }
                            AddRequestDialog.this.certificateName = "Original";
                            AddRequestDialogBinding addRequestDialogBinding38 = AddRequestDialog.this.get_binding();
                            TextInputEditText textInputEditText11 = addRequestDialogBinding38 != null ? addRequestDialogBinding38.reasonText : null;
                            if (textInputEditText11 != null) {
                                textInputEditText11.setVisibility(0);
                            }
                            AddRequestDialogBinding addRequestDialogBinding39 = AddRequestDialog.this.get_binding();
                            TextInputEditText textInputEditText12 = addRequestDialogBinding39 != null ? addRequestDialogBinding39.bankNameText : null;
                            if (textInputEditText12 != null) {
                                textInputEditText12.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding40 = AddRequestDialog.this.get_binding();
                            TextInputEditText textInputEditText13 = addRequestDialogBinding40 != null ? addRequestDialogBinding40.bankAdressText : null;
                            if (textInputEditText13 != null) {
                                textInputEditText13.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding41 = AddRequestDialog.this.get_binding();
                            LinearLayout linearLayout17 = addRequestDialogBinding41 != null ? addRequestDialogBinding41.commonLayout : null;
                            if (linearLayout17 != null) {
                                linearLayout17.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding42 = AddRequestDialog.this.get_binding();
                            LinearLayout linearLayout18 = addRequestDialogBinding42 != null ? addRequestDialogBinding42.originalCertLyt : null;
                            if (linearLayout18 != null) {
                                linearLayout18.setVisibility(0);
                            }
                            AddRequestDialogBinding addRequestDialogBinding43 = AddRequestDialog.this.get_binding();
                            LinearLayout linearLayout19 = addRequestDialogBinding43 != null ? addRequestDialogBinding43.itrLyt : null;
                            if (linearLayout19 != null) {
                                linearLayout19.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding44 = AddRequestDialog.this.get_binding();
                            LinearLayout linearLayout20 = addRequestDialogBinding44 != null ? addRequestDialogBinding44.feeLyt : null;
                            if (linearLayout20 != null) {
                                linearLayout20.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding45 = AddRequestDialog.this.get_binding();
                            LinearLayout linearLayout21 = addRequestDialogBinding45 != null ? addRequestDialogBinding45.cgpaLyt : null;
                            if (linearLayout21 != null) {
                                linearLayout21.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding46 = AddRequestDialog.this.get_binding();
                            TextView textView6 = addRequestDialogBinding46 != null ? addRequestDialogBinding46.isHostlerTv : null;
                            if (textView6 != null) {
                                textView6.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding47 = AddRequestDialog.this.get_binding();
                            spinner7 = addRequestDialogBinding47 != null ? addRequestDialogBinding47.spinnerHostler : null;
                            if (spinner7 == null) {
                                return;
                            }
                            spinner7.setVisibility(8);
                            return;
                        }
                        AddRequestDialog.this.certificateName = "Bank";
                        AddRequestDialogBinding addRequestDialogBinding48 = AddRequestDialog.this.get_binding();
                        TextInputEditText textInputEditText14 = addRequestDialogBinding48 != null ? addRequestDialogBinding48.reasonText : null;
                        if (textInputEditText14 != null) {
                            textInputEditText14.setVisibility(0);
                        }
                        AddRequestDialogBinding addRequestDialogBinding49 = AddRequestDialog.this.get_binding();
                        TextInputEditText textInputEditText15 = addRequestDialogBinding49 != null ? addRequestDialogBinding49.bankNameText : null;
                        if (textInputEditText15 != null) {
                            textInputEditText15.setVisibility(0);
                        }
                        AddRequestDialogBinding addRequestDialogBinding50 = AddRequestDialog.this.get_binding();
                        TextInputEditText textInputEditText16 = addRequestDialogBinding50 != null ? addRequestDialogBinding50.bankAdressText : null;
                        if (textInputEditText16 != null) {
                            textInputEditText16.setVisibility(0);
                        }
                        AddRequestDialogBinding addRequestDialogBinding51 = AddRequestDialog.this.get_binding();
                        LinearLayout linearLayout22 = addRequestDialogBinding51 != null ? addRequestDialogBinding51.commonLayout : null;
                        if (linearLayout22 != null) {
                            linearLayout22.setVisibility(0);
                        }
                        AddRequestDialogBinding addRequestDialogBinding52 = AddRequestDialog.this.get_binding();
                        LinearLayout linearLayout23 = addRequestDialogBinding52 != null ? addRequestDialogBinding52.originalCertLyt : null;
                        if (linearLayout23 != null) {
                            linearLayout23.setVisibility(8);
                        }
                        AddRequestDialogBinding addRequestDialogBinding53 = AddRequestDialog.this.get_binding();
                        LinearLayout linearLayout24 = addRequestDialogBinding53 != null ? addRequestDialogBinding53.itrLyt : null;
                        if (linearLayout24 != null) {
                            linearLayout24.setVisibility(8);
                        }
                        AddRequestDialogBinding addRequestDialogBinding54 = AddRequestDialog.this.get_binding();
                        LinearLayout linearLayout25 = addRequestDialogBinding54 != null ? addRequestDialogBinding54.feeLyt : null;
                        if (linearLayout25 != null) {
                            linearLayout25.setVisibility(8);
                        }
                        AddRequestDialogBinding addRequestDialogBinding55 = AddRequestDialog.this.get_binding();
                        LinearLayout linearLayout26 = addRequestDialogBinding55 != null ? addRequestDialogBinding55.cgpaLyt : null;
                        if (linearLayout26 != null) {
                            linearLayout26.setVisibility(8);
                        }
                        AddRequestDialogBinding addRequestDialogBinding56 = AddRequestDialog.this.get_binding();
                        TextView textView7 = addRequestDialogBinding56 != null ? addRequestDialogBinding56.isHostlerTv : null;
                        if (textView7 != null) {
                            textView7.setVisibility(0);
                        }
                        AddRequestDialogBinding addRequestDialogBinding57 = AddRequestDialog.this.get_binding();
                        spinner7 = addRequestDialogBinding57 != null ? addRequestDialogBinding57.spinnerHostler : null;
                        if (spinner7 == null) {
                            return;
                        }
                        spinner7.setVisibility(0);
                        return;
                    }
                    AddRequestDialog.this.certificateName = "Tuition";
                    AddRequestDialogBinding addRequestDialogBinding58 = AddRequestDialog.this.get_binding();
                    TextInputEditText textInputEditText17 = addRequestDialogBinding58 != null ? addRequestDialogBinding58.reasonText : null;
                    if (textInputEditText17 != null) {
                        textInputEditText17.setVisibility(0);
                    }
                    AddRequestDialogBinding addRequestDialogBinding59 = AddRequestDialog.this.get_binding();
                    TextInputEditText textInputEditText18 = addRequestDialogBinding59 != null ? addRequestDialogBinding59.bankNameText : null;
                    if (textInputEditText18 != null) {
                        textInputEditText18.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding60 = AddRequestDialog.this.get_binding();
                    TextInputEditText textInputEditText19 = addRequestDialogBinding60 != null ? addRequestDialogBinding60.bankAdressText : null;
                    if (textInputEditText19 != null) {
                        textInputEditText19.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding61 = AddRequestDialog.this.get_binding();
                    LinearLayout linearLayout27 = addRequestDialogBinding61 != null ? addRequestDialogBinding61.originalCertLyt : null;
                    if (linearLayout27 != null) {
                        linearLayout27.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding62 = AddRequestDialog.this.get_binding();
                    LinearLayout linearLayout28 = addRequestDialogBinding62 != null ? addRequestDialogBinding62.itrLyt : null;
                    if (linearLayout28 != null) {
                        linearLayout28.setVisibility(0);
                    }
                    AddRequestDialogBinding addRequestDialogBinding63 = AddRequestDialog.this.get_binding();
                    LinearLayout linearLayout29 = addRequestDialogBinding63 != null ? addRequestDialogBinding63.commonLayout : null;
                    if (linearLayout29 != null) {
                        linearLayout29.setVisibility(0);
                    }
                    AddRequestDialogBinding addRequestDialogBinding64 = AddRequestDialog.this.get_binding();
                    LinearLayout linearLayout30 = addRequestDialogBinding64 != null ? addRequestDialogBinding64.feeLyt : null;
                    if (linearLayout30 != null) {
                        linearLayout30.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding65 = AddRequestDialog.this.get_binding();
                    LinearLayout linearLayout31 = addRequestDialogBinding65 != null ? addRequestDialogBinding65.cgpaLyt : null;
                    if (linearLayout31 != null) {
                        linearLayout31.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding66 = AddRequestDialog.this.get_binding();
                    TextView textView8 = addRequestDialogBinding66 != null ? addRequestDialogBinding66.isHostlerTv : null;
                    if (textView8 != null) {
                        textView8.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding67 = AddRequestDialog.this.get_binding();
                    spinner7 = addRequestDialogBinding67 != null ? addRequestDialogBinding67.spinnerHostler : null;
                    if (spinner7 == null) {
                        return;
                    }
                    spinner7.setVisibility(8);
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding9 = get_binding();
        if (addRequestDialogBinding9 != null && (textInputEditText = addRequestDialogBinding9.monthYearCgpaEt) != null) {
            textInputEditText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddRequestDialog.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding10 = get_binding();
        Spinner spinner7 = addRequestDialogBinding10 != null ? addRequestDialogBinding10.spinnerOriginalCert : null;
        if (spinner7 != null) {
            spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.setUp.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    addRequestDialog.subType = addRequestDialog.getSpinnerAdapterClass().getType(position).getName();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding11 = get_binding();
        Spinner spinner8 = addRequestDialogBinding11 != null ? addRequestDialogBinding11.spinnerHostler : null;
        if (spinner8 != null) {
            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.setUp.4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    addRequestDialog.isHostler = addRequestDialog.getSpinnerIsHostler().getType(position);
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding12 = get_binding();
        Spinner spinner9 = addRequestDialogBinding12 != null ? addRequestDialogBinding12.spinnerSemester2 : null;
        if (spinner9 != null) {
            spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.setUp.5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    addRequestDialog.sem = addRequestDialog.getSpinnerSemAdapter().getSemester(position).getId();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding13 = get_binding();
        Spinner spinner10 = addRequestDialogBinding13 != null ? addRequestDialogBinding13.spinnerRequestOpted : null;
        if (spinner10 != null) {
            spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.setUp.6
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    addRequestDialog.subType = addRequestDialog.getSpinnerAdapterItr().getType(position).getName();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding14 = get_binding();
        Spinner spinner11 = addRequestDialogBinding14 != null ? addRequestDialogBinding14.spinnerSemester2 : null;
        if (spinner11 != null) {
            spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.setUp.7
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    addRequestDialog.sem = addRequestDialog.getSpinnerAdapterItr().getType(position).getName();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding15 = get_binding();
        if (addRequestDialogBinding15 != null && (textView2 = addRequestDialogBinding15.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddRequestDialog.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding16 = get_binding();
        if (addRequestDialogBinding16 == null || (textView = addRequestDialogBinding16.submitBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddRequestDialog.setUp$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final AddRequestDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda4
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AddRequestDialog.setUp$lambda$1$lambda$0(this.f$0, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        try {
            View viewFindViewById = datePickerDialog.getDatePicker().findViewById(Resources.getSystem().getIdentifier("android:id/day", null, null));
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(AddRequestDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = new SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(new SimpleDateFormat("yyyy-M", Locale.getDefault()).parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1)));
        AddRequestDialogBinding addRequestDialogBinding = this$0.get_binding();
        if (addRequestDialogBinding == null || (textInputEditText = addRequestDialogBinding.monthYearCgpaEt) == null) {
            return;
        }
        textInputEditText.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddRequestDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddRequestDialog addRequestDialog, View view) {
        TextView textView;
        TextView textView2;
        TextInputEditText textInputEditText;
        TextView textView3;
        TextInputEditText textInputEditText2;
        TextView textView4;
        Object obj;
        Object obj2;
        Object obj3;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        TextInputEditText textInputEditText16;
        TextInputEditText textInputEditText17;
        TextInputEditText textInputEditText18;
        Object obj4;
        Object obj5;
        TextInputEditText textInputEditText19;
        TextInputEditText textInputEditText20;
        TextInputEditText textInputEditText21;
        TextInputEditText textInputEditText22;
        TextInputEditText textInputEditText23;
        TextInputEditText textInputEditText24;
        TextInputEditText textInputEditText25;
        TextInputEditText textInputEditText26;
        TextInputEditText textInputEditText27;
        TextInputEditText textInputEditText28;
        TextInputEditText textInputEditText29;
        TextInputEditText textInputEditText30;
        TextInputEditText textInputEditText31;
        TextInputEditText textInputEditText32;
        TextInputEditText textInputEditText33;
        TextInputEditText textInputEditText34;
        TextInputEditText textInputEditText35;
        TextInputEditText textInputEditText36;
        TextInputEditText textInputEditText37;
        TextInputEditText textInputEditText38;
        TextInputEditText textInputEditText39;
        TextInputEditText textInputEditText40;
        TextInputEditText textInputEditText41;
        TextInputEditText textInputEditText42;
        TextInputEditText textInputEditText43;
        TextInputEditText textInputEditText44;
        TextInputEditText textInputEditText45;
        TextInputEditText textInputEditText46;
        TextInputEditText textInputEditText47;
        TextInputEditText textInputEditText48;
        TextInputEditText textInputEditText49;
        TextInputEditText textInputEditText50;
        TextInputEditText textInputEditText51;
        TextInputEditText textInputEditText52;
        TextInputEditText textInputEditText53;
        TextInputEditText textInputEditText54;
        TextInputEditText textInputEditText55;
        TextInputEditText textInputEditText56;
        TextInputEditText textInputEditText57;
        TextInputEditText textInputEditText58;
        TextInputEditText textInputEditText59;
        TextInputEditText textInputEditText60;
        TextInputEditText textInputEditText61;
        TextInputEditText textInputEditText62;
        AddRequestDialog this$0 = addRequestDialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddRequestDialogBinding addRequestDialogBinding = addRequestDialog.get_binding();
        text = null;
        Editable text = null;
        this$0.reason = String.valueOf((addRequestDialogBinding == null || (textInputEditText62 = addRequestDialogBinding.reasonText) == null) ? null : textInputEditText62.getText());
        if (StringsKt.contains$default((CharSequence) addRequestDialog.getPreference().getBaseUrl(), (CharSequence) "//mea", false, 2, (Object) null)) {
            try {
                AddRequestDialogBinding addRequestDialogBinding2 = addRequestDialog.get_binding();
                if (String.valueOf((addRequestDialogBinding2 == null || (textView4 = addRequestDialogBinding2.completionFileName) == null) ? null : textView4.getText()).length() > 0) {
                    File file = this$0.pickFile;
                    if (file == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    }
                    if (file.length() / ((long) 1024) <= 200) {
                        this$0.setCancelable(false);
                        AddRequestDialogBinding addRequestDialogBinding3 = addRequestDialog.get_binding();
                        if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding3 == null || (textInputEditText2 = addRequestDialogBinding3.reasonText) == null) ? null : textInputEditText2.getText()), "")) {
                            AddRequestDialogBinding addRequestDialogBinding4 = addRequestDialog.get_binding();
                            if (addRequestDialogBinding4 == null || (textView3 = addRequestDialogBinding4.completionSelect) == null) {
                                return;
                            }
                            ToastExtKt.showInfoToast(textView3, "Please enter a valid reason");
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        AddRequestDialogViewModel addRequestDialogViewModel = addRequestDialog.getAddRequestDialogViewModel();
                        String str = this$0.certificate;
                        AddRequestDialogBinding addRequestDialogBinding5 = addRequestDialog.get_binding();
                        String strValueOf = String.valueOf((addRequestDialogBinding5 == null || (textInputEditText = addRequestDialogBinding5.reasonText) == null) ? null : textInputEditText.getText());
                        File file2 = this$0.pickFile;
                        if (file2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                            file2 = null;
                        }
                        addRequestDialogViewModel.applyDutyLeaveApiCall(str, strValueOf, file2);
                        AddRequestDialogBinding addRequestDialogBinding6 = addRequestDialog.get_binding();
                        LinearLayout linearLayout = addRequestDialogBinding6 != null ? addRequestDialogBinding6.completionCard : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        AddRequestDialogBinding addRequestDialogBinding7 = addRequestDialog.get_binding();
                        LinearLayout linearLayout2 = addRequestDialogBinding7 != null ? addRequestDialogBinding7.progressView : null;
                        if (linearLayout2 == null) {
                            return;
                        }
                        linearLayout2.setVisibility(0);
                        return;
                    }
                    AddRequestDialogBinding addRequestDialogBinding8 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding8 == null || (textView2 = addRequestDialogBinding8.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView2, "File Size Limit Is 200KB");
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding9 = addRequestDialog.get_binding();
                if (addRequestDialogBinding9 == null || (textView = addRequestDialogBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Please Select A File");
                Unit unit3 = Unit.INSTANCE;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (StringsKt.contains$default((CharSequence) addRequestDialog.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) addRequestDialog.getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) addRequestDialog.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
            HashMap map = new HashMap();
            map.clear();
            HashMap map2 = map;
            String str2 = this$0.reason;
            Intrinsics.checkNotNull(str2);
            map2.put("CertificateApplication[reason]", str2);
            map2.put("certificate", this$0.certificate);
            AddRequestDialogBinding addRequestDialogBinding10 = addRequestDialog.get_binding();
            if (TextUtils.isEmpty(String.valueOf((addRequestDialogBinding10 == null || (textInputEditText59 = addRequestDialogBinding10.reasonText) == null) ? null : textInputEditText59.getText())) && !Intrinsics.areEqual(this$0.certificateName, "Fee Change")) {
                AddRequestDialogBinding addRequestDialogBinding11 = addRequestDialog.get_binding();
                if (addRequestDialogBinding11 == null || (textInputEditText58 = addRequestDialogBinding11.reasonText) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textInputEditText58, "Please enter a valid reason");
                Unit unit4 = Unit.INSTANCE;
                return;
            }
            if (Intrinsics.areEqual(this$0.certificateName, "Tuition")) {
                map2.put("request_opted", this$0.subType);
                map2.put("class_selected", "");
                map2.put("request_for", "");
                map2.put("name_ofcourse", "");
                map2.put("cgpa_current", "");
                map2.put("semester_for", "");
                map2.put("cgpa1_afterexam", "");
                map2.put("month_ofexam", "");
                map2.put("cgpa2_afterrevaluation", "");
                map2.put("bank_name", "");
                map2.put("bank_address", "");
                map2.put("course_from", "");
                map2.put("course_to", "");
                AddRequestDialogBinding addRequestDialogBinding12 = addRequestDialog.get_binding();
                map2.put("parent_name", String.valueOf((addRequestDialogBinding12 == null || (textInputEditText57 = addRequestDialogBinding12.nameOfParentItr) == null) ? null : textInputEditText57.getText()));
                AddRequestDialogBinding addRequestDialogBinding13 = addRequestDialog.get_binding();
                map2.put("house_name", String.valueOf((addRequestDialogBinding13 == null || (textInputEditText56 = addRequestDialogBinding13.houseNameItr) == null) ? null : textInputEditText56.getText()));
                AddRequestDialogBinding addRequestDialogBinding14 = addRequestDialog.get_binding();
                map2.put("street", String.valueOf((addRequestDialogBinding14 == null || (textInputEditText55 = addRequestDialogBinding14.streetItr) == null) ? null : textInputEditText55.getText()));
                AddRequestDialogBinding addRequestDialogBinding15 = addRequestDialog.get_binding();
                map2.put("post_office", String.valueOf((addRequestDialogBinding15 == null || (textInputEditText54 = addRequestDialogBinding15.postOfficeItr) == null) ? null : textInputEditText54.getText()));
                AddRequestDialogBinding addRequestDialogBinding16 = addRequestDialog.get_binding();
                map2.put("district", String.valueOf((addRequestDialogBinding16 == null || (textInputEditText53 = addRequestDialogBinding16.districtItr) == null) ? null : textInputEditText53.getText()));
                AddRequestDialogBinding addRequestDialogBinding17 = addRequestDialog.get_binding();
                map2.put("state", String.valueOf((addRequestDialogBinding17 == null || (textInputEditText52 = addRequestDialogBinding17.stateItr) == null) ? null : textInputEditText52.getText()));
                AddRequestDialogBinding addRequestDialogBinding18 = addRequestDialog.get_binding();
                map2.put("pin_code", String.valueOf((addRequestDialogBinding18 == null || (textInputEditText51 = addRequestDialogBinding18.pinCodeItr) == null) ? null : textInputEditText51.getText()));
                obj3 = "Fee Change";
                obj2 = "Bank";
                obj = "Bonafide";
            } else {
                if (Intrinsics.areEqual(this$0.certificateName, "Bonafide")) {
                    map2.put("request_opted", "");
                    map2.put("class_selected", "");
                    map2.put("request_for", "");
                    map2.put("name_ofcourse", "");
                    map2.put("cgpa_current", "");
                    map2.put("semester_for", "");
                    map2.put("cgpa1_afterexam", "");
                    map2.put("month_ofexam", "");
                    map2.put("cgpa2_afterrevaluation", "");
                    map2.put("bank_name", "");
                    map2.put("bank_address", "");
                    map2.put("course_from", "");
                    map2.put("course_to", "");
                    AddRequestDialogBinding addRequestDialogBinding19 = addRequestDialog.get_binding();
                    map2.put("parent_name", String.valueOf((addRequestDialogBinding19 == null || (textInputEditText18 = addRequestDialogBinding19.nameOfParentItr) == null) ? null : textInputEditText18.getText()));
                    AddRequestDialogBinding addRequestDialogBinding20 = addRequestDialog.get_binding();
                    map2.put("house_name", String.valueOf((addRequestDialogBinding20 == null || (textInputEditText17 = addRequestDialogBinding20.houseNameItr) == null) ? null : textInputEditText17.getText()));
                    AddRequestDialogBinding addRequestDialogBinding21 = addRequestDialog.get_binding();
                    map2.put("street", String.valueOf((addRequestDialogBinding21 == null || (textInputEditText16 = addRequestDialogBinding21.streetItr) == null) ? null : textInputEditText16.getText()));
                    AddRequestDialogBinding addRequestDialogBinding22 = addRequestDialog.get_binding();
                    map2.put("post_office", String.valueOf((addRequestDialogBinding22 == null || (textInputEditText15 = addRequestDialogBinding22.postOfficeItr) == null) ? null : textInputEditText15.getText()));
                    AddRequestDialogBinding addRequestDialogBinding23 = addRequestDialog.get_binding();
                    map2.put("district", String.valueOf((addRequestDialogBinding23 == null || (textInputEditText14 = addRequestDialogBinding23.districtItr) == null) ? null : textInputEditText14.getText()));
                    AddRequestDialogBinding addRequestDialogBinding24 = addRequestDialog.get_binding();
                    map2.put("state", String.valueOf((addRequestDialogBinding24 == null || (textInputEditText13 = addRequestDialogBinding24.stateItr) == null) ? null : textInputEditText13.getText()));
                    AddRequestDialogBinding addRequestDialogBinding25 = addRequestDialog.get_binding();
                    map2.put("pin_code", String.valueOf((addRequestDialogBinding25 == null || (textInputEditText12 = addRequestDialogBinding25.pinCodeItr) == null) ? null : textInputEditText12.getText()));
                    addRequestDialog.getAddRequestDialogViewModel().applyRequest(map2);
                    obj = "Bonafide";
                    obj3 = "Fee Change";
                    obj2 = "Bank";
                } else {
                    obj = "Bonafide";
                    if (Intrinsics.areEqual(addRequestDialog.certificateName, "Bank")) {
                        map2.put("request_opted", "");
                        map2.put("class_selected", "");
                        map2.put("request_for", "");
                        map2.put("name_ofcourse", "");
                        map2.put("cgpa_current", "");
                        map2.put("semester_for", "");
                        map2.put("cgpa1_afterexam", "");
                        map2.put("month_ofexam", "");
                        map2.put("cgpa2_afterrevaluation", "");
                        map2.put("course_from", "");
                        map2.put("course_to", "");
                        AddRequestDialogBinding addRequestDialogBinding26 = addRequestDialog.get_binding();
                        map2.put("parent_name", String.valueOf((addRequestDialogBinding26 == null || (textInputEditText11 = addRequestDialogBinding26.nameOfParentItr) == null) ? null : textInputEditText11.getText()));
                        AddRequestDialogBinding addRequestDialogBinding27 = addRequestDialog.get_binding();
                        map2.put("house_name", String.valueOf((addRequestDialogBinding27 == null || (textInputEditText10 = addRequestDialogBinding27.houseNameItr) == null) ? null : textInputEditText10.getText()));
                        AddRequestDialogBinding addRequestDialogBinding28 = addRequestDialog.get_binding();
                        map2.put("street", String.valueOf((addRequestDialogBinding28 == null || (textInputEditText9 = addRequestDialogBinding28.streetItr) == null) ? null : textInputEditText9.getText()));
                        AddRequestDialogBinding addRequestDialogBinding29 = addRequestDialog.get_binding();
                        map2.put("post_office", String.valueOf((addRequestDialogBinding29 == null || (textInputEditText8 = addRequestDialogBinding29.postOfficeItr) == null) ? null : textInputEditText8.getText()));
                        AddRequestDialogBinding addRequestDialogBinding30 = addRequestDialog.get_binding();
                        map2.put("district", String.valueOf((addRequestDialogBinding30 == null || (textInputEditText7 = addRequestDialogBinding30.districtItr) == null) ? null : textInputEditText7.getText()));
                        AddRequestDialogBinding addRequestDialogBinding31 = addRequestDialog.get_binding();
                        map2.put("state", String.valueOf((addRequestDialogBinding31 == null || (textInputEditText6 = addRequestDialogBinding31.stateItr) == null) ? null : textInputEditText6.getText()));
                        AddRequestDialogBinding addRequestDialogBinding32 = addRequestDialog.get_binding();
                        map2.put("pin_code", String.valueOf((addRequestDialogBinding32 == null || (textInputEditText5 = addRequestDialogBinding32.pinCodeItr) == null) ? null : textInputEditText5.getText()));
                        AddRequestDialogBinding addRequestDialogBinding33 = addRequestDialog.get_binding();
                        map2.put("bank_name", String.valueOf((addRequestDialogBinding33 == null || (textInputEditText4 = addRequestDialogBinding33.bankNameText) == null) ? null : textInputEditText4.getText()));
                        AddRequestDialogBinding addRequestDialogBinding34 = addRequestDialog.get_binding();
                        map2.put("bank_address", String.valueOf((addRequestDialogBinding34 == null || (textInputEditText3 = addRequestDialogBinding34.bankAdressText) == null) ? null : textInputEditText3.getText()));
                        this$0 = addRequestDialog;
                        map2.put("CertificateApplication[is_hostler]", this$0.isHostler);
                        obj2 = "Bank";
                    } else {
                        obj2 = "Bank";
                        this$0 = addRequestDialog;
                        if (Intrinsics.areEqual(this$0.certificateName, "Original")) {
                            map2.put("class_selected", this$0.subType);
                            map2.put("request_opted", "");
                            map2.put("request_for", "");
                            map2.put("name_ofcourse", "");
                            map2.put("cgpa_current", "");
                            map2.put("semester_for", "");
                            map2.put("cgpa1_afterexam", "");
                            map2.put("month_ofexam", "");
                            map2.put("cgpa2_afterrevaluation", "");
                            map2.put("bank_name", "");
                            map2.put("bank_address", "");
                            map2.put("course_from", "");
                            map2.put("course_to", "");
                        } else if (Intrinsics.areEqual(this$0.certificateName, "Fee Change")) {
                            map2.put("class_selected", "");
                            map2.put("request_opted", "");
                            map2.put("request_for", "");
                            map2.put("name_ofcourse", "");
                            map2.put("cgpa_current", "");
                            map2.put("semester_for", "");
                            map2.put("cgpa1_afterexam", "");
                            map2.put("month_ofexam", "");
                            map2.put("cgpa2_afterrevaluation", "");
                            map2.put("bank_name", "");
                            map2.put("bank_address", "");
                            map2.put("course_from", "");
                            map2.put("course_to", "");
                            obj3 = "Fee Change";
                        } else {
                            obj3 = "Fee Change";
                            this$0 = addRequestDialog;
                            if (Intrinsics.areEqual(this$0.certificateName, obj3)) {
                                map2.put("request_for", this$0.subType);
                                map2.put("request_opted", "");
                                map2.put("class_selected", "");
                                map2.put("name_ofcourse", "");
                                map2.put("cgpa_current", "");
                                map2.put("semester_for", "");
                                map2.put("cgpa1_afterexam", "");
                                map2.put("month_ofexam", "");
                                map2.put("cgpa2_afterrevaluation", "");
                                map2.put("bank_name", "");
                                map2.put("bank_address", "");
                                map2.put("course_from", "");
                                map2.put("course_to", "");
                            }
                        }
                    }
                    obj3 = "Fee Change";
                }
                this$0 = addRequestDialog;
            }
            if (Intrinsics.areEqual(this$0.certificateName, "Tuition")) {
                obj4 = obj;
                obj5 = obj2;
            } else {
                obj5 = obj2;
                if (Intrinsics.areEqual(this$0.certificateName, obj5) || Intrinsics.areEqual(this$0.certificateName, "Original") || Intrinsics.areEqual(this$0.certificateName, obj3)) {
                    obj4 = obj;
                } else {
                    obj4 = obj;
                    if (!Intrinsics.areEqual(this$0.certificateName, obj4)) {
                        addRequestDialog.getAddRequestDialogViewModel().applyRequest(this$0.certificate, this$0.reason);
                        return;
                    }
                }
            }
            if (Intrinsics.areEqual(this$0.certificateName, "Tuition") || Intrinsics.areEqual(this$0.certificateName, obj4) || Intrinsics.areEqual(this$0.certificateName, obj5)) {
                AddRequestDialogBinding addRequestDialogBinding35 = addRequestDialog.get_binding();
                if (String.valueOf((addRequestDialogBinding35 == null || (textInputEditText34 = addRequestDialogBinding35.pinCodeItr) == null) ? null : textInputEditText34.getText()).length() != 6) {
                    AddRequestDialogBinding addRequestDialogBinding36 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding36 == null || (textInputEditText33 = addRequestDialogBinding36.reasonText) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textInputEditText33, "Please enter a valid PIN");
                    Unit unit5 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding37 = addRequestDialog.get_binding();
                if (!this$0.isNumeric(String.valueOf((addRequestDialogBinding37 == null || (textInputEditText32 = addRequestDialogBinding37.pinCodeItr) == null) ? null : textInputEditText32.getText()))) {
                    AddRequestDialogBinding addRequestDialogBinding38 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding38 == null || (textInputEditText31 = addRequestDialogBinding38.reasonText) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textInputEditText31, "Please enter a valid PIN");
                    Unit unit6 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding39 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding39 == null || (textInputEditText30 = addRequestDialogBinding39.nameOfParentItr) == null) ? null : textInputEditText30.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding40 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding40 == null || (textInputEditText29 = addRequestDialogBinding40.nameOfParentItr) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText29, "Name of Parent cannot be blank.");
                    Unit unit7 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding41 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding41 == null || (textInputEditText28 = addRequestDialogBinding41.houseNameItr) == null) ? null : textInputEditText28.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding42 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding42 == null || (textInputEditText27 = addRequestDialogBinding42.houseNameItr) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText27, "House Name cannot be blank.");
                    Unit unit8 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding43 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding43 == null || (textInputEditText26 = addRequestDialogBinding43.streetItr) == null) ? null : textInputEditText26.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding44 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding44 == null || (textInputEditText25 = addRequestDialogBinding44.streetItr) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText25, "Street cannot be blank.");
                    Unit unit9 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding45 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding45 == null || (textInputEditText24 = addRequestDialogBinding45.postOfficeItr) == null) ? null : textInputEditText24.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding46 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding46 == null || (textInputEditText23 = addRequestDialogBinding46.postOfficeItr) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText23, "Post Office cannot be blank.");
                    Unit unit10 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding47 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding47 == null || (textInputEditText22 = addRequestDialogBinding47.districtItr) == null) ? null : textInputEditText22.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding48 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding48 == null || (textInputEditText21 = addRequestDialogBinding48.districtItr) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText21, "District cannot be blank.");
                    Unit unit11 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding49 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding49 == null || (textInputEditText20 = addRequestDialogBinding49.stateItr) == null) ? null : textInputEditText20.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding50 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding50 == null || (textInputEditText19 = addRequestDialogBinding50.stateItr) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText19, "State cannot be blank.");
                    Unit unit12 = Unit.INSTANCE;
                    return;
                }
                addRequestDialog.getAddRequestDialogViewModel().applyRequest(map2);
                return;
            }
            if (Intrinsics.areEqual(this$0.certificateName, "Original")) {
                addRequestDialog.getAddRequestDialogViewModel().applyRequest(map2);
                return;
            }
            if (Intrinsics.areEqual(this$0.certificateName, obj3)) {
                map2.put("semester_for", this$0.sem);
                AddRequestDialogBinding addRequestDialogBinding51 = addRequestDialog.get_binding();
                map2.put("cgpa1_afterexam", String.valueOf((addRequestDialogBinding51 == null || (textInputEditText50 = addRequestDialogBinding51.cgpaExamEt) == null) ? null : textInputEditText50.getText()));
                AddRequestDialogBinding addRequestDialogBinding52 = addRequestDialog.get_binding();
                map2.put("month_ofexam", String.valueOf((addRequestDialogBinding52 == null || (textInputEditText49 = addRequestDialogBinding52.monthYearCgpaEt) == null) ? null : textInputEditText49.getText()));
                AddRequestDialogBinding addRequestDialogBinding53 = addRequestDialog.get_binding();
                map2.put("cgpa2_afterrevaluation", String.valueOf((addRequestDialogBinding53 == null || (textInputEditText48 = addRequestDialogBinding53.sgpaEt) == null) ? null : textInputEditText48.getText()));
                AddRequestDialogBinding addRequestDialogBinding54 = addRequestDialog.get_binding();
                map2.put("certificateApplication[reason]", String.valueOf((addRequestDialogBinding54 == null || (textInputEditText47 = addRequestDialogBinding54.reasonCgpaEt) == null) ? null : textInputEditText47.getText()));
                AddRequestDialogBinding addRequestDialogBinding55 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding55 == null || (textInputEditText46 = addRequestDialogBinding55.cgpaExamEt) == null) ? null : textInputEditText46.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding56 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding56 == null || (textInputEditText45 = addRequestDialogBinding56.cgpaExamEt) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText45, "CGPA field cannot be blank.");
                    Unit unit13 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding57 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding57 == null || (textInputEditText44 = addRequestDialogBinding57.monthYearCgpaEt) == null) ? null : textInputEditText44.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding58 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding58 == null || (textInputEditText43 = addRequestDialogBinding58.monthYearCgpaEt) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText43, "Month and Year cannot be blank.");
                    Unit unit14 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding59 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding59 == null || (textInputEditText42 = addRequestDialogBinding59.sgpaEt) == null) ? null : textInputEditText42.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding60 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding60 == null || (textInputEditText41 = addRequestDialogBinding60.sgpaEt) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText41, "SGPA field cannot be blank.");
                    Unit unit15 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding61 = addRequestDialog.get_binding();
                if (Intrinsics.areEqual(String.valueOf((addRequestDialogBinding61 == null || (textInputEditText40 = addRequestDialogBinding61.reasonCgpaEt) == null) ? null : textInputEditText40.getText()), "")) {
                    AddRequestDialogBinding addRequestDialogBinding62 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding62 == null || (textInputEditText39 = addRequestDialogBinding62.reasonCgpaEt) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textInputEditText39, "Please enter a valid PIN");
                    Unit unit16 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding63 = addRequestDialog.get_binding();
                if (!this$0.isNumeric(String.valueOf((addRequestDialogBinding63 == null || (textInputEditText38 = addRequestDialogBinding63.cgpaExamEt) == null) ? null : textInputEditText38.getText()))) {
                    AddRequestDialogBinding addRequestDialogBinding64 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding64 == null || (textInputEditText37 = addRequestDialogBinding64.cgpaExamEt) == null) {
                        return;
                    }
                    ToastExtKt.showErrorToast(textInputEditText37, "Please enter only valid CGPA.");
                    Unit unit17 = Unit.INSTANCE;
                    return;
                }
                AddRequestDialogBinding addRequestDialogBinding65 = addRequestDialog.get_binding();
                if (!this$0.isNumeric(String.valueOf((addRequestDialogBinding65 == null || (textInputEditText36 = addRequestDialogBinding65.sgpaEt) == null) ? null : textInputEditText36.getText()))) {
                    AddRequestDialogBinding addRequestDialogBinding66 = addRequestDialog.get_binding();
                    if (addRequestDialogBinding66 == null || (textInputEditText35 = addRequestDialogBinding66.sgpaEt) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textInputEditText35, "Please enter only valid SGPA.");
                    Unit unit18 = Unit.INSTANCE;
                    return;
                }
                addRequestDialog.getAddRequestDialogViewModel().applyRequest(map2);
                return;
            }
            return;
        }
        AddRequestDialogBinding addRequestDialogBinding67 = addRequestDialog.get_binding();
        if (addRequestDialogBinding67 != null && (textInputEditText61 = addRequestDialogBinding67.reasonText) != null) {
            text = textInputEditText61.getText();
        }
        if (TextUtils.isEmpty(String.valueOf(text))) {
            AddRequestDialogBinding addRequestDialogBinding68 = addRequestDialog.get_binding();
            if (addRequestDialogBinding68 == null || (textInputEditText60 = addRequestDialogBinding68.reasonText) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textInputEditText60, "Please enter a valid reason");
            Unit unit19 = Unit.INSTANCE;
            return;
        }
        addRequestDialog.getAddRequestDialogViewModel().applyRequest(this$0.certificate, this$0.reason);
    }

    private final void certificateTypeSpinnerResponse() {
        getAddRequestDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new AddRequestDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CertificateTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.certificateTypeSpinnerResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$certificateTypeSpinnerResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddRequestDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CertificateTypeResponse> resource) {
                invoke2((Resource<CertificateTypeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CertificateTypeResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddRequestDialog.this.hideProgress();
                    CertificateTypeResponse data = resource.getData();
                    if (data != null) {
                        AddRequestDialog addRequestDialog = AddRequestDialog.this;
                        addRequestDialog.getSpinnerAdapter().addItems(data.getCertificateType());
                        addRequestDialog.getSpinnerAdapterFee().addItems(data.getRequestFor());
                        addRequestDialog.getSpinnerAdapterClass().addItems(data.getClassSelected());
                        addRequestDialog.getSpinnerAdapterItr().addItems(data.getRequestOpted());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddRequestDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddRequestDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddRequestDialog.this.hideProgress();
                AddRequestDialogBinding addRequestDialogBinding = AddRequestDialog.this.get_binding();
                if (addRequestDialogBinding == null || (spinner = addRequestDialogBinding.spinnerCertificateList) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(spinner, "Something went Wrong!!!");
            }
        }));
    }

    private final void semSpinnerResponse() {
        getAddRequestDialogViewModel().getSemResponse().observe(getViewLifecycleOwner(), new AddRequestDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ArrayList<Semester>>, Unit>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.semSpinnerResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$semSpinnerResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddRequestDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ArrayList<Semester>> resource) {
                invoke2(resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<? extends ArrayList<Semester>> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddRequestDialog.this.hideProgress();
                    ArrayList<Semester> data = resource.getData();
                    if (data != null) {
                        AddRequestDialog.this.getSpinnerSemAdapter().addItems(data);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddRequestDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddRequestDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddRequestDialog.this.hideProgress();
                AddRequestDialogBinding addRequestDialogBinding = AddRequestDialog.this.get_binding();
                if (addRequestDialogBinding == null || (spinner = addRequestDialogBinding.spinnerCertificateList) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(spinner, "Something went Wrong!!!");
            }
        }));
    }

    private final void listenApplyResponse() {
        getAddRequestDialogViewModel().getApplyResponse().observe(getViewLifecycleOwner(), new AddRequestDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog.listenApplyResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$listenApplyResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddRequestDialog.kt */
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
                TextInputEditText reasonText;
                LinearLayout linearLayout;
                TextInputEditText reasonText2;
                TextInputEditText reasonText3;
                TextInputEditText reasonText4;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddRequestDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddRequestDialog.this.hideProgress();
                        AddRequestDialogBinding addRequestDialogBinding = AddRequestDialog.this.get_binding();
                        linearLayout = addRequestDialogBinding != null ? addRequestDialogBinding.progressView : null;
                        if (linearLayout == null) {
                            return;
                        }
                        linearLayout.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddRequestDialog.this.hideProgress();
                    AddRequestDialogBinding addRequestDialogBinding2 = AddRequestDialog.this.get_binding();
                    linearLayout = addRequestDialogBinding2 != null ? addRequestDialogBinding2.progressView : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    AddRequestDialogBinding addRequestDialogBinding3 = AddRequestDialog.this.get_binding();
                    if (addRequestDialogBinding3 == null || (textInputEditText = addRequestDialogBinding3.reasonText) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textInputEditText, message);
                    return;
                }
                AddRequestDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    try {
                        if (data.getSuccess()) {
                            AddRequestDialogBinding addRequestDialogBinding4 = addRequestDialog.get_binding();
                            linearLayout = addRequestDialogBinding4 != null ? addRequestDialogBinding4.progressView : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding5 = addRequestDialog.get_binding();
                            if (addRequestDialogBinding5 != null && (reasonText4 = addRequestDialogBinding5.reasonText) != null) {
                                Intrinsics.checkNotNullExpressionValue(reasonText4, "reasonText");
                                ToastExtKt.showSuccessToast(reasonText4, data.getMessage());
                            }
                            addRequestDialog.dismiss();
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        if (StringsKt.contains$default((CharSequence) data.getError(), (CharSequence) "Request Pending.", false, 2, (Object) null)) {
                            AddRequestDialogBinding addRequestDialogBinding6 = addRequestDialog.get_binding();
                            linearLayout = addRequestDialogBinding6 != null ? addRequestDialogBinding6.progressView : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            AddRequestDialogBinding addRequestDialogBinding7 = addRequestDialog.get_binding();
                            if (addRequestDialogBinding7 != null && (reasonText3 = addRequestDialogBinding7.reasonText) != null) {
                                Intrinsics.checkNotNullExpressionValue(reasonText3, "reasonText");
                                ToastExtKt.showErrorToast(reasonText3, data.getError());
                            }
                            addRequestDialog.dismiss();
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        AddRequestDialogBinding addRequestDialogBinding8 = addRequestDialog.get_binding();
                        linearLayout = addRequestDialogBinding8 != null ? addRequestDialogBinding8.progressView : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        AddRequestDialogBinding addRequestDialogBinding9 = addRequestDialog.get_binding();
                        if (addRequestDialogBinding9 == null || (reasonText2 = addRequestDialogBinding9.reasonText) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(reasonText2, "reasonText");
                        ToastExtKt.showErrorToast(reasonText2, data.getError());
                        Unit unit3 = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        AddRequestDialogBinding addRequestDialogBinding10 = addRequestDialog.get_binding();
                        if (addRequestDialogBinding10 == null || (reasonText = addRequestDialogBinding10.reasonText) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(reasonText, "reasonText");
                        ToastExtKt.showErrorToast(reasonText, "Something went wrong..!!");
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenProgressResponse() {
        getAddRequestDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddRequestDialog.listenProgressResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$6(AddRequestDialog this$0, Resource resource) {
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
            AddRequestDialogBinding addRequestDialogBinding = this$0.get_binding();
            if (addRequestDialogBinding == null || (textView = addRequestDialogBinding.completionFileName) == null) {
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
            float fFloatValue = f.floatValue();
            AddRequestDialogBinding addRequestDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = addRequestDialogBinding2 != null ? addRequestDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) fFloatValue);
            }
            AddRequestDialogBinding addRequestDialogBinding3 = this$0.get_binding();
            TextView textView2 = addRequestDialogBinding3 != null ? addRequestDialogBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) fFloatValue) + " %");
            }
            if (((int) fFloatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver contentResolver;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        String fileName;
        ContentResolver contentResolver2;
        String fileName2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                AddRequestDialogBinding addRequestDialogBinding = get_binding();
                TextView textView = addRequestDialogBinding != null ? addRequestDialogBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        fileName2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        fileName2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + fileName2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(parcelFileDescriptorOpenFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        fileName = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        fileName = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, fileName);
                    ByteStreamsKt.copyTo$default(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean isNumeric(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new Regex("^[0-9]+$").matches(input);
    }

    public final void setCallBack(CertificateRequestFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddRequestListener addRequestListener = this.listener;
        if (addRequestListener != null) {
            addRequestListener.dismiss();
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