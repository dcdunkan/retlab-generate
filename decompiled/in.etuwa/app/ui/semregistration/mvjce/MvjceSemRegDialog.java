package in.etuwa.app.ui.semregistration.mvjce;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.semregistration.AcademicYearResponse;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogMvjceSemRegBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter;
import in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment;
import in.etuwa.app.ui.semregistration.view.SemRegViewFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* compiled from: MvjceSemRegDialog.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0006H\u0002J\b\u0010b\u001a\u00020`H\u0014J\b\u0010c\u001a\u00020`H\u0002J\b\u0010d\u001a\u00020`H\u0002J\b\u0010e\u001a\u00020`H\u0002J\b\u0010f\u001a\u00020`H\u0002J\u0010\u0010g\u001a\u00020`2\u0006\u0010h\u001a\u00020iH\u0002J\u0006\u0010j\u001a\u00020`J\"\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0012\u0010q\u001a\u00020`2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J&\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010y2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010z\u001a\u00020`H\u0016J\b\u0010{\u001a\u00020`H\u0016J\u0010\u0010|\u001a\u00020`2\u0006\u0010}\u001a\u00020~H\u0016J\u001b\u0010\u007f\u001a\u00020`2\u0007\u0010\u0080\u0001\u001a\u00020u2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u0011\u0010\u0081\u0001\u001a\u00020`2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020`2\b\u0010\u0082\u0001\u001a\u00030\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020`H\u0014J\t\u0010\u0087\u0001\u001a\u00020`H\u0014J\r\u0010\u0088\u0001\u001a\u00020\u0006*\u00020mH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b:\u0010;R\u000e\u0010=\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00104\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00104\u001a\u0004\bJ\u0010GR\u001b\u0010L\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00104\u001a\u0004\bM\u0010GR\u001b\u0010O\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u00104\u001a\u0004\bP\u0010GR\u001b\u0010R\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u00104\u001a\u0004\bS\u0010GR\u001b\u0010U\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u00104\u001a\u0004\bV\u0010GR\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u00104\u001a\u0004\bZ\u0010[R\u000e\u0010]\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogMvjceSemRegBinding;", "academics", "", "academicsDetails", "accounts", "accountsDetails", "additional1", "additional2", "additional3", "additional4", "back", "backDetails", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogMvjceSemRegBinding;", "bus", "cgpaClicked", "", "dept", "deptDetails", "dueClicked", "elective1", "elective2", "elective3", "examAttClicked", "feeClicked", "feeConcession", "feePaid", "finalPage", "global1", "global2", "global3", "globalElectiveClicked", "honor", "honorMinorClicked", "hostel", "hostelDetails", "id", "library", "libraryDetails", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog$AddSemRegListener;", "minor", "mvjceSemRegViewModel", "Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegViewModel;", "getMvjceSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegViewModel;", "mvjceSemRegViewModel$delegate", "Lkotlin/Lazy;", "pickFile", "Ljava/io/File;", "pickedFile", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "prevSemClicked", "programElective1", "programElective2", "programElective3", "reg", "regDetails", "semester_id", "spinnerAdditional", "Lin/etuwa/app/ui/semregistration/mace/AcademicYearSpinnerAdapter;", "getSpinnerAdditional", "()Lin/etuwa/app/ui/semregistration/mace/AcademicYearSpinnerAdapter;", "spinnerAdditional$delegate", "spinnerElective", "getSpinnerElective", "spinnerElective$delegate", "spinnerGlobal", "getSpinnerGlobal", "spinnerGlobal$delegate", "spinnerHonour", "getSpinnerHonour", "spinnerHonour$delegate", "spinnerMinors", "getSpinnerMinors", "spinnerMinors$delegate", "spinnerProgramElective", "getSpinnerProgramElective", "spinnerProgramElective$delegate", "spinnerSem", "Lin/etuwa/app/ui/semregistration/mvjce/CurrentSemSpinnerAdapter;", "getSpinnerSem", "()Lin/etuwa/app/ui/semregistration/mvjce/CurrentSemSpinnerAdapter;", "spinnerSem$delegate", "supplyClicked", "type", "confirmApproveView", "", "message", "hideProgress", "listenResponse", "listenResponse2", "listenSpinners", "listenViewResponse", "loadView", "response", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "mainSem", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "setCallBack2", "Lin/etuwa/app/ui/semregistration/view/SemRegViewFragment;", "setUp", "showProgress", "toRoman", "AddSemRegListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MvjceSemRegDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogMvjceSemRegBinding _binding;
    private String academics;
    private String academicsDetails;
    private String accounts;
    private String accountsDetails;
    private String additional1;
    private String additional2;
    private String additional3;
    private String additional4;
    private String back;
    private String backDetails;
    private String bus;
    private boolean cgpaClicked;
    private String dept;
    private String deptDetails;
    private boolean dueClicked;
    private String elective1;
    private String elective2;
    private String elective3;
    private boolean examAttClicked;
    private boolean feeClicked;
    private String feeConcession;
    private String feePaid;
    private boolean finalPage;
    private String global1;
    private String global2;
    private String global3;
    private boolean globalElectiveClicked;
    private String honor;
    private boolean honorMinorClicked;
    private String hostel;
    private String hostelDetails;
    private String id;
    private String library;
    private String libraryDetails;
    private AddSemRegListener listener;
    private String minor;

    /* renamed from: mvjceSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mvjceSemRegViewModel;
    private File pickFile;
    private boolean pickedFile;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private boolean prevSemClicked;
    private String programElective1;
    private String programElective2;
    private String programElective3;
    private String reg;
    private String regDetails;
    private String semester_id;

    /* renamed from: spinnerAdditional$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdditional;

    /* renamed from: spinnerElective$delegate, reason: from kotlin metadata */
    private final Lazy spinnerElective;

    /* renamed from: spinnerGlobal$delegate, reason: from kotlin metadata */
    private final Lazy spinnerGlobal;

    /* renamed from: spinnerHonour$delegate, reason: from kotlin metadata */
    private final Lazy spinnerHonour;

    /* renamed from: spinnerMinors$delegate, reason: from kotlin metadata */
    private final Lazy spinnerMinors;

    /* renamed from: spinnerProgramElective$delegate, reason: from kotlin metadata */
    private final Lazy spinnerProgramElective;

    /* renamed from: spinnerSem$delegate, reason: from kotlin metadata */
    private final Lazy spinnerSem;
    private boolean supplyClicked;
    private String type;

    /* compiled from: MvjceSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog$AddSemRegListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddSemRegListener {
        void dismiss();
    }

    /* compiled from: MvjceSemRegDialog.kt */
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
    public static final MvjceSemRegDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public MvjceSemRegDialog() {
        final MvjceSemRegDialog mvjceSemRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(mvjceSemRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.mvjceSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(mvjceSemRegDialog, Reflection.getOrCreateKotlinClass(MvjceSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MvjceSemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MvjceSemRegDialog mvjceSemRegDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.id = "";
        this.minor = "";
        this.type = "";
        this.reg = "Yes";
        this.bus = "";
        this.dept = "";
        this.library = "";
        this.accounts = "";
        this.academics = "";
        this.hostel = "";
        this.back = "Yes";
        this.feeConcession = "Yes";
        this.feePaid = "Yes";
        this.deptDetails = "";
        this.libraryDetails = "";
        this.accountsDetails = "";
        this.academicsDetails = "";
        this.hostelDetails = "";
        this.regDetails = "";
        this.backDetails = "";
        this.honor = "";
        this.elective1 = "";
        this.elective2 = "";
        this.elective3 = "";
        this.global1 = "";
        this.global2 = "";
        this.global3 = "";
        this.additional1 = "";
        this.additional2 = "";
        this.additional3 = "";
        this.additional4 = "";
        this.programElective1 = "";
        this.programElective2 = "";
        this.programElective3 = "";
        this.semester_id = "";
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerSem$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerSem = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CurrentSemSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mvjce.CurrentSemSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CurrentSemSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CurrentSemSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerMinors$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerMinors = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b5, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerHonour$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerHonour = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b6, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerElective$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        this.spinnerElective = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b7, function05);
            }
        });
        final Function0<ParametersHolder> function06 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerGlobal$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        this.spinnerGlobal = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b8, function06);
            }
        });
        final Function0<ParametersHolder> function07 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerAdditional$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode7 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b9 = 0 == true ? 1 : 0;
        this.spinnerAdditional = LazyKt.lazy(lazyThreadSafetyMode7, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b9, function07);
            }
        });
        final Function0<ParametersHolder> function08 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$spinnerProgramElective$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MvjceSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode8 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b10 = 0 == true ? 1 : 0;
        this.spinnerProgramElective = LazyKt.lazy(lazyThreadSafetyMode8, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = mvjceSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b10, function08);
            }
        });
    }

    private final MvjceSemRegViewModel getMvjceSemRegViewModel() {
        return (MvjceSemRegViewModel) this.mvjceSemRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogMvjceSemRegBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CurrentSemSpinnerAdapter getSpinnerSem() {
        return (CurrentSemSpinnerAdapter) this.spinnerSem.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerMinors() {
        return (AcademicYearSpinnerAdapter) this.spinnerMinors.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerHonour() {
        return (AcademicYearSpinnerAdapter) this.spinnerHonour.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerElective() {
        return (AcademicYearSpinnerAdapter) this.spinnerElective.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerGlobal() {
        return (AcademicYearSpinnerAdapter) this.spinnerGlobal.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerAdditional() {
        return (AcademicYearSpinnerAdapter) this.spinnerAdditional.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerProgramElective() {
        return (AcademicYearSpinnerAdapter) this.spinnerProgramElective.getValue();
    }

    /* compiled from: MvjceSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/mvjce/MvjceSemRegDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MvjceSemRegDialog newInstance(String id) {
            MvjceSemRegDialog mvjceSemRegDialog = new MvjceSemRegDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            mvjceSemRegDialog.setArguments(bundle);
            return mvjceSemRegDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogMvjceSemRegBinding.inflate(inflater, container, false);
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = get_binding();
        if (dialogMvjceSemRegBinding != null) {
            dialogMvjceSemRegBinding.setMvjceSemRegViewModel(getMvjceSemRegViewModel());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = get_binding();
        if (dialogMvjceSemRegBinding2 != null) {
            dialogMvjceSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = get_binding();
        if (dialogMvjceSemRegBinding3 != null) {
            return dialogMvjceSemRegBinding3.getRoot();
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
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        RadioGroup radioGroup5;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        RadioGroup radioGroup8;
        RadioGroup radioGroup9;
        RadioGroup radioGroup10;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextView textView21;
        TextView textView22;
        TextView textView23;
        TextView textView24;
        mainSem();
        if (!Intrinsics.areEqual(this.id, "")) {
            getMvjceSemRegViewModel().getData(this.id);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        listenSpinners();
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = get_binding();
        Spinner spinner = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.elective1 : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = get_binding();
        Spinner spinner2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.elective2 : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = get_binding();
        Spinner spinner3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.elective3 : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = get_binding();
        Spinner spinner4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.globalElective1 : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getSpinnerGlobal());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = get_binding();
        Spinner spinner5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.globalElective2 : null;
        if (spinner5 != null) {
            spinner5.setAdapter((SpinnerAdapter) getSpinnerGlobal());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = get_binding();
        Spinner spinner6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.globalElective3 : null;
        if (spinner6 != null) {
            spinner6.setAdapter((SpinnerAdapter) getSpinnerGlobal());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = get_binding();
        Spinner spinner7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.additionalElective1 : null;
        if (spinner7 != null) {
            spinner7.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = get_binding();
        Spinner spinner8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.additionalElective2 : null;
        if (spinner8 != null) {
            spinner8.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = get_binding();
        Spinner spinner9 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.additionalElective3 : null;
        if (spinner9 != null) {
            spinner9.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = get_binding();
        Spinner spinner10 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.spinnerMinor : null;
        if (spinner10 != null) {
            spinner10.setAdapter((SpinnerAdapter) getSpinnerMinors());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = get_binding();
        Spinner spinner11 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.spinnerHonour : null;
        if (spinner11 != null) {
            spinner11.setAdapter((SpinnerAdapter) getSpinnerHonour());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = get_binding();
        Spinner spinner12 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.spinnerSemesterLastAttended : null;
        if (spinner12 != null) {
            spinner12.setAdapter((SpinnerAdapter) getSpinnerSem());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = get_binding();
        Spinner spinner13 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.thirdProgramElective1 : null;
        if (spinner13 != null) {
            spinner13.setAdapter((SpinnerAdapter) getSpinnerProgramElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = get_binding();
        Spinner spinner14 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.thirdProgramElective2 : null;
        if (spinner14 != null) {
            spinner14.setAdapter((SpinnerAdapter) getSpinnerProgramElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = get_binding();
        Spinner spinner15 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.thirdProgramElective3 : null;
        if (spinner15 != null) {
            spinner15.setAdapter((SpinnerAdapter) getSpinnerProgramElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = get_binding();
        Spinner spinner16 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.thirdAdditionalElective1 : null;
        if (spinner16 != null) {
            spinner16.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = get_binding();
        Spinner spinner17 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.thirdAdditionalElective2 : null;
        if (spinner17 != null) {
            spinner17.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = get_binding();
        Spinner spinner18 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.thirdAdditionalElective3 : null;
        if (spinner18 != null) {
            spinner18.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = get_binding();
        Spinner spinner19 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.thirdAdditionalElective4 : null;
        if (spinner19 != null) {
            spinner19.setAdapter((SpinnerAdapter) getSpinnerAdditional());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = get_binding();
        Spinner spinner20 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.thirdElective1 : null;
        if (spinner20 != null) {
            spinner20.setAdapter((SpinnerAdapter) getSpinnerElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = get_binding();
        Spinner spinner21 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.thirdElective2 : null;
        if (spinner21 != null) {
            spinner21.setAdapter((SpinnerAdapter) getSpinnerElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = get_binding();
        Spinner spinner22 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.thirdElective3 : null;
        if (spinner22 != null) {
            spinner22.setAdapter((SpinnerAdapter) getSpinnerElective());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = get_binding();
        Spinner spinner23 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.thirdGlobalElective1 : null;
        if (spinner23 != null) {
            spinner23.setAdapter((SpinnerAdapter) getSpinnerGlobal());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = get_binding();
        TextInputLayout textInputLayout = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.mtDeptDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = get_binding();
        TextInputLayout textInputLayout2 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.mtLibraryDetail : null;
        if (textInputLayout2 != null) {
            textInputLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = get_binding();
        TextInputLayout textInputLayout3 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.mtAccountDetail : null;
        if (textInputLayout3 != null) {
            textInputLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = get_binding();
        TextInputLayout textInputLayout4 = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.mtAcademicDetail : null;
        if (textInputLayout4 != null) {
            textInputLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding28 = get_binding();
        TextInputLayout textInputLayout5 = dialogMvjceSemRegBinding28 != null ? dialogMvjceSemRegBinding28.mtHostelDetail : null;
        if (textInputLayout5 != null) {
            textInputLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding29 = get_binding();
        TextInputLayout textInputLayout6 = dialogMvjceSemRegBinding29 != null ? dialogMvjceSemRegBinding29.mtBusDetail : null;
        if (textInputLayout6 != null) {
            textInputLayout6.setVisibility(8);
        }
        listenResponse();
        listenResponse2();
        listenViewResponse();
        getMvjceSemRegViewModel().getDropDowns();
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding30 = get_binding();
        Spinner spinner24 = dialogMvjceSemRegBinding30 != null ? dialogMvjceSemRegBinding30.spinnerSemesterLastAttended : null;
        if (spinner24 != null) {
            spinner24.setAdapter((SpinnerAdapter) getSpinnerSem());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding31 = get_binding();
        if (dialogMvjceSemRegBinding31 != null && (textView24 = dialogMvjceSemRegBinding31.completionSelect) != null) {
            textView24.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$2(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding32 = get_binding();
        if (dialogMvjceSemRegBinding32 != null && (textView23 = dialogMvjceSemRegBinding32.nextOne) != null) {
            textView23.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$3(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding33 = get_binding();
        if (dialogMvjceSemRegBinding33 != null && (textView22 = dialogMvjceSemRegBinding33.backTwo) != null) {
            textView22.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$4(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding34 = get_binding();
        if (dialogMvjceSemRegBinding34 != null && (textView21 = dialogMvjceSemRegBinding34.backThree) != null) {
            textView21.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda21
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$5(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding35 = get_binding();
        if (dialogMvjceSemRegBinding35 != null && (textView20 = dialogMvjceSemRegBinding35.nextTwo) != null) {
            textView20.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda23
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$6(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding36 = get_binding();
        if (dialogMvjceSemRegBinding36 != null && (textView19 = dialogMvjceSemRegBinding36.nextThree) != null) {
            textView19.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda24
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$7(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding37 = get_binding();
        if (dialogMvjceSemRegBinding37 != null && (textView18 = dialogMvjceSemRegBinding37.backFour) != null) {
            textView18.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$8(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding38 = get_binding();
        if (dialogMvjceSemRegBinding38 != null && (textView17 = dialogMvjceSemRegBinding38.nextFour) != null) {
            textView17.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$9(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding39 = get_binding();
        if (dialogMvjceSemRegBinding39 != null && (textView16 = dialogMvjceSemRegBinding39.backFive) != null) {
            textView16.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda27
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$10(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding40 = get_binding();
        if (dialogMvjceSemRegBinding40 != null && (textView15 = dialogMvjceSemRegBinding40.nextFive) != null) {
            textView15.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$11(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding41 = get_binding();
        if (dialogMvjceSemRegBinding41 != null && (textView14 = dialogMvjceSemRegBinding41.backSix) != null) {
            textView14.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$12(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding42 = get_binding();
        if (dialogMvjceSemRegBinding42 != null && (textView13 = dialogMvjceSemRegBinding42.nextSix) != null) {
            textView13.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$13(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding43 = get_binding();
        if (dialogMvjceSemRegBinding43 != null && (textView12 = dialogMvjceSemRegBinding43.nextSeven) != null) {
            textView12.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$14(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding44 = get_binding();
        if (dialogMvjceSemRegBinding44 != null && (textView11 = dialogMvjceSemRegBinding44.backSeven) != null) {
            textView11.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$15(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding45 = get_binding();
        if (dialogMvjceSemRegBinding45 != null && (textView10 = dialogMvjceSemRegBinding45.backEight) != null) {
            textView10.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda33
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$16(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding46 = get_binding();
        if (dialogMvjceSemRegBinding46 != null && (radioGroup10 = dialogMvjceSemRegBinding46.examGroup) != null) {
            radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda34
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$17(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding47 = get_binding();
        if (dialogMvjceSemRegBinding47 != null && (radioGroup9 = dialogMvjceSemRegBinding47.busDue) != null) {
            radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda35
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$18(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding48 = get_binding();
        if (dialogMvjceSemRegBinding48 != null && (radioGroup8 = dialogMvjceSemRegBinding48.feeDue) != null) {
            radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$19(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding49 = get_binding();
        if (dialogMvjceSemRegBinding49 != null && (radioGroup7 = dialogMvjceSemRegBinding49.backGroup) != null) {
            radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$20(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding50 = get_binding();
        if (dialogMvjceSemRegBinding50 != null && (radioGroup6 = dialogMvjceSemRegBinding50.departmentDue) != null) {
            radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda3
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$21(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding51 = get_binding();
        if (dialogMvjceSemRegBinding51 != null && (radioGroup5 = dialogMvjceSemRegBinding51.concessionBtn) != null) {
            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda5
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$22(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding52 = get_binding();
        if (dialogMvjceSemRegBinding52 != null && (radioGroup4 = dialogMvjceSemRegBinding52.academicDue) != null) {
            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda6
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$23(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding53 = get_binding();
        if (dialogMvjceSemRegBinding53 != null && (radioGroup3 = dialogMvjceSemRegBinding53.accountsDue) != null) {
            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda7
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$24(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding54 = get_binding();
        if (dialogMvjceSemRegBinding54 != null && (radioGroup2 = dialogMvjceSemRegBinding54.libraryDue) != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda8
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$25(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding55 = get_binding();
        if (dialogMvjceSemRegBinding55 != null && (radioGroup = dialogMvjceSemRegBinding55.hostelDue) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda9
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup11, int i) {
                    MvjceSemRegDialog.setUp$lambda$26(MvjceSemRegDialog.this, radioGroup11, i);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding56 = get_binding();
        Spinner spinner25 = dialogMvjceSemRegBinding56 != null ? dialogMvjceSemRegBinding56.spinnerHonour : null;
        if (spinner25 != null) {
            spinner25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$26
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerHonour;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerHonour = mvjceSemRegDialog.getSpinnerHonour();
                        mvjceSemRegDialog.honor = String.valueOf(spinnerHonour.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding57 = get_binding();
        Spinner spinner26 = dialogMvjceSemRegBinding57 != null ? dialogMvjceSemRegBinding57.spinnerMinor : null;
        if (spinner26 != null) {
            spinner26.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$27
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerMinors;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerMinors = mvjceSemRegDialog.getSpinnerMinors();
                        mvjceSemRegDialog.minor = String.valueOf(spinnerMinors.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding58 = get_binding();
        Spinner spinner27 = dialogMvjceSemRegBinding58 != null ? dialogMvjceSemRegBinding58.elective1 : null;
        if (spinner27 != null) {
            spinner27.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$28
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        mvjceSemRegDialog.elective1 = String.valueOf(spinnerElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding59 = get_binding();
        Spinner spinner28 = dialogMvjceSemRegBinding59 != null ? dialogMvjceSemRegBinding59.elective2 : null;
        if (spinner28 != null) {
            spinner28.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$29
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        mvjceSemRegDialog.elective2 = String.valueOf(spinnerElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding60 = get_binding();
        Spinner spinner29 = dialogMvjceSemRegBinding60 != null ? dialogMvjceSemRegBinding60.thirdElective3 : null;
        if (spinner29 != null) {
            spinner29.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$30
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        mvjceSemRegDialog.elective3 = String.valueOf(spinnerElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding61 = get_binding();
        Spinner spinner30 = dialogMvjceSemRegBinding61 != null ? dialogMvjceSemRegBinding61.thirdElective1 : null;
        if (spinner30 != null) {
            spinner30.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$31
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        mvjceSemRegDialog.elective1 = String.valueOf(spinnerElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding62 = get_binding();
        Spinner spinner31 = dialogMvjceSemRegBinding62 != null ? dialogMvjceSemRegBinding62.thirdElective2 : null;
        if (spinner31 != null) {
            spinner31.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$32
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        mvjceSemRegDialog.elective2 = String.valueOf(spinnerElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding63 = get_binding();
        Spinner spinner32 = dialogMvjceSemRegBinding63 != null ? dialogMvjceSemRegBinding63.elective3 : null;
        if (spinner32 != null) {
            spinner32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$33
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        mvjceSemRegDialog.elective3 = String.valueOf(spinnerElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding64 = get_binding();
        Spinner spinner33 = dialogMvjceSemRegBinding64 != null ? dialogMvjceSemRegBinding64.thirdGlobalElective1 : null;
        if (spinner33 != null) {
            spinner33.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$34
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerGlobal;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerGlobal = mvjceSemRegDialog.getSpinnerGlobal();
                        mvjceSemRegDialog.global1 = String.valueOf(spinnerGlobal.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding65 = get_binding();
        Spinner spinner34 = dialogMvjceSemRegBinding65 != null ? dialogMvjceSemRegBinding65.globalElective1 : null;
        if (spinner34 != null) {
            spinner34.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$35
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerGlobal;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerGlobal = mvjceSemRegDialog.getSpinnerGlobal();
                        mvjceSemRegDialog.global1 = String.valueOf(spinnerGlobal.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding66 = get_binding();
        Spinner spinner35 = dialogMvjceSemRegBinding66 != null ? dialogMvjceSemRegBinding66.globalElective2 : null;
        if (spinner35 != null) {
            spinner35.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$36
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerGlobal;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerGlobal = mvjceSemRegDialog.getSpinnerGlobal();
                        mvjceSemRegDialog.global2 = String.valueOf(spinnerGlobal.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding67 = get_binding();
        Spinner spinner36 = dialogMvjceSemRegBinding67 != null ? dialogMvjceSemRegBinding67.globalElective3 : null;
        if (spinner36 != null) {
            spinner36.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$37
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerGlobal;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerGlobal = mvjceSemRegDialog.getSpinnerGlobal();
                        mvjceSemRegDialog.global3 = String.valueOf(spinnerGlobal.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding68 = get_binding();
        Spinner spinner37 = dialogMvjceSemRegBinding68 != null ? dialogMvjceSemRegBinding68.additionalElective1 : null;
        if (spinner37 != null) {
            spinner37.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$38
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                        mvjceSemRegDialog.additional1 = String.valueOf(spinnerAdditional.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding69 = get_binding();
        Spinner spinner38 = dialogMvjceSemRegBinding69 != null ? dialogMvjceSemRegBinding69.additionalElective2 : null;
        if (spinner38 != null) {
            spinner38.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$39
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                        mvjceSemRegDialog.additional2 = String.valueOf(spinnerAdditional.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding70 = get_binding();
        Spinner spinner39 = dialogMvjceSemRegBinding70 != null ? dialogMvjceSemRegBinding70.additionalElective3 : null;
        if (spinner39 != null) {
            spinner39.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$40
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position <= 0) {
                        MvjceSemRegDialog.this.additional3 = "I";
                        return;
                    }
                    MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                    spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                    mvjceSemRegDialog.additional3 = String.valueOf(spinnerAdditional.getType(position).getId());
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding71 = get_binding();
        Spinner spinner40 = dialogMvjceSemRegBinding71 != null ? dialogMvjceSemRegBinding71.thirdAdditionalElective1 : null;
        if (spinner40 != null) {
            spinner40.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$41
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                        mvjceSemRegDialog.additional1 = String.valueOf(spinnerAdditional.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding72 = get_binding();
        Spinner spinner41 = dialogMvjceSemRegBinding72 != null ? dialogMvjceSemRegBinding72.thirdAdditionalElective2 : null;
        if (spinner41 != null) {
            spinner41.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$42
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                        mvjceSemRegDialog.additional2 = String.valueOf(spinnerAdditional.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding73 = get_binding();
        Spinner spinner42 = dialogMvjceSemRegBinding73 != null ? dialogMvjceSemRegBinding73.thirdAdditionalElective3 : null;
        if (spinner42 != null) {
            spinner42.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$43
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position <= 0) {
                        MvjceSemRegDialog.this.additional3 = "I";
                        return;
                    }
                    MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                    spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                    mvjceSemRegDialog.additional3 = String.valueOf(spinnerAdditional.getType(position).getId());
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding74 = get_binding();
        Spinner spinner43 = dialogMvjceSemRegBinding74 != null ? dialogMvjceSemRegBinding74.thirdAdditionalElective4 : null;
        if (spinner43 != null) {
            spinner43.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$44
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerAdditional;
                    if (position <= 0) {
                        MvjceSemRegDialog.this.additional4 = "I";
                        return;
                    }
                    MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                    spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                    mvjceSemRegDialog.additional4 = String.valueOf(spinnerAdditional.getType(position).getId());
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding75 = get_binding();
        Spinner spinner44 = dialogMvjceSemRegBinding75 != null ? dialogMvjceSemRegBinding75.thirdProgramElective1 : null;
        if (spinner44 != null) {
            spinner44.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$45
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerProgramElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerProgramElective = mvjceSemRegDialog.getSpinnerProgramElective();
                        mvjceSemRegDialog.programElective1 = String.valueOf(spinnerProgramElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding76 = get_binding();
        Spinner spinner45 = dialogMvjceSemRegBinding76 != null ? dialogMvjceSemRegBinding76.thirdProgramElective2 : null;
        if (spinner45 != null) {
            spinner45.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$46
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerProgramElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerProgramElective = mvjceSemRegDialog.getSpinnerProgramElective();
                        mvjceSemRegDialog.programElective2 = String.valueOf(spinnerProgramElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding77 = get_binding();
        Spinner spinner46 = dialogMvjceSemRegBinding77 != null ? dialogMvjceSemRegBinding77.thirdProgramElective3 : null;
        if (spinner46 != null) {
            spinner46.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$setUp$47
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerProgramElective;
                    if (position > 0) {
                        MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                        spinnerProgramElective = mvjceSemRegDialog.getSpinnerProgramElective();
                        mvjceSemRegDialog.programElective3 = String.valueOf(spinnerProgramElective.getType(position).getId());
                    }
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding78 = get_binding();
        if (dialogMvjceSemRegBinding78 != null && (textView9 = dialogMvjceSemRegBinding78.examAttTv) != null) {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$27(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding79 = get_binding();
        if (dialogMvjceSemRegBinding79 != null && (textView8 = dialogMvjceSemRegBinding79.honorMinorTv) != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$28(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding80 = get_binding();
        if (dialogMvjceSemRegBinding80 != null && (textView7 = dialogMvjceSemRegBinding80.globalElecTv) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$29(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding81 = get_binding();
        if (dialogMvjceSemRegBinding81 != null && (textView6 = dialogMvjceSemRegBinding81.sgpaCgpaTv) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$30(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding82 = get_binding();
        if (dialogMvjceSemRegBinding82 != null && (textView5 = dialogMvjceSemRegBinding82.supplyTv) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$31(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding83 = get_binding();
        if (dialogMvjceSemRegBinding83 != null && (textView4 = dialogMvjceSemRegBinding83.prevSemTv) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$32(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding84 = get_binding();
        if (dialogMvjceSemRegBinding84 != null && (textView3 = dialogMvjceSemRegBinding84.feeDetailsTv) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$33(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding85 = get_binding();
        if (dialogMvjceSemRegBinding85 != null && (textView2 = dialogMvjceSemRegBinding85.dueTv) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda19
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MvjceSemRegDialog.setUp$lambda$34(MvjceSemRegDialog.this, view);
                }
            });
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding86 = get_binding();
        if (dialogMvjceSemRegBinding86 == null || (textView = dialogMvjceSemRegBinding86.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MvjceSemRegDialog.setUp$lambda$35(MvjceSemRegDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(MvjceSemRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0415  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void setUp$lambda$3(in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 1076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog.setUp$lambda$3(in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        if (Intrinsics.areEqual(this$0.type, ExifInterface.GPS_MEASUREMENT_3D)) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
            LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
            TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
            LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
            LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.globalElecLt : null;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
            TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.globalElecTv : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
            LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.globalElecThirdLt : null;
            if (linearLayout14 != null) {
                linearLayout14.setVisibility(8);
            }
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.sgpaCgpaLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.sgpaCgpaTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.supplyLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.supplyTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.prevSemLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.prevSemTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        LinearLayout linearLayout18 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.feeDetailsLt : null;
        if (linearLayout18 != null) {
            linearLayout18.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.feeDetailsTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        LinearLayout linearLayout19 = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.dueLt : null;
        if (linearLayout19 != null) {
            linearLayout19.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding28 = this$0.get_binding();
        TextView textView10 = dialogMvjceSemRegBinding28 != null ? dialogMvjceSemRegBinding28.dueTv : null;
        if (textView10 != null) {
            textView10.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding29 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding29 != null ? dialogMvjceSemRegBinding29.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding30 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding30 != null ? dialogMvjceSemRegBinding30.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        if (Intrinsics.areEqual(this$0.type, ExifInterface.GPS_MEASUREMENT_3D)) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
            LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
            TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
            LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
            LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.globalElecLt : null;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
            TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.globalElecTv : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
            LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.globalElecThirdLt : null;
            if (linearLayout14 != null) {
                linearLayout14.setVisibility(8);
            }
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.sgpaCgpaLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.sgpaCgpaTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.supplyLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.supplyTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.prevSemLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.prevSemTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        LinearLayout linearLayout18 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.feeDetailsLt : null;
        if (linearLayout18 != null) {
            linearLayout18.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.feeDetailsTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        LinearLayout linearLayout19 = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.dueLt : null;
        if (linearLayout19 != null) {
            linearLayout19.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding28 = this$0.get_binding();
        TextView textView10 = dialogMvjceSemRegBinding28 != null ? dialogMvjceSemRegBinding28.dueTv : null;
        if (textView10 != null) {
            textView10.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding29 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding29 != null ? dialogMvjceSemRegBinding29.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding30 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding30 != null ? dialogMvjceSemRegBinding30.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(0);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$13(MvjceSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            textView = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
        textView = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(MvjceSemRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finalPage = true;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.registerBtn : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.globalElecThirdLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
        TextView textView9 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.dueTv : null;
        if (textView9 == null) {
            return;
        }
        textView9.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.type, ExifInterface.GPS_MEASUREMENT_2D)) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            LinearLayout linearLayout2 = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
            LinearLayout linearLayout3 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
            LinearLayout linearLayout4 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
            LinearLayout linearLayout5 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
            LinearLayout linearLayout6 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
            LinearLayout linearLayout7 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
            LinearLayout linearLayout8 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
            LinearLayout linearLayout9 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
            TextView textView = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
            LinearLayout linearLayout10 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
            LinearLayout linearLayout11 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
            TextView textView2 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (Intrinsics.areEqual(this$0.type, ExifInterface.GPS_MEASUREMENT_3D)) {
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
                LinearLayout linearLayout12 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
                if (linearLayout12 != null) {
                    linearLayout12.setVisibility(8);
                }
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
                TextView textView3 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
                LinearLayout linearLayout13 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
                if (linearLayout13 != null) {
                    linearLayout13.setVisibility(0);
                }
            } else {
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
                LinearLayout linearLayout14 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.globalElecLt : null;
                if (linearLayout14 != null) {
                    linearLayout14.setVisibility(0);
                }
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
                TextView textView4 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.globalElecTv : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
                LinearLayout linearLayout15 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.globalElecThirdLt : null;
                if (linearLayout15 != null) {
                    linearLayout15.setVisibility(8);
                }
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
            LinearLayout linearLayout16 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.sgpaCgpaLt : null;
            if (linearLayout16 != null) {
                linearLayout16.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
            TextView textView5 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.sgpaCgpaTv : null;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
            LinearLayout linearLayout17 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.supplyLt : null;
            if (linearLayout17 != null) {
                linearLayout17.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
            TextView textView6 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.supplyTv : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
            LinearLayout linearLayout18 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.prevSemLt : null;
            if (linearLayout18 != null) {
                linearLayout18.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
            TextView textView7 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.prevSemTv : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
            LinearLayout linearLayout19 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.feeDetailsLt : null;
            if (linearLayout19 != null) {
                linearLayout19.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            TextView textView8 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.feeDetailsTv : null;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
            LinearLayout linearLayout20 = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.dueLt : null;
            if (linearLayout20 != null) {
                linearLayout20.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding28 = this$0.get_binding();
            TextView textView9 = dialogMvjceSemRegBinding28 != null ? dialogMvjceSemRegBinding28.dueTv : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding29 = this$0.get_binding();
            LinearLayout linearLayout21 = dialogMvjceSemRegBinding29 != null ? dialogMvjceSemRegBinding29.pageOne : null;
            if (linearLayout21 != null) {
                linearLayout21.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding30 = this$0.get_binding();
            LinearLayout linearLayout22 = dialogMvjceSemRegBinding30 != null ? dialogMvjceSemRegBinding30.pageTwo : null;
            if (linearLayout22 != null) {
                linearLayout22.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding31 = this$0.get_binding();
            LinearLayout linearLayout23 = dialogMvjceSemRegBinding31 != null ? dialogMvjceSemRegBinding31.pageThree : null;
            if (linearLayout23 != null) {
                linearLayout23.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding32 = this$0.get_binding();
            LinearLayout linearLayout24 = dialogMvjceSemRegBinding32 != null ? dialogMvjceSemRegBinding32.pageFour : null;
            if (linearLayout24 != null) {
                linearLayout24.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding33 = this$0.get_binding();
            LinearLayout linearLayout25 = dialogMvjceSemRegBinding33 != null ? dialogMvjceSemRegBinding33.pageFive : null;
            if (linearLayout25 != null) {
                linearLayout25.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding34 = this$0.get_binding();
            LinearLayout linearLayout26 = dialogMvjceSemRegBinding34 != null ? dialogMvjceSemRegBinding34.pageSix : null;
            if (linearLayout26 != null) {
                linearLayout26.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding35 = this$0.get_binding();
            LinearLayout linearLayout27 = dialogMvjceSemRegBinding35 != null ? dialogMvjceSemRegBinding35.pageSeven : null;
            if (linearLayout27 != null) {
                linearLayout27.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding36 = this$0.get_binding();
            LinearLayout linearLayout28 = dialogMvjceSemRegBinding36 != null ? dialogMvjceSemRegBinding36.pageEight : null;
            if (linearLayout28 != null) {
                linearLayout28.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding37 = this$0.get_binding();
            TextView textView10 = dialogMvjceSemRegBinding37 != null ? dialogMvjceSemRegBinding37.examAttTv : null;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding38 = this$0.get_binding();
            LinearLayout linearLayout29 = dialogMvjceSemRegBinding38 != null ? dialogMvjceSemRegBinding38.universityPreviousLayout : null;
            if (linearLayout29 != null) {
                linearLayout29.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding39 = this$0.get_binding();
            LinearLayout linearLayout30 = dialogMvjceSemRegBinding39 != null ? dialogMvjceSemRegBinding39.honorMinorLt : null;
            if (linearLayout30 != null) {
                linearLayout30.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding40 = this$0.get_binding();
            TextView textView11 = dialogMvjceSemRegBinding40 != null ? dialogMvjceSemRegBinding40.honorMinorTv : null;
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding41 = this$0.get_binding();
            LinearLayout linearLayout31 = dialogMvjceSemRegBinding41 != null ? dialogMvjceSemRegBinding41.globalElecLt : null;
            if (linearLayout31 != null) {
                linearLayout31.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding42 = this$0.get_binding();
            TextView textView12 = dialogMvjceSemRegBinding42 != null ? dialogMvjceSemRegBinding42.globalElecTv : null;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding43 = this$0.get_binding();
            LinearLayout linearLayout32 = dialogMvjceSemRegBinding43 != null ? dialogMvjceSemRegBinding43.globalElecThirdLt : null;
            if (linearLayout32 != null) {
                linearLayout32.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding44 = this$0.get_binding();
            LinearLayout linearLayout33 = dialogMvjceSemRegBinding44 != null ? dialogMvjceSemRegBinding44.sgpaCgpaLt : null;
            if (linearLayout33 != null) {
                linearLayout33.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding45 = this$0.get_binding();
            TextView textView13 = dialogMvjceSemRegBinding45 != null ? dialogMvjceSemRegBinding45.sgpaCgpaTv : null;
            if (textView13 != null) {
                textView13.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding46 = this$0.get_binding();
            LinearLayout linearLayout34 = dialogMvjceSemRegBinding46 != null ? dialogMvjceSemRegBinding46.supplyLt : null;
            if (linearLayout34 != null) {
                linearLayout34.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding47 = this$0.get_binding();
            TextView textView14 = dialogMvjceSemRegBinding47 != null ? dialogMvjceSemRegBinding47.supplyTv : null;
            if (textView14 != null) {
                textView14.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding48 = this$0.get_binding();
            LinearLayout linearLayout35 = dialogMvjceSemRegBinding48 != null ? dialogMvjceSemRegBinding48.prevSemLt : null;
            if (linearLayout35 != null) {
                linearLayout35.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding49 = this$0.get_binding();
            TextView textView15 = dialogMvjceSemRegBinding49 != null ? dialogMvjceSemRegBinding49.prevSemTv : null;
            if (textView15 != null) {
                textView15.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding50 = this$0.get_binding();
            LinearLayout linearLayout36 = dialogMvjceSemRegBinding50 != null ? dialogMvjceSemRegBinding50.feeDetailsLt : null;
            if (linearLayout36 != null) {
                linearLayout36.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding51 = this$0.get_binding();
            TextView textView16 = dialogMvjceSemRegBinding51 != null ? dialogMvjceSemRegBinding51.feeDetailsTv : null;
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding52 = this$0.get_binding();
            LinearLayout linearLayout37 = dialogMvjceSemRegBinding52 != null ? dialogMvjceSemRegBinding52.dueLt : null;
            if (linearLayout37 != null) {
                linearLayout37.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding53 = this$0.get_binding();
            TextView textView17 = dialogMvjceSemRegBinding53 != null ? dialogMvjceSemRegBinding53.dueTv : null;
            if (textView17 != null) {
                textView17.setVisibility(8);
            }
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding54 = this$0.get_binding();
            TextView textView18 = dialogMvjceSemRegBinding54 != null ? dialogMvjceSemRegBinding54.registerBtn : null;
            if (textView18 != null) {
                textView18.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding55 = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding55 != null ? dialogMvjceSemRegBinding55.registerLyt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding56 = this$0.get_binding();
        TextView textView19 = dialogMvjceSemRegBinding56 != null ? dialogMvjceSemRegBinding56.registerBtn : null;
        if (textView19 != null) {
            textView19.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding57 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding57 != null ? dialogMvjceSemRegBinding57.registerLyt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$16(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.pageOne : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.pageTwo : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.pageThree : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.pageFour : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.pageFive : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.pageSix : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.pageSeven : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.pageEight : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextView textView = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.examAttTv : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(0);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.honorMinorLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.honorMinorTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.globalElecLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        TextView textView3 = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.globalElecTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogMvjceSemRegBinding15 != null ? dialogMvjceSemRegBinding15.globalElecThirdLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = this$0.get_binding();
        TextView textView4 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.sgpaCgpaTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.supplyLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = this$0.get_binding();
        TextView textView5 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.supplyTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.prevSemLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = this$0.get_binding();
        TextView textView6 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.prevSemTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout17 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.feeDetailsLt : null;
        if (linearLayout17 != null) {
            linearLayout17.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = this$0.get_binding();
        TextView textView7 = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.feeDetailsTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout18 = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.dueLt : null;
        if (linearLayout18 != null) {
            linearLayout18.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = this$0.get_binding();
        TextView textView8 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.dueTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = this$0.get_binding();
            TextView textView9 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.registerBtn : null;
            if (textView9 != null) {
                textView9.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.registerLyt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding28 = this$0.get_binding();
        TextView textView10 = dialogMvjceSemRegBinding28 != null ? dialogMvjceSemRegBinding28.registerBtn : null;
        if (textView10 != null) {
            textView10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding29 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding29 != null ? dialogMvjceSemRegBinding29.registerLyt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$17(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.exam_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtMonthYear : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        this$0.regDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtMonthYear : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$18(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtBusDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.bus = string;
            return;
        }
        this$0.regDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtBusDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.bus = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$19(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.fee_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            TextInputLayout textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtBankName : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
            TextInputLayout textInputLayout2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtAmountPaid : null;
            if (textInputLayout2 != null) {
                textInputLayout2.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
            TextInputLayout textInputLayout3 = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.mtDatePayment : null;
            if (textInputLayout3 != null) {
                textInputLayout3.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
            TextInputLayout textInputLayout4 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.mtModePayment : null;
            if (textInputLayout4 != null) {
                textInputLayout4.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
            TextInputLayout textInputLayout5 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.mtRefNo : null;
            if (textInputLayout5 != null) {
                textInputLayout5.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
            TextView textView = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.completionFileName : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.uploadLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.feePaid = string;
            return;
        }
        this$0.regDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        TextInputLayout textInputLayout6 = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.mtBankName : null;
        if (textInputLayout6 != null) {
            textInputLayout6.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
        TextInputLayout textInputLayout7 = dialogMvjceSemRegBinding9 != null ? dialogMvjceSemRegBinding9.mtAmountPaid : null;
        if (textInputLayout7 != null) {
            textInputLayout7.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
        TextInputLayout textInputLayout8 = dialogMvjceSemRegBinding10 != null ? dialogMvjceSemRegBinding10.mtDatePayment : null;
        if (textInputLayout8 != null) {
            textInputLayout8.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
        TextInputLayout textInputLayout9 = dialogMvjceSemRegBinding11 != null ? dialogMvjceSemRegBinding11.mtModePayment : null;
        if (textInputLayout9 != null) {
            textInputLayout9.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
        TextInputLayout textInputLayout10 = dialogMvjceSemRegBinding12 != null ? dialogMvjceSemRegBinding12.mtRefNo : null;
        if (textInputLayout10 != null) {
            textInputLayout10.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
        TextView textView2 = dialogMvjceSemRegBinding13 != null ? dialogMvjceSemRegBinding13.completionFileName : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding14 != null ? dialogMvjceSemRegBinding14.uploadLyt : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.feePaid = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$20(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtBackPapers : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.back = string;
            return;
        }
        this$0.backDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtBackPapers : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.back = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$21(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.dept_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtDeptDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.dept = string;
            return;
        }
        this$0.deptDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtDeptDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.dept = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$22(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.concession_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtConcessionDetsils : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.feeConcession = string;
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        if (dialogMvjceSemRegBinding2 != null && (textInputEditText = dialogMvjceSemRegBinding2.etConcessionDetails) != null) {
            textInputEditText.setText("");
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.mtConcessionDetsils : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.feeConcession = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$23(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.academic_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtAcademicDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.academics = string;
            return;
        }
        this$0.academicsDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtAcademicDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.academics = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$24(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.accounts_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtAccountDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.accounts = string;
            return;
        }
        this$0.accountsDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtAccountDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.accounts = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$25(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.library_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtLibraryDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.library = string;
            return;
        }
        this$0.libraryDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtLibraryDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.library = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$26(MvjceSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.hostel_yes) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.mtHostelDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.hostel = string;
            return;
        }
        this$0.hostelDetails = "";
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.mtHostelDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.hostel = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$27(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.examAttClicked) {
            this$0.examAttClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.universityPreviousLayout : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.examAttClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.universityPreviousLayout : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$28(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.honorMinorClicked) {
            this$0.honorMinorClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.honorMinorLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.honorMinorClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.honorMinorLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$29(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.globalElectiveClicked) {
            this$0.globalElectiveClicked = true;
            if (Intrinsics.areEqual(this$0.type, ExifInterface.GPS_MEASUREMENT_3D)) {
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
                LinearLayout linearLayout2 = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.globalElecLt : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
                TextView textView = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.globalElecTv : null;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
                linearLayout = dialogMvjceSemRegBinding3 != null ? dialogMvjceSemRegBinding3.globalElecThirdLt : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
            LinearLayout linearLayout3 = dialogMvjceSemRegBinding4 != null ? dialogMvjceSemRegBinding4.globalElecLt : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
            TextView textView2 = dialogMvjceSemRegBinding5 != null ? dialogMvjceSemRegBinding5.globalElecTv : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding6 != null ? dialogMvjceSemRegBinding6.globalElecThirdLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        this$0.globalElectiveClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMvjceSemRegBinding7 != null ? dialogMvjceSemRegBinding7.globalElecLt : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding8 != null ? dialogMvjceSemRegBinding8.globalElecThirdLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$30(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.cgpaClicked) {
            this$0.cgpaClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.sgpaCgpaLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.cgpaClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.sgpaCgpaLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$31(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.supplyClicked) {
            this$0.supplyClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.supplyLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.supplyClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.supplyLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$32(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.prevSemClicked) {
            this$0.prevSemClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.prevSemLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.prevSemClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.prevSemLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$33(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.feeClicked) {
            this$0.feeClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.feeDetailsLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.feeClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.feeDetailsLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$34(MvjceSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.dueClicked) {
            this$0.dueClicked = true;
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            linearLayout = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.dueLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.dueClicked = false;
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.dueLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$35(MvjceSemRegDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
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
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.clear();
        hashMap2.clear();
        Editable editable = null;
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMvjceSemRegBinding == null || (textInputEditText13 = dialogMvjceSemRegBinding.etMonthYear) == null) ? null : textInputEditText13.getText()), "") && Intrinsics.areEqual(this$0.back, "Yes")) {
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = this$0.get_binding();
                if (Intrinsics.areEqual(String.valueOf((dialogMvjceSemRegBinding2 == null || (textInputEditText12 = dialogMvjceSemRegBinding2.etBackPaperCount) == null) ? null : textInputEditText12.getText()), "")) {
                    this$0.confirmApproveView(" - Please Fill Registered Month and Year!!\n - Please specify number of back papers!!");
                    return;
                }
            }
        }
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMvjceSemRegBinding3 == null || (textInputEditText11 = dialogMvjceSemRegBinding3.etMonthYear) == null) ? null : textInputEditText11.getText()), "")) {
                this$0.confirmApproveView(" - Please Fill Registered Month and year!!");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMvjceSemRegBinding4 == null || (textInputEditText10 = dialogMvjceSemRegBinding4.etBackPaperCount) == null) ? null : textInputEditText10.getText()), "")) {
                this$0.confirmApproveView(" - Please specify number of back papers!!");
                return;
            }
        }
        if (!Intrinsics.areEqual(this$0.id, "")) {
            String str = this$0.id;
            Intrinsics.checkNotNull(str);
            hashMap.put("id", str);
        }
        HashMap hashMap3 = hashMap;
        hashMap3.put("SemesterRegistration[semester_id]", this$0.semester_id);
        hashMap3.put("SemesterRegistration[exam_appear]", this$0.reg);
        hashMap3.put("SemesterRegistration[backpaper]", this$0.back);
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = this$0.get_binding();
        hashMap3.put("SemesterRegistration[earned_credits]", String.valueOf((dialogMvjceSemRegBinding5 == null || (textInputEditText9 = dialogMvjceSemRegBinding5.etEarnedCredits) == null) ? null : textInputEditText9.getText()));
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[exam_month_year]", String.valueOf((dialogMvjceSemRegBinding6 == null || (textInputEditText8 = dialogMvjceSemRegBinding6.etMonthYear) == null) ? null : textInputEditText8.getText()));
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[backlogs_count]", String.valueOf((dialogMvjceSemRegBinding7 == null || (textInputEditText7 = dialogMvjceSemRegBinding7.etBackPaperCount) == null) ? null : textInputEditText7.getText()));
        }
        hashMap3.put("SemesterRegistration[department_due]", this$0.dept);
        if (Intrinsics.areEqual(this$0.dept, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[department_due_details]", String.valueOf((dialogMvjceSemRegBinding8 == null || (textInputEditText6 = dialogMvjceSemRegBinding8.etDeptDetails) == null) ? null : textInputEditText6.getText()));
        }
        hashMap3.put("SemesterRegistration[library_due]", this$0.library);
        if (Intrinsics.areEqual(this$0.library, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[librarary_due_details]", String.valueOf((dialogMvjceSemRegBinding9 == null || (textInputEditText5 = dialogMvjceSemRegBinding9.etLibraryDetails) == null) ? null : textInputEditText5.getText()));
        }
        hashMap3.put("SemesterRegistration[accounts_due]", this$0.accounts);
        if (Intrinsics.areEqual(this$0.accounts, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[accounts_due_details]", String.valueOf((dialogMvjceSemRegBinding10 == null || (textInputEditText4 = dialogMvjceSemRegBinding10.etAccountsDetails) == null) ? null : textInputEditText4.getText()));
        }
        hashMap3.put("SemesterRegistration[academic_due]", this$0.academics);
        if (Intrinsics.areEqual(this$0.academics, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[academic_due_details]", String.valueOf((dialogMvjceSemRegBinding11 == null || (textInputEditText3 = dialogMvjceSemRegBinding11.etAcademicDetails) == null) ? null : textInputEditText3.getText()));
        }
        hashMap3.put("SemesterRegistration[hostel_due]", this$0.hostel);
        if (Intrinsics.areEqual(this$0.hostel, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = this$0.get_binding();
            hashMap3.put("SemesterRegistration[hostel_due_details]", String.valueOf((dialogMvjceSemRegBinding12 == null || (textInputEditText2 = dialogMvjceSemRegBinding12.etHostelDetails) == null) ? null : textInputEditText2.getText()));
        }
        hashMap3.put("SemesterRegistration[bus_due]", this$0.bus);
        if (Intrinsics.areEqual(this$0.bus, "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = this$0.get_binding();
            if (dialogMvjceSemRegBinding13 != null && (textInputEditText = dialogMvjceSemRegBinding13.etBusDetails) != null) {
                editable = textInputEditText.getText();
            }
            hashMap3.put("SemesterRegistration[bus_due_details]", String.valueOf(editable));
        }
        if (!Intrinsics.areEqual(this$0.id, "")) {
            MvjceSemRegViewModel mvjceSemRegViewModel = this$0.getMvjceSemRegViewModel();
            String str2 = this$0.id;
            Intrinsics.checkNotNull(str2);
            mvjceSemRegViewModel.registerWithoutReceipt(str2, hashMap3);
            return;
        }
        System.out.println(hashMap);
        this$0.getMvjceSemRegViewModel().registerWithoutReceipt(hashMap3);
    }

    private final void listenViewResponse() {
        getMvjceSemRegViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MvjceSemRegDialog.listenViewResponse$lambda$37(MvjceSemRegDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenViewResponse$lambda$37(MvjceSemRegDialog this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SemRegViewResponse semRegViewResponse = (SemRegViewResponse) resource.getData();
            if (semRegViewResponse != null) {
                this$0.loadView(semRegViewResponse);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = this$0.get_binding();
        if (dialogMvjceSemRegBinding == null || (textView = dialogMvjceSemRegBinding.registerBtn) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    private final void loadView(SemRegViewResponse response) {
        TextInputLayout textInputLayout;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
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
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding = get_binding();
        if (dialogMvjceSemRegBinding != null && (textInputEditText15 = dialogMvjceSemRegBinding.etBackPaperCount) != null) {
            textInputEditText15.setText(response.getBackPaperCount());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = get_binding();
        if (dialogMvjceSemRegBinding2 != null && (textInputEditText14 = dialogMvjceSemRegBinding2.etMonthYear) != null) {
            textInputEditText14.setText(response.getExamMonthYear());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding3 = get_binding();
        if (dialogMvjceSemRegBinding3 != null && (textInputEditText13 = dialogMvjceSemRegBinding3.etEarnedCredits) != null) {
            textInputEditText13.setText(response.getEarnedCredits());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding4 = get_binding();
        if (dialogMvjceSemRegBinding4 != null && (textInputEditText12 = dialogMvjceSemRegBinding4.etBankName) != null) {
            textInputEditText12.setText(response.getBankName());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding5 = get_binding();
        if (dialogMvjceSemRegBinding5 != null && (textInputEditText11 = dialogMvjceSemRegBinding5.etAmountPaid) != null) {
            textInputEditText11.setText(response.getAmountPaid());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding6 = get_binding();
        if (dialogMvjceSemRegBinding6 != null && (textInputEditText10 = dialogMvjceSemRegBinding6.etModePayment) != null) {
            textInputEditText10.setText(response.getPaymentMode());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding7 = get_binding();
        if (dialogMvjceSemRegBinding7 != null && (textInputEditText9 = dialogMvjceSemRegBinding7.etDatePayment) != null) {
            textInputEditText9.setText(response.getPaymentDate());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding8 = get_binding();
        if (dialogMvjceSemRegBinding8 != null && (textInputEditText8 = dialogMvjceSemRegBinding8.etRefNo) != null) {
            textInputEditText8.setText(response.getPaymentReferenceNo());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding9 = get_binding();
        if (dialogMvjceSemRegBinding9 != null && (textInputEditText7 = dialogMvjceSemRegBinding9.etConcessionDetails) != null) {
            textInputEditText7.setText(response.getFeeConcessionCategory());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding10 = get_binding();
        if (dialogMvjceSemRegBinding10 != null && (textInputEditText6 = dialogMvjceSemRegBinding10.etDeptDetails) != null) {
            textInputEditText6.setText(response.getDepartmentDueDetails());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding11 = get_binding();
        if (dialogMvjceSemRegBinding11 != null && (textInputEditText5 = dialogMvjceSemRegBinding11.etLibraryDetails) != null) {
            textInputEditText5.setText(response.getLibraryDueDetails());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding12 = get_binding();
        if (dialogMvjceSemRegBinding12 != null && (textInputEditText4 = dialogMvjceSemRegBinding12.etAccountsDetails) != null) {
            textInputEditText4.setText(response.getAccountsDueDetails());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding13 = get_binding();
        if (dialogMvjceSemRegBinding13 != null && (textInputEditText3 = dialogMvjceSemRegBinding13.etAcademicDetails) != null) {
            textInputEditText3.setText(response.getAcademicDueDetails());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding14 = get_binding();
        if (dialogMvjceSemRegBinding14 != null && (textInputEditText2 = dialogMvjceSemRegBinding14.etHostelDetails) != null) {
            textInputEditText2.setText(response.getHostelDueDetails());
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding15 = get_binding();
        if (dialogMvjceSemRegBinding15 != null && (textInputEditText = dialogMvjceSemRegBinding15.etBusDetails) != null) {
            textInputEditText.setText(response.getBusDueDetails());
        }
        if (Intrinsics.areEqual(response.getFeePaid(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding16 = get_binding();
            RadioButton radioButton = dialogMvjceSemRegBinding16 != null ? dialogMvjceSemRegBinding16.feeYes : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding17 = get_binding();
            RadioButton radioButton2 = dialogMvjceSemRegBinding17 != null ? dialogMvjceSemRegBinding17.feeNo : null;
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding18 = get_binding();
            TextInputLayout textInputLayout2 = dialogMvjceSemRegBinding18 != null ? dialogMvjceSemRegBinding18.mtBankName : null;
            if (textInputLayout2 != null) {
                textInputLayout2.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding19 = get_binding();
            TextInputLayout textInputLayout3 = dialogMvjceSemRegBinding19 != null ? dialogMvjceSemRegBinding19.mtAmountPaid : null;
            if (textInputLayout3 != null) {
                textInputLayout3.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding20 = get_binding();
            TextInputLayout textInputLayout4 = dialogMvjceSemRegBinding20 != null ? dialogMvjceSemRegBinding20.mtDatePayment : null;
            if (textInputLayout4 != null) {
                textInputLayout4.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding21 = get_binding();
            TextInputLayout textInputLayout5 = dialogMvjceSemRegBinding21 != null ? dialogMvjceSemRegBinding21.mtModePayment : null;
            if (textInputLayout5 != null) {
                textInputLayout5.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding22 = get_binding();
            TextInputLayout textInputLayout6 = dialogMvjceSemRegBinding22 != null ? dialogMvjceSemRegBinding22.mtRefNo : null;
            if (textInputLayout6 != null) {
                textInputLayout6.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding23 = get_binding();
            TextView textView = dialogMvjceSemRegBinding23 != null ? dialogMvjceSemRegBinding23.completionFileName : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding24 = get_binding();
            LinearLayout linearLayout = dialogMvjceSemRegBinding24 != null ? dialogMvjceSemRegBinding24.uploadLyt : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding25 = get_binding();
            RadioButton radioButton3 = dialogMvjceSemRegBinding25 != null ? dialogMvjceSemRegBinding25.feeYes : null;
            if (radioButton3 != null) {
                radioButton3.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding26 = get_binding();
            RadioButton radioButton4 = dialogMvjceSemRegBinding26 != null ? dialogMvjceSemRegBinding26.feeNo : null;
            if (radioButton4 != null) {
                radioButton4.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding27 = get_binding();
            TextInputLayout textInputLayout7 = dialogMvjceSemRegBinding27 != null ? dialogMvjceSemRegBinding27.mtBankName : null;
            if (textInputLayout7 != null) {
                textInputLayout7.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding28 = get_binding();
            TextInputLayout textInputLayout8 = dialogMvjceSemRegBinding28 != null ? dialogMvjceSemRegBinding28.mtAmountPaid : null;
            if (textInputLayout8 != null) {
                textInputLayout8.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding29 = get_binding();
            TextInputLayout textInputLayout9 = dialogMvjceSemRegBinding29 != null ? dialogMvjceSemRegBinding29.mtDatePayment : null;
            if (textInputLayout9 != null) {
                textInputLayout9.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding30 = get_binding();
            TextInputLayout textInputLayout10 = dialogMvjceSemRegBinding30 != null ? dialogMvjceSemRegBinding30.mtModePayment : null;
            if (textInputLayout10 != null) {
                textInputLayout10.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding31 = get_binding();
            TextInputLayout textInputLayout11 = dialogMvjceSemRegBinding31 != null ? dialogMvjceSemRegBinding31.mtRefNo : null;
            if (textInputLayout11 != null) {
                textInputLayout11.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding32 = get_binding();
            TextView textView2 = dialogMvjceSemRegBinding32 != null ? dialogMvjceSemRegBinding32.completionFileName : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding33 = get_binding();
            LinearLayout linearLayout2 = dialogMvjceSemRegBinding33 != null ? dialogMvjceSemRegBinding33.uploadLyt : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getFeeConcession(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding34 = get_binding();
            RadioButton radioButton5 = dialogMvjceSemRegBinding34 != null ? dialogMvjceSemRegBinding34.concessionYes : null;
            if (radioButton5 != null) {
                radioButton5.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding35 = get_binding();
            RadioButton radioButton6 = dialogMvjceSemRegBinding35 != null ? dialogMvjceSemRegBinding35.concessionNo : null;
            if (radioButton6 != null) {
                radioButton6.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding36 = get_binding();
            TextInputLayout textInputLayout12 = dialogMvjceSemRegBinding36 != null ? dialogMvjceSemRegBinding36.mtConcessionDetsils : null;
            if (textInputLayout12 != null) {
                textInputLayout12.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding37 = get_binding();
            RadioButton radioButton7 = dialogMvjceSemRegBinding37 != null ? dialogMvjceSemRegBinding37.concessionYes : null;
            if (radioButton7 != null) {
                radioButton7.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding38 = get_binding();
            RadioButton radioButton8 = dialogMvjceSemRegBinding38 != null ? dialogMvjceSemRegBinding38.concessionNo : null;
            if (radioButton8 != null) {
                radioButton8.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding39 = get_binding();
            TextInputLayout textInputLayout13 = dialogMvjceSemRegBinding39 != null ? dialogMvjceSemRegBinding39.mtConcessionDetsils : null;
            if (textInputLayout13 != null) {
                textInputLayout13.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getBusDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding40 = get_binding();
            RadioButton radioButton9 = dialogMvjceSemRegBinding40 != null ? dialogMvjceSemRegBinding40.busYes : null;
            if (radioButton9 != null) {
                radioButton9.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding41 = get_binding();
            RadioButton radioButton10 = dialogMvjceSemRegBinding41 != null ? dialogMvjceSemRegBinding41.busNo : null;
            if (radioButton10 != null) {
                radioButton10.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding42 = get_binding();
            TextInputLayout textInputLayout14 = dialogMvjceSemRegBinding42 != null ? dialogMvjceSemRegBinding42.mtBusDetail : null;
            if (textInputLayout14 != null) {
                textInputLayout14.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding43 = get_binding();
            RadioButton radioButton11 = dialogMvjceSemRegBinding43 != null ? dialogMvjceSemRegBinding43.busYes : null;
            if (radioButton11 != null) {
                radioButton11.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding44 = get_binding();
            RadioButton radioButton12 = dialogMvjceSemRegBinding44 != null ? dialogMvjceSemRegBinding44.busNo : null;
            if (radioButton12 != null) {
                radioButton12.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding45 = get_binding();
            TextInputLayout textInputLayout15 = dialogMvjceSemRegBinding45 != null ? dialogMvjceSemRegBinding45.mtBusDetail : null;
            if (textInputLayout15 != null) {
                textInputLayout15.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getAcademicDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding46 = get_binding();
            RadioButton radioButton13 = dialogMvjceSemRegBinding46 != null ? dialogMvjceSemRegBinding46.academicYes : null;
            if (radioButton13 != null) {
                radioButton13.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding47 = get_binding();
            RadioButton radioButton14 = dialogMvjceSemRegBinding47 != null ? dialogMvjceSemRegBinding47.academicNo : null;
            if (radioButton14 != null) {
                radioButton14.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding48 = get_binding();
            TextInputLayout textInputLayout16 = dialogMvjceSemRegBinding48 != null ? dialogMvjceSemRegBinding48.mtAcademicDetail : null;
            if (textInputLayout16 != null) {
                textInputLayout16.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding49 = get_binding();
            RadioButton radioButton15 = dialogMvjceSemRegBinding49 != null ? dialogMvjceSemRegBinding49.academicYes : null;
            if (radioButton15 != null) {
                radioButton15.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding50 = get_binding();
            RadioButton radioButton16 = dialogMvjceSemRegBinding50 != null ? dialogMvjceSemRegBinding50.academicNo : null;
            if (radioButton16 != null) {
                radioButton16.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding51 = get_binding();
            TextInputLayout textInputLayout17 = dialogMvjceSemRegBinding51 != null ? dialogMvjceSemRegBinding51.mtAcademicDetail : null;
            if (textInputLayout17 != null) {
                textInputLayout17.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getDepartmentDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding52 = get_binding();
            RadioButton radioButton17 = dialogMvjceSemRegBinding52 != null ? dialogMvjceSemRegBinding52.deptYes : null;
            if (radioButton17 != null) {
                radioButton17.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding53 = get_binding();
            RadioButton radioButton18 = dialogMvjceSemRegBinding53 != null ? dialogMvjceSemRegBinding53.deptNo : null;
            if (radioButton18 != null) {
                radioButton18.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding54 = get_binding();
            TextInputLayout textInputLayout18 = dialogMvjceSemRegBinding54 != null ? dialogMvjceSemRegBinding54.mtDeptDetail : null;
            if (textInputLayout18 != null) {
                textInputLayout18.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding55 = get_binding();
            RadioButton radioButton19 = dialogMvjceSemRegBinding55 != null ? dialogMvjceSemRegBinding55.deptYes : null;
            if (radioButton19 != null) {
                radioButton19.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding56 = get_binding();
            RadioButton radioButton20 = dialogMvjceSemRegBinding56 != null ? dialogMvjceSemRegBinding56.deptNo : null;
            if (radioButton20 != null) {
                radioButton20.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding57 = get_binding();
            TextInputLayout textInputLayout19 = dialogMvjceSemRegBinding57 != null ? dialogMvjceSemRegBinding57.mtDeptDetail : null;
            if (textInputLayout19 != null) {
                textInputLayout19.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getLibraryDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding58 = get_binding();
            RadioButton radioButton21 = dialogMvjceSemRegBinding58 != null ? dialogMvjceSemRegBinding58.libraryYes : null;
            if (radioButton21 != null) {
                radioButton21.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding59 = get_binding();
            RadioButton radioButton22 = dialogMvjceSemRegBinding59 != null ? dialogMvjceSemRegBinding59.libraryNo : null;
            if (radioButton22 != null) {
                radioButton22.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding60 = get_binding();
            TextInputLayout textInputLayout20 = dialogMvjceSemRegBinding60 != null ? dialogMvjceSemRegBinding60.mtLibraryDetail : null;
            if (textInputLayout20 != null) {
                textInputLayout20.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding61 = get_binding();
            RadioButton radioButton23 = dialogMvjceSemRegBinding61 != null ? dialogMvjceSemRegBinding61.libraryYes : null;
            if (radioButton23 != null) {
                radioButton23.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding62 = get_binding();
            RadioButton radioButton24 = dialogMvjceSemRegBinding62 != null ? dialogMvjceSemRegBinding62.libraryNo : null;
            if (radioButton24 != null) {
                radioButton24.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding63 = get_binding();
            TextInputLayout textInputLayout21 = dialogMvjceSemRegBinding63 != null ? dialogMvjceSemRegBinding63.mtLibraryDetail : null;
            if (textInputLayout21 != null) {
                textInputLayout21.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getAccountsDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding64 = get_binding();
            RadioButton radioButton25 = dialogMvjceSemRegBinding64 != null ? dialogMvjceSemRegBinding64.accountsYes : null;
            if (radioButton25 != null) {
                radioButton25.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding65 = get_binding();
            RadioButton radioButton26 = dialogMvjceSemRegBinding65 != null ? dialogMvjceSemRegBinding65.accountsNo : null;
            if (radioButton26 != null) {
                radioButton26.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding66 = get_binding();
            TextInputLayout textInputLayout22 = dialogMvjceSemRegBinding66 != null ? dialogMvjceSemRegBinding66.mtAccountDetail : null;
            if (textInputLayout22 != null) {
                textInputLayout22.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding67 = get_binding();
            RadioButton radioButton27 = dialogMvjceSemRegBinding67 != null ? dialogMvjceSemRegBinding67.accountsYes : null;
            if (radioButton27 != null) {
                radioButton27.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding68 = get_binding();
            RadioButton radioButton28 = dialogMvjceSemRegBinding68 != null ? dialogMvjceSemRegBinding68.accountsNo : null;
            if (radioButton28 != null) {
                radioButton28.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding69 = get_binding();
            TextInputLayout textInputLayout23 = dialogMvjceSemRegBinding69 != null ? dialogMvjceSemRegBinding69.mtAccountDetail : null;
            if (textInputLayout23 != null) {
                textInputLayout23.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getAcademicDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding70 = get_binding();
            RadioButton radioButton29 = dialogMvjceSemRegBinding70 != null ? dialogMvjceSemRegBinding70.academicYes : null;
            if (radioButton29 != null) {
                radioButton29.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding71 = get_binding();
            RadioButton radioButton30 = dialogMvjceSemRegBinding71 != null ? dialogMvjceSemRegBinding71.academicNo : null;
            if (radioButton30 != null) {
                radioButton30.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding72 = get_binding();
            TextInputLayout textInputLayout24 = dialogMvjceSemRegBinding72 != null ? dialogMvjceSemRegBinding72.mtAcademicDetail : null;
            if (textInputLayout24 != null) {
                textInputLayout24.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding73 = get_binding();
            RadioButton radioButton31 = dialogMvjceSemRegBinding73 != null ? dialogMvjceSemRegBinding73.academicYes : null;
            if (radioButton31 != null) {
                radioButton31.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding74 = get_binding();
            RadioButton radioButton32 = dialogMvjceSemRegBinding74 != null ? dialogMvjceSemRegBinding74.academicNo : null;
            if (radioButton32 != null) {
                radioButton32.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding75 = get_binding();
            TextInputLayout textInputLayout25 = dialogMvjceSemRegBinding75 != null ? dialogMvjceSemRegBinding75.mtAcademicDetail : null;
            if (textInputLayout25 != null) {
                textInputLayout25.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getHostelDue(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding76 = get_binding();
            RadioButton radioButton33 = dialogMvjceSemRegBinding76 != null ? dialogMvjceSemRegBinding76.hostelYes : null;
            if (radioButton33 != null) {
                radioButton33.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding77 = get_binding();
            RadioButton radioButton34 = dialogMvjceSemRegBinding77 != null ? dialogMvjceSemRegBinding77.hostelNo : null;
            if (radioButton34 != null) {
                radioButton34.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding78 = get_binding();
            TextInputLayout textInputLayout26 = dialogMvjceSemRegBinding78 != null ? dialogMvjceSemRegBinding78.mtHostelDetail : null;
            if (textInputLayout26 != null) {
                textInputLayout26.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding79 = get_binding();
            RadioButton radioButton35 = dialogMvjceSemRegBinding79 != null ? dialogMvjceSemRegBinding79.hostelYes : null;
            if (radioButton35 != null) {
                radioButton35.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding80 = get_binding();
            RadioButton radioButton36 = dialogMvjceSemRegBinding80 != null ? dialogMvjceSemRegBinding80.hostelNo : null;
            if (radioButton36 != null) {
                radioButton36.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding81 = get_binding();
            TextInputLayout textInputLayout27 = dialogMvjceSemRegBinding81 != null ? dialogMvjceSemRegBinding81.mtHostelDetail : null;
            if (textInputLayout27 != null) {
                textInputLayout27.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getExamAppear(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding82 = get_binding();
            RadioButton radioButton37 = dialogMvjceSemRegBinding82 != null ? dialogMvjceSemRegBinding82.examYes : null;
            if (radioButton37 != null) {
                radioButton37.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding83 = get_binding();
            RadioButton radioButton38 = dialogMvjceSemRegBinding83 != null ? dialogMvjceSemRegBinding83.examNo : null;
            if (radioButton38 != null) {
                radioButton38.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding84 = get_binding();
            TextInputLayout textInputLayout28 = dialogMvjceSemRegBinding84 != null ? dialogMvjceSemRegBinding84.mtMonthYear : null;
            if (textInputLayout28 != null) {
                textInputLayout28.setVisibility(0);
            }
        } else {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding85 = get_binding();
            RadioButton radioButton39 = dialogMvjceSemRegBinding85 != null ? dialogMvjceSemRegBinding85.examYes : null;
            if (radioButton39 != null) {
                radioButton39.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding86 = get_binding();
            RadioButton radioButton40 = dialogMvjceSemRegBinding86 != null ? dialogMvjceSemRegBinding86.examNo : null;
            if (radioButton40 != null) {
                radioButton40.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding87 = get_binding();
            TextInputLayout textInputLayout29 = dialogMvjceSemRegBinding87 != null ? dialogMvjceSemRegBinding87.mtMonthYear : null;
            if (textInputLayout29 != null) {
                textInputLayout29.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(response.getBackPaper(), "Yes")) {
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding88 = get_binding();
            RadioButton radioButton41 = dialogMvjceSemRegBinding88 != null ? dialogMvjceSemRegBinding88.backYes : null;
            if (radioButton41 != null) {
                radioButton41.setChecked(true);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding89 = get_binding();
            RadioButton radioButton42 = dialogMvjceSemRegBinding89 != null ? dialogMvjceSemRegBinding89.backNo : null;
            if (radioButton42 != null) {
                radioButton42.setChecked(false);
            }
            DialogMvjceSemRegBinding dialogMvjceSemRegBinding90 = get_binding();
            textInputLayout = dialogMvjceSemRegBinding90 != null ? dialogMvjceSemRegBinding90.mtBackPapers : null;
            if (textInputLayout == null) {
                return;
            }
            textInputLayout.setVisibility(0);
            return;
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding91 = get_binding();
        RadioButton radioButton43 = dialogMvjceSemRegBinding91 != null ? dialogMvjceSemRegBinding91.backYes : null;
        if (radioButton43 != null) {
            radioButton43.setChecked(false);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding92 = get_binding();
        RadioButton radioButton44 = dialogMvjceSemRegBinding92 != null ? dialogMvjceSemRegBinding92.backNo : null;
        if (radioButton44 != null) {
            radioButton44.setChecked(true);
        }
        DialogMvjceSemRegBinding dialogMvjceSemRegBinding93 = get_binding();
        textInputLayout = dialogMvjceSemRegBinding93 != null ? dialogMvjceSemRegBinding93.mtBackPapers : null;
        if (textInputLayout == null) {
            return;
        }
        textInputLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toRoman(int i) {
        String str = "";
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(1000, "M"), TuplesKt.to(900, "CM"), TuplesKt.to(500, "D"), TuplesKt.to(400, "CD"), TuplesKt.to(100, SvgConstants.Attributes.PATH_DATA_CURVE_TO), TuplesKt.to(90, "XC"), TuplesKt.to(50, "L"), TuplesKt.to(40, "XL"), TuplesKt.to(10, "X"), TuplesKt.to(9, "IX"), TuplesKt.to(5, "V"), TuplesKt.to(4, "IV"), TuplesKt.to(1, "I")})) {
            int intValue = ((Number) pair.component1()).intValue();
            String str2 = (String) pair.component2();
            while (i >= intValue) {
                str = str + str2;
                i -= intValue;
            }
        }
        return str;
    }

    public final void mainSem() {
        String roman = toRoman(1);
        String roman2 = toRoman(3);
        if (StringsKt.contains$default((CharSequence) getPreference().getUserSem(), (CharSequence) (roman + "st Semester"), false, 2, (Object) null)) {
            this.type = "1";
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getUserSem(), (CharSequence) (roman2 + "rd Semester"), false, 2, (Object) null)) {
            this.type = ExifInterface.GPS_MEASUREMENT_3D;
            getMvjceSemRegViewModel().getDropDowns();
        } else {
            this.type = ExifInterface.GPS_MEASUREMENT_2D;
            getMvjceSemRegViewModel().getDropDowns();
        }
    }

    private final void listenResponse() {
        getMvjceSemRegViewModel().getRegisterResponse().observe(getViewLifecycleOwner(), new MvjceSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SemRegSuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$listenResponse$1

            /* compiled from: MvjceSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SemRegSuccessResponse> resource) {
                invoke2((Resource<SemRegSuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SemRegSuccessResponse> resource) {
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding;
                MvjceSemRegDialog.AddSemRegListener addSemRegListener;
                TextView registerBtn;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MvjceSemRegDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        MvjceSemRegDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        MvjceSemRegDialog.this.hideProgress();
                        return;
                    }
                }
                MvjceSemRegDialog.this.hideProgress();
                SemRegSuccessResponse data = resource.getData();
                if (data != null) {
                    MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                    if (data.getSuccess()) {
                        dialogMvjceSemRegBinding = mvjceSemRegDialog.get_binding();
                        if (dialogMvjceSemRegBinding != null && (registerBtn = dialogMvjceSemRegBinding.registerBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                            ToastExtKt.showSuccessToast(registerBtn, data.getMessage());
                        }
                        addSemRegListener = mvjceSemRegDialog.listener;
                        if (addSemRegListener != null) {
                            addSemRegListener.dismiss();
                        }
                        mvjceSemRegDialog.dismiss();
                        return;
                    }
                    mvjceSemRegDialog.confirmApproveView(data.getError());
                }
            }
        }));
    }

    private final void listenSpinners() {
        getMvjceSemRegViewModel().getDropResponse().observe(getViewLifecycleOwner(), new MvjceSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AcademicYearResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$listenSpinners$1

            /* compiled from: MvjceSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AcademicYearResponse> resource) {
                invoke2((Resource<AcademicYearResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AcademicYearResponse> resource) {
                String roman;
                String roman2;
                CurrentSemSpinnerAdapter spinnerSem;
                String str;
                String str2;
                AcademicYearSpinnerAdapter spinnerAdditional;
                AcademicYearSpinnerAdapter spinnerElective;
                AcademicYearSpinnerAdapter spinnerGlobal;
                AcademicYearSpinnerAdapter spinnerHonour;
                AcademicYearSpinnerAdapter spinnerMinors;
                AcademicYearSpinnerAdapter spinnerProgramElective;
                AcademicYearSpinnerAdapter spinnerAdditional2;
                AcademicYearSpinnerAdapter spinnerElective2;
                AcademicYearSpinnerAdapter spinnerGlobal2;
                AcademicYearSpinnerAdapter spinnerHonour2;
                AcademicYearSpinnerAdapter spinnerMinors2;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MvjceSemRegDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        MvjceSemRegDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        MvjceSemRegDialog.this.hideProgress();
                        return;
                    }
                }
                MvjceSemRegDialog.this.hideProgress();
                AcademicYearResponse data = resource.getData();
                if (data != null) {
                    MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                    roman = mvjceSemRegDialog.toRoman(1);
                    roman2 = mvjceSemRegDialog.toRoman(3);
                    if (StringsKt.contains$default((CharSequence) data.getSemester(), (CharSequence) (roman + "st Semester"), false, 2, (Object) null)) {
                        mvjceSemRegDialog.type = "1";
                    } else {
                        if (StringsKt.contains$default((CharSequence) data.getSemester(), (CharSequence) (roman2 + "rd Semester"), false, 2, (Object) null)) {
                            mvjceSemRegDialog.type = ExifInterface.GPS_MEASUREMENT_3D;
                        } else {
                            mvjceSemRegDialog.type = ExifInterface.GPS_MEASUREMENT_2D;
                        }
                    }
                    mvjceSemRegDialog.semester_id = data.getSemester_id();
                    spinnerSem = mvjceSemRegDialog.getSpinnerSem();
                    spinnerSem.addItems(CollectionsKt.arrayListOf(data.getSemester()));
                    str = mvjceSemRegDialog.type;
                    if (Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_2D)) {
                        spinnerAdditional2 = mvjceSemRegDialog.getSpinnerAdditional();
                        spinnerAdditional2.addItems(data.getAdditional_electives());
                        spinnerElective2 = mvjceSemRegDialog.getSpinnerElective();
                        spinnerElective2.addItems(data.getElectives());
                        spinnerGlobal2 = mvjceSemRegDialog.getSpinnerGlobal();
                        spinnerGlobal2.addItems(data.getGlobalelectives());
                        spinnerHonour2 = mvjceSemRegDialog.getSpinnerHonour();
                        spinnerHonour2.addItems(data.getHonours());
                        spinnerMinors2 = mvjceSemRegDialog.getSpinnerMinors();
                        spinnerMinors2.addItems(data.getMinors());
                    }
                    str2 = mvjceSemRegDialog.type;
                    if (Intrinsics.areEqual(str2, ExifInterface.GPS_MEASUREMENT_3D)) {
                        spinnerAdditional = mvjceSemRegDialog.getSpinnerAdditional();
                        spinnerAdditional.addItems(data.getAdditional_electives());
                        spinnerElective = mvjceSemRegDialog.getSpinnerElective();
                        spinnerElective.addItems(data.getElectives());
                        spinnerGlobal = mvjceSemRegDialog.getSpinnerGlobal();
                        spinnerGlobal.addItems(data.getGlobalelectives());
                        spinnerHonour = mvjceSemRegDialog.getSpinnerHonour();
                        spinnerHonour.addItems(data.getHonours());
                        spinnerMinors = mvjceSemRegDialog.getSpinnerMinors();
                        spinnerMinors.addItems(data.getMinors());
                        spinnerProgramElective = mvjceSemRegDialog.getSpinnerProgramElective();
                        spinnerProgramElective.addItems(data.getProgram_electives());
                    }
                }
            }
        }));
    }

    private final void listenResponse2() {
        getMvjceSemRegViewModel().getRegResponse().observe(getViewLifecycleOwner(), new MvjceSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SemRegSuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$listenResponse2$1

            /* compiled from: MvjceSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SemRegSuccessResponse> resource) {
                invoke2((Resource<SemRegSuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SemRegSuccessResponse> resource) {
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding;
                MvjceSemRegDialog.AddSemRegListener addSemRegListener;
                TextView registerBtn;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MvjceSemRegDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        MvjceSemRegDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        MvjceSemRegDialog.this.hideProgress();
                        return;
                    }
                }
                MvjceSemRegDialog.this.hideProgress();
                SemRegSuccessResponse data = resource.getData();
                if (data != null) {
                    MvjceSemRegDialog mvjceSemRegDialog = MvjceSemRegDialog.this;
                    if (data.getSuccess()) {
                        dialogMvjceSemRegBinding = mvjceSemRegDialog.get_binding();
                        if (dialogMvjceSemRegBinding != null && (registerBtn = dialogMvjceSemRegBinding.registerBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                            ToastExtKt.showSuccessToast(registerBtn, data.getMessage());
                        }
                        addSemRegListener = mvjceSemRegDialog.listener;
                        if (addSemRegListener != null) {
                            addSemRegListener.dismiss();
                        }
                        mvjceSemRegDialog.dismiss();
                        return;
                    }
                    mvjceSemRegDialog.confirmApproveView(data.getError());
                }
            }
        }));
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
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding = get_binding();
                TextView textView = dialogMvjceSemRegBinding != null ? dialogMvjceSemRegBinding.completionFileName : null;
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
                DialogMvjceSemRegBinding dialogMvjceSemRegBinding2 = get_binding();
                TextView textView2 = dialogMvjceSemRegBinding2 != null ? dialogMvjceSemRegBinding2.completionFileName : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                this.pickedFile = true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmApproveView(String message) {
        SpannableString spannableString = new SpannableString(message);
        spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, message.length(), 33);
        new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) "Please fix the following input errors:").setMessage((CharSequence) spannableString).setPositiveButton((CharSequence) "OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegDialog$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(false).show();
    }

    public final void setCallBack(PalaiSemesterRegFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    public final void setCallBack2(SemRegViewFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddSemRegListener addSemRegListener = this.listener;
        if (addSemRegListener != null) {
            addSemRegListener.dismiss();
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