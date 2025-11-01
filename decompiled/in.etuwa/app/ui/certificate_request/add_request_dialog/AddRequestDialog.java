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

/* compiled from: AddRequestDialog.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ]2\u00020\u0001:\u0002\\]B\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0014J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000fJ\b\u0010?\u001a\u00020:H\u0002J\b\u0010@\u001a\u00020:H\u0002J\"\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020:H\u0016J\b\u0010P\u001a\u00020:H\u0016J\u0010\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020SH\u0016J\u001a\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020H2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010V\u001a\u00020:H\u0002J\u000e\u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020YJ\b\u0010Z\u001a\u00020:H\u0014J\b\u0010[\u001a\u00020:H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b(\u0010%R\u001b\u0010*\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b+\u0010%R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/AddRequestDialogBinding;", "addRequestDialogViewModel", "Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialogViewModel;", "getAddRequestDialogViewModel", "()Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialogViewModel;", "addRequestDialogViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/AddRequestDialogBinding;", "certificate", "", "certificateName", "isHostler", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialog$AddRequestListener;", "pickFile", "Ljava/io/File;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "reason", "sem", "spinnerAdapter", "Lin/etuwa/app/ui/certificate_request/add_request_dialog/CertificateTypeSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/certificate_request/add_request_dialog/CertificateTypeSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapterClass", "Lin/etuwa/app/ui/certificate_request/add_request_dialog/CertioficateType2SpinnerAdapter;", "getSpinnerAdapterClass", "()Lin/etuwa/app/ui/certificate_request/add_request_dialog/CertioficateType2SpinnerAdapter;", "spinnerAdapterClass$delegate", "spinnerAdapterFee", "getSpinnerAdapterFee", "spinnerAdapterFee$delegate", "spinnerAdapterItr", "getSpinnerAdapterItr", "spinnerAdapterItr$delegate", "spinnerIsHostler", "Lin/etuwa/app/ui/certificate_request/add_request_dialog/CertificateIsHostlerSpinnerAdapter;", "getSpinnerIsHostler", "()Lin/etuwa/app/ui/certificate_request/add_request_dialog/CertificateIsHostlerSpinnerAdapter;", "spinnerIsHostler$delegate", "spinnerSemAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerSemAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerSemAdapter$delegate", "subType", "viewModel", "certificateTypeSpinnerResponse", "", "hideProgress", "isNumeric", "", "input", "listenApplyResponse", "listenProgressResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "semSpinnerResponse", "setCallBack", "context", "Lin/etuwa/app/ui/certificate_request/CertificateRequestFragment;", "setUp", "showProgress", "AddRequestListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddRequestDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddRequestDialogBinding _binding;

    /* renamed from: addRequestDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addRequestDialogViewModel;
    private String certificate;
    private String certificateName;
    private String isHostler;
    private AddRequestListener listener;
    private File pickFile;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String reason;
    private String sem;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapterClass$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterClass;

    /* renamed from: spinnerAdapterFee$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterFee;

    /* renamed from: spinnerAdapterItr$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterItr;

    /* renamed from: spinnerIsHostler$delegate, reason: from kotlin metadata */
    private final Lazy spinnerIsHostler;

    /* renamed from: spinnerSemAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerSemAdapter;
    private String subType;
    private AddRequestDialogViewModel viewModel;

    /* compiled from: AddRequestDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/certificate_request/add_request_dialog/AddRequestDialog$AddRequestListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddRequestListener {
        void dismiss();
    }

    /* compiled from: AddRequestDialog.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddRequestDialogViewModel.class), qualifier, b, null, koinScope);
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
                return ParametersHolderKt.parametersOf(AddRequestDialog.this.requireActivity());
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
                return ParametersHolderKt.parametersOf(AddRequestDialog.this.requireActivity());
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
                return ParametersHolderKt.parametersOf(AddRequestDialog.this.requireActivity());
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
                return ParametersHolderKt.parametersOf(AddRequestDialog.this.requireActivity());
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
                return ParametersHolderKt.parametersOf(AddRequestDialog.this.requireActivity());
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
                return ParametersHolderKt.parametersOf(AddRequestDialog.this.requireActivity());
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
    /* renamed from: getBinding, reason: from getter */
    public final AddRequestDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: AddRequestDialog.kt */
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
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                /* JADX WARN: Code restructure failed: missing block: B:100:0x01ef, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:101:0x01f5, code lost:
                
                    if (r6 == null) goto L125;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:102:0x01f7, code lost:
                
                    r6 = r6.itrLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:103:0x01fb, code lost:
                
                    if (r6 != null) goto L128;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:104:0x01fe, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:105:0x0201, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:106:0x0207, code lost:
                
                    if (r6 == null) goto L132;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:107:0x0209, code lost:
                
                    r6 = r6.feeLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:108:0x020d, code lost:
                
                    if (r6 != null) goto L135;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:109:0x0210, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:10:0x008f, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:110:0x0213, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:111:0x0219, code lost:
                
                    if (r6 == null) goto L139;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:112:0x021b, code lost:
                
                    r6 = r6.cgpaLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:113:0x021f, code lost:
                
                    if (r6 != null) goto L142;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:114:0x0222, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:115:0x0225, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:116:0x022b, code lost:
                
                    if (r6 == null) goto L146;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:117:0x022d, code lost:
                
                    r6 = r6.isHostlerTv;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:118:0x0231, code lost:
                
                    if (r6 != null) goto L149;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:119:0x0234, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
                
                    if (r6 == null) goto L20;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:120:0x0237, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:121:0x023d, code lost:
                
                    if (r6 == null) goto L153;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:122:0x023f, code lost:
                
                    r1 = r6.spinnerHostler;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:123:0x0241, code lost:
                
                    if (r1 != null) goto L155;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:124:0x0245, code lost:
                
                    r1.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:126:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:127:0x0230, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:128:0x021e, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:129:0x020c, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:12:0x0097, code lost:
                
                    r6 = r6.bankNameText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:130:0x01fa, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:131:0x01e8, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:132:0x01d6, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:133:0x01c4, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:134:0x01b2, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:135:0x01a0, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:139:0x018e, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "demo", false, 2, (java.lang.Object) null) != false) goto L87;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
                
                    if (r6 != null) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:143:0x0278, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "mits", false, 2, (java.lang.Object) null) == false) goto L160;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:144:0x02a8, code lost:
                
                    r5.this$0.certificateName = "Original";
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:145:0x02b3, code lost:
                
                    if (r6 == null) goto L167;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:146:0x02b5, code lost:
                
                    r6 = r6.reasonText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:147:0x02b9, code lost:
                
                    if (r6 != null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:148:0x02bc, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:149:0x02bf, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x009e, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:150:0x02c5, code lost:
                
                    if (r6 == null) goto L174;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:151:0x02c7, code lost:
                
                    r6 = r6.bankNameText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:152:0x02cb, code lost:
                
                    if (r6 != null) goto L177;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:153:0x02ce, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:154:0x02d1, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:155:0x02d7, code lost:
                
                    if (r6 == null) goto L181;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:156:0x02d9, code lost:
                
                    r6 = r6.bankAdressText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:157:0x02dd, code lost:
                
                    if (r6 != null) goto L184;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:158:0x02e0, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:159:0x02e3, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x00a1, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:160:0x02e9, code lost:
                
                    if (r6 == null) goto L188;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:161:0x02eb, code lost:
                
                    r6 = r6.commonLayout;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:162:0x02ef, code lost:
                
                    if (r6 != null) goto L191;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:163:0x02f2, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:164:0x02f5, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:165:0x02fb, code lost:
                
                    if (r6 == null) goto L195;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:166:0x02fd, code lost:
                
                    r6 = r6.originalCertLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:167:0x0301, code lost:
                
                    if (r6 != null) goto L198;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:168:0x0304, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:169:0x0307, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
                
                    if (r6 == null) goto L27;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:170:0x030d, code lost:
                
                    if (r6 == null) goto L202;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:171:0x030f, code lost:
                
                    r6 = r6.itrLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:172:0x0313, code lost:
                
                    if (r6 != null) goto L205;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:173:0x0316, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:174:0x0319, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:175:0x031f, code lost:
                
                    if (r6 == null) goto L209;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:176:0x0321, code lost:
                
                    r6 = r6.feeLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:177:0x0325, code lost:
                
                    if (r6 != null) goto L212;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:178:0x0328, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:179:0x032b, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
                
                    r6 = r6.bankAdressText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:180:0x0331, code lost:
                
                    if (r6 == null) goto L216;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:181:0x0333, code lost:
                
                    r6 = r6.cgpaLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:182:0x0337, code lost:
                
                    if (r6 != null) goto L219;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:183:0x033a, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:184:0x033d, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:185:0x0343, code lost:
                
                    if (r6 == null) goto L223;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:186:0x0345, code lost:
                
                    r6 = r6.isHostlerTv;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:187:0x0349, code lost:
                
                    if (r6 != null) goto L226;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:188:0x034c, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:189:0x034f, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x00ad, code lost:
                
                    if (r6 != null) goto L30;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:190:0x0355, code lost:
                
                    if (r6 == null) goto L230;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:191:0x0357, code lost:
                
                    r1 = r6.spinnerHostler;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:192:0x0359, code lost:
                
                    if (r1 != null) goto L232;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:193:0x035d, code lost:
                
                    r1.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:194:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:195:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:196:0x0348, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:197:0x0336, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:198:0x0324, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:199:0x0312, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x00b0, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:200:0x0300, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:201:0x02ee, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:202:0x02dc, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:203:0x02ca, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:204:0x02b8, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:208:0x02a6, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "demo", false, 2, (java.lang.Object) null) != false) goto L164;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:20:0x00b3, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:212:0x0390, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "mits", false, 2, (java.lang.Object) null) == false) goto L237;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:213:0x03c0, code lost:
                
                    r5.this$0.certificateName = "Fee Change";
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:214:0x03cb, code lost:
                
                    if (r6 == null) goto L244;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:215:0x03cd, code lost:
                
                    r6 = r6.bankNameText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:216:0x03d1, code lost:
                
                    if (r6 != null) goto L247;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:217:0x03d4, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:218:0x03d7, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:219:0x03dd, code lost:
                
                    if (r6 == null) goto L251;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
                
                    if (r6 == null) goto L34;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:220:0x03df, code lost:
                
                    r6 = r6.bankAdressText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:221:0x03e3, code lost:
                
                    if (r6 != null) goto L254;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:222:0x03e6, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:223:0x03e9, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:224:0x03ef, code lost:
                
                    if (r6 == null) goto L258;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:225:0x03f1, code lost:
                
                    r6 = r6.originalCertLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:226:0x03f5, code lost:
                
                    if (r6 != null) goto L261;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:227:0x03f8, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:228:0x03fb, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:229:0x0401, code lost:
                
                    if (r6 == null) goto L265;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
                
                    r6 = r6.originalCertLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:230:0x0403, code lost:
                
                    r6 = r6.itrLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:231:0x0407, code lost:
                
                    if (r6 != null) goto L268;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:232:0x040a, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:233:0x040d, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:234:0x0413, code lost:
                
                    if (r6 == null) goto L272;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:235:0x0415, code lost:
                
                    r6 = r6.feeLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:236:0x0419, code lost:
                
                    if (r6 != null) goto L275;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:237:0x041c, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:238:0x041f, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:239:0x0425, code lost:
                
                    if (r6 == null) goto L279;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:23:0x00bf, code lost:
                
                    if (r6 != null) goto L37;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:240:0x0427, code lost:
                
                    r6 = r6.commonLayout;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:241:0x042b, code lost:
                
                    if (r6 != null) goto L282;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:242:0x042e, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:243:0x0431, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:244:0x0437, code lost:
                
                    if (r6 == null) goto L286;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:245:0x0439, code lost:
                
                    r6 = r6.cgpaLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:246:0x043d, code lost:
                
                    if (r6 != null) goto L289;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:247:0x0440, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:248:0x0443, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:249:0x0449, code lost:
                
                    if (r6 == null) goto L293;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x00c2, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:250:0x044b, code lost:
                
                    r6 = r6.reasonText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:251:0x044f, code lost:
                
                    if (r6 != null) goto L296;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:252:0x0452, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:253:0x0455, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:254:0x045b, code lost:
                
                    if (r6 == null) goto L300;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:255:0x045d, code lost:
                
                    r6 = r6.isHostlerTv;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:256:0x0461, code lost:
                
                    if (r6 != null) goto L303;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:257:0x0464, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:258:0x0467, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:259:0x046d, code lost:
                
                    if (r6 == null) goto L307;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x00c5, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:260:0x046f, code lost:
                
                    r1 = r6.spinnerHostler;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:261:0x0471, code lost:
                
                    if (r1 != null) goto L309;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:262:0x0475, code lost:
                
                    r1.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:263:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:264:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:265:0x0460, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:266:0x044e, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:267:0x043c, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:268:0x042a, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:269:0x0418, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x00cb, code lost:
                
                    if (r6 == null) goto L41;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:270:0x0406, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:271:0x03f4, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:272:0x03e2, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:273:0x03d0, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:277:0x03be, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "demo", false, 2, (java.lang.Object) null) != false) goto L241;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x00cd, code lost:
                
                    r6 = r6.itrLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:281:0x04a7, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "mits", false, 2, (java.lang.Object) null) == false) goto L314;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:282:0x04d6, code lost:
                
                    r5.this$0.certificateName = "Bonafide";
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:283:0x04e1, code lost:
                
                    if (r6 == null) goto L321;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:284:0x04e3, code lost:
                
                    r6 = r6.bankNameText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:285:0x04e7, code lost:
                
                    if (r6 != null) goto L324;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:286:0x04ea, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:287:0x04ed, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:288:0x04f3, code lost:
                
                    if (r6 == null) goto L328;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:289:0x04f5, code lost:
                
                    r6 = r6.bankAdressText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:28:0x00d1, code lost:
                
                    if (r6 != null) goto L44;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:290:0x04f9, code lost:
                
                    if (r6 != null) goto L331;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:291:0x04fc, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:292:0x04ff, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:293:0x0505, code lost:
                
                    if (r6 == null) goto L335;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:294:0x0507, code lost:
                
                    r6 = r6.originalCertLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:295:0x050b, code lost:
                
                    if (r6 != null) goto L338;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:296:0x050e, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:297:0x0511, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:298:0x0517, code lost:
                
                    if (r6 == null) goto L342;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:299:0x0519, code lost:
                
                    r6 = r6.itrLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:29:0x00d4, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:300:0x051d, code lost:
                
                    if (r6 != null) goto L345;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:301:0x0520, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:302:0x0523, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:303:0x0529, code lost:
                
                    if (r6 == null) goto L349;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:304:0x052b, code lost:
                
                    r6 = r6.feeLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:305:0x052f, code lost:
                
                    if (r6 != null) goto L352;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:306:0x0532, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:307:0x0535, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:308:0x053b, code lost:
                
                    if (r6 == null) goto L356;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:309:0x053d, code lost:
                
                    r6 = r6.commonLayout;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x00d7, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:310:0x0541, code lost:
                
                    if (r6 != null) goto L359;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:311:0x0544, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:312:0x0547, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:313:0x054d, code lost:
                
                    if (r6 == null) goto L363;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:314:0x054f, code lost:
                
                    r6 = r6.cgpaLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:315:0x0553, code lost:
                
                    if (r6 != null) goto L366;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:316:0x0556, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:317:0x0559, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:318:0x055f, code lost:
                
                    if (r6 == null) goto L370;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:319:0x0561, code lost:
                
                    r6 = r6.reasonText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x00dd, code lost:
                
                    if (r6 == null) goto L48;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:320:0x0565, code lost:
                
                    if (r6 != null) goto L373;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:321:0x0568, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:322:0x056b, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:323:0x0571, code lost:
                
                    if (r6 == null) goto L377;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:324:0x0573, code lost:
                
                    r6 = r6.isHostlerTv;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:325:0x0577, code lost:
                
                    if (r6 != null) goto L380;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:326:0x057a, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:327:0x057d, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:328:0x0583, code lost:
                
                    if (r6 == null) goto L384;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:329:0x0585, code lost:
                
                    r1 = r6.spinnerHostler;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x00df, code lost:
                
                    r6 = r6.commonLayout;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:330:0x0587, code lost:
                
                    if (r1 != null) goto L386;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:331:0x058b, code lost:
                
                    r1.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:332:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:333:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:334:0x0576, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:335:0x0564, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:336:0x0552, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:337:0x0540, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:338:0x052e, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:339:0x051c, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x00e3, code lost:
                
                    if (r6 != null) goto L51;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:340:0x050a, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:341:0x04f8, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:342:0x04e6, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:346:0x04d4, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "demo", false, 2, (java.lang.Object) null) != false) goto L318;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:34:0x00e6, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00ef, code lost:
                
                    if (r6 == null) goto L55;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:37:0x00f1, code lost:
                
                    r6 = r6.feeLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00f5, code lost:
                
                    if (r6 != null) goto L58;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00f8, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:0x00fb, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:41:0x0101, code lost:
                
                    if (r6 == null) goto L62;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:42:0x0103, code lost:
                
                    r6 = r6.cgpaLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x0107, code lost:
                
                    if (r6 != null) goto L65;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:44:0x010a, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x010d, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x0113, code lost:
                
                    if (r6 == null) goto L69;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x0115, code lost:
                
                    r6 = r6.isHostlerTv;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x0119, code lost:
                
                    if (r6 != null) goto L72;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:49:0x011c, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0046, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "mits", false, 2, (java.lang.Object) null) == false) goto L6;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x011f, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x0125, code lost:
                
                    if (r6 == null) goto L76;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x0127, code lost:
                
                    r1 = r6.spinnerHostler;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x0129, code lost:
                
                    if (r1 != null) goto L78;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x012d, code lost:
                
                    r1.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x0106, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:5:0x0078, code lost:
                
                    r5.this$0.certificateName = "Tuition";
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x00f4, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x00e2, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:62:0x00d0, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x00be, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:65:0x009a, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:66:0x0088, code lost:
                
                    r6 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:6:0x0083, code lost:
                
                    if (r6 == null) goto L13;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:70:0x0076, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "demo", false, 2, (java.lang.Object) null) != false) goto L10;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:74:0x0160, code lost:
                
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6.getBaseUrl(), (java.lang.CharSequence) "mits", false, 2, (java.lang.Object) null) == false) goto L83;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:75:0x0190, code lost:
                
                    r5.this$0.certificateName = "Bank";
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:76:0x019b, code lost:
                
                    if (r6 == null) goto L90;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:77:0x019d, code lost:
                
                    r6 = r6.reasonText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:78:0x01a1, code lost:
                
                    if (r6 != null) goto L93;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:79:0x01a4, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:7:0x0085, code lost:
                
                    r6 = r6.reasonText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:80:0x01a7, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:0x01ad, code lost:
                
                    if (r6 == null) goto L97;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:82:0x01af, code lost:
                
                    r6 = r6.bankNameText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:83:0x01b3, code lost:
                
                    if (r6 != null) goto L100;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:84:0x01b6, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:85:0x01b9, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:86:0x01bf, code lost:
                
                    if (r6 == null) goto L104;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:87:0x01c1, code lost:
                
                    r6 = r6.bankAdressText;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x01c5, code lost:
                
                    if (r6 != null) goto L107;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:89:0x01c8, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:8:0x0089, code lost:
                
                    if (r6 != null) goto L16;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01cb, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:91:0x01d1, code lost:
                
                    if (r6 == null) goto L111;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x01d3, code lost:
                
                    r6 = r6.commonLayout;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:93:0x01d7, code lost:
                
                    if (r6 != null) goto L114;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:94:0x01da, code lost:
                
                    r6.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:95:0x01dd, code lost:
                
                    r6 = r5.this$0.get_binding();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:96:0x01e3, code lost:
                
                    if (r6 == null) goto L118;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:97:0x01e5, code lost:
                
                    r6 = r6.originalCertLyt;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01e9, code lost:
                
                    if (r6 != null) goto L121;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:99:0x01ec, code lost:
                
                    r6.setVisibility(8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:0x008c, code lost:
                
                    r6.setVisibility(0);
                 */
                @Override // android.widget.AdapterView.OnItemSelectedListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onItemSelected(android.widget.AdapterView<?> r6, android.view.View r7, int r8, long r9) {
                    /*
                        Method dump skipped, instructions count: 1592
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$1.onItemSelected(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding9 = get_binding();
        if (addRequestDialogBinding9 != null && (textInputEditText = addRequestDialogBinding9.monthYearCgpaEt) != null) {
            textInputEditText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddRequestDialog.setUp$lambda$1(AddRequestDialog.this, view);
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding10 = get_binding();
        Spinner spinner7 = addRequestDialogBinding10 != null ? addRequestDialogBinding10.spinnerOriginalCert : null;
        if (spinner7 != null) {
            spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CertioficateType2SpinnerAdapter spinnerAdapterClass;
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    spinnerAdapterClass = addRequestDialog.getSpinnerAdapterClass();
                    addRequestDialog.subType = spinnerAdapterClass.getType(position).getName();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding11 = get_binding();
        Spinner spinner8 = addRequestDialogBinding11 != null ? addRequestDialogBinding11.spinnerHostler : null;
        if (spinner8 != null) {
            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CertificateIsHostlerSpinnerAdapter spinnerIsHostler;
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    spinnerIsHostler = addRequestDialog.getSpinnerIsHostler();
                    addRequestDialog.isHostler = spinnerIsHostler.getType(position);
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding12 = get_binding();
        Spinner spinner9 = addRequestDialogBinding12 != null ? addRequestDialogBinding12.spinnerSemester2 : null;
        if (spinner9 != null) {
            spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerSemAdapter;
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    spinnerSemAdapter = addRequestDialog.getSpinnerSemAdapter();
                    addRequestDialog.sem = spinnerSemAdapter.getSemester(position).getId();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding13 = get_binding();
        Spinner spinner10 = addRequestDialogBinding13 != null ? addRequestDialogBinding13.spinnerRequestOpted : null;
        if (spinner10 != null) {
            spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$6
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CertioficateType2SpinnerAdapter spinnerAdapterItr;
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    spinnerAdapterItr = addRequestDialog.getSpinnerAdapterItr();
                    addRequestDialog.subType = spinnerAdapterItr.getType(position).getName();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding14 = get_binding();
        Spinner spinner11 = addRequestDialogBinding14 != null ? addRequestDialogBinding14.spinnerSemester2 : null;
        if (spinner11 != null) {
            spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$setUp$7
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CertioficateType2SpinnerAdapter spinnerAdapterItr;
                    AddRequestDialog addRequestDialog = AddRequestDialog.this;
                    spinnerAdapterItr = addRequestDialog.getSpinnerAdapterItr();
                    addRequestDialog.sem = spinnerAdapterItr.getType(position).getName();
                }
            });
        }
        AddRequestDialogBinding addRequestDialogBinding15 = get_binding();
        if (addRequestDialogBinding15 != null && (textView2 = addRequestDialogBinding15.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddRequestDialog.setUp$lambda$3(AddRequestDialog.this, view);
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
                AddRequestDialog.setUp$lambda$4(AddRequestDialog.this, view);
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
                AddRequestDialog.setUp$lambda$1$lambda$0(AddRequestDialog.this, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        try {
            View findViewById = datePickerDialog.getDatePicker().findViewById(Resources.getSystem().getIdentifier("android:id/day", null, null));
            if (findViewById != null) {
                findViewById.setVisibility(8);
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
        String format = new SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(new SimpleDateFormat("yyyy-M", Locale.getDefault()).parse(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1)));
        AddRequestDialogBinding addRequestDialogBinding = this$0.get_binding();
        if (addRequestDialogBinding == null || (textInputEditText = addRequestDialogBinding.monthYearCgpaEt) == null) {
            return;
        }
        textInputEditText.setText(format);
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
        r2 = null;
        Editable editable = null;
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
                    if (file.length() / 1024 <= 200) {
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
                        String valueOf = String.valueOf((addRequestDialogBinding5 == null || (textInputEditText = addRequestDialogBinding5.reasonText) == null) ? null : textInputEditText.getText());
                        File file2 = this$0.pickFile;
                        if (file2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                            file2 = null;
                        }
                        addRequestDialogViewModel.applyDutyLeaveApiCall(str, valueOf, file2);
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
            HashMap hashMap = new HashMap();
            hashMap.clear();
            HashMap hashMap2 = hashMap;
            String str2 = this$0.reason;
            Intrinsics.checkNotNull(str2);
            hashMap2.put("CertificateApplication[reason]", str2);
            hashMap2.put("certificate", this$0.certificate);
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
                hashMap2.put("request_opted", this$0.subType);
                hashMap2.put("class_selected", "");
                hashMap2.put("request_for", "");
                hashMap2.put("name_ofcourse", "");
                hashMap2.put("cgpa_current", "");
                hashMap2.put("semester_for", "");
                hashMap2.put("cgpa1_afterexam", "");
                hashMap2.put("month_ofexam", "");
                hashMap2.put("cgpa2_afterrevaluation", "");
                hashMap2.put("bank_name", "");
                hashMap2.put("bank_address", "");
                hashMap2.put("course_from", "");
                hashMap2.put("course_to", "");
                AddRequestDialogBinding addRequestDialogBinding12 = addRequestDialog.get_binding();
                hashMap2.put("parent_name", String.valueOf((addRequestDialogBinding12 == null || (textInputEditText57 = addRequestDialogBinding12.nameOfParentItr) == null) ? null : textInputEditText57.getText()));
                AddRequestDialogBinding addRequestDialogBinding13 = addRequestDialog.get_binding();
                hashMap2.put("house_name", String.valueOf((addRequestDialogBinding13 == null || (textInputEditText56 = addRequestDialogBinding13.houseNameItr) == null) ? null : textInputEditText56.getText()));
                AddRequestDialogBinding addRequestDialogBinding14 = addRequestDialog.get_binding();
                hashMap2.put("street", String.valueOf((addRequestDialogBinding14 == null || (textInputEditText55 = addRequestDialogBinding14.streetItr) == null) ? null : textInputEditText55.getText()));
                AddRequestDialogBinding addRequestDialogBinding15 = addRequestDialog.get_binding();
                hashMap2.put("post_office", String.valueOf((addRequestDialogBinding15 == null || (textInputEditText54 = addRequestDialogBinding15.postOfficeItr) == null) ? null : textInputEditText54.getText()));
                AddRequestDialogBinding addRequestDialogBinding16 = addRequestDialog.get_binding();
                hashMap2.put("district", String.valueOf((addRequestDialogBinding16 == null || (textInputEditText53 = addRequestDialogBinding16.districtItr) == null) ? null : textInputEditText53.getText()));
                AddRequestDialogBinding addRequestDialogBinding17 = addRequestDialog.get_binding();
                hashMap2.put("state", String.valueOf((addRequestDialogBinding17 == null || (textInputEditText52 = addRequestDialogBinding17.stateItr) == null) ? null : textInputEditText52.getText()));
                AddRequestDialogBinding addRequestDialogBinding18 = addRequestDialog.get_binding();
                hashMap2.put("pin_code", String.valueOf((addRequestDialogBinding18 == null || (textInputEditText51 = addRequestDialogBinding18.pinCodeItr) == null) ? null : textInputEditText51.getText()));
                obj3 = "Fee Change";
                obj2 = "Bank";
                obj = "Bonafide";
            } else {
                if (Intrinsics.areEqual(this$0.certificateName, "Bonafide")) {
                    hashMap2.put("request_opted", "");
                    hashMap2.put("class_selected", "");
                    hashMap2.put("request_for", "");
                    hashMap2.put("name_ofcourse", "");
                    hashMap2.put("cgpa_current", "");
                    hashMap2.put("semester_for", "");
                    hashMap2.put("cgpa1_afterexam", "");
                    hashMap2.put("month_ofexam", "");
                    hashMap2.put("cgpa2_afterrevaluation", "");
                    hashMap2.put("bank_name", "");
                    hashMap2.put("bank_address", "");
                    hashMap2.put("course_from", "");
                    hashMap2.put("course_to", "");
                    AddRequestDialogBinding addRequestDialogBinding19 = addRequestDialog.get_binding();
                    hashMap2.put("parent_name", String.valueOf((addRequestDialogBinding19 == null || (textInputEditText18 = addRequestDialogBinding19.nameOfParentItr) == null) ? null : textInputEditText18.getText()));
                    AddRequestDialogBinding addRequestDialogBinding20 = addRequestDialog.get_binding();
                    hashMap2.put("house_name", String.valueOf((addRequestDialogBinding20 == null || (textInputEditText17 = addRequestDialogBinding20.houseNameItr) == null) ? null : textInputEditText17.getText()));
                    AddRequestDialogBinding addRequestDialogBinding21 = addRequestDialog.get_binding();
                    hashMap2.put("street", String.valueOf((addRequestDialogBinding21 == null || (textInputEditText16 = addRequestDialogBinding21.streetItr) == null) ? null : textInputEditText16.getText()));
                    AddRequestDialogBinding addRequestDialogBinding22 = addRequestDialog.get_binding();
                    hashMap2.put("post_office", String.valueOf((addRequestDialogBinding22 == null || (textInputEditText15 = addRequestDialogBinding22.postOfficeItr) == null) ? null : textInputEditText15.getText()));
                    AddRequestDialogBinding addRequestDialogBinding23 = addRequestDialog.get_binding();
                    hashMap2.put("district", String.valueOf((addRequestDialogBinding23 == null || (textInputEditText14 = addRequestDialogBinding23.districtItr) == null) ? null : textInputEditText14.getText()));
                    AddRequestDialogBinding addRequestDialogBinding24 = addRequestDialog.get_binding();
                    hashMap2.put("state", String.valueOf((addRequestDialogBinding24 == null || (textInputEditText13 = addRequestDialogBinding24.stateItr) == null) ? null : textInputEditText13.getText()));
                    AddRequestDialogBinding addRequestDialogBinding25 = addRequestDialog.get_binding();
                    hashMap2.put("pin_code", String.valueOf((addRequestDialogBinding25 == null || (textInputEditText12 = addRequestDialogBinding25.pinCodeItr) == null) ? null : textInputEditText12.getText()));
                    addRequestDialog.getAddRequestDialogViewModel().applyRequest(hashMap2);
                    obj = "Bonafide";
                    obj3 = "Fee Change";
                    obj2 = "Bank";
                } else {
                    obj = "Bonafide";
                    if (Intrinsics.areEqual(addRequestDialog.certificateName, "Bank")) {
                        hashMap2.put("request_opted", "");
                        hashMap2.put("class_selected", "");
                        hashMap2.put("request_for", "");
                        hashMap2.put("name_ofcourse", "");
                        hashMap2.put("cgpa_current", "");
                        hashMap2.put("semester_for", "");
                        hashMap2.put("cgpa1_afterexam", "");
                        hashMap2.put("month_ofexam", "");
                        hashMap2.put("cgpa2_afterrevaluation", "");
                        hashMap2.put("course_from", "");
                        hashMap2.put("course_to", "");
                        AddRequestDialogBinding addRequestDialogBinding26 = addRequestDialog.get_binding();
                        hashMap2.put("parent_name", String.valueOf((addRequestDialogBinding26 == null || (textInputEditText11 = addRequestDialogBinding26.nameOfParentItr) == null) ? null : textInputEditText11.getText()));
                        AddRequestDialogBinding addRequestDialogBinding27 = addRequestDialog.get_binding();
                        hashMap2.put("house_name", String.valueOf((addRequestDialogBinding27 == null || (textInputEditText10 = addRequestDialogBinding27.houseNameItr) == null) ? null : textInputEditText10.getText()));
                        AddRequestDialogBinding addRequestDialogBinding28 = addRequestDialog.get_binding();
                        hashMap2.put("street", String.valueOf((addRequestDialogBinding28 == null || (textInputEditText9 = addRequestDialogBinding28.streetItr) == null) ? null : textInputEditText9.getText()));
                        AddRequestDialogBinding addRequestDialogBinding29 = addRequestDialog.get_binding();
                        hashMap2.put("post_office", String.valueOf((addRequestDialogBinding29 == null || (textInputEditText8 = addRequestDialogBinding29.postOfficeItr) == null) ? null : textInputEditText8.getText()));
                        AddRequestDialogBinding addRequestDialogBinding30 = addRequestDialog.get_binding();
                        hashMap2.put("district", String.valueOf((addRequestDialogBinding30 == null || (textInputEditText7 = addRequestDialogBinding30.districtItr) == null) ? null : textInputEditText7.getText()));
                        AddRequestDialogBinding addRequestDialogBinding31 = addRequestDialog.get_binding();
                        hashMap2.put("state", String.valueOf((addRequestDialogBinding31 == null || (textInputEditText6 = addRequestDialogBinding31.stateItr) == null) ? null : textInputEditText6.getText()));
                        AddRequestDialogBinding addRequestDialogBinding32 = addRequestDialog.get_binding();
                        hashMap2.put("pin_code", String.valueOf((addRequestDialogBinding32 == null || (textInputEditText5 = addRequestDialogBinding32.pinCodeItr) == null) ? null : textInputEditText5.getText()));
                        AddRequestDialogBinding addRequestDialogBinding33 = addRequestDialog.get_binding();
                        hashMap2.put("bank_name", String.valueOf((addRequestDialogBinding33 == null || (textInputEditText4 = addRequestDialogBinding33.bankNameText) == null) ? null : textInputEditText4.getText()));
                        AddRequestDialogBinding addRequestDialogBinding34 = addRequestDialog.get_binding();
                        hashMap2.put("bank_address", String.valueOf((addRequestDialogBinding34 == null || (textInputEditText3 = addRequestDialogBinding34.bankAdressText) == null) ? null : textInputEditText3.getText()));
                        this$0 = addRequestDialog;
                        hashMap2.put("CertificateApplication[is_hostler]", this$0.isHostler);
                        obj2 = "Bank";
                    } else {
                        obj2 = "Bank";
                        this$0 = addRequestDialog;
                        if (Intrinsics.areEqual(this$0.certificateName, "Original")) {
                            hashMap2.put("class_selected", this$0.subType);
                            hashMap2.put("request_opted", "");
                            hashMap2.put("request_for", "");
                            hashMap2.put("name_ofcourse", "");
                            hashMap2.put("cgpa_current", "");
                            hashMap2.put("semester_for", "");
                            hashMap2.put("cgpa1_afterexam", "");
                            hashMap2.put("month_ofexam", "");
                            hashMap2.put("cgpa2_afterrevaluation", "");
                            hashMap2.put("bank_name", "");
                            hashMap2.put("bank_address", "");
                            hashMap2.put("course_from", "");
                            hashMap2.put("course_to", "");
                        } else if (Intrinsics.areEqual(this$0.certificateName, "Fee Change")) {
                            hashMap2.put("class_selected", "");
                            hashMap2.put("request_opted", "");
                            hashMap2.put("request_for", "");
                            hashMap2.put("name_ofcourse", "");
                            hashMap2.put("cgpa_current", "");
                            hashMap2.put("semester_for", "");
                            hashMap2.put("cgpa1_afterexam", "");
                            hashMap2.put("month_ofexam", "");
                            hashMap2.put("cgpa2_afterrevaluation", "");
                            hashMap2.put("bank_name", "");
                            hashMap2.put("bank_address", "");
                            hashMap2.put("course_from", "");
                            hashMap2.put("course_to", "");
                            obj3 = "Fee Change";
                        } else {
                            obj3 = "Fee Change";
                            this$0 = addRequestDialog;
                            if (Intrinsics.areEqual(this$0.certificateName, obj3)) {
                                hashMap2.put("request_for", this$0.subType);
                                hashMap2.put("request_opted", "");
                                hashMap2.put("class_selected", "");
                                hashMap2.put("name_ofcourse", "");
                                hashMap2.put("cgpa_current", "");
                                hashMap2.put("semester_for", "");
                                hashMap2.put("cgpa1_afterexam", "");
                                hashMap2.put("month_ofexam", "");
                                hashMap2.put("cgpa2_afterrevaluation", "");
                                hashMap2.put("bank_name", "");
                                hashMap2.put("bank_address", "");
                                hashMap2.put("course_from", "");
                                hashMap2.put("course_to", "");
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
                addRequestDialog.getAddRequestDialogViewModel().applyRequest(hashMap2);
                return;
            }
            if (Intrinsics.areEqual(this$0.certificateName, "Original")) {
                addRequestDialog.getAddRequestDialogViewModel().applyRequest(hashMap2);
                return;
            }
            if (Intrinsics.areEqual(this$0.certificateName, obj3)) {
                hashMap2.put("semester_for", this$0.sem);
                AddRequestDialogBinding addRequestDialogBinding51 = addRequestDialog.get_binding();
                hashMap2.put("cgpa1_afterexam", String.valueOf((addRequestDialogBinding51 == null || (textInputEditText50 = addRequestDialogBinding51.cgpaExamEt) == null) ? null : textInputEditText50.getText()));
                AddRequestDialogBinding addRequestDialogBinding52 = addRequestDialog.get_binding();
                hashMap2.put("month_ofexam", String.valueOf((addRequestDialogBinding52 == null || (textInputEditText49 = addRequestDialogBinding52.monthYearCgpaEt) == null) ? null : textInputEditText49.getText()));
                AddRequestDialogBinding addRequestDialogBinding53 = addRequestDialog.get_binding();
                hashMap2.put("cgpa2_afterrevaluation", String.valueOf((addRequestDialogBinding53 == null || (textInputEditText48 = addRequestDialogBinding53.sgpaEt) == null) ? null : textInputEditText48.getText()));
                AddRequestDialogBinding addRequestDialogBinding54 = addRequestDialog.get_binding();
                hashMap2.put("certificateApplication[reason]", String.valueOf((addRequestDialogBinding54 == null || (textInputEditText47 = addRequestDialogBinding54.reasonCgpaEt) == null) ? null : textInputEditText47.getText()));
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
                addRequestDialog.getAddRequestDialogViewModel().applyRequest(hashMap2);
                return;
            }
            return;
        }
        AddRequestDialogBinding addRequestDialogBinding67 = addRequestDialog.get_binding();
        if (addRequestDialogBinding67 != null && (textInputEditText61 = addRequestDialogBinding67.reasonText) != null) {
            editable = textInputEditText61.getText();
        }
        if (TextUtils.isEmpty(String.valueOf(editable))) {
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
        getAddRequestDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new AddRequestDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CertificateTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$certificateTypeSpinnerResponse$1

            /* compiled from: AddRequestDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CertificateTypeResponse> resource) {
                CertificateTypeSpinnerAdapter spinnerAdapter;
                CertioficateType2SpinnerAdapter spinnerAdapterFee;
                CertioficateType2SpinnerAdapter spinnerAdapterClass;
                CertioficateType2SpinnerAdapter spinnerAdapterItr;
                AddRequestDialogBinding addRequestDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddRequestDialog.this.hideProgress();
                    CertificateTypeResponse data = resource.getData();
                    if (data != null) {
                        AddRequestDialog addRequestDialog = AddRequestDialog.this;
                        spinnerAdapter = addRequestDialog.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getCertificateType());
                        spinnerAdapterFee = addRequestDialog.getSpinnerAdapterFee();
                        spinnerAdapterFee.addItems(data.getRequestFor());
                        spinnerAdapterClass = addRequestDialog.getSpinnerAdapterClass();
                        spinnerAdapterClass.addItems(data.getClassSelected());
                        spinnerAdapterItr = addRequestDialog.getSpinnerAdapterItr();
                        spinnerAdapterItr.addItems(data.getRequestOpted());
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
                addRequestDialogBinding = AddRequestDialog.this.get_binding();
                if (addRequestDialogBinding == null || (spinner = addRequestDialogBinding.spinnerCertificateList) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(spinner, "Something went Wrong!!!");
            }
        }));
    }

    private final void semSpinnerResponse() {
        getAddRequestDialogViewModel().getSemResponse().observe(getViewLifecycleOwner(), new AddRequestDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ArrayList<Semester>>, Unit>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$semSpinnerResponse$1

            /* compiled from: AddRequestDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<? extends ArrayList<Semester>> resource) {
                SemesterSpinnerAdapter spinnerSemAdapter;
                AddRequestDialogBinding addRequestDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddRequestDialog.this.hideProgress();
                    ArrayList<Semester> data = resource.getData();
                    if (data != null) {
                        spinnerSemAdapter = AddRequestDialog.this.getSpinnerSemAdapter();
                        spinnerSemAdapter.addItems(data);
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
                addRequestDialogBinding = AddRequestDialog.this.get_binding();
                if (addRequestDialogBinding == null || (spinner = addRequestDialogBinding.spinnerCertificateList) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(spinner, "Something went Wrong!!!");
            }
        }));
    }

    private final void listenApplyResponse() {
        getAddRequestDialogViewModel().getApplyResponse().observe(getViewLifecycleOwner(), new AddRequestDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialog$listenApplyResponse$1

            /* compiled from: AddRequestDialog.kt */
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
                AddRequestDialogBinding addRequestDialogBinding;
                TextInputEditText reasonText;
                AddRequestDialogBinding addRequestDialogBinding2;
                LinearLayout linearLayout;
                AddRequestDialogBinding addRequestDialogBinding3;
                TextInputEditText reasonText2;
                AddRequestDialogBinding addRequestDialogBinding4;
                AddRequestDialogBinding addRequestDialogBinding5;
                TextInputEditText reasonText3;
                AddRequestDialogBinding addRequestDialogBinding6;
                AddRequestDialogBinding addRequestDialogBinding7;
                TextInputEditText reasonText4;
                AddRequestDialogBinding addRequestDialogBinding8;
                AddRequestDialogBinding addRequestDialogBinding9;
                AddRequestDialogBinding addRequestDialogBinding10;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddRequestDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddRequestDialog.this.hideProgress();
                        addRequestDialogBinding8 = AddRequestDialog.this.get_binding();
                        linearLayout = addRequestDialogBinding8 != null ? addRequestDialogBinding8.progressView : null;
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
                    addRequestDialogBinding9 = AddRequestDialog.this.get_binding();
                    linearLayout = addRequestDialogBinding9 != null ? addRequestDialogBinding9.progressView : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    addRequestDialogBinding10 = AddRequestDialog.this.get_binding();
                    if (addRequestDialogBinding10 == null || (textInputEditText = addRequestDialogBinding10.reasonText) == null) {
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
                            addRequestDialogBinding6 = addRequestDialog.get_binding();
                            linearLayout = addRequestDialogBinding6 != null ? addRequestDialogBinding6.progressView : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            addRequestDialogBinding7 = addRequestDialog.get_binding();
                            if (addRequestDialogBinding7 != null && (reasonText4 = addRequestDialogBinding7.reasonText) != null) {
                                Intrinsics.checkNotNullExpressionValue(reasonText4, "reasonText");
                                ToastExtKt.showSuccessToast(reasonText4, data.getMessage());
                            }
                            addRequestDialog.dismiss();
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        if (StringsKt.contains$default((CharSequence) data.getError(), (CharSequence) "Request Pending.", false, 2, (Object) null)) {
                            addRequestDialogBinding4 = addRequestDialog.get_binding();
                            linearLayout = addRequestDialogBinding4 != null ? addRequestDialogBinding4.progressView : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            addRequestDialogBinding5 = addRequestDialog.get_binding();
                            if (addRequestDialogBinding5 != null && (reasonText3 = addRequestDialogBinding5.reasonText) != null) {
                                Intrinsics.checkNotNullExpressionValue(reasonText3, "reasonText");
                                ToastExtKt.showErrorToast(reasonText3, data.getError());
                            }
                            addRequestDialog.dismiss();
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        addRequestDialogBinding2 = addRequestDialog.get_binding();
                        linearLayout = addRequestDialogBinding2 != null ? addRequestDialogBinding2.progressView : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        addRequestDialogBinding3 = addRequestDialog.get_binding();
                        if (addRequestDialogBinding3 == null || (reasonText2 = addRequestDialogBinding3.reasonText) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(reasonText2, "reasonText");
                        ToastExtKt.showErrorToast(reasonText2, data.getError());
                        Unit unit3 = Unit.INSTANCE;
                    } catch (NullPointerException unused) {
                        addRequestDialogBinding = addRequestDialog.get_binding();
                        if (addRequestDialogBinding == null || (reasonText = addRequestDialogBinding.reasonText) == null) {
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
                AddRequestDialog.listenProgressResponse$lambda$6(AddRequestDialog.this, (Resource) obj);
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
            float floatValue = f.floatValue();
            AddRequestDialogBinding addRequestDialogBinding2 = this$0.get_binding();
            ProgressBar progressBar = addRequestDialogBinding2 != null ? addRequestDialogBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            AddRequestDialogBinding addRequestDialogBinding3 = this$0.get_binding();
            TextView textView2 = addRequestDialogBinding3 != null ? addRequestDialogBinding3.progressText : null;
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
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str;
        ContentResolver contentResolver2;
        String str2;
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
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + str2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str);
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
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