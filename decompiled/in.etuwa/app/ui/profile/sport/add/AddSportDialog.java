package in.etuwa.app.ui.profile.sport.add;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
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
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddSportBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmFragmentKt;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter;
import in.etuwa.app.ui.profile.sport.SportFragment;
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

/* compiled from: AddSportDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0002KLB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020-H\u0002J\"\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u000108H\u0017J\u0012\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J&\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010B\u001a\u00020-H\u0016J\b\u0010C\u001a\u00020-H\u0016J\u001a\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020=2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u000e\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u00020-H\u0015J\b\u0010J\u001a\u00020-H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b\"\u0010\u001fR\u001b\u0010$\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b%\u0010\u001fR\u001b\u0010'\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b(\u0010\u001fR\u0010\u0010*\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lin/etuwa/app/ui/profile/sport/add/AddSportDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddSportBinding;", "addSportViewModel", "Lin/etuwa/app/ui/profile/sport/add/AddSportViewModel;", "getAddSportViewModel", "()Lin/etuwa/app/ui/profile/sport/add/AddSportViewModel;", "addSportViewModel$delegate", "Lkotlin/Lazy;", "award", "", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddSportBinding;", "competitionName", "date", "days", "id", FirebaseAnalytics.Param.LEVEL, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/sport/add/AddSportDialog$AddSportListener;", HostelFeeConfirmFragmentKt.ARG_MONTHS, "name", "organised", "pickFile", "Ljava/io/File;", "spinnerAdapterL", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapterL", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapterL$delegate", "spinnerAdapterN", "getSpinnerAdapterN", "spinnerAdapterN$delegate", "spinnerAdapterT", "getSpinnerAdapterT", "spinnerAdapterT$delegate", "spinnerAdapterY", "getSpinnerAdapterY", "spinnerAdapterY$delegate", "type", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/sport/SportFragment;", "setUp", "showProgress", "AddSportListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddSportDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddSportBinding _binding;

    /* renamed from: addSportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addSportViewModel;
    private String award;
    private String competitionName;
    private String date;
    private String days;
    private String id;
    private String level;
    private AddSportListener listener;
    private String months;
    private String name;
    private String organised;
    private File pickFile;

    /* renamed from: spinnerAdapterL$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterL;

    /* renamed from: spinnerAdapterN$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterN;

    /* renamed from: spinnerAdapterT$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterT;

    /* renamed from: spinnerAdapterY$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapterY;
    private String type;
    private String yearId;

    /* compiled from: AddSportDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/sport/add/AddSportDialog$AddSportListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddSportListener {
        void onDismiss();
    }

    /* compiled from: AddSportDialog.kt */
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
    public static final AddSportDialog newInstance(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddSportDialog() {
        final AddSportDialog addSportDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addSportDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addSportViewModel = FragmentViewModelLazyKt.createViewModelLazy(addSportDialog, Reflection.getOrCreateKotlinClass(AddSportViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddSportViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.months = "";
        this.days = "";
        final AddSportDialog addSportDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$spinnerAdapterN$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddSportDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapterN = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addSportDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$spinnerAdapterT$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddSportDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapterT = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addSportDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$spinnerAdapterL$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddSportDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapterL = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addSportDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b4, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$spinnerAdapterY$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddSportDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerAdapterY = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addSportDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b5, function05);
            }
        });
    }

    private final AddSportViewModel getAddSportViewModel() {
        return (AddSportViewModel) this.addSportViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddSportBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapterN() {
        return (IndexSpinnerAdapter) this.spinnerAdapterN.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapterT() {
        return (IndexSpinnerAdapter) this.spinnerAdapterT.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapterL() {
        return (IndexSpinnerAdapter) this.spinnerAdapterL.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapterY() {
        return (IndexSpinnerAdapter) this.spinnerAdapterY.getValue();
    }

    /* compiled from: AddSportDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/profile/sport/add/AddSportDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/sport/add/AddSportDialog;", "id", "", "name", "organised", "date", "award", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddSportDialog newInstance(String id, String name, String organised, String date, String award) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(organised, "organised");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(award, "award");
            AddSportDialog addSportDialog = new AddSportDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, name);
            bundle.putString("fine", organised);
            bundle.putString(FullDayDialogKt.ARG_BTN, date);
            bundle.putString("cat", award);
            addSportDialog.setArguments(bundle);
            return addSportDialog;
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
            this.date = arguments.getString(FullDayDialogKt.ARG_BTN);
            this.award = arguments.getString("cat");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddSportBinding.inflate(inflater, container, false);
        DialogAddSportBinding dialogAddSportBinding = get_binding();
        if (dialogAddSportBinding != null) {
            dialogAddSportBinding.setAddSportViewModel(getAddSportViewModel());
        }
        DialogAddSportBinding dialogAddSportBinding2 = get_binding();
        if (dialogAddSportBinding2 != null) {
            dialogAddSportBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddSportBinding dialogAddSportBinding3 = get_binding();
        if (dialogAddSportBinding3 != null) {
            return dialogAddSportBinding3.getRoot();
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
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        DialogAddSportBinding dialogAddSportBinding = get_binding();
        Spinner spinner = dialogAddSportBinding != null ? dialogAddSportBinding.spinnerType : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapterT());
        }
        DialogAddSportBinding dialogAddSportBinding2 = get_binding();
        Spinner spinner2 = dialogAddSportBinding2 != null ? dialogAddSportBinding2.spinnerCompetition : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapterN());
        }
        DialogAddSportBinding dialogAddSportBinding3 = get_binding();
        Spinner spinner3 = dialogAddSportBinding3 != null ? dialogAddSportBinding3.spinnerLevel : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapterL());
        }
        DialogAddSportBinding dialogAddSportBinding4 = get_binding();
        Spinner spinner4 = dialogAddSportBinding4 != null ? dialogAddSportBinding4.spinnerYear : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getSpinnerAdapterY());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddSportViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddSportBinding dialogAddSportBinding5 = get_binding();
            TextView textView5 = dialogAddSportBinding5 != null ? dialogAddSportBinding5.addBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            DialogAddSportBinding dialogAddSportBinding6 = get_binding();
            TextView textView6 = dialogAddSportBinding6 != null ? dialogAddSportBinding6.updateBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
        } else {
            DialogAddSportBinding dialogAddSportBinding7 = get_binding();
            TextView textView7 = dialogAddSportBinding7 != null ? dialogAddSportBinding7.addBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            DialogAddSportBinding dialogAddSportBinding8 = get_binding();
            TextView textView8 = dialogAddSportBinding8 != null ? dialogAddSportBinding8.updateBtn : null;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
        }
        DialogAddSportBinding dialogAddSportBinding9 = get_binding();
        if (dialogAddSportBinding9 != null && (textInputEditText3 = dialogAddSportBinding9.etName) != null) {
            textInputEditText3.setText(this.name);
        }
        DialogAddSportBinding dialogAddSportBinding10 = get_binding();
        if (dialogAddSportBinding10 != null && (textInputEditText2 = dialogAddSportBinding10.etAward) != null) {
            textInputEditText2.setText(this.award);
        }
        DialogAddSportBinding dialogAddSportBinding11 = get_binding();
        if (dialogAddSportBinding11 != null && (textInputEditText = dialogAddSportBinding11.etOrgaanisedBy) != null) {
            textInputEditText.setText(this.organised);
        }
        if (!Intrinsics.areEqual(this.date, "")) {
            DialogAddSportBinding dialogAddSportBinding12 = get_binding();
            TextView textView9 = dialogAddSportBinding12 != null ? dialogAddSportBinding12.etDate : null;
            if (textView9 != null) {
                textView9.setText(this.date);
            }
        }
        DialogAddSportBinding dialogAddSportBinding13 = get_binding();
        if (dialogAddSportBinding13 != null && (textView4 = dialogAddSportBinding13.etDate) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddSportDialog.setUp$lambda$2(AddSportDialog.this, i, i2, i3, view);
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding14 = get_binding();
        Spinner spinner5 = dialogAddSportBinding14 != null ? dialogAddSportBinding14.spinnerYear : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapterY;
                    AddSportDialog addSportDialog = AddSportDialog.this;
                    spinnerAdapterY = addSportDialog.getSpinnerAdapterY();
                    addSportDialog.yearId = String.valueOf(spinnerAdapterY.getSemester(position).getId());
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding15 = get_binding();
        Spinner spinner6 = dialogAddSportBinding15 != null ? dialogAddSportBinding15.spinnerLevel : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapterL;
                    AddSportDialog addSportDialog = AddSportDialog.this;
                    spinnerAdapterL = addSportDialog.getSpinnerAdapterL();
                    addSportDialog.level = String.valueOf(spinnerAdapterL.getSemester(position).getId());
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding16 = get_binding();
        Spinner spinner7 = dialogAddSportBinding16 != null ? dialogAddSportBinding16.spinnerType : null;
        if (spinner7 != null) {
            spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$setUp$4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapterT;
                    AddSportDialog addSportDialog = AddSportDialog.this;
                    spinnerAdapterT = addSportDialog.getSpinnerAdapterT();
                    addSportDialog.type = String.valueOf(spinnerAdapterT.getSemester(position).getId());
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding17 = get_binding();
        Spinner spinner8 = dialogAddSportBinding17 != null ? dialogAddSportBinding17.spinnerCompetition : null;
        if (spinner8 != null) {
            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$setUp$5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapterN;
                    AddSportDialog addSportDialog = AddSportDialog.this;
                    spinnerAdapterN = addSportDialog.getSpinnerAdapterN();
                    addSportDialog.competitionName = String.valueOf(spinnerAdapterN.getSemester(position).getId());
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding18 = get_binding();
        if (dialogAddSportBinding18 != null && (textView3 = dialogAddSportBinding18.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddSportDialog.setUp$lambda$4(AddSportDialog.this, view);
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding19 = get_binding();
        if (dialogAddSportBinding19 != null && (textView2 = dialogAddSportBinding19.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddSportDialog.setUp$lambda$5(AddSportDialog.this, view);
                }
            });
        }
        DialogAddSportBinding dialogAddSportBinding20 = get_binding();
        if (dialogAddSportBinding20 == null || (textView = dialogAddSportBinding20.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddSportDialog.setUp$lambda$6(AddSportDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(final AddSportDialog this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda7
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddSportDialog.setUp$lambda$2$lambda$1(AddSportDialog.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2$lambda$1(AddSportDialog this$0, DatePicker datePicker, int i, int i2, int i3) {
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
        DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
        if (dialogAddSportBinding == null || (textView = dialogAddSportBinding.etDate) == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.months + HelpFormatter.DEFAULT_OPT_PREFIX + this$0.days);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddSportDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(AddSportDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextInputEditText textInputEditText;
        TextView textView3;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextView textView4;
        TextInputEditText textInputEditText4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextInputEditText textInputEditText5;
        TextView textView8;
        TextView textView9;
        File file;
        TextInputEditText textInputEditText6;
        TextView textView10;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextView textView11;
        TextInputEditText textInputEditText9;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextInputEditText textInputEditText10;
        TextView textView15;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
            if (String.valueOf((dialogAddSportBinding == null || (textView15 = dialogAddSportBinding.completionFileName) == null) ? null : textView15.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddSportBinding dialogAddSportBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding2 == null || (textInputEditText10 = dialogAddSportBinding2.etName) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogAddSportBinding dialogAddSportBinding3 = this$0.get_binding();
                        if (dialogAddSportBinding3 == null || (textView14 = dialogAddSportBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView14, "Name of the course Cannot be empty");
                        return;
                    }
                    DialogAddSportBinding dialogAddSportBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding4 == null || (textView13 = dialogAddSportBinding4.etDate) == null) ? null : textView13.getText()), "")) {
                        DialogAddSportBinding dialogAddSportBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding5 == null || (textView12 = dialogAddSportBinding5.etDate) == null) ? null : textView12.getText()), "Date")) {
                            DialogAddSportBinding dialogAddSportBinding6 = this$0.get_binding();
                            if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding6 == null || (textInputEditText9 = dialogAddSportBinding6.etName) == null) ? null : textInputEditText9.getText()), "")) {
                                DialogAddSportBinding dialogAddSportBinding7 = this$0.get_binding();
                                if (dialogAddSportBinding7 == null || (textView11 = dialogAddSportBinding7.completionSelect) == null) {
                                    return;
                                }
                                ToastExtKt.showInfoToast(textView11, "Event Date cannot be empty.");
                                return;
                            }
                            AddSportViewModel addSportViewModel = this$0.getAddSportViewModel();
                            String str = this$0.competitionName;
                            Intrinsics.checkNotNull(str);
                            DialogAddSportBinding dialogAddSportBinding8 = this$0.get_binding();
                            String valueOf = String.valueOf((dialogAddSportBinding8 == null || (textInputEditText8 = dialogAddSportBinding8.etName) == null) ? null : textInputEditText8.getText());
                            DialogAddSportBinding dialogAddSportBinding9 = this$0.get_binding();
                            String valueOf2 = String.valueOf((dialogAddSportBinding9 == null || (textInputEditText7 = dialogAddSportBinding9.etOrgaanisedBy) == null) ? null : textInputEditText7.getText());
                            String str2 = this$0.type;
                            Intrinsics.checkNotNull(str2);
                            String str3 = this$0.level;
                            Intrinsics.checkNotNull(str3);
                            DialogAddSportBinding dialogAddSportBinding10 = this$0.get_binding();
                            String valueOf3 = String.valueOf((dialogAddSportBinding10 == null || (textView10 = dialogAddSportBinding10.etDate) == null) ? null : textView10.getText());
                            String str4 = this$0.yearId;
                            Intrinsics.checkNotNull(str4);
                            DialogAddSportBinding dialogAddSportBinding11 = this$0.get_binding();
                            String valueOf4 = String.valueOf((dialogAddSportBinding11 == null || (textInputEditText6 = dialogAddSportBinding11.etAward) == null) ? null : textInputEditText6.getText());
                            File file3 = this$0.pickFile;
                            if (file3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                file = null;
                            } else {
                                file = file3;
                            }
                            addSportViewModel.addSportData(str, valueOf, valueOf2, str2, str3, valueOf3, str4, valueOf4, file);
                            DialogAddSportBinding dialogAddSportBinding12 = this$0.get_binding();
                            LinearLayout linearLayout = dialogAddSportBinding12 != null ? dialogAddSportBinding12.completionCard : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            DialogAddSportBinding dialogAddSportBinding13 = this$0.get_binding();
                            CardView cardView = dialogAddSportBinding13 != null ? dialogAddSportBinding13.progressView : null;
                            if (cardView == null) {
                                return;
                            }
                            cardView.setVisibility(0);
                            return;
                        }
                    }
                    DialogAddSportBinding dialogAddSportBinding14 = this$0.get_binding();
                    if (dialogAddSportBinding14 == null || (textView9 = dialogAddSportBinding14.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView9, "Please choose date.");
                    return;
                }
                DialogAddSportBinding dialogAddSportBinding15 = this$0.get_binding();
                if (dialogAddSportBinding15 == null || (textView8 = dialogAddSportBinding15.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView8, "File Size Limit Is 100KB");
                return;
            }
            DialogAddSportBinding dialogAddSportBinding16 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding16 == null || (textInputEditText5 = dialogAddSportBinding16.etName) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddSportBinding dialogAddSportBinding17 = this$0.get_binding();
                if (dialogAddSportBinding17 == null || (textView7 = dialogAddSportBinding17.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView7, "Name of the course Cannot be empty");
                return;
            }
            DialogAddSportBinding dialogAddSportBinding18 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding18 == null || (textView6 = dialogAddSportBinding18.etDate) == null) ? null : textView6.getText()), "")) {
                DialogAddSportBinding dialogAddSportBinding19 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding19 == null || (textView5 = dialogAddSportBinding19.etDate) == null) ? null : textView5.getText()), "Date")) {
                    DialogAddSportBinding dialogAddSportBinding20 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding20 == null || (textInputEditText4 = dialogAddSportBinding20.etName) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddSportBinding dialogAddSportBinding21 = this$0.get_binding();
                        if (dialogAddSportBinding21 == null || (textView4 = dialogAddSportBinding21.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Event Date cannot be empty.");
                        return;
                    }
                    AddSportViewModel addSportViewModel2 = this$0.getAddSportViewModel();
                    String str5 = this$0.competitionName;
                    Intrinsics.checkNotNull(str5);
                    DialogAddSportBinding dialogAddSportBinding22 = this$0.get_binding();
                    String valueOf5 = String.valueOf((dialogAddSportBinding22 == null || (textInputEditText3 = dialogAddSportBinding22.etName) == null) ? null : textInputEditText3.getText());
                    DialogAddSportBinding dialogAddSportBinding23 = this$0.get_binding();
                    String valueOf6 = String.valueOf((dialogAddSportBinding23 == null || (textInputEditText2 = dialogAddSportBinding23.etOrgaanisedBy) == null) ? null : textInputEditText2.getText());
                    String str6 = this$0.type;
                    Intrinsics.checkNotNull(str6);
                    String str7 = this$0.level;
                    Intrinsics.checkNotNull(str7);
                    DialogAddSportBinding dialogAddSportBinding24 = this$0.get_binding();
                    String valueOf7 = String.valueOf((dialogAddSportBinding24 == null || (textView3 = dialogAddSportBinding24.etDate) == null) ? null : textView3.getText());
                    String str8 = this$0.yearId;
                    Intrinsics.checkNotNull(str8);
                    DialogAddSportBinding dialogAddSportBinding25 = this$0.get_binding();
                    addSportViewModel2.addSportData(str5, valueOf5, valueOf6, str6, str7, valueOf7, str8, String.valueOf((dialogAddSportBinding25 == null || (textInputEditText = dialogAddSportBinding25.etAward) == null) ? null : textInputEditText.getText()));
                    DialogAddSportBinding dialogAddSportBinding26 = this$0.get_binding();
                    LinearLayout linearLayout2 = dialogAddSportBinding26 != null ? dialogAddSportBinding26.completionCard : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(8);
                    return;
                }
            }
            DialogAddSportBinding dialogAddSportBinding27 = this$0.get_binding();
            if (dialogAddSportBinding27 == null || (textView2 = dialogAddSportBinding27.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please choose date.");
        } catch (Exception unused) {
            DialogAddSportBinding dialogAddSportBinding28 = this$0.get_binding();
            if (dialogAddSportBinding28 == null || (textView = dialogAddSportBinding28.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(AddSportDialog this$0, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextView textView2;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextView textView3;
        TextInputEditText textInputEditText4;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextInputEditText textInputEditText5;
        TextView textView7;
        TextView textView8;
        File file;
        TextInputEditText textInputEditText6;
        TextView textView9;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextView textView10;
        TextInputEditText textInputEditText9;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextInputEditText textInputEditText10;
        TextView textView14;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddSportBinding == null || (textView14 = dialogAddSportBinding.completionFileName) == null) ? null : textView14.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddSportBinding dialogAddSportBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding2 == null || (textInputEditText10 = dialogAddSportBinding2.etName) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogAddSportBinding dialogAddSportBinding3 = this$0.get_binding();
                        if (dialogAddSportBinding3 == null || (textView13 = dialogAddSportBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView13, "Name of the course Cannot be empty");
                        return;
                    }
                    DialogAddSportBinding dialogAddSportBinding4 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding4 == null || (textView12 = dialogAddSportBinding4.etDate) == null) ? null : textView12.getText()), "")) {
                        DialogAddSportBinding dialogAddSportBinding5 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding5 == null || (textView11 = dialogAddSportBinding5.etDate) == null) ? null : textView11.getText()), "Date")) {
                            DialogAddSportBinding dialogAddSportBinding6 = this$0.get_binding();
                            if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding6 == null || (textInputEditText9 = dialogAddSportBinding6.etName) == null) ? null : textInputEditText9.getText()), "")) {
                                DialogAddSportBinding dialogAddSportBinding7 = this$0.get_binding();
                                if (dialogAddSportBinding7 == null || (textView10 = dialogAddSportBinding7.completionSelect) == null) {
                                    return;
                                }
                                ToastExtKt.showInfoToast(textView10, "Event Date cannot be empty.");
                                return;
                            }
                            AddSportViewModel addSportViewModel = this$0.getAddSportViewModel();
                            String str = this$0.id;
                            Intrinsics.checkNotNull(str);
                            String str2 = this$0.competitionName;
                            Intrinsics.checkNotNull(str2);
                            DialogAddSportBinding dialogAddSportBinding8 = this$0.get_binding();
                            String valueOf = String.valueOf((dialogAddSportBinding8 == null || (textInputEditText8 = dialogAddSportBinding8.etName) == null) ? null : textInputEditText8.getText());
                            DialogAddSportBinding dialogAddSportBinding9 = this$0.get_binding();
                            String valueOf2 = String.valueOf((dialogAddSportBinding9 == null || (textInputEditText7 = dialogAddSportBinding9.etOrgaanisedBy) == null) ? null : textInputEditText7.getText());
                            String str3 = this$0.type;
                            Intrinsics.checkNotNull(str3);
                            String str4 = this$0.level;
                            Intrinsics.checkNotNull(str4);
                            DialogAddSportBinding dialogAddSportBinding10 = this$0.get_binding();
                            String valueOf3 = String.valueOf((dialogAddSportBinding10 == null || (textView9 = dialogAddSportBinding10.etDate) == null) ? null : textView9.getText());
                            String str5 = this$0.yearId;
                            Intrinsics.checkNotNull(str5);
                            DialogAddSportBinding dialogAddSportBinding11 = this$0.get_binding();
                            String valueOf4 = String.valueOf((dialogAddSportBinding11 == null || (textInputEditText6 = dialogAddSportBinding11.etAward) == null) ? null : textInputEditText6.getText());
                            File file3 = this$0.pickFile;
                            if (file3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                file = null;
                            } else {
                                file = file3;
                            }
                            addSportViewModel.updateSportData(str, str2, valueOf, valueOf2, str3, str4, valueOf3, str5, valueOf4, file);
                            DialogAddSportBinding dialogAddSportBinding12 = this$0.get_binding();
                            LinearLayout linearLayout = dialogAddSportBinding12 != null ? dialogAddSportBinding12.completionCard : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            DialogAddSportBinding dialogAddSportBinding13 = this$0.get_binding();
                            CardView cardView = dialogAddSportBinding13 != null ? dialogAddSportBinding13.progressView : null;
                            if (cardView == null) {
                                return;
                            }
                            cardView.setVisibility(0);
                            return;
                        }
                    }
                    DialogAddSportBinding dialogAddSportBinding14 = this$0.get_binding();
                    if (dialogAddSportBinding14 == null || (textView8 = dialogAddSportBinding14.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView8, "Please choose date.");
                    return;
                }
                DialogAddSportBinding dialogAddSportBinding15 = this$0.get_binding();
                if (dialogAddSportBinding15 == null || (textView7 = dialogAddSportBinding15.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView7, "File Size Limit Is 100KB");
                return;
            }
            DialogAddSportBinding dialogAddSportBinding16 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding16 == null || (textInputEditText5 = dialogAddSportBinding16.etName) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddSportBinding dialogAddSportBinding17 = this$0.get_binding();
                if (dialogAddSportBinding17 == null || (textView6 = dialogAddSportBinding17.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView6, "Name of the course Cannot be empty");
                return;
            }
            DialogAddSportBinding dialogAddSportBinding18 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding18 == null || (textView5 = dialogAddSportBinding18.etDate) == null) ? null : textView5.getText()), "")) {
                DialogAddSportBinding dialogAddSportBinding19 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogAddSportBinding19 == null || (textView4 = dialogAddSportBinding19.etDate) == null) ? null : textView4.getText()), "Date")) {
                    DialogAddSportBinding dialogAddSportBinding20 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddSportBinding20 == null || (textInputEditText4 = dialogAddSportBinding20.etName) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddSportBinding dialogAddSportBinding21 = this$0.get_binding();
                        if (dialogAddSportBinding21 == null || (textView3 = dialogAddSportBinding21.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Event Date cannot be empty.");
                        return;
                    }
                    AddSportViewModel addSportViewModel2 = this$0.getAddSportViewModel();
                    String str6 = this$0.id;
                    Intrinsics.checkNotNull(str6);
                    String str7 = this$0.competitionName;
                    Intrinsics.checkNotNull(str7);
                    DialogAddSportBinding dialogAddSportBinding22 = this$0.get_binding();
                    String valueOf5 = String.valueOf((dialogAddSportBinding22 == null || (textInputEditText3 = dialogAddSportBinding22.etName) == null) ? null : textInputEditText3.getText());
                    DialogAddSportBinding dialogAddSportBinding23 = this$0.get_binding();
                    String valueOf6 = String.valueOf((dialogAddSportBinding23 == null || (textInputEditText2 = dialogAddSportBinding23.etOrgaanisedBy) == null) ? null : textInputEditText2.getText());
                    String str8 = this$0.type;
                    Intrinsics.checkNotNull(str8);
                    String str9 = this$0.level;
                    Intrinsics.checkNotNull(str9);
                    DialogAddSportBinding dialogAddSportBinding24 = this$0.get_binding();
                    String valueOf7 = String.valueOf((dialogAddSportBinding24 == null || (textView2 = dialogAddSportBinding24.etDate) == null) ? null : textView2.getText());
                    String str10 = this$0.yearId;
                    Intrinsics.checkNotNull(str10);
                    DialogAddSportBinding dialogAddSportBinding25 = this$0.get_binding();
                    if (dialogAddSportBinding25 != null && (textInputEditText = dialogAddSportBinding25.etAward) != null) {
                        editable = textInputEditText.getText();
                    }
                    addSportViewModel2.updateSportData(str6, str7, valueOf5, valueOf6, str8, str9, valueOf7, str10, String.valueOf(editable));
                    return;
                }
            }
            DialogAddSportBinding dialogAddSportBinding26 = this$0.get_binding();
            if (dialogAddSportBinding26 == null || (textView = dialogAddSportBinding26.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please choose date.");
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddSportViewModel().getResponse().observe(getViewLifecycleOwner(), new AddSportDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$listenSpinnerResponse$1

            /* compiled from: AddSportDialog.kt */
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
                IndexSpinnerAdapter spinnerAdapterY;
                IndexSpinnerAdapter spinnerAdapterT;
                IndexSpinnerAdapter spinnerAdapterL;
                IndexSpinnerAdapter spinnerAdapterN;
                DialogAddSportBinding dialogAddSportBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddSportDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        AddSportDialog addSportDialog = AddSportDialog.this;
                        try {
                            spinnerAdapterY = addSportDialog.getSpinnerAdapterY();
                            spinnerAdapterY.addItems(data.getYears());
                            spinnerAdapterT = addSportDialog.getSpinnerAdapterT();
                            spinnerAdapterT.addItems(data.getCategory());
                            spinnerAdapterL = addSportDialog.getSpinnerAdapterL();
                            spinnerAdapterL.addItems(data.getLevel());
                            spinnerAdapterN = addSportDialog.getSpinnerAdapterN();
                            spinnerAdapterN.addItems(data.getNature());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddSportDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddSportDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddSportDialog.this.hideProgress();
                dialogAddSportBinding = AddSportDialog.this.get_binding();
                if (dialogAddSportBinding == null || (spinner = dialogAddSportBinding.spinnerYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddSportViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddSportDialog.listenAddResponse$lambda$8(AddSportDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$8(AddSportDialog this$0, Resource resource) {
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
            DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
            if (dialogAddSportBinding != null && (textView = dialogAddSportBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddSportListener addSportListener = this$0.listener;
            if (addSportListener != null) {
                addSportListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddSportBinding dialogAddSportBinding2 = this$0.get_binding();
                if (dialogAddSportBinding2 != null && (addBtn2 = dialogAddSportBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddSportListener addSportListener2 = this$0.listener;
                if (addSportListener2 != null) {
                    addSportListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddSportBinding dialogAddSportBinding3 = this$0.get_binding();
            if (dialogAddSportBinding3 != null && (addBtn = dialogAddSportBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddSportListener addSportListener3 = this$0.listener;
            if (addSportListener3 != null) {
                addSportListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddSportViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddSportDialog.listenAddResponse2$lambda$10(AddSportDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$10(AddSportDialog this$0, Resource resource) {
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
            DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
            if (dialogAddSportBinding != null && (textView = dialogAddSportBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddSportListener addSportListener = this$0.listener;
            if (addSportListener != null) {
                addSportListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddSportBinding dialogAddSportBinding2 = this$0.get_binding();
                if (dialogAddSportBinding2 != null && (addBtn2 = dialogAddSportBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddSportListener addSportListener2 = this$0.listener;
                if (addSportListener2 != null) {
                    addSportListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddSportBinding dialogAddSportBinding3 = this$0.get_binding();
            if (dialogAddSportBinding3 != null && (addBtn = dialogAddSportBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddSportListener addSportListener3 = this$0.listener;
            if (addSportListener3 != null) {
                addSportListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddSportViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddSportDialog.listenUpdateResponse$lambda$12(AddSportDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$12(AddSportDialog this$0, Resource resource) {
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
            DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
            if (dialogAddSportBinding != null && (textView = dialogAddSportBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddSportListener addSportListener = this$0.listener;
            if (addSportListener != null) {
                addSportListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddSportBinding dialogAddSportBinding2 = this$0.get_binding();
                if (dialogAddSportBinding2 != null && (completionFileName2 = dialogAddSportBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddSportListener addSportListener2 = this$0.listener;
                if (addSportListener2 != null) {
                    addSportListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddSportBinding dialogAddSportBinding3 = this$0.get_binding();
            if (dialogAddSportBinding3 != null && (completionFileName = dialogAddSportBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddSportListener addSportListener3 = this$0.listener;
            if (addSportListener3 != null) {
                addSportListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddSportViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.sport.add.AddSportDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddSportDialog.listenProgressResponse$lambda$14(AddSportDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$14(AddSportDialog this$0, Resource resource) {
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
            DialogAddSportBinding dialogAddSportBinding = this$0.get_binding();
            if (dialogAddSportBinding == null || (textView = dialogAddSportBinding.completionFileName) == null) {
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
            DialogAddSportBinding dialogAddSportBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddSportBinding2 != null ? dialogAddSportBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddSportBinding dialogAddSportBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddSportBinding3 != null ? dialogAddSportBinding3.progressText : null;
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
                    DialogAddSportBinding dialogAddSportBinding = get_binding();
                    if (dialogAddSportBinding == null || (completionFileName = dialogAddSportBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddSportBinding dialogAddSportBinding2 = get_binding();
                TextView textView = dialogAddSportBinding2 != null ? dialogAddSportBinding2.completionFileName : null;
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

    public final void setCallBack(SportFragment context) {
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